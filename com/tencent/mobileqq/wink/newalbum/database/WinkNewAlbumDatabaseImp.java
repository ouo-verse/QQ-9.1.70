package com.tencent.mobileqq.wink.newalbum.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.scale.WinkNewAlbumPhotoScaleProcessor;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import s83.WinkNewAlbumConfigInfo;
import t83.c;
import t83.d;
import t83.e;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkNewAlbumDatabaseImp {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f324121b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f324122a = BaseApplication.getContext();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$10, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            new ArrayList();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.this$0.D().getReadableDatabase();
                    sQLiteDatabase.beginTransaction();
                    this.this$0.D();
                    Cursor query = sQLiteDatabase.query(b.l(), null, null, null, null, null, null);
                    if (query != null) {
                        this.this$0.A(query);
                        query.close();
                    } else {
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any photo info!");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryAllPhotoInfo " + e16);
                }
                this.this$0.D().r(sQLiteDatabase);
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryAllPhotoInfo cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th5) {
                this.this$0.D().r(sQLiteDatabase);
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$11, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f324126d;
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            new ArrayList();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.this$0.D().getReadableDatabase();
                    sQLiteDatabase.beginTransaction();
                    this.this$0.D();
                    Cursor query = sQLiteDatabase.query(b.l(), null, this.this$0.D().q(this.f324126d), null, null, null, null);
                    if (query != null) {
                        this.this$0.A(query);
                        query.close();
                    } else {
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any album info!");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryPhotoWithID " + e16);
                }
                this.this$0.D().r(sQLiteDatabase);
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryPhotoWithID cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th5) {
                this.this$0.D().r(sQLiteDatabase);
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$12, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass12 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f324127d;
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.this$0.D().getReadableDatabase();
                    sQLiteDatabase.beginTransaction();
                    this.this$0.D();
                    String l3 = b.l();
                    for (a aVar : this.f324127d) {
                        List arrayList2 = new ArrayList();
                        Cursor query = sQLiteDatabase.query(l3, null, this.this$0.D().q(aVar.getPhotoID()), null, null, null, null);
                        if (query != null) {
                            arrayList2 = this.this$0.A(query);
                            query.close();
                        } else {
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any album info!");
                        }
                        arrayList.addAll(arrayList2);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryPhotoWithAlbumModelList " + e16);
                }
                this.this$0.D().r(sQLiteDatabase);
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryPhotoInfoWithAlbum list cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th5) {
                this.this$0.D().r(sQLiteDatabase);
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$13, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass13 implements Runnable {
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        @Override // java.lang.Runnable
        public void run() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.this$0.D().getWritableDatabase();
                    sQLiteDatabase.beginTransaction();
                    this.this$0.D();
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + b.l());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_clip_memory_photo(id TEXT PRIMARY KEY, mediatype INTEGER, submediatype INTEGER, cameratype INTEGER, cameraswitch INTEGER, hasface INTEGER, videoduration FLOAT, width INTEGER, height INTEGER, aestheticscore FLOAT, curationscore FLOAT, facecount INTEGER, hasexposure INTEGER, path TEXT, timestamp LONG, year INTEGER, month INTEGER, dayofmonth INTEGER, dayofweek INTEGER, week INTEGER, localmediainfo TEXT, chinese_month INTEGER, chinese_day_of_month INTEGER, province TEXT, city TEXT, longitude FLOAT, latitude FLOAT )");
                    sQLiteDatabase.setTransactionSuccessful();
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clear photot table success!");
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clearPhotoDatabase " + e16);
                }
            } finally {
                this.this$0.D().r(sQLiteDatabase);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$14, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass14 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f324128d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ t83.b f324129e;
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b4: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:181), block:B:32:0x00b4 */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            SQLiteDatabase sQLiteDatabase;
            Exception e16;
            SQLiteDatabase sQLiteDatabase2;
            boolean z16;
            t83.b bVar;
            long currentTimeMillis = System.currentTimeMillis();
            SQLiteDatabase sQLiteDatabase3 = null;
            try {
                try {
                    sQLiteDatabase = this.this$0.D().getWritableDatabase();
                } catch (Exception e17) {
                    sQLiteDatabase = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    this.this$0.D().r(sQLiteDatabase3);
                    throw th;
                }
                try {
                    sQLiteDatabase.beginTransaction();
                    ContentValues f16 = this.this$0.D().f(this.f324128d);
                    Iterator<WinkNewAlbumConfigInfo> it = this.this$0.D().e().iterator();
                    while (it.hasNext()) {
                        String storyID = it.next().getStoryID();
                        if (storyID.isEmpty()) {
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "albumID is empty! Please check textInfo");
                        } else {
                            sQLiteDatabase.insertWithOnConflict(this.this$0.D().g(storyID), null, f16, 4);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    this.this$0.D().r(sQLiteDatabase);
                    z16 = true;
                } catch (Exception e18) {
                    e16 = e18;
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertAlbumInfo " + e16);
                    this.this$0.D().r(sQLiteDatabase);
                    z16 = false;
                    bVar = this.f324129e;
                    if (bVar != null) {
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertAlbumInfo cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                bVar = this.f324129e;
                if (bVar != null) {
                    bVar.a(z16);
                }
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertAlbumInfo cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th6) {
                th = th6;
                sQLiteDatabase3 = sQLiteDatabase2;
                this.this$0.D().r(sQLiteDatabase3);
                throw th;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$16, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass16 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f324133d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f324134e;
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            int i3 = 1;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.this$0.D().getReadableDatabase();
                    sQLiteDatabase.beginTransaction();
                    for (WinkNewAlbumConfigInfo winkNewAlbumConfigInfo : this.f324133d) {
                        String storyID = winkNewAlbumConfigInfo.getStoryID();
                        if (!storyID.isEmpty()) {
                            WinkNewMemoryAlbumResult z16 = this.this$0.z(winkNewAlbumConfigInfo);
                            Cursor query = sQLiteDatabase.query(this.this$0.D().g(storyID), null, null, null, null, null, null);
                            if (query != null) {
                                z16.B(this.this$0.x(query));
                                query.close();
                                arrayList.add(z16);
                            } else {
                                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any album info!");
                            }
                            i3 = 1;
                        } else {
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", i3, "albumID is empty! Please check textInfo");
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryAlbumResultWithList " + e16);
                }
                this.this$0.D().r(sQLiteDatabase);
                c cVar = this.f324134e;
                if (cVar != null) {
                    cVar.a(arrayList);
                }
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryAlbumResult cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; infoList size: " + this.f324133d.size());
            } catch (Throwable th5) {
                this.this$0.D().r(sQLiteDatabase);
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp$19, reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ WinkNewAlbumDatabaseImp this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f324122a.deleteDatabase(this.this$0.D().getDatabaseName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<z83.a> A(@NotNull Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            z83.a a16 = z83.a.a(cursor);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    private static String B(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mmkv_n_m_");
        sb5.append(ar.f326685a.k(str + "_" + str2));
        return sb5.toString();
    }

    private static String C(String str) {
        return "mmkv_n_m_collect_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b D() {
        return b.j();
    }

    private static String E(String str) {
        return "mmkv_n_m_" + str;
    }

    public static boolean J(String str) {
        return ar.f326685a.c(C(str), false);
    }

    public static List<String> K(String str) {
        String[] b16 = ar.f326685a.b();
        ArrayList arrayList = new ArrayList();
        String B = B(str, "");
        for (String str2 : b16) {
            if (str2.startsWith(B) && ar.f326685a.c(str2, false)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static boolean L(String str, String str2) {
        return ar.f326685a.c(B(str, str2), false);
    }

    public static float[] M(String str) {
        byte[] d16 = ar.f326685a.d(E(str), new byte[1024]);
        if (d16.length != 4096) {
            QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "can not load img feature, photoId: " + str + ", bytes length: " + d16.length);
            return null;
        }
        FloatBuffer asFloatBuffer = ByteBuffer.wrap(d16).asFloatBuffer();
        float[] fArr = new float[1024];
        asFloatBuffer.get(fArr);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WinkNewMemoryAlbumResult> N(SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query(D().k(), null, null, null, null, null, "exposureTimes ASC, lastTime DESC");
        if (query != null) {
            List<WinkNewMemoryAlbumResult> y16 = y(query);
            query.close();
            return y16;
        }
        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any photo info!");
        return null;
    }

    public static void R(String str) {
        ar.f326685a.l(E(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(z83.a aVar, z83.a aVar2) {
        if (aVar2 == null) {
            return;
        }
        aVar.E(aVar2.getAestheticScore());
        aVar.H(aVar2.getCity());
        aVar.L(aVar2.getLatitude());
        aVar.M(aVar2.getLongitude());
    }

    public static void k(WinkNewMemoryAlbumResult winkNewMemoryAlbumResult) {
        Iterator<z83.a> it = winkNewMemoryAlbumResult.i().iterator();
        while (it.hasNext()) {
            ar.f326685a.m(B(winkNewMemoryAlbumResult.getStoryID(), it.next().getId()), true);
        }
    }

    public static void l(String str) {
        ar.f326685a.m(C(str), true);
    }

    public static void m(float[] fArr, String str) {
        String E = E(str);
        ByteBuffer allocate = ByteBuffer.allocate(fArr.length * 4);
        allocate.asFloatBuffer().put(fArr);
        ar.f326685a.n(E, allocate.array());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(List<WinkNewAlbumConfigInfo> list) {
        SQLiteDatabase sQLiteDatabase = null;
        boolean z16 = false;
        try {
            try {
                sQLiteDatabase = D().getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                if (list != null) {
                    for (WinkNewAlbumConfigInfo winkNewAlbumConfigInfo : list) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + D().g(winkNewAlbumConfigInfo.getStoryID()));
                        sQLiteDatabase.execSQL(D().i(winkNewAlbumConfigInfo.getStoryID()));
                    }
                    try {
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clear all Album success!");
                        z16 = true;
                    } catch (Exception e16) {
                        e = e16;
                        z16 = true;
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clearAllAlbumDatabase" + e);
                        return z16;
                    }
                } else {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "configList is empty! cannot clean table");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e17) {
                e = e17;
            }
            return z16;
        } finally {
            D().r(null);
        }
    }

    public static void q() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.21
            @Override // java.lang.Runnable
            public void run() {
                String[] b16 = ar.f326685a.b();
                if (b16 == null) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "circle key is empty!");
                    return;
                }
                for (String str : b16) {
                    if (str.startsWith("mmkv_n_m_")) {
                        ar.f326685a.l(str);
                    }
                }
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clean imageFeature cache complete!");
            }
        });
    }

    public static void r() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.22
            @Override // java.lang.Runnable
            public void run() {
                String str = r83.a.WINK_NEWALBUM_SCALED_RES_ROOT_PATH;
                String u16 = WinkNewAlbumPhotoScaleProcessor.u();
                try {
                    File file = new File(str);
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "Sandbox folder is empty!");
                            return;
                        }
                        for (File file2 : listFiles) {
                            if (file2.isFile() && file2.getName().endsWith(u16) && !file2.delete()) {
                                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "file delete fail! path: " + file2.getAbsolutePath());
                            }
                        }
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clear sandbox file complete!");
                        return;
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "Sandbox folder doesn't exist!");
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clearAllSandboxCache" + e16);
                }
            }
        });
    }

    public static void s(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ar.f326685a.l(it.next());
        }
    }

    public static boolean u(String str) {
        return ar.f326685a.a(E(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<a> x(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            a a16 = a.a(cursor);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WinkNewMemoryAlbumResult> y(@NotNull Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            WinkNewMemoryAlbumResult a16 = WinkNewMemoryAlbumResult.a(cursor);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WinkNewMemoryAlbumResult z(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo) {
        WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = new WinkNewMemoryAlbumResult();
        winkNewMemoryAlbumResult.H(winkNewAlbumConfigInfo.getStoryID());
        winkNewMemoryAlbumResult.w(winkNewAlbumConfigInfo.getStoryName());
        winkNewMemoryAlbumResult.I(winkNewAlbumConfigInfo.j());
        winkNewMemoryAlbumResult.J(winkNewAlbumConfigInfo.k());
        return winkNewMemoryAlbumResult;
    }

    public void F(final List<WinkNewAlbumConfigInfo> list, final boolean z16, boolean z17, final t83.a aVar) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.1
            @Override // java.lang.Runnable
            public void run() {
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "configInfoList is empty!");
                }
                if (z16 && !WinkNewAlbumDatabaseImp.this.o(list)) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clearAllAlbumDatabase fail!");
                }
                boolean a16 = b.j().a(list);
                t83.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(a16);
                }
            }
        };
        if (z17) {
            synchronized (this) {
                runnable.run();
            }
        } else {
            RFWThreadManager.getInstance().execOnFileThread(runnable);
        }
    }

    public void G(final List<a> list, final WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, boolean z16, final t83.b bVar) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.15
            /* JADX WARN: Not initialized variable reg: 3, insn: 0x009e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:159), block:B:38:0x009e */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0098 A[Catch: all -> 0x00a9, TryCatch #2 {, blocks: (B:16:0x004e, B:17:0x0094, B:19:0x0098, B:20:0x009b, B:27:0x008a, B:35:0x009f, B:36:0x00a8), top: B:5:0x0007 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                SQLiteDatabase sQLiteDatabase;
                SQLiteDatabase sQLiteDatabase2;
                Exception e16;
                t83.b bVar2;
                String storyID;
                synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                    boolean z17 = true;
                    SQLiteDatabase sQLiteDatabase3 = null;
                    try {
                        try {
                            sQLiteDatabase2 = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                        } catch (Exception e17) {
                            sQLiteDatabase2 = null;
                            e16 = e17;
                        } catch (Throwable th5) {
                            th = th5;
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase3);
                            throw th;
                        }
                        try {
                            sQLiteDatabase2.beginTransaction();
                            storyID = winkNewAlbumConfigInfo.getStoryID();
                        } catch (Exception e18) {
                            e16 = e18;
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertAlbumInfoList " + e16);
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            z17 = false;
                            bVar2 = bVar;
                            if (bVar2 != null) {
                            }
                        }
                        if (!storyID.isEmpty()) {
                            String g16 = WinkNewAlbumDatabaseImp.this.D().g(storyID);
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                sQLiteDatabase2.insertWithOnConflict(g16, null, WinkNewAlbumDatabaseImp.this.D().f((a) it.next()), 5);
                            }
                            sQLiteDatabase2.setTransactionSuccessful();
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            bVar2 = bVar;
                            if (bVar2 != null) {
                                bVar2.a(z17);
                            }
                        } else {
                            w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "albumID is empty! Please check textInfo");
                            throw new Exception("albumID is empty");
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        sQLiteDatabase3 = sQLiteDatabase;
                    }
                }
            }
        };
        if (z16) {
            synchronized (this) {
                runnable.run();
            }
        } else {
            RFWThreadManager.getInstance().execOnFileThread(runnable);
        }
    }

    public void H(final List<WinkNewMemoryAlbumResult> list, final t83.b bVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.4
            /* JADX WARN: Removed duplicated region for block: B:18:0x0087 A[Catch: all -> 0x00c4, TryCatch #1 {, blocks: (B:4:0x0005, B:15:0x004f, B:16:0x0083, B:18:0x0087, B:19:0x008a, B:20:0x00b6, B:26:0x0079, B:30:0x00ba, B:31:0x00c3), top: B:3:0x0005 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                SQLiteDatabase sQLiteDatabase;
                Exception e16;
                t83.b bVar2;
                synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z16 = true;
                    SQLiteDatabase sQLiteDatabase2 = null;
                    try {
                        sQLiteDatabase = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                    } catch (Exception e17) {
                        sQLiteDatabase = null;
                        e16 = e17;
                    } catch (Throwable th5) {
                        th = th5;
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                        throw th;
                    }
                    try {
                        try {
                            sQLiteDatabase.beginTransaction();
                            WinkNewAlbumDatabaseImp.this.D().b(sQLiteDatabase);
                            String k3 = WinkNewAlbumDatabaseImp.this.D().k();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                sQLiteDatabase.insertWithOnConflict(k3, null, WinkNewAlbumDatabaseImp.this.D().d((WinkNewMemoryAlbumResult) it.next()), 4);
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                        } catch (Throwable th6) {
                            th = th6;
                            sQLiteDatabase2 = sQLiteDatabase;
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            throw th;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertMemoryAlbumList " + e16);
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                        z16 = false;
                        bVar2 = bVar;
                        if (bVar2 != null) {
                        }
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "insertMemoryAlbumList cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                    }
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(z16);
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "insertMemoryAlbumList cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                }
            }
        });
    }

    public void I(final List<z83.a> list, final t83.b bVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.2
            /* JADX WARN: Removed duplicated region for block: B:38:0x00f5 A[Catch: all -> 0x0131, TryCatch #0 {, blocks: (B:4:0x0007, B:45:0x0127, B:46:0x0130, B:35:0x00e8, B:36:0x00f1, B:38:0x00f5, B:39:0x00f8, B:40:0x0124, B:58:0x00b0), top: B:3:0x0007 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                SQLiteDatabase sQLiteDatabase;
                t83.b bVar2;
                SQLiteDatabase sQLiteDatabase2;
                synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z16 = false;
                    String str = null;
                    try {
                        SQLiteDatabase writableDatabase = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                        try {
                            writableDatabase.beginTransaction();
                            WinkNewAlbumDatabaseImp.this.D();
                            String l3 = b.l();
                            for (z83.a aVar : list) {
                                try {
                                    if (writableDatabase.insertWithOnConflict(l3, str, WinkNewAlbumDatabaseImp.this.D().m(aVar), 4) == -1 && w83.b.f445025a.B()) {
                                        sQLiteDatabase2 = writableDatabase;
                                        try {
                                            Cursor query = writableDatabase.query(l3, null, WinkNewAlbumDatabaseImp.this.D().q(aVar.getId()), null, null, null, null);
                                            if (query != null) {
                                                List A = WinkNewAlbumDatabaseImp.this.A(query);
                                                if (A.size() == 1) {
                                                    WinkNewAlbumDatabaseImp.this.W(aVar, (z83.a) A.get(0));
                                                }
                                                query.close();
                                            } else {
                                                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any album info!");
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            sQLiteDatabase = sQLiteDatabase2;
                                            try {
                                                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertMemoryPhotoInfoList " + e);
                                                WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                                                bVar2 = bVar;
                                                if (bVar2 != null) {
                                                }
                                                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertMemoryPhotoInfo cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                                            } catch (Throwable th5) {
                                                th = th5;
                                                WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                                                throw th;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            sQLiteDatabase = sQLiteDatabase2;
                                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                                            throw th;
                                        }
                                    } else {
                                        sQLiteDatabase2 = writableDatabase;
                                    }
                                    writableDatabase = sQLiteDatabase2;
                                    str = null;
                                } catch (Exception e17) {
                                    e = e17;
                                    sQLiteDatabase2 = writableDatabase;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertMemoryPhotoInfoList " + e);
                                    WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                                    bVar2 = bVar;
                                    if (bVar2 != null) {
                                    }
                                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertMemoryPhotoInfo cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                                } catch (Throwable th7) {
                                    th = th7;
                                    sQLiteDatabase2 = writableDatabase;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                                    throw th;
                                }
                            }
                            sQLiteDatabase2 = writableDatabase;
                            sQLiteDatabase2.setTransactionSuccessful();
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            z16 = true;
                        } catch (Exception e18) {
                            e = e18;
                            sQLiteDatabase = writableDatabase;
                        } catch (Throwable th8) {
                            th = th8;
                            sQLiteDatabase = writableDatabase;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        sQLiteDatabase = null;
                    } catch (Throwable th9) {
                        th = th9;
                        sQLiteDatabase = null;
                    }
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(z16);
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "insertMemoryPhotoInfo cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                }
            }
        });
    }

    public void O(final c cVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.8
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                List<WinkNewMemoryAlbumResult> arrayList = new ArrayList<>();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        sQLiteDatabase = WinkNewAlbumDatabaseImp.this.D().getReadableDatabase();
                        sQLiteDatabase.beginTransaction();
                        arrayList = WinkNewAlbumDatabaseImp.this.N(sQLiteDatabase);
                        for (WinkNewMemoryAlbumResult winkNewMemoryAlbumResult : arrayList) {
                            winkNewMemoryAlbumResult.A(WinkNewAlbumDatabaseImp.this.Q(sQLiteDatabase, winkNewMemoryAlbumResult.f()));
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception e16) {
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryAllCacheAlbumList " + e16);
                    }
                    WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.a(arrayList);
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "queryAllCacheAlbumList cost: " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th5) {
                    WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                    throw th5;
                }
            }
        });
    }

    public void P(final String str, final c cVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.9
            /* JADX WARN: Removed duplicated region for block: B:16:0x00a2  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Exception exc;
                List<WinkNewMemoryAlbumResult> list;
                c cVar2;
                SQLiteDatabase sQLiteDatabase;
                SQLiteDatabase sQLiteDatabase2;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z16 = true;
                SQLiteDatabase sQLiteDatabase3 = null;
                r6 = null;
                r6 = null;
                r6 = null;
                List<WinkNewMemoryAlbumResult> list2 = null;
                sQLiteDatabase3 = null;
                try {
                    try {
                        SQLiteDatabase readableDatabase = WinkNewAlbumDatabaseImp.this.D().getReadableDatabase();
                        try {
                            readableDatabase.beginTransaction();
                            try {
                                Cursor query = readableDatabase.query(WinkNewAlbumDatabaseImp.this.D().k(), null, "storyid = ?", new String[]{str}, null, null, null);
                                if (query != null) {
                                    try {
                                        list2 = WinkNewAlbumDatabaseImp.this.y(query);
                                        query.close();
                                    } catch (Exception e16) {
                                        exc = e16;
                                        list = list2;
                                        sQLiteDatabase3 = readableDatabase;
                                        QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryDDAlbumList " + exc);
                                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase3);
                                        list2 = list;
                                        z16 = false;
                                        cVar2 = cVar;
                                        if (cVar2 != null) {
                                        }
                                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "queryDDAlbumList cost: " + (System.currentTimeMillis() - currentTimeMillis) + " success = " + z16);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        sQLiteDatabase3 = readableDatabase;
                                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase3);
                                        throw th;
                                    }
                                } else {
                                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "cannot find any photo info!");
                                }
                                readableDatabase.setTransactionSuccessful();
                                WinkNewAlbumDatabaseImp.this.D().r(readableDatabase);
                            } catch (Exception e17) {
                                e = e17;
                                sQLiteDatabase2 = readableDatabase;
                                SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
                                exc = e;
                                list = list2;
                                sQLiteDatabase3 = sQLiteDatabase4;
                                QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "queryDDAlbumList " + exc);
                                WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase3);
                                list2 = list;
                                z16 = false;
                                cVar2 = cVar;
                                if (cVar2 != null) {
                                }
                                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "queryDDAlbumList cost: " + (System.currentTimeMillis() - currentTimeMillis) + " success = " + z16);
                            } catch (Throwable th6) {
                                th = th6;
                                sQLiteDatabase = readableDatabase;
                                sQLiteDatabase3 = sQLiteDatabase;
                                WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase3);
                                throw th;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            sQLiteDatabase2 = readableDatabase;
                        } catch (Throwable th7) {
                            th = th7;
                            sQLiteDatabase = readableDatabase;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Exception e19) {
                    exc = e19;
                    list = null;
                }
                cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(list2);
                }
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "queryDDAlbumList cost: " + (System.currentTimeMillis() - currentTimeMillis) + " success = " + z16);
            }
        });
    }

    public List<z83.a> Q(SQLiteDatabase sQLiteDatabase, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        D();
        Cursor query = sQLiteDatabase.query(b.l(), null, D().n(list), (String[]) list.toArray(new String[list.size()]), null, null, null);
        if (query == null) {
            w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "search photo DB failed, cursor is nil");
            return null;
        }
        HashMap hashMap = new HashMap();
        while (query.moveToNext()) {
            z83.a a16 = z83.a.a(query);
            if (a16 == null) {
                w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "get photo Info Failed, photo is null");
            } else if (a16.getId().isEmpty()) {
                w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "get photo Info Failed, photo id is empty");
            } else {
                hashMap.put(a16.getId(), a16);
            }
        }
        query.close();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (hashMap.containsKey(str)) {
                arrayList.add((z83.a) hashMap.get(str));
            }
        }
        return arrayList;
    }

    public void S(final String str, final d dVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.17
            /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                int i16;
                d dVar2;
                d dVar3;
                SQLiteDatabase readableDatabase;
                Cursor rawQuery;
                int i17 = 0;
                Exception e16 = null;
                try {
                    readableDatabase = WinkNewAlbumDatabaseImp.this.D().getReadableDatabase();
                    rawQuery = readableDatabase.rawQuery(WinkNewAlbumDatabaseImp.this.D().o(str), null);
                    if (rawQuery.moveToFirst()) {
                        i16 = rawQuery.getInt(0);
                    } else {
                        i16 = 0;
                    }
                } catch (Exception e17) {
                    e16 = e17;
                    i3 = 0;
                    i16 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    i3 = 0;
                    i16 = 0;
                }
                try {
                    rawQuery.close();
                    Cursor rawQuery2 = readableDatabase.rawQuery(WinkNewAlbumDatabaseImp.this.D().p(str), null);
                    i3 = 0;
                    while (rawQuery2.moveToNext()) {
                        try {
                            try {
                                if (rawQuery2.getInt(rawQuery2.getColumnIndex("mediatype")) == 2) {
                                    i3++;
                                } else {
                                    i17++;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                dVar2 = dVar;
                                if (dVar2 != null) {
                                    dVar2.a(i17, i3, i16, e16);
                                }
                                throw th;
                            }
                        } catch (Exception e18) {
                            e16 = e18;
                            QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "get story exposure info error, storyID: " + str + ", error: " + e16);
                            dVar3 = dVar;
                            if (dVar3 == null) {
                                return;
                            }
                            dVar3.a(i17, i3, i16, e16);
                        }
                    }
                    rawQuery2.close();
                    dVar3 = dVar;
                    if (dVar3 == null) {
                        return;
                    }
                } catch (Exception e19) {
                    e16 = e19;
                    i3 = 0;
                } catch (Throwable th7) {
                    th = th7;
                    i3 = 0;
                    dVar2 = dVar;
                    if (dVar2 != null) {
                    }
                    throw th;
                }
                dVar3.a(i17, i3, i16, e16);
            }
        });
    }

    public void T(final WinkNewMemoryAlbumResult winkNewMemoryAlbumResult) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                SQLiteDatabase sQLiteDatabase;
                Exception e16;
                StringBuilder sb5;
                synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z16 = true;
                    SQLiteDatabase sQLiteDatabase2 = null;
                    long j3 = 0;
                    try {
                        try {
                            sQLiteDatabase = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                        } catch (Exception e17) {
                            sQLiteDatabase = null;
                            e16 = e17;
                        } catch (Throwable th5) {
                            th = th5;
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            throw th;
                        }
                        try {
                            sQLiteDatabase.beginTransaction();
                            j3 = sQLiteDatabase.insertWithOnConflict(WinkNewAlbumDatabaseImp.this.D().k(), null, WinkNewAlbumDatabaseImp.this.D().d(winkNewMemoryAlbumResult), 4);
                            sQLiteDatabase.setTransactionSuccessful();
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                        } catch (Exception e18) {
                            e16 = e18;
                            QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "updateMemoryAlbumExpose " + e16);
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                            z16 = false;
                            sb5 = new StringBuilder();
                            sb5.append("updateMemoryAlbum cost: ");
                            sb5.append(System.currentTimeMillis() - currentTimeMillis);
                            sb5.append(" success: ");
                            sb5.append(z16);
                            sb5.append(" num:");
                            sb5.append(j3);
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, sb5.toString());
                        }
                        sb5 = new StringBuilder();
                        sb5.append("updateMemoryAlbum cost: ");
                        sb5.append(System.currentTimeMillis() - currentTimeMillis);
                        sb5.append(" success: ");
                        sb5.append(z16);
                        sb5.append(" num:");
                        sb5.append(j3);
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, sb5.toString());
                    } catch (Throwable th6) {
                        th = th6;
                        sQLiteDatabase2 = sb5;
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                        throw th;
                    }
                }
            }
        });
    }

    public void U(final String str, final int i3) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.StringBuilder] */
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z16 = true;
                    SQLiteDatabase sQLiteDatabase = 0;
                    SQLiteDatabase sQLiteDatabase2 = null;
                    try {
                        try {
                            sQLiteDatabase2 = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                            sQLiteDatabase2.beginTransaction();
                            String k3 = WinkNewAlbumDatabaseImp.this.D().k();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("exposureTimes", Integer.valueOf(i3));
                            i16 = sQLiteDatabase2.update(k3, contentValues, "albumid=?", new String[]{str});
                        } catch (Exception e16) {
                            e = e16;
                            i16 = 0;
                        }
                        try {
                            sQLiteDatabase2.setTransactionSuccessful();
                        } catch (Exception e17) {
                            e = e17;
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "updateMemoryAlbumExpose " + e);
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            z16 = false;
                            sQLiteDatabase = new StringBuilder();
                            sQLiteDatabase.append("updateMemoryAlbumExpose cost: ");
                            sQLiteDatabase.append(System.currentTimeMillis() - currentTimeMillis);
                            sQLiteDatabase.append(" success: ");
                            sQLiteDatabase.append(z16);
                            sQLiteDatabase.append(" num:");
                            sQLiteDatabase.append(i16);
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, sQLiteDatabase.toString());
                        }
                        sQLiteDatabase = new StringBuilder();
                        sQLiteDatabase.append("updateMemoryAlbumExpose cost: ");
                        sQLiteDatabase.append(System.currentTimeMillis() - currentTimeMillis);
                        sQLiteDatabase.append(" success: ");
                        sQLiteDatabase.append(z16);
                        sQLiteDatabase.append(" num:");
                        sQLiteDatabase.append(i16);
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, sQLiteDatabase.toString());
                    } finally {
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                    }
                }
            }
        });
    }

    public void V(final List<z83.a> list, final t83.b bVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.3
            /* JADX WARN: Removed duplicated region for block: B:19:0x007e A[Catch: all -> 0x00bb, TryCatch #2 {, blocks: (B:4:0x0005, B:15:0x0045, B:17:0x007a, B:19:0x007e, B:20:0x0081, B:21:0x00ad, B:27:0x0070, B:31:0x00b1, B:32:0x00ba), top: B:3:0x0005 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                SQLiteDatabase sQLiteDatabase;
                Exception e16;
                boolean z16;
                t83.b bVar2;
                synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SQLiteDatabase sQLiteDatabase2 = null;
                    try {
                        sQLiteDatabase = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                    } catch (Exception e17) {
                        sQLiteDatabase = null;
                        e16 = e17;
                    } catch (Throwable th5) {
                        th = th5;
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                        throw th;
                    }
                    try {
                        try {
                            sQLiteDatabase.beginTransaction();
                            WinkNewAlbumDatabaseImp.this.D();
                            String l3 = b.l();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                sQLiteDatabase.insertWithOnConflict(l3, null, WinkNewAlbumDatabaseImp.this.D().m((z83.a) it.next()), 5);
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                            z16 = true;
                        } catch (Throwable th6) {
                            th = th6;
                            sQLiteDatabase2 = sQLiteDatabase;
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase2);
                            throw th;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "uploadMemoryPhotoInfoList " + e16);
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                        z16 = false;
                        bVar2 = bVar;
                        if (bVar2 != null) {
                        }
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "uploadMemoryPhotoInfoList cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                    }
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(z16);
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "uploadMemoryPhotoInfoList cost: " + (System.currentTimeMillis() - currentTimeMillis) + "; size: " + list.size());
                }
            }
        });
    }

    public void n(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = D().getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                String g16 = D().g(winkNewAlbumConfigInfo.getStoryID());
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + g16);
                sQLiteDatabase.execSQL(D().i(winkNewAlbumConfigInfo.getStoryID()));
                sQLiteDatabase.setTransactionSuccessful();
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clear Album: " + g16 + " success!");
            } catch (Exception e16) {
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clearAlbumDB" + e16);
            }
        } finally {
            D().r(sQLiteDatabase);
        }
    }

    public void p() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.18
            /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x006d  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                String[] b16;
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        sQLiteDatabase = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WinkNewAlbumDatabaseImp.this.D().k());
                    } catch (Exception e16) {
                        e = e16;
                        z16 = false;
                    }
                    try {
                        sQLiteDatabase.setTransactionSuccessful();
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                        z16 = true;
                    } catch (Exception e17) {
                        e = e17;
                        z16 = true;
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "clearAllCacheMemoryAlbum" + e);
                        b16 = ar.f326685a.b();
                        if (b16 != null) {
                        }
                    }
                    b16 = ar.f326685a.b();
                    if (b16 != null) {
                        QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "circle key is empty!");
                        return;
                    }
                    for (String str : b16) {
                        if (str.startsWith("mmkv_n_m_collect_")) {
                            ar.f326685a.l(str);
                        }
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "clearAllCacheMemoryAlbum success:" + z16);
                } finally {
                    WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                }
            }
        });
    }

    public void t() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (WinkNewAlbumDatabaseImp.f324121b) {
                        QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "closeDatabase");
                        WinkNewAlbumDatabaseImp.this.D().getReadableDatabase().close();
                    }
                } catch (Exception e16) {
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "closeDatabase " + e16);
                }
            }
        });
    }

    public void v(final String str) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp.7
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z16 = true;
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        sQLiteDatabase = WinkNewAlbumDatabaseImp.this.D().getWritableDatabase();
                        sQLiteDatabase.beginTransaction();
                        i3 = sQLiteDatabase.delete(WinkNewAlbumDatabaseImp.this.D().k(), "albumid=?", new String[]{str});
                        try {
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Exception e16) {
                            e = e16;
                            QLog.e("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "deleteMemoryAlbum " + e);
                            WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                            z16 = false;
                            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "deleteMemoryAlbum cost: " + (System.currentTimeMillis() - currentTimeMillis) + " success: " + z16 + " num:" + i3 + " albumId:" + str);
                        }
                    } finally {
                        WinkNewAlbumDatabaseImp.this.D().r(sQLiteDatabase);
                    }
                } catch (Exception e17) {
                    e = e17;
                    i3 = 0;
                }
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "deleteMemoryAlbum cost: " + (System.currentTimeMillis() - currentTimeMillis) + " success: " + z16 + " num:" + i3 + " albumId:" + str);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, String str, Boolean bool, e eVar) {
        long j3;
        SQLiteDatabase readableDatabase;
        SQLiteDatabase sQLiteDatabase;
        Cursor rawQuery;
        Cursor query;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase2 = null;
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            try {
                readableDatabase = D().getReadableDatabase();
                try {
                    readableDatabase.beginTransaction();
                    rawQuery = readableDatabase.rawQuery(str, null);
                } catch (Exception e16) {
                    e = e16;
                    j3 = currentTimeMillis;
                    sQLiteDatabase = readableDatabase;
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = readableDatabase;
                }
                try {
                } catch (Exception e17) {
                    e = e17;
                    j3 = currentTimeMillis;
                    sQLiteDatabase3 = readableDatabase;
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "executeQuery " + e);
                    D().r(sQLiteDatabase3);
                    sQLiteDatabase2 = sQLiteDatabase3;
                    if (eVar != null) {
                    }
                    QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "executeQuery cost: " + (System.currentTimeMillis() - j3));
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase2 = readableDatabase;
                    D().r(sQLiteDatabase2);
                    throw th;
                }
            } catch (Exception e18) {
                e = e18;
                j3 = currentTimeMillis;
            }
            if (rawQuery == null) {
                if (eVar != null) {
                    eVar.a(arrayList, bool);
                }
                D().r(readableDatabase);
                D().r(readableDatabase);
                return;
            }
            WinkNewMemoryAlbumResult z16 = z(winkNewAlbumConfigInfo);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (rawQuery.moveToNext()) {
                a a16 = a.a(rawQuery);
                if (a16 == null) {
                    w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "albumDBModel is null");
                } else if (a16.getPhotoID().isEmpty()) {
                    w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "albumDBModel photoID is empty");
                } else {
                    arrayList2.add(a16);
                    arrayList3.add(a16.getPhotoID());
                }
            }
            rawQuery.close();
            D();
            String l3 = b.l();
            ArrayList arrayList4 = new ArrayList();
            j3 = currentTimeMillis;
            sQLiteDatabase = readableDatabase;
            try {
                query = readableDatabase.query(l3, null, D().n(arrayList3), (String[]) arrayList3.toArray(new String[arrayList3.size()]), null, null, null);
            } catch (Exception e19) {
                e = e19;
                sQLiteDatabase3 = sQLiteDatabase;
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 1, "executeQuery " + e);
                D().r(sQLiteDatabase3);
                sQLiteDatabase2 = sQLiteDatabase3;
                if (eVar != null) {
                }
                QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "executeQuery cost: " + (System.currentTimeMillis() - j3));
            } catch (Throwable th7) {
                th = th7;
                sQLiteDatabase2 = sQLiteDatabase;
                D().r(sQLiteDatabase2);
                throw th;
            }
            if (query == null) {
                w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "search photo DB failed, cursor is nil");
                if (eVar != null) {
                    eVar.a(arrayList, bool);
                }
                D().r(sQLiteDatabase);
                D().r(sQLiteDatabase);
                return;
            }
            while (query.moveToNext()) {
                z83.a a17 = z83.a.a(query);
                if (a17 == null) {
                    w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "get photo Info Failed, photo is null");
                } else if (a17.getId().isEmpty()) {
                    w53.b.c("WinkNewAlbum_WinkNewAlbumDatabaseImp", "get photo Info Failed, photo id is empty");
                } else {
                    arrayList4.add(a17);
                }
            }
            query.close();
            z16.B(arrayList2);
            z16.A(arrayList4);
            arrayList.add(z16);
            sQLiteDatabase.setTransactionSuccessful();
            D().r(sQLiteDatabase);
            sQLiteDatabase2 = z16;
            if (eVar != null) {
                eVar.a(arrayList, bool);
            }
            QLog.d("WinkNewAlbum_WinkNewAlbumDatabaseImp", 4, "executeQuery cost: " + (System.currentTimeMillis() - j3));
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
