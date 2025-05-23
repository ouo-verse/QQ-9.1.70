package com.tencent.mobileqq.guild.aisearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputCloseEvent;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputPart;
import com.tencent.mobileqq.guild.aisearch.parts.EmptyPagePart;
import com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/GuildAISearchChatFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/mobileqq/guild/aisearch/z;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "", "Eb", "title", "f8", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "onFinish", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "logoView", "Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart;", "U", "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListPart;", "aiHistoryListPart", "V", "Ljava/lang/String;", "reportSessionId", "W", "Landroid/view/View;", "mRootView", "<init>", "()V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildAISearchChatFragment extends QQGuildTokenTitleBarFragment implements z {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView logoView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiHistoryListPart;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String reportSessionId;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private View mRootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/GuildAISearchChatFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "a", "", "AI_SEARCH_LOGO", "Ljava/lang/String;", "AI_SEARCH_LOGO_NIGHT", "ENTER_TYPE", "", "ENTER_TYPE_DEFAULT", "I", "ENTER_TYPE_FROM_H5", "GUILD_AI_SEARCH_TAG", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.GuildAISearchChatFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildAISearchChatFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f213973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildAISearchChatFragment f213974e;

        public b(View view, GuildAISearchChatFragment guildAISearchChatFragment) {
            this.f213973d = view;
            this.f213974e = guildAISearchChatFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View rootView;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                ImageView imageView = ((QQGuildCustomTitleBarFragment) this.f213974e).I;
                if (imageView != null && (rootView = imageView.getRootView()) != null) {
                    rootView.requestFocus();
                }
                this.f213974e.Hh().oa();
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(((QQGuildCustomTitleBarFragment) this.f213974e).I, "em_sgrp_history", "", "clck", new HashMap());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildAISearchChatFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIHistoryListPart>() { // from class: com.tencent.mobileqq.guild.aisearch.GuildAISearchChatFragment$aiHistoryListPart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIHistoryListPart invoke() {
                View view;
                view = GuildAISearchChatFragment.this.mRootView;
                Intrinsics.checkNotNull(view);
                return new AIHistoryListPart(view);
            }
        });
        this.aiHistoryListPart = lazy;
        this.reportSessionId = "";
        sh(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIHistoryListPart Hh() {
        return (AIHistoryListPart) this.aiHistoryListPart.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(GuildAISearchChatFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildAISearchInputCloseEvent(true));
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null) {
                activity2.overridePendingTransition(0, R.anim.f154576nj);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.aisearch.z
    public void Eb(@NotNull HashMap<String, String> map) {
        View view;
        Intrinsics.checkNotNullParameter(map, "map");
        if (!Intrinsics.areEqual(map.get("sgrp_ai_session_id"), this.reportSessionId) && (view = this.mRootView) != null) {
            Intrinsics.checkNotNull(view);
            VideoReport.setPageParams(view.getParent(), PageParams.builder().setBasicParams(map).build());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new AIChatListPart(), new GuildAISearchInputPart(), new AIHistoryListEmptyPart(), Hh(), new EmptyPagePart(), new PageToggleAnimatorPart());
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.guild.aisearch.z
    public void f8(@NotNull String title) {
        Resources resources;
        int i3;
        Intrinsics.checkNotNullParameter(title, "title");
        sh(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        textView.setText(title);
        textView.setTextSize(17.0f);
        textView.setGravity(16);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        textView.setTypeface(null, 1);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            int i16 = -2;
            if (layoutParams2 != null) {
                i3 = layoutParams2.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
        }
        if (5 != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = 5;
            textView.setLayoutParams(marginLayoutParams);
        }
        textView.setIncludeFontPadding(false);
        Context context = textView.getContext();
        if (context != null && (resources = context.getResources()) != null) {
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            textView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        }
        linearLayout.addView(textView);
        th(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.edx;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154575ni, R.anim.f154425m);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (Hh().S9()) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154576nj);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        Context context;
        Intent intent;
        super.onFinish();
        FragmentActivity activity = getActivity();
        boolean z16 = false;
        if (activity != null && (intent = activity.getIntent()) != null && intent.getIntExtra("ENTER_TYPE", 0) == 1) {
            z16 = true;
        }
        if (z16 && (context = getContext()) != null) {
            GuildJumpUtil.p(context, null, 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        View view2;
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mRootView = view;
        if (com.tencent.mobileqq.guild.aisearch.input.f.INSTANCE.a()) {
            i3 = 48;
        } else {
            i3 = 16;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(i3 | 4);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            if (view2 == null) {
                view2 = view;
            }
            VideoReport.addToDetectionWhitelist(activity2);
            VideoReport.setPageId(view2, "pg_sgrp_ai_search");
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(view2, "", null);
            VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
        }
        View view3 = getView();
        if (view3 != null) {
            view3.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
        GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(getResources(), R.drawable.guild_vector_icon_close_primary, null);
        if (create != null) {
            create.setTintList(getResources().getColorStateList(R.color.qui_common_icon_primary));
        }
        if (create != null) {
            create.setOverrideStrokeWidth(1.7f);
        }
        xh(create, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildAISearchChatFragment.Ih(GuildAISearchChatFragment.this, view4);
            }
        });
        GuildVectorDrawableCompat create2 = GuildVectorDrawableCompat.create(getResources(), R.drawable.guild_vector_icon_drawer, null);
        if (create2 != null) {
            create2.setOverrideStrokeWidth(1.7f);
        }
        this.I.setImageDrawable(create2);
        this.I.setImageTintList(getResources().getColorStateList(R.color.qui_common_icon_primary));
        this.I.setBackground(null);
        ImageView mLeftBackIcon = this.I;
        Intrinsics.checkNotNullExpressionValue(mLeftBackIcon, "mLeftBackIcon");
        mLeftBackIcon.setVisibility(0);
        ImageView mLeftBackIcon2 = this.I;
        Intrinsics.checkNotNullExpressionValue(mLeftBackIcon2, "mLeftBackIcon");
        mLeftBackIcon2.setOnClickListener(new b(mLeftBackIcon2, this));
        this.C.setVisibility(8);
        RFWIocAbilityProvider.g().registerIoc(view, this, z.class);
        View findViewById = view.findViewById(R.id.f165569wp4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_logo)");
        this.logoView = (ImageView) findViewById;
        if (GuildThemeManager.f235286a.b()) {
            ImageView imageView = this.logoView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoView");
                imageView = null;
            }
            com.tencent.mobileqq.guild.util.v.l("https://downv6.qq.com/innovate/guild/search/guild_ai_search_logo_night.png", imageView, null, 4, null);
        } else {
            ImageView imageView2 = this.logoView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoView");
                imageView2 = null;
            }
            com.tencent.mobileqq.guild.util.v.l("https://downv6.qq.com/innovate/guild/search/guild_ai_search_logo.png", imageView2, null, 4, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.sgf);
        GuildAISearchConfBean.Companion companion = GuildAISearchConfBean.INSTANCE;
        textView.setText(companion.a().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String());
        ((TextView) view.findViewById(R.id.sgd)).setText(companion.a().getSearchResultLine1());
        ((TextView) view.findViewById(R.id.sge)).setText(companion.a().getSearchResultLine2());
    }
}
