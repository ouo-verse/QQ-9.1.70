package com.tenpay.stackview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/stackview/QWalletStackViewContainer;", "Landroid/widget/FrameLayout;", "Lcom/tenpay/stackview/IStackViewInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fragment", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "viewStack", "Ljava/util/Stack;", "Lcom/tenpay/stackview/QWalletStackViewContainer$StackChild;", "count", "finishAll", "", "init", "pop", "", "push", "tag", "view", "Landroid/view/View;", "StackChild", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QWalletStackViewContainer extends FrameLayout implements IStackViewInterface {
    private QWalletBaseFragment fragment;

    @NotNull
    private final Stack<StackChild> viewStack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tenpay/stackview/QWalletStackViewContainer$StackChild;", "", "tag", "", "view", "Landroid/view/View;", "(Ljava/lang/String;Landroid/view/View;)V", "getTag", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class StackChild {

        @NotNull
        private final String tag;

        @NotNull
        private final View view;

        public StackChild(@NotNull String tag, @NotNull View view) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(view, "view");
            this.tag = tag;
            this.view = view;
        }

        public static /* synthetic */ StackChild copy$default(StackChild stackChild, String str, View view, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = stackChild.tag;
            }
            if ((i3 & 2) != 0) {
                view = stackChild.view;
            }
            return stackChild.copy(str, view);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final View getView() {
            return this.view;
        }

        @NotNull
        public final StackChild copy(@NotNull String tag, @NotNull View view) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(view, "view");
            return new StackChild(tag, view);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StackChild)) {
                return false;
            }
            StackChild stackChild = (StackChild) other;
            if (Intrinsics.areEqual(this.tag, stackChild.tag) && Intrinsics.areEqual(this.view, stackChild.view)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @NotNull
        public final View getView() {
            return this.view;
        }

        public int hashCode() {
            return (this.tag.hashCode() * 31) + this.view.hashCode();
        }

        @NotNull
        public String toString() {
            return "StackChild(tag=" + this.tag + ", view=" + this.view + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletStackViewContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewStack = new Stack<>();
    }

    @Override // com.tenpay.stackview.IStackViewInterface
    public int count() {
        return this.viewStack.size();
    }

    @Override // com.tenpay.stackview.IStackViewInterface
    public void finishAll() {
        QWalletBaseFragment qWalletBaseFragment = this.fragment;
        if (qWalletBaseFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            qWalletBaseFragment = null;
        }
        qWalletBaseFragment.finish();
    }

    public final void init(@NotNull QWalletBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    @Override // com.tenpay.stackview.IStackViewInterface
    @Nullable
    public String pop() {
        if (!this.viewStack.isEmpty()) {
            StackChild pop = this.viewStack.pop();
            pop.getView().startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154880eu));
            removeView(pop.getView());
        }
        if (!this.viewStack.isEmpty()) {
            StackChild peek = this.viewStack.peek();
            peek.getView().setVisibility(0);
            return peek.getTag();
        }
        finishAll();
        return null;
    }

    @Override // com.tenpay.stackview.IStackViewInterface
    public int push(@NotNull String tag, @NotNull View view) {
        View view2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!this.viewStack.isEmpty()) {
            StackChild peek = this.viewStack.peek();
            if (peek != null) {
                view2 = peek.getView();
            } else {
                view2 = null;
            }
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        this.viewStack.push(new StackChild(tag, view));
        addView(view);
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154877er));
        return count() - 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletStackViewContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewStack = new Stack<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletStackViewContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewStack = new Stack<>();
    }
}
