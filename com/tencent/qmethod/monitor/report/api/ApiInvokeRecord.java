package com.tencent.qmethod.monitor.report.api;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.api.u;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0010B\u00f3\u0001\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u000b\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u000b\u0012\b\b\u0002\u00104\u001a\u00020\u000b\u0012\b\b\u0002\u00107\u001a\u00020\u000b\u0012\b\b\u0002\u00109\u001a\u00020\u000b\u0012\b\b\u0002\u0010<\u001a\u00020\u000b\u0012\b\b\u0002\u0010?\u001a\u00020\u000b\u0012\b\b\u0002\u0010A\u001a\u00020\u000b\u0012\b\b\u0002\u0010D\u001a\u00020\u000b\u0012\b\b\u0002\u0010G\u001a\u00020\u000b\u0012\b\b\u0002\u0010I\u001a\u00020\u000b\u0012\b\b\u0002\u0010M\u001a\u00020\u000b\u0012\b\b\u0002\u0010P\u001a\u00020\u000b\u0012\b\b\u0002\u0010R\u001a\u00020\u000b\u0012\b\b\u0002\u0010T\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u00040Uj\b\u0012\u0004\u0012\u00020\u0004`V\u00a2\u0006\u0004\b\\\u0010]J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u0004H\u0016J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010*\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b,\u0010\"R\"\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\"\u00104\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001e\u001a\u0004\b\u001d\u0010 \"\u0004\b3\u0010\"R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\"\u00109\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b\u0017\u0010 \"\u0004\b8\u0010\"R\"\u0010<\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u001e\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R\"\u0010?\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u001e\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\"\u0010A\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b2\u0010 \"\u0004\b@\u0010\"R\"\u0010D\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u001e\u001a\u0004\b\u001a\u0010 \"\u0004\bC\u0010\"R\"\u0010G\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\bF\u0010\"R\"\u0010I\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001e\u001a\u0004\bB\u0010 \"\u0004\bH\u0010\"R\"\u0010M\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u001e\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"R\"\u0010P\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\u001e\u001a\u0004\bE\u0010 \"\u0004\bO\u0010\"R\"\u0010R\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u001e\u001a\u0004\b.\u0010 \"\u0004\bQ\u0010\"R\"\u0010T\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001e\u001a\u0004\bJ\u0010 \"\u0004\bS\u0010\"R2\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u00040Uj\b\u0012\u0004\u0012\u00020\u0004`V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010W\u001a\u0004\bN\u0010X\"\u0004\bY\u0010Z\u00a8\u0006^"}, d2 = {"Lcom/tencent/qmethod/monitor/report/api/b;", "", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "", "stackStr", "", "w", "Lorg/json/JSONObject;", HippyTKDListViewAdapter.X, "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "setModuleName", "(Ljava/lang/String;)V", "moduleName", "b", "setApiName", "apiName", "c", "u", "setStackStr", "d", "I", "k", "()I", "setFgCount", "(I)V", "fgCount", "e", "f", "setBgCount", "bgCount", "j", "setFgCacheCount", "fgCacheCount", "g", "setBgCacheCount", "bgCacheCount", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setNormalCount", "normalCount", "i", "setBeforeCount", "beforeCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setIllegalCount", "illegalCount", "setBackCount", "backCount", "l", "setHighFreqCount", "highFreqCount", "t", "setSilenceCount", "silenceCount", "setDenyRetryCount", "denyRetryCount", "o", "setBanCount", "banCount", "p", "setCacheCount", "cacheCount", "setNoCacheCount", "noCacheCount", "r", "v", "setStorageCount", "storageCount", ReportConstant.COSTREPORT_PREFIX, "setNoStorageCount", "noStorageCount", "setCacheOnlyCount", "cacheOnlyCount", "setNotSetCount", "notSetCount", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "Ljava/util/LinkedHashSet;", "()Ljava/util/LinkedHashSet;", "setPages", "(Ljava/util/LinkedHashSet;)V", "pages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIIIIIIIIIIIIILjava/util/LinkedHashSet;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.report.api.b, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ApiInvokeRecord {

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String moduleName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String apiName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String stackStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int fgCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int bgCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int fgCacheCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int bgCacheCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int normalCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int beforeCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int illegalCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int backCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int highFreqCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int silenceCount;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private int denyRetryCount;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private int banCount;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private int cacheCount;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private int noCacheCount;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private int storageCount;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private int noStorageCount;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private int cacheOnlyCount;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private int notSetCount;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedHashSet<String> pages;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qmethod/monitor/report/api/b$a;", "", "Lorg/json/JSONObject;", "Lcom/tencent/qmethod/monitor/report/api/b;", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.report.api.b$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ApiInvokeRecord a(@NotNull JSONObject toApiInvokeRecord) {
            Intrinsics.checkParameterIsNotNull(toApiInvokeRecord, "$this$toApiInvokeRecord");
            JSONArray optJSONArray = toApiInvokeRecord.optJSONArray("pages");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    if (obj != null) {
                        linkedHashSet.add((String) obj);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
            String optString = toApiInvokeRecord.optString("moduleName");
            Intrinsics.checkExpressionValueIsNotNull(optString, "optString(\"moduleName\")");
            String optString2 = toApiInvokeRecord.optString("apiName");
            Intrinsics.checkExpressionValueIsNotNull(optString2, "optString(\"apiName\")");
            String optString3 = toApiInvokeRecord.optString("stackStr");
            Intrinsics.checkExpressionValueIsNotNull(optString3, "optString(\"stackStr\")");
            return new ApiInvokeRecord(optString, optString2, optString3, toApiInvokeRecord.optInt("fgCount"), toApiInvokeRecord.optInt("bgCount"), toApiInvokeRecord.optInt("fgCacheCount"), toApiInvokeRecord.optInt("bgCacheCount"), toApiInvokeRecord.optInt("normalCount"), toApiInvokeRecord.optInt("beforeCount"), toApiInvokeRecord.optInt("illegalCount"), toApiInvokeRecord.optInt("backCount"), toApiInvokeRecord.optInt("highFreqCount"), toApiInvokeRecord.optInt("silenceCount"), toApiInvokeRecord.optInt("denyRetryCount"), toApiInvokeRecord.optInt("banCount"), toApiInvokeRecord.optInt("cacheCount"), toApiInvokeRecord.optInt("noCacheCount"), toApiInvokeRecord.optInt("storageCount"), toApiInvokeRecord.optInt("noStorageCount"), toApiInvokeRecord.optInt("cacheOnlyCount"), toApiInvokeRecord.optInt("notSetCount"), linkedHashSet);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ApiInvokeRecord() {
        this(null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 4194303, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getApiName() {
        return this.apiName;
    }

    /* renamed from: b, reason: from getter */
    public final int getBackCount() {
        return this.backCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getBanCount() {
        return this.banCount;
    }

    /* renamed from: d, reason: from getter */
    public final int getBeforeCount() {
        return this.beforeCount;
    }

    /* renamed from: e, reason: from getter */
    public final int getBgCacheCount() {
        return this.bgCacheCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ApiInvokeRecord) {
                ApiInvokeRecord apiInvokeRecord = (ApiInvokeRecord) other;
                if (!Intrinsics.areEqual(this.moduleName, apiInvokeRecord.moduleName) || !Intrinsics.areEqual(this.apiName, apiInvokeRecord.apiName) || !Intrinsics.areEqual(this.stackStr, apiInvokeRecord.stackStr) || this.fgCount != apiInvokeRecord.fgCount || this.bgCount != apiInvokeRecord.bgCount || this.fgCacheCount != apiInvokeRecord.fgCacheCount || this.bgCacheCount != apiInvokeRecord.bgCacheCount || this.normalCount != apiInvokeRecord.normalCount || this.beforeCount != apiInvokeRecord.beforeCount || this.illegalCount != apiInvokeRecord.illegalCount || this.backCount != apiInvokeRecord.backCount || this.highFreqCount != apiInvokeRecord.highFreqCount || this.silenceCount != apiInvokeRecord.silenceCount || this.denyRetryCount != apiInvokeRecord.denyRetryCount || this.banCount != apiInvokeRecord.banCount || this.cacheCount != apiInvokeRecord.cacheCount || this.noCacheCount != apiInvokeRecord.noCacheCount || this.storageCount != apiInvokeRecord.storageCount || this.noStorageCount != apiInvokeRecord.noStorageCount || this.cacheOnlyCount != apiInvokeRecord.cacheOnlyCount || this.notSetCount != apiInvokeRecord.notSetCount || !Intrinsics.areEqual(this.pages, apiInvokeRecord.pages)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final int getBgCount() {
        return this.bgCount;
    }

    /* renamed from: g, reason: from getter */
    public final int getCacheCount() {
        return this.cacheCount;
    }

    /* renamed from: h, reason: from getter */
    public final int getCacheOnlyCount() {
        return this.cacheOnlyCount;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.moduleName;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.apiName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.stackStr;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (((((((((((((((((((((((((((((((((((((i26 + i17) * 31) + this.fgCount) * 31) + this.bgCount) * 31) + this.fgCacheCount) * 31) + this.bgCacheCount) * 31) + this.normalCount) * 31) + this.beforeCount) * 31) + this.illegalCount) * 31) + this.backCount) * 31) + this.highFreqCount) * 31) + this.silenceCount) * 31) + this.denyRetryCount) * 31) + this.banCount) * 31) + this.cacheCount) * 31) + this.noCacheCount) * 31) + this.storageCount) * 31) + this.noStorageCount) * 31) + this.cacheOnlyCount) * 31) + this.notSetCount) * 31;
        LinkedHashSet<String> linkedHashSet = this.pages;
        if (linkedHashSet != null) {
            i18 = linkedHashSet.hashCode();
        }
        return i27 + i18;
    }

    /* renamed from: i, reason: from getter */
    public final int getDenyRetryCount() {
        return this.denyRetryCount;
    }

    /* renamed from: j, reason: from getter */
    public final int getFgCacheCount() {
        return this.fgCacheCount;
    }

    /* renamed from: k, reason: from getter */
    public final int getFgCount() {
        return this.fgCount;
    }

    /* renamed from: l, reason: from getter */
    public final int getHighFreqCount() {
        return this.highFreqCount;
    }

    /* renamed from: m, reason: from getter */
    public final int getIllegalCount() {
        return this.illegalCount;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getModuleName() {
        return this.moduleName;
    }

    /* renamed from: o, reason: from getter */
    public final int getNoCacheCount() {
        return this.noCacheCount;
    }

    /* renamed from: p, reason: from getter */
    public final int getNoStorageCount() {
        return this.noStorageCount;
    }

    /* renamed from: q, reason: from getter */
    public final int getNormalCount() {
        return this.normalCount;
    }

    /* renamed from: r, reason: from getter */
    public final int getNotSetCount() {
        return this.notSetCount;
    }

    @NotNull
    public final LinkedHashSet<String> s() {
        return this.pages;
    }

    /* renamed from: t, reason: from getter */
    public final int getSilenceCount() {
        return this.silenceCount;
    }

    @NotNull
    public String toString() {
        return "ApiInvokeRecord(moduleName='" + this.moduleName + "', apiName='" + this.apiName + "', stackStr='" + this.stackStr + "', fgCount=" + this.fgCount + ", bgCount=" + this.bgCount + ", fgCacheCount=" + this.fgCacheCount + ", bgCacheCount=" + this.bgCacheCount + ", normalCount=" + this.normalCount + ", beforeCount=" + this.beforeCount + ", illegalCount=" + this.illegalCount + ", backCount=" + this.backCount + ", highFreqCount=" + this.highFreqCount + ", silenceCount=" + this.silenceCount + ", denyRetryCount=" + this.denyRetryCount + ", banCount=" + this.banCount + ", cacheCount=" + this.cacheCount + ", noCacheCount=" + this.noCacheCount + ", storageCount=" + this.storageCount + ", noStorageCount=" + this.noStorageCount + ", cacheOnlyCount=" + this.cacheOnlyCount + ", notSetCount=" + this.notSetCount + ')';
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getStackStr() {
        return this.stackStr;
    }

    /* renamed from: v, reason: from getter */
    public final int getStorageCount() {
        return this.storageCount;
    }

    public final void w(@NotNull u reportStrategy, @NotNull String stackStr) {
        int i3;
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        Intrinsics.checkParameterIsNotNull(stackStr, "stackStr");
        String str = reportStrategy.f343964a;
        Intrinsics.checkExpressionValueIsNotNull(str, "reportStrategy.moduleName");
        this.moduleName = str;
        String str2 = reportStrategy.f343965b;
        Intrinsics.checkExpressionValueIsNotNull(str2, "reportStrategy.apiName");
        this.apiName = str2;
        this.stackStr = stackStr;
        if ((Intrinsics.areEqual(reportStrategy.f343968e, "cache_only") || Intrinsics.areEqual(reportStrategy.f343968e, "memory") || Intrinsics.areEqual(reportStrategy.f343968e, QQPermissionConstants.Permission.STORAGE_GROUP)) && !reportStrategy.f343969f) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (com.tencent.qmethod.monitor.a.l()) {
            this.fgCount++;
            this.fgCacheCount += i3;
        } else {
            this.bgCount++;
            this.bgCacheCount += i3;
        }
        String[] strArr = reportStrategy.f343982s;
        if (strArr != null) {
            LinkedHashSet<String> linkedHashSet = this.pages;
            Intrinsics.checkExpressionValueIsNotNull(strArr, "reportStrategy.currentPages");
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, strArr);
        }
        if (Intrinsics.areEqual("normal", reportStrategy.f343967d)) {
            this.normalCount++;
        }
        if (Intrinsics.areEqual("before", reportStrategy.f343967d)) {
            this.beforeCount++;
        }
        if (Intrinsics.areEqual("illegal_scene", reportStrategy.f343967d)) {
            this.illegalCount++;
        }
        if (Intrinsics.areEqual("back", reportStrategy.f343967d)) {
            this.backCount++;
        }
        if (Intrinsics.areEqual("high_freq", reportStrategy.f343967d)) {
            this.highFreqCount++;
        }
        if (Intrinsics.areEqual("silence", reportStrategy.f343967d)) {
            this.silenceCount++;
        }
        if (Intrinsics.areEqual("deny_retry", reportStrategy.f343967d)) {
            this.denyRetryCount++;
        }
        if (Intrinsics.areEqual("ban", reportStrategy.f343968e)) {
            this.banCount++;
        }
        if (Intrinsics.areEqual("memory", reportStrategy.f343968e)) {
            if (i3 != 0) {
                this.cacheCount++;
            } else {
                this.noCacheCount++;
            }
        }
        if (Intrinsics.areEqual(QQPermissionConstants.Permission.STORAGE_GROUP, reportStrategy.f343968e)) {
            if (i3 != 0) {
                this.storageCount++;
            } else {
                this.noStorageCount++;
            }
        }
        if (Intrinsics.areEqual("cache_only", reportStrategy.f343968e)) {
            this.cacheOnlyCount++;
        }
        if (Intrinsics.areEqual("normal", reportStrategy.f343968e)) {
            this.notSetCount++;
        }
    }

    @NotNull
    public final JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("moduleName", this.moduleName);
        jSONObject.put("apiName", this.apiName);
        jSONObject.put("stackStr", this.stackStr);
        jSONObject.put("fgCount", this.fgCount);
        jSONObject.put("bgCount", this.bgCount);
        jSONObject.put("fgCacheCount", this.fgCacheCount);
        jSONObject.put("bgCacheCount", this.bgCacheCount);
        jSONObject.put("normalCount", this.normalCount);
        jSONObject.put("beforeCount", this.beforeCount);
        jSONObject.put("illegalCount", this.illegalCount);
        jSONObject.put("backCount", this.backCount);
        jSONObject.put("highFreqCount", this.highFreqCount);
        jSONObject.put("silenceCount", this.silenceCount);
        jSONObject.put("denyRetryCount", this.denyRetryCount);
        jSONObject.put("banCount", this.banCount);
        jSONObject.put("cacheCount", this.cacheCount);
        jSONObject.put("noCacheCount", this.noCacheCount);
        jSONObject.put("storageCount", this.storageCount);
        jSONObject.put("noStorageCount", this.noStorageCount);
        jSONObject.put("cacheOnlyCount", this.cacheOnlyCount);
        jSONObject.put("notSetCount", this.notSetCount);
        jSONObject.put("pages", new JSONArray((Collection) this.pages));
        return jSONObject;
    }

    public ApiInvokeRecord(@NotNull String moduleName, @NotNull String apiName, @NotNull String stackStr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, int i56, @NotNull LinkedHashSet<String> pages) {
        Intrinsics.checkParameterIsNotNull(moduleName, "moduleName");
        Intrinsics.checkParameterIsNotNull(apiName, "apiName");
        Intrinsics.checkParameterIsNotNull(stackStr, "stackStr");
        Intrinsics.checkParameterIsNotNull(pages, "pages");
        this.moduleName = moduleName;
        this.apiName = apiName;
        this.stackStr = stackStr;
        this.fgCount = i3;
        this.bgCount = i16;
        this.fgCacheCount = i17;
        this.bgCacheCount = i18;
        this.normalCount = i19;
        this.beforeCount = i26;
        this.illegalCount = i27;
        this.backCount = i28;
        this.highFreqCount = i29;
        this.silenceCount = i36;
        this.denyRetryCount = i37;
        this.banCount = i38;
        this.cacheCount = i39;
        this.noCacheCount = i46;
        this.storageCount = i47;
        this.noStorageCount = i48;
        this.cacheOnlyCount = i49;
        this.notSetCount = i56;
        this.pages = pages;
    }

    public /* synthetic */ ApiInvokeRecord(String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, int i56, LinkedHashSet linkedHashSet, int i57, DefaultConstructorMarker defaultConstructorMarker) {
        this((i57 & 1) != 0 ? "" : str, (i57 & 2) != 0 ? "" : str2, (i57 & 4) == 0 ? str3 : "", (i57 & 8) != 0 ? 0 : i3, (i57 & 16) != 0 ? 0 : i16, (i57 & 32) != 0 ? 0 : i17, (i57 & 64) != 0 ? 0 : i18, (i57 & 128) != 0 ? 0 : i19, (i57 & 256) != 0 ? 0 : i26, (i57 & 512) != 0 ? 0 : i27, (i57 & 1024) != 0 ? 0 : i28, (i57 & 2048) != 0 ? 0 : i29, (i57 & 4096) != 0 ? 0 : i36, (i57 & 8192) != 0 ? 0 : i37, (i57 & 16384) != 0 ? 0 : i38, (i57 & 32768) != 0 ? 0 : i39, (i57 & 65536) != 0 ? 0 : i46, (i57 & 131072) != 0 ? 0 : i47, (i57 & 262144) != 0 ? 0 : i48, (i57 & 524288) != 0 ? 0 : i49, (i57 & 1048576) != 0 ? 0 : i56, (i57 & 2097152) != 0 ? new LinkedHashSet() : linkedHashSet);
    }
}
