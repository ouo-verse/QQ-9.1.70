package com.tencent.mobileqq.guild.aisearch.msgholder;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.aisearch.models.operators.AdaptiveContentEmitKt;
import com.tencent.mobileqq.guild.aisearch.views.AIReplyView;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0001?\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002GHB\u001d\u0012\u0006\u0010C\u001a\u00020\u0016\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b\u00a2\u0006\u0004\bD\u0010EJ\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010!\u001a\u0004\b3\u00104R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lqe1/c;", "Lqe1/a;", "", "rawContent", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "", "v", "reasonContent", "y", "", "resume", "H", "Lcom/tencent/android/androidbypass/parser/a;", "B", "Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "answerItem", "w", "onViewDetachedFromWindow", "onViewAttachedToWindow", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "E", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "adapter", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "aiSearchConfig", "Lkotlinx/coroutines/Job;", "G", "Lkotlinx/coroutines/Job;", "bindJob", "Lvp1/b;", "Lvp1/b;", "binding", "I", "Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "J", "Lcom/tencent/android/androidbypass/parser/a;", "markdownParser", "Lre1/h;", "K", "D", "()Lre1/h;", "msgStateController", "L", "Z", "isExpanded", "M", "inAnimation", "Lcom/tencent/android/androidbypass/enhance/i;", "N", "Lcom/tencent/android/androidbypass/enhance/i;", "styleSheet", "com/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder$e", "P", "Lcom/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder$e;", "sHttpUrlClickDispatcher", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIMsgHolder extends RecyclerView.ViewHolder implements qe1.c, qe1.a {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiSearchConfig;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Job bindJob;

    /* renamed from: H, reason: from kotlin metadata */
    private vp1.b binding;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private a.AnswerItem answerItem;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.parser.a markdownParser;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgStateController;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean inAnimation;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final i styleSheet;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e sHttpUrlClickDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder$a;", "Lst/a;", "", "c", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "Lcom/tencent/android/androidbypass/codeblock/config/c;", "d", "", "a", "Landroidx/lifecycle/LifecycleOwner;", "b", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder;Landroidx/lifecycle/LifecycleOwner;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public final class a implements st.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final LifecycleOwner lifeCycleOwner;

        public a(@Nullable LifecycleOwner lifecycleOwner) {
            this.lifeCycleOwner = lifecycleOwner;
        }

        @Override // st.a
        public int a() {
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).getCodeBlockMaxLineCountInAIO();
        }

        @Override // st.a
        @Nullable
        /* renamed from: b, reason: from getter */
        public LifecycleOwner getLifeCycleOwner() {
            return this.lifeCycleOwner;
        }

        @Override // st.a
        public boolean c() {
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).isEnableCodeBlockHighlight();
        }

        @Override // st.a
        @NotNull
        public com.tencent.android.androidbypass.codeblock.config.c d(@NotNull Context context, @NotNull String language) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(language, "language");
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).buildCodeBlockConfigForAIO(context);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f214185d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIMsgHolder f214186e;

        public d(View view, AIMsgHolder aIMsgHolder) {
            this.f214185d = view;
            this.f214186e = aIMsgHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f214186e.H(false);
                vp1.b bVar = this.f214186e.binding;
                vp1.b bVar2 = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar = null;
                }
                bVar.f442379o.getRootView().requestFocus();
                te1.g gVar = te1.g.f435886a;
                vp1.b bVar3 = this.f214186e.binding;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar2 = bVar3;
                }
                AIReplyView aIReplyView = bVar2.f442374j;
                Intrinsics.checkNotNullExpressionValue(aIReplyView, "binding.reasonContent");
                gVar.b(aIReplyView, new c());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder$e", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.c f214187a = new com.tencent.android.androidbypass.enhance.scheme.matcher.c();

        e() {
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f214187a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            String str;
            String sessionId;
            a.AnswerItem e16;
            if (url != null && view != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    IGuildAIOLinkSpanApi iGuildAIOLinkSpanApi = (IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class);
                    BaseApplication context = BaseApplication.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                    iGuildAIOLinkSpanApi.onInlineBtnClick(peekAppRuntime, context, url);
                }
                ch.Y0(view, "em_sgrp_result_channel_url", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
                HashMap hashMap = new HashMap();
                AIMsgHolder aIMsgHolder = AIMsgHolder.this;
                hashMap.put("sgrp_url", url);
                AiChatSession m06 = aIMsgHolder.adapter.m0();
                String str2 = "";
                if (m06 == null || (e16 = m06.e()) == null || (str = e16.getMessageId()) == null) {
                    str = "";
                }
                hashMap.put("sgrp_dialog_id", str);
                AiChatSession m07 = aIMsgHolder.adapter.m0();
                if (m07 != null && (sessionId = m07.getSessionId()) != null) {
                    str2 = sessionId;
                }
                hashMap.put("sgrp_ai_session_id", str2);
                Unit unit = Unit.INSTANCE;
                VideoReport.reportEvent("dt_clck", view, hashMap);
                view.clearFocus();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIMsgHolder(@NotNull View itemView, @NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter) {
        super(itemView);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildAISearchConfBean>() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.AIMsgHolder$aiSearchConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildAISearchConfBean invoke() {
                return GuildAISearchConfBean.INSTANCE.a();
            }
        });
        this.aiSearchConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<re1.h>() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.AIMsgHolder$msgStateController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final re1.h invoke() {
                vp1.b bVar = AIMsgHolder.this.binding;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar = null;
                }
                return new re1.h(bVar, AIMsgHolder.this.adapter);
            }
        });
        this.msgStateController = lazy2;
        this.isExpanded = true;
        i iVar = new i();
        float[] fArr = iVar.f72178b;
        fArr[0] = 1.3529412f;
        fArr[1] = 1.117647f;
        fArr[2] = 1.117647f;
        fArr[3] = 1.117647f;
        fArr[4] = 1.117647f;
        fArr[5] = 1.117647f;
        iVar.f72206v = itemView.getContext().getColor(R.color.qui_common_brand_standard);
        iVar.B = 4;
        iVar.C = 1;
        iVar.f72209y = 0.88235295f;
        iVar.f72205u = itemView.getContext().getColor(R.color.qui_common_text_secondary);
        iVar.f72208x = 0.65f;
        iVar.f72207w = 0.1f;
        iVar.f72184e = 12.0f;
        this.styleSheet = iVar;
        this.sHttpUrlClickDispatcher = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(AIMsgHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adapter.s0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.android.androidbypass.parser.a B(LifecycleOwner lifecycle) {
        List<? extends com.tencent.android.androidbypass.parser.api.b> listOf;
        if (this.markdownParser == null) {
            com.tencent.android.androidbypass.parser.d c16 = com.tencent.qqnt.markdown.g.f359430a.g().j(com.tencent.guild.aio.msglist.text.util.f.f(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null)).c(new a(lifecycle));
            listOf = CollectionsKt__CollectionsJVMKt.listOf(this.sHttpUrlClickDispatcher);
            this.markdownParser = c16.e(listOf).h(this.styleSheet).b();
        }
        return this.markdownParser;
    }

    private final GuildAISearchConfBean C() {
        return (GuildAISearchConfBean) this.aiSearchConfig.getValue();
    }

    private final re1.h D() {
        return (re1.h) this.msgStateController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AIMsgHolder this$0) {
        View view;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vp1.b bVar = this$0.binding;
        vp1.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        Object parent = bVar.f442374j.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            i3 = view.getWidth();
        } else {
            i3 = UIUtil.f112434a.x().getDisplayMetrics().widthPixels;
        }
        vp1.b bVar3 = this$0.binding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar3 = null;
        }
        bVar3.f442374j.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        vp1.b bVar4 = this$0.binding;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar4 = null;
        }
        bVar4.f442374j.getLayoutParams().height = -2;
        vp1.b bVar5 = this$0.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar5 = null;
        }
        bVar5.f442366b.requestLayout();
        vp1.b bVar6 = this$0.binding;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar6 = null;
        }
        bVar6.f442376l.clearAnimation();
        vp1.b bVar7 = this$0.binding;
        if (bVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar2 = bVar7;
        }
        bVar2.f442374j.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(boolean resume) {
        vp1.b bVar = this.binding;
        vp1.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.f442374j.setFocusable(resume);
        vp1.b bVar3 = this.binding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar3 = null;
        }
        bVar3.f442374j.setTextIsSelectable(resume);
        vp1.b bVar4 = this.binding;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar4 = null;
        }
        bVar4.f442367c.setFocusable(resume);
        vp1.b bVar5 = this.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar2 = bVar5;
        }
        bVar2.f442367c.setTextIsSelectable(resume);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        if (r8 == true) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void v(String rawContent, LifecycleOwner lifecycle) {
        boolean z16;
        StateFlow<ChatAnswerData> b16;
        ChatAnswerData value;
        String content;
        boolean z17;
        String s16 = C().s(rawContent);
        com.tencent.android.androidbypass.parser.a B = B(lifecycle);
        vp1.b bVar = null;
        if (B != null) {
            vp1.b bVar2 = this.binding;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar2 = null;
            }
            a.C0724a.a(B, s16, bVar2.f442367c, null, 4, null);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            int length = s16.length();
            vp1.b bVar3 = this.binding;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar3 = null;
            }
            Log.d("guild.ai.search.AnswerMsgTempHolder", "bindContent: (" + length + ") line=" + bVar3.f442367c.getLineCount());
        }
        a.AnswerItem answerItem = this.answerItem;
        if (answerItem != null && (b16 = answerItem.b()) != null && (value = b16.getValue()) != null && (content = value.getContent()) != null) {
            z16 = true;
            if (content.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            vp1.b bVar4 = this.binding;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bVar = bVar4;
            }
            bVar.f442367c.setVisibility(0);
            return;
        }
        vp1.b bVar5 = this.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar = bVar5;
        }
        bVar.f442367c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AIMsgHolder aIMsgHolder, a.AnswerItem answerItem, ChatAnswerData chatAnswerData) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("guild.ai.search.AnswerMsgTempHolder", "updateUI[" + m.a(aIMsgHolder) + "]: " + chatAnswerData);
        }
        aIMsgHolder.D().f(chatAnswerData, answerItem);
        aIMsgHolder.y(chatAnswerData.l(), nf2.b.a(aIMsgHolder.adapter.getHostActivity()));
        aIMsgHolder.v(chatAnswerData.a(), nf2.b.a(aIMsgHolder.adapter.getHostActivity()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r0 == true) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y(String reasonContent, LifecycleOwner lifecycle) {
        boolean z16;
        StateFlow<ChatAnswerData> b16;
        ChatAnswerData value;
        String reasonContent2;
        boolean z17;
        com.tencent.android.androidbypass.parser.a B = B(lifecycle);
        vp1.b bVar = null;
        if (B != null) {
            vp1.b bVar2 = this.binding;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar2 = null;
            }
            a.C0724a.a(B, reasonContent, bVar2.f442374j, null, 4, null);
        }
        if (!this.inAnimation) {
            a.AnswerItem answerItem = this.answerItem;
            if (answerItem != null && (b16 = answerItem.b()) != null && (value = b16.getValue()) != null && (reasonContent2 = value.getReasonContent()) != null) {
                z16 = true;
                if (reasonContent2.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z16 = false;
            if (z16) {
                GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> bVar3 = this.adapter;
                a.AnswerItem answerItem2 = this.answerItem;
                Intrinsics.checkNotNull(answerItem2);
                if (bVar3.n0(answerItem2.getMessageId())) {
                    vp1.b bVar4 = this.binding;
                    if (bVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar4 = null;
                    }
                    bVar4.f442374j.setVisibility(0);
                    vp1.b bVar5 = this.binding;
                    if (bVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar5 = null;
                    }
                    bVar5.f442376l.setRotation(0.0f);
                } else {
                    vp1.b bVar6 = this.binding;
                    if (bVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar6 = null;
                    }
                    bVar6.f442374j.setVisibility(8);
                    vp1.b bVar7 = this.binding;
                    if (bVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar7 = null;
                    }
                    bVar7.f442376l.setRotation(180.0f);
                }
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    int length = reasonContent.length();
                    vp1.b bVar8 = this.binding;
                    if (bVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bVar = bVar8;
                    }
                    Log.d("guild.ai.search.AnswerMsgTempHolder", "bindReasonContent: (" + length + ") line=" + bVar.f442367c.getLineCount());
                    return;
                }
                return;
            }
            vp1.b bVar9 = this.binding;
            if (bVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bVar = bVar9;
            }
            bVar.f442374j.setVisibility(8);
        }
    }

    @Override // qe1.c
    public void h() {
        this.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.b
            @Override // java.lang.Runnable
            public final void run() {
                AIMsgHolder.E(AIMsgHolder.this);
            }
        });
    }

    @Override // qe1.a
    @NotNull
    public String i() {
        vp1.b bVar = this.binding;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        return bVar.f442367c.j().toString();
    }

    public final void onViewAttachedToWindow() {
        this.adapter.q0(this);
        this.adapter.r0(this);
    }

    public final void onViewDetachedFromWindow() {
        Job job = this.bindJob;
        if (job != null) {
            job.cancel(new CancellationException("View detached from window"));
        }
        this.adapter.t0(this);
        this.adapter.u0(this);
    }

    public final void w(@NotNull a.AnswerItem answerItem) {
        Intrinsics.checkNotNullParameter(answerItem, "answerItem");
        this.answerItem = answerItem;
        Job job = this.bindJob;
        boolean z16 = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        StateFlow<ChatAnswerData> b16 = answerItem.b();
        ChatAnswerData value = b16.getValue();
        if (value.j()) {
            vp1.b bVar = this.binding;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar = null;
            }
            ImageView imageView = bVar.f442370f;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingIcon");
            v.l("https://downv6.qq.com/innovate/search/search_ai_loading_ispt.png", imageView, null, 4, null);
            h();
        }
        this.isExpanded = true;
        if (value.k()) {
            x(this, answerItem, value);
            this.bindJob = null;
            if (value.getReasonContent().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                h();
                return;
            }
            return;
        }
        Flow onEach = FlowKt.onEach(com.tencent.mobileqq.guild.base.extension.FlowKt.b(AdaptiveContentEmitKt.a(b16), 500L, new Function1<ChatAnswerData, Boolean>() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.AIMsgHolder$bindData$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ChatAnswerData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.k());
            }
        }), new AIMsgHolder$bindData$2(this, answerItem, null));
        LifecycleOwner a16 = nf2.b.a(this.adapter.getHostActivity());
        Intrinsics.checkNotNull(a16);
        Job launchIn = FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(a16));
        launchIn.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.AIMsgHolder$bindData$3$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                if (th5 != null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str = "Flow collection failed " + th5;
                    if (str instanceof String) {
                        bVar2.a().add(str);
                    }
                    Iterator<T> it = bVar2.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("guild.ai.search.AnswerMsgTempHolder", 1, (String) it.next(), null);
                    }
                }
            }
        });
        this.bindJob = launchIn;
    }

    public final void z(@Nullable View containerView) {
        if (containerView != null) {
            vp1.b e16 = vp1.b.e(containerView);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(view)");
            this.binding = e16;
            vp1.b bVar = null;
            if (e16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                e16 = null;
            }
            ImageView imageView = e16.f442370f;
            vp1.b bVar2 = this.binding;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar2 = null;
            }
            imageView.setColorFilter(new PorterDuffColorFilter(bVar2.f442370f.getContext().getColor(R.color.qui_common_text_primary), PorterDuff.Mode.SRC_IN));
            vp1.b bVar3 = this.binding;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar3 = null;
            }
            bVar3.f442369e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.msgholder.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIMsgHolder.A(AIMsgHolder.this, view);
                }
            });
            vp1.b bVar4 = this.binding;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar4 = null;
            }
            bVar4.f442367c.setTag(R.id.x1r, this.adapter);
            vp1.b bVar5 = this.binding;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar5 = null;
            }
            bVar5.f442374j.setTag(R.id.x1r, this.adapter);
            vp1.b bVar6 = this.binding;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bVar = bVar6;
            }
            LinearLayout linearLayout = bVar.f442379o;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.thinkTipsLl");
            linearLayout.setOnClickListener(new d(linearLayout, this));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/aisearch/msgholder/AIMsgHolder$c", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "", "repeatedCount", "", "a", "", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.qqnt.aio.anisticker.drawable.g {
        c() {
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStart() {
            float f16;
            AIMsgHolder.this.inAnimation = true;
            vp1.b bVar = AIMsgHolder.this.binding;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar = null;
            }
            ViewPropertyAnimator animate = bVar.f442376l.animate();
            if (AIMsgHolder.this.isExpanded) {
                f16 = 180.0f;
            } else {
                f16 = 0.0f;
            }
            animate.rotation(f16).setDuration(300L).start();
            AIMsgHolder aIMsgHolder = AIMsgHolder.this;
            aIMsgHolder.isExpanded = true ^ aIMsgHolder.isExpanded;
            GuildSearchLLMChatPictureGenerator.b bVar2 = AIMsgHolder.this.adapter;
            a.AnswerItem answerItem = AIMsgHolder.this.answerItem;
            Intrinsics.checkNotNull(answerItem);
            bVar2.o0(answerItem.getMessageId(), AIMsgHolder.this.isExpanded);
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStop(boolean endAnimation) {
            AIMsgHolder.this.adapter.k0();
            AIMsgHolder.this.inAnimation = false;
            AIMsgHolder.this.H(true);
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void a(int repeatedCount) {
        }
    }
}
