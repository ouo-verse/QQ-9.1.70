package com.tencent.cache.core.manager.api;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0010\b\n\u0002\b,\u0018\u0000 z2\u00020\u0001:\u0001zB\u0007\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\"\u00104\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010)\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R\"\u00107\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010)\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R\"\u0010:\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010)\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R\"\u0010=\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010)\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R(\u0010@\u001a\b\u0012\u0004\u0012\u00020'0 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR(\u0010H\u001a\b\u0012\u0004\u0012\u00020'0 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010A\u001a\u0004\bI\u0010C\"\u0004\bJ\u0010ER\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010GR\"\u0010L\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010)\u001a\u0004\bM\u0010+\"\u0004\bN\u0010-R\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u0010\u001a\u0004\b)\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u0010\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR\"\u0010W\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u0010\u001a\u0004\bX\u0010Q\"\u0004\bY\u0010SR\"\u0010Z\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u0010\u001a\u0004\b[\u0010Q\"\u0004\b\\\u0010SR\"\u0010]\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\u0010\u001a\u0004\b^\u0010Q\"\u0004\b_\u0010SR\"\u0010`\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\u0010\u001a\u0004\ba\u0010Q\"\u0004\bb\u0010SR\"\u0010c\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010\u0010\u001a\u0004\bd\u0010Q\"\u0004\be\u0010SR\"\u0010f\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010)\u001a\u0004\bg\u0010+\"\u0004\bh\u0010-R\"\u0010i\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010)\u001a\u0004\bj\u0010+\"\u0004\bk\u0010-R\"\u0010l\u001a\u00020O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010\u0010\u001a\u0004\bm\u0010Q\"\u0004\bn\u0010SR\"\u0010o\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010)\u001a\u0004\bp\u0010+\"\u0004\bq\u0010-R\"\u0010r\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\br\u0010)\u001a\u0004\bs\u0010+\"\u0004\bt\u0010-R\"\u0010u\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010\u0006\u001a\u0004\bv\u0010\b\"\u0004\bw\u0010\n\u00a8\u0006{"}, d2 = {"Lcom/tencent/cache/core/manager/api/CacheConfig;", "", "", "toString", "", "cleanImageSwitch", "Z", "l", "()Z", "M", "(Z)V", "cleanCommonSwitch", "k", "L", "allowSizeCalculator", "c", "I", "useBitmapPool", "G", "setUseBitmapPool", "logRemovedDetailInfo", "w", "setLogRemovedDetailInfo", "useRfwMonitor", "H", "setUseRfwMonitor", "modifyCollectionCompute", "y", "setModifyCollectionCompute", "checkNative", "i", "K", "", "fixedCacheInfo", "[Ljava/lang/String;", "r", "()[Ljava/lang/String;", "setFixedCacheInfo", "([Ljava/lang/String;)V", "", "imageMaxSizeRatio", UserInfo.SEX_FEMALE, "u", "()F", "O", "(F)V", "imagePoolMaxSizeRatio", "v", "setImagePoolMaxSizeRatio", "commonCacheMaxSizeRatio", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setCommonCacheMaxSizeRatio", "imageCacheRatioBelowAndroid8", "t", "setImageCacheRatioBelowAndroid8", "businessUseFrequencyWeight", "g", "setBusinessUseFrequencyWeight", "businessUseTimeWeight", h.F, "setBusinessUseTimeWeight", "businessCacheSizeWeight", "f", "setBusinessCacheSizeWeight", "appLowMemoryCleanRate", "[Ljava/lang/Float;", "d", "()[Ljava/lang/Float;", "J", "([Ljava/lang/Float;)V", "appLowMemoryCleanRateStr", "Ljava/lang/String;", "sysLowMemoryCleanRate", "D", "P", "sysLowMemoryCleanRateStr", "backgroundCleanRate", "e", "setBackgroundCleanRate", "", "trimTimeInternalLowMemory", "()I", "setTrimTimeInternalLowMemory", "(I)V", "trimTimeInternalBackground", "E", "setTrimTimeInternalBackground", "delayCalculatorFromInit", "p", "setDelayCalculatorFromInit", "classComputerMaxTime", "j", "setClassComputerMaxTime", "sameClassComputeMaxTimes", "B", "setSameClassComputeMaxTimes", "singleClassMaxSize", BdhLogUtil.LogTag.Tag_Conn, "setSingleClassMaxSize", "maxComputeDepth", HippyTKDListViewAdapter.X, "setMaxComputeDepth", "dalvikMemoryCeilRate", DomainData.DOMAIN_NAME, "setDalvikMemoryCeilRate", "dalvikMemoryCleanRate", "o", "setDalvikMemoryCleanRate", "pssCeilThreshold", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setPssCeilThreshold", "reportSamplingPercent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setReportSamplingPercent", "hitSampling", ReportConstant.COSTREPORT_PREFIX, "setHitSampling", "fixView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "N", "<init>", "()V", "a", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class CacheConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @SerializedName(alternate = {"allowCalc"}, value = "allowSizeCalculator")
    private boolean allowSizeCalculator;

    @SerializedName("appMemCleanRate")
    @NotNull
    private Float[] appLowMemoryCleanRate;

    @SerializedName("appLowMemoryCleanRate")
    private String appLowMemoryCleanRateStr;

    @SerializedName(alternate = {"bgCleanRate"}, value = "backgroundCleanRate")
    private float backgroundCleanRate;

    @SerializedName(alternate = {"useSizeWT"}, value = "businessCacheSizeWeight")
    private float businessCacheSizeWeight;

    @SerializedName(alternate = {"useFreqWT"}, value = "businessUseFrequencyWeight")
    private float businessUseFrequencyWeight;

    @SerializedName(alternate = {"useTimeWT"}, value = "businessUseTimeWeight")
    private float businessUseTimeWeight;

    @SerializedName("checkNav")
    private boolean checkNative;

    @SerializedName(alternate = {"cmpMaxTime"}, value = "classComputerMaxTime")
    private int classComputerMaxTime;

    @SerializedName(alternate = {"cleanCol"}, value = "cleanCommonSwitch")
    private boolean cleanCommonSwitch;

    @SerializedName(alternate = {"cleanImg"}, value = "cleanImageSwitch")
    private boolean cleanImageSwitch;

    @SerializedName(alternate = {"colRatio"}, value = "commonCacheMaxSizeRatio")
    private float commonCacheMaxSizeRatio;

    @SerializedName(alternate = {"dvkCeilRate"}, value = "dalvikMemoryCeilRate")
    private float dalvikMemoryCeilRate;

    @SerializedName(alternate = {"dvkCleanRate"}, value = "dalvikMemoryCleanRate")
    private float dalvikMemoryCleanRate;

    @SerializedName(alternate = {"delayInit"}, value = "delayCalculatorFromInit")
    private int delayCalculatorFromInit;

    @SerializedName("fixView")
    private boolean fixView;

    @SerializedName(alternate = {"fixedInfo"}, value = "fixedCacheInfo")
    @NotNull
    private String[] fixedCacheInfo;

    @SerializedName("hitSamp")
    private float hitSampling;

    @SerializedName(alternate = {"imgRatioBLO8"}, value = "imageCacheRatioBelowAndroid8")
    private float imageCacheRatioBelowAndroid8;

    @SerializedName(alternate = {"imgRatio"}, value = "imageMaxSizeRatio")
    private float imageMaxSizeRatio;

    @SerializedName(alternate = {"imgPoolRatio"}, value = "imagePoolMaxSizeRatio")
    private float imagePoolMaxSizeRatio;

    @SerializedName(alternate = {"logMore"}, value = "logRemovedDetailInfo")
    private boolean logRemovedDetailInfo;

    @SerializedName(alternate = {"cmpMaxDeep"}, value = "maxComputeDepth")
    private int maxComputeDepth;

    @SerializedName(alternate = {"modifyCol"}, value = "modifyCollectionCompute")
    private boolean modifyCollectionCompute;

    @SerializedName(alternate = {"pssCeilTHR"}, value = "pssCeilThreshold")
    private int pssCeilThreshold;

    @SerializedName(alternate = {"sampling"}, value = "reportSamplingPercent")
    private float reportSamplingPercent;

    @SerializedName(alternate = {"cmpMaxTimes"}, value = "sameClassComputeMaxTimes")
    private int sameClassComputeMaxTimes;

    @SerializedName(alternate = {"cmpMaxSize"}, value = "singleClassMaxSize")
    private int singleClassMaxSize;

    @SerializedName("sysMemCleanRate")
    @NotNull
    private Float[] sysLowMemoryCleanRate;

    @SerializedName("sysLowMemoryCleanRate")
    private String sysLowMemoryCleanRateStr;

    @SerializedName(alternate = {"bgINR"}, value = "trimTimeInternalBackground")
    private int trimTimeInternalBackground;

    @SerializedName(alternate = {"lowMemINR"}, value = "trimTimeInternalLowMemory")
    private int trimTimeInternalLowMemory;

    @SerializedName(alternate = {"useBmpPool"}, value = "useBitmapPool")
    private boolean useBitmapPool;

    @SerializedName(alternate = {"useRfw"}, value = "useRfwMonitor")
    private boolean useRfwMonitor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/cache/core/manager/api/CacheConfig$a;", "", "", "business", "subBusiness", "", "a", "jsonStr", "Lcom/tencent/cache/core/manager/api/CacheConfig;", "b", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.cache.core.manager.api.CacheConfig$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public final boolean a(@NotNull String business, @NotNull String subBusiness) {
            boolean z16;
            boolean contains;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) business, (Object) subBusiness)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(business, "business");
            Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
            String[] r16 = c.f98725d.d().r();
            if (r16.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!(!z16)) {
                return false;
            }
            contains = ArraysKt___ArraysKt.contains(r16, business + '-' + subBusiness);
            if (!contains) {
                return false;
            }
            return true;
        }

        @NotNull
        public final CacheConfig b(@NotNull String jsonStr) {
            boolean contains$default;
            boolean contains$default2;
            List split$default;
            int collectionSizeOrDefault;
            List split$default2;
            int collectionSizeOrDefault2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CacheConfig) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jsonStr);
            }
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            CacheConfig config = (CacheConfig) new Gson().fromJson(jsonStr, CacheConfig.class);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) jsonStr, (CharSequence) "appLowMemoryCleanRate", false, 2, (Object) null);
            if (contains$default) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) config.appLowMemoryCleanRateStr, new String[]{","}, false, 0, 6, (Object) null);
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator it = split$default2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Float.valueOf(Float.parseFloat((String) it.next())));
                }
                Object[] array = arrayList.toArray(new Float[0]);
                if (array != null) {
                    config.J((Float[]) array);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) jsonStr, (CharSequence) "sysLowMemoryCleanRate", false, 2, (Object) null);
            if (contains$default2) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) config.sysLowMemoryCleanRateStr, new String[]{","}, false, 0, 6, (Object) null);
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = split$default.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Float.valueOf(Float.parseFloat((String) it5.next())));
                }
                Object[] array2 = arrayList2.toArray(new Float[0]);
                if (array2 != null) {
                    config.P((Float[]) array2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            Intrinsics.checkNotNullExpressionValue(config, "config");
            return config;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CacheConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.cleanImageSwitch = true;
        this.cleanCommonSwitch = true;
        this.allowSizeCalculator = true;
        this.modifyCollectionCompute = true;
        this.fixedCacheInfo = new String[0];
        this.imageMaxSizeRatio = 0.1875f;
        this.imagePoolMaxSizeRatio = 0.0625f;
        this.commonCacheMaxSizeRatio = 0.25f;
        this.imageCacheRatioBelowAndroid8 = 0.3f;
        this.businessUseFrequencyWeight = 0.3f;
        this.businessUseTimeWeight = 0.3f;
        this.businessCacheSizeWeight = 0.4f;
        this.appLowMemoryCleanRate = new Float[]{Float.valueOf(0.3f), Float.valueOf(0.3f), Float.valueOf(0.0f)};
        this.appLowMemoryCleanRateStr = "0.3f, 0.3f, 0f";
        this.sysLowMemoryCleanRate = new Float[]{Float.valueOf(0.5f), Float.valueOf(0.3f), Float.valueOf(0.1f), Float.valueOf(0.0f)};
        this.sysLowMemoryCleanRateStr = "0.5f, 0.3f, 0.1f, 0f";
        this.backgroundCleanRate = 0.5f;
        this.trimTimeInternalLowMemory = 60000;
        this.trimTimeInternalBackground = 180000;
        this.delayCalculatorFromInit = 30000;
        this.classComputerMaxTime = 1000;
        this.sameClassComputeMaxTimes = 5;
        this.singleClassMaxSize = 15728640;
        this.maxComputeDepth = 5;
        this.dalvikMemoryCeilRate = 0.8f;
        this.dalvikMemoryCleanRate = 0.9f;
        this.pssCeilThreshold = 1073741824;
        this.reportSamplingPercent = 0.01f;
        this.hitSampling = 0.001f;
    }

    public final float A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Float) iPatchRedirector.redirect((short) 61, (Object) this)).floatValue();
        }
        return this.reportSamplingPercent;
    }

    public final int B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, (Object) this)).intValue();
        }
        return this.sameClassComputeMaxTimes;
    }

    public final int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.singleClassMaxSize;
    }

    @NotNull
    public final Float[] D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Float[]) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.sysLowMemoryCleanRate;
    }

    public final int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return this.trimTimeInternalBackground;
    }

    public final int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.trimTimeInternalLowMemory;
    }

    public final boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.useBitmapPool;
    }

    public final boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.useRfwMonitor;
    }

    public final void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.allowSizeCalculator = z16;
        }
    }

    public final void J(@NotNull Float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) fArr);
        } else {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.appLowMemoryCleanRate = fArr;
        }
    }

    public final void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.checkNative = z16;
        }
    }

    public final void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.cleanCommonSwitch = z16;
        }
    }

    public final void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.cleanImageSwitch = z16;
        }
    }

    public final void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, z16);
        } else {
            this.fixView = z16;
        }
    }

    public final void O(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
        } else {
            this.imageMaxSizeRatio = f16;
        }
    }

    public final void P(@NotNull Float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) fArr);
        } else {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.sysLowMemoryCleanRate = fArr;
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.allowSizeCalculator;
    }

    @NotNull
    public final Float[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Float[]) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.appLowMemoryCleanRate;
    }

    public final float e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        return this.backgroundCleanRate;
    }

    public final float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Float) iPatchRedirector.redirect((short) 33, (Object) this)).floatValue();
        }
        return this.businessCacheSizeWeight;
    }

    public final float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Float) iPatchRedirector.redirect((short) 29, (Object) this)).floatValue();
        }
        return this.businessUseFrequencyWeight;
    }

    public final float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Float) iPatchRedirector.redirect((short) 31, (Object) this)).floatValue();
        }
        return this.businessUseTimeWeight;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.checkNative;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this)).intValue();
        }
        return this.classComputerMaxTime;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.cleanCommonSwitch;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.cleanImageSwitch;
    }

    public final float m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        return this.commonCacheMaxSizeRatio;
    }

    public final float n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Float) iPatchRedirector.redirect((short) 55, (Object) this)).floatValue();
        }
        return this.dalvikMemoryCeilRate;
    }

    public final float o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Float) iPatchRedirector.redirect((short) 57, (Object) this)).floatValue();
        }
        return this.dalvikMemoryCleanRate;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return this.delayCalculatorFromInit;
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Boolean) iPatchRedirector.redirect((short) 65, (Object) this)).booleanValue();
        }
        return this.fixView;
    }

    @NotNull
    public final String[] r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.fixedCacheInfo;
    }

    public final float s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Float) iPatchRedirector.redirect((short) 63, (Object) this)).floatValue();
        }
        return this.hitSampling;
    }

    public final float t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this)).floatValue();
        }
        return this.imageCacheRatioBelowAndroid8;
    }

    @NotNull
    public String toString() {
        String joinToString$default;
        String joinToString$default2;
        String joinToString$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (String) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("CacheConfig(cleanImage=");
        a16.append(this.cleanImageSwitch);
        a16.append(", ");
        a16.append("cleanCollection=");
        a16.append(this.cleanCommonSwitch);
        a16.append(", ");
        a16.append("allowCalculator=");
        a16.append(this.allowSizeCalculator);
        a16.append(", ");
        a16.append("useBitmapPool=");
        a16.append(this.useBitmapPool);
        a16.append(", ");
        a16.append("useRfw=");
        a16.append(this.useRfwMonitor);
        a16.append(", ");
        a16.append("checkNative=");
        a16.append(this.checkNative);
        a16.append(", ");
        a16.append("sizeRatio=(");
        a16.append(this.imageMaxSizeRatio);
        a16.append(", ");
        a16.append(this.imagePoolMaxSizeRatio);
        a16.append(", ");
        a16.append(this.commonCacheMaxSizeRatio);
        a16.append("), ");
        a16.append("weight=(");
        a16.append(this.businessUseFrequencyWeight);
        a16.append(", ");
        a16.append(this.businessUseTimeWeight);
        a16.append(", ");
        a16.append(this.businessCacheSizeWeight);
        a16.append("), ");
        a16.append("appLowMemCleanRate=");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.appLowMemoryCleanRate, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CacheConfig$toString$1.INSTANCE, 31, (Object) null);
        StringBuilder a17 = com.tencent.cache.api.h.a(a16, joinToString$default, ", ", "sysLowMemCleanRate=");
        joinToString$default2 = ArraysKt___ArraysKt.joinToString$default(this.sysLowMemoryCleanRate, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CacheConfig$toString$2.INSTANCE, 31, (Object) null);
        StringBuilder a18 = com.tencent.cache.api.h.a(a17, joinToString$default2, ", ", "bgCleanRate=");
        a18.append(this.backgroundCleanRate);
        a18.append(", ");
        a18.append("ceilRate=(");
        a18.append(this.dalvikMemoryCeilRate);
        a18.append(", ");
        a18.append(this.dalvikMemoryCleanRate);
        a18.append(", ");
        a18.append(this.pssCeilThreshold);
        a18.append("), ");
        a18.append("trimInternal=(");
        a18.append(this.trimTimeInternalLowMemory);
        a18.append(", ");
        a18.append(this.trimTimeInternalBackground);
        a18.append("), ");
        a18.append("computerLimit=(");
        a18.append(this.classComputerMaxTime);
        a18.append(", ");
        a18.append(this.sameClassComputeMaxTimes);
        a18.append(", ");
        a18.append(this.singleClassMaxSize);
        a18.append(", ");
        a18.append(this.maxComputeDepth);
        a18.append(", ");
        a18.append(this.modifyCollectionCompute);
        a18.append("), ");
        a18.append("fixedInfo=");
        joinToString$default3 = ArraysKt___ArraysKt.joinToString$default(this.fixedCacheInfo, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CacheConfig$toString$3.INSTANCE, 31, (Object) null);
        StringBuilder a19 = com.tencent.cache.api.h.a(a18, joinToString$default3, ", ", "delayInit=");
        a19.append(this.delayCalculatorFromInit);
        a19.append(", ");
        a19.append("imageRatioBLO8=");
        a19.append(this.imageCacheRatioBelowAndroid8);
        a19.append(", ");
        a19.append("sampling=");
        a19.append(this.reportSamplingPercent);
        a19.append(", ");
        a19.append(this.hitSampling);
        a19.append(", ");
        a19.append("fixView=");
        a19.append(this.fixView);
        return a19.toString();
    }

    public final float u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Float) iPatchRedirector.redirect((short) 21, (Object) this)).floatValue();
        }
        return this.imageMaxSizeRatio;
    }

    public final float v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.imagePoolMaxSizeRatio;
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.logRemovedDetailInfo;
    }

    public final int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }
        return this.maxComputeDepth;
    }

    public final boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.modifyCollectionCompute;
    }

    public final int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }
        return this.pssCeilThreshold;
    }
}
