package com.tencent.qqnt.chathistory.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.chathistory.api.IMsgMigrationApi;
import com.tencent.qqnt.chathistory.bridge.IC2CChatHistoryVasApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.category.ChatHistoryCategoryFragment;
import com.tencent.qqnt.chathistory.ui.menu.viewmodel.ChatHistorySearchViewModel;
import com.tencent.qqnt.chathistory.ui.widget.ChatHistoryMenuItemView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class ChatHistoryMenuFragment$contentView$2 extends Lambda implements Function0<RelativeLayout> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ChatHistoryMenuFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chathistory/ui/menu/ChatHistoryMenuFragment$contentView$2$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatHistoryMenuFragment f353803d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f353804e;

        a(ChatHistoryMenuFragment chatHistoryMenuFragment, ImageView imageView) {
            this.f353803d = chatHistoryMenuFragment;
            this.f353804e = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryMenuFragment, (Object) imageView);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            Object obj;
            String str;
            IC2CChatHistoryVasApi Jh;
            ImageView imageView;
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                ImageView imageView2 = null;
                if (v3 != null) {
                    obj = v3.getTag();
                } else {
                    obj = null;
                }
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (str != null) {
                    ChatHistoryMenuFragment chatHistoryMenuFragment = this.f353803d;
                    ImageView imageView3 = this.f353804e;
                    Jh = chatHistoryMenuFragment.Jh();
                    Context context = imageView3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Jh.jumpToH5(context, str);
                    imageView = chatHistoryMenuFragment.vasTipsView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vasTipsView");
                    } else {
                        imageView2 = imageView;
                    }
                    imageView2.setVisibility(8);
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryMenuFragment$contentView$2(ChatHistoryMenuFragment chatHistoryMenuFragment) {
        super(0);
        this.this$0 = chatHistoryMenuFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryMenuFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TextView this_TextView, ChatHistoryMenuFragment this$0, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_TextView, "$this_TextView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ((IMsgMigrationApi) companion.a(IMsgMigrationApi.class)).triggerToMigration(this_TextView.getContext());
        IMsgMigrationApi iMsgMigrationApi = (IMsgMigrationApi) companion.a(IMsgMigrationApi.class);
        i3 = this$0.com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin.USERTYPE java.lang.String;
        IMsgMigrationApi.a.a(iMsgMigrationApi, "0X800C516", i3, 0, null, null, null, null, 124, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ChatHistoryMenuFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.n(a16, it, "em_bas_search_box", null, 4, null);
        this$0.Mh();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ChatHistoryMenuFragment this$0, ChatHistoryMenuItemView it12, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it12, "$it1");
        ChatHistorySearchViewModel rh5 = this$0.rh();
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        rh5.Q1(requireActivity, ChatHistoryCategoryFragment.class, new Function1<Intent, Unit>(i3) { // from class: com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$contentView$2$1$1$3$4$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $it;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$it = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent start) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) start);
                } else {
                    Intrinsics.checkNotNullParameter(start, "$this$start");
                    start.putExtra("categorySelectKey", this.$it);
                }
            }
        });
        if (this$0.rh().M1() == 1) {
            switch (i3) {
                case 0:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_date_tab", null, 4, null);
                    return;
                case 1:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_picture_video_tab", null, 4, null);
                    return;
                case 2:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_emoticon_tab", null, 4, null);
                    return;
                case 3:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_file_tab", null, 4, null);
                    return;
                case 4:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_document_tab", null, 4, null);
                    return;
                case 5:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_link_tab", null, 4, null);
                    return;
                case 6:
                    HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_short_video_tab", null, 4, null);
                    return;
                default:
                    return;
            }
        }
        switch (i3) {
            case 0:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_date_tab", null, 4, null);
                return;
            case 1:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_group_member_tab", null, 4, null);
                return;
            case 2:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_picture_video_tab", null, 4, null);
                return;
            case 3:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_emoticon_tab", null, 4, null);
                return;
            case 4:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_file_tab", null, 4, null);
                return;
            case 5:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_document_tab", null, 4, null);
                return;
            case 6:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_link_tab", null, 4, null);
                return;
            case 7:
                HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), it12, "em_bas_short_video_tab", null, 4, null);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final RelativeLayout invoke() {
        ImageView imageView;
        boolean Hh;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.this$0.getContext());
        final ChatHistoryMenuFragment chatHistoryMenuFragment = this.this$0;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            Context context = linearLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QUISecNavBar qUISecNavBar = new QUISecNavBar(context, null, 0, 6, null);
            chatHistoryMenuFragment.titleBarLayout = qUISecNavBar;
            qUISecNavBar.S(chatHistoryMenuFragment);
            qUISecNavBar.setLeftType(2);
            qUISecNavBar.setCenterType(1);
            qUISecNavBar.setRightType(2);
            qUISecNavBar.setCenterText(chatHistoryMenuFragment.getString(R.string.dqi));
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$contentView$2$1$1$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMenuFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull BaseAction motion) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) motion);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(motion, "motion");
                    if (motion == BaseAction.ACTION_LEFT_BUTTON) {
                        ChatHistoryMenuFragment.this.requireActivity().onBackPressed();
                    }
                }
            });
            BaseAction baseAction = BaseAction.ACTION_LEFT_BUTTON;
            String string = chatHistoryMenuFragment.getString(R.string.button_back);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026qui.R.string.button_back)");
            qUISecNavBar.setBaseViewDescription(baseAction, string);
            linearLayout.addView(qUISecNavBar);
            LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
            if (invoke2 != null) {
                linearLayout2.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l3 = com.tencent.aio.view_dsl.dsl.b.l();
                if (linearLayout2.getLayoutParams() == null) {
                    linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
                } else {
                    linearLayout2.getLayoutParams().width = l3;
                }
                int l16 = com.tencent.aio.view_dsl.dsl.b.l();
                if (linearLayout2.getLayoutParams() == null) {
                    linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
                } else {
                    linearLayout2.getLayoutParams().height = l16;
                }
                linearLayout2.setOrientation(1);
                linearLayout2.setBackground(AppCompatResources.getDrawable(linearLayout2.getContext(), R.drawable.qui_common_bg_bottom_light_bg));
                ImageView imageView2 = new ImageView(linearLayout2.getContext());
                chatHistoryMenuFragment.vasTipsView = imageView2;
                imageView2.setVisibility(8);
                imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                imageView = chatHistoryMenuFragment.vasTipsView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vasTipsView");
                    imageView = null;
                }
                imageView.setContentDescription(chatHistoryMenuFragment.getString(R.string.zkv));
                imageView2.setOnClickListener(new a(chatHistoryMenuFragment, imageView2));
                linearLayout2.addView(imageView2);
                QUISearchBar qUISearchBar = new QUISearchBar(linearLayout2.getContext());
                qUISearchBar.setFocusable(false);
                qUISearchBar.updateStyle(1);
                qUISearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.menu.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChatHistoryMenuFragment$contentView$2.e(ChatHistoryMenuFragment.this, view);
                    }
                });
                linearLayout2.addView(qUISearchBar);
                final ChatHistoryMenuItemView chatHistoryMenuItemView = new ChatHistoryMenuItemView(linearLayout2.getContext(), 3, chatHistoryMenuFragment.getString(R.string.zjd), chatHistoryMenuFragment.rh().b2());
                chatHistoryMenuItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                chatHistoryMenuItemView.a(new ChatHistoryMenuItemView.f() { // from class: com.tencent.qqnt.chathistory.ui.menu.c
                    @Override // com.tencent.qqnt.chathistory.ui.widget.ChatHistoryMenuItemView.f
                    public final void a(int i16) {
                        ChatHistoryMenuFragment$contentView$2.f(ChatHistoryMenuFragment.this, chatHistoryMenuItemView, i16);
                    }
                });
                linearLayout2.addView(chatHistoryMenuItemView);
                linearLayout.addView(linearLayout2);
                relativeLayout.addView(linearLayout);
                Hh = chatHistoryMenuFragment.Hh();
                if (Hh) {
                    final TextView textView = new TextView(relativeLayout.getContext());
                    Object invoke3 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                    if (invoke3 != null) {
                        textView.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(12, -1);
                        layoutParams.addRule(14, -1);
                        layoutParams.bottomMargin = ViewUtils.dpToPx(31.0f);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextSize(14.0f);
                        String string2 = textView.getContext().getResources().getString(R.string.f168392fi);
                        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026.msg_migration_tips_jump)");
                        String string3 = textView.getContext().getResources().getString(R.string.f168382fh);
                        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026g_migration_tips_content)");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new RichTextHelper.RichTextData(string2, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.menu.d
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ChatHistoryMenuFragment$contentView$2.d(textView, chatHistoryMenuFragment, view);
                            }
                        }, true));
                        textView.setText(RichTextHelper.buildSpannable(string3, textView.getContext(), false, arrayList));
                        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
                        textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
                        relativeLayout.addView(textView);
                        IMsgMigrationApi iMsgMigrationApi = (IMsgMigrationApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMsgMigrationApi.class);
                        i3 = chatHistoryMenuFragment.com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin.USERTYPE java.lang.String;
                        IMsgMigrationApi.a.a(iMsgMigrationApi, "0X800C515", i3, 0, null, null, null, null, 124, null);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                }
                return relativeLayout;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
