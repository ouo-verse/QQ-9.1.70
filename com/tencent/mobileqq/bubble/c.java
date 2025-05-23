package com.tencent.mobileqq.bubble;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;
    public static int B;
    private int A;

    /* renamed from: a, reason: collision with root package name */
    public int f200668a;

    /* renamed from: b, reason: collision with root package name */
    public String f200669b;

    /* renamed from: c, reason: collision with root package name */
    public NinePatch f200670c;

    /* renamed from: d, reason: collision with root package name */
    public String f200671d;

    /* renamed from: e, reason: collision with root package name */
    public NinePatch f200672e;

    /* renamed from: f, reason: collision with root package name */
    public String f200673f;

    /* renamed from: g, reason: collision with root package name */
    public String f200674g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f200675h;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public g.a f200676i;

    /* renamed from: j, reason: collision with root package name */
    public int f200677j;

    /* renamed from: k, reason: collision with root package name */
    public int f200678k;

    /* renamed from: l, reason: collision with root package name */
    public int f200679l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f200680m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f200681n;

    /* renamed from: o, reason: collision with root package name */
    public double f200682o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f200683p;

    /* renamed from: q, reason: collision with root package name */
    public String f200684q;

    /* renamed from: r, reason: collision with root package name */
    public int f200685r;

    /* renamed from: s, reason: collision with root package name */
    public int f200686s;

    /* renamed from: t, reason: collision with root package name */
    public a f200687t;

    /* renamed from: u, reason: collision with root package name */
    public a f200688u;

    /* renamed from: v, reason: collision with root package name */
    public List<Pair<a, a>> f200689v;

    /* renamed from: w, reason: collision with root package name */
    public HashMap<String, String> f200690w;

    /* renamed from: x, reason: collision with root package name */
    List<View> f200691x;

    /* renamed from: y, reason: collision with root package name */
    List<View> f200692y;

    /* renamed from: z, reason: collision with root package name */
    private int f200693z;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f200694a;

        /* renamed from: b, reason: collision with root package name */
        public int f200695b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f200696c;

        /* renamed from: d, reason: collision with root package name */
        public int f200697d;

        /* renamed from: e, reason: collision with root package name */
        public String f200698e;

        /* renamed from: f, reason: collision with root package name */
        public Rect f200699f;

        /* renamed from: g, reason: collision with root package name */
        public int f200700g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f200701h;

        /* renamed from: i, reason: collision with root package name */
        public String f200702i;

        /* renamed from: j, reason: collision with root package name */
        public String[] f200703j;

        /* renamed from: k, reason: collision with root package name */
        public com.tencent.mobileqq.bubble.a f200704k;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f200695b = 1;
            this.f200696c = true;
            this.f200697d = 50;
            this.f200699f = new Rect();
            this.f200700g = -1;
            this.f200701h = true;
            this.f200703j = new String[0];
            this.f200698e = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "CommonAttrs [key=" + this.f200702i + ", mRect=" + this.f200699f + ", count=" + this.f200694a + ", duration=" + this.f200697d + ", align=" + this.f200700g + ", mBigImgPath=" + this.f200698e + ", repeatCount=" + this.f200695b + ", mAnimationPath=" + Arrays.toString(this.f200703j) + "]";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            B = 0;
        }
    }

    public c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f200668a = 0;
        this.f200669b = "";
        this.f200671d = "";
        this.f200673f = "";
        this.f200674g = "";
        this.f200675h = null;
        this.f200691x = new ArrayList();
        this.f200692y = new ArrayList();
        this.f200668a = i3;
    }

    private Drawable b(boolean z16, Drawable drawable) {
        String str;
        Drawable.ConstantState constantState;
        if (TokenResUtils.useSimpleBubble()) {
            if (z16) {
                str = "bubblebg://default_mine_simple";
            } else {
                str = "bubblebg://default_friend_simple";
            }
        } else if (z16) {
            str = "bubblebg://default_mine";
        } else {
            str = "bubblebg://default_friend";
        }
        try {
            constantState = (Drawable.ConstantState) ImageCacheHelper.f98636a.g(str);
        } catch (ArrayIndexOutOfBoundsException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("BubbleInfo", 4, "ArrayIndexOutOfBoundsException", e16);
            }
            constantState = null;
        }
        if (constantState != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BubbleInfo", 4, "getBubbleDrawable, get Default from imageCache, key=" + str + ", bubbleId=" + this.f200668a);
            }
            return constantState.newDrawable();
        }
        return drawable;
    }

    public static int e() {
        if (QQTheme.isNowSimpleUI()) {
            return 64;
        }
        return 65;
    }

    @NotNull
    private Drawable f(QQAppInterface qQAppInterface, boolean z16) {
        String str;
        Resources resources = qQAppInterface.getApp().getResources();
        Drawable drawable = resources.getDrawable(SimpleModeHelper.e(z16, true));
        Drawable drawable2 = resources.getDrawable(SimpleModeHelper.e(z16, false));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable2);
        if (TokenResUtils.useSimpleBubble()) {
            if (z16) {
                str = "bubblebg://default_mine_simple";
            } else {
                str = "bubblebg://default_friend_simple";
            }
        } else if (z16) {
            str = "bubblebg://default_mine";
        } else {
            str = "bubblebg://default_friend";
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("BubbleInfo", 4, "getBubbleDrawable, put default bubble to imageCache, key=" + str + ", bubbleId=" + this.f200668a);
        }
        ImageCacheHelper.f98636a.i(str, stateListDrawable.getConstantState(), Business.AIO);
        return stateListDrawable;
    }

    @Nullable
    private Drawable g(QQAppInterface qQAppInterface, boolean z16, boolean z17, Drawable drawable) {
        Drawable i3;
        if (!TextUtils.isEmpty(this.f200669b) && !TextUtils.isEmpty(this.f200671d)) {
            h hVar = new h(qQAppInterface.getApp().getResources(), this.f200670c, this.f200672e, this.f200668a);
            hVar.d(!z16, z17);
            if (QLog.isDevelopLevel()) {
                QLog.d("BubbleInfo", 4, "getBubbleDrawable, bubbleId=" + this.f200668a + ", vipBubbleDrawable=" + hVar);
            }
            if (!BubbleManager.K && this.f200668a != 0) {
                BubbleManager.K = true;
                return hVar;
            }
            return hVar;
        }
        int i16 = this.f200668a;
        if (i16 == 100000 || i16 == 100001) {
            if (z16) {
                i3 = null;
            } else {
                i3 = i(qQAppInterface.getApp(), this.f200668a, z16, z17, this.f200693z, this.A);
            }
            return i3;
        }
        return drawable;
    }

    @NotNull
    private Drawable h(QQAppInterface qQAppInterface, boolean z16, boolean z17, boolean z18, Drawable drawable) {
        if (z17) {
            drawable = g(qQAppInterface, z16, z18, drawable);
        }
        if (drawable == null) {
            drawable = b(z16, drawable);
        }
        if (drawable == null) {
            return f(qQAppInterface, z16);
        }
        return drawable;
    }

    private Drawable i(Context context, int i3, boolean z16, boolean z17, int i16, int i17) {
        String str = "bubbleinfo_" + i3 + "_bg_" + z16 + "_" + z17;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g(str);
        if (g16 instanceof com.tencent.cache.api.g) {
            return ((Drawable.ConstantState) ((com.tencent.cache.api.g) g16).b()).newDrawable(context.getResources());
        }
        Drawable drawable = context.getResources().getDrawable(i16);
        Drawable drawable2 = context.getResources().getDrawable(i17);
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (drawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, drawable);
        }
        if (drawable2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable2);
            stateListDrawable.addState(new int[]{-16842910}, drawable2);
        }
        int e16 = cn.e(drawable) + cn.e(drawable2);
        if (e16 > 0) {
            imageCacheHelper.i(str, new com.tencent.cache.api.g(stateListDrawable.getConstantState(), e16), Business.AIO);
        }
        return stateListDrawable;
    }

    private void l(QQAppInterface qQAppInterface, boolean z16, boolean z17, boolean z18, String str, int i3, Drawable drawable) {
        if ((drawable instanceof h) && z17 && !z18 && i3 > 0) {
            ((h) drawable).e(qQAppInterface, str + "_" + i3, !z16);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f200691x) {
            this.f200691x.clear();
        }
        synchronized (this.f200692y) {
            this.f200692y.clear();
        }
    }

    public Drawable c(QQAppInterface qQAppInterface, boolean z16, boolean z17, boolean z18, View view, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, this, qQAppInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), view, str, Integer.valueOf(i3));
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("BubbleInfo", 4, "getBubbleDrawable, bubbleId=" + this.f200668a + ", isUser=" + z16 + ", needVipBubble=" + z17 + ", useAnimationBg=" + z18 + ", senderUin=" + str);
        }
        Drawable h16 = h(qQAppInterface, z16, z17, z18, null);
        boolean z19 = h16 instanceof h;
        if (z19 && !TextUtils.isEmpty(this.f200674g)) {
            if (this.f200676i != null && view != null) {
                int width = view.getWidth();
                g.a aVar = this.f200676i;
                if (aVar.f200750f == 0) {
                    ((h) h16).f(true, this.f200674g, aVar.f200747b, aVar.f200746a);
                } else {
                    if (width == 0) {
                        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        width = view.getMeasuredWidth();
                    }
                    g.a aVar2 = this.f200676i;
                    if (width > aVar2.f200750f) {
                        ((h) h16).f(true, this.f200674g, aVar2.f200747b, aVar2.f200746a);
                    } else {
                        ((h) h16).f(false, null, null, null);
                    }
                }
            } else if (z19) {
                ((h) h16).f(false, null, null, null);
            }
        }
        l(qQAppInterface, z16, z17, z18, str, i3, h16);
        m(view, h16);
        return h16;
    }

    public Drawable d(QQAppInterface qQAppInterface, boolean z16, boolean z17, boolean z18, View view, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, qQAppInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), view, Boolean.valueOf(z19));
        }
        g.a aVar = this.f200676i;
        if (!z19) {
            this.f200676i = null;
        }
        Drawable c16 = c(qQAppInterface, z16, z17, z18, view, "", 0);
        this.f200676i = aVar;
        return c16;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f200669b) && !TextUtils.isEmpty(this.f200671d)) {
            return true;
        }
        return false;
    }

    public void k(View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) view2);
            return;
        }
        synchronized (this.f200691x) {
            this.f200691x.remove(view);
        }
        synchronized (this.f200692y) {
            this.f200692y.remove(view2);
        }
    }

    public void m(View view, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) drawable);
            return;
        }
        if (drawable != null && view != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            int paddingTop = view.getPaddingTop() + rect.top;
            int paddingLeft = view.getPaddingLeft() + rect.left;
            int paddingRight = view.getPaddingRight() + rect.right;
            int paddingBottom = view.getPaddingBottom() + rect.bottom;
            view.setBackgroundDrawable(drawable);
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "BubbleInfo [bubbleId=" + this.f200668a + ",aioUserBgNorResPath=" + this.f200669b + ",aioUserPicNorResPath=" + this.f200671d + ",bubbleThumbnailResPath=" + this.f200673f + ",bubbleChartletResPath=" + this.f200674g + ", mTextColor=" + this.f200677j + ", mKeyWords=" + Arrays.toString(this.f200683p) + ", currKeyWord=" + this.f200684q + ", mBubbleHeightBegin=" + this.f200685r + ", mBubbleHeightEnd=" + this.f200686s + ", pttAttrs=" + this.f200687t + ", heightAttrs=" + this.f200688u + ", keywordAttrs=" + this.f200689v + ", keyWorsAnimMap=" + this.f200690w + "]";
    }

    public c(int i3, String str, String str2, String str3, String str4, g.a aVar, int i16, int i17, int i18, boolean z16, boolean z17, double d16, String[] strArr, a aVar2, int i19, int i26, a aVar3, List<Pair<a, a>> list, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, str4, aVar, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17), Double.valueOf(d16), strArr, aVar2, Integer.valueOf(i19), Integer.valueOf(i26), aVar3, list, hashMap);
            return;
        }
        this.f200668a = 0;
        this.f200669b = "";
        this.f200671d = "";
        this.f200673f = "";
        this.f200674g = "";
        this.f200675h = null;
        this.f200691x = new ArrayList();
        this.f200692y = new ArrayList();
        this.f200668a = i3;
        this.f200673f = str3;
        this.f200669b = str;
        this.f200671d = str2;
        this.f200674g = str4;
        this.f200676i = aVar;
        this.f200677j = i16;
        this.f200678k = i17;
        this.f200679l = i18;
        this.f200680m = z16;
        this.f200681n = z17;
        this.f200682o = d16;
        this.f200685r = i19;
        this.f200686s = i26;
        this.f200683p = strArr;
        this.f200689v = list == null ? new ArrayList<>() : list;
        this.f200687t = aVar2;
        this.f200688u = aVar3;
        this.f200690w = hashMap == null ? new HashMap<>() : hashMap;
    }

    public c(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f200668a = 0;
        this.f200669b = "";
        this.f200671d = "";
        this.f200673f = "";
        this.f200674g = "";
        this.f200675h = null;
        this.f200691x = new ArrayList();
        this.f200692y = new ArrayList();
        this.f200668a = i3;
        this.f200693z = i16;
        this.A = i17;
    }
}
