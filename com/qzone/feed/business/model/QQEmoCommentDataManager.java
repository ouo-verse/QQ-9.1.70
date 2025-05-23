package com.qzone.feed.business.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.qzone.common.account.LoginData;
import com.qzone.util.al;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.qzone.widget.m;
import com.qzone.widget.n;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QQEmoCommentDataManager implements Handler.Callback {
    public static int G = 0;
    public static int H = 0;
    public static boolean I = false;

    /* renamed from: d, reason: collision with root package name */
    private SparseIntArray f47089d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<ArrayList<Long>> f47090e;

    /* renamed from: f, reason: collision with root package name */
    private c f47091f;

    /* renamed from: m, reason: collision with root package name */
    private int f47094m;
    private static final String F = QZoneFilePath.QQ_EMOTICON_DIR;
    private static final al<QQEmoCommentDataManager, Void> J = new a();

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, HashMap<Long, d>> f47092h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, n> f47093i = new ConcurrentHashMap<>();
    private Handler C = new Handler(Looper.getMainLooper(), this);
    private ArrayList<b> D = new ArrayList<>();
    private final Object E = new Object();

    /* compiled from: P */
    /* renamed from: com.qzone.feed.business.model.QQEmoCommentDataManager$4, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f47096d;
        final /* synthetic */ QQEmoCommentDataManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.Q(this.f47096d);
            this.this$0.R();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QQEmoCommentDataManager, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQEmoCommentDataManager a(Void r16) {
            return new QQEmoCommentDataManager();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f47097a;

        /* renamed from: b, reason: collision with root package name */
        public List<m> f47098b = new CopyOnWriteArrayList();

        c() {
        }
    }

    private String A(String str, Long l3) {
        d z16 = z(str, l3);
        if (z16 != null) {
            return z16.c();
        }
        return null;
    }

    private String B() {
        return VFSAssistantUtils.getSDKPrivatePath(ImageManager.IMAGE_DIR_NAME_V2);
    }

    public static QQEmoCommentDataManager C() {
        return J.get(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(ContentResolver contentResolver, Uri uri, String str) {
        int i3 = 0;
        try {
            Bundle call = contentResolver.call(uri, AppConstants.VIPKey.KEY_FOR_VIP_TYPE, str, (Bundle) null);
            if (call != null) {
                i3 = call.getInt(AppConstants.VIPKey.KEY_FOR_VIP_TYPE);
            }
        } catch (Exception e16) {
            QZLog.e("QQEmoCommentDataManager", "getQQVipType, get vip type exception!");
            e16.printStackTrace();
        }
        QZLog.i("QQEmoCommentDataManager", "getQQVipType, vip type is : " + i3);
        return i3;
    }

    private String G(String str, long j3) {
        return null;
    }

    private String I(String str, long j3) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        c cVar = this.f47091f;
        if (cVar == null || cVar.f47098b == null) {
            return;
        }
        this.f47089d = new SparseIntArray();
        this.f47090e = new SparseArray<>();
        int i3 = 0;
        this.f47094m = 0;
        int i16 = G - 1;
        while (i3 < H) {
            this.f47089d.put(i3, i3);
            i3++;
        }
        for (m mVar : this.f47091f.f47098b) {
            ArrayList<Long> arrayList = mVar.f60905d;
            if (arrayList == null) {
                QZLog.e("QQEmoCommentDataManager", "initPages, rapidCommentTabInfo.rcExpressionList is null");
            } else {
                i16++;
                mVar.f60907f = i16;
                mVar.f60910i = arrayList.size();
                int i17 = this.f47094m;
                int i18 = H;
                mVar.f60908g = i17 + i18;
                mVar.f60909h = i18 + i17;
                this.f47094m = i17 + 1;
                this.f47089d.put(i3, i16);
                this.f47090e.put(i3, mVar.f60905d);
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3) {
        c cVar = this.f47091f;
        if (cVar == null || cVar.f47098b == null || i3 <= 0) {
            return;
        }
        this.f47089d = new SparseIntArray();
        this.f47090e = new SparseArray<>();
        this.f47094m = 0;
        int i16 = G - 1;
        int i17 = 0;
        while (i17 < H) {
            this.f47089d.put(i17, i17);
            i17++;
        }
        int i18 = this.f47091f.f47097a;
        if (i3 > i18) {
            i3 = i18;
        }
        for (int i19 = 0; i19 < i3; i19++) {
            m mVar = this.f47091f.f47098b.get(i19);
            ArrayList<Long> arrayList = mVar.f60905d;
            if (arrayList == null) {
                QZLog.e("QQEmoCommentDataManager", "initPages, rapidCommentTabInfo.rcExpressionList is null");
            } else {
                i16++;
                mVar.f60907f = i16;
                mVar.f60910i = arrayList.size();
                int i26 = this.f47094m;
                int i27 = H;
                mVar.f60908g = i26 + i27;
                mVar.f60909h = i27 + i26;
                this.f47094m = i26 + 1;
                this.f47089d.put(i17, i16);
                this.f47090e.put(i17, mVar.f60905d);
                i17++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        ArrayList arrayList;
        synchronized (this.E) {
            arrayList = new ArrayList(this.D);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        a0(new Runnable() { // from class: com.qzone.feed.business.model.QQEmoCommentDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                QQEmoCommentDataManager.this.P();
                QQEmoCommentDataManager.this.R();
            }
        });
    }

    private void a0(Runnable runnable) {
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            runnable.run();
        } else {
            this.C.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(n nVar) {
        return nVar.f60913c != 3 && nVar.f60912b == 2 && r(nVar.f60911a);
    }

    private boolean s(n nVar) {
        int i3;
        return nVar.f60913c != 3 && ((i3 = nVar.f60912b) == 2 || i3 == 0) && r(nVar.f60911a);
    }

    private String x(String str) {
        return F + str + File.separator;
    }

    private d z(String str, Long l3) {
        HashMap<Long, d> hashMap;
        ConcurrentHashMap<String, HashMap<Long, d>> concurrentHashMap = this.f47092h;
        if (concurrentHashMap == null || (hashMap = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return hashMap.get(l3);
    }

    public List<m> E() {
        c cVar = this.f47091f;
        if (cVar != null) {
            return cVar.f47098b;
        }
        return null;
    }

    public long F() {
        return 100L;
    }

    public int J(int i3) {
        if (L(i3) != -1) {
            return L(i3) - G;
        }
        return -1;
    }

    public m K(int i3) {
        List<m> list;
        c cVar = this.f47091f;
        if (cVar == null || (list = cVar.f47098b) == null || i3 == -1 || i3 >= list.size()) {
            return null;
        }
        return this.f47091f.f47098b.get(i3);
    }

    public int L(int i3) {
        SparseIntArray sparseIntArray = this.f47089d;
        if (sparseIntArray == null || i3 >= sparseIntArray.size()) {
            return -1;
        }
        return this.f47089d.get(i3);
    }

    public int M(int i3) {
        List<m> list;
        c cVar = this.f47091f;
        if (cVar != null && (list = cVar.f47098b) != null) {
            for (m mVar : list) {
                if (String.valueOf(i3).equals(mVar.f60902a)) {
                    return mVar.f60907f;
                }
            }
        }
        return -1;
    }

    public int N() {
        return this.f47094m + H;
    }

    public int O() {
        return this.f47094m;
    }

    public boolean U(String str) {
        return new File(x(str)).exists();
    }

    public void Y(final boolean z16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.feed.business.model.QQEmoCommentDataManager.2
            /* JADX WARN: Code restructure failed: missing block: B:57:0x01dc, code lost:
            
                if (r5 != null) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x01f9, code lost:
            
                if (r14 != null) goto L54;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                int columnIndex;
                int columnIndex2;
                int columnIndex3;
                int i3;
                int i16;
                String str2 = EmojiManagerServiceProxy.EPID;
                QQEmoCommentDataManager.this.f47091f = new c();
                try {
                    long uin = LoginData.getInstance().getUin();
                    ContentResolver contentResolver = BaseApplicationImpl.getApplication().getContentResolver();
                    Uri parse = Uri.parse("content://qq.emoticon/emoticon_fav/?uin=" + uin);
                    QQEmoCommentDataManager.this.V(contentResolver, Uri.parse("content://qq.emoticon/emoticon_package/?uin=" + uin));
                    int D = QQEmoCommentDataManager.this.D(contentResolver, Uri.parse("content://qq.emoticon/"), String.valueOf(uin));
                    if (z16) {
                        QQEmoCommentDataManager.this.W(contentResolver, parse, D);
                    }
                    Cursor query = ContactsMonitor.query(contentResolver, Uri.parse("content://qq.emoticon/emoticon_tab/?uin=" + uin), null, null, null, null);
                    try {
                        if (query != null) {
                            try {
                                int columnIndex4 = query.getColumnIndex(EmojiManagerServiceProxy.EPID);
                                while (query.moveToNext()) {
                                    String decode = SecurityUtile.decode(query.getString(columnIndex4));
                                    if (QZLog.isColorLevel()) {
                                        QZLog.i("QQEmoCommentDataManager", "epid = " + decode);
                                    }
                                    long j3 = uin;
                                    query = ContactsMonitor.query(contentResolver, Uri.parse("content://qq.emoticon/emoticon/?uin=" + uin), null, "epId=?", new String[]{decode}, null);
                                    if (query != null) {
                                        try {
                                            try {
                                                columnIndex = query.getColumnIndex(str2);
                                                columnIndex2 = query.getColumnIndex("eId");
                                                columnIndex3 = query.getColumnIndex("name");
                                            } catch (Exception e16) {
                                                e = e16;
                                                str = str2;
                                            }
                                            if (!TextUtils.isEmpty(decode)) {
                                                n nVar = (n) QQEmoCommentDataManager.this.f47093i.get(decode);
                                                if (!QQEmoCommentDataManager.this.q(nVar) || !QQEmoCommentDataManager.this.S(nVar, D)) {
                                                    query.close();
                                                    uin = j3;
                                                }
                                            }
                                            ArrayList arrayList = new ArrayList();
                                            HashMap hashMap = new HashMap();
                                            while (query.moveToNext()) {
                                                String decode2 = SecurityUtile.decode(query.getString(columnIndex));
                                                String decode3 = SecurityUtile.decode(query.getString(columnIndex2));
                                                str = str2;
                                                try {
                                                    String decode4 = SecurityUtile.decode(query.getString(columnIndex3));
                                                    if (QZLog.isColorLevel()) {
                                                        i3 = columnIndex;
                                                        StringBuilder sb5 = new StringBuilder();
                                                        i16 = columnIndex2;
                                                        sb5.append("emoticonEpId = ");
                                                        sb5.append(decode2);
                                                        sb5.append(", eId = ");
                                                        sb5.append(decode3);
                                                        sb5.append(", name = ");
                                                        sb5.append(decode4);
                                                        QZLog.i("QQEmoCommentDataManager", sb5.toString());
                                                    } else {
                                                        i3 = columnIndex;
                                                        i16 = columnIndex2;
                                                    }
                                                    long hashCode = decode3.hashCode();
                                                    arrayList.add(Long.valueOf(hashCode));
                                                    hashMap.put(Long.valueOf(hashCode), new d(decode, decode3, decode4));
                                                    columnIndex = i3;
                                                    str2 = str;
                                                    columnIndex2 = i16;
                                                } catch (Exception e17) {
                                                    e = e17;
                                                    QZLog.e("QQEmoCommentDataManager", "emoticon db operation exception");
                                                    e.printStackTrace();
                                                    query.close();
                                                    uin = j3;
                                                    str2 = str;
                                                }
                                            }
                                            str = str2;
                                            QQEmoCommentDataManager.this.f47092h.put(decode, hashMap);
                                            QQEmoCommentDataManager.this.f47091f.f47098b.add(new m(decode, null, arrayList, false));
                                        } finally {
                                        }
                                    } else {
                                        str = str2;
                                    }
                                }
                            } catch (Exception e18) {
                                QZLog.e("QQEmoCommentDataManager", "emoticon_tab db operation exception");
                                e18.printStackTrace();
                                query.close();
                                QQEmoCommentDataManager.this.X();
                            }
                        }
                    } finally {
                    }
                } catch (Exception e19) {
                    QZLog.e("QQEmoCommentDataManager", "Failed to open db!");
                    e19.printStackTrace();
                }
            }
        });
    }

    public void Z(int i3, int i16) {
        H = i3;
        G = i16;
        P();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public void n(b bVar) {
        synchronized (this.E) {
            if (bVar != null) {
                if (!this.D.contains(bVar)) {
                    this.D.add(bVar);
                }
            }
        }
    }

    public void o() {
        synchronized (this.E) {
            this.D.clear();
        }
    }

    public ArrayList<Long> t(int i3) {
        SparseArray<ArrayList<Long>> sparseArray = this.f47090e;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public String u(String str, Long l3) {
        if ("fav_tab_id".equals(str)) {
            d z16 = z(str, l3);
            if (T(z16)) {
                return p(z16, z16.c());
            }
            return A(str, l3);
        }
        return p(z(str, l3), str);
    }

    public String v(String str, long j3) {
        return w(str, j3);
    }

    public String w(String str, long j3) {
        if ("fav_tab_id".equals(str)) {
            d z16 = z(str, Long.valueOf(j3));
            if (T(z16)) {
                return x(z16.c()) + z16.a() + "_thu.png";
            }
            return A(str, Long.valueOf(j3));
        }
        d z17 = z(str, Long.valueOf(j3));
        if (z17 == null) {
            return null;
        }
        return x(str) + z17.a() + "_thu.png";
    }

    public String y(String str) {
        return x(str) + "list.png";
    }

    private boolean r(String str) {
        try {
            File file = new File(x(str));
            if (file.exists() && file.isDirectory()) {
                return file.listFiles().length > 0;
            }
            return false;
        } catch (Exception e16) {
            QZLog.e("QQEmoCommentDataManager", "expressionExists, expression file does not exist!");
            e16.printStackTrace();
            return false;
        }
    }

    private boolean T(d dVar) {
        return (dVar == null || dVar.a() == null || dVar.c() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(ContentResolver contentResolver, Uri uri, int i3) {
        n nVar;
        Cursor query = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
        if (query != null) {
            try {
                try {
                    int columnIndex = query.getColumnIndex(QQSysAndEmojiResInfo.EMO_ID);
                    int columnIndex2 = query.getColumnIndex("eId");
                    int columnIndex3 = query.getColumnIndex("emoPath");
                    ArrayList arrayList = new ArrayList();
                    HashMap<Long, d> hashMap = new HashMap<>();
                    while (query.moveToNext()) {
                        int i16 = query.getInt(columnIndex);
                        String decode = SecurityUtile.decode(query.getString(columnIndex2));
                        String string = query.getString(columnIndex3);
                        if (!RFWFileUtils.isLocalPath(string)) {
                            string = SecurityUtile.decode(string);
                        }
                        if (QZLog.isColorLevel()) {
                            QZLog.i("QQEmoCommentDataManager", "loadFavoritesEmoticonData: emoId = " + i16 + ", eId = " + decode + ", path = " + string);
                        }
                        if (!TextUtils.isEmpty(decode) && !TextUtils.isEmpty(string) && (nVar = this.f47093i.get(string)) != null) {
                            if (s(nVar) && S(nVar, i3)) {
                            }
                        }
                        long j3 = i16;
                        arrayList.add(Long.valueOf(j3));
                        d dVar = new d(String.valueOf(i16), decode, null);
                        dVar.d(string);
                        hashMap.put(Long.valueOf(j3), dVar);
                        columnIndex = columnIndex;
                    }
                    Collections.reverse(arrayList);
                    this.f47092h.put("fav_tab_id", hashMap);
                    this.f47091f.f47098b.add(new m("fav_tab_id", null, arrayList, true));
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QZLog.e("QQEmoCommentDataManager", "loadFavoritesEmoticonData: emoticon_fav db operation exception");
                }
            } finally {
                query.close();
            }
        }
        if (query == null) {
        }
    }

    private String p(d dVar, String str) {
        if (dVar == null) {
            return null;
        }
        String a16 = dVar.a();
        String str2 = x(str) + a16;
        if (new File(str2).exists()) {
            String str3 = B() + a16 + "_qzonegif";
            if (QZLog.isColorLevel()) {
                Log.i("QQEmoCommentDataManager", "destPath = " + str3);
            }
            if (FileUtils.pushData2File(str3, com.tencent.mobileqq.emosm.e.q(str2), false)) {
                QZLog.i("QQEmoCommentDataManager", "destPath = " + str3 + ", save to the decrypt file");
                return str3;
            }
            return str2 + "_thu.png";
        }
        String str4 = str2 + "_apng";
        if (!new File(str4).exists()) {
            return null;
        }
        String str5 = B() + a16 + "_qzonegif";
        if (QZLog.isColorLevel()) {
            QZLog.i("QQEmoCommentDataManager", "destPath = " + str5);
        }
        if (FileUtils.pushData2File(str5, com.tencent.mobileqq.emosm.e.q(str4), false)) {
            QZLog.i("QQEmoCommentDataManager", "destPath = " + str5 + ", save to the decrypt file");
            return str5;
        }
        return str2 + "_thu.png";
    }

    public RapidCommentExpressionInfo H(m mVar, long j3) {
        HashMap<Long, RapidCommentExpressionInfo> hashMap;
        if (mVar == null || (hashMap = mVar.f60906e) == null) {
            return null;
        }
        RapidCommentExpressionInfo rapidCommentExpressionInfo = hashMap.get(Long.valueOf(j3));
        if (rapidCommentExpressionInfo != null && !rapidCommentExpressionInfo.D) {
            String str = mVar.f60902a;
            rapidCommentExpressionInfo.f60639d = str;
            rapidCommentExpressionInfo.f60641f = I(str, j3);
            rapidCommentExpressionInfo.f60642h = G(mVar.f60902a, j3);
            rapidCommentExpressionInfo.f60643i = v(mVar.f60902a, j3);
            rapidCommentExpressionInfo.f60644m = w(mVar.f60902a, j3);
            rapidCommentExpressionInfo.C = F();
            rapidCommentExpressionInfo.D = true;
            d z16 = z(mVar.f60902a, Long.valueOf(j3));
            if (z16 != null) {
                rapidCommentExpressionInfo.E = z16.b();
            }
        }
        return rapidCommentExpressionInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(n nVar, int i3) {
        if (nVar == null) {
            return false;
        }
        int i16 = nVar.f60914d;
        return i16 == 4 ? i3 == 1 || i3 == 3 : i16 != 5 || i3 == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(ContentResolver contentResolver, Uri uri) {
        Cursor query = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
        if (query != null) {
            try {
                try {
                    int columnIndex = query.getColumnIndex(EmojiManagerServiceProxy.EPID);
                    int columnIndex2 = query.getColumnIndex("status");
                    int columnIndex3 = query.getColumnIndex("jobType");
                    int columnIndex4 = query.getColumnIndex("mobileFeetype");
                    int columnIndex5 = query.getColumnIndex("isAPNG");
                    while (query.moveToNext()) {
                        String decode = SecurityUtile.decode(query.getString(columnIndex));
                        int i3 = query.getInt(columnIndex2);
                        int i16 = query.getInt(columnIndex3);
                        int i17 = query.getInt(columnIndex4);
                        int i18 = query.getInt(columnIndex5);
                        if (!TextUtils.isEmpty(decode)) {
                            n nVar = new n();
                            nVar.f60911a = decode;
                            nVar.f60912b = i3;
                            nVar.f60913c = i16;
                            nVar.f60914d = i17;
                            nVar.f60915e = i18;
                            this.f47093i.put(decode, nVar);
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                query.close();
            }
        }
        if (query == null) {
        }
    }
}
