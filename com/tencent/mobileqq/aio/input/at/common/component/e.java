package com.tencent.mobileqq.aio.input.at.common.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.common.MultiSelectCompleteEvent;
import com.tencent.mobileqq.aio.input.at.common.MultiSelectModeEvent;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.aio.input.at.common.component.a;
import com.tencent.mobileqq.aio.input.at.common.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001c*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u000bB\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/component/e;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Lcom/tencent/mobileqq/aio/input/at/common/component/a;", "", "g", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "e", "", "a", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "d", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mMultiSelectView", "", h.F, "Z", "mIsMultiSelectMode", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;)V", "i", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e<T extends com.tencent.mobileqq.aio.input.at.common.c> implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j<T> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mMultiSelectView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMultiSelectMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/component/e$a;", "", "", "HINT_HEIGHT", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.component.e$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull j<T> mDialogContext) {
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext);
        } else {
            this.mDialogContext = mDialogContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g() {
        boolean z16 = this.mIsMultiSelectMode;
        if (!z16) {
            boolean z17 = !z16;
            this.mIsMultiSelectMode = z17;
            this.mDialogContext.i(z17);
            TextView textView = this.mMultiSelectView;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiSelectView");
                textView = null;
            }
            textView.setText(this.mDialogContext.c().getString(R.string.f1623820_));
            if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                TextView textView3 = this.mMultiSelectView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMultiSelectView");
                    textView3 = null;
                }
                TextView textView4 = this.mMultiSelectView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMultiSelectView");
                } else {
                    textView2 = textView4;
                }
                AccessibilityUtil.p(textView3, textView2.getText());
            }
            SimpleEventBus.getInstance().dispatchEvent(new MultiSelectModeEvent(this.mIsMultiSelectMode));
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(MultiSelectCompleteEvent.INSTANCE);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return com.tencent.qqnt.util.view.b.f362999a.b(57);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            a.C7254a.c(this, z16);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            a.C7254a.a(this);
        }
    }

    @NotNull
    public View e(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.mDialogContext.c()).inflate(R.layout.fg7, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mDialogContext.getC\u2026er_layout, parent, false)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        inflate.getLayoutParams().height = a();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f2w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<T\u2026tView>(R.id.multi_select)");
        TextView textView = (TextView) findViewById;
        this.mMultiSelectView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiSelectView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.at.common.component.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.f(e.this, view2);
            }
        });
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            TextView textView2 = this.mMultiSelectView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiSelectView");
                textView2 = null;
            }
            TextView textView3 = this.mMultiSelectView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultiSelectView");
                textView3 = null;
            }
            AccessibilityUtil.p(textView2, textView3.getText());
        }
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return view2;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            a.C7254a.b(this);
        }
    }
}
