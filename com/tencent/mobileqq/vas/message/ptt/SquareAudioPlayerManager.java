package com.tencent.mobileqq.vas.message.ptt;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ch;
import com.tencent.mobileqq.vas.social.config.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.api.AudioMessageListener;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.PttMessage;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001cB\u0007\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J2\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00030\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&J\u0006\u0010*\u001a\u00020\u001dJ\u000e\u0010+\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001c\u00101\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00103\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00102\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00105\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00104\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206H\u0016J\u000e\u00109\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0005J$\u0010;\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010:\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010=\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010<\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010>\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010/\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR<\u0010F\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0Bj\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020&0T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010RR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010[R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010]R\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010_\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/vas/message/ptt/SquareAudioPlayerManager;", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase$b;", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "", "W", "", "uin", "", "unreadCount", "Lkotlin/Function1;", "Ljava/util/Queue;", "Lcom/tencent/mobileqq/vas/message/ptt/PttMsgItem;", "callback", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "message", "O", "ptt", "Lkotlin/Function0;", "T", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "M", "E", UserInfo.SEX_FEMALE, "H", "J", "I", "G", "", "msgId", "", "w", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "messageService", "y", "u", "r", ExifInterface.LATITUDE_SOUTH, "X", "Lcom/tencent/state/square/api/AudioMessageListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase;", "player", "sourcePath", "W8", "errorCode", "k9", "currentPosition", "V3", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "notifyUnreadMessage", HippyTKDListViewAdapter.X, "streamType", "j5", "volumeType", "Tg", "f9", "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "d", "Lcom/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "pttMessageCacheMap", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "mHandler", tl.h.F, "Lcom/tencent/mobileqq/vas/message/ptt/PttMsgItem;", "currentMessage", "i", "Ljava/util/Queue;", "currentMessageQueue", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "speakerPhoneOn", "Ljava/util/concurrent/CopyOnWriteArraySet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/CopyOnWriteArraySet;", "audioMessageListenerSet", "D", "isPlaying", "Lcom/tencent/mobileqq/vas/social/config/s;", "Lcom/tencent/mobileqq/vas/social/config/s;", "reporter", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "mFinishListener", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareAudioPlayerManager implements AudioPlayerBase.b, UnreadMessageObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private final CopyOnWriteArraySet<AudioMessageListener> audioMessageListenerSet;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: E, reason: from kotlin metadata */
    private final s reporter;

    /* renamed from: F, reason: from kotlin metadata */
    private ISquareBaseMessageService messageService;

    /* renamed from: G, reason: from kotlin metadata */
    private final MediaPlayer.OnCompletionListener mFinishListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonAudioPlayer player;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Queue<PttMsgItem>> pttMessageCacheMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PttMsgItem currentMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Queue<PttMsgItem> currentMessageQueue;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean speakerPhoneOn;

    public SquareAudioPlayerManager() {
        CommonAudioPlayer commonAudioPlayer = new CommonAudioPlayer(MobileQQ.sMobileQQ, this);
        commonAudioPlayer.M();
        this.player = commonAudioPlayer;
        this.pttMessageCacheMap = new HashMap<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.currentMessageQueue = new LinkedList();
        this.speakerPhoneOn = true;
        this.audioMessageListenerSet = new CopyOnWriteArraySet<>();
        this.reporter = new s(null, 1, 0 == true ? 1 : 0);
        this.mFinishListener = new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.vas.message.ptt.d
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                SquareAudioPlayerManager.D(SquareAudioPlayerManager.this, mediaPlayer);
            }
        };
    }

    private final void A(final String uin, int unreadCount, final Function1<? super Queue<PttMsgItem>, Unit> callback) {
        IKernelService iKernelService;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        w wVar = null;
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface != null && (iKernelService = (IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")) != null) {
            wVar = iKernelService.getMsgService();
        }
        w wVar2 = wVar;
        Contact contact = new Contact(1, ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin), "");
        if (wVar2 != null) {
            wVar2.getMsgs(contact, 0L, unreadCount, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.vas.message.ptt.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    SquareAudioPlayerManager.B(uin, this, callback, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String uin, SquareAudioPlayerManager this$0, final Function1 callback, int i3, String str, ArrayList arrayList) {
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager loadMessageList " + uin + " " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null) + " " + i3 + " " + str);
        if (arrayList == null) {
            return;
        }
        final LinkedList linkedList = new LinkedList();
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = filterNotNull.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MsgRecord) next).msgType == 6) {
                arrayList2.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(new PttMsgItem((MsgRecord) it5.next()));
        }
        ArrayList<PttMsgItem> arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            PttMsgItem pttMsgItem = (PttMsgItem) obj;
            if ((pttMsgItem.H() || pttMsgItem.p2()) ? false : true) {
                arrayList4.add(obj);
            }
        }
        for (PttMsgItem pttMsgItem2 : arrayList4) {
            linkedList.add(pttMsgItem2);
            pttMsgItem2.i2();
        }
        this$0.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.message.ptt.i
            @Override // java.lang.Runnable
            public final void run() {
                SquareAudioPlayerManager.C(Function1.this, linkedList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 callback, Queue pttMessageQueue) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(pttMessageQueue, "$pttMessageQueue");
        callback.invoke(pttMessageQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final SquareAudioPlayerManager this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        AudioUtil.f306881c = null;
        PttMsgItem pttMsgItem = this$0.currentMessage;
        if (pttMsgItem != null) {
            this$0.T(pttMsgItem, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.message.ptt.SquareAudioPlayerManager$mFinishListener$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Queue queue;
                    Queue queue2;
                    boolean z16;
                    PttMsgItem pttMsgItem2;
                    String str;
                    queue = SquareAudioPlayerManager.this.currentMessageQueue;
                    queue.poll();
                    queue2 = SquareAudioPlayerManager.this.currentMessageQueue;
                    if (!queue2.isEmpty()) {
                        z16 = SquareAudioPlayerManager.this.isPlaying;
                        if (z16) {
                            SquareAudioPlayerManager.this.Q();
                            return;
                        }
                        return;
                    }
                    SquareAudioPlayerManager squareAudioPlayerManager = SquareAudioPlayerManager.this;
                    pttMsgItem2 = squareAudioPlayerManager.currentMessage;
                    if (pttMsgItem2 == null || (str = pttMsgItem2.o2()) == null) {
                        str = "";
                    }
                    squareAudioPlayerManager.F(str);
                    SquareAudioPlayerManager.this.currentMessage = null;
                }
            });
        }
    }

    private final void E(PttMsgItem message) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyNewMessagePlay " + message.o2());
        if (!this.audioMessageListenerSet.isEmpty()) {
            Iterator<AudioMessageListener> it = this.audioMessageListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onNewMessagePlay(new PttMessage(message.o2(), message.getMsgRecord().msgId, message.getMsgRecord().msgTime));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String uin) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyPlayComplete " + uin);
        if (!this.audioMessageListenerSet.isEmpty()) {
            Iterator<AudioMessageListener> it = this.audioMessageListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onComplete(uin);
            }
        }
    }

    private final void G(String uin) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyPlayError " + uin);
        if (!this.audioMessageListenerSet.isEmpty()) {
            Iterator<AudioMessageListener> it = this.audioMessageListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onPlayError(uin);
            }
        }
    }

    private final void H(String uin) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyPlayInterrupt " + uin);
        if (!this.audioMessageListenerSet.isEmpty()) {
            Iterator<AudioMessageListener> it = this.audioMessageListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onInterrupt(uin);
            }
        }
    }

    private final void I(String uin) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyPlayPause " + uin);
        if (!this.audioMessageListenerSet.isEmpty()) {
            Iterator<AudioMessageListener> it = this.audioMessageListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onPlayPause(uin);
            }
        }
    }

    private final void J(String uin) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyPlayStart " + uin);
        if (!this.audioMessageListenerSet.isEmpty()) {
            Iterator<AudioMessageListener> it = this.audioMessageListenerSet.iterator();
            while (it.hasNext()) {
                it.next().onPlayStart(uin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(String str, SquareAudioPlayerManager this$0, int i3, String str2, ArrayList arrayList) {
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyUnreadMessage " + str + " " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null) + " " + i3 + " " + str2);
        if (arrayList == null) {
            return;
        }
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = filterNotNull.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MsgRecord) next).msgType == 6) {
                arrayList2.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(new PttMsgItem((MsgRecord) it5.next()));
        }
        ArrayList<PttMsgItem> arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            PttMsgItem pttMsgItem = (PttMsgItem) obj;
            if ((pttMsgItem.H() || pttMsgItem.p2()) ? false : true) {
                arrayList4.add(obj);
            }
        }
        for (PttMsgItem pttMsgItem2 : arrayList4) {
            if (this$0.pttMessageCacheMap.containsKey(pttMsgItem2.o2())) {
                if (!this$0.w(pttMsgItem2.o2(), pttMsgItem2.getMsgRecord().msgId)) {
                    Queue<PttMsgItem> queue = this$0.pttMessageCacheMap.get(pttMsgItem2.o2());
                    if (queue != null) {
                        queue.add(pttMsgItem2);
                    }
                }
            } else {
                HashMap<String, Queue<PttMsgItem>> hashMap = this$0.pttMessageCacheMap;
                String o26 = pttMsgItem2.o2();
                LinkedList linkedList = new LinkedList();
                linkedList.add(pttMsgItem2);
                hashMap.put(o26, linkedList);
            }
            if (QLog.isColorLevel()) {
                QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager notifyUnreadMessage " + pttMsgItem2);
            }
            pttMsgItem2.i2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(SquareAudioPlayerManager this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentMessage != null) {
            long n3 = this$0.player.n();
            if (n3 > 0) {
                float f16 = i3 / ((float) n3);
                PttMsgItem pttMsgItem = this$0.currentMessage;
                if (pttMsgItem == null) {
                    return;
                }
                pttMsgItem.r2(f16);
            }
        }
    }

    private final void M() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.message.ptt.b
            @Override // java.lang.Runnable
            public final void run() {
                SquareAudioPlayerManager.N(SquareAudioPlayerManager.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(SquareAudioPlayerManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            AudioUtil.m(R.raw.f169247q, 1, this$0.mFinishListener, this$0.mHandler);
        } catch (Throwable th5) {
            QLog.e("SquareAudioPlayerManager", 1, th5, new Object[0]);
        }
    }

    private final void O(final PttMsgItem message) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.message.ptt.e
            @Override // java.lang.Runnable
            public final void run() {
                SquareAudioPlayerManager.P(PttMsgItem.this, this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(PttMsgItem message, SquareAudioPlayerManager this$0) {
        int l26;
        Intrinsics.checkNotNullParameter(message, "$message");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (message.q2()) {
                this$0.player.F(1.0f);
                float playProgress = message.getPlayProgress();
                if (playProgress == 1.0f) {
                    message.r2(0.0f);
                    l26 = 0;
                } else {
                    l26 = (int) (playProgress * message.l2());
                }
                this$0.player.A(message.n2(), l26);
                this$0.E(message);
                message.s2();
                return;
            }
            this$0.G(message.o2());
            QQToast.makeText(BaseApplication.getContext(), R.string.xsl, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } catch (Throwable th5) {
            QLog.e("SquareAudioPlayerManager", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        Map<String, Object> mutableMapOf;
        PttMsgItem peek = this.currentMessageQueue.peek();
        if (peek != null) {
            this.currentMessage = peek;
            s sVar = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", peek.o2()), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_ID, Long.valueOf(peek.getMsgRecord().msgId)), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_PLAY_TYPE, 2));
            sVar.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_VOICE_MESSAGE_PLAY, mutableMapOf);
            O(peek);
        }
    }

    private final void T(PttMsgItem ptt, final Function0<Unit> callback) {
        IKernelService iKernelService;
        QLog.d("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager setRead " + ptt.getMsgId());
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        w wVar = null;
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface != null && (iKernelService = (IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")) != null) {
            wVar = iKernelService.getMsgService();
        }
        if (wVar != null) {
            wVar.j(ptt.v(), ptt.getMsgId(), ptt.j2().elementId, new IOperateCallback() { // from class: com.tencent.mobileqq.vas.message.ptt.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SquareAudioPlayerManager.U(i3, str);
                }
            });
        }
        if (wVar != null) {
            wVar.setSpecificMsgReadAndReport(ptt.v(), ptt.getMsgId(), new IOperateCallback() { // from class: com.tencent.mobileqq.vas.message.ptt.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SquareAudioPlayerManager.V(Function0.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(int i3, String str) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager setPttPlayedState " + i3 + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function0 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager setRead " + i3 + " " + str);
        callback.invoke();
    }

    private final void W() {
        int a16 = ch.a(this.speakerPhoneOn, com.tencent.mobileqq.qqaudio.audioplayer.c.f(MobileQQ.sMobileQQ), com.tencent.mobileqq.qqaudio.audioplayer.c.c(MobileQQ.sMobileQQ));
        if (a16 > 0) {
            QQToast.makeText(BaseApplication.getContext(), a16, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private final boolean w(String uin, long msgId) {
        MsgRecord msgRecord;
        Queue<PttMsgItem> queue = this.pttMessageCacheMap.get(uin);
        if (queue != null) {
            for (PttMsgItem pttMsgItem : queue) {
                if ((pttMsgItem == null || (msgRecord = pttMsgItem.getMsgRecord()) == null || msgRecord.msgId != msgId) ? false : true) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void R(final String uin, int unreadCount) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager preLoadPttMessage " + uin + " " + unreadCount);
        A(uin, unreadCount, new Function1<Queue<PttMsgItem>, Unit>() { // from class: com.tencent.mobileqq.vas.message.ptt.SquareAudioPlayerManager$preLoadPttMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Queue<PttMsgItem> queue) {
                invoke2(queue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Queue<PttMsgItem> it) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(it, "it");
                hashMap = SquareAudioPlayerManager.this.pttMessageCacheMap;
                hashMap.put(uin, it);
            }
        });
    }

    public final void S(String uin) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager requestPlay " + uin);
        this.isPlaying = true;
        if (z() && this.currentMessage != null) {
            this.player.stop();
            PttMsgItem pttMsgItem = this.currentMessage;
            Intrinsics.checkNotNull(pttMsgItem);
            H(pttMsgItem.o2());
        }
        if (!this.pttMessageCacheMap.containsKey(uin)) {
            QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager requestPlay containsKey " + uin);
            return;
        }
        Queue<PttMsgItem> queue = this.pttMessageCacheMap.get(uin);
        if (queue != null) {
            this.currentMessageQueue = queue;
            PttMsgItem peek = queue.peek();
            this.speakerPhoneOn = com.tencent.mobileqq.qqaudio.audioplayer.c.b(MobileQQ.sMobileQQ.peekAppRuntime());
            if (peek != null) {
                this.currentMessage = peek;
                W();
                J(uin);
                O(peek);
                s sVar = this.reporter;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", uin), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_ID, Long.valueOf(peek.getMsgRecord().msgId)), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_PLAY_TYPE, 0));
                sVar.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_VOICE_MESSAGE_PLAY, mutableMapOf);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void V3(AudioPlayerBase player, final int currentPosition, String sourcePath) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.message.ptt.a
            @Override // java.lang.Runnable
            public final void run() {
                SquareAudioPlayerManager.L(SquareAudioPlayerManager.this, currentPosition);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(AudioPlayerBase player, String sourcePath) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager onComplete");
        PttMsgItem pttMsgItem = this.currentMessage;
        if (pttMsgItem != null) {
            s sVar = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", pttMsgItem.o2()), TuplesKt.to("zplan_unread_message_number", 1), TuplesKt.to(SquareReportConst.Key.KEY_HANDLE_MESSAGE_METHOD, 5));
            sVar.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_HANDLE_MESSAGE, mutableMapOf);
            s sVar2 = this.reporter;
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", pttMsgItem.o2()), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_ID, Long.valueOf(pttMsgItem.getMsgRecord().msgId)), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_PLAY_TYPE, 1));
            sVar2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_VOICE_MESSAGE_PLAY, mutableMapOf2);
        }
        PttMsgItem pttMsgItem2 = this.currentMessage;
        if (pttMsgItem2 != null) {
            pttMsgItem2.r2(0.0f);
        }
        M();
    }

    public final void X() {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager updateSpeakPhone " + this.speakerPhoneOn);
        boolean z16 = this.speakerPhoneOn ^ true;
        com.tencent.mobileqq.qqaudio.audioplayer.c.i(z16, MobileQQ.sMobileQQ.peekAppRuntime());
        this.speakerPhoneOn = z16;
        W();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void k9(AudioPlayerBase player, int errorCode, String sourcePath) {
        String str;
        QLog.e("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager play onError: " + errorCode);
        PttMsgItem pttMsgItem = this.currentMessage;
        if (pttMsgItem == null || (str = pttMsgItem.o2()) == null) {
            str = "";
        }
        G(str);
    }

    @Override // com.tencent.state.square.api.UnreadMessageObserver
    public void notifyUnreadMessage(SquareBaseMessageRecord record) {
        IKernelService iKernelService;
        Intrinsics.checkNotNullParameter(record, "record");
        if (record instanceof SquareMessageRecord) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            w wVar = null;
            QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
            if (qQAppInterface != null && (iKernelService = (IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")) != null) {
                wVar = iKernelService.getMsgService();
            }
            w wVar2 = wVar;
            final String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(record.getUin());
            Contact contact = new Contact(1, uidFromUin, "");
            if (wVar2 != null) {
                wVar2.getMsgs(contact, 0L, record.getUnreadCount(), true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.vas.message.ptt.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String str, ArrayList arrayList) {
                        SquareAudioPlayerManager.K(uidFromUin, this, i3, str, arrayList);
                    }
                });
            }
        }
    }

    public final void q(AudioMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.audioMessageListenerSet.contains(listener)) {
            return;
        }
        this.audioMessageListenerSet.add(listener);
    }

    public final void s(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager clearTargetCache " + uin);
        if (this.pttMessageCacheMap.containsKey(uin)) {
            this.pttMessageCacheMap.remove(uin);
        }
    }

    public final void t(AudioMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.audioMessageListenerSet.contains(listener)) {
            this.audioMessageListenerSet.remove(listener);
        }
    }

    public final void v(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager doPause " + uin);
        if (z()) {
            this.player.stop();
        }
        this.isPlaying = false;
        I(uin);
    }

    public final boolean x(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Queue<PttMsgItem> queue = this.pttMessageCacheMap.get(uin);
        if (queue == null) {
            return false;
        }
        Iterator<T> it = queue.iterator();
        while (it.hasNext()) {
            if (!((PttMsgItem) it.next()).p2()) {
                return true;
            }
        }
        return false;
    }

    public final boolean z() {
        return this.player.r();
    }

    public final void r() {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager service clear");
        this.pttMessageCacheMap.clear();
        this.currentMessage = null;
        this.currentMessageQueue.clear();
    }

    public final void u() {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager service destroy");
        ISquareBaseMessageService iSquareBaseMessageService = this.messageService;
        if (iSquareBaseMessageService != null) {
            iSquareBaseMessageService.deleteUnreadMessageObserver(this);
        }
        this.pttMessageCacheMap.clear();
        this.currentMessage = null;
        this.currentMessageQueue.clear();
        this.player.stop();
    }

    public final void y(ISquareBaseMessageService messageService) {
        QLog.i("SquareAudioPlayerManager", 1, "SquareAudioPlayerManager service init");
        this.messageService = messageService;
        if (messageService != null) {
            messageService.addUnreadMessageObserver(this);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void f9(AudioPlayerBase player, String sourcePath) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void Tg(AudioPlayerBase player, int volumeType, String sourcePath) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void j5(AudioPlayerBase player, int streamType, String sourcePath) {
    }
}
