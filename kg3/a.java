package kg3;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mb4.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J0\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fJ(\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0002J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J&\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002J&\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0016\u0010\"\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tJ&\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%J\u0006\u0010)\u001a\u00020\nR\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lkg3/a;", "", "", "mapId", ZPlanPublishSource.FROM_SCHEME, "time", "", "a", "event", "", "", "d", "", "params", "e", "code", "", QCircleWeakNetReporter.KEY_COST, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "modId", "currentUrl", h.F, "l", "p", "j", Constants.SP_DEVICE_ID, "gmUid", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/mod/data/a;", "rpcData", DomainData.DOMAIN_NAME, InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "o", "g", "type", "", "isReceiveFirstFrame", "isVideoReady", "f", "c", "b", "J", "mFragmentCreateTime", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412316a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mFragmentCreateTime;

    a() {
    }

    private final Map<String, String> a(String mapId, String scheme, String time) {
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", mapId);
        if (scheme == null) {
            scheme = "";
        }
        hashMap.put("k_action_scheme", scheme);
        if (time.length() == 0) {
            time = String.valueOf(System.currentTimeMillis());
        }
        hashMap.put("k_action_time", time);
        return hashMap;
    }

    public final void d(String event, int mapId, String scheme) {
        Intrinsics.checkNotNullParameter(event, "event");
        c.c(c.f416532a, event, b(this, String.valueOf(mapId), scheme, null, 4, null), false, 4, null);
    }

    public final void e(String event, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        c.c(c.f416532a, event, params, false, 4, null);
    }

    public final void f(int mapId, int type, boolean isReceiveFirstFrame, boolean isVideoReady) {
        String str;
        Map<String, String> b16 = b(this, String.valueOf(mapId), "", null, 4, null);
        b16.put("k_click_type", String.valueOf(type));
        String str2 = "1";
        if (isReceiveFirstFrame) {
            str = "1";
        } else {
            str = "0";
        }
        b16.put("k_is_receive_first_frame", str);
        if (!isVideoReady) {
            str2 = "0";
        }
        b16.put("k_is_video_ready", str2);
        e("e_zplan_cloud_mod_exit_dialog_click", b16);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportExitDialogClick, mapId: " + mapId + ", isReceiveFirstFrame:" + isReceiveFirstFrame + ", isVideoReady:" + isVideoReady);
    }

    public final void g(int mapId) {
        e("e_zplan_cloud_mod_exit_dialog", b(this, String.valueOf(mapId), "", null, 4, null));
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportExitDialogImpl, mapId: " + mapId);
    }

    public final void h(int modId, String currentUrl) {
        mFragmentCreateTime = System.currentTimeMillis();
        d("e_zplan_cloud_mod_fragment_init", modId, currentUrl);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportFragmentCreate");
    }

    public final void i(int modId, String currentUrl, String deviceId, String gmUid) {
        Intrinsics.checkNotNullParameter(currentUrl, "currentUrl");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmUid, "gmUid");
        Map<String, String> b16 = b(this, String.valueOf(modId), currentUrl, null, 4, null);
        b16.put("k_total_cost", String.valueOf(System.currentTimeMillis() - mFragmentCreateTime));
        b16.put("k_device_id", deviceId);
        b16.put("k_gm_uid", gmUid);
        e("e_zplan_cloud_mod_device_ready", b16);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportH5VideoReady, map: " + b16);
    }

    public final void j(int modId, String currentUrl, long cost) {
        Intrinsics.checkNotNullParameter(currentUrl, "currentUrl");
        Map<String, String> b16 = b(this, String.valueOf(modId), currentUrl, null, 4, null);
        b16.put("k_load_cost", String.valueOf(cost));
        b16.put("k_total_cost", String.valueOf(System.currentTimeMillis() - mFragmentCreateTime));
        e("e_zplan_cloud_mod_h5_ready", b16);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportH5LoadFinish, map: " + b16);
    }

    public final void k(int modId, String currentUrl, String deviceId, String gmUid) {
        Intrinsics.checkNotNullParameter(currentUrl, "currentUrl");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmUid, "gmUid");
        Map<String, String> b16 = b(this, String.valueOf(modId), currentUrl, null, 4, null);
        b16.put("k_total_cost", String.valueOf(System.currentTimeMillis() - mFragmentCreateTime));
        b16.put("k_device_id", deviceId);
        b16.put("k_gm_uid", gmUid);
        e("e_zplan_cloud_mod_video_ready", b16);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportH5VideoReady, map: " + b16);
    }

    public final void l(int modId, String currentUrl) {
        Intrinsics.checkNotNullParameter(currentUrl, "currentUrl");
        Map<String, String> b16 = b(this, String.valueOf(modId), currentUrl, null, 4, null);
        b16.put("k_total_cost", String.valueOf(System.currentTimeMillis() - mFragmentCreateTime));
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportModFirstFrame,, map: " + b16);
        e("e_zplan_cloud_mod_first_frame", b16);
    }

    public final void m(int mapId, String scheme, int code, long cost) {
        Map b16 = b(this, String.valueOf(mapId), scheme, null, 4, null);
        b16.put("k_load_cost", String.valueOf(cost));
        b16.put("k_quatify_type", String.valueOf(code));
        c.c(c.f416532a, "e_zplan_cloud_mod_quatify", b16, false, 4, null);
    }

    public final void n(ZPlanModRPCData rpcData) {
        Intrinsics.checkNotNullParameter(rpcData, "rpcData");
        Map<String, String> b16 = b(this, String.valueOf(rpcData.getModId()), "", null, 4, null);
        b16.put("k_rpc_type", String.valueOf(rpcData.getType()));
        b16.put("k_rpc_cost", "0");
        b16.put("k_rpc_msg", rpcData.i());
        e("e_zplan_cloud_mod_n2m", b16);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportReceiveL2NRPCData, rpcData: " + rpcData);
    }

    public final void o(ZPlanModRPCData rpcData, long currentTime) {
        Intrinsics.checkNotNullParameter(rpcData, "rpcData");
        Map<String, String> b16 = b(this, String.valueOf(rpcData.getModId()), "", null, 4, null);
        b16.put("k_rpc_type", String.valueOf(rpcData.getType()));
        b16.put("k_rpc_cost", String.valueOf(currentTime - rpcData.getTimeStamp()));
        b16.put("k_rpc_msg", rpcData.i());
        e("e_zplan_cloud_mod_m2n", b16);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportReceiveL2NRPCData, rpcData: " + rpcData + ", currentTime: " + currentTime);
    }

    public final void p(int modId, String currentUrl) {
        Intrinsics.checkNotNullParameter(currentUrl, "currentUrl");
        Map<String, String> b16 = b(this, String.valueOf(modId), currentUrl, null, 4, null);
        b16.put("k_total_cost", String.valueOf(System.currentTimeMillis() - mFragmentCreateTime));
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportSceneActive, map: " + b16);
        e("e_zplan_cloud_mod_scene_active", b16);
    }

    public final void q() {
        Map<String, String> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        e("e_zplan_cloud_mod_x5_not_ready", emptyMap);
        QLog.d("ZPlanCloudModTechReportHelper", 1, "reportX5NotReady");
    }

    public final void c() {
        mFragmentCreateTime = 0L;
    }

    static /* synthetic */ Map b(a aVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        return aVar.a(str, str2, str3);
    }
}
