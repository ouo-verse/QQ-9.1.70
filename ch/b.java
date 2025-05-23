package ch;

import android.text.TextUtils;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCover;
import com.qzone.proxy.feedcomponent.model.CellRecommendList;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.util.QzoneZipCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f30801a;

    /* renamed from: b, reason: collision with root package name */
    private String f30802b;

    /* renamed from: c, reason: collision with root package name */
    private ch.a f30803c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f30804d = VasNormalToggle.VAS_QZONE_UNZIP_BUG.isEnable(true);

    /* renamed from: e, reason: collision with root package name */
    private QzoneZipCacheHelperCallBack f30805e = new C0191b();

    /* renamed from: f, reason: collision with root package name */
    private QzoneZipCacheHelper.a f30806f = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements FileFilter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30807d;

        a(String str) {
            this.f30807d = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().contains(this.f30807d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements QzoneZipCacheHelper.a {
        c() {
        }

        @Override // com.qzone.proxy.feedcomponent.util.QzoneZipCacheHelper.a
        public void a(boolean z16, boolean z17) {
            if (b.this.f30803c == null) {
                return;
            }
            if (z16 || z17) {
                b.this.f30803c.a();
                b.this.f30803c = null;
            }
        }
    }

    private boolean d(BusinessFeedData businessFeedData) {
        return ((!(businessFeedData.getSinglePicAdvStyle() == 4 && (!businessFeedData.isAdFeeds() || !businessFeedData.isAdFeeds() || !businessFeedData.getLocalInfo().canLike || !businessFeedData.getLocalInfo().canShare || !businessFeedData.getLocalInfo().canComment)) && businessFeedData.getRecommHeader() != null && businessFeedData.feedType != 2) || (businessFeedData.getFeedCommInfo().isTopFeed() && businessFeedData.feedType == 3) || o(businessFeedData) || n(businessFeedData)) ? false : true;
    }

    private void j(String str) {
        String str2;
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            str2 = "_dark";
        } else {
            str2 = "_light";
        }
        File[] listFiles = new File(str).listFiles(new a(str2));
        if (listFiles == null || listFiles.length != 1) {
            return;
        }
        this.f30801a = listFiles[0].getAbsolutePath();
        QLog.i("QZoneFeedVipSkinControl", 2, "mLuxuryFeedSkinPath: " + this.f30801a);
    }

    private boolean o(BusinessFeedData businessFeedData) {
        return (businessFeedData.feedType == 2 || businessFeedData.getUpperBanner() == null) ? false : true;
    }

    public String e() {
        return this.f30801a;
    }

    public String f() {
        return this.f30802b;
    }

    public String g(BusinessFeedData businessFeedData) {
        int i3;
        String str;
        String str2;
        FeedSkinData cellFeedSkinInfo = businessFeedData.getCellFeedSkinInfo();
        if (cellFeedSkinInfo != null) {
            str2 = cellFeedSkinInfo.sSkinId;
            i3 = cellFeedSkinInfo.nSkinType;
            str = cellFeedSkinInfo.sPicUrl;
        } else {
            i3 = 0;
            str = "";
            str2 = null;
        }
        CellCover coverInfo = businessFeedData.getCoverInfo();
        if (coverInfo != null) {
            str2 = coverInfo.coverId;
            i3 = coverInfo.cover_type;
            str = com.qzone.adapter.feedcomponent.i.H().C0(str2);
        }
        if (TextUtils.isEmpty(str2) || "-1".equals(str2)) {
            QLog.d("QZoneFeedVipSkinControl", 2, "@new card update coverId is null");
        }
        if (TextUtils.isEmpty(str2) || i3 == 392 || TextUtils.isEmpty(str) || !d(businessFeedData)) {
            return null;
        }
        return str;
    }

    public void l(ch.a aVar) {
        this.f30803c = aVar;
    }

    public boolean m(BusinessFeedData businessFeedData) {
        boolean z16 = !TextUtils.isEmpty(businessFeedData.getCellFeedSkinInfo().strFrameZip);
        if (!c(businessFeedData) && !z16) {
            return false;
        }
        FeedSkinData cellFeedSkinInfo = businessFeedData.getCellFeedSkinInfo();
        return z16 || (cellFeedSkinInfo.nSkinType == 392 && !TextUtils.isEmpty(cellFeedSkinInfo.sPicUrl)) || (TextUtils.isEmpty(g(businessFeedData)) ^ true);
    }

    public void k() {
        this.f30801a = null;
        this.f30802b = null;
    }

    private boolean n(BusinessFeedData businessFeedData) {
        ArrayList<CellRecommendList.RecommendMan> userList;
        return (businessFeedData == null || !businessFeedData.getFeedCommInfo().isShowFeedRecommend() || businessFeedData.feedType == 2 || (userList = businessFeedData.getCellRecommendListSafe().getUserList()) == null || userList.size() <= 0) ? false : true;
    }

    public boolean c(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getUser() == null || !h(businessFeedData.getUser()) || !com.qzone.adapter.feedcomponent.i.H().d1()) {
            return false;
        }
        return (businessFeedData.getCellLuckyMoney() == null && (com.qzone.adapter.feedcomponent.i.H().u1(businessFeedData) || businessFeedData.getFeedCommInfo().recomtype == 7 || businessFeedData.getFeedCommInfo().isBizRecomFeeds() || businessFeedData.isSubFeed)) ? false : true;
    }

    private static boolean h(User user) {
        if (user == null) {
            return false;
        }
        int i3 = user.from;
        if (i3 == 0 || i3 == 1) {
            return user.uin > 0;
        }
        if (i3 == 2 || i3 == 3 || i3 == 4) {
            return !TextUtils.isEmpty(user.logo);
        }
        if (i3 != 8) {
            return false;
        }
        return (user.logoImageUrl == null && TextUtils.isEmpty(user.logo) && user.uin <= 0) ? false : true;
    }

    public boolean i(BusinessFeedData businessFeedData) {
        String d16;
        boolean b16;
        if (businessFeedData == null) {
            return false;
        }
        FeedSkinData cellFeedSkinInfo = businessFeedData.getCellFeedSkinInfo();
        if (TextUtils.isEmpty(cellFeedSkinInfo.strFrameZip)) {
            return false;
        }
        if (this.f30804d) {
            d16 = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(cellFeedSkinInfo.strFrameZip.hashCode()));
        } else {
            d16 = QzoneZipCacheHelper.d(ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(cellFeedSkinInfo.strFrameZip.hashCode()), 0);
        }
        if (new File(d16).exists() && new File(d16).isDirectory()) {
            if (new File(d16, "lv10").exists()) {
                this.f30802b = d16 + "/lv10";
            } else if (new File(d16, "luxury10").exists()) {
                j(d16 + "/luxury10/");
            }
        } else if (!TextUtils.isEmpty(cellFeedSkinInfo.strFrameZip)) {
            if (this.f30804d) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    String str = cellFeedSkinInfo.strFrameZip;
                    b16 = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).checkAndDownLoadFileIfNeeded((AppInterface) peekAppRuntime, str, ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(str.hashCode()), 0, this.f30805e);
                } else {
                    String str2 = cellFeedSkinInfo.strFrameZip;
                    b16 = QzoneZipCacheHelper.b(str2, ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(str2.hashCode()), 0, this.f30806f);
                }
            } else {
                String str3 = cellFeedSkinInfo.strFrameZip;
                b16 = QzoneZipCacheHelper.b(str3, ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(str3.hashCode()), 0, this.f30806f);
            }
            return !b16;
        }
        return false;
    }

    /* compiled from: P */
    /* renamed from: ch.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0191b implements QzoneZipCacheHelperCallBack {
        C0191b() {
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean z16) {
            if (b.this.f30803c != null && z16) {
                b.this.f30803c.a();
                b.this.f30803c = null;
            }
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean z16, String str, String str2) {
        }
    }
}
