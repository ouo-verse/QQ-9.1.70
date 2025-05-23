package com.tencent.mobileqq.app.message.hookparcel;

import android.content.ContentValues;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Base64;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.imcore.message.s;
import com.tencent.mobileqq.app.message.OnReceiveVerify;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.app.message.SendMsgVerify;
import com.tencent.mobileqq.cuckoo.Cuckoo;
import com.tencent.mobileqq.cuckoo.MethodCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robolectric.ShadowParcel;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes11.dex */
public class ParcelHooker {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ParcelHooker";
    private static Callback sCallback;
    private static volatile boolean sParcelHooking;
    private static Set<Class> shouldRecordTypes;
    private volatile long mNativePtr;
    private volatile Parcel mParcel;
    volatile boolean mParcelHooking;
    private volatile Thread mParcelThread;
    private ThreadLocal<SendMsgVerify> sendMsgVerify;

    /* loaded from: classes11.dex */
    public interface Callback {
        void registerTypeAdapter(GsonBuilder gsonBuilder, Field[] fieldArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements ExclusionStrategy {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls)).booleanValue();
            }
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fieldAttributes)).booleanValue();
            }
            if (fieldAttributes.hasModifier(128) || fieldAttributes.hasModifier(8) || fieldAttributes.hasModifier(64)) {
                return true;
            }
            if (!ParcelHooker.shouldKeepType(fieldAttributes.getDeclaredClass()) && !ParcelHooker.shouldKeepType(fieldAttributes.getDeclaredClass().getComponentType()) && ((!(fieldAttributes.getDeclaredType() instanceof ParameterizedType) || !ParcelHooker.shouldKeepType(((ParameterizedType) fieldAttributes.getDeclaredType()).getActualTypeArguments()[0])) && fieldAttributes.getAnnotation(RecordForTest.class) == null)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f195994b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38778);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f195994b = true;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 2) {
                return;
            }
            boolean z16 = f195994b;
            if (!z16 && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            if (!z16 && objArr[1].getClass() != Long.class) {
                throw new AssertionError();
            }
            ShadowParcel.p((int) ParcelHooker.this.mNativePtr, ((Long) objArr[1]).longValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f195996b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38892);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f195996b = true;
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 2) {
                return;
            }
            boolean z16 = f195996b;
            if (!z16 && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            if (!z16 && objArr[1].getClass() != Float.class) {
                throw new AssertionError();
            }
            ShadowParcel.l((int) ParcelHooker.this.mNativePtr, ((Float) objArr[1]).floatValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f195998b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38958);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f195998b = true;
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 2) {
                return;
            }
            boolean z16 = f195998b;
            if (!z16 && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            if (!z16 && objArr[1].getClass() != Double.class) {
                throw new AssertionError();
            }
            ShadowParcel.j((int) ParcelHooker.this.mNativePtr, ((Double) objArr[1]).doubleValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f196000b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38998);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f196000b = true;
            }
        }

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 4) {
                return;
            }
            if (!f196000b && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            ShadowParcel.h((int) ParcelHooker.this.mNativePtr, (byte[]) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class f extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f196002b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39053);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f196002b = true;
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 2) {
                return;
            }
            boolean z16 = f196002b;
            if (!z16 && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            if (!z16 && objArr[1].getClass() != Integer.class) {
                throw new AssertionError();
            }
            ShadowParcel.n((int) ParcelHooker.this.mNativePtr, ((Integer) objArr[1]).intValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class g extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f196004b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39433);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f196004b = true;
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 4) {
                return;
            }
            if (!f196004b && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            ShadowParcel.g(ParcelHooker.this.mNativePtr, (byte[]) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class h extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f196006b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39542);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f196006b = true;
            }
        }

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 2) {
                return;
            }
            if (!f196006b && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            ShadowParcel.e((int) ParcelHooker.this.mNativePtr, ((Integer) objArr[1]).intValue());
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class i extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f196008b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39676);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f196008b = true;
            }
        }

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 2) {
                return;
            }
            if (!f196008b && objArr[0] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            ShadowParcel.r((int) ParcelHooker.this.mNativePtr, (String) objArr[1]);
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class j extends MethodCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f196010b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39685);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f196010b = true;
            }
        }

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParcelHooker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.MethodCallback
        public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
                return;
            }
            if (ParcelHooker.this.mParcelThread != Thread.currentThread() || !ParcelHooker.this.mParcelHooking || objArr.length != 3) {
                return;
            }
            if (!f196010b && objArr[1] != ParcelHooker.this.mParcel) {
                throw new AssertionError();
            }
            ShadowParcel.r((int) ParcelHooker.this.mNativePtr, (String) objArr[2]);
            QLog.i(ParcelHooker.TAG, 2, "onMethodEntry() called with: className = [" + str + "], methodName = [" + str2 + "], sig = [" + str3 + "], arguments = [" + Arrays.toString(objArr) + "]");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40425);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            s.a();
        }
    }

    public ParcelHooker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sendMsgVerify = new ThreadLocal<>();
        }
    }

    private void endHookParcel(Thread thread, Parcel parcel, long j3) {
        this.mParcelHooking = false;
    }

    private byte[] getBytes(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        Number b16 = ShadowParcel.b();
        startHookParcel(Thread.currentThread(), obtain, b16.longValue());
        parcelable.writeToParcel(obtain, 0);
        endHookParcel(Thread.currentThread(), obtain, b16.longValue());
        byte[] c16 = ShadowParcel.c(b16.intValue());
        OaidMonitor.parcelRecycle(obtain);
        return c16;
    }

    private List<Class> getClassHierarchy(MessageRecord messageRecord) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = messageRecord.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        return arrayList;
    }

    public static Gson getGsonForMr(Class<? extends MessageRecord> cls) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        sCallback.registerTypeAdapter(gsonBuilder, cls.getFields());
        return gsonBuilder.excludeFieldsWithModifiers(8, 128, 64).setExclusionStrategies(new a()).create();
    }

    private byte[] getReqBytes(ToServiceMsg toServiceMsg) {
        Parcel obtain = Parcel.obtain();
        Number b16 = ShadowParcel.b();
        startHookParcel(Thread.currentThread(), obtain, b16.longValue());
        toServiceMsg.mSkipBinderWhenMarshall = true;
        toServiceMsg.writeToParcel(obtain, 0);
        toServiceMsg.mSkipBinderWhenMarshall = false;
        endHookParcel(Thread.currentThread(), obtain, b16.longValue());
        byte[] c16 = ShadowParcel.c(b16.intValue());
        OaidMonitor.parcelRecycle(obtain);
        return c16;
    }

    private byte[] getRespBytes(FromServiceMsg fromServiceMsg) {
        Parcel obtain = Parcel.obtain();
        Number b16 = ShadowParcel.b();
        startHookParcel(Thread.currentThread(), obtain, b16.longValue());
        fromServiceMsg.writeToParcel(obtain, 0);
        endHookParcel(Thread.currentThread(), obtain, b16.longValue());
        byte[] c16 = ShadowParcel.c(b16.intValue());
        OaidMonitor.parcelRecycle(obtain);
        return c16;
    }

    @NonNull
    private MethodCallback methodCallbackGetSetDataPosition() {
        return new h();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteBlob() {
        return new g();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteByteArray() {
        return new e();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteDouble() {
        return new d();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteFloat() {
        return new c();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteInt() {
        return new f();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteLong() {
        return new b();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteString() {
        return new j();
    }

    @NonNull
    private MethodCallback methodCallbackGetWriteStringNoHelper() {
        return new i();
    }

    private ContentValues mr2Cv(MessageRecord messageRecord) {
        Object obj;
        ContentValues contentValues = new ContentValues();
        Iterator<Class> it = getClassHierarchy(messageRecord).iterator();
        while (it.hasNext()) {
            for (Field field : it.next().getDeclaredFields()) {
                String name = field.getName();
                if ((field.getModifiers() & 16) != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "mr2Cv() skip final filed: " + name);
                    }
                } else {
                    try {
                        obj = field.get(messageRecord);
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                        obj = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "mr2Cv() called with: key = [" + name + "] value = " + obj);
                    }
                    if (obj instanceof Byte) {
                        contentValues.put(name, (Byte) obj);
                    } else if (obj instanceof Boolean) {
                        contentValues.put(name, (Boolean) obj);
                    } else if (obj instanceof String) {
                        contentValues.put(name, (String) obj);
                    } else if (obj instanceof Integer) {
                        contentValues.put(name, (Integer) obj);
                    } else if (obj instanceof Long) {
                        contentValues.put(name, (Long) obj);
                    } else if (obj instanceof Float) {
                        contentValues.put(name, (Float) obj);
                    } else if (obj instanceof Double) {
                        contentValues.put(name, (Double) obj);
                    } else if (obj instanceof byte[]) {
                        contentValues.put(name, (byte[]) obj);
                    } else if (obj instanceof Short) {
                        contentValues.put(name, (Short) obj);
                    }
                }
            }
        }
        return contentValues;
    }

    private void printCv(ContentValues contentValues) {
        for (String str : contentValues.keySet()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "printCv() called with: key = [" + str + "] value = " + contentValues.get(str));
            }
        }
    }

    private void serializeExt(MessageRecord messageRecord) {
        try {
            Method declaredMethod = Entity.class.getDeclaredMethod("prewrite", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(messageRecord, new Object[0]);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
        } catch (InvocationTargetException e18) {
            e18.printStackTrace();
        }
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldKeepType(Type type) {
        if (type == null) {
            return false;
        }
        if (shouldRecordTypes == null) {
            HashSet hashSet = new HashSet();
            shouldRecordTypes = hashSet;
            hashSet.addAll(Arrays.asList(Integer.TYPE, Integer.class, Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class, Byte.TYPE, Byte.class, Boolean.TYPE, Boolean.class, Short.TYPE, Short.class, String.class));
        }
        return shouldRecordTypes.contains(type);
    }

    private static void writeFacadeFile(String str, String str2) {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/QQMessageFacade/");
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis());
        if (str2 == null) {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append(".txt");
        FileUtils.writeFile(sDKPrivatePath, sb5.toString(), str);
    }

    private void writeFile(OnReceiveVerify onReceiveVerify, String str) {
        String json = new Gson().toJson(onReceiveVerify);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/MessageHandlerOnReceive/");
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtils.writeFile(sDKPrivatePath, System.currentTimeMillis() + "-" + str + Sticker.JSON_SUFFIX, json);
    }

    public SendMsgVerify getSendMsgVerify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SendMsgVerify) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.sendMsgVerify.get() == null) {
            this.sendMsgVerify.set(new SendMsgVerify());
        }
        return this.sendMsgVerify.get();
    }

    public void printParams(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        String e16 = Utils.e(getReqBytes(toServiceMsg));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "printParams reqData=[" + e16 + "]");
        }
        Object remove = fromServiceMsg.attributes.remove("FromServiceMsg");
        String e17 = Utils.e(getRespBytes(fromServiceMsg));
        fromServiceMsg.attributes.put("FromServiceMsg", remove);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "printParams respData=[" + e17 + "]");
        }
        OnReceiveVerify onReceiveVerify = new OnReceiveVerify();
        onReceiveVerify.req = e16;
        onReceiveVerify.resp = e17;
        onReceiveVerify.result = "placeholder for MessageRecord's metadata";
        onReceiveVerify.addMessageTimes = 1;
        onReceiveVerify.notifyUITimes = 1;
        writeFile(onReceiveVerify, fromServiceMsg.getServiceCmd());
    }

    public void printSendParams(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        String e16 = Utils.e(getReqBytes(toServiceMsg));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "printSendParams reqData=[" + e16 + "]");
        }
        SendMsgVerify sendMsgVerify = getSendMsgVerify();
        sendMsgVerify.toServiceMsg = e16;
        MessageRecord messageRecord = (MessageRecord) getGsonForMr(sendMsgVerify.f195864msg.getClass()).fromJson(sendMsgVerify.msgContent, (Class) sendMsgVerify.f195864msg.getClass());
        sendMsgVerify.f195864msg = messageRecord;
        sendMsgVerify.msgContent = null;
        writeFacadeFile(getGsonForMr(messageRecord.getClass()).toJson(sendMsgVerify), "_" + sendMsgVerify.clsName);
    }

    public void recordCookie(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        } else {
            getSendMsgVerify().cookie = Base64.encodeToString(bArr, 3);
        }
    }

    public void recordMR(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord);
            return;
        }
        serializeExt(messageRecord);
        ContentValues mr2Cv = mr2Cv(messageRecord);
        printCv(mr2Cv);
        byte[] bytes = getBytes(mr2Cv);
        SendMsgVerify sendMsgVerify = getSendMsgVerify();
        sendMsgVerify.msgContent = Base64.encodeToString(bytes, 3);
        sendMsgVerify.clsName = messageRecord.getClass().getName();
    }

    public void recordMrAsJson(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord);
            return;
        }
        serializeExt(messageRecord);
        SendMsgVerify sendMsgVerify = getSendMsgVerify();
        sendMsgVerify.f195864msg = messageRecord;
        sendMsgVerify.msgContent = getGsonForMr(messageRecord.getClass()).toJson(messageRecord);
        sendMsgVerify.clsName = messageRecord.getClass().getName();
    }

    void startHookParcel(Thread thread, Parcel parcel, long j3) {
        if (!sParcelHooking) {
            sParcelHooking = true;
            Cuckoo.init(true);
            Cuckoo.registMethod("android/os/Parcel$ReadWriteHelper", "writeString", "(Landroid/os/Parcel;Ljava/lang/String;)V", methodCallbackGetWriteString());
            Cuckoo.registMethod("android/os/Parcel", "writeStringNoHelper", "(Ljava/lang/String;)V", methodCallbackGetWriteStringNoHelper());
            Cuckoo.registMethod("android/os/Parcel", "writeInt", "(I)V", methodCallbackGetWriteInt());
            Cuckoo.registMethod("android/os/Parcel", "writeLong", "(J)V", methodCallbackGetWriteLong());
            Cuckoo.registMethod("android/os/Parcel", "writeFloat", "(F)V", methodCallbackGetWriteFloat());
            Cuckoo.registMethod("android/os/Parcel", "writeDouble", "(D)V", methodCallbackGetWriteDouble());
            Cuckoo.registMethod("android/os/Parcel", "writeByteArray", "([BII)V", methodCallbackGetWriteByteArray());
            Cuckoo.registMethod("android/os/Parcel", "writeBlob", "([BII)V", methodCallbackGetWriteBlob());
            Cuckoo.registMethod("android/os/Parcel", "setDataPosition", "(I)V", methodCallbackGetSetDataPosition());
        }
        this.mParcelThread = thread;
        this.mParcel = parcel;
        this.mNativePtr = j3;
        this.mParcelHooking = true;
    }
}
