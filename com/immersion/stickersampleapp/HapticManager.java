package com.immersion.stickersampleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.immersion.touchsensesdk.HapticMediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.poke.f;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HapticManager {

    /* renamed from: l, reason: collision with root package name */
    private static final String f38060l = f.i() + "poke/immersion_source/libTouchSenseSDK.so";

    /* renamed from: m, reason: collision with root package name */
    private static HapticManager f38061m = new HapticManager(BaseApplicationImpl.sApplication);

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Integer, String> f38064c;

    /* renamed from: d, reason: collision with root package name */
    private HapticMediaPlayer f38065d;

    /* renamed from: e, reason: collision with root package name */
    private Context f38066e;

    /* renamed from: i, reason: collision with root package name */
    private InitHMPRunnable f38070i;

    /* renamed from: a, reason: collision with root package name */
    boolean f38062a = false;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f38063b = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f38068g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38069h = false;

    /* renamed from: j, reason: collision with root package name */
    private ClockTask f38071j = new ClockTask();

    /* renamed from: k, reason: collision with root package name */
    private DisposeTask f38072k = new DisposeTask();

    /* renamed from: f, reason: collision with root package name */
    private b f38067f = new b();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class ClockTask implements Runnable {
        ClockTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ThreadManager.getUIHandler().post(HapticManager.this.f38072k);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class DisposeTask implements Runnable {
        DisposeTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HapticManager.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class InitHMPRunnable implements Runnable {
        InitHMPRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HapticManager.this.f()) {
                HapticManager.this.y();
            }
            HapticManager.this.f38069h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private String f38073a;

        /* renamed from: b, reason: collision with root package name */
        private int f38074b;

        /* renamed from: c, reason: collision with root package name */
        private int f38075c;

        public a(String str, int i3) {
            this.f38073a = str;
            this.f38074b = i3;
        }
    }

    HapticManager(Context context) {
        this.f38070i = null;
        this.f38066e = context;
        this.f38070i = new InitHMPRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        if (QLog.isColorLevel()) {
            QLog.i("HapticManager", 2, "HapticMediaPlayer start check so");
        }
        this.f38068g = false;
        File file = new File(f38060l);
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("HapticManager", 2, "getFilesDir is null");
            }
            return false;
        }
        String str = filesDir.getParent() + "/immer";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(str + File.separator + "libTouchSenseSDK.so");
        if (file3.exists() || (file.exists() && g(file, file3))) {
            try {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("early_qq.android.poke.res_0625", 0);
                String string = sharedPreferences.getString("SoMD5", "");
                long j3 = sharedPreferences.getLong("SoLength", 0L);
                if (QLog.isColorLevel()) {
                    QLog.e("HapticManager", 2, "somd5 : " + string + "\nsolength :" + j3);
                }
                if (!TextUtils.isEmpty(string) && j3 != 0) {
                    if (string.equals(com.tencent.qqprotect.singleupdate.a.d(file3)) && file3.length() == j3) {
                        System.load(file3.getAbsolutePath());
                        if (QLog.isColorLevel()) {
                            QLog.e("HapticManager", 2, "HapticMediaPlayer so load success");
                        }
                        this.f38068g = true;
                        return true;
                    }
                    j(true);
                    file3.delete();
                    return false;
                }
                j(false);
                return false;
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
                }
                this.f38068g = false;
                e16.printStackTrace();
            } catch (UnsatisfiedLinkError e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
                }
                e17.printStackTrace();
                this.f38068g = false;
            }
        }
        j(true);
        return false;
    }

    private void i() {
        HapticMediaPlayer hapticMediaPlayer = this.f38065d;
        if (hapticMediaPlayer != null) {
            hapticMediaPlayer.dispose();
        }
        if (this.f38063b != null) {
            v();
            synchronized (this.f38063b) {
                this.f38063b.clear();
            }
        }
        HashMap<Integer, String> hashMap = this.f38064c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f38065d = null;
        this.f38062a = false;
    }

    private void j(boolean z16) {
        IEarlyDownloadService iEarlyDownloadService;
        PokeResHandler pokeResHandler;
        if (QLog.isColorLevel()) {
            QLog.d("HapticManager", 4, "HapticManager doRequest so zip");
        }
        if (MobileQQ.sProcessId == 1 && (iEarlyDownloadService = (IEarlyDownloadService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IEarlyDownloadService.class, "")) != null && (pokeResHandler = (PokeResHandler) iEarlyDownloadService.getEarlyHandler("qq.android.poke.res_0625")) != null) {
            if (z16) {
                XmlData o16 = pokeResHandler.o();
                o16.loadState = 0;
                com.tencent.mobileqq.earlydownload.a.f(o16, new String[0]);
            }
            pokeResHandler.I(false);
        }
    }

    private a k(String str) {
        synchronized (this.f38063b) {
            for (a aVar : this.f38063b) {
                if (aVar.f38073a.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x00a0 -> B:13:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String l(int i3, String str) {
        InputStream inputStream;
        byte[] bArr = new byte[1024];
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                inputStream = this.f38066e.getResources().openRawResource(i3);
            } catch (FileNotFoundException e17) {
                e = e17;
                inputStream = null;
            } catch (IOException e18) {
                e = e18;
                inputStream = null;
            } catch (ArrayIndexOutOfBoundsException e19) {
                e = e19;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                i3 = 0;
                if (0 != 0) {
                }
                if (i3 == 0) {
                }
            }
            try {
                fileOutputStream = this.f38066e.openFileOutput(str + IAIOHapticApi.HAPT_FILE_EXTENSION, 0);
                for (int available = inputStream.available(); available > 0; available = inputStream.available()) {
                    fileOutputStream.write(bArr, 0, inputStream.read(bArr));
                }
                fileOutputStream.close();
                inputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
                inputStream.close();
            } catch (FileNotFoundException e27) {
                e = e27;
                QLog.e("HapticManager", 2, e, new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return this.f38066e.getFilesDir().getAbsolutePath() + File.separator + str + IAIOHapticApi.HAPT_FILE_EXTENSION;
            } catch (IOException e29) {
                e = e29;
                QLog.e("HapticManager", 2, e, new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e36) {
                        e36.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return this.f38066e.getFilesDir().getAbsolutePath() + File.separator + str + IAIOHapticApi.HAPT_FILE_EXTENSION;
            } catch (ArrayIndexOutOfBoundsException e37) {
                e = e37;
                QLog.e("HapticManager", 2, e, new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e38) {
                        e38.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return this.f38066e.getFilesDir().getAbsolutePath() + File.separator + str + IAIOHapticApi.HAPT_FILE_EXTENSION;
            }
            return this.f38066e.getFilesDir().getAbsolutePath() + File.separator + str + IAIOHapticApi.HAPT_FILE_EXTENSION;
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (IOException e39) {
                    e39.printStackTrace();
                }
            }
            if (i3 == 0) {
                try {
                    i3.close();
                    throw th;
                } catch (IOException e46) {
                    e46.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    public static synchronized HapticManager m() {
        HapticManager hapticManager;
        synchronized (HapticManager.class) {
            hapticManager = f38061m;
        }
        return hapticManager;
    }

    private void n() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.f38064c = hashMap;
        hashMap.put(0, "SUCCESS");
        this.f38064c.put(2, "MISSING_PERMISSIONS");
        this.f38064c.put(1, "INVALID_PARAMETER");
        this.f38064c.put(-1, "INVALID_PARAMETER");
        this.f38064c.put(-2, "INVALID_URI");
        this.f38064c.put(-3, "INVALID_EFFECT");
        this.f38064c.put(-5, "OUT_OF_MEMORY");
        this.f38064c.put(-7, "IO_ERROR");
        this.f38064c.put(-9, "HAPT_NOT_READY");
        this.f38064c.put(-10, "TOO_MANY_EFFECTS");
        this.f38064c.put(-11, "PLAYER_NOT_INITIALIZED");
        this.f38064c.put(3, "INVALID_CREDENTIALS");
        this.f38064c.put(-12, "TOO_MANY_CONCURRENT_EFFECTS");
        this.f38064c.put(-13, "INVALID_STATE");
        this.f38064c.put(-14, "LIB_VERSION_NOT_FOUND");
    }

    private synchronized void o() {
        int playerInfo;
        n();
        try {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("HapticManager", 2, "start create HapticMediaPlayer");
                }
                HapticMediaPlayer create = HapticMediaPlayer.create(this.f38066e, "d449069abbf775f15a17602efed01328f36864b2c5af513c946db5ae4b2e7c03", "Rc#aX%L*", "tkcn.pmtvmimmersion.com", this.f38067f);
                this.f38065d = create;
                if (create != null && (playerInfo = create.getPlayerInfo(40)) != 0) {
                    throw new Exception("Error creating HapticMediaPlayer. Error: " + this.f38064c.get(Integer.valueOf(playerInfo)));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("HapticManager", 2, "HapticMediaPlayer create fail 1");
                    QLog.e("HapticManager", 2, e16.getMessage());
                }
            }
        } catch (UnsatisfiedLinkError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("HapticManager", 2, "HapticMediaPlayer create fail");
                QLog.e("HapticManager", 2, e17.getMessage());
            }
            this.f38068g = false;
        }
    }

    private void p() {
        int[] iArr = {R.raw.f169307b, R.raw.f169306a, R.raw.f169308c, R.raw.f169309d, R.raw.f169310e, R.raw.f169311f, R.raw.f169312g, R.raw.f169313h, R.raw.f169314i};
        String[] strArr = {"chat_item_for_qq666", "chat_item_for_likeplus", "chat_item_for_qqbixin_light", "chat_item_for_qqbixin_strong", "chat_item_for_qqheartbroken", "chat_item_for_qqlikenew", "chat_item_for_qqpokenew", "chat_item_for_qqultnew", "chat_item_for_sticker40"};
        for (int i3 = 0; i3 < 9; i3++) {
            int addResource = this.f38065d.addResource(l(iArr[i3], strArr[i3]), 1);
            synchronized (this.f38063b) {
                this.f38063b.add(new a(strArr[i3], addResource));
            }
        }
    }

    private boolean z(int i3) {
        if (!y() || i3 < 0) {
            return false;
        }
        return true;
    }

    public void d(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("HapticManager", 2, "add effect from sd card, effectName: " + str + ".");
        }
        if (!new File(str2).exists()) {
            QLog.i("HapticManager", 1, "vas poke shock file " + str + " not exists.");
            return;
        }
        synchronized (this.f38063b) {
            Iterator<a> it = this.f38063b.iterator();
            while (it.hasNext()) {
                if (it.next().f38073a.equals(str)) {
                    return;
                }
            }
            HapticMediaPlayer hapticMediaPlayer = this.f38065d;
            if (hapticMediaPlayer != null) {
                int addResource = hapticMediaPlayer.addResource(str2, 1);
                synchronized (this.f38063b) {
                    this.f38063b.add(new a(str, addResource));
                }
                QLog.i("HapticManager", 1, "vas poke shock file " + str + " load success.");
                return;
            }
            QLog.i("HapticManager", 1, "vas poke shock file " + str + " load failure, because mHapticMediaPlayer is null.");
        }
    }

    public void e() {
        if (this.f38062a) {
            return;
        }
        synchronized (this) {
            if (y()) {
                p();
                this.f38062a = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            file2.createNewFile();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    fileInputStream2.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    return true;
                } catch (IOException e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e28) {
                                e28.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } catch (IOException e29) {
                e = e29;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (IOException e36) {
            e = e36;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public synchronized void h() {
        this.f38067f.setConnection(null);
        i();
    }

    public boolean q(int i3) {
        if (y() && this.f38065d.getEffectInfo(i3, 51) == 21) {
            return true;
        }
        return false;
    }

    public void r(int i3) {
        if (!z(i3)) {
            return;
        }
        this.f38065d.pause(i3);
    }

    public int s(String str, int i3) {
        boolean z16 = false;
        int t16 = t(str, i3, false);
        if (t16 > 0) {
            z16 = true;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("effectName", str);
        StatisticCollector.getInstance(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SUCCESS_RATE_FOR_POKE_EFFECT, z16, 0L, 0L, hashMap, "");
        ThreadManager.getSubThreadHandler().removeCallbacks(this.f38071j);
        ThreadManager.getSubThreadHandler().postDelayed(this.f38071j, 60000L);
        return t16;
    }

    public int t(String str, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("TouchEffect", 2, "playEffect: " + str);
        }
        if (!y()) {
            return -1;
        }
        e();
        a k3 = k(str);
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("HapticManager", 2, "No effect added with name " + str);
            }
            return -1;
        }
        v();
        int i16 = k3.f38074b;
        if (i16 < 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TouchEffect", 2, "Invalid resource id for effect with name " + str + "! Error code returned = " + this.f38064c.get(Integer.valueOf(i16)));
            }
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TouchEffect", 2, "resource id:" + i16);
        }
        int play = this.f38065d.play(i16, i3);
        if (play >= 0) {
            k3.f38075c = play;
            if (QLog.isColorLevel()) {
                QLog.d("TouchEffect", 2, "effect id:" + k3.f38075c);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("HapticManager", 2, "Error while playing haptic effect with name " + str + "! Error returned = " + this.f38064c.get(Integer.valueOf(play)));
        }
        return play;
    }

    public void u(int i3) {
        if (!z(i3)) {
            return;
        }
        this.f38065d.resume(i3);
    }

    public void v() {
        if (QLog.isColorLevel()) {
            QLog.d("TouchEffect", 2, "stopAll");
        }
        if (this.f38065d == null) {
            return;
        }
        synchronized (this.f38063b) {
            Iterator<a> it = this.f38063b.iterator();
            while (it.hasNext()) {
                int i3 = it.next().f38075c;
                if (i3 > 0 && q(i3)) {
                    w(i3);
                }
            }
        }
    }

    public void w(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TouchEffect", 2, "stopEffect: " + i3);
        }
        if (this.f38065d == null || !z(i3)) {
            return;
        }
        this.f38065d.stop(i3);
    }

    public void x(int i3, int i16) {
        if (!z(i3) || !q(i3)) {
            return;
        }
        this.f38065d.update(i3, i16);
    }

    public synchronized boolean y() {
        boolean z16;
        z16 = true;
        if (this.f38065d == null) {
            if (!this.f38068g) {
                if (!this.f38069h) {
                    this.f38069h = true;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ThreadManagerV2.post(this.f38070i, 10, null, false);
                    } else {
                        this.f38070i.run();
                    }
                }
            } else {
                o();
            }
        }
        if (this.f38065d == null) {
            z16 = false;
        }
        return z16;
    }
}
