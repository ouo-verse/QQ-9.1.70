package com.tencent.mobileqq.ad.cardad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdVideoViewContainer;", "Landroid/widget/FrameLayout;", "", "requestLayout", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "measureAndLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CardAdVideoViewContainer extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable measureAndLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdVideoViewContainer(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attrs);
        } else {
            this.measureAndLayout = new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.e
                @Override // java.lang.Runnable
                public final void run() {
                    CardAdVideoViewContainer.b(CardAdVideoViewContainer.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CardAdVideoViewContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.measure(View.MeasureSpec.makeMeasureSpec(this$0.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this$0.getHeight(), 1073741824));
        this$0.layout(this$0.getLeft(), this$0.getTop(), this$0.getRight(), this$0.getBottom());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.requestLayout();
            post(this.measureAndLayout);
        }
    }
}
