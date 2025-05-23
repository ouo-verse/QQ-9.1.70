package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0003hijB\t\b\u0002\u00a2\u0006\u0004\bg\u0010%J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014J\u001c\u0010\u001a\u001a\u00020\t2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001dJ3\u0010\"\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b$\u0010%J5\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b&\u0010#J\u0017\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0018H\u0000\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0018H\u0000\u00a2\u0006\u0004\b*\u0010)J\u0019\u0010,\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\u0018H\u0000\u00a2\u0006\u0004\b,\u0010)J\u001c\u0010-\u001a\u00020\u00182\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u001a\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00102\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00104\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00103\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00106\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00105\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00108\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00107\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00109\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0016J(\u0010?\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u0018H\u0016J\u000f\u0010@\u001a\u00020\u0018H\u0000\u00a2\u0006\u0004\b@\u0010AJ<\u0010F\u001a\u00020\t2\u001e\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020C0B0B2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\t0\u0017H\u0002JD\u0010G\u001a\u00020\t2\u001e\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020C0B0B2\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\t0\u0017H\u0002R\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010IR\u0014\u0010L\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010KR\u0016\u0010M\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u0010R\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR3\u0010V\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020C0B0B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010P\u001a\u0004\bT\u0010UR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010WR$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010XR\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010YR&\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\f0[j\b\u0012\u0004\u0012\u00020\f`\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010]R\u0014\u0010_\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010KR\u0014\u0010b\u001a\u00020`8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010aR$\u0010f\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00188B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010A\"\u0004\be\u0010)\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager;", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase$b;", "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer$a;", "", "msgId", "", "audioPath", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "listener", "", "y", "(JLjava/lang/String;Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;)V", "", "instanceHash", HippyTKDListViewAdapter.X, "(JILjava/lang/String;Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;)V", UserInfo.SEX_FEMALE, "(J)V", "G", "(JI)V", "Lkotlin/Function0;", "onPlayerStop", "B", "Lkotlin/Function1;", "", "onLowVolume", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "hashCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", ReportConstant.COSTREPORT_PREFIX, "timeOffset", "", "playSpeed", "E", "(Ljava/lang/String;IFJ)V", "D", "()V", "w", "speakerPhoneOn", "f", "(Z)V", BdhLogUtil.LogTag.Tag_Conn, "needUpdateUI", "u", "o", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase;", "player", "W8", "errorCode", "k9", "streamType", "j5", "volumeType", "Tg", "currentPosition", "V3", "f9", "nearEear", "e", "wiredHeadsetConnect", "btHeadsetConnect", "callFromBoradcast", "k", DomainData.DOMAIN_NAME, "()Z", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$a;", "audioMap", "action", "g", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$PlayerHolder;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$PlayerHolder;", "holder", "Z", "aioPttPlaySpeedSwitch", "curPlaySpeed", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$b;", "i", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$b;", "lastStateHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/concurrent/ConcurrentHashMap;", "listenerMap", "Lkotlin/jvm/functions/Function0;", "Lkotlin/jvm/functions/Function1;", "J", "currentPlayingAudioMsgId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "aioMsgList", "supportMultiAio", "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "()Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "audioPlayer", "value", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "lastTimeUseSpeaker", "<init>", "a", "b", "PlayerHolder", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPttAudioPlayerManager implements AudioPlayerBase.b, CommonAudioPlayer.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private static Function0<Unit> onPlayerStop;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private static Function1<? super Boolean, Unit> onLowVolume;

    /* renamed from: E, reason: from kotlin metadata */
    private static long currentPlayingAudioMsgId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static ArrayList<Integer> aioMsgList;

    /* renamed from: G, reason: from kotlin metadata */
    private static final boolean supportMultiAio;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final AIOPttAudioPlayerManager f191706d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile PlayerHolder holder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final boolean aioPttPlaySpeedSwitch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static float curPlaySpeed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy lastStateHolder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy listenerMap;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$PlayerHolder;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "audioPlayer", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager;", "listener", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class PlayerHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean isInit;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy audioPlayer;

        public PlayerHolder(@NotNull final AIOPttAudioPlayerManager listener) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener);
                return;
            }
            this.isInit = new AtomicBoolean(false);
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<CommonAudioPlayer>(this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$PlayerHolder$audioPlayer$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AIOPttAudioPlayerManager.PlayerHolder this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPttAudioPlayerManager.this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final CommonAudioPlayer invoke() {
                    IAudioDeviceService iAudioDeviceService;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (CommonAudioPlayer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOPttAudioPlayerManager", 2, "AudioPlayer Construct");
                    }
                    CommonAudioPlayer commonAudioPlayer = new CommonAudioPlayer(MobileQQ.sMobileQQ, AIOPttAudioPlayerManager.this);
                    AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.this;
                    AIOPttAudioPlayerManager.PlayerHolder playerHolder = this.this$0;
                    commonAudioPlayer.M();
                    commonAudioPlayer.R(aIOPttAudioPlayerManager);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null && (iAudioDeviceService = (IAudioDeviceService) peekAppRuntime.getRuntimeService(IAudioDeviceService.class, "")) != null) {
                        iAudioDeviceService.registerAudioDeviceListener(commonAudioPlayer);
                    }
                    playerHolder.b().set(true);
                    return commonAudioPlayer;
                }
            });
            this.audioPlayer = lazy;
        }

        @NotNull
        public final CommonAudioPlayer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CommonAudioPlayer) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (CommonAudioPlayer) this.audioPlayer.getValue();
        }

        @NotNull
        public final AtomicBoolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AtomicBoolean) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.isInit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getMsgId", "()J", "msgId", "b", "Ljava/lang/String;", "getAudioPath", "()Ljava/lang/String;", "audioPath", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "listener", "<init>", "(JLjava/lang/String;Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String audioPath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c listener;

        public a(long j3, @Nullable String str, @NotNull c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, listener);
                return;
            }
            this.msgId = j3;
            this.audioPath = str;
            this.listener = listener;
        }

        @NotNull
        public final c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.listener;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.msgId == aVar.msgId && Intrinsics.areEqual(this.audioPath, aVar.audioPath) && Intrinsics.areEqual(this.listener, aVar.listener)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int a16 = androidx.fragment.app.a.a(this.msgId) * 31;
            String str = this.audioPath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return ((a16 + hashCode) * 31) + this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "AudioData(msgId=" + this.msgId + ", audioPath=" + this.audioPath + ", listener=" + this.listener + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttAudioPlayerManager$b;", "", "", "a", "Z", "()Z", "b", "(Z)V", "lastTimeUseSpeaker", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private volatile boolean lastTimeUseSpeaker;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.lastTimeUseSpeaker = !com.tencent.mobileqq.qqaudio.audioplayer.c.b(MobileQQ.sMobileQQ.peekAppRuntime());
            QLog.i("AIOPttAudioPlayerManager", 1, "HolderInit lastTimeUseSpeaker: " + this.lastTimeUseSpeaker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.lastTimeUseSpeaker;
        }

        public final void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.lastTimeUseSpeaker = z16;
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        f191706d = new AIOPttAudioPlayerManager();
        FreesiaWrapperImpl.Companion companion = FreesiaWrapperImpl.INSTANCE;
        boolean isSwitchOn = companion.b().isSwitchOn("aio_ptt_play_speed_9015_119639819", true);
        QLog.i("AIOPttAudioPlayerManager", 1, "aioPttPlaySpeedSwitch:" + isSwitchOn);
        aioPttPlaySpeedSwitch = isSwitchOn;
        curPlaySpeed = 1.0f;
        lazy = LazyKt__LazyJVMKt.lazy(AIOPttAudioPlayerManager$lastStateHolder$2.INSTANCE);
        lastStateHolder = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOPttAudioPlayerManager$listenerMap$2.INSTANCE);
        listenerMap = lazy2;
        aioMsgList = new ArrayList<>();
        supportMultiAio = companion.b().isSwitchOn("ptt_support_multi_aio_127845253", true);
    }

    AIOPttAudioPlayerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void g(ConcurrentHashMap<Long, ConcurrentHashMap<Integer, a>> audioMap, Function1<? super a, Unit> action) {
        Iterator<ConcurrentHashMap<Integer, a>> it = audioMap.values().iterator();
        while (it.hasNext()) {
            for (a audioData : it.next().values()) {
                Intrinsics.checkNotNullExpressionValue(audioData, "audioData");
                action.invoke(audioData);
            }
        }
    }

    private final void h(ConcurrentHashMap<Long, ConcurrentHashMap<Integer, a>> audioMap, long msgId, Function1<? super a, Unit> action) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = audioMap.get(Long.valueOf(msgId));
        if (concurrentHashMap == null) {
            return;
        }
        for (a audioData : concurrentHashMap.values()) {
            Intrinsics.checkNotNullExpressionValue(audioData, "audioData");
            action.invoke(audioData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommonAudioPlayer i() {
        PlayerHolder playerHolder = holder;
        if (playerHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holder");
            playerHolder = null;
        }
        return playerHolder.a();
    }

    private final b j() {
        return (b) lastStateHolder.getValue();
    }

    private final boolean l() {
        return j().a();
    }

    private final ConcurrentHashMap<Long, ConcurrentHashMap<Integer, a>> m() {
        return (ConcurrentHashMap) listenerMap.getValue();
    }

    public static /* synthetic */ boolean p(AIOPttAudioPlayerManager aIOPttAudioPlayerManager, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        return aIOPttAudioPlayerManager.o(str, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
        PlayerHolder playerHolder = holder;
        if (playerHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holder");
            playerHolder = null;
        }
        playerHolder.a();
        QLog.i("AIOPttAudioPlayerManager", 1, "audioPlayer register, lastTimeUseSpeaker: " + f191706d.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        IAudioDeviceService iAudioDeviceService;
        AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
        aIOPttAudioPlayerManager.i().stop();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iAudioDeviceService = (IAudioDeviceService) peekAppRuntime.getRuntimeService(IAudioDeviceService.class, "")) != null) {
            iAudioDeviceService.unRegisterAudioDeviceListener(aIOPttAudioPlayerManager.i());
        }
        aIOPttAudioPlayerManager.i().j();
        aIOPttAudioPlayerManager.m().clear();
        QLog.i("AIOPttAudioPlayerManager", 1, "AudioPlayer Destroy");
    }

    public static /* synthetic */ void v(AIOPttAudioPlayerManager aIOPttAudioPlayerManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        aIOPttAudioPlayerManager.u(z16);
    }

    private final void z(boolean z16) {
        j().b(z16);
    }

    public final void A(@Nullable Function1<? super Boolean, Unit> onLowVolume2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onLowVolume2);
        } else {
            onLowVolume = onLowVolume2;
        }
    }

    public final void B(@Nullable Function0<Unit> onPlayerStop2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onPlayerStop2);
        } else {
            onPlayerStop = onPlayerStop2;
        }
    }

    public final void C(boolean speakerPhoneOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, speakerPhoneOn);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPttAudioPlayerManager", 4, "setSpeakPhoneOn: " + speakerPhoneOn);
        }
        z(speakerPhoneOn);
        com.tencent.mobileqq.qqaudio.audioplayer.c.i(speakerPhoneOn, MobileQQ.sMobileQQ.peekAppRuntime());
        i().g(1, speakerPhoneOn);
    }

    public final void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (i().r()) {
            g(m(), AIOPttAudioPlayerManager$stopCurrentPlayingAudio$1.INSTANCE);
            Function0<Unit> function0 = onPlayerStop;
            if (function0 != null) {
                function0.invoke();
            }
            Function1<? super Boolean, Unit> function1 = onLowVolume;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            i().stop();
        }
        currentPlayingAudioMsgId = 0L;
    }

    public final void E(@NotNull final String audioPath, int timeOffset, float playSpeed, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, audioPath, Integer.valueOf(timeOffset), Float.valueOf(playSpeed), Long.valueOf(msgId));
            return;
        }
        Intrinsics.checkNotNullParameter(audioPath, "audioPath");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPttAudioPlayerManager", 4, "togglePlayAudio: msgId:" + msgId + ", " + audioPath + ", offset: " + timeOffset + ", playSpeed: " + playSpeed + " ");
        }
        if (!i().r()) {
            w(audioPath, timeOffset, playSpeed, msgId);
        } else if (currentPlayingAudioMsgId == msgId) {
            g(m(), new Function1<a, Unit>(audioPath) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$togglePlayAudio$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $audioPath;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$audioPath = audioPath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) audioPath);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    CommonAudioPlayer i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    String str = this.$audioPath;
                    i3 = AIOPttAudioPlayerManager.f191706d.i();
                    a16.a(j3, str, i3.m());
                }
            });
            v(this, false, 1, null);
        } else {
            D();
            w(audioPath, timeOffset, playSpeed, msgId);
        }
    }

    public final void F(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, msgId);
        } else {
            G(msgId, 0);
        }
    }

    public final void G(long msgId, int instanceHash) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(msgId), Integer.valueOf(instanceHash));
            return;
        }
        synchronized (m()) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            ConcurrentHashMap<Integer, a> concurrentHashMap = aIOPttAudioPlayerManager.m().get(Long.valueOf(msgId));
            if (concurrentHashMap == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "listenerMap[msgId] ?: return");
            if (concurrentHashMap.size() <= 1) {
                aIOPttAudioPlayerManager.m().remove(Long.valueOf(msgId));
            } else {
                concurrentHashMap.remove(Integer.valueOf(instanceHash));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void Tg(@Nullable AudioPlayerBase player, int volumeType, @Nullable String audioPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, player, Integer.valueOf(volumeType), audioPath);
            return;
        }
        Function1<? super Boolean, Unit> function1 = onLowVolume;
        if (function1 != null) {
            if (volumeType != 0) {
                z16 = false;
            }
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void V3(@Nullable AudioPlayerBase player, final int currentPosition, @Nullable final String audioPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, player, Integer.valueOf(currentPosition), audioPath);
        } else if (audioPath != null) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            aIOPttAudioPlayerManager.g(aIOPttAudioPlayerManager.m(), new Function1<a, Unit>(audioPath, currentPosition) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$onProgressChanged$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $audioPath;
                final /* synthetic */ int $currentPosition;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$audioPath = audioPath;
                    this.$currentPosition = currentPosition;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) audioPath, currentPosition);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    CommonAudioPlayer i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    String str = this.$audioPath;
                    int i16 = this.$currentPosition;
                    i3 = AIOPttAudioPlayerManager.f191706d.i();
                    a16.g(j3, str, i16, i3.n());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(@NotNull AudioPlayerBase player, @Nullable final String audioPath) {
        final float o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) player, (Object) audioPath);
            return;
        }
        Intrinsics.checkNotNullParameter(player, "player");
        if (QLog.isColorLevel()) {
            QLog.d("AIOPttAudioPlayerManager", 2, "onComplete audioPath: " + audioPath);
        }
        if (aioPttPlaySpeedSwitch) {
            o16 = curPlaySpeed;
        } else {
            o16 = player.o();
        }
        if (audioPath != null) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            aIOPttAudioPlayerManager.g(aIOPttAudioPlayerManager.m(), new Function1<a, Unit>(audioPath) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$onCompletion$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $path;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$path = audioPath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) audioPath);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    a16.b(j3, this.$path);
                }
            });
            aIOPttAudioPlayerManager.h(aIOPttAudioPlayerManager.m(), currentPlayingAudioMsgId, new Function1<a, Unit>(o16) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$onCompletion$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ float $speed;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$speed = o16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Float.valueOf(o16));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    a16.e(j3, this.$speed);
                }
            });
        }
        Function0<Unit> function0 = onPlayerStop;
        if (function0 != null) {
            function0.invoke();
        }
        Function1<? super Boolean, Unit> function1 = onLowVolume;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        currentPlayingAudioMsgId = 0L;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
    public void e(boolean nearEear, boolean speakerPhoneOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        final boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(nearEear), Boolean.valueOf(speakerPhoneOn));
            return;
        }
        if (nearEear || !speakerPhoneOn) {
            z16 = true;
        }
        QLog.d("AIOPttAudioPlayerManager", 1, "Ptt msg: is now near to ear: " + nearEear + ", path: " + i().l() + ", newState: " + z16 + ", oldState, " + l());
        if (z16 != l()) {
            z(z16);
            if (currentPlayingAudioMsgId != 0) {
                h(m(), currentPlayingAudioMsgId, new Function1<a, Unit>(z16) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$onNearToEar$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ boolean $newState;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$newState = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, z16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                        long j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        c a16 = it.a();
                        j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                        a16.c(j3, this.$newState);
                    }
                });
            }
        }
    }

    public final void f(boolean speakerPhoneOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, speakerPhoneOn);
            return;
        }
        QLog.w("AIOPttAudioPlayerManager", 1, "continuePlay: " + speakerPhoneOn);
        C(speakerPhoneOn);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void f9(@Nullable AudioPlayerBase player, @Nullable final String audioPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) player, (Object) audioPath);
            return;
        }
        if (audioPath != null) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            aIOPttAudioPlayerManager.h(aIOPttAudioPlayerManager.m(), currentPlayingAudioMsgId, new Function1<a, Unit>(audioPath) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$onPause$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $audioPath;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$audioPath = audioPath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) audioPath);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    CommonAudioPlayer i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    String str = this.$audioPath;
                    i3 = AIOPttAudioPlayerManager.f191706d.i();
                    a16.a(j3, str, i3.m());
                }
            });
            Function0<Unit> function0 = onPlayerStop;
            if (function0 != null) {
                function0.invoke();
            }
            Function1<? super Boolean, Unit> function1 = onLowVolume;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void j5(@Nullable AudioPlayerBase player, int streamType, @Nullable String audioPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, player, Integer.valueOf(streamType), audioPath);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
    public void k(boolean wiredHeadsetConnect, boolean btHeadsetConnect, boolean speakerPhoneOn, boolean callFromBoradcast) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(wiredHeadsetConnect), Boolean.valueOf(btHeadsetConnect), Boolean.valueOf(speakerPhoneOn), Boolean.valueOf(callFromBoradcast));
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void k9(@Nullable AudioPlayerBase player, int errorCode, @Nullable final String audioPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, player, Integer.valueOf(errorCode), audioPath);
            return;
        }
        if (audioPath != null) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            aIOPttAudioPlayerManager.g(aIOPttAudioPlayerManager.m(), new Function1<a, Unit>(audioPath) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$onError$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $audioPath;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$audioPath = audioPath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) audioPath);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    a16.b(j3, this.$audioPath);
                }
            });
        }
        Function0<Unit> function0 = onPlayerStop;
        if (function0 != null) {
            function0.invoke();
        }
        Function1<? super Boolean, Unit> function1 = onLowVolume;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        currentPlayingAudioMsgId = 0L;
        QLog.e("AIOPttAudioPlayerManager", 1, "onError, errorCode:" + errorCode);
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return i().L();
    }

    public final boolean o(@Nullable String audioPath, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, audioPath, Long.valueOf(msgId))).booleanValue();
        }
        if (holder == null) {
            return false;
        }
        if (msgId > 0 && msgId != currentPlayingAudioMsgId) {
            return false;
        }
        PlayerHolder playerHolder = holder;
        if (playerHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holder");
            playerHolder = null;
        }
        if (!playerHolder.b().get() || (audioPath != null && !TextUtils.equals(audioPath, i().q()))) {
            return false;
        }
        return i().r();
    }

    public final void q(int hashCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, hashCode);
            return;
        }
        aioMsgList.add(Integer.valueOf(hashCode));
        QLog.i("AIOPttAudioPlayerManager", 1, "onCreate  hashCode:" + hashCode + ", size:" + aioMsgList.size());
        if (supportMultiAio && aioMsgList.size() > 1) {
            return;
        }
        holder = new PlayerHolder(this);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttAudioPlayerManager.r();
            }
        });
    }

    public final void s(int hashCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, hashCode);
            return;
        }
        aioMsgList.remove(Integer.valueOf(hashCode));
        QLog.i("AIOPttAudioPlayerManager", 1, "onDestroy  hashCode:" + hashCode + ", size:" + aioMsgList.size());
        if (supportMultiAio && aioMsgList.size() > 0) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttAudioPlayerManager.t();
            }
        });
    }

    public final void u(boolean needUpdateUI) {
        final String q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, needUpdateUI);
            return;
        }
        i().stop();
        Function0<Unit> function0 = onPlayerStop;
        if (function0 != null) {
            function0.invoke();
        }
        Function1<? super Boolean, Unit> function1 = onLowVolume;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        if (needUpdateUI && (q16 = i().q()) != null) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            aIOPttAudioPlayerManager.g(aIOPttAudioPlayerManager.m(), new Function1<a, Unit>(q16) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$pause$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $audioPath;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$audioPath = q16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) q16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                    long j3;
                    CommonAudioPlayer i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    c a16 = it.a();
                    j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                    String str = this.$audioPath;
                    i3 = AIOPttAudioPlayerManager.f191706d.i();
                    a16.a(j3, str, i3.m());
                }
            });
        }
    }

    public final void w(@NotNull final String audioPath, int timeOffset, float playSpeed, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, audioPath, Integer.valueOf(timeOffset), Float.valueOf(playSpeed), Long.valueOf(msgId));
            return;
        }
        Intrinsics.checkNotNullParameter(audioPath, "audioPath");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPttAudioPlayerManager", 4, "playAudio: " + audioPath + ", offset: " + timeOffset + ", playSpeed: " + playSpeed + " ");
        }
        curPlaySpeed = playSpeed;
        i().F(playSpeed);
        currentPlayingAudioMsgId = msgId;
        i().A(audioPath, timeOffset);
        g(m(), new Function1<a, Unit>(audioPath) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager$playAudio$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $audioPath;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$audioPath = audioPath;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) audioPath);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIOPttAudioPlayerManager.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIOPttAudioPlayerManager.a it) {
                long j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                c a16 = it.a();
                j3 = AIOPttAudioPlayerManager.currentPlayingAudioMsgId;
                a16.d(j3, this.$audioPath);
            }
        });
    }

    public final void x(long msgId, int instanceHash, @NotNull String audioPath, @NotNull c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgId), Integer.valueOf(instanceHash), audioPath, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(audioPath, "audioPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (m()) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = f191706d;
            ConcurrentHashMap<Integer, a> concurrentHashMap = aIOPttAudioPlayerManager.m().get(Long.valueOf(msgId));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                aIOPttAudioPlayerManager.m().put(Long.valueOf(msgId), concurrentHashMap);
            }
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "listenerMap[msgId] ?: Co\u2026msgId] = it\n            }");
            concurrentHashMap.put(Integer.valueOf(instanceHash), new a(msgId, audioPath, listener));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void y(long msgId, @NotNull String audioPath, @NotNull c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), audioPath, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(audioPath, "audioPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        x(msgId, 0, audioPath, listener);
    }
}
