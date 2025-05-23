package com.tencent.mobileqq.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import org.apache.commons.fileupload.MultipartStream;
import protocol.KQQConfig.GetResourceRespInfoV2;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g implements IHttpCommunicatorListener {
    public static final byte[] D = {-16, 68, 31, 95, -12, MultipartStream.DASH, -91, -113, -36, -9, -108, -102, -70, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, -44, 17};
    private static int E = 1;
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private Timer f202872d;

    /* renamed from: e, reason: collision with root package name */
    public a f202873e = new a();

    /* renamed from: f, reason: collision with root package name */
    private boolean f202874f = false;

    /* renamed from: h, reason: collision with root package name */
    private int[] f202875h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    private File f202876i;

    /* renamed from: m, reason: collision with root package name */
    String f202877m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f202878a = "";

        /* renamed from: b, reason: collision with root package name */
        public byte f202879b = 0;

        /* renamed from: c, reason: collision with root package name */
        public byte f202880c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f202881d = "";

        a() {
        }
    }

    public g(Context context, String str) {
        String str2 = context.getFilesDir().getAbsolutePath() + "/" + str;
        File file = new File(str2);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
        this.f202877m = context.getFilesDir().getAbsolutePath() + "/" + str + "/qq_config.dat";
        if (QLog.isDevelopLevel()) {
            QLog.i("SPLASH_ConfigServlet", 4, "savePointFilePath == " + this.f202877m);
        }
        File file2 = new File(str2, "qq_config.dat");
        this.f202876i = file2;
        try {
            if (!file2.exists()) {
                this.f202876i.createNewFile();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f202872d = ThreadManagerV2.getTimer();
        this.C = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, int i3) {
        if (i3 > 0) {
            if (str.indexOf("g_q=") != -1) {
                return str;
            }
            if (str.indexOf(63) > 0) {
                if (str.endsWith("g_q=")) {
                    return str + i3;
                }
                return str + "&g_q=" + i3;
            }
            return str + "?g_q=" + i3;
        }
        return str;
    }

    public static ResourcePluginInfo e(EntityManager entityManager, boolean z16, GetResourceRespInfoV2 getResourceRespInfoV2) {
        String str;
        ResourcePluginInfo resourcePluginInfo = new ResourcePluginInfo();
        resourcePluginInfo.strPkgName = getResourceRespInfoV2.strPkgName;
        resourcePluginInfo.strResName = getResourceRespInfoV2.strResName;
        if (z16) {
            str = getResourceRespInfoV2.strResURL_big;
        } else {
            str = getResourceRespInfoV2.strResURL_small;
        }
        resourcePluginInfo.strResURL = str;
        resourcePluginInfo.uiCurVer = getResourceRespInfoV2.uiNewVer;
        resourcePluginInfo.sLanType = getResourceRespInfoV2.sLanType;
        resourcePluginInfo.sResSubType = getResourceRespInfoV2.sResSubType;
        if (QLog.isColorLevel()) {
            QLog.i("ConfigManager", 2, "plugin config xml:" + getResourceRespInfoV2.strResConf);
        }
        HashMap<String, String> l3 = h.l(getResourceRespInfoV2.strResConf);
        if (l3 != null) {
            resourcePluginInfo.strGotoUrl = l3.get("pluginEntranceUrl");
            String str2 = l3.get("newswitch");
            if (str2 != null) {
                try {
                    if (((byte) Integer.parseInt(str2)) == 0) {
                        resourcePluginInfo.isNew = (byte) 1;
                    } else {
                        resourcePluginInfo.isNew = (byte) 0;
                    }
                } catch (Exception unused) {
                }
            }
            try {
                resourcePluginInfo.lebaSearchResultType = Integer.parseInt(l3.get("pluginType"));
            } catch (Exception unused2) {
                resourcePluginInfo.lebaSearchResultType = -1;
            }
            resourcePluginInfo.pluginSetTips = l3.get("pluginSetTips");
            resourcePluginInfo.pluginBg = l3.get(TextEditorData.BACKGROUND);
            String str3 = l3.get("fullConfig");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    if (Integer.parseInt(str3) == 1) {
                        resourcePluginInfo.enableFlag(1);
                    } else {
                        resourcePluginInfo.disableFlag(1);
                    }
                } catch (Exception unused3) {
                }
                if (QLog.isColorLevel()) {
                    QLog.i("WholePeopleLebaEntryChecker", 2, "fullConfig " + str3);
                }
            }
        } else {
            resourcePluginInfo.strGotoUrl = "";
            resourcePluginInfo.isNew = (byte) 0;
            resourcePluginInfo.lebaSearchResultType = -1;
            resourcePluginInfo.pluginSetTips = "";
            resourcePluginInfo.pluginBg = null;
        }
        resourcePluginInfo.strNewPluginDesc = getResourceRespInfoV2.strNewPluginDesc;
        resourcePluginInfo.strNewPluginURL = getResourceRespInfoV2.strNewPluginURL;
        resourcePluginInfo.sPriority = getResourceRespInfoV2.sPriority;
        resourcePluginInfo.strResDesc = getResourceRespInfoV2.strResDesc;
        resourcePluginInfo.cCanChangeState = getResourceRespInfoV2.cCanChangeState;
        byte b16 = getResourceRespInfoV2.cDefaultState;
        resourcePluginInfo.cDefaultState = b16;
        resourcePluginInfo.uiResId = getResourceRespInfoV2.uiResId;
        if (b16 == 0) {
            resourcePluginInfo.cLocalState = (byte) 1;
        } else if (b16 == 1) {
            resourcePluginInfo.cLocalState = (byte) 0;
        }
        resourcePluginInfo.iPluginType = getResourceRespInfoV2.iPluginType;
        ResourcePluginInfo.persistOrReplace(entityManager, resourcePluginInfo);
        return resourcePluginInfo;
    }

    private void g(com.tencent.mobileqq.config.struct.b bVar, DataInputStream dataInputStream) throws Exception {
        bVar.f(dataInputStream);
    }

    public static final int h() {
        int i3 = E;
        E = i3 + 1;
        return i3;
    }

    public boolean b() {
        byte b16 = this.f202873e.f202879b;
        if (b16 == 1 || b16 == 2) {
            return true;
        }
        return false;
    }

    public void c() {
        try {
            File file = this.f202876i;
            if (file != null && file.exists()) {
                this.f202876i.delete();
                this.f202876i = null;
            }
        } catch (Exception unused) {
        }
    }

    public void d() {
        this.f202874f = true;
        ArrayList<f> d16 = e.d();
        if (d16 != null) {
            Iterator<f> it = d16.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        if (QLog.isColorLevel()) {
            QLog.d("ShanPing", 2, "config-huibao--decode------------");
        }
        byte[] recvData = httpMsg2.getRecvData();
        try {
            synchronized (this.f202875h) {
                if (this.f202874f) {
                    return;
                }
                h.f(recvData, new i(), this.C);
                b();
                d();
            }
        } catch (RuntimeException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b A[LOOP:1: B:44:0x009b->B:46:0x00a0, LOOP_START, PHI: r3
  0x009b: PHI (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:43:0x0099, B:46:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        boolean z16;
        DataInputStream dataInputStream;
        Throwable th5;
        Exception e16;
        File file = this.f202876i;
        DataInputStream dataInputStream2 = null;
        if (file != null && file.exists() && this.f202876i.canRead() && this.f202876i.length() > 0) {
            try {
                fileInputStream = new FileInputStream(this.f202876i);
            } catch (Exception unused) {
                fileInputStream = null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (Exception unused2) {
                bufferedInputStream = null;
                int i3 = 0;
                if (bufferedInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (dataInputStream2 != null) {
                }
                z16 = false;
                if (!z16) {
                }
            }
        } else {
            fileInputStream = null;
            bufferedInputStream = null;
        }
        int i36 = 0;
        if (bufferedInputStream != null) {
            z16 = true;
            try {
                if (bufferedInputStream.available() > 0) {
                    dataInputStream = new DataInputStream(bufferedInputStream);
                    int i16 = 0;
                    while (true) {
                        try {
                            try {
                                com.tencent.mobileqq.config.struct.b[] bVarArr = e.f202869g;
                                if (i16 >= bVarArr.length) {
                                    break;
                                }
                                com.tencent.mobileqq.config.struct.b bVar = bVarArr[i16];
                                g(bVar, dataInputStream);
                                byte b16 = bVar.f202976m;
                                if ((b16 == 1 || b16 == 0) && bVar.e()) {
                                    bVar.b();
                                }
                                i16++;
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception unused4) {
                                }
                                if (dataInputStream == null) {
                                    try {
                                        dataInputStream.close();
                                        throw th5;
                                    } catch (Exception unused5) {
                                        throw th5;
                                    }
                                }
                                throw th5;
                            }
                        } catch (Exception e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused6) {
                                }
                            }
                            try {
                                bufferedInputStream.close();
                            } catch (Exception unused7) {
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception unused8) {
                                }
                            }
                            if (!z16) {
                            }
                        }
                    }
                    dataInputStream2 = dataInputStream;
                }
            } catch (Exception e18) {
                dataInputStream = null;
                e16 = e18;
            } catch (Throwable th7) {
                dataInputStream = null;
                th5 = th7;
                if (fileInputStream != null) {
                }
                bufferedInputStream.close();
                if (dataInputStream == null) {
                }
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception unused9) {
            }
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (Exception unused10) {
            }
        }
        if (dataInputStream2 != null) {
            try {
                dataInputStream2.close();
            } catch (Exception unused11) {
            }
        }
        z16 = false;
        if (!z16) {
            return;
        }
        while (true) {
            com.tencent.mobileqq.config.struct.b[] bVarArr2 = e.f202869g;
            if (i36 < bVarArr2.length) {
                bVarArr2[i36].b();
                i36++;
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        d();
    }

    public void i() {
        DataOutputStream dataOutputStream;
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        File file = new File(this.f202877m);
        this.f202876i = file;
        try {
            if (!file.exists()) {
                this.f202876i.createNewFile();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        File file2 = this.f202876i;
        if (file2 != null && file2.exists()) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f202876i));
                try {
                    dataOutputStream = new DataOutputStream(bufferedOutputStream);
                    int i3 = 0;
                    while (true) {
                        try {
                            com.tencent.mobileqq.config.struct.b[] bVarArr = e.f202869g;
                            if (i3 < bVarArr.length) {
                                j(bVarArr[i3], dataOutputStream);
                                i3++;
                            } else {
                                try {
                                    break;
                                } catch (Exception unused) {
                                }
                            }
                        } catch (Exception unused2) {
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            this.f202876i.delete();
                            return;
                        } catch (Throwable th6) {
                            th5 = th6;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                    throw th5;
                                } catch (Exception unused6) {
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    }
                    bufferedOutputStream.close();
                    try {
                        dataOutputStream.close();
                    } catch (Exception unused7) {
                    }
                } catch (Exception unused8) {
                    dataOutputStream = null;
                } catch (Throwable th7) {
                    dataOutputStream = null;
                    th5 = th7;
                }
            } catch (Exception unused9) {
                dataOutputStream = null;
            } catch (Throwable th8) {
                dataOutputStream = null;
                th5 = th8;
                bufferedOutputStream = null;
            }
        }
    }

    public void j(com.tencent.mobileqq.config.struct.b bVar, DataOutputStream dataOutputStream) throws Exception {
        bVar.i(dataOutputStream);
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        return true;
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
    }
}
