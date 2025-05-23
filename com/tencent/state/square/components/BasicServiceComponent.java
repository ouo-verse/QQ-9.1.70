package com.tencent.state.square.components;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.IActivityResultHandler;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMiniAioMultiSelectedRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import com.tencent.state.square.invite.ISelectFriendCallback;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J$\u0010!\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/components/BasicServiceComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/IVasBaseServiceProvider;", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "Lcom/tencent/state/IActivityResultHandler;", "()V", "inviteObserverSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/state/square/invite/ISelectFriendCallback;", "messageService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "pushService", "Lcom/tencent/state/square/api/ISquarePushService;", "addSelectFriendCallback", "", "observer", "deleteSelectFriendCallback", "doOnActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "getMessageService", "getPushService", "notifyUnreadMessage", "message", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentPreCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class BasicServiceComponent extends VasBaseFragmentComponent implements IVasBaseServiceProvider, UnreadMessageObserver, IActivityResultHandler {
    private final CopyOnWriteArraySet<ISelectFriendCallback> inviteObserverSet = new CopyOnWriteArraySet<>();
    private ISquareBaseMessageService messageService;
    private ISquarePushService pushService;

    @Override // com.tencent.state.IVasBaseServiceProvider
    public void addSelectFriendCallback(ISelectFriendCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.inviteObserverSet.contains(observer)) {
            return;
        }
        this.inviteObserverSet.add(observer);
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public void deleteSelectFriendCallback(ISelectFriendCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.inviteObserverSet.contains(observer)) {
            this.inviteObserverSet.remove(observer);
        }
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public ISquareBaseMessageService getMessageService() {
        return this.messageService;
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public ISquarePushService getPushService() {
        return this.pushService;
    }

    @Override // com.tencent.state.square.api.UnreadMessageObserver
    public void notifyUnreadMessage(SquareBaseMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ISquareBaseMessageService iSquareBaseMessageService = this.messageService;
        if (iSquareBaseMessageService != null) {
            iSquareBaseMessageService.deleteUnreadMessageObserver(this);
        }
        this.inviteObserverSet.clear();
        ISquarePushService iSquarePushService = this.pushService;
        if (iSquarePushService != null) {
            iSquarePushService.release();
        }
        ISquareBaseMessageService iSquareBaseMessageService2 = this.messageService;
        if (iSquareBaseMessageService2 != null) {
            iSquareBaseMessageService2.destroy();
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPreCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Square square = Square.INSTANCE;
        this.messageService = square.getConfig().getSquareMiniAioServiceProvider().createService();
        this.pushService = square.getConfig().getServiceProvider().createPushService();
        ISquareBaseMessageService iSquareBaseMessageService = this.messageService;
        if (iSquareBaseMessageService != null) {
            iSquareBaseMessageService.init();
        }
        ISquarePushService iSquarePushService = this.pushService;
        if (iSquarePushService != null) {
            iSquarePushService.init();
        }
        ISquareBaseMessageService iSquareBaseMessageService2 = this.messageService;
        if (iSquareBaseMessageService2 != null) {
            iSquareBaseMessageService2.addUnreadMessageObserver(this);
        }
    }

    @Override // com.tencent.state.IActivityResultHandler
    public void doOnActivityResult(int requestCode, int resultCode, Intent data) {
        ISquareBaseMessageService messageService;
        SquareMiniAioMultiSelectedRecord pareSingleSelectUinInfo;
        if (requestCode != 1002 || (messageService = getMessageService()) == null || (pareSingleSelectUinInfo = messageService.pareSingleSelectUinInfo(data)) == null || this.inviteObserverSet.isEmpty()) {
            return;
        }
        Iterator<ISelectFriendCallback> it = this.inviteObserverSet.iterator();
        while (it.hasNext()) {
            ISelectFriendCallback next = it.next();
            String uin = pareSingleSelectUinInfo.getUin();
            boolean z16 = true;
            if (pareSingleSelectUinInfo.getType() != 1) {
                z16 = false;
            }
            next.onSelectFriend(uin, z16);
        }
    }
}
