package com.tencent.mobileqq.aio.title;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIOMsgShotTitleLeftBtnTalkbackHelper;", "", "Landroid/view/View$OnClickListener;", "listener", "", tl.h.F, "Landroid/view/View;", "a", "Landroid/view/View;", "leftBtn", "b", "Landroid/view/View$OnClickListener;", "onClickListener", "c", "Lkotlin/Lazy;", "f", "()Landroid/view/View;", "talkbackView", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgShotTitleLeftBtnTalkbackHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View leftBtn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onClickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy talkbackView;

    public AIOMsgShotTitleLeftBtnTalkbackHelper(@NotNull View leftBtn) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(leftBtn, "leftBtn");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) leftBtn);
            return;
        }
        this.leftBtn = leftBtn;
        lazy = LazyKt__LazyJVMKt.lazy(new AIOMsgShotTitleLeftBtnTalkbackHelper$talkbackView$2(this));
        this.talkbackView = lazy;
        leftBtn.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.title.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                AIOMsgShotTitleLeftBtnTalkbackHelper.c(AIOMsgShotTitleLeftBtnTalkbackHelper.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AIOMsgShotTitleLeftBtnTalkbackHelper this$0, View view, final int i3, final int i16, final int i17, final int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final View f16 = this$0.f();
        f16.post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.d
            @Override // java.lang.Runnable
            public final void run() {
                AIOMsgShotTitleLeftBtnTalkbackHelper.g(i17, i3, i18, i16, f16);
            }
        });
    }

    private final View f() {
        return (View) this.talkbackView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, int i16, int i17, int i18, View this_run) {
        int coerceAtLeast;
        int coerceAtLeast2;
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((com.tencent.qqnt.aio.utils.l.b(48) - (i3 - i16)) / 2, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((com.tencent.qqnt.aio.utils.l.b(48) - (i17 - i18)) / 2, 0);
        this_run.layout(i16 - coerceAtLeast, i18 - coerceAtLeast2, i3 + coerceAtLeast, i17 + coerceAtLeast2);
    }

    public final void h(@NotNull View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onClickListener = listener;
        }
    }
}
