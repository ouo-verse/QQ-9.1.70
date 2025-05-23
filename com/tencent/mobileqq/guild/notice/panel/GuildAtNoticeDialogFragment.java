package com.tencent.mobileqq.guild.notice.panel;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.notice.panel.GuildAtNoticeDialogFragment;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSendNoticeRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.ei;
import com.tencent.mobileqq.qqguildsdk.data.genc.j;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import ie0.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ed;
import yu1.SelectRoleData;
import yu1.SelectRoleStyle;
import yu1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J$\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010/R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00105\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/notice/panel/GuildAtNoticeDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "uh", "", "initView", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "roles", "yh", "sh", "", "limit", "Ch", "Ah", "Bh", "pageIn", "xh", "Landroid/view/View;", "view", "isAtAll", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGuildId", "D", "mChannelId", "", "E", "Ljava/lang/Long;", "mLiveRoomId", "Lkotlin/Pair;", "", UserInfo.SEX_FEMALE, "Lkotlin/Pair;", "mAtCount", "G", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mAtCountView", "I", "mNewGuideView", "Landroid/widget/ImageButton;", "J", "Landroid/widget/ImageButton;", "mNewGuideCloseBtn", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "mNewGuidePicView", "L", "mSelectRoleLayout", "Lyu1/h;", "M", "Lyu1/h;", "mSelectRoleVB", "N", "mWindowHeight", "<init>", "()V", "P", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAtNoticeDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private String mGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    private String mChannelId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Long mLiveRoomId;

    /* renamed from: F, reason: from kotlin metadata */
    private Pair<Integer, Integer> mAtCount;

    /* renamed from: G, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mAtCountView;

    /* renamed from: I, reason: from kotlin metadata */
    private View mNewGuideView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageButton mNewGuideCloseBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView mNewGuidePicView;

    /* renamed from: L, reason: from kotlin metadata */
    private View mSelectRoleLayout;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final h mSelectRoleVB = new h();

    /* renamed from: N, reason: from kotlin metadata */
    private int mWindowHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/notice/panel/GuildAtNoticeDialogFragment$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends BottomSheetBehavior.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<View> f230920b;

        b(BottomSheetBehavior<View> bottomSheetBehavior) {
            this.f230920b = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                this.f230920b.setState(5);
            }
        }
    }

    private final void Ah() {
        View view = this.mRootView;
        ViewGroup viewGroup = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
    }

    private final void Bh() {
        boolean z16;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_summoned_panel");
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        VideoReport.setPageParams(view3, "sgrp_channel_id", str);
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        String str2 = this.mChannelId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelId");
            str2 = null;
        }
        VideoReport.setPageParams(view4, "sgrp_sub_channel_id", str2);
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        Pair<Integer, Integer> pair = this.mAtCount;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtCount");
            pair = null;
        }
        VideoReport.setPageParams(view5, "sgrp_surplus_num", pair.getFirst());
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        String str3 = this.mGuildId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str3 = null;
        }
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str3);
        if (guildInfo != null) {
            int i3 = 1;
            if (guildInfo.getUserType() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = 2;
            }
            View view6 = this.mRootView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view6 = null;
            }
            VideoReport.setPageParams(view6, "sgrp_user_type", Integer.valueOf(i3));
        }
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view7;
        }
        VideoReport.setPageReportPolicy(view2, PageReportPolicy.REPORT_NONE);
    }

    private final void Ch(float limit) {
        View view = this.mSelectRoleLayout;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleLayout");
            view = null;
        }
        if (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            View view3 = this.mSelectRoleLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectRoleLayout");
            } else {
                view2 = view3;
            }
            view2.getLayoutParams().height = this.mWindowHeight - ViewUtils.dpToPx(limit);
        }
    }

    private final void initView() {
        View view;
        String str;
        View view2 = this.mRootView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        a f16 = a.f();
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        view2.setBackgroundColor(f16.g(view4.getContext(), R.color.qui_common_bg_middle_light, 1001));
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById = view5.findViewById(R.id.zpx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.new_guide_view)");
        this.mNewGuideView = findViewById;
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        View findViewById2 = view6.findViewById(R.id.zpv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.new_guide_close_btn)");
        this.mNewGuideCloseBtn = (ImageButton) findViewById2;
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        View findViewById3 = view7.findViewById(R.id.zpw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.new_guide_img)");
        this.mNewGuidePicView = (ImageView) findViewById3;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable("https://downv6.qq.com/innovate/guild/cover_info/guild_at_notice_new_guide.png", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(NEW_GUIDE_PIC_URL, options)");
        ImageView imageView = this.mNewGuidePicView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewGuidePicView");
            imageView = null;
        }
        imageView.setImageDrawable(drawable2);
        View view8 = this.mRootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view8 = null;
        }
        View findViewById4 = view8.findViewById(R.id.i6q);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.remain_count)");
        TextView textView = (TextView) findViewById4;
        this.mAtCountView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtCountView");
            textView = null;
        }
        View view9 = this.mRootView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view9 = null;
        }
        Context context = view9.getContext();
        Object[] objArr = new Object[2];
        Pair<Integer, Integer> pair = this.mAtCount;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtCount");
            pair = null;
        }
        objArr[0] = pair.getFirst();
        Pair<Integer, Integer> pair2 = this.mAtCount;
        if (pair2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtCount");
            pair2 = null;
        }
        objArr[1] = pair2.getSecond();
        textView.setText(context.getString(R.string.f139850cd, objArr));
        View view10 = this.mRootView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view10 = null;
        }
        View findViewById5 = view10.findViewById(R.id.f778845k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.role_select_layout)");
        this.mSelectRoleLayout = findViewById5;
        h hVar = this.mSelectRoleVB;
        View view11 = this.mRootView;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        } else {
            view = view11;
        }
        String str2 = this.mGuildId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        } else {
            str = str2;
        }
        String str3 = this.mChannelId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelId");
            str3 = null;
        }
        h.j(hVar, view, str, this, new SelectRoleData(str3, null, null, new SelectRoleStyle("#FFDEDFD0", -16777216, null)), 0, 16, null);
        this.mSelectRoleVB.k();
        View view12 = this.mRootView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view3 = view12;
        }
        QUIButton qUIButton = (QUIButton) view3.findViewById(R.id.send_btn);
        qUIButton.setThemeId(1001);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: yu1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view13) {
                GuildAtNoticeDialogFragment.vh(GuildAtNoticeDialogFragment.this, view13);
            }
        });
    }

    private final void sh() {
        View view = null;
        if (!bw.t0()) {
            View view2 = this.mNewGuideView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewGuideView");
                view2 = null;
            }
            view2.setVisibility(0);
            ImageButton imageButton = this.mNewGuideCloseBtn;
            if (imageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewGuideCloseBtn");
            } else {
                view = imageButton;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: yu1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    GuildAtNoticeDialogFragment.th(GuildAtNoticeDialogFragment.this, view3);
                }
            });
            return;
        }
        View view3 = this.mNewGuideView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewGuideView");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(GuildAtNoticeDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.mNewGuideView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNewGuideView");
            view2 = null;
        }
        view2.setVisibility(8);
        bw.g1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean uh() {
        String str;
        String str2;
        int i3;
        Bundle arguments = getArguments();
        Long l3 = null;
        if (arguments != null) {
            str = arguments.getString(IGuildFeedConfigAPi.PARAM_GUILD_ID);
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString(IGuildFeedConfigAPi.PARAM_CHANNEL_ID);
        } else {
            str2 = null;
        }
        int i16 = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNull(str);
            this.mGuildId = str;
            Intrinsics.checkNotNull(str2);
            this.mChannelId = str2;
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                l3 = Long.valueOf(arguments3.getLong("PARAM_LIVE_ROOM_ID"));
            }
            if (l3 == null || l3.longValue() != 0) {
                this.mLiveRoomId = l3;
            }
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                i3 = arguments4.getInt("PARAM_AT_REMAIN_COUNT");
            } else {
                i3 = 0;
            }
            Bundle arguments5 = getArguments();
            if (arguments5 != null) {
                i16 = arguments5.getInt("PARAM_AT_MAX_COUNT");
            }
            this.mAtCount = new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
            return true;
        }
        QLog.e("GuildAtNoticeDialogFragment", 1, "initData guildId or channelId is null!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(GuildAtNoticeDialogFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            String str = null;
            if (this$0.mSelectRoleVB.h()) {
                String str2 = this$0.mChannelId;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelId");
                    str2 = null;
                }
                String str3 = this$0.mGuildId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                    str3 = null;
                }
                QLog.i("GuildAtNoticeDialogFragment", 1, "sendAtAllNotice channelId: " + str2 + ", guildId: " + str3 + ", liveRoomId: " + this$0.mLiveRoomId);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.wh(it, true, null);
                this$0.yh(null);
            } else {
                ArrayList<RoleGroupModel> c16 = this$0.mSelectRoleVB.c();
                String str4 = this$0.mChannelId;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelId");
                    str4 = null;
                }
                String str5 = this$0.mGuildId;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                } else {
                    str = str5;
                }
                QLog.i("GuildAtNoticeDialogFragment", 1, "sendAtRoleNotice channelId: " + str4 + ", guildId: " + str + ", liveRoomId: " + this$0.mLiveRoomId + ", selected size: " + c16.size());
                if (c16.isEmpty()) {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.f157491n2, 0).show();
                } else {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this$0.wh(it, false, c16);
                    this$0.yh(c16);
                }
            }
        } catch (Exception e16) {
            QLog.e("GuildAtNoticeDialogFragment", 1, "sendSummonMsg e: " + e16.getMessage());
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void wh(View view, boolean isAtAll, List<RoleGroupModel> roles) {
        int i3;
        HashMap hashMapOf;
        boolean z16;
        if (isAtAll) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        StringBuilder sb5 = new StringBuilder();
        if (!isAtAll) {
            List<RoleGroupModel> list = roles;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                int size = roles.size();
                for (int i16 = 0; i16 < size; i16++) {
                    sb5.append(roles.get(i16).getId());
                    if (i16 < roles.size() - 1) {
                        sb5.append(",");
                    }
                }
            }
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_notice_range", Integer.valueOf(i3)), TuplesKt.to("sgrp_identity_group_id", sb5.toString()));
        ChannelSettingUtils.i(view, "em_sgrp_send", hashMapOf);
    }

    private final void xh(boolean pageIn) {
        View view = null;
        if (pageIn) {
            View view2 = this.mRootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view2;
            }
            VideoReport.reportPgIn(view);
            return;
        }
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view3;
        }
        VideoReport.reportPgOut(view);
    }

    private final void yh(List<RoleGroupModel> roles) {
        int i3;
        ei eiVar = new ei();
        String str = this.mGuildId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        eiVar.i(MiscKt.l(str));
        String str3 = this.mChannelId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelId");
        } else {
            str2 = str3;
        }
        eiVar.h(MiscKt.l(str2));
        Long l3 = this.mLiveRoomId;
        if (l3 != null) {
            Intrinsics.checkNotNull(l3, "null cannot be cast to non-null type kotlin.Long");
            eiVar.j(l3.longValue());
            eiVar.g(999L);
        } else {
            eiVar.g(0L);
        }
        j e16 = eiVar.e();
        if (roles == null) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        e16.c(i3);
        if (roles != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<RoleGroupModel> it = roles.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(MiscKt.l(it.next().getId())));
            }
            eiVar.e().d(arrayList);
        }
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).sendAudioOrLiveNotice(eiVar, new ed() { // from class: yu1.c
            @Override // wh2.ed
            public final void a(int i16, String str4, IGProSendNoticeRsp iGProSendNoticeRsp) {
                GuildAtNoticeDialogFragment.zh(i16, str4, iGProSendNoticeRsp);
            }
        });
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(int i3, String str, IGProSendNoticeRsp iGProSendNoticeRsp) {
        QLog.i("GuildAtNoticeDialogFragment", 1, "sendNotice result: " + i3 + ", errMsg: " + str + ", rsp: " + iGProSendNoticeRsp.getCode() + ", notAllowReason: " + iGProSendNoticeRsp.getNotAllowReason());
        if (i3 == 0 && iGProSendNoticeRsp.getCode() == 1) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f157511n4, 0).show();
        } else if (iGProSendNoticeRsp.getCode() == 2 && !TextUtils.isEmpty(iGProSendNoticeRsp.getNotAllowReason())) {
            QQToast.makeText(BaseApplication.getContext(), iGProSendNoticeRsp.getNotAllowReason(), 0).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f157501n3, 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eg9, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026notice_dialog, container)");
        this.mRootView = inflate;
        View view2 = null;
        if (!uh()) {
            dismissAllowingStateLoss();
            view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            view2 = view;
        } else {
            this.mWindowHeight = ScreenUtil.getInstantScreenHeight(getContext()) - ViewUtils.dpToPx(83.0f);
            initView();
            sh();
            Ch(194.0f);
            Bh();
            xh(true);
            view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            view2 = view;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        xh(false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Ah();
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
            View findViewById = aVar.findViewById(R.id.ugk);
            if (findViewById != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
                Intrinsics.checkNotNullExpressionValue(from, "from(this)");
                from.setState(3);
                findViewById.getLayoutParams().height = this.mWindowHeight;
                from.addBottomSheetCallback(new b(from));
            }
            Window window = aVar.getWindow();
            Intrinsics.checkNotNull(window);
            window.getAttributes().windowAnimations = R.style.axr;
        }
    }
}
