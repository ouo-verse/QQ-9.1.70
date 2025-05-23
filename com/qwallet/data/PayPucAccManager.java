package com.qwallet.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.data.ImageManager;
import com.qwallet.protocol.Wallet.OpenPay.PuinInfoV2;
import com.qwallet.protocol.Wallet.OpenPay.RespGetPuinInfo;
import com.qwallet.protocol.Wallet.OpenPay.bargainor;
import com.qwallet.utils.QWalletUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tenpay.sdk.helper.SharedHelper;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import mqq.app.MobileQQ;

/* loaded from: classes3.dex */
public class PayPucAccManager {

    /* renamed from: a, reason: collision with root package name */
    private static a f41505a = null;

    /* renamed from: b, reason: collision with root package name */
    private static QQEntityManagerFactory f41506b = null;

    /* renamed from: c, reason: collision with root package name */
    protected static ExecutorService f41507c = null;

    /* renamed from: d, reason: collision with root package name */
    protected static ImageManager f41508d = null;

    /* renamed from: e, reason: collision with root package name */
    public static int f41509e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static int f41510f = -1;

    /* loaded from: classes3.dex */
    public static class PubAccItem implements Serializable {
        private static final long serialVersionUID = 1;

        /* renamed from: id, reason: collision with root package name */
        public int f41525id;
        public String[] uinsCancelled;
        public String bargainorId = "";
        public String subBargainorId = "";
        public String businessId = "";
        public long puin = 0;
        public String logo = "";
        public String name = "";
        public int selected = 0;
        public long ability = 0;
        public int payType = 0;
        public int weightIndex = 0;
        public boolean isFollowed = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "qwallet_pubacc.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        private String b(String str) {
            if (str == null) {
                return "";
            }
            return str;
        }

        private PubAccItem e(Cursor cursor) {
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("lid");
            int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bg_id");
            int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("sbg_id");
            int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("bus_id");
            int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(IPublicAccountBrowser.KEY_PUB_UIN);
            int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("logo");
            int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("name");
            int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("ability");
            int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("isCheck");
            int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("payType");
            int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow("weightIndex");
            PubAccItem pubAccItem = new PubAccItem();
            pubAccItem.f41525id = cursor.getInt(columnIndexOrThrow);
            pubAccItem.bargainorId = cursor.getString(columnIndexOrThrow2);
            pubAccItem.subBargainorId = cursor.getString(columnIndexOrThrow3);
            pubAccItem.businessId = cursor.getString(columnIndexOrThrow4);
            pubAccItem.puin = cursor.getLong(columnIndexOrThrow5);
            pubAccItem.logo = cursor.getString(columnIndexOrThrow6);
            pubAccItem.name = cursor.getString(columnIndexOrThrow7);
            pubAccItem.ability = cursor.getLong(columnIndexOrThrow8);
            pubAccItem.selected = cursor.getInt(columnIndexOrThrow9);
            pubAccItem.payType = cursor.getInt(columnIndexOrThrow10);
            pubAccItem.weightIndex = cursor.getInt(columnIndexOrThrow11);
            return pubAccItem;
        }

        private int f(bargainor bargainorVar) {
            return g(bargainorVar.bargainorId, bargainorVar.subbargainorId, bargainorVar.bussId);
        }

