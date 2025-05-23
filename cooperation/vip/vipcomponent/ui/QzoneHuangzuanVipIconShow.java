package cooperation.vip.vipcomponent.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import cooperation.qzone.statistic.Singleton;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import cooperation.vip.vipcomponent.util.c;
import cooperation.vip.vipcomponent.util.e;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneHuangzuanVipIconShow {
    public static final int HIGHEST_LEVEL = 8;
    public static final int LOWEST_LEVEL = 1;
    private static final int RES_BG = 1;
    private static final int RES_CUSTOM_DIAMOND = 10;
    private static final int RES_KINGBG = 9;
    private static final int RES_LEVEL = 2;
    private static final int RES_LV9_GUAN = 7;
    private static final int RES_LV9_WINDS = 8;
    private static final int RES_NORMAL_ANNUAL = 5;
    private static final int RES_PERSONALIZED_ANNUAL = 6;
    private static final int RES_PERSONALIZED_HEAD = 0;
    private static final int RES_PERSONALIZED_LEVEL = 4;
    private static final int RES_RIBBON_LEVEL = 3;
    private Context context;
    private LruCache<String, Drawable.ConstantState> layerCache;
    public static int ICON_ANNUALVIP_WIDTH = (int) (ViewUtils.getDensity() * 27.0f);
    public static int ICON_DEFAULT_SIZE = cooperation.vip.vipcomponent.util.a.f391397b;
    public static int PERSONALIZED_ICON_LV_WIDTH = (int) (ViewUtils.getDensity() * 26.0f);
    public static int PERSONALIZED_ICON_LV_HEIGHT = (int) (ViewUtils.getDensity() * 9.0f);
    public static int PERSONALIZED_ICON_HEAD_HEIGHT = (int) (ViewUtils.getDensity() * 23.0f);
    public static int PERSONALIZED_ICON_HEAD_WIDTH = (int) (ViewUtils.getDensity() * 11.0f);
    public static int PERSONALIZED_ICON_YEAR_WIDTH = (int) (ViewUtils.getDensity() * 40.0f);
    public static int PERSONALIZED_ICON_YEAR_HEIGHT = (int) (ViewUtils.getDensity() * 24.0f);
    public static int PERSONALIZED_ICON_LV_MARGIN_TOP = (int) (ViewUtils.getDensity() * 21.0f);
    public static int RIBBON_ICON_BG_MARGIN_LEFT = (int) (ViewUtils.getDensity() * 1.0f);
    public static int ANUAL_ICON_MARGIN_LEFT = (int) (ViewUtils.getDensity() * 2.0f);
    public static int ANUAL_ICON_MARGIN_LEFT_IF_LV9 = (int) (ViewUtils.getDensity() * 5.0f);
    public static int PERSONALIZED_ICON_AVATAR_TOP = (int) (ViewUtils.getDensity() * 1.0f);
    public static int LV9_GUAN_ICON_MARGIN_LEFT = (int) (ViewUtils.getDensity() * 1.0f);
    public static int LV9_GUAN_ICON_MARGIN_TOP = (int) (ViewUtils.getDensity() * (-3.0f));
    public static int LV9_GUAN_ICON_WIDTH = (int) (ViewUtils.getDensity() * 22.0f);
    public static int LV9_GUAN_ICON_HEIGHT = (int) (ViewUtils.getDensity() * 10.5d);
    public static int LV9_WINDS_MARGIN_TOP = (int) (ViewUtils.getDensity() * 4.5d);
    public static int LV9_WINDS_MARGIN_LEFT = (int) (ViewUtils.getDensity() * (-8.0f));
    public static int LV9_WINDS_HEIGHT = (int) (ViewUtils.getDensity() * 9.5d);
    public static int LV9_WINDS_WIDTH = (int) (ViewUtils.getDensity() * 40.0f);
    public static int PERSONALIZED_ICON_ANUAL_LEFT = (int) (ViewUtils.getDensity() * 10.0f);
    public static final int RIBBON_ICON_LEVEL_MARGIN_TOP = (int) (ViewUtils.getDensity() * 6.0f);
    public static int ICON_ANNUALVIP_HEIGHT = (int) (ViewUtils.getDensity() * 12.0f);
    public static int ICON_ADJUST_ANNUALVIP_MARGIN_TOP = (int) (ViewUtils.getDensity() * 9.0f);
    private static final Singleton<QzoneHuangzuanVipIconShow, Context> sSingleton = new a();
    private int[] mNormalGrayVipIdListInAvatar = {18, 19, 20, 21, 22, 23, 24, 25, 26};
    private int[] mAnunalGrayVipIdListInAvatar = {9, 10, 11, 12, 13, 14, 15, 16, 17};
    private int[] mNormalVipIdListInAvatar = {37, 38, 39, 40, 41, 42, 43, 44, 45, 46};
    private int[] mAnunalVipIdListInAvatar = {27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    private int[] mNormalVipIdListInRibbon = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106};
    private int[] mAnunalVipIdListInRibbon = {87, 88, 89, 90, 91, 92, 93, 94, 95, 96};

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends Singleton<QzoneHuangzuanVipIconShow, Context> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qzone.statistic.Singleton
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QzoneHuangzuanVipIconShow create(Context context) {
            return new QzoneHuangzuanVipIconShow(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VipResourcesListener f391370a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f391371b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m15.a f391372c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f391373d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f391374e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f391375f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f391376g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f391377h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f391378i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f391379j;

        b(VipResourcesListener vipResourcesListener, int i3, m15.a aVar, int i16, int i17, boolean z16, String str, int i18, boolean z17, int i19) {
            this.f391370a = vipResourcesListener;
            this.f391371b = i3;
            this.f391372c = aVar;
            this.f391373d = i16;
            this.f391374e = i17;
            this.f391375f = z16;
            this.f391376g = str;
            this.f391377h = i18;
            this.f391378i = z17;
            this.f391379j = i19;
        }

        @Override // cooperation.vip.vipcomponent.util.e
        public void onDownloaded(String str, int i3, String str2, Drawable drawable) {
            QzoneHuangzuanVipIconShow.this.handleDownloadSuccess(i3, drawable, this.f391371b, this.f391372c, this.f391373d);
            if (this.mCount <= 0) {
                QzoneHuangzuanVipIconShow.this.addToCache(this.f391372c, this.f391374e, this.f391371b, this.f391373d, this.f391375f, this.f391376g, this.f391377h, this.f391378i, this.f391379j);
                VipResourcesListener vipResourcesListener = this.f391370a;
                if (vipResourcesListener != null) {
                    vipResourcesListener.onLoaded(this.f391372c);
                }
            }
        }

        @Override // cooperation.vip.vipcomponent.util.e
        public void onFailed(String str, int i3, String str2) {
            VipResourcesListener vipResourcesListener = this.f391370a;
            if (vipResourcesListener != null) {
                vipResourcesListener.onFailed();
            }
        }
    }

    public QzoneHuangzuanVipIconShow(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
        this.layerCache = new LruCache<>(MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToCache(m15.a aVar, int i3, int i16, int i17, boolean z16, String str, int i18, boolean z17, int i19) {
        int i26;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append("_");
        sb5.append(i16);
        sb5.append("_");
        sb5.append(i17);
        sb5.append("_");
        sb5.append(z16);
        sb5.append("_");
        sb5.append(str);
        sb5.append("_");
        sb5.append(i18);
        sb5.append("_");
        if (z17) {
            i26 = 1;
        } else {
            i26 = 2;
        }
        sb5.append(i26);
        sb5.append("_");
        sb5.append(i19);
        String sb6 = sb5.toString();
        if (aVar != null) {
            this.layerCache.put(sb6, aVar.a());
        }
    }

    private static Drawable getBGForLuxuryVip(int i3, int i16, int i17, String str, e eVar, int i18) {
        if (!TextUtils.isEmpty(str) && i17 == 4) {
            return c.d(2, i16, eVar);
        }
        if (8 == i3) {
            if (i18 != 1) {
                return c.d(3, i16, eVar);
            }
            return c.d(2, i16, eVar);
        }
        return c.d(2, i16, eVar);
    }

    private static Drawable getBGForOthers(int i3, int i16, int i17, e eVar) {
        if (i17 == 6 || i17 == 7 || i17 == 8) {
            return null;
        }
        if (8 == i3) {
            return c.d(5, i16, eVar);
        }
        if (i3 == 0) {
            if (i17 == 4 || i17 == 6 || i17 != 5) {
                return null;
            }
            return c.d(6, i16, eVar);
        }
        return c.d(6, i16, eVar);
    }

    private static Drawable getBGForVip(int i3, int i16, int i17, String str, e eVar, int i18) {
        if (!TextUtils.isEmpty(str) && i17 == 4) {
            return c.d(1, i16, eVar);
        }
        if (8 == i3) {
            if (i18 != 1) {
                return c.d(4, i16, eVar);
            }
            return c.d(1, i16, eVar);
        }
        return c.d(1, i16, eVar);
    }

    private static Drawable getBackground(int i3, int i16, int i17, int i18, String str, e eVar, int i19) {
        if (i3 != 1) {
            if (i3 != 2) {
                return getBGForOthers(i16, i17, i18, eVar);
            }
            return getBGForLuxuryVip(i16, i17, i18, str, eVar, i19);
        }
        return getBGForVip(i16, i17, i18, str, eVar, i19);
    }

    private Drawable getDefaultDrawable(int i3, e eVar) {
        m15.a aVar = new m15.a();
        Drawable d16 = c.d(1, 1, eVar);
        d16.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i3), getRealSize(ICON_DEFAULT_SIZE, i3));
        aVar.f(d16);
        return aVar;
    }

    private boolean getDefaultDrawableFromUrl(int i3, boolean z16, int i16, int i17, String str, m15.a aVar, e eVar, boolean z17, boolean z18, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (!TextUtils.isEmpty(str)) {
            if (handlePersonalized(i3, i16, i17, str, aVar, eVar, z17, z18, drawable, drawable2, drawable3, drawable4)) {
                return true;
            }
            return false;
        }
        if (z16) {
            if (handleAnunalVip(i17, aVar, eVar, z17, z18, drawable, drawable2, drawable3, drawable4)) {
                return true;
            }
            return false;
        }
        if (drawable3 == null || drawable4 == null || ((z18 && drawable == null) || (z17 && drawable2 == null))) {
            return true;
        }
        return false;
    }

    private Drawable getFromCache(int i3, int i16, int i17, boolean z16, String str, int i18, boolean z17, int i19) {
        int i26;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append("_");
        sb5.append(i16);
        sb5.append("_");
        sb5.append(i17);
        sb5.append("_");
        sb5.append(z16);
        sb5.append("_");
        sb5.append(str);
        sb5.append("_");
        sb5.append(i18);
        sb5.append("_");
        if (z17) {
            i26 = 1;
        } else {
            i26 = 2;
        }
        sb5.append(i26);
        sb5.append("_");
        sb5.append(i19);
        Drawable.ConstantState constantState = this.layerCache.get(sb5.toString());
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return null;
    }

    public static QzoneHuangzuanVipIconShow getInstance() {
        return sSingleton.get(null);
    }

    private Drawable getLevelDrawable(int i3, int i16, boolean z16, int i17, boolean z17, e eVar) {
        if (i17 <= 0 || i17 > 10) {
            return null;
        }
        if (z17) {
            if (i17 >= 10) {
                return null;
            }
            if (z16 && i3 == 4) {
                return c.d(this.mAnunalGrayVipIdListInAvatar[i17 - 1], i16, eVar);
            }
            return c.d(this.mNormalGrayVipIdListInAvatar[i17 - 1], i16, eVar);
        }
        if (z16 && i3 == 7) {
            return c.d(this.mAnunalVipIdListInRibbon[i17 - 1], i16, eVar);
        }
        if (!z16 && i3 == 7) {
            return c.d(this.mNormalVipIdListInRibbon[i17 - 1], i16, eVar);
        }
        if (z16 && i3 == 4) {
            return c.d(this.mAnunalVipIdListInAvatar[i17 - 1], i16, eVar);
        }
        return c.d(this.mNormalVipIdListInAvatar[i17 - 1], i16, eVar);
    }

    private static Drawable getLv9Guan(int i3, int i16, int i17, int i18, e eVar) {
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                return null;
            }
            return c.d(125, i18, eVar);
        }
        return c.d(126, i18, eVar);
    }

    private static int getRealSize(int i3, int i16) {
        return (int) ((i16 / 100.0d) * i3);
    }

    private static Drawable getWindsDrawalbe(int i3, int i16, int i17, e eVar) {
        if (i16 != 9) {
            return null;
        }
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                return null;
            }
            return c.d(123, i17, eVar);
        }
        return c.d(124, i17, eVar);
    }

    private boolean handleAnunalVip(int i3, m15.a aVar, e eVar, boolean z16, boolean z17, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i16;
        Drawable d16 = c.d(7, 5, eVar);
        if (d16 != null) {
            if (z16 && drawable2 != null) {
                i16 = ANUAL_ICON_MARGIN_LEFT_IF_LV9;
            } else {
                i16 = 0;
            }
            d16.setBounds(getRealSize((ICON_DEFAULT_SIZE / 2) + ANUAL_ICON_MARGIN_LEFT + i16, i3), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, i3), getRealSize(ICON_ANNUALVIP_WIDTH + (ICON_DEFAULT_SIZE / 2) + ANUAL_ICON_MARGIN_LEFT + i16, i3), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, i3));
            aVar.e(d16);
        }
        if (drawable3 != null && drawable4 != null && d16 != null && ((!z17 || drawable != null) && (!z16 || drawable2 != null))) {
            return false;
        }
        cooperation.vip.vipcomponent.util.b.b("vipIconShow", "nameplateDrawable is null");
        return true;
    }

    private Drawable handleCustomDiamond(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, int i19, m15.a aVar, e eVar) {
        Drawable a16 = c.a(str, i16, 10, i3, z16, i17, eVar);
        if (a16 != null) {
            a16.setBounds(0, 0, getRealSize(a16.getIntrinsicWidth(), i18), getRealSize(a16.getIntrinsicHeight(), i18));
            aVar.h(a16);
            addToCache(aVar, i19, i18, i3, z17, str, i17, z16, i16);
            return aVar;
        }
        return getDefaultDrawable(i18, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadSuccess(int i3, Drawable drawable, int i16, m15.a aVar, int i17) {
        if (drawable == null) {
            return;
        }
        switch (i3) {
            case 0:
                drawable.setBounds(getRealSize(ICON_DEFAULT_SIZE - drawable.getIntrinsicWidth(), i16) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, i16), getRealSize(ICON_DEFAULT_SIZE + drawable.getIntrinsicWidth(), i16) / 2, getRealSize(drawable.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, i16));
                aVar.i(drawable);
                return;
            case 1:
                drawable.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i16), getRealSize(ICON_DEFAULT_SIZE, i16));
                aVar.f(drawable);
                return;
            case 2:
                drawable.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i16), getRealSize(ICON_DEFAULT_SIZE, i16));
                aVar.k(drawable);
                return;
            case 3:
                int i18 = RIBBON_ICON_LEVEL_MARGIN_TOP;
                drawable.setBounds(0, getRealSize(i18, i16), getRealSize(ICON_DEFAULT_SIZE, i16), getRealSize(ICON_DEFAULT_SIZE + i18, i16));
                aVar.k(drawable);
                return;
            case 4:
                drawable.setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, i16), getRealSize(PERSONALIZED_ICON_LV_WIDTH, i16), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, i16));
                aVar.k(drawable);
                return;
            case 5:
                int i19 = i17 == 9 ? ANUAL_ICON_MARGIN_LEFT_IF_LV9 : 0;
                drawable.setBounds(getRealSize((ICON_DEFAULT_SIZE / 2) + ANUAL_ICON_MARGIN_LEFT + i19, i16), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, i16), getRealSize(ICON_ANNUALVIP_WIDTH + (ICON_DEFAULT_SIZE / 2) + ANUAL_ICON_MARGIN_LEFT + i19, i16), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, i16));
                aVar.e(drawable);
                return;
            case 6:
                drawable.setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, i16), getRealSize(ICON_DEFAULT_SIZE - drawable.getIntrinsicHeight(), i16), getRealSize((ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT) + drawable.getIntrinsicWidth(), i16), getRealSize(ICON_DEFAULT_SIZE, i16));
                aVar.e(drawable);
                cooperation.vip.vipcomponent.util.b.a("@vipIcon", "left" + (ICON_DEFAULT_SIZE / 2) + " width = " + drawable.getIntrinsicWidth() + " defualt_width =" + ICON_DEFAULT_SIZE + " height = " + drawable.getIntrinsicHeight());
                return;
            case 7:
                drawable.setBounds(getRealSize(LV9_GUAN_ICON_MARGIN_LEFT, i16), getRealSize(LV9_GUAN_ICON_MARGIN_TOP, i16), getRealSize(LV9_GUAN_ICON_WIDTH + LV9_GUAN_ICON_MARGIN_LEFT, i16), getRealSize(LV9_GUAN_ICON_HEIGHT + LV9_GUAN_ICON_MARGIN_TOP, i16));
                aVar.i(drawable);
                return;
            case 8:
                drawable.setBounds(getRealSize(LV9_WINDS_MARGIN_LEFT, i16), getRealSize(LV9_WINDS_MARGIN_TOP, i16), getRealSize(LV9_WINDS_WIDTH + LV9_WINDS_MARGIN_LEFT, i16), getRealSize(LV9_WINDS_HEIGHT + LV9_WINDS_MARGIN_TOP, i16));
                aVar.l(drawable);
                return;
            case 9:
                drawable.setBounds(getRealSize((ICON_DEFAULT_SIZE - drawable.getIntrinsicWidth()) / 2, i16), getRealSize(ICON_DEFAULT_SIZE - drawable.getIntrinsicHeight(), i16), getRealSize((ICON_DEFAULT_SIZE + drawable.getIntrinsicWidth()) / 2, i16), getRealSize(ICON_DEFAULT_SIZE, i16));
                aVar.j(drawable);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("left=");
                sb5.append((ICON_DEFAULT_SIZE - drawable.getIntrinsicWidth()) / 2);
                sb5.append(" width = ");
                sb5.append(drawable.getIntrinsicWidth());
                sb5.append(" defualt_width =");
                sb5.append(ICON_DEFAULT_SIZE);
                sb5.append(" height = ");
                sb5.append(drawable.getIntrinsicHeight());
                sb5.append(" bitmapwith =");
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                sb5.append((int) ((bitmapDrawable.getBitmap().getWidth() / 2) * ViewUtils.getDensity()));
                sb5.append("bitmapheight =");
                sb5.append((int) ((bitmapDrawable.getBitmap().getHeight() / 2) * ViewUtils.getDensity()));
                cooperation.vip.vipcomponent.util.b.a("@vipIcon KINGBG", sb5.toString());
                return;
            case 10:
                drawable.setBounds(0, 0, getRealSize(drawable.getIntrinsicWidth(), i16), getRealSize(drawable.getIntrinsicHeight(), i16));
                aVar.h(drawable);
                return;
            default:
                return;
        }
    }

    private boolean handleIfNeedDefaultDrawable(int i3, int i16, int i17, String str, m15.a aVar, e eVar, boolean z16, boolean z17, Drawable drawable, Drawable drawable2, Drawable drawable3, boolean z18, Drawable drawable4) {
        boolean z19;
        if (z18) {
            z19 = handlePersonalizedAvatar(i3, i16, i17, str, aVar, eVar);
        } else {
            z19 = false;
        }
        if (drawable3 != null && drawable4 != null && ((!z17 || drawable != null) && ((!z16 || drawable2 != null) && !z19))) {
            return false;
        }
        return true;
    }

    private Drawable handleLocationAvatar(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, int i19, m15.a aVar, e eVar, boolean z18, boolean z19, Drawable drawable, Drawable drawable2, Drawable drawable3, boolean z26, Drawable drawable4) {
        if (i17 != 4) {
            return aVar;
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i18), getRealSize(ICON_DEFAULT_SIZE, i18));
            aVar.f(drawable3);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i18), getRealSize(ICON_DEFAULT_SIZE, i18));
            aVar.k(drawable4);
        }
        if (handleIfNeedDefaultDrawable(i3, i17, i18, str2, aVar, eVar, z18, z19, drawable, drawable2, drawable3, z26, drawable4)) {
            return getDefaultDrawable(i18, eVar);
        }
        addToCache(aVar, i19, i18, i3, z17, str, i17, z16, i16);
        return aVar;
    }

    private Drawable handleLocationRibbon(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, int i19, int i26, m15.a aVar, e eVar, boolean z18, boolean z19, Drawable drawable, Drawable drawable2) {
        Drawable levelDrawable;
        Drawable background = getBackground(i16, i3, 1, i17, str2, eVar, i19);
        if (background != null) {
            background.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i18), getRealSize(ICON_DEFAULT_SIZE, i18));
            aVar.f(background);
        }
        if (!TextUtils.isEmpty(str2)) {
            levelDrawable = c.e(str2, 4, i3, i17, eVar);
            if (levelDrawable != null) {
                levelDrawable.setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, i18), getRealSize(PERSONALIZED_ICON_LV_WIDTH, i18), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, i18));
                aVar.k(levelDrawable);
            }
        } else {
            levelDrawable = getLevelDrawable(i17, 3, z16, i3, i3 == 0 || i16 == 0, eVar);
            if (levelDrawable != null) {
                int i27 = RIBBON_ICON_LEVEL_MARGIN_TOP;
                levelDrawable.setBounds(0, getRealSize(i27, i18), getRealSize(ICON_DEFAULT_SIZE, i18), getRealSize(ICON_DEFAULT_SIZE + i27, i18));
                aVar.k(levelDrawable);
            }
        }
        if (levelDrawable != null && background != null && ((!z19 || drawable != null) && (!z18 || drawable2 != null))) {
            addToCache(aVar, i26, i18, i3, z17, str, i17, z16, i16);
            return aVar;
        }
        return getDefaultDrawable(i18, eVar);
    }

    private Drawable handleNotLocationAvatar(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, int i19, int i26, m15.a aVar, e eVar, boolean z18, boolean z19, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        cooperation.vip.vipcomponent.util.b.a("vipIcon", "come to annual vip icon show");
        if (i19 == 1 && !TextUtils.isEmpty(str2)) {
            Drawable f16 = c.f(str2, 9, i3, i17, eVar, i19);
            cooperation.vip.vipcomponent.util.b.a("@vipIcon", "get is kingtype  url = " + str2);
            if (f16 != null) {
                f16.setBounds(getRealSize((ICON_DEFAULT_SIZE - f16.getIntrinsicWidth()) / 2, i18), getRealSize(ICON_DEFAULT_SIZE - f16.getIntrinsicHeight(), i18), getRealSize((ICON_DEFAULT_SIZE + f16.getIntrinsicWidth()) / 2, i18), getRealSize(ICON_DEFAULT_SIZE, i18));
                aVar.j(f16);
            }
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i18), getRealSize(ICON_DEFAULT_SIZE, i18));
            aVar.f(drawable3);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, i18), getRealSize(ICON_DEFAULT_SIZE, i18));
            aVar.k(drawable4);
        }
        if (getDefaultDrawableFromUrl(i3, z16, i17, i18, str2, aVar, eVar, z18, z19, drawable, drawable2, drawable3, drawable4)) {
            return getDefaultDrawable(i18, eVar);
        }
        addToCache(aVar, i26, i18, i3, z17, str, i17, z16, i16);
        return aVar;
    }

    private Drawable handleNotRibbon(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, int i19, int i26, m15.a aVar, e eVar, boolean z18, boolean z19, Drawable drawable, Drawable drawable2) {
        boolean z26 = !TextUtils.isEmpty(str2) && i17 == 4;
        Drawable background = getBackground(i16, i3, 1, i17, str2, eVar, i19);
        Drawable levelDrawable = getLevelDrawable(i17, 2, z16, i3, i3 == 0 || i16 == 0, eVar);
        if (i17 != 6 && i17 != 5 && i17 != 8) {
            return handleLocationAvatar(i3, i16, z16, z17, str, i17, i18, str2, i26, aVar, eVar, z18, z19, drawable, drawable2, background, z26, levelDrawable);
        }
        return handleNotLocationAvatar(i3, i16, z16, z17, str, i17, i18, str2, i19, i26, aVar, eVar, z18, z19, drawable, drawable2, background, levelDrawable);
    }

    private boolean handlePersonalized(int i3, int i16, int i17, String str, m15.a aVar, e eVar, boolean z16, boolean z17, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable e16 = c.e(str, 6, i3, i16, eVar);
        cooperation.vip.vipcomponent.util.b.a("@vipIcon", "feeds personalized  url = " + str);
        if (e16 != null) {
            e16.setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, i17), getRealSize(ICON_DEFAULT_SIZE - e16.getIntrinsicHeight(), i17), getRealSize((ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT) + e16.getIntrinsicWidth(), i17), getRealSize(ICON_DEFAULT_SIZE, i17));
            aVar.e(e16);
        }
        if (drawable3 != null && drawable4 != null && e16 != null && ((!z17 || drawable != null) && (!z16 || drawable2 != null))) {
            return false;
        }
        cooperation.vip.vipcomponent.util.b.b("vipIconShow", "personalized Drawable is null");
        return true;
    }

    private boolean handlePersonalizedAvatar(int i3, int i16, int i17, String str, m15.a aVar, e eVar) {
        Drawable e16 = c.e(str, 0, i3, i16, eVar);
        if (e16 != null) {
            e16.setBounds(getRealSize(ICON_DEFAULT_SIZE - e16.getIntrinsicWidth(), i17) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, i17), getRealSize(ICON_DEFAULT_SIZE + e16.getIntrinsicWidth(), i17) / 2, getRealSize(e16.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, i17));
            aVar.i(e16);
        }
        if (e16 != null) {
            return false;
        }
        return true;
    }

    private boolean isVipIcon(int i3, int i16, int i17) {
        if (1 == i3 || 2 == i3) {
            return true;
        }
        if (6 == i16 || 7 == i16 || 8 == i16) {
            return false;
        }
        if (i17 != 0 || 4 != i16) {
            return true;
        }
        return false;
    }

    private static boolean showCustomDiamond(int i3, boolean z16, String str) {
        if ((i3 == 1 || i3 == 2) && z16 && !TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    public float getDensity() {
        return ViewUtils.getDensity();
    }

    public synchronized Drawable getLayers(int i3, int i16, boolean z16, int i17, int i18, String str, VipResourcesListener vipResourcesListener, int i19) {
        return getLayers(i3, i16, z16, false, null, i17, i18, str, vipResourcesListener, i19);
    }

    public void releaseResources() {
        this.context = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1 A[Catch: all -> 0x017c, TryCatch #0 {, blocks: (B:4:0x000b, B:10:0x0015, B:14:0x0033, B:16:0x0061, B:21:0x0083, B:28:0x00d9, B:30:0x00e1, B:33:0x0124, B:37:0x0176, B:42:0x0099, B:44:0x00a1), top: B:3:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Drawable getLayers(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, VipResourcesListener vipResourcesListener, int i19) {
        b bVar;
        m15.a aVar;
        int i26;
        boolean z18;
        Drawable drawable;
        Drawable drawable2;
        boolean z19;
        int i27;
        Drawable windsDrawalbe;
        Drawable drawable3 = null;
        if (!isVipIcon(i16, i17, i3)) {
            return null;
        }
        int b16 = l15.b.b(str2);
        Drawable fromCache = getFromCache(b16, i18, i3, z17, str, i17, z16, i16);
        if (fromCache != null) {
            return fromCache;
        }
        m15.a aVar2 = new m15.a();
        b bVar2 = new b(vipResourcesListener, i18, aVar2, i3, b16, z17, str, i17, z16, i16);
        if (showCustomDiamond(i16, z17, str)) {
            return handleCustomDiamond(i3, i16, z16, z17, str, i17, i18, b16, aVar2, bVar2);
        }
        boolean z26 = false;
        if (i3 == 9) {
            if (!TextUtils.isEmpty(str2) && i17 == 4) {
                i27 = i18;
                bVar = bVar2;
                aVar = aVar2;
                windsDrawalbe = getWindsDrawalbe(i16, i3, 8, bVar);
                if (windsDrawalbe != null) {
                    windsDrawalbe.setBounds(getRealSize(LV9_WINDS_MARGIN_LEFT, i27), getRealSize(LV9_WINDS_MARGIN_TOP, i27), getRealSize(LV9_WINDS_WIDTH + LV9_WINDS_MARGIN_LEFT, i27), getRealSize(LV9_WINDS_HEIGHT + LV9_WINDS_MARGIN_TOP, i27));
                    aVar.l(windsDrawalbe);
                }
                drawable2 = windsDrawalbe;
                z18 = z26;
                drawable = drawable3;
                i26 = 7;
                z19 = true;
            }
            if (i19 != 1) {
                bVar = bVar2;
                Drawable lv9Guan = getLv9Guan(i16, i3, i17, 7, bVar);
                if (lv9Guan != null) {
                    i27 = i18;
                    lv9Guan.setBounds(getRealSize(LV9_GUAN_ICON_MARGIN_LEFT, i27), getRealSize(LV9_GUAN_ICON_MARGIN_TOP, i27), getRealSize(LV9_GUAN_ICON_WIDTH + LV9_GUAN_ICON_MARGIN_LEFT, i27), getRealSize(LV9_GUAN_ICON_HEIGHT + LV9_GUAN_ICON_MARGIN_TOP, i27));
                    aVar = aVar2;
                    aVar.i(lv9Guan);
                } else {
                    i27 = i18;
                    aVar = aVar2;
                }
                drawable3 = lv9Guan;
                z26 = true;
                windsDrawalbe = getWindsDrawalbe(i16, i3, 8, bVar);
                if (windsDrawalbe != null) {
                }
                drawable2 = windsDrawalbe;
                z18 = z26;
                drawable = drawable3;
                i26 = 7;
                z19 = true;
            } else {
                i27 = i18;
                bVar = bVar2;
                aVar = aVar2;
                windsDrawalbe = getWindsDrawalbe(i16, i3, 8, bVar);
                if (windsDrawalbe != null) {
                }
                drawable2 = windsDrawalbe;
                z18 = z26;
                drawable = drawable3;
                i26 = 7;
                z19 = true;
            }
        } else {
            bVar = bVar2;
            aVar = aVar2;
            i26 = 7;
            z18 = false;
            drawable = null;
            drawable2 = null;
            z19 = false;
        }
        if (i17 == i26) {
            return handleLocationRibbon(i3, i16, z16, z17, str, i17, i18, str2, i19, b16, aVar, bVar, z19, z18, drawable, drawable2);
        }
        return handleNotRibbon(i3, i16, z16, z17, str, i17, i18, str2, i19, b16, aVar, bVar, z19, z18, drawable, drawable2);
    }
}
