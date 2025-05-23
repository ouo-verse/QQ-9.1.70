package com.tencent.mobileqq.secspy;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter;
import com.tencent.mobileqq.unifiedebug.c;
import com.tencent.mobileqq.unifiedebug.d;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import mqq.app.TicketManagerImpl;
import mqq.manager.Manager;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SecSpyFileManager implements Manager {
    static IPatchRedirector $redirector_;
    private static final String E;
    private static final String F;
    public Handler C;
    private Runnable D;

    /* renamed from: d, reason: collision with root package name */
    public String f285249d;

    /* renamed from: e, reason: collision with root package name */
    public String f285250e;

    /* renamed from: f, reason: collision with root package name */
    public String f285251f;

    /* renamed from: h, reason: collision with root package name */
    public QQAppInterface f285252h;

    /* renamed from: i, reason: collision with root package name */
    public UnifiedDebugManager f285253i;

    /* renamed from: m, reason: collision with root package name */
    public c f285254m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private float f285262a;

        /* renamed from: b, reason: collision with root package name */
        private float f285263b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f285264c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SecSpyFileManager.this);
            } else {
                this.f285262a = 0.0f;
                this.f285264c = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            E = HardCodeUtil.qqStr(R.string.t86);
            F = HardCodeUtil.qqStr(R.string.t85);
        }
    }

    public SecSpyFileManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f285249d = "https://logic.content.qq.com/public/file_upload2?";
        this.f285250e = "https://qprostat.imtt.qq.com/";
        this.f285251f = ".mgz";
        this.f285252h = qQAppInterface;
        this.D = new Runnable() { // from class: com.tencent.mobileqq.secspy.SecSpyFileManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SecSpyFileManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    UnifiedDebugManager.C(SecSpyFileManager.this.f285252h.getApplication());
                }
            }
        };
        if (qQAppInterface.getApplication().getSharedPreferences("x5_proxy_setting", 4).getBoolean("is_in_proxy", false)) {
            ThreadManager.getFileThreadHandler().post(this.D);
        }
    }

    static /* bridge */ /* synthetic */ Runnable a(SecSpyFileManager secSpyFileManager) {
        return secSpyFileManager.D;
    }

    static /* bridge */ /* synthetic */ void b(SecSpyFileManager secSpyFileManager, String str, String str2, long j3, String str3) {
        secSpyFileManager.s(str, str2, j3, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(String str, String str2, long j3, String str3) {
        FileInputStream fileInputStream;
        Throwable th5;
        Exception e16;
        File j16 = j(this.f285253i.K(str));
        if (j16 != null && j16.exists() && j16.isFile()) {
            k(j3, 2, Long.valueOf(j16.length()));
            k(j3, 3, 100);
            HashMap hashMap = new HashMap();
            hashMap.put("q-guid", str2);
            hashMap.put("openrandom", "qqplatform");
            hashMap.put("q-proxy-log", "livelog");
            ?? r36 = "q-params";
            hashMap.put("q-params", "{\"id\":\"" + str2 + "\"}");
            OutputStream outputStream = null;
            try {
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            try {
                try {
                    r36 = (HttpURLConnection) new URL(this.f285250e).openConnection();
                    try {
                        r36.setDoOutput(true);
                        r36.setDoInput(true);
                        r36.setUseCaches(false);
                        r36.setRequestMethod("POST");
                        r36.setRequestProperty(FileUploadBase.CONTENT_LENGTH, "" + j16.length());
                        r36.setRequestProperty("Content-Type", "application/octet-stream");
                        r36.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                        for (String str4 : hashMap.keySet()) {
                            r36.setRequestProperty(str4, (String) hashMap.get(str4));
                        }
                        OutputStream outputStream2 = r36.getOutputStream();
                        try {
                            try {
                                byte[] bArr = new byte[10240];
                                try {
                                    fileInputStream = new FileInputStream(j16);
                                    while (true) {
                                        try {
                                            try {
                                                int read = fileInputStream.read(bArr, 0, 10240);
                                                if (read != -1) {
                                                    outputStream2.write(bArr, 0, read);
                                                } else {
                                                    try {
                                                        break;
                                                    } catch (IOException e18) {
                                                        e18.printStackTrace();
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                th5 = th6;
                                                if (fileInputStream != null) {
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (IOException e19) {
                                                        e19.printStackTrace();
                                                    }
                                                }
                                                throw th5;
                                            }
                                        } catch (Exception e26) {
                                            e16 = e26;
                                            k(j3, -1, "x5 log upload failed, err = " + e16.getMessage());
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException e27) {
                                                    e27.printStackTrace();
                                                }
                                            }
                                            if (outputStream2 != null) {
                                                try {
                                                    outputStream2.close();
                                                } catch (IOException e28) {
                                                    e28.printStackTrace();
                                                    return;
                                                }
                                            }
                                            r36.disconnect();
                                            return;
                                        }
                                    }
                                    fileInputStream.close();
                                    int responseCode = r36.getResponseCode();
                                    if (responseCode == 200) {
                                        k(j3, 0, new Object[0]);
                                    } else {
                                        k(j3, -1, "x5 log upload failed, http response code = " + responseCode);
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    r36.disconnect();
                                } catch (Exception e29) {
                                    fileInputStream = null;
                                    e16 = e29;
                                } catch (Throwable th7) {
                                    fileInputStream = null;
                                    th5 = th7;
                                    if (fileInputStream != null) {
                                    }
                                    throw th5;
                                }
                            } catch (IOException e36) {
                                e = e36;
                                outputStream = outputStream2;
                                QLog.e("SecSpyFileManager", 1, "x5 log upload failed", e);
                                k(j3, -1, e.getMessage());
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (r36 != 0) {
                                    r36.disconnect();
                                }
                                j16.delete();
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            outputStream = outputStream2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e37) {
                                    e37.printStackTrace();
                                    throw th;
                                }
                            }
                            if (r36 != 0) {
                                r36.disconnect();
                            }
                            throw th;
                        }
                    } catch (IOException e38) {
                        e = e38;
                    }
                } catch (IOException e39) {
                    e = e39;
                    r36 = 0;
                } catch (Throwable th9) {
                    th = th9;
                    r36 = 0;
                }
                j16.delete();
            } catch (Throwable th10) {
                th = th10;
            }
        } else {
            k(j3, -1, "file zip failed");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0086, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
    
        com.tencent.qphone.base.util.QLog.e("SecSpyFileManager", 2, "compress file error!", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b8, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c7 A[Catch: Exception -> 0x00c3, TRY_LEAVE, TryCatch #7 {Exception -> 0x00c3, blocks: (B:61:0x00bf, B:52:0x00c7), top: B:60:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(File file) {
        GZIPOutputStream gZIPOutputStream;
        FileInputStream fileInputStream;
        File j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) file)).booleanValue();
        }
        FileInputStream fileInputStream2 = null;
        boolean z16 = false;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e16) {
            e = e16;
            gZIPOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = null;
        }
        try {
            try {
                j3 = j(file.getAbsolutePath() + this.f285251f);
            } catch (IOException e17) {
                e = e17;
                gZIPOutputStream = null;
            }
            if (j3 == null) {
                try {
                    fileInputStream.close();
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SecSpyFileManager", 2, "compress file error!", e18);
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SecSpyFileManager", 2, "compress file error!", e19);
                    }
                }
                return false;
            }
            gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(j3));
            try {
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 10240);
                    if (read == -1) {
                        break;
                    }
                    gZIPOutputStream.write(bArr, 0, read);
                }
                z16 = true;
                gZIPOutputStream.flush();
                try {
                    fileInputStream.close();
                    gZIPOutputStream.close();
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (IOException e27) {
                e = e27;
                fileInputStream2 = fileInputStream;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e("SecSpyFileManager", 2, "compress file error!", e);
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e28) {
                            e = e28;
                        }
                    }
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return z16;
                } catch (Throwable th6) {
                    th = th6;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e29) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SecSpyFileManager", 2, "compress file error!", e29);
                            }
                            throw th;
                        }
                    }
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                if (gZIPOutputStream != null) {
                }
                throw th;
            }
            return z16;
        } catch (Throwable th8) {
            th = th8;
            gZIPOutputStream = null;
        }
    }

    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.f285253i.f(this.f285252h.getApplication(), j3);
        }
    }

    public void e(List<String> list, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, Long.valueOf(j3), str);
        } else if (this.f285253i.f(this.f285252h.getApplication(), j3)) {
            r(list, j3, str);
        }
    }

    public String f(TreeMap<String, Object> treeMap, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) treeMap, (Object) str);
        }
        Iterator<String> it = treeMap.keySet().iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = str2 + treeMap.get(it.next());
        }
        return MD5.toMD5(str2 + str);
    }

    public void g(submsgtype0x7c$MsgBody submsgtype0x7c_msgbody, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) submsgtype0x7c_msgbody, i3);
            return;
        }
        if (i3 < 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SecSpyFileManager", 2, "retry to max retry number ");
                return;
            }
            return;
        }
        if (this.C == null) {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("SecSpyFile", 0);
            newFreeHandlerThread.start();
            this.C = new Handler(newFreeHandlerThread.getLooper());
            this.f285253i = new UnifiedDebugManager(new SnapshotResultReceiver(this.f285252h, this.C));
        }
        if (this.f285254m == null) {
            this.f285254m = new c(this.f285252h);
        }
        this.C.post(new Runnable(submsgtype0x7c_msgbody, i3) { // from class: com.tencent.mobileqq.secspy.SecSpyFileManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ submsgtype0x7c$MsgBody f285255d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f285256e;

            {
                this.f285255d = submsgtype0x7c_msgbody;
                this.f285256e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SecSpyFileManager.this, submsgtype0x7c_msgbody, Integer.valueOf(i3));
                }
            }

            /*  JADX ERROR: Type inference failed
                jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
                */
            /* JADX WARN: Not initialized variable reg: 18, insn: 0x0454: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:460:0x0452 */
            /* JADX WARN: Not initialized variable reg: 18, insn: 0x0460: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:458:0x045e */
            /* JADX WARN: Not initialized variable reg: 18, insn: 0x0495: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:450:0x0493 */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    Method dump skipped, instructions count: 3342
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.secspy.SecSpyFileManager.AnonymousClass2.run():void");
            }
        });
    }

    public List<String> h(JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, (Object) jSONArray);
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String optString = jSONArray.optString(i3);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    public JSONArray i(Collection collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (JSONArray) iPatchRedirector.redirect((short) 17, (Object) this, (Object) collection);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        return jSONArray;
    }

    public File j(String str) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (File) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        try {
            if (str.startsWith("/data/data/com.tencent.mobileqq/")) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                String substring = str.substring(str.indexOf("/data/data/com.tencent.mobileqq/") + 32);
                String substring2 = substring.substring(0, substring.indexOf("/"));
                String substring3 = substring.substring(substring.indexOf("/") + 1);
                Context applicationContext = this.f285252h.getApplication().getApplicationContext();
                if (substring2.equals("files")) {
                    file = new File(applicationContext.getFilesDir(), substring3);
                } else if (substring2.equals("cache")) {
                    file = new File(applicationContext.getCacheDir(), substring3);
                } else if (substring2.startsWith("app_")) {
                    file = new File(this.f285252h.getApplication().getApplicationContext().getDir(substring2.substring(4), 0), substring3);
                } else {
                    file = new File(str);
                }
            } else if (str.startsWith("sdcard/")) {
                String replace = str.replace("sdcard/", "");
                if (!"mounted".equals(Environment.getExternalStorageState()) || !Environment.getExternalStorageDirectory().canWrite()) {
                    return null;
                }
                file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + replace);
            } else {
                return new File(str);
            }
            return file;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SecSpyFileManager", 2, "wrong to parse file from path :" + str, e16);
            }
            e16.printStackTrace();
            return null;
        }
    }

    public void k(long j3, int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Integer.valueOf(i3), objArr);
            return;
        }
        try {
            if (i3 != -1) {
                if (i3 != 0 && i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            JSONObject jSONObject = new JSONObject();
                            if (objArr.length > 0) {
                                jSONObject.put("percent", objArr[0]);
                            }
                            this.f285254m.b(j3, i3, jSONObject);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (objArr.length > 0) {
                        jSONObject2.put("sizes", objArr[0]);
                    }
                    this.f285254m.b(j3, i3, jSONObject2);
                    return;
                }
                this.f285254m.b(j3, i3, null);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (objArr.length > 0) {
                jSONObject3.put("msg", objArr[0]);
            }
            this.f285254m.b(j3, i3, jSONObject3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void l(long j3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), jSONObject);
        } else {
            this.f285254m.b(j3, 0, jSONObject);
        }
    }

    public void m(long j3, String str, Map<String, Object> map, List<UnifiedTraceRouter.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, map, list);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < list.size(); i3++) {
            jSONArray.mo162put(list.get(i3).a());
        }
        try {
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            jSONObject.put("dns", this.f285253i.j());
            jSONObject.put("ip", this.f285253i.n(str));
            jSONObject.put("traceRoute", jSONArray);
            if (QLog.isColorLevel()) {
                QLog.d("SecSpyFileManager", 2, jSONObject.toString());
            }
            l(j3, jSONObject);
        } catch (Exception e16) {
            k(j3, -1, e16.getMessage());
        }
        list.clear();
    }

    public void n(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str);
        } else {
            k(j3, -1, str);
        }
    }

    public void o(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            this.f285253i.y(this.f285252h.getApp(), str, i3, j3, j16, str2);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void p(String str, long j3, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3), str2, Boolean.valueOf(z16));
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            k(j3, 2, Long.valueOf(file.length()));
            if (q(str, j3, str2, false)) {
                if (z16) {
                    file.delete();
                    if (QLog.isColorLevel()) {
                        QLog.d("SecSpyFileManager", 2, str + " delete success");
                        return;
                    }
                    return;
                }
                return;
            }
            k(j3, -1, "file upload failed");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0523 A[Catch: all -> 0x0581, TryCatch #10 {all -> 0x0581, blocks: (B:43:0x051d, B:45:0x0523, B:46:0x052a), top: B:42:0x051d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0543 A[Catch: Exception -> 0x053e, TryCatch #23 {Exception -> 0x053e, blocks: (B:69:0x053a, B:49:0x0543, B:51:0x0548, B:53:0x054d, B:55:0x0564, B:57:0x056a, B:58:0x056d), top: B:68:0x053a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0548 A[Catch: Exception -> 0x053e, TryCatch #23 {Exception -> 0x053e, blocks: (B:69:0x053a, B:49:0x0543, B:51:0x0548, B:53:0x054d, B:55:0x0564, B:57:0x056a, B:58:0x056d), top: B:68:0x053a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x054d A[Catch: Exception -> 0x053e, TryCatch #23 {Exception -> 0x053e, blocks: (B:69:0x053a, B:49:0x0543, B:51:0x0548, B:53:0x054d, B:55:0x0564, B:57:0x056a, B:58:0x056d), top: B:68:0x053a }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x053a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x058e A[Catch: Exception -> 0x0589, TryCatch #13 {Exception -> 0x0589, blocks: (B:95:0x0585, B:75:0x058e, B:77:0x0593, B:79:0x0598, B:81:0x05af, B:83:0x05b5, B:84:0x05b8), top: B:94:0x0585 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0593 A[Catch: Exception -> 0x0589, TryCatch #13 {Exception -> 0x0589, blocks: (B:95:0x0585, B:75:0x058e, B:77:0x0593, B:79:0x0598, B:81:0x05af, B:83:0x05b5, B:84:0x05b8), top: B:94:0x0585 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0598 A[Catch: Exception -> 0x0589, TryCatch #13 {Exception -> 0x0589, blocks: (B:95:0x0585, B:75:0x058e, B:77:0x0593, B:79:0x0598, B:81:0x05af, B:83:0x05b5, B:84:0x05b8), top: B:94:0x0585 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0585 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean q(String str, long j3, String str2, boolean z16) {
        String str3;
        String str4;
        long j16;
        Throwable th5;
        HttpURLConnection httpURLConnection;
        FileInputStream fileInputStream;
        Throwable th6;
        Exception exc;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3), str2, Boolean.valueOf(z16))).booleanValue();
        }
        VasCommonReporter.getHistoryFeature("user_log_upload").report(false);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = new a();
        DataOutputStream dataOutputStream = null;
        try {
            try {
                File j17 = j(str);
                if (j17 != null) {
                    try {
                        if (j17.exists() && j17.isFile()) {
                            try {
                                if (j17.length() > (HttpUtil.getNetWorkType() == 1 ? GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT : 10485760L)) {
                                    k(j3, -1, E);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SecSpyFileManager", 2, "can not upload file which size more than 10mb " + j17.length());
                                    }
                                    if (z16) {
                                        try {
                                            File j18 = j(str + this.f285251f);
                                            if (j18 != null && j18.exists()) {
                                                j18.delete();
                                            }
                                        } catch (Exception e16) {
                                            if (QLog.isColorLevel()) {
                                                QLog.e("SecSpyFileManager", 2, "finally: close and delete tmp", e16);
                                            }
                                            e16.printStackTrace();
                                        }
                                    }
                                    aVar.f285264c = true;
                                    return false;
                                }
                                String substring = str.substring(str.lastIndexOf(47) + 1);
                                if (z16) {
                                    substring = substring + ".gz";
                                    if (!c(j17)) {
                                        if (z16) {
                                            try {
                                                File j19 = j(str + this.f285251f);
                                                if (j19 != null && j19.exists()) {
                                                    j19.delete();
                                                }
                                            } catch (Exception e17) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("SecSpyFileManager", 2, "finally: close and delete tmp", e17);
                                                }
                                                e17.printStackTrace();
                                                return false;
                                            }
                                        }
                                        aVar.f285264c = true;
                                        return false;
                                    }
                                    j17 = j(str + this.f285251f);
                                    if (j17 == null || !j17.exists() || !j17.isFile()) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SecSpyFileManager", 2, "can not get compress file, " + str + this.f285251f);
                                        }
                                        if (z16) {
                                            try {
                                                File j26 = j(str + this.f285251f);
                                                if (j26 != null && j26.exists()) {
                                                    j26.delete();
                                                }
                                            } catch (Exception e18) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("SecSpyFileManager", 2, "finally: close and delete tmp", e18);
                                                }
                                                e18.printStackTrace();
                                                return false;
                                            }
                                        }
                                        aVar.f285264c = true;
                                        return false;
                                    }
                                }
                                TreeMap<String, Object> treeMap = new TreeMap<>();
                                try {
                                    treeMap.put("seq", Long.valueOf(j3));
                                    treeMap.put("type", "formdata");
                                    treeMap.put("filename", substring);
                                    treeMap.put(MediaDBValues.FILESIZE, Long.valueOf(j17.length()));
                                } catch (Exception e19) {
                                    e = e19;
                                    str3 = str;
                                } catch (Throwable th7) {
                                    th = th7;
                                    str3 = str;
                                }
                                try {
                                    treeMap.put("offset", 0);
                                    treeMap.put(PreloadTRTCPlayerParams.KEY_SIG, f(treeMap, str2));
                                    String str5 = this.f285249d;
                                    Iterator<String> it = treeMap.keySet().iterator();
                                    while (it.hasNext()) {
                                        try {
                                            String next = it.next();
                                            Iterator<String> it5 = it;
                                            str5 = str5 + next + ContainerUtils.KEY_VALUE_DELIMITER + treeMap.get(next) + ContainerUtils.FIELD_DELIMITER;
                                            it = it5;
                                        } catch (Exception e26) {
                                            exc = e26;
                                            j16 = j3;
                                            httpURLConnection = null;
                                            fileInputStream = null;
                                            str4 = "finally: close and delete tmp";
                                            str3 = str;
                                            try {
                                                if (QLog.isColorLevel()) {
                                                }
                                                k(j16, -1, exc.getMessage());
                                                if (dataOutputStream != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                if (z16) {
                                                }
                                                aVar.f285264c = true;
                                                return false;
                                            } catch (Throwable th8) {
                                                th6 = th8;
                                                th5 = th6;
                                                if (dataOutputStream != null) {
                                                    try {
                                                        dataOutputStream.close();
                                                    } catch (Exception e27) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.e("SecSpyFileManager", 2, str4, e27);
                                                        }
                                                        e27.printStackTrace();
                                                        throw th5;
                                                    }
                                                }
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                if (z16) {
                                                    File j27 = j(str3 + this.f285251f);
                                                    if (j27 != null && j27.exists()) {
                                                        j27.delete();
                                                    }
                                                }
                                                aVar.f285264c = true;
                                                throw th5;
                                            }
                                        } catch (Throwable th9) {
                                            str3 = str;
                                            th5 = th9;
                                            httpURLConnection = null;
                                            fileInputStream = null;
                                            str4 = "finally: close and delete tmp";
                                            if (dataOutputStream != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (z16) {
                                            }
                                            aVar.f285264c = true;
                                            throw th5;
                                        }
                                    }
                                    if (str5.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                                        str5 = str5.substring(0, str5.length() - 1);
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SecSpyFileManager", 2, "url:" + str5);
                                    }
                                    httpURLConnection = (HttpURLConnection) new URL(str5).openConnection();
                                } catch (Exception e28) {
                                    e = e28;
                                    str3 = str;
                                    str4 = "finally: close and delete tmp";
                                    j16 = j3;
                                    exc = e;
                                    httpURLConnection = null;
                                    fileInputStream = null;
                                    if (QLog.isColorLevel()) {
                                    }
                                    k(j16, -1, exc.getMessage());
                                    if (dataOutputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (z16) {
                                    }
                                    aVar.f285264c = true;
                                    return false;
                                } catch (Throwable th10) {
                                    th = th10;
                                    str3 = str;
                                    str4 = "finally: close and delete tmp";
                                    th5 = th;
                                    httpURLConnection = null;
                                    fileInputStream = null;
                                    if (dataOutputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (z16) {
                                    }
                                    aVar.f285264c = true;
                                    throw th5;
                                }
                                try {
                                    httpURLConnection.setUseCaches(false);
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setRequestProperty("Cookie", "uin=o0" + this.f285252h.getCurrentAccountUin() + "; skey=" + VasSkey.getSkey((TicketManagerImpl) this.f285252h.getManager(2), this.f285252h.getCurrentAccountUin()));
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=*****");
                                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                                    try {
                                        dataOutputStream2.writeBytes("--*****\r\n");
                                        dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + substring + "\"\r\n");
                                        dataOutputStream2.writeBytes("\r\n");
                                        fileInputStream = new FileInputStream(j17);
                                        try {
                                            int available = fileInputStream.available();
                                            int min = Math.min(available, RFixConstants.MD5_FILE_BUF_LENGTH);
                                            byte[] bArr = new byte[min];
                                            aVar.f285263b = available;
                                            this.f285253i.q().postDelayed(new Runnable(aVar, j3) { // from class: com.tencent.mobileqq.secspy.SecSpyFileManager.3
                                                static IPatchRedirector $redirector_;

                                                /* renamed from: d, reason: collision with root package name */
                                                final /* synthetic */ a f285260d;

                                                /* renamed from: e, reason: collision with root package name */
                                                final /* synthetic */ long f285261e;

                                                {
                                                    this.f285260d = aVar;
                                                    this.f285261e = j3;
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                        iPatchRedirector2.redirect((short) 1, this, SecSpyFileManager.this, aVar, Long.valueOf(j3));
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                                    } else {
                                                        if (this.f285260d.f285264c) {
                                                            return;
                                                        }
                                                        SecSpyFileManager.this.k(this.f285261e, 3, Integer.valueOf((int) ((this.f285260d.f285262a / this.f285260d.f285263b) * 100.0f)));
                                                        SecSpyFileManager.this.f285253i.q().postDelayed(this, 20000L);
                                                    }
                                                }
                                            }, 20000L);
                                            int i3 = 0;
                                            int read = fileInputStream.read(bArr, 0, min);
                                            while (read > 0) {
                                                try {
                                                    dataOutputStream2.write(bArr, i3, min);
                                                    aVar.f285262a += read;
                                                    min = Math.min(fileInputStream.available(), RFixConstants.MD5_FILE_BUF_LENGTH);
                                                    read = fileInputStream.read(bArr, 0, min);
                                                    i3 = 0;
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    str3 = str;
                                                    j16 = j3;
                                                    dataOutputStream = dataOutputStream2;
                                                    str4 = "finally: close and delete tmp";
                                                    exc = e;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    k(j16, -1, exc.getMessage());
                                                    if (dataOutputStream != null) {
                                                    }
                                                    if (fileInputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (z16) {
                                                    }
                                                    aVar.f285264c = true;
                                                    return false;
                                                } catch (Throwable th11) {
                                                    th6 = th11;
                                                    str3 = str;
                                                    dataOutputStream = dataOutputStream2;
                                                    str4 = "finally: close and delete tmp";
                                                    th5 = th6;
                                                    if (dataOutputStream != null) {
                                                    }
                                                    if (fileInputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (z16) {
                                                    }
                                                    aVar.f285264c = true;
                                                    throw th5;
                                                }
                                            }
                                            dataOutputStream2.writeBytes("\r\n");
                                            dataOutputStream2.writeBytes("--*****--\r\n");
                                            int responseCode = httpURLConnection.getResponseCode();
                                            String responseMessage = httpURLConnection.getResponseMessage();
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SecSpyFileManager", 2, "" + responseCode + ",  " + responseMessage);
                                            }
                                            dataOutputStream2.flush();
                                            dataOutputStream2.close();
                                            fileInputStream.close();
                                            boolean z17 = responseCode == 200;
                                            try {
                                                dataOutputStream2.close();
                                                httpURLConnection.disconnect();
                                                if (z16) {
                                                    File j28 = j(str + this.f285251f);
                                                    if (j28 != null && j28.exists()) {
                                                        j28.delete();
                                                    }
                                                }
                                                aVar.f285264c = true;
                                                return z17;
                                            } catch (Exception e36) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("SecSpyFileManager", 2, "finally: close and delete tmp", e36);
                                                }
                                                e36.printStackTrace();
                                                return z17;
                                            }
                                        } catch (Exception e37) {
                                            e = e37;
                                            str3 = str;
                                            str4 = "finally: close and delete tmp";
                                            j16 = j3;
                                            dataOutputStream = dataOutputStream2;
                                            exc = e;
                                            if (QLog.isColorLevel()) {
                                            }
                                            k(j16, -1, exc.getMessage());
                                            if (dataOutputStream != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (z16) {
                                            }
                                            aVar.f285264c = true;
                                            return false;
                                        } catch (Throwable th12) {
                                            th6 = th12;
                                            str3 = str;
                                            str4 = "finally: close and delete tmp";
                                            dataOutputStream = dataOutputStream2;
                                            th5 = th6;
                                            if (dataOutputStream != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (z16) {
                                            }
                                            aVar.f285264c = true;
                                            throw th5;
                                        }
                                    } catch (Exception e38) {
                                        e = e38;
                                        str3 = str;
                                        str4 = "finally: close and delete tmp";
                                        j16 = j3;
                                        fileInputStream = null;
                                    } catch (Throwable th13) {
                                        th6 = th13;
                                        str3 = str;
                                        str4 = "finally: close and delete tmp";
                                        fileInputStream = null;
                                    }
                                } catch (Exception e39) {
                                    str3 = str;
                                    str4 = "finally: close and delete tmp";
                                    j16 = j3;
                                    exc = e39;
                                    fileInputStream = null;
                                } catch (Throwable th14) {
                                    str3 = str;
                                    str4 = "finally: close and delete tmp";
                                    th5 = th14;
                                    fileInputStream = null;
                                    if (dataOutputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (z16) {
                                    }
                                    aVar.f285264c = true;
                                    throw th5;
                                }
                            } catch (Exception e46) {
                                exc = e46;
                                j16 = j3;
                                str4 = "finally: close and delete tmp";
                                fileInputStream = null;
                                str3 = str;
                                httpURLConnection = null;
                            } catch (Throwable th15) {
                                th5 = th15;
                                str3 = str;
                                str4 = "finally: close and delete tmp";
                                httpURLConnection = null;
                                fileInputStream = null;
                                if (dataOutputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (z16) {
                                }
                                aVar.f285264c = true;
                                throw th5;
                            }
                        }
                    } catch (Exception e47) {
                        e = e47;
                        str3 = str;
                        str4 = "finally: close and delete tmp";
                    }
                }
                str3 = str;
                str4 = "finally: close and delete tmp";
            } catch (Throwable th16) {
                th = th16;
                str3 = str;
                str4 = "finally: close and delete tmp";
            }
            try {
                try {
                    j16 = j3;
                    try {
                        k(j16, -1, F);
                        if (QLog.isColorLevel()) {
                            QLog.d("SecSpyFileManager", 2, "can not get file, " + str3);
                        }
                        if (z16) {
                            try {
                                File j29 = j(str3 + this.f285251f);
                                if (j29 != null && j29.exists()) {
                                    j29.delete();
                                }
                            } catch (Exception e48) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SecSpyFileManager", 2, str4, e48);
                                }
                                e48.printStackTrace();
                                return false;
                            }
                        }
                        aVar.f285264c = true;
                        return false;
                    } catch (Exception e49) {
                        e = e49;
                        exc = e;
                        httpURLConnection = null;
                        fileInputStream = null;
                        if (QLog.isColorLevel()) {
                        }
                        k(j16, -1, exc.getMessage());
                        if (dataOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (z16) {
                        }
                        aVar.f285264c = true;
                        return false;
                    }
                } catch (Exception e56) {
                    e = e56;
                    j16 = j3;
                    exc = e;
                    httpURLConnection = null;
                    fileInputStream = null;
                    if (QLog.isColorLevel()) {
                        QLog.e("SecSpyFileManager", 2, "can not upload file", exc);
                    }
                    k(j16, -1, exc.getMessage());
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e57) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SecSpyFileManager", 2, str4, e57);
                            }
                            e57.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (z16) {
                        File j36 = j(str3 + this.f285251f);
                        if (j36 != null && j36.exists()) {
                            j36.delete();
                        }
                    }
                    aVar.f285264c = true;
                    return false;
                }
            } catch (Throwable th17) {
                th = th17;
                th5 = th;
                httpURLConnection = null;
                fileInputStream = null;
                if (dataOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                if (z16) {
                }
                aVar.f285264c = true;
                throw th5;
            }
        } catch (Exception e58) {
            e = e58;
            j16 = j3;
            str4 = "finally: close and delete tmp";
            str3 = str;
        }
    }

    public void r(List<String> list, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, Long.valueOf(j3), str);
            return;
        }
        p(this.f285253i.J(list), j3, str, false);
        d.a(list);
        list.clear();
    }
}
