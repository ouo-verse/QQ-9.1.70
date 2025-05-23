package com.tencent.sqshow.zootopia.operation;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.sqshow.utils.featureswitch.model.MaxSilverConfig;
import com.tencent.sqshow.utils.featureswitch.model.MinSilverConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/b;", "", "", "f", "c", "b", "d", "a", "toString", "", "hashCode", "other", "", "equals", "I", "e", "()I", "silver", "Lcom/tencent/sqshow/zootopia/operation/SilverGuideType;", "Lcom/tencent/sqshow/zootopia/operation/SilverGuideType;", "getType", "()Lcom/tencent/sqshow/zootopia/operation/SilverGuideType;", "type", "Lcom/tencent/sqshow/utils/featureswitch/model/e;", "Lcom/tencent/sqshow/utils/featureswitch/model/e;", "getMinSilverConfig", "()Lcom/tencent/sqshow/utils/featureswitch/model/e;", "minSilverConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/d;", "Lcom/tencent/sqshow/utils/featureswitch/model/d;", "getMaxSilverConfig", "()Lcom/tencent/sqshow/utils/featureswitch/model/d;", "maxSilverConfig", "<init>", "(ILcom/tencent/sqshow/zootopia/operation/SilverGuideType;Lcom/tencent/sqshow/utils/featureswitch/model/e;Lcom/tencent/sqshow/utils/featureswitch/model/d;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.operation.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class SilverDialogParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int silver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final SilverGuideType type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final MinSilverConfig minSilverConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final MaxSilverConfig maxSilverConfig;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.sqshow.zootopia.operation.b$a */
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372115a;

        static {
            int[] iArr = new int[SilverGuideType.values().length];
            try {
                iArr[SilverGuideType.TYPE_SILVER_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SilverGuideType.TYPE_SILVER_SUFFICIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f372115a = iArr;
        }
    }

    public SilverDialogParams() {
        this(0, null, null, null, 15, null);
    }

    public final String a() {
        MaxSilverConfig maxSilverConfig;
        int i3 = a.f372115a[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (maxSilverConfig = this.maxSilverConfig) != null) {
                return maxSilverConfig.getSchemeUrl();
            }
            return null;
        }
        MinSilverConfig minSilverConfig = this.minSilverConfig;
        if (minSilverConfig != null) {
            return minSilverConfig.getSchemeUrl();
        }
        return null;
    }

    public final String b() {
        MaxSilverConfig maxSilverConfig;
        int i3 = a.f372115a[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (maxSilverConfig = this.maxSilverConfig) != null) {
                return maxSilverConfig.getButtonTitle();
            }
            return null;
        }
        MinSilverConfig minSilverConfig = this.minSilverConfig;
        if (minSilverConfig != null) {
            return minSilverConfig.getButtonTitle();
        }
        return null;
    }

    public final String c() {
        MaxSilverConfig maxSilverConfig;
        int i3 = a.f372115a[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (maxSilverConfig = this.maxSilverConfig) != null) {
                return maxSilverConfig.getEndTipText();
            }
            return null;
        }
        MinSilverConfig minSilverConfig = this.minSilverConfig;
        if (minSilverConfig != null) {
            return minSilverConfig.getEndTipText();
        }
        return null;
    }

    public final String d() {
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        IZPlanApi iZPlanApi = (IZPlanApi) api;
        int zPlanGenderWithUin = iZPlanApi.getZPlanGenderWithUin(String.valueOf(iZPlanApi.getCurrentUin()));
        int i3 = a.f372115a[this.type.ordinal()];
        if (i3 == 1) {
            if (zPlanGenderWithUin == 1) {
                MinSilverConfig minSilverConfig = this.minSilverConfig;
                if (minSilverConfig != null) {
                    return minSilverConfig.getMaleUrl();
                }
                return null;
            }
            MinSilverConfig minSilverConfig2 = this.minSilverConfig;
            if (minSilverConfig2 != null) {
                return minSilverConfig2.getFemaleUrl();
            }
            return null;
        }
        if (i3 != 2) {
            return null;
        }
        if (zPlanGenderWithUin == 1) {
            MaxSilverConfig maxSilverConfig = this.maxSilverConfig;
            if (maxSilverConfig != null) {
                return maxSilverConfig.getMaleUrl();
            }
            return null;
        }
        MaxSilverConfig maxSilverConfig2 = this.maxSilverConfig;
        if (maxSilverConfig2 != null) {
            return maxSilverConfig2.getFemaleUrl();
        }
        return null;
    }

    /* renamed from: e, reason: from getter */
    public final int getSilver() {
        return this.silver;
    }

    public final String f() {
        MaxSilverConfig maxSilverConfig;
        int i3 = a.f372115a[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (maxSilverConfig = this.maxSilverConfig) != null) {
                return maxSilverConfig.getStartTipText();
            }
            return null;
        }
        MinSilverConfig minSilverConfig = this.minSilverConfig;
        if (minSilverConfig != null) {
            return minSilverConfig.getStartTipText();
        }
        return null;
    }

    public int hashCode() {
        int hashCode = ((this.silver * 31) + this.type.hashCode()) * 31;
        MinSilverConfig minSilverConfig = this.minSilverConfig;
        int hashCode2 = (hashCode + (minSilverConfig == null ? 0 : minSilverConfig.hashCode())) * 31;
        MaxSilverConfig maxSilverConfig = this.maxSilverConfig;
        return hashCode2 + (maxSilverConfig != null ? maxSilverConfig.hashCode() : 0);
    }

    public String toString() {
        return "SilverDialogParams(silver=" + this.silver + ", type=" + this.type + ", minSilverConfig=" + this.minSilverConfig + ", maxSilverConfig=" + this.maxSilverConfig + ")";
    }

    public SilverDialogParams(int i3, SilverGuideType type, MinSilverConfig minSilverConfig, MaxSilverConfig maxSilverConfig) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.silver = i3;
        this.type = type;
        this.minSilverConfig = minSilverConfig;
        this.maxSilverConfig = maxSilverConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SilverDialogParams)) {
            return false;
        }
        SilverDialogParams silverDialogParams = (SilverDialogParams) other;
        return this.silver == silverDialogParams.silver && this.type == silverDialogParams.type && Intrinsics.areEqual(this.minSilverConfig, silverDialogParams.minSilverConfig) && Intrinsics.areEqual(this.maxSilverConfig, silverDialogParams.maxSilverConfig);
    }

    public /* synthetic */ SilverDialogParams(int i3, SilverGuideType silverGuideType, MinSilverConfig minSilverConfig, MaxSilverConfig maxSilverConfig, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? SilverGuideType.TYPE_NO_NEED : silverGuideType, (i16 & 4) != 0 ? null : minSilverConfig, (i16 & 8) != 0 ? null : maxSilverConfig);
    }
}
