package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Set<FileInfo> f207755a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<WeiYunFileInfo> f207756b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<OfflineFileInfo> f207757c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<FileManagerEntity> f207758d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<FavFileInfo> f207759e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private static int f207760f = 20;

    /* renamed from: g, reason: collision with root package name */
    private static long f207761g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList<FileInfo> f207762h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private static ArrayList<String> f207763i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private static int f207764j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f207765k = 2;

    /* renamed from: l, reason: collision with root package name */
    public static int f207766l = 4;

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, a> f207767m = new HashMap();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f207768a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f207769b;
    }

    public static boolean A(FileManagerEntity fileManagerEntity) {
        String extension = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(fileManagerEntity.fileName);
        if (extension == null || extension.length() == 0) {
            return false;
        }
        if (!((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsFile(extension.toLowerCase())) {
            return false;
        }
        return true;
    }

    public static boolean B(FavFileInfo favFileInfo) {
        Iterator<FavFileInfo> it = f207759e.iterator();
        while (it.hasNext()) {
            if (it.next().f207674f.equals(favFileInfo.f207674f)) {
                return true;
            }
        }
        return false;
    }

    public static boolean C(FileInfo fileInfo) {
        return f207755a.contains(fileInfo);
    }

    public static boolean D(FileManagerEntity fileManagerEntity) {
        return f207758d.contains(fileManagerEntity);
    }

    public static boolean E(WeiYunFileInfo weiYunFileInfo) {
        Iterator<WeiYunFileInfo> it = f207756b.iterator();
        while (it.hasNext()) {
            if (it.next().f209603d.equals(weiYunFileInfo.f209603d)) {
                return true;
            }
        }
        return false;
    }

    public static void F(FavFileInfo favFileInfo) {
        Iterator<FavFileInfo> it = f207759e.iterator();
        while (it.hasNext()) {
            FavFileInfo next = it.next();
            if (next.f207674f.equals(favFileInfo.f207674f)) {
                f207759e.remove(next);
                return;
            }
        }
    }

    public static void G(FileInfo fileInfo) {
        f207755a.remove(fileInfo);
    }

    public static void H(FileManagerEntity fileManagerEntity) {
        f207758d.remove(fileManagerEntity);
    }

    public static void I(WeiYunFileInfo weiYunFileInfo) {
        Iterator<WeiYunFileInfo> it = f207756b.iterator();
        while (it.hasNext()) {
            WeiYunFileInfo next = it.next();
            if (next.f209603d.equals(weiYunFileInfo.f209603d)) {
                f207756b.remove(next);
                return;
            }
        }
    }

    public static void J(long j3) {
        Iterator<FavFileInfo> it = f207759e.iterator();
        while (it.hasNext()) {
            FavFileInfo next = it.next();
            if (next.f207672d == j3) {
                f207759e.remove(next);
                return;
            }
        }
    }

    public static boolean K() {
        if (s() == 0 || f207756b.size() > 0) {
            return false;
        }
        Iterator<FileInfo> it = f207755a.iterator();
        while (it.hasNext()) {
            String extension = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(it.next().j());
            if (extension != null && extension.length() != 0) {
                if (!((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsFile(extension.toLowerCase())) {
                }
            }
            return false;
        }
        Iterator<FileManagerEntity> it5 = f207758d.iterator();
        while (it5.hasNext()) {
            String extension2 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(it5.next().fileName);
            if (extension2 != null && extension2.length() != 0) {
                if (!((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsFile(extension2.toLowerCase())) {
                }
            }
            return false;
        }
        return true;
    }

    public static void L(int i3) {
        f207764j = i3 | f207764j;
    }

    public static void M(int i3) {
        f207760f = i3;
    }

    public static void N(long j3) {
        f207761g = j3;
    }

    public static void a(ArrayList<FileInfo> arrayList) {
        f207762h.clear();
        f207762h.addAll(arrayList);
    }

    public static void b(FavFileInfo favFileInfo) {
        if (!h(favFileInfo.f207677m)) {
            return;
        }
        f207759e.add(favFileInfo);
    }

    public static void c(FileInfo fileInfo) {
        if (!h(fileInfo.l()) || f207755a.contains(fileInfo)) {
            return;
        }
        f207755a.add(fileInfo);
    }

    public static void d(FileManagerEntity fileManagerEntity) {
        if (!h(fileManagerEntity.fileSize)) {
            return;
        }
        f207758d.add(fileManagerEntity);
    }

    public static void e(WeiYunFileInfo weiYunFileInfo) {
        if (!h(weiYunFileInfo.f209606h)) {
            return;
        }
        f207756b.add(weiYunFileInfo);
    }

    public static void f(List<FileInfo> list) {
        f207755a.addAll(list);
    }

    public static void g(String str, byte[] bArr) {
        a aVar = new a();
        aVar.f207768a = str;
        aVar.f207769b = bArr;
        f207767m.put(str, aVar);
    }

    private static boolean h(long j3) {
        if (f207760f > 0 && s() >= f207760f) {
            com.tencent.mobileqq.filemanager.util.d.d(String.format(BaseApplication.getContext().getResources().getString(R.string.b_l), Integer.valueOf(f207760f)));
            return false;
        }
        if (f207761g <= 0 || t() + j3 <= f207761g) {
            return true;
        }
        com.tencent.mobileqq.filemanager.util.d.d(BaseApplication.getContext().getResources().getString(R.string.b_s) + q.g(f207761g));
        return false;
    }

    public static void i() {
        f207762h.clear();
    }

    public static void j() {
        f207764j = 0;
    }

    public static void k() {
        f207755a.clear();
        f207758d.clear();
        f207757c.clear();
        f207756b.clear();
        f207759e.clear();
        j();
    }

    public static ArrayList<FavFileInfo> l() {
        return f207759e;
    }

    public static ArrayList<FileInfo> m() {
        return f207762h;
    }

    public static Set<FileInfo> n() {
        return f207755a;
    }

    public static long o() {
        return f207761g;
    }

    public static ArrayList<OfflineFileInfo> p() {
        return f207757c;
    }

    public static ArrayList<FileManagerEntity> q() {
        return f207758d;
    }

    public static long r() {
        Iterator<WeiYunFileInfo> it = f207756b.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().f209606h;
        }
        Iterator<OfflineFileInfo> it5 = f207757c.iterator();
        while (it5.hasNext()) {
            j3 += it5.next().C;
        }
        Iterator<FileManagerEntity> it6 = f207758d.iterator();
        while (it6.hasNext()) {
            FileManagerEntity next = it6.next();
            int cloudType = next.getCloudType();
            if (cloudType == 1 || cloudType == 2) {
                j3 += next.fileSize;
            }
        }
        return j3;
    }

    public static long s() {
        return f207755a.size() + f207758d.size() + f207757c.size() + f207756b.size() + f207759e.size();
    }

    public static long t() {
        Iterator<FileInfo> it = f207755a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().l();
        }
        Iterator<WeiYunFileInfo> it5 = f207756b.iterator();
        while (it5.hasNext()) {
            j3 += it5.next().f209606h;
        }
        Iterator<OfflineFileInfo> it6 = f207757c.iterator();
        while (it6.hasNext()) {
            j3 += it6.next().C;
        }
        Iterator<FileManagerEntity> it7 = f207758d.iterator();
        while (it7.hasNext()) {
            j3 += it7.next().fileSize;
        }
        Iterator<FavFileInfo> it8 = f207759e.iterator();
        while (it8.hasNext()) {
            j3 += it8.next().f207677m;
        }
        return j3;
    }

    public static long u() {
        Iterator<FileInfo> it = f207755a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().l();
        }
        IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
        Iterator<FileManagerEntity> it5 = f207758d.iterator();
        while (it5.hasNext()) {
            FileManagerEntity next = it5.next();
            if (iQQFileTempUtils.bShowFlowDialog(next, false)) {
                j3 += iQQFileTempUtils.getFileSize(next.getFilePath());
            }
        }
        return j3;
    }

    public static ArrayList<WeiYunFileInfo> v() {
        return f207756b;
    }

    public static boolean w(int i3) {
        if ((f207764j & i3) == i3) {
            return true;
        }
        return false;
    }

    public static boolean x() {
        if (s() == 0) {
            return false;
        }
        Iterator<FileInfo> it = f207755a.iterator();
        while (it.hasNext()) {
            if (z(it.next())) {
                return true;
            }
        }
        Iterator<FileManagerEntity> it5 = f207758d.iterator();
        while (it5.hasNext()) {
            if (A(it5.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean y() {
        Iterator<FileManagerEntity> it = f207758d.iterator();
        while (it.hasNext()) {
            if (it.next().nFileType == 13) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(FileInfo fileInfo) {
        String extension = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(fileInfo.j());
        if (extension == null || extension.length() == 0) {
            return false;
        }
        if (!((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsFile(extension.toLowerCase())) {
            return false;
        }
        return true;
    }
}
