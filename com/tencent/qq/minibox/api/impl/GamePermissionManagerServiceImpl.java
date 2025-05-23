package com.tencent.qq.minibox.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IGamePermissionManagerService;
import com.tencent.qq.minibox.permission.GamePermissionItem;
import com.tencent.qq.minibox.permission.PermissionItem;
import com.tencent.qq.minibox.permissions.PermissionConfigProcessor;
import com.tencent.qq.minibox.ui.PermissionSettingFragment;
import com.tencent.qq.minibox.ui.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Service(process = {"all"})
/* loaded from: classes22.dex */
public class GamePermissionManagerServiceImpl implements IGamePermissionManagerService {
    public static final String TAG = "game.permission.GamePermissionManagerImpl";
    private EntityManager mEntityMgr;
    private final Map<String, PermissionItem> mPermissionItemsCache = Collections.synchronizedMap(new HashMap());
    private List<GamePermissionItem> mGamePermissionItemsCache = Collections.synchronizedList(new ArrayList());
    private Runnable mInitTask = new Runnable() { // from class: com.tencent.qq.minibox.api.impl.GamePermissionManagerServiceImpl.1
        @Override // java.lang.Runnable
        public void run() {
            QLog.i(GamePermissionManagerServiceImpl.TAG, 1, "initTask begins.");
            GamePermissionManagerServiceImpl.this.initPermissionItems();
            GamePermissionManagerServiceImpl.this.initGamePermissionItems();
            QLog.i(GamePermissionManagerServiceImpl.TAG, 1, "initTask ends.");
        }
    };

