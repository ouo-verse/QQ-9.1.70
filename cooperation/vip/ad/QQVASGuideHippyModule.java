package cooperation.vip.ad;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQVASGuideHippyModule.TAG, thread = HippyNativeModule.Thread.MAIN)
/* loaded from: classes28.dex */
public class QQVASGuideHippyModule extends HippyNativeModuleBase {
    private static final String TAG = "QQVASGuideHippyModule";

    public QQVASGuideHippyModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "dismiss")
    public void dismiss() {
        QLog.d(TAG, 1, "dismiss....");
        a.closeLayer();
    }

    @HippyMethod(name = "doClickAction")
    public void doClickAction(HippyMap hippyMap) {
        String str;
        if (!hippyMap.containsKey("url")) {
            str = "";
        } else {
            str = hippyMap.getString("url");
        }
        SimpleEventBus.getInstance().dispatchEvent(new VideoMessage(3, str));
        if (hippyMap.containsKey("actionId")) {
            SimpleEventBus.getInstance().dispatchEvent(new VideoMessage(6, hippyMap.getString("actionId")));
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new VideoMessage(2, ""));
        }
        a.closeLayer();
        QLog.d(TAG, 2, "doClickAction actionId:", hippyMap.getString("actionId"), " jumpUrl: ", str);
    }

    @HippyMethod(name = "doDTReport")
    public void doDTReport(HippyMap hippyMap) {
        String string = hippyMap.getString(AdMetricTag.EVENT_NAME);
        if (TextUtils.isEmpty(string)) {
            QLog.e(TAG, 2, "doDTReport eventName is null");
            return;
        }
        HashMap hashMap = new HashMap();
        HippyMap map = hippyMap.getMap("eventParams");
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        VideoReport.reportEvent(string, hashMap);
        QLog.d(TAG, 2, "doDTReport eventName:", string, " params", hashMap);
    }

    @HippyMethod(name = "firstScreenTechReport")
    public void firstScreenTechReport(HippyMap hippyMap) {
        JSONObject jSONObject = new JSONObject();
        for (String str : hippyMap.keySet()) {
            try {
                jSONObject.put(str, hippyMap.get(str));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "firstScreenTechReport error", e16);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new VideoMessage(7, jSONObject.toString()));
    }
}
