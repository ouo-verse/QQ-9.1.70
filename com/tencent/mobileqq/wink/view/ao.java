package com.tencent.mobileqq.wink.view;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/view/ao;", "", "", "key", "", "e", "", "f", "Landroid/view/View;", "anchorView", "g", "Lcom/tencent/mobileqq/widget/tip/a;", "a", "Lcom/tencent/mobileqq/widget/tip/a;", "shareBubbleContainer", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "dismissAutoBubbleViewRunnable", "<init>", "()V", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.tip.a shareBubbleContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable dismissAutoBubbleViewRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.view.an
        @Override // java.lang.Runnable
        public final void run() {
            ao.d(ao.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ao this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.widget.tip.a aVar = this$0.shareBubbleContainer;
        if (aVar != null) {
            aVar.o();
        }
    }

    private final boolean e(String key) {
        return com.tencent.mobileqq.wink.utils.ar.f326685a.c(key, false);
    }

    private final void f(String key) {
        com.tencent.mobileqq.wink.utils.ar.f326685a.m(key, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ao this$0, View anchorView, String key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
        Intrinsics.checkNotNullParameter(key, "$key");
        com.tencent.mobileqq.widget.tip.a aVar = this$0.shareBubbleContainer;
        if (aVar != null) {
            aVar.o0(anchorView.getContext().getString(R.string.f240917qg));
        }
        com.tencent.mobileqq.widget.tip.a aVar2 = this$0.shareBubbleContainer;
        if (aVar2 != null) {
            aVar2.S(anchorView);
        }
        com.tencent.mobileqq.widget.tip.a aVar3 = this$0.shareBubbleContainer;
        if (aVar3 != null) {
            aVar3.R(2);
        }
        com.tencent.mobileqq.widget.tip.a aVar4 = this$0.shareBubbleContainer;
        if (aVar4 != null) {
            aVar4.k0(0);
        }
        com.tencent.mobileqq.widget.tip.a aVar5 = this$0.shareBubbleContainer;
        if (aVar5 != null) {
            aVar5.m0(3);
        }
        com.tencent.mobileqq.widget.tip.a aVar6 = this$0.shareBubbleContainer;
        if (aVar6 != null) {
            aVar6.s0();
        }
        ThreadManager.getUIHandler().postDelayed(this$0.dismissAutoBubbleViewRunnable, 3000L);
        com.tencent.mobileqq.widget.tip.a aVar7 = this$0.shareBubbleContainer;
        if (aVar7 != null) {
            aVar7.f(new b());
        }
        this$0.f(key);
    }

    public final void g(@NotNull final View anchorView, @NotNull final String key) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(key, "key");
        if (e(key)) {
            w53.b.f("WinkShowShareBubbleWindow", "showAutoBubble return");
            return;
        }
        com.tencent.mobileqq.widget.tip.a aVar = this.shareBubbleContainer;
        boolean z16 = false;
        if (aVar != null && aVar.L()) {
            z16 = true;
        }
        if (z16) {
            w53.b.f("WinkShowShareBubbleWindow", "showAutoBubble isShowing  return");
            return;
        }
        w53.b.f("WinkShowShareBubbleWindow", "showAutoBubble key = " + key);
        if (this.shareBubbleContainer == null) {
            this.shareBubbleContainer = QUIDefaultBubbleTip.r(anchorView.getContext());
        }
        anchorView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.am
            @Override // java.lang.Runnable
            public final void run() {
                ao.h(ao.this, anchorView, key);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/view/ao$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            ThreadManager.getUIHandler().removeCallbacks(ao.this.dismissAutoBubbleViewRunnable);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
        }
    }
}
