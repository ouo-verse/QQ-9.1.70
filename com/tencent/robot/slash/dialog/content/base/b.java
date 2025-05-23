package com.tencent.robot.slash.dialog.content.base;

import com.tencent.mvi.api.ability.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/b;", "Lcom/tencent/mvi/api/ability/d;", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/robot/slash/dialog/content/base/b$b;", "Lcom/tencent/robot/slash/dialog/content/base/b$c;", "Lcom/tencent/robot/slash/dialog/content/base/b$d;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b implements d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/b$b;", "Lcom/tencent/robot/slash/dialog/content/base/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "c", "()Z", "isHalfMode", "I", "a", "()I", "accumulatedValue", "d", "totalAvailableHint", "<init>", "(ZII)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.slash.dialog.content.base.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class FetchHeight extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isHalfMode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int accumulatedValue;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int totalAvailableHint;

        public FetchHeight(boolean z16, int i3, int i16) {
            super(null);
            this.isHalfMode = z16;
            this.accumulatedValue = i3;
            this.totalAvailableHint = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getAccumulatedValue() {
            return this.accumulatedValue;
        }

        /* renamed from: b, reason: from getter */
        public final int getTotalAvailableHint() {
            return this.totalAvailableHint;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsHalfMode() {
            return this.isHalfMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FetchHeight)) {
                return false;
            }
            FetchHeight fetchHeight = (FetchHeight) other;
            if (this.isHalfMode == fetchHeight.isHalfMode && this.accumulatedValue == fetchHeight.accumulatedValue && this.totalAvailableHint == fetchHeight.totalAvailableHint) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isHalfMode;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.accumulatedValue) * 31) + this.totalAvailableHint;
        }

        @NotNull
        public String toString() {
            return "FetchHeight(isHalfMode=" + this.isHalfMode + ", accumulatedValue=" + this.accumulatedValue + ", totalAvailableHint=" + this.totalAvailableHint + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/b$c;", "Lcom/tencent/robot/slash/dialog/content/base/b;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends b {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f368466b = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/b$d;", "Lcom/tencent/robot/slash/dialog/content/base/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "c", "()Z", "isHalfMode", "I", "a", "()I", "accumulatedValue", "d", "totalAvailableHint", "<init>", "(ZII)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.slash.dialog.content.base.b$d, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class FetchVisualHeight extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isHalfMode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int accumulatedValue;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int totalAvailableHint;

        public FetchVisualHeight(boolean z16, int i3, int i16) {
            super(null);
            this.isHalfMode = z16;
            this.accumulatedValue = i3;
            this.totalAvailableHint = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getAccumulatedValue() {
            return this.accumulatedValue;
        }

        /* renamed from: b, reason: from getter */
        public final int getTotalAvailableHint() {
            return this.totalAvailableHint;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsHalfMode() {
            return this.isHalfMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FetchVisualHeight)) {
                return false;
            }
            FetchVisualHeight fetchVisualHeight = (FetchVisualHeight) other;
            if (this.isHalfMode == fetchVisualHeight.isHalfMode && this.accumulatedValue == fetchVisualHeight.accumulatedValue && this.totalAvailableHint == fetchVisualHeight.totalAvailableHint) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isHalfMode;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.accumulatedValue) * 31) + this.totalAvailableHint;
        }

        @NotNull
        public String toString() {
            return "FetchVisualHeight(isHalfMode=" + this.isHalfMode + ", accumulatedValue=" + this.accumulatedValue + ", totalAvailableHint=" + this.totalAvailableHint + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
