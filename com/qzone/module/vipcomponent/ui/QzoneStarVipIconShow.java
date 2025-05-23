package com.qzone.module.vipcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import cooperation.vip.vipcomponent.util.c;
import cooperation.vip.vipcomponent.util.e;
import java.util.concurrent.ConcurrentHashMap;
import m15.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneStarVipIconShow {
    public static final int TYPE_STAR_VIP_DEALY = 1;
    public static final int TYPE_STAR_VIP_NEVER = 0;
    public static final int TYPE_STAR_VIP_OPEN = 2;

    /* renamed from: a, reason: collision with root package name */
    private Context f49074a;

    /* renamed from: b, reason: collision with root package name */
    private float f49075b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    private int[] f49076c = {115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: d, reason: collision with root package name */
    private int[] f49077d = {107, 108, 109, 110, 111, 112, 113, 114};

    /* renamed from: e, reason: collision with root package name */
    private int[] f49078e = {55, 56, 57, 58, 59, 60, 61, 62};

    /* renamed from: f, reason: collision with root package name */
    private int[] f49079f = {71, 72, 73, 74, 75, 76, 77, 78};

    /* renamed from: g, reason: collision with root package name */
    private int[] f49080g = {63, 64, 65, 66, 67, 68, 69, 70};

    /* renamed from: h, reason: collision with root package name */
    private int[] f49081h = {79, 80, 81, 82, 83, 84, 85, 86};
    public static final int ICON_DEFAULT_SIZE = (int) (VipEnv.getDensity() * 24.0f);
    public static final int ANUAL_ICON_MARGIN_LEFT = (int) (VipEnv.getDensity() * 2.0f);
    public static final int ICON_ANNUALVIP_WIDTH = (int) (VipEnv.getDensity() * 22.0f);
    public static final int ICON_ANNUALVIP_HEIGHT = (int) (VipEnv.getDensity() * 12.0f);
    public static final int RIBBON_ICON_LEVEL_MARGIN_TOP = (int) (VipEnv.getDensity() * 6.0f);
    public static final int ICON_ADJUST_ANNUALVIP_MARGIN_TOP = (int) (VipEnv.getDensity() * 9.0f);
    public static QzoneStarVipIconShow mInstance = null;

    /* renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Drawable.ConstantState> f49073i = new ConcurrentHashMap<>();

    public QzoneStarVipIconShow(Context context) {
        this.f49074a = context;
    }

    private a e(int i3, e eVar) {
        a aVar = new a();
        Drawable f16 = f(47, 0, eVar);
        int i16 = ICON_DEFAULT_SIZE;
        f16.setBounds(0, 0, i(i16, i3), i(i16, i3));
        aVar.f(f16);
        return aVar;
    }

    private Drawable f(int i3, int i16, e eVar) {
        return c.d(i3, i16, eVar);
    }

    public static QzoneStarVipIconShow getInstance() {
        if (mInstance == null) {
            synchronized (QzoneStarVipIconShow.class) {
                if (mInstance == null) {
                    mInstance = new QzoneStarVipIconShow(null);
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i3, int i16) {
        return (int) ((i16 / 100.0d) * i3);
    }

    private boolean j(int i3, int i16) {
        if (2 == i3) {
            return true;
        }
        if (1 == i3 && 6 != i16 && 8 != i16) {
            return true;
        }
        return false;
    }

    private synchronized a g(final int i3, final int i16, final boolean z16, final boolean z17, final int i17, final int i18, final VipResourcesListener vipResourcesListener) {
        e eVar;
        Drawable drawable = null;
        if (!j(i16, i17)) {
            return null;
        }
        final a aVar = new a();
        e eVar2 = new e() { // from class: com.qzone.module.vipcomponent.ui.QzoneStarVipIconShow.1
            @Override // cooperation.vip.vipcomponent.util.e
            public void onFailed(String str, int i19, String str2) {
                VipResourcesListener vipResourcesListener2 = vipResourcesListener;
                if (vipResourcesListener2 != null) {
                    vipResourcesListener2.onFailed();
                }
            }

            @Override // cooperation.vip.vipcomponent.util.e
            public void onDownloaded(String str, int i19, String str2, Drawable drawable2) {
                if (i19 != 0) {
                    if (i19 != 1) {
                        if (i19 != 2) {
                            if (i19 == 3 && drawable2 != null) {
                                int i26 = QzoneStarVipIconShow.ICON_DEFAULT_SIZE;
                                int i27 = QzoneStarVipIconShow.ANUAL_ICON_MARGIN_LEFT;
                                int i28 = QzoneStarVipIconShow.i((i26 / 2) + i27, i18);
                                int i29 = QzoneStarVipIconShow.ICON_ADJUST_ANNUALVIP_MARGIN_TOP;
                                drawable2.setBounds(i28, QzoneStarVipIconShow.i(i29, i18), QzoneStarVipIconShow.i(QzoneStarVipIconShow.ICON_ANNUALVIP_WIDTH + (i26 / 2) + i27, i18), QzoneStarVipIconShow.i(i29 + QzoneStarVipIconShow.ICON_ANNUALVIP_HEIGHT, i18));
                                aVar.e(drawable2);
                            }
                        } else if (drawable2 != null) {
                            int i36 = QzoneStarVipIconShow.RIBBON_ICON_LEVEL_MARGIN_TOP;
                            int i37 = QzoneStarVipIconShow.ICON_DEFAULT_SIZE;
                            drawable2.setBounds(0, i36, QzoneStarVipIconShow.i(i37, i18), QzoneStarVipIconShow.i(i37, i18) + i36);
                            aVar.k(drawable2);
                        }
                    } else if (drawable2 != null) {
                        int i38 = QzoneStarVipIconShow.ICON_DEFAULT_SIZE;
                        drawable2.setBounds(0, 0, QzoneStarVipIconShow.i(i38, i18), QzoneStarVipIconShow.i(i38, i18));
                        aVar.k(drawable2);
                    }
                } else if (drawable2 != null) {
                    int i39 = QzoneStarVipIconShow.ICON_DEFAULT_SIZE;
                    drawable2.setBounds(0, 0, QzoneStarVipIconShow.i(i39, i18), QzoneStarVipIconShow.i(i39, i18));
                    aVar.f(drawable2);
                }
                if (this.mCount <= 0) {
                    QzoneStarVipIconShow.this.c(i3, i16, z16, z17, i17, i18, aVar);
                    VipResourcesListener vipResourcesListener2 = vipResourcesListener;
                    if (vipResourcesListener2 != null) {
                        vipResourcesListener2.onLoaded(aVar);
                    }
                }
            }
        };
        if (i17 == 7) {
            Drawable d16 = d(i3, i16, z16, z17, i17, i18, eVar2);
            if (d16 != null) {
                int i19 = ICON_DEFAULT_SIZE;
                d16.setBounds(0, 0, i(i19, i18), i(i19, i18));
                aVar.f(d16);
            }
            Drawable h16 = h(z16, 2, i16, i3, i17, eVar2);
            if (h16 != null) {
                int i26 = RIBBON_ICON_LEVEL_MARGIN_TOP;
                int i27 = ICON_DEFAULT_SIZE;
                h16.setBounds(0, i26, i(i27, i18), i(i27, i18) + i26);
                aVar.k(h16);
            }
            if (d16 != null && h16 != null) {
                c(i3, i16, z16, z17, i17, i18, aVar);
                return aVar;
            }
            return e(i18, eVar2);
        }
        Drawable d17 = d(i3, i16, z16, z17, i17, i18, eVar2);
        Drawable h17 = h(z16, 1, i16, i3, i17, eVar2);
        if (d17 != null) {
            int i28 = ICON_DEFAULT_SIZE;
            d17.setBounds(0, 0, i(i28, i18), i(i28, i18));
            aVar.f(d17);
        }
        if (h17 != null) {
            int i29 = ICON_DEFAULT_SIZE;
            h17.setBounds(0, 0, i(i29, i18), i(i29, i18));
            aVar.k(h17);
        }
        if (!z16 || 8 != i17) {
            if (d17 != null && h17 != null) {
                c(i3, i16, z16, z17, i17, i18, aVar);
                return aVar;
            }
            return e(i18, eVar2);
        }
        if (2 == i16) {
            eVar = eVar2;
            drawable = f(7, 3, eVar);
        } else {
            eVar = eVar2;
            if (1 == i16) {
                drawable = f(8, 3, eVar);
            }
        }
        if (drawable != null) {
            int i36 = ICON_DEFAULT_SIZE;
            int i37 = ANUAL_ICON_MARGIN_LEFT;
            int i38 = i((i36 / 2) + i37, i18);
            int i39 = ICON_ADJUST_ANNUALVIP_MARGIN_TOP;
            drawable.setBounds(i38, i(i39, i18), i(ICON_ANNUALVIP_WIDTH + (i36 / 2) + i37, i18), i(i39 + ICON_ANNUALVIP_HEIGHT, i18));
            aVar.e(drawable);
        }
        if (drawable != null && d17 != null && h17 != null) {
            c(i3, i16, z16, z17, i17, i18, aVar);
            return aVar;
        }
        return e(i18, eVar);
    }

    private Drawable h(boolean z16, int i3, int i16, int i17, int i18, e eVar) {
        if (7 == i18) {
            if (z16) {
                if (i17 <= 0 || i17 > 8) {
                    return null;
                }
                return c.d(this.f49077d[i17 - 1], i3, eVar);
            }
            if (i17 <= 0 || i17 > 8) {
                return null;
            }
            return c.d(this.f49076c[i17 - 1], i3, eVar);
        }
        if (i16 == 1) {
            if (!z16 || 8 == i18) {
                if (i17 <= 0 || i17 > 8) {
                    return null;
                }
                return c.d(this.f49081h[i17 - 1], i3, eVar);
            }
            if (i17 <= 0 || i17 > 8) {
                return null;
            }
            return c.d(this.f49079f[i17 - 1], i3, eVar);
        }
        if (i16 != 2) {
            return null;
        }
        if (!z16 || 8 == i18) {
            if (i17 <= 0 || i17 > 8) {
                return null;
            }
            return c.d(this.f49080g[i17 - 1], i3, eVar);
        }
        if (i17 <= 0 || i17 > 8) {
            return null;
        }
        return c.d(this.f49078e[i17 - 1], i3, eVar);
    }

    public Drawable getVipIcon(int i3, int i16, boolean z16, boolean z17, int i17, int i18, VipResourcesListener vipResourcesListener) {
        Drawable.ConstantState constantState = f49073i.get(Integer.valueOf((100000 * (z17 ? 1 : 0)) + (i18 * 10000) + (i3 * 1000) + (i16 * 100) + (i17 * 10) + (z16 ? 1 : 0)));
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return g(i3, i16, z16, z17, i17, i18, vipResourcesListener);
    }

    private Drawable d(int i3, int i16, boolean z16, boolean z17, int i17, int i18, e eVar) {
        if (i16 == 1) {
            if (8 == i3) {
                return f(z17 ? 54 : 49, 0, eVar);
            }
            return f(z17 ? 52 : 50, 0, eVar);
        }
        if (i16 != 2) {
            return null;
        }
        if (8 == i3) {
            return f(z17 ? 53 : 48, 0, eVar);
        }
        return f(z17 ? 51 : 47, 0, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3, int i16, boolean z16, boolean z17, int i17, int i18, a aVar) {
        int i19 = ((z17 ? 1 : 0) * 100000) + (i18 * 10000) + (i3 * 1000) + (i17 * 100) + ((z16 ? 1 : 2) * 10) + i16;
        if (aVar != null) {
            f49073i.put(Integer.valueOf(i19), aVar.a());
        }
    }
}
