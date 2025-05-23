package com.tencent.mobileqq.troop.troopfriend.api.impl;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.x;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopBatchAddFriendServiceImpl implements ITroopBatchAddFriendService, LifecycleOwner {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopBatchAddFriendServiceImpl";
    private final LifecycleRegistry lifecycleRegistry;
    x mTroopBatchAddFriendMgr;

    public TroopBatchAddFriendServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lifecycleRegistry = new LifecycleRegistry(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDestroy$1() {
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.lifecycleRegistry;
    }

    @Override // com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService
    public x getTroopBatchAddFriendMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (x) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTroopBatchAddFriendMgr;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopfriend.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopBatchAddFriendServiceImpl.this.lambda$onCreate$0();
                }
            });
            this.mTroopBatchAddFriendMgr = new x((QQAppInterface) appRuntime, this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        x xVar = this.mTroopBatchAddFriendMgr;
        if (xVar != null) {
            xVar.J();
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopfriend.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopBatchAddFriendServiceImpl.this.lambda$onDestroy$1();
            }
        });
    }
}
