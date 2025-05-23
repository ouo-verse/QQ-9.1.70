package com.tencent.mobileqq.troop.teamup.publish.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpPublishLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "d", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "()Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "c", "()Landroidx/recyclerview/widget/RecyclerView;", "mediaInputBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISecNavBar navBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISettingsRecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mediaInputBar;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpPublishLayout$a", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", "Landroidx/core/view/WindowInsetsAnimationCompat;", "runningAnimations", "onProgress", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends WindowInsetsAnimationCompat.Callback {
        static IPatchRedirector $redirector_;

        a() {
            super(0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpPublishLayout.this);
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WindowInsetsCompat) iPatchRedirector.redirect((short) 2, (Object) this, (Object) insets, (Object) runningAnimations);
            }
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            TroopTeamUpPublishLayout.this.c().setTranslationY(-insets.getInsets(WindowInsetsCompat.Type.ime()).bottom);
            return insets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopTeamUpPublishLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat b(TroopTeamUpPublishLayout this$0, View view, WindowInsetsCompat windowInsetsCompat) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.recyclerView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null && (i3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime() | WindowInsetsCompat.Type.navigationBars()).bottom) != marginLayoutParams.bottomMargin) {
            marginLayoutParams.bottomMargin = i3;
            this$0.recyclerView.setLayoutParams(marginLayoutParams);
        }
        RecyclerView recyclerView = this$0.mediaInputBar;
        Boolean valueOf = Boolean.valueOf(windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime()));
        recyclerView.setVisibility(0);
        if (((View) au.a(valueOf, recyclerView)) == null) {
            recyclerView.setVisibility(8);
        }
        this$0.mediaInputBar.setTranslationY(-windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom);
        return windowInsetsCompat;
    }

    @NotNull
    public final RecyclerView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mediaInputBar;
    }

    @NotNull
    public final QUISecNavBar d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QUISecNavBar) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.navBar;
    }

    @NotNull
    public final QUISettingsRecyclerView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.recyclerView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopTeamUpPublishLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopTeamUpPublishLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopTeamUpPublishLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null, 0, 6, null);
        qUISecNavBar.setId(View.generateViewId());
        qUISecNavBar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setCenterText(context.getString(R.string.f236427eb));
        qUISecNavBar.setLeftType(1);
        qUISecNavBar.setLeftText(context.getString(R.string.f236337e3));
        qUISecNavBar.setRightType(1);
        qUISecNavBar.setRightText(context.getString(R.string.f236417ea));
        addView(qUISecNavBar);
        this.navBar = qUISecNavBar;
        QUISettingsRecyclerView qUISettingsRecyclerView = new QUISettingsRecyclerView(context, null, 2, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, qUISecNavBar.getId());
        layoutParams.addRule(12);
        qUISettingsRecyclerView.setLayoutParams(layoutParams);
        addView(qUISettingsRecyclerView);
        this.recyclerView = qUISettingsRecyclerView;
        RecyclerView recyclerView = new RecyclerView(context);
        ViewUtils viewUtils = ViewUtils.f352270a;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, viewUtils.a(44.0f));
        layoutParams2.addRule(12);
        recyclerView.setLayoutParams(layoutParams2);
        recyclerView.setBackground(new ColorDrawable(recyclerView.getResources().getColor(R.color.qui_common_bg_top_light, null)));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.addItemDecoration(new com.tencent.mobileqq.troop.teamup.publish.view.a(viewUtils.a(4.0f), viewUtils.a(2.0f), 0, 4, null));
        recyclerView.setVisibility(8);
        addView(recyclerView);
        this.mediaInputBar = recyclerView;
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.view.b
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat b16;
                b16 = TroopTeamUpPublishLayout.b(TroopTeamUpPublishLayout.this, view, windowInsetsCompat);
                return b16;
            }
        });
        ViewCompat.setWindowInsetsAnimationCallback(this, new a());
    }
}
