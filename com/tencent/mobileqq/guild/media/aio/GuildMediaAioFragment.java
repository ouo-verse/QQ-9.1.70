package com.tencent.mobileqq.guild.media.aio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guildmedia.api.IGuildMediaAioApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout;
import com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.a;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.MediaShareLoadInfo;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.core.notify.bc;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.ak;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import dt0.MediaUserEnterTipsModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002TX\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0003J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0006H\u0016J\u000f\u0010+\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0003H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u001eH\u0016J\b\u00106\u001a\u00020\u0003H\u0016J\b\u00107\u001a\u00020\u0003H\u0016R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00100\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Let0/a;", "", "Ph", "initView", "", "show", WidgetCacheLunarData.JI, "ii", "hi", "initViewModel", "Qh", "Lcom/tencent/mobileqq/guild/media/aio/AioUiState;", "Lh", "panelOrKeyboardShow", "", "Kh", "(Ljava/lang/Boolean;)I", "Oh", "ei", "di", "fi", "ci", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "isPanelOrKeyBoardShow", "isAioInputBarShow", "b7", "be", "Landroid/widget/TextView;", "tv", "Ea", "isSelectMode", "g", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Integer;", "", "seq", "E2", "l0", "Landroid/view/MotionEvent;", "ev", "Q4", "msgListView", "g4", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/core/l;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/mobileqq/guild/media/core/l;", "dataHub", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "D", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "aioViewModel", "E", "Landroid/view/ViewGroup;", "aioMsgUiRootView", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout;", "aioMsgUiContainer", "G", "Z", "isInRoomBeforeViewCreated", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioMsgListShowHideController;", "H", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioMsgListShowHideController;", "listShowHideController", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "I", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "mChannelViewModel", "com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$l", "J", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$l;", "selfProfileListener", "com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$k", "K", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$k;", "mediaChannelObserver", "Landroidx/lifecycle/Observer;", "L", "Landroidx/lifecycle/Observer;", "guildMediaSpeakSwitchObserver", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaAioFragment extends QPublicBaseFragment implements et0.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataHub;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildMediaAioViewModel aioViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup aioMsgUiRootView;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildLiveSwipeBackLayout aioMsgUiContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isInRoomBeforeViewCreated;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildMediaAioMsgListShowHideController listShowHideController;

    /* renamed from: I, reason: from kotlin metadata */
    private GuildMediaChannelViewModel mChannelViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final l selfProfileListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final k mediaChannelObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Observer<Integer> guildMediaSpeakSwitchObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227781a;

        static {
            int[] iArr = new int[ThirdAppBarClickEvent.values().length];
            try {
                iArr[ThirdAppBarClickEvent.MINIMIZE_LAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThirdAppBarClickEvent.MINIMIZE_PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThirdAppBarClickEvent.FULL_LAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ThirdAppBarClickEvent.FULL_PORTRAIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f227781a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.ac> {
        public c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.ac event) {
            com.tencent.mobileqq.guild.media.core.notify.ac acVar = event;
            GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            guildMediaAioViewModel.l2(new b.i(acVar.getIsMicEnable()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.z> {
        public d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.z event) {
            com.tencent.mobileqq.guild.media.core.notify.z zVar = event;
            GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            guildMediaAioViewModel.l2(new b.p(zVar.getOldSpeakModel(), zVar.getNewSpeakModel()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<bc> {
        public e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(bc event) {
            bc bcVar = event;
            GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            guildMediaAioViewModel.l2(new b.e(bcVar.a()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.c> {
        public f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.c event) {
            com.tencent.mobileqq.guild.media.core.notify.c cVar = event;
            GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            guildMediaAioViewModel.l2(new b.f(cVar.getAudioQueueState()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<ThirdAppBarClickEvent> {
        public g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(ThirdAppBarClickEvent event) {
            ThirdAppBarClickEvent thirdAppBarClickEvent = event;
            Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "ThirdAppBarClickEvent value:" + thirdAppBarClickEvent);
            int i3 = b.f227781a[thirdAppBarClickEvent.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if ((i3 == 3 || i3 == 4) && GuildMediaAioFragment.this.getView() != null) {
                    GuildMediaAioFragment.this.requireView().setVisibility(8);
                    return;
                }
                return;
            }
            if (GuildMediaAioFragment.this.getView() != null) {
                GuildMediaAioFragment.this.requireView().setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        public h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(SwitchThemeEvent event) {
            ViewGroup viewGroup = GuildMediaAioFragment.this.aioMsgUiRootView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
                viewGroup = null;
            }
            viewGroup.requestLayout();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$i", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i implements com.tencent.mobileqq.guild.media.core.notify.o<NotifyGiftRankChanged> {
        public i() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(NotifyGiftRankChanged event) {
            NotifyGiftRankChanged notifyGiftRankChanged = event;
            Logger.f235387a.d().d("QGMC.GuildMediaAioFragment", 1, "[NotifyGiftRankChanged] " + notifyGiftRankChanged);
            GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            guildMediaAioViewModel.c2(notifyGiftRankChanged);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$j", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout$b;", "", "onPageSwipeClose", "onPageSwipeOpen", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j implements GuildLiveSwipeBackLayout.b {
        j() {
        }

        @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.b
        public void onPageSwipeClose() {
            GuildMediaAioFragment.this.ji(false);
        }

        @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.b
        public void onPageSwipeOpen() {
            GuildMediaAioFragment.this.ji(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$k", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "userId", "", "available", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k extends com.tencent.mobileqq.guild.media.core.notify.y {
        k() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void z(@Nullable String userId, boolean available) {
            super.z(userId, available);
            if (GuildMediaAioFragment.this.aioMsgUiRootView != null) {
                ViewGroup viewGroup = GuildMediaAioFragment.this.aioMsgUiRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
                    viewGroup = null;
                }
                viewGroup.requestLayout();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioFragment$l", "Lcom/tencent/mobileqq/guild/profile/me/ak;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "profileInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l implements ak {
        l() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(@NotNull ev profileInfo) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(profileInfo, "profileInfo");
            aj.q(this);
            Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "add self enter tips, from onProfileChange. nick:" + profileInfo.getNickName());
            String f16 = ch.f();
            Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
            String nickName = profileInfo.getNickName();
            Intrinsics.checkNotNullExpressionValue(nickName, "profileInfo.nickName");
            MediaUserEnterTipsModel mediaUserEnterTipsModel = new MediaUserEnterTipsModel(f16, nickName, GuildMediaAioFragment.this.ci(), false, 8, null);
            GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(mediaUserEnterTipsModel);
            guildMediaAioViewModel.l2(new b.e(arrayListOf));
        }
    }

    public GuildMediaAioFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.media.core.l>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$dataHub$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.media.core.l invoke() {
                return com.tencent.mobileqq.guild.media.core.j.c();
            }
        });
        this.dataHub = lazy;
        this.selfProfileListener = new l();
        this.mediaChannelObserver = new k();
        this.guildMediaSpeakSwitchObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Nh(GuildMediaAioFragment.this, ((Integer) obj).intValue());
            }
        };
    }

    private final int Kh(Boolean panelOrKeyboardShow) {
        double d16;
        int i3 = com.tencent.mobileqq.util.x.f(BaseApplication.context).f185861b;
        int m3 = MediaChannelUtils.m();
        if (m3 != 6 && m3 != 7) {
            d16 = 0.5d;
        } else {
            d16 = 0.58d;
        }
        double d17 = i3;
        if (Intrinsics.areEqual(panelOrKeyboardShow, Boolean.TRUE)) {
            d16 = 0.28d;
        }
        return (int) (d17 * d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AioUiState Lh() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        if (guildMediaAioViewModel.i2()) {
            return AioUiState.SHOW_CANNOT_INPUT;
        }
        return AioUiState.SHOW;
    }

    private final com.tencent.mobileqq.guild.media.core.l Mh() {
        return (com.tencent.mobileqq.guild.media.core.l) this.dataHub.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildMediaAioFragment this$0, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QGMC.GuildMediaAioFragment", 1, "[guildMediaSpeakSwitchObserver] closeSpeak = " + z16);
        if (z16) {
            GuildMediaAioViewModel guildMediaAioViewModel = this$0.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            guildMediaAioViewModel.l2(new b.v(AioUiState.SHOW_CANNOT_INPUT));
        }
    }

    private final void Oh() {
        IGProChannelInfo iGProChannelInfo;
        QLog.i("QGMC.GuildMediaAioFragment", 1, "initAioModule.");
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        GuildMediaAioViewModel guildMediaAioViewModel = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        Bundle T1 = guildMediaChannelViewModel.T1();
        Serializable serializable = T1.getSerializable("extra_guild_channel_info");
        if (serializable instanceof IGProChannelInfo) {
            iGProChannelInfo = (IGProChannelInfo) serializable;
        } else {
            iGProChannelInfo = null;
        }
        if (iGProChannelInfo == null) {
            QLog.i("QGMC.GuildMediaAioFragment", 1, "initAioModule err. channelInfo is null.");
            return;
        }
        Bundle bundle = T1.getBundle(AppConstants.Key.GUILD_EXTRA);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        GuildMediaAioViewModel guildMediaAioViewModel2 = this.aioViewModel;
        if (guildMediaAioViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel2 = null;
        }
        boolean z16 = !guildMediaAioViewModel2.i2();
        bundle2.putBoolean("extra_key_show_aio_msg", z16);
        if (com.tencent.mobileqq.guild.media.core.m.h(Mh()) && Intrinsics.areEqual(Mh().getSelfUserInfo().P, iGProChannelInfo.getGuildId())) {
            bundle2.putLong("extra_key_show_max_msg_seq", Mh().a());
        }
        IGuildMediaAioApi iGuildMediaAioApi = (IGuildMediaAioApi) QRoute.api(IGuildMediaAioApi.class);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        String guildId = iGProChannelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        String channelUin = iGProChannelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        us0.b initAIOFragment = iGuildMediaAioApi.initAIOFragment(R.id.wpq, childFragmentManager, guildId, channelUin, bundle2, this, oe1.a.f422573a.b());
        GuildMediaAioViewModel guildMediaAioViewModel3 = this.aioViewModel;
        if (guildMediaAioViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel3 = null;
        }
        guildMediaAioViewModel3.l2(new b.j(initAIOFragment));
        GuildMediaAioViewModel guildMediaAioViewModel4 = this.aioViewModel;
        if (guildMediaAioViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
        } else {
            guildMediaAioViewModel = guildMediaAioViewModel4;
        }
        guildMediaAioViewModel.l2(new b.v(Lh()));
        QLog.i("QGMC.GuildMediaAioFragment", 1, "initAioModule [" + iGProChannelInfo.getGuildId() + "]-[" + iGProChannelInfo.getChannelUin() + "], showAioMsg[" + z16 + "]");
        ei();
        com.tencent.mobileqq.guild.util.security.f fVar = com.tencent.mobileqq.guild.util.security.f.f235633d;
        fVar.b(iGProChannelInfo.getGuildId(), this.guildMediaSpeakSwitchObserver);
        String guildId2 = iGProChannelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId2, "channelInfo.guildId");
        fVar.d(guildId2);
    }

    private final void Ph() {
        FragmentActivity activity = getActivity();
        if (getContext() != null && activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            if (getViewLifecycleOwnerLiveData().getValue() == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.GuildMediaAioFragment", 1, (String) it.next(), null);
                }
                return;
            }
            initView();
            initViewModel();
            Oh();
            Qh();
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("init all, ignore, act finish.");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("QGMC.GuildMediaAioFragment", 1, (String) it5.next(), null);
        }
    }

    private final void Qh() {
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.ac.class, new c());
        com.tencent.mobileqq.guild.media.core.notify.p d17 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        d17.k0(viewLifecycleOwner2, com.tencent.mobileqq.guild.media.core.notify.z.class, new d());
        com.tencent.mobileqq.guild.media.core.notify.p d18 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        d18.k0(viewLifecycleOwner3, bc.class, new e());
        com.tencent.mobileqq.guild.media.core.notify.p d19 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        d19.k0(viewLifecycleOwner4, com.tencent.mobileqq.guild.media.core.notify.c.class, new f());
        LiveData<Boolean> G = com.tencent.mobileqq.guild.media.core.j.c().G();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$5
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
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                        guildMediaAioViewModel = null;
                    }
                    guildMediaAioViewModel.M1();
                }
            }
        };
        G.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Rh(Function1.this, obj);
            }
        });
        LiveData<MediaShareLoadInfo> C = com.tencent.mobileqq.guild.media.core.j.c().C();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<MediaShareLoadInfo, Unit> function12 = new Function1<MediaShareLoadInfo, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaShareLoadInfo mediaShareLoadInfo) {
                invoke2(mediaShareLoadInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaShareLoadInfo mediaShareLoadInfo) {
                if (mediaShareLoadInfo != null) {
                    GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                        guildMediaAioViewModel = null;
                    }
                    guildMediaAioViewModel.m2(mediaShareLoadInfo);
                }
            }
        };
        C.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Sh(Function1.this, obj);
            }
        });
        LiveData<Boolean> E = com.tencent.mobileqq.guild.media.core.j.c().E();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final GuildMediaAioFragment$initEvents$7 guildMediaAioFragment$initEvents$7 = new GuildMediaAioFragment$initEvents$7(this);
        E.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Th(Function1.this, obj);
            }
        });
        cn<IGProSendGiftEventData> f06 = com.tencent.mobileqq.guild.media.core.j.c().f0();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        final Function1<IGProSendGiftEventData, Unit> function13 = new Function1<IGProSendGiftEventData, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProSendGiftEventData iGProSendGiftEventData) {
                invoke2(iGProSendGiftEventData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProSendGiftEventData it) {
                GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                if (guildMediaAioViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                    guildMediaAioViewModel = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaAioViewModel.b2(it);
            }
        };
        f06.observe(viewLifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Uh(Function1.this, obj);
            }
        });
        cn<IGProSendGiftEventData> e06 = com.tencent.mobileqq.guild.media.core.j.c().e0();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        final Function1<IGProSendGiftEventData, Unit> function14 = new Function1<IGProSendGiftEventData, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProSendGiftEventData iGProSendGiftEventData) {
                invoke2(iGProSendGiftEventData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProSendGiftEventData it) {
                GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                if (guildMediaAioViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                    guildMediaAioViewModel = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaAioViewModel.a2(it);
            }
        };
        e06.observe(viewLifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Vh(Function1.this, obj);
            }
        });
        cn<IGProSendGiftEventData> l06 = com.tencent.mobileqq.guild.media.core.j.c().l0();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        final Function1<IGProSendGiftEventData, Unit> function15 = new Function1<IGProSendGiftEventData, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProSendGiftEventData iGProSendGiftEventData) {
                invoke2(iGProSendGiftEventData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProSendGiftEventData it) {
                GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                if (guildMediaAioViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                    guildMediaAioViewModel = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaAioViewModel.W1(it);
            }
        };
        l06.observe(viewLifecycleOwner10, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Wh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.guild.media.core.notify.p d26 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "viewLifecycleOwner");
        d26.k0(viewLifecycleOwner11, ThirdAppBarClickEvent.class, new g());
        com.tencent.mobileqq.guild.media.core.notify.p d27 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner12 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner12, "viewLifecycleOwner");
        d27.k0(viewLifecycleOwner12, SwitchThemeEvent.class, new h());
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mediaChannelObserver);
        cn<Boolean> j06 = com.tencent.mobileqq.guild.media.core.j.c().j0();
        LifecycleOwner viewLifecycleOwner13 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$13
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
            public final void invoke2(Boolean it) {
                Logger.f235387a.d().d("QGMC.GuildMediaAioFragment", 1, "[isTodayFirstGetFreeGift] " + it);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                        guildMediaAioViewModel = null;
                    }
                    guildMediaAioViewModel.X1();
                }
            }
        };
        j06.observe(viewLifecycleOwner13, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Xh(Function1.this, obj);
            }
        });
        cn<Boolean> d06 = com.tencent.mobileqq.guild.media.core.j.c().d0();
        LifecycleOwner viewLifecycleOwner14 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initEvents$14
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
            public final void invoke2(Boolean it) {
                Logger.f235387a.d().d("QGMC.GuildMediaAioFragment", 1, "[isFirstGetUpperLimitFreeGift] " + it);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    GuildMediaAioViewModel guildMediaAioViewModel = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                        guildMediaAioViewModel = null;
                    }
                    guildMediaAioViewModel.Z1();
                }
            }
        };
        d06.observe(viewLifecycleOwner14, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.Yh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.guild.media.core.notify.p d28 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner15, "viewLifecycleOwner");
        d28.k0(viewLifecycleOwner15, NotifyGiftRankChanged.class, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildMediaAioFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ji(MediaChannelCore.INSTANCE.a().o0().getAioShowState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(GuildMediaAioFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ph();
        QQSysAndEmojiResMgr.getInstance().refreshConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ci() {
        boolean z16;
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        if (guildInfo != null) {
            z16 = guildInfo.isMember();
        } else {
            z16 = false;
        }
        return !z16;
    }

    private final void di() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(b.a.f227857a);
    }

    private final void ei() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        Integer valueOf = Integer.valueOf(R.drawable.guild_live_channel_icon_system_head);
        String f16 = bs.f();
        String qqStr = HardCodeUtil.qqStr(R.string.f1498613f);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_media_security_text_prefix)");
        guildMediaAioViewModel.l2(new b.c(valueOf, f16, qqStr, null, 8, null));
    }

    private final void fi() {
        ArrayList arrayListOf;
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String d16 = com.tencent.mobileqq.guild.media.core.m.d(Mh());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ch.f());
        iGPSService.fetchUserInfo(d16, arrayListOf, false, new bq() { // from class: com.tencent.mobileqq.guild.media.aio.i
            @Override // vh2.bq
            public final void a(int i3, String str, List list, List list2) {
                GuildMediaAioFragment.gi(GuildMediaAioFragment.this, i3, str, list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(GuildMediaAioFragment this$0, int i3, String str, List list, List list2) {
        MediaUserEnterTipsModel mediaUserEnterTipsModel;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDetached()) {
            QLog.e("QGMC.GuildMediaAioFragment", 1, "isDetached.");
            return;
        }
        if (list.isEmpty()) {
            ev l3 = aj.l();
            if (l3 == null) {
                aj.g(this$0.selfProfileListener);
                QLog.e("QGMC.GuildMediaAioFragment", 1, "selfUserProfileInfo is null! wait update notify.");
                return;
            }
            Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "add self enter tips, from getSelfUserProfileInfo. nick:" + l3.getNickName());
            String f16 = ch.f();
            Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
            String nickName = l3.getNickName();
            Intrinsics.checkNotNullExpressionValue(nickName, "selfUserProfileInfo.nickName");
            mediaUserEnterTipsModel = new MediaUserEnterTipsModel(f16, nickName, this$0.ci(), false, 8, null);
        } else {
            Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "add self enter tips, from fetchUserInfo.");
            IGProUserInfo iGProUserInfo = (IGProUserInfo) list.get(0);
            String f17 = ch.f();
            Intrinsics.checkNotNullExpressionValue(f17, "accountTinyId()");
            String d06 = ch.d0(iGProUserInfo);
            Intrinsics.checkNotNullExpressionValue(d06, "getUserShowName(userInfo)");
            mediaUserEnterTipsModel = new MediaUserEnterTipsModel(f17, d06, this$0.ci(), false, 8, null);
        }
        GuildMediaAioViewModel guildMediaAioViewModel = this$0.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(mediaUserEnterTipsModel);
        guildMediaAioViewModel.l2(new b.e(arrayListOf));
    }

    private final void hi() {
        ViewGroup viewGroup = this.aioMsgUiRootView;
        GuildMediaAioViewModel guildMediaAioViewModel = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        GuildMediaAioViewModel guildMediaAioViewModel2 = this.aioViewModel;
        if (guildMediaAioViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel2 = null;
        }
        guildMediaAioViewModel2.k2();
        GuildMediaAioViewModel guildMediaAioViewModel3 = this.aioViewModel;
        if (guildMediaAioViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel3 = null;
        }
        guildMediaAioViewModel3.l2(new b.v(AioUiState.HIDE));
        GuildMediaAioViewModel guildMediaAioViewModel4 = this.aioViewModel;
        if (guildMediaAioViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
        } else {
            guildMediaAioViewModel = guildMediaAioViewModel4;
        }
        guildMediaAioViewModel.l2(new b.q(false));
    }

    private final void ii() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        GuildMediaAioViewModel guildMediaAioViewModel2 = null;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(new b.v(Lh()));
        GuildMediaAioViewModel guildMediaAioViewModel3 = this.aioViewModel;
        if (guildMediaAioViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
        } else {
            guildMediaAioViewModel2 = guildMediaAioViewModel3;
        }
        guildMediaAioViewModel2.l2(new b.q(true));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.exz, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.aioMsgUiRootView = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.wps);
        Intrinsics.checkNotNullExpressionValue(findViewById, "aioMsgUiRootView.findVie\u2026id.guild_media_aio_swipe)");
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout2 = (GuildLiveSwipeBackLayout) findViewById;
        this.aioMsgUiContainer = guildLiveSwipeBackLayout2;
        if (guildLiveSwipeBackLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiContainer");
            guildLiveSwipeBackLayout2 = null;
        }
        guildLiveSwipeBackLayout2.setOnPageSwipeListener(new j());
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout3 = this.aioMsgUiContainer;
        if (guildLiveSwipeBackLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiContainer");
        } else {
            guildLiveSwipeBackLayout = guildLiveSwipeBackLayout3;
        }
        guildLiveSwipeBackLayout.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaAioFragment.Zh(GuildMediaAioFragment.this);
            }
        });
    }

    private final void initViewModel() {
        GuildMediaAioViewModel.Companion companion = GuildMediaAioViewModel.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        GuildMediaAioViewModel a16 = companion.a(requireActivity);
        this.aioViewModel = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            a16 = null;
        }
        LiveData<a> N1 = a16.N1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<a, Unit> function1 = new Function1<a, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a aVar) {
                GuildLiveSwipeBackLayout guildLiveSwipeBackLayout;
                AioUiState Lh;
                GuildMediaAioMsgListShowHideController guildMediaAioMsgListShowHideController;
                GuildMediaAioMsgListShowHideController guildMediaAioMsgListShowHideController2;
                GuildMediaAioMsgListShowHideController guildMediaAioMsgListShowHideController3;
                GuildMediaAioMsgListShowHideController guildMediaAioMsgListShowHideController4;
                GuildMediaAioViewModel guildMediaAioViewModel = null;
                ViewGroup viewGroup = null;
                GuildMediaAioViewModel guildMediaAioViewModel2 = null;
                if (aVar instanceof a.C7830a) {
                    a.C7830a c7830a = (a.C7830a) aVar;
                    Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "AioNotifyUiEvent.SetAioMsgListUiVisible visible:" + c7830a.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
                    guildMediaAioMsgListShowHideController3 = GuildMediaAioFragment.this.listShowHideController;
                    if (guildMediaAioMsgListShowHideController3 == null) {
                        GuildMediaAioFragment guildMediaAioFragment = GuildMediaAioFragment.this;
                        ViewGroup viewGroup2 = GuildMediaAioFragment.this.aioMsgUiRootView;
                        if (viewGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
                        } else {
                            viewGroup = viewGroup2;
                        }
                        guildMediaAioFragment.listShowHideController = new GuildMediaAioMsgListShowHideController(viewGroup);
                    }
                    guildMediaAioMsgListShowHideController4 = GuildMediaAioFragment.this.listShowHideController;
                    if (guildMediaAioMsgListShowHideController4 != null) {
                        guildMediaAioMsgListShowHideController4.q(c7830a.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
                        return;
                    }
                    return;
                }
                if (aVar instanceof a.b) {
                    Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "AioNotifyUiEvent.SetAioMsgListUiVisible SetAioUiHideToRight.");
                    ViewGroup viewGroup3 = GuildMediaAioFragment.this.aioMsgUiRootView;
                    if (viewGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
                        viewGroup3 = null;
                    }
                    viewGroup3.setVisibility(8);
                    GuildMediaAioViewModel guildMediaAioViewModel3 = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                        guildMediaAioViewModel3 = null;
                    }
                    guildMediaAioViewModel3.l2(new b.h(false, 1, null));
                    GuildMediaAioViewModel guildMediaAioViewModel4 = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                    } else {
                        guildMediaAioViewModel2 = guildMediaAioViewModel4;
                    }
                    guildMediaAioViewModel2.l2(new b.v(AioUiState.HIDE));
                    guildMediaAioMsgListShowHideController2 = GuildMediaAioFragment.this.listShowHideController;
                    if (guildMediaAioMsgListShowHideController2 != null) {
                        guildMediaAioMsgListShowHideController2.s(false);
                        return;
                    }
                    return;
                }
                if (aVar instanceof a.c) {
                    Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "AioNotifyUiEvent.SetAioUiShowFromRight SetAioUiShowFromRight.");
                    ViewGroup viewGroup4 = GuildMediaAioFragment.this.aioMsgUiRootView;
                    if (viewGroup4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
                        viewGroup4 = null;
                    }
                    viewGroup4.setVisibility(0);
                    guildLiveSwipeBackLayout = GuildMediaAioFragment.this.aioMsgUiContainer;
                    if (guildLiveSwipeBackLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiContainer");
                        guildLiveSwipeBackLayout = null;
                    }
                    guildLiveSwipeBackLayout.l(500);
                    GuildMediaAioViewModel guildMediaAioViewModel5 = GuildMediaAioFragment.this.aioViewModel;
                    if (guildMediaAioViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                    } else {
                        guildMediaAioViewModel = guildMediaAioViewModel5;
                    }
                    Lh = GuildMediaAioFragment.this.Lh();
                    guildMediaAioViewModel.l2(new b.v(Lh));
                    guildMediaAioMsgListShowHideController = GuildMediaAioFragment.this.listShowHideController;
                    if (guildMediaAioMsgListShowHideController != null) {
                        guildMediaAioMsgListShowHideController.s(true);
                    }
                }
            }
        };
        N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.media.aio.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaAioFragment.ai(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(boolean show) {
        QLog.i("QGMC.GuildMediaAioFragment", 1, "[swipeAioVisible] show:" + show);
        if (show) {
            ii();
        } else {
            hi();
        }
        MediaChannelCore.INSTANCE.a().o0().e0(show);
    }

    @Override // et0.a
    public void E2(long seq) {
        QLog.i("QGMC.GuildMediaAioFragment", 1, "onInitFirstMsgSeq, seq[" + seq + "]");
        com.tencent.mobileqq.guild.media.core.j.a().O(seq);
    }

    @Override // et0.a
    public void Ea(@NotNull TextView tv5) {
        Intrinsics.checkNotNullParameter(tv5, "tv");
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(new b.g((GuildAIOInputEditText) tv5));
    }

    @Override // et0.a
    public boolean Q4(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        if (guildMediaAioViewModel.g2()) {
            return true;
        }
        return false;
    }

    @Override // et0.a
    @NotNull
    public Integer S() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        GuildMediaAioViewModel guildMediaAioViewModel2 = null;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        int Kh = Kh(guildMediaAioViewModel.O1().getValue());
        GuildMediaAioViewModel guildMediaAioViewModel3 = this.aioViewModel;
        if (guildMediaAioViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
        } else {
            guildMediaAioViewModel2 = guildMediaAioViewModel3;
        }
        guildMediaAioViewModel2.l2(new b.s(Kh));
        return Integer.valueOf(Kh);
    }

    @Override // et0.a
    public void b7(boolean isPanelOrKeyBoardShow, boolean isAioInputBarShow) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("QGMC.GuildMediaAioFragment", 1, "onPanelChanged, isPanelOrKeyBoardShow[" + isPanelOrKeyBoardShow + "], isAioInputBarShow[" + isAioInputBarShow + "]");
        }
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(new b.t(isPanelOrKeyBoardShow, isAioInputBarShow));
    }

    @Override // et0.a
    public void be(boolean isPanelOrKeyBoardShow) {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(new b.u(isPanelOrKeyBoardShow));
    }

    @Override // et0.a
    public void g(boolean isSelectMode) {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(new b.r(isSelectMode));
    }

    @Override // et0.a
    @NotNull
    public View g4(@NotNull View msgListView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgListView, "msgListView");
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout = this.aioMsgUiContainer;
        if (guildLiveSwipeBackLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiContainer");
            guildLiveSwipeBackLayout = null;
        }
        if (guildLiveSwipeBackLayout.indexOfChild(msgListView) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            marginLayoutParams.topMargin = msgListView.getResources().getDimensionPixelSize(R.dimen.ch6);
            GuildLiveSwipeBackLayout guildLiveSwipeBackLayout2 = this.aioMsgUiContainer;
            if (guildLiveSwipeBackLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiContainer");
                guildLiveSwipeBackLayout2 = null;
            }
            guildLiveSwipeBackLayout2.addView(msgListView, marginLayoutParams);
        }
        ViewGroup viewGroup = this.aioMsgUiRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgUiRootView");
            return null;
        }
        return viewGroup;
    }

    @Override // et0.a
    public void l0() {
        if (!this.isInRoomBeforeViewCreated && !isDetached()) {
            ei();
            di();
            fi();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(com.tencent.mobileqq.guild.media.presenter.g.f229131d).get(GuildMediaChannelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(Guil\u2026nelViewModel::class.java)");
        this.mChannelViewModel = (GuildMediaChannelViewModel) viewModel;
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setId(R.id.wpq);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        IGProChannelInfo iGProChannelInfo = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        Serializable serializable = guildMediaChannelViewModel.T1().getSerializable("extra_guild_channel_info");
        if (serializable instanceof IGProChannelInfo) {
            iGProChannelInfo = (IGProChannelInfo) serializable;
        }
        if (iGProChannelInfo != null) {
            com.tencent.mobileqq.guild.util.security.f.f235633d.f(iGProChannelInfo.getGuildId(), this.guildMediaSpeakSwitchObserver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Logger.f235387a.d().i("QGMC.GuildMediaAioFragment", 1, "onDestroyView.");
        GuildMediaAioMsgListShowHideController guildMediaAioMsgListShowHideController = this.listShowHideController;
        if (guildMediaAioMsgListShowHideController != null) {
            guildMediaAioMsgListShowHideController.n();
        }
        aj.q(this.selfProfileListener);
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mediaChannelObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.isInRoomBeforeViewCreated = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().R;
        View view2 = getView();
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAioFragment.bi(GuildMediaAioFragment.this);
                }
            });
        }
    }
}
