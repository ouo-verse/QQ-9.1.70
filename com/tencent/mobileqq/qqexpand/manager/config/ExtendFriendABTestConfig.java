package com.tencent.mobileqq.qqexpand.manager.config;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import expand.network.ExtendFriendABTestConfig$ExtendFriendParamsInfo;
import expand.network.ExtendFriendABTestConfig$GrayPolicyInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendABTestConfig extends zg2.a {
    public static final int INTERVAL_TIME_HOUR = 24;
    private String expKey;
    private String grayPolicyId;
    private final List<a> paramsInfoList;
    private String sGroupKey;
    private String sStrategyType;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f263912a;

        /* renamed from: b, reason: collision with root package name */
        private String f263913b;

        public a(ExtendFriendABTestConfig$ExtendFriendParamsInfo extendFriendABTestConfig$ExtendFriendParamsInfo) {
            this.f263912a = extendFriendABTestConfig$ExtendFriendParamsInfo.key.get();
            this.f263913b = extendFriendABTestConfig$ExtendFriendParamsInfo.value.get();
        }
    }

    public ExtendFriendABTestConfig() {
        this.paramsInfoList = new ArrayList();
    }

    public static ExtendFriendABJson buildConfigJson(List<ExtendFriendABTestConfig> list) {
        return new ExtendFriendABJson(list);
    }

    public String getExpKey() {
        return this.expKey;
    }

    public String getGrayPolicyId() {
        return this.grayPolicyId;
    }

    public List<a> getParamsInfoList() {
        return this.paramsInfoList;
    }

    public String getsGroupKey() {
        return this.sGroupKey;
    }

    public String getsStrategyType() {
        return this.sStrategyType;
    }

    public void setExpKey(String str) {
        this.expKey = str;
    }

    public void setGrayPolicyId(String str) {
        this.grayPolicyId = str;
    }

    public void setParamsInfoList(List<a> list) {
        this.paramsInfoList.clear();
        this.paramsInfoList.addAll(list);
    }

    public void setsGroupKey(String str) {
        this.sGroupKey = str;
    }

    public void setsStrategyType(String str) {
        this.sStrategyType = str;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class ExtendFriendABJson extends zg2.a {
        private final List<ExtendFriendABTestConfig> grayPolicyInfoList = new ArrayList();
        private long reqTimestamp;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes35.dex */
        public class a implements ExclusionStrategy {
            a() {
            }

            @Override // com.google.gson.ExclusionStrategy
            public boolean shouldSkipClass(Class<?> cls) {
                return false;
            }

            @Override // com.google.gson.ExclusionStrategy
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return "reqTimestamp".equals(fieldAttributes.getName());
            }
        }

        public ExtendFriendABJson() {
        }

        public static String getEmptyJson() {
            return getNoTimeStampGson().toJson(new ExtendFriendABJson());
        }

        public static Gson getNoTimeStampGson() {
            return new GsonBuilder().setExclusionStrategies(new a()).create();
        }

        public List<ExtendFriendABTestConfig> getGrayPolicyInfoList() {
            return this.grayPolicyInfoList;
        }

        public long getReqTimestamp() {
            return this.reqTimestamp;
        }

        public void setGrayPolicyInfoList(List<ExtendFriendABTestConfig> list) {
            this.grayPolicyInfoList.clear();
            this.grayPolicyInfoList.addAll(list);
        }

        public void setReqTimestamp(long j3) {
            this.reqTimestamp = j3;
        }

        public ExtendFriendABJson(List<ExtendFriendABTestConfig> list) {
            setGrayPolicyInfoList(list);
        }
    }

    public ExtendFriendABTestConfig(String str, List<a> list, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        this.paramsInfoList = arrayList;
        this.grayPolicyId = str;
        this.sGroupKey = str2;
        this.sStrategyType = str3;
        this.expKey = str4;
        arrayList.addAll(list);
    }

    public static List<ExtendFriendABTestConfig> buildConfigList(List<ExtendFriendABTestConfig$GrayPolicyInfo> list) {
        if (list != null && list.size() != 0) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                ExtendFriendABTestConfig$GrayPolicyInfo extendFriendABTestConfig$GrayPolicyInfo = list.get(i3);
                PBRepeatMessageField<ExtendFriendABTestConfig$ExtendFriendParamsInfo> pBRepeatMessageField = extendFriendABTestConfig$GrayPolicyInfo.paramsInfoList;
                int size2 = pBRepeatMessageField.size();
                ArrayList arrayList2 = new ArrayList();
                if (size2 > 0) {
                    for (int i16 = 0; i16 < size2; i16++) {
                        arrayList2.add(new a(pBRepeatMessageField.get(i16)));
                    }
                }
                arrayList.add(new ExtendFriendABTestConfig(extendFriendABTestConfig$GrayPolicyInfo.grayPolicyId.get(), arrayList2, extendFriendABTestConfig$GrayPolicyInfo.sGroupKey.get(), extendFriendABTestConfig$GrayPolicyInfo.sStrategyType.get(), extendFriendABTestConfig$GrayPolicyInfo.expKey.get()));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
