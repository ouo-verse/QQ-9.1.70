package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepClassConstructor
/* loaded from: classes12.dex */
public class FileManagerProxy extends BaseProxy {

    /* renamed from: l, reason: collision with root package name */
    private static bc f207692l;

    /* renamed from: a, reason: collision with root package name */
    private List<FileManagerEntity> f207693a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Long, FileManagerEntity> f207694b;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f207695c;

    /* renamed from: d, reason: collision with root package name */
    List<FileManagerEntity> f207696d;

    /* renamed from: e, reason: collision with root package name */
    List<FileManagerEntity> f207697e;

    /* renamed from: f, reason: collision with root package name */
    List<a> f207698f;

    /* renamed from: g, reason: collision with root package name */
    private long f207699g;

    /* renamed from: h, reason: collision with root package name */
    private List<Integer> f207700h;

    /* renamed from: i, reason: collision with root package name */
    private final int f207701i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, FileManagerEntity> f207702j;

    /* renamed from: k, reason: collision with root package name */
    private final Object f207703k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        long f207710a;

        /* renamed from: b, reason: collision with root package name */
        String f207711b;

        /* renamed from: c, reason: collision with root package name */
        long f207712c;

        a() {
        }
    }

    public FileManagerProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        this.f207693a = null;
        this.f207694b = null;
        this.f207695c = null;
        this.f207696d = null;
        this.f207697e = null;
        this.f207698f = new ArrayList();
        this.f207699g = 0L;
        this.f207700h = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        this.f207701i = 2000;
        this.f207702j = new Hashtable();
        this.f207703k = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(FileManagerEntity fileManagerEntity) {
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileManagerEntityUpdate(this.app, fileManagerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        this.f207699g = System.currentTimeMillis();
        Map<Long, FileManagerEntity> map = this.f207694b;
        if (map == null) {
            return;
        }
        if (map.size() == 0) {
            return;
        }
        try {
            Iterator<Map.Entry<Long, FileManagerEntity>> it = this.f207694b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Long, FileManagerEntity> next = it.next();
                int i3 = next.getValue().status;
                if (i3 != 2 && i3 != 14 && i3 != 15 && i3 != 4) {
                    long longValue = next.getKey().longValue();
                    it.remove();
                    if (QLog.isColorLevel()) {
                        QLog.d("FileManagerProxy<FileAssistant>", 2, "remove mem entiy [" + longValue + "]. remove the entity for free memory");
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ContentValues m(Entity entity) {
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

    private synchronized boolean u(int i3) {
        String str;
        PackageInfo packageInfo;
        if (this.f207693a == null) {
            init();
        }
        if (this.f207693a.size() == 0) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("select * from ( select * from ");
        sb5.append(FileManagerEntity.tableName());
        sb5.append(" where srvTime <= ");
        List<FileManagerEntity> list = this.f207693a;
        sb5.append(String.valueOf(list.get(list.size() - 1).srvTime));
        sb5.append(" and  nSessionId != ");
        List<FileManagerEntity> list2 = this.f207693a;
        sb5.append(String.valueOf(list2.get(list2.size() - 1).nSessionId));
        sb5.append("  order by srvTime desc limit ");
        sb5.append(i3);
        sb5.append(") order by srvTime desc");
        List<FileManagerEntity> b16 = i.b(DBMethodProxy.rawQuery(this.app.getEntityManagerFactory().createEntityManager(), FileManagerEntity.class, sb5.toString(), null));
        if (b16 == null) {
            return false;
        }
        if (b16.size() == 0) {
            return false;
        }
        for (FileManagerEntity fileManagerEntity : b16) {
            if (fileManagerEntity.nFileType == 5 && fileManagerEntity.getCloudType() == 3 && !q.p(fileManagerEntity.getFilePath()) && (str = fileManagerEntity.strApkPackageName) != null && str.length() > 0 && (packageInfo = ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getPackageInfo(BaseApplication.getContext(), fileManagerEntity.strApkPackageName)) != null) {
                fileManagerEntity.setFilePath(packageInfo.applicationInfo.publicSourceDir);
            }
            if (this.f207694b.get(Long.valueOf(fileManagerEntity.nSessionId)) == null) {
                this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
            }
            this.f207693a.add(this.f207694b.get(Long.valueOf(fileManagerEntity.nSessionId)));
        }
        if (b16.size() < 30) {
            return false;
        }
        return true;
    }

    public boolean A(String str, long j3) {
        String str2;
        for (a aVar : this.f207698f) {
            if (aVar.f207712c == j3 && (str2 = aVar.f207711b) != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public synchronized FileManagerEntity C(long j3) {
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            if (fileManagerEntity.nSessionId == j3) {
                return fileManagerEntity;
            }
        }
        List<FileManagerEntity> list = this.f207696d;
        if (list != null) {
            for (FileManagerEntity fileManagerEntity2 : list) {
                if (fileManagerEntity2.nSessionId == j3) {
                    return fileManagerEntity2;
                }
            }
        }
        return this.f207694b.get(Long.valueOf(j3));
    }

    public synchronized FileManagerEntity D(long j3, String str, int i3) {
        String str2;
        if (j3 != -1 && str != null) {
            if (str.length() != 0) {
                if (this.f207693a == null) {
                    init();
                }
                for (FileManagerEntity fileManagerEntity : this.f207693a) {
                    String str3 = fileManagerEntity.peerUin;
                    if ((str3 != null && str3.equals(str)) || (!TextUtils.isEmpty(fileManagerEntity.guildId) && !TextUtils.isEmpty(fileManagerEntity.channelId))) {
                        if (fileManagerEntity.uniseq == j3) {
                            if (fileManagerEntity.cloudType == 1 && FileManagerUtil.fileWhetherExpire(fileManagerEntity)) {
                                fileManagerEntity.status = 16;
                            }
                            return fileManagerEntity;
                        }
                    }
                }
                Map<Long, FileManagerEntity> map = this.f207694b;
                if (map != null) {
                    Iterator<Map.Entry<Long, FileManagerEntity>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        FileManagerEntity value = it.next().getValue();
                        if (value.uniseq == j3 && (str2 = value.peerUin) != null && str2.equals(str) && i3 == value.peerType) {
                            if (value.cloudType == 1 && FileManagerUtil.fileWhetherExpire(value)) {
                                value.status = 16;
                            }
                            return value;
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    public synchronized FileManagerEntity E(String str) {
        if (this.f207693a == null) {
            init();
        }
        String str2 = "select * from " + FileManagerEntity.tableName() + " where Uuid = ?";
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
            }
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<FileManagerEntity> b16 = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str2, new String[]{SecurityUtile.encode(str)}));
        long currentTimeMillis2 = System.currentTimeMillis();
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(currentTimeMillis) + "], overTime[" + String.valueOf(currentTimeMillis2) + "]");
        }
        if (b16.size() > 1 && QLog.isColorLevel()) {
            QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(b16.size()) + "] over 1?");
        }
        FileManagerEntity fileManagerEntity = b16.get(0);
        if (fileManagerEntity == null) {
            return null;
        }
        this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
        ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
        if (fileManagerEntity.cloudType == 1 && FileManagerUtil.fileWhetherExpire(fileManagerEntity)) {
            fileManagerEntity.status = 16;
        }
        return fileManagerEntity;
    }

    public synchronized FileManagerEntity F(long j3, String str, int i3) {
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "queryEntityForDbByUniseq uniseq is " + j3);
        if (this.f207693a == null) {
            init();
        }
        String str2 = "select * from " + FileManagerEntity.tableName() + " where uniseq = ?";
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
            }
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<FileManagerEntity> b16 = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str2, new String[]{String.valueOf(j3)}));
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(currentTimeMillis) + "], overTime[" + String.valueOf(currentTimeMillis2) + "]");
        }
        if (b16 != null && b16.size() != 0) {
            if (b16.size() > 1 && QLog.isColorLevel()) {
                QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(b16.size()) + "] over 1?");
            }
            FileManagerEntity fileManagerEntity = b16.get(0);
            try {
                this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
                ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
                if (fileManagerEntity.cloudType == 1 && FileManagerUtil.fileWhetherExpire(fileManagerEntity)) {
                    fileManagerEntity.status = 16;
                }
                return fileManagerEntity;
            } catch (Exception e16) {
                QLog.e("FileManagerProxy<FileAssistant>", 1, e16.toString());
                QLog.e("FileManagerProxy<FileAssistant>", 1, new Throwable().getStackTrace());
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
        }
        return null;
    }

    public synchronized FileManagerEntity G(String str) {
        if (this.f207693a == null) {
            init();
        }
        ArrayList arrayList = new ArrayList();
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            String str2 = fileManagerEntity.WeiYunFileId;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                if (fileManagerEntity.status == 1 && q.f(fileManagerEntity.getFilePath())) {
                    return fileManagerEntity;
                }
                arrayList.add(fileManagerEntity);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = (FileManagerEntity) it.next();
            int i3 = fileManagerEntity2.nOpType;
            if (i3 == 5 || i3 == 50 || fileManagerEntity2.cloudType == 2) {
                return fileManagerEntity2;
            }
        }
        arrayList.clear();
        Iterator<Long> it5 = this.f207694b.keySet().iterator();
        while (it5.hasNext()) {
            FileManagerEntity fileManagerEntity3 = this.f207694b.get(it5.next());
            String str3 = fileManagerEntity3.WeiYunFileId;
            if (str3 != null && str3.equalsIgnoreCase(str)) {
                if (fileManagerEntity3.status == 1 && q.f(fileManagerEntity3.getFilePath())) {
                    return fileManagerEntity3;
                }
                arrayList.add(fileManagerEntity3);
            }
        }
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            FileManagerEntity fileManagerEntity4 = (FileManagerEntity) it6.next();
            int i16 = fileManagerEntity4.nOpType;
            if (i16 == 5 || i16 == 50 || fileManagerEntity4.cloudType == 2) {
                return fileManagerEntity4;
            }
        }
        return null;
    }

    public List<FileManagerEntity> H(String str, String str2, boolean z16) {
        if (this.f207696d == null) {
            S();
        }
        ArrayList arrayList = new ArrayList();
        for (FileManagerEntity fileManagerEntity : this.f207696d) {
            if (!TextUtils.isEmpty(fileManagerEntity.fileName) && !TextUtils.isEmpty(fileManagerEntity.peerUin)) {
                String str3 = fileManagerEntity.fileName;
                if (fileManagerEntity.peerUin.equals(str2) || TextUtils.isEmpty(str2)) {
                    if (str3.indexOf(str) >= 0) {
                        arrayList.add(fileManagerEntity);
                    } else if (SearchUtils.j0(str, str3, com.tencent.mobileqq.search.j.f283423k) > Long.MIN_VALUE) {
                        arrayList.add(fileManagerEntity);
                    }
                }
            }
        }
        return arrayList;
    }

    public Map<String, List<FileManagerEntity>> I(String str) {
        if (this.f207696d == null) {
            S();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (FileManagerEntity fileManagerEntity : this.f207696d) {
            if (!TextUtils.isEmpty(fileManagerEntity.fileName) && fileManagerEntity.fileName.indexOf(str) >= 0) {
                if (!linkedHashMap.containsKey(fileManagerEntity.fileName)) {
                    linkedHashMap.put(fileManagerEntity.fileName, new ArrayList());
                }
                ((List) linkedHashMap.get(fileManagerEntity.fileName)).add(fileManagerEntity);
            }
        }
        for (FileManagerEntity fileManagerEntity2 : this.f207696d) {
            if (!TextUtils.isEmpty(fileManagerEntity2.fileName)) {
                String str2 = fileManagerEntity2.fileName;
                if (linkedHashMap.containsKey(str2)) {
                    continue;
                } else if (SearchUtils.j0(str, str2, com.tencent.mobileqq.search.j.f283423k) > Long.MIN_VALUE) {
                    if (!linkedHashMap.containsKey(fileManagerEntity2.fileName)) {
                        linkedHashMap.put(fileManagerEntity2.fileName, new ArrayList());
                    }
                    ((List) linkedHashMap.get(fileManagerEntity2.fileName)).add(fileManagerEntity2);
                } else {
                    String fileOperationTypeToPeer = FileManagerUtil.getFileOperationTypeToPeer(fileManagerEntity2);
                    if (TextUtils.isEmpty(fileOperationTypeToPeer)) {
                        if (QLog.isDevelopLevel()) {
                            throw new NullPointerException("get Full String error!!!");
                        }
                    } else if (SearchUtils.j0(str, fileOperationTypeToPeer.replace(HardCodeUtil.qqStr(R.string.miq), "").replace(HardCodeUtil.qqStr(R.string.mjd), "").replace(HardCodeUtil.qqStr(R.string.mj8), "").replace(HardCodeUtil.qqStr(R.string.f171979mj1), "").replace(HardCodeUtil.qqStr(R.string.mir), "").replace(HardCodeUtil.qqStr(R.string.mjk), "").replace(HardCodeUtil.qqStr(R.string.mj6), "").replace(HardCodeUtil.qqStr(R.string.f171980mj2), "").replace(HardCodeUtil.qqStr(R.string.miz), "").trim(), com.tencent.mobileqq.search.j.f283423k) > Long.MIN_VALUE) {
                        if (!linkedHashMap.containsKey(fileManagerEntity2.fileName)) {
                            linkedHashMap.put(fileManagerEntity2.fileName, new ArrayList());
                        }
                        ((List) linkedHashMap.get(fileManagerEntity2.fileName)).add(fileManagerEntity2);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public List<FileManagerEntity> J(List<Integer> list, String str) {
        if (list != null && !list.isEmpty()) {
            if (this.f207696d == null) {
                S();
            }
            ArrayList arrayList = new ArrayList();
            for (FileManagerEntity fileManagerEntity : this.f207696d) {
                if (!TextUtils.isEmpty(fileManagerEntity.fileName) && !TextUtils.isEmpty(fileManagerEntity.peerUin)) {
                    int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
                    if (fileManagerEntity.peerUin.equals(str) && list.contains(Integer.valueOf(fileType))) {
                        arrayList.add(fileManagerEntity);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public synchronized FileManagerEntity K(String str) {
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            String str2 = fileManagerEntity.Uuid;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return fileManagerEntity;
            }
        }
        Iterator<Long> it = this.f207694b.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = this.f207694b.get(it.next());
            if (fileManagerEntity2 != null && !TextUtils.isEmpty(fileManagerEntity2.Uuid) && fileManagerEntity2.Uuid.equalsIgnoreCase(str)) {
                return fileManagerEntity2;
            }
        }
        return null;
    }

    public synchronized List<FileManagerEntity> L(String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 1, "call thread:" + Thread.currentThread().getName());
        }
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        if (this.f207693a == null) {
            init();
        }
        ArrayList arrayList = new ArrayList();
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            if (fileManagerEntity.fileSize == j3 && str.equals(fileManagerEntity.fileName) && fileManagerEntity.status == 1 && q.f(fileManagerEntity.getFilePath())) {
                arrayList.add(fileManagerEntity);
            }
        }
        Iterator<Long> it = this.f207694b.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = this.f207694b.get(it.next());
            if (!arrayList.contains(fileManagerEntity2) && fileManagerEntity2.fileSize == j3 && str.equals(fileManagerEntity2.fileName) && fileManagerEntity2.status == 1 && q.f(fileManagerEntity2.getFilePath())) {
                arrayList.add(fileManagerEntity2);
            }
        }
        return arrayList;
    }

    public synchronized List<FileManagerEntity> M(int i3) {
        String str = "select * from " + FileManagerEntity.tableName() + " where nOpType = ? order by lastTime desc limit 200";
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
            }
            return null;
        }
        List<FileManagerEntity> b16 = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str, new String[]{String.valueOf(i3)}));
        if (b16 != null && b16.size() != 0) {
            return b16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
        }
        return null;
    }

    public List<FileManagerEntity> N(List<Integer> list, String str) {
        if (this.f207696d == null) {
            S();
        }
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList(this.f207700h);
        arrayList2.removeAll(arrayList);
        ArrayList arrayList3 = new ArrayList();
        for (FileManagerEntity fileManagerEntity : this.f207696d) {
            if (!TextUtils.isEmpty(fileManagerEntity.fileName) && !TextUtils.isEmpty(fileManagerEntity.peerUin)) {
                int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
                if (fileManagerEntity.peerUin.equals(str) && arrayList2.contains(Integer.valueOf(fileType))) {
                    arrayList3.add(fileManagerEntity);
                }
            }
        }
        return arrayList3;
    }

    public synchronized FileManagerEntity O(String str) {
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            if (fileManagerEntity.getFilePath() != null && fileManagerEntity.getFilePath().equalsIgnoreCase(str)) {
                return fileManagerEntity;
            }
        }
        Iterator<Long> it = this.f207694b.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = this.f207694b.get(it.next());
            if (fileManagerEntity2.getFilePath() != null && fileManagerEntity2.getFilePath().equalsIgnoreCase(str)) {
                return fileManagerEntity2;
            }
        }
        return null;
    }

    public synchronized FileManagerEntity P(String str) {
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            String str2 = fileManagerEntity.strServerPath;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return fileManagerEntity;
            }
        }
        Iterator<Long> it = this.f207694b.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = this.f207694b.get(it.next());
            String str3 = fileManagerEntity2.strServerPath;
            if (str3 != null && !fileManagerEntity2.bDelInFM && str3.equalsIgnoreCase(str)) {
                return fileManagerEntity2;
            }
        }
        return null;
    }

    public synchronized FileManagerEntity Q(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            if (fileManagerEntity.peerType == 1 && fileManagerEntity.TroopUin == j3 && !TextUtils.isEmpty(fileManagerEntity.strTroopFileID) && str.equals(fileManagerEntity.strTroopFileID)) {
                return fileManagerEntity;
            }
        }
        for (FileManagerEntity fileManagerEntity2 : this.f207694b.values()) {
            if (fileManagerEntity2.peerType == 1 && fileManagerEntity2.TroopUin == j3 && !TextUtils.isEmpty(fileManagerEntity2.strTroopFileID) && str.equals(fileManagerEntity2.strTroopFileID)) {
                return fileManagerEntity2;
            }
        }
        return null;
    }

    public synchronized FileManagerEntity R(String str) {
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            String str2 = fileManagerEntity.WeiYunFileId;
            if (str2 != null && str2.equalsIgnoreCase(str) && fileManagerEntity.status == 1 && fileManagerEntity.imgHeight > 0 && fileManagerEntity.imgWidth > 0) {
                return fileManagerEntity;
            }
        }
        Iterator<Long> it = this.f207694b.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = this.f207694b.get(it.next());
            String str3 = fileManagerEntity2.WeiYunFileId;
            if (str3 != null && str3.equalsIgnoreCase(str) && fileManagerEntity2.status == 1 && fileManagerEntity2.imgHeight > 0 && fileManagerEntity2.imgWidth > 0) {
                return fileManagerEntity2;
            }
        }
        return null;
    }

    public synchronized List<FileManagerEntity> S() {
        List<FileManagerEntity> U = U(500);
        this.f207696d = U;
        if (U == null) {
            this.f207696d = new ArrayList();
        }
        return new ArrayList(this.f207696d);
    }

    public synchronized List<FileManagerEntity> T(String str) {
        List<FileManagerEntity> W;
        List<FileManagerEntity> list = this.f207697e;
        if (list != null) {
            list.clear();
        } else {
            this.f207697e = new ArrayList();
        }
        W = W(500, str);
        this.f207697e = W;
        if (W != null) {
            W = new ArrayList<>(this.f207697e);
        }
        return W;
    }

    public synchronized List<FileManagerEntity> U(int i3) {
        List<FileManagerEntity> list;
        List<FileManagerEntity> list2 = this.f207693a;
        if (list2 == null || list2.isEmpty()) {
            init();
        }
        String str = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + i3 + ") order by srvTime desc";
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            list = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str, null));
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + i3 + " data,is oom!");
            }
            list = null;
        }
        if (QLog.isDevelopLevel()) {
            if (list == null) {
                QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
            } else {
                QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + list.size() + "]");
            }
        }
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (FileManagerEntity fileManagerEntity : list) {
                boolean z16 = true;
                if (this.f207694b.containsKey(Long.valueOf(fileManagerEntity.nSessionId))) {
                    FileManagerEntity fileManagerEntity2 = this.f207694b.get(Long.valueOf(fileManagerEntity.nSessionId));
                    FileManagerUtil.correctFileInfo(fileManagerEntity2);
                    if (fileManagerEntity2 != null) {
                        fileManagerEntity2.status = fileManagerEntity.status;
                    }
                    arrayList.add(fileManagerEntity2);
                } else {
                    Iterator<FileManagerEntity> it = this.f207693a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            FileManagerEntity next = it.next();
                            if (next.nSessionId == fileManagerEntity.nSessionId) {
                                FileManagerUtil.correctFileInfo(next);
                                arrayList.add(next);
                                next.status = fileManagerEntity.status;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        FileManagerUtil.correctFileInfo(fileManagerEntity);
                        arrayList.add(fileManagerEntity);
                        this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.d("FileManagerProxy<FileAssistant>", 2, "QueryMoreEntity cost[" + currentTimeMillis2 + "], size[" + arrayList.size() + "]");
            }
            return arrayList;
        }
        return null;
    }

    public synchronized List<FileManagerEntity> V(int i3, int i16) {
        List<FileManagerEntity> list;
        boolean z16;
        List<FileManagerEntity> list2 = this.f207693a;
        if (list2 == null || list2.isEmpty()) {
            init();
        }
        String str = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + (i3 * i16) + "," + ((i16 + 1) * i3) + ") order by srvTime desc";
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            list = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str, null));
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + i3 + " data,is oom!");
            }
            list = null;
        }
        if (QLog.isDevelopLevel()) {
            if (list == null) {
                QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
            } else {
                QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + list.size() + "]");
            }
        }
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (FileManagerEntity fileManagerEntity : list) {
                if (this.f207694b.containsKey(Long.valueOf(fileManagerEntity.nSessionId))) {
                    FileManagerEntity fileManagerEntity2 = this.f207694b.get(Long.valueOf(fileManagerEntity.nSessionId));
                    FileManagerUtil.correctFileInfo(fileManagerEntity2);
                    arrayList.add(fileManagerEntity2);
                } else {
                    Iterator<FileManagerEntity> it = this.f207693a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            FileManagerEntity next = it.next();
                            if (next.nSessionId == fileManagerEntity.nSessionId) {
                                FileManagerUtil.correctFileInfo(next);
                                arrayList.add(next);
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        FileManagerUtil.correctFileInfo(fileManagerEntity);
                        arrayList.add(fileManagerEntity);
                        this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isDevelopLevel()) {
                QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity cost[" + currentTimeMillis2 + "]");
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity retList size" + arrayList.size());
            return arrayList;
        }
        return null;
    }

    public synchronized List<FileManagerEntity> W(int i3, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (this.f207696d == null) {
            this.f207696d = new ArrayList();
        }
        for (FileManagerEntity fileManagerEntity : this.f207696d) {
            if (fileManagerEntity != null && (str2 = fileManagerEntity.peerUin) != null && str2.equals(str) && (fileManagerEntity.getCloudType() != 2 || fileManagerEntity.nOpType == 3)) {
                arrayList.add(fileManagerEntity);
            }
            if (arrayList.size() >= i3) {
                return arrayList;
            }
        }
        int i16 = 0;
        while (arrayList.size() <= 0) {
            List<FileManagerEntity> V = V(500, i16);
            if (V == null) {
                return arrayList;
            }
            i16++;
            for (FileManagerEntity fileManagerEntity2 : V) {
                if (fileManagerEntity2 != null && fileManagerEntity2.peerUin != null && !arrayList.contains(fileManagerEntity2) && fileManagerEntity2.peerUin.equals(str) && (fileManagerEntity2.getCloudType() != 2 || fileManagerEntity2.nOpType == 3)) {
                    arrayList.add(fileManagerEntity2);
                    this.f207696d.add(fileManagerEntity2);
                }
                if (arrayList.size() >= i3) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public synchronized FileManagerEntity X(String str, long j3) {
        if (this.f207693a == null) {
            init();
        }
        if (str != null && j3 > 0) {
            for (FileManagerEntity fileManagerEntity : this.f207693a) {
                if (fileManagerEntity.nOLfileSessionId == j3 && str.equalsIgnoreCase(fileManagerEntity.peerUin)) {
                    return fileManagerEntity;
                }
                if (0 == fileManagerEntity.nOLfileSessionId && j3 == fileManagerEntity.nSessionId && str.equalsIgnoreCase(fileManagerEntity.peerUin)) {
                    fileManagerEntity.nOLfileSessionId = j3;
                    e0(fileManagerEntity);
                    return fileManagerEntity;
                }
            }
            for (FileManagerEntity fileManagerEntity2 : this.f207694b.values()) {
                if (fileManagerEntity2.nOLfileSessionId == j3 && str.equalsIgnoreCase(fileManagerEntity2.peerUin)) {
                    return fileManagerEntity2;
                }
                if (0 == fileManagerEntity2.nOLfileSessionId && j3 == fileManagerEntity2.nSessionId && str.equalsIgnoreCase(fileManagerEntity2.peerUin)) {
                    fileManagerEntity2.nOLfileSessionId = j3;
                    e0(fileManagerEntity2);
                    return fileManagerEntity2;
                }
            }
            return null;
        }
        return null;
    }

    public synchronized void Y(long j3) {
        Map<Long, FileManagerEntity> map = this.f207694b;
        if (map != null) {
            Iterator<Map.Entry<Long, FileManagerEntity>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (j3 == it.next().getValue().nSessionId) {
                    it.remove();
                }
            }
        }
    }

    public void Z() {
        long currentTimeMillis = System.currentTimeMillis();
        Map<Long, FileManagerEntity> map = this.f207694b;
        if (map != null && map.size() > 0 && currentTimeMillis - this.f207699g > 5000) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.FileManagerProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    FileManagerProxy.this.j();
                }
            });
        }
        Set<String> set = this.f207695c;
        if (set != null) {
            set.clear();
        }
    }

    public void a0(long j3, String str, long j16) {
        if (str != null && j3 >= 0 && j16 > 0) {
            if (this.f207698f.size() > 30) {
                this.f207698f.remove(0);
            }
            a aVar = new a();
            aVar.f207710a = j3;
            aVar.f207711b = str;
            aVar.f207712c = j16;
            this.f207698f.add(aVar);
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerProxy<FileAssistant>", 2, "saveDeletedEntity nSessionId=" + j3 + " nOlSessionId=" + j16);
            }
        }
    }

    public void b0(FileManagerEntity fileManagerEntity, String str) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
            }
        } else {
            fileManagerEntity.setFilePath(str);
            FileManagerEntity m177clone = fileManagerEntity.m177clone();
            ContentValues contentValues = new ContentValues();
            contentValues.put("strFilePath", str);
            d0(FileManagerEntity.tableName(), contentValues, "nSessionId=?", new String[]{String.valueOf(m177clone.nSessionId)}, null);
            B(m177clone);
        }
    }

    public void c0() {
        if (this.f207693a == null) {
            init();
        }
        String str = null;
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            fileManagerEntity.isReaded = true;
            str = fileManagerEntity.getTableName();
        }
        if (str != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isReaded", Boolean.TRUE);
            d0(str, contentValues, "isReaded=?", new String[]{"0"}, null);
        }
    }

    void d0(String str, ContentValues contentValues, String str2, String[] strArr, ProxyListener proxyListener) {
        this.proxyManager.addMsgQueue(String.valueOf(0), 0, str, contentValues, str2, strArr, 1, proxyListener);
    }

    public void e0(final FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "updateFileEntity, Error : entity is null!!!");
                return;
            }
            return;
        }
        FileManagerUtil.correctFileInfo(fileManagerEntity);
        int i3 = fileManagerEntity.status;
        if (i3 == 2) {
            fileManagerEntity.status = 0;
        } else if (i3 == 16 && fileManagerEntity.peerType == 10014 && QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 1, "updateFileEntity call stack: " + QLog.getStackTraceString(new Throwable()));
        }
        final ContentValues m3 = m(fileManagerEntity);
        fileManagerEntity.status = i3;
        final long j3 = fileManagerEntity.nSessionId;
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            try {
                d0(FileManagerEntity.tableName(), m3, "nSessionId=?", new String[]{String.valueOf(j3)}, null);
                B(fileManagerEntity);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.FileManagerProxy.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileManagerProxy.this.d0(FileManagerEntity.tableName(), m3, "nSessionId=?", new String[]{String.valueOf(j3)}, null);
                    FileManagerProxy.this.B(fileManagerEntity);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        });
    }

    public synchronized void f0(FileManagerEntity fileManagerEntity) {
        this.f207693a.remove(fileManagerEntity);
        List<FileManagerEntity> list = this.f207696d;
        if (list != null) {
            Iterator<FileManagerEntity> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().nSessionId == fileManagerEntity.nSessionId) {
                    it.remove();
                }
            }
        }
        Iterator<Map.Entry<Long, FileManagerEntity>> it5 = this.f207694b.entrySet().iterator();
        while (it5.hasNext()) {
            if (fileManagerEntity.nSessionId == it5.next().getValue().nSessionId) {
                it5.remove();
            }
        }
        w(fileManagerEntity);
    }

    public synchronized void g(final FileManagerEntity fileManagerEntity) {
        x(fileManagerEntity);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.FileManagerProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileManagerProxy.this.h(fileManagerEntity, null);
                        FileManagerProxy.this.w(fileManagerEntity);
                    } catch (Exception e16) {
                        QLog.e("FileManagerProxy<FileAssistant>", 1, "addToDB error:", e16);
                    }
                }
            }, 32, null, false);
        } else {
            try {
                h(fileManagerEntity, null);
                w(fileManagerEntity);
            } catch (Exception e16) {
                QLog.e("FileManagerProxy<FileAssistant>", 1, "addToDB error:", e16);
            }
        }
    }

    public synchronized void g0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        if (fileManagerEntity.bDelInFM) {
            contentValues.put("bDelInFM", Boolean.TRUE);
        } else {
            contentValues.put("bDelInFM", Boolean.FALSE);
        }
        d0(FileManagerEntity.tableName(), contentValues, "nSessionId=?", new String[]{String.valueOf(fileManagerEntity.nSessionId)}, null);
    }

    synchronized void h(FileManagerEntity fileManagerEntity, ProxyListener proxyListener) {
        if (this.app.getEntityManagerFactory().createEntityManager() == null) {
            return;
        }
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        if (fileManagerEntity.nFileType != 13) {
            fileManagerEntity.nFileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
        }
        fileManagerEntity2.copyFrom(fileManagerEntity);
        fileManagerEntity2.nSessionId = fileManagerEntity.nSessionId;
        boolean z16 = fileManagerEntity.bSend;
        fileManagerEntity2.bSend = z16;
        fileManagerEntity2.bDelInAio = fileManagerEntity.bDelInAio;
        fileManagerEntity2.bDelInFM = fileManagerEntity.bDelInFM;
        int i3 = fileManagerEntity2.status;
        if (i3 != 1 && i3 != -1 && !z16 && i3 != 4) {
            fileManagerEntity2.status = 0;
        }
        int i16 = fileManagerEntity2.status;
        if (i16 == 2 || i16 == 18) {
            fileManagerEntity2.status = 0;
        }
        if (fileManagerEntity.status == 16) {
            fileManagerEntity2.status = 16;
        }
        if (fileManagerEntity2.getStatus() == 1000) {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, fileManagerEntity2.getTableName(), fileManagerEntity2, 0, null);
        } else if (fileManagerEntity2.getStatus() == 1001) {
            this.proxyManager.addMsgQueue(String.valueOf(0), 0, fileManagerEntity2.getTableName(), fileManagerEntity2, 1, null);
        } else if (QLog.isColorLevel()) {
            QLog.e("FileManagerProxy<FileAssistant>", 2, "FileManagerEntity status[" + String.valueOf(fileManagerEntity2.getStatus()) + "] is wrong");
        }
        this.proxyManager.transSaveToDatabase();
        fileManagerEntity.setId(fileManagerEntity2.getId());
        fileManagerEntity.setStatus(fileManagerEntity2.getStatus());
        B(fileManagerEntity2);
    }

    public synchronized void h0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgSeq", Long.valueOf(fileManagerEntity.msgSeq));
        contentValues.put(AppConstants.Key.COLUMN_MSG_UID, Long.valueOf(fileManagerEntity.msgUid));
        contentValues.put("msgTime", Long.valueOf(fileManagerEntity.msgTime));
        d0(FileManagerEntity.tableName(), contentValues, "nSessionId=?", new String[]{String.valueOf(fileManagerEntity.nSessionId)}, null);
    }

    public void i(final long j3, final String str) {
        if (f207692l == null) {
            f207692l = ThreadManagerV2.newHandlerRecycleThread("FileManagerDBThread", 0).b();
        }
        f207692l.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.FileManagerProxy.4
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                int size;
                String str3 = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0  and nRelatedSessionId = " + j3 + "  order by srvTime desc limit 2000) ";
                EntityManager createEntityManager = ((BaseProxy) FileManagerProxy.this).app.getEntityManagerFactory().createEntityManager();
                List<FileManagerEntity> b16 = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str3, null));
                synchronized (FileManagerProxy.this.f207703k) {
                    FileManagerProxy.this.f207702j = new HashMap();
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("find ZipList file:");
                    if (b16 == null) {
                        size = 0;
                    } else {
                        size = b16.size();
                    }
                    sb5.append(size);
                    QLog.i("FileManagerProxy<FileAssistant>", 1, sb5.toString());
                }
                if (b16 != null) {
                    for (FileManagerEntity fileManagerEntity : b16) {
                        String str4 = str;
                        if (str4 != null && (str2 = fileManagerEntity.zipFileId) != null && !str2.equalsIgnoreCase(str4)) {
                            if (QLog.isDevelopLevel()) {
                                QLog.e("FileManagerProxy<FileAssistant>", 1, fileManagerEntity.fileName + ": fileId is error! continiu");
                            }
                        } else if (TextUtils.isEmpty(fileManagerEntity.strServerPath)) {
                            if (QLog.isDevelopLevel()) {
                                QLog.e("FileManagerProxy<FileAssistant>", 1, fileManagerEntity.fileName + ": serverPath is empty!");
                            }
                            fileManagerEntity.setStatus(1001);
                            createEntityManager.remove(fileManagerEntity);
                        } else if (!q.f(fileManagerEntity.getFilePath())) {
                            if (QLog.isDevelopLevel()) {
                                QLog.e("FileManagerProxy<FileAssistant>", 1, fileManagerEntity.fileName + ": file not exist!");
                            }
                            fileManagerEntity.setStatus(1001);
                            createEntityManager.remove(fileManagerEntity);
                        } else {
                            try {
                                synchronized (FileManagerProxy.this.f207703k) {
                                    FileManagerProxy.this.f207702j.put(fileManagerEntity.zipInnerPath, fileManagerEntity);
                                }
                            } catch (Exception e16) {
                                QLog.e("FileManagerProxy<FileAssistant>", 1, fileManagerEntity.fileName + " getPath error:" + e16.toString());
                                e16.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        if (this.f207693a != null) {
            return;
        }
        String str = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit 30) order by srvTime desc";
        String str2 = "update  " + FileManagerEntity.tableName() + " set bDelInFM = ?  where ( srvTime + ?  ) < ? and cloudType = ? ";
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        createEntityManager.update(str2, new Object[]{1, 604800000L, Long.valueOf(com.tencent.mobileqq.service.message.e.K0() * 1000), 1});
        List<FileManagerEntity> b16 = i.b(DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str, null));
        this.f207693a = b16;
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerProxy<FileAssistant>", 2, "init , buf fmList is null,maybe is not data!,sql[" + str + "]");
            }
            this.f207693a = new ArrayList();
        }
        synchronized (this) {
            if (this.f207694b == null) {
                this.f207694b = new HashMap(this.f207693a.size());
                for (FileManagerEntity fileManagerEntity : this.f207693a) {
                    FileManagerUtil.correctFileInfo(fileManagerEntity);
                    this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
                }
            }
        }
        createEntityManager.close();
    }

    public void k() {
        DBMethodProxy.execSQL(this.app.getEntityManagerFactory().createEntityManager(), "delete from " + FileManagerEntity.tableName());
    }

    public void l() {
        synchronized (this.f207703k) {
            this.f207702j.clear();
        }
    }

    protected void n(String str, String str2, String[] strArr, ProxyListener proxyListener) {
        this.proxyManager.addMsgQueue(String.valueOf(0), 0, str, str2, strArr, 2, proxyListener);
    }

    public synchronized boolean o(FileManagerEntity fileManagerEntity, boolean z16) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 2, "if item is null, why can choose???!!!");
            }
            return false;
        }
        if (this.app.getEntityManagerFactory().createEntityManager() == null) {
            return false;
        }
        MessageRecord w06 = ((QQAppInterface) this.app).getMessageFacade().w0(fileManagerEntity.peerUin, fileManagerEntity.peerType, fileManagerEntity.uniseq);
        if (fileManagerEntity.bDelInAio && fileManagerEntity.bDelInFM && w06 == null) {
            n(FileManagerEntity.tableName(), "nSessionId = ?", new String[]{String.valueOf(fileManagerEntity.nSessionId)}, null);
            this.f207693a.remove(fileManagerEntity);
            List<FileManagerEntity> list = this.f207696d;
            if (list != null) {
                Iterator<FileManagerEntity> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == fileManagerEntity) {
                        it.remove();
                    }
                }
            }
            Iterator<Map.Entry<Long, FileManagerEntity>> it5 = this.f207694b.entrySet().iterator();
            while (it5.hasNext()) {
                if (fileManagerEntity.nSessionId == it5.next().getValue().nSessionId) {
                    it5.remove();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerProxy<FileAssistant>", 2, "Delete FileManagerEntity[" + String.valueOf(fileManagerEntity.nSessionId) + "] for memory and db:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
            }
            a0(fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.nOLfileSessionId);
            return u(1);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("bDelInAio", Boolean.valueOf(fileManagerEntity.bDelInAio));
        contentValues.put("bDelInFM", Boolean.valueOf(fileManagerEntity.bDelInFM));
        contentValues.put("uniseq", Long.valueOf(fileManagerEntity.uniseq));
        d0(FileManagerEntity.tableName(), contentValues, "nSessionId = ?", new String[]{String.valueOf(fileManagerEntity.nSessionId)}, null);
        if (z16) {
            this.proxyManager.transSaveToDatabase();
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Update FileManagerEntity[" + String.valueOf(fileManagerEntity.nSessionId) + "] for db:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
        }
        return true;
    }

    public synchronized void p(String str, int i3) {
        if (this.f207693a == null) {
            init();
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            String str2 = fileManagerEntity.peerUin;
            if (str2 != null && str2.equals(str) && fileManagerEntity.peerType == i3) {
                fileManagerEntity.uniseq = -1L;
                fileManagerEntity.bDelInAio = true;
            }
        }
        Iterator<Long> it = this.f207694b.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity2 = this.f207694b.get(it.next());
            String str3 = fileManagerEntity2.peerUin;
            if (str3 != null && str3.equals(str) && fileManagerEntity2.peerType == i3) {
                fileManagerEntity2.uniseq = -1L;
                fileManagerEntity2.bDelInAio = true;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("bDelInAio", Boolean.TRUE);
        contentValues.put("uniseq", (Integer) (-1));
        d0(FileManagerEntity.tableName(), contentValues, " peerUin = ? and peerType = ? ", new String[]{str, String.valueOf(i3)}, null);
        n(FileManagerEntity.tableName(), " bDelInAio = ? and bDelInFM = ? ", new String[]{String.valueOf(1), String.valueOf(1)}, null);
    }

    public long q(int i3, long j3, long j16, long j17, long j18) {
        String str;
        int size;
        if (this.f207693a == null) {
            init();
        }
        List<MessageRecord> Q = ((QQAppInterface) this.app).getMessageFacade().Q(String.valueOf(j17), i3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("------->FileManager findUinSeqForCache :msgIsTroop:");
            sb5.append(i3);
            sb5.append(",peerUin:");
            sb5.append(FileManagerUtil.enCodecString(String.valueOf(j17)));
            sb5.append(",list size:");
            if (Q == null) {
                size = 0;
            } else {
                size = Q.size();
            }
            sb5.append(size);
            QLog.i("FileManagerProxy<FileAssistant>", 2, sb5.toString());
        }
        if (Q != null && Q.size() > 0) {
            for (MessageRecord messageRecord : Q) {
                long j19 = messageRecord.msgUid;
                if (j19 != 0 && j19 == j18) {
                    return messageRecord.uniseq;
                }
                if (Math.abs(messageRecord.time - j16) < 30 && messageRecord.shmsgseq == j3 && messageRecord.senderuin.equals(Long.valueOf(j17))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FileManagerProxy<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
                    }
                    return messageRecord.uniseq;
                }
            }
        }
        for (FileManagerEntity fileManagerEntity : this.f207693a) {
            if (fileManagerEntity.peerType == i3 && fileManagerEntity.msgSeq == j3 && fileManagerEntity.msgUid == j18 && (str = fileManagerEntity.peerUin) != null && str.equals(Long.valueOf(j17))) {
                return fileManagerEntity.uniseq;
            }
        }
        return -1L;
    }

    public List<FileManagerEntity> r() {
        List<FileManagerEntity> list = this.f207693a;
        if (list == null || list.isEmpty()) {
            init();
        }
        return this.f207693a;
    }

    public synchronized FileManagerEntity s(long j3) {
        FileManagerEntity fileManagerEntity;
        if (this.f207694b.containsKey(Long.valueOf(j3))) {
            fileManagerEntity = this.f207694b.get(Long.valueOf(j3));
        } else {
            fileManagerEntity = null;
        }
        return fileManagerEntity;
    }

    public synchronized List<FileManagerEntity> t() {
        if (this.f207696d == null) {
            S();
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "queryMaxRecentRecords size[" + this.f207696d.size() + "]");
        }
        return this.f207696d;
    }

    public FileManagerEntity v(String str) {
        synchronized (this.f207703k) {
            if (this.f207702j.size() == 0) {
                return null;
            }
            FileManagerEntity fileManagerEntity = this.f207702j.get(str);
            if (fileManagerEntity == null) {
                return null;
            }
            FileManagerEntity s16 = s(fileManagerEntity.nSessionId);
            if (s16 != null) {
                if (s16 == fileManagerEntity) {
                    if (!q.f(fileManagerEntity.getFilePath())) {
                        synchronized (this.f207703k) {
                            this.f207702j.remove(fileManagerEntity.zipInnerPath);
                        }
                        QLog.e("FileManagerProxy<FileAssistant>", 1, "getZipFileListEntity : can find the Entity in cache, but raw file is not exist! [fileName] = " + fileManagerEntity.fileName + "[sessionId] = " + fileManagerEntity.nSessionId);
                        return null;
                    }
                    return fileManagerEntity;
                }
                synchronized (this.f207703k) {
                    this.f207702j.put(str, s16);
                }
                return s16;
            }
            synchronized (this) {
                this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
            }
            return fileManagerEntity;
        }
    }

    public synchronized void w(FileManagerEntity fileManagerEntity) {
        boolean z16;
        try {
            if (this.f207693a == null) {
                init();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerProxy<FileAssistant>", 1, e16.toString());
            }
        }
        if (this.f207693a.contains(fileManagerEntity)) {
            QLog.w("FileManagerProxy<FileAssistant>", 1, "!!!!!!!!!!!fmList has one!!!!!!!!!!!!");
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.f207693a.size()) {
                if (fileManagerEntity.srvTime >= this.f207693a.get(i3).srvTime) {
                    if (!fileManagerEntity.bDelInFM) {
                        this.f207693a.add(i3, fileManagerEntity);
                    }
                    List<FileManagerEntity> list = this.f207696d;
                    if (list != null) {
                        list.add(i3, fileManagerEntity);
                    }
                    z16 = true;
                } else {
                    i3++;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            if (this.f207693a.size() == 0) {
                if (!fileManagerEntity.bDelInFM) {
                    this.f207693a.add(0, fileManagerEntity);
                }
                List<FileManagerEntity> list2 = this.f207696d;
                if (list2 != null) {
                    list2.add(0, fileManagerEntity);
                }
            } else {
                if (!fileManagerEntity.bDelInFM) {
                    this.f207693a.add(fileManagerEntity);
                }
                List<FileManagerEntity> list3 = this.f207696d;
                if (list3 != null) {
                    list3.add(fileManagerEntity);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 4, "insertToList, is add" + z16 + " entityInfo:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
        }
        this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
        if (this.f207693a.size() > 30) {
            List<FileManagerEntity> list4 = this.f207693a;
            list4.remove(list4.size() - 1);
        }
    }

    public synchronized void x(FileManagerEntity fileManagerEntity) {
        init();
        FileManagerUtil.correctFileInfo(fileManagerEntity);
        this.f207694b.get(Long.valueOf(fileManagerEntity.nSessionId));
        this.f207694b.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerEntity);
    }

    public void y(FileManagerEntity fileManagerEntity) {
        synchronized (this.f207703k) {
            this.f207702j.put(fileManagerEntity.zipInnerPath, fileManagerEntity);
            QLog.e("FileManagerProxy<FileAssistant>", 1, "insertToZipListFile : [fileName] = " + fileManagerEntity.fileName + "[sessionId] = " + fileManagerEntity.nSessionId);
        }
    }

    public boolean z(long j3) {
        Iterator<a> it = this.f207698f.iterator();
        while (it.hasNext()) {
            if (it.next().f207710a == j3) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
    }
}
