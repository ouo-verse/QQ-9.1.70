package com.tencent.mobileqq.unitedconfig_android;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.freesia.GetConfigRsp;
import com.tencent.freesia.PBUtils;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr.configDistributionSvr;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/UnitedConfigServlet;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "fromServiceMsg", "onReceive", "<init>", "()V", "d", "a", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class UnitedConfigServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<Random> f306015e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f306016f;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f306017h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f306018i;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f306019m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\t\u0010\n\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0011\u0010\n\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR(\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0015\u0010\n\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR(\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0019\u0010\n\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010%\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u0014\u0010&\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001fR\u0014\u0010'\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u0014\u0010(\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010)\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u0014\u0010+\u001a\u00020*8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u001d8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u001fR\u0014\u0010.\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u001fR\u0014\u0010/\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u001f\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/UnitedConfigServlet$a;", "", "Ljava/util/Random;", "random$delegate", "Lkotlin/Lazy;", "f", "()Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "", "fetchFailed", "Z", "b", "()Z", "setFetchFailed", "(Z)V", "getFetchFailed$annotations", "()V", "fetchNoLoginFailed", "c", "setFetchNoLoginFailed", "getFetchNoLoginFailed$annotations", "fetching", "d", "setFetching", "getFetching$annotations", "noLoginFetching", "e", "setNoLoginFetching", "getNoLoginFetching$annotations", "", "DEFAULT_UIN", "Ljava/lang/String;", "FETCH_COMMAND", "FETCH_NO_LOGIN_COMMAND", "KEY_CMD", "KEY_IS_SSO_RECEIVED", "KEY_REQUEST_BYTES", "KEY_REQUEST_SEQ", "KEY_RESULT", "KEY_RESULT_CODE", "KEY_RETRY_COUNT", "KEY_UIN", "", "SAMPLING_RATE", "I", "TAG", "UNITED_CONFIG_EXCEPTION_REPORT", "UNITED_CONFIG_SSO_REPORT", "<init>", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.unitedconfig_android.UnitedConfigServlet$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Random f() {
            return (Random) UnitedConfigServlet.f306015e.getValue();
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return UnitedConfigServlet.f306016f;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return UnitedConfigServlet.f306017h;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return UnitedConfigServlet.f306018i;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return UnitedConfigServlet.f306019m;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
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
        Lazy<Random> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(UnitedConfigServlet$Companion$random$2.INSTANCE);
        f306015e = lazy;
    }

    public UnitedConfigServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a1  */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(@Nullable Intent request, @Nullable FromServiceMsg fromServiceMsg) {
        int i3;
        configDistributionSvr.GetConfigRsp getConfigRsp;
        GetConfigRsp nativeRsp;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) fromServiceMsg);
            return;
        }
        if (request != null && fromServiceMsg != null) {
            String stringExtra = request.getStringExtra(CheckForwardServlet.KEY_CMD);
            QLog.d("FreesiaServlet", 1, "onReceive from " + stringExtra + " with code: " + fromServiceMsg.getResultCode());
            if (Intrinsics.areEqual(stringExtra, "trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetNoLoginConfig")) {
                f306019m = false;
            } else if (Intrinsics.areEqual(stringExtra, com.tencent.mobileqq.msf.core.k.f248590i)) {
                f306018i = false;
            } else {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_seq", request.getIntExtra("request_seq", -1));
            bundle.putString(CheckForwardServlet.KEY_CMD, stringExtra);
            bundle.putString("uin", request.getStringExtra("uin"));
            bundle.putInt("result_code", fromServiceMsg.getResultCode());
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("FreesiaServlet", 1, "app runtime is null");
                return;
            }
            String account = peekAppRuntime.getAccount();
            if (account == null) {
                account = TVKUpdateInfo.APP_ID;
            }
            if (INSTANCE.f().nextInt(10000) == 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("isSSOReceived", String.valueOf(fromServiceMsg.getResultCode()));
                linkedHashMap.put("retry_count", String.valueOf(request.getIntExtra("retry_count", 0)));
                QQBeaconReport.report(account, "unitedConfig_sso_report_event", linkedHashMap);
                QLog.d("FreesiaServlet", 1, "report SSO result: ", Integer.valueOf(fromServiceMsg.getResultCode()));
            }
            boolean isSuccess = fromServiceMsg.isSuccess();
            if (isSuccess) {
                try {
                    byte[] bArr = new byte[r0.getInt() - 4];
                    ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                    getConfigRsp = new configDistributionSvr.GetConfigRsp();
                    getConfigRsp.mergeFrom(bArr);
                    nativeRsp = PBUtils.INSTANCE.toNativeRsp(getConfigRsp);
                } catch (Throwable th5) {
                    th = th5;
                    i3 = 0;
                }
                try {
                    QLog.d("FreesiaServlet", 1, "onReveive seq: " + nativeRsp.getControlInfo().getConfigSeq() + ", interval: " + nativeRsp.getControlInfo().getUpdateInterval());
                    bundle.putParcelable("result", nativeRsp);
                    if (getConfigRsp.configs.has() && getConfigRsp.configs.size() > 0) {
                        QLog.d("FreesiaServlet", 1, "onReveive: group size = " + getConfigRsp.configs.size());
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i3 = 0;
                    QLog.e("FreesiaServlet", 1, th, new Object[i3]);
                    bundle.putParcelable("result", PBUtils.INSTANCE.toEmptyNativeRsp());
                    QQBeaconReport.report(account, "unitedConfig_exception_report_event");
                    QLog.d("FreesiaServlet", 1, "report exception");
                    z16 = i3;
                    if (!Intrinsics.areEqual(stringExtra, "trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetNoLoginConfig")) {
                    }
                    notifyObserver(request, 1, z16, bundle, m.class);
                }
            }
            z16 = isSuccess;
            if (!Intrinsics.areEqual(stringExtra, "trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetNoLoginConfig")) {
                f306017h = !z16;
            } else {
                f306016f = !z16;
            }
            notifyObserver(request, 1, z16, bundle, m.class);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) packet);
            return;
        }
        if (request != null && packet != null) {
            String stringExtra = request.getStringExtra(CheckForwardServlet.KEY_CMD);
            if (Intrinsics.areEqual(stringExtra, "trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetNoLoginConfig")) {
                f306019m = true;
            } else if (Intrinsics.areEqual(stringExtra, com.tencent.mobileqq.msf.core.k.f248590i)) {
                f306018i = true;
            }
            packet.setSSOCommand(stringExtra);
            packet.putSendData(fh.b(request.getByteArrayExtra("request_bytes")));
        }
    }
}
