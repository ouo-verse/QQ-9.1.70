package com.qzone.business.plusunion.plusoperation;

import android.text.TextUtils;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f44663a = {QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusMood", "\u8bf4\u8bf4"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusAlbum", QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusShoot", "\u76f8\u673a"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusSignIn", "\u7b7e\u5230"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusBlog", "\u65e5\u5fd7"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusTemplate", "\u505a\u540c\u6b3e"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PlusMoment", QzoneConfig.DEFAULT_KEY_QZONE_MOMENT_OUTER_ENTRANCE_MAIN_TEXT)};

    /* renamed from: b, reason: collision with root package name */
    public static final String f44664b = l.a(R.string.p_j);

    /* renamed from: c, reason: collision with root package name */
    public static final String f44665c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f44666d;

    /* renamed from: e, reason: collision with root package name */
    public static String[] f44667e;

    /* renamed from: f, reason: collision with root package name */
    public static int[] f44668f;

    /* renamed from: g, reason: collision with root package name */
    public static int[] f44669g;

    /* renamed from: h, reason: collision with root package name */
    public static int[] f44670h;

    /* renamed from: i, reason: collision with root package name */
    public static int[] f44671i;

    /* renamed from: j, reason: collision with root package name */
    public static int[] f44672j;

    /* renamed from: k, reason: collision with root package name */
    public static int[] f44673k;

    /* renamed from: l, reason: collision with root package name */
    public static int[] f44674l;

    /* renamed from: m, reason: collision with root package name */
    public static int[] f44675m;

    /* renamed from: n, reason: collision with root package name */
    public static int[] f44676n;

    /* renamed from: o, reason: collision with root package name */
    public static int[] f44677o;

    public static String a() {
        String l06 = QZoneConfigHelper.l0();
        return !TextUtils.isEmpty(l06) ? l06 : "https://h5.qzone.qq.com/check_in/index.html?_wv=3&_wwv=1";
    }

    static {
        String a16 = l.a(R.string.p_l);
        f44665c = a16;
        f44666d = "mqzone://arouse/takevideo?" + a16;
        f44667e = new String[]{"mqzone://arouse/writemood", QZoneJsConstants.SCHEME_PREFIX_UPLOAD_PHOTO, "mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzoneCamera&uin=&appid=406&widgetid=&shareto=2", a(), "https://h5.qzone.qq.com/blog/list2?_wv=3&_proxy=1&source=panel", "mqqapi://arouse/openqqpublish/mood?target=2", "mqzone://arouse/moment/publish"};
        f44668f = new int[]{R.drawable.g_0, R.drawable.g9w, R.drawable.hy5, R.drawable.g_4, R.drawable.nxb, R.drawable.nxj, R.drawable.nxe};
        f44669g = new int[]{R.drawable.nxg, R.drawable.nxd, R.drawable.nxl, R.drawable.nxi, R.drawable.nxc, R.drawable.nxk, R.drawable.nxf};
        f44670h = new int[]{0, 0, 0, 0, 0, 1, 1};
        f44671i = new int[]{36, 37, 38, 39, 27, 62, 42};
        f44672j = new int[]{0, 0, 0, 0, 0, 0, 0};
        f44673k = new int[]{2, 2, 2, 3, 2, 2, 2};
        f44674l = new int[]{309, 309, 309, 309, 309, 309, 309};
        f44675m = new int[]{104, 105, 106, 108, 130, 156, 161};
        f44676n = new int[]{2, 2, 2, 2, 2, 2, 2};
        f44677o = new int[]{1, 1, 1, 1, 1, 1, 1};
    }
}
