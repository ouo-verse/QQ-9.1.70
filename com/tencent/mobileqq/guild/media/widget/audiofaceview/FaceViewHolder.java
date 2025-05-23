package com.tencent.mobileqq.guild.media.widget.audiofaceview;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guildmedia.data.GuildMediaAIOLottieEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.GuildMediaAIOExKt;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.ac;
import com.tencent.mobileqq.guild.media.core.notify.au;
import com.tencent.mobileqq.guild.media.core.notify.bd;
import com.tencent.mobileqq.guild.media.core.notify.m;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.gift.i;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.NumberUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u000b*\u0004QTWZ\u0018\u0000 b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001cB\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u0011H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016J\u0006\u0010\u001d\u001a\u00020\bJ\u0016\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$R\u0017\u0010(\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b?\u00105\"\u0004\b@\u00107R$\u0010A\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u00103\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u0016\u0010D\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER)\u0010M\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010G0G0F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020$0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001c\u0010_\u001a\n H*\u0004\u0018\u00010G0G8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseTrtcLiveObserveMediaItemViewHolder;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/guildmedia/data/GuildMediaAIOLottieEvent;", "", "currentIsAudioQueueMode", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "", "updateAudioQueueNumber", "updateCountDownTime", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "needReceiveAudioQueueFinish", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "setNetworkStatus", "", "", "hasVolumeUserMap", "setVolume", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "resetStatusAndAnim", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "bindData", "", "tag", "setTag", "", "column", "bindColumn", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/ColumnLayout;", "columnLayout", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/ColumnLayout;", "getColumnLayout", "()Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/ColumnLayout;", "mLocalUser", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "getMLocalUser", "()Lcom/tencent/mobileqq/guild/media/core/data/f;", "setMLocalUser", "(Lcom/tencent/mobileqq/guild/media/core/data/f;)V", "mId", "Ljava/lang/String;", "getMId", "()Ljava/lang/String;", "setMId", "(Ljava/lang/String;)V", "mUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "getMUserInfo", "()Lcom/tencent/mobileqq/guild/media/core/data/p;", "setMUserInfo", "(Lcom/tencent/mobileqq/guild/media/core/data/p;)V", "mAvatarMeta", "getMAvatarMeta", "setMAvatarMeta", "mNickNameIconUrl", "getMNickNameIconUrl", "setMNickNameIconUrl", "mColumn", "I", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "kotlin.jvm.PlatformType", "_gproServiceRef$delegate", "Lkotlin/Lazy;", "get_gproServiceRef", "()Ljava/lang/ref/WeakReference;", "_gproServiceRef", "Landroidx/lifecycle/Observer;", "countDownTimeObserver", "Landroidx/lifecycle/Observer;", "com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$d", "micSequenceListObserver", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$d;", "com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$c", "giftAnimObserver", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$c;", "com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$e", "thirdAppAnimObserver", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$e;", "com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$b", "audioQueueSpeakFinishObserver", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$b;", "getGproService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/ColumnLayout;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FaceViewHolder extends BaseTrtcLiveObserveMediaItemViewHolder implements SimpleEventReceiver<GuildMediaAIOLottieEvent> {
    public static final int DEFAULT_VOLUME = 5;
    public static final int INTERVAL_SECOND = 1000;
    public static final int PRIORITY_DISABLE_VOICE_ANIMATION = 110;
    public static final int PRIORITY_MIC_OFF = 1;
    public static final int PRIORITY_MIC_ON = 100;
    public static final int PRIORITY_MUTE = 2;
    public static final int PRIORITY_PHONE_BUSY = 5;
    public static final int PRIORITY_UNKNOWN = 0;

    @NotNull
    public static final String TAG = "QGMC.FaceViewHolder";

    /* renamed from: _gproServiceRef$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy _gproServiceRef;

    @NotNull
    private final b audioQueueSpeakFinishObserver;

    @NotNull
    private final ColumnLayout columnLayout;

    @NotNull
    private final Observer<Integer> countDownTimeObserver;

    @NotNull
    private final c giftAnimObserver;

    @NotNull
    private String mAvatarMeta;
    private int mColumn;

    @NotNull
    private String mId;

    @Nullable
    private f mLocalUser;

    @Nullable
    private String mNickNameIconUrl;

    @Nullable
    private p mUserInfo;

    @NotNull
    private final d micSequenceListObserver;

    @NotNull
    private final e thirdAppAnimObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements o<com.tencent.mobileqq.guild.media.core.notify.a> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (FaceViewHolder.this.getMUserInfo() != null && FaceViewHolder.this.needReceiveAudioQueueFinish(event)) {
                QLog.d(FaceViewHolder.TAG, 1, "speak finished");
                FaceViewHolder.this.getColumnLayout().A(0);
                ac M = j.a().M();
                p mUserInfo = FaceViewHolder.this.getMUserInfo();
                Intrinsics.checkNotNull(mUserInfo);
                String str = mUserInfo.f228093a;
                Intrinsics.checkNotNullExpressionValue(str, "mUserInfo!!.id");
                ac.T0(M, str, false, 2, null);
                j.a().M().l0().removeObserver(FaceViewHolder.this.countDownTimeObserver);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/m;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<m> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull m event) {
            String str;
            float f16;
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d(FaceViewHolder.TAG, 1, "giftAnimObserver " + event.getGiftData().f264920k + ", path:" + event.getPngFilePath());
            long j3 = event.getGiftData().f264920k;
            p mUserInfo = FaceViewHolder.this.getMUserInfo();
            if (mUserInfo != null) {
                str = mUserInfo.f228093a;
            } else {
                str = null;
            }
            if (j3 == NumberUtil.stringToLong(str) && !StringUtil.isEmpty(event.getPngFilePath())) {
                if (FaceViewHolder.this.mColumn == 3) {
                    f16 = 66.0f;
                } else {
                    f16 = 100.0f;
                }
                int dpToPx = ViewUtils.dpToPx(f16);
                ImageView giftAnimIv = FaceViewHolder.this.getColumnLayout().getGiftAnimIv();
                giftAnimIv.getLayoutParams().width = dpToPx;
                giftAnimIv.getLayoutParams().height = dpToPx;
                giftAnimIv.requestLayout();
                i.f228937a.b(FaceViewHolder.this.getColumnLayout().getGiftAnimShowBg(), FaceViewHolder.this.getColumnLayout().getMAvatarArea(), FaceViewHolder.this.getColumnLayout().getGiftAnimIv(), event);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bd;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements o<bd> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bd event) {
            Intrinsics.checkNotNullParameter(event, "event");
            p mUserInfo = FaceViewHolder.this.getMUserInfo();
            if (mUserInfo != null) {
                FaceViewHolder.this.updateAudioQueueNumber(mUserInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/au;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements o<au> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull au event) {
            Intrinsics.checkNotNullParameter(event, "event");
            p mUserInfo = FaceViewHolder.this.getMUserInfo();
            if (mUserInfo != null) {
                FaceViewHolder faceViewHolder = FaceViewHolder.this;
                faceViewHolder.getColumnLayout().H(mUserInfo, faceViewHolder.getMUserInfo());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceViewHolder(@NotNull ColumnLayout columnLayout) {
        super(columnLayout);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(columnLayout, "columnLayout");
        this.columnLayout = columnLayout;
        this.mId = "";
        this.mAvatarMeta = "";
        this.mColumn = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WeakReference<IGPSService>>() { // from class: com.tencent.mobileqq.guild.media.widget.audiofaceview.FaceViewHolder$_gproServiceRef$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WeakReference<IGPSService> invoke() {
                return new WeakReference<>(ch.R0(IGPSService.class));
            }
        });
        this._gproServiceRef = lazy;
        int random = (int) ((Math.random() * 2) + 1);
        QLog.i(TAG, 1, "MemberRvBaseItemViewHolder init randNum " + random);
        if (GuildMediaUtils.f227771a.n()) {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_item_bg);
        } else if (random == 1) {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg1);
        } else {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg2);
        }
        this.countDownTimeObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.audiofaceview.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceViewHolder.countDownTimeObserver$lambda$0(FaceViewHolder.this, (Integer) obj);
            }
        };
        this.micSequenceListObserver = new d();
        this.giftAnimObserver = new c();
        this.thirdAppAnimObserver = new e();
        this.audioQueueSpeakFinishObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void countDownTimeObserver$lambda$0(FaceViewHolder this$0, Integer countDownTime) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ColumnLayout columnLayout = this$0.columnLayout;
        Intrinsics.checkNotNullExpressionValue(countDownTime, "countDownTime");
        columnLayout.A(countDownTime.intValue());
    }

    private final boolean currentIsAudioQueueMode() {
        return MediaChannelUtils.f228046a.u(j.a().E());
    }

    private final IGPSService getGproService() {
        IGPSService iGPSService = get_gproServiceRef().get();
        if (iGPSService == null) {
            return (IGPSService) ch.R0(IGPSService.class);
        }
        return iGPSService;
    }

    private final WeakReference<IGPSService> get_gproServiceRef() {
        return (WeakReference) this._gproServiceRef.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean needReceiveAudioQueueFinish(com.tencent.mobileqq.guild.media.core.notify.a event) {
        if (!event.getNotifyForAll() && event.b() != null && !event.b().isEmpty()) {
            List<String> b16 = event.b();
            p pVar = this.mUserInfo;
            Intrinsics.checkNotNull(pVar);
            if (b16.contains(pVar.f228093a)) {
                p pVar2 = this.mUserInfo;
                Intrinsics.checkNotNull(pVar2);
                if (pVar2.F > 0) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAudioQueueNumber(p userInfo) {
        Object obj;
        w.c("FaceViewHolder_updateAudioQueueNumber");
        if (!currentIsAudioQueueMode()) {
            this.columnLayout.y(null);
            w.d();
            return;
        }
        List<IGProUserInfo> d16 = j.a().N().d1();
        Iterator<T> it = d16.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), userInfo.f228093a)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
        if (iGProUserInfo != null) {
            this.columnLayout.y(String.valueOf(d16.indexOf(iGProUserInfo) + 1));
        } else {
            this.columnLayout.y(null);
        }
        w.d();
    }

    private final void updateCountDownTime(p userInfo) {
        w.c("FaceViewHolder_updateCountDownTime");
        if (!currentIsAudioQueueMode()) {
            this.columnLayout.A(0);
            w.d();
            return;
        }
        if (userInfo.E && userInfo.F > 0) {
            int userAVState = userInfo.C.getUserAVInfo().getUserAVState();
            if (userInfo.G > 0 && (userAVState == 4 || userAVState == 8 || userAVState == 3 || userAVState == 1)) {
                ac M = j.a().M();
                long j3 = userInfo.H;
                long j16 = userInfo.G;
                String str = userInfo.f228093a;
                Intrinsics.checkNotNullExpressionValue(str, "userInfo.id");
                ac.R0(M, j3, j16, str, false, 8, null);
                j.a().M().l0().observeForever(this.countDownTimeObserver);
                j.d().V(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueSpeakFinishObserver);
            }
            w.d();
            return;
        }
        this.columnLayout.A(0);
        j.a().M().l0().removeObserver(this.countDownTimeObserver);
        j.d().V(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueSpeakFinishObserver);
        w.d();
    }

    public final void bindColumn(int column) {
        if (this.mColumn == column) {
            return;
        }
        this.mColumn = column;
        w.c("FaceViewHolder_bindColumn");
        this.columnLayout.f(column);
        w.d();
    }

    public final void bindData(@NotNull p userInfo, @NotNull f selfUserInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        w.c("FaceViewHolder_bindData");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 2, "[bindData] userInfo: " + userInfo);
        }
        w.c("UserInfo_copy");
        this.mLocalUser = selfUserInfo;
        p pVar = this.mUserInfo;
        if (pVar == null) {
            p j3 = p.j();
            j3.e(userInfo);
            this.mUserInfo = j3;
        } else if (pVar != null) {
            pVar.e(userInfo);
        }
        w.d();
        getColumnLayout().D(userInfo);
        Unit unit = Unit.INSTANCE;
        ColumnLayout columnLayout = getColumnLayout();
        String str = selfUserInfo.P;
        Intrinsics.checkNotNullExpressionValue(str, "selfUserInfo.guildId");
        String str2 = userInfo.f228093a;
        Intrinsics.checkNotNullExpressionValue(str2, "userInfo.id");
        String str3 = userInfo.f228096d;
        Intrinsics.checkNotNullExpressionValue(str3, "userInfo.avatarMeta");
        String str4 = userInfo.J;
        Intrinsics.checkNotNullExpressionValue(str4, "userInfo.avatarPendant");
        columnLayout.z(str, str2, str3, str4);
        getColumnLayout().setNetWorkStatus(userInfo);
        getColumnLayout().H(userInfo, getMUserInfo());
        getColumnLayout().J(userInfo);
        getColumnLayout().x(userInfo);
        getColumnLayout().G(userInfo);
        getColumnLayout().F(userInfo);
        updateAudioQueueNumber(userInfo);
        updateCountDownTime(userInfo);
        j.d().V(bd.class, this.micSequenceListObserver);
        j.d().V(au.class, this.thirdAppAnimObserver);
        w.d();
    }

    @NotNull
    public final ColumnLayout getColumnLayout() {
        return this.columnLayout;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildMediaAIOLottieEvent>> getEventClass() {
        ArrayList<Class<GuildMediaAIOLottieEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildMediaAIOLottieEvent.class);
        return arrayListOf;
    }

    @NotNull
    protected final String getMAvatarMeta() {
        return this.mAvatarMeta;
    }

    @NotNull
    protected final String getMId() {
        return this.mId;
    }

    @Nullable
    protected final f getMLocalUser() {
        return this.mLocalUser;
    }

    @Nullable
    protected final String getMNickNameIconUrl() {
        return this.mNickNameIconUrl;
    }

    @Nullable
    protected final p getMUserInfo() {
        return this.mUserInfo;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GuildMediaAIOExKt.j(event, this.mUserInfo, this.columnLayout.k(), this.columnLayout.l());
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
        j.d().V(m.class, this.giftAnimObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        j.d().j(m.class, this.giftAnimObserver);
        i.f228937a.c(this.columnLayout.getGiftAnimShowBg());
    }

    public final void resetStatusAndAnim() {
        this.columnLayout.s();
        j.a().M().l0().removeObserver(this.countDownTimeObserver);
        j.d().j(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueSpeakFinishObserver);
        j.d().j(bd.class, this.micSequenceListObserver);
        j.d().j(au.class, this.thirdAppAnimObserver);
    }

    protected final void setMAvatarMeta(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mAvatarMeta = str;
    }

    protected final void setMId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mId = str;
    }

    protected final void setMLocalUser(@Nullable f fVar) {
        this.mLocalUser = fVar;
    }

    protected final void setMNickNameIconUrl(@Nullable String str) {
        this.mNickNameIconUrl = str;
    }

    protected final void setMUserInfo(@Nullable p pVar) {
        this.mUserInfo = pVar;
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void setNetworkStatus(@NotNull r userInfoList) {
        String str;
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        p pVar = this.mUserInfo;
        if (pVar != null) {
            str = pVar.f228093a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        p g16 = userInfoList.g(str);
        if (g16 != null) {
            this.columnLayout.setNetWorkStatus(g16);
        }
    }

    public final void setTag(@NotNull Object tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.itemView.setTag(tag);
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void setVolume(@NotNull Map<String, ? extends p> hasVolumeUserMap) {
        Intrinsics.checkNotNullParameter(hasVolumeUserMap, "hasVolumeUserMap");
        this.columnLayout.K(hasVolumeUserMap, this.mUserInfo);
    }
}
