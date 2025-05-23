package com.tencent.robot.relation.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.AddRobotToGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemoveRobotFromGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendResponse;
import com.tencent.qqnt.kernel.nativeinterface.RobotAuthRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotRemoveFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotUserPermissionType;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001cH\u0016J \u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001eH\u0016J*\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020 H\u0016J \u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\"H\u0016R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R+\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00120'j\b\u0012\u0004\u0012\u00020\u0012`(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/robot/relation/api/impl/RobotRelationServiceImpl;", "Lcom/tencent/robot/relation/api/IRobotRelationService;", "", "robotUin", "", "notifyAuthVerifyRobotSuccess", "notifyAddRobotFriendSuccess", "notifyRemoveRobotFriend", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "notifyAddRobotToGroupSuccess", "notifyAddRobotToGroupFailed", "notifyRemoveRobotFromGroupSuccess", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "La54/a;", "observer", "addRelationObserver", "removeRelationObserver", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotUserPermissionType;", "permissionType", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotAuthCallback;", "callback", "authVerifyRobot", "robotUid", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;", "addRobotFriend", "Lcom/tencent/qqnt/kernel/nativeinterface/IRemoveFriendCallback;", "removeRobotFriend", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAddRobotToGroupCallback;", "addRobotToTroop", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetRemoveRobotFromGroupCallback;", "removeRobotFromGroup", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "mObserverLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mRelationObserverList$delegate", "Lkotlin/Lazy;", "getMRelationObserverList", "()Ljava/util/ArrayList;", "mRelationObserverList", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotRelationServiceImpl implements IRobotRelationService {

    @NotNull
    private final ReentrantReadWriteLock mObserverLock = new ReentrantReadWriteLock();

    /* renamed from: mRelationObserverList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRelationObserverList;

    public RobotRelationServiceImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<a54.a>>() { // from class: com.tencent.robot.relation.api.impl.RobotRelationServiceImpl$mRelationObserverList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<a54.a> invoke() {
                return new ArrayList<>();
            }
        });
        this.mRelationObserverList = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRobotFriend$lambda$8(final IAddFriendCallback callback, final RobotRelationServiceImpl this$0, final String robotUin, final int i3, final String str, final RobotAddFriendResponse robotAddFriendResponse) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.relation.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotRelationServiceImpl.addRobotFriend$lambda$8$lambda$7(IAddFriendCallback.this, i3, str, robotAddFriendResponse, this$0, robotUin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRobotFriend$lambda$8$lambda$7(IAddFriendCallback callback, int i3, String str, RobotAddFriendResponse robotAddFriendResponse, RobotRelationServiceImpl this$0, String robotUin) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        callback.onResult(i3, str, robotAddFriendResponse);
        if (i3 == 0) {
            this$0.notifyAddRobotFriendSuccess(robotUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRobotToTroop$lambda$16(final ISetAddRobotToGroupCallback callback, final RobotRelationServiceImpl this$0, final String robotUin, final String troopUin, final Object obj, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.relation.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                RobotRelationServiceImpl.addRobotToTroop$lambda$16$lambda$15(ISetAddRobotToGroupCallback.this, i3, str, this$0, robotUin, troopUin, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRobotToTroop$lambda$16$lambda$15(ISetAddRobotToGroupCallback callback, int i3, String str, RobotRelationServiceImpl this$0, String robotUin, String troopUin, Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        callback.onResult(i3, str);
        if (i3 == 0) {
            this$0.notifyAddRobotToGroupSuccess(robotUin, troopUin, obj);
        } else {
            this$0.notifyAddRobotToGroupFailed(robotUin, troopUin, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authVerifyRobot$lambda$4(final IRobotAuthCallback callback, final RobotRelationServiceImpl this$0, final String robotUin, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.relation.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                RobotRelationServiceImpl.authVerifyRobot$lambda$4$lambda$3(IRobotAuthCallback.this, i3, str, this$0, robotUin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authVerifyRobot$lambda$4$lambda$3(IRobotAuthCallback callback, int i3, String str, RobotRelationServiceImpl this$0, String robotUin) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        callback.onResult(i3, str);
        if (i3 == 0) {
            this$0.notifyAuthVerifyRobotSuccess(robotUin);
        }
    }

    private final ArrayList<a54.a> getMRelationObserverList() {
        return (ArrayList) this.mRelationObserverList.getValue();
    }

    private final void notifyAddRobotFriendSuccess(String robotUin) {
        ReentrantReadWriteLock.ReadLock readLock = this.mObserverLock.readLock();
        readLock.lock();
        try {
            Iterator<T> it = getMRelationObserverList().iterator();
            while (it.hasNext()) {
                ((a54.a) it.next()).c(robotUin);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    private final void notifyAddRobotToGroupFailed(String robotUin, String troopUin, Object extraData) {
        ReentrantReadWriteLock.ReadLock readLock = this.mObserverLock.readLock();
        readLock.lock();
        try {
            Iterator<T> it = getMRelationObserverList().iterator();
            while (it.hasNext()) {
                ((a54.a) it.next()).e(robotUin, troopUin, extraData);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    private final void notifyAddRobotToGroupSuccess(String robotUin, String troopUin, Object extraData) {
        ReentrantReadWriteLock.ReadLock readLock = this.mObserverLock.readLock();
        readLock.lock();
        try {
            Iterator<T> it = getMRelationObserverList().iterator();
            while (it.hasNext()) {
                ((a54.a) it.next()).d(robotUin, troopUin, extraData);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    private final void notifyAuthVerifyRobotSuccess(String robotUin) {
        ReentrantReadWriteLock.ReadLock readLock = this.mObserverLock.readLock();
        readLock.lock();
        try {
            Iterator<T> it = getMRelationObserverList().iterator();
            while (it.hasNext()) {
                ((a54.a) it.next()).b(robotUin);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    private final void notifyRemoveRobotFriend(String robotUin) {
        ReentrantReadWriteLock.ReadLock readLock = this.mObserverLock.readLock();
        readLock.lock();
        try {
            Iterator<T> it = getMRelationObserverList().iterator();
            while (it.hasNext()) {
                ((a54.a) it.next()).a(robotUin);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    private final void notifyRemoveRobotFromGroupSuccess(String robotUin, String troopUin) {
        ReentrantReadWriteLock.ReadLock readLock = this.mObserverLock.readLock();
        readLock.lock();
        try {
            Iterator<T> it = getMRelationObserverList().iterator();
            while (it.hasNext()) {
                ((a54.a) it.next()).f(robotUin, troopUin);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRobotFriend$lambda$12(final IRemoveFriendCallback callback, final RobotRelationServiceImpl this$0, final String robotUin, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.relation.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotRelationServiceImpl.removeRobotFriend$lambda$12$lambda$11(IRemoveFriendCallback.this, i3, str, this$0, robotUin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRobotFriend$lambda$12$lambda$11(IRemoveFriendCallback callback, int i3, String str, RobotRelationServiceImpl this$0, String robotUin) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        callback.onResult(i3, str);
        if (i3 == 0) {
            this$0.notifyRemoveRobotFriend(robotUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRobotFromGroup$lambda$22(final ISetRemoveRobotFromGroupCallback callback, final RobotRelationServiceImpl this$0, final String robotUin, final String troopUin, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.relation.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                RobotRelationServiceImpl.removeRobotFromGroup$lambda$22$lambda$21(ISetRemoveRobotFromGroupCallback.this, i3, str, this$0, robotUin, troopUin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRobotFromGroup$lambda$22$lambda$21(ISetRemoveRobotFromGroupCallback callback, int i3, String str, RobotRelationServiceImpl this$0, String robotUin, String troopUin) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        callback.onResult(i3, str);
        if (i3 == 0) {
            this$0.notifyRemoveRobotFromGroupSuccess(robotUin, troopUin);
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void addRelationObserver(@NotNull a54.a observer) {
        int i3;
        Intrinsics.checkNotNullParameter(observer, "observer");
        ReentrantReadWriteLock reentrantReadWriteLock = this.mObserverLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i16 = 0;
        if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
            i3 = reentrantReadWriteLock.getReadHoldCount();
        } else {
            i3 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (!getMRelationObserverList().contains(observer)) {
                getMRelationObserverList().add(observer);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i16 < i3) {
                readLock.lock();
                i16++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void addRobotFriend(@NotNull final String robotUin, @NotNull String robotUid, @NotNull final IAddFriendCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotAddFriendRequest robotAddFriendRequest = new RobotAddFriendRequest(Util.toLongOrDefault(robotUin, 0L), robotUid);
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.addFriend(robotAddFriendRequest, new IAddFriendCallback() { // from class: com.tencent.robot.relation.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback
                public final void onResult(int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
                    RobotRelationServiceImpl.addRobotFriend$lambda$8(IAddFriendCallback.this, this, robotUin, i3, str, robotAddFriendResponse);
                }
            });
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void addRobotToTroop(@NotNull final String robotUin, @NotNull final String troopUin, @Nullable final Object extraData, @NotNull final ISetAddRobotToGroupCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AddRobotToGroupReq addRobotToGroupReq = new AddRobotToGroupReq(Util.toLongOrDefault(troopUin, 0L), Util.toLongOrDefault(robotUin, 0L));
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.setAddRobotToGroup(addRobotToGroupReq, new ISetAddRobotToGroupCallback() { // from class: com.tencent.robot.relation.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                public final void onResult(int i3, String str) {
                    RobotRelationServiceImpl.addRobotToTroop$lambda$16(ISetAddRobotToGroupCallback.this, this, robotUin, troopUin, extraData, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void authVerifyRobot(@NotNull final String robotUin, @NotNull RobotUserPermissionType permissionType, @NotNull final IRobotAuthCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotAuthRequest robotAuthRequest = new RobotAuthRequest(Util.toLongOrDefault(robotUin, 0L), permissionType);
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.robotAuth(robotAuthRequest, new IRobotAuthCallback() { // from class: com.tencent.robot.relation.api.impl.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotAuthCallback
                public final void onResult(int i3, String str) {
                    RobotRelationServiceImpl.authVerifyRobot$lambda$4(IRobotAuthCallback.this, this, robotUin, i3, str);
                }
            });
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        int i3;
        ReentrantReadWriteLock reentrantReadWriteLock = this.mObserverLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i16 = 0;
        if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
            i3 = reentrantReadWriteLock.getReadHoldCount();
        } else {
            i3 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            getMRelationObserverList().clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i16 < i3) {
                readLock.lock();
                i16++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void removeRelationObserver(@NotNull a54.a observer) {
        int i3;
        Intrinsics.checkNotNullParameter(observer, "observer");
        ReentrantReadWriteLock reentrantReadWriteLock = this.mObserverLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i16 = 0;
        if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
            i3 = reentrantReadWriteLock.getReadHoldCount();
        } else {
            i3 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            getMRelationObserverList().remove(observer);
        } finally {
            while (i16 < i3) {
                readLock.lock();
                i16++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void removeRobotFriend(@NotNull final String robotUin, @NotNull String robotUid, @NotNull final IRemoveFriendCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotRemoveFriendRequest robotRemoveFriendRequest = new RobotRemoveFriendRequest(Util.toLongOrDefault(robotUin, 0L), robotUid);
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.removeFriend(robotRemoveFriendRequest, new IRemoveFriendCallback() { // from class: com.tencent.robot.relation.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback
                public final void onResult(int i3, String str) {
                    RobotRelationServiceImpl.removeRobotFriend$lambda$12(IRemoveFriendCallback.this, this, robotUin, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.robot.relation.api.IRobotRelationService
    public void removeRobotFromGroup(@NotNull final String robotUin, @NotNull final String troopUin, @NotNull final ISetRemoveRobotFromGroupCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RemoveRobotFromGroupReq removeRobotFromGroupReq = new RemoveRobotFromGroupReq(Util.toLongOrDefault(troopUin, 0L), Util.toLongOrDefault(robotUin, 0L));
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.setRemoveRobotFromGroup(removeRobotFromGroupReq, new ISetRemoveRobotFromGroupCallback() { // from class: com.tencent.robot.relation.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback
                public final void onResult(int i3, String str) {
                    RobotRelationServiceImpl.removeRobotFromGroup$lambda$22(ISetRemoveRobotFromGroupCallback.this, this, robotUin, troopUin, i3, str);
                }
            });
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
