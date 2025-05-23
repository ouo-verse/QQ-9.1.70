package hr;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends hr.a {

    /* renamed from: n, reason: collision with root package name */
    public String f406064n;

    /* renamed from: o, reason: collision with root package name */
    public String f406065o;

    /* renamed from: p, reason: collision with root package name */
    public final List<b> f406066p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f406067q;

    /* renamed from: r, reason: collision with root package name */
    public int f406068r;

    /* renamed from: s, reason: collision with root package name */
    public int f406069s;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".bmp") || name.endsWith(".apng") || name.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b implements Comparable {

        /* renamed from: d, reason: collision with root package name */
        public String f406071d;

        /* renamed from: e, reason: collision with root package name */
        public String f406072e;

        /* renamed from: f, reason: collision with root package name */
        public int f406073f;

        /* renamed from: h, reason: collision with root package name */
        public String f406074h;

        public b(String str, String str2, int i3, String str3) {
            this.f406071d = str;
            this.f406072e = str2;
            this.f406073f = i3;
            this.f406074h = str3;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            if (obj instanceof b) {
                return this.f406072e.compareTo(((b) obj).f406072e);
            }
            return 0;
        }
    }

    public f(String str) {
        super(str);
        this.f406068r = 100;
        this.f406069s = 0;
        this.f406066p = new ArrayList();
    }

    @Override // hr.a
    public int b() {
        return this.f406066p.size();
    }

    @Override // hr.a
    public String e() {
        return "NormalFacePackage";
    }

    public String h(String str) {
        List<b> list;
        if (StringUtil.isEmpty(str) || (list = this.f406066p) == null) {
            return null;
        }
        for (b bVar : list) {
            if (str.equals(bVar.f406071d)) {
                return bVar.f406072e;
            }
        }
        return null;
    }

    public int j(String str) {
        List<b> list;
        if (StringUtil.isEmpty(str) || (list = this.f406066p) == null) {
            return 0;
        }
        for (b bVar : list) {
            if (str.equals(bVar.f406071d)) {
                return bVar.f406073f;
            }
        }
        return 0;
    }

    public List<b> k() {
        File[] listFiles;
        int i3;
        String str;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f406065o)) {
            return null;
        }
        File file = new File(this.f406065o);
        if (!file.exists()) {
            return null;
        }
        if (file.isDirectory() && (listFiles = file.listFiles(new a())) != null) {
            for (File file2 : listFiles) {
                if (this.f406066p.size() >= 100) {
                    break;
                }
                String name = file2.getName();
                if (name.endsWith(".apng")) {
                    i3 = 1;
                } else {
                    i3 = name.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) ? 2 : 0;
                }
                if (i3 == 1) {
                    String str2 = file2.getAbsolutePath().substring(0, r10.length() - 5) + ".bpng";
                    File file3 = new File(str2);
                    if (file3.isFile() && file3.exists()) {
                        str = file3.toURI().toString();
                        arrayList.add(new b(name, file2.toURI().toString(), i3, str));
                    } else if (QLog.isColorLevel()) {
                        QLog.d("FacePackage", 2, "dynamicStatic thumbFile not exist " + str2);
                    }
                }
                str = null;
                arrayList.add(new b(name, file2.toURI().toString(), i3, str));
            }
        }
        return arrayList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("NormalFacePackage{");
        stringBuffer.append("id='");
        stringBuffer.append(this.f405988a);
        stringBuffer.append('\'');
        stringBuffer.append("logoUrl='");
        stringBuffer.append(this.f405990c);
        stringBuffer.append('\'');
        stringBuffer.append("logoDrawable='");
        stringBuffer.append(this.f405992e);
        stringBuffer.append('\'');
        stringBuffer.append(", zipDownloadUrl='");
        stringBuffer.append(this.f406064n);
        stringBuffer.append('\'');
        stringBuffer.append(", facePkgPath='");
        stringBuffer.append(this.f406065o);
        stringBuffer.append('\'');
        stringBuffer.append(", isDownloading=");
        stringBuffer.append(this.f406067q);
        stringBuffer.append(", maxProgress=");
        stringBuffer.append(this.f406068r);
        stringBuffer.append(", currentProgress=");
        stringBuffer.append(this.f406069s);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // hr.a
    public String d(int i3) {
        if (i3 < 0 || i3 >= this.f406066p.size()) {
            return null;
        }
        return this.f406066p.get(i3).f406072e;
    }

    public String g(int i3) {
        if (i3 < 0 || i3 >= this.f406066p.size()) {
            return null;
        }
        return this.f406066p.get(i3).f406074h;
    }

    public int i(int i3) {
        if (i3 < 0 || i3 >= this.f406066p.size()) {
            return 0;
        }
        return this.f406066p.get(i3).f406073f;
    }

    public void l(List<b> list) {
        if (list == null) {
            return;
        }
        this.f406066p.clear();
        this.f406066p.addAll(list);
    }
}
