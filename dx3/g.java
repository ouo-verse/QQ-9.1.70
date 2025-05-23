package dx3;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqnt.kernel.nativeinterface.BatteryStatus;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.SendRequestParam;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import com.tencent.qqnt.kernel.nativeinterface.SessionTicket;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001Jf\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000eH&J`\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000eH&J\u0084\u0001\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000e2&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H&J\b\u0010\u001c\u001a\u00020\u001bH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J0\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010 H&J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0&H\u0016\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010*\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH&\u00a8\u0006+"}, d2 = {"Ldx3/g;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "serviceType", "cmd", "", "pbBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/SendRequestParam;", "param", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "transInfoMap", "", "onSendOidbRequest", "ssoCmd", "a", "httpMethod", "url", "heads", "params", "retryCnt", "timeout", "onSendNetRequest", "Lcom/tencent/qqnt/kernel/nativeinterface/BatteryStatus;", "getBatteryStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/SessionTicket;", "getLoginTicket", "domain", "Lcom/tencent/qqnt/kernel/nativeinterface/IpType;", "ipType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "Lkotlin/collections/ArrayList;", "getIpDirectList", "", "c", "()[Ljava/lang/String;", "uin", "b", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface g {
    void a(long requestId, @Nullable String ssoCmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap);

    @Nullable
    String b(@NotNull String uin);

    @NotNull
    String[] c();

    @NotNull
    BatteryStatus getBatteryStatus();

    @Nullable
    ArrayList<ServerAddress> getIpDirectList(@Nullable String domain, @Nullable IpType ipType);

    @Nullable
    SessionTicket getLoginTicket();

    void onSendNetRequest(long requestId, @Nullable String httpMethod, @Nullable String url, @Nullable HashMap<String, String> heads, @Nullable HashMap<String, String> params, int retryCnt, int timeout);

    void onSendOidbRequest(long requestId, int serviceType, int cmd, @Nullable byte[] pbBuffer, @Nullable SendRequestParam param, @Nullable String traceInfo, @Nullable HashMap<String, byte[]> transInfoMap);
}
