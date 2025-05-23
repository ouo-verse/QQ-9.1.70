package com.tencent.mobileqq.activity.qcircle.utils;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static String f184607f = "WHITE_DEFAULT_MODE";

    /* renamed from: g, reason: collision with root package name */
    private static String f184608g = "DARK_DEFAULT_MODE";

    /* renamed from: h, reason: collision with root package name */
    private static String f184609h = "WHITE_SIMPLE_MODE";

    /* renamed from: i, reason: collision with root package name */
    private static String f184610i = "DARK_SIMPLE_MODE";

    /* renamed from: j, reason: collision with root package name */
    private static String f184611j = "WHITE_VAS_MODE";

    /* renamed from: k, reason: collision with root package name */
    private static String f184612k = "DARK_DEFAULT_MODE_AL";

    /* renamed from: l, reason: collision with root package name */
    private static int f184613l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static com.tencent.mobileqq.activity.home.impl.d f184614m;

    /* renamed from: n, reason: collision with root package name */
    private static HashMap<String, HashMap<String, Pair<Integer, Integer>>> f184615n = new HashMap<>(8);

    /* renamed from: c, reason: collision with root package name */
    private String f184618c;

    /* renamed from: d, reason: collision with root package name */
    private a f184619d;

    /* renamed from: a, reason: collision with root package name */
    private int f184616a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f184617b = true;

    /* renamed from: e, reason: collision with root package name */
    private final Set<Integer> f184620e = new HashSet();

    static {
        HashMap<String, Pair<Integer, Integer>> hashMap = new HashMap<>();
        String str = f184607f;
        Integer valueOf = Integer.valueOf(R.drawable.qui_tab_conversation_default);
        Integer valueOf2 = Integer.valueOf(R.drawable.qui_tab_conversation_default_pressed);
        hashMap.put(str, new Pair<>(valueOf, valueOf2));
        hashMap.put(f184611j, new Pair<>(Integer.valueOf(R.drawable.qui_tab_conversation_vas), valueOf2));
        hashMap.put(f184608g, new Pair<>(Integer.valueOf(R.drawable.qui_tab_conversation_default_dark), valueOf2));
        String str2 = f184609h;
        Integer valueOf3 = Integer.valueOf(R.drawable.qui_tab_conversation_simple);
        Integer valueOf4 = Integer.valueOf(R.drawable.qui_tab_conversation_simple_pressed);
        hashMap.put(str2, new Pair<>(valueOf3, valueOf4));
        hashMap.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.qui_tab_conversation_simple_dark), valueOf4));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183049l, hashMap);
        HashMap<String, Pair<Integer, Integer>> hashMap2 = new HashMap<>();
        String str3 = f184607f;
        Integer valueOf5 = Integer.valueOf(R.drawable.qui_tab_contact_default);
        Integer valueOf6 = Integer.valueOf(R.drawable.qui_tab_contact_default_pressed);
        hashMap2.put(str3, new Pair<>(valueOf5, valueOf6));
        hashMap2.put(f184611j, new Pair<>(Integer.valueOf(R.drawable.qui_tab_contact_vas), valueOf6));
        hashMap2.put(f184608g, new Pair<>(Integer.valueOf(R.drawable.qui_tab_contact_default_dark), valueOf6));
        String str4 = f184609h;
        Integer valueOf7 = Integer.valueOf(R.drawable.qui_tab_contact_simple);
        Integer valueOf8 = Integer.valueOf(R.drawable.qui_tab_contact_simple_pressed);
        hashMap2.put(str4, new Pair<>(valueOf7, valueOf8));
        hashMap2.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.qui_tab_contact_simple_dark), valueOf8));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183050m, hashMap2);
        HashMap<String, Pair<Integer, Integer>> hashMap3 = new HashMap<>();
        String str5 = f184607f;
        Integer valueOf9 = Integer.valueOf(R.drawable.qui_tab_activity_default);
        Integer valueOf10 = Integer.valueOf(R.drawable.qui_tab_activity_default_pressed);
        hashMap3.put(str5, new Pair<>(valueOf9, valueOf10));
        hashMap3.put(f184611j, new Pair<>(Integer.valueOf(R.drawable.qui_tab_activity_vas), valueOf10));
        hashMap3.put(f184608g, new Pair<>(Integer.valueOf(R.drawable.qui_tab_activity_default_dark), valueOf10));
        String str6 = f184609h;
        Integer valueOf11 = Integer.valueOf(R.drawable.qui_tab_activity_simple);
        Integer valueOf12 = Integer.valueOf(R.drawable.qui_tab_activity_simple_pressed);
        hashMap3.put(str6, new Pair<>(valueOf11, valueOf12));
        hashMap3.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.qui_tab_activity_simple_dark), valueOf12));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183052o, hashMap3);
        HashMap<String, Pair<Integer, Integer>> hashMap4 = new HashMap<>();
        String str7 = f184607f;
        Integer valueOf13 = Integer.valueOf(R.drawable.skin_tab_icon_see_normal);
        Integer valueOf14 = Integer.valueOf(R.drawable.skin_tab_icon_see_selected);
        hashMap4.put(str7, new Pair<>(valueOf13, valueOf14));
        hashMap4.put(f184611j, new Pair<>(valueOf13, valueOf14));
        hashMap4.put(f184608g, new Pair<>(Integer.valueOf(R.drawable.osx), valueOf14));
        String str8 = f184609h;
        Integer valueOf15 = Integer.valueOf(R.drawable.skin_tab_icon_see_normal_simple);
        Integer valueOf16 = Integer.valueOf(R.drawable.skin_tab_icon_see_selected_simple);
        hashMap4.put(str8, new Pair<>(valueOf15, valueOf16));
        hashMap4.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.os_), valueOf16));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183054q, hashMap4);
        HashMap<String, Pair<Integer, Integer>> hashMap5 = new HashMap<>();
        String str9 = f184607f;
        Integer valueOf17 = Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_default);
        Integer valueOf18 = Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_default_pressed);
        hashMap5.put(str9, new Pair<>(valueOf17, valueOf18));
        hashMap5.put(f184611j, new Pair<>(Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_vas), valueOf18));
        String str10 = f184608g;
        Integer valueOf19 = Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_default_dark);
        hashMap5.put(str10, new Pair<>(valueOf19, valueOf18));
        hashMap5.put(f184612k, new Pair<>(valueOf19, Integer.valueOf(R.drawable.kfj)));
        String str11 = f184609h;
        Integer valueOf20 = Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_simple);
        Integer valueOf21 = Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_simple_pressed);
        hashMap5.put(str11, new Pair<>(valueOf20, valueOf21));
        hashMap5.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.qui_tab_new_btm_small_world_simple_dark), valueOf21));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183055r, hashMap5);
        HashMap<String, Pair<Integer, Integer>> hashMap6 = new HashMap<>();
        String str12 = f184607f;
        Integer valueOf22 = Integer.valueOf(R.drawable.qui_tab_meta_dream_default);
        Integer valueOf23 = Integer.valueOf(R.drawable.qui_tab_meta_dream_default_pressed);
        hashMap6.put(str12, new Pair<>(valueOf22, valueOf23));
        hashMap6.put(f184611j, new Pair<>(Integer.valueOf(R.drawable.qui_tab_meta_dream_vas), valueOf23));
        hashMap6.put(f184608g, new Pair<>(Integer.valueOf(R.drawable.qui_tab_meta_dream_default_dark), valueOf23));
        String str13 = f184609h;
        Integer valueOf24 = Integer.valueOf(R.drawable.qui_tab_meta_dream_simple);
        Integer valueOf25 = Integer.valueOf(R.drawable.qui_tab_meta_dream_simple_pressed);
        hashMap6.put(str13, new Pair<>(valueOf24, valueOf25));
        hashMap6.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.qui_tab_meta_dream_simple_dark), valueOf25));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183057t, hashMap6);
        HashMap<String, Pair<Integer, Integer>> hashMap7 = new HashMap<>();
        String str14 = f184607f;
        Integer valueOf26 = Integer.valueOf(R.drawable.qui_tab_guild_default);
        Integer valueOf27 = Integer.valueOf(R.drawable.qui_tab_guild_default_pressed);
        hashMap7.put(str14, new Pair<>(valueOf26, valueOf27));
        hashMap7.put(f184611j, new Pair<>(Integer.valueOf(R.drawable.qui_tab_guild_vas), valueOf27));
        hashMap7.put(f184608g, new Pair<>(Integer.valueOf(R.drawable.qui_tab_guild_default_dark), valueOf27));
        hashMap7.put(f184609h, new Pair<>(Integer.valueOf(R.drawable.qui_tab_guild_simple), Integer.valueOf(R.drawable.qui_tab_guild_simple_pressed)));
        hashMap7.put(f184610i, new Pair<>(Integer.valueOf(R.drawable.qui_tab_guild_simple_dark), Integer.valueOf(R.drawable.qui_tab_guild_simple_pressed)));
        f184615n.put(com.tencent.mobileqq.activity.home.impl.b.f183056s, hashMap7);
    }

    private boolean A() {
        if (c.i() || this.f184617b) {
            return true;
        }
        if (ThemeUtil.isVasDarkTheme() && uq3.c.t()) {
            return true;
        }
        return false;
    }

    private void B(FrameFragment frameFragment) {
        if (frameFragment == null || frameFragment.mTabBlurView == null || this.f184619d == null) {
            return;
        }
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d("QCircleThemeUtils", 1, "[unregisterTabBlurAttachedState] unregister tab blur attached state.");
        }
        frameFragment.mTabBlurView.removeOnAttachStateChangeListener(this.f184619d);
        this.f184619d = null;
    }

    private void C(FrameFragment frameFragment) {
        try {
            QFSSmallWindowGlobalCollect.k().o(QCircleInjectImpl.b0(frameFragment));
        } catch (Throwable th5) {
            QLog.e("QCircleThemeUtils", 1, "[updateBusinessIndex] ex: ", th5);
        }
    }

    private static boolean D() {
        com.tencent.mobileqq.activity.home.impl.d dVar = f184614m;
        if (dVar == null) {
            TabDragAnimationView.setIsQCircleLayerMode(false);
            QLog.d("QCircleThemeUtils", 1, "sInitBean is empty");
            return false;
        }
        if (!dVar.c(TabDataHelper.TAB_NEW_WORLD)) {
            TabDragAnimationView.setIsQCircleLayerMode(false);
            QLog.d("QCircleThemeUtils", 1, "sInitBean no qCircle");
            return false;
        }
        if (!f184614m.e()) {
            TabDragAnimationView.setIsQCircleLayerMode(false);
            QLog.d("QCircleThemeUtils", 1, "sInitBean not layerMode");
            return false;
        }
        TabDragAnimationView.setIsQCircleLayerMode(true);
        return true;
    }

    private void a(TextView textView, boolean z16, boolean z17, boolean z18) {
        if (!QQTheme.isCustomTheme("", false) && !z17) {
            if (z16) {
                textView.setTextColor(o(BaseApplication.getContext().getResources()));
                return;
            } else if (z18) {
                textView.setTextColor(Color.parseColor("#0071FF"));
                return;
            } else {
                textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f158017al3));
                return;
            }
        }
        if (A() && this.f184617b) {
            textView.setTextColor(Color.parseColor("#0099ff"));
        } else {
            textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.qui_common_brand_standard));
        }
    }

    private void b(String[] strArr, String str, TabDragAnimationView tabDragAnimationView, TextView textView, boolean z16, boolean z17) {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsDefault = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        HashMap<String, Pair<Integer, Integer>> hashMap = f184615n.get(str);
        boolean t16 = t(str);
        float textSize = textView.getTextSize();
        if (TabDragAnimationView.t()) {
            h(tabDragAnimationView, str, j(z17, hashMap, t16), z17, textSize);
            boolean Y4 = uq3.c.Y4();
            if (z17) {
                if (this.f184617b && !Y4) {
                    tabDragAnimationView.setEnableLottie(true);
                    tabDragAnimationView.setPressChanged(z16);
                } else {
                    tabDragAnimationView.setEnableLottie(false);
                }
            } else if (t16 && Y4) {
                tabDragAnimationView.setEnableLottie(false);
                tabDragAnimationView.setPressChanged(z16);
            } else {
                tabDragAnimationView.setEnableLottie(true);
                tabDragAnimationView.setPressChanged(z16);
                if (z16 || (str.equals(this.f184618c) && !t(this.f184618c))) {
                    tabDragAnimationView.D();
                }
            }
            this.f184618c = str;
            tabDragAnimationView.invalidate();
        } else if (isNowThemeIsSimple) {
            h(tabDragAnimationView, str, n(z16, z17, hashMap, t16), z17, textSize);
        } else if (!isNowThemeIsDefault && !isNowThemeIsNight) {
            Pair<Integer, Integer> m3 = m(l(strArr, str), z17, hashMap, t16);
            if (((Integer) m3.first).intValue() == f184613l || ((Integer) m3.second).intValue() == f184613l) {
                m3 = j(z17, hashMap, t16);
            }
            h(tabDragAnimationView, str, m3, z17, textSize);
        } else {
            h(tabDragAnimationView, str, j(z17, hashMap, t16), z17, textSize);
        }
        f(textView, t16, z17, z16);
        e(textView, t16);
        textView.setVisibility(0);
    }

    private void c(FrameFragment frameFragment) {
        Object obj;
        if (frameFragment != null && (obj = frameFragment.mTabHost) != null) {
            View findViewById = ((ViewGroup) obj).findViewById(af.f());
            if (findViewById == null) {
                QLog.d("QCircleThemeUtils", 1, "changeTabHostBackGround failed NO widget");
                return;
            }
            boolean u16 = u(frameFragment.getCurrentTabName(), com.tencent.mobileqq.activity.home.impl.b.F, com.tencent.mobileqq.activity.home.impl.b.f183055r);
            if (u16) {
                q(frameFragment, findViewById);
            } else {
                w(frameFragment, findViewById);
                B(frameFragment);
            }
            SimpleModeHelper.v(u16, ((ViewGroup) frameFragment.mTabHost).findViewById(R.id.f916655s));
            return;
        }
        QLog.d("QCircleThemeUtils", 1, "changeTabHostBackGround failed");
    }

    private void d(FrameFragment frameFragment) {
        boolean z16;
        if (frameFragment == null) {
            QLog.i("QCircleThemeUtils", 1, "initFlashShowTab remove flashShow");
            return;
        }
        String currentTabName = frameFragment.getCurrentTabName();
        TabViewMap tabViewMap = frameFragment.mTabViewMap;
        if (tabViewMap == null) {
            return;
        }
        int size = frameFragment.mTabHostTabListWithOrder.size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = com.tencent.mobileqq.activity.home.impl.b.b(frameFragment.mTabHostTabListWithOrder.get(i3).getTag());
        }
        Iterator<Map.Entry<String, View>> it = tabViewMap.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            if (value != null) {
                TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) value.findViewById(R.id.j_k);
                TextView textView = (TextView) value.findViewById(R.id.kbi);
                if (tabDragAnimationView != null && textView != null) {
                    String p16 = p(value, textView);
                    if (f184615n.containsKey(p16)) {
                        boolean u16 = u(currentTabName, com.tencent.mobileqq.activity.home.impl.b.k(p16), p16);
                        if (!TextUtils.isEmpty(currentTabName) && currentTabName.equals(com.tencent.mobileqq.activity.home.impl.b.F)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        b(strArr, p16, tabDragAnimationView, textView, u16, z16);
                    }
                }
            }
        }
    }

    private void e(TextView textView, boolean z16) {
        if (z16 && textView != null) {
            textView.setText(uq3.c.O3());
        }
    }

    private void f(TextView textView, boolean z16, boolean z17, boolean z18) {
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsDefault = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        if (z16 && z17) {
            a(textView, isNowThemeIsSimple, isNowThemeIsDefault, isNowThemeIsNight);
            return;
        }
        if (!z16 && z18) {
            textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.qui_common_brand_standard));
        } else if (z17) {
            if (A()) {
                textView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f156965gb));
            } else {
                textView.setTextColor(TabDragAnimationView.o(BaseApplicationImpl.getApplication().getResources()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:3:0x0002, B:5:0x0023, B:6:0x003b, B:8:0x0058, B:10:0x005e, B:12:0x0064, B:18:0x0074, B:19:0x0078, B:21:0x007e, B:23:0x0082, B:24:0x0089, B:26:0x0091, B:30:0x009b), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:3:0x0002, B:5:0x0023, B:6:0x003b, B:8:0x0058, B:10:0x005e, B:12:0x0064, B:18:0x0074, B:19:0x0078, B:21:0x007e, B:23:0x0082, B:24:0x0089, B:26:0x0091, B:30:0x009b), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:3:0x0002, B:5:0x0023, B:6:0x003b, B:8:0x0058, B:10:0x005e, B:12:0x0064, B:18:0x0074, B:19:0x0078, B:21:0x007e, B:23:0x0082, B:24:0x0089, B:26:0x0091, B:30:0x009b), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(TabDragAnimationView tabDragAnimationView, String str, Pair<Integer, Integer> pair, boolean z16, float f16) {
        boolean z17;
        int i3;
        int i16;
        try {
            tabDragAnimationView.setBgPressedDrawable(((Integer) pair.second).intValue());
            tabDragAnimationView.setBgDrawable(((Integer) pair.first).intValue());
            int i17 = -1;
            if (((Integer) pair.first).intValue() != -1) {
                i17 = BaseApplication.getContext().getResources().getDrawable(((Integer) pair.first).intValue()).getIntrinsicWidth();
            }
            float f17 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
            if (!ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null) && !QQTheme.isNowSimpleUI() && !QQTheme.isBaseDIYTheme() && !QQTheme.isNowThemeIsNight()) {
                z17 = false;
                if (z17) {
                    i17 = (int) ((f17 * 29.0f) + 0.5f);
                }
                if (TabDragAnimationView.t()) {
                    i17 = (int) (29.0f * f17);
                }
                if (!z17) {
                    i3 = (int) ((f17 * 5.0f) + 0.5f);
                } else {
                    i3 = 0;
                }
                tabDragAnimationView.setPadding(0, i3, 0, i3);
                tabDragAnimationView.setIconSize(i17, i17);
                if (!z17 && !TabDragAnimationView.t()) {
                    i16 = 0;
                    tabDragAnimationView.setIconGravity(i16);
                }
                i16 = 1;
                tabDragAnimationView.setIconGravity(i16);
            }
            z17 = true;
            if (z17) {
            }
            if (TabDragAnimationView.t()) {
            }
            if (!z17) {
            }
            tabDragAnimationView.setPadding(0, i3, 0, i3);
            tabDragAnimationView.setIconSize(i17, i17);
            if (!z17) {
                i16 = 0;
                tabDragAnimationView.setIconGravity(i16);
            }
            i16 = 1;
            tabDragAnimationView.setIconGravity(i16);
        } catch (Exception e16) {
            QLog.e("QCircleThemeUtils", 1, e16, new Object[0]);
        }
    }

    private Pair<Integer, Integer> j(boolean z16, HashMap<String, Pair<Integer, Integer>> hashMap, boolean z17) {
        Pair<Integer, Integer> pair;
        int intValue;
        int intValue2;
        if (z16 && A()) {
            if (z17) {
                pair = hashMap.get(f184612k);
            } else {
                pair = hashMap.get(f184608g);
            }
        } else {
            pair = hashMap.get(f184607f);
        }
        int i3 = -1;
        if (pair == null) {
            intValue = -1;
        } else {
            intValue = ((Integer) pair.first).intValue();
        }
        if (pair == null) {
            intValue2 = -1;
        } else {
            intValue2 = ((Integer) pair.second).intValue();
        }
        if (pair != null) {
            i3 = pair.hashCode();
        }
        if (!this.f184620e.contains(Integer.valueOf(i3))) {
            QLog.d("QCircleThemeUtils", 1, "[getDefaultIconPair] normalId: " + intValue + " | normalName: " + k(intValue) + " | pressedId: " + intValue2 + " | pressedName: " + k(intValue2));
            this.f184620e.add(Integer.valueOf(i3));
        }
        return pair;
    }

    private String k(int i3) {
        Resources resources;
        Application application = RFWApplication.getApplication();
        if (application == null) {
            resources = null;
        } else {
            resources = application.getResources();
        }
        if (resources != null && i3 != -1) {
            return resources.getResourceEntryName(i3);
        }
        return "null";
    }

    private Pair<Integer, Integer> l(String[] strArr, String str) {
        int i3;
        int i16 = f184613l;
        Pair<Integer, Integer> h16 = com.tencent.mobileqq.activity.home.impl.b.h(strArr, str);
        if (h16 != null) {
            i16 = ((Integer) h16.first).intValue();
            i3 = ((Integer) h16.second).intValue();
        } else {
            i3 = i16;
        }
        return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    private Pair<Integer, Integer> m(Pair<Integer, Integer> pair, boolean z16, HashMap<String, Pair<Integer, Integer>> hashMap, boolean z17) {
        if (z16) {
            if (z17) {
                if (A() && this.f184617b) {
                    return hashMap.get(f184612k);
                }
                return hashMap.get(f184611j);
            }
            if (A()) {
                return hashMap.get(f184608g);
            }
            return hashMap.get(f184611j);
        }
        return pair;
    }

    private Pair<Integer, Integer> n(boolean z16, boolean z17, HashMap<String, Pair<Integer, Integer>> hashMap, boolean z18) {
        Pair<Integer, Integer> pair;
        if (z17 && A()) {
            pair = hashMap.get(f184610i);
        } else {
            pair = hashMap.get(f184609h);
        }
        if (pair != null) {
            ((Integer) pair.first).intValue();
        }
        if (pair != null) {
            ((Integer) pair.second).intValue();
        }
        return pair;
    }

    private int o(Resources resources) {
        if (resources == null) {
            QLog.e("TabDragAnimationView", 1, "getTabTextViewColor called error: resources == null");
            return Color.parseColor("#000000");
        }
        String currentThemeId = QQTheme.getCurrentThemeId();
        if (TextUtils.isEmpty(currentThemeId)) {
            return resources.getColor(R.color.skin_tab_selected_blue);
        }
        if (QQTheme.SIMPLE_THEME_IDS.contains(currentThemeId)) {
            return resources.getColor(R.color.skin_color_tab_simple_selected);
        }
        return resources.getColor(R.color.skin_tab_selected_blue);
    }

    private String p(View view, TextView textView) {
        String charSequence;
        String str = (String) textView.getTag();
        if (TextUtils.equals(str, com.tencent.mobileqq.activity.home.impl.b.f183056s)) {
            return str;
        }
        if (textView.getText() == null) {
            charSequence = "";
        } else {
            charSequence = textView.getText().toString();
        }
        if (charSequence.equals(uq3.c.O3())) {
            charSequence = com.tencent.mobileqq.activity.home.impl.b.f183055r;
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (view instanceof RedTouchTab) {
                return (String) ((RedTouchTab) view).getTarget().getContentDescription();
            }
            if (view instanceof RedTouch) {
                return (String) ((RedTouch) view).getTarget().getContentDescription();
            }
            return charSequence;
        }
        return charSequence;
    }

    private void q(@NonNull FrameFragment frameFragment, @NonNull View view) {
        int i3;
        frameFragment.disableBlur(view);
        frameFragment.pauseTabBlur();
        QQBlurViewWrapper qQBlurViewWrapper = frameFragment.mTabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.setEnableBlur(false);
            frameFragment.mTabBlurView.setVisibility(8);
        }
        x(frameFragment);
        if (c.i()) {
            view.setBackground(new ColorDrawable(-16777216));
            QLog.d("QCircleThemeUtils", 1, "isNowFlatState, set back ground black");
            return;
        }
        if (!this.f184617b) {
            QBaseActivity baseActivity = frameFragment.getBaseActivity();
            if (baseActivity != null) {
                QUIImmersiveHelper.s(baseActivity, true, true);
            }
            view.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.qui_common_bg_middle_light));
            QLog.d("QCircleThemeUtils", 1, "set back ground middle_light");
            return;
        }
        if (A()) {
            view.setBackground(new ColorDrawable(-16777216));
            QLog.d("QCircleThemeUtils", 1, "set back ground black");
            return;
        }
        Resources resources = view.getResources();
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.color.can;
        } else {
            i3 = R.color.cam;
        }
        view.setBackgroundColor(resources.getColor(i3));
        QLog.d("QCircleThemeUtils", 1, "set back ground middle_qq_theme");
    }

    public static void s(com.tencent.mobileqq.activity.home.impl.d dVar) {
        f184614m = dVar;
        QLog.i("QCircleThemeUtils", 1, "init isQCircleLayerMode:" + D());
    }

    private boolean t(String str) {
        return com.tencent.mobileqq.activity.home.impl.b.f183055r.equals(str);
    }

    private void w(FrameFragment frameFragment, View view) {
        View view2 = frameFragment.mRootView;
        if (view2 == null) {
            return;
        }
        View findViewById = view2.findViewById(af.b());
        QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) frameFragment.mRootView.findViewById(R.id.kmr);
        frameFragment.mTabBlurView = qQBlurViewWrapper;
        if (qQBlurViewWrapper != null && findViewById != null) {
            qQBlurViewWrapper.setDebugTag("TAB");
            frameFragment.mTabBlurView.setVisibility(8);
            frameFragment.mTabBlurView.onPause();
            frameFragment.mTabBlurView.onDestroy();
            if (frameFragment.enableBlur()) {
                frameFragment.enableBlur(view, findViewById);
                frameFragment.resumeTabBlur();
                frameFragment.mTabBlurView.setEnableBlur(true);
            } else {
                frameFragment.disableBlur(view);
                frameFragment.pauseTabBlur();
                frameFragment.mTabBlurView.setEnableBlur(false);
            }
            frameFragment.mTabBlurView.setVisibility(0);
        }
    }

    private void x(FrameFragment frameFragment) {
        if (frameFragment != null && frameFragment.mTabBlurView != null) {
            if (QLog.isColorLevel() || QLog.isDebugVersion()) {
                QLog.d("QCircleThemeUtils", 1, "[registerTabBlurAttachedState] register tab blur attached state.");
            }
            a aVar = new a(frameFragment);
            this.f184619d = aVar;
            frameFragment.mTabBlurView.addOnAttachStateChangeListener(aVar);
        }
    }

    public void g(FrameFragment frameFragment) {
        if (!D()) {
            return;
        }
        d(frameFragment);
        c(frameFragment);
        C(frameFragment);
    }

    public int i() {
        return ie0.a.f().g(RFWApplication.getApplication(), R.color.qui_common_bg_bottom_standard, 1000);
    }

    public boolean r() {
        if (this.f184616a != i()) {
            return true;
        }
        return false;
    }

    public boolean u(String str, String str2, String str3) {
        if (str3.equals(com.tencent.mobileqq.activity.home.impl.b.f183052o)) {
            if (!str.equals(com.tencent.mobileqq.activity.home.impl.b.B) && !str.equals(com.tencent.mobileqq.activity.home.impl.b.C)) {
                return false;
            }
            return true;
        }
        if (str3.equals(com.tencent.mobileqq.activity.home.impl.b.f183054q)) {
            if (!str.equals(com.tencent.mobileqq.activity.home.impl.b.D) && !str.equals(com.tencent.mobileqq.activity.home.impl.b.E)) {
                return false;
            }
            return true;
        }
        return str.equals(str2);
    }

    public void v(boolean z16, boolean z17) {
        if (!z16 && z17) {
            z(true);
        }
    }

    public void y(int i3) {
        this.f184616a = i3;
    }

    public void z(boolean z16) {
        this.f184617b = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(api = 12)
    /* loaded from: classes10.dex */
    public static class a implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<FrameFragment> f184621d;

        public a(FrameFragment frameFragment) {
            this.f184621d = new WeakReference<>(frameFragment);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameFragment frameFragment;
            WeakReference<FrameFragment> weakReference = this.f184621d;
            if (weakReference == null) {
                frameFragment = null;
            } else {
                frameFragment = weakReference.get();
            }
            if (frameFragment == null) {
                return;
            }
            if (QLog.isColorLevel() || QLog.isDebugVersion()) {
                QLog.d("QCircleThemeUtils", 1, "[onViewAttachedToWindow] attach window pause tab blur.");
            }
            frameFragment.pauseTabBlur();
            QQBlurViewWrapper qQBlurViewWrapper = frameFragment.mTabBlurView;
            if (qQBlurViewWrapper != null) {
                qQBlurViewWrapper.setEnableBlur(false);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
