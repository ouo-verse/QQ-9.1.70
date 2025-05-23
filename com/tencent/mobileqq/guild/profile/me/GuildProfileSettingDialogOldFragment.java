package com.tencent.mobileqq.guild.profile.me;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.profile.me.edit.GuildMeAddFriendModel;
import com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u0011\u0012\b\u0010U\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J:\u0010\u0018\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u001a\u0010%\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0006R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R.\u0010>\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010:j\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u0001`;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u0004\u0018\u00010?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u00103R\u0016\u0010J\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileSettingDialogOldFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", "", "Ah", "Landroid/view/View;", "contentRoot", "wh", "vh", "", "radiusTop", "radiusBottom", "Landroid/view/ViewGroup;", "viewGroup", "Hh", "Dh", "Ch", "view", "", "elementID", "eventID", "key", "value", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "onCreateView", "onResume", "onStart", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/widget/CompoundButton;", "isChecked", "onCheckedChanged", NodeProps.ON_CLICK, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Gh", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "Landroid/widget/RelativeLayout;", "D", "Landroid/widget/RelativeLayout;", "mOpenMyselfOrderCenter", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mFeedbackContainer", UserInfo.SEX_FEMALE, "mOpenSingingCenterContainer", "G", "Landroid/view/View;", "mRootView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mSettingContainerList", "Lcom/tencent/mobileqq/guild/profile/me/GuildMeViewModel;", "I", "Lcom/tencent/mobileqq/guild/profile/me/GuildMeViewModel;", "mMeViewModel", "Lcom/tencent/widget/Switch;", "J", "Lcom/tencent/widget/Switch;", "mAddFriendSwitch", "K", "mAddFriendTitle", "L", "mViewQQProfileSwitch", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "mArraw", "N", "mOrderArraw", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$c;", "P", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$c;", DownloadInfo.spKey_Config, "meViewModel", "<init>", "(Lcom/tencent/mobileqq/guild/profile/me/GuildMeViewModel;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileSettingDialogOldFragment extends ReportAndroidXDialogFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private RelativeLayout mOpenMyselfOrderCenter;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mFeedbackContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private RelativeLayout mOpenSingingCenterContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ArrayList<RelativeLayout> mSettingContainerList;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final GuildMeViewModel mMeViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private Switch mAddFriendSwitch;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mAddFriendTitle;

    /* renamed from: L, reason: from kotlin metadata */
    private Switch mViewQQProfileSwitch;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView mArraw;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView mOrderArraw;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private GuildSignAndWalletConfig.GuildSigningCenterEntranceConfig config = GuildSignAndWalletConfig.INSTANCE.a().getSingingCenterConfig();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/profile/me/GuildProfileSettingDialogOldFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f231123d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildProfileSettingDialogOldFragment f231124e;

        b(QUSHalfScreenFloatingView qUSHalfScreenFloatingView, GuildProfileSettingDialogOldFragment guildProfileSettingDialogOldFragment) {
            this.f231123d = qUSHalfScreenFloatingView;
            this.f231124e = guildProfileSettingDialogOldFragment;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            View view = LayoutInflater.from(this.f231123d.getContext()).inflate(R.layout.f8e, (ViewGroup) null);
            GuildProfileSettingDialogOldFragment guildProfileSettingDialogOldFragment = this.f231124e;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            guildProfileSettingDialogOldFragment.wh(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public GuildProfileSettingDialogOldFragment(@Nullable GuildMeViewModel guildMeViewModel) {
        this.mMeViewModel = guildMeViewModel;
    }

    private final void Ah() {
        View view = this.mRootView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = (QUSHalfScreenFloatingView) findViewById;
        this.mFloatingView = qUSHalfScreenFloatingView2;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new b(qUSHalfScreenFloatingView, this));
        qUSHalfScreenFloatingView.J();
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.profile.me.ae
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildProfileSettingDialogOldFragment.Bh(GuildProfileSettingDialogOldFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(GuildProfileSettingDialogOldFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void Ch() {
        ch.i1(getActivity(), ch.P());
    }

    private final void Dh() {
        String ecommerceUrl = ch.O();
        IQQECommerceSdk iQQECommerceSdk = (IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class);
        Intrinsics.checkNotNullExpressionValue(ecommerceUrl, "ecommerceUrl");
        iQQECommerceSdk.handleScheme(ecommerceUrl, null);
    }

    private final void Eh(View view, String elementID, String eventID, String key, String value) {
        VideoReport.setElementId(view, elementID);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_mine");
        hashMap.put("dt_eid", elementID);
        if (key != null) {
            hashMap.put(key, value);
        }
        VideoReport.reportEvent(eventID, view, hashMap);
    }

    static /* synthetic */ void Fh(GuildProfileSettingDialogOldFragment guildProfileSettingDialogOldFragment, View view, String str, String str2, String str3, String str4, int i3, Object obj) {
        String str5;
        String str6;
        if ((i3 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str4;
        }
        guildProfileSettingDialogOldFragment.Eh(view, str, str2, str5, str6);
    }

    private final void Hh(boolean radiusTop, boolean radiusBottom, ViewGroup viewGroup) {
        if (radiusTop && radiusBottom) {
            viewGroup.setBackgroundResource(R.drawable.guild_token_setting_round_rect_8_selector);
            View findViewById = viewGroup.findViewById(R.id.wzw);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        if (!radiusTop && !radiusBottom) {
            viewGroup.setBackgroundResource(R.drawable.guild_token_setting_rect_8_selector);
            View findViewById2 = viewGroup.findViewById(R.id.wzw);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
                return;
            }
            return;
        }
        if (radiusTop) {
            viewGroup.setBackgroundResource(R.drawable.guild_token_setting_top_round_rect_8_selector);
            View findViewById3 = viewGroup.findViewById(R.id.wzw);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
                return;
            }
            return;
        }
        if (radiusBottom) {
            viewGroup.setBackgroundResource(R.drawable.guild_token_setting_bottom_round_rect_8_selector);
            View findViewById4 = viewGroup.findViewById(R.id.wzw);
            if (findViewById4 != null) {
                findViewById4.setVisibility(8);
            }
        }
    }

    private final void vh() {
        boolean z16;
        ArrayList<RelativeLayout> arrayList = null;
        if (this.config.getIsShow()) {
            RelativeLayout relativeLayout = this.mOpenSingingCenterContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
        } else {
            RelativeLayout relativeLayout2 = this.mOpenSingingCenterContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
        }
        if (ch.K0()) {
            TextView textView = this.mFeedbackContainer;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
                textView = null;
            }
            textView.setVisibility(0);
        } else {
            TextView textView2 = this.mFeedbackContainer;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
                textView2 = null;
            }
            textView2.setVisibility(8);
        }
        if (ch.y0()) {
            RelativeLayout relativeLayout3 = this.mOpenMyselfOrderCenter;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenMyselfOrderCenter");
                relativeLayout3 = null;
            }
            relativeLayout3.setVisibility(0);
        } else {
            RelativeLayout relativeLayout4 = this.mOpenMyselfOrderCenter;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenMyselfOrderCenter");
                relativeLayout4 = null;
            }
            relativeLayout4.setVisibility(8);
        }
        ArrayList<RelativeLayout> arrayList2 = this.mSettingContainerList;
        if (arrayList2 != null) {
            arrayList = new ArrayList();
            for (Object obj : arrayList2) {
                RelativeLayout relativeLayout5 = (RelativeLayout) obj;
                if (relativeLayout5 != null && relativeLayout5.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            for (RelativeLayout relativeLayout6 : arrayList) {
                int i16 = i3 + 1;
                if (relativeLayout6 != null) {
                    if (size == 1) {
                        Hh(true, true, relativeLayout6);
                    } else if (i3 == 0) {
                        Hh(true, false, relativeLayout6);
                    } else if (i3 == size - 1) {
                        Hh(false, true, relativeLayout6);
                    } else {
                        Hh(false, false, relativeLayout6);
                    }
                }
                i3 = i16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(View contentRoot) {
        ArrayList<RelativeLayout> arrayListOf;
        LiveData<ri1.a> guildError;
        LiveData<Boolean> isQQProfileSwitchChecked;
        MutableLiveData<GuildMeAddFriendModel> isFriendSwitchChecked;
        View findViewById = contentRoot.findViewById(R.id.wt_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentRoot.findViewById\u2026open_myself_order_center)");
        this.mOpenMyselfOrderCenter = (RelativeLayout) findViewById;
        View findViewById2 = contentRoot.findViewById(R.id.f165530wi0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentRoot.findViewById\u2026p_and_feedback_container)");
        this.mFeedbackContainer = (TextView) findViewById2;
        View findViewById3 = contentRoot.findViewById(R.id.vwm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentRoot.findViewById\u2026.guild_add_friend_switch)");
        this.mAddFriendSwitch = (Switch) findViewById3;
        View findViewById4 = contentRoot.findViewById(R.id.vwn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentRoot.findViewById\u2026d.guild_add_friend_title)");
        this.mAddFriendTitle = (TextView) findViewById4;
        View findViewById5 = contentRoot.findViewById(R.id.svk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentRoot.findViewById(R.id.arraw)");
        this.mArraw = (ImageView) findViewById5;
        View findViewById6 = contentRoot.findViewById(R.id.zlt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentRoot.findViewById(R.id.my_order_arraw)");
        this.mOrderArraw = (ImageView) findViewById6;
        View findViewById7 = contentRoot.findViewById(R.id.f165626x10);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentRoot.findViewById\u2026.id.guild_singing_center)");
        this.mOpenSingingCenterContainer = (RelativeLayout) findViewById7;
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_secondary);
        DrawableType drawableType = new DrawableType(R.drawable.guild_me_right_arrow, valueOf);
        ImageView imageView = this.mArraw;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mArraw");
            imageView = null;
        }
        drawableType.b(imageView);
        DrawableType drawableType2 = new DrawableType(R.drawable.guild_me_right_arrow, valueOf);
        ImageView imageView2 = this.mOrderArraw;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOrderArraw");
            imageView2 = null;
        }
        drawableType2.b(imageView2);
        Switch r06 = this.mAddFriendSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSwitch");
            r06 = null;
        }
        r06.setTag("em_sgrp_mine_addqqfriend");
        Switch r07 = this.mAddFriendSwitch;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSwitch");
            r07 = null;
        }
        r07.setOnCheckedChangeListener(this);
        View findViewById8 = contentRoot.findViewById(R.id.x4s);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentRoot.findViewById\u2026d_view_qq_profile_switch)");
        Switch r65 = (Switch) findViewById8;
        this.mViewQQProfileSwitch = r65;
        if (r65 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewQQProfileSwitch");
            r65 = null;
        }
        r65.setOnCheckedChangeListener(this);
        Switch r66 = this.mViewQQProfileSwitch;
        if (r66 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewQQProfileSwitch");
            r66 = null;
        }
        r66.setTag("em_sgrp_qq_card_switch");
        RelativeLayout[] relativeLayoutArr = new RelativeLayout[2];
        RelativeLayout relativeLayout = this.mOpenSingingCenterContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
            relativeLayout = null;
        }
        relativeLayoutArr[0] = relativeLayout;
        RelativeLayout relativeLayout2 = this.mOpenMyselfOrderCenter;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenMyselfOrderCenter");
            relativeLayout2 = null;
        }
        relativeLayoutArr[1] = relativeLayout2;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(relativeLayoutArr);
        this.mSettingContainerList = arrayListOf;
        if (arrayListOf != null) {
            for (RelativeLayout relativeLayout3 : arrayListOf) {
                if (relativeLayout3 != null) {
                    relativeLayout3.setOnClickListener(this);
                }
            }
        }
        RelativeLayout relativeLayout4 = this.mOpenSingingCenterContainer;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
            relativeLayout4 = null;
        }
        relativeLayout4.setOnClickListener(this);
        TextView textView2 = this.mFeedbackContainer;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(this);
        GuildMeViewModel guildMeViewModel = this.mMeViewModel;
        if (guildMeViewModel != null && (isFriendSwitchChecked = guildMeViewModel.isFriendSwitchChecked()) != null) {
            isFriendSwitchChecked.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.af
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildProfileSettingDialogOldFragment.xh(GuildProfileSettingDialogOldFragment.this, (GuildMeAddFriendModel) obj);
                }
            });
        }
        GuildMeViewModel guildMeViewModel2 = this.mMeViewModel;
        if (guildMeViewModel2 != null && (isQQProfileSwitchChecked = guildMeViewModel2.isQQProfileSwitchChecked()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildProfileSettingDialogOldFragment$initContentView$3
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
                public final void invoke2(Boolean status) {
                    Switch r08;
                    r08 = GuildProfileSettingDialogOldFragment.this.mViewQQProfileSwitch;
                    if (r08 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewQQProfileSwitch");
                        r08 = null;
                    }
                    GuildProfileSettingDialogOldFragment guildProfileSettingDialogOldFragment = GuildProfileSettingDialogOldFragment.this;
                    if (Intrinsics.areEqual(status, Boolean.valueOf(r08.isChecked()))) {
                        return;
                    }
                    r08.setOnCheckedChangeListener(null);
                    Intrinsics.checkNotNullExpressionValue(status, "status");
                    r08.setChecked(status.booleanValue());
                    r08.setOnCheckedChangeListener(guildProfileSettingDialogOldFragment);
                }
            };
            isQQProfileSwitchChecked.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.ag
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildProfileSettingDialogOldFragment.yh(Function1.this, obj);
                }
            });
        }
        GuildMeViewModel guildMeViewModel3 = this.mMeViewModel;
        if (guildMeViewModel3 != null) {
            guildMeViewModel3.fetchProfilePrivacySetting();
        }
        GuildMeViewModel guildMeViewModel4 = this.mMeViewModel;
        if (guildMeViewModel4 != null && (guildError = guildMeViewModel4.getGuildError()) != null) {
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            final GuildProfileSettingDialogOldFragment$initContentView$4 guildProfileSettingDialogOldFragment$initContentView$4 = new Function1<ri1.a, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildProfileSettingDialogOldFragment$initContentView$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ri1.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ri1.a aVar) {
                    if (TextUtils.isEmpty(aVar.f431478b)) {
                        return;
                    }
                    QQToastUtil.showQQToast(1, aVar.f431478b);
                }
            };
            guildError.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.ah
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildProfileSettingDialogOldFragment.zh(Function1.this, obj);
                }
            });
        }
        vh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(GuildProfileSettingDialogOldFragment this$0, GuildMeAddFriendModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "model");
        Switch r06 = this$0.mAddFriendSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendSwitch");
            r06 = null;
        }
        if (model.getEnable()) {
            r06.setAlpha(1.0f);
            TextView textView = this$0.mAddFriendTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendTitle");
                textView = null;
            }
            textView.setAlpha(1.0f);
        } else {
            r06.setAlpha(0.2f);
            TextView textView2 = this$0.mAddFriendTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendTitle");
                textView2 = null;
            }
            textView2.setAlpha(0.2f);
        }
        r06.setEnabled(model.getEnable());
        if (!TextUtils.isEmpty(model.getErrorMsg())) {
            QQToastUtil.showQQToast(1, model.getErrorMsg());
        }
        if (model.getStatus() == r06.isChecked()) {
            return;
        }
        r06.setOnCheckedChangeListener(null);
        r06.setChecked(model.getStatus());
        r06.setOnCheckedChangeListener(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void Gh(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        VideoReport.setPageId(rootView, "pg_sgrp_mine");
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton view, boolean isChecked) {
        Object obj;
        String str;
        GuildMeViewModel guildMeViewModel;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, isChecked);
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj;
        if (isChecked) {
            str = "1";
        } else {
            str = "2";
        }
        Eh(view, str2, "clck", "sgrp_switch_type", str);
        if (Intrinsics.areEqual(str2, "em_sgrp_mine_addqqfriend")) {
            GuildMeViewModel guildMeViewModel2 = this.mMeViewModel;
            if (guildMeViewModel2 != null) {
                guildMeViewModel2.setAddFriendSwitchStatus(isChecked);
            }
        } else if (Intrinsics.areEqual(str2, "em_sgrp_qq_card_switch") && (guildMeViewModel = this.mMeViewModel) != null) {
            guildMeViewModel.setViewQQProfileSwitchStatus(isChecked);
        }
        EventCollector.getInstance().onCompoundButtonChecked(view, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        dismissAllowingStateLoss();
        RelativeLayout relativeLayout = null;
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        RelativeLayout relativeLayout2 = this.mOpenMyselfOrderCenter;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenMyselfOrderCenter");
            relativeLayout2 = null;
        }
        int id5 = relativeLayout2.getId();
        if (num != null && num.intValue() == id5) {
            Dh();
        } else {
            TextView textView = this.mFeedbackContainer;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
                textView = null;
            }
            int id6 = textView.getId();
            if (num != null && num.intValue() == id6) {
                Fh(this, view, "em_sgrp_mine_feedback", "clck", null, null, 24, null);
                Ch();
            } else {
                RelativeLayout relativeLayout3 = this.mOpenSingingCenterContainer;
                if (relativeLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
                } else {
                    relativeLayout = relativeLayout3;
                }
                int id7 = relativeLayout.getId();
                if (num != null && num.intValue() == id7) {
                    Fh(this, view, "em_sgrp_sign_center_entrance", "clck", null, null, 24, null);
                    String jumpUrl = this.config.getJumpUrl();
                    if (jumpUrl != null && jumpUrl.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        ch.i1(getActivity(), this.config.getJumpUrl());
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.f173448dl);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e3i, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026screen, container, false)");
        this.mRootView = inflate;
        Ah();
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        Gh(view);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        View view;
        Switch r36;
        RelativeLayout relativeLayout;
        TextView textView;
        super.onPause();
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        } else {
            view = view2;
        }
        Fh(this, view, "em_sgrp_mine_setting_panel", "imp_end", null, null, 24, null);
        Switch r06 = this.mViewQQProfileSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewQQProfileSwitch");
            r36 = null;
        } else {
            r36 = r06;
        }
        Fh(this, r36, "em_sgrp_qq_card_switch", "imp_end", null, null, 24, null);
        TextView textView2 = this.mFeedbackContainer;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
            textView2 = null;
        }
        if (textView2.getVisibility() == 0) {
            TextView textView3 = this.mFeedbackContainer;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
                textView = null;
            } else {
                textView = textView3;
            }
            Fh(this, textView, "em_sgrp_mine_feedback", "imp_end", null, null, 24, null);
        }
        RelativeLayout relativeLayout2 = this.mOpenSingingCenterContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
            relativeLayout2 = null;
        }
        if (relativeLayout2.getVisibility() == 0) {
            RelativeLayout relativeLayout3 = this.mOpenSingingCenterContainer;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
                relativeLayout = null;
            } else {
                relativeLayout = relativeLayout3;
            }
            Fh(this, relativeLayout, "em_sgrp_sign_center_entrance", "imp_end", null, null, 24, null);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        View view;
        Switch r46;
        String str;
        RelativeLayout relativeLayout;
        TextView textView;
        super.onResume();
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        ViewParent parent = view2.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        } else {
            view = view3;
        }
        Fh(this, view, "em_sgrp_mine_setting_panel", "imp", null, null, 24, null);
        Switch r06 = this.mViewQQProfileSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewQQProfileSwitch");
            r46 = null;
        } else {
            r46 = r06;
        }
        Switch r07 = this.mViewQQProfileSwitch;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewQQProfileSwitch");
            r07 = null;
        }
        if (r07.isChecked()) {
            str = "1";
        } else {
            str = "2";
        }
        Eh(r46, "em_sgrp_qq_card_switch", "imp", "sgrp_switch_type", str);
        TextView textView2 = this.mFeedbackContainer;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
            textView2 = null;
        }
        if (textView2.getVisibility() == 0) {
            TextView textView3 = this.mFeedbackContainer;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedbackContainer");
                textView = null;
            } else {
                textView = textView3;
            }
            Fh(this, textView, "em_sgrp_mine_feedback", "imp", null, null, 24, null);
        }
        RelativeLayout relativeLayout2 = this.mOpenSingingCenterContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
            relativeLayout2 = null;
        }
        if (relativeLayout2.getVisibility() == 0) {
            RelativeLayout relativeLayout3 = this.mOpenSingingCenterContainer;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenSingingCenterContainer");
                relativeLayout = null;
            } else {
                relativeLayout = relativeLayout3;
            }
            Fh(this, relativeLayout, "em_sgrp_sign_center_entrance", "imp", null, null, 24, null);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            if (dialog.getWindow() != null) {
                Dialog dialog2 = getDialog();
                Intrinsics.checkNotNull(dialog2);
                Window window = dialog2.getWindow();
                Intrinsics.checkNotNull(window);
                GuildUIUtils.H(window);
            }
        }
    }
}
