package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.text.TextUtils;
import com.qq.e.comm.constants.TangramAppConstants;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.g;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qs.f;

/* loaded from: classes32.dex */
public class PtvTemplateManager {

    /* renamed from: b, reason: collision with root package name */
    private static String f67560b = "dov_ptv_template_usable_doodle";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f67562d;

    /* renamed from: g, reason: collision with root package name */
    private static PtvTemplateManager f67565g;

    /* renamed from: a, reason: collision with root package name */
    private f f67566a;

    /* renamed from: e, reason: collision with root package name */
    private static Object f67563e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static Object f67564f = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static File f67561c = new File(new File(g.f185856d), "dov_doodle_template");

    /* loaded from: classes32.dex */
    public interface a {
        void a(f fVar, boolean z16);

        void b(f fVar, int i3);
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f67561c.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(f67560b);
        sb5.append(str);
        f67560b = sb5.toString();
        f67562d = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(com.tencent.aelight.camera.constants.a.F);
    }

    public static PtvTemplateManager j() {
        if (f67565g == null) {
            synchronized (f67563e) {
                if (f67565g == null) {
                    f67565g = new PtvTemplateManager();
                }
            }
        }
        return f67565g;
    }

    public static boolean n() {
        return new File(f67561c, "dov_doodle_template_new.cfg").exists();
    }

    public static String p(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            if (!QLog.isDevelopLevel()) {
                return null;
            }
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[Catch: JSONException -> 0x007d, TryCatch #2 {JSONException -> 0x007d, blocks: (B:14:0x0036, B:17:0x003d, B:19:0x0047, B:21:0x0055), top: B:13:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static f q(String str) {
        f fVar;
        JSONArray jSONArray;
        int length;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            fVar = (f) JSONUtils.b(jSONObject, f.class);
        } catch (JSONException e16) {
            e = e16;
            fVar = null;
        }
        try {
        } catch (JSONException e17) {
            e = e17;
            if (QLog.isColorLevel()) {
                e.printStackTrace();
            }
            jSONArray = null;
            if (jSONArray != null) {
            }
            return null;
        }
        if (jSONObject.has("doodleinfo")) {
            jSONArray = jSONObject.getJSONArray("doodleinfo");
            if (jSONArray != null && fVar != null) {
                try {
                    length = jSONArray.length();
                    if (length > 0) {
                        return null;
                    }
                    fVar.f429443k = new ArrayList<>(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        qs.a aVar = (qs.a) JSONUtils.b(jSONArray.getJSONObject(i3), qs.a.class);
                        if (aVar != null) {
                            fVar.f429443k.add(aVar);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "parseDoodleConfig|templateInfo= " + fVar);
                    }
                    return fVar;
                } catch (JSONException e18) {
                    if (QLog.isDevelopLevel()) {
                        e18.printStackTrace();
                    }
                }
            }
            return null;
        }
        jSONArray = null;
        if (jSONArray != null) {
            length = jSONArray.length();
            if (length > 0) {
            }
        }
        return null;
    }

