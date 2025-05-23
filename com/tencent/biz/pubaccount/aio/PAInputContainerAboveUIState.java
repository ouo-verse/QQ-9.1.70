package com.tencent.biz.pubaccount.aio;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "AddAboveView", "RemoveAboveView", "UpdateAboveParentViewMargin", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public class PAInputContainerAboveUIState implements MviUIState {
    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState$AddAboveView;", "Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "b", "()Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "e", "Landroid/view/ViewGroup$LayoutParams;", "a", "()Landroid/view/ViewGroup$LayoutParams;", "params", "<init>", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final /* data */ class AddAboveView extends PAInputContainerAboveUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final View view;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final ViewGroup.LayoutParams params;

        public AddAboveView(View view, ViewGroup.LayoutParams params) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(params, "params");
            this.view = view;
            this.params = params;
        }

        /* renamed from: a, reason: from getter */
        public final ViewGroup.LayoutParams getParams() {
            return this.params;
        }

        /* renamed from: b, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public int hashCode() {
            return (this.view.hashCode() * 31) + this.params.hashCode();
        }

        public String toString() {
            return "AddAboveView(view=" + this.view + ", params=" + this.params + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddAboveView)) {
                return false;
            }
            AddAboveView addAboveView = (AddAboveView) other;
            return Intrinsics.areEqual(this.view, addAboveView.view) && Intrinsics.areEqual(this.params, addAboveView.params);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState$RemoveAboveView;", "Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final /* data */ class RemoveAboveView extends PAInputContainerAboveUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final View view;

        public RemoveAboveView(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        /* renamed from: a, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public int hashCode() {
            return this.view.hashCode();
        }

        public String toString() {
            return "RemoveAboveView(view=" + this.view + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RemoveAboveView) && Intrinsics.areEqual(this.view, ((RemoveAboveView) other).view);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState$UpdateAboveParentViewMargin;", "Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "leftMargin", "e", "topMargin", "f", "c", "rightMargin", tl.h.F, "a", "bottomMargin", "<init>", "(IIII)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final /* data */ class UpdateAboveParentViewMargin extends PAInputContainerAboveUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int leftMargin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int topMargin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int rightMargin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bottomMargin;

        public UpdateAboveParentViewMargin(int i3, int i16, int i17, int i18) {
            this.leftMargin = i3;
            this.topMargin = i16;
            this.rightMargin = i17;
            this.bottomMargin = i18;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottomMargin() {
            return this.bottomMargin;
        }

        /* renamed from: b, reason: from getter */
        public final int getLeftMargin() {
            return this.leftMargin;
        }

        /* renamed from: c, reason: from getter */
        public final int getRightMargin() {
            return this.rightMargin;
        }

        /* renamed from: d, reason: from getter */
        public final int getTopMargin() {
            return this.topMargin;
        }

        public int hashCode() {
            return (((((this.leftMargin * 31) + this.topMargin) * 31) + this.rightMargin) * 31) + this.bottomMargin;
        }

        public String toString() {
            return "UpdateAboveParentViewMargin(leftMargin=" + this.leftMargin + ", topMargin=" + this.topMargin + ", rightMargin=" + this.rightMargin + ", bottomMargin=" + this.bottomMargin + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateAboveParentViewMargin)) {
                return false;
            }
            UpdateAboveParentViewMargin updateAboveParentViewMargin = (UpdateAboveParentViewMargin) other;
            return this.leftMargin == updateAboveParentViewMargin.leftMargin && this.topMargin == updateAboveParentViewMargin.topMargin && this.rightMargin == updateAboveParentViewMargin.rightMargin && this.bottomMargin == updateAboveParentViewMargin.bottomMargin;
        }
    }
}
