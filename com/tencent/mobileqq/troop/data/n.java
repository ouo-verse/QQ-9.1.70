package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListRspBody;
import tencent.im.cs.group_file_common.group_file_common$FileInfo;
import tencent.im.cs.group_file_common.group_file_common$FolderInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileListRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class n {
    static IPatchRedirector $redirector_;
    public boolean A;
    public boolean B;
    public int C;
    public Map<String, n> D;
    public String E;
    public String F;
    public long G;
    public long H;
    public String I;
    public long J;

    /* renamed from: a, reason: collision with root package name */
    public UUID f294915a;

    /* renamed from: b, reason: collision with root package name */
    public String f294916b;

    /* renamed from: c, reason: collision with root package name */
    public String f294917c;

    /* renamed from: d, reason: collision with root package name */
    public long f294918d;

    /* renamed from: e, reason: collision with root package name */
    public int f294919e;

    /* renamed from: f, reason: collision with root package name */
    public long f294920f;

    /* renamed from: g, reason: collision with root package name */
    public long f294921g;

    /* renamed from: h, reason: collision with root package name */
    public int f294922h;

    /* renamed from: i, reason: collision with root package name */
    public int f294923i;

    /* renamed from: j, reason: collision with root package name */
    private int f294924j;

    /* renamed from: k, reason: collision with root package name */
    public int f294925k;

    /* renamed from: l, reason: collision with root package name */
    public String f294926l;

    /* renamed from: m, reason: collision with root package name */
    public String f294927m;

    /* renamed from: n, reason: collision with root package name */
    public String f294928n;

    /* renamed from: o, reason: collision with root package name */
    public String f294929o;

    /* renamed from: p, reason: collision with root package name */
    public int f294930p;

    /* renamed from: q, reason: collision with root package name */
    public String f294931q;

    /* renamed from: r, reason: collision with root package name */
    public long f294932r;

    /* renamed from: s, reason: collision with root package name */
    public int f294933s;

    /* renamed from: t, reason: collision with root package name */
    public String f294934t;

    /* renamed from: u, reason: collision with root package name */
    public int f294935u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f294936v;

    /* renamed from: w, reason: collision with root package name */
    public transient String f294937w;

    /* renamed from: x, reason: collision with root package name */
    public transient String f294938x;

    /* renamed from: y, reason: collision with root package name */
    public transient String f294939y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f294940z;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements Comparator<n> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(n nVar, n nVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar, (Object) nVar2)).intValue();
            }
            int i3 = nVar.f294922h;
            int i16 = nVar2.f294922h;
            if (i3 < i16) {
                return 1;
            }
            if (i3 == i16) {
                return 0;
            }
            return -1;
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f294930p = 7;
        this.D = new ConcurrentHashMap();
        this.J = 0L;
        this.f294930p = 7;
        this.f294940z = true;
    }

    public static String d(Context context, long j3) {
        String str;
        try {
            str = en.g(context, j3);
        } catch (Exception e16) {
            QLog.e("TroopFileInfo", 1, "formatNewRefreshTime error:" + e16.getMessage() + ", timestamp:" + j3);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            int b16 = en.b(j3);
            int indexOf = str.indexOf(" ");
            if (indexOf != -1 && indexOf < str.length() - 1) {
                if (b16 == 1) {
                    return str.substring(indexOf + 1);
                }
                String substring = str.substring(0, indexOf);
                if (b16 == 5) {
                    return substring.substring(2);
                }
                return substring;
            }
            return str;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0059 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:35:0x0007, B:38:0x000c, B:41:0x001b, B:46:0x0029, B:48:0x0031, B:50:0x003f, B:55:0x0044, B:6:0x0059, B:11:0x0082, B:13:0x008a, B:18:0x009b, B:21:0x00a9, B:22:0x00a5, B:15:0x0097, B:26:0x00af), top: B:34:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized String h(BaseQQAppInterface baseQQAppInterface, long j3, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19 = true;
        boolean z26 = false;
        if (!z16) {
            try {
                if (this.I != null && SystemClock.uptimeMillis() - this.J <= MiniBoxNoticeInfo.MIN_5) {
                    if (this.I.length() <= 10) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.I.length()) {
                                break;
                            }
                            if (!Character.isDigit(this.I.charAt(i3))) {
                                z17 = false;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z17 || SystemClock.uptimeMillis() - this.J <= 3000) {
                        z18 = false;
                        if (z18) {
                            String s16 = ac.s((QQAppInterface) baseQQAppInterface, i(), j3 + "", 1, 0);
                            this.I = s16;
                            if (s16.length() > 10) {
                                z19 = false;
                            }
                            if (z19) {
                                for (int i16 = 0; i16 < this.I.length(); i16++) {
                                    if (!Character.isDigit(this.I.charAt(i16))) {
                                        break;
                                    }
                                }
                            }
                            z26 = z19;
                            if (TextUtils.isEmpty(this.I) || z26) {
                                this.I = this.f294928n;
                            }
                            this.J = SystemClock.uptimeMillis();
                        }
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        z18 = true;
        if (z18) {
        }
        return this.I;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (r0 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (r6.B != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r6.B != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(QQAppInterface qQAppInterface, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, qQAppInterface, Long.valueOf(j3), Boolean.valueOf(z16))).booleanValue();
        }
        boolean equals = qQAppInterface.getCurrentAccountUin().equals(i());
        boolean a16 = TroopFileUtils.a(qQAppInterface, j3);
        switch (this.f294930p) {
            case 1:
            case 4:
            case 8:
                if (z16) {
                    break;
                }
                break;
            case 7:
                if (!this.B) {
                    if (!a16) {
                    }
                    z17 = true;
                    break;
                }
                z17 = a16;
                break;
        }
        if (QLog.isDebugVersion() && QLog.isColorLevel()) {
            QLog.i("TroopFileInfo", 2, "canShowDeleteBtn, isCanShowDelBtn:" + z17 + ",isAdmin:" + a16 + ", status:" + this.f294930p + ", isUploader:" + equals);
        }
        return z17;
    }

    public boolean b(QQAppInterface qQAppInterface, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, qQAppInterface, Long.valueOf(j3), Boolean.valueOf(z16))).booleanValue();
        }
        if (TroopFileUtils.a(qQAppInterface, j3) && !this.B && !z16 && !com.tencent.mobileqq.troop.data.a.b(this.f294930p) && !com.tencent.mobileqq.troop.data.a.a(this.f294930p)) {
            return true;
        }
        return false;
    }

    public boolean c(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qQAppInterface, Long.valueOf(j3))).booleanValue();
        }
        if (TroopFileUtils.a(qQAppInterface, j3) && this.B) {
            return true;
        }
        return false;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return TroopFileUtils.j(this.f294918d);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof n)) {
            return this.f294915a.equals(((n) obj).f294915a);
        }
        return false;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.f294922h;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f294928n;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f294920f + "";
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.f294924j = i3;
            this.F = d(BaseApplication.getContext(), this.f294924j * 1000);
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.f294922h = i3;
            this.E = d(BaseApplication.getContext(), this.f294922h * 1000);
        }
    }

    public void l(n nVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) nVar);
            return;
        }
        if (nVar != null) {
            int i3 = nVar.f294930p;
            if (i3 != 8 && i3 != 9) {
                if ((i3 == 11 || i3 == 10 || i3 == 12) && (str = nVar.f294916b) != null) {
                    this.D.remove(str);
                    return;
                }
                return;
            }
            String str2 = nVar.f294916b;
            if (str2 != null) {
                this.D.put(str2, nVar);
            }
        }
    }

    public void m(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) nVar);
            return;
        }
        if (nVar == null) {
            return;
        }
        this.f294940z = false;
        this.f294916b = nVar.f294916b;
        this.f294929o = nVar.f294929o;
        this.f294917c = nVar.f294917c;
        this.f294919e = nVar.f294919e;
        this.f294920f = nVar.f294920f;
        this.f294921g = nVar.f294921g;
        this.f294918d = nVar.f294918d;
        this.f294922h = nVar.f294922h;
        this.f294923i = nVar.f294923i;
        this.f294924j = nVar.f294924j;
        this.f294925k = nVar.f294925k;
        this.f294928n = nVar.f294928n;
        this.C = nVar.C;
        this.f294926l = nVar.f294926l;
        this.f294927m = nVar.f294927m;
        this.B = nVar.B;
        this.E = nVar.E;
        this.F = nVar.F;
        this.G = nVar.G;
        this.H = nVar.H;
        this.f294930p = nVar.f294930p;
        this.f294931q = nVar.f294931q;
        this.f294932r = nVar.f294932r;
        this.f294934t = nVar.f294934t;
    }

    public void n(cmd0x383$ApplyGetFileListRspBody.FileInfo fileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileInfo);
            return;
        }
        if (fileInfo == null) {
            return;
        }
        this.f294940z = false;
        this.f294916b = fileInfo.str_file_path.get();
        this.f294917c = fileInfo.str_file_name.get();
        this.f294918d = fileInfo.uint64_file_size.get();
        this.f294919e = fileInfo.uint32_bus_id.get();
        this.f294920f = fileInfo.uint32_upload_uin.get();
        this.f294921g = fileInfo.uint64_uploaded_size.get();
        this.f294922h = fileInfo.uint32_upload_time.get();
        this.f294923i = fileInfo.uint32_dead_time.get();
        this.f294924j = fileInfo.uint32_modify_time.get();
        this.f294925k = fileInfo.uint32_download_times.get();
        this.f294928n = fileInfo.str_uploader_name.get();
        this.f294926l = new String(fileInfo.bytes_sha.get().toByteArray());
        this.f294927m = HexUtil.bytes2HexStr(fileInfo.bytes_md5.get().toByteArray());
        this.F = d(BaseApplication.getContext(), this.f294924j * 1000);
        this.E = d(BaseApplication.getContext(), this.f294922h * 1000);
        this.B = false;
    }

    public void o(group_file_common$FolderInfo group_file_common_folderinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) group_file_common_folderinfo);
            return;
        }
        if (group_file_common_folderinfo == null) {
            return;
        }
        this.B = true;
        this.f294916b = group_file_common_folderinfo.str_folder_id.get();
        this.f294917c = group_file_common_folderinfo.str_folder_name.get();
        this.f294922h = group_file_common_folderinfo.uint32_create_time.get();
        this.f294924j = group_file_common_folderinfo.uint32_modify_time.get();
        this.f294920f = group_file_common_folderinfo.uint64_create_uin.get();
        this.f294929o = "/";
        this.C = group_file_common_folderinfo.uint32_total_file_count.get();
        this.E = d(BaseApplication.getContext(), this.f294922h * 1000);
        this.F = d(BaseApplication.getContext(), this.f294924j * 1000);
    }

    public void p(oidb_0x6d8$GetFileListRspBody.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) item);
            return;
        }
        if (item == null) {
            return;
        }
        this.f294940z = false;
        int i3 = item.uint32_type.get();
        if (i3 != 1) {
            if (i3 == 2) {
                this.B = true;
                group_file_common$FolderInfo group_file_common_folderinfo = item.folder_info.get();
                this.f294916b = group_file_common_folderinfo.str_folder_id.get();
                this.f294917c = group_file_common_folderinfo.str_folder_name.get();
                this.f294924j = group_file_common_folderinfo.uint32_modify_time.get();
                this.f294922h = group_file_common_folderinfo.uint32_create_time.get();
                this.f294920f = group_file_common_folderinfo.uint64_create_uin.get();
                this.f294929o = group_file_common_folderinfo.str_parent_folder_id.get();
                this.C = group_file_common_folderinfo.uint32_total_file_count.get();
                this.E = d(BaseApplication.getContext(), this.f294922h * 1000);
                this.F = d(BaseApplication.getContext(), this.f294924j * 1000);
                return;
            }
            return;
        }
        this.B = false;
        group_file_common$FileInfo group_file_common_fileinfo = item.file_info.get();
        this.f294916b = group_file_common_fileinfo.str_file_id.get();
        this.f294917c = group_file_common_fileinfo.str_file_name.get();
        this.f294918d = group_file_common_fileinfo.uint64_file_size.get();
        this.f294919e = group_file_common_fileinfo.uint32_bus_id.get();
        this.f294920f = group_file_common_fileinfo.uint64_uploader_uin.get();
        this.f294921g = group_file_common_fileinfo.uint64_uploaded_size.get();
        this.f294922h = group_file_common_fileinfo.uint32_upload_time.get();
        this.f294923i = group_file_common_fileinfo.uint32_dead_time.get();
        this.f294924j = group_file_common_fileinfo.uint32_modify_time.get();
        this.f294925k = group_file_common_fileinfo.uint32_download_times.get();
        this.f294928n = group_file_common_fileinfo.str_uploader_name.get();
        this.f294926l = new String(group_file_common_fileinfo.bytes_sha.get().toByteArray());
        this.f294927m = HexUtil.bytes2HexStr(group_file_common_fileinfo.bytes_md5.get().toByteArray());
        this.f294929o = group_file_common_fileinfo.str_parent_folder_id.get();
        this.E = d(BaseApplication.getContext(), this.f294922h * 1000);
        this.F = d(BaseApplication.getContext(), this.f294924j * 1000);
    }

    public void q(t tVar, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) tVar, (Object) qQAppInterface);
            return;
        }
        this.f294937w = tVar.f294979m;
        this.f294938x = tVar.f294980n;
        this.f294939y = tVar.f294981o;
        this.f294930p = tVar.f294972f;
        this.f294934t = tVar.f294978l;
        this.f294932r = tVar.f294977k;
        this.f294933s = tVar.f294974h;
        this.A = tVar.f294973g;
        if (this.f294922h == 0) {
            this.f294922h = tVar.f294975i;
            this.E = d(BaseApplication.getContext(), this.f294922h * 1000);
        }
        if (this.f294916b == null) {
            this.f294916b = tVar.f294985s;
        }
        if (this.f294929o == null) {
            this.f294929o = tVar.f294991y;
        }
        if (this.f294918d == 0) {
            this.f294918d = tVar.f294976j;
        }
        if (this.f294917c == null) {
            this.f294917c = tVar.f294987u;
        }
        if (this.f294919e == 0 || com.tencent.mobileqq.troop.data.a.b(tVar.f294972f)) {
            this.f294919e = tVar.f294988v;
        }
        if (this.f294920f == 0 && com.tencent.mobileqq.troop.data.a.b(tVar.f294972f)) {
            try {
                this.f294920f = Long.parseLong(qQAppInterface.getCurrentAccountUin());
            } catch (NumberFormatException unused) {
                QLog.e("TroopFileInfo", 4, "updateItemStatus NumberFormatException");
            }
        }
        if (this.G == 0) {
            this.G = tVar.J;
        }
        if (this.H == 0) {
            this.H = tVar.K;
        }
    }

    public void r(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qQAppInterface, Long.valueOf(j3));
        } else {
            this.f294928n = h(qQAppInterface, j3, false);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "TroopFileInfo{TAG='TroopFileInfo', Id=" + this.f294915a + ", str_file_path='" + this.f294916b + "', str_file_name='" + this.f294917c + "', uint64_file_size=" + this.f294918d + ", uint32_bus_id=" + this.f294919e + ", uint32_upload_uin=" + this.f294920f + ", uint64_uploaded_size=" + this.f294921g + ", uint32_upload_time=" + this.f294922h + ", uint32_dead_time=" + this.f294923i + ", uint32_modify_time=" + this.f294924j + ", uint32_download_times=" + this.f294925k + ", str_uploader_name='" + this.f294928n + "', Status=" + this.f294930p + ", _sStatus='" + this.f294931q + "', ProgressValue=" + this.f294932r + ", ErrorCode=" + this.f294933s + ", LocalFile='" + this.f294934t + "', UploadCreateTime=" + this.f294935u + ", Unread=" + this.f294936v + ", ThumbnailFile_Small='" + this.f294937w + "', ThumbnailFile_Large='" + this.f294938x + "', IsGhost=" + this.f294940z + ", IsNewStatus=" + this.A + ", NickName='" + this.I + "', lastNickNameUpdateMS=" + this.J + '}';
    }

    public n(cmd0x383$ApplyGetFileListRspBody.FileInfo fileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fileInfo);
            return;
        }
        this.f294930p = 7;
        this.D = new ConcurrentHashMap();
        this.J = 0L;
        this.f294930p = 7;
        n(fileInfo);
    }

    public n(oidb_0x6d8$GetFileListRspBody.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) item);
            return;
        }
        this.f294930p = 7;
        this.D = new ConcurrentHashMap();
        this.J = 0L;
        this.f294930p = 7;
        p(item);
    }

    public n(group_file_common$FolderInfo group_file_common_folderinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) group_file_common_folderinfo);
            return;
        }
        this.f294930p = 7;
        this.D = new ConcurrentHashMap();
        this.J = 0L;
        this.f294930p = 7;
        o(group_file_common_folderinfo);
    }

    public n(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) nVar);
            return;
        }
        this.f294930p = 7;
        this.D = new ConcurrentHashMap();
        this.J = 0L;
        this.f294915a = nVar.f294915a;
        this.f294916b = nVar.f294916b;
        this.f294917c = nVar.f294917c;
        this.f294918d = nVar.f294918d;
        this.f294919e = nVar.f294919e;
        this.f294920f = nVar.f294920f;
        this.f294921g = nVar.f294921g;
        this.f294923i = nVar.f294923i;
        this.f294924j = nVar.f294924j;
        this.f294925k = nVar.f294925k;
        this.f294926l = nVar.f294926l;
        this.f294927m = nVar.f294927m;
        this.f294928n = nVar.f294928n;
        this.f294929o = nVar.f294929o;
        this.f294930p = nVar.f294930p;
        this.f294931q = nVar.f294931q;
        this.f294932r = nVar.f294932r;
        this.f294933s = nVar.f294933s;
        this.f294934t = nVar.f294934t;
        this.f294935u = nVar.f294935u;
        this.f294936v = nVar.f294936v;
        this.f294937w = nVar.f294937w;
        this.f294938x = nVar.f294938x;
        this.f294939y = nVar.f294939y;
        this.f294940z = nVar.f294940z;
        this.A = nVar.A;
        this.B = nVar.B;
        this.C = nVar.C;
        this.D = new ConcurrentHashMap(nVar.D);
        this.E = nVar.E;
        this.F = nVar.F;
        this.G = nVar.G;
        this.H = nVar.H;
        this.I = nVar.I;
        this.J = nVar.J;
    }
}
