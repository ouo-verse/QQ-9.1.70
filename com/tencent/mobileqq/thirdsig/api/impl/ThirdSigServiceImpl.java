package com.tencent.mobileqq.thirdsig.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.thirdsig.api.IOpenSigInjectService;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.thirdsig.api.impl.ThirdSigServiceImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelThirdPartySigService;
import com.tencent.qqnt.kernel.nativeinterface.IOpenIDCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPT4tokenCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine;
import com.tencent.qqnt.kernel.nativeinterface.IThirdPartySigCallback;
import com.tencent.qqnt.kernel.nativeinterface.IThirdPartySigChangeListener;
import com.tencent.qqnt.kernel.nativeinterface.InitThirdPartySigConfig;
import com.tencent.qqnt.kernel.nativeinterface.OpenIDResult;
import com.tencent.qqnt.kernel.nativeinterface.PT4tokenInfo;
import com.tencent.qqnt.kernel.nativeinterface.PT4tokenResult;
import com.tencent.qqnt.kernel.nativeinterface.ThirdPartySigResult;
import com.tencent.qqnt.kernel.nativeinterface.ThirdPartySigType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J@\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J(\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010 \u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010!\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010#\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\"H\u0016J \u0010$\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J8\u0010)\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u000f0%j\b\u0012\u0004\u0012\u00020\u000f`&2\u0006\u0010\u0013\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u0002H\u0016R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010=R&\u0010?\u001a\u0012\u0012\u0004\u0012\u00020*0%j\b\u0012\u0004\u0012\u00020*`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl;", "Lcom/tencent/mobileqq/thirdsig/api/IThirdSigService;", "", "init", "realInit", "", "uin", "sendSigChangeBroadCast", "initSigChangeReceiver", "initAccountKickedReceiver", "", "uinType", "Lcom/tencent/qqnt/kernel/nativeinterface/ThirdPartySigType;", "sigType", "loginAppid", "", "appidToken", "guid", "Lcom/tencent/mobileqq/thirdsig/api/d;", "callback", "getThirdPartySigByUin", "result", "Lcom/tencent/qqnt/kernel/nativeinterface/ThirdPartySigResult;", BuiltInServlet.MSF_KEY_SIG_INFO, "errMsg", "callbackAdapter", "", "bArray", "bytesToHexString", "getStWeb", "getSt", "openAppid", "getAccessToken", "getOpenKey", "Lcom/tencent/mobileqq/thirdsig/api/b;", "getOpenId", "getSuperKey", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "domains", "Lcom/tencent/mobileqq/thirdsig/api/c;", "getPt4Token", "Lcom/tencent/mobileqq/thirdsig/api/e;", "listener", "addOnSigChangeListener", "removeOnSigChangeListener", "delThirdPartySigByUin", "onAppInit", "onAppDestroy", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/tencent/mobileqq/thirdsig/api/impl/c;", "thirdSigAttackUpdateHelper", "Lcom/tencent/mobileqq/thirdsig/api/impl/c;", "Landroid/content/BroadcastReceiver;", "mAccountKickedReceiver", "Landroid/content/BroadcastReceiver;", "mSigChangeBroadcastReceiver", "mListenerList", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/IThirdPartySigChangeListener;", "kernelListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IThirdPartySigChangeListener;", "<init>", "()V", "Companion", "a", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ThirdSigServiceImpl implements IThirdSigService {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String ACTION_SIG_CHANGE = "nt_third_sig_change";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int EXCEPTION_ERROR_CODE = -10001;

    @NotNull
    public static final String EXCEPTION_ERROR_MESSAGE = "Got Exception:";

    @NotNull
    public static final String KEY_APPID = "appid";

    @NotNull
    public static final String KEY_UIN = "uin";

    @NotNull
    public static final String NT_OPENID_DIR = "/nt_openid/";

    @NotNull
    public static final String NT_WTLOGIN_DIR = "/nt_wtlogin/";

    @NotNull
    public static final String TAG = "ThirdSigManagerImpl";

    @Nullable
    private static IKernelThirdPartySigService service;

    @NotNull
    private final AtomicBoolean isInit;
    private IThirdPartySigChangeListener kernelListener;

    @Nullable
    private BroadcastReceiver mAccountKickedReceiver;

    @NotNull
    private ArrayList<com.tencent.mobileqq.thirdsig.api.e> mListenerList;

    @Nullable
    private BroadcastReceiver mSigChangeBroadcastReceiver;

    @NotNull
    private com.tencent.mobileqq.thirdsig.api.impl.c thirdSigAttackUpdateHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$a;", "", "", "ACTION_SIG_CHANGE", "Ljava/lang/String;", "", "EXCEPTION_ERROR_CODE", "I", "EXCEPTION_ERROR_MESSAGE", "KEY_APPID", "KEY_UIN", "NT_OPENID_DIR", "NT_WTLOGIN_DIR", "TAG", "<init>", "()V", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.thirdsig.api.impl.ThirdSigServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$b", "Lcom/tencent/mobileqq/thirdsig/api/a;", "", "onSuccess", "", "retCode", "", "errMsg", "onFail", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.thirdsig.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f292833b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f292834c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f292835d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292836e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$b$a", "Lcom/tencent/mobileqq/guid/d;", "", "guid", "", "a", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class a implements com.tencent.mobileqq.guid.d {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ThirdSigServiceImpl f292837a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f292838b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f292839c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f292840d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292841e;

            a(ThirdSigServiceImpl thirdSigServiceImpl, long j3, int i3, int i16, com.tencent.mobileqq.thirdsig.api.d dVar) {
                this.f292837a = thirdSigServiceImpl;
                this.f292838b = j3;
                this.f292839c = i3;
                this.f292840d = i16;
                this.f292841e = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, thirdSigServiceImpl, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), dVar);
                }
            }

            @Override // com.tencent.mobileqq.guid.d
            public void a(@NotNull byte[] guid) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) guid);
                } else {
                    Intrinsics.checkNotNullParameter(guid, "guid");
                    this.f292837a.getThirdPartySigByUin(this.f292838b, this.f292839c, ThirdPartySigType.ST, this.f292840d, "", "", this.f292841e);
                }
            }
        }

        b(long j3, int i3, int i16, com.tencent.mobileqq.thirdsig.api.d dVar) {
            this.f292833b = j3;
            this.f292834c = i3;
            this.f292835d = i16;
            this.f292836e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThirdSigServiceImpl.this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), dVar);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onFail(int retCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, retCode, (Object) errMsg);
            } else {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                this.f292836e.onFail(retCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.guid.c.f213821a.g(new a(ThirdSigServiceImpl.this, this.f292833b, this.f292834c, this.f292835d, this.f292836e));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$c", "Lcom/tencent/mobileqq/guid/d;", "", "guid", "", "a", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.mobileqq.guid.d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f292843b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f292844c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f292845d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292846e;

        c(long j3, int i3, int i16, com.tencent.mobileqq.thirdsig.api.d dVar) {
            this.f292843b = j3;
            this.f292844c = i3;
            this.f292845d = i16;
            this.f292846e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThirdSigServiceImpl.this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), dVar);
            }
        }

        @Override // com.tencent.mobileqq.guid.d
        public void a(@NotNull byte[] guid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) guid);
            } else {
                Intrinsics.checkNotNullParameter(guid, "guid");
                ThirdSigServiceImpl.this.getThirdPartySigByUin(this.f292843b, this.f292844c, ThirdPartySigType.ST, this.f292845d, "", "", this.f292846e);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$d", "Lcom/tencent/mobileqq/thirdsig/api/a;", "", "onSuccess", "", "retCode", "", "errMsg", "onFail", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.mobileqq.thirdsig.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f292848b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f292849c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f292850d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292851e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$d$a", "Lcom/tencent/mobileqq/guid/d;", "", "guid", "", "a", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class a implements com.tencent.mobileqq.guid.d {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ThirdSigServiceImpl f292852a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f292853b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f292854c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f292855d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292856e;

            a(ThirdSigServiceImpl thirdSigServiceImpl, long j3, int i3, int i16, com.tencent.mobileqq.thirdsig.api.d dVar) {
                this.f292852a = thirdSigServiceImpl;
                this.f292853b = j3;
                this.f292854c = i3;
                this.f292855d = i16;
                this.f292856e = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, thirdSigServiceImpl, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), dVar);
                }
            }

            @Override // com.tencent.mobileqq.guid.d
            public void a(@NotNull byte[] guid) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) guid);
                    return;
                }
                Intrinsics.checkNotNullParameter(guid, "guid");
                try {
                    String bytesToHexString = this.f292852a.bytesToHexString(guid);
                    Intrinsics.checkNotNull(bytesToHexString);
                    this.f292852a.getThirdPartySigByUin(this.f292853b, this.f292854c, ThirdPartySigType.ST_WEB, this.f292855d, "", bytesToHexString, this.f292856e);
                } catch (Exception e16) {
                    this.f292856e.onFail(-10001, ThirdSigServiceImpl.EXCEPTION_ERROR_MESSAGE + e16.getMessage());
                    QLog.e(ThirdSigServiceImpl.TAG, 1, "getStWeb uin type 6 loginAppid:" + this.f292855d + ", exception:", e16);
                }
            }
        }

        d(long j3, int i3, int i16, com.tencent.mobileqq.thirdsig.api.d dVar) {
            this.f292848b = j3;
            this.f292849c = i3;
            this.f292850d = i16;
            this.f292851e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThirdSigServiceImpl.this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), dVar);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onFail(int retCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, retCode, (Object) errMsg);
            } else {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                this.f292851e.onFail(retCode, errMsg);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.guid.c.f213821a.g(new a(ThirdSigServiceImpl.this, this.f292848b, this.f292849c, this.f292850d, this.f292851e));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$e", "Lcom/tencent/mobileqq/guid/d;", "", "guid", "", "a", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements com.tencent.mobileqq.guid.d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f292858b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f292859c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f292860d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292861e;

        e(long j3, int i3, int i16, com.tencent.mobileqq.thirdsig.api.d dVar) {
            this.f292858b = j3;
            this.f292859c = i3;
            this.f292860d = i16;
            this.f292861e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThirdSigServiceImpl.this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), dVar);
            }
        }

        @Override // com.tencent.mobileqq.guid.d
        public void a(@NotNull byte[] guid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) guid);
                return;
            }
            Intrinsics.checkNotNullParameter(guid, "guid");
            try {
                String bytesToHexString = ThirdSigServiceImpl.this.bytesToHexString(guid);
                Intrinsics.checkNotNull(bytesToHexString);
                ThirdSigServiceImpl.this.getThirdPartySigByUin(this.f292858b, this.f292859c, ThirdPartySigType.ST_WEB, this.f292860d, "", bytesToHexString, this.f292861e);
            } catch (Exception e16) {
                this.f292861e.onFail(-10001, ThirdSigServiceImpl.EXCEPTION_ERROR_MESSAGE + e16.getMessage());
                QLog.e(ThirdSigServiceImpl.TAG, 1, "getStWeb loginAppid:" + this.f292860d + " exception:", e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$f", "Lcom/tencent/qqnt/kernel/nativeinterface/IThirdPartySigCallback;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/ThirdPartySigResult;", BuiltInServlet.MSF_KEY_SIG_INFO, "", "onResult", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f implements IThirdPartySigCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f292863b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ThirdPartySigType f292864c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f292865d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.thirdsig.api.d f292866e;

        f(long j3, ThirdPartySigType thirdPartySigType, int i3, com.tencent.mobileqq.thirdsig.api.d dVar) {
            this.f292863b = j3;
            this.f292864c = thirdPartySigType;
            this.f292865d = i3;
            this.f292866e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThirdSigServiceImpl.this, Long.valueOf(j3), thirdPartySigType, Integer.valueOf(i3), dVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ThirdSigServiceImpl this$0, long j3, ThirdPartySigType sigType, int i3, int i16, ThirdPartySigResult sigInfo, com.tencent.mobileqq.thirdsig.api.d callback, String errMsg) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(sigType, "$sigType");
            Intrinsics.checkNotNullParameter(sigInfo, "$sigInfo");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
            this$0.callbackAdapter(j3, sigType, i3, i16, sigInfo, callback, errMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IThirdPartySigCallback
        public void onResult(final int result, @NotNull final String errMsg, @NotNull final ThirdPartySigResult sigInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, sigInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(sigInfo, "sigInfo");
            final ThirdSigServiceImpl thirdSigServiceImpl = ThirdSigServiceImpl.this;
            final long j3 = this.f292863b;
            final ThirdPartySigType thirdPartySigType = this.f292864c;
            final int i3 = this.f292865d;
            final com.tencent.mobileqq.thirdsig.api.d dVar = this.f292866e;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.thirdsig.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    ThirdSigServiceImpl.f.b(ThirdSigServiceImpl.this, j3, thirdPartySigType, i3, result, sigInfo, dVar, errMsg);
                }
            }, 16, null, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$g", "Lcom/tencent/qqnt/kernel/nativeinterface/IThirdPartySigChangeListener;", "", "uin", "", "onChange", "onDelete", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g implements IThirdPartySigChangeListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThirdSigServiceImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IThirdPartySigChangeListener
        public void onChange(long uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ThirdSigServiceImpl.this.sendSigChangeBroadCast(uin);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, uin);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IThirdPartySigChangeListener
        public void onDelete(long uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ThirdSigServiceImpl.this.sendSigChangeBroadCast(uin);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, uin);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ThirdSigServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isInit = new AtomicBoolean(false);
        this.thirdSigAttackUpdateHelper = new com.tencent.mobileqq.thirdsig.api.impl.c();
        this.mListenerList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String bytesToHexString(byte[] bArray) {
        boolean z16;
        if (bArray != null) {
            if (bArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                StringBuffer stringBuffer = new StringBuffer(bArray.length);
                for (byte b16 : bArray) {
                    String hexString = Integer.toHexString(b16 & 255);
                    Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(0xFF and bArray[i].toInt())");
                    if (hexString.length() < 2) {
                        stringBuffer.append(0);
                    }
                    String upperCase = hexString.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackAdapter(long uin, ThirdPartySigType sigType, int loginAppid, int result, ThirdPartySigResult sigInfo, com.tencent.mobileqq.thirdsig.api.d callback, String errMsg) {
        if (result == 0 && sigInfo.getErrorInfo().getErrCode() == 0) {
            byte[] bArr = sigInfo.sigInfo.sig;
            Intrinsics.checkNotNullExpressionValue(bArr, "sigInfo.sigInfo.sig");
            callback.a(new com.tencent.mobileqq.thirdsig.api.g(bArr, sigInfo.sigInfo.sigkey));
            com.tencent.mobileqq.thirdsig.api.h.f292822a.b(uin, sigType.name(), loginAppid, null, 0, "");
            return;
        }
        if (result != 0) {
            callback.onFail(result, errMsg);
            com.tencent.mobileqq.thirdsig.api.h.f292822a.b(uin, sigType.name(), loginAppid, null, result, errMsg);
        } else if (sigInfo.getErrorInfo().getErrCode() != 0) {
            int errCode = sigInfo.getErrorInfo().getErrCode();
            String errMessage = sigInfo.getErrorInfo().getErrMsg();
            Intrinsics.checkNotNullExpressionValue(errMessage, "errMessage");
            callback.onFail(errCode, errMessage);
            com.tencent.mobileqq.thirdsig.api.h.f292822a.b(uin, sigType.name(), loginAppid, null, errCode, errMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOpenId$lambda$1(final long j3, final int i3, final com.tencent.mobileqq.thirdsig.api.b callback, final ThirdSigServiceImpl this$0, final int i16, final String str, final OpenIDResult openIDResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.thirdsig.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                ThirdSigServiceImpl.getOpenId$lambda$1$lambda$0(i16, openIDResult, j3, i3, callback, this$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOpenId$lambda$1$lambda$0(int i3, OpenIDResult openIDResult, long j3, int i16, com.tencent.mobileqq.thirdsig.api.b callback, ThirdSigServiceImpl this$0, String errMsg) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            try {
                if (openIDResult.getErrorInfo().getErrCode() == 0) {
                    com.tencent.mobileqq.thirdsig.api.h.f292822a.b(j3, "openid", i16, null, 0, "");
                    String bytesToHexString = this$0.bytesToHexString(openIDResult.getOpenidInfo().openid);
                    Intrinsics.checkNotNull(bytesToHexString);
                    callback.onSuccess(bytesToHexString);
                }
            } catch (Exception e16) {
                String str = EXCEPTION_ERROR_MESSAGE + e16.getMessage();
                callback.onFail(-10001, str);
                QLog.e(TAG, 1, "getOpenId openAppId:" + i16 + " exception:", e16);
                com.tencent.mobileqq.thirdsig.api.h.f292822a.b(j3, "openid", i16, null, -10001, str);
                return;
            }
        }
        if (i3 != 0) {
            com.tencent.mobileqq.thirdsig.api.h hVar = com.tencent.mobileqq.thirdsig.api.h.f292822a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            hVar.b(j3, "openid", i16, null, i3, errMsg);
            callback.onFail(i3, errMsg);
        } else if (openIDResult.getErrorInfo().getErrCode() != 0) {
            int errCode = openIDResult.getErrorInfo().getErrCode();
            String errMessage = openIDResult.getErrorInfo().getErrMsg();
            Intrinsics.checkNotNullExpressionValue(errMessage, "errMessage");
            callback.onFail(errCode, errMessage);
            com.tencent.mobileqq.thirdsig.api.h.f292822a.b(j3, "openid", i16, null, errCode, errMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPt4Token$lambda$4(final long j3, final int i3, final ArrayList domains, final com.tencent.mobileqq.thirdsig.api.c callback, final int i16, final String str, final PT4tokenResult pT4tokenResult) {
        Intrinsics.checkNotNullParameter(domains, "$domains");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.thirdsig.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                ThirdSigServiceImpl.getPt4Token$lambda$4$lambda$3(i16, pT4tokenResult, j3, i3, domains, callback, str);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPt4Token$lambda$4$lambda$3(int i3, PT4tokenResult pT4tokenResult, long j3, int i16, ArrayList domains, com.tencent.mobileqq.thirdsig.api.c callback, String errMsg) {
        Intrinsics.checkNotNullParameter(domains, "$domains");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0 && pT4tokenResult.getErrorInfo().getErrCode() == 0) {
            ArrayList<com.tencent.mobileqq.thirdsig.api.f> arrayList = new ArrayList<>();
            ArrayList<PT4tokenInfo> pt4tokens = pT4tokenResult.getPt4tokens();
            Intrinsics.checkNotNullExpressionValue(pt4tokens, "pt4tokens.getPt4tokens()");
            for (PT4tokenInfo pT4tokenInfo : pt4tokens) {
                byte[] bArr = pT4tokenInfo.sig;
                Intrinsics.checkNotNullExpressionValue(bArr, "it.sig");
                String str = pT4tokenInfo.domain;
                Intrinsics.checkNotNullExpressionValue(str, "it.domain");
                arrayList.add(new com.tencent.mobileqq.thirdsig.api.f(bArr, str));
            }
            com.tencent.mobileqq.thirdsig.api.h.f292822a.b(j3, "pt4token", i16, domains, 0, "");
            callback.onSuccess(arrayList);
            return;
        }
        if (i3 != 0) {
            com.tencent.mobileqq.thirdsig.api.h hVar = com.tencent.mobileqq.thirdsig.api.h.f292822a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            hVar.b(j3, "pt4token", i16, domains, i3, errMsg);
            callback.onFail(i3, errMsg);
            return;
        }
        if (pT4tokenResult.getErrorInfo().getErrCode() != 0) {
            int errCode = pT4tokenResult.getErrorInfo().getErrCode();
            String errMessage = pT4tokenResult.getErrorInfo().getErrMsg();
            Intrinsics.checkNotNullExpressionValue(errMessage, "errMessage");
            callback.onFail(errCode, errMessage);
            com.tencent.mobileqq.thirdsig.api.h.f292822a.b(j3, "pt4token", i16, domains, errCode, errMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getThirdPartySigByUin(long uin, int uinType, ThirdPartySigType sigType, int loginAppid, String appidToken, String guid, com.tencent.mobileqq.thirdsig.api.d callback) {
        init();
        IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService().getThirdPartySigByUin(uin, uinType, sigType, loginAppid, appidToken, guid, new f(uin, sigType, loginAppid, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init() {
        try {
            if (!this.isInit.get()) {
                synchronized (this) {
                    if (!this.isInit.get()) {
                        realInit();
                        this.isInit.set(true);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private final void initAccountKickedReceiver() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        if (this.mAccountKickedReceiver == null) {
            this.mAccountKickedReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.thirdsig.api.impl.ThirdSigServiceImpl$initAccountKickedReceiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThirdSigServiceImpl.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (context != null && intent != null) {
                        Serializable serializableExtra = intent.getSerializableExtra("reason");
                        QLog.d(ThirdSigServiceImpl.TAG, 1, "account kicked, logoutReason=" + serializableExtra);
                        if ((serializableExtra == Constants.LogoutReason.kicked || serializableExtra == Constants.LogoutReason.secKicked) && j.a()) {
                            ThirdSigServiceImpl.this.init();
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            if (peekAppRuntime != null) {
                                IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService().delThirdPartySigByUin(peekAppRuntime.getLongAccountUin());
                            }
                        }
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        BaseApplication.getContext().registerReceiver(this.mAccountKickedReceiver, intentFilter);
    }

    private final void initSigChangeReceiver() {
        if (this.mSigChangeBroadcastReceiver == null) {
            this.mSigChangeBroadcastReceiver = new ThirdSigServiceImpl$initSigChangeReceiver$1(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_SIG_CHANGE);
        BaseApplication.getContext().registerReceiver(this.mSigChangeBroadcastReceiver, intentFilter);
    }

    private final void realInit() {
        InitThirdPartySigConfig initThirdPartySigConfig = new InitThirdPartySigConfig();
        initThirdPartySigConfig.commonPath = BaseApplication.getContext().getFilesDir().getPath() + NT_WTLOGIN_DIR;
        initThirdPartySigConfig.openidPath = BaseApplication.getContext().getFilesDir().getPath() + NT_OPENID_DIR;
        initThirdPartySigConfig.bid = String.valueOf(AppSetting.f());
        if (service == null) {
            service = IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService();
        }
        IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService().initConfig(initThirdPartySigConfig);
        this.kernelListener = new g();
        IKernelThirdPartySigService thirdPartySigService = IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService();
        IThirdPartySigChangeListener iThirdPartySigChangeListener = this.kernelListener;
        if (iThirdPartySigChangeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kernelListener");
            iThirdPartySigChangeListener = null;
        }
        thirdPartySigService.addOnSigChangeListener(iThirdPartySigChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSigChangeBroadCast(long uin) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Intent intent = new Intent();
        intent.setAction(ACTION_SIG_CHANGE);
        intent.getData();
        intent.putExtra("uin", uin);
        mobileQQ.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void addOnSigChangeListener(@NotNull com.tencent.mobileqq.thirdsig.api.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.mListenerList) {
            if (!this.mListenerList.contains(listener)) {
                this.mListenerList.add(listener);
                QLog.d(TAG, 1, "register listener: ok");
            } else {
                QLog.d(TAG, 1, "register listener: duplicated listener");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void delThirdPartySigByUin(long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, uin);
            return;
        }
        init();
        QLog.d(TAG, 1, "delThirdPartySigByUin uin=" + uin);
        IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService().delThirdPartySigByUin(uin);
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getAccessToken(long uin, int openAppid, @NotNull String appidToken, @NotNull com.tencent.mobileqq.thirdsig.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(uin), Integer.valueOf(openAppid), appidToken, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appidToken, "appidToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getThirdPartySigByUin(uin, 0, ThirdPartySigType.TOKEN, openAppid, appidToken, "", callback);
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getOpenId(final long uin, final int openAppid, @NotNull String appidToken, @NotNull final com.tencent.mobileqq.thirdsig.api.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(uin), Integer.valueOf(openAppid), appidToken, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appidToken, "appidToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        init();
        IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService().getOpenIDByUin(uin, openAppid, appidToken, new IOpenIDCallback() { // from class: com.tencent.mobileqq.thirdsig.api.impl.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOpenIDCallback
            public final void onResult(int i3, String str, OpenIDResult openIDResult) {
                ThirdSigServiceImpl.getOpenId$lambda$1(uin, openAppid, callback, this, i3, str, openIDResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getOpenKey(long uin, int openAppid, @NotNull String appidToken, @NotNull com.tencent.mobileqq.thirdsig.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(uin), Integer.valueOf(openAppid), appidToken, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appidToken, "appidToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getThirdPartySigByUin(uin, 0, ThirdPartySigType.OPENKEY, openAppid, appidToken, "", callback);
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getPt4Token(final long uin, final int loginAppid, @NotNull final ArrayList<String> domains, @NotNull final com.tencent.mobileqq.thirdsig.api.c callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(uin), Integer.valueOf(loginAppid), domains, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        init();
        com.tencent.mobileqq.thirdsig.api.h.f292822a.a(domains);
        IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService().getPT4tokenByUin(uin, loginAppid, domains, new IPT4tokenCallback() { // from class: com.tencent.mobileqq.thirdsig.api.impl.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IPT4tokenCallback
            public final void onResult(int i3, String str, PT4tokenResult pT4tokenResult) {
                ThirdSigServiceImpl.getPt4Token$lambda$4(uin, loginAppid, domains, callback, i3, str, pT4tokenResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getSt(long uin, int uinType, int loginAppid, @NotNull com.tencent.mobileqq.thirdsig.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(uin), Integer.valueOf(uinType), Integer.valueOf(loginAppid), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uinType == 6) {
            ((IOpenSigInjectService) QRoute.api(IOpenSigInjectService.class)).commitOpenTicketToMsf(uin, new b(uin, uinType, loginAppid, callback));
        } else {
            com.tencent.mobileqq.guid.c.f213821a.g(new c(uin, uinType, loginAppid, callback));
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getStWeb(long uin, int uinType, int loginAppid, @NotNull com.tencent.mobileqq.thirdsig.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(uin), Integer.valueOf(uinType), Integer.valueOf(loginAppid), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uinType == 6) {
            ((IOpenSigInjectService) QRoute.api(IOpenSigInjectService.class)).commitOpenTicketToMsf(uin, new d(uin, uinType, loginAppid, callback));
        } else {
            com.tencent.mobileqq.guid.c.f213821a.g(new e(uin, uinType, loginAppid, callback));
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void getSuperKey(long uin, int loginAppid, @NotNull com.tencent.mobileqq.thirdsig.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(uin), Integer.valueOf(loginAppid), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            getThirdPartySigByUin(uin, 0, ThirdPartySigType.SUPER_KEY, loginAppid, "", "", callback);
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void onAppDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.thirdSigAttackUpdateHelper.c();
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void onAppInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.thirdSigAttackUpdateHelper.d();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        QLog.d(TAG, 1, "onCreate appRuntime = " + appRuntime);
        initSigChangeReceiver();
        initAccountKickedReceiver();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        synchronized (this.mListenerList) {
            this.mListenerList.clear();
            Unit unit = Unit.INSTANCE;
        }
        if (this.isInit.get()) {
            IKernelThirdPartySigService thirdPartySigService = IQQNTWrapperEngine.CppProxy.get().getThirdPartySigService();
            IThirdPartySigChangeListener iThirdPartySigChangeListener = this.kernelListener;
            if (iThirdPartySigChangeListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("kernelListener");
                iThirdPartySigChangeListener = null;
            }
            thirdPartySigService.removeSigChangeListener(iThirdPartySigChangeListener);
        }
        onAppDestroy();
        try {
            if (this.mAccountKickedReceiver != null) {
                BaseApplication.getContext().unregisterReceiver(this.mAccountKickedReceiver);
                this.mAccountKickedReceiver = null;
            }
            if (this.mSigChangeBroadcastReceiver != null) {
                BaseApplication.getContext().unregisterReceiver(this.mSigChangeBroadcastReceiver);
                this.mSigChangeBroadcastReceiver = null;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "onDestroy unregister broadcast failed :" + e16);
        }
    }

    @Override // com.tencent.mobileqq.thirdsig.api.IThirdSigService
    public void removeOnSigChangeListener(@NotNull com.tencent.mobileqq.thirdsig.api.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.mListenerList) {
            if (this.mListenerList.remove(listener)) {
                QLog.d(TAG, 1, "unregister listener: ok");
            } else {
                QLog.d(TAG, 1, "unregister listener: no such listener");
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
