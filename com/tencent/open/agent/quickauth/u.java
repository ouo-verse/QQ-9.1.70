package com.tencent.open.agent.quickauth;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.api.qrlogin.IQrLoginApi;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.quickauth.u;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.OpenAppInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SecCheckResult;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wtlogin.qrlogin.scanresult.QrLogin$RejectInfo;
import wtlogin.qrlogin.scanresult.QrLogin$RiskInfo;
import wtlogin.qrlogin.scanresult.QrLogin$ScanResultInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00106\u001a\u00020\u0005\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.\u00a8\u0006:"}, d2 = {"Lcom/tencent/open/agent/quickauth/u;", "Lcom/tencent/open/agent/quickauth/WebQuickAuthHandler;", "", "p0", "G", "Landroid/os/Bundle;", "data", "u0", "Lwtlogin/qrlogin/scanresult/QrLogin$ScanResultInfo;", "scanResultInfo", "Ljava/lang/StringBuilder;", "log", "", "r0", "", "tips", "isNewQrLogin", "y0", "w0", "m0", "o0", "B0", "l", "a", "Lcom/tencent/open/agent/quickauth/z;", "e", "k", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "mDialog", "Lcom/tencent/mobileqq/loginregister/servlet/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/loginregister/servlet/a;", "mQrLoginManager", "Landroid/os/Handler;", DomainData.DOMAIN_NAME, "Landroid/os/Handler;", "mSubHandler", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "o", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "mGetAppIdWTLoginObserver", "p", "wtloginObserver", "Lf72/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lf72/a;", "mGetAppInfoQrLoginCallback", "r", "mQrLoginCallback", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/open/agent/quickauth/i;", "view", "mParams", "<init>", "(Landroid/app/Activity;Lcom/tencent/open/agent/quickauth/i;Landroid/os/Bundle;)V", ReportConstant.COSTREPORT_PREFIX, "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class u extends WebQuickAuthHandler {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.servlet.a mQrLoginManager;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler mSubHandler;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.loginregister.servlet.h mGetAppIdWTLoginObserver;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.loginregister.servlet.h wtloginObserver;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f72.a mGetAppInfoQrLoginCallback;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f72.a mQrLoginCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\\\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/open/agent/quickauth/u$b", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "", "userAccount", "", "appName", "", "time", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "data", "errMsg", "", "ret", "Loicq/wlogin_sdk/tools/ErrMsg;", NotificationActivity.KEY_LAST_ERROR, "", "E", "e", "cmd", "j", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends com.tencent.mobileqq.loginregister.servlet.h {
        b() {
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void E(@Nullable String userAccount, @Nullable byte[] appName, long time, @Nullable ArrayList<String> data, @Nullable byte[] errMsg, int ret, @Nullable ErrMsg lastError) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "mGetAppIdWTLoginObserver.OnVerifyCode(): ret=" + ret);
            if (ret != 0) {
                return;
            }
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i3 = 0; i3 < size; i3++) {
                    try {
                        String str = data.get(i3);
                        Intrinsics.checkNotNullExpressionValue(str, "data[i]");
                        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
                        int buf_to_int16 = util.buf_to_int16(hexStr2Bytes, 0);
                        int buf_to_int162 = util.buf_to_int16(hexStr2Bytes, 2);
                        com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "onVerifyCode data tag: " + buf_to_int16);
                        if (buf_to_int16 == 54) {
                            byte[] bArr = new byte[buf_to_int162];
                            System.arraycopy(hexStr2Bytes, 4, bArr, 0, buf_to_int162);
                            String str2 = new String(bArr, Charsets.UTF_8);
                            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "mGetAppIdWTLoginObserver.OnVerifyCode(): getAppid sucess Json:" + str2);
                            JSONObject jSONObject = new JSONObject(str2);
                            long optLong = jSONObject.optLong("open_appid");
                            String from = jSONObject.optString("comefrom");
                            u uVar = u.this;
                            Intrinsics.checkNotNullExpressionValue(from, "from");
                            uVar.K(optLong, from);
                        }
                    } catch (Throwable th5) {
                        com.tencent.open.agent.util.t.d("QrCodeWebQuickAuthHandler", "mGetAppIdWTLoginObserver.OnVerifyCode exeption:", th5);
                    }
                }
                return;
            }
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "mGetAppIdWTLoginObserver.OnVerifyCode getAppid failed for data is null");
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void j(@NotNull String e16, int cmd) {
            Intrinsics.checkNotNullParameter(e16, "e");
            super.j(e16, cmd);
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "mGetAppIdWTLoginObserver.OnException() e:" + e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/open/agent/quickauth/u$c", "Lf72/a;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", "info", "", "a", "jmpUrl", "b", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements f72.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f340458a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f340459b;

        c(i iVar, u uVar) {
            this.f340458a = iVar;
            this.f340459b = uVar;
        }

        @Override // f72.a
        public void a(int result, @Nullable String errMsg, @Nullable ScanQrRspInfo info) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "onVerifyCode result: " + result + ", info: " + info);
            if (result == 0 && info != null) {
                i iVar = this.f340458a;
                String str = info.dstAppName;
                Intrinsics.checkNotNullExpressionValue(str, "info.dstAppName");
                iVar.p0(str, null);
                OpenAppInfo openAppInfo = info.dstOpenAppInfo;
                if (openAppInfo != null) {
                    u uVar = this.f340459b;
                    long j3 = openAppInfo.openAppid;
                    String str2 = openAppInfo.comeFrom;
                    Intrinsics.checkNotNullExpressionValue(str2, "dstOpenAppInfo.comeFrom");
                    uVar.K(j3, str2);
                }
            }
        }

        @Override // f72.a
        public void b(int result, @Nullable String errMsg, @Nullable String jmpUrl) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "onCloseCode result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/open/agent/quickauth/u$d", "Lf72/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", "info", "", "g", "", "result", "", "errMsg", "", "a", "jmpUrl", "b", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements f72.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f340461b;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes22.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f340462a;

            static {
                int[] iArr = new int[SecCheckResult.values().length];
                try {
                    iArr[SecCheckResult.KSAFE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SecCheckResult.KRISK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SecCheckResult.KREJECT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f340462a = iArr;
            }
        }

        d(i iVar) {
            this.f340461b = iVar;
        }

        private final boolean g(final ScanQrRspInfo info) {
            int i3;
            if (info == null) {
                com.tencent.open.agent.util.t.e("QrCodeWebQuickAuthHandler", "handleScanQrRspInfo: ScanQrRspInfo = null");
                return false;
            }
            SecCheckResult secCheckResult = info.getSecCheckResult();
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "handleScanQrRspInfo scanResult: " + secCheckResult);
            if (secCheckResult == null) {
                i3 = -1;
            } else {
                i3 = a.f340462a[secCheckResult.ordinal()];
            }
            if (i3 == 1) {
                u.this.m0();
                return true;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final i iVar = this.f340461b;
                final u uVar = u.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.open.agent.quickauth.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.d.i(i.this, uVar, info);
                    }
                });
                return true;
            }
            Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
            final i iVar2 = this.f340461b;
            final u uVar2 = u.this;
            uIHandlerV22.post(new Runnable() { // from class: com.tencent.open.agent.quickauth.x
                @Override // java.lang.Runnable
                public final void run() {
                    u.d.h(i.this, uVar2, info);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(i view, u this$0, ScanQrRspInfo scanQrRspInfo) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            view.L();
            String tips = scanQrRspInfo.getTips().getTips();
            Intrinsics.checkNotNullExpressionValue(tips, "info.getTips().getTips()");
            this$0.y0(tips, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(i view, u this$0, ScanQrRspInfo scanQrRspInfo) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            view.L();
            String tips = scanQrRspInfo.getTips().getTips();
            Intrinsics.checkNotNullExpressionValue(tips, "info.getTips().getTips()");
            this$0.w0(tips);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(int i3) {
            QQToast.makeText(MobileQQ.sMobileQQ, 1, HardCodeUtil.qqStr(R.string.f172504rf2) + i3 + ")", 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(int i3, i view, u this$0) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(MobileQQ.sMobileQQ, 1, HardCodeUtil.qqStr(R.string.f172503rf1) + i3 + ")", 1).show();
            view.n1(this$0.B(null));
        }

        @Override // f72.a
        public void a(final int result, @Nullable String errMsg, @Nullable ScanQrRspInfo info) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "mQrLoginCallback onVerifyCode result=" + result + ", info=" + info);
            if (result != 0) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final i iVar = this.f340461b;
                final u uVar = u.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.open.agent.quickauth.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.d.k(result, iVar, uVar);
                    }
                });
            }
            if (!g(info)) {
                u.this.m0();
            }
        }

        @Override // f72.a
        public void b(final int result, @Nullable String errMsg, @Nullable String jmpUrl) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "mQrLoginCallback onCloseCode result=" + result + " errMsg=" + errMsg);
            if (result != 0) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.quickauth.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.d.j(result);
                    }
                });
            }
            this.f340461b.n1(u.this.B(null));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/open/agent/quickauth/u$e", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1007) {
                com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "handler message HANDLE_VERIFY_CODE");
                Bundle data = msg2.getData();
                u uVar = u.this;
                Intrinsics.checkNotNullExpressionValue(data, "data");
                uVar.u0(data);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JJ\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016JP\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/open/agent/quickauth/u$f", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "", "userAccount", "", "appName", "", "time", "Loicq/wlogin_sdk/request/WUserSigInfo;", "userSigInfo", "errMsg", "", "ret", "Loicq/wlogin_sdk/tools/ErrMsg;", NotificationActivity.KEY_LAST_ERROR, "", tl.h.F, "Ljava/util/ArrayList;", "data", "E", "e", "cmd", "j", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class f extends com.tencent.mobileqq.loginregister.servlet.h {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f340464d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ u f340465e;

        f(i iVar, u uVar) {
            this.f340464d = iVar;
            this.f340465e = uVar;
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void E(@Nullable String userAccount, @Nullable byte[] appName, long time, @Nullable ArrayList<String> data, @Nullable byte[] errMsg, int ret, @Nullable ErrMsg lastError) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "wtloginObserver.OnVerifyCode userAccount=" + userAccount + " ret=" + ret);
            Bundle bundle = new Bundle();
            bundle.putInt("key_verify_code_ret", ret);
            bundle.putStringArrayList("key_verify_code_tlv", data);
            bundle.putByteArray("key_verify_err_msg", errMsg);
            Message message = new Message();
            message.setData(bundle);
            message.what = 1007;
            this.f340465e.mSubHandler.sendMessage(message);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void h(@Nullable String userAccount, @Nullable byte[] appName, long time, @Nullable WUserSigInfo userSigInfo, @Nullable byte[] errMsg, int ret, @Nullable ErrMsg lastError) {
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "wtloginObserver.OnCloseCode userAccount=" + userAccount + " ret=" + ret);
            if (ret != 0) {
                QQToast.makeText(MobileQQ.sMobileQQ, 1, HardCodeUtil.qqStr(R.string.f172504rf2) + ret + ")", 2000).show();
            }
            this.f340464d.n1(this.f340465e.B(null));
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void j(@NotNull String e16, int cmd) {
            Intrinsics.checkNotNullParameter(e16, "e");
            com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "wtloginObserver.OnException e=" + e16);
            this.f340464d.n1(this.f340465e.B(null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull Activity activity, @NotNull i view, @NotNull Bundle mParams) {
        super(activity, view, mParams);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        this.mSubHandler = new e(ThreadManagerV2.getSubThreadLooper());
        this.mGetAppIdWTLoginObserver = new b();
        this.wtloginObserver = new f(view, this);
        this.mGetAppInfoQrLoginCallback = new c(view, this);
        this.mQrLoginCallback = new d(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(u this$0, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        if (z16) {
            this$0.m0();
        } else {
            this$0.o0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B0() {
        int indexOf$default;
        int i3;
        boolean contains$default;
        com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "-->verifyQRCode()");
        String string = getMParams().getString("qrcode");
        if (string == null) {
            string = "";
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, "?k=", 0, false, 6, (Object) null);
        int i16 = indexOf$default + 3;
        if (i16 >= 3 && (i3 = i16 + 32) <= string.length()) {
            String substring = string.substring(i16, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            Charset charset = Charsets.UTF_8;
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            U(com.tencent.open.agent.util.q.a(bytes, substring.length()));
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "&n=1", false, 2, (Object) null);
            if (!contains$default && !MobileQQ.sMobileQQ.isLoginByNT()) {
                Bundle bundle = new Bundle();
                bundle.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, com.tencent.open.agent.util.q.b(d(), 2, false).toByteArray());
                IRuntimeService runtimeService = d().getRuntimeService(ILoginServletService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppRuntime().getRunti\u2026ant.ALL\n                )");
                ((ILoginServletService) runtimeService).verifyCode(getCurrentAccount(), 16L, true, getQrCodeBytes(), new int[]{3, 5, 32, 53}, 1, this.wtloginObserver, bundle);
                return;
            }
            com.tencent.mobileqq.loginregister.servlet.a aVar = this.mQrLoginManager;
            if (aVar != null) {
                ScanScene scanScene = ScanScene.KWXONETAB;
                byte[] bytes2 = substring.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                aVar.i(scanScene, bytes2, this.mQrLoginCallback);
                return;
            }
            return;
        }
        com.tencent.open.agent.util.t.e("QrCodeWebQuickAuthHandler", "verifyQRCode qrCodeContent error: " + i16 + "," + string.length() + "," + string);
        getView().n1(B(null));
    }

    private final void G() {
        if (Intrinsics.areEqual(getCurrentAccount(), d().getAccount())) {
            com.tencent.open.agent.util.t.b("QrCodeWebQuickAuthHandler", "-->doAuthorize verifyQRCode");
            B0();
            return;
        }
        com.tencent.open.agent.util.d.e("qrcode_ssoGetTicketNoPasswd", 0L);
        com.tencent.open.agent.util.t.b("QrCodeWebQuickAuthHandler", "-->doAuthorize authAccount[" + getCurrentAccount() + "] is not currentAccount[" + StringUtil.getSimpleUinForPrint(d().getAccount()) + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(final u this$0, final boolean z16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.n
            @Override // java.lang.Runnable
            public final void run() {
                u.l0(z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(boolean z16, u this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.G();
        } else {
            this$0.getView().u0();
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.cp9, 0).show(this$0.h().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.quickauth.o
            @Override // java.lang.Runnable
            public final void run() {
                u.n0(u.this);
            }
        });
        com.tencent.mobileqq.loginregister.servlet.a aVar = this.mQrLoginManager;
        if (aVar != null) {
            aVar.f(SwitchOperation.KOPDEFAULT, this.mQrLoginCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(u this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getView().showProgress(null);
    }

    private final void o0() {
        getView().showProgress(null);
        ArrayList<String> arrayList = new ArrayList<>();
        IRuntimeService runtimeService = d().getRuntimeService(ILoginServletService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppRuntime()\n        \u2026ava, ProcessConstant.ALL)");
        ((ILoginServletService) runtimeService).closeCode(getCurrentAccount(), 16L, getQrCodeBytes(), 1, arrayList, this.wtloginObserver, null);
    }

    private final void p0() {
        int indexOf$default;
        int i3;
        boolean contains$default;
        com.tencent.open.agent.util.t.f("QrCodeWebQuickAuthHandler", "-->getAppidByWtlogin()");
        String string = getMParams().getString("qrcode", "");
        Intrinsics.checkNotNullExpressionValue(string, "mParams.getString(PtLogi\u2026nst.URL_PARAM_QRCODE, \"\")");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, "?k=", 0, false, 6, (Object) null);
        int i16 = indexOf$default + 3;
        if (i16 >= 3 && (i3 = i16 + 32) <= string.length()) {
            String substring = string.substring(i16, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            Charset charset = Charsets.UTF_8;
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            U(com.tencent.open.agent.util.q.a(bytes, substring.length()));
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "&n=1", false, 2, (Object) null);
            if (!contains$default && !MobileQQ.sMobileQQ.isLoginByNT()) {
                Bundle bundle = new Bundle();
                bundle.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, com.tencent.open.agent.util.q.b(d(), 2, false).toByteArray());
                IRuntimeService runtimeService = d().getRuntimeService(ILoginServletService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppRuntime()\n        \u2026ava, ProcessConstant.ALL)");
                ((ILoginServletService) runtimeService).verifyCode(getCurrentAccount(), 16L, true, getQrCodeBytes(), new int[]{3, 5, 32, 54}, 1, this.mGetAppIdWTLoginObserver, bundle);
                return;
            }
            com.tencent.mobileqq.loginregister.servlet.a qrLoginManager = ((IQrLoginApi) QRoute.api(IQrLoginApi.class)).getQrLoginManager();
            this.mQrLoginManager = qrLoginManager;
            if (qrLoginManager != null) {
                ScanScene scanScene = ScanScene.KWXONETAB;
                byte[] bytes2 = substring.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                qrLoginManager.i(scanScene, bytes2, this.mGetAppInfoQrLoginCallback);
                return;
            }
            return;
        }
        com.tencent.open.agent.util.t.e("QrCodeWebQuickAuthHandler", "getAppidByWtlogin qrCodeString error: " + i16 + "," + string.length() + "," + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(u this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0();
    }

    private final boolean r0(final QrLogin$ScanResultInfo scanResultInfo, StringBuilder log) {
        if (scanResultInfo == null) {
            log.append(",scanResultInfo = null");
            return false;
        }
        if (!scanResultInfo.scan_result.has()) {
            log.append(",scan_result = null");
            return false;
        }
        int i3 = scanResultInfo.scan_result.get();
        log.append(",scan_result = ");
        log.append(i3);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.quickauth.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.t0(u.this, scanResultInfo);
                    }
                });
                return true;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.quickauth.p
                @Override // java.lang.Runnable
                public final void run() {
                    u.s0(u.this, scanResultInfo);
                }
            });
            return true;
        }
        o0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(u this$0, QrLogin$ScanResultInfo qrLogin$ScanResultInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getView().L();
        QrLogin$RiskInfo qrLogin$RiskInfo = qrLogin$ScanResultInfo.risk_info.get();
        if (qrLogin$RiskInfo != null && qrLogin$RiskInfo.str_new_tips_template.has()) {
            str = qrLogin$RiskInfo.str_new_tips_template.get();
            Intrinsics.checkNotNullExpressionValue(str, "riskInfo.str_new_tips_template.get()");
        } else {
            str = "";
        }
        this$0.y0(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(u this$0, QrLogin$ScanResultInfo qrLogin$ScanResultInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getView().L();
        QrLogin$RejectInfo qrLogin$RejectInfo = qrLogin$ScanResultInfo.reject_info.get();
        String str2 = "";
        if (qrLogin$RejectInfo == null || !qrLogin$RejectInfo.str_tips.has()) {
            str = "";
        } else {
            str = qrLogin$RejectInfo.str_tips.get();
        }
        if (str != null) {
            str2 = str;
        }
        this$0.w0(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(final Bundle data) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.agent.quickauth.l
            @Override // java.lang.Runnable
            public final void run() {
                u.v0(data, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Bundle data, u this$0) {
        QrLogin$ScanResultInfo qrLogin$ScanResultInfo;
        Object th5;
        byte[] hexStr2Bytes;
        int buf_to_int16;
        int buf_to_int162;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = data.getInt("key_verify_code_ret", 1);
        ArrayList<String> stringArrayList = data.getStringArrayList("key_verify_code_tlv");
        byte[] byteArray = data.getByteArray("key_verify_err_msg");
        if (byteArray == null) {
            byteArray = new byte[0];
        }
        StringBuilder sb5 = new StringBuilder("handleVerifyCode");
        QrLogin$ScanResultInfo qrLogin$ScanResultInfo2 = null;
        if (i3 == 0) {
            if (stringArrayList != null) {
                int size = stringArrayList.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        break;
                    }
                    try {
                        hexStr2Bytes = com.tencent.mobileqq.utils.HexUtil.hexStr2Bytes(stringArrayList.get(i16));
                        buf_to_int16 = util.buf_to_int16(hexStr2Bytes, 0);
                        buf_to_int162 = util.buf_to_int16(hexStr2Bytes, 2);
                    } catch (Throwable th6) {
                        qrLogin$ScanResultInfo = qrLogin$ScanResultInfo2;
                        th5 = th6;
                    }
                    if (buf_to_int16 == 208) {
                        qrLogin$ScanResultInfo = new QrLogin$ScanResultInfo();
                        try {
                            byte[] bArr = new byte[buf_to_int162];
                            System.arraycopy(hexStr2Bytes, 4, bArr, 0, buf_to_int162);
                            qrLogin$ScanResultInfo.mergeFrom(bArr);
                            qrLogin$ScanResultInfo2 = qrLogin$ScanResultInfo;
                            break;
                        } catch (Throwable th7) {
                            th5 = th7;
                            com.tencent.open.agent.util.t.e("QrCodeWebQuickAuthHandler", th5);
                            qrLogin$ScanResultInfo2 = qrLogin$ScanResultInfo;
                            i16++;
                        }
                    } else {
                        continue;
                        i16++;
                    }
                }
            }
            if (!this$0.r0(qrLogin$ScanResultInfo2, sb5)) {
                this$0.o0();
            }
        } else {
            sb5.append(",ret = ");
            sb5.append(i3);
            sb5.append(",errMsg = ");
            sb5.append(new String(byteArray, Charsets.UTF_8));
            QQToast.makeText(MobileQQ.sMobileQQ, 1, HardCodeUtil.qqStr(R.string.f172503rf1) + i3 + ")", 2000).show();
            this$0.getView().n1(this$0.B(null));
        }
        com.tencent.open.agent.util.t.b("QrCodeWebQuickAuthHandler", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(String tips) {
        if (TextUtils.isEmpty(tips)) {
            tips = h().getString(R.string.f216815zb);
        }
        String str = tips;
        Intrinsics.checkNotNullExpressionValue(str, "if (TextUtils.isEmpty(ti\u2026th_reject_tips) else tips");
        if (getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().isFinishing()) {
            com.tencent.open.agent.util.t.b("QrCodeWebQuickAuthHandler", "showRejectDialog, activity is finishing.");
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, (String) null, str, (String) null, h().getString(R.string.f216805za), new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.quickauth.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                u.x0(u.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
        this.mDialog = createCustomDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(u this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getView().n1(this$0.B(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(String tips, final boolean isNewQrLogin) {
        if (TextUtils.isEmpty(tips)) {
            tips = h().getString(R.string.f216845ze);
        }
        String str = tips;
        Intrinsics.checkNotNullExpressionValue(str, "if (TextUtils.isEmpty(ti\u2026auth_risk_tips) else tips");
        if (getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().isFinishing()) {
            com.tencent.open.agent.util.t.b("QrCodeWebQuickAuthHandler", "showRiskDialog, activity is finishing.");
            return;
        }
        QQCustomDialog createCountdownDialog = DialogUtil.createCountdownDialog(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), null, str, h().getString(R.string.f216835zd), h().getString(R.string.f216825zc), true, 10, 1, new View.OnClickListener() { // from class: com.tencent.open.agent.quickauth.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.z0(u.this, view);
            }
        }, new View.OnClickListener() { // from class: com.tencent.open.agent.quickauth.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.A0(u.this, isNewQrLogin, view);
            }
        });
        this.mDialog = createCountdownDialog;
        if (createCountdownDialog != null) {
            createCountdownDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this$0.getView().n1(this$0.B(null));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.open.agent.quickauth.WebQuickAuthHandler, com.tencent.open.agent.quickauth.j
    public void a() {
        getView().showProgress(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.f171153cp1));
        com.tencent.open.agent.util.g.f(getCurrentAccount(), new com.tencent.open.agent.util.u() { // from class: com.tencent.open.agent.quickauth.k
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z16, String str) {
                u.k0(u.this, z16, str);
            }
        });
    }

    @Override // com.tencent.open.agent.quickauth.WebQuickAuthHandler, com.tencent.open.agent.quickauth.j
    @NotNull
    public QuickAuthApp e() {
        QuickAuthApp e16 = super.e();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.agent.quickauth.m
            @Override // java.lang.Runnable
            public final void run() {
                u.q0(u.this);
            }
        });
        return e16;
    }

    @Override // com.tencent.open.agent.quickauth.j
    public boolean k() {
        return false;
    }

    @Override // com.tencent.open.agent.quickauth.WebQuickAuthHandler, com.tencent.open.agent.quickauth.j
    public void l() {
        com.tencent.open.b.d();
    }
}
