package com.tencent.mobileqq.guild.setting.member.view;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.channelcard.AnimationControl;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.discovery.widget.voiceavatar.MineVoiceAvatarLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 f2\u00020\u0001:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%H\u0002R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00100R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u00100R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00100R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010V\u001a\u00020Q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010;R\u0018\u0010[\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ld02/b;", "listener", "Oh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Fh", "initData", "Ph", "initView", "Nh", "", "spanCount", "Qh", "Lcg1/b;", "Ih", "", "tinyId", "Jh", "Mh", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Dh", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGuildId", "", "D", "J", "mChannelId", "E", "Landroid/view/ViewGroup;", "mRootView", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "mAvatarList", "G", "mChannelList", "H", "mContent", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mSkeleton", "mAvatarWrapper", "K", "mChannelListWrapper", "Lcom/tencent/mobileqq/guild/setting/member/view/GuildMemberAvatarAdapter;", "L", "Lcom/tencent/mobileqq/guild/setting/member/view/GuildMemberAvatarAdapter;", "mAvatarAdapter", "Lcg1/a;", "M", "Lcg1/a;", "mChannelAdapter", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c;", "N", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c;", "mVisibleAreaVideoController", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", "P", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", "mAnimationControl", "Le02/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Eh", "()Le02/c;", "viewModel", BdhLogUtil.LogTag.Tag_Req, "mostSpanCount", ExifInterface.LATITUDE_SOUTH, "Ld02/b;", "clickListener", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "T", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "guildObserver", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "U", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "cardShowListener", "<init>", "()V", "V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOnlineMemberDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<Integer, Integer> W;

    @NotNull
    private static final Map<Integer, Integer> X;

    @NotNull
    private static final List<Integer> Y;

    /* renamed from: C, reason: from kotlin metadata */
    private String mGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    private long mChannelId;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView mAvatarList;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView mChannelList;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewGroup mContent;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mSkeleton;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewGroup mAvatarWrapper;

    /* renamed from: K, reason: from kotlin metadata */
    private ViewGroup mChannelListWrapper;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildMemberAvatarAdapter mAvatarAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private cg1.a mChannelAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.channelcard.videoplay.c mVisibleAreaVideoController;

    /* renamed from: P, reason: from kotlin metadata */
    private AnimationControl mAnimationControl;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private int mostSpanCount;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private d02.b clickListener;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver guildObserver;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final GuildProfileCard.e cardShowListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "guildId", "", "channelId", "Ld02/b;", "clickListener", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.member.view.GuildOnlineMemberDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String guildId, long channelId, @Nullable d02.b clickListener) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildOnlineMemberDialogFragment guildOnlineMemberDialogFragment = new GuildOnlineMemberDialogFragment();
            guildOnlineMemberDialogFragment.Oh(clickListener);
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", guildId);
            bundle.putLong("channel_id", channelId);
            guildOnlineMemberDialogFragment.setArguments(bundle);
            com.tencent.mobileqq.guild.base.extension.d.a(guildOnlineMemberDialogFragment, fragmentManager, "Guild.userl.GuildOnlineMemberDialogFragment");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "channelIds", "", "onPushChannelDestroy", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@Nullable String guildId, @Nullable List<String> channelIds) {
            boolean z16 = false;
            if (channelIds != null && channelIds.contains(String.valueOf(GuildOnlineMemberDialogFragment.this.mChannelId))) {
                z16 = true;
            }
            if (z16) {
                GuildOnlineMemberDialogFragment.this.dismiss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) > 0) {
                outRect.left = ViewUtils.dpToPx(14.0f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends RecyclerView.ItemDecoration {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.top = ViewUtils.dpToPx(6.0f);
            outRect.right = ViewUtils.dpToPx(6.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$f", "Lcg1/b;", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout;", "mediaAvatarLayout", "", "r1", "Landroid/view/View;", "cardView", "A0", "", "a", "itemView", "", "position", "Ldg1/b;", "itemData", ICustomDataEditor.STRING_PARAM_1, "", "channelId", "channelType", "z0", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "feedSummary", "q1", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements cg1.b {
        f() {
        }

        @Override // cg1.b
        public void A0(@NotNull View cardView) {
            Intrinsics.checkNotNullParameter(cardView, "cardView");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = dh1.a.f393835a.d();
        }

        @Override // cg1.b
        public boolean a() {
            AnimationControl animationControl = GuildOnlineMemberDialogFragment.this.mAnimationControl;
            if (animationControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnimationControl");
                animationControl = null;
            }
            return animationControl.f();
        }

        @Override // cg1.b
        public void q1(@NotNull dg1.b channelInfo, @NotNull IGProFeedSummary feedSummary) {
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            Intrinsics.checkNotNullParameter(feedSummary, "feedSummary");
            GuildOnlineMemberDialogFragment.this.dismissAllowingStateLoss();
            d02.b bVar = GuildOnlineMemberDialogFragment.this.clickListener;
            if (bVar != null) {
                bVar.q1(channelInfo, feedSummary);
            }
        }

        @Override // cg1.b
        public void r1(@NotNull MineVoiceAvatarLayout mediaAvatarLayout) {
            Intrinsics.checkNotNullParameter(mediaAvatarLayout, "mediaAvatarLayout");
            dh1.a aVar = dh1.a.f393835a;
            mediaAvatarLayout.setAvatarSizeAndHorizontalSpacing(aVar.b(), aVar.c());
            mediaAvatarLayout.setAvatarRatio(aVar.b() / cw.d(37));
        }

        @Override // cg1.b
        public void s1(@NotNull View itemView, int position, @NotNull dg1.b itemData) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            VideoReport.setElementId(itemView, "em_sgrp_sub_channel_click");
            VideoReport.setElementReuseIdentifier(itemView, itemData.getChannelId() + "_" + itemData.getCardType());
            VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(itemView, EndExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_ALL);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_online_status", v.a(itemData.getChannelType())), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(itemData.getChannelId())), TuplesKt.to("sgrp_user_place", Integer.valueOf(position)), TuplesKt.to("sgrp_channel_online_number", itemData.getMemberCount()), TuplesKt.to("sgrp_content_card_type", Integer.valueOf(itemData.getCardType())));
            VideoReport.setElementParams(itemView, mapOf);
        }

        @Override // cg1.b
        public void z0(@NotNull String channelId, int channelType) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            GuildOnlineMemberDialogFragment.this.dismissAllowingStateLoss();
            d02.b bVar = GuildOnlineMemberDialogFragment.this.clickListener;
            if (bVar != null) {
                bVar.z0(channelId, channelType);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$g", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g extends BottomSheetBehavior.e {
        g() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                GuildOnlineMemberDialogFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        Map<Integer, Integer> mapOf2;
        List<Integer> listOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, 0), TuplesKt.to(2, 1), TuplesKt.to(7, 6), TuplesKt.to(5, 2));
        W = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(1, 2), TuplesKt.to(2, 3), TuplesKt.to(7, 7), TuplesKt.to(5, 4));
        X = mapOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 7, 5});
        Y = listOf;
    }

    public GuildOnlineMemberDialogFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.guild.setting.member.view.GuildOnlineMemberDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(e02.c.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.guild.setting.member.view.GuildOnlineMemberDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.mostSpanCount = dh1.a.f393835a.f();
        this.guildObserver = new c();
        this.cardShowListener = new b();
    }

    private final int Dh(IGProChannelInfo channelInfo) {
        String str;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam.JoinInfoParam joinInfoParam2;
        Integer num = X.get(Integer.valueOf(channelInfo.getType()));
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        if (channelInfo.getType() == 5) {
            Bundle startParamsBundle = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).getStartParamsBundle();
            String str2 = null;
            if (startParamsBundle != null && (joinInfoParam2 = (JumpGuildParam.JoinInfoParam) startParamsBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
                str = joinInfoParam2.getMainSource();
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (startParamsBundle != null && (joinInfoParam = (JumpGuildParam.JoinInfoParam) startParamsBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
                str2 = joinInfoParam.getSubSource();
            }
            if (str2 != null) {
                str3 = str2;
            }
            return GuildProfileData.getSceneTypeBySource(str, str3, 4);
        }
        return intValue;
    }

    private final e02.c Eh() {
        return (e02.c) this.viewModel.getValue();
    }

    private final void Fh() {
        HashMap hashMap = new HashMap();
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(String.valueOf(this.mChannelId), hashMap);
        w.b(hashMap);
        VideoReport.addToDetectionWhitelist(getActivity());
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        VideoReport.setPageId(viewGroup, "pg_sgrp_sub_channel_online");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        iGuildDTReportApi.setChannelPageParams(viewGroup3, str, String.valueOf(this.mChannelId), hashMap);
        ViewGroup viewGroup4 = this.mRootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup4;
        }
        VideoReport.setPageReportPolicy(viewGroup2, PageReportPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final cg1.b Ih() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(final String tinyId) {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).hide();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.view.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildOnlineMemberDialogFragment.Kh(GuildOnlineMemberDialogFragment.this, tinyId);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(GuildOnlineMemberDialogFragment this$0, String tinyId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        this$0.dismissAllowingStateLoss();
        this$0.Mh(tinyId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(GuildOnlineMemberDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Mh(String tinyId) {
        String str;
        if (getActivity() != null && !requireActivity().isFinishing()) {
            String valueOf = String.valueOf(this.mChannelId);
            AppRuntime m3 = ch.m();
            String str2 = this.mGuildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                str2 = null;
            }
            IGProChannelInfo C = ch.C(m3, str2, String.valueOf(this.mChannelId));
            if (TextUtils.isEmpty(valueOf)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str3 = "jumpToGuildProfile: channelId[" + valueOf + "]";
                if (str3 instanceof String) {
                    bVar.a().add(str3);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.userl.GuildOnlineMemberDialogFragment", 1, (String) it.next(), null);
                }
                return;
            }
            if (C == null) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("jumpToGuildProfile: channelInfo is null");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.userl.GuildOnlineMemberDialogFragment", 1, (String) it5.next(), null);
                }
                return;
            }
            if (!Y.contains(Integer.valueOf(C.getType()))) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                String str4 = "jumpToGuildProfile: unknown channelType: " + C.getType();
                if (str4 instanceof String) {
                    bVar3.a().add(str4);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("Guild.userl.GuildOnlineMemberDialogFragment", 1, (String) it6.next(), null);
                }
                return;
            }
            String str5 = this.mGuildId;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                str = null;
            } else {
                str = str5;
            }
            String valueOf2 = String.valueOf(this.mChannelId);
            Integer num = W.get(Integer.valueOf(C.getType()));
            Intrinsics.checkNotNull(num);
            GuildProfileData guildProfileData = new GuildProfileData(str, valueOf2, tinyId, num.intValue(), Dh(C));
            guildProfileData.getGuildBaseProfileData().r(String.valueOf(this.mChannelId));
            GuildProfileCard.Mh(getActivity(), guildProfileData, this.cardShowListener);
        }
    }

    private final void Nh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        int c16 = bv.c(getContext());
        int a16 = bv.a(getContext());
        if (c16 > 0 && a16 > 0) {
            window.setLayout(-1, (a16 - c16) - getResources().getDimensionPixelSize(R.dimen.f158964cd4));
            window.setGravity(80);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        if (Eh().S1().getValue() != null && Eh().R1().getValue() != null) {
            ImageView imageView = this.mSkeleton;
            ViewGroup viewGroup = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSkeleton");
                imageView = null;
            }
            imageView.setVisibility(8);
            ViewGroup viewGroup2 = this.mContent;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(0);
        }
    }

    private final void Qh(int spanCount) {
        this.mostSpanCount = spanCount;
        RecyclerView recyclerView = this.mChannelList;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelList");
            recyclerView = null;
        }
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView recyclerView3 = this.mChannelList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelList");
            } else {
                recyclerView2 = recyclerView3;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            ((GridLayoutManager) layoutManager).setSpanCount(spanCount);
        }
    }

    private final void initData() {
        ((IGPSService) ch.S0(IGPSService.class, "")).addObserver(this.guildObserver);
        e02.c Eh = Eh();
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        Eh.U1(str, this.mChannelId);
        MutableLiveData<List<GuildMemberAvatarInfo>> S1 = Eh().S1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends GuildMemberAvatarInfo>, Unit> function1 = new Function1<List<? extends GuildMemberAvatarInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.view.GuildOnlineMemberDialogFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildMemberAvatarInfo> list) {
                invoke2((List<GuildMemberAvatarInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<GuildMemberAvatarInfo> dataList) {
                ViewGroup viewGroup;
                GuildMemberAvatarAdapter guildMemberAvatarAdapter;
                ViewGroup viewGroup2;
                GuildMemberAvatarAdapter guildMemberAvatarAdapter2 = null;
                ViewGroup viewGroup3 = null;
                if (dataList.isEmpty()) {
                    viewGroup2 = GuildOnlineMemberDialogFragment.this.mAvatarWrapper;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAvatarWrapper");
                    } else {
                        viewGroup3 = viewGroup2;
                    }
                    viewGroup3.setVisibility(8);
                } else {
                    viewGroup = GuildOnlineMemberDialogFragment.this.mAvatarWrapper;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAvatarWrapper");
                        viewGroup = null;
                    }
                    viewGroup.setVisibility(0);
                    guildMemberAvatarAdapter = GuildOnlineMemberDialogFragment.this.mAvatarAdapter;
                    if (guildMemberAvatarAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAvatarAdapter");
                    } else {
                        guildMemberAvatarAdapter2 = guildMemberAvatarAdapter;
                    }
                    Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                    guildMemberAvatarAdapter2.k0(dataList);
                }
                GuildOnlineMemberDialogFragment.this.Ph();
            }
        };
        S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.view.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildOnlineMemberDialogFragment.Gh(Function1.this, obj);
            }
        });
        MutableLiveData<List<dg1.b>> R1 = Eh().R1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final GuildOnlineMemberDialogFragment$initData$2 guildOnlineMemberDialogFragment$initData$2 = new GuildOnlineMemberDialogFragment$initData$2(this);
        R1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.view.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildOnlineMemberDialogFragment.Hh(Function1.this, obj);
            }
        });
    }

    private final void initView() {
        RecyclerView recyclerView;
        ViewGroup viewGroup = this.mRootView;
        RecyclerView recyclerView2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.content)");
        this.mContent = (ViewGroup) findViewById;
        ViewGroup viewGroup2 = this.mRootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup2 = null;
        }
        View findViewById2 = viewGroup2.findViewById(R.id.f85764pu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.skeleton)");
        this.mSkeleton = (ImageView) findViewById2;
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        View findViewById3 = viewGroup3.findViewById(R.id.t1o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.avatar_list_wrapper)");
        this.mAvatarWrapper = (ViewGroup) findViewById3;
        ViewGroup viewGroup4 = this.mRootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup4 = null;
        }
        View findViewById4 = viewGroup4.findViewById(R.id.ts6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.channel_list_wrapper)");
        this.mChannelListWrapper = (ViewGroup) findViewById4;
        ViewGroup viewGroup5 = this.mRootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup5 = null;
        }
        View findViewById5 = viewGroup5.findViewById(R.id.t1l);
        RecyclerView recyclerView3 = (RecyclerView) findViewById5;
        recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext(), 0, false));
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        this.mAvatarAdapter = new GuildMemberAvatarAdapter(str, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.view.GuildOnlineMemberDialogFragment$initView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildOnlineMemberDialogFragment.this.Jh(it);
            }
        });
        recyclerView3.addItemDecoration(new d());
        GuildMemberAvatarAdapter guildMemberAvatarAdapter = this.mAvatarAdapter;
        if (guildMemberAvatarAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarAdapter");
            guildMemberAvatarAdapter = null;
        }
        recyclerView3.setAdapter(guildMemberAvatarAdapter);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById<R\u2026 mAvatarAdapter\n        }");
        this.mAvatarList = recyclerView3;
        this.mChannelAdapter = new cg1.a(Ih());
        ViewGroup viewGroup6 = this.mRootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup6 = null;
        }
        View findViewById6 = viewGroup6.findViewById(R.id.ts5);
        RecyclerView recyclerView4 = (RecyclerView) findViewById6;
        recyclerView4.setLayoutManager(new GridLayoutManager(recyclerView4.getContext(), this.mostSpanCount));
        cg1.a aVar = this.mChannelAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelAdapter");
            aVar = null;
        }
        recyclerView4.setAdapter(aVar);
        recyclerView4.addItemDecoration(new e());
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById<R\u2026\n            })\n        }");
        this.mChannelList = recyclerView4;
        GuildLivePlayerTag guildLivePlayerTag = GuildLivePlayerTag.ONLINE_MEMBER_DIALOG;
        RecyclerView recyclerView5 = this.mChannelList;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelList");
            recyclerView = null;
        } else {
            recyclerView = recyclerView5;
        }
        this.mVisibleAreaVideoController = new com.tencent.mobileqq.guild.channelcard.videoplay.c(guildLivePlayerTag, recyclerView, 0, 4, null);
        RecyclerView recyclerView6 = this.mChannelList;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelList");
        } else {
            recyclerView2 = recyclerView6;
        }
        this.mAnimationControl = new AnimationControl(recyclerView2);
    }

    public final void Oh(@Nullable d02.b listener) {
        this.clickListener = listener;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int f16 = QQGuildUIUtil.f(newConfig.screenWidthDp * 1.0f);
        dh1.a aVar = dh1.a.f393835a;
        aVar.g(f16);
        Qh(aVar.f());
        Nh();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.a0o;
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.addBottomSheetCallback(new g());
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f1o, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        Bundle arguments = getArguments();
        String str2 = "";
        ViewGroup viewGroup = null;
        if (arguments != null) {
            str = arguments.getString("guild_id", "");
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        this.mGuildId = str2;
        Bundle arguments2 = getArguments();
        long j3 = 0;
        if (arguments2 != null) {
            j3 = arguments2.getLong("channel_id", 0L);
        }
        this.mChannelId = j3;
        initView();
        initData();
        Fh();
        ViewGroup viewGroup2 = this.mRootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup = viewGroup2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IGPSService) ch.S0(IGPSService.class, "")).deleteObserver(this.guildObserver);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ViewGroup viewGroup = this.mRootView;
        com.tencent.mobileqq.guild.channelcard.videoplay.c cVar = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        VideoReport.reportPgOut(viewGroup);
        com.tencent.mobileqq.guild.channelcard.videoplay.c cVar2 = this.mVisibleAreaVideoController;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisibleAreaVideoController");
        } else {
            cVar = cVar2;
        }
        cVar.k();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewGroup viewGroup = this.mRootView;
        com.tencent.mobileqq.guild.channelcard.videoplay.c cVar = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        VideoReport.reportPgIn(viewGroup);
        com.tencent.mobileqq.guild.channelcard.videoplay.c cVar2 = this.mVisibleAreaVideoController;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisibleAreaVideoController");
        } else {
            cVar = cVar2;
        }
        cVar.g();
        Nh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        ((ViewGroup) viewGroup.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.member.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildOnlineMemberDialogFragment.Lh(GuildOnlineMemberDialogFragment.this, view);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildOnlineMemberDialogFragment$b", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildProfileCard.e {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void a() {
            GuildOnlineMemberDialogFragment.this.dismiss();
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public /* synthetic */ void c() {
            com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.h.a(this);
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void b() {
        }
    }
}
