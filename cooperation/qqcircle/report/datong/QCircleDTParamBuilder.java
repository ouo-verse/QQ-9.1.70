package cooperation.qqcircle.report.datong;

import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes28.dex */
public class QCircleDTParamBuilder {
    public IDynamicParams buildDynamicParams() {
        return new IDynamicParams() { // from class: cooperation.qqcircle.report.datong.QCircleDTParamBuilder.2
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public Map<String, Object> getDynamicParams(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                return hashMap;
            }
        };
    }

    public IElementDynamicParams buildElementDynamicParams() {
        return new IElementDynamicParams() { // from class: cooperation.qqcircle.report.datong.QCircleDTParamBuilder.1
            @Override // com.tencent.qqlive.module.videoreport.data.IElementDynamicParams
            public Map<String, Object> getElementDynamicParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                return hashMap;
            }
        };
    }

    public Map<String, Object> buildElementParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
        return hashMap;
    }

    public PageParams buildPageParams(String str) {
        return buildPageParams(str, null);
    }

    public PageParams buildPageParams(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
        hashMap.put(QCircleDaTongConstant.PageParam.PAGE_SUBCLASS, str);
        return new PageParams(hashMap);
    }
}
