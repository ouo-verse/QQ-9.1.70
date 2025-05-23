package e63;

import androidx.annotation.ColorInt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J1\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010 \u001a\u0004\b\u001a\u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b+\u0010\u0016R\u0011\u0010.\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b-\u0010'\u00a8\u00061"}, d2 = {"Le63/a;", "", "", "j", "", "startPositionMs", "stopPositionMs", "", "color", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "appliedEffect", "a", "", "toString", "hashCode", "other", "", "equals", "J", "g", "()J", "o", "(J)V", "b", h.F, "p", "c", "I", "d", "()I", "l", "(I)V", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "k", "(Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;)V", "e", "Z", "f", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "selected", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "realTimeOffset", "i", "valid", "<init>", "(JJILcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e63.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class EffectMaskLocation {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long startPositionMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long stopPositionMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int color;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private EffectStatusManager.AppliedEffect appliedEffect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long realTimeOffset;

    public EffectMaskLocation(long j3, long j16, @ColorInt int i3, @NotNull EffectStatusManager.AppliedEffect appliedEffect) {
        Intrinsics.checkNotNullParameter(appliedEffect, "appliedEffect");
        this.startPositionMs = j3;
        this.stopPositionMs = j16;
        this.color = i3;
        this.appliedEffect = appliedEffect;
    }

    public static /* synthetic */ EffectMaskLocation b(EffectMaskLocation effectMaskLocation, long j3, long j16, int i3, EffectStatusManager.AppliedEffect appliedEffect, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = effectMaskLocation.startPositionMs;
        }
        long j17 = j3;
        if ((i16 & 2) != 0) {
            j16 = effectMaskLocation.stopPositionMs;
        }
        long j18 = j16;
        if ((i16 & 4) != 0) {
            i3 = effectMaskLocation.color;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            appliedEffect = effectMaskLocation.appliedEffect;
        }
        return effectMaskLocation.a(j17, j18, i17, appliedEffect);
    }

    @NotNull
    public final EffectMaskLocation a(long startPositionMs, long stopPositionMs, @ColorInt int color, @NotNull EffectStatusManager.AppliedEffect appliedEffect) {
        Intrinsics.checkNotNullParameter(appliedEffect, "appliedEffect");
        return new EffectMaskLocation(startPositionMs, stopPositionMs, color, appliedEffect);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final EffectStatusManager.AppliedEffect getAppliedEffect() {
        return this.appliedEffect;
    }

    /* renamed from: d, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: e, reason: from getter */
    public final long getRealTimeOffset() {
        return this.realTimeOffset;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EffectMaskLocation)) {
            return false;
        }
        EffectMaskLocation effectMaskLocation = (EffectMaskLocation) other;
        if (this.startPositionMs == effectMaskLocation.startPositionMs && this.stopPositionMs == effectMaskLocation.stopPositionMs && this.color == effectMaskLocation.color && Intrinsics.areEqual(this.appliedEffect, effectMaskLocation.appliedEffect)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: g, reason: from getter */
    public final long getStartPositionMs() {
        return this.startPositionMs;
    }

    /* renamed from: h, reason: from getter */
    public final long getStopPositionMs() {
        return this.stopPositionMs;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.startPositionMs) * 31) + androidx.fragment.app.a.a(this.stopPositionMs)) * 31) + this.color) * 31) + this.appliedEffect.hashCode();
    }

    public final boolean i() {
        long j3 = this.startPositionMs;
        if (j3 >= 0) {
            long j16 = this.stopPositionMs;
            if (j16 >= 0 && j3 <= j16) {
                return true;
            }
        }
        return false;
    }

    public final void j() {
        this.startPositionMs = -1L;
        this.stopPositionMs = -1L;
    }

    public final void k(@NotNull EffectStatusManager.AppliedEffect appliedEffect) {
        Intrinsics.checkNotNullParameter(appliedEffect, "<set-?>");
        this.appliedEffect = appliedEffect;
    }

    public final void l(int i3) {
        this.color = i3;
    }

    public final void m(long j3) {
        this.realTimeOffset = j3;
    }

    public final void n(boolean z16) {
        this.selected = z16;
    }

    public final void o(long j3) {
        this.startPositionMs = j3;
    }

    public final void p(long j3) {
        this.stopPositionMs = j3;
    }

    @NotNull
    public String toString() {
        return "EffectMaskLocation(startPositionMs=" + this.startPositionMs + ", stopPositionMs=" + this.stopPositionMs + ", color=" + this.color + ", appliedEffect=" + this.appliedEffect + ")";
    }
}
