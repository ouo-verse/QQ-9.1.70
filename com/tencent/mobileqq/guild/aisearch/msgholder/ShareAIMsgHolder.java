package com.tencent.mobileqq.guild.aisearch.msgholder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.share.ShareScreenshot;
import com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareHelper;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.perf.block.ContextMethodProxy;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import te1.a;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u00a2\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/msgholder/ShareAIMsgHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "t", "", "p", "r", "o", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "E", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "chatListAdapter", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "shareView", "G", "copyView", "H", "refreshView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ShareAIMsgHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> chatListAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView shareView;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView copyView;

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView refreshView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f214189d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ShareAIMsgHolder f214190e;

        public b(View view, ShareAIMsgHolder shareAIMsgHolder) {
            this.f214189d = view;
            this.f214190e = shareAIMsgHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                new GuildLLMChatShareHelper().d(this.f214190e.chatListAdapter);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f214191d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ShareAIMsgHolder f214192e;

        public c(View view, ShareAIMsgHolder shareAIMsgHolder) {
            this.f214191d = view;
            this.f214192e = shareAIMsgHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                ShareScreenshot shareScreenshot = new ShareScreenshot(this.f214192e.chatListAdapter.getHostActivity(), GuildSharePageSource.AI_CARD_SHOOT);
                shareScreenshot.j(new Function1<ShareScreenshot.b, Boolean>() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.ShareAIMsgHolder$bindData$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull ShareScreenshot.b configShareTarget) {
                        Intrinsics.checkNotNullParameter(configShareTarget, "$this$configShareTarget");
                        if (configShareTarget instanceof ShareScreenshot.b.g) {
                            ((ShareScreenshot.b.g) configShareTarget).d("\u5206\u4eab\u6211\u8ddf" + GuildAISearchConfBean.INSTANCE.a().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String() + "\u7684\u5bf9\u8bdd");
                        }
                        return Boolean.TRUE;
                    }
                });
                GuildSearchLLMChatPictureGenerator.b bVar = this.f214192e.chatListAdapter;
                GuildAISearchConfBean.Companion companion = GuildAISearchConfBean.INSTANCE;
                shareScreenshot.p(new GuildSearchLLMChatPictureOldGenerator.GeneratorParam(bVar, companion.a().getIconUrl(), companion.a().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String(), 5000L));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f214193d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ShareAIMsgHolder f214194e;

        public d(View view, ShareAIMsgHolder shareAIMsgHolder) {
            this.f214193d = view;
            this.f214194e = shareAIMsgHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                Context context = this.f214194e.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                Object systemService = ContextMethodProxy.getSystemService(context, "clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("label", this.f214194e.chatListAdapter.l0()));
                a.Companion companion = te1.a.INSTANCE;
                Context context2 = this.f214194e.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                companion.b(context2, "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f214195d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ShareAIMsgHolder f214196e;

        public e(View view, ShareAIMsgHolder shareAIMsgHolder) {
            this.f214195d = view;
            this.f214196e = shareAIMsgHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f214196e.chatListAdapter.s0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareAIMsgHolder(@NotNull View itemView, @NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> chatListAdapter) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(chatListAdapter, "chatListAdapter");
        this.chatListAdapter = chatListAdapter;
        this.shareView = (ImageView) itemView.findViewById(R.id.vn6);
        this.copyView = (ImageView) itemView.findViewById(R.id.u9m);
        this.refreshView = (ImageView) itemView.findViewById(R.id.f72363qn);
    }

    private final void p() {
        this.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.e
            @Override // java.lang.Runnable
            public final void run() {
                ShareAIMsgHolder.q(ShareAIMsgHolder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ShareAIMsgHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("imp", this$0.shareView, this$0.t());
        VideoReport.reportEvent("imp", this$0.copyView, this$0.t());
        VideoReport.reportEvent("imp", this$0.refreshView, this$0.t());
    }

    private final void r() {
        this.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.d
            @Override // java.lang.Runnable
            public final void run() {
                ShareAIMsgHolder.s(ShareAIMsgHolder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ShareAIMsgHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("imp", this$0.copyView, this$0.t());
        VideoReport.reportEvent("imp", this$0.refreshView, this$0.t());
    }

    private final HashMap<String, String> t() {
        String str;
        String sessionId;
        a.AnswerItem e16;
        HashMap<String, String> hashMap = new HashMap<>();
        AiChatSession m06 = this.chatListAdapter.m0();
        String str2 = "";
        if (m06 == null || (e16 = m06.e()) == null || (str = e16.getMessageId()) == null) {
            str = "";
        }
        hashMap.put("sgrp_dialog_id", str);
        AiChatSession m07 = this.chatListAdapter.m0();
        if (m07 != null && (sessionId = m07.getSessionId()) != null) {
            str2 = sessionId;
        }
        hashMap.put("sgrp_ai_session_id", str2);
        return hashMap;
    }

    public final void o() {
        ImageView shareView = this.shareView;
        Intrinsics.checkNotNullExpressionValue(shareView, "shareView");
        HashMap<String, String> t16 = t();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        bt.c(shareView, "em_sgrp_create_share_img", t16, clickPolicy, exposurePolicy, endExposurePolicy);
        ImageView copyView = this.copyView;
        Intrinsics.checkNotNullExpressionValue(copyView, "copyView");
        bt.c(copyView, "em_sgrp_copy", t(), clickPolicy, exposurePolicy, endExposurePolicy);
        ImageView refreshView = this.refreshView;
        Intrinsics.checkNotNullExpressionValue(refreshView, "refreshView");
        bt.c(refreshView, "em_sgrp_search_again", t(), clickPolicy, exposurePolicy, endExposurePolicy);
        this.itemView.setVisibility(0);
        int show_new_share = GuildAISearchConfBean.INSTANCE.a().getShow_new_share();
        if (show_new_share != 0) {
            if (show_new_share != 1) {
                if (show_new_share == 2) {
                    ImageView shareView2 = this.shareView;
                    Intrinsics.checkNotNullExpressionValue(shareView2, "shareView");
                    shareView2.setOnClickListener(new c(shareView2, this));
                    p();
                }
            } else {
                ImageView shareView3 = this.shareView;
                Intrinsics.checkNotNullExpressionValue(shareView3, "shareView");
                shareView3.setOnClickListener(new b(shareView3, this));
                p();
            }
        } else {
            this.shareView.setVisibility(8);
            r();
        }
        ImageView copyView2 = this.copyView;
        Intrinsics.checkNotNullExpressionValue(copyView2, "copyView");
        copyView2.setOnClickListener(new d(copyView2, this));
        ImageView refreshView2 = this.refreshView;
        Intrinsics.checkNotNullExpressionValue(refreshView2, "refreshView");
        refreshView2.setOnClickListener(new e(refreshView2, this));
    }
}
