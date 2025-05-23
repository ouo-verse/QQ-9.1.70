package com.tencent.mobileqq.guild.media.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0003|\u0080\u0001\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u0002:\u0002\u0087\u0001B\u0019\u0012\u0006\u0010D\u001a\u00020?\u0012\u0006\u0010J\u001a\u00020E\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J \u0010$\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J\u001a\u0010*\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\bH\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016J$\u00104\u001a\u00020'2\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u0001022\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u00105\u001a\u00020\u0003H\u0016J\u000e\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u00020\bJ\u000e\u0010:\u001a\u00020\u00032\u0006\u00109\u001a\u000208J\u000e\u0010;\u001a\u00020\u00032\u0006\u00109\u001a\u000208J\u000e\u0010<\u001a\u00020\u00032\u0006\u00109\u001a\u00020\bJ\u0012\u0010>\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010'H\u0016R\u0017\u0010D\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010J\u001a\u00020E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020R0Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010fR\u0016\u0010k\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010fR\"\u0010q\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010L\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR0\u0010w\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020s0rj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020s`t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "", "Ih", "initView", "Hh", "ci", "", "from", "Fh", "", "state", "", "local", "ei", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;", "fi", "di", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper;", "Ch", "Lcom/google/android/material/bottomsheet/a;", "dialog", "Gh", "ai", "bi", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Uh", "Vh", "Xh", "Wh", "status", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Zh", "Jh", "Th", "Landroid/view/View;", "reportView", "elementId", "Sh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onStart", "reason", "gi", "", "tinyId", "Bh", "Yh", "Kh", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getMGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Dh", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "E", "Z", "curMicSequenceStatus", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;", "selfMicStatus", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "G", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBehavior", "H", "Landroid/view/ViewGroup;", "mRootView", "I", "Landroid/view/View;", "mEmptyView", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "mEmptyImageView", "Landroidx/recyclerview/widget/RecyclerView;", "K", "Landroidx/recyclerview/widget/RecyclerView;", "mListView", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "mMicSequenceStatusCtrlTv", "M", "mMicSequenceStatusTv", "N", "mSelfMicCtrlTv", "P", "Eh", "()Z", "setMIsManager", "(Z)V", "mIsManager", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashMap;", "mDtPageParam", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "com/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$e", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$e;", "micQueueStateObserver", "com/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$f", "T", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$f;", "selfMicStateObserver", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMicSequenceDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IGProGuildInfo mGuildInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IGProChannelInfo mChannelInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean curMicSequenceStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MediaChannelMicSequenceHelper.MicSequenceState selfMicStatus;

    /* renamed from: G, reason: from kotlin metadata */
    private BottomSheetBehavior<FrameLayout> mBehavior;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* renamed from: I, reason: from kotlin metadata */
    private View mEmptyView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mEmptyImageView;

    /* renamed from: K, reason: from kotlin metadata */
    private RecyclerView mListView;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mMicSequenceStatusCtrlTv;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView mMicSequenceStatusTv;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView mSelfMicCtrlTv;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsManager;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mDtPageParam;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.notify.y mAudioRoomObserver;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final e micQueueStateObserver;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final f selfMicStateObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229758a;

        static {
            int[] iArr = new int[MediaChannelMicSequenceHelper.MicSequenceState.values().length];
            try {
                iArr[MediaChannelMicSequenceHelper.MicSequenceState.STATUS_ON_MIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaChannelMicSequenceHelper.MicSequenceState.STATUS_ENQUEUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaChannelMicSequenceHelper.MicSequenceState.STATUS_DEQUEUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaChannelMicSequenceHelper.MicSequenceState.STATUS_WAITTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MediaChannelMicSequenceHelper.MicSequenceState.STATUS_NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MediaChannelMicSequenceHelper.MicSequenceState.USER_STATE_DISABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f229758a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.bd> {
        public c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.bd event) {
            GuildMicSequenceDialogFragment.this.gi("UserMicSequenceEvent");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$d", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "from", "guildId", "roomId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "", HippyTKDListViewAdapter.X, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends com.tencent.mobileqq.guild.media.core.notify.y {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@NotNull String from, @NotNull String guildId, @NotNull String roomId, @NotNull com.tencent.mobileqq.guild.media.core.data.f localUserInfo) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            Intrinsics.checkNotNullParameter(localUserInfo, "localUserInfo");
            if (Intrinsics.areEqual(guildId, GuildMicSequenceDialogFragment.this.getMChannelInfo().getGuildId()) && Intrinsics.areEqual(roomId, GuildMicSequenceDialogFragment.this.getMChannelInfo().getChannelUin()) && localUserInfo.R) {
                Logger.f235387a.d().d("GuildMicSequenceDialogFragment", 1, "mAudioRoomObserver handleOnUserDataUpdate");
                GuildMicSequenceDialogFragment.this.Fh(from);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ab;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.ab> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.ab event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMicSequenceDialogFragment.this.ei(event.getState(), false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ao;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.ao> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.ao event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMicSequenceDialogFragment.this.fi(event.getState(), false);
        }
    }

    public GuildMicSequenceDialogFragment(@NotNull IGProGuildInfo mGuildInfo, @NotNull IGProChannelInfo mChannelInfo) {
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        this.mGuildInfo = mGuildInfo;
        this.mChannelInfo = mChannelInfo;
        this.selfMicStatus = MediaChannelMicSequenceHelper.MicSequenceState.STATUS_NONE;
        this.mDtPageParam = new HashMap<>();
        this.mAudioRoomObserver = new d();
        this.micQueueStateObserver = new e();
        this.selfMicStateObserver = new f();
    }

    private final MediaChannelMicSequenceHelper Ch() {
        return com.tencent.mobileqq.guild.media.core.j.a().N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(String from) {
        if (Intrinsics.areEqual(from, "onAdminChanged")) {
            Logger.a d16 = Logger.f235387a.d();
            com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.IMediaChannelInnerCore");
            d16.d("GuildMicSequenceDialogFragment", 1, "handleOnUserDataUpdate from = " + from + ", userType = " + ((com.tencent.mobileqq.guild.media.core.f) a16).getSelfUserInfo().f228097e);
            boolean Jh = Jh();
            if (Jh != this.mIsManager) {
                this.mIsManager = Jh;
                gi("onUserDataUpdate");
            }
        }
    }

    private final void Gh(com.google.android.material.bottomsheet.a dialog) {
        BottomSheetBehavior<FrameLayout> behavior = dialog.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        this.mBehavior = behavior;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        if (behavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            behavior = null;
        }
        behavior.setFitToContents(true);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.mBehavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior2;
        }
        bottomSheetBehavior.setPeekHeight(displayMetrics.heightPixels);
    }

    private final void Hh() {
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.bd.class, new c());
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.ab.class, this.micQueueStateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.ao.class, this.selfMicStateObserver);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
    }

    private final void Ih() {
        boolean z16;
        if (this.mChannelInfo.getVoiceQueueCfg().getVoiceQueueState() != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.curMicSequenceStatus = z16;
        this.selfMicStatus = Ch().getSelfMicSequenceState();
        this.mIsManager = Jh();
        Logger.f235387a.d().d("GuildMicSequenceDialogFragment", 1, "curMicSequenceStatus = " + this.curMicSequenceStatus + ",  voiceQueueState = " + getMChannelInfo().getVoiceQueueCfg().getVoiceQueueState() + ", selfMicStatus = " + this.selfMicStatus + ", mIsManager = " + getMIsManager());
    }

    private final boolean Jh() {
        if (!ch.m0(com.tencent.mobileqq.guild.media.core.j.a().getGuildID()) && !ch.h0(com.tencent.mobileqq.guild.media.core.j.a().E())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(GuildMicSequenceDialogFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch().p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildMicSequenceDialogFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch().n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildMicSequenceDialogFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch().p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(GuildMicSequenceDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Sh(View reportView, String elementId) {
        if (reportView == null) {
            return;
        }
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", reportView, this.mDtPageParam);
    }

    private final void Th() {
        VideoReport.addToDetectionWhitelist(requireActivity());
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        VideoReport.setPageId(viewGroup, "pg_sgrp_avchannel_queue_manage");
        HashMap<String, Object> hashMap = this.mDtPageParam;
        String channelUin = this.mChannelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo.channelUin");
        hashMap.put("sgrp_sub_channel_id", channelUin);
        HashMap<String, Object> hashMap2 = this.mDtPageParam;
        String channelName = this.mChannelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "mChannelInfo.channelName");
        hashMap2.put("sgrp_sub_channel_name", channelName);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        iGuildDTReportApi.setGuildPageParams(viewGroup2, com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), this.mDtPageParam);
    }

    private final void Uh(Activity activity) {
        TextView textView = this.mMicSequenceStatusCtrlTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView = null;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f139890ch));
        TextView textView3 = this.mMicSequenceStatusCtrlTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView3 = null;
        }
        textView3.setBackground(activity.getDrawable(R.drawable.guild_media_channel_mic_status_btn_bg));
        TextView textView4 = this.mMicSequenceStatusCtrlTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView4 = null;
        }
        textView4.setTextColor(getResources().getColorStateList(R.color.f157157bs3));
        TextView textView5 = this.mMicSequenceStatusTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusTv");
        } else {
            textView2 = textView5;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.f140150d7));
    }

    private final void Vh(Activity activity) {
        TextView textView = this.mMicSequenceStatusCtrlTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView = null;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f139880cg));
        TextView textView3 = this.mMicSequenceStatusCtrlTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView3 = null;
        }
        textView3.setBackground(activity.getDrawable(R.drawable.guild_media_channel_item_invite_btn_bg));
        TextView textView4 = this.mMicSequenceStatusCtrlTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView4 = null;
        }
        textView4.setTextColor(Color.parseColor("#FFFFFFFF"));
        TextView textView5 = this.mMicSequenceStatusTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusTv");
        } else {
            textView2 = textView5;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.f140160d8));
    }

    private final void Wh(Activity activity) {
        TextView textView = this.mSelfMicCtrlTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
            textView = null;
        }
        textView.setBackground(activity.getDrawable(R.drawable.guild_media_channel_stop_mic_queue_btn));
        TextView textView3 = this.mSelfMicCtrlTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(getResources().getColorStateList(R.color.bs5));
    }

    private final void Xh(Activity activity) {
        TextView textView = this.mSelfMicCtrlTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
            textView = null;
        }
        textView.setTextColor(getResources().getColor(R.color.bun));
        TextView textView3 = this.mSelfMicCtrlTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
        } else {
            textView2 = textView3;
        }
        textView2.setBackground(activity.getDrawable(R.drawable.guild_media_channel_item_invite_btn_bg));
    }

    private final void Zh(MediaChannelMicSequenceHelper.MicSequenceState status, DialogInterface.OnClickListener onConfirm, DialogInterface.OnClickListener onCancel) {
        String str;
        String str2;
        if (status == MediaChannelMicSequenceHelper.MicSequenceState.STATUS_ENQUEUE) {
            str = "\u786e\u5b9a\u9000\u51fa\u6392\u9ea6\u961f\u5217\u5417\uff1f";
            str2 = "\u786e\u5b9a";
        } else {
            str = "\u786e\u5b9a\u63d0\u524d\u4e0b\u9ea6\u5417\uff1f";
            str2 = "\u4e0b\u9ea6";
        }
        String str3 = str2;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, str, "\u53d6\u6d88", str3, onConfirm, onCancel);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nfirm, onCancel\n        )");
        createCustomDialog.show();
    }

    private final void ai() {
        Ch().A1();
    }

    private final void bi() {
        Ch().C1();
    }

    private final void ci() {
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.ab.class, this.micQueueStateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.ao.class, this.selfMicStateObserver);
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
    }

    private final void di() {
        RecyclerView recyclerView;
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("updateListView");
        Iterator<T> it = bVar.a().iterator();
        while (true) {
            recyclerView = null;
            if (!it.hasNext()) {
                break;
            }
            Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it.next(), null);
        }
        List<IGProUserInfo> d16 = Ch().d1();
        if (d16.isEmpty()) {
            View view = this.mEmptyView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                view = null;
            }
            view.setVisibility(0);
            RecyclerView recyclerView2 = this.mListView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        View view2 = this.mEmptyView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            view2 = null;
        }
        view2.setVisibility(8);
        RecyclerView recyclerView3 = this.mListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView3 = null;
        }
        recyclerView3.setVisibility(0);
        RecyclerView recyclerView4 = this.mListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        } else {
            recyclerView = recyclerView4;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.adapter.GuildMicSequenceAdapter");
        ((com.tencent.mobileqq.guild.media.widget.adapter.a) adapter).updateList(d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(int state, boolean local) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "updateMicQueueState: state = " + state + ", local = " + local;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it.next(), null);
            }
            if (state != 0 && state != 1) {
                if (state == 2) {
                    Vh(activity);
                    this.curMicSequenceStatus = false;
                }
            } else {
                Uh(activity);
                this.curMicSequenceStatus = true;
            }
            fi(Ch().getSelfMicSequenceState(), local);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(MediaChannelMicSequenceHelper.MicSequenceState state, boolean local) {
        TextView textView;
        this.selfMicStatus = state;
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "updateSelfMicCtrlTv: state[" + state + "], isLocal: " + local;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (true) {
            textView = null;
            if (!it.hasNext()) {
                break;
            }
            Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it.next(), null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            switch (b.f229758a[state.ordinal()]) {
                case 1:
                    TextView textView2 = this.mSelfMicCtrlTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                        textView2 = null;
                    }
                    textView2.setAlpha(1.0f);
                    TextView textView3 = this.mSelfMicCtrlTv;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                    } else {
                        textView = textView3;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f140490e4));
                    Wh(activity);
                    return;
                case 2:
                    TextView textView4 = this.mSelfMicCtrlTv;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                        textView4 = null;
                    }
                    textView4.setAlpha(1.0f);
                    TextView textView5 = this.mSelfMicCtrlTv;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                    } else {
                        textView = textView5;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f140520e7));
                    Wh(activity);
                    return;
                case 3:
                    if (!this.curMicSequenceStatus) {
                        TextView textView6 = this.mSelfMicCtrlTv;
                        if (textView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                            textView6 = null;
                        }
                        textView6.setAlpha(0.3f);
                    } else {
                        TextView textView7 = this.mSelfMicCtrlTv;
                        if (textView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                            textView7 = null;
                        }
                        textView7.setAlpha(1.0f);
                    }
                    TextView textView8 = this.mSelfMicCtrlTv;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                    } else {
                        textView = textView8;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f140500e5));
                    Xh(activity);
                    return;
                case 4:
                    TextView textView9 = this.mSelfMicCtrlTv;
                    if (textView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                        textView9 = null;
                    }
                    textView9.setAlpha(1.0f);
                    TextView textView10 = this.mSelfMicCtrlTv;
                    if (textView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                    } else {
                        textView = textView10;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f140490e4));
                    Wh(activity);
                    return;
                case 5:
                    if (!this.curMicSequenceStatus) {
                        TextView textView11 = this.mSelfMicCtrlTv;
                        if (textView11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                            textView11 = null;
                        }
                        textView11.setAlpha(0.3f);
                    } else {
                        TextView textView12 = this.mSelfMicCtrlTv;
                        if (textView12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                            textView12 = null;
                        }
                        textView12.setAlpha(1.0f);
                    }
                    TextView textView13 = this.mSelfMicCtrlTv;
                    if (textView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                    } else {
                        textView = textView13;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f140500e5));
                    Xh(activity);
                    return;
                case 6:
                    TextView textView14 = this.mSelfMicCtrlTv;
                    if (textView14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                        textView14 = null;
                    }
                    textView14.setAlpha(0.3f);
                    TextView textView15 = this.mSelfMicCtrlTv;
                    if (textView15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                    } else {
                        textView = textView15;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f140500e5));
                    Xh(activity);
                    return;
                default:
                    return;
            }
        }
    }

    private final void initView() {
        ViewGroup viewGroup = this.mRootView;
        ImageView imageView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        View findViewById = viewGroup.getRootView().findViewById(R.id.bww);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.rootView.findV\u2026ewGroup>(R.id.empty_view)");
        this.mEmptyView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            findViewById = null;
        }
        findViewById.setVisibility(0);
        ViewGroup viewGroup2 = this.mRootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup2 = null;
        }
        View findViewById2 = viewGroup2.findViewById(R.id.eap);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        String guildId = this.mChannelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "mChannelInfo.guildId");
        recyclerView.setAdapter(new com.tencent.mobileqq.guild.media.widget.adapter.a(guildId, this, this.mDtPageParam));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById<R\u2026Detach = true }\n        }");
        this.mListView = recyclerView;
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        View findViewById3 = viewGroup3.getRootView().findViewById(R.id.f657539s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.rootView.findV\u2026ew>(R.id.queue_status_tv)");
        this.mMicSequenceStatusTv = (TextView) findViewById3;
        ViewGroup viewGroup4 = this.mRootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup4 = null;
        }
        View findViewById4 = viewGroup4.getRootView().findViewById(R.id.z68);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.rootView.findV\u2026ic_sequence_queue_ctr_tv)");
        TextView textView = (TextView) findViewById4;
        this.mMicSequenceStatusCtrlTv = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        if (this.mIsManager) {
            TextView textView2 = this.mMicSequenceStatusCtrlTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            TextView textView3 = this.mMicSequenceStatusCtrlTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        ViewGroup viewGroup5 = this.mRootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup5 = null;
        }
        View findViewById5 = viewGroup5.getRootView().findViewById(R.id.z66);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.rootView.findV\u2026View>(R.id.mic_ctrl_text)");
        TextView textView4 = (TextView) findViewById5;
        this.mSelfMicCtrlTv = textView4;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
            textView4 = null;
        }
        textView4.setOnClickListener(this);
        ViewGroup viewGroup6 = this.mRootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup6 = null;
        }
        View findViewById6 = viewGroup6.getRootView().findViewById(R.id.uub);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.rootView.findViewById(R.id.empty_iv)");
        ImageView imageView2 = (ImageView) findViewById6;
        this.mEmptyImageView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyImageView");
        } else {
            imageView = imageView2;
        }
        com.tencent.mobileqq.guild.u.q("https://downv6.qq.com/innovate/guild/media_game/guild_media_mic_seq_empty.png", imageView, true);
        gi("initView");
    }

    public final void Bh(long tinyId) {
        Ch().l1(tinyId);
    }

    @NotNull
    /* renamed from: Dh, reason: from getter */
    public final IGProChannelInfo getMChannelInfo() {
        return this.mChannelInfo;
    }

    /* renamed from: Eh, reason: from getter */
    public final boolean getMIsManager() {
        return this.mIsManager;
    }

    public final void Kh(@NotNull String tinyId) {
        com.tencent.mobileqq.guild.media.core.data.p pVar;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        if (TextUtils.isEmpty(E)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "jumpToGuildProfile: channelId[" + E + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it.next(), null);
            }
            return;
        }
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo();
        if (selfUserInfo == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "jumpToGuildProfile: can not find self user info. channelId[" + E + "]";
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it5.next(), null);
            }
            return;
        }
        List<com.tencent.mobileqq.guild.media.core.data.p> list = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "getDataHub().userInfoList.anchors");
        ListIterator<com.tencent.mobileqq.guild.media.core.data.p> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                pVar = listIterator.previous();
                if (TextUtils.equals(pVar.f228093a, tinyId)) {
                    break;
                }
            } else {
                pVar = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.media.core.data.p pVar2 = pVar;
        if (pVar2 == null) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            String str3 = "jumpToGuildProfile: can not find target user. channelId[" + E + "]";
            if (str3 instanceof String) {
                bVar3.a().add(str3);
            }
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it6.next(), null);
            }
            return;
        }
        GuildProfileData guildProfileData = new GuildProfileData(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), tinyId, 1, MediaChannelUtils.f228046a.l());
        guildProfileData.getExtras().putParcelable(GuildProfileData.KEY_CHANNEL_DATA, new GuildAudioChannelData(com.tencent.mobileqq.guild.media.core.j.a().E(), 2, selfUserInfo.f228093a, selfUserInfo.f228097e, pVar2.f228093a, pVar2.f228097e, pVar2.f228112t, pVar2.f228113u, pVar2.f228105m));
        guildProfileData.getGuildBaseProfileData().r(E);
        GuildProfileCard.Lh(getActivity(), guildProfileData);
    }

    public final void Yh(long tinyId) {
        Ch().E1(tinyId);
    }

    public final void gi(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "updateUI for reason = " + reason;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildMicSequenceDialogFragment", 1, (String) it.next(), null);
        }
        ei(Ch().getMMicQueueState(), false);
        fi(Ch().getSelfMicSequenceState(), false);
        di();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        TextView textView = this.mMicSequenceStatusCtrlTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceStatusCtrlTv");
            textView = null;
        }
        if (Intrinsics.areEqual(v3, textView)) {
            if (this.curMicSequenceStatus) {
                Logger.f235387a.d().d("GuildMicSequenceDialogFragment", 1, "onClick,  handleStopMicSequence ");
                bi();
                this.curMicSequenceStatus = false;
                ei(2, true);
                Sh(v3, "em_sgrp_queuemanage_stop");
            } else {
                Logger.f235387a.d().d("GuildMicSequenceDialogFragment", 1, "onClick,  handleStartMicSequence ");
                ai();
                this.curMicSequenceStatus = true;
                ei(1, true);
                Sh(v3, "em_sgrp_queuemanage_resume");
            }
        } else {
            TextView textView2 = this.mSelfMicCtrlTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelfMicCtrlTv");
                textView2 = null;
            }
            if (Intrinsics.areEqual(v3, textView2)) {
                switch (b.f229758a[this.selfMicStatus.ordinal()]) {
                    case 1:
                        Zh(this.selfMicStatus, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ah
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                GuildMicSequenceDialogFragment.Lh(GuildMicSequenceDialogFragment.this, dialogInterface, i3);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ai
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                GuildMicSequenceDialogFragment.Mh(dialogInterface, i3);
                            }
                        });
                        break;
                    case 2:
                        Zh(this.selfMicStatus, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.aj
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                GuildMicSequenceDialogFragment.Nh(GuildMicSequenceDialogFragment.this, dialogInterface, i3);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ak
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                GuildMicSequenceDialogFragment.Oh(dialogInterface, i3);
                            }
                        });
                        Sh(v3, "em_sgrp_avchannel_queueout");
                        break;
                    case 3:
                        if (!this.curMicSequenceStatus) {
                            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f140510e6), 1).show();
                            break;
                        } else {
                            MediaChannelMicSequenceHelper.s1(Ch(), null, 1, null);
                            Sh(v3, "em_sgrp_avchannel_queueup");
                            break;
                        }
                    case 4:
                        Zh(this.selfMicStatus, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.al
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                GuildMicSequenceDialogFragment.Ph(GuildMicSequenceDialogFragment.this, dialogInterface, i3);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.am
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                GuildMicSequenceDialogFragment.Qh(dialogInterface, i3);
                            }
                        });
                        break;
                    case 5:
                        if (!this.curMicSequenceStatus) {
                            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f140510e6), 1).show();
                            break;
                        } else {
                            MediaChannelMicSequenceHelper.s1(Ch(), null, 1, null);
                            Sh(v3, "em_sgrp_avchannel_queueup");
                            break;
                        }
                    case 6:
                        MediaChannelMicSequenceHelper.s1(Ch(), null, 1, null);
                        Sh(v3, "em_sgrp_avchannel_queueup");
                        break;
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
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
        Gh(aVar);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ezu, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        Ih();
        initView();
        Hh();
        Th();
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ci();
        super.onDestroy();
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
        viewGroup2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMicSequenceDialogFragment.Rh(GuildMicSequenceDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(DialogInterface dialogInterface, int i3) {
    }
}
