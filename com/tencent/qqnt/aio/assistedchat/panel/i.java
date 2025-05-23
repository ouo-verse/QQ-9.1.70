package com.tencent.qqnt.aio.assistedchat.panel;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u00018\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u00109R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/i;", "", "", "source", "f", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "g", "Landroid/view/View;", "i", "", "enable", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/qqnt/aio/assistedchat/panel/k;", "panelItemList", "o", "", "panelId", DomainData.DOMAIN_NAME, "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", tl.h.F, "l", "Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "a", "Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "e", "()Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "interaction", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerLayout;", "b", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerLayout;", "containerView", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "contentView", "Lcom/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView;", "Lcom/tencent/qqnt/aio/assistedchat/panel/PanelPolarLightView;", "polarLightView", "Lcom/tencent/mobileqq/widget/QQViewPager;", "Lcom/tencent/mobileqq/widget/QQViewPager;", "viewPager", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "settingIv", "Lcom/tencent/qqnt/aio/assistedchat/panel/b;", "Lcom/tencent/qqnt/aio/assistedchat/panel/b;", "panelAdapter", "com/tencent/qqnt/aio/assistedchat/panel/i$a", "Lcom/tencent/qqnt/aio/assistedchat/panel/i$a;", "onPageChangeListener", "j", "Ljava/util/List;", "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/panel/p;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p interaction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AssistedChatPanelContainerLayout containerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout contentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PanelPolarLightView polarLightView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQViewPager viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPageTabBar tabBar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView settingIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b panelAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a onPageChangeListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<k> panelItemList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/i$a", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "onPageSelected", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends ViewPager.SimpleOnPageChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
            } else {
                i.this.e().c(i.this.panelAdapter.e(position));
            }
        }
    }

    public i(@NotNull p interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interaction);
            return;
        }
        this.interaction = interaction;
        this.panelAdapter = new b(interaction);
        this.onPageChangeListener = new a();
    }

    private final String f(String source) {
        int hashCode = source.hashCode();
        if (hashCode != 213008209) {
            if (hashCode != 1386343374) {
                if (hashCode == 1950231791 && source.equals("bottom_bar_topic")) {
                    return "2";
                }
            } else if (source.equals("input_icon")) {
                return "4";
            }
        } else if (source.equals("bottom_bar_polish")) {
            return "3";
        }
        return "0";
    }

    private final Drawable g(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_light_tertiary));
        gradientDrawable.setStroke((int) com.tencent.qqnt.aio.utils.l.a(0.5f), ContextCompat.getColorStateList(context, R.color.qui_common_border_light));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r1 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void j(i this$0, QUIPageTabBar this_apply, int i3, boolean z16) {
        String str;
        Map<String, String> mapOf;
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (z16) {
            List<k> list = this$0.panelItemList;
            if (list != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, i3);
                k kVar = (k) orNull;
                if (kVar != null) {
                    str = kVar.b();
                }
            }
            str = "";
            AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("label_name", str));
            assistedChatPanelDtReporter.a("em_kl_agent_label", this_apply, mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.interaction.b();
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        AssistedChatPanelDtReporter.b(assistedChatPanelDtReporter, "em_kl_agent_set_en", it, null, 4, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    public final int d() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager != null) {
            i3 = qQViewPager.getCurrentItem();
        } else {
            i3 = 0;
        }
        return this.panelAdapter.e(i3);
    }

    @NotNull
    public final p e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (p) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.interaction;
    }

    public final void h(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AssistedChatPanelContainerLayout assistedChatPanelContainerLayout = this.containerView;
        if (assistedChatPanelContainerLayout != null) {
            AssistedChatPanelDtReporter.f349138a.f(assistedChatPanelContainerLayout, aioContext);
        }
    }

    @NotNull
    public final View i(@NotNull Context context) {
        Typeface create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        AssistedChatPanelContainerLayout assistedChatPanelContainerLayout = new AssistedChatPanelContainerLayout(context, null, 0, 6, null);
        assistedChatPanelContainerLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        assistedChatPanelContainerLayout.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        this.containerView = assistedChatPanelContainerLayout;
        PanelPolarLightView panelPolarLightView = new PanelPolarLightView(context);
        panelPolarLightView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.polarLightView = panelPolarLightView;
        assistedChatPanelContainerLayout.addView(panelPolarLightView);
        QQViewPager qQViewPager = new QQViewPager(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        qQViewPager.setLayoutParams(layoutParams);
        qQViewPager.setOffscreenPageLimit(2);
        qQViewPager.setAdapter(this.panelAdapter);
        qQViewPager.addOnPageChangeListener(this.onPageChangeListener);
        this.viewPager = qQViewPager;
        final QUIPageTabBar qUIPageTabBar = new QUIPageTabBar(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, com.tencent.qqnt.aio.utils.l.b(44));
        layoutParams2.weight = 1.0f;
        qUIPageTabBar.setLayoutParams(layoutParams2);
        qUIPageTabBar.setCheckedColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        qUIPageTabBar.setUncheckedColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_secondary));
        qUIPageTabBar.setUnderlineColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        qUIPageTabBar.setTabTextSize(16.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(null, 600, false);
            qUIPageTabBar.setTabTypeface(create);
        }
        qUIPageTabBar.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.qqnt.aio.assistedchat.panel.g
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                i.j(i.this, qUIPageTabBar, i3, z16);
            }
        });
        qUIPageTabBar.setViewPager(this.viewPager);
        this.tabBar = qUIPageTabBar;
        AlphaClickableImageView alphaClickableImageView = new AlphaClickableImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.tencent.qqnt.aio.utils.l.b(28), com.tencent.qqnt.aio.utils.l.b(28));
        layoutParams3.leftMargin = com.tencent.qqnt.aio.utils.l.b(-12);
        layoutParams3.gravity = 16;
        alphaClickableImageView.setLayoutParams(layoutParams3);
        alphaClickableImageView.setImageResource(R.drawable.qui_setting_icon_secondary_selector);
        int b16 = com.tencent.qqnt.aio.utils.l.b(4);
        alphaClickableImageView.setPadding(b16, b16, b16, b16);
        alphaClickableImageView.setBackground(g(context));
        alphaClickableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.k(i.this, view);
            }
        });
        AssistedChatPanelDtReporter.d(AssistedChatPanelDtReporter.f349138a, "em_kl_agent_set_en", alphaClickableImageView, null, 4, null);
        this.settingIv = alphaClickableImageView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) com.tencent.qqnt.aio.utils.l.a(0.5f)));
        view.setBackgroundResource(R.drawable.qui_common_border_light_bg);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.qqnt.aio.utils.l.b(44)));
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(com.tencent.qqnt.aio.utils.l.b(16), 0, com.tencent.qqnt.aio.utils.l.b(16), 0);
        linearLayout2.addView(this.tabBar);
        linearLayout2.addView(this.settingIv);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(this.viewPager);
        this.contentView = linearLayout;
        assistedChatPanelContainerLayout.addView(linearLayout);
        return assistedChatPanelContainerLayout;
    }

    public final void l(@NotNull String source) {
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) source);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        LinearLayout linearLayout = this.contentView;
        if (linearLayout != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("recommended_scenario_source", f(source)));
            AssistedChatPanelDtReporter.f349138a.c("em_kl_more_panel", linearLayout, mapOf);
        }
    }

    public final void m(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, enable);
            return;
        }
        PanelPolarLightView panelPolarLightView = this.polarLightView;
        if (panelPolarLightView != null) {
            panelPolarLightView.p(enable);
        }
    }

    public final void n(int panelId) {
        QQViewPager qQViewPager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, panelId);
            return;
        }
        int d16 = this.panelAdapter.d(panelId);
        if (d16 >= 0 && d16 < this.panelAdapter.getF373114d() && (qQViewPager = this.viewPager) != null) {
            qQViewPager.setCurrentItem(d16);
        }
    }

    public final void o(@NotNull List<k> panelItemList) {
        int collectionSizeOrDefault;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) panelItemList);
            return;
        }
        Intrinsics.checkNotNullParameter(panelItemList, "panelItemList");
        this.panelItemList = panelItemList;
        this.panelAdapter.f(panelItemList);
        QUIPageTabBar qUIPageTabBar = this.tabBar;
        if (qUIPageTabBar != null) {
            List<k> list = panelItemList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList<String> arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((k) it.next()).b());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            qUIPageTabBar.setTabData((String[]) array);
            for (String str : arrayList) {
                AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("label_name", str));
                assistedChatPanelDtReporter.c("em_kl_agent_label", qUIPageTabBar, mapOf);
            }
        }
    }
}
