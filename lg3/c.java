package lg3;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zplan.web.impl.CommonNative2JsEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Llg3/c;", "", "Llg3/b;", "cloudNetworkData", "", "b", "a", "", "I", "CHANGE_RATE_DELAY", "", "c", "Z", "isChangedRate", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f414549a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int CHANGE_RATE_DELAY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isChangedRate;

    static {
        CHANGE_RATE_DELAY = 200;
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("100341", new byte[0]), Charsets.UTF_8);
        if (str.length() > 0) {
            CHANGE_RATE_DELAY = new JSONObject(str).optInt("changeRateDelay", 200);
        }
    }

    c() {
    }

    public final void b(CloudNetworkData cloudNetworkData) {
        Intrinsics.checkNotNullParameter(cloudNetworkData, "cloudNetworkData");
        if (cloudNetworkData.getDelay() <= CHANGE_RATE_DELAY || isChangedRate) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rate", "2");
        SimpleEventBus.getInstance().dispatchEvent(new CommonNative2JsEvent("receiveMsgFromNative", new ZPlanModRPCData(0, null, null, jSONObject.toString(), 0L, "CG_GAME_EVENT_SETTING_RATE", null, 87, null).i()));
        QLog.i("CloudRateManager_", 1, "updateRateLimit :: SETTING_RATE");
        isChangedRate = true;
    }

    public final void a() {
        isChangedRate = false;
    }
}
