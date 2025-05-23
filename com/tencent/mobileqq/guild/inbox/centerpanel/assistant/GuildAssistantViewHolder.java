package com.tencent.mobileqq.guild.inbox.centerpanel.assistant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeSubTitleData;
import com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b.\u0010/J\"\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001e\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co$d;", "jumpButtonList", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", UinConfigManager.KEY_ADS, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "guildNoticeJumpButton", "Landroid/widget/TextView;", "jumpButton", "t", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/a;", "subTitleData", "r", "Lkotlin/Function0;", NodeProps.ON_CLICK, "Landroid/text/style/ClickableSpan;", ReportConstant.COSTREPORT_PREFIX, "p", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/c;", "E", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/c;", "eventHandler", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mAvatar", "G", "Landroid/widget/TextView;", "mTitle", "H", "mNoticeTime", "I", "mSubTitle", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "jumpBtnContainer", "K", "jumpBtn1", "L", "jumpBtn2", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/c;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAssistantViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.inbox.centerpanel.assistant.c eventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ImageView mAvatar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TextView mTitle;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private TextView mNoticeTime;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TextView mSubTitle;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private LinearLayout jumpBtnContainer;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private TextView jumpBtn1;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private TextView jumpBtn2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantViewHolder$b", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/i;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", UinConfigManager.KEY_ADS, "Lcom/tencent/mobileqq/guild/inbox/centerpanel/a;", "subTitleData", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements i {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.assistant.i
        public void a(@NotNull co notice, @NotNull GuildNoticeSubTitleData subTitleData) {
            Intrinsics.checkNotNullParameter(notice, "notice");
            Intrinsics.checkNotNullParameter(subTitleData, "subTitleData");
            GuildAssistantViewHolder.this.r(notice, subTitleData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantViewHolder$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f226123d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildAssistantViewHolder f226124e;

        c(Function0<Unit> function0, GuildAssistantViewHolder guildAssistantViewHolder) {
            this.f226123d = function0;
            this.f226124e = guildAssistantViewHolder;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function0<Unit> function0 = this.f226123d;
            if (!o.c("fastClickGuard")) {
                function0.invoke();
            }
            VideoReport.reportEvent("clck", this.f226124e.itemView, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f226124e.mSubTitle.getContext().getColor(R.color.qui_common_text_link));
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAssistantViewHolder(@NotNull View itemView, @NotNull com.tencent.mobileqq.guild.inbox.centerpanel.assistant.c eventHandler) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
        View findViewById = itemView.findViewById(R.id.zst);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.notice_avatar)");
        this.mAvatar = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.h4o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.notice_title)");
        this.mTitle = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.zto);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.notice_time)");
        this.mNoticeTime = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.ztm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.notice_subtitle)");
        this.mSubTitle = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.ztf);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026otice_jump_btn_container)");
        this.jumpBtnContainer = (LinearLayout) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.ztd);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.notice_jump_btn_1)");
        this.jumpBtn1 = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.zte);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.notice_jump_btn_2)");
        this.jumpBtn2 = (TextView) findViewById7;
    }

    private final void q(List<? extends co.d> jumpButtonList, co notice) {
        boolean z16;
        List<? extends co.d> list = jumpButtonList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.jumpBtnContainer.setVisibility(8);
            Logger.f235387a.d().d("Guild.C2C.GuildAssistantViewHolder", 1, "[bindJumpButton] list is null or empty");
            return;
        }
        co.d dVar = jumpButtonList.get(0);
        if (dVar == null) {
            this.jumpBtnContainer.setVisibility(8);
            Logger.f235387a.d().d("Guild.C2C.GuildAssistantViewHolder", 1, "[bindJumpButton] jumpButton is null");
            return;
        }
        this.jumpBtnContainer.setVisibility(0);
        this.jumpBtn1.setVisibility(0);
        t(dVar, this.jumpBtn1, notice);
        if (jumpButtonList.size() > 1) {
            co.d dVar2 = jumpButtonList.get(1);
            if (dVar2 == null) {
                this.jumpBtn2.setVisibility(8);
                Logger.f235387a.d().d("Guild.C2C.GuildAssistantViewHolder", 1, "[bindJumpButton] jumpButton2 is null");
                return;
            } else {
                this.jumpBtn2.setVisibility(0);
                t(dVar2, this.jumpBtn2, notice);
                return;
            }
        }
        Logger.f235387a.d().d("Guild.C2C.GuildAssistantViewHolder", 1, "[bindJumpButton] jumpButton2 is null");
        this.jumpBtn2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(final co notice, final GuildNoticeSubTitleData subTitleData) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(subTitleData.getSubtitleContent());
        if (subTitleData.e()) {
            spannableStringBuilder.setSpan(s(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantViewHolder$dealSubTitleSpan$guildNameClickSpan$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    c cVar;
                    cVar = GuildAssistantViewHolder.this.eventHandler;
                    Function2<String, String, Unit> a16 = cVar.a();
                    String guildId = subTitleData.getGuildId();
                    String str = notice.f265896l;
                    Intrinsics.checkNotNullExpressionValue(str, "notice.joinSign");
                    a16.invoke(guildId, str);
                }
            }), subTitleData.getStartIndex(), subTitleData.getEndIndex(), 17);
        }
        List<co.c> list = notice.f265898n;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str = notice.f265898n.get(0).f265912b;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z17 = false;
                    if (!z17) {
                        ClickableSpan s16 = s(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantViewHolder$dealSubTitleSpan$webViewJumpTextClickSpan$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                c cVar;
                                cVar = GuildAssistantViewHolder.this.eventHandler;
                                Function2<String, String, Unit> b16 = cVar.b();
                                String str2 = notice.f265890f;
                                Intrinsics.checkNotNullExpressionValue(str2, "notice.guildId");
                                String str3 = notice.f265898n.get(0).f265912b;
                                Intrinsics.checkNotNullExpressionValue(str3, "notice.jumpLink[0].url");
                                b16.invoke(str2, str3);
                            }
                        });
                        Context context = this.mSubTitle.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "mSubTitle.context");
                        Drawable w3 = GuildUIUtils.w(context, R.drawable.guild_assistant_list_item_arrow, Integer.valueOf(R.color.qui_common_text_link));
                        if (w3 == null) {
                            w3 = this.itemView.getResources().getDrawable(R.drawable.guild_assistant_list_item_arrow);
                        }
                        Intrinsics.checkNotNull(w3);
                        w3.setBounds(QQGuildUIUtil.e(2.0f, this.itemView.getResources()), QQGuildUIUtil.e(-1.0f, this.itemView.getResources()), QQGuildUIUtil.e(8.0f, this.itemView.getResources()), QQGuildUIUtil.e(9.0f, this.itemView.getResources()));
                        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(w3);
                        spannableStringBuilder.append((CharSequence) (notice.f265898n.get(0).f265911a + " "));
                        spannableStringBuilder.setSpan(verticalCenterImageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                        spannableStringBuilder.setSpan(s16, (spannableStringBuilder.length() - notice.f265898n.get(0).f265911a.length()) - 1, spannableStringBuilder.length(), 17);
                    }
                }
            }
            z17 = true;
            if (!z17) {
            }
        }
        this.mSubTitle.setText(spannableStringBuilder);
        this.mSubTitle.setMovementMethod(a.INSTANCE.a());
        this.mSubTitle.setHighlightColor(0);
        VideoReport.setElementParam(this.itemView, "sgrp_channel_content", this.mSubTitle.getText().toString());
        VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
    }

    private final ClickableSpan s(Function0<Unit> onClick) {
        return new c(onClick, this);
    }

    private final void t(co.d guildNoticeJumpButton, TextView jumpButton, final co notice) {
        co.e eVar = guildNoticeJumpButton.f265916a;
        if (eVar != null) {
            jumpButton.setText(eVar.f265918a);
            if (2 == eVar.f265919b) {
                jumpButton.setBackgroundResource(R.drawable.guild_token_blue_button_bg);
                jumpButton.setTextColor(ContextCompat.getColor(jumpButton.getContext(), R.color.qui_button_text_primary_default));
            } else {
                jumpButton.setBackgroundResource(R.drawable.guild_token_button_border_disable);
                jumpButton.setTextColor(ContextCompat.getColorStateList(jumpButton.getContext(), R.color.bmo));
            }
        }
        co.g gVar = guildNoticeJumpButton.f265917b;
        if (gVar != null && 2 == gVar.f265921a) {
            jumpButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildAssistantViewHolder.u(GuildAssistantViewHolder.this, notice, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GuildAssistantViewHolder this$0, co notice, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(notice, "$notice");
        if (!o.c("fastClickGuard") && !TextUtils.isEmpty(notice.f265890f)) {
            Function2<String, String, Unit> a16 = this$0.eventHandler.a();
            String str = notice.f265890f;
            Intrinsics.checkNotNullExpressionValue(str, "notice.guildId");
            String str2 = notice.f265896l;
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "notice.joinSign ?: \"\"");
            }
            a16.invoke(str, str2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void p(@NotNull co notice) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        GuildNoticeUtils guildNoticeUtils = GuildNoticeUtils.f226106a;
        ImageView imageView = this.mAvatar;
        co.b bVar = notice.f265891g;
        String str = notice.f265890f;
        Intrinsics.checkNotNullExpressionValue(str, "notice.guildId");
        GuildNoticeUtils.k(guildNoticeUtils, imageView, bVar, str, null, 8, null);
        this.mTitle.setText(GuildNoticeUtils.i(notice));
        this.mNoticeTime.setText(en.p(notice.f265887c * 1000, true, "yy-MM-dd"));
        q(notice.f265904t, notice);
        ch.Y0(this.itemView, "em_sgrp_channelassitant_link", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        guildNoticeUtils.h(notice, new b());
    }
}