        private int g(String str, String str2, String str3) {
            return (b(str) + "," + b(str2) + "," + b(str3)).hashCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.database.sqlite.SQLiteDatabase, java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r6v0, types: [android.database.sqlite.SQLiteOpenHelper, com.qwallet.data.PayPucAccManager$a] */
        public synchronized ArrayList<PubAccItem> h(String str, String str2, String str3) {
            ?? r36;
            Cursor cursor;
            ArrayList<PubAccItem> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return arrayList;
            }
            Cursor cursor2 = null;
            try {
                String[] split = ((String) SharedHelper.getUValue(BaseApplication.getContext(), QWalletUtils.h(), "KEY_PUIN", "")).split(",");
                r36 = getReadableDatabase();
                if (r36 != 0) {
                    try {
                        cursor2 = r36.rawQuery("SELECT * FROM pubacc where lid=" + g(str, str2, str3), null);
                        if (cursor2 != null && cursor2.getCount() > 0) {
                            while (cursor2.moveToNext()) {
                                PubAccItem e16 = e(cursor2);
                                e16.uinsCancelled = split;
                                arrayList.add(e16);
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        cursor = cursor2;
                        cursor2 = r36;
                        try {
                            QLog.e("PayPucAccManager", 1, "", e);
                            if (QLog.isColorLevel()) {
                                QLog.i("PayPucAccManager", 2, "DatabaseHelper.queryPubAcc err:" + e.getMessage());
                            }
                            i(cursor);
                            j(cursor2);
                            return arrayList;
                        } catch (Throwable th5) {
                            th = th5;
                            r36 = cursor2;
                            cursor2 = cursor;
                            i(cursor2);
                            j(r36);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        i(cursor2);
                        j(r36);
                        throw th;
                    }
                }
                i(cursor2);
                j(r36);
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (Throwable th7) {
                th = th7;
                r36 = 0;
            }
            return arrayList;
        }

        private void i(Cursor cursor) {
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception e16) {
                    QLog.e("PayPucAccManager", 1, "", e16);
                }
            }
        }

        private void j(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e16) {
                    QLog.e("PayPucAccManager", 1, "", e16);
                }
            }
        }

        protected String d() {
            return " CREATE TABLE IF NOT EXISTS pubacc ( lid INTEGER(32), bg_id VARCHAR(64) NOT NULL, sbg_id VARCHAR(64), bus_id VARCHAR(64), " + IPublicAccountBrowser.KEY_PUB_UIN + " INTEGER(64), logo VARCHAR(256), name VARCHAR(32), ability INTEGER(64), isCheck INTEGER(32), payType INTEGER(32), weightIndex INTEGER(32)  ) ";
        }

