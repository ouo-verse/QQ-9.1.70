package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.doodle.j;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
class LoadDataJob implements Runnable {
    private static final String C = com.tencent.mobileqq.scribble.e.a() + "pclcache" + File.separator;

    /* renamed from: d, reason: collision with root package name */
    public String f178472d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<b> f178473e;

    /* renamed from: f, reason: collision with root package name */
    private int f178474f;

    /* renamed from: h, reason: collision with root package name */
    private int f178475h;

    /* renamed from: i, reason: collision with root package name */
    private int f178476i = 0;

    /* renamed from: m, reason: collision with root package name */
    final int f178477m = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class UnmarshallJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private byte[] f178480d;

        /* renamed from: e, reason: collision with root package name */
        private d f178481e;

        /* renamed from: f, reason: collision with root package name */
        private int f178482f;

        public UnmarshallJob(int i3, byte[] bArr, d dVar) {
            this.f178480d = bArr;
            this.f178481e = dVar;
            this.f178482f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f178481e;
            if (dVar == null) {
                return;
            }
            byte[] bArr = this.f178480d;
            if (bArr == null) {
                dVar.a(this.f178482f, null);
                return;
            }
            try {
                j k3 = LoadDataJob.this.k(bArr);
                if (k3 != null) {
                    this.f178481e.a(this.f178482f, o.f178572k.a(k3));
                    return;
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("UnmarshallJob", 2, "unmarshall  exception:" + LoadDataJob.this.f178472d);
                }
            }
            this.f178481e.a(this.f178482f, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f178483a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f178484b;

        a(Map map, List list) {
            this.f178483a = map;
            this.f178484b = list;
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.d
        public void a(int i3, o oVar) {
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "unmarshall task finish id:" + i3);
            }
            synchronized (this.f178483a) {
                this.f178483a.remove(Integer.valueOf(i3));
                this.f178483a.notifyAll();
            }
            synchronized (this.f178484b) {
                this.f178484b.add(oVar);
                if (this.f178484b.size() == LoadDataJob.this.f178476i) {
                    this.f178484b.notifyAll();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(String str, int i3, g gVar, List<o> list, Map<Integer, Integer> map);

        boolean c(String str);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((o) obj).f178579g - ((o) obj2).f178579g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a(int i3, o oVar);
    }

    public LoadDataJob(String str, int i3, int i16, b bVar) {
        this.f178472d = str;
        this.f178473e = new WeakReference<>(bVar);
        this.f178474f = i3;
        this.f178475h = i16;
    }

    private Map<Integer, Integer> d(List<o> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        Iterator<o> it = list.iterator();
        while (it.hasNext()) {
            int n3 = it.next().n();
            if (n3 > 0) {
                if (!DoodleResHelper.k().l(0, n3)) {
                    hashMap.put(Integer.valueOf(n3), 4);
                } else {
                    hashMap.put(Integer.valueOf(n3), 0);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = C + str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf(95)) + "_dwr";
            if (z16) {
                if (!FileUtils.fileExists(str2)) {
                    return null;
                }
                return str2;
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = C + str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf(95)) + "_prm";
            if (z16) {
                if (!FileUtils.fileExists(str2)) {
                    return null;
                }
                return str2;
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x04c0: MOVE (r4 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:339:0x04bf */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0373 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0510 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0407 A[Catch: all -> 0x04be, TRY_LEAVE, TryCatch #25 {all -> 0x04be, blocks: (B:82:0x0353, B:84:0x0359, B:149:0x0401, B:151:0x0407), top: B:6:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0471 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x044b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0425 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0359 A[Catch: all -> 0x04be, TRY_LEAVE, TryCatch #25 {all -> 0x04be, blocks: (B:82:0x0353, B:84:0x0359, B:149:0x0401, B:151:0x0407), top: B:6:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0399 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v41, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r5v46, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<o> h(String str, b bVar) {
        Throwable th5;
        FileLock fileLock;
        FileLock fileLock2;
        FileInputStream fileInputStream;
        int i3;
        boolean z16;
        FileLock fileLock3;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        ?? r46;
        BufferedInputStream bufferedInputStream4;
        boolean z17;
        int i16;
        BufferedInputStream bufferedInputStream5;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        boolean z18 = true;
        ?? r65 = 0;
        try {
            try {
                this.f178476i = 1;
            } catch (Exception e16) {
                e = e16;
            } catch (OutOfMemoryError e17) {
                e = e17;
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e18) {
                e = e18;
                z16 = true;
                i3 = 0;
                fileInputStream = null;
                fileLock3 = null;
                bufferedInputStream = null;
                try {
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                    }
                    if (fileLock3 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    FileUtils.deleteFile(str);
                    arrayList.clear();
                    r46 = i3;
                    if (r46 != 0) {
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    fileLock2 = fileLock3;
                    z18 = z16;
                    bufferedInputStream2 = bufferedInputStream;
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (Exception e19) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e19);
                            }
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e26) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e26);
                            }
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e27) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e27);
                            }
                        }
                    }
                    if (!z18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "failed to restore drawer, delete file");
                        }
                        FileUtils.deleteFile(str);
                        arrayList.clear();
                        throw th5;
                    }
                    throw th5;
                }
            } catch (OutOfMemoryError e28) {
                e = e28;
                i3 = 0;
                fileInputStream = null;
                fileLock3 = null;
                bufferedInputStream3 = null;
                if (QLog.isColorLevel()) {
                }
                if (fileLock3 != null) {
                }
                if (fileInputStream != null) {
                }
                if (bufferedInputStream3 != null) {
                }
                if (QLog.isColorLevel()) {
                }
                FileUtils.deleteFile(str);
                arrayList.clear();
                r46 = i3;
                if (r46 != 0) {
                }
            } catch (Throwable th8) {
                th = th8;
                th5 = th;
                fileLock2 = null;
                fileInputStream = null;
                bufferedInputStream2 = null;
                if (fileLock2 != null) {
                }
                if (fileInputStream != null) {
                }
                if (bufferedInputStream2 != null) {
                }
                if (!z18) {
                }
            }
            try {
                fileLock3 = fileInputStream.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                if (fileLock3 != null) {
                    try {
                        ?? bufferedInputStream6 = new BufferedInputStream(fileInputStream);
                        try {
                            try {
                                byte[] bArr = new byte[4];
                                int i17 = 0;
                                for (int i18 = 4; bufferedInputStream6.read(bArr) == i18; i18 = 4) {
                                    int b16 = com.tencent.mobileqq.activity.aio.doodle.d.b(bArr, r65);
                                    if (b16 > 0 && b16 < 1024000) {
                                        byte[] bArr2 = new byte[b16];
                                        if (bufferedInputStream6.read(bArr2, r65, b16) != b16) {
                                            try {
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("LoadDataJob", 2, "read drawer parcel data error:" + b16);
                                                }
                                                z17 = r65;
                                                r46 = z17 ? 1 : 0;
                                                bufferedInputStream5 = bufferedInputStream6;
                                            } catch (Exception e29) {
                                                e = e29;
                                                z16 = z18;
                                                i3 = r65;
                                                bufferedInputStream = bufferedInputStream6;
                                                e.printStackTrace();
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (fileLock3 != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (bufferedInputStream != null) {
                                                }
                                                if (QLog.isColorLevel()) {
                                                }
                                                FileUtils.deleteFile(str);
                                                arrayList.clear();
                                                r46 = i3;
                                                if (r46 != 0) {
                                                }
                                            } catch (OutOfMemoryError e36) {
                                                e = e36;
                                                i3 = r65;
                                                bufferedInputStream3 = bufferedInputStream6;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (fileLock3 != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (bufferedInputStream3 != null) {
                                                }
                                                if (QLog.isColorLevel()) {
                                                }
                                                FileUtils.deleteFile(str);
                                                arrayList.clear();
                                                r46 = i3;
                                                if (r46 != 0) {
                                                }
                                            } catch (Throwable th9) {
                                                th5 = th9;
                                                fileLock2 = fileLock3;
                                                bufferedInputStream2 = bufferedInputStream6;
                                                if (fileLock2 != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (bufferedInputStream2 != null) {
                                                }
                                                if (!z18) {
                                                }
                                            }
                                        } else {
                                            UnmarshallJob unmarshallJob = new UnmarshallJob(i17, bArr2, new a(hashMap, arrayList));
                                            synchronized (hashMap) {
                                                if (hashMap.size() > 3) {
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("LoadDataJob", 2, "unmarshall need wait, size:" + hashMap.size());
                                                        }
                                                        hashMap.wait(5000L);
                                                    } catch (Exception e37) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("LoadDataJob", 2, "unmarshall wait taak exception.." + e37);
                                                        }
                                                    }
                                                }
                                            }
                                            if (!bVar.c(this.f178472d)) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("LoadDataJob", 2, "check file, exit");
                                                }
                                                try {
                                                    synchronized (hashMap) {
                                                        Iterator it = hashMap.values().iterator();
                                                        i16 = 0;
                                                        while (it.hasNext()) {
                                                            if (ThreadManagerV2.removeJobFromThreadPool((UnmarshallJob) it.next(), 16)) {
                                                                i16++;
                                                            }
                                                        }
                                                        hashMap.clear();
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("LoadDataJob", 2, "remove count:" + i16);
                                                    }
                                                    if (i16 > 0) {
                                                        synchronized (arrayList) {
                                                            this.f178476i -= i16;
                                                        }
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("LoadDataJob", 2, "new drawercount:" + this.f178476i);
                                                        }
                                                    }
                                                    z17 = true;
                                                    r46 = 1;
                                                    bufferedInputStream5 = bufferedInputStream6;
                                                } catch (Exception e38) {
                                                    e = e38;
                                                    i3 = 1;
                                                    bufferedInputStream4 = bufferedInputStream6;
                                                    z16 = true;
                                                    bufferedInputStream = bufferedInputStream4;
                                                    e.printStackTrace();
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("LoadDataJob", 2, "restore exception, delete file:" + e);
                                                    }
                                                    if (fileLock3 != null) {
                                                        try {
                                                            fileLock3.release();
                                                        } catch (Exception e39) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e39);
                                                            }
                                                        }
                                                    }
                                                    if (fileInputStream != null) {
                                                        try {
                                                            fileInputStream.close();
                                                        } catch (Exception e46) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e46);
                                                            }
                                                        }
                                                    }
                                                    if (bufferedInputStream != null) {
                                                        try {
                                                            bufferedInputStream.close();
                                                        } catch (Exception e47) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e47);
                                                            }
                                                        }
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("LoadDataJob", 2, "failed to restore drawer, delete file");
                                                    }
                                                    FileUtils.deleteFile(str);
                                                    arrayList.clear();
                                                    r46 = i3;
                                                    if (r46 != 0) {
                                                    }
                                                } catch (OutOfMemoryError e48) {
                                                    e = e48;
                                                    i3 = 1;
                                                    bufferedInputStream3 = bufferedInputStream6;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("LoadDataJob", 2, "restore OOM, delete file:" + e.toString());
                                                    }
                                                    if (fileLock3 != null) {
                                                        try {
                                                            fileLock3.release();
                                                        } catch (Exception e49) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e49);
                                                            }
                                                        }
                                                    }
                                                    if (fileInputStream != null) {
                                                        try {
                                                            fileInputStream.close();
                                                        } catch (Exception e56) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e56);
                                                            }
                                                        }
                                                    }
                                                    if (bufferedInputStream3 != null) {
                                                        try {
                                                            bufferedInputStream3.close();
                                                        } catch (Exception e57) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e57);
                                                            }
                                                        }
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("LoadDataJob", 2, "failed to restore drawer, delete file");
                                                    }
                                                    FileUtils.deleteFile(str);
                                                    arrayList.clear();
                                                    r46 = i3;
                                                    if (r46 != 0) {
                                                    }
                                                }
                                            } else {
                                                synchronized (hashMap) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("LoadDataJob", 2, "run on thread pool, taskid:" + i17);
                                                    }
                                                    hashMap.put(Integer.valueOf(i17), unmarshallJob);
                                                    i17++;
                                                }
                                                synchronized (arrayList) {
                                                    this.f178476i++;
                                                }
                                                ThreadManagerV2.excute(unmarshallJob, 16, null, true);
                                                z18 = true;
                                                r65 = 0;
                                            }
                                        }
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.e("LoadDataJob", 2, "read drawer parcel error: len:" + b16);
                                    }
                                    z17 = false;
                                    r46 = 0;
                                    bufferedInputStream5 = bufferedInputStream6;
                                }
                                z17 = true;
                                r46 = 0;
                                bufferedInputStream5 = bufferedInputStream6;
                            } catch (Exception e58) {
                                e = e58;
                                i3 = 0;
                                bufferedInputStream4 = bufferedInputStream6;
                            } catch (OutOfMemoryError e59) {
                                e = e59;
                                i3 = 0;
                                bufferedInputStream3 = bufferedInputStream6;
                            }
                        } catch (Throwable th10) {
                            th5 = th10;
                            fileLock2 = fileLock3;
                            z18 = true;
                            bufferedInputStream2 = bufferedInputStream6;
                        }
                    } catch (Exception e65) {
                        e = e65;
                        i3 = 0;
                        bufferedInputStream4 = null;
                    } catch (OutOfMemoryError e66) {
                        e = e66;
                        i3 = 0;
                        bufferedInputStream3 = null;
                        if (QLog.isColorLevel()) {
                        }
                        if (fileLock3 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (bufferedInputStream3 != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        FileUtils.deleteFile(str);
                        arrayList.clear();
                        r46 = i3;
                        if (r46 != 0) {
                        }
                    } catch (Throwable th11) {
                        th5 = th11;
                        fileLock2 = fileLock3;
                        z18 = true;
                        bufferedInputStream2 = null;
                        if (fileLock2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (bufferedInputStream2 != null) {
                        }
                        if (!z18) {
                        }
                    }
                } else {
                    z17 = true;
                    r46 = 0;
                    bufferedInputStream5 = null;
                }
                try {
                    synchronized (arrayList) {
                        this.f178476i--;
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "unmarshall wait:" + this.f178476i + " - " + arrayList.size() + " bRet:" + z17 + " bcancel:" + r46);
                        }
                        if (this.f178476i > arrayList.size() && z17) {
                            try {
                                arrayList.wait(60000L);
                            } catch (Exception e67) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("LoadDataJob", 2, "unmarshall wait exception.." + e67);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Collections.sort(arrayList, new c());
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("LoadDataJob", 2, "unmarshall finish");
                    }
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (Exception e68) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e68);
                            }
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e69) {
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e69);
                        }
                    }
                    if (bufferedInputStream5 != null) {
                        try {
                            bufferedInputStream5.close();
                        } catch (Exception e75) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e75);
                            }
                        }
                    }
                    if (!z17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "failed to restore drawer, delete file");
                        }
                        FileUtils.deleteFile(str);
                        arrayList.clear();
                    }
                } catch (Exception e76) {
                    e = e76;
                    z16 = z17;
                    i3 = r46 == true ? 1 : 0;
                    bufferedInputStream = bufferedInputStream5;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                    }
                    if (fileLock3 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    FileUtils.deleteFile(str);
                    arrayList.clear();
                    r46 = i3;
                    if (r46 != 0) {
                    }
                } catch (OutOfMemoryError e77) {
                    e = e77;
                    i3 = r46 == true ? 1 : 0;
                    bufferedInputStream3 = bufferedInputStream5;
                    if (QLog.isColorLevel()) {
                    }
                    if (fileLock3 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (bufferedInputStream3 != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    FileUtils.deleteFile(str);
                    arrayList.clear();
                    r46 = i3;
                    if (r46 != 0) {
                    }
                } catch (Throwable th12) {
                    z18 = z17;
                    fileLock2 = fileLock3;
                    th5 = th12;
                    bufferedInputStream2 = bufferedInputStream5;
                    if (fileLock2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (bufferedInputStream2 != null) {
                    }
                    if (!z18) {
                    }
                }
            } catch (Exception e78) {
                e = e78;
                z16 = true;
                i3 = 0;
                fileLock3 = null;
                bufferedInputStream = null;
                e.printStackTrace();
                if (QLog.isColorLevel()) {
                }
                if (fileLock3 != null) {
                }
                if (fileInputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (QLog.isColorLevel()) {
                }
                FileUtils.deleteFile(str);
                arrayList.clear();
                r46 = i3;
                if (r46 != 0) {
                }
            } catch (OutOfMemoryError e79) {
                e = e79;
                i3 = 0;
                fileLock3 = null;
                bufferedInputStream3 = null;
                if (QLog.isColorLevel()) {
                }
                if (fileLock3 != null) {
                }
                if (fileInputStream != null) {
                }
                if (bufferedInputStream3 != null) {
                }
                if (QLog.isColorLevel()) {
                }
                FileUtils.deleteFile(str);
                arrayList.clear();
                r46 = i3;
                if (r46 != 0) {
                }
            } catch (Throwable th13) {
                th5 = th13;
                fileLock2 = null;
            }
            if (r46 != 0) {
                return arrayList;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "cancel restore drawer, return null");
            }
            return null;
        } catch (Throwable th14) {
            th5 = th14;
            fileLock2 = fileLock;
            z18 = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0134 A[Catch: all -> 0x01bc, TRY_LEAVE, TryCatch #16 {all -> 0x01bc, blocks: (B:72:0x012e, B:74:0x0134), top: B:71:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private g i(String str) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        FileLock fileLock;
        ?? r95;
        InputStream inputStream2;
        g gVar;
        FileLock fileLock2 = null;
        InputStream inputStream3 = null;
        fileLock2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z16 = false;
        boolean z17 = true;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    fileLock = fileInputStream.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                    if (fileLock != null) {
                        try {
                            r95 = new BufferedInputStream(fileInputStream);
                        } catch (Exception e16) {
                            e = e16;
                            r95 = 0;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream2 = null;
                            fileLock2 = fileLock;
                            inputStream = inputStream2;
                            if (fileLock2 != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (!z17) {
                            }
                        }
                        try {
                            byte[] bArr = new byte[4];
                            if (r95.read(bArr) == 4) {
                                int b16 = com.tencent.mobileqq.activity.aio.doodle.d.b(bArr, 0);
                                if (b16 > 0 && b16 < 1024000) {
                                    byte[] bArr2 = new byte[b16];
                                    if (r95.read(bArr2, 0, b16) != b16) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e("LoadDataJob", 2, "read param parcel error data error:" + b16);
                                        }
                                        gVar = null;
                                        inputStream3 = r95;
                                    } else {
                                        j k3 = k(bArr2);
                                        if (k3 != null) {
                                            gVar = g.f178540g.a(k3);
                                            z16 = true;
                                            inputStream3 = r95;
                                        }
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.e("LoadDataJob", 2, "read param parcel error: len:" + b16);
                                }
                                gVar = null;
                                inputStream3 = r95;
                            }
                            gVar = null;
                            z16 = true;
                            inputStream3 = r95;
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("LoadDataJob", 2, "restore exception:" + e);
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e18);
                                        }
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e19);
                                        }
                                    }
                                }
                                if (r95 != 0) {
                                    try {
                                        r95.close();
                                    } catch (Exception e26) {
                                        e26.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e26);
                                        }
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.e("LoadDataJob", 2, "failed to restore param, delete file");
                                }
                                FileUtils.deleteFile(str);
                                return null;
                            } catch (Throwable th6) {
                                z17 = false;
                                th = th6;
                                inputStream2 = r95;
                                fileLock2 = fileLock;
                                inputStream = inputStream2;
                                if (fileLock2 != null) {
                                    try {
                                        fileLock2.release();
                                    } catch (Exception e27) {
                                        e27.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e27);
                                        }
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e28) {
                                        e28.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e28);
                                        }
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                        e29.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e29);
                                        }
                                    }
                                }
                                if (!z17) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("LoadDataJob", 2, "failed to restore param, delete file");
                                    }
                                    FileUtils.deleteFile(str);
                                    throw th;
                                }
                                throw th;
                            }
                        }
                    } else {
                        gVar = null;
                        z16 = true;
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e36) {
                            e36.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e36);
                            }
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e37) {
                        e37.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "restore exception when close:" + e37);
                        }
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception e38) {
                            e38.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("LoadDataJob", 2, "restore exception when close:" + e38);
                            }
                        }
                    }
                    if (!z16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("LoadDataJob", 2, "failed to restore param, delete file");
                        }
                        FileUtils.deleteFile(str);
                    }
                    return gVar;
                } catch (Exception e39) {
                    e = e39;
                    fileLock = null;
                    r95 = fileLock;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                    }
                    if (fileLock != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (r95 != 0) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    FileUtils.deleteFile(str);
                    return null;
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = null;
                    if (fileLock2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (!z17) {
                    }
                }
            } catch (Exception e46) {
                e = e46;
                fileInputStream = null;
                fileLock = null;
            } catch (Throwable th8) {
                th = th8;
                fileInputStream = null;
                inputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    private List<o> j(List<m> list, Rect rect) {
        int i3;
        int i16;
        long j3 = 0;
        for (m mVar : list) {
            if (mVar.f() != null) {
                j3 += mVar.f().b();
            }
        }
        if (j3 <= 3000) {
            i3 = 10;
            i16 = 30;
        } else if (j3 <= 20000) {
            i3 = 20;
            i16 = 37;
        } else {
            i3 = 50;
            i16 = 45;
        }
        int i17 = i3;
        int i18 = i16;
        if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "setPathDatas params: totaltime:" + j3 + "  segmentLen:" + i17 + " timeInterval:" + i18);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<m> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new o(it.next(), rect.width(), rect.height(), this.f178474f, this.f178475h, i17, i18, 1.0f));
        }
        Collections.sort(arrayList, new c());
        return arrayList;
    }

    public j.a g(k kVar) {
        j jVar = new j(RFixConstants.MD5_FILE_BUF_LENGTH);
        kVar.a(jVar, 0);
        return jVar.b();
    }

    public j k(byte[] bArr) {
        j jVar = new j(0);
        jVar.j(bArr, 0, bArr.length);
        return jVar;
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0164: MOVE (r9 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:357), block:B:103:0x0164 */
    public void l(com.tencent.mobileqq.activity.aio.doodle.g r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.l(com.tencent.mobileqq.activity.aio.doodle.g, java.lang.String):void");
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x018b: MOVE (r11 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:396), block:B:111:0x018b */
    public boolean m(java.util.List<com.tencent.mobileqq.activity.aio.doodle.o> r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.m(java.util.List, java.lang.String):boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        g gVar;
        List<o> list;
        g gVar2;
        List<o> list2;
        if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "run  begin");
        }
        File file = new File(C);
        if (!file.exists()) {
            file.mkdirs();
        }
        WeakReference<b> weakReference = this.f178473e;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            QLog.d("LoadDataJob", 2, "mListener == null");
            return;
        }
        String str = this.f178472d;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "file == null");
            }
            bVar.a(null, 4, null, null, null);
            return;
        }
        if (!bVar.c(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "onCheck  false");
                return;
            }
            return;
        }
        String e16 = e(this.f178472d, true);
        String f16 = f(this.f178472d, true);
        if (!bVar.c(this.f178472d)) {
            return;
        }
        if (!TextUtils.isEmpty(e16) && !TextUtils.isEmpty(f16)) {
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run  read parcel begin");
            }
            list = h(e16, bVar);
            if (bVar.c(this.f178472d) && list != null) {
                for (o oVar : list) {
                    if (oVar != null && oVar.q()) {
                        oVar.t(0, 0, this.f178474f, this.f178475h);
                    } else {
                        FileUtils.deleteFile(e16);
                        list = null;
                        break;
                    }
                }
                gVar = i(f16);
                if (QLog.isColorLevel()) {
                    QLog.d("LoadDataJob", 2, "run  read parcel end");
                }
            } else {
                return;
            }
        } else {
            gVar = null;
            list = null;
        }
        if (!bVar.c(this.f178472d)) {
            return;
        }
        if (list != null && gVar != null && list.size() != 0) {
            gVar2 = gVar;
            list2 = list;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run load file begin:");
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mobileqq.activity.aio.doodle.b h16 = com.tencent.mobileqq.activity.aio.doodle.d.h(this.f178472d);
            if (h16 == null) {
                bVar.a(this.f178472d, 4, null, null, null);
                return;
            }
            final g b16 = h16.b();
            if (!bVar.c(this.f178472d)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run setpathdata ");
            }
            final List<o> j3 = j(h16.c(), h16.b().d());
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!bVar.c(this.f178472d)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run load data time:" + (currentTimeMillis2 - currentTimeMillis));
            }
            if (currentTimeMillis2 - currentTimeMillis > 100) {
                if (QLog.isColorLevel()) {
                    QLog.d("LoadDataJob", 2, "need cache:");
                }
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "run write parcel begin:");
                        }
                        LoadDataJob loadDataJob = LoadDataJob.this;
                        loadDataJob.l(b16, loadDataJob.f(loadDataJob.f178472d, false));
                        LoadDataJob loadDataJob2 = LoadDataJob.this;
                        if (loadDataJob2.m(j3, loadDataJob2.e(loadDataJob2.f178472d, false))) {
                            Iterator it = j3.iterator();
                            while (it.hasNext()) {
                                ((o) it.next()).d();
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("LoadDataJob", 2, "run write parcel end:");
                        }
                    }
                }, 5, null, false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run load file end:");
            }
            gVar2 = b16;
            list2 = j3;
        }
        if (!bVar.c(this.f178472d)) {
            return;
        }
        bVar.a(this.f178472d, 0, gVar2, list2, d(list2));
        if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "run  end");
        }
    }
}
