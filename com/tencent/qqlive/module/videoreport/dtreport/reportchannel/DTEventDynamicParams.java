package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.verifydata.VerifyDataHelper;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class DTEventDynamicParams implements IEventDynamicParams {
    private IDTParamProvider mDtParamProvider;
    private final ThreadLocal<Map<String, Object>> mEventParams;
    private final ThreadLocal<Map<String, Object>> mNonRealTimeParams;
    private final ThreadLocal<Map<String, Object>> mRealTimeParams;

    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        private static DTEventDynamicParams sInstance = new DTEventDynamicParams();

        InstanceHolder() {
        }
    }

    /* loaded from: classes22.dex */
    private static class ThreadLocalMap extends ThreadLocal<Map<String, Object>> {
        ThreadLocalMap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<String, Object> initialValue() {
            return new HashMap();
        }
    }

    private void addDTParams(Map<String, Object> map) {
        IDTParamProvider iDTParamProvider = this.mDtParamProvider;
        if (iDTParamProvider != null && map != null) {
            map.putAll(DTCommonParams.getCommParams(iDTParamProvider));
        }
    }

    private void checkParams(@NonNull Map<String, Object> map) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            VerifyDataHelper.checkMap(map);
        }
    }

    public static DTEventDynamicParams getInstance() {
        return InstanceHolder.sInstance;
    }

    public IDTParamProvider getDTParamProvider() {
        return this.mDtParamProvider;
    }

    public void setDTCommonParams(@NonNull IDTParamProvider iDTParamProvider) {
        this.mDtParamProvider = iDTParamProvider;
    }

    @Override // com.tencent.qqlive.module.videoreport.IEventDynamicParams
    public void setEventDynamicParams(String str, Map<String, Object> map) {
        Map<String, Object> map2 = this.mEventParams.get();
        map2.clear();
        IDTParamProvider iDTParamProvider = this.mDtParamProvider;
        if (iDTParamProvider != null) {
            iDTParamProvider.setEventDynamicParams(str, map2);
        }
        checkParams(map2);
        if (map != null) {
            map.putAll(map2);
        }
        map2.clear();
    }

    @Override // com.tencent.qqlive.module.videoreport.IEventDynamicParams
    public void setNonRealtimePublicDynamicParams(Map<String, Object> map) {
        Map<String, Object> map2 = this.mNonRealTimeParams.get();
        map2.clear();
        IDTParamProvider iDTParamProvider = this.mDtParamProvider;
        if (iDTParamProvider != null) {
            iDTParamProvider.setNonRealtimePublicDynamicParams(map2);
        }
        checkParams(map2);
        if (map != null) {
            map.putAll(map2);
        }
        addDTParams(map);
        map2.clear();
    }

    @Override // com.tencent.qqlive.module.videoreport.IEventDynamicParams
    public void setRealtimePublicDynamicParams(Map<String, Object> map) {
        Map<String, Object> map2 = this.mRealTimeParams.get();
        map2.clear();
        IDTParamProvider iDTParamProvider = this.mDtParamProvider;
        if (iDTParamProvider != null) {
            iDTParamProvider.setRealtimePublicDynamicParams(map2);
        }
        checkParams(map2);
        if (map != null) {
            map.putAll(map2);
        }
        map2.clear();
    }

    DTEventDynamicParams() {
        this.mRealTimeParams = new ThreadLocalMap();
        this.mNonRealTimeParams = new ThreadLocalMap();
        this.mEventParams = new ThreadLocalMap();
    }
}
