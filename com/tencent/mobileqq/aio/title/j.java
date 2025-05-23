package com.tencent.mobileqq.aio.title;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/title/j;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/n;", "Lcom/tencent/mobileqq/aio/title/AIOTitleUIState;", "", "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "f1", "Lw71/i;", "d", "Lw71/i;", "mTitleBinding", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j extends com.tencent.aio.base.mvvm.a<n, AIOTitleUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w71.i mTitleBinding;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void g1() {
        final w71.i iVar = this.mTitleBinding;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            iVar = null;
        }
        int i3 = 0;
        n.f fVar = new n.f(false, false, 3, null);
        sendIntent(fVar);
        if (fVar.a()) {
            iVar.f444817g.setBackgroundColor(iVar.getRoot().getResources().getColor(R.color.qui_common_bg_top_dark));
            iVar.f444816f.setBackgroundResource(R.drawable.qui_chevron_left_icon_allwhite_primary);
            iVar.f444814d.setTextColor(iVar.getRoot().getContext().getColor(R.color.qui_common_text_allwhite_primary));
            iVar.f444813c.setTextColor(iVar.getRoot().getContext().getColor(R.color.qui_common_text_allwhite_secondary));
            iVar.f444812b.setTextColor(iVar.getRoot().getContext().getColor(R.color.qui_common_text_allwhite_primary));
        } else if (QQTheme.isSimpleWhite() && com.tencent.mobileqq.utils.r.a()) {
            iVar.f444817g.setBackgroundResource(R.drawable.f162589ob3);
        } else {
            iVar.f444817g.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        }
        iVar.f444816f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.h1(j.this, view);
            }
        });
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if (bVar.enableTalkBack()) {
            TextView shotTitleBtnLeft = iVar.f444816f;
            Intrinsics.checkNotNullExpressionValue(shotTitleBtnLeft, "shotTitleBtnLeft");
            new AIOMsgShotTitleLeftBtnTalkbackHelper(shotTitleBtnLeft).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.i1(w71.i.this, view);
                }
            });
        }
        iVar.f444812b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.j1(j.this, view);
            }
        });
        if (bVar.enableTalkBack()) {
            TextView textView = iVar.f444812b;
            AccessibilityUtil.p(textView, textView.getText());
        }
        iVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.k1(view);
            }
        });
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(getMContext());
        }
        if (!fVar.b()) {
            LinearLayout linearLayout = iVar.f444817g;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), i3, linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.C7362n.f193987d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(w71.i this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.f444816f.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.l.f193985d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.bindViewAndData();
            g1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<n, AIOTitleUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new k();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        w71.i g16 = w71.i.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mTitleBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        return root;
    }
}
