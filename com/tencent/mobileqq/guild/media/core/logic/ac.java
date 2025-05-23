package com.tencent.mobileqq.guild.media.core.logic;

import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.guild.media.core.MediaBusinessType;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.es;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u000326:\u0018\u0000 D2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\bB\u0010CJ&\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\"\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u0011J\u001a\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u0011J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ac;", "Lcom/tencent/mobileqq/guild/media/core/d;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "userList", "F0", "", "speakTotalTime", "speakStartTime", "", "tinyId", "", "j0", "i0", "", "userIdList", "", "notifyForAll", "M0", "isSelf", "notifyAll", "P0", "H0", "", "speakMode", "J0", "f0", "isFromPush", "Q0", "isForce", "S0", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "I0", "U0", "E0", "u", "Lcom/tencent/mobileqq/guild/media/core/f;", "f", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Landroidx/lifecycle/MutableLiveData;", tl.h.F, "Landroidx/lifecycle/MutableLiveData;", "l0", "()Landroidx/lifecycle/MutableLiveData;", "setCountDownTime", "(Landroidx/lifecycle/MutableLiveData;)V", "countDownTime", "com/tencent/mobileqq/guild/media/core/logic/ac$c", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/ac$c;", "observer", "com/tencent/mobileqq/guild/media/core/logic/ac$e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/logic/ac$e;", "userTalkPermissionUpdateEvent", "com/tencent/mobileqq/guild/media/core/logic/ac$d", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/core/logic/ac$d;", "speakModeChangeObserver", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "O", "()Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "businessType", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ac extends com.tencent.mobileqq.guild.media.core.d {
    private static long E;

    @Nullable
    private static CountDownTimer F;
    private static long H;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d speakModeChangeObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> countDownTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c observer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e userTalkPermissionUpdateEvent;

    @NotNull
    private static String G = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ac$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f228316b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, long j3) {
            super(j3, 1000L);
            this.f228316b = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "countDown finished");
            ac.this.i0();
            ac.this.l0().postValue(0);
            ac.F = null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f228316b);
            ac.O0(ac.this, arrayList, false, 2, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ac.this.l0().postValue(Integer.valueOf((int) (millisUntilFinished / 1000)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J6\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J6\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ac$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "userList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "", "onUserWaitingToSpeakNotifyForAll", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "onPushAVUserStateChange", "onUserLeaveListNotifyForAll", "onUserAVStateResetNotifyForAll", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPushAVUserStateChange(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
            boolean z16;
            boolean z17;
            if (!MediaChannelUtils.f228046a.u(com.tencent.mobileqq.guild.media.core.j.a().E()) || StringUtil.isEmpty(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a)) {
                return;
            }
            if (userStateInfo != null) {
                long tinyId = userStateInfo.getTinyId();
                String str = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
                Intrinsics.checkNotNullExpressionValue(str, "getDataHub().selfUserInfo.id");
                if (tinyId == Long.parseLong(str)) {
                    z16 = true;
                    if (!z16) {
                        es userCtlInfo = userStateInfo.getUserCtlInfo();
                        if (userCtlInfo != null && userCtlInfo.b() == 3) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            ac.this.Q0(userStateInfo.getUserCtlInfo().getSpeakTimeCtl().getQueueSpeakS(), userStateInfo.getUserCtlInfo().getSpeakTimeCtl().getStartSpeakMs(), String.valueOf(userStateInfo.getTinyId()), true);
                            QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "onPushAVUserStateChange: " + userStateInfo.getTinyId());
                            ac.this.P0(true, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserAVStateResetNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            String str;
            Integer num;
            IGProChannelInfo channelInfo = ac.this.core.getChannelInfo();
            if (channelInfo != null) {
                str = channelInfo.getChannelUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(channelId, str) && MediaChannelUtils.f228046a.u(channelId)) {
                ArrayList arrayList = new ArrayList();
                if (userList != null) {
                    Iterator<T> it = userList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((IGProUserInfo) it.next()).getTinyId());
                    }
                }
                com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo();
                if (arrayList.contains(selfUserInfo.f228093a) && !MediaChannelUtils.f228046a.t(selfUserInfo)) {
                    com.tencent.mobileqq.guild.media.core.j.a().W().g();
                }
                if (arrayList.contains(ac.G)) {
                    ac.T0(ac.this, ac.G, false, 2, null);
                }
                if (userList != null) {
                    num = Integer.valueOf(userList.size());
                } else {
                    num = null;
                }
                QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "onUserAVStateResetNotifyForAll: " + num);
                ac.O0(ac.this, arrayList, false, 2, null);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserLeaveListNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            String str;
            IGProChannelInfo channelInfo = ac.this.core.getChannelInfo();
            if (channelInfo != null) {
                str = channelInfo.getChannelUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(channelId, str) && MediaChannelUtils.f228046a.u(channelId)) {
                ArrayList arrayList = new ArrayList();
                if (userList != null) {
                    Iterator<T> it = userList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((IGProUserInfo) it.next()).getTinyId());
                    }
                }
                QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "onUserLeaveListNotifyForAll: " + arrayList);
                if (arrayList.contains(ac.G)) {
                    ac.T0(ac.this, ac.G, false, 2, null);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserWaitingToSpeakNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            String str;
            IGProUserInfo F0;
            IGProChannelInfo channelInfo = ac.this.core.getChannelInfo();
            if (channelInfo != null) {
                str = channelInfo.getChannelUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(channelId, str) || !MediaChannelUtils.f228046a.u(channelId) || (F0 = ac.this.F0(userList)) == null) {
                return;
            }
            QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "onUserWaitingToSpeakNotifyForAll: " + F0.getTinyId());
            ac.this.P0(Intrinsics.areEqual(F0.getTinyId(), ac.this.core.getSelfUserInfo().f228093a), true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ac$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/z;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.z> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.z event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "speakModeChanged, oldSpeakMode: " + event.getOldSpeakModel() + ", newSpeakMode: " + event.getNewSpeakModel());
            if (!MediaChannelUtils.f228046a.u(ac.this.core.E())) {
                QLog.i("QGMC.MediaChannelAudioQueueHelper", 1, "speak mode change to free");
                ac.T0(ac.this, null, true, 1, null);
                ac.this.M0(null, true);
            }
            ac.this.J0(event.getOldSpeakModel());
            ac.E = NetConnInfoCenter.getServerTime();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ac$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.bi> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (MediaChannelUtils.f228046a.u(ac.this.core.E()) && ac.this.core.S().i0() && !StringUtil.isEmpty(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a) && !StringUtil.isEmpty(ac.this.core.getGuildID()) && !StringUtil.isEmpty(ac.this.core.E())) {
                kt1.d dVar = kt1.d.f412973a;
                long parseLong = Long.parseLong(ac.this.core.getGuildID());
                long parseLong2 = Long.parseLong(ac.this.core.E());
                String str = ac.this.core.v0().getSelfUserInfo().f228093a;
                Intrinsics.checkNotNullExpressionValue(str, "core.getDataHub().selfUserInfo.id");
                dVar.f(parseLong, parseLong2, Long.parseLong(str), false);
            }
        }
    }

    public ac(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.countDownTime = new MutableLiveData<>();
        this.observer = new c();
        this.userTalkPermissionUpdateEvent = new e();
        this.speakModeChangeObserver = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProUserInfo F0(ArrayList<IGProUserInfo> userList) {
        ArrayList arrayList;
        boolean z16;
        if (userList != null) {
            arrayList = new ArrayList();
            for (Object obj : userList) {
                IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
                if (iGProUserInfo.getBusinessInfo().getUserAVInfo().isUserInSpeakQueue() && iGProUserInfo.getBusinessInfo().getUserAVInfo().getSpeakTimeCtl().getStopSpeakMs() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty() || arrayList.size() > 1) {
            return null;
        }
        return (IGProUserInfo) arrayList.get(0);
    }

    private final boolean H0(String tinyId, long speakStartTime) {
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "isUserTimerFinished: " + G + ", " + H);
        if (Intrinsics.areEqual(tinyId, G) && speakStartTime == H) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(int speakMode) {
        if (E <= 0) {
            QLog.i("QGMC.MediaChannelAudioQueueHelper", 1, "reportSpeakModeDuration, enterChannelTime = 0");
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = E;
        long j16 = serverTime - j3;
        QLog.i("QGMC.MediaChannelAudioQueueHelper", 1, "reportSpeakModeDuration, enterChannelTime: " + j3 + ", stayTime: " + j16);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.core.getGuildID());
        hashMap.put("sgrp_sub_channel_id", this.core.E());
        hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(this.core.getGuildID())));
        hashMap.put("sgrp_speakmode_type", Integer.valueOf(speakMode));
        hashMap.put("duration", Long.valueOf(j16));
        VideoReport.reportEvent("ev_sgrp_avchannel_speakmode_duration", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(List<String> userIdList, boolean notifyForAll) {
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "sendFinishEvent, notifyForAll: " + notifyForAll + ", userIdList: " + userIdList);
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.a(userIdList, notifyForAll));
    }

    static /* synthetic */ void O0(ac acVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        acVar.M0(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(boolean isSelf, boolean notifyAll) {
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "sendStartEvent, notifyForAll: " + notifyAll + ", isSelf: " + isSelf);
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.b(isSelf, notifyAll));
    }

    public static /* synthetic */ void R0(ac acVar, long j3, long j16, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        acVar.Q0(j3, j16, str, z16);
    }

    public static /* synthetic */ void T0(ac acVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        acVar.S0(str, z16);
    }

    private final void f0() {
        CountDownTimer countDownTimer = F;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        F = null;
        G = "";
        H = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        if (!TextUtils.isEmpty(G) && Intrinsics.areEqual(this.core.getSelfUserInfo().f228093a, G)) {
            kt1.d.g(kt1.d.f412973a, Long.parseLong(this.core.getGuildID()), Long.parseLong(this.core.E()), Long.parseLong(G), false, 8, null);
        }
    }

    private final void j0(long speakTotalTime, long speakStartTime, String tinyId) {
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "createCountDownTimer, tinyId: " + tinyId + ", speakStartTime: " + speakStartTime + ", speakTotalTime: " + speakTotalTime);
        G = tinyId;
        H = speakStartTime;
        long serverTime = (((long) ((int) (speakStartTime / 1000))) + speakTotalTime) - NetConnInfoCenter.getServerTime();
        long min = Math.min(serverTime, speakTotalTime);
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "createCountDownTimer, countDownTimeCapacity: " + serverTime + ", speakTime: " + min);
        F = new b(tinyId, min * 1000);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        I0();
        f0();
    }

    public void I0() {
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).addObserver(this.observer);
        this.core.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.z.class, this.speakModeChangeObserver);
        this.core.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.userTalkPermissionUpdateEvent);
        E = NetConnInfoCenter.getServerTime();
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    @NotNull
    public MediaBusinessType O() {
        return MediaBusinessType.MEDIA_AUDIO_QUEUE;
    }

    public final void Q0(long speakTotalTime, long speakStartTime, @NotNull String tinyId, boolean isFromPush) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "startCountDownTimer, speakTotalTime: " + speakTotalTime + ", speakStartTime: " + speakStartTime + ", tinyId: " + tinyId);
        if (isFromPush || (!H0(tinyId, speakStartTime) && F == null)) {
            CountDownTimer countDownTimer = F;
            if (countDownTimer != null) {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                F = null;
            }
            j0(speakTotalTime, speakStartTime, tinyId);
            CountDownTimer countDownTimer2 = F;
            if (countDownTimer2 != null) {
                countDownTimer2.start();
            }
        }
    }

    public final void S0(@NotNull String tinyId, boolean isForce) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "stopCountDownTimer: " + tinyId);
        if (!isForce && !Intrinsics.areEqual(tinyId, G)) {
            QLog.d("QGMC.MediaChannelAudioQueueHelper", 1, "the working timer and user not match: " + tinyId);
            return;
        }
        CountDownTimer countDownTimer = F;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTime.postValue(0);
        F = null;
    }

    public void U0() {
        int i3;
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).deleteObserver(this.observer);
        this.core.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.z.class, this.speakModeChangeObserver);
        this.core.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.userTalkPermissionUpdateEvent);
        IGProChannelInfo channelInfo = this.core.getChannelInfo();
        if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null) {
            i3 = voiceSpeakModeCfg.getSpeakMode();
        } else {
            i3 = 1;
        }
        J0(i3);
    }

    @NotNull
    public final MutableLiveData<Integer> l0() {
        return this.countDownTime;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        U0();
        T0(this, null, true, 1, null);
        M0(null, true);
        f0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void R() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void S() {
    }
}
