package com.tencent.state.square.message.box;

import android.os.Build;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.SquareDebug;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTempMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import com.tencent.state.square.data.SquareUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001UB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J \u0010\u001d\u001a\u00020\u00172\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u001c\u0010 \u001a\u00020\u00192\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\"H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0016JN\u0010+\u001a@\u0012&\u0012$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00190\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,`-\u0012\u0004\u0012\u00020\u00190\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,`.2\u0006\u0010/\u001a\u000200H\u0002JH\u00101\u001a\u00020\u00192\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020)0\u000fj\b\u0012\u0004\u0012\u00020)`\u00112&\u00103\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000204\u0018\u00010\u000fj\n\u0012\u0004\u0012\u000204\u0018\u0001`\u0011\u0012\u0004\u0012\u00020\u00190\"H\u0016J*\u00105\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0018\u00103\u001a\u0014\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001906H\u0016J\b\u00107\u001a\u00020\u0019H\u0002J\b\u00108\u001a\u00020\u0017H\u0016J\u001e\u00109\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100,2\u0006\u0010(\u001a\u00020)H\u0002J,\u0010;\u001a\u00020\u00192\"\u00103\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0012\u0004\u0012\u00020\u00190\"H\u0002J\b\u0010<\u001a\u00020\nH\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0010H\u0002J\u0018\u0010>\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0015H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0002J\u0010\u0010A\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0018\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0017H\u0016J\u0018\u0010E\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0017H\u0016J\b\u0010F\u001a\u00020\u0019H\u0016J\u0018\u0010G\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0017H\u0016J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u0010H\u0016J\u0010\u0010I\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0010\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u0019H\u0002J\u0010\u0010P\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010R\u001a\u00020\u00192\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010S\u001a\u00020\u00192\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010T\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006V"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxDataProvider;", "Lcom/tencent/state/square/message/box/IMsgBoxDataProvider;", "Lcom/tencent/state/square/message/box/IMsgBoxLifeCycle;", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "Lcom/tencent/state/square/message/box/IMsgBoxObservable;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;)V", "canDispatchChange", "", "destroyed", "inited", "Ljava/lang/Boolean;", "msgRecords", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "Lkotlin/collections/ArrayList;", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "readedMsgValidDuration", "", "totalUnReadNum", "", "addMsgBoxDataObserver", "", "observer", "checkForbiddenNotify", "msg", "computeTotalUnReadNum", TabPreloadItem.TAB_NAME_MESSAGE, "destroy", "filterMsgRecord", "filter", "Lkotlin/Function1;", "findItemIndex", "message", "getMsgBoxSource", "Lcom/tencent/state/square/message/box/MsgBoxSource;", "getMsgRecord", "uin", "", "getMsgRecords", "getRecentRecordsTask", "", "Lcom/tencent/state/utils/CallbackFun;", "Lcom/tencent/state/utils/TaskFun;", "type", "Lcom/tencent/state/square/api/MessageRecordType;", "getStrangerNickList", SquareJSConst.Params.PARAMS_UIN_LIST, "callback", "Lcom/tencent/state/square/data/SquareUserInfo;", "getStrangerNickName", "Lkotlin/Function2;", "getTempMessageNick", "getTotalUnReadCount", "inFriendList", "list", "initData", "isDestroy", "isMessageIncrease", "isValidMsg", "curTime", "mockData", "notifyUnreadMessage", "onDataInsert", "data", "index", "onDataRemove", "onDataSetChange", "onDataUpdate", "onNewMessageCome", "onReceiveMessage", "onTotalUnreadNumChange", "unreadNum", "pauseObserve", "flag", "Lcom/tencent/state/square/message/box/MsgBoxOperateFlag;", "registerPlatformMsgObserver", "removeMsgBoxDataObserver", "resumeObserve", "startObserve", "stopObserve", "unRegisterPlatformMsgObserver", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxDataProvider implements IMsgBoxDataProvider, IMsgBoxLifeCycle, IMsgBoxDataObserver, UnreadMessageObserver, IMsgBoxObservable {
    private static final SquareMessageRecord HEAD_ITEM;
    private static final int NON_MSG_INDEX = -1;
    private static final String TAG = "SquareMsgBoxDataProvider";
    private static final SquareMessageRecord TAIL_ITEM;
    private static final int TOP_MSG_INDEX = 1;
    private boolean canDispatchChange;
    private boolean destroyed;
    private Boolean inited;
    private final MsgBoxContext msgBoxContext;
    private final ArrayList<SquareBaseMessageRecord> msgRecords;
    private final CopyOnWriteArraySet<IMsgBoxDataObserver> observers;
    private long readedMsgValidDuration;
    private int totalUnReadNum;

    static {
        MessageRecordType messageRecordType = MessageRecordType.RECORD_TYPE_NONE;
        TAIL_ITEM = new SquareMessageRecord("", messageRecordType);
        HEAD_ITEM = new SquareMessageRecord("", messageRecordType);
    }

    public MsgBoxDataProvider(MsgBoxContext msgBoxContext) {
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        this.msgBoxContext = msgBoxContext;
        this.observers = new CopyOnWriteArraySet<>();
        ArrayList<SquareBaseMessageRecord> arrayList = new ArrayList<>();
        arrayList.add(HEAD_ITEM);
        arrayList.add(TAIL_ITEM);
        Unit unit = Unit.INSTANCE;
        this.msgRecords = arrayList;
        this.canDispatchChange = true;
        Square square = Square.INSTANCE;
        this.readedMsgValidDuration = (square.getConfig().isDebug() && SquareDebug.INSTANCE.getShortMsgBoxReadedExpireDuration()) ? 60000L : square.getConfig().getCommonUtils().getMsgBoxConfig().getReadedMsgValidDay() * 1000;
    }

    private final boolean checkForbiddenNotify(SquareBaseMessageRecord msg2) {
        ISquareBaseMessageService messageService;
        ISquareBaseMessageService messageService2;
        if (msg2.isTroop()) {
            IVasBaseServiceProvider provider = this.msgBoxContext.getProvider();
            return provider == null || (messageService2 = provider.getMessageService()) == null || !messageService2.isReceiveNotify(msg2.getUin(), MessageRecordType.RECORD_TYPE_TROOP);
        }
        if (!msg2.isFriend()) {
            return false;
        }
        IVasBaseServiceProvider provider2 = this.msgBoxContext.getProvider();
        return provider2 == null || (messageService = provider2.getMessageService()) == null || !messageService.isReceiveNotify(msg2.getUin(), MessageRecordType.RECORD_TYPE_FRIEND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int computeTotalUnReadNum(ArrayList<SquareBaseMessageRecord> msgList) {
        int i3 = 0;
        for (SquareBaseMessageRecord squareBaseMessageRecord : msgList) {
            if (!squareBaseMessageRecord.getForbiddenNotify()) {
                if (squareBaseMessageRecord.getUnreadCount() > 0) {
                    i3 += squareBaseMessageRecord.getUnreadCount();
                } else if (squareBaseMessageRecord.getUnReadMark()) {
                    i3++;
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findItemIndex(SquareBaseMessageRecord message) {
        boolean isBlank;
        int i3 = 0;
        for (Object obj : this.msgRecords) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SquareBaseMessageRecord squareBaseMessageRecord = (SquareBaseMessageRecord) obj;
            isBlank = StringsKt__StringsJVMKt.isBlank(squareBaseMessageRecord.getUin());
            if ((!isBlank) && squareBaseMessageRecord.getUin().equals(message.getUin())) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<Function1<? super List<? extends SquareBaseMessageRecord>, Unit>, Unit> getRecentRecordsTask(final MessageRecordType type) {
        return new Function1<Function1<? super List<? extends SquareBaseMessageRecord>, ? extends Unit>, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$getRecentRecordsTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super List<? extends SquareBaseMessageRecord>, ? extends Unit> function1) {
                invoke2((Function1<? super List<? extends SquareBaseMessageRecord>, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Function1<? super List<? extends SquareBaseMessageRecord>, Unit> callback) {
                MsgBoxContext msgBoxContext;
                ISquareBaseMessageService messageService;
                Intrinsics.checkNotNullParameter(callback, "callback");
                msgBoxContext = MsgBoxDataProvider.this.msgBoxContext;
                IVasBaseServiceProvider provider = msgBoxContext.getProvider();
                if (provider == null || (messageService = provider.getMessageService()) == null) {
                    return;
                }
                messageService.getRecentMsgListSyncAioTable(-1, type, new Function1<List<? extends SquareBaseMessageRecord>, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$getRecentRecordsTask$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SquareBaseMessageRecord> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends SquareBaseMessageRecord> msgs) {
                        boolean isValidMsg;
                        Intrinsics.checkNotNullParameter(msgs, "msgs");
                        SquareBaseKt.getSquareLog().i("SquareMsgBoxDataProvider", "getRecentRecords " + type + ", result:" + msgs.size());
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : msgs) {
                            isValidMsg = MsgBoxDataProvider.this.isValidMsg((SquareBaseMessageRecord) obj, currentTimeMillis);
                            if (isValidMsg) {
                                arrayList.add(obj);
                            }
                        }
                        callback.invoke(arrayList);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getTempMessageNick() {
        ArrayList<SquareBaseMessageRecord> arrayList = this.msgRecords;
        ArrayList<SquareBaseMessageRecord> arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SquareBaseMessageRecord) next).getRecordType() == MessageRecordType.RECORD_TYPE_SQUARE_TEMP) {
                arrayList2.add(next);
            }
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (SquareBaseMessageRecord squareBaseMessageRecord : arrayList2) {
            if (!Intrinsics.areEqual(squareBaseMessageRecord.getUin(), "0")) {
                if (!(squareBaseMessageRecord.getUin().length() == 0)) {
                    arrayList3.add(squareBaseMessageRecord.getUin());
                }
            }
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getTempMessageNick, uin is empty, " + squareBaseMessageRecord, null, 4, null);
        }
        getStrangerNickList(arrayList3, new Function1<ArrayList<SquareUserInfo>, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$getTempMessageNick$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SquareUserInfo> arrayList4) {
                invoke2(arrayList4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<SquareUserInfo> arrayList4) {
                ArrayList arrayList5;
                Integer num;
                Object obj;
                int findItemIndex;
                if (arrayList4 != null) {
                    for (SquareUserInfo squareUserInfo : arrayList4) {
                        arrayList5 = MsgBoxDataProvider.this.msgRecords;
                        Iterator it5 = arrayList5.iterator();
                        while (true) {
                            num = null;
                            if (it5.hasNext()) {
                                obj = it5.next();
                                if (Intrinsics.areEqual(((SquareBaseMessageRecord) obj).getUin(), squareUserInfo.getUin())) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        SquareBaseMessageRecord squareBaseMessageRecord2 = (SquareBaseMessageRecord) obj;
                        if (squareBaseMessageRecord2 != null) {
                            findItemIndex = MsgBoxDataProvider.this.findItemIndex(squareBaseMessageRecord2);
                            num = Integer.valueOf(findItemIndex);
                        }
                        if (squareBaseMessageRecord2 != null) {
                            squareBaseMessageRecord2.setNickName(squareUserInfo.getNick());
                        }
                        if (num != null) {
                            MsgBoxDataProvider.this.onDataUpdate(squareBaseMessageRecord2, num.intValue());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean inFriendList(List<? extends SquareBaseMessageRecord> list, String uin) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((SquareBaseMessageRecord) it.next()).getUin(), uin)) {
                return true;
            }
        }
        return false;
    }

    private final void initData(Function1<? super ArrayList<SquareBaseMessageRecord>, Unit> callback) {
        SquareBaseKt.getSquareThread().postOnSubThread(new MsgBoxDataProvider$initData$1(this, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMessageIncrease(SquareBaseMessageRecord message) {
        return message.getUnreadCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidMsg(SquareBaseMessageRecord msg2, long curTime) {
        SquareBaseKt.getSquareLog().i(TAG, "isValidMsg, type: " + msg2.getRecordType() + ", stamp:" + msg2.getLastTimeStamp() + ", curr " + curTime + ", duration:" + this.readedMsgValidDuration);
        return msg2.getUnreadCount() > 0 || curTime - (msg2.getLastTimeStamp() * 1000) < this.readedMsgValidDuration || msg2.getUnReadMark();
    }

    private final void onReceiveMessage(final SquareBaseMessageRecord message) {
        if (getDestroyed()) {
            return;
        }
        if ((message instanceof SquareTempMessageRecord) && SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode()) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveMessage but in study mode and teenage shield open");
        } else {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onReceiveMessage$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean isMessageIncrease;
                    int findItemIndex;
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    int computeTotalUnReadNum;
                    int i3;
                    int findItemIndex2;
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    ArrayList arrayList5;
                    isMessageIncrease = MsgBoxDataProvider.this.isMessageIncrease(message);
                    if (isMessageIncrease) {
                        findItemIndex2 = MsgBoxDataProvider.this.findItemIndex(message);
                        if (findItemIndex2 == 1) {
                            arrayList5 = MsgBoxDataProvider.this.msgRecords;
                            arrayList5.set(findItemIndex2, message);
                            MsgBoxDataProvider.this.onDataUpdate(message, findItemIndex2);
                        } else {
                            if (findItemIndex2 > 1) {
                                arrayList4 = MsgBoxDataProvider.this.msgRecords;
                                arrayList4.remove(findItemIndex2);
                                MsgBoxDataProvider.this.onDataRemove(message, findItemIndex2);
                            }
                            arrayList3 = MsgBoxDataProvider.this.msgRecords;
                            arrayList3.add(1, message);
                            MsgBoxDataProvider.this.onDataInsert(message, 1);
                        }
                        if (!message.getForbiddenNotify()) {
                            MsgBoxDataProvider.this.onNewMessageCome(message);
                        }
                    } else {
                        findItemIndex = MsgBoxDataProvider.this.findItemIndex(message);
                        if (findItemIndex == -1) {
                            return;
                        }
                        arrayList = MsgBoxDataProvider.this.msgRecords;
                        arrayList.set(findItemIndex, message);
                        MsgBoxDataProvider.this.onDataUpdate(message, findItemIndex);
                    }
                    MsgBoxDataProvider msgBoxDataProvider = MsgBoxDataProvider.this;
                    arrayList2 = msgBoxDataProvider.msgRecords;
                    computeTotalUnReadNum = msgBoxDataProvider.computeTotalUnReadNum(arrayList2);
                    msgBoxDataProvider.totalUnReadNum = computeTotalUnReadNum;
                    MsgBoxDataProvider msgBoxDataProvider2 = MsgBoxDataProvider.this;
                    i3 = msgBoxDataProvider2.totalUnReadNum;
                    msgBoxDataProvider2.onTotalUnreadNumChange(i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerPlatformMsgObserver() {
        IVasBaseServiceProvider provider;
        ISquareBaseMessageService messageService;
        if (getDestroyed() || (provider = this.msgBoxContext.getProvider()) == null || (messageService = provider.getMessageService()) == null) {
            return;
        }
        messageService.addUnreadMessageObserver(this);
    }

    private final void unRegisterPlatformMsgObserver() {
        ISquareBaseMessageService messageService;
        IVasBaseServiceProvider provider = this.msgBoxContext.getProvider();
        if (provider == null || (messageService = provider.getMessageService()) == null) {
            return;
        }
        messageService.deleteUnreadMessageObserver(this);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void addMsgBoxDataObserver(IMsgBoxDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (getDestroyed()) {
            return;
        }
        this.observers.add(observer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void filterMsgRecord(final Function1<? super SquareBaseMessageRecord, Boolean> filter) {
        Set set;
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 24) {
            this.msgRecords.removeIf(new Predicate<SquareBaseMessageRecord>() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$filterMsgRecord$1
                @Override // java.util.function.Predicate
                public final boolean test(SquareBaseMessageRecord it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Boolean) Function1.this.invoke(it)).booleanValue();
                }
            });
            return;
        }
        ArrayList<SquareBaseMessageRecord> arrayList = this.msgRecords;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (filter.invoke(obj).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        arrayList.removeAll(set);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    /* renamed from: getMsgBoxSource */
    public MsgBoxSource getSource() {
        return this.msgBoxContext.getMsgBoxManager().getSource();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public SquareBaseMessageRecord getMsgRecord(String uin) {
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Iterator<T> it = this.msgRecords.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (uin.equals(((SquareBaseMessageRecord) obj).getUin())) {
                break;
            }
        }
        return (SquareBaseMessageRecord) obj;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public ArrayList<SquareBaseMessageRecord> getMsgRecords() {
        return this.msgRecords;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void getStrangerNickList(ArrayList<String> uinList, Function1<? super ArrayList<SquareUserInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.msgBoxContext.getMsgBoxManager().getStrangerNickList(uinList, callback);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void getStrangerNickName(String uin, Function2<? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.msgBoxContext.getMsgBoxManager().getStrangerNickName(uin, callback);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    /* renamed from: getTotalUnReadCount, reason: from getter */
    public int getTotalUnReadNum() {
        return this.totalUnReadNum;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    /* renamed from: isDestroy, reason: from getter */
    public boolean getDestroyed() {
        return this.destroyed;
    }

    @Override // com.tencent.state.square.api.UnreadMessageObserver
    public void notifyUnreadMessage(SquareBaseMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        onReceiveMessage(message);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataInsert(final SquareBaseMessageRecord data, final int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canDispatchChange) {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onDataInsert$1
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    copyOnWriteArraySet = MsgBoxDataProvider.this.observers;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IMsgBoxDataObserver) it.next()).onDataInsert(data, index);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataRemove(final SquareBaseMessageRecord data, final int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canDispatchChange) {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onDataRemove$1
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    copyOnWriteArraySet = MsgBoxDataProvider.this.observers;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IMsgBoxDataObserver) it.next()).onDataRemove(data, index);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataSetChange() {
        if (this.canDispatchChange) {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onDataSetChange$1
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    copyOnWriteArraySet = MsgBoxDataProvider.this.observers;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IMsgBoxDataObserver) it.next()).onDataSetChange();
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataUpdate(final SquareBaseMessageRecord data, final int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canDispatchChange) {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onDataUpdate$1
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    copyOnWriteArraySet = MsgBoxDataProvider.this.observers;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IMsgBoxDataObserver) it.next()).onDataUpdate(data, index);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onNewMessageCome(final SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canDispatchChange) {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onNewMessageCome$1
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    copyOnWriteArraySet = MsgBoxDataProvider.this.observers;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IMsgBoxDataObserver) it.next()).onNewMessageCome(data);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onTotalUnreadNumChange(final int unreadNum) {
        if (this.canDispatchChange) {
            this.msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$onTotalUnreadNumChange$1
                @Override // java.lang.Runnable
                public final void run() {
                    CopyOnWriteArraySet copyOnWriteArraySet;
                    copyOnWriteArraySet = MsgBoxDataProvider.this.observers;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((IMsgBoxDataObserver) it.next()).onTotalUnreadNumChange(unreadNum);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void pauseObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.canDispatchChange = false;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void removeMsgBoxDataObserver(IMsgBoxDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (getDestroyed()) {
            return;
        }
        this.observers.remove(observer);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void resumeObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.canDispatchChange = true;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void startObserve(final MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (getDestroyed()) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "startObserve, from:" + flag);
        if (this.inited == null) {
            this.inited = Boolean.FALSE;
            initData(new Function1<ArrayList<SquareBaseMessageRecord>, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$startObserve$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SquareBaseMessageRecord> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<SquareBaseMessageRecord> it) {
                    boolean z16;
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    int computeTotalUnReadNum;
                    int i3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("startObserve, from:");
                    sb5.append(flag);
                    sb5.append(", result:");
                    sb5.append(it.size());
                    sb5.append(", ");
                    z16 = MsgBoxDataProvider.this.destroyed;
                    sb5.append(z16);
                    squareLog.i("SquareMsgBoxDataProvider", sb5.toString());
                    MsgBoxDataProvider.this.inited = Boolean.TRUE;
                    if (MsgBoxDataProvider.this.getDestroyed()) {
                        return;
                    }
                    arrayList = MsgBoxDataProvider.this.msgRecords;
                    arrayList.clear();
                    arrayList2 = MsgBoxDataProvider.this.msgRecords;
                    arrayList2.addAll(it);
                    MsgBoxDataProvider.this.getTempMessageNick();
                    MsgBoxDataProvider.this.onDataSetChange();
                    MsgBoxDataProvider msgBoxDataProvider = MsgBoxDataProvider.this;
                    computeTotalUnReadNum = msgBoxDataProvider.computeTotalUnReadNum(it);
                    msgBoxDataProvider.totalUnReadNum = computeTotalUnReadNum;
                    MsgBoxDataProvider msgBoxDataProvider2 = MsgBoxDataProvider.this;
                    i3 = msgBoxDataProvider2.totalUnReadNum;
                    msgBoxDataProvider2.onTotalUnreadNumChange(i3);
                    MsgBoxDataProvider.this.registerPlatformMsgObserver();
                }
            });
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void stopObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.canDispatchChange = false;
        unRegisterPlatformMsgObserver();
    }

    private final List<SquareBaseMessageRecord> mockData() {
        List listOf;
        int i3 = 2;
        SquareMessageRecord squareMessageRecord = new SquareMessageRecord("11111111", null, i3, 0 == true ? 1 : 0);
        squareMessageRecord.setNickName("\u597d\u53cb1_\u65e0\u672a\u8bfb");
        squareMessageRecord.setUnreadCount(0);
        squareMessageRecord.setLastTimeStamp(System.currentTimeMillis());
        squareMessageRecord.setLastMsg("\u54c8\u54c8\u54c8");
        Unit unit = Unit.INSTANCE;
        SquareMessageRecord squareMessageRecord2 = new SquareMessageRecord("11111112", 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        squareMessageRecord2.setNickName("\u597d\u53cb2_\u672a\u8bfb\u6570");
        squareMessageRecord2.setUnreadCount(3);
        squareMessageRecord2.setLastTimeStamp(System.currentTimeMillis());
        squareMessageRecord2.setLastMsg("\u54c8\u54c8\u54c8");
        SquareMessageRecord squareMessageRecord3 = new SquareMessageRecord("11111113", 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        squareMessageRecord3.setNickName("\u597d\u53cb3_\u8d85\u957f\u6635\u79f0_123456789_abcdefghijklmnopqrstuvwxyz");
        squareMessageRecord3.setUnreadCount(105);
        squareMessageRecord3.setLastTimeStamp(System.currentTimeMillis());
        squareMessageRecord3.setLastMsg("\u54c8\u54c8\u54c8_\u8d85\u957f\u9884\u89c8_123456789_abcdefghijklmnopqrstuvwxyz");
        SquareMessageRecord squareMessageRecord4 = new SquareMessageRecord("11111114", MessageRecordType.RECORD_TYPE_SQUARE_TEMP);
        squareMessageRecord4.setNickName("\u597d\u53cb4_\u56fe\u4e66\u9986");
        squareMessageRecord4.setUnreadCount(45);
        squareMessageRecord4.setLastTimeStamp(System.currentTimeMillis());
        squareMessageRecord4.setLastMsg("\u54c8\u54c8\u54c8");
        SquareTroopMessageRecord squareTroopMessageRecord = new SquareTroopMessageRecord("11111115", 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        squareTroopMessageRecord.setNickName("\u7fa41");
        squareTroopMessageRecord.setUnreadCount(3);
        squareTroopMessageRecord.setLastTimeStamp(System.currentTimeMillis());
        squareTroopMessageRecord.setLastMsg("\u54c8\u54c8\u54c8");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new SquareBaseMessageRecord[]{squareMessageRecord, squareMessageRecord2, squareMessageRecord3, squareMessageRecord4, squareTroopMessageRecord});
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 <= 4; i16++) {
            arrayList.addAll(listOf);
        }
        return arrayList;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    public void destroy() {
        this.destroyed = true;
        stopObserve(MsgBoxOperateFlag.PAGE_DESTROY);
        this.observers.clear();
    }
}
