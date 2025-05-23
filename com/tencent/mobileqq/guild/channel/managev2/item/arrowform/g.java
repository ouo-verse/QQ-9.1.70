package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/g;", "Lcom/tencent/mobileqq/guild/channel/managev2/a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "e1", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingUIState;", "state", "", "f1", "e", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "viewModel", "", "f", "I", "titleRes", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "type", "i", "Ljava/lang/Integer;", "tipRes", "Lvp1/z;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvp1/z;", "binding", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/x;", "viewConfig", "<init>", "(Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;ILcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;Ljava/lang/Integer;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g extends com.tencent.mobileqq.guild.channel.managev2.a {

    /* renamed from: C, reason: from kotlin metadata */
    private x<x.b, x.c> viewConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelSettingBaseVM viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int titleRes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIListItemBackgroundType type;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer tipRes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private z binding;

    public /* synthetic */ g(ChannelSettingBaseVM channelSettingBaseVM, int i3, QUIListItemBackgroundType qUIListItemBackgroundType, Integer num, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(channelSettingBaseVM, i3, (i16 & 4) != 0 ? QUIListItemBackgroundType.AllRound : qUIListItemBackgroundType, (i16 & 8) != 0 ? null : num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.mnr.ChannelSettingBaseVB", 1, "click " + HardCodeUtil.qqStr(this$0.titleRes));
        }
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            z zVar = this$0.binding;
            if (zVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                zVar = null;
            }
            LinearLayout root = zVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this$0.sendIntent(new b.C7685b(root));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: from getter and merged with bridge method [inline-methods] */
    public ChannelSettingBaseVM createVM() {
        return this.viewModel;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ChannelSettingUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        x<x.b, x.c> xVar = this.viewConfig;
        x<x.b, x.c> xVar2 = null;
        x<x.b, x.c> xVar3 = null;
        z zVar = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            xVar = null;
        }
        x.c O = xVar.O();
        Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text");
        x.c.g gVar = (x.c.g) O;
        if (state instanceof ChannelSettingUIState.SettingItemDescUIState) {
            gVar.h(((ChannelSettingUIState.SettingItemDescUIState) state).getDesc());
            z zVar2 = this.binding;
            if (zVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                zVar2 = null;
            }
            QUISingleLineListItem qUISingleLineListItem = zVar2.f443147c;
            x<x.b, x.c> xVar4 = this.viewConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            } else {
                xVar3 = xVar4;
            }
            qUISingleLineListItem.setConfig(xVar3);
            return;
        }
        if (state instanceof ChannelSettingUIState.SettingItemEnableUIState) {
            z zVar3 = this.binding;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                zVar = zVar3;
            }
            QUISingleLineListItem qUISingleLineListItem2 = zVar.f443147c;
            Intrinsics.checkNotNullExpressionValue(qUISingleLineListItem2, "binding.singleLineItem");
            b1(qUISingleLineListItem2, ((ChannelSettingUIState.SettingItemEnableUIState) state).getEnableModify());
            return;
        }
        if (state instanceof ChannelSettingUIState.SettingItemRedDotUIState) {
            gVar.g(((ChannelSettingUIState.SettingItemRedDotUIState) state).getIsShow());
            z zVar4 = this.binding;
            if (zVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                zVar4 = null;
            }
            QUISingleLineListItem qUISingleLineListItem3 = zVar4.f443147c;
            x<x.b, x.c> xVar5 = this.viewConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            } else {
                xVar2 = xVar5;
            }
            qUISingleLineListItem3.setConfig(xVar2);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        boolean z16;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        z g16 = z.g(LayoutInflater.from(createViewParams.a()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026reateViewParams.context))");
        this.binding = g16;
        z zVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        TextView textView = g16.f443146b;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.settingTips");
        int i3 = 0;
        if (this.tipRes != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        Integer num = this.tipRes;
        if (num != null) {
            num.intValue();
            z zVar2 = this.binding;
            if (zVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                zVar2 = null;
            }
            zVar2.f443146b.setText(HardCodeUtil.qqStr(this.tipRes.intValue()));
        }
        String qqStr = HardCodeUtil.qqStr(this.titleRes);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(titleRes)");
        this.viewConfig = new x<>(new x.b.d(qqStr), new x.c.g("", true, false, 4, null));
        z zVar3 = this.binding;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar3 = null;
        }
        QUISingleLineListItem qUISingleLineListItem = zVar3.f443147c;
        x<x.b, x.c> xVar = this.viewConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            xVar = null;
        }
        qUISingleLineListItem.setConfig(xVar);
        z zVar4 = this.binding;
        if (zVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar4 = null;
        }
        zVar4.f443147c.setStyle(QUIListItemStyle.Card);
        z zVar5 = this.binding;
        if (zVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar5 = null;
        }
        zVar5.f443147c.setBackgroundType(this.type);
        z zVar6 = this.binding;
        if (zVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar6 = null;
        }
        zVar6.f443147c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.arrowform.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.g1(g.this, view);
            }
        });
        z zVar7 = this.binding;
        if (zVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            zVar = zVar7;
        }
        LinearLayout root = zVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public g(@NotNull ChannelSettingBaseVM viewModel, int i3, @NotNull QUIListItemBackgroundType type, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(type, "type");
        this.viewModel = viewModel;
        this.titleRes = i3;
        this.type = type;
        this.tipRes = num;
    }
}
