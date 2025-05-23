package com.tencent.mobileqq.config.struct;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.e;
import com.tencent.mobileqq.config.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.MD5;
import okhttp3.HttpUrl;

/* loaded from: classes10.dex */
public class PicAndAdConf extends b implements IHttpCommunicatorListener {
    public boolean E;
    private HashSet<String> F;
    private HashMap<String, Long> G;

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        protected long f202950a = 0;

        /* renamed from: b, reason: collision with root package name */
        protected String f202951b = null;

        /* renamed from: c, reason: collision with root package name */
        protected String f202952c = null;

        /* renamed from: d, reason: collision with root package name */
        protected String f202953d = null;

        /* renamed from: e, reason: collision with root package name */
        protected byte[] f202954e = null;

        /* renamed from: f, reason: collision with root package name */
        protected String f202955f = null;

        /* renamed from: g, reason: collision with root package name */
        protected byte f202956g = 3;

        /* renamed from: h, reason: collision with root package name */
        protected String f202957h = "";

        /* renamed from: i, reason: collision with root package name */
        protected short f202958i = 0;

        /* renamed from: j, reason: collision with root package name */
        protected String f202959j = "";

        /* renamed from: k, reason: collision with root package name */
        protected int f202960k = 0;

        /* renamed from: l, reason: collision with root package name */
        protected boolean f202961l = true;

        public a() {
        }

        public void a(DataInputStream dataInputStream) throws Exception {
            this.f202950a = dataInputStream.readLong();
            this.f202951b = dataInputStream.readUTF();
            this.f202952c = dataInputStream.readUTF();
            this.f202955f = dataInputStream.readUTF();
            this.f202956g = dataInputStream.readByte();
            this.f202953d = dataInputStream.readUTF();
            this.f202957h = dataInputStream.readUTF();
            this.f202958i = dataInputStream.readShort();
        }

        public void b(DataInputStream dataInputStream) throws Exception {
            a(dataInputStream);
            this.f202959j = dataInputStream.readUTF();
        }

        public void c(DataOutputStream dataOutputStream) throws Exception {
            if (this.f202951b == null) {
                this.f202951b = "";
            }
            if (this.f202952c == null) {
                this.f202952c = "";
            }
            if (this.f202955f == null) {
                this.f202955f = "";
            }
            if (this.f202953d == null) {
                this.f202953d = "";
            }
            dataOutputStream.writeLong(this.f202950a);
            dataOutputStream.writeUTF(this.f202951b);
            dataOutputStream.writeUTF(this.f202952c);
            dataOutputStream.writeUTF(this.f202955f);
            dataOutputStream.writeByte(this.f202956g);
            dataOutputStream.writeUTF(this.f202953d);
            dataOutputStream.writeUTF(this.f202957h);
            dataOutputStream.writeShort(this.f202958i);
        }

