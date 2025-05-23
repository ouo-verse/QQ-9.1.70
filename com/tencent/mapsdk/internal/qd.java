package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.hd;
import com.tencent.mapsdk.internal.lb;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qd {

    /* renamed from: a, reason: collision with root package name */
    private static final String f149775a = "UTF-8";

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<qf> f149776b;

    /* renamed from: c, reason: collision with root package name */
    private List<FileUpdateReq> f149777c;

    /* renamed from: d, reason: collision with root package name */
    private String f149778d;

    /* renamed from: e, reason: collision with root package name */
    private String f149779e;

    /* renamed from: f, reason: collision with root package name */
    private String f149780f;

    /* renamed from: g, reason: collision with root package name */
    private int f149781g;

    private FileUpdateReq b(String str) {
        List<FileUpdateReq> list = this.f149777c;
        if (list != null && !list.isEmpty()) {
            for (FileUpdateReq fileUpdateReq : this.f149777c) {
                if (hs.a(fileUpdateReq.sName, str)) {
                    return fileUpdateReq;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0151 A[LOOP:0: B:6:0x0060->B:18:0x0151, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0101 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<FileUpdateRsp> a(String str, String str2, String str3, CSFileUpdateReq cSFileUpdateReq, qf qfVar) {
        hd.c cVar;
        char c16;
        this.f149777c = cSFileUpdateReq.vItems;
        this.f149778d = str;
        this.f149779e = str2;
        this.f149776b = new WeakReference<>(qfVar);
        this.f149780f = str3;
        List<FileUpdateRsp> a16 = a(cSFileUpdateReq);
        LogUtil.c("net", "rspList = ".concat(String.valueOf(a16)));
        a(3, "getFileUpdateFromServer: ".concat(String.valueOf(a16)), null, false, false, false, "", "", null);
        if (a16 == null || a16.isEmpty()) {
            return null;
        }
        this.f149781g = a16.size();
        for (FileUpdateRsp fileUpdateRsp : a16) {
            if (fileUpdateRsp != null && fileUpdateRsp.iRet == 0) {
                String str4 = fileUpdateRsp.sName;
                str4.hashCode();
                switch (str4.hashCode()) {
                    case -1319508241:
                        if (str4.equals(er.f148285n)) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -1091367180:
                        if (str4.equals(er.f148284m)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case -503063473:
                        if (str4.equals(er.f148287p)) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 178735484:
                        if (str4.equals(er.f148281j)) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 204802075:
                        if (str4.equals(er.f148283l)) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 451944782:
                        if (str4.equals("poi_icon")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 1366209438:
                        if (str4.equals(er.f148280i)) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case 1864531656:
                        if (str4.equals(er.f148286o)) {
                            c16 = 7;
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 6:
                    case 7:
                        cVar = a(fileUpdateRsp, this.f149778d, false);
                        break;
                    case 3:
                        cVar = a(fileUpdateRsp, this.f149779e, true);
                        break;
                    case 5:
                        cVar = a(fileUpdateRsp, this.f149778d, true);
                        break;
                }
                if (cVar == null) {
                    FileUpdateReq b16 = b(cVar.f148640a);
                    if (b16 != null) {
                        cVar.f148644e = b16.iVersion;
                    } else {
                        cVar.f148644e = -1;
                    }
                    cVar.f148641b = System.currentTimeMillis();
                    a(cVar);
                    LogUtil.c("net", "fileUpdateRsp = ".concat(String.valueOf(fileUpdateRsp)));
                    LogUtil.c("net", "failUpdate = ".concat(String.valueOf(cVar)));
                    a(5, "failUpdate: ".concat(String.valueOf(cVar)), null, false, false, false, "", "", null);
                    return null;
                }
                this.f149781g--;
            }
            cVar = null;
            if (cVar == null) {
            }
        }
        if (this.f149781g != 0) {
            return null;
        }
        return a16;
    }

    private void a(int i3, String str, Throwable th5, boolean z16, boolean z17, boolean z18, String str2, String str3, Object obj) {
        qf qfVar;
        WeakReference<bi>[] b16;
        bi biVar;
        WeakReference<qf> weakReference = this.f149776b;
        if (weakReference == null || (qfVar = weakReference.get()) == null || (b16 = qfVar.b()) == null) {
            return;
        }
        for (WeakReference<bi> weakReference2 : b16) {
            if (weakReference2 != null && (biVar = weakReference2.get()) != null && biVar.f147819b != null && biVar.f147819b.aC != null) {
                int i16 = biVar.f147819b.aC.N;
                if (i3 == 2) {
                    LogUtil.a(i16).a(lb.a.f149158e, str, th5);
                } else if (i3 == 3) {
                    LogUtil.a(i16).b(lb.a.f149158e, str, th5);
                } else if (i3 == 4) {
                    LogUtil.a(i16).c(lb.a.f149158e, str, th5);
                } else if (i3 == 5) {
                    LogUtil.a(i16).d(lb.a.f149158e, str, th5);
                } else if (i3 == 6) {
                    LogUtil.a(i16).e(lb.a.f149158e, str, th5);
                }
                if (z16) {
                    lc.a(ky.f149100f, str2, i16);
                }
                if (z17) {
                    lc.a(ky.f149100f, str2, str3, obj, i16);
                }
                if (z18) {
                    lc.f(ky.f149100f, str2, i16);
                }
            }
        }
    }

    private List<FileUpdateRsp> a(CSFileUpdateReq cSFileUpdateReq) {
        byte[] bArr;
        try {
            NetResponse configFileUpdate = ((de) ((dt) cr.a(dt.class)).i()).configFileUpdate(ho.i(), ho.d(), ho.m(), ho.g(), this.f149780f, cSFileUpdateReq.toByteArray("UTF-8"));
            if (configFileUpdate != null && (bArr = configFileUpdate.data) != null) {
                m mVar = new m(bArr);
                mVar.a("UTF-8");
                SCFileUpdateRsp sCFileUpdateRsp = new SCFileUpdateRsp();
                try {
                    sCFileUpdateRsp.readFrom(mVar);
                } catch (Exception e16) {
                    LogUtil.e(ky.f149100f, "MapConfigUpdate read field exception:" + e16.fillInStackTrace());
                }
                LogUtil.c("net", "scrsp.iRet = " + sCFileUpdateRsp.iRet);
                if (sCFileUpdateRsp.iRet == 0) {
                    return sCFileUpdateRsp.vItems;
                }
                return null;
            }
            StringBuilder sb5 = new StringBuilder("rsp = ");
            sb5.append(configFileUpdate != null ? Integer.valueOf(configFileUpdate.statusCode) : "null");
            LogUtil.c("net", sb5.toString());
            return null;
        } catch (Exception e17) {
            LogUtil.d(Log.getStackTraceString(e17));
            return null;
        }
    }

    private hd.c a(FileUpdateRsp fileUpdateRsp) {
        if (fileUpdateRsp == null || fileUpdateRsp.iRet != 0) {
            return null;
        }
        String str = fileUpdateRsp.sName;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1319508241:
                if (str.equals(er.f148285n)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1091367180:
                if (str.equals(er.f148284m)) {
                    c16 = 1;
                    break;
                }
                break;
            case -503063473:
                if (str.equals(er.f148287p)) {
                    c16 = 2;
                    break;
                }
                break;
            case 178735484:
                if (str.equals(er.f148281j)) {
                    c16 = 3;
                    break;
                }
                break;
            case 204802075:
                if (str.equals(er.f148283l)) {
                    c16 = 4;
                    break;
                }
                break;
            case 451944782:
                if (str.equals("poi_icon")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1366209438:
                if (str.equals(er.f148280i)) {
                    c16 = 6;
                    break;
                }
                break;
            case 1864531656:
                if (str.equals(er.f148286o)) {
                    c16 = 7;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 6:
            case 7:
                return a(fileUpdateRsp, this.f149778d, false);
            case 3:
                return a(fileUpdateRsp, this.f149779e, true);
            case 5:
                return a(fileUpdateRsp, this.f149778d, true);
            default:
                return null;
        }
    }

    private hd.c a(FileUpdateRsp fileUpdateRsp, String str, boolean z16) {
        if (fileUpdateRsp.iFileUpdated != 1) {
            return null;
        }
        String str2 = fileUpdateRsp.sName;
        if (str2.equals(er.f148280i)) {
            str2 = er.f148272a;
        } else if (str2.equals(er.f148283l)) {
            str2 = er.f148273b;
        } else if (str2.equals(er.f148284m)) {
            str2 = er.f148274c;
        } else if (str2.equals(er.f148285n)) {
            str2 = er.f148276e;
        } else if (str2.equals(er.f148286o)) {
            str2 = er.f148277f;
        } else if (str2.equals(er.f148287p)) {
            str2 = er.f148279h;
        }
        File file = new File(str + str2);
        hd.c a16 = a(str2, fileUpdateRsp.sUpdateUrl, file);
        LogUtil.c("net", "fileUpdateRsp.sName = " + fileUpdateRsp.sName);
        if (a16 != null) {
            a16.f148640a = fileUpdateRsp.sName;
            return a16;
        }
        try {
            String a17 = li.a(file);
            LogUtil.c("net", "fileMd5 = ".concat(String.valueOf(a17)));
            if (!fileUpdateRsp.sMd5.equals(a17)) {
                hd.c cVar = new hd.c();
                cVar.f148640a = fileUpdateRsp.sName;
                cVar.f148642c = fileUpdateRsp.sMd5;
                cVar.f148643d = a17;
                LogUtil.c("net", "error md5 1");
                a(5, "md5 not equal, file md5: " + a17 + ", server md5: " + fileUpdateRsp.sMd5, null, false, false, false, "", "", null);
                return cVar;
            }
            if (z16) {
                try {
                    kw.b(file, file.getParent());
                    file.delete();
                } catch (Throwable th5) {
                    LogUtil.d(th5.getMessage());
                    hd.c cVar2 = new hd.c();
                    cVar2.f148640a = fileUpdateRsp.sName;
                    LogUtil.c("net", "error unzip");
                    a(6, "unzip tmp file: " + fileUpdateRsp.sName + ", exception appear", th5, false, false, false, "", "", null);
                    return cVar2;
                }
            }
            WeakReference<qf> weakReference = this.f149776b;
            if (weakReference != null && weakReference.get() != null) {
                this.f149776b.get().f149786a = true;
            }
            return null;
        } catch (Exception e16) {
            LogUtil.d(e16.getMessage());
            hd.c cVar3 = new hd.c();
            cVar3.f148640a = fileUpdateRsp.sName;
            LogUtil.c("net", "error md5 2 " + e16.getMessage());
            a(6, "get tmp file md5 exception", e16, false, false, false, "", "", null);
            return cVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private hd.c a(String str, String str2, File file) {
        NetResponse netResponse;
        FileOutputStream fileOutputStream;
        Exception exc;
        int i3;
        NetResponse netResponse2;
        int i16;
        FileOutputStream fileOutputStream2;
        LogUtil.c(ky.f149100f, "\u5f00\u59cb\u4e0b\u8f7d[" + str + "]:" + str2);
        a(3, "\u5f00\u59cb\u4e0b\u8f7d[" + str + "]: " + str2, null, true, false, false, str2, "", null);
        InputStream inputStream = null;
        int i17 = 200;
        try {
            netResponse = NetManager.getInstance().builder().url(str2).doStream();
            try {
                i17 = netResponse.statusCode;
                InputStream inputStream2 = netResponse.dataStream;
                try {
                    if (!file.exists()) {
                        File parentFile = file.getParentFile();
                        if (parentFile != null) {
                            parentFile.mkdirs();
                        }
                        file.createNewFile();
                    }
                    fileOutputStream2 = new FileOutputStream(file, false);
                } catch (Exception e16) {
                    exc = e16;
                    i3 = i17;
                    netResponse2 = netResponse;
                    fileOutputStream = null;
                    inputStream = inputStream2;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                    inputStream = inputStream2;
                }
                try {
                    ku.a(inputStream2, fileOutputStream2);
                    ku.a((Closeable) inputStream2);
                    ku.a(fileOutputStream2);
                    ku.a((Closeable) netResponse.dataStream);
                    a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, true, false, str2, "netError", Integer.valueOf(i17));
                    a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, false, true, str2, "", null);
                    LogUtil.c(ky.f149100f, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f");
                    return null;
                } catch (Exception e17) {
                    i3 = i17;
                    netResponse2 = netResponse;
                    inputStream = inputStream2;
                    fileOutputStream = fileOutputStream2;
                    exc = e17;
                    try {
                        LogUtil.d(Log.getStackTraceString(exc));
                        hd.c cVar = new hd.c();
                        cVar.f148645f = i3;
                        NetResponse netResponse3 = netResponse2;
                        i16 = i3;
                        try {
                            a(5, "\u4e0b\u8f7d[" + str + "]\u9519\u8bef", exc, false, true, false, str2, "error", Log.getStackTraceString(exc));
                            ku.a((Closeable) inputStream);
                            ku.a(fileOutputStream);
                            if (netResponse3 != null) {
                                ku.a((Closeable) netResponse3.dataStream);
                            }
                            a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, true, false, str2, "netError", Integer.valueOf(i16));
                            a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, false, true, str2, "", null);
                            LogUtil.c(ky.f149100f, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f");
                            return cVar;
                        } catch (Throwable th6) {
                            th = th6;
                            netResponse = netResponse3;
                            i17 = i16;
                            ku.a((Closeable) inputStream);
                            ku.a(fileOutputStream);
                            if (netResponse != null) {
                                ku.a((Closeable) netResponse.dataStream);
                            }
                            a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, true, false, str2, "netError", Integer.valueOf(i17));
                            a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, false, true, str2, "", null);
                            LogUtil.c(ky.f149100f, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f");
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        netResponse = netResponse2;
                        i16 = i3;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = inputStream2;
                    fileOutputStream = fileOutputStream2;
                    ku.a((Closeable) inputStream);
                    ku.a(fileOutputStream);
                    if (netResponse != null) {
                    }
                    a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, true, false, str2, "netError", Integer.valueOf(i17));
                    a(5, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f", null, false, false, true, str2, "", null);
                    LogUtil.c(ky.f149100f, "\u4e0b\u8f7d[" + str + "]\u7ed3\u675f");
                    throw th;
                }
            } catch (Exception e18) {
                exc = e18;
                i3 = i17;
                netResponse2 = netResponse;
                fileOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = null;
            }
        } catch (Exception e19) {
            exc = e19;
            i3 = 200;
            netResponse2 = null;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            netResponse = null;
            fileOutputStream = null;
        }
    }

    private static String a(String str) {
        return str.equals(er.f148280i) ? er.f148272a : str.equals(er.f148283l) ? er.f148273b : str.equals(er.f148284m) ? er.f148274c : str.equals(er.f148285n) ? er.f148276e : str.equals(er.f148286o) ? er.f148277f : str.equals(er.f148287p) ? er.f148279h : str;
    }

    private void a(hd.c cVar) {
        qf qfVar;
        WeakReference<bi>[] b16;
        bi biVar;
        WeakReference<qf> weakReference = this.f149776b;
        if (weakReference == null || (qfVar = weakReference.get()) == null || (b16 = qfVar.b()) == null) {
            return;
        }
        for (WeakReference<bi> weakReference2 : b16) {
            if (weakReference2 != null && (biVar = weakReference2.get()) != null && biVar.f147819b != null && biVar.f147819b.aC != null) {
                hi hiVar = biVar.f147819b.aC.f147918e;
                if (hiVar == null) {
                    return;
                }
                cVar.f148641b -= hiVar.t();
                hiVar.a().a(cVar);
            }
        }
    }
}
