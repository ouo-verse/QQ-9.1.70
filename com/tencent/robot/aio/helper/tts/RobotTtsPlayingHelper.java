package com.tencent.robot.aio.helper.tts;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.tts.TtsMsgIntent;
import com.tencent.qqnt.audio.tts.ui.a;
import com.tencent.qqnt.audio.tts.ui.e;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.helper.tts.RobotTtsPlayingHelper$mAction$2;
import com.tencent.robot.aio.helper.tts.task.TtsPlayTaskCenter;
import com.tencent.robot.aio.playvideo.PlayVideoMsgIntent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\u0006*\u0002KQ\b\u0007\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u0003:\u0001>B\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010!\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0016J\b\u00105\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020-H\u0016J4\u0010=\u001a\u00020\u00042\u0006\u00108\u001a\u00020/2\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020:09j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020:`;H\u0016J4\u0010>\u001a\u00020\u00042\u0006\u00108\u001a\u00020/2\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/09j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/`;H\u0016R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010P\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010R\u00a8\u0006V"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/RobotTtsPlayingHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/qqnt/audio/tts/ui/a$a;", "Lcom/tencent/mvi/base/route/g;", "", UserInfo.SEX_FEMALE, "J", "K", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", DomainData.DOMAIN_NAME, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "w", "r", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnRevokeEvent;", "p", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$OnTtsAbilityInitCompleted;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$OnAutoTtsSwitchStateChanged;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$OnReceiveMsgs;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/aio/stream/StreamMsgEvent$OnMsgStreamStatusChanged;", "v", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$ActiveTriggerPlayTtsMsgIntent;", "j", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$ActiveTriggerStopTtsMsgIntent;", "k", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$StopAllTtsMsgIntent;", "t", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$TryToAutoTtsWelcomeMsg;", "msgIntent", "y", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$OnUserTriggerMsgRegenerating;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/aio/stream/StreamMsgEvent$EndStreamAnim;", "o", "Lcom/tencent/qqnt/aio/stream/StreamMsgEvent$OnStreamMsgRegenerated;", "u", BdhLogUtil.LogTag.Tag_Conn, "H", "E", "D", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "event", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "b", "a", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/robot/aio/helper/tts/task/b;", "e", "Lcom/tencent/robot/aio/helper/tts/task/b;", "mTtsPlayTaskCenter", "", "f", "Z", "mIsVideoPlaying", "com/tencent/robot/aio/helper/tts/RobotTtsPlayingHelper$mAction$2$a", h.F, "Lkotlin/Lazy;", "i", "()Lcom/tencent/robot/aio/helper/tts/RobotTtsPlayingHelper$mAction$2$a;", "mAction", "com/tencent/robot/aio/helper/tts/RobotTtsPlayingHelper$mVideoChatReceiver$1", "Lcom/tencent/robot/aio/helper/tts/RobotTtsPlayingHelper$mVideoChatReceiver$1;", "mVideoChatReceiver", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class RobotTtsPlayingHelper implements com.tencent.aio.main.businesshelper.h, a.InterfaceC9501a, g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.aio.helper.tts.task.b mTtsPlayTaskCenter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsVideoPlaying;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotTtsPlayingHelper$mVideoChatReceiver$1 mVideoChatReceiver;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.robot.aio.helper.tts.RobotTtsPlayingHelper$mVideoChatReceiver$1] */
    public RobotTtsPlayingHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<RobotTtsPlayingHelper$mAction$2.a>() { // from class: com.tencent.robot.aio.helper.tts.RobotTtsPlayingHelper$mAction$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/tts/RobotTtsPlayingHelper$mAction$2$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements com.tencent.mvi.base.route.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotTtsPlayingHelper f367104d;

                a(RobotTtsPlayingHelper robotTtsPlayingHelper) {
                    this.f367104d = robotTtsPlayingHelper;
                }

                @Override // com.tencent.mvi.base.route.a
                public void call(@NotNull MsgIntent i3) {
                    Intrinsics.checkNotNullParameter(i3, "i");
                    this.f367104d.n(i3);
                }

                @Override // com.tencent.mvi.base.route.a
                public boolean sticky() {
                    return a.C9235a.a(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotTtsPlayingHelper.this);
            }
        });
        this.mAction = lazy;
        this.mVideoChatReceiver = new BroadcastReceiver() { // from class: com.tencent.robot.aio.helper.tts.RobotTtsPlayingHelper$mVideoChatReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, ITroopHWApi.ACTION_START_VIDEO_CHAT)) {
                    RobotTtsPlayingHelper.this.F();
                }
            }
        };
    }

    private final void A() {
        QLog.i("TtsPlayingHelper", 1, "handleVideoPlayEnd");
        this.mIsVideoPlaying = false;
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.l();
    }

    private final void B() {
        QLog.i("TtsPlayingHelper", 1, "handleVideoPlayStart");
        this.mIsVideoPlaying = true;
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    private final void C() {
        e.INSTANCE.b();
        com.tencent.qqnt.audio.tts.ui.a aVar = com.tencent.qqnt.audio.tts.ui.a.f352581a;
        if (aVar.a() == null) {
            aVar.d(this);
        }
        H();
    }

    private final void D() {
        QLog.i("TtsPlayingHelper", 1, "onLifeCycleDestroy");
        this.mIsVideoPlaying = false;
        com.tencent.aio.api.runtime.a aVar = null;
        com.tencent.qqnt.audio.tts.ui.a.f352581a.d(null);
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.onDestroy();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().i(this, i());
        K();
    }

    private final void E() {
        QLog.i("TtsPlayingHelper", 1, "onLifeCycleStop");
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.aio.helper.tts.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotTtsPlayingHelper.G(RobotTtsPlayingHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(RobotTtsPlayingHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TtsPlayingHelper", 1, "onVideoChatStarted");
        com.tencent.robot.aio.helper.tts.task.b bVar = this$0.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    private final void H() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.aio.helper.tts.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotTtsPlayingHelper.I();
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I() {
        URLDrawable.getDrawable("https://static-res.qq.com/static-res/adelie/aio/aio_audio_playing.png", URLDrawable.URLDrawableOptions.obtain()).downloadImediatly(false);
        URLDrawable.getDrawable("https://static-res.qq.com/static-res/adelie/aio/aio_audio_loading.png", URLDrawable.URLDrawableOptions.obtain()).downloadImediatly(false);
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private final void J() {
        Object m476constructorimpl;
        Context context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        try {
            Result.Companion companion = Result.INSTANCE;
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            Intent intent = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            Fragment c16 = aVar.c();
            if (c16 != null && (context = c16.getContext()) != null) {
                intent = context.registerReceiver(this.mVideoChatReceiver, intentFilter);
            }
            m476constructorimpl = Result.m476constructorimpl(intent);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            QLog.i("TtsPlayingHelper", 1, "registerVideoChatReceiver failed");
        }
    }

    private final void K() {
        Object m476constructorimpl;
        Context context;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            Unit unit = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            Fragment c16 = aVar.c();
            if (c16 != null && (context = c16.getContext()) != null) {
                context.unregisterReceiver(this.mVideoChatReceiver);
                unit = Unit.INSTANCE;
            }
            m476constructorimpl = Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            QLog.i("TtsPlayingHelper", 1, "registerVideoChatReceiver failed");
        }
    }

    private final RobotTtsPlayingHelper$mAction$2.a i() {
        return (RobotTtsPlayingHelper$mAction$2.a) this.mAction.getValue();
    }

    private final void j(TtsMsgIntent.ActiveTriggerPlayTtsMsgIntent intent) {
        QLog.i("TtsPlayingHelper", 1, "handleActiveTriggerPlayTts source = " + intent.a().getMsgId());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.e(intent.a());
    }

    private final void k(TtsMsgIntent.ActiveTriggerStopTtsMsgIntent intent) {
        QLog.i("TtsPlayingHelper", 1, "handleActiveTriggerStopTts source = " + intent.a().getMsgId());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.g(intent.a());
    }

    private final void m(TtsMsgIntent.OnAutoTtsSwitchStateChanged intent) {
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.h(intent.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MsgIntent intent) {
        if (intent instanceof AIOMsgSendEvent.TextSendEvent) {
            x();
            return;
        }
        if (intent instanceof AIOMsgSendEvent.SendBeforeEvent) {
            w();
            return;
        }
        if (intent instanceof AIOMsgListEvent.PlayAudio) {
            r();
            return;
        }
        if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            p((AIOMsgSendEvent.MsgOnRevokeEvent) intent);
            return;
        }
        if (intent instanceof TtsMsgIntent.OnTtsAbilityInitCompleted) {
            z((TtsMsgIntent.OnTtsAbilityInitCompleted) intent);
            return;
        }
        if (intent instanceof TtsMsgIntent.OnAutoTtsSwitchStateChanged) {
            m((TtsMsgIntent.OnAutoTtsSwitchStateChanged) intent);
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnReceiveMsgs) {
            s((AIOMsgListEvent.OnReceiveMsgs) intent);
            return;
        }
        if (intent instanceof StreamMsgEvent.OnMsgStreamStatusChanged) {
            v((StreamMsgEvent.OnMsgStreamStatusChanged) intent);
            return;
        }
        if (intent instanceof TtsMsgIntent.ActiveTriggerPlayTtsMsgIntent) {
            j((TtsMsgIntent.ActiveTriggerPlayTtsMsgIntent) intent);
            return;
        }
        if (intent instanceof TtsMsgIntent.ActiveTriggerStopTtsMsgIntent) {
            k((TtsMsgIntent.ActiveTriggerStopTtsMsgIntent) intent);
            return;
        }
        if (intent instanceof TtsMsgIntent.StopAllTtsMsgIntent) {
            t((TtsMsgIntent.StopAllTtsMsgIntent) intent);
            return;
        }
        if (intent instanceof TtsMsgIntent.TryToAutoTtsWelcomeMsg) {
            y((TtsMsgIntent.TryToAutoTtsWelcomeMsg) intent);
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnUserTriggerMsgRegenerating) {
            q((AIOMsgListEvent.OnUserTriggerMsgRegenerating) intent);
            return;
        }
        if (intent instanceof StreamMsgEvent.EndStreamAnim) {
            o((StreamMsgEvent.EndStreamAnim) intent);
            return;
        }
        if (intent instanceof StreamMsgEvent.OnStreamMsgRegenerated) {
            u((StreamMsgEvent.OnStreamMsgRegenerated) intent);
        } else if (intent instanceof PlayVideoMsgIntent.OnVideoPlayStart) {
            B();
        } else if (intent instanceof PlayVideoMsgIntent.OnVideoPlayEnd) {
            A();
        }
    }

    private final void o(StreamMsgEvent.EndStreamAnim msgIntent) {
        QLog.i("TtsPlayingHelper", 1, "handleMsgEndStreamAnim msgID = " + msgIntent.a());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.k(msgIntent.a());
    }

    private final void p(AIOMsgSendEvent.MsgOnRevokeEvent intent) {
        QLog.i("TtsPlayingHelper", 1, "handlePlayAudioMsgIntent msgId = " + intent.a());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.c(intent.a());
    }

    private final void q(AIOMsgListEvent.OnUserTriggerMsgRegenerating msgIntent) {
        QLog.i("TtsPlayingHelper", 1, "handleOnUserTriggerMsgRegenerating source = " + msgIntent.a().getMsgId());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.j(msgIntent.a());
    }

    private final void r() {
        QLog.i("TtsPlayingHelper", 1, "handlePlayAudioMsgIntent");
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    private final void s(AIOMsgListEvent.OnReceiveMsgs intent) {
        if (this.mIsVideoPlaying) {
            return;
        }
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.p(intent.a());
    }

    private final void t(TtsMsgIntent.StopAllTtsMsgIntent intent) {
        QLog.i("TtsPlayingHelper", 1, "handleStopTtsMsgIntent source = " + intent.a());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    private final void u(StreamMsgEvent.OnStreamMsgRegenerated msgIntent) {
        QLog.i("TtsPlayingHelper", 1, "handleOnUserTriggerMsgRegenerating source = " + msgIntent.a().getMsgId());
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.d(msgIntent.a());
    }

    private final void v(StreamMsgEvent.OnMsgStreamStatusChanged intent) {
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.f(intent.a(), intent.b());
    }

    private final void w() {
        QLog.i("TtsPlayingHelper", 1, "handleTextSendBeforeEvent");
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    private final void x() {
        QLog.i("TtsPlayingHelper", 1, "handleTextSendEvent");
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.m();
    }

    private final void y(TtsMsgIntent.TryToAutoTtsWelcomeMsg msgIntent) {
        QLog.i("TtsPlayingHelper", 1, "autoTtsWelcomeMsg videoPlaying=" + this.mIsVideoPlaying);
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.b(msgIntent.a(), !this.mIsVideoPlaying);
    }

    private final void z(TtsMsgIntent.OnTtsAbilityInitCompleted intent) {
        QLog.i("TtsPlayingHelper", 1, "handleTtsAbilityInitCompleted " + intent);
        com.tencent.robot.aio.helper.tts.task.b bVar = this.mTtsPlayTaskCenter;
        com.tencent.robot.aio.helper.tts.task.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            bVar = null;
        }
        bVar.o(intent.c(), intent.b(), intent.a());
        if (!this.mIsVideoPlaying) {
            com.tencent.robot.aio.helper.tts.task.b bVar3 = this.mTtsPlayTaskCenter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTtsPlayTaskCenter");
            } else {
                bVar2 = bVar3;
            }
            bVar2.l();
        }
    }

    @Override // com.tencent.qqnt.audio.tts.ui.a.InterfaceC9501a
    public void a(@NotNull String event, @NotNull HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), event, params);
    }

    @Override // com.tencent.qqnt.audio.tts.ui.a.InterfaceC9501a
    public void b(@NotNull String event, @NotNull HashMap<String, Object> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.mobileqq.aio.utils.b.f194119a.o(event, params);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 47;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.TextSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendBeforeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.PlayAudio");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.OnTtsAbilityInitCompleted");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.OnAutoTtsSwitchStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnRevokeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnReceiveMsgs");
        hashSet.add("com.tencent.qqnt.aio.stream.StreamMsgEvent.OnMsgStreamStatusChanged");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.ActiveTriggerPlayTtsMsgIntent");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.ActiveTriggerStopTtsMsgIntent");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.StopAllTtsMsgIntent");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.TryToAutoTtsWelcomeMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnUserTriggerMsgRegenerating");
        hashSet.add("com.tencent.qqnt.aio.stream.StreamMsgEvent.EndStreamAnim");
        hashSet.add("com.tencent.qqnt.aio.stream.StreamMsgEvent.OnStreamMsgRegenerated");
        hashSet.add("com.tencent.robot.aio.playvideo.PlayVideoMsgIntent.OnVideoPlayStart");
        hashSet.add("com.tencent.robot.aio.playvideo.PlayVideoMsgIntent.OnVideoPlayEnd");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TtsPlayingHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 8, 9, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        a16.e().f(this, i());
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        TtsPlayTaskCenter ttsPlayTaskCenter = new TtsPlayTaskCenter(aVar);
        ttsPlayTaskCenter.K();
        this.mTtsPlayTaskCenter = ttsPlayTaskCenter;
        J();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 9) {
                if (state == 12) {
                    D();
                    return;
                }
                return;
            }
            E();
            return;
        }
        C();
    }
}
