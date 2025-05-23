package com.tencent.mobileqq.troop.avatar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopUploadingThread extends BaseThread {
    static IPatchRedirector $redirector_;
    protected ArrayList<g> C;
    protected boolean D;
    protected i E;
    protected volatile boolean F;
    protected c G;
    private com.tencent.mobileqq.troop.avatar.b H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements HostnameVerifier {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpsURLConnection f294518a;

        a(HttpsURLConnection httpsURLConnection) {
            this.f294518a = httpsURLConnection;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopUploadingThread.this, (Object) httpsURLConnection);
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
            }
            String requestProperty = this.f294518a.getRequestProperty("Host");
            if (requestProperty == null) {
                requestProperty = this.f294518a.getURL().getHost();
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f294520a;

        /* renamed from: b, reason: collision with root package name */
        public int f294521b;

        /* renamed from: c, reason: collision with root package name */
        public int f294522c;

        /* renamed from: d, reason: collision with root package name */
        public long f294523d;

        /* renamed from: e, reason: collision with root package name */
        public int f294524e;

        /* renamed from: f, reason: collision with root package name */
        public int f294525f;

        /* renamed from: g, reason: collision with root package name */
        public String f294526g;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TroopUploadingThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.D = true;
            this.F = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ByteArrayOutputStream c(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).calculateInSampleSize(options, 1024, 1024);
            options.inJustDecodeBounds = false;
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(str, options);
            if (decodeFileWithBufferedStream == null) {
                return null;
            }
            Bitmap exifBitmapCreator_createBitmap = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).exifBitmapCreator_createBitmap(decodeFileWithBufferedStream, str);
            if (exifBitmapCreator_createBitmap == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e16) {
                e = e16;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (byteArrayOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    exifBitmapCreator_createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    if (!exifBitmapCreator_createBitmap.isRecycled()) {
                        exifBitmapCreator_createBitmap.recycle();
                    }
                    return byteArrayOutputStream;
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopUploadingThread", 2, "getByteStream," + e.toString());
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public HttpURLConnection d(URL url, long j3) {
        HttpURLConnection httpURLConnection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HttpURLConnection) iPatchRedirector.redirect((short) 7, this, url, Long.valueOf(j3));
        }
        if (url == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopUploadingThread", 2, "getConnection, url == null");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopUploadingThread", 2, "url : " + url.toString());
        }
        try {
            if (url.toString().startsWith("https://")) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setInstanceFollowRedirects(true);
                c cVar = this.G;
                if (cVar != null && !cVar.b().isEmpty()) {
                    httpsURLConnection.setRequestProperty("Host", this.G.b());
                }
                httpsURLConnection.setSSLSocketFactory(new d(httpsURLConnection));
                httpsURLConnection.setHostnameVerifier(new a(httpsURLConnection));
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (httpURLConnection == null) {
                return null;
            }
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                try {
                    httpURLConnection.setFixedLengthStreamingMode((int) j3);
                    httpURLConnection.setUseCaches(false);
                    try {
                        if (Build.VERSION.SDK != null) {
                            httpURLConnection.setRequestProperty("Connection", "close");
                        } else {
                            httpURLConnection.setRequestProperty("http.keepAlive", "false");
                        }
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=****");
                        httpURLConnection.setRequestProperty("User-Agent", com.tencent.mobileqq.webview.swift.utils.i.n(com.tencent.mobileqq.webview.swift.utils.i.i(""), "", false));
                        c cVar2 = this.G;
                        if (cVar2 != null && !cVar2.a().isEmpty()) {
                            httpURLConnection.setRequestProperty("Cookie", this.G.a());
                        }
                        return httpURLConnection;
                    } catch (ProtocolException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopUploadingThread", 2, "getConnection3 ProtocolException", e16);
                        }
                        return null;
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopUploadingThread", 2, "getConnection3 Exception", e17);
                    }
                    return null;
                }
            } catch (IllegalAccessError e18) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopUploadingThread", 2, "getConnection2 IllegalAccessError", e18);
                }
                return null;
            }
        } catch (Exception e19) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopUploadingThread", 2, "getConnection1 Exception", e19);
            }
            return null;
        }
    }

    public ArrayList<g> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.C;
    }

    protected List<String> p(HashMap<String, String> hashMap, List<String> list, TroopClipPic troopClipPic) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, hashMap, list, troopClipPic);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (hashMap != null) {
                for (String str2 : hashMap.keySet()) {
                    next = next + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + hashMap.get(str2);
                }
            }
            String str3 = (next + "&subcmd=" + ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getSubcmdByType(troopClipPic.type)) + "&subver=101";
            if (!TextUtils.isEmpty(troopClipPic.clipInfo)) {
                str = str3 + "&clip=" + troopClipPic.clipInfo;
            } else {
                str = str3 + "&clip=" + ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipStr(0, 0, 0, 0);
            }
            arrayList.add(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopUploadingThread", 2, String.format("geturl=%s", Arrays.toString(arrayList.toArray())));
        }
        return arrayList;
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        ArrayList<g> arrayList = this.C;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g gVar = this.C.get(size);
            if (gVar.f294550a.equals(str)) {
                if (size == 0) {
                    gVar.f294552c = true;
                } else {
                    this.C.remove(gVar);
                }
            }
        }
    }

    public void r(ArrayList<TroopClipPic> arrayList, HashMap<String, String> hashMap, List<String> list, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, arrayList, hashMap, list, iVar);
            return;
        }
        this.E = iVar;
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        Iterator<TroopClipPic> it = arrayList.iterator();
        while (it.hasNext()) {
            TroopClipPic next = it.next();
            new File(next.f203184id);
            g gVar = new g();
            gVar.f294551b = p(hashMap, list, next);
            gVar.f294550a = next.f203184id;
            gVar.f294554e = next.type;
            gVar.f294555f = next.f203185ts;
            gVar.f294556g = next.clipInfo;
            this.C.add(gVar);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        while (true) {
            ArrayList<g> arrayList = this.C;
            if (arrayList == null || arrayList.size() <= 0) {
                break;
            } else {
                t(this.C.get(0));
            }
        }
        this.E = null;
    }

    public void s(com.tencent.mobileqq.troop.avatar.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        this.H = bVar;
        if (bVar != null) {
            this.G = bVar.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        r8.f294520a = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(g gVar) {
        byte[] byteArray;
        int length;
        boolean z16;
        com.tencent.mobileqq.troop.avatar.b bVar;
        String str = "TroopUploadingThread";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) gVar);
            return;
        }
        ByteArrayOutputStream c16 = c(gVar.f294550a);
        int i3 = 0;
        URL url = null;
        if (c16 == null) {
            byteArray = null;
            length = -1;
            z16 = true;
        } else {
            byteArray = c16.toByteArray();
            length = byteArray.length;
            z16 = false;
        }
        b bVar2 = new b();
        bVar2.f294523d = gVar.f294555f;
        bVar2.f294524e = gVar.f294554e;
        int i16 = -1;
        while (true) {
            if (i3 > 3) {
                break;
            }
            i3++;
            if (z16) {
                i16 = 101;
                break;
            }
            try {
                try {
                    url = new URL(gVar.a(i3 - 1) + "&filesize=" + length);
                } catch (MalformedURLException e16) {
                    QLog.d(str, 1, e16.getMessage(), e16);
                }
                HttpURLConnection d16 = d(url, length);
                if (d16 != null && (i16 = u(byteArray, d16, gVar, i3)) != -4) {
                    if (i16 != -1 && i16 != 104 && (bVar = this.H) != null) {
                        i16 = bVar.b(d16, bVar2, gVar);
                        break;
                    }
                    break;
                }
            } catch (Throwable th5) {
                QLog.d(str, 1, th5.getMessage(), th5);
            }
        }
        bVar2.f294520a = 2;
        bVar2.f294521b = i16;
        this.C.remove(gVar);
        if (i16 != 104) {
            this.E.notifyObservers(bVar2);
        }
    }

    public int u(byte[] bArr, HttpURLConnection httpURLConnection, g gVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, bArr, httpURLConnection, gVar, Integer.valueOf(i3))).intValue();
        }
        int i17 = -1;
        if (httpURLConnection == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopUploadingThread", 2, "writeData,con == null");
            }
            return -1;
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            int length = bArr.length;
            int i18 = 0;
            int i19 = 0;
            while (i18 < length) {
                try {
                    if (gVar.f294552c) {
                        this.C.remove(gVar);
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        return 104;
                    }
                    int i26 = length - i18;
                    if (i26 > 10240) {
                        i26 = 10240;
                    }
                    dataOutputStream.write(bArr, i18, i26);
                    i18 += i26;
                    int i27 = i18 * 100;
                    if ((i27 / length) - i19 > 0) {
                        gVar.f294553d = i19;
                        b bVar = new b();
                        bVar.f294520a = i16;
                        bVar.f294521b = i19;
                        bVar.f294523d = gVar.f294555f;
                        bVar.f294524e = gVar.f294554e;
                        this.E.notifyObservers(bVar);
                    }
                    i19 = i27 / length;
                    i16 = 0;
                    i17 = -1;
                } catch (IOException e16) {
                    try {
                        dataOutputStream.close();
                        QLog.d("TroopUploadingThread", 1, e16.getMessage(), e16);
                        httpURLConnection.disconnect();
                        if (i3 < 3) {
                            return -4;
                        }
                        return 103;
                    } catch (IOException e17) {
                        e17.printStackTrace();
                        return -1;
                    }
                }
            }
            int i28 = i17;
            try {
                dataOutputStream.close();
                return 0;
            } catch (IOException e18) {
                e18.printStackTrace();
                return i28;
            }
        } catch (IOException e19) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopUploadingThread", 1, e19.getMessage(), e19);
            }
            httpURLConnection.disconnect();
            if (i3 < 3) {
                return -4;
            }
            return -1;
        }
    }
}
