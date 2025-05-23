package com.tencent.mobileqq.qne.utils.network;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b,\u0010-J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J&\u0010\u0010\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\nH\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0018J(\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bR\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00180$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/QneRequestHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "data", "", Constants.BASE_IN_PLUGIN_VERSION, "", "E2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "res", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "cmd", "reqBytes", "Lcom/tencent/mobileqq/qne/utils/network/a;", "observer", "F2", "", "timeoutMillis", Constants.MMCCID, "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "", "e", "Ljava/util/Map;", "observerMap", "Ljava/util/concurrent/locks/ReentrantLock;", "f", "Ljava/util/concurrent/locks/ReentrantLock;", "observerLock", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", h.F, "ResponseRunnable", "a", "qne-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QneRequestHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicLong f262076i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, a> observerMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock observerLock;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/QneRequestHandler$ResponseRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "d", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "getResponse", "()Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "Lcom/tencent/mobileqq/qne/utils/network/a;", "e", "Lcom/tencent/mobileqq/qne/utils/network/a;", "getObserver", "()Lcom/tencent/mobileqq/qne/utils/network/a;", "observer", "", "f", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "data", "<init>", "(Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/qne/utils/network/a;Ljava/lang/Object;)V", "qne-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class ResponseRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FromServiceMsg response;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final a observer;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Object data;

        public ResponseRunnable(@NotNull FromServiceMsg response, @Nullable a aVar, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(response, "response");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, response, aVar, obj);
                return;
            }
            this.response = response;
            this.observer = aVar;
            this.data = obj;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:10:0x0010, B:12:0x0018, B:15:0x001e, B:17:0x0021, B:18:0x002a, B:20:0x002e), top: B:9:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            a aVar;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            try {
                byte[] trpcRspErrorMsg = this.response.getTrpcRspErrorMsg();
                if (trpcRspErrorMsg != null) {
                    if (trpcRspErrorMsg.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        str = new String(trpcRspErrorMsg, Charsets.UTF_8);
                        aVar = this.observer;
                        if (aVar == null) {
                            aVar.onResponse(this.response.getResultCode(), this.response.getTrpcRspFuncRetCode(), str, this.data);
                            return;
                        }
                        return;
                    }
                }
                str = null;
                aVar = this.observer;
                if (aVar == null) {
                }
            } catch (Throwable th5) {
                QLog.e("QneRequestHandler", 1, "ResponseRunnable is error : " + th5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\n\u0010\u000b\u001a\u00020\u0005*\u00020\nJ\f\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\u0005J\f\u0010\r\u001a\u0004\u0018\u00010\u0005*\u00020\u0005R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/QneRequestHandler$a;", "", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "", "b", "", "reqBytes", "g", "Lcom/tencent/mobileqq/qne/utils/network/QneRequestHandler;", "c", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "d", "e", "f", "", "DEFAULT_TIMEOUT", "J", "EXTRA_CMD", "Ljava/lang/String;", "EXTRA_CMD_SEQ", "EXTRA_DATA", "EXTRA_TIMEOUT", "TAG", "Ljava/util/concurrent/atomic/AtomicLong;", "seqIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "<init>", "()V", "qne-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qne.utils.network.QneRequestHandler$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(FromServiceMsg fromServiceMsg) {
            return "sso:" + fromServiceMsg.getBusinessFailCode() + " -> " + fromServiceMsg.getBusinessFailMsg() + ", trpc:" + fromServiceMsg.getTrpcRspFuncRetCode() + " -> " + fromServiceMsg.getTrpcRspErrorMsg();
        }

        private final byte[] g(byte[] reqBytes) {
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(-1L);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(reqBytes));
            byte[] byteArray = stQWebReq.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "webReq.toByteArray()");
            return byteArray;
        }

        @Nullable
        public final QneRequestHandler c() {
            BusinessHandler businessHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QneRequestHandler) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            AppInterface a16 = ie2.a.a();
            if (a16 != null) {
                businessHandler = a16.getBusinessHandler(QneRequestHandler.class.getName());
            } else {
                businessHandler = null;
            }
            return (QneRequestHandler) businessHandler;
        }

        @NotNull
        public final byte[] d(@NotNull oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_sso_oidbssopkg);
            }
            Intrinsics.checkNotNullParameter(oidb_sso_oidbssopkg, "<this>");
            byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
            int length = byteArray.length;
            int i3 = length + 4;
            byte[] bArr = new byte[i3];
            PkgTools.DWord2Byte(bArr, 0, i3);
            PkgTools.copyData(bArr, 4, byteArray, length);
            return bArr;
        }

        @Nullable
        public final byte[] e(@NotNull byte[] bArr) {
            IntRange until;
            byte[] sliceArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            }
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            if (bArr.length > 4) {
                until = RangesKt___RangesKt.until(4, bArr.length);
                sliceArray = ArraysKt___ArraysKt.sliceArray(bArr, until);
                return sliceArray;
            }
            return null;
        }

        @Nullable
        public final byte[] f(@NotNull byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            }
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            byte[] g16 = g(bArr);
            int length = g16.length;
            int i3 = length + 4;
            byte[] bArr2 = new byte[i3];
            PkgTools.DWord2Byte(bArr2, 0, i3);
            PkgTools.copyData(bArr2, 4, g16, length);
            return bArr2;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22523);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
            f262076i = new AtomicLong(0L);
        }
    }

    public QneRequestHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.app = appInterface;
        this.observerMap = new LinkedHashMap();
        this.observerLock = new ReentrantLock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean D2(Intent request, FromServiceMsg response, byte[] data) {
        boolean z16;
        String stringExtra = request.getStringExtra("__cmd_seq__");
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            a remove = this.observerMap.remove(stringExtra);
            if (remove == null) {
                return false;
            }
            reentrantLock.unlock();
            if (QLog.isColorLevel()) {
                QLog.i("QneRequestHandler", 2, "handleObserverResponse, cmd: " + stringExtra + ", rsp:" + INSTANCE.b(response));
            }
            Class cls = (Class) request.getSerializableExtra("__rspClass__");
            if (cls != null) {
                try {
                    Object newInstance = cls.newInstance();
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.pb.MessageMicro<*>");
                    MessageMicro messageMicro = (MessageMicro) newInstance;
                    messageMicro.mergeFrom(data);
                    data = messageMicro;
                } catch (Throwable unused) {
                }
            }
            ThreadManagerV2.excute(new ResponseRunnable(response, remove, data), 16, null, true);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void E2(@NotNull Intent request, @NotNull FromServiceMsg response, @Nullable byte[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, request, response, data);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!D2(request, response, data)) {
            QLog.e("QneRequestHandler", 1, "handleResponse error " + request.getStringExtra("cmd"));
        }
    }

    public final void F2(@NotNull String cmd, @Nullable byte[] reqBytes, @NotNull a observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, cmd, reqBytes, observer);
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(observer, "observer");
        G2(cmd, reqBytes, observer, 60000L);
    }

    public final void G2(@NotNull String cmd, @Nullable byte[] reqBytes, @NotNull a observer, long timeoutMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, cmd, reqBytes, observer, Long.valueOf(timeoutMillis));
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(observer, "observer");
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QneRequestHandler", 2, "request, cmd:" + cmd);
        }
        String str = cmd + util.base64_pad_url + f262076i.incrementAndGet();
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            this.observerMap.put(str, observer);
            reentrantLock.unlock();
            NewIntent newIntent = new NewIntent(appInterface.getApp(), g.class);
            newIntent.putExtra("cmd", cmd);
            newIntent.putExtra("data", reqBytes);
            newIntent.putExtra("timeout", timeoutMillis);
            newIntent.putExtra("__cmd_seq__", str);
            appInterface.startServlet(newIntent);
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("QneRequestHandler", 1, "onDestroy, clear observer map");
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            this.observerMap.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, req, res, data);
        }
    }
}
