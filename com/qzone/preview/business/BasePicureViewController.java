package com.qzone.preview.business;

import NS_MOBILE_FEEDS.FaceRecommendInfo;
import NS_MOBILE_FEEDS.s_pic_host;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.s_outshare;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.tool.ReportUtils;
import com.qzone.preview.BasePictureViewer;
import com.qzone.preview.LocalPictureViewer;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.database.PictureViewerCacheData;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.util.ToastUtil;
import com.qzone.util.aj;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.QzoneFaceFriendSelectPopWindow;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.qzoneplayer.video.AutoVideoProgressRecorder;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfoHolder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.ShareArkInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import g5.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import n5.d;

/* loaded from: classes39.dex */
public class BasePicureViewController implements com.tencent.common.galleryactivity.e {
    protected static boolean N = true;
    public static final long O = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MAX_P2V_VIDEO_DURING, 15000L);
    private static final int[] P = {11, 3, 1, 0};
    protected int B;
    private f C;
    public boolean E;
    protected com.qzone.preview.b J;
    QzoneFaceFriendSelectPopWindow.d K;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f49871a;

    /* renamed from: b, reason: collision with root package name */
    protected PhotoInfo[] f49872b;

    /* renamed from: d, reason: collision with root package name */
    protected int f49874d;

    /* renamed from: e, reason: collision with root package name */
    public Photo f49875e;

    /* renamed from: g, reason: collision with root package name */
    public PhotoParam f49877g;

    /* renamed from: h, reason: collision with root package name */
    public int f49878h;

    /* renamed from: i, reason: collision with root package name */
    public int f49879i;

    /* renamed from: y, reason: collision with root package name */
    protected RecomAlbumList f49895y;

    /* renamed from: c, reason: collision with root package name */
    protected int f49873c = 0;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f49876f = true;

    /* renamed from: j, reason: collision with root package name */
    public int f49880j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f49881k = 0;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f49882l = true;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f49883m = true;

    /* renamed from: n, reason: collision with root package name */
    protected int f49884n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f49885o = 0;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f49886p = false;

    /* renamed from: q, reason: collision with root package name */
    boolean f49887q = false;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList<FaceData> f49888r = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    public int f49889s = 1;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f49890t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f49891u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f49892v = true;

    /* renamed from: w, reason: collision with root package name */
    private boolean f49893w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f49894x = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f49896z = false;
    public int A = 1;
    public boolean D = false;
    private ConcurrentHashMap<String, Boolean> F = new ConcurrentHashMap<>();
    private HashMap<String, Boolean> G = new HashMap<>();
    h8.a H = new h8.a();
    protected e I = null;
    public HashMap<String, FaceRecommendInfo> L = new HashMap<>();
    private d M = null;

    /* loaded from: classes39.dex */
    public interface d {
        void a(MotionEvent motionEvent, float f16, boolean z16);

        void b(float f16);
    }

    /* loaded from: classes39.dex */
    public interface e {
        void a(boolean z16);
    }

    /* loaded from: classes39.dex */
    public interface f {
        void a(int i3);
    }

    private static String A(Map<Integer, s_picurl> map) {
        if (map == null) {
            return "";
        }
        for (int i3 : P) {
            if (map.containsKey(Integer.valueOf(i3)) && map.get(Integer.valueOf(i3)) != null && map.get(Integer.valueOf(i3)).url != null) {
                return map.get(Integer.valueOf(i3)).url;
            }
        }
        return "";
    }

    private void Z() {
        PhotoParam photoParam = this.f49877g;
        if (photoParam == null || photoParam.appid != 311) {
            return;
        }
        this.f49889s = 2;
    }

    public static boolean a0() {
        int i3 = BasePictureViewer.X0;
        return i3 == 3 || i3 == 11;
    }

    public static boolean b0() {
        int i3 = BasePictureViewer.X0;
        return i3 == 1 || i3 == 9 || i3 == 12;
    }

    public static boolean f0() {
        return BasePictureViewer.X0 == 2;
    }

    public static void f1(Album album, int i3, PhotoInfo photoInfo, Photo photo, PhotoParam photoParam) {
        photoInfo.albumId = photo.albumid;
        photoInfo.appid = photoParam.appid;
        PictureViewerFactory.g0(photoInfo, photo, album != null ? album.type : 1);
        if (album != null) {
            if (!TextUtils.isEmpty(album.albumid) && TextUtils.isEmpty(photoInfo.albumId)) {
                photoInfo.albumId = album.albumid;
            }
            photoInfo.allow_share = album.allow_share;
            photoInfo.opMask = album.opmask;
            photoInfo.albumName = album.name;
        }
        if (!TextUtils.isEmpty(photoInfo.orgUrl) && photoInfo.hasLocalOrgFile == null) {
            photoInfo.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null);
        }
        if (photoParam.appid == 311 && i3 == 1) {
            photoInfo.hasPraise = photoParam.isLike;
        }
        B(photoInfo, photo);
    }

    public static boolean g0() {
        return BasePictureViewer.X0 == 8;
    }

    public static boolean i0() {
        return BasePictureViewer.X0 == 0;
    }

    public static boolean n0() {
        int i3 = BasePictureViewer.X0;
        return i3 == 1 || i3 == 3 || i3 == 13 || i3 == 9 || i3 == 12 || i3 == 11;
    }

    public static boolean o0() {
        return BasePictureViewer.X0 == 13;
    }

    private void t0(Context context, String str) {
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromQZone", true);
            if (o0()) {
                intent.setFlags(402653184);
            }
            intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
            intent.addFlags(268435456);
            yo.b.a(intent);
            context.startActivity(intent);
        }
    }

    public static boolean w0() {
        return N;
    }

    public void A0(MotionEvent motionEvent, float f16, boolean z16) {
        d dVar = this.M;
        if (dVar != null) {
            dVar.a(motionEvent, f16, z16);
        }
    }

    public boolean B0(PhotoInfo photoInfo, boolean z16, int i3, int i16) {
        if (this.f49877g.appid != 311) {
            return false;
        }
        if (z0(photoInfo) && this.f49877g.isLike != z16) {
            for (PhotoInfo photoInfo2 : P()) {
                if (z16) {
                    photoInfo2.praiseCount++;
                } else {
                    photoInfo2.praiseCount--;
                }
                photoInfo2.hasPraise = z16;
            }
        }
        PhotoParam photoParam = this.f49877g;
        photoParam.isLike = z16;
        photoParam.likeNum = i3;
        photoParam.commentNum = i16;
        return true;
    }

    public void C(String str, String str2, Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(b16.lloc);
        PhotoParam photoParam = this.f49877g;
        long j3 = photoParam.realOwnerUin;
        PictureManager.getInstance().getSender().forwardPhoto(handler, str, str2, 4, 0, j3 >= 10001 ? j3 : photoParam.ownerUin, this.f49877g.albumid, arrayList);
    }

    public int D() {
        return F().commentCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D0(Map<Integer, byte[]> map) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_SWITCH, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < config) {
            QZLog.i("[PhotoAlbum]BasePicureViewController", 2, "[parseRecomAlbumListForPhotoList] current sdk ", Integer.valueOf(i3), " less than lessSdkVersion ", Integer.valueOf(config));
            return;
        }
        this.f49895y = new RecomAlbumList();
        this.f49895y.parsedFromFeature(map, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND, -1), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND, 2));
    }

    public String E() {
        String str = "";
        if (this.f49877g.ownerUin >= 10001) {
            str = "" + this.f49877g.ownerUin;
        }
        if (!TextUtils.isEmpty(this.f49877g.albumid)) {
            str = str + "_" + this.f49877g.albumid;
        }
        PhotoInfo b16 = b();
        if (b16 == null || TextUtils.isEmpty(b16.lloc)) {
            return str;
        }
        return str + "_" + b16.lloc;
    }

    public PhotoInfo F() {
        return getItem(this.f49873c);
    }

    public void F0(QzoneFavoriteService.d dVar, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            if (dVar != null) {
                dVar.a(null, false);
                return;
            }
            return;
        }
        Boolean bool = this.F.get(str);
        if (bool != null && z16) {
            boolean z17 = !bool.booleanValue();
            this.F.put(str, Boolean.valueOf(z17));
            if (dVar != null) {
                dVar.a(null, z17);
                return;
            }
            return;
        }
        if (bool == null) {
            g5.a.b(new a(dVar, str), str);
        } else if (dVar != null) {
            dVar.a(null, bool.booleanValue());
        }
    }

    public PhotoParam G() {
        return this.f49877g;
    }

    public void G0() {
        PhotoInfo[] P2 = P();
        if (P2 == null) {
            return;
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (PhotoInfo photoInfo : P2) {
            if (photoInfo != null) {
                boolean z16 = photoInfo.hasVisited;
                if (z16) {
                    i17++;
                }
                boolean z17 = photoInfo.hasPreDownload;
                if (z17) {
                    i3++;
                }
                if (z17 && z16) {
                    i16++;
                }
            }
        }
        if (i3 == 0) {
            return;
        }
        int i18 = i3 != 0 ? (i16 * 100) / i3 : 0;
        String format = String.format("PictureViewer--reportHitRate[visitedCount=%d,preDownloadCout=%d,hitCount=%d,hitRate=%d%%]", Integer.valueOf(i17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i18));
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.PICTURE_PREVIEW, 2, format);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("visitedCount", String.valueOf(i17));
        hashMap.put("preDownloadCout", String.valueOf(i3));
        hashMap.put("hitCount", String.valueOf(i16));
        hashMap.put("hitRate", String.valueOf(i18));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), "pic.QzonePictureViewer.PreloadHitRate", true, 0L, 0L, hashMap, null);
    }

    public int H() {
        return this.f49874d;
    }

    public void H0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.G.put(str, Boolean.TRUE);
    }

    public QzoneFaceFriendSelectPopWindow.d I() {
        if (this.K == null) {
            this.K = new c();
        }
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0(int i3) {
        this.f49885o = this.f49873c - i3;
    }

    public Handler J() {
        return this.J.getHandler();
    }

    public void J0(Activity activity, d.g gVar) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        if (!f()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotQuotePhoto", "\u4e3b\u4eba\u4e0d\u5141\u8bb8\u8f6c\u8f7d\u7167\u7247"), 4);
            return;
        }
        NetImageInfo netImageInfo = new NetImageInfo(b16.currentUrl, b16.bigUrl, b16.albumId);
        netImageInfo.lloc = b16.lloc;
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        arrayList.add(netImageInfo);
        n5.d.l().s(1);
        n5.d.l().r(gVar);
        n5.d.l().u(new n5.b());
        n5.d l3 = n5.d.l();
        PhotoParam photoParam = this.f49877g;
        l3.o(activity, arrayList, photoParam.appid, photoParam.ownerUin, null);
    }

    @Override // com.tencent.common.galleryactivity.e
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public PhotoInfo getItem(int i3) {
        PhotoInfo[] photoInfoArr = this.f49872b;
        if (photoInfoArr != null && i3 < photoInfoArr.length && i3 >= 0) {
            PhotoInfo photoInfo = photoInfoArr[i3];
            e1(photoInfo);
            return photoInfo != null ? photoInfo : new PhotoInfo();
        }
        return new PhotoInfo();
    }

    public void K0(Bundle bundle) {
        PictureViewerCacheData c16 = this.H.c();
        if (c16 != null && this.J.getHostActivity() != null) {
            this.f49873c = c16.mCurPhotoIndex;
            ArrayList arrayList = (ArrayList) c16.list;
            if (arrayList != null) {
                this.f49872b = (PhotoInfo[]) arrayList.toArray(new PhotoInfo[0]);
            }
            this.f49874d = c16.mPhotoCount;
            this.f49878h = c16.getPicListFlag;
            this.f49879i = c16.pressIndex;
            this.f49880j = c16.mLeftIndex;
            this.f49881k = c16.mRightIndex;
            this.f49882l = c16.mIsLeftFinish;
            this.f49883m = c16.mIsRightFinish;
            this.f49877g = c16.photoParam;
            this.f49876f = c16.mIsBottomBarUp;
            this.f49886p = c16.hasResponed;
            this.D = true;
            if (QZLog.isColorLevel()) {
                QZLog.d("[PhotoAlbum]BasePicureViewController", 2, "restore ", Integer.valueOf(this.f49873c), " ", Integer.valueOf(this.f49874d), " ", Integer.valueOf(this.f49878h), " ", Integer.valueOf(this.f49879i), " ", Integer.valueOf(this.f49880j), " ", Integer.valueOf(this.f49881k), " ", Boolean.valueOf(this.f49882l), " ", Boolean.valueOf(this.f49883m), " ", Boolean.valueOf(this.f49876f), " ", this.f49877g);
                return;
            }
            return;
        }
        QZLog.w("[PhotoAlbum]BasePicureViewController", "PictureViewerCacheData == null");
        this.J.getHostActivity().finish();
    }

    public long L() {
        PhotoParam photoParam = this.f49877g;
        if (photoParam != null) {
            return photoParam.ownerUin;
        }
        return 0L;
    }

    public void L0() {
        LocalMultiProcConfig.putBool("BasePictureViewController#mIsBottomBarUp", this.f49876f);
    }

    public int M() {
        return this.B;
    }

    public void M0(Bundle bundle) {
        PhotoInfo[] photoInfoArr = this.f49872b;
        if (photoInfoArr == null) {
            QZLog.w("[PhotoAlbum]BasePicureViewController", "[saveInstanceState] mPhotoInfos is null");
            return;
        }
        PictureViewerCacheData pictureViewerCacheData = new PictureViewerCacheData(Arrays.asList(photoInfoArr), this.f49873c, this.f49874d, this.f49878h, this.f49879i, this.f49880j, this.f49881k, this.f49882l, this.f49883m, this.f49876f, this.f49877g, this.f49886p);
        if (QZLog.isColorLevel()) {
            QZLog.d("[PhotoAlbum]BasePicureViewController", 2, "saveInstanceState ", Integer.valueOf(this.f49873c), " ", Integer.valueOf(this.f49874d), " ", Integer.valueOf(this.f49878h), " ", Integer.valueOf(this.f49879i), " ", Integer.valueOf(this.f49880j), " ", Integer.valueOf(this.f49881k), " ", Boolean.valueOf(this.f49882l), " ", Boolean.valueOf(this.f49883m), " ", Boolean.valueOf(this.f49876f), " ", this.f49877g);
        }
        this.H.e(pictureViewerCacheData);
    }

    public int N() {
        return F().praiseCount;
    }

    public void O(Handler handler) {
        if (PictureManager.getInstance().checkNetworkConnect()) {
            P0(handler);
        }
    }

    public PhotoInfo[] P() {
        return this.f49872b;
    }

    public boolean P0(Handler handler) {
        return false;
    }

    public void Q0(com.qzone.preview.b bVar) {
        this.J = bVar;
    }

    public RecomAlbumList R() {
        RecomAlbumList recomAlbumList = this.f49895y;
        if (recomAlbumList == null || !recomAlbumList.canBeShown()) {
            return null;
        }
        return this.f49895y;
    }

    public void R0(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f49872b != null) {
            int i3 = 0;
            while (true) {
                PhotoInfo[] photoInfoArr = this.f49872b;
                if (i3 >= photoInfoArr.length) {
                    break;
                }
                arrayList.add(photoInfoArr[i3]);
                i3++;
            }
        }
        extras.putSerializable("picturelist", arrayList);
        extras.putBoolean(PictureConst.KEY_NEED_OPEN_FACE, this.f49896z);
        intent.putExtras(extras);
    }

    @Override // com.tencent.common.galleryactivity.e
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public PhotoInfo b() {
        return getItem(this.f49873c);
    }

    public boolean T() {
        return this.f49892v;
    }

    public void T0(d dVar) {
        if (this.M != dVar) {
            this.M = dVar;
        }
    }

    public String U() {
        PhotoParam photoParam = this.f49877g;
        if (photoParam == null) {
            return null;
        }
        if (photoParam.appid == 4 && !W()) {
            PhotoInfo b16 = b();
            if (b16 == null) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f49877g.ownerUin);
            sb5.append("_");
            PhotoParam photoParam2 = this.f49877g;
            sb5.append(photoParam2.mFromRecent ? 4 : photoParam2.appid);
            sb5.append("_");
            sb5.append(this.f49877g.albumid);
            sb5.append("_");
            sb5.append(b16.lloc);
            return sb5.toString();
        }
        return this.f49877g.ugcKey;
    }

    public void U0(e eVar) {
        this.I = eVar;
    }

    public boolean V() {
        return this.f49886p;
    }

    public void V0(float f16) {
        d dVar = this.M;
        if (dVar != null) {
            dVar.b(f16);
        }
    }

    public boolean W() {
        PhotoInfo b16;
        PhotoParam photoParam = this.f49877g;
        if (photoParam != null && photoParam.appid == 4 && photoParam.isOnePictureFeed && (b16 = b()) != null && !TextUtils.isEmpty(b16.currentUrl)) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QzonePictureViewer", 4, "curSmallURL=" + b16.lloc + ",enter url=" + this.f49877g.oneFeedPictruePath);
            }
            if (b16.lloc.equals(this.f49877g.oneFeedPictruePath)) {
                if (!QZLog.isDevelopLevel()) {
                    return true;
                }
                QZLog.d("QzonePictureViewer", 4, "curSmallURL=" + b16.lloc + ",enter url=" + this.f49877g.oneFeedPictruePath + ",hit");
                return true;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QzonePictureViewer", 4, "curSmallURL=" + b16.lloc + ",enter url=" + this.f49877g.oneFeedPictruePath + ",not hit");
            }
        }
        return false;
    }

    public void W0(f fVar) {
        this.C = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(PhotoInfo photoInfo) {
        if (photoInfo.busi_param == null) {
            photoInfo.busi_param = new HashMap();
        }
        if (photoInfo.lloc != null) {
            photoInfo.busi_param.put(2, photoInfo.lloc);
            photoInfo.busi_param.put(1, photoInfo.sloc);
        }
        photoInfo.busi_param.put(15, photoInfo.bigUrl);
    }

    public boolean X0() {
        return false;
    }

    public void Y(Bundle bundle) {
        this.B = bundle.getInt(PictureConst.KEY_PAGE_MODE, 0);
        this.f49873c = bundle.getInt("curindex");
        this.f49887q = bundle.getBoolean(PictureConst.KEY_PHOTO_PREVIEW_LOCAL, false);
        ArrayList arrayList = (ArrayList) bundle.getSerializable("picturelist");
        if (arrayList != null) {
            this.f49872b = (PhotoInfo[]) arrayList.toArray(new PhotoInfo[0]);
        }
        PhotoInfo[] photoInfoArr = this.f49872b;
        if (photoInfoArr != null) {
            this.f49874d = photoInfoArr.length;
        }
        PhotoParam photoParam = (PhotoParam) bundle.getParcelable("photo_param");
        this.f49877g = photoParam;
        if (photoParam == null) {
            this.f49877g = new PhotoParam();
        }
        if (this.f49877g.loginUin != 0) {
            LoginData.getInstance().setUin(this.f49877g.loginUin);
        }
        this.f49879i = this.f49873c;
        this.f49893w = bundle.getBoolean(PictureConst.KEY_FAKE_FEED, false);
        this.f49894x = bundle.getBoolean(PictureConst.PARAM_FROM_WX, false);
        this.f49871a = bundle.getBoolean(PictureConst.KEY_SAFE_MODE_FEED, false);
        if (bundle.getSerializable(PictureConst.KEY_SHOW_PROGRESSVIEW) != null) {
            N = ((Boolean) bundle.getSerializable(PictureConst.KEY_SHOW_PROGRESSVIEW)).booleanValue();
        }
        this.f49876f = LocalMultiProcConfig.getBool("BasePictureViewController#mIsBottomBarUp", true);
        this.f49896z = bundle.getBoolean(PictureConst.KEY_NEED_OPEN_FACE);
        this.A = bundle.getInt(PictureConst.KEY_NEED_FACE_FUNTION, 1);
        Z();
    }

    public boolean Y0() {
        return this.f49890t || this.f49886p;
    }

    public void Z0(boolean z16) {
        this.f49892v = z16;
        e eVar = this.I;
        if (eVar != null) {
            eVar.a(z16);
        }
    }

    @Override // com.tencent.common.galleryactivity.e
    public void a(int i3) {
        this.f49873c = i3;
        f fVar = this.C;
        if (fVar != null) {
            fVar.a(i3);
        }
    }

    public void a1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g5.a.b(new b(str), str);
    }

    public void b1(FaceData faceData, int i3, String str) {
        int i16 = 0;
        if (b().unikey.equals(str)) {
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "updateFaceData hit index:", Integer.valueOf(i3), " unikey:", str);
            b().mFaceList.set(i3, faceData);
            return;
        }
        while (true) {
            PhotoInfo[] photoInfoArr = this.f49872b;
            if (i16 >= photoInfoArr.length) {
                return;
            }
            PhotoInfo photoInfo = photoInfoArr[i16];
            if (photoInfo != null && !TextUtils.isEmpty(photoInfo.unikey) && this.f49872b[i16].unikey.equals(str)) {
                this.f49872b[i16].mFaceList.set(i3, faceData);
            }
            i16++;
        }
    }

    public boolean c0() {
        return this.f49876f;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.G.put(str, Boolean.FALSE);
    }

    public boolean d0(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = this.G.get(str)) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean e0() {
        return this.f49893w;
    }

    public boolean f() {
        if (b0()) {
            return ((b().opsynflag & 64) == 64) && h0();
        }
        return ((b().opMask & 128) != 0) && h0() && (this.f49877g.appid != 2) && ((b().allow_share != 0) || (this.f49877g.appid == 311));
    }

    public boolean g() {
        return false;
    }

    public boolean g1(int i3, int i16, Callback callback) {
        return false;
    }

    @Override // com.tencent.common.galleryactivity.e
    public int getCount() {
        return this.f49874d;
    }

    @Override // com.tencent.common.galleryactivity.e
    public int getSelectedIndex() {
        return this.f49873c;
    }

    public boolean h() {
        PhotoParam photoParam = this.f49877g;
        return photoParam == null || photoParam.appid != 7035;
    }

    public boolean h0() {
        PhotoParam photoParam = this.f49877g;
        if (photoParam == null) {
            return false;
        }
        long j3 = photoParam.loginUin;
        return j3 != 0 ? photoParam.ownerUin != j3 : photoParam.ownerUin != LoginData.getInstance().getUin();
    }

    public void i1(long j3, String str, String str2, int i3) {
        ArrayList<FaceData> arrayList;
        PhotoInfo b16 = b();
        if (i3 == -1 || b16 == null || (arrayList = b16.mFaceList) == null || i3 >= arrayList.size()) {
            return;
        }
        FaceData faceData = b16.mFaceList.get(i3);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        faceData.targetnick = str;
        faceData.targetuin = j3;
        faceData.writernick = G().loginNickName;
        faceData.writeruin = G().loginUin;
        faceData.isRecommend = false;
        ArrayList<FaceRecommendInfo> arrayList2 = faceData.recommend_infos;
        if (arrayList2 != null && arrayList2.size() != 0) {
            faceData.targetGroupid = faceData.recommend_infos.get(0).groupid;
        }
        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[\u66f4\u65b0\u63a8\u8350\u4eba] targetnick:", faceData.targetnick, " targetuin:", Long.valueOf(faceData.targetuin), " writernick:", faceData.writernick, " writeruin:", Long.valueOf(faceData.writeruin), " targetGroupid:", faceData.targetGroupid);
        this.J.h7().l().K();
        this.J.h7().l().x().notifyDataSetChanged();
    }

    public boolean j() {
        return false;
    }

    public boolean j0() {
        PhotoParam photoParam = this.f49877g;
        return photoParam != null && photoParam.isOnlyPreView;
    }

    public void j1(long j3, String str, String str2, int i3) {
        ArrayList<FaceData> arrayList;
        PhotoInfo b16 = b();
        if (i3 == -1 || b16 == null || (arrayList = b16.mFaceList) == null || i3 >= arrayList.size()) {
            return;
        }
        FaceData faceData = b16.mFaceList.get(i3);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        faceData.targetnick = str;
        faceData.targetuin = j3;
        faceData.writernick = G().loginNickName;
        faceData.writeruin = G().loginUin;
        faceData.isRecommend = false;
        ArrayList<FaceRecommendInfo> arrayList2 = faceData.recommend_infos;
        if (arrayList2 != null && arrayList2.size() != 0) {
            faceData.targetGroupid = faceData.recommend_infos.get(0).groupid;
        }
        if (!TextUtils.isEmpty(faceData.groupid)) {
            HashMap<String, FaceRecommendInfo> hashMap = this.L;
            String str3 = faceData.groupid;
            hashMap.put(str3, new FaceRecommendInfo(faceData.targetuin, faceData.targetnick, str3));
        }
        O0(faceData, i3, 1);
        this.J.h7().l().K();
        this.J.h7().l().h();
    }

    public boolean k() {
        PhotoInfo F = F();
        return (F == null || (F.opsynflag & 128) == 0) ? false : true;
    }

    public boolean k0() {
        PhotoParam photoParam = this.f49877g;
        return photoParam != null && photoParam.appid == 4;
    }

    public boolean l() {
        return true;
    }

    public boolean l0() {
        int i3;
        PhotoInfo[] photoInfoArr = this.f49872b;
        return photoInfoArr != null && (i3 = this.f49873c) < photoInfoArr.length && i3 >= 0;
    }

    public boolean m() {
        PhotoInfo b16 = b();
        return (b16 == null || TextUtils.isEmpty(b16.albumId) || TextUtils.isEmpty(b16.lloc)) ? false : true;
    }

    public boolean m0() {
        int i3 = this.f49877g.appid;
        return i3 == 4 || i3 == 422 || i3 == 423;
    }

    public boolean n() {
        PhotoInfo b16 = b();
        return (b16 == null || TextUtils.isEmpty(b16.albumId) || TextUtils.isEmpty(b16.lloc) || TextUtils.isEmpty(this.f49877g.cell_id)) ? false : true;
    }

    public boolean o() {
        PhotoParam photoParam = this.f49877g;
        return (photoParam == null || photoParam.ownerUin == photoParam.loginUin) ? false : true;
    }

    public boolean p0() {
        PhotoParam photoParam = this.f49877g;
        return photoParam != null && photoParam.appid == 422;
    }

    public boolean q0() {
        PhotoParam photoParam = this.f49877g;
        return photoParam != null && photoParam.appid == 311;
    }

    public void r0(Context context) {
        String str;
        PhotoInfo F = F();
        String j3 = yo.f.j(yo.f.j(yo.f.j(yo.f.j(yo.f.t(yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", "Report", "https://jubao.qq.com/uniform_impeach/impeach_entry?system={system}&version={qua}&uintype=1&eviluin={eviluin}&appname={appname}&appid={appid}&scene={scene}&subapp={subapp}&srv_para={srv_para}"), "{system}", "android")), "{appname}", "mqzone"), "{appid}", "2400003"), "{subapp}", "photo"), "{scene}", "1305");
        long L = L();
        if (L == 0) {
            L = F().uploaduin;
        }
        String i3 = yo.f.i(j3, "{eviluin}", L);
        String replace = "pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}".replace("{own_uin}", String.valueOf(L)).replace("{qzone_appid}", "4");
        try {
            if (m0()) {
                replace = replace.replace("{pid}", this.f49877g.albumid);
                if (!TextUtils.isEmpty(F.sloc)) {
                    str = replace.replace("{cid}", F.sloc);
                } else {
                    str = replace.replace("{cid}", F.lloc);
                }
            } else {
                replace = replace.replace("{pid}", "0");
                str = replace.replace("{cid}", this.f49877g.ugcKey);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            str = replace;
        }
        t0(context, yo.f.j(i3, "{srv_para}", str));
    }

    public boolean s() {
        return F().hasPraise;
    }

    public void s0(Activity activity) {
        ArrayList<AlbumCacheData> arrayList;
        RecomAlbumList recomAlbumList = this.f49895y;
        if (recomAlbumList == null || !recomAlbumList.canBeShown() || (arrayList = this.f49895y.recomAlbumList) == null || arrayList.size() <= 0) {
            return;
        }
        long j3 = this.f49895y.recomAlbumList.get(0).ownerUin;
        long j16 = this.f49895y.recomAlbumList.get(0).loginUin;
        vo.b.f(activity, j3, "qzone_recom_album_list");
    }

    public void t(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        if (q0()) {
            VideoInfo videoInfo = b16.videodata;
            if (videoInfo != null && !TextUtils.isEmpty(videoInfo.videoId)) {
                ArrayList<String> arrayList = new ArrayList<>(1);
                arrayList.add(b16.videodata.videoId);
                QZLog.i("[PhotoAlbum]BasePicureViewController", 2, "delete shuoshuo video ", b16.videodata.videoId);
                PictureManager.getInstance().getSender().deleteShuoShuoVideo(handler, 311, arrayList);
                return;
            }
            QZLog.e("[PhotoAlbum]BasePicureViewController", 2, "delete shuoshuo video fail with empty vid");
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>(1);
        ArrayList<String> arrayList3 = new ArrayList<>(1);
        arrayList2.add(b16.lloc);
        VideoInfo videoInfo2 = b16.videodata;
        if (videoInfo2 != null && !TextUtils.isEmpty(videoInfo2.videoId)) {
            arrayList3.add(b16.videodata.videoId);
        }
        QZLog.i("[PhotoAlbum]BasePicureViewController", 2, "delete album video ", b16.lloc);
        PictureManager.getInstance().getSender().deletePhoto(handler, this.f49877g.albumid, arrayList2, arrayList3);
    }

    public void v() {
        try {
            this.f49872b = (PhotoInfo[]) com.qzone.util.d.b(this.f49872b, this.f49873c);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        int i3 = this.f49873c;
        int i16 = this.f49874d;
        if (i3 == i16 - 1) {
            this.f49873c = i3 - 1;
        }
        this.f49874d = i16 - 1;
        this.f49881k--;
    }

    public boolean z0(PhotoInfo photoInfo) {
        return false;
    }

    /* loaded from: classes39.dex */
    class c implements QzoneFaceFriendSelectPopWindow.d {
        c() {
        }

        @Override // com.qzone.widget.QzoneFaceFriendSelectPopWindow.d
        public void b(FaceData faceData, int i3) {
            if (BasePicureViewController.this.J.getHostActivity() == null) {
                return;
            }
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ForwardFriendListActivity.class);
            intent.putExtra("extra_choose_friend", 7);
            intent.putExtra("only_single_selection", true);
            intent.putExtra("key_selected_share_touch_face_position", i3);
            intent.putExtra("key_selected_facedata", faceData);
            com.qzone.preview.b bVar = BasePicureViewController.this.J;
            if (bVar instanceof LocalPictureViewer) {
                bVar.getHostActivity().startActivityForResult(intent, 1003);
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 4);
                HashMap hashMap = new HashMap(1);
                hashMap.put("markFace", String.valueOf(1));
                ReportUtils.b("faceData", hashMap);
                return;
            }
            bVar.getHostActivity().startActivityForResult(intent, 1004);
        }

        @Override // com.qzone.widget.QzoneFaceFriendSelectPopWindow.d
        public void a(FaceData faceData, int i3, int i16) {
            ArrayList<FaceRecommendInfo> arrayList;
            if (faceData == null || (arrayList = faceData.recommend_infos) == null || arrayList.size() == 0) {
                return;
            }
            FaceRecommendInfo faceRecommendInfo = faceData.recommend_infos.get(i3);
            faceData.targetuin = faceRecommendInfo.uin;
            faceData.targetnick = faceRecommendInfo.nick;
            faceData.targetGroupid = faceRecommendInfo.groupid;
            faceData.isRecommend = true;
            faceData.writeruin = LoginData.getInstance().getUin();
            com.qzone.preview.b bVar = BasePicureViewController.this.J;
            if (bVar != null && bVar.h7() != null && BasePicureViewController.this.J.h7().l() != null && BasePicureViewController.this.J.h7().l().x() != null) {
                QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[BasePicureViewController] FaceClick notifyDataSetChanged");
                BasePicureViewController.this.J.h7().l().K();
                BasePicureViewController.this.J.h7().l().x().notifyDataSetChanged();
            }
            if (!(BasePicureViewController.this.J instanceof LocalPictureViewer)) {
                if (!TextUtils.isEmpty(faceData.groupid)) {
                    QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[Cache] recommendInfoCache faceData.groupid:", faceData.groupid);
                    BasePicureViewController.this.L.put(faceData.groupid, faceRecommendInfo);
                }
                BasePicureViewController.this.O0(faceData, i16, 1);
                return;
            }
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 5);
            HashMap hashMap = new HashMap(1);
            hashMap.put("markFace", String.valueOf(1));
            hashMap.put("recommendUinClick", String.valueOf(1));
            ReportUtils.b("faceData", hashMap);
        }
    }

    public void Q(Callback callback) {
        QZLog.d("QzonePictureViewer", 4, "getPhotoList()");
        if (this.D) {
            QZLog.d("[PhotoAlbum]BasePicureViewController", 1, "getPhotoList... restore not getPhotoList");
            this.D = false;
            this.f49890t = true;
            J().post(new Runnable() { // from class: com.qzone.preview.business.BasePicureViewController.1
                @Override // java.lang.Runnable
                public void run() {
                    BasePicureViewController.this.J.h7().l().h();
                }
            });
            return;
        }
        if (!PictureManager.getInstance().checkNetworkConnect()) {
            this.f49890t = true;
        } else if (!g1(1, 1, callback)) {
            this.f49890t = true;
        } else {
            this.f49890t = false;
            J().postDelayed(new Runnable() { // from class: com.qzone.preview.business.BasePicureViewController.2
                @Override // java.lang.Runnable
                public void run() {
                    BasePicureViewController.this.f49890t = true;
                }
            }, 3000L);
        }
    }

    public void S0(ArrayList<FaceData> arrayList, String str, boolean z16) {
        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[BasePicureViewController setFaceList] mPhotoInfos size:", Integer.valueOf(this.f49872b.length));
        int i3 = 0;
        while (true) {
            PhotoInfo[] photoInfoArr = this.f49872b;
            if (i3 >= photoInfoArr.length) {
                return;
            }
            PhotoInfo photoInfo = photoInfoArr[i3];
            if (photoInfo != null && str.equals(photoInfo.bigUrl)) {
                QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[BasePicureViewController setFaceList] setFaceList i:", Integer.valueOf(i3), " onlyUpdateRecommmand:", Boolean.valueOf(z16), " match:", str);
                if (z16) {
                    for (int i16 = 0; i16 < arrayList.size(); i16++) {
                        this.f49872b[i3].mFaceList.get(i16).groupid = arrayList.get(i16).groupid;
                        this.f49872b[i3].mFaceList.get(i16).recommend_infos = arrayList.get(i16).recommend_infos;
                    }
                } else {
                    this.f49872b[i3].mFaceList = arrayList;
                }
                this.f49872b[i3].hasCheckFace = true;
                return;
            }
            i3++;
        }
    }

    public void c1(PhotoInfo photoInfo) {
        ArrayList<FaceData> arrayList;
        if (photoInfo != null && (arrayList = photoInfo.mFaceList) != null) {
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[BasePicureViewController updateFaceList] photoInfo.mFaceList size:", Integer.valueOf(arrayList.size()), "\nphotoInfo.bigUrl:", photoInfo.bigUrl);
            S0(photoInfo.mFaceList, photoInfo.bigUrl, true);
        } else {
            QZLog.e("[PhotoAlbum]FaceFuntion", 1, "photoInfo is null");
        }
    }

    public void x0(Callback callback) {
        QZLog.d("QzonePictureViewer", 4, "needGetPhoto()");
        int i3 = this.f49880j;
        if (i3 > 0 && this.f49873c - this.f49884n == i3 && !this.f49882l) {
            g1(1, 0, callback);
            this.f49879i = this.f49873c;
        } else if (this.f49873c + this.f49884n == this.f49881k && !this.f49883m) {
            g1(0, 1, callback);
            this.f49879i = this.f49873c;
        }
        if (this.E) {
            QZLog.d("[PhotoAlbum]BasePicureViewController", 1, "this log is for qzonetest : the Picture is loading complete.");
            this.E = false;
        }
    }

    public static boolean e(PhotoInfo photoInfo) {
        return photoInfo != null && (photoInfo.opsynflag & 16) == 16;
    }

    private void e1(PhotoInfo photoInfo) {
        VideoInfo videoInfo;
        String str;
        if (photoInfo == null || (videoInfo = photoInfo.videodata) == null || (str = videoInfo.videoId) == null) {
            return;
        }
        try {
            String[] split = str.split("[#]");
            if (split.length == 3) {
                long parseLong = Long.parseLong(split[1]);
                Long.parseLong(split[2]);
                VideoPlayInfoHolder videoPlayInfoHolder = new VideoPlayInfoHolder();
                videoPlayInfoHolder.currentPositionMills = parseLong;
                videoPlayInfoHolder.currentPositionSec = Math.round((parseLong * 1.0d) / 1000.0d);
                long j3 = photoInfo.videodata.videoTime;
                videoPlayInfoHolder.totalDurationMills = j3;
                videoPlayInfoHolder.totalDurationSec = Math.round((j3 * 1.0d) / 1000.0d);
                AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(str, videoPlayInfoHolder);
            }
        } catch (Exception e16) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzonePictureViewer", 2, "updateLocalVideoProgress " + e16);
            }
        }
    }

    public static boolean p(PhotoInfo photoInfo) {
        return (photoInfo == null || TextUtils.isEmpty(photoInfo.lloc) || TextUtils.isEmpty(photoInfo.albumId)) ? false : true;
    }

    public void N0(boolean z16, Handler handler) {
        ArrayList<String> arrayList;
        String str;
        String str2;
        String str3;
        PhotoParam photoParam = this.f49877g;
        if (photoParam == null) {
            return;
        }
        long j3 = photoParam.subid;
        String str4 = photoParam.ugcKey;
        String str5 = photoParam.cell_id;
        String str6 = photoParam.cell_subId;
        if (photoParam.appid == 4) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            PhotoInfo b16 = b();
            if (b16 != null) {
                if (!TextUtils.isEmpty(b16.bigUrl)) {
                    str3 = b16.bigUrl;
                } else {
                    str3 = b16.currentUrl;
                }
                if (z16) {
                    arrayList2.add(str3);
                }
                if (!W()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f49877g.ownerUin);
                    sb5.append("_");
                    PhotoParam photoParam2 = this.f49877g;
                    sb5.append(photoParam2.mFromRecent ? 4 : photoParam2.appid);
                    sb5.append("_");
                    sb5.append(this.f49877g.albumid);
                    sb5.append("_");
                    sb5.append(b16.lloc);
                    str4 = sb5.toString();
                }
            }
            arrayList = arrayList2;
            str = "";
            str2 = str;
        } else {
            arrayList = null;
            str = str5;
            str2 = str6;
        }
        d(str4);
        if (z16) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzonePictureViewer", 2, "ugckey=" + str4 + ",owner=" + this.f49877g.ownerUin + ",appid=" + this.f49877g.appid + ",subid=" + j3 + ",cellid=" + str + ",sid=" + str2);
            }
            PictureManager.getInstance().getSender().addFavor(handler, this.f49877g.ownerUin, r4.appid, j3, str, str2, str4, null, arrayList);
            return;
        }
        PictureManager.getInstance().getSender().delFavor(handler, this.f49877g.ownerUin, str4, r1.appid, j3);
    }

    public boolean i(int i3) {
        PhotoParam photoParam;
        if (i3 != 0 && (photoParam = this.f49877g) != null && !this.f49887q && photoParam.canAddFavor && photoParam.appid != 7035) {
            return true;
        }
        if (!QZLog.isDevelopLevel()) {
            return false;
        }
        QZLog.d("QzonePictureViewer", 4, "photoParam=" + this.f49877g + ",fromLocal=" + this.f49887q);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        if (r14 != 75) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v0(ArrayList<s_picdata> arrayList, int i3, boolean z16, int i16, NS_MOBILE_QUN.Album album) {
        int i17;
        int i18;
        int i19;
        if (arrayList != null) {
            arrayList.size();
        }
        if (z16) {
            PhotoInfo[] photoInfoArr = this.f49872b;
            this.f49872b = new PhotoInfo[this.f49874d];
            if (photoInfoArr != null) {
                int length = photoInfoArr.length;
                for (int i26 = 0; i26 < length; i26++) {
                    int i27 = this.f49885o;
                    if (i26 + i27 >= 0 && i26 + i27 < this.f49874d) {
                        this.f49872b[i27 + i26] = photoInfoArr[i26];
                    }
                }
            }
        }
        int size = arrayList != null ? arrayList.size() : 0;
        if (i16 != 4) {
            if (i16 == 5) {
                this.f49880j = (i3 - size) + 1;
            } else if (i16 == 6) {
                this.f49881k = (i3 + size) - 1;
            }
            if (this.f49880j < 0) {
                this.f49880j = 0;
            }
            i17 = this.f49881k;
            i18 = this.f49874d;
            if (i17 > i18 - 1) {
                this.f49881k = i18 - 1;
            }
            if (i16 != 6) {
                i3 = this.f49880j;
            }
            for (i19 = 0; i19 < size; i19++) {
                int i28 = i3 + i19;
                try {
                    if (i28 >= this.f49874d) {
                        return;
                    }
                    PhotoInfo[] photoInfoArr2 = this.f49872b;
                    if (photoInfoArr2[i28] == null) {
                        photoInfoArr2[i28] = new PhotoInfo();
                    }
                    PhotoInfo photoInfo = this.f49872b[i28];
                    s_picdata s_picdataVar = arrayList.get(i19);
                    photoInfo.albumId = s_picdataVar.albumid;
                    PictureViewerFactory.f0(photoInfo, s_picdataVar, 1);
                    if (album != null) {
                        if (!TextUtils.isEmpty(album.albumid) && TextUtils.isEmpty(photoInfo.albumId)) {
                            photoInfo.albumId = album.albumid;
                        }
                        photoInfo.albumName = album.name;
                    }
                    if (!TextUtils.isEmpty(photoInfo.orgUrl) && photoInfo.hasLocalOrgFile == null) {
                        photoInfo.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null);
                    }
                    PhotoParam photoParam = this.f49877g;
                    if (photoParam.appid == 311 && size == 1) {
                        this.f49872b[i28].hasPraise = photoParam.isLike;
                    }
                    if (s_picdataVar.photourl.containsKey(-1)) {
                        this.f49872b[i28].bigUrl = s_picdataVar.photourl.get(-1).url;
                    }
                    if (s_picdataVar.photourl.containsKey(1)) {
                        this.f49872b[i28].bigUrl = s_picdataVar.photourl.get(1).url;
                    }
                    if (s_picdataVar.photourl.containsKey(0)) {
                        this.f49872b[i28].orgUrl = s_picdataVar.photourl.get(0).url;
                    }
                    photoInfo.shareAlbumRight = 1;
                    photoInfo.shareSpaceRight = 1;
                    s_pic_host s_pic_hostVar = s_picdataVar.pic_host_nick;
                    photoInfo.uploadOwner = s_pic_hostVar.nick;
                    photoInfo.uploaduin = s_pic_hostVar.uin;
                } catch (ArrayIndexOutOfBoundsException e16) {
                    QZLog.i("[PhotoAlbum]BasePicureViewController", 1, e16.toString() + "newAlbumCount=" + z16 + " mPhotoCount=" + this.f49874d + " mType=" + i16);
                    return;
                }
            }
        }
        if (this.f49882l) {
            this.f49880j = 0;
            this.f49881k = size - 1;
        } else if (this.f49883m) {
            int i29 = this.f49874d;
            this.f49881k = i29 - 1;
            this.f49880j = i29 - size;
        } else {
            int i36 = i3 - ((size - 1) / 2);
            this.f49880j = i36;
            this.f49881k = (i36 + size) - 1;
        }
        if (this.f49880j < 0) {
        }
        i17 = this.f49881k;
        i18 = this.f49874d;
        if (i17 > i18 - 1) {
        }
        if (i16 != 6) {
        }
        while (i19 < size) {
        }
    }

    /* loaded from: classes39.dex */
    class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneFavoriteService.d f49897a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f49898b;

        a(QzoneFavoriteService.d dVar, String str) {
            this.f49897a = dVar;
            this.f49898b = str;
        }

        @Override // g5.a.b
        public void onResult(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                String string = bundle.getString("rsp_fav_id");
                if (!TextUtils.isEmpty(string)) {
                    QzoneFavoriteService.d dVar = this.f49897a;
                    if (dVar != null) {
                        dVar.a(string, true);
                    }
                    BasePicureViewController.this.F.put(this.f49898b, Boolean.TRUE);
                    return;
                }
            }
            QzoneFavoriteService.d dVar2 = this.f49897a;
            if (dVar2 != null) {
                dVar2.a(null, false);
            }
            BasePicureViewController.this.F.put(this.f49898b, Boolean.FALSE);
        }
    }

    /* loaded from: classes39.dex */
    class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f49900a;

        b(String str) {
            this.f49900a = str;
        }

        @Override // g5.a.b
        public void onResult(boolean z16, Bundle bundle) {
            if (z16 && bundle != null && !TextUtils.isEmpty(bundle.getString("rsp_fav_id"))) {
                BasePicureViewController.this.F.put(this.f49900a, Boolean.TRUE);
            }
            BasePicureViewController.this.F.put(this.f49900a, Boolean.FALSE);
        }
    }

    public static boolean y0(int i3) {
        return (i3 == 0 && QZoneConfigHelper.G()) || i3 == 1 || i3 == 2;
    }

    public void u(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        photoInfo.commentCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        if (r12 != 75) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u0(ArrayList<Photo> arrayList, int i3, boolean z16, int i16, Album album) {
        int i17;
        int i18;
        if (arrayList != null && arrayList.size() != 0) {
            this.f49875e = arrayList.get(arrayList.size() - 1);
        }
        if (z16) {
            try {
                PhotoInfo[] photoInfoArr = this.f49872b;
                this.f49872b = new PhotoInfo[this.f49874d];
                if (photoInfoArr != null) {
                    int length = photoInfoArr.length;
                    for (int i19 = 0; i19 < length; i19++) {
                        int i26 = this.f49885o;
                        if (i19 + i26 >= 0 && i19 + i26 < this.f49874d) {
                            this.f49872b[i26 + i19] = photoInfoArr[i19];
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        int size = arrayList != null ? arrayList.size() : 0;
        if (i16 != 4) {
            if (i16 == 5) {
                this.f49880j = (i3 - size) + 1;
            } else if (i16 == 6) {
                this.f49881k = (i3 + size) - 1;
            }
            if (this.f49880j < 0) {
                this.f49880j = 0;
            }
            i17 = this.f49881k;
            i18 = this.f49874d;
            if (i17 > i18 - 1) {
                this.f49881k = i18 - 1;
            }
            if (i16 != 6) {
                i3 = this.f49880j;
            }
            for (int i27 = 0; i27 < size; i27++) {
                int i28 = i3 + i27;
                try {
                    if (i28 >= this.f49874d) {
                        return;
                    }
                    PhotoInfo[] photoInfoArr2 = this.f49872b;
                    if (photoInfoArr2[i28] == null) {
                        photoInfoArr2[i28] = new PhotoInfo();
                    }
                    f1(album, size, this.f49872b[i28], arrayList.get(i27), this.f49877g);
                } catch (ArrayIndexOutOfBoundsException e17) {
                    QZLog.i("[PhotoAlbum]BasePicureViewController", 1, e17.toString() + "newAlbumCount=" + z16 + " mPhotoCount=" + this.f49874d + " mType=" + i16);
                    return;
                }
            }
        }
        if (this.f49882l) {
            this.f49880j = 0;
            this.f49881k = size - 1;
        } else if (this.f49883m) {
            int i29 = this.f49874d;
            this.f49881k = i29 - 1;
            this.f49880j = i29 - size;
        } else {
            int i36 = i3 - ((size - 1) / 2);
            this.f49880j = i36;
            this.f49881k = (i36 + size) - 1;
        }
        if (this.f49880j < 0) {
        }
        i17 = this.f49881k;
        i18 = this.f49874d;
        if (i17 > i18 - 1) {
        }
        if (i16 != 6) {
        }
        while (i27 < size) {
        }
    }

    public void w(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        if (z0(photoInfo)) {
            h1();
            d1(photoInfo);
        } else {
            boolean z16 = photoInfo.hasPraise;
            if (!z16) {
                photoInfo.praiseCount++;
            } else {
                photoInfo.praiseCount--;
            }
            photoInfo.hasPraise = !z16;
        }
        PhotoParam photoParam = this.f49877g;
        if (photoParam.appid == 311 && photoInfo.hasPraise && !photoParam.isLike) {
            photoParam.isLike = true;
            photoParam.likeNum++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void B(PhotoInfo photoInfo, Photo photo) {
        s_outshare s_outshareVar;
        if (photoInfo == null || photo == null || (s_outshareVar = photo.share_info) == null) {
            return;
        }
        photoInfo.shareWeixinUrl = s_outshareVar.weixin_url;
        photoInfo.shareQqUrl = s_outshareVar.qq_url;
        photoInfo.shareTitle = s_outshareVar.title;
        photoInfo.shareSummary = s_outshareVar.summary;
        photoInfo.sharePhotoUrl = A(s_outshareVar.photourl);
        s_outshare s_outshareVar2 = photo.share_info;
        photoInfo.shareSpaceRight = s_outshareVar2.space_right;
        photoInfo.shareAlbumRight = s_outshareVar2.album_right;
        photoInfo.shareArkInfo = ShareArkInfo.convertFromArkShare(s_outshareVar2.ark_sharedata);
    }

    public void x(Handler handler, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options, int i3, PhotoInfo photoInfo, boolean z16) {
        String a16;
        if (photoInfo == null) {
            return;
        }
        if (z16) {
            a16 = aj.b(photoInfo);
        } else {
            a16 = aj.a(photoInfo);
        }
        if (photoInfo.photoType == 2 && (i3 == 1000065 || i3 == 1000067 || i3 == 1000069)) {
            a16 = BasePictureViewer.V3(photoInfo);
        }
        QLog.d("QzonePhotoUtil", 1, "downloadImage, shouldDownloadOrigin: " + z16 + ", url: " + a16);
        if (ImageLoader.getInstance().loadImage(a16, imageLoadListener, options) != null) {
            QZLog.d("[PhotoAlbum]BasePicureViewController", 1, "orgImg != null  url:", a16);
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(i3);
            handler.sendMessage(obtain);
            return;
        }
        QLog.d("[PhotoAlbum]BasePicureViewController", 1, "get org_img is null");
    }

    public void y(Handler handler, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options, int i3, PhotoInfo photoInfo) {
        x(handler, imageLoadListener, options, i3, photoInfo, true);
    }

    public void E0(Handler handler) {
    }

    protected void d1(PhotoInfo photoInfo) {
    }

    protected void h1() {
    }

    public void q() {
    }

    public void C0(QZoneResult qZoneResult, int i3) {
    }

    public void O0(FaceData faceData, int i3, int i16) {
    }

    public void r(String str, ArrayList<String> arrayList, String str2, boolean z16, Handler handler, String str3, String str4, String str5) {
    }

    public void z(Handler handler, String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, String str2) {
    }
}
