package com.tencent.mobileqq.vas.aio.animation;

import b8.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.aio.animation.VasWordsInterceptProcessor;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import u71.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/animation/VasWordsInterceptProcessor;", "Lu71/b;", "", "configVipType", "realVipType", "", "c", "id", "", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "vipType", "a", "<init>", "()V", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasWordsInterceptProcessor implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f308357b = VasNtToggle.VAS_COMMON_EGGS_CONTROLLER_CONFIG.isEnable(false);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Map<Integer, VipTypeData>> f308358c;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002R'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/animation/VasWordsInterceptProcessor$a;", "", "", "", "Lcom/tencent/mobileqq/vas/aio/animation/VasWordsInterceptProcessor$b;", "d", "config$delegate", "Lkotlin/Lazy;", "c", "()Ljava/util/Map;", DownloadInfo.spKey_Config, "BVIP", "I", "BVIP_YEAR", "DEFAULT_KING_ID", "SVIP", "SVIP_YEAR", "", "TAG", "Ljava/lang/String;", a.f28043VIP, "VIP_YEAR", "", "enableConfig", "Z", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.aio.animation.VasWordsInterceptProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Integer, VipTypeData> c() {
            return (Map) VasWordsInterceptProcessor.f308358c.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Integer, VipTypeData> d() {
            int i3;
            int i16;
            JSONObject json = VasNtToggle.VAS_COMMON_EGGS_CONTROLLER_CONFIG.getJson();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator keys = json.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "config.keys()");
            while (keys.hasNext()) {
                String it = (String) keys.next();
                JSONObject optJSONObject = json.optJSONObject(it);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Integer valueOf = Integer.valueOf(Integer.parseInt(it));
                int i17 = 0;
                if (optJSONObject != null) {
                    i3 = optJSONObject.optInt(AppConstants.VIPKey.KEY_FOR_VIP_TYPE);
                } else {
                    i3 = 0;
                }
                if (optJSONObject != null) {
                    i17 = optJSONObject.optInt("bit");
                }
                if (optJSONObject != null) {
                    i16 = optJSONObject.optInt("need_show");
                } else {
                    i16 = 1;
                }
                linkedHashMap.put(valueOf, new VipTypeData(i3, i17, i16));
            }
            return linkedHashMap;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/animation/VasWordsInterceptProcessor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "vipType", "b", "bit", "needShow", "<init>", "(III)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.aio.animation.VasWordsInterceptProcessor$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class VipTypeData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int vipType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bit;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int needShow;

        public VipTypeData() {
            this(0, 0, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getBit() {
            return this.bit;
        }

        /* renamed from: b, reason: from getter */
        public final int getNeedShow() {
            return this.needShow;
        }

        /* renamed from: c, reason: from getter */
        public final int getVipType() {
            return this.vipType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VipTypeData)) {
                return false;
            }
            VipTypeData vipTypeData = (VipTypeData) other;
            if (this.vipType == vipTypeData.vipType && this.bit == vipTypeData.bit && this.needShow == vipTypeData.needShow) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.vipType * 31) + this.bit) * 31) + this.needShow;
        }

        @NotNull
        public String toString() {
            return "VipTypeData(vipType=" + this.vipType + ", bit=" + this.bit + ", needShow=" + this.needShow + ")";
        }

        public VipTypeData(int i3, int i16, int i17) {
            this.vipType = i3;
            this.bit = i16;
            this.needShow = i17;
        }

        public /* synthetic */ VipTypeData(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? 1 : i17);
        }
    }

    static {
        Lazy<Map<Integer, VipTypeData>> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<Integer, VipTypeData>>() { // from class: com.tencent.mobileqq.vas.aio.animation.VasWordsInterceptProcessor$Companion$config$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Integer, VasWordsInterceptProcessor.VipTypeData> invoke() {
                Map<Integer, VasWordsInterceptProcessor.VipTypeData> d16;
                d16 = VasWordsInterceptProcessor.INSTANCE.d();
                return d16;
            }
        });
        f308358c = lazy;
    }

    private final boolean c(int configVipType, int realVipType) {
        if (configVipType != 1) {
            if (configVipType != 2) {
                if (configVipType != 3) {
                    return false;
                }
                if (realVipType != 3 && realVipType != 259) {
                    return false;
                }
                return true;
            }
            if (realVipType != 2 && realVipType != 3 && realVipType != 258 && realVipType != 259) {
                return false;
            }
            return true;
        }
        if (realVipType != 1 && realVipType != 2 && realVipType != 3 && realVipType != 257 && realVipType != 258 && realVipType != 259) {
            return false;
        }
        return true;
    }

    @Override // u71.b
    public boolean a(int id5, long senderUin, int vipType) {
        VipTypeData vipTypeData;
        if (f308357b && (vipTypeData = (VipTypeData) INSTANCE.c().get(Integer.valueOf(id5))) != null) {
            if (vipTypeData.getNeedShow() == 0) {
                return true;
            }
            VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(String.valueOf(senderUin));
            if (vipTypeData.getVipType() > 0 && vipTypeData.getBit() == 0) {
                if (c(vipTypeData.getVipType(), vipType)) {
                    return false;
                }
                return true;
            }
            if (vipTypeData.getVipType() == 0 && vipTypeData.getBit() > 0 && vipTypeData.getBit() <= 64) {
                if ((vipDataForFriends.getKingVipType() & (1 << (vipTypeData.getBit() - 1))) == 1) {
                    return false;
                }
                return true;
            }
            if (vipTypeData.getVipType() > 0 && vipTypeData.getBit() > 0 && vipTypeData.getBit() <= 64) {
                if (c(vipTypeData.getVipType(), vipType) && (vipDataForFriends.getKingVipType() & (1 << (vipTypeData.getBit() - 1))) == 1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