        public void d(DataOutputStream dataOutputStream) throws Exception {
            c(dataOutputStream);
            if (this.f202959j == null) {
                this.f202959j = "";
            }
            dataOutputStream.writeUTF(this.f202959j);
        }
    }

    public PicAndAdConf(short s16, byte b16) {
        super(s16, b16);
        this.E = true;
        this.G = new HashMap<>(8);
    }

    private void A(byte[] bArr, String str, long j3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    file.delete();
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
                edit.putLong(AppConstants.Preferences.LOGO_START_TIME, j3);
                edit.commit();
                if (QLog.isColorLevel()) {
                    QLog.d("ShanPing", 2, "flashlogo has been saved ");
                }
                fileOutputStream.close();
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
    }

    private boolean B(byte[] bArr, String str) {
        File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/NearbyBannerPic");
        File file2 = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/NearbyBannerPic/" + str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                } else {
                    file2.delete();
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.d("PicAndAdConf", 2, "", e);
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void l(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    l(file2);
                }
            }
            file.delete();
        }
    }

    private boolean z(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic");
        File file2 = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + str);
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            } else {
                file2.delete();
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2, true);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    return false;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            throw th;
        }
    }

    public void C(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http://")) {
            if (this.f202976m == 2) {
                synchronized (this.G) {
                    if (this.G.containsKey(str) && Math.abs(System.currentTimeMillis() - this.G.get(str).longValue()) < 36000) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PicAndAdConf", 2, "sendImgRequest | retry interval is too small, " + str);
                        }
                        return;
                    }
                }
            }
            if (this.F == null) {
                this.F = new HashSet<>();
            }
            this.F.add(str);
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(new HttpMsg(str, null, this, true));
        }
    }

    @Override // com.tencent.mobileqq.config.struct.b
    public void b() {
        j(true);
        this.f202974h = -1L;
        this.f202975i = -1L;
        this.C.clear();
        byte b16 = this.f202976m;
        if (b16 != 0) {
            if (b16 == 1) {
                File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/flashlogo.png");
                try {
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        k();
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        if (httpMsg != null && httpMsg2 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShanPing", 2, "flashlogo request huibao decode ");
            }
            t(httpMsg.getUrl(), httpMsg2.getRecvData());
        }
    }

    @Override // com.tencent.mobileqq.config.struct.b
    public void f(DataInputStream dataInputStream) throws Exception {
        this.f202972e = dataInputStream.readShort();
        this.f202973f = dataInputStream.readLong();
        this.f202974h = dataInputStream.readLong();
        this.f202975i = dataInputStream.readLong();
        this.f202976m = dataInputStream.readByte();
        int readInt = dataInputStream.readInt();
        if (readInt > 0) {
            for (int i3 = 0; i3 < readInt; i3++) {
                a aVar = new a();
                if (this.f202976m == 2) {
                    aVar.b(dataInputStream);
                } else {
                    aVar.a(dataInputStream);
                }
                a(aVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            if (httpMsg.getUrl().startsWith(((a) this.C.get(i3)).f202952c)) {
                ArrayList<f> d16 = e.d();
                if (d16 != null) {
                    Iterator<f> it = d16.iterator();
                    while (it.hasNext()) {
                        it.next().a(false, this.f202972e, i3, httpMsg.getUrl());
                    }
                    return;
                }
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.config.struct.b
    public void i(DataOutputStream dataOutputStream) throws Exception {
        dataOutputStream.writeShort(this.f202972e);
        dataOutputStream.writeLong(this.f202973f);
        dataOutputStream.writeLong(this.f202974h);
        dataOutputStream.writeLong(this.f202975i);
        dataOutputStream.writeByte(this.f202976m);
        ArrayList arrayList = this.C;
        if (arrayList != null && arrayList.size() != 0) {
            int size = this.C.size();
            dataOutputStream.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = (a) this.C.get(i3);
                if (this.f202976m == 2) {
                    aVar.d(dataOutputStream);
                } else {
                    aVar.c(dataOutputStream);
                }
            }
            return;
        }
        dataOutputStream.writeInt(0);
    }

    public void k() {
        try {
            l(new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic"));
        } catch (Exception unused) {
        }
    }

    public String m(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            return ((a) this.C.get(i3)).f202955f;
        }
        return "";
    }

    public Bitmap n(int i3) {
        Bitmap bitmap = null;
        if (i3 < 0 || i3 >= this.C.size()) {
            return null;
        }
        try {
            a aVar = (a) this.C.get(i3);
            byte b16 = aVar.f202956g;
            if (b16 != 1) {
                if (b16 != 3) {
                    return null;
                }
                byte[] bArr = ((a) this.C.get(i3)).f202954e;
                String str = ((a) this.C.get(i3)).f202953d;
                if (str != null && this.f202976m == 1 && !e() && !d()) {
                    return j.c(str);
                }
                if (str != null && this.f202976m == 0) {
                    if (new File(str).exists()) {
                        Bitmap c16 = j.c(str);
                        if (c16 == null && aVar.f202961l) {
                            aVar.f202961l = false;
                            C(aVar.f202952c);
                            return c16;
                        }
                        return c16;
                    }
                    C(aVar.f202952c);
                    return null;
                }
                if (!TextUtils.isEmpty(str) && this.f202976m == 2) {
                    if (new File(str).exists()) {
                        try {
                            bitmap = j.c(str);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PicAndAdConf", 2, "get NearbyBanner image", e16);
                            }
                        } catch (OutOfMemoryError unused) {
                        }
                    }
                    if (bitmap == null) {
                        C(aVar.f202952c);
                        return bitmap;
                    }
                    return bitmap;
                }
                if (bArr == null || bArr.length <= 0) {
                    return null;
                }
                try {
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                } catch (Exception unused2) {
                    return null;
                }
            }
            return j.c(aVar.f202952c);
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("Config", 2, QLog.getStackTraceString(th5));
            return null;
        }
    }

    public long o(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            return ((a) this.C.get(i3)).f202950a;
        }
        return 0L;
    }

    public String p(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            return ((a) this.C.get(i3)).f202959j;
        }
        return "";
    }

    public String q(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            return ((a) this.C.get(i3)).f202957h;
        }
        return "";
    }

    public short r(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            return ((a) this.C.get(i3)).f202958i;
        }
        return (short) -1;
    }

    public String s(String str, byte b16) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (b16 != 1) {
            if (b16 == 3) {
                if (str.startsWith("http://") && !str.endsWith(".png")) {
                    byte b17 = this.f202976m;
                    if (b17 == 6) {
                        str = str + "_" + ((int) e.f202865c) + "_" + ((int) e.f202864b) + ".png";
                    } else if (b17 == 0) {
                        str = str + "_" + (e.f202864b - 2) + ".png";
                    } else if (b17 == 1 && str.contains(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                        str = str.replace(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, ah.x() + HippyTKDListViewAdapter.X + ah.w());
                    } else {
                        str = str + "_" + ((int) e.f202864b) + ".png";
                    }
                } else if (str.startsWith("http://") && this.f202976m == 1 && str.contains(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                    str = str.replace(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, ah.x() + HippyTKDListViewAdapter.X + ah.w());
                }
            }
        } else if (!str.startsWith("/")) {
            str = "/" + str;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShanPing", 2, "flashlogo final request url = " + str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        String str;
        if (i3 == 3) {
            String responseProperty = httpMsg2.getResponseProperty("Content-Type");
            if (responseProperty != null) {
                str = responseProperty.toLowerCase();
            } else {
                str = null;
            }
            if (str != null && str.indexOf("image") != -1) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void t(String str, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && str != null && str.length() > 0) {
            ArrayList<f> d16 = e.d();
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                a aVar = (a) this.C.get(i3);
                if (str.startsWith(aVar.f202952c)) {
                    byte b16 = this.f202976m;
                    if (b16 == 1) {
                        String str2 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/flashlogo.png";
                        aVar.f202953d = str2;
                        A(bArr, str2, this.f202974h);
                        if (d16 != null) {
                            Iterator<f> it = d16.iterator();
                            while (it.hasNext()) {
                                it.next().a(true, this.f202972e, i3, str);
                            }
                            return;
                        }
                        return;
                    }
                    if (b16 == 0) {
                        z(bArr, String.valueOf(aVar.f202959j));
                        try {
                            File file = new File(aVar.f202953d);
                            if (!MD5.getFileMD5(file).equalsIgnoreCase(aVar.f202959j)) {
                                file.delete();
                                int i16 = aVar.f202960k;
                                if (i16 < 1) {
                                    aVar.f202960k = i16 + 1;
                                    C(aVar.f202952c);
                                }
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (d16 != null) {
                            Iterator<f> it5 = d16.iterator();
                            while (it5.hasNext()) {
                                it5.next().a(true, this.f202972e, i3, str);
                            }
                            return;
                        }
                        return;
                    }
                    if (b16 == 2) {
                        B(bArr, String.valueOf(aVar.f202959j));
                        try {
                            File file2 = new File(aVar.f202953d);
                            String fileMD5 = MD5.getFileMD5(file2);
                            if (!fileMD5.equalsIgnoreCase(aVar.f202959j)) {
                                file2.delete();
                                int i17 = aVar.f202960k;
                                if (i17 < 1) {
                                    aVar.f202960k = i17 + 1;
                                    C(aVar.f202952c);
                                } else {
                                    synchronized (this.G) {
                                        this.G.put(aVar.f202952c, Long.valueOf(System.currentTimeMillis()));
                                    }
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("PicAndAdConf", 2, "handle download NearbyBanner image, cid = " + aVar.f202950a + ", md5 is " + fileMD5.equalsIgnoreCase(aVar.f202959j));
                                return;
                            }
                            return;
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PicAndAdConf", 2, "handleImgData exception, item md5 = " + aVar.f202959j, e17);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.G) {
                this.G.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public a u(long j3, String str, byte b16, String str2, String str3, String str4, String str5, short s16, String str6) {
        a aVar = new a();
        aVar.f202950a = j3;
        aVar.f202951b = str;
        aVar.f202952c = str2;
        aVar.f202955f = str3;
        aVar.f202956g = b16;
        aVar.f202953d = str4;
        aVar.f202957h = str5;
        aVar.f202958i = s16;
        aVar.f202959j = str6;
        aVar.f202960k = 0;
        return aVar;
    }

    public a v(long j3, String str, byte b16, String str2, byte[] bArr, String str3) {
        a aVar = new a();
        aVar.f202950a = j3;
        aVar.f202951b = str;
        aVar.f202952c = str2;
        aVar.f202954e = bArr;
        aVar.f202955f = str3;
        aVar.f202956g = b16;
        aVar.f202960k = 0;
        return aVar;
    }

    public a w(long j3, String str, String str2, String str3, String str4, String str5, short s16) {
        return u(j3, str, (byte) 3, str2, str3, str4, str5, s16, "");
    }

    public a x(long j3, String str, String str2, byte[] bArr, String str3) {
        return v(j3, str, (byte) 3, str2, bArr, str3);
    }

    public void y() {
        if (this.f202976m == 2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("preDownload NearbyBanner image");
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                final a aVar = (a) this.C.get(i3);
                if (aVar.f202953d != null) {
                    File file = new File(aVar.f202953d);
                    if (!file.exists() || !file.canRead()) {
                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                        sb5.append(aVar.f202950a);
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.struct.PicAndAdConf.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PicAndAdConf.this.C(aVar.f202952c);
                            }
                        }, 5, null, false);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("PicAndAdConf", 2, sb5.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
    }
}
