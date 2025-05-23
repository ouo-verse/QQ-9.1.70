package com.tencent.mobileqq.guild.setting.guildsetting.part;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dl;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0004R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingHeadInfoPart;", "Lcom/tencent/mobileqq/guild/setting/guildsetting/part/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "Z9", "", "isCanModifyGuildInfo", "U9", "aa", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "", "name", "ea", "Landroid/view/View;", "view", "elementId", "ba", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "D9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "initData", "e", "Landroid/view/View;", "guildInfoRootView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "guildIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "guildName", "i", "guildStrNumber", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "guildQrcodeImg", BdhLogUtil.LogTag.Tag_Conn, "guildInfoArrow", "Landroidx/constraintlayout/widget/ConstraintLayout;", "D", "Landroidx/constraintlayout/widget/ConstraintLayout;", "guildInfoContainer", "E", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "da", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "Lcom/tencent/mobileqq/widget/listitem/u;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/u;", "T9", "()Lcom/tencent/mobileqq/widget/listitem/u;", "ca", "(Lcom/tencent/mobileqq/widget/listitem/u;)V", "config2", "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingHeadInfoPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView guildInfoArrow;

    /* renamed from: D, reason: from kotlin metadata */
    private ConstraintLayout guildInfoContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: F, reason: from kotlin metadata */
    public com.tencent.mobileqq.widget.listitem.u config2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View guildInfoRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView guildIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView guildName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView guildStrNumber;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView guildQrcodeImg;

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingHeadInfoPart$b", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "view", "", "position", "", "", "payloads", "", UserInfo.SEX_FEMALE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.widget.listitem.u {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        public void F(@NotNull View view, int position, @NotNull List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            GuildSettingHeadInfoPart.this.initData();
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            dl g16 = dl.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026  false\n                )");
            GuildSettingHeadInfoPart guildSettingHeadInfoPart = GuildSettingHeadInfoPart.this;
            ConstraintLayout root = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            guildSettingHeadInfoPart.guildInfoRootView = root;
            GuildSettingHeadInfoPart guildSettingHeadInfoPart2 = GuildSettingHeadInfoPart.this;
            ImageView imageView = g16.f442934b;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildIconHead");
            guildSettingHeadInfoPart2.guildIcon = imageView;
            GuildSettingHeadInfoPart guildSettingHeadInfoPart3 = GuildSettingHeadInfoPart.this;
            TextView textView = g16.f442938f;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildName");
            guildSettingHeadInfoPart3.guildName = textView;
            GuildSettingHeadInfoPart guildSettingHeadInfoPart4 = GuildSettingHeadInfoPart.this;
            TextView textView2 = g16.f442940h;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.guildStrNumber");
            guildSettingHeadInfoPart4.guildStrNumber = textView2;
            GuildSettingHeadInfoPart guildSettingHeadInfoPart5 = GuildSettingHeadInfoPart.this;
            ImageView imageView2 = g16.f442939g;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.guildQrcodeImg");
            guildSettingHeadInfoPart5.guildQrcodeImg = imageView2;
            GuildSettingHeadInfoPart guildSettingHeadInfoPart6 = GuildSettingHeadInfoPart.this;
            ImageView imageView3 = g16.f442936d;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.guildInfoArrow");
            guildSettingHeadInfoPart6.guildInfoArrow = imageView3;
            GuildSettingHeadInfoPart guildSettingHeadInfoPart7 = GuildSettingHeadInfoPart.this;
            ConstraintLayout constraintLayout = g16.f442937e;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.guildInfoContainer");
            guildSettingHeadInfoPart7.guildInfoContainer = constraintLayout;
            ConstraintLayout root2 = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            return root2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(final boolean isCanModifyGuildInfo) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingHeadInfoPart$guildInfoClick$onClick$1
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
                GuildSettingHeadInfoPart.this.aa(isCanModifyGuildInfo);
            }
        };
        ConstraintLayout constraintLayout = this.guildInfoContainer;
        TextView textView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoContainer");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new com.tencent.mobileqq.guild.base.extension.l(constraintLayout, function0));
        TextView textView2 = this.guildName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView2 = null;
        }
        textView2.setOnClickListener(new com.tencent.mobileqq.guild.base.extension.l(textView2, function0));
        TextView textView3 = this.guildStrNumber;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStrNumber");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new com.tencent.mobileqq.guild.base.extension.l(textView, function0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(GuildSettingHeadInfoPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQGuildUIUtil.v()) {
            GuildSettingQRCodeFragment.Companion companion = GuildSettingQRCodeFragment.INSTANCE;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.a(context, this$0.getGuildId());
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.ba(it, "em_sgrp_channel_code_qr");
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y9(GuildSettingHeadInfoPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGProGuildInfo iGProGuildInfo = this$0.guildInfo;
        if (iGProGuildInfo != null) {
            String guildNumber = iGProGuildInfo.getGuildNumber();
            Intrinsics.checkNotNullExpressionValue(guildNumber, "it.guildNumber");
            com.tencent.mobileqq.guild.util.b.a(guildNumber);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(IGProGuildInfo guildInfo) {
        TextView textView = this.guildName;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        textView.setText(guildInfo.getGuildName());
        TextView textView2 = this.guildStrNumber;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStrNumber");
            textView2 = null;
        }
        textView2.setText("\u9891\u9053\u53f7\uff1a" + guildInfo.getGuildNumber());
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        Intrinsics.checkNotNullExpressionValue(medalInfoList, "guildInfo.medalInfoList");
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        ea(medalInfoList, guildName);
        String avatarUrl = guildInfo.getAvatarUrl(140);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_140)");
        if (TextUtils.isEmpty(avatarUrl)) {
            ImageView imageView2 = this.guildIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.guildIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        Drawable J = ch.J(avatarUrl, Utils.n(49.0f, getContext().getResources()), BaseImageUtil.getDefaultFaceDrawable(false), false);
        ImageView imageView4 = this.guildIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
        } else {
            imageView = imageView4;
        }
        imageView.setImageDrawable(J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(boolean isCanModifyGuildInfo) {
        ConstraintLayout constraintLayout = null;
        if (isCanModifyGuildInfo) {
            GuildProfileFragment.Companion companion = GuildProfileFragment.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.a(context, getGuildId());
            ConstraintLayout constraintLayout2 = this.guildInfoContainer;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfoContainer");
            } else {
                constraintLayout = constraintLayout2;
            }
            ba(constraintLayout, "em_sgrp_channel_set_channel_profile");
            return;
        }
        GuildInfoFragment.INSTANCE.a(x9(), A9());
        ConstraintLayout constraintLayout3 = this.guildInfoContainer;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoContainer");
        } else {
            constraintLayout = constraintLayout3;
        }
        ba(constraintLayout, "em_sgrp_channel_set_channel_profile");
    }

    private final void ba(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, null);
    }

    private final void ea(List<? extends IGProMedalInfo> medalInfoList, final String name) {
        final List<IGProMedalInfo> s16 = GuildMedalUtils.s(new ArrayList(medalInfoList), medalInfoList.size());
        if (s16.isEmpty()) {
            return;
        }
        TextView textView = this.guildName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        textView.setText(name);
        TextView textView3 = this.guildName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
        } else {
            textView2 = textView3;
        }
        textView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildSettingHeadInfoPart.ga(name, s16, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(String name, List validMediaList, GuildSettingHeadInfoPart this$0) {
        TextView textView;
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(validMediaList, "$validMediaList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
        TextView textView2 = this$0.guildName;
        TextView textView3 = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        } else {
            textView = textView2;
        }
        GuildMedalUtils.w(guildMedalUtils, name, validMediaList, textView, null, 0, null, 56, null);
        TextView textView4 = this$0.guildName;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
        } else {
            textView3 = textView4;
        }
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.tencent.mobileqq.guild.setting.guildsetting.part.a
    @NotNull
    public Group[] D9() {
        return new Group[]{Group.INSTANCE.d(T9())};
    }

    @NotNull
    public final com.tencent.mobileqq.widget.listitem.u T9() {
        com.tencent.mobileqq.widget.listitem.u uVar = this.config2;
        if (uVar != null) {
            return uVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config2");
        return null;
    }

    public final void ca(@NotNull com.tencent.mobileqq.widget.listitem.u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<set-?>");
        this.config2 = uVar;
    }

    public final void da(@Nullable IGProGuildInfo iGProGuildInfo) {
        this.guildInfo = iGProGuildInfo;
    }

    public final void initData() {
        LiveData<IGProGuildInfo> j26 = B9().j2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingHeadInfoPart$initData$1
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
                GuildSettingHeadInfoPart.this.da(iGProGuildInfo);
                if (iGProGuildInfo != null) {
                    GuildSettingHeadInfoPart.this.Z9(iGProGuildInfo);
                }
            }
        };
        j26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingHeadInfoPart.V9(Function1.this, obj);
            }
        });
        LiveData<Boolean> T1 = B9().getGuildSettingPermissionViewModel().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingHeadInfoPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isCanModify) {
                GuildSettingHeadInfoPart guildSettingHeadInfoPart = GuildSettingHeadInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(isCanModify, "isCanModify");
                guildSettingHeadInfoPart.U9(isCanModify.booleanValue());
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingHeadInfoPart.W9(Function1.this, obj);
            }
        });
        ImageView imageView = this.guildQrcodeImg;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrcodeImg");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingHeadInfoPart.X9(GuildSettingHeadInfoPart.this, view);
            }
        });
        TextView textView2 = this.guildStrNumber;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStrNumber");
        } else {
            textView = textView2;
        }
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean Y9;
                Y9 = GuildSettingHeadInfoPart.Y9(GuildSettingHeadInfoPart.this, view);
                return Y9;
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ca(new b());
    }
}
