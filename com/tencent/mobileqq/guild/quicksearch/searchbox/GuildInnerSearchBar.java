package com.tencent.mobileqq.guild.quicksearch.searchbox;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002;<B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u0002H\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar;", "Landroid/widget/FrameLayout;", "", "l", "p", "r", "", "marginLeftDp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$b;", "searchBarListener", "setSearchBarListener", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "extData", "setExtInfo", "", "show", "setKeyboardVisible", NodeProps.VISIBLE, "doAnimate", "setBackVisible", NodeProps.ON_DETACHED_FROM_WINDOW, "", "searchText", "setEditText", "Landroid/view/View;", "d", "Landroid/view/View;", "backView", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "e", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "f", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$b;", "Landroid/animation/ValueAnimator;", tl.h.F, "Landroid/animation/ValueAnimator;", "transitionAnimate", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/g;", "i", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/guild/quicksearch/searchbox/g;", "guildSearchLayoutExt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", BdhLogUtil.LogTag.Tag_Conn, "Z", "isInDelete", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildInnerSearchBar extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isInDelete;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View backView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar searchBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b searchBarListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator transitionAnimate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildSearchLayoutExt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SearchBarExtData extData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$b;", "", "", "onCancelClick", "Landroid/view/View;", "backView", "onBackClick", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "extData", "", "text", "c", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "b", "view", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public static final class a {
            public static void a(@NotNull b bVar, @NotNull QUISearchBar searchBar, @NotNull View backView) {
                Intrinsics.checkNotNullParameter(searchBar, "searchBar");
                Intrinsics.checkNotNullParameter(backView, "backView");
            }
        }

        void a(@NotNull View view);

        void b(@NotNull QUISearchBar searchBar, @NotNull View backView);

        void c(@Nullable SearchBarExtData extData, @NotNull String text);

        void onBackClick(@NotNull View backView);

        void onCancelClick();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f231843d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildInnerSearchBar f231844e;

        public c(View view, GuildInnerSearchBar guildInnerSearchBar) {
            this.f231843d = view;
            this.f231844e = guildInnerSearchBar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildInnerSearchBar", "onBack");
                }
                b bVar = this.f231844e.searchBarListener;
                if (bVar != null) {
                    bVar.onBackClick(this.f231844e.backView);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$d", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bar", "Landroid/graphics/drawable/Drawable;", "getBackground", "", "getHintTextColor", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends QUISearchBarResource {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        @NotNull
        public Drawable getBackground(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            return new ColorDrawable(0);
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public int getHintTextColor(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            return ie0.a.f().g(bar.getContext(), R.color.qui_common_text_secondary_light, bar.getCurThemeId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$e", "Lcom/tencent/mobileqq/widget/search/ActionCallbackAdapter;", "", "onCancel", "", "onClear", "", "onSearch", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends ActionCallbackAdapter {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildInnerSearchBar", "onCancel");
            }
            b bVar = GuildInnerSearchBar.this.searchBarListener;
            if (bVar != null) {
                bVar.onCancelClick();
            }
            QUISearchBar qUISearchBar = GuildInnerSearchBar.this.searchBar;
            if (qUISearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar = null;
            }
            qUISearchBar.getInputWidget().setText("");
            GuildInnerSearchBar.this.setKeyboardVisible(false);
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildInnerSearchBar", "onCancel");
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            QUISearchBar qUISearchBar = GuildInnerSearchBar.this.searchBar;
            if (qUISearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar = null;
            }
            String obj = qUISearchBar.getInputWidget().getText().toString();
            Logger logger = Logger.f235387a;
            GuildInnerSearchBar guildInnerSearchBar = GuildInnerSearchBar.this;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildInnerSearchBar", "onSearch\uff1a" + guildInnerSearchBar.extData + ", " + obj);
            }
            b bVar = GuildInnerSearchBar.this.searchBarListener;
            if (bVar != null) {
                bVar.c(GuildInnerSearchBar.this.extData, obj);
            }
            if (GuildInnerSearchBar.this.isInDelete) {
                GuildInnerSearchBar.this.isInDelete = false;
                GuildInnerSearchBar.this.r();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildInnerSearchBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final g k() {
        return (g) this.guildSearchLayoutExt.getValue();
    }

    private final void l() {
        QUISearchBar qUISearchBar = this.searchBar;
        QUISearchBar qUISearchBar2 = null;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        qUISearchBar.setSearchMode(0);
        QUISearchBar qUISearchBar3 = this.searchBar;
        if (qUISearchBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar3 = null;
        }
        qUISearchBar3.setCustomResource(new d());
        QUISearchBar qUISearchBar4 = this.searchBar;
        if (qUISearchBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar4 = null;
        }
        qUISearchBar4.getInputWidget().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.searchbox.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInnerSearchBar.m(GuildInnerSearchBar.this, view);
            }
        });
        QUISearchBar qUISearchBar5 = this.searchBar;
        if (qUISearchBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar5 = null;
        }
        qUISearchBar5.setActionCallback(new e());
        QUISearchBar qUISearchBar6 = this.searchBar;
        if (qUISearchBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar6 = null;
        }
        qUISearchBar6.getInputWidget().setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.mobileqq.guild.quicksearch.searchbox.d
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean n3;
                n3 = GuildInnerSearchBar.n(GuildInnerSearchBar.this, view, i3, keyEvent);
                return n3;
            }
        });
        QUISearchBar qUISearchBar7 = this.searchBar;
        if (qUISearchBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar7 = null;
        }
        qUISearchBar7.getInputWidget().addTextChangedListener(new f());
        QUISearchBar qUISearchBar8 = this.searchBar;
        if (qUISearchBar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        } else {
            qUISearchBar2 = qUISearchBar8;
        }
        qUISearchBar2.getInputWidget().clearFocus();
        View view = this.backView;
        view.setOnClickListener(new c(view, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildInnerSearchBar this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.searchBarListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.a(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(GuildInnerSearchBar this$0, View view, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 67 && keyEvent.getAction() == 0) {
            QUISearchBar qUISearchBar = this$0.searchBar;
            QUISearchBar qUISearchBar2 = null;
            if (qUISearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar = null;
            }
            int selectionStart = qUISearchBar.getInputWidget().getSelectionStart();
            QUISearchBar qUISearchBar3 = this$0.searchBar;
            if (qUISearchBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            } else {
                qUISearchBar2 = qUISearchBar3;
            }
            if (selectionStart == qUISearchBar2.getInputWidget().getSelectionEnd() && selectionStart == 0) {
                this$0.p();
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildInnerSearchBar this$0, ValueAnimator valueAnimator) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.backView.setAlpha(floatValue);
        View view = this$0.backView;
        int i3 = 0;
        if (floatValue > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this$0.q((26.0f * floatValue) + ((1 - floatValue) * 0.0f));
    }

    private final void p() {
        if (this.extData == null) {
            return;
        }
        if (this.isInDelete) {
            this.extData = null;
            this.isInDelete = false;
        } else {
            this.isInDelete = true;
        }
        r();
    }

    private final void q(float marginLeftDp) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        QUISearchBar qUISearchBar = this.searchBar;
        QUISearchBar qUISearchBar2 = null;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        ViewGroup.LayoutParams layoutParams = qUISearchBar.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = bi.a(marginLeftDp);
            QUISearchBar qUISearchBar3 = this.searchBar;
            if (qUISearchBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            } else {
                qUISearchBar2 = qUISearchBar3;
            }
            qUISearchBar2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        List<? extends SearchBarExtData> listOf;
        if (this.extData != null) {
            g k3 = k();
            SearchBarExtData searchBarExtData = this.extData;
            Intrinsics.checkNotNull(searchBarExtData);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(searchBarExtData);
            k3.a(listOf, this.isInDelete);
            return;
        }
        k().a(null, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.transitionAnimate;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            }
            this.transitionAnimate = null;
        }
    }

    public final void setBackVisible(boolean visible, boolean doAnimate) {
        float f16;
        int i3 = 0;
        float f17 = 1.0f;
        float f18 = 0.0f;
        if (doAnimate) {
            ValueAnimator valueAnimator = this.transitionAnimate;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.end();
            }
            if (visible) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            if (!visible) {
                f17 = 0.0f;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.quicksearch.searchbox.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    GuildInnerSearchBar.o(GuildInnerSearchBar.this, valueAnimator2);
                }
            });
            ofFloat.start();
            this.transitionAnimate = ofFloat;
            return;
        }
        View view = this.backView;
        if (!visible) {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.backView;
        if (!visible) {
            f17 = 0.0f;
        }
        view2.setAlpha(f17);
        if (visible) {
            f18 = 26.0f;
        }
        q(f18);
    }

    public final void setEditText(@NotNull String searchText) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        qUISearchBar.getInputWidget().setText(searchText);
    }

    public final void setExtInfo(@NotNull SearchBarExtData extData) {
        Intrinsics.checkNotNullParameter(extData, "extData");
        this.isInDelete = false;
        this.extData = extData;
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        qUISearchBar.setSearchBarLayoutExt(k());
        r();
    }

    public final void setKeyboardVisible(boolean show) {
        QUISearchBar qUISearchBar = null;
        if (show) {
            QUISearchBar qUISearchBar2 = this.searchBar;
            if (qUISearchBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar2 = null;
            }
            qUISearchBar2.getInputWidget().requestFocus();
            QUISearchBar qUISearchBar3 = this.searchBar;
            if (qUISearchBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar3 = null;
            }
            qUISearchBar3.getInputWidget().setCursorVisible(true);
            QUISearchBar qUISearchBar4 = this.searchBar;
            if (qUISearchBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            } else {
                qUISearchBar = qUISearchBar4;
            }
            InputMethodUtil.show(qUISearchBar.getInputWidget());
            return;
        }
        QUISearchBar qUISearchBar5 = this.searchBar;
        if (qUISearchBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar5 = null;
        }
        qUISearchBar5.getInputWidget().clearFocus();
        QUISearchBar qUISearchBar6 = this.searchBar;
        if (qUISearchBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar6 = null;
        }
        qUISearchBar6.getInputWidget().setCursorVisible(false);
        QUISearchBar qUISearchBar7 = this.searchBar;
        if (qUISearchBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        } else {
            qUISearchBar = qUISearchBar7;
        }
        InputMethodUtil.hide(qUISearchBar.getInputWidget());
    }

    public final void setSearchBarListener(@NotNull b searchBarListener) {
        Intrinsics.checkNotNullParameter(searchBarListener, "searchBarListener");
        this.searchBarListener = searchBarListener;
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        searchBarListener.b(qUISearchBar, this.backView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildInnerSearchBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildInnerSearchBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildInnerSearchBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar$guildSearchLayoutExt$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                QUISearchBar qUISearchBar = GuildInnerSearchBar.this.searchBar;
                if (qUISearchBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                    qUISearchBar = null;
                }
                return new g(qUISearchBar);
            }
        });
        this.guildSearchLayoutExt = lazy;
        LayoutInflater.from(context).inflate(R.layout.ev8, this);
        View findViewById = findViewById(R.id.f164559a43);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.back)");
        this.backView = findViewById;
        View findViewById2 = findViewById(R.id.f81284dr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.searchbar)");
        this.searchBar = (QUISearchBar) findViewById2;
        l();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$f", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (GuildInnerSearchBar.this.isInDelete) {
                GuildInnerSearchBar.this.isInDelete = false;
                GuildInnerSearchBar.this.r();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
