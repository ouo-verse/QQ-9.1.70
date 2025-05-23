package com.tencent.mobileqq.guild.media.presenter;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.notify.ah;
import com.tencent.mobileqq.guild.media.core.notify.bi;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.viewmodel.MicState;
import com.tencent.mobileqq.guild.media.widget.GuildMicSequenceDialogFragment;
import com.tencent.mobileqq.guild.media.widget.bd;
import com.tencent.mobileqq.guild.media.widget.theme.GuildMediaThemeChooseDialog;
import com.tencent.mobileqq.guild.performance.report.aa;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00f4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0006\u0088\u0001\u008b\u0001\u008e\u0001\u0018\u0000 \u0085\u00012\u00020\u0001:\u0001ABG\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?\u0012\u0006\u0010I\u001a\u00020D\u0012\u0006\u0010N\u001a\u00020\u0012\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010X\u001a\u00020O\u0012\u0006\u0010^\u001a\u00020Y\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0002J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u0012\u0010!\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J@\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042&\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010%j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`&H\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u0006H\u0002J \u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0002J \u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\u0004J)\u00107\u001a\u00020\u00062!\u00106\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u000602J\u0006\u00108\u001a\u00020\u000eJ\u000e\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0004J\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u0006J\u0006\u0010=\u001a\u00020\u0006J\u0006\u0010>\u001a\u00020\u0006R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0017\u0010I\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010N\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010QR\u0017\u0010^\u001a\u00020Y8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0016\u0010b\u001a\u0004\u0018\u00010_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010q\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u0004\u0018\u00010r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010|\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010pR\u0018\u0010\u0081\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0087\u0001\u001a\r \u0083\u0001*\u0005\u0018\u00010\u0082\u00010\u0082\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0017\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u008a\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u0089\u0001R\u0017\u0010\u008d\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bL\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\\\u0010\u008f\u0001R\u0017\u0010\u0093\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\t\u0010\u0092\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter;", "", "", "iconRes", "", "tips", "", "X", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper;", "v", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "", "isUserChanged", "isAdminChanged", "Y", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "L", BdhLogUtil.LogTag.Tag_Req, "T", "r", "H", "M", "Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "state", "a0", ReportConstant.COSTREPORT_PREFIX, "G", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "J", "Landroid/view/View;", "reportView", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventParams", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K", "V", "status", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "W", "from", "P", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "enableMic", "reportClick", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "openIndex", "E", "y", "D", "N", "O", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "a", "Ljava/lang/ref/WeakReference;", "fragmentReference", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getMGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "t", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mVoiceMic", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mAudioQueueTv", "f", "mAudioQueueManageIv", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "g", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "u", "()Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "micStateViewModel", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/guild/media/core/e;", "i", "Lcom/tencent/mobileqq/guild/media/core/e;", "mCore", "Lcom/tencent/mobileqq/guild/media/core/l;", "j", "Lcom/tencent/mobileqq/guild/media/core/l;", "mDataHub", "Ljava/util/concurrent/atomic/AtomicInteger;", "k", "Ljava/util/concurrent/atomic/AtomicInteger;", "mAudioRoute", "l", "Z", "mRobotIconEnable", "Lcom/tencent/mobileqq/guild/media/widget/bd;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/widget/bd;", "mMicOnDrawable", "Luf1/a;", DomainData.DOMAIN_NAME, "Luf1/a;", "mProxyManager", "o", "I", "audioQueueState", "p", "needBadTips", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "lastMicStatus", "Landroid/animation/StateListAnimator;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "w", "()Landroid/animation/StateListAnimator;", "voiceMicStateListAnimator", "com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$f", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$f;", "userTalkPermissionUpdateEvent", "com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$c", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$c;", "firstEnterMicEvent", "com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$e", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$e;", "openThirdAppPanelEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mobileqq/guild/media/viewmodel/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelFragmentBottomBarPresenter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Fragment> fragmentReference;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProGuildInfo mGuildInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo mChannelInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mVoiceMic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mAudioQueueTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mAudioQueueManageIv;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.viewmodel.b micStateViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context mContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.e mCore;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.l mDataHub;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger mAudioRoute;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mRobotIconEnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final bd mMicOnDrawable;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final uf1.a mProxyManager;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int audioQueueState;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean needBadTips;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MicState lastMicStatus;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy voiceMicStateListAnimator;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f userTalkPermissionUpdateEvent;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c firstEnterMicEvent;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e openThirdAppPanelEvent;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y mAudioRoomObserver;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229109a;

        static {
            int[] iArr = new int[MicState.values().length];
            try {
                iArr[MicState.MIC_STATE_ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MicState.MIC_STATE_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MicState.MIC_STATE_DISABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MicState.MIC_STATE_IN_ACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MicState.MIC_STATE_GONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f229109a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/h;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.h> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.h event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!StringUtil.isEmpty(event.getTips())) {
                MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = MediaChannelFragmentBottomBarPresenter.this;
                String tips = event.getTips();
                Intrinsics.checkNotNull(tips);
                mediaChannelFragmentBottomBarPresenter.X(R.drawable.guild_media_aio_close_mic, tips);
            }
        }
    }

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J*\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J0\u0010\u0019\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$d", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "channelID", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Lkotlin/collections/ArrayList;", "qualityArr", "", "B", "from", "guildId", "roomId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", HippyTKDListViewAdapter.X, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "e", "a", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "w", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends y {
        d() {
        }

        private final void B(String channelID, ArrayList<TRTCQuality> qualityArr) {
            if (!Intrinsics.areEqual(channelID, MediaChannelFragmentBottomBarPresenter.this.getMChannelInfo().getChannelUin())) {
                QLog.d("QGMC.MediaChannelFragmentBottomBarPresenter", 4, "[showPoorNetworkToastIfNeeded] channelId not matched: " + channelID);
                return;
            }
            Iterator<TRTCQuality> it = qualityArr.iterator();
            while (it.hasNext()) {
                TRTCQuality next = it.next();
                String userId = next.getUserId();
                if (next.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String() >= 4) {
                    if (Intrinsics.areEqual(userId, com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a) && MediaChannelFragmentBottomBarPresenter.this.needBadTips) {
                        Context context = MediaChannelFragmentBottomBarPresenter.this.mContext;
                        if (context != null) {
                            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = MediaChannelFragmentBottomBarPresenter.this;
                            String string = context.getString(R.string.f140540e9);
                            Intrinsics.checkNotNullExpressionValue(string, "it.getString(R.string.guild_audio_weak_net)");
                            mediaChannelFragmentBottomBarPresenter.X(R.drawable.guild_media_aio_network, string);
                        }
                        MediaChannelFragmentBottomBarPresenter.this.needBadTips = false;
                    }
                } else if (Intrinsics.areEqual(userId, com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a)) {
                    MediaChannelFragmentBottomBarPresenter.this.needBadTips = true;
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void a() {
            QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "onBusinessModeUpdated: ");
            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = MediaChannelFragmentBottomBarPresenter.this;
            MediaChannelFragmentBottomBarPresenter.S(mediaChannelFragmentBottomBarPresenter, mediaChannelFragmentBottomBarPresenter.mCore.getChannelInfo(), false, 2, null);
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.d());
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void e(@Nullable IGProChannelInfo channelInfo) {
            String str;
            Integer num;
            IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
            if (channelInfo != null) {
                str = channelInfo.getChannelUin();
            } else {
                str = null;
            }
            if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null) {
                num = Integer.valueOf(voiceSpeakModeCfg.getSpeakMode());
            } else {
                num = null;
            }
            QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "onSpeakModeChanged: " + str + ", " + num);
            MediaChannelFragmentBottomBarPresenter.S(MediaChannelFragmentBottomBarPresenter.this, channelInfo, false, 2, null);
            MediaChannelFragmentBottomBarPresenter.U(MediaChannelFragmentBottomBarPresenter.this, channelInfo, false, 2, null);
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.d());
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void q(@Nullable String channelID, @NotNull ArrayList<TRTCQuality> qualityArr) {
            Intrinsics.checkNotNullParameter(qualityArr, "qualityArr");
            B(channelID, qualityArr);
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void u() {
            MediaChannelFragmentBottomBarPresenter.this.mRobotIconEnable = true;
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
            bd bdVar;
            Boolean value = MediaChannelFragmentBottomBarPresenter.this.getMicStateViewModel().l2().getValue();
            Intrinsics.checkNotNull(value);
            if (!value.booleanValue()) {
                return;
            }
            if (MediaChannelFragmentBottomBarPresenter.this.getMicStateViewModel().Z1()) {
                MicState micState = MediaChannelFragmentBottomBarPresenter.this.lastMicStatus;
                MicState micState2 = MicState.MIC_STATE_IN_ACTIVE;
                if (micState != micState2) {
                    MediaChannelFragmentBottomBarPresenter.this.getMicStateViewModel().v2(micState2);
                    return;
                }
                return;
            }
            MicState micState3 = MediaChannelFragmentBottomBarPresenter.this.lastMicStatus;
            MicState micState4 = MicState.MIC_STATE_ON;
            if (micState3 != micState4) {
                MediaChannelFragmentBottomBarPresenter.this.getMicStateViewModel().v2(micState4);
            }
            if (localUserInfo != null && (bdVar = MediaChannelFragmentBottomBarPresenter.this.mMicOnDrawable) != null) {
                bdVar.k(localUserInfo.f228109q);
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@NotNull String from, @NotNull String guildId, @NotNull String roomId, @NotNull com.tencent.mobileqq.guild.media.core.data.f localUserInfo) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            Intrinsics.checkNotNullParameter(localUserInfo, "localUserInfo");
            if (Intrinsics.areEqual(guildId, MediaChannelFragmentBottomBarPresenter.this.getMChannelInfo().getGuildId()) && Intrinsics.areEqual(roomId, MediaChannelFragmentBottomBarPresenter.this.getMChannelInfo().getChannelUin())) {
                MediaChannelFragmentBottomBarPresenter.this.mRobotIconEnable = true;
                if (localUserInfo.R) {
                    MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = MediaChannelFragmentBottomBarPresenter.this;
                    mediaChannelFragmentBottomBarPresenter.P(localUserInfo, mediaChannelFragmentBottomBarPresenter.mDataHub.getUserInfoList(), from);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ah;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<ah> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ah event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger.f235387a.d().d("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "[listenEvent] OpenThirdAppPanel!");
            Fragment fragment = (Fragment) MediaChannelFragmentBottomBarPresenter.this.fragmentReference.get();
            if (fragment != null) {
                GuildMediaThemeChooseDialog.Companion companion = GuildMediaThemeChooseDialog.INSTANCE;
                FragmentManager supportFragmentManager = fragment.requireActivity().getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragment.requireActivity().supportFragmentManager");
                companion.e("2", supportFragmentManager, "QGMC.MediaChannelFragmentBottomBarPresenter");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<bi> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "UserTalkPermissionUpdateEvent selfIsMicOn " + com.tencent.mobileqq.guild.media.core.m.m(MediaChannelFragmentBottomBarPresenter.this.mDataHub));
            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = MediaChannelFragmentBottomBarPresenter.this;
            MediaChannelFragmentBottomBarPresenter.Z(mediaChannelFragmentBottomBarPresenter, mediaChannelFragmentBottomBarPresenter.mDataHub.getSelfUserInfo(), null, false, false, 14, null);
        }
    }

    public MediaChannelFragmentBottomBarPresenter(@NotNull WeakReference<Fragment> fragmentReference, @NotNull IGProGuildInfo mGuildInfo, @NotNull IGProChannelInfo mChannelInfo, @NotNull ImageView mVoiceMic, @NotNull TextView mAudioQueueTv, @NotNull ImageView mAudioQueueManageIv, @NotNull com.tencent.mobileqq.guild.media.viewmodel.b micStateViewModel) {
        Context context;
        Lazy lazy;
        Bundle arguments;
        Intrinsics.checkNotNullParameter(fragmentReference, "fragmentReference");
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        Intrinsics.checkNotNullParameter(mVoiceMic, "mVoiceMic");
        Intrinsics.checkNotNullParameter(mAudioQueueTv, "mAudioQueueTv");
        Intrinsics.checkNotNullParameter(mAudioQueueManageIv, "mAudioQueueManageIv");
        Intrinsics.checkNotNullParameter(micStateViewModel, "micStateViewModel");
        this.fragmentReference = fragmentReference;
        this.mGuildInfo = mGuildInfo;
        this.mChannelInfo = mChannelInfo;
        this.mVoiceMic = mVoiceMic;
        this.mAudioQueueTv = mAudioQueueTv;
        this.mAudioQueueManageIv = mAudioQueueManageIv;
        this.micStateViewModel = micStateViewModel;
        Fragment fragment = fragmentReference.get();
        if (fragment != null) {
            context = fragment.requireContext();
        } else {
            context = null;
        }
        this.mContext = context;
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        this.mCore = a16;
        this.mDataHub = com.tencent.mobileqq.guild.media.core.j.c();
        this.mAudioRoute = new AtomicInteger(a16.J().getAudioRoute());
        this.mMicOnDrawable = context != null ? new bd(context, context.getResources().getDimensionPixelOffset(R.dimen.cdb), context.getResources().getDimensionPixelOffset(R.dimen.cdb)) : null;
        this.needBadTips = true;
        this.lastMicStatus = MicState.MIC_STATE_UNKNOWN;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<StateListAnimator>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentBottomBarPresenter$voiceMicStateListAnimator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StateListAnimator invoke() {
                ImageView imageView;
                imageView = MediaChannelFragmentBottomBarPresenter.this.mVoiceMic;
                return AnimatorInflater.loadStateListAnimator(imageView.getContext(), R.animator.f155134n);
            }
        });
        this.voiceMicStateListAnimator = lazy;
        f fVar = new f();
        this.userTalkPermissionUpdateEvent = fVar;
        c cVar = new c();
        this.firstEnterMicEvent = cVar;
        e eVar = new e();
        this.openThirdAppPanelEvent = eVar;
        d dVar = new d();
        this.mAudioRoomObserver = dVar;
        a16.l0().b(dVar);
        com.tencent.mobileqq.guild.media.core.j.d().V(bi.class, fVar);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.h.class, cVar);
        com.tencent.mobileqq.guild.media.core.j.d().V(ah.class, eVar);
        H();
        Fragment fragment2 = fragmentReference.get();
        uf1.a aVar = new uf1.a((fragment2 == null || (arguments = fragment2.getArguments()) == null) ? new Bundle() : arguments);
        aVar.i(mGuildInfo.getGuildID(), mChannelInfo.getChannelUin());
        this.mProxyManager = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(Ref.ObjectRef userInfo, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(userInfo, "$userInfo");
        kt1.d dVar = kt1.d.f412973a;
        String str = ((com.tencent.mobileqq.guild.media.core.data.f) userInfo.element).P;
        Intrinsics.checkNotNullExpressionValue(str, "userInfo.guildId");
        long parseLong = Long.parseLong(str);
        String str2 = ((com.tencent.mobileqq.guild.media.core.data.f) userInfo.element).Q;
        Intrinsics.checkNotNullExpressionValue(str2, "userInfo.channelId");
        long parseLong2 = Long.parseLong(str2);
        String str3 = ((com.tencent.mobileqq.guild.media.core.data.f) userInfo.element).f228093a;
        Intrinsics.checkNotNullExpressionValue(str3, "userInfo.id");
        dVar.l(parseLong, parseLong2, Long.parseLong(str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(MediaChannelFragmentBottomBarPresenter this$0, Ref.ObjectRef userInfo, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userInfo, "$userInfo");
        kt1.d dVar = kt1.d.f412973a;
        String str = ((com.tencent.mobileqq.guild.media.core.data.f) userInfo.element).P;
        Intrinsics.checkNotNullExpressionValue(str, "userInfo.guildId");
        long parseLong = Long.parseLong(str);
        String str2 = ((com.tencent.mobileqq.guild.media.core.data.f) userInfo.element).Q;
        Intrinsics.checkNotNullExpressionValue(str2, "userInfo.channelId");
        long parseLong2 = Long.parseLong(str2);
        String str3 = ((com.tencent.mobileqq.guild.media.core.data.f) userInfo.element).f228093a;
        Intrinsics.checkNotNullExpressionValue(str3, "userInfo.id");
        kt1.d.g(dVar, parseLong, parseLong2, Long.parseLong(str3), false, 8, null);
    }

    private final void G() {
        this.mVoiceMic.setVisibility(0);
        this.mVoiceMic.setImageResource(R.drawable.guild_media_mic_off_disable);
        this.mVoiceMic.setEnabled(true);
        this.mVoiceMic.setStateListAnimator(null);
    }

    private final void H() {
        Fragment fragment = this.fragmentReference.get();
        if (fragment != null) {
            e12.e<MicState> c26 = this.micStateViewModel.c2();
            final Function1<MicState, Unit> function1 = new Function1<MicState, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentBottomBarPresenter$initMicState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MicState micState) {
                    invoke2(micState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MicState it) {
                    MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = MediaChannelFragmentBottomBarPresenter.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mediaChannelFragmentBottomBarPresenter.a0(it);
                }
            };
            c26.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.guild.media.presenter.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MediaChannelFragmentBottomBarPresenter.I(Function1.this, obj);
                }
            });
        }
        if (M()) {
            if (this.mDataHub.getSelfUserInfo().f228101i) {
                this.mVoiceMic.setImageResource(R.drawable.guild_media_mic_on_press);
            } else {
                this.mVoiceMic.setImageResource(R.drawable.guild_media_mic_off_press);
            }
        } else if (this.micStateViewModel.W1()) {
            this.micStateViewModel.h2(this.mDataHub.getSelfUserInfo().f228101i);
        } else {
            Boolean value = this.micStateViewModel.l2().getValue();
            Intrinsics.checkNotNull(value);
            if (value.booleanValue()) {
                this.mVoiceMic.setImageResource(R.drawable.guild_media_mic_on_press);
            }
        }
        this.micStateViewModel.h2(com.tencent.mobileqq.guild.media.core.m.m(this.mDataHub));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean J(Activity activity) {
        if (activity == null) {
            QLog.w("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "[isActivityContextValid] activity is null. ");
            return false;
        }
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    private final boolean K() {
        FragmentActivity fragmentActivity;
        boolean z16;
        boolean z17;
        FragmentActivity activity;
        FragmentActivity activity2;
        Fragment fragment = this.fragmentReference.get();
        if (fragment != null) {
            fragmentActivity = fragment.getActivity();
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return true;
        }
        Fragment fragment2 = this.fragmentReference.get();
        if (fragment2 != null && (activity2 = fragment2.getActivity()) != null && activity2.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        Fragment fragment3 = this.fragmentReference.get();
        if (fragment3 != null && (activity = fragment3.getActivity()) != null && activity.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final boolean L(IGProChannelInfo channelInfo) {
        String str;
        boolean z16;
        boolean m16 = com.tencent.mobileqq.guild.media.core.j.a().d0().m1();
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        if (channelInfo != null) {
            str = channelInfo.getChannelUin();
        } else {
            str = null;
        }
        if (mediaChannelUtils.u(str) && !M()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!m16 && z16) {
            return true;
        }
        return false;
    }

    private final boolean M() {
        boolean m06 = ch.m0(com.tencent.mobileqq.guild.media.core.j.a().getGuildID());
        boolean h06 = ch.h0(com.tencent.mobileqq.guild.media.core.j.a().E());
        boolean t16 = MediaChannelUtils.f228046a.t(this.mDataHub.getSelfUserInfo());
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "isManager, isGuildAdminOrCreator: " + m06 + ", isChannelOrCategoryAdmin: " + h06 + ", isAdminUser: " + t16);
        }
        if (m06 || h06 || t16) {
            return true;
        }
        return false;
    }

    private final void Q(View reportView, String elementId, HashMap<String, Object> eventParams) {
        HashMap hashMap = new HashMap();
        String guildID = this.mGuildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
        hashMap.put("sgrp_channel_id", guildID);
        hashMap.put("sgrp_user_type", Integer.valueOf(this.mGuildInfo.getUserType()));
        String channelUin = this.mChannelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo.channelUin");
        hashMap.put("sgrp_sub_channel_id", channelUin);
        hashMap.put("sgrp_sub_channel_type", Integer.valueOf(this.mChannelInfo.getType()));
        if (eventParams != null && (!eventParams.isEmpty())) {
            hashMap.putAll(eventParams);
        }
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", reportView, hashMap);
    }

    private final void R(IGProChannelInfo channelInfo, boolean isAdminChanged) {
        Integer num;
        boolean z16;
        String str;
        Drawable drawable;
        String str2;
        String str3;
        String str4;
        Drawable drawable2;
        IGProVoiceQueueCfg voiceQueueCfg;
        Drawable drawable3 = null;
        if (channelInfo != null && (voiceQueueCfg = channelInfo.getVoiceQueueCfg()) != null) {
            num = Integer.valueOf(voiceQueueCfg.getVoiceQueueState());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isAdminChanged) {
            com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.IMediaChannelInnerCore");
            if (((com.tencent.mobileqq.guild.media.core.f) a16).getSelfUserInfo().f228097e == 1) {
                this.mAudioQueueTv.setVisibility(8);
                return;
            }
        }
        if (!L(channelInfo)) {
            this.mAudioQueueTv.setVisibility(8);
            return;
        }
        if (this.mAudioQueueTv.getVisibility() == 8) {
            this.mAudioQueueTv.setVisibility(0);
        }
        if (this.mAudioQueueTv.getStateListAnimator() == null) {
            TextView textView = this.mAudioQueueTv;
            textView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(textView.getContext(), R.animator.f155134n));
        }
        int i3 = this.audioQueueState;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        TextView textView2 = this.mAudioQueueTv;
                        Context context = this.mContext;
                        if (context != null) {
                            str4 = context.getString(R.string.f140250dg);
                        } else {
                            str4 = null;
                        }
                        textView2.setText(str4);
                        TextView textView3 = this.mAudioQueueTv;
                        Context context2 = this.mContext;
                        if (context2 != null) {
                            drawable2 = context2.getDrawable(R.drawable.guild_audio_queue_btn_active_bg);
                        } else {
                            drawable2 = null;
                        }
                        textView3.setBackground(drawable2);
                        this.mAudioQueueTv.setAlpha(0.3f);
                        this.mAudioQueueTv.setStateListAnimator(null);
                        return;
                    }
                    return;
                }
                TextView textView4 = this.mAudioQueueTv;
                Context context3 = this.mContext;
                if (context3 != null) {
                    str3 = context3.getString(R.string.f140230de);
                } else {
                    str3 = null;
                }
                textView4.setText(str3);
                TextView textView5 = this.mAudioQueueTv;
                Context context4 = this.mContext;
                if (context4 != null) {
                    drawable3 = context4.getDrawable(R.drawable.guild_audio_queue_btn_normal_bg);
                }
                textView5.setBackground(drawable3);
                this.mAudioQueueTv.setAlpha(1.0f);
                return;
            }
            TextView textView6 = this.mAudioQueueTv;
            Context context5 = this.mContext;
            if (context5 != null) {
                str2 = context5.getString(R.string.f140240df);
            } else {
                str2 = null;
            }
            textView6.setText(str2);
            TextView textView7 = this.mAudioQueueTv;
            Context context6 = this.mContext;
            if (context6 != null) {
                drawable3 = context6.getDrawable(R.drawable.guild_audio_queue_btn_normal_bg);
            }
            textView7.setBackground(drawable3);
            this.mAudioQueueTv.setAlpha(1.0f);
            return;
        }
        TextView textView8 = this.mAudioQueueTv;
        Context context7 = this.mContext;
        if (context7 != null) {
            str = context7.getString(R.string.f140250dg);
        } else {
            str = null;
        }
        textView8.setText(str);
        TextView textView9 = this.mAudioQueueTv;
        Context context8 = this.mContext;
        if (context8 != null) {
            drawable = context8.getDrawable(R.drawable.guild_audio_queue_btn_active_bg);
        } else {
            drawable = null;
        }
        textView9.setBackground(drawable);
        if (z16) {
            this.mAudioQueueTv.setAlpha(0.3f);
            this.mAudioQueueTv.setStateListAnimator(null);
        } else {
            this.mAudioQueueTv.setAlpha(1.0f);
        }
    }

    static /* synthetic */ void S(MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter, IGProChannelInfo iGProChannelInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        mediaChannelFragmentBottomBarPresenter.R(iGProChannelInfo, z16);
    }

    private final void T(IGProChannelInfo channelInfo, boolean isAdminChanged) {
        String str;
        if (isAdminChanged) {
            com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.IMediaChannelInnerCore");
            if (((com.tencent.mobileqq.guild.media.core.f) a16).getSelfUserInfo().f228097e == 0) {
                this.mAudioQueueManageIv.setVisibility(8);
                return;
            }
        }
        if (M()) {
            MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
            if (channelInfo != null) {
                str = channelInfo.getChannelUin();
            } else {
                str = null;
            }
            if (mediaChannelUtils.u(str)) {
                if (this.mAudioQueueManageIv.getVisibility() == 8) {
                    this.mAudioQueueManageIv.setVisibility(0);
                }
                if (this.mAudioQueueManageIv.getStateListAnimator() == null) {
                    ImageView imageView = this.mAudioQueueManageIv;
                    imageView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(imageView.getContext(), R.animator.f155134n));
                    return;
                }
                return;
            }
        }
        this.mAudioQueueManageIv.setVisibility(8);
    }

    static /* synthetic */ void U(MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter, IGProChannelInfo iGProChannelInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        mediaChannelFragmentBottomBarPresenter.T(iGProChannelInfo, z16);
    }

    private final void V() {
        FragmentManager childFragmentManager;
        Fragment fragment = this.fragmentReference.get();
        if (fragment != null && (childFragmentManager = fragment.getChildFragmentManager()) != null) {
            com.tencent.mobileqq.guild.base.extension.d.a(new GuildMicSequenceDialogFragment(this.mGuildInfo, this.mChannelInfo), childFragmentManager, "GuildMicSequenceDialogFragment");
        }
    }

    private final void W(int status, DialogInterface.OnClickListener onConfirm, DialogInterface.OnClickListener onCancel) {
        String str;
        String str2;
        if (status == 2) {
            str = "\u786e\u5b9a\u9000\u51fa\u6392\u9ea6\u961f\u5217\u5417\uff1f";
            str2 = "\u786e\u5b9a";
        } else {
            str = "\u786e\u5b9a\u63d0\u524d\u4e0b\u9ea6\u5417\uff1f";
            str2 = "\u4e0b\u9ea6";
        }
        String str3 = str2;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mContext, 230, (String) null, str, "\u53d6\u6d88", str3, onConfirm, onCancel);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nfirm, onCancel\n        )");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int iconRes, String tips) {
        FragmentActivity activity;
        Fragment fragment = this.fragmentReference.get();
        if (fragment != null && (activity = fragment.getActivity()) != null) {
            GuildMediaAioViewModel.INSTANCE.a(activity).l2(new b.c(Integer.valueOf(iconRes), tips, null, null, 12, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009a, code lost:
    
        if (r10 != 4) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Y(com.tencent.mobileqq.guild.media.core.data.f selfUserInfo, com.tencent.mobileqq.guild.media.core.data.r userInfoList, boolean isUserChanged, boolean isAdminChanged) {
        String str;
        boolean z16;
        List<com.tencent.mobileqq.guild.media.core.data.p> list;
        IGProChannelInfo channelInfo = this.mCore.getChannelInfo();
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        ArrayList arrayList = null;
        if (channelInfo != null) {
            str = channelInfo.getChannelUin();
        } else {
            str = null;
        }
        if (!mediaChannelUtils.u(str)) {
            return;
        }
        int i3 = 0;
        if (!this.micStateViewModel.T1() && !x() && !v().d0() && !v().i0() && v().f0()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.audioQueueState = 3;
        } else {
            if (userInfoList != null && (list = userInfoList.f228125a) != null) {
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics.areEqual(((com.tencent.mobileqq.guild.media.core.data.p) obj).f228093a, selfUserInfo.f228093a)) {
                        arrayList.add(obj);
                    }
                }
            }
            if (isUserChanged && (arrayList == null || arrayList.isEmpty())) {
                return;
            }
            int userAVState = selfUserInfo.C.getUserAVInfo().getUserAVState();
            if (userAVState != 1) {
                if (userAVState != 8) {
                    if (userAVState != 3) {
                    }
                } else {
                    i3 = 2;
                }
                this.audioQueueState = i3;
            }
            i3 = 1;
            this.audioQueueState = i3;
        }
        QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "updateAudioQueueState: " + this.audioQueueState + ", " + selfUserInfo.C.getUserAVInfo().getUserAVState());
        R(channelInfo, isAdminChanged);
        T(channelInfo, isAdminChanged);
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.d());
    }

    static /* synthetic */ void Z(MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter, com.tencent.mobileqq.guild.media.core.data.f fVar, com.tencent.mobileqq.guild.media.core.data.r rVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            rVar = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        mediaChannelFragmentBottomBarPresenter.Y(fVar, rVar, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(MicState state) {
        this.mVoiceMic.setVisibility(0);
        int i3 = b.f229109a[state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            this.mVoiceMic.setVisibility(8);
                        }
                    } else {
                        G();
                    }
                } else {
                    s();
                }
            } else {
                this.mVoiceMic.setImageResource(R.drawable.guild_media_mic_off_press);
                this.mVoiceMic.setEnabled(true);
                this.mVoiceMic.setStateListAnimator(w());
            }
        } else {
            this.mVoiceMic.setImageDrawable(this.mMicOnDrawable);
            bd bdVar = this.mMicOnDrawable;
            if (bdVar != null) {
                bdVar.k(this.mDataHub.getSelfUserInfo().f228109q);
            }
            this.mVoiceMic.setEnabled(true);
            this.mVoiceMic.setStateListAnimator(w());
        }
        this.lastMicStatus = state;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGMC.MediaChannelFragmentBottomBarPresenter", 2, "updateVoiceMicBg state:" + state);
        }
    }

    private final void s() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGMC.MediaChannelFragmentBottomBarPresenter", 2, "disableVoiceMic");
        }
        this.mVoiceMic.setVisibility(0);
        this.mVoiceMic.setImageResource(R.drawable.guild_media_mic_off_disable);
        this.mVoiceMic.setStateListAnimator(null);
    }

    private final MediaChannelPermissionHelper v() {
        return com.tencent.mobileqq.guild.media.core.j.a().S();
    }

    private final StateListAnimator w() {
        return (StateListAnimator) this.voiceMicStateListAnimator.getValue();
    }

    public final void D() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_queuemanage_entrance_type", 2);
        Q(this.mAudioQueueManageIv, "em_sgrp_avchannel_manege_queue", hashMap);
        V();
    }

    public final void E(@NotNull String openIndex) {
        HashMap<String, String> hashMapOf;
        FragmentActivity requireActivity;
        HashMap<String, String> hashMapOf2;
        HashMap<String, String> hashMapOf3;
        HashMap<String, String> hashMapOf4;
        Intrinsics.checkNotNullParameter(openIndex, "openIndex");
        if (ch.j0(this.mChannelInfo.getGuildId())) {
            JumpGuildParam d16 = this.mProxyManager.d();
            if (d16 == null) {
                aa aaVar = aa.f230980i;
                GuildCounterNames guildCounterNames = GuildCounterNames.MORE_BTN_CLICK;
                hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("msg", "join_info_null"));
                aaVar.s(guildCounterNames, hashMapOf4, false);
                return;
            }
            if (J(QBaseActivity.sTopActivity)) {
                ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(QBaseActivity.sTopActivity, d16, HardCodeUtil.qqStr(R.string.f147280wg));
            } else {
                QLog.w("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "[handleClickMoreBtn] failed. context invalid");
            }
            aa aaVar2 = aa.f230980i;
            GuildCounterNames guildCounterNames2 = GuildCounterNames.MORE_BTN_CLICK;
            hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("msg", "guest_refuse"));
            aaVar2.s(guildCounterNames2, hashMapOf3, false);
            return;
        }
        if (K()) {
            aa aaVar3 = aa.f230980i;
            GuildCounterNames guildCounterNames3 = GuildCounterNames.MORE_BTN_CLICK;
            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("msg", "is_activity_unavailable"));
            aaVar3.s(guildCounterNames3, hashMapOf2, false);
            return;
        }
        aa aaVar4 = aa.f230980i;
        GuildCounterNames guildCounterNames4 = GuildCounterNames.MORE_BTN_CLICK;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("msg", "success"));
        aaVar4.s(guildCounterNames4, hashMapOf, true);
        Fragment fragment = this.fragmentReference.get();
        if (fragment != null && (requireActivity = fragment.requireActivity()) != null) {
            GuildMediaThemeChooseDialog.Companion companion = GuildMediaThemeChooseDialog.INSTANCE;
            FragmentManager supportFragmentManager = requireActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            companion.e(openIndex, supportFragmentManager, "QGMC.MediaChannelFragmentBottomBarPresenter");
        }
    }

    public final void F(@NotNull Function1<? super Boolean, Unit> reportClick) {
        Intrinsics.checkNotNullParameter(reportClick, "reportClick");
        QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "handleVoice: guild = " + this.mGuildInfo.getGuildID() + ", channelId = " + this.mChannelInfo.getChannelUin() + " canTalkOnMuting = " + this.micStateViewModel.R1() + " mGlobalMute = " + x() + " mMicEnabled = " + this.micStateViewModel.l2().getValue() + "mMicInActive = " + this.micStateViewModel.Z1());
        Context context = this.mContext;
        if (context != null) {
            this.micStateViewModel.i2(reportClick, context, this.fragmentReference);
        }
    }

    public final void N() {
        Z(this, com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo(), com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList(), false, false, 12, null);
    }

    public final void O() {
        this.mCore.l0().B(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(bi.class, this.userTalkPermissionUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.h.class, this.firstEnterMicEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ah.class, this.openThirdAppPanelEvent);
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0051, code lost:
    
        r8.micStateViewModel.o2(r9.f228101i);
        r8.mAudioRoute.set(r9.S);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006e, code lost:
    
        if (com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper.U(com.tencent.mobileqq.guild.media.core.j.a().C(), false, false, 3, null) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0070, code lost:
    
        r8.micStateViewModel.g2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007d, code lost:
    
        Z(r8, r9, r10, true, false, 8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0076, code lost:
    
        r8.micStateViewModel.h2(r9.f228101i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r11.equals("setUserMuteSeatInGuild") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (r11.equals("onFetchAudioChannelUserList") != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        if (r11.equals("onAVUserInfoChangeNotifyForAll") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a5, code lost:
    
        if (r11.equals("onPushPermissionInGuild") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:
    
        if (r11.equals("pushOnSelfTRTCAudioAvailable") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x00b0, code lost:
    
        if (r9.f228101i != com.tencent.mobileqq.guild.media.core.m.m(r8.mDataHub)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00b2, code lost:
    
        r8.micStateViewModel.h2(r9.f228101i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (r11.equals("onAudioChannelUserSelfAdd") == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(@NotNull com.tencent.mobileqq.guild.media.core.data.f selfUserInfo, @NotNull com.tencent.mobileqq.guild.media.core.data.r userInfoList, @NotNull String from) {
        int i3;
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        Intrinsics.checkNotNullParameter(from, "from");
        switch (from.hashCode()) {
            case -2036431770:
                break;
            case -1908147228:
                if (from.equals("onAdminChanged")) {
                    Z(this, selfUserInfo, userInfoList, false, true, 4, null);
                    break;
                }
                break;
            case -1260191490:
                break;
            case 1176472369:
                break;
            case 1396165923:
                break;
            case 2119444478:
                break;
            case 2145970341:
                break;
        }
        if (this.mAudioRoute.get() == -1 && (i3 = selfUserInfo.S) != -1) {
            this.mAudioRoute.set(i3);
        }
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final IGProChannelInfo getMChannelInfo() {
        return this.mChannelInfo;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final com.tencent.mobileqq.guild.media.viewmodel.b getMicStateViewModel() {
        return this.micStateViewModel;
    }

    public final boolean x() {
        return com.tencent.mobileqq.guild.media.core.m.j(this.mDataHub);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.tencent.mobileqq.guild.media.core.data.f, com.tencent.mobileqq.guild.media.core.data.p] */
    public final void y() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? selfUserInfo = this.mDataHub.getSelfUserInfo();
        objectRef.element = selfUserInfo;
        if (selfUserInfo != 0 && !TextUtils.isEmpty(selfUserInfo.f228093a)) {
            QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "handleClickAudioQueueBtn, audioQueueState = " + this.audioQueueState);
            if (!L(this.mChannelInfo) || !this.micStateViewModel.S1(this.fragmentReference)) {
                return;
            }
            int i3 = this.audioQueueState;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return;
                        }
                    } else {
                        W(2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.presenter.s
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                MediaChannelFragmentBottomBarPresenter.A(Ref.ObjectRef.this, dialogInterface, i16);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.presenter.t
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                MediaChannelFragmentBottomBarPresenter.B(dialogInterface, i16);
                            }
                        });
                        Q(this.mAudioQueueTv, "em_sgrp_avchannel_queueout", null);
                        return;
                    }
                } else {
                    W(1, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.presenter.q
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            MediaChannelFragmentBottomBarPresenter.C(MediaChannelFragmentBottomBarPresenter.this, objectRef, dialogInterface, i16);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.presenter.r
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            MediaChannelFragmentBottomBarPresenter.z(dialogInterface, i16);
                        }
                    });
                    return;
                }
            }
            kt1.d dVar = kt1.d.f412973a;
            String str = ((com.tencent.mobileqq.guild.media.core.data.f) objectRef.element).P;
            Intrinsics.checkNotNullExpressionValue(str, "userInfo.guildId");
            long parseLong = Long.parseLong(str);
            String str2 = ((com.tencent.mobileqq.guild.media.core.data.f) objectRef.element).Q;
            Intrinsics.checkNotNullExpressionValue(str2, "userInfo.channelId");
            long parseLong2 = Long.parseLong(str2);
            String str3 = ((com.tencent.mobileqq.guild.media.core.data.f) objectRef.element).f228093a;
            Intrinsics.checkNotNullExpressionValue(str3, "userInfo.id");
            dVar.d(parseLong, parseLong2, Long.parseLong(str3));
            Q(this.mAudioQueueTv, "em_sgrp_avchannel_queueup", null);
            return;
        }
        QLog.i("QGMC.MediaChannelFragmentBottomBarPresenter", 1, "handleClickAudioQueueBtn, userInfo is empty");
    }

    private final void r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(DialogInterface dialogInterface, int i3) {
    }
}