    private GamePermissionItem findPermissionItem(String str, String str2) {
        List<GamePermissionItem> list;
        if (!TextUtils.isEmpty(str2) && (list = this.mGamePermissionItemsCache) != null && list.size() != 0) {
            for (GamePermissionItem gamePermissionItem : this.mGamePermissionItemsCache) {
                if (TextUtils.equals(str, gamePermissionItem.mGameId) && str2.equals(gamePermissionItem.mPermission)) {
                    return gamePermissionItem;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGamePermissionItems() {
        try {
            ArrayList arrayList = (ArrayList) this.mEntityMgr.query(GamePermissionItem.class);
            if (arrayList != null && arrayList.size() != 0) {
                this.mGamePermissionItemsCache.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Entity entity = (Entity) it.next();
                    if (entity != null) {
                        this.mGamePermissionItemsCache.add((GamePermissionItem) entity);
                    }
                }
                QLog.i(TAG, 1, "gamePermissionItems.size:" + this.mGamePermissionItemsCache.size());
                return;
            }
            this.mEntityMgr.persistOrReplace(new GamePermissionItem());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPermissionItems() {
        ArrayList<PermissionItem> arrayList;
        ArrayList<PermissionItem> arrayList2;
        ps3.a c16 = PermissionConfigProcessor.c();
        if (c16 != null && (arrayList2 = c16.f427083d) != null && arrayList2.size() > 0) {
            QLog.i(TAG, 1, "use manager config: size=" + c16.f427083d.size());
            replaceMemPermissionItem(c16.f427083d);
            savePermissionItemsImpl(c16.f427083d);
            return;
        }
        try {
            ArrayList arrayList3 = (ArrayList) this.mEntityMgr.query(PermissionItem.class);
            if (arrayList3 != null && arrayList3.size() > 0) {
                QLog.i(TAG, 1, "use db config: size=" + arrayList3.size());
                replaceMemPermissionItem(arrayList3);
                return;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
        ps3.a d16 = ps3.a.d(MobileQQ.sMobileQQ);
        if (d16 != null && (arrayList = d16.f427083d) != null && arrayList.size() > 0) {
            QLog.i(TAG, 1, "use asset config: size=" + d16.f427083d.size());
            replaceMemPermissionItem(d16.f427083d);
            return;
        }
        QLog.e(TAG, 1, "initPermissionItems: failed, this should not happened");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGamePermissionItems() {
        QLog.i(TAG, 1, "[removeGamePermissionItems], ret:" + this.mEntityMgr.delete(GamePermissionItem.class.getSimpleName(), null, null));
        this.mGamePermissionItemsCache.clear();
    }

    private void removePermissionItems() {
        QLog.i(TAG, 1, "[removePermissionItems], ret:" + this.mEntityMgr.delete(PermissionItem.class.getSimpleName(), null, null));
    }

    private void replaceMemPermissionItem(List<PermissionItem> list) {
        this.mPermissionItemsCache.clear();
        for (PermissionItem permissionItem : list) {
            if (permissionItem != null) {
                this.mPermissionItemsCache.put(permissionItem.mPermission, permissionItem);
            }
        }
    }

    private void savePermissionItemsImpl(List<PermissionItem> list) {
        removePermissionItems();
        for (PermissionItem permissionItem : list) {
            if (permissionItem != null && !TextUtils.isEmpty(permissionItem.mPermission)) {
                permissionItem.setStatus(1000);
                updateEntity(permissionItem);
            }
        }
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public void clearPermissionStatusAsyn(String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.GamePermissionManagerServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                GamePermissionManagerServiceImpl.this.removeGamePermissionItems();
            }
        }, 32, null, true);
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public List<os3.a> getGamePermissionItems(String str) {
        List<GamePermissionItem> list;
        initGamePermissionItems();
        if (!TextUtils.isEmpty(str) && (list = this.mGamePermissionItemsCache) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (GamePermissionItem gamePermissionItem : this.mGamePermissionItemsCache) {
                if (str.equals(gamePermissionItem.mGameId)) {
                    PermissionItem permissionItem = getPermissionItem(gamePermissionItem.mPermission);
                    if (permissionItem == null) {
                        QLog.w(TAG, 1, "permission was removed.");
                    } else {
                        os3.a aVar = new os3.a();
                        aVar.f423974a = str;
                        aVar.f423976c = permissionItem.mPermission;
                        aVar.f423975b = permissionItem.mName;
                        aVar.f423979f = permissionItem.mReqDetail;
                        aVar.f423978e = permissionItem.mReqTitle;
                        aVar.f423977d = gamePermissionItem.mStatus;
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public PermissionItem getPermissionItem(String str) {
        if (!TextUtils.isEmpty(str) && this.mPermissionItemsCache.size() != 0) {
            return this.mPermissionItemsCache.get(str);
        }
        return null;
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public boolean isPermissionDefined(String str) {
        if (TextUtils.isEmpty(str) || getPermissionItem(str) == null) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 1, "[onCreate]");
        this.mEntityMgr = appRuntime.getEntityManagerFactory().createEntityManager();
        ThreadManagerV2.excute(this.mInitTask, 32, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "[onDestroy]");
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public int queryPermissionStatus(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (GamePermissionItem gamePermissionItem : this.mGamePermissionItemsCache) {
                if (str.equals(gamePermissionItem.mGameId) && str2.equals(gamePermissionItem.mPermission)) {
                    return gamePermissionItem.mStatus;
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public void showPermissionConfirmDialog(Activity activity, Drawable drawable, String str, String str2, String str3, bs3.a aVar) {
        new z(activity).N(str3, str, str2, drawable, aVar);
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public void startPermissionSettingFragment(Context context, Intent intent) {
        QLog.i(TAG, 1, "[startPermissionSettingFragment]");
        QPublicFragmentActivity.start(context, intent, PermissionSettingFragment.class);
    }

    protected boolean updateEntity(Entity entity) {
        if (this.mEntityMgr.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.mEntityMgr.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.mEntityMgr.update(entity);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public void updateGamePermission(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str2)) {
            QLog.w(TAG, 1, "update Fails!! Permission is NULL.");
            return;
        }
        final GamePermissionItem findPermissionItem = findPermissionItem(str, str2);
        if (findPermissionItem == null) {
            QLog.i(TAG, 1, "insert a new item.");
            findPermissionItem = new GamePermissionItem();
            findPermissionItem.mGameId = str;
            findPermissionItem.mPermission = str2;
            findPermissionItem.mStatus = i3;
            findPermissionItem.setStatus(1000);
            this.mGamePermissionItemsCache.add(findPermissionItem);
        } else {
            QLog.i(TAG, 1, "update the existed item.");
            findPermissionItem.mStatus = i3;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.GamePermissionManagerServiceImpl.4
            @Override // java.lang.Runnable
            public void run() {
                GamePermissionManagerServiceImpl.this.updateEntity(findPermissionItem);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.qq.minibox.api.IGamePermissionManagerService
    public void showPermissionConfirmDialog(final Activity activity, final String str, final String str2, final String str3, final String str4, final bs3.a aVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.GamePermissionManagerServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                new z(activity).O(str, str2, str3, str4, aVar);
            }
        });
    }
}
