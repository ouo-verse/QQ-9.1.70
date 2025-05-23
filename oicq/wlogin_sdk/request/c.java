package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.pb.ThirdPartLogin$RspBody;
import oicq.wlogin_sdk.pb.ThirdPartLogin$RspCommonInfo;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f422871e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f422872f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static b f422873g;

    /* renamed from: h, reason: collision with root package name */
    public static b f422874h;

    /* renamed from: a, reason: collision with root package name */
    public Context f422875a;

    /* renamed from: b, reason: collision with root package name */
    public TreeMap<Long, WloginAllSigInfo> f422876b = new TreeMap<>();

    /* renamed from: c, reason: collision with root package name */
    public TreeMap<String, UinInfo> f422877c;

    /* renamed from: d, reason: collision with root package name */
    public int f422878d;

    public c(Context context) {
        this.f422877c = new TreeMap<>();
        this.f422875a = context;
        TreeMap<String, UinInfo> a16 = a(context, "name_file", 0L);
        this.f422877c = a16;
        if (a16 == null) {
            this.f422877c = new TreeMap<>();
        }
    }

    public static int a(Context context, TreeMap treeMap, String str, byte[] bArr) {
        if ("tk_file".equals(str)) {
            try {
                for (Object obj : treeMap.keySet()) {
                    WloginAllSigInfo wloginAllSigInfo = (WloginAllSigInfo) treeMap.get(obj);
                    if (wloginAllSigInfo != null) {
                        util.LOGI(obj + "save allsig: " + wloginAllSigInfo._tk_map, "" + obj);
                    }
                }
            } catch (Exception e16) {
                util.printException(e16, "");
            }
        }
        oicq.wlogin_sdk.contextpersist.a.a(context, treeMap, str);
        util.LOGI("saveTKTreeMap start fileName=" + str, "");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int a16 = a(context, str, cryptor.encrypt(byteArray, 0, byteArray.length, bArr));
            objectOutputStream.close();
            byteArrayOutputStream.close();
            util.LOGI("saveTKTreeMap end=" + str, "");
            return a16;
        } catch (Throwable th5) {
            util.LOGI("saveTKTreeMap failed " + th5.getStackTrace().toString(), "");
            util.printThrowable(th5, "");
            return -1022;
        }
    }

    public static void b(String str, boolean z16) {
        util.LOGI("file " + str + " last update time " + new File(str).lastModified() + ",beforeWrite=" + z16, "");
    }

    public static String a(Context context, String str) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(filesDir.getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(util.FILE_DIR);
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }

    public static byte[] b(Context context, String str, StringBuffer stringBuffer) {
        String a16 = a(context, str);
        stringBuffer.append(",getFromSigFilePath=");
        stringBuffer.append(a16);
        if (TextUtils.isEmpty(a16)) {
            stringBuffer.append("isEmpty");
            return null;
        }
        File file = new File(a16);
        if (!file.exists() || !file.canRead()) {
            stringBuffer.append(",sigFileExists=");
            stringBuffer.append(file.exists());
            stringBuffer.append(",sigFileCanRead=");
            stringBuffer.append(file.canRead());
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                int available = fileInputStream.available();
                byte[] bArr = new byte[available];
                fileInputStream.read(bArr);
                fileInputStream.close();
                stringBuffer.append(",readSuccess=");
                stringBuffer.append(available);
                stringBuffer.append(",lastModified=");
                stringBuffer.append(file.lastModified());
                return bArr;
            } finally {
            }
        } catch (Exception e16) {
            stringBuffer.append(",readException=");
            stringBuffer.append(util.getThrowableInfo(e16));
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0106 A[Catch: all -> 0x014f, TryCatch #9 {all -> 0x014f, blocks: (B:87:0x0068, B:89:0x006e, B:17:0x007a, B:37:0x00b6, B:39:0x00bc, B:45:0x00d0, B:54:0x0100, B:56:0x0106, B:57:0x010b, B:59:0x0118, B:62:0x0135, B:74:0x011f, B:75:0x0109), top: B:2:0x000f, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0109 A[Catch: all -> 0x014f, TryCatch #9 {all -> 0x014f, blocks: (B:87:0x0068, B:89:0x006e, B:17:0x007a, B:37:0x00b6, B:39:0x00bc, B:45:0x00d0, B:54:0x0100, B:56:0x0106, B:57:0x010b, B:59:0x0118, B:62:0x0135, B:74:0x011f, B:75:0x0109), top: B:2:0x000f, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(Context context, String str) {
        SQLiteDatabase sQLiteDatabase;
        Exception exc;
        Cursor cursor;
        b bVar;
        Cursor cursor2;
        Boolean bool = Boolean.FALSE;
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor3 = null;
        byte[] bArr = null;
        cursor3 = null;
        try {
            try {
                stringBuffer.append("stashDbFileBefore");
                a(context, str, stringBuffer);
                if (str.equals("tk_file")) {
                    if (f422873g == null) {
                        f422873g = new b(context, str, null, 1);
                    }
                    bVar = f422873g;
                } else {
                    if (f422874h == null) {
                        f422874h = new b(context, str, null, 1);
                    }
                    bVar = f422874h;
                }
                sQLiteDatabase = bVar.getReadableDatabase();
                try {
                    b(sQLiteDatabase.getPath(), false);
                    cursor = sQLiteDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str + "' ", null);
                    try {
                        if (cursor.moveToNext()) {
                            try {
                                if (cursor.getInt(0) > 0) {
                                    bool = Boolean.TRUE;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                exc = e;
                                if (str.equals("tk_file")) {
                                    f422874h = null;
                                } else {
                                    f422873g = null;
                                }
                                stringBuffer.append(",dbException=");
                                stringBuffer.append(util.getThrowableInfo(exc));
                                try {
                                    bArr = b(context, str, stringBuffer);
                                } catch (Exception e17) {
                                    stringBuffer.append(",fileException=");
                                    stringBuffer.append(util.getThrowableInfo(e17));
                                }
                                a(context, str, stringBuffer, bArr == null ? "read_db_error_file_suc" : "read_db_error_file_error");
                                util.printException(exc, "");
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.isOpen();
                                }
                                return bArr;
                            }
                        }
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                        if (!bool.booleanValue()) {
                            if (!cursor.isClosed()) {
                                cursor.close();
                            }
                            sQLiteDatabase.isOpen();
                            return null;
                        }
                        cursor2 = cursor;
                        try {
                            Cursor query = sQLiteDatabase.query(str, new String[]{str}, "ID=0", null, null, null, null);
                            if (query == null) {
                                if (query != null && !query.isClosed()) {
                                    query.close();
                                }
                                sQLiteDatabase.isOpen();
                                return null;
                            }
                            if (!query.moveToFirst()) {
                                query.close();
                                if (!query.isClosed()) {
                                    query.close();
                                }
                                sQLiteDatabase.isOpen();
                                return null;
                            }
                            byte[] blob = query.getBlob(0);
                            query.close();
                            if (!query.isClosed()) {
                                query.close();
                            }
                            sQLiteDatabase.isOpen();
                            return blob;
                        } catch (Exception e18) {
                            exc = e18;
                            cursor = cursor2;
                            if (str.equals("tk_file")) {
                            }
                            stringBuffer.append(",dbException=");
                            stringBuffer.append(util.getThrowableInfo(exc));
                            bArr = b(context, str, stringBuffer);
                            a(context, str, stringBuffer, bArr == null ? "read_db_error_file_suc" : "read_db_error_file_error");
                            util.printException(exc, "");
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                            }
                            return bArr;
                        } catch (Throwable th5) {
                            th = th5;
                            cursor3 = cursor2;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e19) {
                        e = e19;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor2 = cursor;
                    }
                } catch (Exception e26) {
                    exc = e26;
                    cursor = null;
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Exception e27) {
                exc = e27;
                cursor = null;
                sQLiteDatabase = null;
            } catch (Throwable th8) {
                th = th8;
                sQLiteDatabase = null;
            }
        } catch (Throwable th9) {
            th = th9;
            cursor3 = cursor;
            if (cursor3 != null && !cursor3.isClosed()) {
                cursor3.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.isOpen();
            }
            throw th;
        }
    }

    public synchronized String a(Long l3) {
        for (String str : this.f422877c.keySet()) {
            UinInfo uinInfo = this.f422877c.get(str);
            if (uinInfo != null && uinInfo._uin.equals(l3)) {
                return str;
            }
        }
        return null;
    }

    public static TreeMap a(Context context, String str, long j3) {
        util.LOGI("loadTKTreeMap sigfile start " + str, "");
        byte[] b16 = b(context, str);
        TreeMap treeMap = null;
        if (b16 == null) {
            util.LOGI("loadTKTreeMap dbdata is null at " + u.f(), "");
            return null;
        }
        util.LOGI("loadTKTreeMap len:" + b16.length + " at " + u.f(), "");
        try {
            byte[] decrypt = cryptor.decrypt(b16, 0, b16.length, u.E);
            if (decrypt != null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decrypt);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                TreeMap treeMap2 = (TreeMap) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    if (treeMap2 == null) {
                        util.LOGI("tree is null", "");
                        return null;
                    }
                    util.LOGI("loadTKTreeMap tree size: " + treeMap2.size(), "");
                    if ("tk_file".equals(str)) {
                        try {
                            if (0 == j3) {
                                for (Object obj : treeMap2.keySet()) {
                                    util.LOGI(obj + " allsig: " + ((WloginAllSigInfo) treeMap2.get(obj))._tk_map, "" + obj);
                                }
                            } else {
                                util.LOGI(j3 + " allsig: " + ((WloginAllSigInfo) treeMap2.get(Long.valueOf(j3)))._tk_map, "" + j3);
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        for (Object obj2 : treeMap2.keySet()) {
                            UinInfo uinInfo = (UinInfo) treeMap2.get(obj2);
                            if (uinInfo != null) {
                                util.LOGI(obj2 + " is uin: " + uinInfo._uin, "");
                            }
                        }
                    }
                    oicq.wlogin_sdk.contextpersist.a.a(context, treeMap2, str);
                    return treeMap2;
                } catch (Throwable th5) {
                    th = th5;
                    treeMap = treeMap2;
                }
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(u.E, "DESede");
                Cipher cipher = Cipher.getInstance("DESede");
                cipher.init(2, secretKeySpec);
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(b16);
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new CipherInputStream(byteArrayInputStream2, cipher));
                TreeMap treeMap3 = (TreeMap) objectInputStream2.readObject();
                if (treeMap3 == null) {
                    return treeMap3;
                }
                try {
                    objectInputStream2.close();
                    byteArrayInputStream2.close();
                    oicq.wlogin_sdk.contextpersist.a.a(context, treeMap3, str);
                    return treeMap3;
                } catch (Throwable th6) {
                    th = th6;
                    treeMap = treeMap3;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
        util.printThrowable(th, "");
        return treeMap;
    }

    public synchronized UinInfo a(String str, boolean z16) {
        if (z16) {
            UinInfo uinInfo = this.f422877c.get(str);
            if (uinInfo != null) {
                util.LOGI("mem got_account name: " + str + " uin: " + uinInfo._uin + ", " + uinInfo.getHasPassword(), "");
                return uinInfo;
            }
        }
        Context context = this.f422875a;
        if (context == null) {
            return null;
        }
        TreeMap a16 = a(context, "name_file", 0L);
        if (a16 == null) {
            return null;
        }
        UinInfo uinInfo2 = (UinInfo) a16.get(str);
        if (uinInfo2 == null) {
            return null;
        }
        this.f422877c.put(str, uinInfo2);
        util.LOGI("file got_account name: " + str + " uin: " + uinInfo2._uin + ", " + uinInfo2.getHasPassword(), "");
        return uinInfo2;
    }

    public synchronized WloginAllSigInfo a(long j3) {
        WloginAllSigInfo wloginAllSigInfo = this.f422876b.get(Long.valueOf(j3));
        if (wloginAllSigInfo != null) {
            util.LOGI("get_all_siginfo in mem", "");
            return wloginAllSigInfo;
        }
        Context context = this.f422875a;
        if (context == null) {
            return null;
        }
        TreeMap a16 = a(context, "tk_file", j3);
        if (a16 == null) {
            return null;
        }
        WloginAllSigInfo wloginAllSigInfo2 = (WloginAllSigInfo) a16.get(Long.valueOf(j3));
        if (wloginAllSigInfo2 == null) {
            return null;
        }
        util.LOGI("got in file", "");
        this.f422876b.put(Long.valueOf(j3), wloginAllSigInfo2);
        return wloginAllSigInfo2;
    }

    public final void a(long j3, long j16, byte[][] bArr, long j17, byte[] bArr2, WloginAllSigInfo wloginAllSigInfo) {
        util.LOGI("A1 version tlv543In119 len = " + bArr2.length, "" + j3);
        ThirdPartLogin$RspBody thirdPartLogin$RspBody = new ThirdPartLogin$RspBody();
        try {
            thirdPartLogin$RspBody.mergeFrom(bArr2);
        } catch (InvalidProtocolBufferMicroException e16) {
            util.printException(e16);
        }
        if (!thirdPartLogin$RspBody.has() || !thirdPartLogin$RspBody.msg_rsp_common_info.has()) {
            wloginAllSigInfo.resetSigA1Version(j16);
            wloginAllSigInfo.put_siginfo(j16, bArr, j17);
            return;
        }
        ThirdPartLogin$RspCommonInfo thirdPartLogin$RspCommonInfo = thirdPartLogin$RspBody.msg_rsp_common_info;
        if (!thirdPartLogin$RspCommonInfo.uint32_a1_seq.has()) {
            wloginAllSigInfo.resetSigA1Version(j16);
            wloginAllSigInfo.put_siginfo(j16, bArr, j17);
            return;
        }
        util.LOGI("A1 version tlv543In119 len = " + bArr2.length, "" + j3);
        wloginAllSigInfo.put_siginfo(j16, bArr, j17, (long) thirdPartLogin$RspCommonInfo.uint32_a1_seq.get());
    }

    public static void a(Context context, String str, StringBuffer stringBuffer) {
        try {
            stringBuffer.append(",table=");
            stringBuffer.append(str);
            File databasePath = context.getDatabasePath(str);
            stringBuffer.append(",file=");
            stringBuffer.append(databasePath.getAbsolutePath());
            stringBuffer.append(",isExists=");
            stringBuffer.append(databasePath.exists());
            stringBuffer.append(",canRead=");
            stringBuffer.append(databasePath.canRead());
            stringBuffer.append(",canWrite=");
            stringBuffer.append(databasePath.canWrite());
            stringBuffer.append(",canExecute=");
            stringBuffer.append(databasePath.canExecute());
            stringBuffer.append(",lastModified=");
            stringBuffer.append(databasePath.lastModified());
            File parentFile = databasePath.getParentFile();
            stringBuffer.append(",isParentExists=");
            stringBuffer.append(parentFile.exists());
        } catch (Exception e16) {
            stringBuffer.append(",exception=");
            stringBuffer.append(util.getThrowableInfo(e16));
        }
    }

    public synchronized void a(String str, Long l3, boolean z16) {
        util.LOGI("put account " + str, "" + l3);
        String a16 = a(l3);
        if (a16 != null) {
            this.f422877c.remove(a16);
        }
        UinInfo uinInfo = new UinInfo(l3, z16);
        this.f422877c.put(str, uinInfo);
        if (this.f422875a != null) {
            synchronized (f422872f) {
                TreeMap a17 = a(this.f422875a, "name_file", 0L);
                if (a17 == null) {
                    a17 = new TreeMap();
                }
                if (a16 != null) {
                    a17.remove(a16);
                }
                a17.put(str, uinInfo);
                a(a17, "name_file");
            }
        }
    }

    public static boolean a(Context context, String str, byte[] bArr, StringBuffer stringBuffer) {
        String a16 = a(context, str);
        stringBuffer.append(",writeToSigFilePath=");
        stringBuffer.append(a16);
        if (TextUtils.isEmpty(a16)) {
            stringBuffer.append("isEmpty");
            return false;
        }
        File file = new File(a16);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                boolean mkdirs = parentFile.mkdirs();
                stringBuffer.append(",mkdirsResult=");
                stringBuffer.append(mkdirs);
                if (!mkdirs) {
                    return false;
                }
            }
            boolean createNewFile = file.createNewFile();
            stringBuffer.append(",createResult=");
            stringBuffer.append(createNewFile);
        }
        if (!file.exists() || !file.canWrite()) {
            stringBuffer.append(",sigFileExists=");
            stringBuffer.append(file.exists());
            stringBuffer.append(",sigFileCanWrite=");
            stringBuffer.append(file.canWrite());
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                stringBuffer.append(",writeSuccess=");
                stringBuffer.append(bArr.length);
                return true;
            } finally {
            }
        } catch (Exception e16) {
            stringBuffer.append(",writeException=");
            stringBuffer.append(util.getThrowableInfo(e16));
            return false;
        }
    }

    public static void a(Context context, String str, StringBuffer stringBuffer, String str2) {
        stringBuffer.append(",printDbFileWhenError");
        a(context, str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        util.LOGI(stringBuffer2, "");
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_DB_ERROR, str2, stringBuffer2);
        aVar.f422858d = true;
        aVar.f422859e = true;
        oicq.wlogin_sdk.report.c.b.a(aVar);
    }

    public synchronized int a(TreeMap treeMap, String str) {
        int a16;
        if (!"tk_file".equals(str) && !"name_file".equals(str)) {
            a16 = 0;
        }
        a16 = a(this.f422875a, treeMap, str, u.E);
        return a16;
    }

    public oicq.wlogin_sdk.report.c.a a(WloginSigInfo wloginSigInfo, int i3, byte[] bArr, long j3, long j16) {
        byte[] bArr2;
        if (j16 != 16) {
            return null;
        }
        if (!(wloginSigInfo == null || (bArr2 = wloginSigInfo._en_A1) == null || bArr2.length == 0)) {
            return null;
        }
        boolean z16 = wloginSigInfo == null;
        boolean z17 = bArr == null || bArr.length == 0;
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ALARM, "a1_empty", "");
        aVar.f422860f = String.valueOf(j3);
        aVar.f422861g.put("isSigInfoEmpty", String.valueOf(z16));
        aVar.f422861g.put("isOldA1Empty", String.valueOf(z17));
        aVar.f422861g.put("ret", String.valueOf(i3));
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0178 A[Catch: all -> 0x01ed, TryCatch #7 {all -> 0x01ed, blocks: (B:24:0x00cf, B:25:0x00d5, B:45:0x0172, B:47:0x0178, B:48:0x017d, B:50:0x018a, B:53:0x01a8, B:74:0x0191, B:76:0x017b), top: B:2:0x0013, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017b A[Catch: all -> 0x01ed, TryCatch #7 {all -> 0x01ed, blocks: (B:24:0x00cf, B:25:0x00d5, B:45:0x0172, B:47:0x0178, B:48:0x017d, B:50:0x018a, B:53:0x01a8, B:74:0x0191, B:76:0x017b), top: B:2:0x0013, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        b bVar;
        Exception exc;
        boolean z16;
        b bVar2;
        SQLiteDatabase writableDatabase;
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = null;
        try {
            try {
                stringBuffer.append("stashDbFileBefore");
                a(context, str, stringBuffer);
                try {
                    if (str.equals("tk_file")) {
                        if (f422873g == null) {
                            f422873g = new b(context, str, null, 1);
                        }
                        bVar2 = f422873g;
                    } else {
                        if (f422874h == null) {
                            f422874h = new b(context, str, null, 1);
                        }
                        bVar2 = f422874h;
                    }
                    writableDatabase = bVar2.getWritableDatabase();
                    try {
                        b(writableDatabase.getPath(), true);
                        writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                        bVar = null;
                    } catch (Exception e16) {
                        e = e16;
                        sQLiteDatabase = writableDatabase;
                        bVar = null;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase = writableDatabase;
                    }
                } catch (Exception e17) {
                    exc = e17;
                    sQLiteDatabase = null;
                    bVar = null;
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase = null;
                }
            } catch (Exception e18) {
                bVar = null;
                exc = e18;
                sQLiteDatabase = null;
                cursor = null;
            } catch (Throwable th7) {
                th = th7;
                sQLiteDatabase = null;
                cursor = null;
            }
            try {
                cursor = writableDatabase.query(str, new String[]{"ID"}, "ID=0", null, null, null, null);
            } catch (Exception e19) {
                sQLiteDatabase = writableDatabase;
                exc = e19;
                cursor = null;
                if (str.equals("tk_file")) {
                }
                stringBuffer.append(",dbException=");
                stringBuffer.append(util.getThrowableInfo(exc));
                try {
                    z16 = a(context, str, bArr, stringBuffer);
                } catch (Exception e26) {
                    stringBuffer.append(",fileException=");
                    stringBuffer.append(util.getThrowableInfo(e26));
                    z16 = false;
                }
                a(context, str, stringBuffer, !z16 ? "write_db_error_file_suc" : "write_db_error_file_error");
                util.printException(exc, "");
                util.LOGI("save ticket to file failed " + exc.getMessage(), "");
                if (!z16) {
                }
            } catch (Throwable th8) {
                th = th8;
                sQLiteDatabase = writableDatabase;
                cursor = null;
            }
            try {
                if (cursor.getCount() == 0) {
                    sQLiteDatabase = writableDatabase;
                    try {
                        sQLiteDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new Object[]{0, new byte[1]});
                    } catch (Exception e27) {
                        e = e27;
                        exc = e;
                        if (str.equals("tk_file")) {
                            f422874h = bVar;
                        } else {
                            f422873g = bVar;
                        }
                        stringBuffer.append(",dbException=");
                        stringBuffer.append(util.getThrowableInfo(exc));
                        z16 = a(context, str, bArr, stringBuffer);
                        a(context, str, stringBuffer, !z16 ? "write_db_error_file_suc" : "write_db_error_file_error");
                        util.printException(exc, "");
                        util.LOGI("save ticket to file failed " + exc.getMessage(), "");
                        if (!z16) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.isOpen();
                            }
                            return 0;
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (sQLiteDatabase == null) {
                            return -1022;
                        }
                        sQLiteDatabase.isOpen();
                        return -1022;
                    }
                } else {
                    sQLiteDatabase = writableDatabase;
                }
                sQLiteDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new Object[]{bArr});
                if (!cursor.isClosed()) {
                    cursor.close();
                }
                sQLiteDatabase.isOpen();
                try {
                    String a16 = a(context, str);
                    if (!TextUtils.isEmpty(a16)) {
                        File file = new File(a16);
                        if (file.exists()) {
                            util.LOGI("delSigFile result = " + file.delete(), "");
                        }
                    }
                } catch (Exception e28) {
                    util.printException(e28, "");
                }
                return 0;
            } catch (Exception e29) {
                e = e29;
                sQLiteDatabase = writableDatabase;
            } catch (Throwable th9) {
                th = th9;
                sQLiteDatabase = writableDatabase;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.isOpen();
            }
            throw th;
        }
    }
}
