package com.qzone.album.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.BaseAdapter;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.album.business.photolist.adapter.ac;
import com.qzone.album.business.photolist.adapter.s;
import com.qzone.album.business.photolist.adapter.t;
import com.qzone.album.business.photolist.adapter.z;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PoiInfo;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.al;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.theme.SkinnableBitmapDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAlbumUtil {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageLoader.ImageLoadListener f44352d;

        a(ImageLoader.ImageLoadListener imageLoadListener) {
            this.f44352d = imageLoadListener;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            ImageLoader.ImageLoadListener imageLoadListener = this.f44352d;
            if (imageLoadListener != null) {
                imageLoadListener.onImageLoaded(str, drawable, options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d extends ImageProcessor {

        /* renamed from: a, reason: collision with root package name */
        private SpecifiedSizeCropByPivotProcessor f44353a;

        /* renamed from: b, reason: collision with root package name */
        private RoundCornerProcessor f44354b = new RoundCornerProcessor(ar.e(4.0f));

        /* renamed from: c, reason: collision with root package name */
        private ScaleProcessor f44355c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f44356d;

        d(int i3) {
            this.f44356d = i3;
            this.f44353a = new SpecifiedSizeCropByPivotProcessor(i3, i3, 0.5f, 0.5f);
            this.f44355c = new ScaleProcessor(i3, i3);
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return this.f44355c.process(this.f44354b.process(this.f44353a.process(drawable)));
        }
    }

    public static boolean A(int i3) {
        if (i3 != 4 && i3 != 5) {
            return false;
        }
        return true;
    }

    public static boolean B(int i3) {
        if (i3 != 5 && i3 != 6) {
            return false;
        }
        return true;
    }

    public static boolean C(int i3) {
        if (i3 != 4 && i3 != 6) {
            return false;
        }
        return true;
    }

    public static void D(Context context, String str, String str2, String str3, boolean z16) {
        String replace = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHARE_ALBUM_INVITE_TO_FEEDS_URL, QzoneConfig.DEFAULT_SHARE_ALBUM_INVITE_TO_FEEDS_URL).replace("{albumUin}", str).replace("{albumid}", str2).replace("{loginUin}", str3);
        if (z16) {
            replace = replace + "&share_platform=wx";
        }
        yo.d.b(context, new yo.g(replace));
    }

    public static void E(String str, int i3, ImageLoader.ImageLoadListener imageLoadListener) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.imageConfig = Bitmap.Config.ARGB_4444;
        if (str != null && str.contains(".9.png")) {
            obtain.extraProcessor = new z4.c(i3, 0, true);
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, imageLoadListener, obtain);
        if (loadImage == null || imageLoadListener == null) {
            return;
        }
        imageLoadListener.onImageLoaded(str, loadImage, obtain);
    }

    public static PoiInfo H(LbsDataV2.PoiInfo poiInfo) {
        PoiInfo poiInfo2 = new PoiInfo();
        poiInfo2.poiId = poiInfo.poiId;
        if (poiInfo.gpsInfo != null) {
            poiInfo2.poiX = String.valueOf(r1.lon / 1000000.0f);
            poiInfo2.poiY = String.valueOf(poiInfo.gpsInfo.lat / 1000000.0f);
        }
        poiInfo2.poiName = poiInfo.poiName;
        poiInfo2.poiAddress = poiInfo.address;
        poiInfo2.poiType = poiInfo.poiType;
        return poiInfo2;
    }

    public static void I(String str) {
        LocalMultiProcConfig.putString("qzone_album_added_shortcut_with_redpot", LocalMultiProcConfig.getString("qzone_album_added_shortcut_with_redpot", "").replaceAll(str + ";", ""));
    }

    public static SpannableStringBuilder K(int i3, int i16, int i17) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (i3 > 0) {
            spannableStringBuilder = b(b(spannableStringBuilder, "" + i3, new AbsoluteSizeSpan(18, true)), "/", new AbsoluteSizeSpan(18, true));
        }
        if (i16 > 0) {
            spannableStringBuilder = b(b(spannableStringBuilder, "" + i16, new AbsoluteSizeSpan(18, true)), "/", new AbsoluteSizeSpan(18, true));
        }
        if (i17 <= 0) {
            return spannableStringBuilder;
        }
        return b(spannableStringBuilder, "" + i17, new AbsoluteSizeSpan(18, true));
    }

    public static void L(Context context, String str, String str2, String str3, long j3, boolean z16) {
        int i3;
        if (c() && d()) {
            if (z16) {
                a(str2);
                i3 = 3;
            } else {
                I(str2);
                i3 = 2;
            }
            p(context, i3, str, str2, str3, j3);
        }
    }

    public static void a(String str) {
        String string = LocalMultiProcConfig.getString("qzone_album_added_shortcut_with_redpot", "");
        if (string.contains(str)) {
            return;
        }
        LocalMultiProcConfig.putString("qzone_album_added_shortcut_with_redpot", string + str + ";");
    }

    public static boolean c() {
        return (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_QZONE_OPEN_ADD_SHORTCUT, 1) == 1) && !QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_QZONE_CREATE_SHORTCUT_BLACK_LIST, "Pixel 2 XL|").trim().toLowerCase().contains(DeviceInfoMonitor.getModel().trim().toLowerCase());
    }

    public static boolean d() {
        return !QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_QZONE_UPDATE_SHORTCUT_BLACK_LIST, "SM-G9550| vivo Z1| vivo X9s Plus| OPPO R6007| M4S| MX4| OPPO R11s| M15| MI 5C| OnePlus A5010| VIVO V1813BA| VIVO NEX A| VIVO V1801A0| GIONEE GN8002S| VIVO X9sPlus| X800+| SLA-TL10|").trim().toLowerCase().contains(DeviceInfoMonitor.getModel().trim().toLowerCase());
    }

    public static Calendar f(long j3) {
        com.qzone.proxy.feedcomponent.b.a("QZoneAlbumUtil", "convertBirthTimeToCalendar birthTime=" + j3);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(String.valueOf(j3)));
            com.qzone.proxy.feedcomponent.b.a("QZoneAlbumUtil", "get result ca.year=" + calendar.get(1) + "; month=" + calendar.get(2) + "; day=" + calendar.get(5));
            return calendar;
        } catch (ParseException e16) {
            e16.printStackTrace();
            return calendar;
        }
    }

    public static int g(long j3) {
        String valueOf = String.valueOf(j3);
        if (valueOf == null || valueOf.length() != 8) {
            return 0;
        }
        return Integer.parseInt(valueOf.substring(6, 8));
    }

    public static int h(long j3) {
        String valueOf = String.valueOf(j3);
        if (valueOf == null || valueOf.length() != 8) {
            return 0;
        }
        return Integer.parseInt(valueOf.substring(4, 6));
    }

    public static String i(int i3, int i16, int i17) {
        String str;
        String str2 = i3 + "";
        if (i16 < 10) {
            str = str2 + "0" + i16;
        } else {
            str = str2 + "" + i16;
        }
        if (i17 < 10) {
            return str + "0" + i17;
        }
        return str + "" + i17;
    }

    public static String j(long j3) {
        String valueOf = String.valueOf(j3);
        if (valueOf != null && valueOf.length() == 8) {
            return valueOf.substring(0, 4) + "." + valueOf.substring(4, 6) + "." + valueOf.substring(6, 8);
        }
        com.qzone.proxy.feedcomponent.b.i("QZoneAlbumUtil", "wrong birtime params birthTime=" + j3);
        return "";
    }

    public static int k(long j3) {
        String valueOf = String.valueOf(j3);
        if (valueOf == null || valueOf.length() != 8) {
            return 0;
        }
        return Integer.parseInt(valueOf.substring(0, 4));
    }

    public static long l(long j3) {
        long j16;
        com.qzone.proxy.feedcomponent.b.a("QZoneAlbumUtil", "convertLoveTimeToSeconds time=" + j3);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(String.valueOf(j3)));
            j16 = calendar.getTimeInMillis();
        } catch (ParseException e16) {
            e16.printStackTrace();
            j16 = 0;
        }
        if (j16 < 0) {
            return 0L;
        }
        return j16;
    }

    public static long m(long j3) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(DateUtil.DATE_FORMAT_14).parse(String.valueOf(j3)));
            return calendar.getTimeInMillis();
        } catch (ParseException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static String n(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(1) + "/" + (calendar.get(2) + 1) + "/" + calendar.get(5);
    }

    public static String o(long j3) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(String.valueOf(j3)));
            return String.valueOf(calendar.getTimeInMillis());
        } catch (ParseException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static long q(long j3) {
        Calendar.getInstance().setTimeInMillis(j3);
        return (((j3 - (((r0.get(11) * 60) * 60) * 1000)) - ((r0.get(12) * 60) * 1000)) - (r0.get(13) * 1000)) - 1000;
    }

    public static int r(int i3) {
        if (i3 == 8) {
            return 5;
        }
        if (i3 == 9) {
            return 6;
        }
        if (i3 == 11) {
            return 8;
        }
        if (i3 == 12) {
            return 9;
        }
        return 1;
    }

    public static int s(int i3) {
        if (i3 == 5) {
            return 5;
        }
        if (i3 == 6) {
            return 6;
        }
        if (i3 == 8) {
            return 8;
        }
        if (i3 == 9) {
            return 9;
        }
        return 0;
    }

    public static int t(int i3) {
        if (i3 == 5) {
            return 8;
        }
        if (i3 == 6) {
            return 9;
        }
        if (i3 == 8) {
            return 11;
        }
        if (i3 == 9) {
            return 12;
        }
        return 1;
    }

    public static String x(long j3, String str) {
        x6.a g16 = z5.a.f().g(j3);
        String str2 = g16 != null ? g16.nickName : null;
        if (TextUtils.isEmpty(str2)) {
            str2 = s8.f.f().g(Long.toString(j3));
            if (TextUtils.isEmpty(str2)) {
                return TextUtils.isEmpty(str) ? Long.toString(j3) : str;
            }
        }
        return str2;
    }

    public static void y(Context context, AlbumCacheData albumCacheData) {
        com.qzone.album.env.common.a.m().P(326, 14, "17", true, null);
        if (albumCacheData != null) {
            D(context, String.valueOf(albumCacheData.ownerUin), albumCacheData.albumid, String.valueOf(com.qzone.album.env.common.a.m().s()), false);
        }
    }

    public static boolean z(String str) {
        String string = LocalMultiProcConfig.getString("qzone_album_added_shortcut_with_redpot", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return string.contains(str);
    }

    public static void F(String str, ImageLoader.ImageLoadListener imageLoadListener) {
        E(str, 0, imageLoadListener);
    }

    public static boolean e(long j3, long j16) {
        try {
            String o16 = o(j16);
            if (TextUtils.isEmpty(o16)) {
                return false;
            }
            return j3 > Long.parseLong(o16);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static BaseAdapter u(int i3, int i16, x4.a aVar, View.OnClickListener onClickListener, boolean z16, boolean z17) {
        QZLog.d("QZoneAlbumUtil", 1, "getPhotoListAdapterByAlbumTheme... mAlbumType:", Integer.valueOf(i3), " mShowType:", Integer.valueOf(i16));
        if (i3 == 10) {
            return new z(aVar, null, z16);
        }
        if (i16 == 0) {
            switch (i3) {
                case 8:
                    return new t(aVar, onClickListener);
                case 9:
                    return new ac(aVar, onClickListener);
                case 10:
                default:
                    return new s(aVar, onClickListener);
                case 11:
                    return new com.qzone.album.business.photolist.adapter.q(aVar, onClickListener);
                case 12:
                    return new com.qzone.album.business.photolist.adapter.r(aVar, onClickListener);
            }
        }
        if (i16 == 1) {
            switch (i3) {
                case 8:
                    return new com.qzone.album.business.photolist.adapter.g(aVar, onClickListener);
                case 9:
                    return new com.qzone.album.business.photolist.adapter.n(aVar, onClickListener);
                case 10:
                default:
                    if (!z17 && !com.qzone.album.util.b.f(aVar.g())) {
                        return new com.qzone.album.business.photolist.adapter.f(aVar, onClickListener);
                    }
                    return new com.qzone.album.business.photolist.adapter.m(aVar, onClickListener);
                case 11:
                    return new com.qzone.album.business.photolist.adapter.d(aVar, onClickListener);
                case 12:
                    return new com.qzone.album.business.photolist.adapter.e(aVar, onClickListener);
            }
        }
        return new s(aVar, onClickListener);
    }

    private static SpannableStringBuilder b(SpannableStringBuilder spannableStringBuilder, String str, AbsoluteSizeSpan absoluteSizeSpan) {
        if (spannableStringBuilder == null) {
            return null;
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(absoluteSizeSpan, length, str.length() + length, 33);
        return spannableStringBuilder;
    }

    public static void G(String str, boolean z16, ImageLoader.ImageLoadListener imageLoadListener) {
        if (!z16) {
            E(str, 0, imageLoadListener);
            return;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.imageConfig = Bitmap.Config.ARGB_4444;
        if (str != null && str.contains(".9.png")) {
            obtain.extraProcessor = new z4.c(u4.a.z().C() / 240.0f);
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, new a(imageLoadListener), obtain);
        if (loadImage == null || imageLoadListener == null) {
            return;
        }
        imageLoadListener.onImageLoaded(str, loadImage, obtain);
    }

    public static void p(Context context, int i3, String str, String str2, String str3, long j3) {
        int a16 = (int) al.a(context, 50.0f);
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.extraProcessor = new d(a16);
        ImageLoader.getInstance().loadImageAsync(str, new e(context, i3, str2, str3, j3), obtain);
    }

    public static Comparator<com.qzone.component.cache.database.a> w(int i3) {
        if (i3 == 6) {
            return new b();
        }
        if (i3 == 5) {
            return new c();
        }
        return null;
    }

    public static void J(final View view) {
        if (view == null) {
            return;
        }
        view.setClickable(false);
        view.postDelayed(new Runnable() { // from class: com.qzone.album.util.QZoneAlbumUtil.5
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 != null) {
                    view2.setClickable(true);
                }
            }
        }, 500L);
    }

    public static BaseAdapter v(int i3, x4.a aVar, boolean z16) {
        switch (i3) {
            case 8:
                return new t(aVar, null);
            case 9:
                return new ac(aVar, null);
            case 10:
                return new z(aVar, null, z16);
            case 11:
                return new com.qzone.album.business.photolist.adapter.q(aVar, null);
            case 12:
                return new com.qzone.album.business.photolist.adapter.r(aVar, null);
            default:
                return new s(aVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements Comparator<com.qzone.component.cache.database.a> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.qzone.component.cache.database.a aVar, com.qzone.component.cache.database.a aVar2) {
            if (aVar == null || aVar2 == null) {
                return 0;
            }
            PhotoCacheData photoCacheData = (PhotoCacheData) aVar;
            long j3 = photoCacheData.shoottime;
            PhotoCacheData photoCacheData2 = (PhotoCacheData) aVar2;
            long j16 = photoCacheData2.shoottime;
            if (j3 < j16) {
                return -1;
            }
            if (j3 == j16) {
                long j17 = photoCacheData.uploadtime;
                long j18 = photoCacheData2.uploadtime;
                if (j17 < j18) {
                    return -1;
                }
                if (j17 == j18) {
                    return 0;
                }
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements Comparator<com.qzone.component.cache.database.a> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.qzone.component.cache.database.a aVar, com.qzone.component.cache.database.a aVar2) {
            if (aVar == null || aVar2 == null) {
                return 0;
            }
            PhotoCacheData photoCacheData = (PhotoCacheData) aVar;
            long j3 = photoCacheData.shoottime;
            PhotoCacheData photoCacheData2 = (PhotoCacheData) aVar2;
            long j16 = photoCacheData2.shoottime;
            if (j3 > j16) {
                return -1;
            }
            if (j3 == j16) {
                long j17 = photoCacheData.uploadtime;
                long j18 = photoCacheData2.uploadtime;
                if (j17 < j18) {
                    return -1;
                }
                if (j17 == j18) {
                    return 0;
                }
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f44357d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f44358e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f44359f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f44360h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f44361i;

        e(Context context, int i3, String str, String str2, long j3) {
            this.f44357d = context;
            this.f44358e = i3;
            this.f44359f = str;
            this.f44360h = str2;
            this.f44361i = j3;
        }

        private void a(Intent intent, Bitmap bitmap) {
            intent.putExtra("UploadPhoto.key_album_cover", bitmap);
            intent.addFlags(268435456);
            this.f44357d.startActivity(intent);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Drawable drawable2;
            Intent qZoneVideoDownloadActivityIntent = QZoneHelper.getQZoneVideoDownloadActivityIntent(this.f44357d);
            qZoneVideoDownloadActivityIntent.putExtra(QZoneHelper.QZONE_ALBUM_SHORTCUT_ACTION_TYPE, this.f44358e);
            qZoneVideoDownloadActivityIntent.putExtra("UploadPhoto.key_album_id", this.f44359f);
            qZoneVideoDownloadActivityIntent.putExtra("UploadPhoto.key_album_name", this.f44360h);
            qZoneVideoDownloadActivityIntent.putExtra(QZoneHelper.Constants.KEY_ALBUM_OWNER_UID, this.f44361i);
            Bitmap f16 = ar.f(drawable);
            QZLog.i("QZoneAlbumUtil", "doAlbumShortAction. actionType = " + this.f44358e + ", id=" + this.f44359f + ", albumname=" + this.f44360h);
            if (this.f44358e == 3) {
                if ("SM-G9500|".toLowerCase().contains(DeviceInfoMonitor.getModel().trim().toLowerCase())) {
                    drawable2 = this.f44357d.getResources().getDrawable(R.drawable.ar6);
                } else {
                    drawable2 = this.f44357d.getResources().getDrawable(R.drawable.ar5);
                }
                if (drawable2 instanceof SkinnableBitmapDrawable) {
                    f16 = com.tencent.biz.qqstory.utils.b.j(f16, ((SkinnableBitmapDrawable) drawable2).getBitmap());
                } else {
                    f16 = com.tencent.biz.qqstory.utils.b.j(f16, ((BitmapDrawable) drawable2).getBitmap());
                }
            }
            try {
                a(qZoneVideoDownloadActivityIntent, f16);
            } catch (Throwable th5) {
                th5.printStackTrace();
                QZLog.e("QZoneAlbumUtil", "doAlbumShortAction. startActivity  error! iconBmp.getByteCount()= " + f16.getByteCount());
                try {
                    byte[] d16 = com.qzone.util.image.c.d(f16, 100, false);
                    f16 = BitmapFactory.decodeByteArray(d16, 0, d16.length);
                    a(qZoneVideoDownloadActivityIntent, f16);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                    QZLog.e("QZoneAlbumUtil", "doAlbumShortAction. startActivity  error again! give up! iconBmp.getByteCount()= " + f16.getByteCount());
                    ToastUtil.o(R.string.f170347o5, 4);
                }
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static abstract class f implements ImageLoader.ImageLoadListener {
        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
