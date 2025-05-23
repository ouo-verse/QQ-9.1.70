package com.tencent.robot.aio.input.inputbar.blur;

import android.view.View;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/blur/RobotInputBlurUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "UpdateBlurState", "Lcom/tencent/robot/aio/input/inputbar/blur/RobotInputBlurUIState$UpdateBlurState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotInputBlurUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/blur/RobotInputBlurUIState$UpdateBlurState;", "Lcom/tencent/robot/aio/input/inputbar/blur/RobotInputBlurUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "c", "()Z", "show", "Landroid/view/View;", "e", "Landroid/view/View;", "b", "()Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "bgList", "<init>", "(ZLandroid/view/View;Ljava/util/ArrayList;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateBlurState extends RobotInputBlurUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final View bgView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ArrayList<Object> bgList;

        public /* synthetic */ UpdateBlurState(boolean z16, View view, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? null : view, (i3 & 4) != 0 ? null : arrayList);
        }

        @Nullable
        public final ArrayList<Object> a() {
            return this.bgList;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final View getBgView() {
            return this.bgView;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateBlurState)) {
                return false;
            }
            UpdateBlurState updateBlurState = (UpdateBlurState) other;
            if (this.show == updateBlurState.show && Intrinsics.areEqual(this.bgView, updateBlurState.bgView) && Intrinsics.areEqual(this.bgList, updateBlurState.bgList)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.show;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            View view = this.bgView;
            int i16 = 0;
            if (view == null) {
                hashCode = 0;
            } else {
                hashCode = view.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            ArrayList<Object> arrayList = this.bgList;
            if (arrayList != null) {
                i16 = arrayList.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "UpdateBlurState(show=" + this.show + ", bgView=" + this.bgView + ", bgList=" + this.bgList + ")";
        }

        public UpdateBlurState(boolean z16, @Nullable View view, @Nullable ArrayList<Object> arrayList) {
            super(null);
            this.show = z16;
            this.bgView = view;
            this.bgList = arrayList;
        }
    }

    public /* synthetic */ RobotInputBlurUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotInputBlurUIState() {
    }
}
