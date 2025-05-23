package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerViewData;
import com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnEmtity$TextDesc;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\tB=\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getFieldRes", "()Ljava/lang/String;", "fieldRes", "b", "getFlowerRes", "flowerRes", "c", "getMsgRes", "msgRes", "", "Lcom/tencent/filament/zplanservice/pbjava/wowoconn/WowoConnEmtity$TextDesc;", "d", "Ljava/util/List;", "getBubbles", "()Ljava/util/List;", "bubbles", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "e", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.g, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerViewData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String fieldRes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String flowerRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String msgRes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<WowoConnEmtity$TextDesc> bubbles;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/g$a;", "", "Lcom/tencent/filament/zplanservice/pbjava/huateng/HuatengSvr$FlowerViewData;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/g;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.g$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FlowerViewData a(@Nullable HuatengSvr$FlowerViewData rsp) {
            List list;
            if (rsp != null) {
                String str = rsp.field_res.get();
                String str2 = rsp.flower_res.get();
                String str3 = rsp.msg_res.get();
                List<WowoConnEmtity$TextDesc> list2 = rsp.bubbles.get();
                Intrinsics.checkNotNullExpressionValue(list2, "rsp.bubbles.get()");
                list = CollectionsKt___CollectionsKt.toList(list2);
                return new FlowerViewData(str, str2, str3, list);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerViewData() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerViewData) {
                FlowerViewData flowerViewData = (FlowerViewData) other;
                if (!Intrinsics.areEqual(this.fieldRes, flowerViewData.fieldRes) || !Intrinsics.areEqual(this.flowerRes, flowerViewData.flowerRes) || !Intrinsics.areEqual(this.msgRes, flowerViewData.msgRes) || !Intrinsics.areEqual(this.bubbles, flowerViewData.bubbles)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.fieldRes;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.flowerRes;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.msgRes;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        List<WowoConnEmtity$TextDesc> list = this.bubbles;
        if (list != null) {
            i18 = list.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "FlowerViewData(fieldRes=" + this.fieldRes + ", flowerRes=" + this.flowerRes + ", msgRes=" + this.msgRes + ", bubbles=" + this.bubbles + ")";
    }

    public FlowerViewData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<WowoConnEmtity$TextDesc> list) {
        this.fieldRes = str;
        this.flowerRes = str2;
        this.msgRes = str3;
        this.bubbles = list;
    }

    public /* synthetic */ FlowerViewData(String str, String str2, String str3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : list);
    }
}
