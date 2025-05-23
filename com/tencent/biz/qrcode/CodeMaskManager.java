package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.common.BitMatrix;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.java_websocket.WebSocketImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CodeMaskManager {

    /* renamed from: j, reason: collision with root package name */
    private static final String f94558j;

    /* renamed from: a, reason: collision with root package name */
    protected List<Bundle> f94559a;

    /* renamed from: c, reason: collision with root package name */
    protected Activity f94561c;

    /* renamed from: d, reason: collision with root package name */
    protected Thread f94562d;

    /* renamed from: f, reason: collision with root package name */
    protected int f94564f;

    /* renamed from: g, reason: collision with root package name */
    protected Handler f94565g;

    /* renamed from: i, reason: collision with root package name */
    private Bundle f94567i;

    /* renamed from: e, reason: collision with root package name */
    protected int f94563e = -1;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f94566h = false;

    /* renamed from: b, reason: collision with root package name */
    protected List<Bundle> f94560b = new Vector();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class PrepareBundleTask extends BaseThread {
        AtomicBoolean C;
        a D;
        Bundle E;

        PrepareBundleTask(a aVar, Bundle bundle) {
            super("qr_code_mask_prepare_thread");
            this.C = new AtomicBoolean(false);
            this.D = aVar;
            this.E = bundle;
        }

        Bundle o() {
            BitMatrix bitMatrix;
            try {
                try {
                    if (this.E.containsKey("qrsz")) {
                        String data = ((QRDisplayActivity) CodeMaskManager.this.f94561c).getData();
                        if (!TextUtils.isEmpty(data)) {
                            try {
                                bitMatrix = h.o(data, this.E.getInt("qrsz"));
                            } catch (Exception unused) {
                                bitMatrix = null;
                            }
                            if (bitMatrix == null) {
                                return null;
                            }
                        }
                    }
                    if (this.E.containsKey("bkgUrl")) {
                        this.E.putParcelable("bkg", CodeMaskManager.this.h(this.E.getString("bkgUrl")));
                        this.E.remove("bkgUrl");
                    }
                    if (this.E.containsKey("qrbkgUrl")) {
                        this.E.putParcelable("qrbkg", CodeMaskManager.this.h(this.E.getString("qrbkgUrl")));
                        this.E.remove("qrbkgUrl");
                    }
                    return this.E;
                } catch (IOException unused2) {
                    return null;
                }
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("CodeMaskManager", 2, e16.getMessage());
                }
                System.gc();
                return null;
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            final Bundle o16 = o();
            if (this.C.compareAndSet(false, true)) {
                CodeMaskManager.this.f94565g.post(new Runnable() { // from class: com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PrepareBundleTask prepareBundleTask = PrepareBundleTask.this;
                        CodeMaskManager codeMaskManager = CodeMaskManager.this;
                        if (codeMaskManager.f94566h) {
                            return;
                        }
                        Bundle bundle = o16;
                        if (bundle == null) {
                            prepareBundleTask.D.o0(codeMaskManager.f());
                        } else {
                            prepareBundleTask.D.o0((Bundle) bundle.clone());
                        }
                        CodeMaskManager.this.o();
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void o0(Bundle bundle);
    }

    static {
        if (cu.e()) {
            f94558j = AppConstants.SDCARD_PATH + "qbiz/qrcode/";
            return;
        }
        f94558j = BaseApplication.getContext().getCacheDir().getAbsolutePath() + "/qbiz/qrcode/";
    }

    public CodeMaskManager(Activity activity, int i3) {
        this.f94561c = activity;
        i(i3);
        this.f94559a = this.f94560b;
        n(j());
        this.f94565g = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle f() {
        return g(this.f94560b.get(k(this.f94560b.size())));
    }

    private Bundle g(Bundle bundle) {
        if (bundle.containsKey("bkgRes")) {
            int i3 = bundle.getInt("bkgRes");
            bundle.remove("bkg");
            if (i3 != 0) {
                try {
                    bundle.putParcelable("bkg", BitmapFactory.decodeResource(this.f94561c.getResources(), i3));
                } catch (OutOfMemoryError unused) {
                }
            }
        }
        if (bundle.containsKey("qrbkgRes")) {
            int i16 = bundle.getInt("qrbkgRes");
            bundle.remove("qrbkg");
            if (i16 != 0) {
                try {
                    bundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.f94561c.getResources(), i16));
                } catch (OutOfMemoryError unused2) {
                }
            }
        }
        return (Bundle) bundle.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap h(String str) throws IOException {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap;
        BufferedInputStream bufferedInputStream2 = null;
        if (str == null || str.equals("")) {
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            str = "https://pub.idqqimg.com/qqmobile/qrcode/images/" + str;
        }
        String fileName = AbsDownloader.getFileName(str);
        try {
            fileInputStream = new FileInputStream(f94558j + fileName);
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
        } catch (Exception e17) {
            e = e17;
            bufferedInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (bufferedInputStream2 != null) {
            }
            if (fileInputStream == null) {
            }
        }
        try {
            try {
                bitmap = BitmapFactory.decodeStream(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (fileInputStream == null) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (IOException unused3) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            if (QLog.isColorLevel()) {
                QLog.d("CodeMaskManager", 2, e.getMessage());
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused4) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            }
            bitmap = null;
            if (bitmap == null) {
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException unused6) {
            if (bitmap == null) {
                return bitmap;
            }
            byte[] openUrlForByte = HttpUtil.openUrlForByte(this.f94561c, MsfSdkUtils.insertMtype("codemask", str), "GET", null, null);
            if (openUrlForByte != null) {
                bitmap = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length);
            }
            if (bitmap != null) {
                p(fileName, openUrlForByte);
                return bitmap;
            }
            throw new IOException(HardCodeUtil.qqStr(R.string.ks_));
        }
    }

    private void i(int i3) {
        Bundle bundle = new Bundle();
        if (i3 == 1) {
            bundle.putInt("qrbkgRes", R.drawable.dul);
            bundle.putInt("bkgRes", 0);
            bundle.putInt("nameClr", -16777216);
            bundle.putInt("tipsClr", RichStatus.ACTION_COLOR_NORMAL);
            bundle.putInt("B", 0);
            bundle.putInt("W", -1);
            bundle.putParcelable("qrloc", new Rect(126, 156, 413, WebSocketImpl.DEFAULT_WSS_PORT));
            bundle.putInt("head", 0);
            bundle.putInt("type", 1);
        } else {
            bundle.putInt("bkgRes", 0);
            bundle.putInt("nameClr", -16777216);
            bundle.putInt("tipsClr", RichStatus.ACTION_COLOR_NORMAL);
            bundle.putInt("B", -16777216);
            bundle.putInt("W", 16777215);
            bundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
            bundle.putInt("head", 1);
            bundle.putInt("type", 1);
        }
        this.f94560b.add(bundle);
    }

    private int j() {
        try {
            String string = this.f94561c.getSharedPreferences("qrcode", 0).getString("tpl_json", null);
            if (string == null) {
                return 0;
            }
            JSONObject jSONObject = new JSONObject(string);
            JSONArray jSONArray = jSONObject.getJSONArray("tpls");
            if (jSONArray.length() <= 0) {
                return 0;
            }
            m(jSONArray);
            return jSONObject.getInt("t");
        } catch (JSONException unused) {
            return 0;
        }
    }

    private int k(int i3) {
        if (i3 >= 1) {
            int i16 = 0;
            if (i3 != 1) {
                if (this.f94563e == -1) {
                    int i17 = this.f94561c.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
                    if (i17 >= 0 && i17 < i3) {
                        i16 = i17;
                    }
                } else {
                    i16 = (int) (Math.random() * (i3 - 1));
                    if (i16 >= this.f94563e) {
                        i16++;
                    }
                }
            }
            this.f94564f = i16;
            return i16;
        }
        throw new IllegalArgumentException("qrcode mask build-in list should have at least 1 item");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void m(JSONArray jSONArray) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        CodeMaskManager codeMaskManager;
        String str5;
        int i16;
        CodeMaskManager codeMaskManager2 = this;
        String str6 = "v";
        String str7 = "qrbkg";
        String str8 = "tipsClr";
        String str9 = "nameClr";
        String str10 = "bkg";
        if (codeMaskManager2.f94566h) {
            return;
        }
        codeMaskManager2.f94559a = new Vector(codeMaskManager2.f94560b);
        int i17 = 0;
        while (i17 < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i17);
                Bundle bundle = new Bundle();
                if (jSONObject.has(str10)) {
                    i3 = i17;
                    try {
                        bundle.putString("bkgUrl", jSONObject.getString(str10));
                    } catch (JSONException unused) {
                        str = str7;
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        String str11 = str6;
                        codeMaskManager = codeMaskManager2;
                        str5 = str11;
                        i17 = i3 + 1;
                        str9 = str3;
                        str7 = str;
                        str8 = str2;
                        str10 = str4;
                        CodeMaskManager codeMaskManager3 = codeMaskManager;
                        str6 = str5;
                        codeMaskManager2 = codeMaskManager3;
                    }
                } else {
                    i3 = i17;
                }
                String str12 = str6;
                try {
                    bundle.putInt(str9, (int) Long.parseLong(jSONObject.getString(str9), 16));
                    bundle.putInt(str8, (int) Long.parseLong(jSONObject.getString(str8), 16));
                    if (jSONObject.has(str7)) {
                        bundle.putString("qrbkgUrl", jSONObject.getString(str7));
                    }
                    if (jSONObject.has("qrloc")) {
                        try {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("qrloc");
                            str = str7;
                            try {
                                str2 = str8;
                                try {
                                    bundle.putParcelable("qrloc", new Rect(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(0) + jSONArray2.getInt(2), jSONArray2.getInt(1) + jSONArray2.getInt(3)));
                                } catch (JSONException unused2) {
                                    codeMaskManager = this;
                                    str3 = str9;
                                    str4 = str10;
                                    str5 = str12;
                                    i17 = i3 + 1;
                                    str9 = str3;
                                    str7 = str;
                                    str8 = str2;
                                    str10 = str4;
                                    CodeMaskManager codeMaskManager32 = codeMaskManager;
                                    str6 = str5;
                                    codeMaskManager2 = codeMaskManager32;
                                }
                            } catch (JSONException unused3) {
                                str2 = str8;
                                codeMaskManager = this;
                                str3 = str9;
                                str4 = str10;
                                str5 = str12;
                                i17 = i3 + 1;
                                str9 = str3;
                                str7 = str;
                                str8 = str2;
                                str10 = str4;
                                CodeMaskManager codeMaskManager322 = codeMaskManager;
                                str6 = str5;
                                codeMaskManager2 = codeMaskManager322;
                            }
                        } catch (JSONException unused4) {
                            str = str7;
                        }
                    } else {
                        str = str7;
                        str2 = str8;
                    }
                    if (jSONObject.has("qrsz")) {
                        bundle.putInt("qrsz", jSONObject.getInt("qrsz"));
                    }
                    if (jSONObject.has("clip")) {
                        try {
                            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                            JSONArray jSONArray3 = jSONObject.getJSONArray("clip");
                            int i18 = 0;
                            while (i18 < jSONArray3.length()) {
                                JSONArray jSONArray4 = jSONArray3.getJSONArray(i18);
                                JSONArray jSONArray5 = jSONArray3;
                                str3 = str9;
                                try {
                                    str4 = str10;
                                    try {
                                        arrayList.add(new Rect(jSONArray4.getInt(0), jSONArray4.getInt(1), jSONArray4.getInt(0) + jSONArray4.getInt(2), jSONArray4.getInt(1) + jSONArray4.getInt(3)));
                                        i18++;
                                        jSONArray3 = jSONArray5;
                                        str9 = str3;
                                        str10 = str4;
                                    } catch (JSONException unused5) {
                                        codeMaskManager = this;
                                        str5 = str12;
                                        i17 = i3 + 1;
                                        str9 = str3;
                                        str7 = str;
                                        str8 = str2;
                                        str10 = str4;
                                        CodeMaskManager codeMaskManager3222 = codeMaskManager;
                                        str6 = str5;
                                        codeMaskManager2 = codeMaskManager3222;
                                    }
                                } catch (JSONException unused6) {
                                    str4 = str10;
                                    codeMaskManager = this;
                                    str5 = str12;
                                    i17 = i3 + 1;
                                    str9 = str3;
                                    str7 = str;
                                    str8 = str2;
                                    str10 = str4;
                                    CodeMaskManager codeMaskManager32222 = codeMaskManager;
                                    str6 = str5;
                                    codeMaskManager2 = codeMaskManager32222;
                                }
                            }
                            str3 = str9;
                            str4 = str10;
                            bundle.putParcelableArrayList("clip", arrayList);
                        } catch (JSONException unused7) {
                            str3 = str9;
                        }
                    } else {
                        str3 = str9;
                        str4 = str10;
                    }
                    bundle.putInt("B", (int) Long.parseLong(jSONObject.getString("B"), 16));
                    if (jSONObject.has("W")) {
                        bundle.putInt("W", (int) Long.parseLong(jSONObject.getString("W"), 16));
                    } else {
                        bundle.putInt("W", 16777215);
                    }
                    try {
                        bundle.putInt("head", jSONObject.getInt("head"));
                    } catch (Exception unused8) {
                        if (jSONObject.getBoolean("head")) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        bundle.putInt("head", i16);
                    }
                    str5 = str12;
                    try {
                        bundle.putInt(str5, jSONObject.getInt(str5));
                        bundle.putInt("type", 2);
                        codeMaskManager = this;
                        try {
                            codeMaskManager.f94559a.add(bundle);
                        } catch (JSONException unused9) {
                        }
                    } catch (JSONException unused10) {
                        codeMaskManager = this;
                    }
                } catch (JSONException unused11) {
                    codeMaskManager = this;
                    str = str7;
                    str2 = str8;
                }
            } catch (JSONException unused12) {
                str = str7;
                str2 = str8;
                str3 = str9;
                str4 = str10;
                i3 = i17;
            }
            i17 = i3 + 1;
            str9 = str3;
            str7 = str;
            str8 = str2;
            str10 = str4;
            CodeMaskManager codeMaskManager322222 = codeMaskManager;
            str6 = str5;
            codeMaskManager2 = codeMaskManager322222;
        }
    }

    private void n(final int i3) {
        if (this.f94562d != null) {
            return;
        }
        final SharedPreferences sharedPreferences = this.f94561c.getSharedPreferences("qrcode", 0);
        if (System.currentTimeMillis() - sharedPreferences.getLong("updateTemplate2", 0L) < 86400000) {
            return;
        }
        Display defaultDisplay = ((WindowManager) this.f94561c.getSystemService("window")).getDefaultDisplay();
        final int height = defaultDisplay.getHeight();
        final int width = defaultDisplay.getWidth();
        BaseThread baseThread = new BaseThread("qr_code_mask_update_extenal_thread") { // from class: com.tencent.biz.qrcode.CodeMaskManager.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong("updateTemplate2", System.currentTimeMillis());
                String str = "https://qm.qq.com/cgi-bin/tpl?v=1&os=a&resx=" + width + "&resy=" + height + "&t=" + i3 + ContainerUtils.FIELD_DELIMITER + HttpMsg.MTYPE + ContainerUtils.KEY_VALUE_DELIMITER + AppConstants.HTTP_TYPE_QB_QRCODE;
                try {
                    String openUrl = HttpUtil.openUrl(CodeMaskManager.this.f94561c, str, "GET", null, null);
                    if (QLog.isColorLevel()) {
                        QLog.d("QRHttpUtil", 2, "open :" + str + ", result: " + openUrl);
                    }
                    JSONObject jSONObject = new JSONObject(openUrl);
                    if (jSONObject.getInt("r") == 0) {
                        final JSONArray jSONArray = jSONObject.getJSONArray("tpls");
                        if (jSONArray.length() > 0) {
                            CodeMaskManager.this.f94565g.post(new Runnable() { // from class: com.tencent.biz.qrcode.CodeMaskManager.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    CodeMaskManager codeMaskManager = CodeMaskManager.this;
                                    if (!codeMaskManager.f94566h) {
                                        codeMaskManager.m(jSONArray);
                                    }
                                }
                            });
                            edit.putString("tpl_json", openUrl);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QRHttpUtil", 2, e16.getMessage());
                    }
                    edit.putLong("updateTemplate2", 0L);
                }
                edit.commit();
                CodeMaskManager.this.f94562d = null;
            }
        };
        this.f94562d = baseThread;
        baseThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f94563e = this.f94564f;
        SharedPreferences.Editor edit = this.f94561c.getSharedPreferences("qrcode", 0).edit();
        edit.putInt("lastIndex", this.f94563e);
        edit.commit();
    }

    private boolean p(String str, byte[] bArr) {
        if (bArr != null) {
            FileOutputStream fileOutputStream = null;
            try {
                String str2 = f94558j;
                new File(str2).mkdirs();
                File file = new File(str2 + str);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException unused) {
                        return true;
                    }
                } catch (IOException unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    fileOutputStream = fileOutputStream2;
                    th = th5;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return false;
    }

    public void e(final a aVar, boolean z16, boolean z17, int i3, boolean z18) {
        if (this.f94566h) {
            return;
        }
        int i16 = 0;
        if (z18) {
            new Bundle();
            Bundle bundle = new Bundle();
            bundle.putInt("bkgRes", 0);
            bundle.putInt("nameClr", -16777216);
            bundle.putInt("tipsClr", RichStatus.ACTION_COLOR_NORMAL);
            bundle.putInt("W", 16777215);
            bundle.putInt("B", -16777216);
            bundle.putInt("head", 0);
            bundle.putInt("type", 1);
            aVar.o0(g(bundle));
            return;
        }
        if (z16 && z17 && (i3 == 2 || i3 == 1)) {
            if (this.f94567i == null) {
                Bundle bundle2 = new Bundle();
                this.f94567i = bundle2;
                bundle2.putInt("bkgRes", 0);
                this.f94567i.putInt("nameClr", -16777216);
                this.f94567i.putInt("tipsClr", RichStatus.ACTION_COLOR_NORMAL);
                this.f94567i.putInt("W", 0);
                this.f94567i.putInt("B", -9947128);
                if (i3 == 2) {
                    this.f94567i.putInt("head", 3);
                } else if (i3 == 1) {
                    this.f94567i.putInt("head", 4);
                }
                this.f94567i.putInt("type", 1);
            }
            aVar.o0(g(this.f94567i));
            return;
        }
        int k3 = k(this.f94559a.size());
        if (k3 >= 0 && k3 < this.f94559a.size()) {
            i16 = k3;
        }
        Bundle bundle3 = this.f94559a.get(i16);
        if (bundle3.getInt("type") == 1) {
            aVar.o0(g(bundle3));
            o();
        } else {
            final PrepareBundleTask prepareBundleTask = new PrepareBundleTask(aVar, bundle3);
            this.f94565g.postDelayed(new Runnable() { // from class: com.tencent.biz.qrcode.CodeMaskManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!CodeMaskManager.this.f94566h && prepareBundleTask.C.compareAndSet(false, true)) {
                        aVar.o0(CodeMaskManager.this.f());
                        CodeMaskManager.this.o();
                    }
                }
            }, 10000L);
            prepareBundleTask.start();
        }
    }

    public void l() {
        this.f94566h = true;
        for (Bundle bundle : this.f94559a) {
            Bitmap bitmap = (Bitmap) bundle.getParcelable("bkg");
            if (bitmap != null) {
                bitmap.recycle();
            }
            Bitmap bitmap2 = (Bitmap) bundle.getParcelable("qrbkg");
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        }
        this.f94560b.clear();
        this.f94559a.clear();
    }
}
