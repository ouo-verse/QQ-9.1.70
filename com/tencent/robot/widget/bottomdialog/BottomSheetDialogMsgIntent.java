package com.tencent.robot.widget.bottomdialog;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnDialogDismissed", "OnDialogShowed", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class BottomSheetDialogMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "getFlag", "()I", "flag", "Landroid/view/View;", "e", "Landroid/view/View;", "a", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(ILandroid/view/View;)V", "f", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnDialogDismissed extends BottomSheetDialogMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int flag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View rootView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnDialogDismissed(int i3, @NotNull View rootView) {
            super(null);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.flag = i3;
            this.rootView = rootView;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnDialogDismissed)) {
                return false;
            }
            OnDialogDismissed onDialogDismissed = (OnDialogDismissed) other;
            if (this.flag == onDialogDismissed.flag && Intrinsics.areEqual(this.rootView, onDialogDismissed.rootView)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.flag * 31) + this.rootView.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnDialogDismissed(flag=" + this.flag + ", rootView=" + this.rootView + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnDialogShowed extends BottomSheetDialogMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View rootView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnDialogShowed(@NotNull View rootView) {
            super(null);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = rootView;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnDialogShowed) && Intrinsics.areEqual(this.rootView, ((OnDialogShowed) other).rootView)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.rootView.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnDialogShowed(rootView=" + this.rootView + ")";
        }
    }

    public /* synthetic */ BottomSheetDialogMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    BottomSheetDialogMsgIntent() {
    }
}
