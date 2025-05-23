package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.hb.aio.elem.a;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f311353a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.cache.api.collection.a<String, f> f311354b;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<d> f311361i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f311362j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f311363k;

    /* renamed from: n, reason: collision with root package name */
    long f311366n;

    /* renamed from: p, reason: collision with root package name */
    IndividualRedPacketManager f311368p;

    /* renamed from: c, reason: collision with root package name */
    public b f311355c = new b();

    /* renamed from: d, reason: collision with root package name */
    public b f311356d = new b();

    /* renamed from: e, reason: collision with root package name */
    public e f311357e = new e();

    /* renamed from: f, reason: collision with root package name */
    public String f311358f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f311359g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f311360h = null;

    /* renamed from: l, reason: collision with root package name */
    public Map<String, List<String>> f311364l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    AtomicBoolean f311365m = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    public AtomicBoolean f311367o = new AtomicBoolean(false);

    /* renamed from: q, reason: collision with root package name */
    CallBacker f311369q = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends CallBacker {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            String str4;
            if (16 == j3 && !TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel() || i3 != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("callBacker, from:");
                    sb5.append(str3);
                    sb5.append(",httpCode=");
                    sb5.append(i16);
                    sb5.append(",errorCode:");
                    sb5.append(i3);
                    sb5.append(", scid:");
                    sb5.append(str);
                    sb5.append(", cfgScid:");
                    sb5.append(str2);
                    if (i3 != 0) {
                        str4 = ", Error ";
                    } else {
                        str4 = ", ok ";
                    }
                    sb5.append(str4);
                    QLog.d("IndividualRedPacketResDownloader", 2, sb5.toString());
                }
                try {
                    boolean u16 = w.this.u(str, i3);
                    if (QLog.isColorLevel()) {
                        QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + str3 + ",httpCode=" + i16 + ",errorCode:" + i3 + ", scid:" + str + ", cfgScid:" + str2 + ", downloadOK=" + u16);
                    }
                    if (!TextUtils.isEmpty(str3) && str3.startsWith("silent_download.redbag")) {
                        w.this.G();
                    }
                } catch (Exception e16) {
                    QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + str3 + ",httpCode=" + i16 + ",errorCode:" + i3 + ", scid:" + str + ", cfgScid:" + str2, e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends e {

        /* renamed from: g, reason: collision with root package name */
        public String f311371g;

        /* renamed from: h, reason: collision with root package name */
        public String f311372h = "";

        /* renamed from: i, reason: collision with root package name */
        public int f311373i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f311374j = 100;

        /* renamed from: k, reason: collision with root package name */
        public int f311375k = 20;

        public String a() {
            if (TextUtils.isEmpty(this.f311371g)) {
                return "";
            }
            return this.f311371g;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends e {

        /* renamed from: g, reason: collision with root package name */
        public int f311376g;

        /* renamed from: h, reason: collision with root package name */
        public Rect f311377h;

        /* renamed from: i, reason: collision with root package name */
        public a.C8458a f311378i;

        /* renamed from: j, reason: collision with root package name */
        public String f311379j;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public long f311380a;

        /* renamed from: b, reason: collision with root package name */
        public String f311381b;

        /* renamed from: c, reason: collision with root package name */
        public String f311382c;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f311383a;

        /* renamed from: b, reason: collision with root package name */
        public String f311384b;

        /* renamed from: c, reason: collision with root package name */
        public String f311385c;

        /* renamed from: d, reason: collision with root package name */
        public int f311386d;

        /* renamed from: e, reason: collision with root package name */
        public int f311387e;

        /* renamed from: f, reason: collision with root package name */
        public int f311388f;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class f {

        /* renamed from: h, reason: collision with root package name */
        public static int f311389h = 2;

        /* renamed from: i, reason: collision with root package name */
        public static int f311390i = 1;

        /* renamed from: a, reason: collision with root package name */
        public String f311391a;

        /* renamed from: b, reason: collision with root package name */
        public c f311392b;

        /* renamed from: c, reason: collision with root package name */
        public c f311393c;

        /* renamed from: d, reason: collision with root package name */
        public c f311394d;

        /* renamed from: e, reason: collision with root package name */
        public int f311395e;

        /* renamed from: f, reason: collision with root package name */
        public int f311396f;

        /* renamed from: g, reason: collision with root package name */
        public int f311397g;
    }

    public w(QQAppInterface qQAppInterface, IndividualRedPacketManager individualRedPacketManager) {
        this.f311353a = qQAppInterface;
        this.f311356d.f311371g = "";
        this.f311368p = individualRedPacketManager;
        this.f311363k = individualRedPacketManager.n().getBoolean("mall_entrance_switch", false);
        this.f311362j = individualRedPacketManager.n().getBoolean("redpacket_is_show_switch", false);
        this.f311354b = new com.tencent.cache.api.collection.a<>(Business.AIO, "RedPacketTemplateInfo", 100);
        this.f311357e.f311388f = 8;
        this.f311356d.f311388f = 26;
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
        if (iVasQuickUpdateService != null) {
            iVasQuickUpdateService.addCallBacker(this.f311369q);
        }
    }

    private static boolean A(String str, String str2, File file, boolean z16, boolean z17) {
        if (!z16) {
            File file2 = new File(str2);
            QLog.d("IndividualRedPacketResDownloader", 1, "uncompressZip DownloaderFactory.unzipResource, themeZipPath:" + str);
            z17 = DownloaderFactory.X(file, file2, false);
        }
        if (!z16 && !z17) {
            FileUtils.deleteFile(str);
            QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip result false");
        }
        return z17;
    }

    @Nullable
    private JSONObject D(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("timestamp", 1L);
        if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "initAllConfigJson timestamp=" + optLong + ", mJsonTimestamp:" + this.f311366n);
        }
        if (optLong <= this.f311366n) {
            return null;
        }
        this.f311366n = optLong;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson, null == data, timestamp=" + optLong + ", mJsonTimestamp:" + this.f311366n);
            return null;
        }
        return optJSONObject;
    }

    private boolean E(File file, File file2, File file3, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
            return true;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("templateList");
        if (optJSONArray == null) {
            QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
            return true;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            f l3 = l(optJSONArray.optJSONObject(i3), false);
            if (!x(l3)) {
                String str = l3.f311391a + "_" + l3.f311396f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(file.getAbsolutePath());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(str);
                String sb6 = sb5.toString();
                c cVar = l3.f311392b;
                if (cVar.f311388f == 19) {
                    sb6 = sb6 + "_zip";
                }
                if (new File(sb6).exists()) {
                    String[] strArr = {sb6, file2.getAbsolutePath() + str2 + str, file3.getAbsolutePath() + str2 + str};
                    c cVar2 = l3.f311393c;
                    c cVar3 = l3.f311394d;
                    String[] strArr2 = {IndividualRedPacketManager.x(cVar.f311384b, cVar.f311383a, cVar.f311388f, cVar.f311386d, 0), IndividualRedPacketManager.x(cVar2.f311384b, cVar2.f311383a, cVar2.f311388f, cVar2.f311386d, 0), IndividualRedPacketManager.x(cVar3.f311384b, cVar3.f311383a, cVar3.f311388f, cVar3.f311386d, 0)};
                    int i16 = 0;
                    while (true) {
                        if (i16 >= 3) {
                            break;
                        }
                        if (!FileUtils.copyFile(strArr[i16], strArr2[i16])) {
                            if (QLog.isColorLevel()) {
                                QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + strArr[i16] + ", newPath:" + strArr2[i16]);
                            }
                        } else {
                            i16++;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void F(JSONArray jSONArray) {
        if (jSONArray != null) {
            n(jSONArray);
        } else if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
        }
    }

    private void H(JSONObject jSONObject, boolean z16, f fVar) {
        JSONArray optJSONArray = jSONObject.optJSONArray("aioChar");
        if (optJSONArray != null && optJSONArray.length() >= 4) {
            fVar.f311392b.f311377h = new Rect(optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(0) + optJSONArray.optInt(2), optJSONArray.optInt(1) + optJSONArray.optInt(3));
            fVar.f311392b.f311376g = optJSONArray.optInt(2);
        } else {
            QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioChar error,name:" + fVar.f311392b.f311383a + ", id:" + fVar.f311391a + ", isV710:" + z16);
            fVar.f311392b.f311377h = new Rect(1, 1, 1, 1);
            fVar.f311392b.f311376g = 1;
            fVar.f311395e = f.f311390i;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("packetChar");
        if (optJSONArray2 != null && optJSONArray2.length() >= 4) {
            fVar.f311393c.f311377h = new Rect(optJSONArray2.optInt(0), optJSONArray2.optInt(1), optJSONArray2.optInt(0) + optJSONArray2.optInt(2), optJSONArray2.optInt(1) + optJSONArray2.optInt(3));
            fVar.f311393c.f311376g = optJSONArray2.optInt(2);
        } else {
            QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson packetChar error,name:" + fVar.f311392b.f311383a + ", id:" + fVar.f311391a + ", isV710:" + z16);
            fVar.f311393c.f311377h = new Rect(1, 1, 1, 1);
            fVar.f311393c.f311376g = 1;
            fVar.f311395e = f.f311390i;
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("sendChar");
        if (optJSONArray3 != null && optJSONArray3.length() >= 4) {
            fVar.f311394d.f311377h = new Rect(optJSONArray3.optInt(0), optJSONArray3.optInt(1), optJSONArray3.optInt(0) + optJSONArray3.optInt(2), optJSONArray3.optInt(1) + optJSONArray3.optInt(3));
            fVar.f311394d.f311376g = optJSONArray3.optInt(2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + fVar.f311392b.f311383a + ", id:" + fVar.f311391a + ", isV710:" + z16);
        }
    }

    public static boolean I(String str, String str2) {
        boolean z16;
        boolean z17;
        int i3;
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            if (QLog.isColorLevel()) {
                QLog.d("IndividualRedPacketResDownloader", 2, "uncompressZip zipFile.exists(), zipFile.length()=" + file.length());
            }
            try {
                FileUtils.uncompressZip(str, str2, false);
                File file2 = new File(str2);
                if (file2.exists()) {
                    i3 = ThemeUtil.getFileNumInFile(file2);
                } else {
                    i3 = 0;
                }
            } catch (Exception e16) {
                QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip FileUtils.uncompressZip IOException:" + e16.getMessage());
            }
            if (i3 > 0) {
                z17 = true;
                z16 = A(str, str2, file, z17, false);
            } else {
                QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip fileNum == 0");
                z17 = false;
                z16 = A(str, str2, file, z17, false);
            }
        } else {
            z16 = false;
            z17 = false;
        }
        if (z17 || z16) {
            return true;
        }
        return false;
    }

    private void K(File file, String str) {
        if (!TextUtils.isEmpty(this.f311356d.f311372h) && !str.equals(this.f311368p.n().getString("special_unzip_version_key", ""))) {
            File file2 = new File(IndividualRedPacketManager.x(null, null, 26, 0, 0));
            if (I(file2.getAbsolutePath(), IndividualRedPacketManager.p(2) + "images")) {
                this.f311368p.n().edit().putString("special_unzip_version_key", str).commit();
            } else if (!file2.exists() && file != null) {
                file.delete();
            }
        }
    }

    private void b() {
        if (this.f311355c.f311387e == 2 && this.f311357e.f311387e == 2 && this.f311368p.H()) {
            if (QLog.isColorLevel()) {
                QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
            }
            this.f311368p.K(this.f311355c);
        }
    }

    private boolean d() {
        IndividualRedPacketManager individualRedPacketManager;
        if (this.f311353a == null || (individualRedPacketManager = this.f311368p) == null || individualRedPacketManager.G.get()) {
            return true;
        }
        return false;
    }

    private void e(boolean z16, ArrayList<d> arrayList, int i3) {
        ArrayList<d> arrayList2 = this.f311361i;
        if (arrayList2 == null) {
            this.f311361i = arrayList;
        } else {
            arrayList2.addAll(arrayList);
        }
        if (!this.f311365m.get() && ((1 == i3 || z16) && this.f311368p.H())) {
            G();
        } else {
            this.f311361i = null;
        }
    }

    @NotNull
    private ArrayList<d> g(JSONObject jSONObject, boolean z16) {
        int i3;
        int i16;
        Object valueOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("isPreload");
        int i17 = 0;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            int optInt = optJSONObject.optInt("isPreload", 5);
            i16 = optJSONObject.optInt("preloadTotal", 50);
            i3 = optInt;
        } else {
            i3 = 5;
            i16 = 50;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("templateIdList");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkAndDownloadBeforeUse ,emergencyDownload:");
            sb5.append(z16);
            sb5.append(", templateIdList:");
            if (optJSONArray2 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(optJSONArray2.length());
            }
            sb5.append(valueOf);
            QLog.d("IndividualRedPacketResDownloader", 2, sb5.toString());
        }
        ArrayList<d> arrayList = new ArrayList<>();
        if (optJSONArray2 != null) {
            i17 = j(i16, 0, i3, optJSONArray2, arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse finish! size = " + this.f311354b.h() + ", preloadSize=" + i17 + ", totalCanPreload=" + i3);
        }
        F(jSONObject.optJSONArray("vipRedPacketURL"));
        return arrayList;
    }

    private JSONObject h(JSONObject jSONObject) {
        if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
        }
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(ClubContentJsonTask.iRedPacketJSONTask.jsonUrl, new File(this.f311353a.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.iRedPacketJSONTask.jsonName));
        gVar.Q = true;
        if (DownloaderFactory.o(gVar, this.f311353a) == 0) {
            return ClubContentJsonTask.getJsonFromLocalFile(this.f311353a, ClubContentJsonTask.iRedPacketJSONTask, false);
        }
        QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + ClubContentJsonTask.iRedPacketJSONTask.jsonUrl);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject i(boolean z16, boolean z17, String str, File file) {
        JSONObject jSONObject;
        String str2;
        if (file != null && file.exists()) {
            try {
                jSONObject = new JSONObject(FileUtils.readFileContent(file));
            } catch (Throwable th5) {
                QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + file.getAbsolutePath(), th5);
            }
            if (jSONObject != null) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("initJsonBySCID null == resJson, scid=");
                    sb5.append(str);
                    sb5.append(", isAfterDownload:");
                    sb5.append(z16);
                    sb5.append(", isInit");
                    sb5.append(z17);
                    sb5.append(", file=");
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    } else {
                        str2 = "null";
                    }
                    sb5.append(str2);
                    QLog.e("IndividualRedPacketResDownloader", 2, sb5.toString());
                }
                return null;
            }
            return jSONObject;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }

    private int j(int i3, int i16, int i17, JSONArray jSONArray, ArrayList<d> arrayList) {
        for (int i18 = 0; i18 < jSONArray.length(); i18++) {
            String optString = jSONArray.optString(i18);
            if (!TextUtils.isEmpty(optString)) {
                f e16 = this.f311354b.e(optString);
                synchronized (this.f311364l) {
                    if (this.f311364l.containsKey(optString)) {
                        w(false, optString, e16);
                    }
                }
            }
        }
        return i16;
    }

    private f k(String str, f fVar) {
        if (fVar == null || z(fVar.f311392b) || z(fVar.f311393c) || z(fVar.f311394d)) {
            return B(str);
        }
        return fVar;
    }

    private void n(JSONArray jSONArray) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            String optString = optJSONObject.optString("name");
            String optString2 = optJSONObject.optString("url", null);
            if ("aioTail".equals(optString)) {
                this.f311359g = optString2;
            } else if ("personalityMall".equals(optString)) {
                this.f311358f = optString2;
            } else if ("tencentPay".equals(optString)) {
                this.f311360h = optString2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse mAioTailURL:" + this.f311359g + ", mTencentPayURL:" + this.f311360h + ", mPersonalityMallURL:" + this.f311358f);
        }
    }

    private void o(String str, boolean z16) {
        String str2;
        f B;
        String s16 = IndividualRedPacketManager.s(str);
        if (z16 && (B = B(s16)) != null && this.f311368p != null) {
            c cVar = B.f311392b;
            String str3 = IndividualRedPacketManager.x(s16, null, cVar.f311388f, cVar.f311386d, 0) + "_dir2";
            VasUpdateUtil.safeDeleteFile(new File(str3));
            if (QLog.isColorLevel()) {
                QLog.d("IndividualRedPacketResDownloader", 2, "callBacker delete animateDir: " + str3);
            }
            synchronized (this.f311364l) {
                if (this.f311364l.containsKey(s16)) {
                    List<String> list = this.f311364l.get(s16);
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        String str4 = list.get(i3);
                        if (!TextUtils.isEmpty(str4)) {
                            this.f311368p.J(str4, B.f311392b.f311388f);
                            this.f311368p.J(str4 + "_tp", B.f311393c.f311388f);
                            this.f311368p.J(str4 + "_send", B.f311394d.f311388f);
                        }
                    }
                    this.f311364l.remove(B.f311391a);
                }
            }
        }
        QQAppInterface qQAppInterface = this.f311353a;
        String str5 = IndividualRedPacketManager.f194760e0;
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, str5, str2, "1", s16);
    }

    private void r(String str, boolean z16, int i3, e eVar, int i16) {
        eVar.f311387e = i3;
        if (z16) {
            q(true, false, str, new File(IndividualRedPacketManager.x(null, null, i16, 0, 0)));
        }
    }

    private void s(String str, boolean z16) {
        if (!VasNormalToggle.VAS_DELIST_RED_PACKAGE.isEnable(false) && z16) {
            q(true, false, str, VasUpdateUtil.getFileFromLocal(this.f311353a, 16L, VasUpdateConstants.SCID_REDPACKET_300CHAR, BaseApplication.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + VasUpdateConstants.SCID_REDPACKET_300CHAR, false, this.f311369q));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str, int i3) {
        boolean z16;
        int i16;
        String str2;
        String str3;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 2;
        } else {
            i16 = -1;
        }
        if (VasUpdateConstants.SCID_REDPACKET_CONFIG.equals(str)) {
            p(true, false);
        } else if (VasUpdateConstants.SCID_REDPACKET_300CHAR.equals(str)) {
            s(str, z16);
            QQAppInterface qQAppInterface = this.f311353a;
            String str4 = IndividualRedPacketManager.f194760e0;
            if (z16) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, str4, str3, "1", "");
        } else if (VasUpdateConstants.SCID_REDPACKET_FONT_ZIP.equals(str)) {
            r(str, z16, i16, this.f311357e, 21);
            QQAppInterface qQAppInterface2 = this.f311353a;
            String str5 = IndividualRedPacketManager.f194760e0;
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            ReportController.o(qQAppInterface2, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, str5, str2, "1", "");
        } else if (VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP.equals(str)) {
            r(str, z16, i16, this.f311356d, 25);
        } else if (str.startsWith(VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP)) {
            o(str, z16);
        }
        return z16;
    }

    private boolean v(JSONObject jSONObject, boolean z16) throws ParseException, JSONException {
        boolean z17;
        String optString = jSONObject.optString("time");
        boolean z18 = true;
        if (!TextUtils.isEmpty(optString)) {
            if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(optString).getTime() - NetConnInfoCenter.getServerTimeMillis() < 172800000) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        SharedPreferences n3 = this.f311368p.n();
        SharedPreferences.Editor edit = n3.edit();
        if (jSONObject.has("androidShowSwitch")) {
            if (jSONObject.getInt("androidShowSwitch") == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f311362j = z17;
        }
        if (jSONObject.has("androidEntrySwitch")) {
            if (jSONObject.getInt("androidEntrySwitch") != 1) {
                z18 = false;
            }
            this.f311363k = z18;
        }
        if (this.f311362j != n3.getBoolean("redpacket_is_show_switch", false) || this.f311363k != n3.getBoolean("mall_entrance_switch", false)) {
            edit.putBoolean("redpacket_is_show_switch", this.f311362j);
            edit.putBoolean("mall_entrance_switch", this.f311363k);
            edit.commit();
        }
        return z16;
    }

    private boolean w(boolean z16, String str, f fVar) {
        f k3 = k(str, fVar);
        if (k3 != null && z(k3.f311392b) && z(k3.f311393c) && z(k3.f311394d)) {
            List<String> list = this.f311364l.get(str);
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str2 = list.get(i3);
                if (!TextUtils.isEmpty(str2)) {
                    this.f311368p.J(str2, k3.f311392b.f311388f);
                    this.f311368p.J(str2 + "_tp", k3.f311393c.f311388f);
                    this.f311368p.J(str2 + "_send", k3.f311394d.f311388f);
                }
            }
            this.f311364l.remove(str);
            return z16;
        }
        f(16L, str, null, "isInDownloadArr");
        return true;
    }

    private boolean x(f fVar) {
        if (fVar == null || fVar.f311392b == null || fVar.f311393c == null || fVar.f311394d == null || new File(IndividualRedPacketManager.x(fVar.f311391a, null, 0, 0, 0)).exists()) {
            return true;
        }
        return false;
    }

    private boolean y(File file, File file2, File file3, boolean z16) {
        if (file.exists() && file.isDirectory() && file2.exists() && file2.isDirectory() && file3.exists() && file3.isDirectory()) {
            String[] list = file.list();
            String[] list2 = file2.list();
            String[] list3 = file3.list();
            if (list.length > 0 && list2.length > 0 && list3.length > 0) {
                return true;
            }
            return z16;
        }
        return z16;
    }

    public static boolean z(e eVar) {
        int i3;
        File file;
        if (eVar == null || (i3 = eVar.f311388f) == 0) {
            return false;
        }
        String x16 = IndividualRedPacketManager.x(eVar.f311384b, eVar.f311383a, i3, eVar.f311386d, 0);
        if (TextUtils.isEmpty(x16)) {
            file = null;
        } else {
            file = new File(x16);
        }
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public f B(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(IndividualRedPacketManager.x(str, null, 0, 0, 0));
        if (file.exists()) {
            try {
                f l3 = l(new JSONObject(FileUtils.readFileContent(file)), true);
                if (l3 != null) {
                    this.f311354b.f(l3.f311391a, l3);
                }
                return l3;
            } catch (Throwable th5) {
                QLog.e("IndividualRedPacketResDownloader", 2, "loadPacketJson ,filePath:" + file.getAbsolutePath(), th5);
            }
        }
        return null;
    }

    public void C() {
        QQAppInterface qQAppInterface = this.f311353a;
        if (qQAppInterface != null) {
            ((IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.f311369q);
        }
        this.f311353a = null;
        this.f311354b.d();
        this.f311368p = null;
    }

    synchronized void G() {
        ArrayList<d> arrayList;
        d remove;
        if (this.f311353a != null && this.f311368p != null && (arrayList = this.f311361i) != null && arrayList.size() > 0) {
            if (VasNormalToggle.VAS_DELIST_RED_PACKAGE.isEnable(false)) {
                return;
            }
            try {
                remove = this.f311361i.remove(0);
            } catch (Exception e16) {
                QLog.d("IndividualRedPacketResDownloader", 2, "preDownload, err=" + e16.getMessage());
            }
            if (remove == null) {
                G();
            } else {
                if (new File(remove.f311382c).exists()) {
                    G();
                    return;
                }
                IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) this.f311353a.getRuntimeService(IVasQuickUpdateService.class, "");
                iVasQuickUpdateService.addCallBacker(this.f311369q);
                iVasQuickUpdateService.downloadItem(remove.f311380a, remove.f311381b, "silent_download.redbag");
            }
        }
    }

    public void J() {
        if (d()) {
            return;
        }
        try {
            if (this.f311368p.n().getBoolean("res_version_has_updated", false)) {
                return;
            }
            File file = new File(IndividualRedPacketManager.p(3) + "10029_0");
            File file2 = new File(IndividualRedPacketManager.x(null, null, 8, 0, 0));
            if (file.exists() && !file2.exists()) {
                file.renameTo(file2);
            }
            StringBuilder sb5 = new StringBuilder();
            String str = AppConstants.SDCARD_PATH;
            sb5.append(str);
            sb5.append("RedPacket/templateAIO");
            File file3 = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
            File file4 = new File(VFSAssistantUtils.getSDKPrivatePath(str + "RedPacket/templateTENPAY"));
            File file5 = new File(VFSAssistantUtils.getSDKPrivatePath(str + "RedPacket/templateSEND"));
            if (!y(file3, file4, file5, false)) {
                this.f311368p.n().edit().putBoolean("res_version_has_updated", true).commit();
                return;
            }
            JSONObject jsonFromLocalFile = ClubContentJsonTask.getJsonFromLocalFile(this.f311353a, ClubContentJsonTask.iRedPacketJSONTask, false);
            if (jsonFromLocalFile == null) {
                jsonFromLocalFile = h(jsonFromLocalFile);
            }
            if (jsonFromLocalFile == null) {
                QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
                return;
            }
            if (E(file3, file4, file5, jsonFromLocalFile)) {
                return;
            }
            SharedPreferences.Editor edit = this.f311368p.n().edit();
            edit.putBoolean("res_version_has_updated", true);
            edit.commit();
            VasUpdateUtil.safeDeleteFile(file3);
            VasUpdateUtil.safeDeleteFile(file4);
            VasUpdateUtil.safeDeleteFile(file5);
        } catch (Throwable th5) {
            QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion TODO v7.10 updateErr:" + th5.toString());
        }
    }

    public JSONObject c(File file, JSONObject jSONObject) {
        if (file != null && file.exists()) {
            try {
                return new JSONObject(FileUtils.readFileContent(file));
            } catch (Throwable th5) {
                QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + file.getAbsolutePath(), th5);
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public synchronized void f(long j3, String str, String str2, String str3) {
        String x16;
        if (this.f311353a != null && 0 != j3 && !TextUtils.isEmpty(str)) {
            if (VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP.equals(str)) {
                x16 = IndividualRedPacketManager.x(null, null, 11, 0, 0);
            } else {
                File file = new File(IndividualRedPacketManager.x(str, null, 24, 0, 0));
                boolean exists = file.exists();
                if (QLog.isColorLevel()) {
                    QLog.d("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit, id: " + str + " exists: " + exists);
                }
                if (exists) {
                    VasUpdateUtil.safeDeleteFile(file);
                }
                x16 = IndividualRedPacketManager.x(str, null, 0, 0, 0);
                str = VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP + str;
            }
            VasUpdateUtil.getFileFromLocal(this.f311353a, j3, str, x16, true, this.f311369q);
            VasCommonReporter.getHistoryFeature("individualRed").setValue2(str3).report();
            return;
        }
        QLog.e("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit err filePath, bid=" + j3 + ",id:" + str);
    }

    f l(JSONObject jSONObject, boolean z16) {
        String str;
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("id");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            f fVar = new f();
            c cVar = new c();
            fVar.f311392b = cVar;
            cVar.f311388f = 2;
            c cVar2 = new c();
            fVar.f311393c = cVar2;
            cVar2.f311388f = 3;
            c cVar3 = new c();
            fVar.f311394d = cVar3;
            cVar3.f311388f = 14;
            fVar.f311391a = optString;
            c cVar4 = fVar.f311392b;
            cVar4.f311384b = optString;
            fVar.f311393c.f311384b = optString;
            cVar3.f311384b = optString;
            cVar4.f311383a = jSONObject.optString("name");
            c cVar5 = fVar.f311393c;
            c cVar6 = fVar.f311392b;
            cVar5.f311383a = cVar6.f311383a;
            fVar.f311394d.f311383a = cVar6.f311383a;
            fVar.f311395e = jSONObject.optInt("customWord", f.f311390i);
            fVar.f311397g = jSONObject.optInt("fontTypeId", 1);
            int optInt = jSONObject.optInt("version", 0);
            fVar.f311396f = optInt;
            fVar.f311392b.f311386d = optInt;
            fVar.f311393c.f311386d = optInt;
            fVar.f311394d.f311386d = optInt;
            if (fVar.f311395e == f.f311389h) {
                H(jSONObject, z16, fVar);
            } else {
                String optString2 = jSONObject.optString("aioPngZip", null);
                if (!TextUtils.isEmpty(optString2) && optString2.indexOf("http") >= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioPngZip ,name=" + fVar.f311392b.f311383a + ", id:" + fVar.f311391a + ", url:" + optString2 + ", isV710:" + z16);
                    }
                    a.C8458a c8458a = new a.C8458a();
                    c8458a.f277234c = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL, 100);
                    c8458a.f277233b = jSONObject.optInt("flameCount", 0);
                    c cVar7 = fVar.f311392b;
                    cVar7.f311378i = c8458a;
                    cVar7.f311379j = optString2;
                    cVar7.f311388f = 19;
                }
            }
            c cVar8 = fVar.f311392b;
            if (cVar8.f311378i == null) {
                str = jSONObject.optString("aioImgUrl", "");
            } else {
                str = cVar8.f311379j;
            }
            cVar8.f311385c = str;
            fVar.f311393c.f311385c = jSONObject.optString("redEnvelopeImgUrl", "");
            fVar.f311394d.f311385c = jSONObject.optString("sendImgUrl", "");
            return fVar;
        } catch (Throwable th5) {
            QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson Err:" + th5.toString() + ", isV710:" + z16);
            return null;
        }
    }

    public f m(String str, boolean z16) {
        f e16 = this.f311354b.e(str);
        if (!z16) {
            return e16;
        }
        if (e16 == null || e16.f311392b == null || e16.f311393c == null || e16.f311394d == null) {
            return B(str);
        }
        return e16;
    }

    public synchronized void p(boolean z16, boolean z17) {
        File file;
        JSONObject D;
        JSONObject jSONObject;
        boolean z18;
        if (this.f311353a != null && this.f311368p != null) {
            boolean z19 = false;
            if (VasNormalToggle.VAS_DELIST_RED_PACKAGE.isEnable(false)) {
                String str = BaseApplication.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + VasUpdateConstants.SCID_REDPACKET_CONFIG;
                QQAppInterface qQAppInterface = this.f311353a;
                if (!z16) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                file = VasUpdateUtil.getFileFromLocal(qQAppInterface, 16L, VasUpdateConstants.SCID_REDPACKET_CONFIG, str, z18, this.f311369q);
            } else {
                file = null;
            }
            JSONObject c16 = c(file, null);
            if (c16 == null) {
                QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson null == resJson,isAfterDownload:" + z16 + ", isInit" + z17);
                return;
            }
            try {
                try {
                    D = D(c16);
                } catch (Exception e16) {
                    QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: ", e16);
                }
            } catch (JSONException e17) {
                QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: ", e17);
            }
            if (D == null) {
                return;
            }
            JSONArray optJSONArray = D.optJSONArray("activityInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                jSONObject = optJSONArray.optJSONObject(0);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                z19 = v(jSONObject, false);
            } else {
                QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
            }
            e(z19, g(D, z19), NetworkUtil.getSystemNetwork(null));
            this.f311367o.set(true);
        }
    }

    void q(boolean z16, boolean z17, String str, File file) {
        JSONObject i3;
        JSONArray optJSONArray;
        if (this.f311353a == null || this.f311368p == null || (i3 = i(z16, z17, str, file)) == null) {
            return;
        }
        try {
            if (VasUpdateConstants.SCID_REDPACKET_300CHAR.equals(str) && (optJSONArray = i3.optJSONArray("data")) != null) {
                StringBuilder sb5 = new StringBuilder();
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    sb5.append(optJSONArray.getString(i16));
                }
                this.f311355c.f311371g = sb5.toString();
                this.f311355c.f311387e = 2;
            }
            if (VasUpdateConstants.SCID_REDPACKET_FONT_ZIP.equals(str)) {
                this.f311357e.f311384b = i3.optString("id", "");
                this.f311357e.f311383a = i3.optString("name", "");
                this.f311357e.f311386d = i3.optInt("version");
                e eVar = this.f311357e;
                eVar.f311387e = 2;
                this.f311368p.d(eVar.f311384b);
            }
            if (VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP.equals(str)) {
                this.f311356d.f311384b = i3.optString("id", "0");
                this.f311356d.f311386d = i3.optInt("version");
                b bVar = this.f311356d;
                bVar.f311387e = 2;
                bVar.f311372h = i3.optString(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, "");
                this.f311356d.f311371g = "" + this.f311356d.f311372h;
                K(file, this.f311356d.f311384b + this.f311356d.f311386d);
            }
            b();
        } catch (Throwable th5) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", th5);
        }
    }

    public void t() {
        if (this.f311353a == null) {
            return;
        }
        p(false, true);
        if (!VasNormalToggle.VAS_DELIST_RED_PACKAGE.isEnable(false)) {
            if (VasUpdateUtil.getFileFromLocal(this.f311353a, 16L, VasUpdateConstants.SCID_REDPACKET_FONT_ZIP, IndividualRedPacketManager.x(null, null, 8, 0, 0), true, this.f311369q) != null) {
                q(false, true, VasUpdateConstants.SCID_REDPACKET_FONT_ZIP, new File(IndividualRedPacketManager.x(null, null, 21, 0, 0)));
            }
            q(false, true, VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP, VasUpdateUtil.getFileFromLocal(this.f311353a, 16L, VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP, IndividualRedPacketManager.x(null, null, 25, 0, 0), true, this.f311369q));
            q(false, true, VasUpdateConstants.SCID_REDPACKET_300CHAR, VasUpdateUtil.getFileFromLocal(this.f311353a, 16L, VasUpdateConstants.SCID_REDPACKET_300CHAR, BaseApplication.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + VasUpdateConstants.SCID_REDPACKET_300CHAR, true, this.f311369q));
        }
    }
}
