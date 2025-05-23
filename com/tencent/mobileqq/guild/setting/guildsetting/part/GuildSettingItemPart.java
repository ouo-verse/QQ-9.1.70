package com.tencent.mobileqq.guild.setting.guildsetting.part;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.folder.GuildFolderGuideDialogFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.chats.api.IGuildFolderGuideApi;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dm;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0014\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J8\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0%2\b\b\u0001\u0010\u001f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\rH\u0002R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingItemPart;", "Lcom/tencent/mobileqq/guild/setting/guildsetting/part/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "initData", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "D9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "", "res", "", "getString", "va", "sa", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/widget/listitem/a;", "ma", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "ha", "Ma", "guildInfo", "wa", "qa", "ta", "na", "ia", "left", "Landroid/view/View$OnClickListener;", "listener", "elementId", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "right", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "xa", "view", "ua", "e", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "quiListItemAdapter", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l;", "f", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l;", "viewModel", "Lvp1/dm;", tl.h.F, "Lvp1/dm;", "mManagerLayoutBinding", "i", "Ljava/lang/String;", "mOperationHelperUrl", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isNeedVerify", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingItemPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIListItemAdapter quiListItemAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private dm mManagerLayoutBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mOperationHelperUrl = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedVerify;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingItemPart$b", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.widget.listitem.u {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            TextView textView = new TextView(parent.getContext());
            Resources resources = GuildSettingItemPart.this.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, resources.getDimensionPixelOffset(R.dimen.dar)));
            textView.setGravity(17);
            textView.setTextColor(resources.getColorStateList(R.color.bu9));
            textView.setTextSize(2, 17.0f);
            textView.setText(GuildSettingItemPart.this.getString(R.string.f156041j5));
            return textView;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingItemPart$c", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends com.tencent.mobileqq.widget.listitem.u {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            Resources resources = GuildSettingItemPart.this.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, resources.getDimensionPixelOffset(R.dimen.f159638dl3)));
            TextView textView = new TextView(parent.getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setTextColor(resources.getColorStateList(R.color.qui_common_text_secondary));
            textView.setTextSize(1, 13.0f);
            textView.setText(GuildSettingItemPart.this.getString(R.string.f141420gm));
            ImageView imageView = new ImageView(GuildSettingItemPart.this.getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView.setImageResource(R.drawable.guild_token_report_icon);
            linearLayout.setGravity(17);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            return linearLayout;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingItemPart$d", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends com.tencent.mobileqq.widget.listitem.u {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new View(parent.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(GuildSettingItemPart this$0, String elementId, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.ua(view, elementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(GuildSettingItemPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        lVar.e2(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(GuildSettingItemPart this$0, CompoundButton compoundButton, boolean z16) {
        int i3;
        Map mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i16 = 2;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this$0.B9().y2(i3, this$0.x9(), null);
        ch.Y0(compoundButton, "em_sgrp_fold_switch", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        if (z16) {
            i16 = 1;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_switch_type", Integer.valueOf(i16)));
        VideoReport.reportEvent("dt_clck", compoundButton, mapOf);
        if (z16) {
            this$0.va();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(com.tencent.mobileqq.widget.listitem.x this_apply, View view) {
        int i3;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_fold_switch");
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        if (((x.c.f) this_apply.O()).getIsChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_switch_type", Integer.valueOf(i3)));
        ch.T0(view, "em_sgrp_fold_switch", clickPolicy, exposurePolicy, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(GuildSettingItemPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("https://qun.qq.com/guild/h5/guild-school/index.html?guildId=%s#/blackboard?tabIndex=0", Arrays.copyOf(new Object[]{this$0.getGuildId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        lVar.X1(it, format, false, true);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(GuildSettingItemPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        lVar.d2(it, String.valueOf(this$0.B9().r2().getValue()));
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(GuildSettingItemPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.ua(view, "em_sgrp_grpname");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(GuildSettingItemPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f02.a aVar = f02.a.f397498a;
        Intrinsics.checkNotNull(compoundButton);
        aVar.a(compoundButton, "em_sgrp_private_channel_push_switch", z16);
        this$0.B9().y2(z16 ? 1 : 0, this$0.x9(), null);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(IGProGuildInfo mGuildInfo) {
        Logger.f235387a.d().d("GuildSettingItemPart", 1, "[updateOperationAdUI] operatorRedPoint is null");
        wa(mGuildInfo);
        ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(IGProGuildInfo mGuildInfo) {
        boolean z16;
        String T = ch.T();
        Intrinsics.checkNotNullExpressionValue(T, "getOperationHelperUrl()");
        this.mOperationHelperUrl = T;
        dm dmVar = null;
        if (mGuildInfo.getUserType() != 0 && ch.o0()) {
            if (this.mOperationHelperUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                dm dmVar2 = this.mManagerLayoutBinding;
                if (dmVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                    dmVar2 = null;
                }
                dmVar2.f442947g.setVisibility(0);
                dm dmVar3 = this.mManagerLayoutBinding;
                if (dmVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                    dmVar3 = null;
                }
                dmVar3.f442952l.setVisibility(0);
                dm dmVar4 = this.mManagerLayoutBinding;
                if (dmVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                } else {
                    dmVar = dmVar4;
                }
                dmVar.f442942b.setBackgroundResource(R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector);
                return;
            }
        }
        dm dmVar5 = this.mManagerLayoutBinding;
        if (dmVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar5 = null;
        }
        dmVar5.f442952l.setVisibility(8);
        dm dmVar6 = this.mManagerLayoutBinding;
        if (dmVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar6 = null;
        }
        dmVar6.f442947g.setVisibility(8);
        dm dmVar7 = this.mManagerLayoutBinding;
        if (dmVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar7 = null;
        }
        dmVar7.f442947g.setClickable(false);
        dm dmVar8 = this.mManagerLayoutBinding;
        if (dmVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
        } else {
            dmVar = dmVar8;
        }
        dmVar.f442942b.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_round_8_bg_selector);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ia(QUIListItemAdapter adapter) {
        com.tencent.mobileqq.widget.listitem.a x16 = new b().w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.m
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSettingItemPart.ja(GuildSettingItemPart.this, view);
            }
        }).x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart.la(GuildSettingItemPart.this, view);
            }
        });
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        return x16.l(lifecycleOwner, adapter).f(B9().j2(), new Function1<IGProGuildInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$createExitGuildConfig$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable IGProGuildInfo iGProGuildInfo) {
                boolean z16 = false;
                if (iGProGuildInfo != null && iGProGuildInfo.getUserType() == 2) {
                    z16 = true;
                }
                return Boolean.valueOf(!z16);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(GuildSettingItemPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.ua(view, "em_sgrp_set_quit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(GuildSettingItemPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        lVar.b2(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ma(QUIListItemAdapter adapter) {
        GuildSettingItemPart$createOwnerConfig$1 guildSettingItemPart$createOwnerConfig$1 = new GuildSettingItemPart$createOwnerConfig$1(this);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        return guildSettingItemPart$createOwnerConfig$1.l(lifecycleOwner, adapter).e(B9().getGuildSettingPermissionViewModel().W1()).d();
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> na(QUIListItemAdapter adapter) {
        com.tencent.mobileqq.widget.listitem.a x16 = new c().w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.k
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSettingItemPart.oa(GuildSettingItemPart.this, view);
            }
        }).x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart.pa(GuildSettingItemPart.this, view);
            }
        });
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        return x16.l(lifecycleOwner, adapter).f(B9().j2(), new Function1<IGProGuildInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$createReportGuildConfig$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable IGProGuildInfo iGProGuildInfo) {
                boolean z16 = false;
                if (iGProGuildInfo != null && iGProGuildInfo.getUserType() == 2) {
                    z16 = true;
                }
                return Boolean.valueOf(!z16);
            }
        }).e(B9().getGuildSettingItemViewModel().d2()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(GuildSettingItemPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.ua(view, "em_sgrp_set_report");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(GuildSettingItemPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        lVar.g2(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        dm dmVar = this.mManagerLayoutBinding;
        dm dmVar2 = null;
        if (dmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar = null;
        }
        dmVar.f442944d.setVisibility(8);
        dm dmVar3 = this.mManagerLayoutBinding;
        if (dmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar3 = null;
        }
        dmVar3.f442945e.setVisibility(8);
        dm dmVar4 = this.mManagerLayoutBinding;
        if (dmVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
        } else {
            dmVar2 = dmVar4;
        }
        dmVar2.f442948h.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ta() {
        Map mapOf;
        dm dmVar = this.mManagerLayoutBinding;
        dm dmVar2 = null;
        if (dmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar = null;
        }
        RelativeLayout relativeLayout = dmVar.f442947g;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        dm dmVar3 = this.mManagerLayoutBinding;
        if (dmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
        } else {
            dmVar2 = dmVar3;
        }
        CharSequence text = dmVar2.f442945e.getText();
        if (text == null) {
            text = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_state", text));
        ch.T0(relativeLayout, "em_sgrp_operation_center", clickPolicy, exposurePolicy, mapOf);
    }

    private final void ua(View view, String elementId) {
        VideoReport.setElementReuseIdentifier(view, elementId);
        ch.Y0(view, elementId, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    private final void va() {
        FragmentManager childFragmentManager;
        GuildSettingFragment partHost = getPartHost();
        if (!(partHost instanceof Fragment)) {
            partHost = null;
        }
        if (partHost != null && (childFragmentManager = partHost.getChildFragmentManager()) != null) {
            GuildFolderGuideDialogFragment.INSTANCE.a(IGuildFolderGuideApi.SCENE_SETTING, getGuildId(), childFragmentManager, new GuildSettingItemPart$showGuildFolderGuideDialog$1(this));
        }
    }

    private final void wa(IGProGuildInfo guildInfo) {
        boolean z16;
        if (guildInfo.getUserType() != 2) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildSettingItemPart", 1, "[showRealNameAuthInfo] not guild owner");
            }
            qa();
            return;
        }
        Cdo I = ch.I();
        if (I == null) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildSettingItemPart", 1, "[showRealNameAuthInfo] faceAuthInfo is null");
            }
            qa();
            return;
        }
        if (1 == I.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isNeedVerify = z16;
        Logger.f235387a.d().d("GuildSettingItemPart", 1, "[showRealNameAuthInfo] isNeedVerify:" + this.isNeedVerify);
        if (this.isNeedVerify) {
            dm dmVar = this.mManagerLayoutBinding;
            RelativeLayout.LayoutParams layoutParams = null;
            if (dmVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar = null;
            }
            dmVar.f442944d.setVisibility(8);
            dm dmVar2 = this.mManagerLayoutBinding;
            if (dmVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar2 = null;
            }
            dmVar2.f442948h.setVisibility(8);
            dm dmVar3 = this.mManagerLayoutBinding;
            if (dmVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar3 = null;
            }
            dmVar3.f442945e.setVisibility(0);
            dm dmVar4 = this.mManagerLayoutBinding;
            if (dmVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar4 = null;
            }
            dmVar4.f442945e.setText("\u5b9e\u540d\u8ba4\u8bc1\u63d0\u5347\u4eba\u6570\u4e0a\u9650");
            dm dmVar5 = this.mManagerLayoutBinding;
            if (dmVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar5 = null;
            }
            Context context = dmVar5.f442945e.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mManagerLayoutBinding.guildOperationAdText.context");
            Drawable w3 = GuildUIUtils.w(context, R.drawable.qui_info_circle, Integer.valueOf(R.color.qui_common_icon_secondary));
            if (w3 != null) {
                w3.setBounds(0, 0, QQGuildUIUtil.f(19.0f), QQGuildUIUtil.f(19.0f));
            }
            dm dmVar6 = this.mManagerLayoutBinding;
            if (dmVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar6 = null;
            }
            dmVar6.f442945e.setCompoundDrawablePadding(QQGuildUIUtil.f(4.0f));
            dm dmVar7 = this.mManagerLayoutBinding;
            if (dmVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar7 = null;
            }
            dmVar7.f442945e.setCompoundDrawables(w3, null, null, null);
            dm dmVar8 = this.mManagerLayoutBinding;
            if (dmVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                dmVar8 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = dmVar8.f442945e.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            }
            if (layoutParams != null) {
                layoutParams.removeRule(17);
                return;
            }
            return;
        }
        qa();
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c> xa(@StringRes int left, View.OnClickListener listener, final String elementId, x.c right) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(getString(left)), right);
        xVar.x(listener);
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.j
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSettingItemPart.Aa(GuildSettingItemPart.this, elementId, view);
            }
        });
        return xVar;
    }

    static /* synthetic */ com.tencent.mobileqq.widget.listitem.x za(GuildSettingItemPart guildSettingItemPart, int i3, View.OnClickListener onClickListener, String str, x.c cVar, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            cVar = new x.c.g("", false, false, 6, null);
        }
        return guildSettingItemPart.xa(i3, onClickListener, str, cVar);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildsetting.part.a
    @NotNull
    public Group[] D9() {
        QUIListItemAdapter qUIListItemAdapter;
        final String selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        Group[] groupArr = new Group[7];
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        com.tencent.mobileqq.widget.listitem.x za5 = za(this, R.string.f156311jv, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart.Ba(GuildSettingItemPart.this, view);
            }
        }, "em_sgrp_notice_box", null, 8, null);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter2 = this.quiListItemAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter2 = null;
        }
        aVarArr[0] = za5.l(lifecycleOwner, qUIListItemAdapter2).d();
        groupArr[0] = new Group(aVarArr);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = new com.tencent.mobileqq.widget.listitem.a[3];
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f156301ju)), new x.c.a("", "", false, false, 12, null));
        xVar.R(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$submitPartGroups$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                com.tencent.mobileqq.guild.u.n(GuildSettingItemPart.this.getGuildId(), selfTinyId, "", 3, imageView);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart.Ga(GuildSettingItemPart.this, view);
            }
        });
        LiveData<String> r26 = B9().r2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$submitPartGroups$2$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter qUIListItemAdapter3;
                x.c.a O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                xVar.O().j(it);
                qUIListItemAdapter3 = this.quiListItemAdapter;
                if (qUIListItemAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                    qUIListItemAdapter3 = null;
                }
                qUIListItemAdapter3.l0(xVar);
            }
        };
        r26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart.Ha(Function1.this, obj);
            }
        });
        LiveData<String> q26 = B9().q2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$submitPartGroups$2$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter qUIListItemAdapter3;
                x.c.a O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.j(it);
                qUIListItemAdapter3 = this.quiListItemAdapter;
                if (qUIListItemAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                    qUIListItemAdapter3 = null;
                }
                qUIListItemAdapter3.l0(xVar);
            }
        };
        q26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart.Ia(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.widget.listitem.a<com.tencent.mobileqq.widget.listitem.ac<V>> w3 = xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.t
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSettingItemPart.Ja(GuildSettingItemPart.this, view);
            }
        });
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "partHost.hostLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter3 = this.quiListItemAdapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter3 = null;
        }
        aVarArr2[0] = w3.l(lifecycleOwner4, qUIListItemAdapter3).d();
        final com.tencent.mobileqq.widget.listitem.x xVar2 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f15050156)), new x.c.f(true, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildSettingItemPart.Ka(GuildSettingItemPart.this, compoundButton, z16);
            }
        }));
        LiveData<Integer> p26 = B9().p2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$submitPartGroups$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QUIListItemAdapter qUIListItemAdapter4;
                xVar2.O().f(num == null || num.intValue() != 0);
                qUIListItemAdapter4 = this.quiListItemAdapter;
                if (qUIListItemAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                    qUIListItemAdapter4 = null;
                }
                qUIListItemAdapter4.l0(xVar2);
            }
        };
        p26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart.La(Function1.this, obj);
            }
        });
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner6, "partHost.hostLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter4 = this.quiListItemAdapter;
        if (qUIListItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter4 = null;
        }
        aVarArr2[1] = xVar2.l(lifecycleOwner6, qUIListItemAdapter4).d();
        String string = getContext().getString(R.string.f145900sq);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_fold_the_guild)");
        final com.tencent.mobileqq.widget.listitem.x xVar3 = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(string, R.drawable.qui_list_symbol), new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildSettingItemPart.Ca(GuildSettingItemPart.this, compoundButton, z16);
            }
        }));
        LiveData<Integer> p27 = B9().p2();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$submitPartGroups$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QUIListItemAdapter qUIListItemAdapter5;
                QUIListItemAdapter qUIListItemAdapter6;
                qUIListItemAdapter5 = GuildSettingItemPart.this.quiListItemAdapter;
                QUIListItemAdapter qUIListItemAdapter7 = null;
                if (qUIListItemAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                    qUIListItemAdapter5 = null;
                }
                boolean z16 = false;
                qUIListItemAdapter5.m0(xVar3, num == null || num.intValue() != 0);
                x.c.f O = xVar3.O();
                if (num != null && num.intValue() == 2) {
                    z16 = true;
                }
                O.f(z16);
                qUIListItemAdapter6 = GuildSettingItemPart.this.quiListItemAdapter;
                if (qUIListItemAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                } else {
                    qUIListItemAdapter7 = qUIListItemAdapter6;
                }
                qUIListItemAdapter7.l0(xVar3);
            }
        };
        p27.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart.Da(Function1.this, obj);
            }
        });
        xVar3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSettingItemPart.Ea(com.tencent.mobileqq.widget.listitem.x.this, view);
            }
        });
        LifecycleOwner lifecycleOwner8 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner8, "partHost.hostLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter5 = this.quiListItemAdapter;
        if (qUIListItemAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter5 = null;
        }
        aVarArr2[2] = xVar3.l(lifecycleOwner8, qUIListItemAdapter5).d();
        groupArr[1] = new Group(aVarArr2);
        Group.Companion companion = Group.INSTANCE;
        com.tencent.mobileqq.widget.listitem.a<?>[] aVarArr3 = new com.tencent.mobileqq.widget.listitem.a[1];
        QUIListItemAdapter qUIListItemAdapter6 = this.quiListItemAdapter;
        if (qUIListItemAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter6 = null;
        }
        aVarArr3[0] = ma(qUIListItemAdapter6);
        groupArr[2] = companion.d(aVarArr3);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr4 = new com.tencent.mobileqq.widget.listitem.a[1];
        com.tencent.mobileqq.widget.listitem.x za6 = za(this, R.string.f156011j2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart.Fa(GuildSettingItemPart.this, view);
            }
        }, "em_sgrp_databorad", null, 8, null);
        LifecycleOwner lifecycleOwner9 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner9, "partHost.hostLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter7 = this.quiListItemAdapter;
        if (qUIListItemAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter7 = null;
        }
        aVarArr4[0] = za6.l(lifecycleOwner9, qUIListItemAdapter7).e(B9().getGuildSettingPermissionViewModel().U1()).d();
        groupArr[3] = new Group(aVarArr4);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr5 = new com.tencent.mobileqq.widget.listitem.a[1];
        QUIListItemAdapter qUIListItemAdapter8 = this.quiListItemAdapter;
        if (qUIListItemAdapter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter8 = null;
        }
        aVarArr5[0] = ia(qUIListItemAdapter8);
        groupArr[4] = new Group(aVarArr5);
        com.tencent.mobileqq.widget.listitem.a<?>[] aVarArr6 = new com.tencent.mobileqq.widget.listitem.a[1];
        QUIListItemAdapter qUIListItemAdapter9 = this.quiListItemAdapter;
        if (qUIListItemAdapter9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter = null;
        } else {
            qUIListItemAdapter = qUIListItemAdapter9;
        }
        aVarArr6[0] = na(qUIListItemAdapter);
        groupArr[5] = companion.d(aVarArr6);
        groupArr[6] = companion.d(new d());
        return groupArr;
    }

    @NotNull
    public final String getString(@StringRes int res) {
        if (res == 0) {
            return "";
        }
        String string = getContext().getResources().getString(res);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(res)");
        return string;
    }

    public final void initData() {
        LiveData<IGProGuildInfo> j26 = B9().j2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar;
                lVar = GuildSettingItemPart.this.viewModel;
                if (lVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    lVar = null;
                }
                lVar.i2(iGProGuildInfo);
            }
        };
        j26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart.ra(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.viewModel = com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l.INSTANCE.a(getPartHost(), getGuildId(), x9());
        if (z9() == null) {
            return;
        }
        QUIListItemAdapter z95 = z9();
        Intrinsics.checkNotNull(z95);
        this.quiListItemAdapter = z95;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
    }
}
