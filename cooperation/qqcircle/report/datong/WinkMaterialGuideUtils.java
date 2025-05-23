package cooperation.qqcircle.report.datong;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WinkMaterialGuideUtils {
    public static final String KEY_ATTRS = "key_attrs";

    public static Map<String, Object> getReportArgsFromIntent(Activity activity) {
        HashMap hashMap = new HashMap();
        if (activity != null && activity.getIntent() != null && activity.getIntent().getExtras() != null && activity.getIntent().getExtras().size() > 0) {
            Map map = (Map) activity.getIntent().getExtras().get("key_attrs");
            if (map != null && !map.isEmpty()) {
                if (map.get("xsj_operation_activity_id") != null && !TextUtils.isEmpty(map.get("xsj_operation_activity_id").toString())) {
                    hashMap.put("xsj_operation_activity_id", map.get("xsj_operation_activity_id"));
                }
                if (map.get("xsj_material_type") != null && !TextUtils.isEmpty(map.get("xsj_material_type").toString())) {
                    hashMap.put("xsj_material_type", map.get("xsj_material_type"));
                }
                if (map.get("xsj_material_id") != null && !TextUtils.isEmpty(map.get("xsj_material_id").toString())) {
                    hashMap.put("xsj_material_id", map.get("xsj_material_id"));
                }
                if (map.get("xsj_resource_type") != null && !TextUtils.isEmpty(map.get("xsj_resource_type").toString())) {
                    hashMap.put("xsj_resource_type", map.get("xsj_resource_type"));
                }
                if (map.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE) != null && !TextUtils.isEmpty(map.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE).toString())) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, map.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE));
                }
            }
            try {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PREVIEW_PAGE_TYPE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_PREVIEW_PAGE_TYPE));
                if (activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE) != null) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE));
                }
                if (hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE) == null) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE));
                }
            } catch (Exception e16) {
                QLog.i("WinkMaterialGuideUtils", 1, "getReportArgsFromIntent error " + e16.getMessage());
                e16.printStackTrace();
            }
        }
        return hashMap;
    }
}
