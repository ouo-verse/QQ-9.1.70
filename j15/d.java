package j15;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.util.QZLog;
import j15.a;
import java.io.File;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d extends j15.a {

    /* renamed from: d, reason: collision with root package name */
    public i15.c f409148d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class a extends a.C10566a {
        a() {
        }

        @Override // j15.a.C10566a
        public boolean a() {
            File[] listFiles;
            if (!TextUtils.isEmpty(this.f409145c) && !TextUtils.isEmpty(d.this.f409148d.f407063d)) {
                String basePath = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(d.this.f409148d.f407063d.hashCode()));
                if (cooperation.vip.qqbanner.manager.a.f391337g) {
                    basePath = RFWDownloaderFactory.getDownloader(cooperation.vip.qqbanner.manager.a.f391338h).getDefaultSavePath(d.this.f409148d.f407063d) + "_unzip";
                }
                File file = new File(basePath);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    this.f409145c = basePath;
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // j15.a.C10566a
        public void b(boolean z16) {
            String basePath;
            super.b(z16);
            if (z16 && q.p(this.f409145c)) {
                if (cooperation.vip.qqbanner.manager.a.f391337g) {
                    basePath = RFWDownloaderFactory.getDownloader(cooperation.vip.qqbanner.manager.a.f391338h).getDefaultSavePath(d.this.f409148d.f407063d) + "_unzip";
                } else {
                    basePath = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(d.this.f409148d.f407063d.hashCode()));
                }
                File file = new File(this.f409145c);
                ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).unzipFile(file.getAbsolutePath(), basePath);
                if (file.exists()) {
                    q.c(file);
                }
                this.f409145c = basePath;
                if (QZLog.isColorLevel()) {
                    QZLog.i("VasADBannerConfigInfo", 2, "unzip success = pathDir = " + basePath);
                }
            }
        }
    }

    public d(Map<String, String> map) {
        super(map);
    }

    @Override // j15.a
    protected void a(Map<String, String> map) {
        super.a(map);
        if (map != null && f() != null) {
            try {
                this.f409148d = i15.c.a().l(map.get("topText")).c(map.get("bottomText")).j(map.get("textColor")).h(map.get("cartoon")).d(map.get("cartoon_md5")).f(map.get("cartoon_pag")).g(map.get("cartoon_md5_pag")).e(map.get("cartoonNum")).k(map.get("threeDimension")).i(map.get("statusBarColor")).b();
                if (f() != null) {
                    f().f407081l = this.f409148d;
                }
                a.C10566a c10566a = new a.C10566a();
                i15.c cVar = this.f409148d;
                String str = cVar.f407065f;
                c10566a.f409143a = str;
                c10566a.f409144b = cVar.f407066g;
                if (!TextUtils.isEmpty(str)) {
                    if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tian_shu_vas_banner_use_pag", true)) {
                        this.f409140a.clear();
                        return;
                    }
                    c10566a.f409145c = cooperation.vip.qqbanner.manager.a.e().f(this.f409148d.f407065f);
                    this.f409140a.put(8, c10566a);
                    this.f409140a.put(9, new a.C10566a().d(this.f409148d.f407063d).c(cooperation.vip.qqbanner.manager.a.e().f(this.f409148d.f407063d)));
                    return;
                }
                a aVar = new a();
                i15.c cVar2 = this.f409148d;
                String str2 = cVar2.f407063d;
                aVar.f409143a = str2;
                aVar.f409144b = cVar2.f407064e;
                if (!TextUtils.isEmpty(str2)) {
                    if (cooperation.vip.qqbanner.manager.a.f391337g) {
                        aVar.f409145c = RFWDownloaderFactory.getDownloader(cooperation.vip.qqbanner.manager.a.f391338h).getDefaultSavePath(this.f409148d.f407063d);
                    } else {
                        aVar.f409145c = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(this.f409148d.f407063d.hashCode())) + ".zip";
                    }
                    this.f409140a.put(2, aVar);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("VasADBannerConfigInfo", 1, "vas banner buildData error = " + e16);
                return;
            }
        }
        QLog.e("VasADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
    }

    @Override // j15.a
    public void c(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return;
        }
        super.c(sharedPreferences, str);
        try {
            this.f409148d = i15.c.a().l(sharedPreferences.getString("splash_union_banner_top_text" + str, "")).c(sharedPreferences.getString("splash_union_banner_bottom_text" + str, "")).j(sharedPreferences.getString("splash_union_banner_text_color" + str, "")).h(sharedPreferences.getString("splash_union_banner_cartoon_url" + str, "")).d(sharedPreferences.getString("splash_union_banner_md5" + str, "")).e(sharedPreferences.getString("splash_union_banner_cartoon_num" + str, "")).b();
            if (f() != null) {
                f().f407081l = this.f409148d;
            }
            a aVar = new a();
            i15.c cVar = this.f409148d;
            String str2 = cVar.f407063d;
            aVar.f409143a = str2;
            aVar.f409144b = cVar.f407064e;
            if (!TextUtils.isEmpty(str2)) {
                if (cooperation.vip.qqbanner.manager.a.f391337g) {
                    aVar.f409145c = RFWDownloaderFactory.getDownloader(cooperation.vip.qqbanner.manager.a.f391338h).getDefaultSavePath(this.f409148d.f407063d);
                } else {
                    aVar.f409145c = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("vas_banner", String.valueOf(this.f409148d.f407063d.hashCode())) + ".zip";
                }
            }
            aVar.a();
            this.f409140a.put(2, aVar);
        } catch (Exception e16) {
            QLog.e("VasADBannerConfigInfo", 1, "buildUnionBannerFromSP error " + e16);
        }
    }

    @Override // j15.a
    public void j(String str) {
        SharedPreferences l3 = com.tencent.mobileqq.vassplash.common.c.l(BaseApplication.getContext(), str + "");
        if (l3 != null && f() != null) {
            super.j(str);
            SharedPreferences.Editor edit = l3.edit();
            String str2 = f().f407075f;
            edit.putString("splash_union_banner_top_text" + str2, this.f409148d.f407060a);
            edit.putString("splash_union_banner_bottom_text" + str2, this.f409148d.f407061b);
            edit.putString("splash_union_banner_text_color" + str2, this.f409148d.f407062c);
            edit.putString("splash_union_banner_cartoon_url" + str2, this.f409148d.f407063d);
            edit.putString("splash_union_banner_md5" + str2, this.f409148d.f407064e);
            edit.putString("splash_union_banner_cartoon_num" + str2, this.f409148d.f407067h);
            edit.apply();
        }
    }
}
