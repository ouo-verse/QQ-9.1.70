package com.tencent.mobileqq.guild.profile.me;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.inbox.startpanel.GuildInboxTitleHeaderView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.profile.me.edit.GuildEditProfileFragment;
import com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u0002:\u0002\u0081\u0001B\u0011\b\u0016\u0012\u0006\u0010x\u001a\u00020w\u00a2\u0006\u0004\by\u0010zB\u001b\b\u0016\u0012\u0006\u0010x\u001a\u00020w\u0012\b\u0010|\u001a\u0004\u0018\u00010{\u00a2\u0006\u0004\by\u0010}B#\b\u0016\u0012\u0006\u0010x\u001a\u00020w\u0012\b\u0010|\u001a\u0004\u0018\u00010{\u0012\u0006\u0010~\u001a\u00020\n\u00a2\u0006\u0004\by\u0010\u007fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\u001f\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0003J\b\u0010$\u001a\u00020\u0003H\u0014J\b\u0010%\u001a\u00020\u0003H\u0014J\u0012\u0010'\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010(\u001a\u00020\u0003J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\nH\u0007J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0007J\u0006\u0010.\u001a\u00020\u0003J\u0006\u0010/\u001a\u00020\u0003R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010C\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010:R\u0018\u0010E\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u00020n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010NR\u0016\u0010r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010ZR\u001c\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010u\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileBannerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "R0", "b1", "c1", "S0", "", "count", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreatedGuildInfo;", "guildList", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "T0", "k1", "l1", "Landroid/view/View;", "reportView", "", "elementId", "d1", "e1", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "Lcom/tencent/mobileqq/guild/mainframe/i;", "guildMainViewContext", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "V0", "Lcom/tencent/mobileqq/guild/profile/me/GuildMeViewModel;", "guildMeViewModel", "setViewModel", "setupLiveDataInfo", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "view", NodeProps.ON_CLICK, "onThemeChanged", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "Y0", "Z0", "U0", "X0", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mUserInfoLayout", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "e", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "mIvAvatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTvName", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mSignIcon", "i", "mTvTopName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTvInfo", BdhLogUtil.LogTag.Tag_Conn, "mWalletIcon", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "D", "Landroidx/lifecycle/LiveData;", "mSelfInfoUpdateLiveData", "E", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycle", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/mainframe/i;", "mGuildMainViewContext", "Landroidx/lifecycle/MutableLiveData;", "G", "Landroidx/lifecycle/MutableLiveData;", "mUserDescLiveDataInfo", "H", "Lcom/tencent/mobileqq/guild/profile/me/GuildMeViewModel;", "mGuildMeViewModel", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileSettingDialogOldFragment;", "I", "Lmqq/util/WeakReference;", "mSettingDialog", "Landroid/widget/RelativeLayout;", "J", "Landroid/widget/RelativeLayout;", "mMyOwnFeedsView", "K", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "mMyOwnGuildView", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;", "L", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxTitleHeaderView;", "mInboxTitleInTitle", "M", "Landroid/view/View;", "mDiveredView", "N", "Landroid/view/ViewGroup;", "mTopTitlebarLayout", "", "P", "mRecyclerViewScrollOffset", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mTitleBackgroundColor", "Landroidx/lifecycle/Observer;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/Observer;", "mBackgroundColorObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileBannerLayout extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView mWalletIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LiveData<ev> mSelfInfoUpdateLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner mLifecycle;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.mainframe.i mGuildMainViewContext;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private MutableLiveData<String> mUserDescLiveDataInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildMeViewModel mGuildMeViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private WeakReference<GuildProfileSettingDialogOldFragment> mSettingDialog;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private RelativeLayout mMyOwnFeedsView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GuildProfileMyGuildsLayout mMyOwnGuildView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private GuildInboxTitleHeaderView mInboxTitleInTitle;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View mDiveredView;

    /* renamed from: N, reason: from kotlin metadata */
    private ViewGroup mTopTitlebarLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private float mRecyclerViewScrollOffset;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mTitleBackgroundColor;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Observer<Integer> mBackgroundColorObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout mUserInfoLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildUserAvatarViewWithPendant mIvAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mTvName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mSignIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTvTopName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mTvInfo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildProfileBannerLayout(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout.LayoutParams R0() {
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(0, -2);
        layoutParams.startToStart = 0;
        layoutParams.topToBottom = this.mMyOwnFeedsView.getId();
        layoutParams.endToEnd = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.setMarginEnd(QQGuildUIUtil.f(13.0f));
        layoutParams.setMarginStart(QQGuildUIUtil.f(13.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = QQGuildUIUtil.f(24.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = QQGuildUIUtil.f(8.0f);
        return layoutParams;
    }

    private final void S0() {
        GuildProfileSettingDialogOldFragment guildProfileSettingDialogOldFragment;
        WeakReference<GuildProfileSettingDialogOldFragment> weakReference = this.mSettingDialog;
        if (weakReference != null && (guildProfileSettingDialogOldFragment = weakReference.get()) != null) {
            guildProfileSettingDialogOldFragment.dismissAllowingStateLoss();
        }
        this.mSettingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildProfileMyGuildsLayout T0(int count, List<? extends IGProCreatedGuildInfo> guildList) {
        if (count != 0) {
            if (count != 1) {
                if (count != 2) {
                    if (count != 3) {
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        Intrinsics.checkNotNull(guildList);
                        return new GuildProfileMyGuildThreeLayout(context, guildList);
                    }
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    Intrinsics.checkNotNull(guildList);
                    return new GuildProfileMyGuildThreeLayout(context2, guildList);
                }
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                Intrinsics.checkNotNull(guildList);
                return new GuildProfileMyGuildTwoLayout(context3, guildList);
            }
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            Intrinsics.checkNotNull(guildList);
            return new GuildProfileMyGuildOneLayout(context4, guildList);
        }
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        return new GuildProfileMyGuildsLayoutEmpty(context5, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(GuildProfileBannerLayout this$0, Integer num) {
        int color;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null) {
            color = kotlin.g.a(num.intValue(), 100);
        } else {
            color = this$0.getResources().getColor(R.color.qui_common_fill_light_primary);
        }
        this$0.mTitleBackgroundColor = color;
        this$0.l1();
    }

    private final void a1() {
        QPublicFragmentActivity.b.b(getContext(), new Intent(), QPublicFragmentActivity.class, GuildEditProfileFragment.class);
    }

    private final void b1() {
        Bundle bundle = new Bundle();
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam();
        joinInfoParam.setMainSource("mine");
        joinInfoParam.setSubSource("mine_like");
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iGuildFeedLauncherApi.launchGuildFeedPostsLoadFragment(context, bundle);
    }

    private final void c1() {
        GuildProfileSettingDialogOldFragment guildProfileSettingDialogOldFragment;
        S0();
        WeakReference<GuildProfileSettingDialogOldFragment> weakReference = new WeakReference<>(new GuildProfileSettingDialogOldFragment(this.mGuildMeViewModel));
        this.mSettingDialog = weakReference;
        if (this.mGuildMainViewContext != null && (guildProfileSettingDialogOldFragment = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(guildProfileSettingDialogOldFragment, "get()");
            com.tencent.mobileqq.guild.mainframe.i iVar = this.mGuildMainViewContext;
            Intrinsics.checkNotNull(iVar);
            FragmentManager childFragmentManager = iVar.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "mGuildMainViewContext!!.childFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(guildProfileSettingDialogOldFragment, childFragmentManager, "Guild.profile.GuildSettingDialogFragm");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(View reportView, String elementId) {
        VideoReport.setElementId(reportView, elementId);
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_mine");
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", reportView, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(View reportView, String elementId) {
        VideoReport.setElementId(reportView, elementId);
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_mine");
        VideoReport.reportEvent("imp", reportView, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void k1() {
        GuildInboxTitleHeaderView guildInboxTitleHeaderView = this.mInboxTitleInTitle;
        if (guildInboxTitleHeaderView != null) {
            guildInboxTitleHeaderView.setVisibility(0);
        }
        View view = this.mDiveredView;
        if (view != null) {
            view.setVisibility(0);
        }
        GuildInboxTitleHeaderView guildInboxTitleHeaderView2 = this.mInboxTitleInTitle;
        if (guildInboxTitleHeaderView2 != null) {
            guildInboxTitleHeaderView2.setBackgroundColor(this.mTitleBackgroundColor);
        }
        ViewGroup viewGroup = this.mTopTitlebarLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f16 = QQGuildUIUtil.f(6.0f);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(this.mTitleBackgroundColor);
        viewGroup.setBackground(gradientDrawable);
        TextView textView = this.mTvTopName;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.mTvTopName;
        if (textView2 != null) {
            textView2.setAlpha(1.0f);
        }
        ViewGroup viewGroup3 = this.mTopTitlebarLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup3 = null;
        }
        viewGroup3.setFocusable(true);
        ViewGroup viewGroup4 = this.mTopTitlebarLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.setClickable(true);
    }

    private final void l1() {
        int i3;
        ViewGroup viewGroup = this.mTopTitlebarLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup = null;
        }
        if (viewGroup.getBackground() != null) {
            ViewGroup viewGroup2 = this.mTopTitlebarLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
                viewGroup2 = null;
            }
            viewGroup2.setBackgroundColor(this.mTitleBackgroundColor);
        }
        GuildInboxTitleHeaderView guildInboxTitleHeaderView = this.mInboxTitleInTitle;
        if (guildInboxTitleHeaderView != null) {
            guildInboxTitleHeaderView.setBackgroundColor(this.mTitleBackgroundColor);
        }
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.guild_vas_theme_channel_item_bg_with_border;
        } else {
            i3 = R.drawable.guild_theme_channel_item_bg_with_border;
        }
        this.mMyOwnFeedsView.setBackground(ResourcesCompat.getDrawable(getResources(), i3, null));
        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout = this.mMyOwnGuildView;
        if (guildProfileMyGuildsLayout != null) {
            guildProfileMyGuildsLayout.J0();
        }
    }

    public final void U0() {
        GuildInboxTitleHeaderView guildInboxTitleHeaderView = this.mInboxTitleInTitle;
        if (guildInboxTitleHeaderView != null) {
            guildInboxTitleHeaderView.setVisibility(8);
        }
        View view = this.mDiveredView;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.mTopTitlebarLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup = null;
        }
        viewGroup.setBackground(null);
        TextView textView = this.mTvTopName;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mTvTopName;
        if (textView2 != null) {
            textView2.setAlpha(0.0f);
        }
        setAlpha(1.0f);
        ViewGroup viewGroup3 = this.mTopTitlebarLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup3 = null;
        }
        viewGroup3.setFocusable(false);
        ViewGroup viewGroup4 = this.mTopTitlebarLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.setClickable(false);
    }

    public final void V0(@Nullable LifecycleOwner lifecycle, @NotNull com.tencent.mobileqq.guild.mainframe.i guildMainViewContext, @NotNull ViewGroup rootView) {
        int i3;
        Intrinsics.checkNotNullParameter(guildMainViewContext, "guildMainViewContext");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mInboxTitleInTitle = (GuildInboxTitleHeaderView) rootView.findViewById(R.id.wja);
        View findViewById = rootView.findViewById(R.id.wu_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_profile_inbox_title_bar)");
        this.mTopTitlebarLayout = (ViewGroup) findViewById;
        this.mTvTopName = (TextView) rootView.findViewById(R.id.wua);
        this.mWalletIcon = (ImageView) rootView.findViewById(R.id.x4x);
        this.mDiveredView = rootView.findViewById(R.id.bnd);
        this.mLifecycle = lifecycle;
        this.mIvAvatar.setLogTag("Guild.profile.GuildProfileBannerLayout");
        this.mGuildMainViewContext = guildMainViewContext;
        this.mIvAvatar.setAvatarSize(1);
        this.mUserInfoLayout.setOnClickListener(this);
        this.mMyOwnFeedsView.setOnClickListener(this);
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_mine");
        ch.W0(this.mMyOwnFeedsView, "em_sgrp_mine_forum_feed", hashMap);
        GuildSignAndWalletConfig.GuildWalletEntranceConfig guildWalletEntranceConfig = GuildSignAndWalletConfig.INSTANCE.a().getGuildWalletEntranceConfig();
        ImageView imageView = this.mWalletIcon;
        if (imageView != null) {
            if (guildWalletEntranceConfig.getIsShow()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        ImageView imageView2 = this.mWalletIcon;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
    }

    public final void X0() {
        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout = this.mMyOwnGuildView;
        if (guildProfileMyGuildsLayout != null) {
            guildProfileMyGuildsLayout.I0();
        }
    }

    @SuppressLint({"LongLogTag"})
    public final void Y0(@NotNull RecyclerView recyclerView, int newState) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0) {
            TextView textView = this.mTvTopName;
            if (textView != null && textView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                GuildInboxTitleHeaderView guildInboxTitleHeaderView = this.mInboxTitleInTitle;
                if (guildInboxTitleHeaderView != null && guildInboxTitleHeaderView.getVisibility() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                    int measuredHeight = computeVerticalScrollOffset - getMeasuredHeight();
                    ViewGroup viewGroup = this.mTopTitlebarLayout;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
                        viewGroup = null;
                    }
                    int measuredHeight2 = measuredHeight + viewGroup.getMeasuredHeight();
                    if (!recyclerView.canScrollVertically(1)) {
                        if (computeVerticalScrollOffset > ScreenUtils.getScreenHeight(getContext())) {
                            QLog.d("Guild.profile.GuildProfileBannerLayout", 1, "swipe too fast:");
                            k1();
                            return;
                        }
                        QLog.d("Guild.profile.GuildProfileBannerLayout", 2, "swipe dy" + computeVerticalScrollOffset);
                        if (recyclerView.getPaddingBottom() > QQGuildUIUtil.f(45.0f)) {
                            QLog.d("Guild.profile.GuildProfileBannerLayout", 1, "padding bottom has too large" + recyclerView.getPaddingBottom());
                            recyclerView.scrollBy(0, 0);
                            int computeVerticalScrollOffset2 = recyclerView.computeVerticalScrollOffset();
                            if (computeVerticalScrollOffset2 != 0) {
                                recyclerView.smoothScrollBy(0, -computeVerticalScrollOffset2);
                            }
                            recyclerView.setPadding(0, 0, 0, QQGuildUIUtil.f(45.0f));
                            return;
                        }
                        recyclerView.setPadding(0, 0, 0, recyclerView.getPaddingBottom() - measuredHeight2);
                    } else {
                        QLog.d("Guild.profile.GuildProfileBannerLayout", 2, "can scroll up,scroll offset " + measuredHeight2);
                    }
                    recyclerView.scrollBy(0, 0);
                    recyclerView.smoothScrollBy(0, -measuredHeight2);
                }
            }
            ((OverScrollRecyclerViewWithHeaderFooter) recyclerView).P();
        }
    }

    @SuppressLint({"LongLogTag"})
    public final void Z0(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.mRecyclerViewScrollOffset = recyclerView.computeVerticalScrollOffset();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0) {
            k1();
            return;
        }
        int measuredHeight = getMeasuredHeight();
        float f16 = this.mRecyclerViewScrollOffset;
        ViewGroup viewGroup = this.mTopTitlebarLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup = null;
        }
        if (f16 + viewGroup.getMeasuredHeight() < measuredHeight) {
            float f17 = 1;
            float f18 = this.mRecyclerViewScrollOffset;
            int measuredHeight2 = getMeasuredHeight();
            ViewGroup viewGroup3 = this.mTopTitlebarLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
                viewGroup3 = null;
            }
            setAlpha(f17 - (f18 / (measuredHeight2 - viewGroup3.getMeasuredHeight())));
        }
        float f19 = this.mRecyclerViewScrollOffset;
        ViewGroup viewGroup4 = this.mTopTitlebarLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup4 = null;
        }
        float measuredHeight3 = f19 + viewGroup4.getMeasuredHeight();
        if (measuredHeight3 > measuredHeight / 2) {
            TextView textView = this.mTvTopName;
            if (textView != null) {
                textView.setVisibility(0);
            }
            ViewGroup viewGroup5 = this.mTopTitlebarLayout;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
                viewGroup5 = null;
            }
            float measuredHeight4 = measuredHeight3 / (getMeasuredHeight() + viewGroup5.getMeasuredHeight());
            TextView textView2 = this.mTvTopName;
            if (textView2 != null) {
                textView2.setAlpha(measuredHeight4);
            }
        } else {
            TextView textView3 = this.mTvTopName;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        float f26 = this.mRecyclerViewScrollOffset;
        int measuredHeight5 = getMeasuredHeight();
        ViewGroup viewGroup6 = this.mTopTitlebarLayout;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup6 = null;
        }
        if (f26 >= measuredHeight5 - viewGroup6.getMeasuredHeight()) {
            k1();
            return;
        }
        GuildInboxTitleHeaderView guildInboxTitleHeaderView = this.mInboxTitleInTitle;
        if (guildInboxTitleHeaderView != null) {
            guildInboxTitleHeaderView.setVisibility(8);
        }
        View view = this.mDiveredView;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup7 = this.mTopTitlebarLayout;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup7 = null;
        }
        viewGroup7.setBackground(null);
        ViewGroup viewGroup8 = this.mTopTitlebarLayout;
        if (viewGroup8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
            viewGroup8 = null;
        }
        viewGroup8.setFocusable(false);
        ViewGroup viewGroup9 = this.mTopTitlebarLayout;
        if (viewGroup9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopTitlebarLayout");
        } else {
            viewGroup2 = viewGroup9;
        }
        viewGroup2.setClickable(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg).observeForever(this.mBackgroundColorObserver);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f115716ws) {
            d1(view, "em_sgrp_mine_edit");
            a1();
        } else if (num != null && num.intValue() == R.id.wzz) {
            d1(view, "em_sgrp_mine_set");
            c1();
        } else if (num != null && num.intValue() == R.id.f165603ww3) {
            b1();
            VideoReport.reportEvent("dt_clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg).removeObserver(this.mBackgroundColorObserver);
    }

    public final void onThemeChanged() {
        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout = this.mMyOwnGuildView;
        if (guildProfileMyGuildsLayout != null) {
            guildProfileMyGuildsLayout.onThemeChanged();
        }
    }

    public final void setViewModel(@NotNull GuildMeViewModel guildMeViewModel) {
        Intrinsics.checkNotNullParameter(guildMeViewModel, "guildMeViewModel");
        this.mGuildMeViewModel = guildMeViewModel;
    }

    public final void setupLiveDataInfo() {
        MutableLiveData<String> mutableLiveData;
        LiveData<GuildSignAndWalletConfig.GuildWalletEntranceConfig> walletConfig;
        MutableLiveData<ArrayList<IGProCreatedGuildInfo>> myCreatedGuildList;
        GuildMeViewModel guildMeViewModel = this.mGuildMeViewModel;
        MutableLiveData<ev> mutableLiveData2 = null;
        if (guildMeViewModel != null) {
            mutableLiveData = guildMeViewModel.getInfo();
        } else {
            mutableLiveData = null;
        }
        this.mUserDescLiveDataInfo = mutableLiveData;
        GuildMeViewModel guildMeViewModel2 = this.mGuildMeViewModel;
        if (guildMeViewModel2 != null) {
            mutableLiveData2 = guildMeViewModel2.getSelfInfoUpdateLiveData();
        }
        this.mSelfInfoUpdateLiveData = mutableLiveData2;
        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout = this.mMyOwnGuildView;
        if (guildProfileMyGuildsLayout != null && guildProfileMyGuildsLayout != null) {
            aa.a(guildProfileMyGuildsLayout);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mMyOwnGuildView = new GuildProfileMyGuildsLayoutLoading(context);
        addView(new View(getContext()), R0());
        LifecycleOwner lifecycleOwner = this.mLifecycle;
        if (lifecycleOwner != null) {
            LiveData<ev> liveData = this.mSelfInfoUpdateLiveData;
            if (liveData != null) {
                final GuildProfileBannerLayout$setupLiveDataInfo$2$1 guildProfileBannerLayout$setupLiveDataInfo$2$1 = new GuildProfileBannerLayout$setupLiveDataInfo$2$1(this);
                liveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.u
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildProfileBannerLayout.f1(Function1.this, obj);
                    }
                });
            }
            MutableLiveData<String> mutableLiveData3 = this.mUserDescLiveDataInfo;
            if (mutableLiveData3 != null) {
                final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildProfileBannerLayout$setupLiveDataInfo$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str) {
                        TextView textView;
                        textView = GuildProfileBannerLayout.this.mTvInfo;
                        textView.setText(str);
                    }
                };
                mutableLiveData3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.v
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildProfileBannerLayout.g1(Function1.this, obj);
                    }
                });
            }
            GuildMeViewModel guildMeViewModel3 = this.mGuildMeViewModel;
            if (guildMeViewModel3 != null && (myCreatedGuildList = guildMeViewModel3.getMyCreatedGuildList()) != null) {
                final Function1<ArrayList<IGProCreatedGuildInfo>, Unit> function12 = new Function1<ArrayList<IGProCreatedGuildInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildProfileBannerLayout$setupLiveDataInfo$2$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<IGProCreatedGuildInfo> arrayList) {
                        invoke2(arrayList);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
                    
                        r2 = r4.this$0.mMyOwnGuildView;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(ArrayList<IGProCreatedGuildInfo> arrayList) {
                        ConstraintLayout.LayoutParams R0;
                        List<IGProCreatedGuildInfo> list;
                        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout2;
                        GuildProfileMyGuildsLayout T0;
                        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout3;
                        GuildProfileMyGuildsLayout guildProfileMyGuildsLayout4;
                        R0 = GuildProfileBannerLayout.this.R0();
                        if (arrayList != null) {
                            list = arrayList.subList(0, arrayList.size() <= 3 ? arrayList.size() : 3);
                        } else {
                            list = null;
                        }
                        int size = list != null ? list.size() : 0;
                        guildProfileMyGuildsLayout2 = GuildProfileBannerLayout.this.mMyOwnGuildView;
                        if (guildProfileMyGuildsLayout2 != null && guildProfileMyGuildsLayout4 != null) {
                            aa.a(guildProfileMyGuildsLayout4);
                        }
                        GuildProfileBannerLayout guildProfileBannerLayout = GuildProfileBannerLayout.this;
                        T0 = guildProfileBannerLayout.T0(size, list);
                        guildProfileBannerLayout.mMyOwnGuildView = T0;
                        guildProfileMyGuildsLayout3 = GuildProfileBannerLayout.this.mMyOwnGuildView;
                        if (guildProfileMyGuildsLayout3 != null) {
                            final GuildProfileBannerLayout guildProfileBannerLayout2 = GuildProfileBannerLayout.this;
                            guildProfileBannerLayout2.addView(guildProfileMyGuildsLayout3, R0);
                            guildProfileMyGuildsLayout3.E0(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildProfileBannerLayout$setupLiveDataInfo$2$3$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                    invoke2(str);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull String guildId) {
                                    com.tencent.mobileqq.guild.mainframe.i iVar;
                                    Intrinsics.checkNotNullParameter(guildId, "guildId");
                                    iVar = GuildProfileBannerLayout.this.mGuildMainViewContext;
                                    if (iVar != null) {
                                        iVar.h(1, guildId, null);
                                    }
                                }
                            });
                        }
                    }
                };
                myCreatedGuildList.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.w
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildProfileBannerLayout.h1(Function1.this, obj);
                    }
                });
            }
            GuildMeViewModel guildMeViewModel4 = this.mGuildMeViewModel;
            if (guildMeViewModel4 != null && (walletConfig = guildMeViewModel4.getWalletConfig()) != null) {
                final GuildProfileBannerLayout$setupLiveDataInfo$2$4 guildProfileBannerLayout$setupLiveDataInfo$2$4 = new GuildProfileBannerLayout$setupLiveDataInfo$2$4(this);
                walletConfig.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.x
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildProfileBannerLayout.i1(Function1.this, obj);
                    }
                });
            }
        }
        GuildMeViewModel guildMeViewModel5 = this.mGuildMeViewModel;
        if (guildMeViewModel5 != null) {
            guildMeViewModel5.fetchMyCreatedGuildList();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildProfileBannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileBannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTitleBackgroundColor = getResources().getColor(R.color.qui_common_fill_light_primary);
        this.mBackgroundColorObserver = new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileBannerLayout.W0(GuildProfileBannerLayout.this, (Integer) obj);
            }
        };
        LayoutInflater.from(context).inflate(R.layout.f2q, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f115716ws);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.user_profile_basic_info)");
        this.mUserInfoLayout = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.wk5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_iv_avatar)");
        this.mIvAvatar = (GuildUserAvatarViewWithPendant) findViewById2;
        View findViewById3 = findViewById(R.id.x3n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_tv_name)");
        this.mTvName = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.x3g);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_tv_info)");
        this.mTvInfo = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.x0s);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_sign_icon)");
        this.mSignIcon = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f165603ww3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.guild_rl_my_feeds)");
        this.mMyOwnFeedsView = (RelativeLayout) findViewById6;
    }
}
