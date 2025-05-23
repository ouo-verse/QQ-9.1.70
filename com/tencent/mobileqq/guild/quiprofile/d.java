package com.tencent.mobileqq.guild.quiprofile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUITokenResUtil;
import ie0.a;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d implements mw1.b {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f231936g = false;

    /* renamed from: h, reason: collision with root package name */
    private static final be0.a f231937h = be0.a.b("guild_light");

    /* renamed from: i, reason: collision with root package name */
    private static final be0.a f231938i = be0.a.b("guild_night");

    /* renamed from: a, reason: collision with root package name */
    private final boolean f231939a;

    /* renamed from: b, reason: collision with root package name */
    private final int f231940b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Drawable, Drawable> f231941c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<ColorStateList, ColorStateList> f231942d = new WeakHashMap();

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private be0.a f231943e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f231944f = null;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements a.InterfaceC10522a {
        a() {
        }

        @Override // ie0.a.InterfaceC10522a
        public boolean a(Context context) {
            return context.getResources() instanceof c;
        }

        @Override // ie0.a.InterfaceC10522a
        public ColorStateList b(Context context, int i3, int i16) {
            if (i16 == 1000 || !a(context)) {
                return null;
            }
            Resources resources = context.getResources();
            String resourceEntryName = resources.getResourceEntryName(i3);
            ColorStateList colorStateList = ((c) resources).getCom.qq.e.comm.managers.plugin.PM.BASE java.lang.String().getColorStateList(i3);
            if (i16 == 1002 && GuildColorPalette.r().y(resourceEntryName)) {
                return d.d().d(colorStateList);
            }
            if (i16 != 1001 || !GuildColorPalette.p().y(resourceEntryName)) {
                return null;
            }
            return d.c().d(colorStateList);
        }
    }

    static {
        GuildColorPalette.z();
        ie0.a.f().a(new a());
    }

    public d(int i3, boolean z16) {
        this.f231940b = i3;
        this.f231939a = z16;
        g();
    }

    static /* bridge */ /* synthetic */ be0.a c() {
        return e();
    }

    static /* bridge */ /* synthetic */ be0.a d() {
        return f();
    }

    private static be0.a e() {
        ae0.a n3;
        be0.a aVar = f231937h;
        if (f231936g) {
            n3 = GuildColorPalette.p().q();
        } else {
            n3 = GuildColorPalette.n();
        }
        aVar.c(n3);
        return aVar;
    }

    private static be0.a f() {
        ae0.a o16;
        be0.a aVar = f231938i;
        if (f231936g) {
            o16 = GuildColorPalette.r().q();
        } else {
            o16 = GuildColorPalette.o();
        }
        aVar.c(o16);
        return aVar;
    }

    @Override // mw1.b
    public Drawable a(Context context, Drawable drawable) {
        Drawable drawable2 = this.f231941c.get(drawable);
        if (drawable2 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QUIProfileSkinGuildTintHelper", 1, "find cached drawable");
            }
            drawable = drawable2;
        }
        be0.a aVar = this.f231943e;
        if (aVar == null) {
            return drawable;
        }
        if (drawable instanceof GuildVectorDrawableCompat) {
            GuildVectorDrawableCompat guildVectorDrawableCompat = (GuildVectorDrawableCompat) drawable;
            guildVectorDrawableCompat.profileColor(context.getResources(), context.getTheme());
            return guildVectorDrawableCompat;
        }
        Drawable e16 = aVar.e(context, drawable);
        if (e16 != drawable) {
            this.f231941c.put(e16, drawable);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUIProfileSkinGuildTintHelper", 1, "mDrawableMap Size\uff1a" + this.f231941c.size());
            }
        }
        return e16;
    }

    @Override // mw1.b
    public ColorStateList b(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.f231942d.get(colorStateList);
        if (colorStateList2 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QUIProfileSkinGuildTintHelper", 1, "find cached color");
            }
            colorStateList = colorStateList2;
        }
        be0.a aVar = this.f231943e;
        if (aVar == null) {
            return colorStateList;
        }
        ColorStateList d16 = aVar.d(colorStateList);
        if (d16 != colorStateList) {
            this.f231942d.put(d16, colorStateList);
            if (QLog.isDevelopLevel()) {
                QLog.d("QUIProfileSkinGuildTintHelper", 1, "mColorMap Size\uff1a" + this.f231942d.size());
            }
        }
        return d16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x010e, code lost:
    
        if (r0.equals("2921") == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        ae0.a o16;
        ae0.a n3;
        ae0.a t16;
        ae0.a x16;
        ae0.a u16;
        ae0.a w3;
        ae0.a v3;
        ae0.a s16;
        ae0.a n16;
        ae0.a o17;
        ae0.a r16;
        ae0.a p16;
        String currentThemeId = QQTheme.getCurrentThemeId();
        if (TextUtils.equals(currentThemeId, this.f231944f)) {
            return;
        }
        this.f231944f = currentThemeId;
        int i3 = this.f231940b;
        char c16 = 1;
        if (i3 == 1001) {
            this.f231943e = e();
            QLog.i("QUIProfileSkinGuildTintHelper", 1, "\u9891\u9053profile\uff1a\u5f3a\u5236\u6d45\u8272");
            return;
        }
        if (i3 == 1002) {
            this.f231943e = f();
            QLog.i("QUIProfileSkinGuildTintHelper", 1, "\u9891\u9053profile\uff1a\u5f3a\u5236\u6df1\u8272");
            return;
        }
        if (i3 != 1000) {
            this.f231943e = null;
            return;
        }
        if (QUITokenResUtil.isNowQUIDebugTheme()) {
            this.f231943e = null;
            QLog.i("QUIProfileSkinGuildTintHelper", 1, "\u9891\u9053profile\uff1a\u8ddf\u968f\u624bQ\uff0cthemeId\uff1a" + currentThemeId + ", \u4f46\u5c5e\u4e8eQUI DEBUG\u4e3b\u9898");
            return;
        }
        be0.a b16 = be0.a.b("guild");
        this.f231943e = b16;
        if (QQTheme.isDefaultTheme()) {
            if (f231936g) {
                p16 = GuildColorPalette.p().q();
            } else {
                p16 = GuildColorPalette.p();
            }
            b16.c(p16);
            return;
        }
        if ("1103".equals(currentThemeId)) {
            if (f231936g) {
                r16 = GuildColorPalette.r().q();
            } else {
                r16 = GuildColorPalette.r();
            }
            b16.c(r16);
        }
        currentThemeId.hashCode();
        switch (currentThemeId.hashCode()) {
            case 1545925:
                if (currentThemeId.equals("2920")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1545926:
                break;
            case 1546081:
                if (currentThemeId.equals("2971")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1567194:
                if (currentThemeId.equals("3063")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1567195:
                if (currentThemeId.equals("3064")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1567196:
                if (currentThemeId.equals("3065")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1567197:
                if (currentThemeId.equals("3066")) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1567198:
                if (currentThemeId.equals("3067")) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1571129:
                if (currentThemeId.equals("3491")) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                if (f231936g) {
                    o16 = GuildColorPalette.r().q();
                } else {
                    o16 = GuildColorPalette.o();
                }
                b16.c(o16);
                return;
            case 1:
            case 2:
                if (f231936g) {
                    n3 = GuildColorPalette.p().q();
                } else {
                    n3 = GuildColorPalette.n();
                }
                b16.c(n3);
                return;
            case 3:
                if (f231936g) {
                    t16 = GuildColorPalette.t().q();
                } else {
                    t16 = GuildColorPalette.t();
                }
                b16.c(t16);
                return;
            case 4:
                if (f231936g) {
                    x16 = GuildColorPalette.x().q();
                } else {
                    x16 = GuildColorPalette.x();
                }
                b16.c(x16);
                return;
            case 5:
                if (f231936g) {
                    u16 = GuildColorPalette.u().q();
                } else {
                    u16 = GuildColorPalette.u();
                }
                b16.c(u16);
                return;
            case 6:
                if (f231936g) {
                    w3 = GuildColorPalette.w().q();
                } else {
                    w3 = GuildColorPalette.w();
                }
                b16.c(w3);
                return;
            case 7:
                if (f231936g) {
                    v3 = GuildColorPalette.v().q();
                } else {
                    v3 = GuildColorPalette.v();
                }
                b16.c(v3);
                return;
            case '\b':
                if (f231936g) {
                    s16 = GuildColorPalette.s().q();
                } else {
                    s16 = GuildColorPalette.s();
                }
                b16.c(s16);
                return;
            default:
                if (!this.f231939a && !f231936g) {
                    this.f231943e = null;
                    return;
                }
                if (GuildThemeManager.f235286a.b()) {
                    if (f231936g) {
                        o17 = GuildColorPalette.r().q();
                    } else {
                        o17 = GuildColorPalette.o();
                    }
                    b16.c(o17);
                    return;
                }
                if (f231936g) {
                    n16 = GuildColorPalette.p().q();
                } else {
                    n16 = GuildColorPalette.n();
                }
                b16.c(n16);
                return;
        }
    }
}
