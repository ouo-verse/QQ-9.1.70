package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.repository.OnlineStatusLikeRepository;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.onlinestatus.utils.z;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusFriendListFragment;
import com.tencent.mobileqq.onlinestatus.view.ak;
import com.tencent.mobileqq.onlinestatus.x;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusExtInfo$SynchVideoBizInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001kB+\u0012\u000e\b\u0002\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00140d\u0012\b\b\u0002\u0010f\u001a\u00020\f\u0012\b\b\u0002\u0010g\u001a\u00020\f\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J$\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010+\u001a\u00020*2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\u001c\u00104\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000402H\u0016J\u001c\u00105\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000402H\u0016R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR$\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010MR$\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR*\u0010]\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0011\u0010b\u001a\u00020/8F\u00a2\u0006\u0006\u001a\u0004\bb\u0010c\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/onlinestatus/view/ak;", "", "initView", "Th", "Landroid/view/View;", "v", "Oh", "Sh", "Bh", "", "likeType", "Hh", "Kh", "Qh", "Ph", "Lmqq/app/AppRuntime$Status;", "status", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "curFriend", "Uh", "Mh", "curFriends", "yh", "Lh", GuildMsgItem.NICK_FRIEND, "Rh", "Dh", "Eh", "Ch", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Dialog;", "onCreateDialog", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.ON_CLICK, "", "r", "Z", "Lkotlin/Function1;", "listener", "z1", "Dg", "Lcom/tencent/common/app/AppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/common/app/AppInterface;", "mAppInterface", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/n;", "D", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/n;", "mOnlineStatusCardListAdapter", "E", "I", "mCurrentSelectIndex", "Lcom/tencent/mobileqq/onlinestatus/viewmodel/i;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/onlinestatus/viewmodel/i;", "mViewModel", "Lcom/tencent/mobileqq/onlinestatus/viewmodel/j;", "G", "Lcom/tencent/mobileqq/onlinestatus/viewmodel/j;", "mViewModelFactory", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding;", "H", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding;", "mBinding", "Lkotlin/jvm/functions/Function1;", "mDismissListener", "J", "mShowListener", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;", "K", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;", "mReporter", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/OnlineStatusFriendListFragment;", "L", "Lmqq/util/WeakReference;", "getMWeakReferenceFragment", "()Lmqq/util/WeakReference;", "Nh", "(Lmqq/util/WeakReference;)V", "mWeakReferenceFragment", "Lcom/tencent/mobileqq/onlinestatus/av;", "M", "Lcom/tencent/mobileqq/onlinestatus/av;", "mOnlineStatusObserver", "isShowing", "()Z", "", "friendsList", "selectIndex", IProfileCardConst.KEY_FROM_TYPE, "<init>", "(Ljava/util/List;II)V", "N", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusLikeWithAvatarDialog extends BottomSheetDialogFragment implements View.OnClickListener, ak {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AppInterface mAppInterface;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final n mOnlineStatusCardListAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private int mCurrentSelectIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.onlinestatus.viewmodel.i mViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.onlinestatus.viewmodel.j mViewModelFactory;

    /* renamed from: H, reason: from kotlin metadata */
    private OnlineStatusLikeWithAvatarBinding mBinding;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Function1<? super ak, Unit> mDismissListener;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Function1<? super ak, Unit> mShowListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final OnlineStatusLikeWithAvatarReporter mReporter;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private WeakReference<OnlineStatusFriendListFragment> mWeakReferenceFragment;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final av mOnlineStatusObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog$b", "Lcom/tencent/mobileqq/onlinestatus/av;", "", "isSuccess", "Landroid/os/Bundle;", "data", "", "f", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends av {
        b() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean isSuccess, @Nullable Bundle data) {
            int i3;
            if (data != null) {
                i3 = (int) data.getLong("onlineStatus", 0L);
            } else {
                i3 = 0;
            }
            AppRuntime.Status build = AppRuntime.Status.build(i3);
            if (isSuccess) {
                String string = OnlineStatusLikeWithAvatarDialog.this.getResources().getString(R.string.f69, ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(build, af.C().M(OnlineStatusLikeWithAvatarDialog.this.mAppInterface), false).f255490c);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026_online_tips, item.title)");
                QQToast.makeText(OnlineStatusLikeWithAvatarDialog.this.getContext(), 2, string, 1).show();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends BottomSheetBehavior.e {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (QLog.isColorLevel()) {
                QLog.i("OnlineStatusLikeWithAvatarDialog", 2, "onSlide\uff1aslideOffset = " + slideOffset);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (QLog.isColorLevel()) {
                QLog.i("OnlineStatusLikeWithAvatarDialog", 2, "onStateChanged\uff1anewState = " + newState);
            }
            if (newState == 4) {
                OnlineStatusLikeWithAvatarDialog.this.dismiss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends ViewOutlineProvider {
        d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(28.0f));
            outline.setAlpha(0.3f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog$e", "Lh43/e;", "", "b", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements h43.e {
        e() {
        }

        @Override // h43.e
        public void a() {
            if (QLog.isColorLevel()) {
                QLog.i("OnlineStatusLikeWithAvatarDialog", 2, "[stepCountStatus] onPermissionDenied");
            }
        }

        @Override // h43.e
        public void b() {
            OnlineStatusLikeWithAvatarDialog.this.Ph();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog$f", "Lec2/a;", "", "success", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements ec2.a {
        f() {
        }

        @Override // ec2.a
        public void a(boolean success) {
            QLog.i("OnlineStatusLikeWithAvatarDialog", 1, "[OnClick]: reuslt is " + success);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog$g", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class g extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime.Status f256687b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.onlinestatus.model.d f256688c;

        g(AppRuntime.Status status, com.tencent.mobileqq.onlinestatus.model.d dVar) {
            this.f256687b = status;
            this.f256688c = dVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            OnlineStatusLikeWithAvatarDialog.this.Mh(this.f256687b, this.f256688c);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            if (com.tencent.mobileqq.weather.util.i.a(OnlineStatusLikeWithAvatarDialog.this.getActivity(), QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)) {
                OnlineStatusLikeWithAvatarDialog.this.Mh(this.f256687b, this.f256688c);
            }
        }
    }

    public OnlineStatusLikeWithAvatarDialog() {
        this(null, 0, 0, 7, null);
    }

    private final void Bh() {
        if (getContext() == null) {
            return;
        }
        Object systemService = requireContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(new long[]{0, 1, 20, 21}, -1);
    }

    private final void Ch() {
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        String M1 = iVar.M1();
        if (TextUtils.isEmpty(M1)) {
            QLog.i("OnlineStatusLikeWithAvatarDialog", 1, "jumpSchema is null");
        } else {
            bs.s0(M1, getActivity());
        }
    }

    private final void Dh() {
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        AllInOne allInOne = new AllInOne(iVar.N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), 1);
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding2 = this.mBinding;
        if (onlineStatusLikeWithAvatarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            onlineStatusLikeWithAvatarBinding = onlineStatusLikeWithAvatarBinding2;
        }
        ProfileUtils.openProfileCard(onlineStatusLikeWithAvatarBinding.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.getContext(), allInOne);
    }

    private final void Eh() {
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        com.tencent.mobileqq.onlinestatus.model.d N1 = iVar.N1();
        au onlineStatusItem = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(ae.c(N1.getStatus()), N1.getStatus().e0(), false);
        if (onlineStatusItem != null && !TextUtils.isEmpty(onlineStatusItem.f255501n)) {
            bs.s0(onlineStatusItem.f255501n, getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(vc2.a layoutManager, OnlineStatusLikeWithAvatarDialog this$0, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(layoutManager, "$layoutManager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        View findViewByPosition = layoutManager.findViewByPosition(this$0.mCurrentSelectIndex);
        if (findViewByPosition != null) {
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = this$0.mBinding;
            if (onlineStatusLikeWithAvatarBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                onlineStatusLikeWithAvatarBinding = null;
            }
            int[] calculateDistanceToFinalSnap = onlineStatusLikeWithAvatarBinding.k().calculateDistanceToFinalSnap(layoutManager, findViewByPosition);
            Intrinsics.checkNotNull(calculateDistanceToFinalSnap);
            recyclerView.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(OnlineStatusLikeWithAvatarDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Hh(int likeType) {
        if (!NetworkUtil.isNetSupport(getContext())) {
            QQToast.makeText(getContext(), 1, getResources().getString(R.string.b3j), 1).show();
            return;
        }
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        iVar.U1(likeType);
        OnlineStatusLikeWithAvatarReporter onlineStatusLikeWithAvatarReporter = this.mReporter;
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar3 = this.mViewModel;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            iVar2 = iVar3;
        }
        onlineStatusLikeWithAvatarReporter.c(likeType, iVar2.N1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ih(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(View view) {
        view.setBackground(null);
    }

    private final void Kh() {
        if (getContext() == null) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        com.tencent.mobileqq.onlinestatus.model.d N1 = iVar.N1();
        AppRuntime.Status c16 = ae.c(N1.getStatus());
        au onlineStatusItem = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(c16, N1.getStatus().e0(), false);
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        AppInterface appInterface = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface);
        IRuntimeService runtimeService = appInterface.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mAppInterface!!.getRunti\u2026ssConstant.MAIN\n        )");
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) runtimeService;
        AppRuntime.Status status = iOnlineStatusService.getOnlineStatus();
        long M = af.C().M(this.mAppInterface);
        if (onlineStatusItem.f255489b != 2000 && status == c16 && M == N1.getStatus().e0()) {
            String string = requireContext().getResources().getString(R.string.f197174ja, onlineStatusItem.f255490c);
            Intrinsics.checkNotNullExpressionValue(string, "requireContext().resourc\u2026_same_status, item.title)");
            QQToast.makeText(getContext(), 2, string, 1).show();
        } else if (com.tencent.mobileqq.config.square.a.f202944a.e(onlineStatusItem.f255489b)) {
            Bundle bundle = new Bundle();
            bundle.putInt(ProfileCardDtReportUtil.STATUS_ID, onlineStatusItem.f255494g.getValue());
            bundle.putInt("rich_status_id", (int) onlineStatusItem.f255489b);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).startSquareActivity(activity, bundle);
            }
        } else if (studyModeSwitch && !onlineStatusItem.f255497j) {
            String string2 = requireContext().getResources().getString(R.string.f197164j_, onlineStatusItem.f255490c);
            Intrinsics.checkNotNullExpressionValue(string2, "requireContext().resourc\u2026e_cannot_set, item.title)");
            QQToast.makeText(getContext(), 2, string2, 1).show();
        } else {
            long j3 = onlineStatusItem.f255489b;
            if (j3 == 2017) {
                Qh();
            } else if (j3 == 1030) {
                Intrinsics.checkNotNullExpressionValue(status, "status");
                Uh(status, N1);
            } else if (j3 == 1040) {
                Intrinsics.checkNotNullExpressionValue(status, "status");
                yh(status, N1);
            } else if (j3 == 2000) {
                iOnlineStatusService.updateDiyOnlineStatus(c16, N1.getStatus().e0(), new DiyStatusEmoInfo(N1.getStatus().x(), N1.getStatus().w(), N1.getStatus().v()));
            } else if (j3 == 1021) {
                Rh(N1);
            } else {
                iOnlineStatusService.updateOnlineStatus(c16, N1.getStatus().e0());
            }
        }
        this.mReporter.d(N1);
    }

    private final void Lh(AppRuntime.Status status, com.tencent.mobileqq.onlinestatus.model.d curFriend) {
        AppInterface appInterface = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface);
        IRuntimeService runtimeService = appInterface.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mAppInterface!!.getRunti\u2026va, ProcessConstant.MAIN)");
        ((IOnlineStatusService) runtimeService).updateOnlineStatus(status, curFriend.getStatus().e0());
        kc2.d dVar = kc2.d.f412021a;
        AppInterface appInterface2 = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface2);
        dVar.a(appInterface2, 1040);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(AppRuntime.Status status, com.tencent.mobileqq.onlinestatus.model.d curFriend) {
        AppInterface appInterface = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface);
        IRuntimeService runtimeService = appInterface.getRuntimeService(IOnlineStatusManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mAppInterface!!.getRunti\u2026ssConstant.MAIN\n        )");
        com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
        ((OnlineStatusDataManager) manager).O(9);
        AppInterface appInterface2 = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface2);
        IRuntimeService runtimeService2 = appInterface2.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "mAppInterface!!.getRunti\u2026va, ProcessConstant.MAIN)");
        ((IOnlineStatusService) runtimeService2).updateOnlineStatus(status, curFriend.getStatus().e0());
    }

    private final void Oh(View v3) {
        v3.setOutlineProvider(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            IRuntimeService runtimeService = appInterface.getRuntimeService(IOnlineStatusManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IOn\u2026va, ProcessConstant.MAIN)");
            com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
            ((OnlineStatusDataManager) manager).I(new Intent());
        }
    }

    private final void Qh() {
        if (((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            Ph();
        } else {
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).requestStepPermission(new e(), null);
        }
    }

    private final void Rh(com.tencent.mobileqq.onlinestatus.model.d friend) {
        Bundle bundle = new Bundle();
        OnlineStatusExtInfo$SynchVideoBizInfo onlineStatusExtInfo$SynchVideoBizInfo = new OnlineStatusExtInfo$SynchVideoBizInfo();
        if (!TextUtils.isEmpty(friend.getStatus().g0()) && !TextUtils.isEmpty(friend.getStatus().i0())) {
            onlineStatusExtInfo$SynchVideoBizInfo.string_cid.set(friend.getStatus().g0());
            onlineStatusExtInfo$SynchVideoBizInfo.string_tvURL.set(friend.getStatus().i0());
            onlineStatusExtInfo$SynchVideoBizInfo.synch_type.set(2);
        } else {
            onlineStatusExtInfo$SynchVideoBizInfo.synch_type.set(1);
        }
        bundle.putByteArray("TencentVideoInfo", onlineStatusExtInfo$SynchVideoBizInfo.toByteArray());
        bundle.putInt("StatusId", 1021);
        AppInterface appInterface = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface);
        BusinessHandler businessHandler = appInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
        ((OnlineStatusHandler) businessHandler).b3(5, bundle, null);
    }

    private final void Sh(View v3) {
        Boolean bool;
        Object tag = v3.getTag(R.id.f922357b);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            bs.A0(1, new f());
        }
    }

    private final void Th() {
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = this.mBinding;
        if (onlineStatusLikeWithAvatarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            onlineStatusLikeWithAvatarBinding = null;
        }
        for (com.tencent.mobileqq.onlinestatus.view.withAvatar.b bVar : onlineStatusLikeWithAvatarBinding.getLikeViewWrapperArray()) {
            ViewCompat.setElevation(bVar.e(), ViewUtils.dip2px(4.0f));
            Oh(bVar.e());
        }
    }

    private final void Uh(AppRuntime.Status status, com.tencent.mobileqq.onlinestatus.model.d curFriend) {
        QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_WEATHER_ID, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)).requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new g(status, curFriend));
    }

    private final void initView() {
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = this.mBinding;
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding2 = null;
        if (onlineStatusLikeWithAvatarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            onlineStatusLikeWithAvatarBinding = null;
        }
        View findViewById = onlineStatusLikeWithAvatarBinding.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.findViewById(R.id.f125957ng);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mBinding.rootView.findVi\u2026nline_status_icon_xieyan)");
        ((ImageView) findViewById).setBackgroundResource(R.drawable.f161165n54);
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding3 = this.mBinding;
        if (onlineStatusLikeWithAvatarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            onlineStatusLikeWithAvatarBinding3 = null;
        }
        for (com.tencent.mobileqq.onlinestatus.view.withAvatar.b bVar : onlineStatusLikeWithAvatarBinding3.getLikeViewWrapperArray()) {
            bVar.e().setOnClickListener(this);
        }
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding4 = this.mBinding;
        if (onlineStatusLikeWithAvatarBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            onlineStatusLikeWithAvatarBinding4 = null;
        }
        final RecyclerView onlineStatusCardListView = onlineStatusLikeWithAvatarBinding4.getOnlineStatusCardListView();
        onlineStatusCardListView.setItemViewCacheSize(0);
        onlineStatusCardListView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = onlineStatusCardListView.getLayoutParams();
        if (layoutParams != null) {
            float max = Math.max(1.0f, FontSettingManager.getFontScale());
            int i3 = layoutParams.height;
            layoutParams.height = (int) Math.max(i3 * 0.5f, Math.min(i3 / max, onlineStatusCardListView.getContext().getResources().getDisplayMetrics().heightPixels * 0.65f));
        } else {
            layoutParams = null;
        }
        onlineStatusCardListView.setLayoutParams(layoutParams);
        if (this.mOnlineStatusCardListAdapter.getNUM_BACKGOURND_ICON() > 0) {
            onlineStatusCardListView.setAdapter(this.mOnlineStatusCardListAdapter);
            this.mOnlineStatusCardListAdapter.m0(new Function1<Integer, OnlineStatusLikeWithAvatarViewHolder>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarDialog$initView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ OnlineStatusLikeWithAvatarViewHolder invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @Nullable
                public final OnlineStatusLikeWithAvatarViewHolder invoke(int i16) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = RecyclerView.this.findViewHolderForAdapterPosition(i16);
                    if (findViewHolderForAdapterPosition instanceof OnlineStatusLikeWithAvatarViewHolder) {
                        return (OnlineStatusLikeWithAvatarViewHolder) findViewHolderForAdapterPosition;
                    }
                    return null;
                }
            });
            int dpToPx = ViewUtils.dpToPx(16.0f);
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding5 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                onlineStatusLikeWithAvatarBinding5 = null;
            }
            Context context = onlineStatusLikeWithAvatarBinding5.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mBinding.rootView.context");
            final vc2.a aVar = new vc2.a(context, 0, false);
            onlineStatusCardListView.setLayoutManager(aVar);
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding6 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                onlineStatusLikeWithAvatarBinding6 = null;
            }
            tc2.a k3 = onlineStatusLikeWithAvatarBinding6.k();
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding7 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                onlineStatusLikeWithAvatarBinding7 = null;
            }
            k3.attachToRecyclerView(onlineStatusLikeWithAvatarBinding7.getOnlineStatusCardListView());
            if (this.mOnlineStatusCardListAdapter.getNUM_BACKGOURND_ICON() > 1) {
                aVar.r(dpToPx);
                onlineStatusCardListView.setPadding(dpToPx, 0, dpToPx, 0);
                onlineStatusCardListView.setClipToPadding(false);
            } else {
                ViewGroup.LayoutParams layoutParams2 = onlineStatusCardListView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = dpToPx;
                marginLayoutParams.rightMargin = dpToPx;
                onlineStatusCardListView.setLayoutParams(marginLayoutParams);
            }
            int i16 = this.mCurrentSelectIndex;
            if (i16 >= 0 && i16 < this.mOnlineStatusCardListAdapter.getNUM_BACKGOURND_ICON()) {
                onlineStatusCardListView.scrollToPosition(this.mCurrentSelectIndex);
                onlineStatusCardListView.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        OnlineStatusLikeWithAvatarDialog.Fh(vc2.a.this, this, onlineStatusCardListView);
                    }
                });
            }
            if (this.mOnlineStatusCardListAdapter.getNUM_BACKGOURND_ICON() == 1) {
                aVar.a(false);
            }
        }
        Th();
        if (ab.a() && AppSetting.f99565y) {
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding8 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                onlineStatusLikeWithAvatarBinding2 = onlineStatusLikeWithAvatarBinding8;
            }
            View findViewById2 = onlineStatusLikeWithAvatarBinding2.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.findViewById(R.id.y4c);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mBinding.rootView.findVi\u2026(R.id.iv_horizontal_line)");
            ImageView imageView = (ImageView) findViewById2;
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f170202in));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnlineStatusLikeWithAvatarDialog.Gh(OnlineStatusLikeWithAvatarDialog.this, view);
                }
            });
        }
    }

    private final void yh(final AppRuntime.Status status, final com.tencent.mobileqq.onlinestatus.model.d curFriends) {
        IProfileCardUtil iProfileCardUtil = (IProfileCardUtil) QRoute.api(IProfileCardUtil.class);
        AppInterface appInterface = this.mAppInterface;
        Intrinsics.checkNotNull(appInterface);
        Card initCard = iProfileCardUtil.initCard(appInterface, appInterface.getCurrentAccountUin());
        boolean z16 = false;
        if (initCard.constellation == 0) {
            QLog.d("OnlineStatusLikeWithAvatarDialog", 1, "user constellation status is 0");
            QQToast.makeText(getContext(), R.string.f196914il, 0).show();
            return;
        }
        if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileSettingStateFromCard(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION, initCard) != 2) {
            z16 = true;
        }
        if (!z16) {
            DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.f196954ip), HardCodeUtil.qqStr(R.string.f196924im), R.string.f196934in, R.string.f196944io, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    OnlineStatusLikeWithAvatarDialog.zh(OnlineStatusLikeWithAvatarDialog.this, status, curFriends, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    OnlineStatusLikeWithAvatarDialog.Ah(dialogInterface, i3);
                }
            }).show();
        } else {
            Lh(status, curFriends);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(OnlineStatusLikeWithAvatarDialog this$0, AppRuntime.Status status, com.tencent.mobileqq.onlinestatus.model.d curFriends, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        Intrinsics.checkNotNullParameter(curFriends, "$curFriends");
        this$0.Lh(status, curFriends);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.ak
    public void Dg(@NotNull Function1<? super ak, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mShowListener = listener;
    }

    public final void Nh(@Nullable WeakReference<OnlineStatusFriendListFragment> weakReference) {
        this.mWeakReferenceFragment = weakReference;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.ak
    public void Z() {
        dismiss();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.ak
    public void doOnActivityResult(int i3, int i16, @NotNull Intent intent) {
        ak.a.a(this, i3, i16, intent);
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing() && !isRemoving()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.zxx) {
            IOnLineStatueHelperApi iOnLineStatueHelperApi = (IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class);
            AppInterface appInterface = this.mAppInterface;
            FragmentActivity activity = getActivity();
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar = null;
            }
            iOnLineStatueHelperApi.handleAIOSubTitleClicked(appInterface, activity, iVar.N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), v3);
        } else if (id5 == R.id.zxs) {
            Ch();
        } else {
            boolean z16 = true;
            if (id5 == R.id.zyc) {
                Bh();
                Kh();
                Sh(v3);
                z.l(1);
            } else if (id5 == R.id.f126007nl) {
                Bh();
                Hh(1);
                z.l(2);
            } else if (id5 == R.id.f125917nc) {
                Bh();
                Hh(2);
                z.l(3);
            } else if (id5 == R.id.f125987nj) {
                Bh();
                Hh(3);
                z.l(4);
            } else if (id5 == R.id.f125997nk) {
                Bh();
                Hh(4);
                z.l(5);
            } else if (id5 == R.id.f125927nd) {
                Bh();
                Hh(5);
                z.l(6);
            } else {
                if (id5 != R.id.zxt && id5 != R.id.zxr) {
                    z16 = false;
                }
                if (z16) {
                    Dh();
                    z.d();
                    dismiss();
                } else if (id5 == R.id.zxz) {
                    Eh();
                    dismiss();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        this.mAppInterface = appInterface;
        if (appInterface != null) {
            Intrinsics.checkNotNull(appInterface);
            appInterface.addObserver(this.mOnlineStatusObserver);
        }
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(this, this.mViewModelFactory).get(com.tencent.mobileqq.onlinestatus.viewmodel.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ikeViewModel::class.java)");
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = (com.tencent.mobileqq.onlinestatus.viewmodel.i) viewModel;
        this.mViewModel = iVar;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        iVar.L1();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.e
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                boolean Ih;
                Ih = OnlineStatusLikeWithAvatarDialog.Ih(dialogInterface, i3, keyEvent);
                return Ih;
            }
        });
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.setSkipCollapsed(true);
        behavior.addBottomSheetCallback(new c());
        z.m();
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.mBinding = OnlineStatusLikeWithAvatarBinding.INSTANCE.a(inflater, container);
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = null;
        if (this.mOnlineStatusCardListAdapter.getNUM_BACKGOURND_ICON() == 0) {
            QLog.e("OnlineStatusLikeWithAvatarDialog", 1, "onCreateView itemCount = 0");
            try {
                dismissAllowingStateLoss();
            } catch (Exception e16) {
                QLog.e("OnlineStatusLikeWithAvatarDialog", 1, "onCreateView dismissAllowingStateLoss exception ", e16);
            }
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding2 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                onlineStatusLikeWithAvatarBinding = onlineStatusLikeWithAvatarBinding2;
            }
            view = onlineStatusLikeWithAvatarBinding.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String;
        } else {
            initView();
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding3 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                onlineStatusLikeWithAvatarBinding3 = null;
            }
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar = null;
            }
            onlineStatusLikeWithAvatarBinding3.d(iVar, this);
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar2 = this.mViewModel;
            if (iVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar2 = null;
            }
            iVar2.X1(this.mCurrentSelectIndex, true, true);
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar3 = this.mViewModel;
            if (iVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar3 = null;
            }
            x.f(iVar3.N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar4 = this.mViewModel;
            if (iVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar4 = null;
            }
            iVar4.M1();
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding4 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                onlineStatusLikeWithAvatarBinding4 = null;
            }
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar5 = this.mViewModel;
            if (iVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar5 = null;
            }
            onlineStatusLikeWithAvatarBinding4.g(iVar5);
            OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding5 = this.mBinding;
            if (onlineStatusLikeWithAvatarBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                onlineStatusLikeWithAvatarBinding = onlineStatusLikeWithAvatarBinding5;
            }
            view = onlineStatusLikeWithAvatarBinding.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        OnlineStatusFriendListFragment onlineStatusFriendListFragment;
        WeakReference<OnlineStatusFriendListFragment> weakReference = this.mWeakReferenceFragment;
        if (weakReference != null && (onlineStatusFriendListFragment = weakReference.get()) != null) {
            onlineStatusFriendListFragment.notifyDataSetChanged();
        }
        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = this.mViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            iVar = null;
        }
        iVar.T1();
        AppInterface appInterface = this.mAppInterface;
        if (appInterface != null) {
            appInterface.removeObserver(this.mOnlineStatusObserver);
        }
        Function1<? super ak, Unit> function1 = this.mDismissListener;
        if (function1 != null) {
            function1.invoke(this);
        }
        this.mOnlineStatusCardListAdapter.k0();
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = this.mBinding;
        final View view = null;
        if (onlineStatusLikeWithAvatarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            onlineStatusLikeWithAvatarBinding = null;
        }
        Object parent = onlineStatusLikeWithAvatarBinding.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        }
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.f
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStatusLikeWithAvatarDialog.Jh(view);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Function1<? super ak, Unit> function1 = this.mShowListener;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.ak
    public boolean r() {
        return isShowing();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.ak
    public void z1(@NotNull Function1<? super ak, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDismissListener = listener;
    }

    public /* synthetic */ OnlineStatusLikeWithAvatarDialog(List list, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 4 : i16);
    }

    public OnlineStatusLikeWithAvatarDialog(@NotNull List<com.tencent.mobileqq.onlinestatus.model.d> friendsList, int i3, int i16) {
        List mutableList;
        Intrinsics.checkNotNullParameter(friendsList, "friendsList");
        this.mCurrentSelectIndex = -1;
        OnlineStatusLikeWithAvatarReporter onlineStatusLikeWithAvatarReporter = new OnlineStatusLikeWithAvatarReporter(friendsList, i16);
        this.mReporter = onlineStatusLikeWithAvatarReporter;
        this.mOnlineStatusObserver = new b();
        OnlineStatusLikeWithAvatarExtParam onlineStatusLikeWithAvatarExtParam = new OnlineStatusLikeWithAvatarExtParam(i16, onlineStatusLikeWithAvatarReporter, null, 4, null);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) friendsList);
        OnlineStatusLikeRepository onlineStatusLikeRepository = new OnlineStatusLikeRepository(mutableList);
        n nVar = new n(onlineStatusLikeRepository, onlineStatusLikeWithAvatarExtParam);
        this.mOnlineStatusCardListAdapter = nVar;
        nVar.o0(i3);
        nVar.n0(new Function3<View, com.tencent.mobileqq.onlinestatus.model.d, Integer, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarDialog.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.mobileqq.onlinestatus.model.d dVar, Integer num) {
                invoke(view, dVar, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view, @NotNull com.tencent.mobileqq.onlinestatus.model.d friends, int i17) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(friends, "friends");
                OnlineStatusLikeWithAvatarDialog onlineStatusLikeWithAvatarDialog = OnlineStatusLikeWithAvatarDialog.this;
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusLikeWithAvatarDialog", 2, "onItemClickListener: pos = " + i17 + ", friend = " + friends);
                }
                onlineStatusLikeWithAvatarDialog.onClick(view);
            }
        });
        onlineStatusLikeRepository.u(nVar);
        this.mViewModelFactory = new com.tencent.mobileqq.onlinestatus.viewmodel.j(onlineStatusLikeRepository);
        this.mCurrentSelectIndex = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(DialogInterface dialogInterface, int i3) {
    }
}
