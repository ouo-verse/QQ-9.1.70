package com.tencent.mobileqq.vas.social.config;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.state.square.api.ISquareFriendObserver;
import com.tencent.state.square.api.ISquareFriendService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/h;", "Lcom/tencent/state/square/api/ISquareFriendService;", "Lcom/tencent/state/square/api/ISquareFriendObserver;", "observer", "", "addObserver", "destroy", "init", "removeObserver", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "Lcom/tencent/common/app/AppInterface;", "b", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/friend/observer/a;", "c", "Lcom/tencent/mobileqq/friend/observer/a;", "getFriendObserver", "()Lcom/tencent/mobileqq/friend/observer/a;", "setFriendObserver", "(Lcom/tencent/mobileqq/friend/observer/a;)V", "friendObserver", "<init>", "()V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h implements ISquareFriendService {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AppInterface appInterface;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<ISquareFriendObserver> observers = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.friend.observer.a friendObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/social/config/h$b", "Lcom/tencent/mobileqq/friend/observer/a;", "", "isSuccess", "addSuccess", com.tencent.mobileqq.friend.observer.a.ADD_DIRECT, "", "reqestUin", "Landroid/os/Bundle;", "bundle", "", "onUpdateAddFriend", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.friend.observer.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean isSuccess, boolean addSuccess, boolean addDirect, String reqestUin, Bundle bundle) {
            Iterator it = h.this.observers.iterator();
            while (it.hasNext()) {
                ((ISquareFriendObserver) it.next()).onUpdateAddFriend(isSuccess, addSuccess, addDirect, reqestUin, bundle);
            }
        }
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void addObserver(ISquareFriendObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void destroy() {
        AppInterface appInterface = this.appInterface;
        if (appInterface != null) {
            appInterface.removeObserver(this.friendObserver);
        }
        this.observers.clear();
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void init() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        this.appInterface = appInterface;
        appInterface.addObserver(this.friendObserver);
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void removeObserver(ISquareFriendObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }
}