        public synchronized void k(RespGetPuinInfo respGetPuinInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("PayPucAccManager", 2, "updatePubAccList...");
            }
            if (respGetPuinInfo != null && respGetPuinInfo.ret == 0 && respGetPuinInfo.vPuinInfoV2 != null) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        sQLiteDatabase = getWritableDatabase();
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.beginTransaction();
                            sQLiteDatabase.execSQL("DELETE FROM pubacc");
                            if (respGetPuinInfo.vPuinInfoV2.size() > 0) {
                                SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT INTO pubacc ( lid,bg_id,sbg_id,bus_id," + IPublicAccountBrowser.KEY_PUB_UIN + ",logo,name,ability,isCheck,payType,weightIndex ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                                for (int i3 = 0; i3 < respGetPuinInfo.vPuinInfoV2.size(); i3++) {
                                    PuinInfoV2 puinInfoV2 = respGetPuinInfo.vPuinInfoV2.get(i3);
                                    if (puinInfoV2 != null) {
                                        for (int i16 = 0; i16 < puinInfoV2.bargainorList.size(); i16++) {
                                            bargainor bargainorVar = puinInfoV2.bargainorList.get(i16);
                                            if (bargainorVar != null) {
                                                try {
                                                    compileStatement.bindLong(1, f(bargainorVar));
                                                    compileStatement.bindString(2, b(bargainorVar.bargainorId));
                                                    compileStatement.bindString(3, b(bargainorVar.subbargainorId));
                                                    compileStatement.bindString(4, b(bargainorVar.bussId));
                                                    compileStatement.bindLong(5, puinInfoV2.uin);
                                                    compileStatement.bindString(6, b(puinInfoV2.logo));
                                                    compileStatement.bindString(7, b(puinInfoV2.name));
                                                    compileStatement.bindLong(8, bargainorVar.switchbit);
                                                    compileStatement.bindLong(9, bargainorVar.defaultSelected);
                                                    compileStatement.bindLong(10, bargainorVar.paytypebit);
                                                    compileStatement.bindLong(11, bargainorVar.weightIndex);
                                                    compileStatement.execute();
                                                } catch (Exception e16) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("PayPucAccManager", 2, "DatabaseHelper.updatePubAccList bind err:" + e16.getMessage());
                                                    }
                                                }
                                                compileStatement.clearBindings();
                                            }
                                        }
                                    }
                                }
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                        }
                    } finally {
                        j(sQLiteDatabase);
                    }
                } catch (Exception e17) {
                    QLog.w("PayPucAccManager", 1, "DatabaseHelper.updatePubAccList err:" + e17.getMessage());
                }
                return;
            }
            QLog.i("PayPucAccManager", 2, "updatePubAccList: vPuinInfoV2 is null");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (QLog.isColorLevel()) {
                QLog.i("PayPucAccManager", 2, "DatabaseHelper onCreate");
            }
            try {
                sQLiteDatabase.execSQL(d());
            } catch (Exception e16) {
                QLog.e("PayPucAccManager", 1, "", e16);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            try {
                QLog.i("PayPucAccManager", 1, "DatabaseHelper onUpgrade oldVersion: " + i3 + ", newVersion: " + i16);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS pubacc");
                onCreate(sQLiteDatabase);
            } catch (Exception e16) {
                QLog.e("PayPucAccManager", 1, "", e16);
            }
        }
    }

    public static void e(final String str) {
        final String h16 = QWalletUtils.h();
        if (TextUtils.isEmpty(h16)) {
            if (QLog.isColorLevel()) {
                QLog.i("PayPucAccManager", 2, "addCancelRecord parameters error.");
                return;
            }
            return;
        }
        h().execute(new Runnable() { // from class: com.qwallet.data.PayPucAccManager.4
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3 = (String) SharedHelper.getUValue(BaseApplication.context, h16, "KEY_PUIN", "");
                StringBuffer stringBuffer = new StringBuffer();
                if (!TextUtils.isEmpty(str3)) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(str3.split(",")));
                    if (arrayList.contains(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PayPucAccManager", 2, "puin contains, return: " + str);
                            return;
                        }
                        return;
                    }
                    arrayList.add(str);
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (i3 == 0) {
                            str2 = (String) arrayList.get(i3);
                        } else {
                            str2 = "," + ((String) arrayList.get(i3));
                        }
                        stringBuffer.append(str2);
                    }
                } else {
                    stringBuffer.append(str);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "save puin: " + stringBuffer.toString());
                }
                SharedHelper.setUValue(BaseApplication.context, h16, "KEY_PUIN", stringBuffer.toString());
            }
        });
    }

    private static void f(Context context, SharedPreferences sharedPreferences) {
        if (sharedPreferences.getInt("pay_pubacc_db_last_version", -1) != 2) {
            sharedPreferences.edit().putInt("pay_pubacc_db_last_version", 2).apply();
            q(context, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized a g(Context context) {
        a aVar;
        synchronized (PayPucAccManager.class) {
            if (f41505a == null) {
                f41505a = new a(context);
            }
            aVar = f41505a;
        }
        return aVar;
    }

    protected static ExecutorService h() {
        ExecutorService executorService = f41507c;
        if (executorService == null || executorService.isShutdown()) {
            f41507c = ProxyExecutors.newFixedThreadPool(3);
        }
        return f41507c;
    }

    protected static ImageManager i() {
        if (f41508d == null) {
            f41508d = new ImageManager(MobileQQ.sMobileQQ.getApplicationContext());
        }
        return f41508d;
    }

    public static long j(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qwallet", 0);
        if (sharedPreferences == null) {
            return 0L;
        }
        f(context, sharedPreferences);
        return sharedPreferences.getLong("pay_pubacc_timestamp", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0119, code lost:
    
        if (r2 >= r18.uinsCancelled.length) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean k(Context context, PubAccItem pubAccItem, Bundle bundle, int i3, int i16, ImageManager imageManager, ArrayList<PubAccItem> arrayList, ImageManager.c cVar) {
        long j3;
        boolean z16;
        String i17;
        if (context != null && bundle != null && imageManager != null && cVar != null) {
            ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("callback");
            int i18 = bundle.getInt("payType");
            if (resultReceiver == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "handleGetPayPubAcc callback is null.");
                }
                return false;
            }
            if (pubAccItem == null) {
                resultReceiver.send(2, null);
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "handleGetPayPubAcc PubAcc isn't exist");
                }
                return false;
            }
            if (pubAccItem.isFollowed) {
                resultReceiver.send(1, null);
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "handleGetPayPubAcc PubAcc isFollowed");
                }
                return false;
            }
            if (i3 == 5) {
                j3 = 4;
            } else {
                if (i3 == 9 || i3 == 24) {
                    if (i16 == 1) {
                        j3 = 2;
                    } else if (i16 == 8) {
                        j3 = 8;
                    } else if (i16 == 6 || i16 == 7 || i16 == 3 || i16 == 4) {
                        j3 = 1;
                    }
                }
                j3 = 16;
            }
            if ((pubAccItem.ability & j3) == 0) {
                resultReceiver.send(2, null);
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "onGetPayPubAcc item.ability:" + pubAccItem.ability + " payAbility:" + j3);
                }
                return false;
            }
            if ((pubAccItem.payType & i18) == 0) {
                resultReceiver.send(2, null);
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "onGetPayPubAcc item.payType:" + pubAccItem.payType + " payType:" + i18);
                }
                return false;
            }
            if ((i18 & pubAccItem.selected) != 0) {
                if (pubAccItem.uinsCancelled != null) {
                    String h16 = QWalletUtils.h();
                    int i19 = 0;
                    while (true) {
                        String[] strArr = pubAccItem.uinsCancelled;
                        if (i19 >= strArr.length) {
                            break;
                        }
                        if (strArr[i19].equals(h16)) {
                            QLog.i("PayPucAccManager", 2, "user has ever canceled");
                            break;
                        }
                        i19++;
                    }
                }
                z16 = true;
                ImageManager.b bVar = new ImageManager.b();
                bVar.f41482a = cVar;
                bVar.f41483b = pubAccItem.logo;
                bVar.f41484c = QWalletUtils.e();
                i17 = imageManager.i(bVar);
                Bundle bundle2 = new Bundle();
                bundle2.putString("tips", String.format("\u5173\u6ce8%s\u516c\u4f17\u53f7", pubAccItem.name));
                bundle2.putString("name", pubAccItem.name);
                bundle2.putString(IPublicAccountBrowser.KEY_PUB_UIN, String.valueOf(pubAccItem.puin));
                bundle2.putBoolean("isCheck", z16);
                if (!TextUtils.isEmpty(i17)) {
                    bundle2.putString("logo", i17);
                }
                bundle2.putSerializable("subItems", arrayList);
                resultReceiver.send(0, bundle2);
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "onGetPayPubAcc item.tips:" + pubAccItem.name + " isCheck:" + z16 + " logo:" + i17);
                }
                if (TextUtils.isEmpty(i17)) {
                    imageManager.f(bVar);
                }
                return true;
            }
            z16 = false;
            ImageManager.b bVar2 = new ImageManager.b();
            bVar2.f41482a = cVar;
            bVar2.f41483b = pubAccItem.logo;
            bVar2.f41484c = QWalletUtils.e();
            i17 = imageManager.i(bVar2);
            Bundle bundle22 = new Bundle();
            bundle22.putString("tips", String.format("\u5173\u6ce8%s\u516c\u4f17\u53f7", pubAccItem.name));
            bundle22.putString("name", pubAccItem.name);
            bundle22.putString(IPublicAccountBrowser.KEY_PUB_UIN, String.valueOf(pubAccItem.puin));
            bundle22.putBoolean("isCheck", z16);
            if (!TextUtils.isEmpty(i17)) {
            }
            bundle22.putSerializable("subItems", arrayList);
            resultReceiver.send(0, bundle22);
            if (QLog.isColorLevel()) {
            }
            if (TextUtils.isEmpty(i17)) {
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PayPucAccManager", 2, "handleGetPayPubAcc parameters error.");
        }
        return false;
    }

    public static void l(ImageManager.b bVar, Bundle bundle) {
        String str;
        if (bVar != null && bundle != null) {
            ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("callback");
            if (resultReceiver == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "handlePayPubAccImageDownload callback is null.");
                    return;
                }
                return;
            }
            Bundle bundle2 = new Bundle();
            String str2 = "";
            if (!bVar.f41494m) {
                str = "";
            } else {
                str = bVar.f41496o;
            }
            bundle2.putString("logo", str);
            resultReceiver.send(3, bundle2);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handlePayPubAccImageDownload logo:");
                if (bVar.f41494m) {
                    str2 = bVar.f41496o;
                }
                sb5.append(str2);
                QLog.i("PayPucAccManager", 2, sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PayPucAccManager", 2, "handlePayPubAccImageDownload parameters error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(String str) {
        try {
            return ((INewQWalletApi) QRoute.apiIPCSync(INewQWalletApi.class)).ipcIsFollowUin(str);
        } catch (Exception e16) {
            QLog.e("PayPucAccManager", 1, "isFollowUin: ", e16);
            return false;
        }
    }

    public static void n() {
        if (QLog.isColorLevel()) {
            QLog.i("PayPucAccManager", 2, "onDestory");
        }
        a aVar = f41505a;
        if (aVar != null) {
            try {
                aVar.close();
            } catch (Exception e16) {
                QLog.e("PayPucAccManager", 1, "", e16);
            }
            f41505a = null;
        }
        QQEntityManagerFactory qQEntityManagerFactory = f41506b;
        if (qQEntityManagerFactory != null) {
            try {
                qQEntityManagerFactory.close();
            } catch (Exception e17) {
                QLog.e("PayPucAccManager", 1, "", e17);
            }
            f41506b = null;
        }
        ExecutorService executorService = f41507c;
        if (executorService != null) {
            executorService.shutdown();
            f41507c = null;
        }
        ImageManager imageManager = f41508d;
        if (imageManager != null) {
            imageManager.c();
            f41508d = null;
        }
    }

    public static void o(Bundle bundle) {
        String str;
        final String string = bundle.getString("bargainorId");
        final String string2 = bundle.getString("subBargainorId");
        final String string3 = bundle.getString("businessId");
        final ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("callback");
        if (resultReceiver != null && (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3))) {
            if (QLog.isColorLevel()) {
                QLog.i("PayPucAccManager", 2, "queryPubAcc bargainorId:" + string + " subBargainorId:" + string2);
            }
            h().execute(new Runnable() { // from class: com.qwallet.data.PayPucAccManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList h16 = PayPucAccManager.g(MobileQQ.sMobileQQ.getApplicationContext()).h(string, string2, string3);
                    if (QLog.isColorLevel()) {
                        QLog.i("PayPucAccManager", 2, "items size: " + h16.size());
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = h16.iterator();
                    PubAccItem pubAccItem = null;
                    while (it.hasNext()) {
                        PubAccItem pubAccItem2 = (PubAccItem) it.next();
                        boolean m3 = PayPucAccManager.m("" + pubAccItem2.puin);
                        pubAccItem2.isFollowed = m3;
                        if (!m3) {
                            if (pubAccItem2.weightIndex == 0) {
                                if (pubAccItem == null) {
                                    pubAccItem = pubAccItem2;
                                }
                            } else {
                                arrayList.add(pubAccItem2);
                            }
                        }
                    }
                    if (pubAccItem != null) {
                        arrayList.add(0, pubAccItem);
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("subItems", arrayList);
                    resultReceiver.send(0, bundle2);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryPayPubAcc callback:");
            if (resultReceiver == null) {
                str = "null";
            } else {
                str = "not null";
            }
            sb5.append(str);
            sb5.append(" bargainorId:");
            sb5.append(string);
            sb5.append(" subBargainorId:");
            sb5.append(string2);
            QLog.i("PayPucAccManager", 2, sb5.toString());
        }
    }

    public static void p(final Bundle bundle) {
        String str;
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PayPucAccManager", 2, "queryPubAcc parameters error.");
                return;
            }
            return;
        }
        final String string = bundle.getString("bargainorId");
        final String string2 = bundle.getString("subBargainorId");
        final String string3 = bundle.getString("businessId");
        ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("callback");
        if (resultReceiver != null && (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3))) {
            if (QLog.isColorLevel()) {
                QLog.i("PayPucAccManager", 2, "queryPubAcc bargainorId:" + string + " subBargainorId:" + string2);
            }
            h().execute(new Runnable() { // from class: com.qwallet.data.PayPucAccManager.3

                /* renamed from: com.qwallet.data.PayPucAccManager$3$a */
                /* loaded from: classes3.dex */
                class a implements Comparator<PubAccItem> {
                    a() {
                    }

                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(PubAccItem pubAccItem, PubAccItem pubAccItem2) {
                        return pubAccItem.weightIndex - pubAccItem2.weightIndex;
                    }
                }

                /* renamed from: com.qwallet.data.PayPucAccManager$3$b */
                /* loaded from: classes3.dex */
                class b extends ImageManager.c {
                    b() {
                    }

                    @Override // com.qwallet.data.ImageManager.c
                    public void a(ImageManager.b bVar) {
                        if (PayPucAccManager.f41505a == null) {
                            return;
                        }
                        PayPucAccManager.l(bVar, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList h16 = PayPucAccManager.g(MobileQQ.sMobileQQ.getApplicationContext()).h(string, string2, string3);
                    if (QLog.isColorLevel()) {
                        QLog.i("PayPucAccManager", 2, "items size: " + h16.size());
                    }
                    if (h16.size() > 0) {
                        Collections.sort(h16, new a());
                        PubAccItem pubAccItem = (PubAccItem) h16.get(0);
                        if (pubAccItem.weightIndex != 0) {
                            if (QLog.isColorLevel()) {
                                QLog.i("PayPucAccManager", 2, "there has no main puin");
                                return;
                            }
                            return;
                        }
                        try {
                            pubAccItem.isFollowed = PayPucAccManager.m("" + pubAccItem.puin);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i("PayPucAccManager", 2, "queryPubAcc isFollowed error" + e16.getMessage());
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("PayPucAccManager", 2, "queryPubAcc item.isFollowed:" + pubAccItem.isFollowed);
                        }
                        b bVar = new b();
                        Iterator it = h16.iterator();
                        while (it.hasNext()) {
                            if (((PubAccItem) it.next()).weightIndex == 0) {
                                it.remove();
                            }
                        }
                        PayPucAccManager.k(MobileQQ.sMobileQQ.getApplicationContext(), pubAccItem, bundle, PayPucAccManager.f41510f, PayPucAccManager.f41509e, PayPucAccManager.i(), h16, bVar);
                    }
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryPayPubAcc callback:");
            if (resultReceiver == null) {
                str = "null";
            } else {
                str = "not null";
            }
            sb5.append(str);
            sb5.append(" bargainorId:");
            sb5.append(string);
            sb5.append(" subBargainorId:");
            sb5.append(string2);
            QLog.i("PayPucAccManager", 2, sb5.toString());
        }
    }

    protected static void q(Context context, long j3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qwallet", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("pay_pubacc_timestamp", j3).commit();
        }
    }

    public static void r(Context context, final RespGetPuinInfo respGetPuinInfo) {
        if (respGetPuinInfo != null && respGetPuinInfo.ret == 0 && respGetPuinInfo.vPuinInfoV2 != null) {
            if (respGetPuinInfo.f41685st <= j(context)) {
                if (QLog.isColorLevel()) {
                    QLog.i("PayPucAccManager", 2, "updatePayPubAcc st not update: " + respGetPuinInfo.f41685st);
                    return;
                }
                return;
            }
            q(context, respGetPuinInfo.f41685st);
            final WeakReference weakReference = new WeakReference(context);
            h().execute(new Runnable() { // from class: com.qwallet.data.PayPucAccManager.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        return;
                    }
                    PayPucAccManager.g(context2).k(respGetPuinInfo);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PayPucAccManager", 2, "updatePayPubAcc parameters error.");
        }
    }
}