    public ArrayList<qs.a> h() {
        File[] listFiles;
        ArrayList<qs.a> arrayList = new ArrayList<>();
        synchronized (f67564f) {
            f fVar = this.f67566a;
            if (fVar != null && !fVar.f429443k.isEmpty()) {
                Iterator<qs.a> it = this.f67566a.f429443k.iterator();
                while (it.hasNext()) {
                    qs.a next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.f429423b)) {
                        boolean z16 = false;
                        if (!new File(f67561c, next.f429423b).exists()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
                            }
                            next.f429426e = false;
                        } else {
                            File file = new File(f67560b + next.f429423b + File.separator, IVideoFilterTools.CONFIG_FILE);
                            if (!file.exists()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|paramFile is not exist ");
                                }
                                next.f429426e = false;
                            } else {
                                File parentFile = file.getParentFile();
                                if (parentFile.isDirectory() && (listFiles = parentFile.listFiles()) != null && listFiles.length > 0) {
                                    int length = listFiles.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length) {
                                            break;
                                        }
                                        if (listFiles[i3].getName().endsWith("png")) {
                                            z16 = true;
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                                if (!z16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|image is not exist ");
                                    }
                                    file.delete();
                                } else {
                                    arrayList.add(next);
                                }
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "info is null or info name is null " + next);
                    }
                }
                return arrayList;
            }
            return null;
        }
    }

    public String i(int i3) {
        ArrayList<qs.a> arrayList;
        f fVar = this.f67566a;
        if (fVar != null && (arrayList = fVar.f429443k) != null && !arrayList.isEmpty()) {
            Iterator<qs.a> it = this.f67566a.f429443k.iterator();
            while (it.hasNext()) {
                qs.a next = it.next();
                if (Integer.valueOf(next.f429422a).intValue() == i3) {
                    return f67560b + next.f429423b;
                }
            }
            return "";
        }
        return "";
    }

    public void k(final String str, QQAppInterface qQAppInterface) {
        f q16 = q(str);
        if (q16 == null) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.writeFile(PtvTemplateManager.f67561c.getPath() + File.separator, "dov_doodle_template_new.cfg", str);
                if (QLog.isColorLevel()) {
                    QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
                }
            }
        });
        synchronized (f67564f) {
            this.f67566a = q16;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.3
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                boolean z16;
                if (PtvTemplateManager.f67561c == null || (listFiles = PtvTemplateManager.f67561c.listFiles()) == null || listFiles.length == 0) {
                    return;
                }
                for (File file : listFiles) {
                    if (file != null && file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && !name.contains(".")) {
                            Iterator<qs.a> it = PtvTemplateManager.this.f67566a.f429443k.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z16 = false;
                                    break;
                                }
                                qs.a next = it.next();
                                if (next != null && !TextUtils.isEmpty(next.f429423b) && file.getName().equalsIgnoreCase(next.f429423b)) {
                                    z16 = true;
                                    break;
                                }
                            }
                            if (!z16) {
                                file.deleteOnExit();
                                new File(PtvTemplateManager.f67560b + file.getName()).deleteOnExit();
                            }
                        }
                    }
                }
            }
        });
        r(qQAppInterface);
    }

    public boolean l() {
        return BaseApplication.getContext().getSharedPreferences("key_sp_doodle_resource", 4).getBoolean("key_doodle_resource_download_fail", false);
    }

    public void m(final AppInterface appInterface, final qs.b bVar) {
        final File file = new File(f67561c, "dov_doodle_template_new.cfg");
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initLocalDoodleInfo config file not exist.");
            }
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.1
                @Override // java.lang.Runnable
                public void run() {
                    f q16;
                    ArrayList<qs.a> arrayList;
                    boolean z16;
                    String p16 = PtvTemplateManager.p(file);
                    if (TextUtils.isEmpty(p16) || (q16 = PtvTemplateManager.q(p16)) == null || (arrayList = q16.f429443k) == null || arrayList.isEmpty()) {
                        return;
                    }
                    Iterator<qs.a> it = q16.f429443k.iterator();
                    loop0: while (true) {
                        z16 = false;
                        while (it.hasNext()) {
                            qs.a next = it.next();
                            if (next != null) {
                                boolean o16 = PtvTemplateManager.this.o(next, true);
                                next.f429426e = o16;
                                if (z16 || o16) {
                                    z16 = true;
                                }
                            }
                        }
                    }
                    synchronized (PtvTemplateManager.f67564f) {
                        PtvTemplateManager.this.f67566a = q16;
                    }
                    qs.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    if (appInterface instanceof QQAppInterface) {
                        if (com.tencent.mobileqq.shortvideo.util.f.m()) {
                            PtvTemplateManager.this.r((QQAppInterface) appInterface);
                        }
                    } else if (z16) {
                        PtvTemplateManager.this.s(false);
                    }
                }
            }, 64, null, false);
            if (QLog.isDevelopLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, "initLocalDoodleInfo async");
            }
        }
    }

    public void s(boolean z16) {
        BaseApplication.getContext().getSharedPreferences("key_sp_doodle_resource", 4).edit().putBoolean("key_doodle_resource_download_fail", !z16).apply();
    }

    /* loaded from: classes32.dex */
    public static class b {
        private static f b(JSONObject jSONObject) {
            f fVar = new f();
            try {
                if (jSONObject.has("id")) {
                    fVar.f429433a = jSONObject.getString("id");
                }
                if (jSONObject.has(TangramAppConstants.ICON_URL)) {
                    fVar.f429434b = jSONObject.getString(TangramAppConstants.ICON_URL);
                }
                if (jSONObject.has("resurl")) {
                    fVar.f429435c = jSONObject.getString("resurl");
                }
                if (jSONObject.has("md5")) {
                    fVar.f429436d = jSONObject.getString("md5");
                }
                if (jSONObject.has("name")) {
                    fVar.f429437e = jSONObject.getString("name");
                }
                if (jSONObject.has("predownload")) {
                    fVar.f429438f = jSONObject.getBoolean("predownload");
                }
                if (jSONObject.has("platform")) {
                    fVar.f429441i = jSONObject.getInt("platform");
                }
                if (jSONObject.has(PreDownloadConstants.RPORT_KEY_BUSINESS_ID)) {
                    fVar.f429442j = jSONObject.getInt(PreDownloadConstants.RPORT_KEY_BUSINESS_ID);
                }
                if (jSONObject.has("categoryId")) {
                    fVar.f429444l = jSONObject.getInt("categoryId");
                }
                if (jSONObject.has("templateStyle")) {
                    fVar.f429445m = jSONObject.getInt("templateStyle");
                }
                if (jSONObject.has("needRedDot")) {
                    fVar.f429446n = jSONObject.getBoolean("needRedDot");
                }
                if (jSONObject.has("kind")) {
                    fVar.f429447o = jSONObject.getInt("kind");
                }
                if (jSONObject.has("displayType")) {
                    fVar.f429448p = jSONObject.getInt("displayType");
                }
                if (jSONObject.has(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE)) {
                    fVar.f429449q = jSONObject.getString(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE);
                }
                if (jSONObject.has(PeakConstants.KEY_QQ_CAMERA_SCHEME)) {
                    fVar.f429450r = jSONObject.getString(PeakConstants.KEY_QQ_CAMERA_SCHEME);
                }
                if (jSONObject.has("activityType")) {
                    fVar.f429452t = jSONObject.getInt("activityType");
                }
                if (jSONObject.has("category")) {
                    fVar.f429453u = jSONObject.getInt("category");
                }
                if (jSONObject.has("gestureType")) {
                    fVar.f429454v = jSONObject.getString("gestureType");
                }
                if (jSONObject.has("gestureWording")) {
                    fVar.f429455w = jSONObject.getString("gestureWording");
                }
                if (jSONObject.has("advertisement")) {
                    fVar.f429457y = jSONObject.getBoolean("advertisement");
                }
                if (jSONObject.has("androidopenurlheader")) {
                    fVar.f429458z = jSONObject.getString("androidopenurlheader");
                }
                if (jSONObject.has("openurl")) {
                    fVar.A = jSONObject.getString("openurl");
                }
                if (jSONObject.has("storeurl")) {
                    fVar.B = jSONObject.getString("storeurl");
                }
                if (jSONObject.has("popup")) {
                    fVar.C = jSONObject.getBoolean("popup");
                }
                if (jSONObject.has("badgeurl")) {
                    fVar.D = jSONObject.getString("badgeurl");
                }
                if (jSONObject.has("popupimgurl")) {
                    fVar.E = jSONObject.getString("popupimgurl");
                }
                if (jSONObject.has("popupcontent")) {
                    fVar.F = jSONObject.getString("popupcontent");
                }
                if (jSONObject.has("popupbtn")) {
                    fVar.G = jSONObject.getString("popupbtn");
                }
                if (jSONObject.has("popupcontent2")) {
                    fVar.H = jSONObject.getString("popupcontent2");
                }
                if (jSONObject.has("popupbtn2")) {
                    fVar.I = jSONObject.getString("popupbtn2");
                }
                if (jSONObject.has("buttonbgcolor")) {
                    fVar.J = jSONObject.getString("buttonbgcolor");
                }
                if (jSONObject.has("multivideosupport")) {
                    fVar.K = jSONObject.getBoolean("multivideosupport");
                }
                if (jSONObject.has("sizeFree")) {
                    fVar.U = jSONObject.getDouble("sizeFree");
                }
                if (jSONObject.has("jump_app")) {
                    fVar.f429451s = jSONObject.getString("jump_app");
                }
                if (jSONObject.has("funcType")) {
                    fVar.f429456x = jSONObject.getInt("funcType");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PtvTemplateManager", 1, "parseContent error=" + e16.getMessage());
                }
            }
            return fVar;
        }

        public static List<f> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            try {
                int length = jSONArray.length();
                if (length <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    f b16 = b(jSONArray.getJSONObject(i3));
                    if (b16 != null) {
                        try {
                            Long.parseLong(b16.f429433a);
                            int i16 = b16.f429447o;
                            if (i16 != 1) {
                                if (i16 != 12) {
                                    arrayList.add(b16);
                                } else {
                                    arrayList.add(b16);
                                }
                            } else if (!PtvTemplateManager.f67562d) {
                                arrayList.add(b16);
                            }
                        } catch (Exception unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
                return null;
            }
        }
    }

    public boolean o(qs.a aVar, boolean z16) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f429423b)) {
            File file = new File(f67561c, aVar.f429423b);
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|file is not exist -> " + aVar.f429423b);
                }
                return false;
            }
            try {
                String calcMd5 = FileUtils.calcMd5(file.getPath());
                if (TextUtils.isEmpty(calcMd5) || !calcMd5.equalsIgnoreCase(aVar.f429425d)) {
                    return false;
                }
                if (z16) {
                    if (!new File(f67560b + aVar.f429423b + File.separator, IVideoFilterTools.CONFIG_FILE).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|paramFile is not exist->>" + aVar.f429423b);
                        }
                        try {
                            ZipUtils.unZipFile(new File(f67561c, aVar.f429423b), f67560b);
                            if (QLog.isColorLevel()) {
                                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|unZipFile->>" + aVar.f429423b);
                            }
                            return true;
                        } catch (IOException e16) {
                            if (QLog.isColorLevel()) {
                                e16.printStackTrace();
                            }
                            return false;
                        }
                    }
                }
                return true;
            } catch (UnsatisfiedLinkError e17) {
                if (QLog.isColorLevel()) {
                    e17.printStackTrace();
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final QQAppInterface qQAppInterface) {
        f fVar = this.f67566a;
        if (fVar == null || fVar.f429443k.isEmpty() || qQAppInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "preDownloadDoodleTemplate|app= " + qQAppInterface);
        }
        Iterator<qs.a> it = this.f67566a.f429443k.iterator();
        while (it.hasNext()) {
            final qs.a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f429424c) && !next.f429426e) {
                Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PtvTemplateManager.this.o(next, true)) {
                            next.f429426e = true;
                            return;
                        }
                        HttpNetReq httpNetReq = new HttpNetReq();
                        httpNetReq.mCallback = new a();
                        httpNetReq.mReqUrl = next.f429424c;
                        httpNetReq.mHttpMethod = 0;
                        httpNetReq.mOutPath = new File(PtvTemplateManager.f67561c, next.f429423b).getPath();
                        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                        ((IHttpEngineService) qQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                        if (QLog.isColorLevel()) {
                            QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + next.f429424c);
                        }
                    }

                    /* renamed from: com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager$4$a */
                    /* loaded from: classes32.dex */
                    class a implements INetEngineListener {
                        a() {
                        }

                        @Override // com.tencent.mobileqq.transfile.INetEngineListener
                        public void onResp(NetResp netResp) {
                            if (QLog.isColorLevel()) {
                                QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + next.f429424c + " resultcode: " + netResp.mHttpCode);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            qs.a aVar = next;
                            aVar.f429426e = PtvTemplateManager.this.o(aVar, false);
                            if (next.f429426e) {
                                try {
                                    ZipUtils.unZipFile(new File(PtvTemplateManager.f67561c, next.f429423b), PtvTemplateManager.f67560b);
                                } catch (IOException e16) {
                                    QLog.e("PtvTemplateManager", 1, "preDownloadDoodleTemplate error, ", e16);
                                }
                            }
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            PtvTemplateManager.this.s(next.f429426e);
                            if (netResp.mResult == 0) {
                                IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
                                if (iPreDownloadController.isEnable()) {
                                    iPreDownloadController.preDownloadSuccess(next.f429424c, netResp.mTotalFileLen);
                                }
                            }
                        }

                        @Override // com.tencent.mobileqq.transfile.INetEngineListener
                        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                        }
                    }
                };
                IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
                if (iPreDownloadController.isEnable()) {
                    iPreDownloadController.requestPreDownload(10020, null, next.f429423b, 0, next.f429424c, new File(f67561c, next.f429423b).getPath(), 2, 0, true, new RunnableTask(qQAppInterface, "qq_doodle_res", runnable, 4000L));
                } else {
                    ThreadManagerV2.post(runnable, 8, null, true);
                }
            }
        }
    }
}
