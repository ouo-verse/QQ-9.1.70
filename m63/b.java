package m63;

import androidx.annotation.ColorInt;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lm63/b;", "", "<init>", "()V", "a", "b", "c", "d", "Lm63/b$a;", "Lm63/b$b;", "Lm63/b$c;", "Lm63/b$d;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lm63/b$a;", "Lm63/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "", "b", "J", "getStartUs", "()J", "startUs", "c", "getEndUs", "endUs", "d", "I", "getColor", "()I", "color", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "e", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "getAppliedEffect", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "appliedEffect", "<init>", "(Ljava/lang/String;JJILcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m63.b$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Add extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startUs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long endUs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final EffectStatusManager.AppliedEffect appliedEffect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Add(@NotNull String id5, long j3, long j16, @ColorInt int i3, @NotNull EffectStatusManager.AppliedEffect appliedEffect) {
            super(null);
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(appliedEffect, "appliedEffect");
            this.id = id5;
            this.startUs = j3;
            this.endUs = j16;
            this.color = i3;
            this.appliedEffect = appliedEffect;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Add)) {
                return false;
            }
            Add add = (Add) other;
            if (Intrinsics.areEqual(this.id, add.id) && this.startUs == add.startUs && this.endUs == add.endUs && this.color == add.color && Intrinsics.areEqual(this.appliedEffect, add.appliedEffect)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + androidx.fragment.app.a.a(this.startUs)) * 31) + androidx.fragment.app.a.a(this.endUs)) * 31) + this.color) * 31) + this.appliedEffect.hashCode();
        }

        @NotNull
        public String toString() {
            return "Add(id=" + this.id + ", startUs=" + this.startUs + ", endUs=" + this.endUs + ", color=" + this.color + ", appliedEffect=" + this.appliedEffect + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lm63/b$b;", "Lm63/b;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m63.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C10768b extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C10768b f416299a = new C10768b();

        C10768b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lm63/b$c;", "Lm63/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "", "b", "J", "c", "()J", "startUs", "I", "()I", "color", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "d", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "appliedEffect", "<init>", "(Ljava/lang/String;JILcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m63.b$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Start extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startUs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final EffectStatusManager.AppliedEffect appliedEffect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(@NotNull String id5, long j3, @ColorInt int i3, @NotNull EffectStatusManager.AppliedEffect appliedEffect) {
            super(null);
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(appliedEffect, "appliedEffect");
            this.id = id5;
            this.startUs = j3;
            this.color = i3;
            this.appliedEffect = appliedEffect;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EffectStatusManager.AppliedEffect getAppliedEffect() {
            return this.appliedEffect;
        }

        /* renamed from: b, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: c, reason: from getter */
        public final long getStartUs() {
            return this.startUs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Start)) {
                return false;
            }
            Start start = (Start) other;
            if (Intrinsics.areEqual(this.id, start.id) && this.startUs == start.startUs && this.color == start.color && Intrinsics.areEqual(this.appliedEffect, start.appliedEffect)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + androidx.fragment.app.a.a(this.startUs)) * 31) + this.color) * 31) + this.appliedEffect.hashCode();
        }

        @NotNull
        public String toString() {
            return "Start(id=" + this.id + ", startUs=" + this.startUs + ", color=" + this.color + ", appliedEffect=" + this.appliedEffect + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lm63/b$d;", "Lm63/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "endUs", "<init>", "(J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m63.b$d, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Stop extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long endUs;

        public Stop(long j3) {
            super(null);
            this.endUs = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getEndUs() {
            return this.endUs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Stop) && this.endUs == ((Stop) other).endUs) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.endUs);
        }

        @NotNull
        public String toString() {
            return "Stop(endUs=" + this.endUs + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
