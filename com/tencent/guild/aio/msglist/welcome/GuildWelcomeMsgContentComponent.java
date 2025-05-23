package com.tencent.guild.aio.msglist.welcome;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010 \u001a\u00020\t\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J&\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018H\u0016R\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001b\u00100\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010\u001f\u00a8\u00065"}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem;", "msgItem", "", "k1", "", "originText", "i1", "Landroid/view/View;", DTConstants.TAG.ELEMENT, "", ICustomDataEditor.NUMBER_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "contentView", "Landroid/widget/TextView;", "i", "Lkotlin/Lazy;", "m1", "()Landroid/widget/TextView;", "titleTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l1", "tipsTextView", BdhLogUtil.LogTag.Tag_Conn, "j1", "bottomLine", "<init>", "(Landroid/view/View;)V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWelcomeMsgContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tipsTextView;

    public GuildWelcomeMsgContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.contentView = new LinearLayout(root.getContext());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgContentComponent$titleTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(GuildWelcomeMsgContentComponent.this.getRoot().getContext());
                GuildWelcomeMsgContentComponent guildWelcomeMsgContentComponent = GuildWelcomeMsgContentComponent.this;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = guildWelcomeMsgContentComponent.getRoot().getResources().getDimensionPixelSize(R.dimen.c_z);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                textView.setTextSize(2, 26.0f);
                return textView;
            }
        });
        this.titleTextView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgContentComponent$tipsTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(GuildWelcomeMsgContentComponent.this.getRoot().getContext());
                GuildWelcomeMsgContentComponent guildWelcomeMsgContentComponent = GuildWelcomeMsgContentComponent.this;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = guildWelcomeMsgContentComponent.getRoot().getResources().getDimensionPixelOffset(R.dimen.c_v);
                layoutParams.bottomMargin = guildWelcomeMsgContentComponent.getRoot().getResources().getDimensionPixelOffset(R.dimen.c_v);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                textView.setTextSize(2, 14.0f);
                return textView;
            }
        });
        this.tipsTextView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgContentComponent$bottomLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(GuildWelcomeMsgContentComponent.this.getRoot().getContext());
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.guild.aio.util.c.b(1)));
                return view;
            }
        });
        this.bottomLine = lazy3;
    }

    private final CharSequence i1(String originText) {
        StringBuilder sb5 = new StringBuilder(originText);
        sb5.append("\u200b");
        return sb5;
    }

    private final View j1() {
        return (View) this.bottomLine.getValue();
    }

    private final CharSequence k1(GuildWelcomeMsgItem msgItem) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(msgItem.getChannelId());
        }
        if (iGProChannelInfo != null) {
            String operationTitle = iGProChannelInfo.getOperationTitle();
            if (operationTitle != null && operationTitle.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && iGProChannelInfo.getOperationType() == 1) {
                String operationTitle2 = iGProChannelInfo.getOperationTitle();
                Intrinsics.checkNotNullExpressionValue(operationTitle2, "channelInfo.operationTitle");
                return operationTitle2;
            }
        }
        return i1(msgItem.getTips().toString());
    }

    private final TextView l1() {
        return (TextView) this.tipsTextView.getValue();
    }

    private final TextView m1() {
        return (TextView) this.titleTextView.getValue();
    }

    private final void n1(View element) {
        VideoReport.setElementId(element, "em_sgrp_welcome_invite_word_link");
        VideoReport.setElementClickPolicy(element, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(element, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(element, EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        int i3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(msgItem instanceof GuildWelcomeMsgItem)) {
            QLog.e("GuildWelcomeMsgComponent", 1, "bind, msgItem = " + msgItem.getClass());
            return;
        }
        if (this.contentView.getChildCount() == 0) {
            this.contentView.setOrientation(1);
            this.contentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.contentView.addView(m1());
            this.contentView.addView(l1());
            this.contentView.addView(j1());
        }
        GuildWelcomeMsgItem guildWelcomeMsgItem = (GuildWelcomeMsgItem) msgItem;
        m1().setText(guildWelcomeMsgItem.getTitleText());
        l1().setText(k1(guildWelcomeMsgItem));
        l1().setMovementMethod(LinkMovementMethod.getInstance());
        l1().postInvalidate();
        n1(l1());
        View j16 = j1();
        if (guildWelcomeMsgItem.getShowBottomLine()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        j16.setVisibility(i3);
        if (j1().getVisibility() == 0) {
            j1().setBackgroundResource(R.drawable.qui_common_border_standard_bg);
        }
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        guildUIUtils.b(m1(), R.color.qui_common_text_primary);
        guildUIUtils.b(l1(), R.color.qui_common_text_secondary_light);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.contentView;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new c();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
