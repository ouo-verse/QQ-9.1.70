package com.tencent.mobileqq.aio.title.center;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/title/center/MainTitleTalkbackHelper;", "", "", "j", "", "enableTalkbackHelper", tl.h.F, "", "title", "i", "", "memberCount", "k", "Landroid/view/View;", "a", "Landroid/view/View;", "titleView", "b", "titleTailView", "c", "Ljava/lang/CharSequence;", "mMainTitle", "d", "I", "mMemberCount", "e", "Lkotlin/Lazy;", "f", "()Landroid/view/View;", "mMainTitleTalkbackView", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MainTitleTalkbackHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View titleView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View titleTailView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence mMainTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMemberCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMainTitleTalkbackView;

    public MainTitleTalkbackHelper(@NotNull View titleView, @NotNull View titleTailView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(titleView, "titleView");
        Intrinsics.checkNotNullParameter(titleTailView, "titleTailView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) titleView, (Object) titleTailView);
            return;
        }
        this.titleView = titleView;
        this.titleTailView = titleTailView;
        this.mMemberCount = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.title.center.MainTitleTalkbackHelper$mMainTitleTalkbackView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainTitleTalkbackHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view;
                View view2;
                View view3;
                View view4;
                View view5;
                View view6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                view = MainTitleTalkbackHelper.this.titleView;
                View view7 = new View(view.getContext());
                MainTitleTalkbackHelper mainTitleTalkbackHelper = MainTitleTalkbackHelper.this;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                view2 = mainTitleTalkbackHelper.titleView;
                layoutParams.addRule(5, view2.getId());
                view3 = mainTitleTalkbackHelper.titleView;
                layoutParams.addRule(6, view3.getId());
                view4 = mainTitleTalkbackHelper.titleView;
                layoutParams.addRule(8, view4.getId());
                view5 = mainTitleTalkbackHelper.titleTailView;
                layoutParams.addRule(7, view5.getId());
                view7.setLayoutParams(layoutParams);
                view7.setId(R.id.f98885oa);
                view6 = mainTitleTalkbackHelper.titleView;
                ViewParent parent = view6.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.addView(view7);
                }
                return view7;
            }
        });
        this.mMainTitleTalkbackView = lazy;
        titleView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.title.center.q
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                MainTitleTalkbackHelper.c(MainTitleTalkbackHelper.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MainTitleTalkbackHelper this$0, View view, final int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final View f16 = this$0.f();
        f16.post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.r
            @Override // java.lang.Runnable
            public final void run() {
                MainTitleTalkbackHelper.g(f16, i3);
            }
        });
    }

    private final View f() {
        return (View) this.mMainTitleTalkbackView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View this_run, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        int left = this_run.getLeft() - i3;
        this_run.layout(this_run.getLeft() - left, this_run.getTop(), this_run.getRight() - left, this_run.getBottom());
    }

    private final void h(boolean enableTalkbackHelper) {
        int i3;
        if (enableTalkbackHelper) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        ViewCompat.setImportantForAccessibility(this.titleView, i3);
        ViewCompat.setImportantForAccessibility(this.titleTailView, i3);
    }

    private final void j() {
        boolean z16;
        CharSequence charSequence;
        if (this.titleTailView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            CharSequence charSequence2 = this.mMainTitle;
            charSequence = ((Object) charSequence2) + "(" + this.mMemberCount + ")";
        } else {
            charSequence = this.mMainTitle;
        }
        View f16 = f();
        Boolean valueOf = Boolean.valueOf(z16);
        f16.setVisibility(0);
        if (((View) au.a(valueOf, f16)) == null) {
            f16.setVisibility(8);
        }
        f().setContentDescription(charSequence);
        h(z16);
    }

    public final void i(@NotNull CharSequence title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) title);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        this.mMainTitle = title;
        j();
    }

    public final void k(int memberCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, memberCount);
        } else {
            this.mMemberCount = memberCount;
            j();
        }
    }
}
