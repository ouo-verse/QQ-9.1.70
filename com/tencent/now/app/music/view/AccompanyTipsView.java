package com.tencent.now.app.music.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.app.music.view.AccompanyTipsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014B%\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0010\u0010\u0017J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/now/app/music/view/AccompanyTipsView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/tencent/component/core/thread/ThreadCenter$HandlerKeyable;", "", "notify", "", "isShowLong", "", "setNotify", NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "showRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-accompany-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AccompanyTipsView extends AppCompatTextView implements ThreadCenter.HandlerKeyable {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable showRunnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccompanyTipsView(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        this.showRunnable = new Runnable() { // from class: bm3.a
            @Override // java.lang.Runnable
            public final void run() {
                AccompanyTipsView.b(AccompanyTipsView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AccompanyTipsView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThreadCenter.removeUITask(this, this.showRunnable);
    }

    public final void setNotify(@NotNull String notify, boolean isShowLong) {
        Intrinsics.checkNotNullParameter(notify, "notify");
        setClickable(false);
        setVisibility(0);
        setText(notify);
        ThreadCenter.removeUITask(this, this.showRunnable);
        if (!isShowLong) {
            ThreadCenter.postDelayedUITask(this, this.showRunnable, 3000L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccompanyTipsView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        this.showRunnable = new Runnable() { // from class: bm3.a
            @Override // java.lang.Runnable
            public final void run() {
                AccompanyTipsView.b(AccompanyTipsView.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccompanyTipsView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
        this.showRunnable = new Runnable() { // from class: bm3.a
            @Override // java.lang.Runnable
            public final void run() {
                AccompanyTipsView.b(AccompanyTipsView.this);
            }
        };
    }
}
