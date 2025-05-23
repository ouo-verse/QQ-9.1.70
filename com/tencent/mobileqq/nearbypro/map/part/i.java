package com.tencent.mobileqq.nearbypro.map.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/i;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Lcom/tencent/mobileqq/nearbypro/map/view/NearbyProMapView;", "F9", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "E9", "", "action", "", "args", "getMessage", "<init>", "()V", "f", "a", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class i extends com.tencent.mobileqq.nearbypro.part.e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/i$a;", "", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.map.part.i$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TencentMap a(@NotNull Part part) {
            Intrinsics.checkNotNullParameter(part, "<this>");
            Object broadcastGetMessage = part.broadcastGetMessage("GET_TENCENT_MAP", null);
            if (!(broadcastGetMessage instanceof TencentMap)) {
                return null;
            }
            return (TencentMap) broadcastGetMessage;
        }

        Companion() {
        }
    }

    @Nullable
    public abstract TencentMap E9();

    @Nullable
    public abstract NearbyProMapView F9();

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@NotNull String action, @Nullable Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual("GET_TENCENT_MAP", action)) {
            return E9();
        }
        if (Intrinsics.areEqual("GET_TENCENT_MAP_VIEW", action)) {
            return F9();
        }
        return super.getMessage(action, args);
    }
}
