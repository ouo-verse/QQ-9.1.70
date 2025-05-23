package com.tencent.mobileqq.troop.filemanager;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8688a implements ProxyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TroopFileTansferItemEntity f295745a;

        C8688a(TroopFileTansferItemEntity troopFileTansferItemEntity) {
            this.f295745a = troopFileTansferItemEntity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) troopFileTansferItemEntity);
            }
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onDeleteFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295745a.Id.toString() + "] addItem finish[del]. table:" + str);
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onInsertFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295745a.Id.toString() + "] addItem finish. table:" + str);
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onUpdateFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295745a.Id.toString() + "] addItem finish[up]. table:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements ProxyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TroopFileTansferItemEntity f295747a;

        b(TroopFileTansferItemEntity troopFileTansferItemEntity) {
            this.f295747a = troopFileTansferItemEntity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) troopFileTansferItemEntity);
            }
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onDeleteFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295747a.Id.toString() + "] updateItem finish[del]. table:" + str);
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onInsertFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295747a.Id.toString() + "] updateItem finish[add]. table:" + str);
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onUpdateFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295747a.Id.toString() + "] updateItem finish. table:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements ProxyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UUID f295749a;

        c(UUID uuid) {
            this.f295749a = uuid;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) uuid);
            }
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onDeleteFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295749a.toString() + "] deleteItem finish. table:" + str);
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onInsertFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295749a.toString() + "] deleteItem finish[add]. table:" + str);
        }

        @Override // com.tencent.mobileqq.app.proxy.ProxyListener
        public void onUpdateFinish(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            e.b.a("TroopFileDataBaseProxy", e.b.f295940d, "[" + this.f295749a.toString() + "] deleteItem finish[up]. table:" + str);
        }
    }

    public a(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ContentValues b(Entity entity) {
        Object obj;
        ContentValues contentValues = new ContentValues();
        List<Field> validField = TableBuilder.getValidField((Class<? extends Entity>) entity.getClass());
        int size = validField.size();
        for (int i3 = 0; i3 < size; i3++) {
            Field field = validField.get(i3);
            String name = field.getName();
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                obj = field.get(entity);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                obj = null;
                if (obj instanceof Integer) {
                }
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
                obj = null;
                if (obj instanceof Integer) {
                }
            }
            if (obj instanceof Integer) {
                contentValues.put(name, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(name, (Long) obj);
            } else if (obj instanceof String) {
                contentValues.put(name, (String) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(name, (byte[]) obj);
            } else if (obj instanceof Short) {
                contentValues.put(name, (Short) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put(name, (Boolean) obj);
            } else if (obj instanceof Double) {
                contentValues.put(name, (Double) obj);
            } else if (obj instanceof Float) {
                contentValues.put(name, (Float) obj);
            } else if (obj instanceof Byte) {
                contentValues.put(name, (Byte) obj);
            }
        }
        return contentValues;
    }

    private void f(TroopFileTansferItemEntity troopFileTansferItemEntity) {
        if (troopFileTansferItemEntity.Id != null && !TextUtils.isEmpty(troopFileTansferItemEntity.LocalFile)) {
            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onTroopFileDownloaded(troopFileTansferItemEntity.Id.toString(), troopFileTansferItemEntity.LocalFile);
        }
    }

    public void a(TroopFileTansferItemEntity troopFileTansferItemEntity, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopFileTansferItemEntity, (Object) proxyListener);
            return;
        }
        e.b.c("TroopFileDataBaseProxy", e.b.f295938b, "[" + troopFileTansferItemEntity.Id.toString() + "] addItem status[" + troopFileTansferItemEntity.getStatus() + "] LocalFile[" + troopFileTansferItemEntity.LocalFile + "]");
        C8688a c8688a = new C8688a(troopFileTansferItemEntity);
        if (troopFileTansferItemEntity.getStatus() == 1000) {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, troopFileTansferItemEntity.getTableName(), troopFileTansferItemEntity, 0, c8688a);
            return;
        }
        if (troopFileTansferItemEntity.getStatus() == 1001) {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, troopFileTansferItemEntity.getTableName(), troopFileTansferItemEntity, 1, c8688a);
            return;
        }
        e.b.b("TroopFileDataBaseProxy", e.b.f295938b, "Item status[" + String.valueOf(troopFileTansferItemEntity.getStatus()) + "] is wrong");
    }

    protected void c(String str, String str2, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, strArr, proxyListener);
        } else {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, str, str2, strArr, 2, proxyListener);
        }
    }

    public void d(long j3, UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), uuid);
            return;
        }
        if (uuid == null) {
            return;
        }
        e.b.c("TroopFileDataBaseProxy", e.b.f295938b, "[" + uuid.toString() + "] deleteItem");
        TroopFileTansferItemEntity troopFileTansferItemEntity = new TroopFileTansferItemEntity();
        troopFileTansferItemEntity.troopuin = j3;
        c(troopFileTansferItemEntity.getTableName(), "_sId=?", new String[]{uuid.toString()}, new c(uuid));
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public List<TroopFileTansferItemEntity> e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        TroopFileTansferItemEntity troopFileTansferItemEntity = new TroopFileTansferItemEntity();
        troopFileTansferItemEntity.troopuin = j3;
        return DBMethodProxy.rawQuery(createEntityManager, TroopFileTansferItemEntity.class, "select * from " + troopFileTansferItemEntity.getTableName() + " where troopuin = ?", new String[]{"" + j3});
    }

    protected void g(String str, ContentValues contentValues, String str2, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, contentValues, str2, strArr, proxyListener);
        } else {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, str, contentValues, str2, strArr, 1, proxyListener);
        }
    }

    public void h(TroopFileTansferItemEntity troopFileTansferItemEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopFileTansferItemEntity);
            return;
        }
        if (troopFileTansferItemEntity != null && troopFileTansferItemEntity.Id != null) {
            if (QLog.isColorLevel()) {
                e.b.c("TroopFileDataBaseProxy", e.b.f295938b, "[" + troopFileTansferItemEntity.Id.toString() + "] updateItem transStatus[" + troopFileTansferItemEntity.Status + "] FilePath[" + troopFileTansferItemEntity.FilePath + "] LocalFile[" + troopFileTansferItemEntity.LocalFile + "]");
            }
            int i3 = troopFileTansferItemEntity.Status;
            if (i3 != 0 && i3 != 1) {
                if (i3 == 8) {
                    i3 = 10;
                }
            } else {
                i3 = 3;
            }
            troopFileTansferItemEntity.preupdate();
            ContentValues b16 = b(troopFileTansferItemEntity);
            b16.put("Status", Integer.valueOf(i3));
            b16.put("_sStatus", com.tencent.mobileqq.troop.data.a.c(i3));
            g(troopFileTansferItemEntity.getTableName(), b16, "_sId=?", new String[]{troopFileTansferItemEntity.Id.toString()}, new b(troopFileTansferItemEntity));
            f(troopFileTansferItemEntity);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
