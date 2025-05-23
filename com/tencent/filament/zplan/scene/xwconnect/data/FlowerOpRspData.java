package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NativeDoFlowerOpRsp;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB5\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\t\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "opMsg", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "flowerData", "d", "getGifUrl", HippyTKDGifImageViewController.PROPS_GIFURL, "<init>", "(ZLjava/lang/String;Lcom/tencent/filament/zplan/scene/xwconnect/data/b;Ljava/lang/String;)V", "e", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FlowerOpRspData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String opMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FlowerData flowerData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String gifUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/c$a;", "", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/NativeDoFlowerOp$NativeDoFlowerOpRsp;", "rsp", "Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.data.c$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FlowerOpRspData a(@Nullable NativeDoFlowerOp$NativeDoFlowerOpRsp rsp) {
            boolean z16;
            if (rsp != null) {
                if (rsp.do_op_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return new FlowerOpRspData(z16, rsp.do_op_message.get(), FlowerData.INSTANCE.a(rsp.flower_data), rsp.gif_url.get());
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlowerOpRspData() {
        this(false, null, null, null, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final FlowerData getFlowerData() {
        return this.flowerData;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getOpMsg() {
        return this.opMsg;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FlowerOpRspData) {
                FlowerOpRspData flowerOpRspData = (FlowerOpRspData) other;
                if (this.result != flowerOpRspData.result || !Intrinsics.areEqual(this.opMsg, flowerOpRspData.opMsg) || !Intrinsics.areEqual(this.flowerData, flowerOpRspData.flowerData) || !Intrinsics.areEqual(this.gifUrl, flowerOpRspData.gifUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int i3;
        int i16;
        boolean z16 = this.result;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i17 = r06 * 31;
        String str = this.opMsg;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        FlowerData flowerData = this.flowerData;
        if (flowerData != null) {
            i16 = flowerData.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.gifUrl;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "FlowerOpRspData(result=" + this.result + ", opMsg=" + this.opMsg + ", flowerData=" + this.flowerData + ", gifUrl=" + this.gifUrl + ")";
    }

    public FlowerOpRspData(boolean z16, @Nullable String str, @Nullable FlowerData flowerData, @Nullable String str2) {
        this.result = z16;
        this.opMsg = str;
        this.flowerData = flowerData;
        this.gifUrl = str2;
    }

    public /* synthetic */ FlowerOpRspData(boolean z16, String str, FlowerData flowerData, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : flowerData, (i3 & 8) != 0 ? null : str2);
    }
}
