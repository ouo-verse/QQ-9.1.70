package com.tencent.state.square.message.box;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.data.SquareUserInfo;
import com.tencent.state.square.detail.DetailBaseSelectFragment;
import com.tencent.state.square.message.StrangerNickManager;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 L2\u00020\u0001:\u0001LB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*H\u0016J\u001c\u0010+\u001a\u00020\u001e2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0-H\u0016J\b\u0010.\u001a\u00020\u000bH\u0016J\u0012\u0010/\u001a\u0004\u0018\u00010%2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u0012\u0012\u0004\u0012\u00020%03j\b\u0012\u0004\u0012\u00020%`4H\u0016JH\u00105\u001a\u00020\u001e2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020103j\b\u0012\u0004\u0012\u000201`42&\u00107\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000208\u0018\u000103j\n\u0012\u0004\u0012\u000208\u0018\u0001`4\u0012\u0004\u0012\u00020\u001e0-H\u0016J*\u00109\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001e0:H\u0016J\b\u0010;\u001a\u00020#H\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010>\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020\u000eH\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\b\u0010A\u001a\u00020\u000eH\u0016J\b\u0010B\u001a\u00020\u000eH\u0016J\b\u0010C\u001a\u00020\u001eH\u0016J\u0010\u0010D\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010E\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010F\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010G\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010J\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010K\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxManager;", "Lcom/tencent/state/square/message/box/IMsgBoxManager;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "managerProxy", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "provider", "Lcom/tencent/state/IVasBaseServiceProvider;", "source", "Lcom/tencent/state/square/message/box/MsgBoxSource;", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/state/VasBaseFragment;Lcom/tencent/state/square/resource/ISquareViewManagerProxy;Lcom/tencent/state/IVasBaseServiceProvider;Lcom/tencent/state/square/message/box/MsgBoxSource;)V", "destroyed", "", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", "msgBoxDataProvider", "Lcom/tencent/state/square/message/box/MsgBoxDataProvider;", "msgBoxReddotHelper", "Lcom/tencent/state/square/message/box/MsgBoxReddotHelper;", "msgListPanel", "Lcom/tencent/state/square/message/box/MsgBoxPanel;", "newMsgBubble", "Lcom/tencent/state/square/message/box/MsgBoxBubble;", "getSource", "()Lcom/tencent/state/square/message/box/MsgBoxSource;", "strangerNickManager", "Lcom/tencent/state/square/message/StrangerNickManager;", "addMsgBoxDataObserver", "", "observer", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "backToMainSquare", "covert2SquareItemType", "", "messageRecord", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "destroy", "enableNewMsgBubble", "enable", "flag", "Lcom/tencent/state/square/message/box/MsgBoxOperateFlag;", "filterMsgRecord", "filter", "Lkotlin/Function1;", "getMsgBoxSource", "getMsgRecord", "uin", "", "getMsgRecords", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStrangerNickList", SquareJSConst.Params.PARAMS_UIN_LIST, "callback", "Lcom/tencent/state/square/data/SquareUserInfo;", "getStrangerNickName", "Lkotlin/Function2;", "getTotalUnReadCount", "hideMsgListPanel", "hideNewMsgBubble", "isDestroy", "isInDetailPage", "isInMainSquare", "isShowingMsgBubble", "isShowingMsgListPanel", "jumpToDetailPage", "pauseObserve", "removeMsgBoxDataObserver", "resumeObserve", "showMsgListPanel", "showNewMsgBubble", "data", "startObserve", "stopObserve", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxManager implements IMsgBoxManager {
    private static final String TAG = "SquareMsgBoxManager";
    private boolean destroyed;
    private final MsgBoxContext msgBoxContext;
    private final MsgBoxDataProvider msgBoxDataProvider;
    private final MsgBoxReddotHelper msgBoxReddotHelper;
    private MsgBoxPanel msgListPanel;
    private MsgBoxBubble newMsgBubble;
    private final MsgBoxSource source;
    private StrangerNickManager strangerNickManager;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageRecordType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageRecordType.RECORD_TYPE_TROOP.ordinal()] = 1;
            iArr[MessageRecordType.RECORD_TYPE_SQUARE_TEMP.ordinal()] = 2;
        }
    }

    public MsgBoxManager(FragmentActivity activity, VasBaseFragment fragment, ISquareViewManagerProxy managerProxy, IVasBaseServiceProvider iVasBaseServiceProvider, MsgBoxSource source) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(managerProxy, "managerProxy");
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        MsgBoxContext msgBoxContext = new MsgBoxContext(activity, new WeakReference(fragment), managerProxy, iVasBaseServiceProvider, this);
        this.msgBoxContext = msgBoxContext;
        this.msgBoxDataProvider = new MsgBoxDataProvider(msgBoxContext);
        this.msgBoxReddotHelper = new MsgBoxReddotHelper(msgBoxContext);
        this.newMsgBubble = new MsgBoxBubble(msgBoxContext);
        this.strangerNickManager = new StrangerNickManager();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void addMsgBoxDataObserver(IMsgBoxDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.msgBoxDataProvider.addMsgBoxDataObserver(observer);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxSceneChange
    public void backToMainSquare() {
        SquareBaseKt.getSquareLog().i(TAG, "backToMainSquare");
        resumeObserve(MsgBoxOperateFlag.BACK_TO_MAIN_SQUARE);
        this.msgBoxReddotHelper.onTotalUnreadNumChange(this.msgBoxDataProvider.getTotalUnReadNum());
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxCommonUtils
    public int covert2SquareItemType(SquareBaseMessageRecord messageRecord) {
        Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
        int i3 = WhenMappings.$EnumSwitchMapping$0[messageRecord.getRecordType().ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? 0 : 2;
        }
        return 1;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public void enableNewMsgBubble(boolean enable, MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.newMsgBubble.enable(enable, flag);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void filterMsgRecord(Function1<? super SquareBaseMessageRecord, Boolean> filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.msgBoxDataProvider.filterMsgRecord(filter);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    /* renamed from: getMsgBoxSource, reason: from getter */
    public MsgBoxSource getSource() {
        return this.source;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public SquareBaseMessageRecord getMsgRecord(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return this.msgBoxDataProvider.getMsgRecord(uin);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public ArrayList<SquareBaseMessageRecord> getMsgRecords() {
        return this.msgBoxDataProvider.getMsgRecords();
    }

    public final MsgBoxSource getSource() {
        return this.source;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void getStrangerNickList(ArrayList<String> uinList, Function1<? super ArrayList<SquareUserInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.strangerNickManager.getStrangerNick(uinList, callback);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void getStrangerNickName(String uin, Function2<? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.strangerNickManager.getStrangerNick(uin, callback);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    /* renamed from: getTotalUnReadCount */
    public int getTotalUnReadNum() {
        return this.msgBoxDataProvider.getTotalUnReadNum();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public void hideMsgListPanel(MsgBoxOperateFlag flag) {
        MsgBoxPanel msgBoxPanel;
        Intrinsics.checkNotNullParameter(flag, "flag");
        MsgBoxPanel msgBoxPanel2 = this.msgListPanel;
        if (msgBoxPanel2 == null || !msgBoxPanel2.isShowing() || (msgBoxPanel = this.msgListPanel) == null) {
            return;
        }
        msgBoxPanel.dismiss();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public void hideNewMsgBubble(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (this.newMsgBubble.isShowing()) {
            this.newMsgBubble.dismiss();
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    /* renamed from: isDestroy, reason: from getter */
    public boolean getDestroyed() {
        return this.destroyed;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxSceneChange
    public boolean isInDetailPage() {
        VasBaseFragment vasBaseFragment = this.msgBoxContext.getFragment().get();
        return (vasBaseFragment != null ? vasBaseFragment.getTopFragment() : null) instanceof DetailBaseSelectFragment;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxSceneChange
    public boolean isInMainSquare() {
        VasBaseFragment vasBaseFragment = this.msgBoxContext.getFragment().get();
        return (vasBaseFragment != null ? vasBaseFragment.getTopFragment() : null) instanceof SquareFragment;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public boolean isShowingMsgBubble() {
        return this.newMsgBubble.isShowing();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public boolean isShowingMsgListPanel() {
        MsgBoxPanel msgBoxPanel = this.msgListPanel;
        if (msgBoxPanel != null) {
            return msgBoxPanel.isShowing();
        }
        return false;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxSceneChange
    public void jumpToDetailPage() {
        SquareBaseKt.getSquareLog().i(TAG, "jumpToDetailPage");
        MsgBoxOperateFlag msgBoxOperateFlag = MsgBoxOperateFlag.ENTER_DETAIL;
        pauseObserve(msgBoxOperateFlag);
        hideNewMsgBubble(msgBoxOperateFlag);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void pauseObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.msgBoxDataProvider.pauseObserve(flag);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataProvider
    public void removeMsgBoxDataObserver(IMsgBoxDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.msgBoxDataProvider.removeMsgBoxDataObserver(observer);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void resumeObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.msgBoxDataProvider.resumeObserve(flag);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public void showMsgListPanel(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (getDestroyed()) {
            return;
        }
        MsgBoxPanel msgBoxPanel = this.msgListPanel;
        if (msgBoxPanel == null) {
            this.msgListPanel = new MsgBoxPanel(this.msgBoxContext);
        } else if (msgBoxPanel != null) {
            msgBoxPanel.onDataSetChange();
        }
        MsgBoxPanel msgBoxPanel2 = this.msgListPanel;
        if (msgBoxPanel2 != null) {
            msgBoxPanel2.show();
        }
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxViewDirector
    public void showNewMsgBubble(SquareBaseMessageRecord data, MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (getDestroyed()) {
            return;
        }
        this.newMsgBubble.setDataAndShowIfNeeded(data);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void startObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.msgBoxDataProvider.startObserve(flag);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxObservable
    public void stopObserve(MsgBoxOperateFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.msgBoxDataProvider.stopObserve(flag);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    public void destroy() {
        this.destroyed = true;
        this.strangerNickManager.clear();
        this.newMsgBubble.destroy();
        MsgBoxPanel msgBoxPanel = this.msgListPanel;
        if (msgBoxPanel != null) {
            msgBoxPanel.destroy();
        }
        this.msgBoxReddotHelper.destroy();
        this.msgBoxDataProvider.destroy();
    }

    public /* synthetic */ MsgBoxManager(FragmentActivity fragmentActivity, VasBaseFragment vasBaseFragment, ISquareViewManagerProxy iSquareViewManagerProxy, IVasBaseServiceProvider iVasBaseServiceProvider, MsgBoxSource msgBoxSource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, vasBaseFragment, iSquareViewManagerProxy, iVasBaseServiceProvider, (i3 & 16) != 0 ? MsgBoxSource.SQUARE : msgBoxSource);
    }
}
