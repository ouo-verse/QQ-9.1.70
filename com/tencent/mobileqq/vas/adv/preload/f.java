package com.tencent.mobileqq.vas.adv.preload;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.vas.adv.base.service.VasGdtService;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/f;", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService;", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$b;", "c", "", "Ljava/lang/String;", "businessId", "", "d", "Ljava/util/List;", "posIdList", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f extends VasGdtService {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Map<String, qq_ad_get.QQAdGetRsp> f308165f = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String businessId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> posIdList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/adv/preload/f$a", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$a;", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "rsp", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements VasGdtService.a {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.adv.base.service.VasGdtService.a
        public void a(@Nullable qq_ad_get.QQAdGetRsp rsp) {
            f.f308165f.put(f.this.businessId, rsp);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/f$b;", "", "", "businessId", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "c", "a", "b", "", "preloadedAd", "Ljava/util/Map;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.preload.f$b, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final qq_ad_get.QQAdGetRsp a(@NotNull String businessId) {
            Intrinsics.checkNotNullParameter(businessId, "businessId");
            return (qq_ad_get.QQAdGetRsp) f.f308165f.get(businessId);
        }

        @JvmStatic
        @Nullable
        public final String b(@NotNull String businessId) {
            Object pbToJson;
            Intrinsics.checkNotNullParameter(businessId, "businessId");
            qq_ad_get.QQAdGetRsp a16 = a(businessId);
            if (a16 == null || (pbToJson = GdtJsonPbUtil.pbToJson(a16)) == null) {
                return null;
            }
            return pbToJson.toString();
        }

        @JvmStatic
        @Nullable
        public final qq_ad_get.QQAdGetRsp c(@NotNull String businessId) {
            Intrinsics.checkNotNullParameter(businessId, "businessId");
            return (qq_ad_get.QQAdGetRsp) f.f308165f.remove(businessId);
        }

        Companion() {
        }
    }

    public f(@NotNull String businessId, @NotNull List<String> posIdList) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(posIdList, "posIdList");
        this.businessId = businessId;
        this.posIdList = posIdList;
        h(new a());
    }

    @Override // com.tencent.mobileqq.vas.adv.base.service.VasGdtService
    @NotNull
    protected VasGdtService.GdtParams c() {
        Set set;
        long i3 = VasAdvSupport.INSTANCE.a().i();
        set = CollectionsKt___CollectionsKt.toSet(this.posIdList);
        return new VasGdtService.GdtParams(i3, set, 0, 0, null, null, null, null, null, null, null, 2044, null);
    }
}
