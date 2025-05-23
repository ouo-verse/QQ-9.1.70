package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquareFriendService;
import com.tencent.state.square.api.ISquareMonitorService;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.ISquarePttMessageService;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTempMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import com.tencent.state.square.components.ISquareServiceProvider;
import com.tencent.state.square.components.SquareGroupServiceComponent;
import com.tencent.state.square.invite.ISelectFriendCallback;
import com.tencent.state.square.invite.ISquareInviteManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,BY\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0016R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/square/components/ISquareServiceProvider;", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "proxy", "onUnreadMessageNotify", "Lkotlin/Function1;", "Lcom/tencent/state/square/api/SquareMessageRecord;", "", "onTempUnreadMessageNotify", "Lcom/tencent/state/square/api/SquareTempMessageRecord;", "onTroopMessageNotify", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "(Lcom/tencent/state/square/components/ISquareServiceProvider;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "addSelectFriendCallback", "observer", "Lcom/tencent/state/square/invite/ISelectFriendCallback;", "deleteSelectFriendCallback", "getFriendService", "Lcom/tencent/state/square/api/ISquareFriendService;", "getInviteManager", "Lcom/tencent/state/square/invite/ISquareInviteManager;", "getMessageService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "getMonitorService", "Lcom/tencent/state/square/api/ISquareMonitorService;", "getMusicService", "Lcom/tencent/state/square/api/ISquareMusicService;", "getPttMessageService", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "getPushService", "Lcom/tencent/state/square/api/ISquarePushService;", "getServiceProvider", "notifyUnreadMessage", "message", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareServiceProvider extends VasBaseFragmentComponent implements ISquareServiceProvider, UnreadMessageObserver {
    private static final String TAG = "SquareServiceProvider";
    private final Function1<SquareTempMessageRecord, Unit> onTempUnreadMessageNotify;
    private final Function1<SquareTroopMessageRecord, Unit> onTroopMessageNotify;
    private final Function1<SquareMessageRecord, Unit> onUnreadMessageNotify;
    private final ISquareServiceProvider proxy;

    public SquareServiceProvider() {
        this(null, null, null, null, 15, null);
    }

    private final ISquareServiceProvider getServiceProvider() {
        ISquareServiceProvider iSquareServiceProvider = this.proxy;
        if (iSquareServiceProvider != null) {
            return iSquareServiceProvider;
        }
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            return (SquareGroupServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, SquareGroupServiceComponent.class, null, null, 6, null);
        }
        return null;
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public void addSelectFriendCallback(ISelectFriendCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            serviceProvider.addSelectFriendCallback(observer);
        }
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public void deleteSelectFriendCallback(ISelectFriendCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            serviceProvider.deleteSelectFriendCallback(observer);
        }
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquareFriendService getFriendService() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getFriendService();
        }
        return null;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    /* renamed from: getInviteManager */
    public ISquareInviteManager getInviter() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getInviter();
        }
        return null;
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public ISquareBaseMessageService getMessageService() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getMessageService();
        }
        return null;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquareMonitorService getMonitorService() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getMonitorService();
        }
        return null;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquareMusicService getMusicService() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getMusicService();
        }
        return null;
    }

    @Override // com.tencent.state.square.components.ISquareServiceProvider
    public ISquarePttMessageService getPttMessageService() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getPttMessageService();
        }
        return null;
    }

    @Override // com.tencent.state.IVasBaseServiceProvider
    public ISquarePushService getPushService() {
        ISquareServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider != null) {
            return serviceProvider.getPushService();
        }
        return null;
    }

    @Override // com.tencent.state.square.api.UnreadMessageObserver
    public void notifyUnreadMessage(final SquareBaseMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareServiceProvider$notifyUnreadMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function1 function1;
                Function1 function12;
                Function1 function13;
                SquareBaseMessageRecord squareBaseMessageRecord = message;
                if (squareBaseMessageRecord instanceof SquareMessageRecord) {
                    function13 = SquareServiceProvider.this.onUnreadMessageNotify;
                    if (function13 != null) {
                        return;
                    }
                    return;
                }
                if (squareBaseMessageRecord instanceof SquareTroopMessageRecord) {
                    function12 = SquareServiceProvider.this.onTroopMessageNotify;
                    if (function12 != null) {
                        return;
                    }
                    return;
                }
                if (squareBaseMessageRecord instanceof SquareTempMessageRecord) {
                    if (!SquareBaseKt.getSquareCommon().getNeedShieldTeenager() || !SquareBaseKt.getSquareCommon().getStudyMode()) {
                        function1 = SquareServiceProvider.this.onTempUnreadMessageNotify;
                        if (function1 != null) {
                            return;
                        }
                        return;
                    }
                    SquareBaseKt.getSquareLog().i("SquareServiceProvider", "receiver temp message in study and need shield teenager");
                }
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ISquareBaseMessageService messageService = getMessageService();
        if (messageService != null) {
            messageService.addUnreadMessageObserver(this);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ISquareBaseMessageService messageService = getMessageService();
        if (messageService != null) {
            messageService.deleteUnreadMessageObserver(this);
        }
    }

    public /* synthetic */ SquareServiceProvider(ISquareServiceProvider iSquareServiceProvider, Function1 function1, Function1 function12, Function1 function13, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iSquareServiceProvider, (i3 & 2) != 0 ? null : function1, (i3 & 4) != 0 ? null : function12, (i3 & 8) != 0 ? null : function13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SquareServiceProvider(ISquareServiceProvider iSquareServiceProvider, Function1<? super SquareMessageRecord, Unit> function1, Function1<? super SquareTempMessageRecord, Unit> function12, Function1<? super SquareTroopMessageRecord, Unit> function13) {
        this.proxy = iSquareServiceProvider;
        this.onUnreadMessageNotify = function1;
        this.onTempUnreadMessageNotify = function12;
        this.onTroopMessageNotify = function13;
    }
}
