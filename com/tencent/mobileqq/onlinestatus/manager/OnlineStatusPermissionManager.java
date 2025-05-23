package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.bb;
import com.tencent.mobileqq.onlinestatus.bc;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* loaded from: classes16.dex */
public class OnlineStatusPermissionManager implements i {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f255953d;

    /* renamed from: f, reason: collision with root package name */
    private OnlineStatusFriendsPermissionItem f255955f;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<WeakReference<b>> f255957i;

    /* renamed from: m, reason: collision with root package name */
    private bb f255958m;

    /* renamed from: e, reason: collision with root package name */
    private int f255954e = -1;

    /* renamed from: h, reason: collision with root package name */
    private List<Integer> f255956h = new ArrayList();

    /* loaded from: classes16.dex */
    class a extends bb {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.bb
        public void b(boolean z16, Bundle bundle) {
            super.b(z16, bundle);
            if (z16) {
                OnlineStatusPermissionManager.this.G();
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface b {
        void G6(OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem, List<Integer> list);
    }

    public OnlineStatusPermissionManager(AppInterface appInterface) {
        a aVar = new a();
        this.f255958m = aVar;
        this.f255953d = appInterface;
        appInterface.registObserver(aVar);
        this.f255957i = new ArrayList<>();
        F(appInterface);
    }

    private Pair<Boolean, List<Integer>> C(List<Integer> list) {
        return new Pair<>(Boolean.FALSE, new ArrayList(list));
    }

    private synchronized void F(final AppInterface appInterface) {
        if (this.f255954e == -1) {
            this.f255954e = 0;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    String str = "online_status_file_" + appInterface.getCurrentAccountUin();
                    boolean z17 = false;
                    if (OnlineStatusPermissionManager.this.f255955f == null) {
                        OnlineStatusPermissionManager.this.f255955f = (OnlineStatusFriendsPermissionItem) FileUtils.readObject(str);
                        if (QLog.isColorLevel()) {
                            Object[] objArr = new Object[2];
                            objArr[0] = "initFriendPermissionFromFile mLocalPermission is empty:";
                            if (OnlineStatusPermissionManager.this.f255955f == null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            objArr[1] = Boolean.valueOf(z16);
                            QLog.d("OnlineStatusPermissionManager", 2, objArr);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = "initFriendPermissionFromFile init mLocalPermission";
                        if (OnlineStatusPermissionManager.this.f255955f == null) {
                            z17 = true;
                        }
                        objArr2[1] = Boolean.valueOf(z17);
                        QLog.d("OnlineStatusPermissionManager", 2, objArr2);
                    }
                    if (OnlineStatusPermissionManager.this.f255955f == null) {
                        OnlineStatusPermissionManager.this.f255955f = new OnlineStatusFriendsPermissionItem(true, null);
                    }
                    OnlineStatusPermissionManager.this.f255954e = 1;
                    OnlineStatusPermissionManager.this.f255953d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OnlineStatusPermissionManager.this.G();
                        }
                    });
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void G() {
        Iterator<WeakReference<b>> it = this.f255957i.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() != null) {
                b bVar = next.get();
                bVar.G6(this.f255955f, new ArrayList());
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusPermissionManager", 2, "notifyReceiveDataListener exist", bVar);
                }
            }
        }
        this.f255957i.clear();
    }

    private synchronized void H(b bVar) {
        Iterator<WeakReference<b>> it = this.f255957i.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() != null && bVar == next.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusPermissionManager", 2, "registerReceiveDataListener exist", bVar);
                }
                return;
            }
        }
        this.f255957i.add(new WeakReference<>(bVar));
    }

    private synchronized void J(@NonNull final OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.writeObject("online_status_file_" + OnlineStatusPermissionManager.this.f255953d.getCurrentAccountUin(), onlineStatusFriendsPermissionItem);
            }
        }, 16, null, true);
    }

    private boolean L(List<Integer> list) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        String str = "online_status_permission_" + ("smart_selected_list" + this.f255953d.getCurrentUin());
        if (list.size() == 0) {
            from.removeKey(str);
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb5.append(list.get(i3));
            if (i3 != list.size() - 1) {
                sb5.append("#");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, "saveSmartSelectedListToSP ", sb5.toString());
        }
        from.encodeString(str, sb5.toString());
        from.commitAsync();
        return true;
    }

    private synchronized boolean M(List<Integer> list) {
        if (list == null) {
            return false;
        }
        this.f255956h = list;
        return L(list);
    }

    @Nullable
    public synchronized OnlineStatusFriendsPermissionItem D(long j3, boolean z16, b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, " getOnlineStatusPermission onlineStatusType=", Long.valueOf(j3), " state= ", Integer.valueOf(this.f255954e), " fetchIfAbsent=", Boolean.valueOf(z16));
        }
        OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem = this.f255955f;
        if (onlineStatusFriendsPermissionItem != null) {
            return onlineStatusFriendsPermissionItem;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, " getOnlineStatusPermission registerListener", bVar);
        }
        H(bVar);
        if (z16) {
            I(j3, false);
        }
        return null;
    }

    public boolean E(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem, b bVar) {
        if (onlineStatusPermissionItem == null) {
            return false;
        }
        OnlineStatusFriendsPermissionItem D = D(40001L, false, bVar);
        if (D == null) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity is null");
            }
            return false;
        }
        if (D.allHasPermission != onlineStatusPermissionItem.isAllHasPermission()) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity.allHasPermission=", Boolean.valueOf(D.allHasPermission), " item.isAllHasPermission=", onlineStatusPermissionItem.getPermissionUins());
            }
            return true;
        }
        if (D.permissionUins.size() != onlineStatusPermissionItem.getPermissionUins().size()) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity.size=", Integer.valueOf(D.permissionUins.size()), " item.size=", Integer.valueOf(onlineStatusPermissionItem.getPermissionUins().size()));
            }
            return true;
        }
        if (D.permissionUins.containsAll(onlineStatusPermissionItem.getPermissionUins())) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity not contains item all");
        }
        return true;
    }

    public void I(long j3, boolean z16) {
        bc.e(this.f255953d, j3, z16, false);
    }

    public synchronized void K(@NonNull OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, " saveOnlineStatusPermission item=", onlineStatusFriendsPermissionItem);
        }
        this.f255955f = onlineStatusFriendsPermissionItem;
        J(onlineStatusFriendsPermissionItem);
    }

    public synchronized boolean N(List<Integer> list) {
        if (list == null) {
            return false;
        }
        return M(C(list).second);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        this.f255957i.clear();
        List<Integer> list = this.f255956h;
        if (list != null) {
            list.clear();
        }
        if (this.f255955f != null) {
            this.f255955f = null;
        }
        this.f255954e = -1;
        this.f255953d.unRegistObserver(this.f255958m);
    }
}
