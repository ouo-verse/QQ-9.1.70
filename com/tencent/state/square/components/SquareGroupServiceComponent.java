package com.tencent.state.square.components;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.DefaultSquareMonitorService;
import com.tencent.state.square.api.ISquareFriendService;
import com.tencent.state.square.api.ISquareMonitorService;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.ISquarePttMessageService;
import com.tencent.state.square.api.MsgType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.invite.ISquareInviteManager;
import com.tencent.state.square.invite.SquareInviteManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/components/SquareGroupServiceComponent;", "Lcom/tencent/state/square/components/BasicServiceComponent;", "Lcom/tencent/state/square/components/ISquareServiceProvider;", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "()V", "friendService", "Lcom/tencent/state/square/api/ISquareFriendService;", "inviter", "Lcom/tencent/state/square/invite/ISquareInviteManager;", "monitorService", "Lcom/tencent/state/square/api/ISquareMonitorService;", "musicService", "Lcom/tencent/state/square/api/ISquareMusicService;", "pttMessageService", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "getFriendService", "getInviteManager", "getMonitorService", "getMusicService", "getPttMessageService", "notifyUnreadMessage", "", "message", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentPreCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupServiceComponent extends BasicServiceComponent implements ISquareServiceProvider {
    private final ISquareFriendService friendService = Square.INSTANCE.getConfig().getServiceProvider().createFriendService();
    private ISquareInviteManager inviter;
    private ISquareMonitorService monitorService;
    private ISquareMusicService musicService;
    private ISquarePttMessageService pttMessageService;

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquareFriendService getFriendService() {
        return this.friendService;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    /* renamed from: getInviteManager, reason: from getter */
    public ISquareInviteManager getInviter() {
        return this.inviter;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquareMonitorService getMonitorService() {
        return this.monitorService;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquareMusicService getMusicService() {
        return this.musicService;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquarePttMessageService getPttMessageService() {
        return this.pttMessageService;
    }

    @Override // com.tencent.state.square.components.BasicServiceComponent, com.tencent.state.square.api.UnreadMessageObserver
    public void notifyUnreadMessage(SquareBaseMessageRecord message) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof SquareMessageRecord) {
            if (message.getUnreadCount() > 0) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("zplan_is_friend_or_group", 0);
                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_ID, Long.valueOf(message.getLastMsgUid()));
                pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_TYPE, Integer.valueOf(((SquareMessageRecord) message).getLastMsgType() != MsgType.PTT ? 0 : 1));
                pairArr[3] = TuplesKt.to("zplan_other_user_qq", message.getUin());
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr);
                squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_RECEIVE_MESSAGE, mutableMapOf2);
                return;
            }
            return;
        }
        if (message instanceof SquareTroopMessageRecord) {
            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_friend_or_group", 1), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_ID, Long.valueOf(message.getLastMsgUid())), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_TYPE, 0), TuplesKt.to("zplan_other_user_qq", message.getUin()));
            squareReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_RECEIVE_MESSAGE, mutableMapOf);
        }
    }

    @Override // com.tencent.state.square.components.BasicServiceComponent, com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        ISquarePttMessageService iSquarePttMessageService = this.pttMessageService;
        if (iSquarePttMessageService != null) {
            iSquarePttMessageService.destroy();
        }
        ISquareMusicService iSquareMusicService = this.musicService;
        if (iSquareMusicService != null) {
            iSquareMusicService.onDestroy();
        }
        ISquareMonitorService iSquareMonitorService = this.monitorService;
        if (iSquareMonitorService != null) {
            iSquareMonitorService.destroy();
        }
        this.friendService.destroy();
    }

    @Override // com.tencent.state.square.components.BasicServiceComponent, com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPreCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentPreCreated(fm5, f16, savedInstanceState);
        Square square = Square.INSTANCE;
        this.pttMessageService = square.getConfig().getSquareMiniAioServiceProvider().createPttMessageService();
        this.musicService = square.getConfig().getServiceProvider().createMusicService();
        this.monitorService = new DefaultSquareMonitorService();
        ISquareMusicService iSquareMusicService = this.musicService;
        if (iSquareMusicService != null) {
            iSquareMusicService.init();
        }
        ISquareMonitorService iSquareMonitorService = this.monitorService;
        if (iSquareMonitorService != null) {
            iSquareMonitorService.init();
        }
        this.friendService.init();
        ISquarePttMessageService iSquarePttMessageService = this.pttMessageService;
        if (iSquarePttMessageService != null) {
            iSquarePttMessageService.init(getMessageService());
        }
        this.inviter = new SquareInviteManager();
    }
}
