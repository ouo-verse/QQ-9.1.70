package com.tencent.ecommerce.biz.customerservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u000b\fJ3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo;", "", "Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;", "scene", "", "shopId", "spuId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo$a;", "fetchCustomerServiceInfo", "(Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECCustomerServiceRepo {
    Object fetchCustomerServiceInfo(CustomerServiceScene customerServiceScene, String str, String str2, String str3, Continuation<? super CustomerServiceResult> continuation);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "errorCode", "b", "Ljava/lang/String;", "errorMsg", "c", "url", "", "d", "Ljava/util/Map;", "()Ljava/util/Map;", "interceptInfos", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CustomerServiceResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int errorCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String errorMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String url;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final Map<String, String> interceptInfos;

        public CustomerServiceResult(int i3, String str, String str2, Map<String, String> map) {
            this.errorCode = i3;
            this.errorMsg = str;
            this.url = str2;
            this.interceptInfos = map;
        }

        public final Map<String, String> a() {
            return this.interceptInfos;
        }

        public int hashCode() {
            int i3 = this.errorCode * 31;
            String str = this.errorMsg;
            int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.url;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Map<String, String> map = this.interceptInfos;
            return hashCode2 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "CustomerServiceResult(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", url=" + this.url + ", interceptInfos=" + this.interceptInfos + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomerServiceResult)) {
                return false;
            }
            CustomerServiceResult customerServiceResult = (CustomerServiceResult) other;
            return this.errorCode == customerServiceResult.errorCode && Intrinsics.areEqual(this.errorMsg, customerServiceResult.errorMsg) && Intrinsics.areEqual(this.url, customerServiceResult.url) && Intrinsics.areEqual(this.interceptInfos, customerServiceResult.interceptInfos);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo$b;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "replaceUrl", "b", "extractParamKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class UrlOverrideInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String replaceUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String extractParamKey;

        /* renamed from: c, reason: collision with root package name */
        private static final Gson f101981c = new GsonBuilder().create();

        public UrlOverrideInfo(String str, String str2) {
            this.replaceUrl = str;
            this.extractParamKey = str2;
        }

        public final String a() {
            return f101981c.toJson(this);
        }

        public int hashCode() {
            String str = this.replaceUrl;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.extractParamKey;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "UrlOverrideInfo(replaceUrl=" + this.replaceUrl + ", extractParamKey=" + this.extractParamKey + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UrlOverrideInfo)) {
                return false;
            }
            UrlOverrideInfo urlOverrideInfo = (UrlOverrideInfo) other;
            return Intrinsics.areEqual(this.replaceUrl, urlOverrideInfo.replaceUrl) && Intrinsics.areEqual(this.extractParamKey, urlOverrideInfo.extractParamKey);
        }
    }
}
