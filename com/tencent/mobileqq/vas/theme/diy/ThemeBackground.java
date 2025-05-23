package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.android.gldrawable.api.VideoOptions;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settingme.QQSettingMeBackgroundView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.theme.SkinEngine;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeBackground {
    public static final int AVATAR_BG_ID = 47967;
    public static final int BG_TYPE_AIO = 2;
    public static final int BG_TYPE_CONVERSATION = 1;
    public static final int BG_TYPE_DYNAMIC = 4;
    public static final int BG_TYPE_FRIEND = 3;
    public static final int BG_TYPE_SETTING = 0;
    public static final String DIY_DEFAULT_BG_ID = "100";
    public static final String DIY_UPLOAD_BG_ID = "99";
    public static final int PAGE_INDEX_MSG = 100;
    static final String TAG = "ThemeBackground";
    public static boolean needUpdateThemeForBg;
    public Drawable img;
    public boolean isAnimateBg;
    public boolean isDecodeInDiy;
    public boolean isNeedImg = true;
    public int pageIndex;
    public String path;
    public ImageView.ScaleType scaleType;
    public static BusinessFlag sAIOBusinessFlag = new BusinessFlag(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
    public static BusinessFlag sRecentBusinessFlag = new BusinessFlag("RECENT");
    private static boolean fixAnrBug = VasNormalToggle.BUG_115132569.isEnable(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f310917d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ThemeBackground f310918e;

        a(int i3, ThemeBackground themeBackground) {
            this.f310917d = i3;
            this.f310918e = themeBackground;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (QLog.isColorLevel()) {
                QLog.d(ThemeBackground.TAG, 2, "onLayoutChange bgType:" + this.f310917d + " isAnimate:" + ThemeUtil.isHorizontalAnimate() + " view width:" + view.getWidth() + " height:" + view.getHeight());
            }
            if (view.getHeight() > 0) {
                view.removeOnLayoutChangeListener(this);
                ThemeBackground.setThemeDrawArea(view, this.f310917d, this.f310918e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Function0<Drawable> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f310920e;

        b(String str) {
            this.f310920e = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke() {
            return VasApngUtil.getApngDrawable(null, ThemeBackground.this.path, "-setting-", BaseApplication.getContext().getResources().getDrawable(R.drawable.qq_setting_me_bg), new int[]{1}, this.f310920e, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements Function0<Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f310921d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ThemeBackground f310922e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f310923f;

        c(boolean z16, ThemeBackground themeBackground, String str) {
            this.f310921d = z16;
            this.f310922e = themeBackground;
            this.f310923f = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke() {
            if (this.f310921d) {
                ThemeBackground.sRecentBusinessFlag.setUseApng();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_use_rect", true);
            return VasApngUtil.getApngDrawable(null, this.f310922e.path, "-conversation-", BaseApplication.getContext().getResources().getDrawable(R.drawable.bg_texture_theme_version2), VasApngUtil.converstionTag, this.f310923f, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements Function0<Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f310924d;

        d(Drawable drawable) {
            this.f310924d = drawable;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke() {
            return this.f310924d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements Function1<IFactoryStub, Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoOptions f310925d;

        e(VideoOptions videoOptions) {
            this.f310925d = videoOptions;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke(IFactoryStub iFactoryStub) {
            iFactoryStub.useCache(true);
            return iFactoryStub.fromBundle(this.f310925d.toBundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements Function0<Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f310926d;

        f(int i3) {
            this.f310926d = i3;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke() {
            if (this.f310926d > 0) {
                return BaseApplication.getContext().getResources().getDrawable(this.f310926d);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class g implements Function1<IFactoryStub, Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f310927d;

        g(File file) {
            this.f310927d = file;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke(IFactoryStub iFactoryStub) {
            return iFactoryStub.useCache(true).fromFile(this.f310927d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h implements Function1<IFactoryStub, Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f310928d;

        h(String str) {
            this.f310928d = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke(IFactoryStub iFactoryStub) {
            return iFactoryStub.useCache(true).fromFile(new File(this.f310928d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applySettingMeVipNumber(View view) {
        AppRuntime peekAppRuntime;
        if (!(view instanceof QQSettingMeBackgroundView) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        try {
            ((QQSettingMeBackgroundView) view).setVipNumberInfo(peekAppRuntime.getAccount(), Integer.parseInt(QQTheme.getCurrentThemeId()));
        } catch (Exception e16) {
            QLog.e(VasLogNtReporter.getVipNumber().getReportTag(), 1, e16, new Object[0]);
        }
    }

    public static void applyThemeBg(final AppRuntime appRuntime, final View view, final int i3, final int i16, final String str) {
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "applyThemeBg view is null,  animateName:" + str + " byType:" + i3);
                return;
            }
            return;
        }
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            QLog.d("TAG", 2, "ThemeBackground useNativeThemeVideoPlayer return");
            if (i3 == 0) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.diy.ThemeBackground.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ThemeBackground.applySettingMeVipNumber(view);
                    }
                });
                return;
            }
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.diy.ThemeBackground.9
            @Override // java.lang.Runnable
            public void run() {
                AppRuntime appRuntime2 = AppRuntime.this;
                final ThemeBackground themeBgObj = ThemeBackground.getThemeBgObj(appRuntime2, appRuntime2.getApplication().getApplicationContext(), i3, str, i16);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.diy.ThemeBackground.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable;
                        if (i3 == 1 && QQTheme.isNowThemeIsNight()) {
                            if (QLog.isColorLevel()) {
                                QLog.e(ThemeBackground.TAG, 2, "applyThemeBg set conversation Night bg BLACK");
                            }
                            view.setBackgroundColor(-16777216);
                            return;
                        }
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        if (i3 == 0) {
                            ThemeBackground.applySettingMeVipNumber(view);
                        }
                        if (!"null".equals(themeBgObj.path)) {
                            ThemeBackground themeBackground = themeBgObj;
                            if (themeBackground.img != null) {
                                AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                                ThemeBackground.setBackGrooundImg(view, themeBackground, i16, i3);
                                if (!(view instanceof ImageView) && QLog.isColorLevel() && (drawable = ((ImageView) view).getDrawable()) != null) {
                                    cn.h(drawable);
                                    return;
                                }
                                return;
                            }
                        }
                        Object tag = view.getTag();
                        if (tag instanceof ThemeBackground) {
                            Drawable drawable2 = ((ThemeBackground) tag).img;
                            if (drawable2 instanceof IGLDrawable) {
                                ((IGLDrawable) drawable2).recycle();
                            }
                        }
                        themeBgObj.img = null;
                        view.setTag(null);
                        AnonymousClass9 anonymousClass93 = AnonymousClass9.this;
                        View view2 = view;
                        if (view2 instanceof ImageView) {
                            ((ImageView) view2).setImageResource(i16);
                            ImageView.ScaleType scaleType = themeBgObj.scaleType;
                            if (scaleType != null) {
                                ((ImageView) view).setScaleType(scaleType);
                            }
                        } else {
                            IVasDepTemp iVasDepTemp = (IVasDepTemp) QRoute.api(IVasDepTemp.class);
                            AnonymousClass9 anonymousClass94 = AnonymousClass9.this;
                            if (!iVasDepTemp.setContentBackground(view, i16)) {
                                AnonymousClass9 anonymousClass95 = AnonymousClass9.this;
                                View view3 = view;
                                if (view3 instanceof FPSSwipListView) {
                                    ((FPSSwipListView) view3).setContentBackground(i16);
                                } else {
                                    view3.setBackground(view3.getContext().getDrawable(i16));
                                    QLog.d(ThemeBackground.TAG, 1, "applyThemeBg use defaultBgResId");
                                }
                            }
                        }
                        if (!(view instanceof ImageView)) {
                        }
                    }
                });
            }
        }, 8, null, true);
    }

    public static float[] calThemeDrawArea(float f16, float f17, float f18, int i3) {
        float f19;
        float f26;
        float f27 = 0.0f;
        float f28 = 0.5f;
        if (i3 != 0) {
            float f29 = f17 / f16;
            if (f29 == 1.7777778f) {
                f19 = 1.0f;
                f26 = 1.0f;
            } else if (f29 > 1.7777778f) {
                f26 = 1.0f - ((1.0f - ((f16 / f17) / 0.5625f)) * 0.5f);
                f19 = 1.0f;
            } else {
                f27 = (1.0f - (f29 / 1.7777778f)) / 2.0f;
                f19 = 1.0f - f27;
                f26 = 1.0f;
            }
        } else {
            float f36 = f17 / f16;
            if (f36 == 1.7777778f) {
                f26 = 0.5f;
                f19 = 1.0f;
                f28 = 0.0f;
            } else if (f36 > 1.7777778f) {
                f26 = 0.5f;
                f28 = (1.0f - ((f16 / f17) / 0.5625f)) * 0.5f;
                f19 = 1.0f;
            } else {
                float f37 = (1.0f - (f36 / 1.7777778f)) / 2.0f;
                f27 = f37;
                f19 = 1.0f - f37;
                f26 = 0.5f;
                f28 = 0.0f;
            }
        }
        return new float[]{f28, f27 + ((f19 - f27) * (1.0f - ((f18 * 1.0f) / f17))), f26, f19};
    }

    public static void clear(Context context, String str, String str2) {
        if (str == null) {
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences(context, str2, 4).edit();
        edit.putString(str, "null");
        edit.putBoolean(str + ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, false);
        edit.commit();
    }

    private static void dealNowDiyTheme(AppRuntime appRuntime, Context context, int i3, ThemeBackground themeBackground) {
        Drawable drawable;
        String str;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        getThemeBackground(context, AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH_PNG, appRuntime.getAccount(), themeBackground);
                        if (themeBackground.img == null) {
                            getThemeBackground(context, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, appRuntime.getAccount(), themeBackground);
                            return;
                        }
                        return;
                    }
                    return;
                }
                getThemeBackground(context, AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH_PNG, appRuntime.getAccount(), themeBackground);
                if (themeBackground.img == null) {
                    getThemeBackground(context, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, appRuntime.getAccount(), themeBackground);
                    return;
                }
                return;
            }
            getThemeBackground(context, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, appRuntime.getAccount(), themeBackground);
            return;
        }
        getThemeBackground(context, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG, appRuntime.getAccount(), themeBackground);
        if (themeBackground.img != null) {
            if (isSettingBaseDiyTheme(AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG) && (str = themeBackground.path) != null && str.contains("qq_setting_me_bg")) {
                drawable = new ColorDrawable();
            } else {
                drawable = appRuntime.getApplication().getApplicationContext().getResources().getDrawable(R.drawable.apj);
            }
            themeBackground.img = new LayerDrawable(new Drawable[]{themeBackground.img, drawable});
        }
    }

    private static void dealNowIsAnimatorTheme(AppRuntime appRuntime, Context context, int i3, String str, int i16, ThemeBackground themeBackground, boolean z16) {
        themeBackground.isAnimateBg = true;
        String str2 = "qq_skin_drawer_conversation.mp4";
        if (i3 != 0) {
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                if (z16) {
                    sRecentBusinessFlag.setUseVideo();
                }
                String animatePathByTag = ThemeUtil.getAnimatePathByTag(2);
                themeBackground.path = animatePathByTag;
                if (!ThemeUtil.isHorizontalAnimate()) {
                    str2 = "qq_skin_conversation.mp4";
                }
                Drawable dynamicDrawable = getDynamicDrawable(animatePathByTag, str2, i16);
                themeBackground.img = dynamicDrawable;
                if (dynamicDrawable == null) {
                    if (z16) {
                        sRecentBusinessFlag.setUseAETC();
                    }
                    themeBackground.img = getGLDrawableDrawable(themeBackground.path, new c(z16, themeBackground, str));
                }
                Drawable drawable = themeBackground.img;
                if (drawable instanceof IGLDrawable) {
                    ((IGLDrawable) drawable).setLockWH(true);
                    return;
                }
                return;
            }
            return;
        }
        String animatePathByTag2 = ThemeUtil.getAnimatePathByTag(1);
        themeBackground.path = animatePathByTag2;
        if (!ThemeUtil.isHorizontalAnimate()) {
            str2 = "qq_skin_drawer.mp4";
        }
        Drawable dynamicDrawable2 = getDynamicDrawable(animatePathByTag2, str2, i16);
        themeBackground.img = dynamicDrawable2;
        if (dynamicDrawable2 == null) {
            themeBackground.img = getGLDrawableDrawable(themeBackground.path, new b(str));
        }
    }

    private static void dealOldDiyTheme(Context context, ThemeBackground themeBackground, String str, String str2) {
        boolean z16;
        boolean z17 = true;
        if ("999".equals(str) && Integer.parseInt(str2) < Integer.parseInt("20000000")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || "999".equals(str) || Integer.parseInt(str) >= 5010) {
            z17 = false;
        }
        QLog.d(TAG, 2, "getThemeBackground setting old ,oldDefualtDiy=" + z16 + ",otherOldDiy=" + z17 + ",id=" + str + ",ver=" + str2);
        if (z16 || z17 || isSettingBaseDiyTheme(AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG)) {
            File file = new File(SkinEngine.getInstances().getSkinRootPath() + "drawable-xhdpi/qq_setting_me_bg.png");
            if (file.exists() && file.isFile()) {
                QLog.d(TAG, 2, "getThemeBackground setting old ,already has file");
                return;
            }
            QLog.d(TAG, 2, "getThemeBackground setting old ,have no file");
            themeBackground.img = new ColorDrawable(Color.parseColor("#0EB8F6"));
            themeBackground.path = "qq_setting_me_bg.png";
        }
    }

    @Nullable
    private static Bitmap getBitmap(Context context, String str, String str2) {
        Bitmap f16 = ImageCacheHelper.f98636a.f(str2);
        if (f16 != null) {
            return f16;
        }
        File file = new File(str2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getThemeBackground_diy, bgType=" + str + ", path=" + str2 + ", exists=" + file.exists() + ", isFile=" + file.isFile());
        }
        if (file.exists() && file.isFile()) {
            return getStatisticParam(context, str, str2);
        }
        return getBitmap(context, str, str2, f16, file);
    }

    public static Drawable getDynamicDrawable(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && isSupportVideo()) {
            return GLDrawableApi.asyncFactory(new f(i3), new g(file));
        }
        return null;
    }

    public static Drawable getGLDrawableDrawable(String str, Drawable drawable) {
        if (TextUtils.isEmpty(str) || !new File(str).exists() || !isSupportVideo()) {
            return null;
        }
        VideoOptions videoOptions = new VideoOptions();
        videoOptions.setFilePath(str);
        videoOptions.setNeedThumbnail(true);
        videoOptions.setLoop(false);
        return GLDrawableApi.asyncFactory(new d(drawable), new e(videoOptions));
    }

    private static void getImgFromCache(Context context, String str, ThemeBackground themeBackground, SharedPreferences sharedPreferences, String str2, Bitmap bitmap) {
        if (bitmap != null) {
            if (AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG.equals(str)) {
                ImageCacheHelper.f98636a.i(str2, bitmap, Business.AIO);
            }
            themeBackground.path = str2;
            if (AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG.equals(str)) {
                themeBackground.img = new BitmapDrawable(context.getResources(), bitmap);
                return;
            }
            ChatBackgroundDrawable chatBackgroundDrawable = new ChatBackgroundDrawable(context.getResources(), bitmap);
            chatBackgroundDrawable.setGravity(48);
            themeBackground.img = chatBackgroundDrawable;
            return;
        }
        String string = sharedPreferences.getString(str + ThemeConstants.THEME_DIY_BG_URL_SUFFIX, null);
        if (!TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getThemeBackground, downloading, bgType=" + str + ", url=" + string + ", path=" + str2);
            }
            ResData resData = new ResData();
            resData.path = str2;
            resData.url = string;
            boolean z16 = true;
            if (!themeBackground.isDecodeInDiy) {
                if (!AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG.equals(str) && !AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH.equals(str)) {
                    resData.loadingType = 2;
                } else {
                    resData.loadingType = 1;
                }
            }
            int i3 = themeBackground.pageIndex;
            if (i3 == 100) {
                if (i3 != 100) {
                    z16 = false;
                }
                needUpdateThemeForBg = z16;
            }
            themeBackground.img = DIYThemeUtils.getDIYDrawable(context, resData, 0, 0, i3, true);
            themeBackground.path = str2;
            return;
        }
        QLog.e(TAG, 2, "getThemeBackground, use to defualt, bgType=" + str + ", path=" + str2);
        themeBackground.path = "null";
    }

    public static boolean getMarkOfAioBgFromDiy(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && AppConstants.Preferences.THEME_DIY_BG_AIO_PATH.equals(str)) {
            String string = ChatBackgroundUtil.getMMKVData(context, str2).getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, "null");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            SharedPreferences sharedPreferences = getSharedPreferences(context, str2, 0);
            String string2 = sharedPreferences.getString(str, null);
            if (!TextUtils.isEmpty(string2) && string.equals(string2)) {
                return sharedPreferences.getBoolean(str + ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, false);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [mqq.app.BaseActivity, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r13v6, types: [mqq.app.BaseActivity, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void getNewBackgroundImage(Context context, String str, ThemeBackground themeBackground, SharedPreferences sharedPreferences, String str2) {
        String str3;
        boolean z16;
        ?? r132;
        Bitmap bitmap;
        boolean z17;
        if (themeBackground.isNeedImg) {
            try {
                bitmap = getBitmap(context, str, str2);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getThemeBackground, check ,bgType=");
                    sb5.append(str);
                    sb5.append(",bg=");
                    if (bitmap != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    sb5.append(z17);
                    sb5.append(", path=");
                    sb5.append(str2);
                    QLog.d(TAG, 2, sb5.toString());
                }
                r132 = 0;
                str3 = TAG;
            } catch (Exception e16) {
                e = e16;
                r132 = 0;
                str3 = TAG;
            } catch (OutOfMemoryError e17) {
                e = e17;
                r132 = 0;
                str3 = TAG;
            }
            try {
                getImgFromCache(context, str, themeBackground, sharedPreferences, str2, bitmap);
            } catch (Exception e18) {
                e = e18;
                QLog.e(str3, 1, "getThemeBackground Err a2:" + e.getMessage());
                themeBackground.img = r132;
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_FailCode", "EE");
                    hashMap.put("param_bgType", str);
                    hashMap.put("param_themeid", ThemeUtil.getCurrentThemeId());
                    StatisticCollector.getInstance(context).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(r132).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, hashMap, "", false);
                } catch (Exception e19) {
                    QLog.e(str3, 1, "getThemeBackground :" + e19.getMessage());
                }
                if (QLog.isColorLevel()) {
                }
            } catch (OutOfMemoryError e26) {
                e = e26;
                QLog.e(str3, 1, "getThemeBackground OOM a1:" + e.getMessage());
                themeBackground.img = r132;
                try {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("param_FailCode", "OOM");
                    hashMap2.put("param_bgType", str);
                    hashMap2.put("param_themeid", ThemeUtil.getCurrentThemeId());
                    StatisticCollector.getInstance(context).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(r132).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, hashMap2, "", false);
                } catch (Exception e27) {
                    QLog.e(str3, 1, "getThemeBackground :" + e27.getMessage());
                }
                if (QLog.isColorLevel()) {
                }
            }
        } else {
            str3 = TAG;
            themeBackground.path = str2;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("getThemeBackground, bgType=");
            sb6.append(str);
            sb6.append(", path2=");
            sb6.append(themeBackground.path);
            sb6.append(", img=");
            if (themeBackground.img == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb6.append(z16);
            QLog.d(str3, 2, sb6.toString());
        }
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i3) {
        SharedPreferences theme = VipMMKV.getTheme(context, AppConstants.Preferences.THEME_DIY_BACKGROUND_PATH + str);
        if (theme.getInt("theme_background_version", 0) < 1) {
            SharedPreferences.Editor edit = theme.edit();
            String[] strArr = {AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG};
            for (int i16 = 0; i16 < 5; i16++) {
                String str2 = strArr[i16];
                String string = theme.getString(str2, null);
                if (string != null) {
                    if (string.contains("custom_background/" + str + "/")) {
                        edit.putString(str2, string.replace("custom_background/" + str + "/", "custom_background/" + DiySecureFileHelper.secureUin(str) + "/"));
                    }
                }
            }
            edit.putInt("theme_background_version", 1).commit();
        }
        return theme;
    }

    @Nullable
    private static Bitmap getStatisticParam(Context context, String str, String str2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.BRAND)) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        j.a f16 = j.f(str2, options);
        Bitmap bitmap = f16.f306778a;
        if (bitmap != null && f16.f306779b == 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getThemeBackground, decodeFileForResult ok bgType=");
            sb5.append(str);
            sb5.append(", path=");
            sb5.append(str2);
            sb5.append(", result:");
            sb5.append(f16.f306779b);
            sb5.append(",bg=");
            if (bitmap != null) {
                z26 = true;
            } else {
                z26 = false;
            }
            sb5.append(z26);
            QLog.d(TAG, 2, sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("getThemeBackground, decodeFileForResult Err0 bgType=");
            sb6.append(str);
            sb6.append(", path=");
            sb6.append(str2);
            sb6.append(", result:");
            sb6.append(f16.f306779b);
            sb6.append(",bg=");
            if (bitmap != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb6.append(z16);
            QLog.e(TAG, 2, sb6.toString());
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", "d_" + f16.f306779b);
            hashMap.put("param_bgType", str);
            hashMap.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector statisticCollector = StatisticCollector.getInstance(context);
            String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            if (bitmap != null) {
                z19 = true;
            } else {
                z19 = false;
            }
            statisticCollector.collectPerformance(account, "ThemeBackgroundDecoder", z19, 1L, 0L, hashMap, "", false);
        } catch (Exception e16) {
            QLog.e(TAG, 2, e16.getMessage());
        }
        if (f16.f306779b == 1) {
            for (int i3 = 2; i3 <= 32; i3 *= 2) {
                options.inSampleSize = i3;
                f16 = j.f(str2, options);
                bitmap = f16.f306778a;
                if (bitmap == null) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("getThemeBackground, miniDecode, bgType=");
                    sb7.append(str);
                    sb7.append(", path=");
                    sb7.append(str2);
                    sb7.append(",simpleSize=");
                    sb7.append(i3);
                    sb7.append(", bg=");
                    if (bitmap != null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    sb7.append(z18);
                    sb7.append(", result=");
                    sb7.append(f16.f306779b);
                    QLog.d(TAG, 2, sb7.toString());
                }
                if (f16.f306779b == 1) {
                }
            }
            try {
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("param_FailCode", "dd_" + f16.f306779b);
                hashMap2.put("param_themeid", ThemeUtil.getCurrentThemeId());
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(context);
                String account2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
                if (bitmap != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                statisticCollector2.collectPerformance(account2, "ThemeBackgroundDecoder", z17, 1L, 0L, hashMap2, "", false);
            } catch (Exception e17) {
                QLog.e(TAG, 2, e17.getMessage());
            }
        }
        return bitmap;
    }

    public static synchronized boolean getThemeBackground(Context context, String str, String str2, ThemeBackground themeBackground) {
        synchronized (ThemeBackground.class) {
            boolean z16 = false;
            if (themeBackground != null && str != null) {
                SharedPreferences sharedPreferences = getSharedPreferences(context, str2, 4);
                String string = sharedPreferences.getString(str, "null");
                if (string != null && string.equals("") && !isSettingBaseDiyTheme(str)) {
                    themeBackground.img = context.getResources().getDrawable(R.drawable.bg_texture_theme_version2);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getThemeBackground, bgType=");
                    sb5.append(str);
                    sb5.append("path1=");
                    sb5.append(string);
                    sb5.append(", out.isNeedImg=");
                    sb5.append(themeBackground.isNeedImg);
                    sb5.append(",out.path=");
                    sb5.append(themeBackground.path);
                    sb5.append(", img=");
                    if (themeBackground.img == null) {
                        z16 = true;
                    }
                    sb5.append(z16);
                    QLog.d(TAG, 2, sb5.toString());
                }
                return updateThemeBack(context, str, themeBackground, sharedPreferences, string);
            }
            QLog.d(TAG, 2, "getThemeBackground, bgType== null");
            return false;
        }
    }

    public static boolean getThemeBackgroundEnable() {
        return ThemeUtil.getIsDIYTheme(null);
    }

    public static String getThemeBackgroundPathByType(Context context, String str, String str2) {
        return getSharedPreferences(context, str2, 0).getString(str, "null");
    }

    public static ThemeBackground getThemeBgObj(AppRuntime appRuntime, Context context, int i3, String str, int i16) {
        ThemeBackground themeBackground = new ThemeBackground();
        if (appRuntime != null && context != null) {
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            boolean z17 = z16;
            if (z17) {
                sRecentBusinessFlag.setUseStatic();
            }
            if (ThemeUtil.isNowThemeIsDIY()) {
                dealNowDiyTheme(appRuntime, context, i3, themeBackground);
            } else if (ThemeUtil.isNowThemeIsAnimate()) {
                dealNowIsAnimatorTheme(appRuntime, context, i3, str, i16, themeBackground, z17);
            }
            return themeBackground;
        }
        QLog.i(TAG, 2, "getThemeBgObj app,context = null; animateName=" + str + ", app=" + appRuntime + ", context=" + context);
        return themeBackground;
    }

    private static void horizontalAnimateInit(int i3, ThemeBackground themeBackground, View view) {
        if (ThemeUtil.isHorizontalAnimate() && (themeBackground.img instanceof IGLDrawable)) {
            view.addOnLayoutChangeListener(new a(i3, themeBackground));
            setThemeDrawArea(view, i3, themeBackground);
        }
    }

    private static boolean isSettingBaseDiyTheme(String str) {
        if (QQTheme.isBaseDIYTheme() && AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG.equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isSupportVideo() {
        return VasToggle.getBooleanDataSet(VasToggle.GLDRAWABLE, "video", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setBackGrooundImg(View view, ThemeBackground themeBackground, int i3, int i16) {
        view.setTag(themeBackground);
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            imageView.setImageDrawable(themeBackground.img);
            if (ThemeUtil.isHorizontalAnimate() && (themeBackground.img instanceof IGLDrawable)) {
                themeBackground.scaleType = imageView.getScaleType();
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        } else if (!((IVasDepTemp) QRoute.api(IVasDepTemp.class)).setContentBackground(view, i3)) {
            if (view instanceof FPSSwipListView) {
                ((FPSSwipListView) view).setContentBackground(themeBackground.img);
            } else {
                view.setBackgroundDrawable(themeBackground.img);
            }
        }
        horizontalAnimateInit(i16, themeBackground, view);
    }

    private static void setOldDiyBackground(Context context, ThemeBackground themeBackground) {
        Bundle currentThemeInfo = ThemeUtil.getCurrentThemeInfo();
        try {
            dealOldDiyTheme(context, themeBackground, currentThemeInfo.getString("themeId"), currentThemeInfo.getString("version"));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getThemeBackground setting err:" + e16.getMessage());
        }
    }

    public static void setThemeBackgroundPic(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, boolean z16) {
        QLog.d(TAG, 1, "setThemeBackgroundPic, bgType=" + str + ", url=" + str4 + ", path=" + str3 + ", id=" + str5 + ", name=" + str6 + ", feetype=" + i3 + ", isDiy=" + z16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences(context, str2, 4).edit();
        edit.putString(str, str3);
        edit.putString(str + ThemeConstants.THEME_DIY_BG_URL_SUFFIX, str4);
        edit.putString(str + "_id", str5);
        edit.putBoolean(str + ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, z16);
        if (str6 != null) {
            edit.putString(str + ThemeConstants.THEME_DIY_BG_NAME_SUFFIX, str6);
        }
        edit.putInt(str + ThemeConstants.THEME_DIY_BG_FEETYPE_SUFFIX, i3);
        if (str7 != null) {
            edit.putString(str + ThemeConstants.THEME_DIY_BG_THUM_SUFFIX, str7);
        }
        edit.commit();
    }

    public static void setThemeDrawArea(View view, int i3, ThemeBackground themeBackground) {
        float height = view.getRootView().getHeight();
        float height2 = view.getHeight();
        float width = view.getWidth();
        if (height != 0.0f && height2 != 0.0f && height >= height2) {
            float[] calThemeDrawArea = calThemeDrawArea(width, height, height2, i3);
            Drawable drawable = themeBackground.img;
            if (drawable instanceof IGLDrawable) {
                ((IGLDrawable) drawable).setDrawArea(calThemeDrawArea[0], calThemeDrawArea[1], calThemeDrawArea[2], calThemeDrawArea[3]);
            }
        }
    }

    private static boolean updateThemeBack(Context context, String str, ThemeBackground themeBackground, SharedPreferences sharedPreferences, String str2) {
        String str3 = themeBackground.path;
        boolean z16 = true;
        if (str3 != null && str3.equals(str2) && themeBackground.img != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getThemeBackground, bgType=");
            sb5.append(str);
            sb5.append(", path5=");
            sb5.append(themeBackground.path);
            sb5.append(", img=");
            if (themeBackground.img != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(TAG, 2, sb5.toString());
            return false;
        }
        if (!TextUtils.isEmpty(str2) && !"null".equals(str2) && !"none".equals(str2)) {
            getNewBackgroundImage(context, str, themeBackground, sharedPreferences, str2);
        } else {
            themeBackground.path = "null";
            QLog.d(TAG, 2, "getThemeBackground_DEFUALT, bgType=" + str + ", path=" + str2);
        }
        if (!themeBackground.isDecodeInDiy && themeBackground.img == null && AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG.equals(str)) {
            setOldDiyBackground(context, themeBackground);
        }
        return true;
    }

    public static Drawable getDynamicDrawable(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getDynamicDrawable(new File(new File(str).getParent(), str2).getAbsolutePath(), i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:
    
        if (r9 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0075, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
    
        r10.append(r6);
        r10.append(", path=");
        r10.append(r8);
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.vas.theme.diy.ThemeBackground.TAG, 2, r10.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
    
        if (r9 != null) goto L16;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap getBitmap(Context context, String str, String str2, Bitmap bitmap, File file) {
        StringBuilder sb5;
        File file2 = new File(((IVasDepTemp) QRoute.api(IVasDepTemp.class)).convert2SharpPFilePath(file));
        if (file2.exists()) {
            boolean isFunctionAvaliable = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).isFunctionAvaliable(context);
            if (QLog.isColorLevel() || !isFunctionAvaliable) {
                QLog.d(TAG, 2, "getThemeBackground, sharpP exists, bgType=" + str + ", path=" + str2 + ", sharpPAv=" + isFunctionAvaliable);
            }
            if (isFunctionAvaliable) {
                try {
                    try {
                        bitmap = SharpPUtil.decodeSharpPByFilePath(file2.getAbsolutePath());
                        if (QLog.isColorLevel() || bitmap == null) {
                            sb5 = new StringBuilder();
                            sb5.append("getThemeBackground, sharpP decode result=");
                        }
                    } catch (UnsatisfiedLinkError e16) {
                        QLog.e(TAG, 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + e16.getMessage());
                        if (QLog.isColorLevel() || bitmap == null) {
                            sb5 = new StringBuilder();
                            sb5.append("getThemeBackground, sharpP decode result=");
                        }
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel() || bitmap == null) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("getThemeBackground, sharpP decode result=");
                        sb6.append(bitmap != null);
                        sb6.append(", path=");
                        sb6.append(str2);
                        QLog.d(TAG, 2, sb6.toString());
                    }
                    throw th5;
                }
            }
        } else {
            QLog.e(TAG, 2, "getThemeBackground, file not exists, bgType=" + str + ", path=" + str2);
        }
        return bitmap;
    }

    public static Drawable getGLDrawableDrawable(String str, Function0<Drawable> function0) {
        if (!VasToggle.getBooleanDataSet(VasToggle.GLDRAWABLE, "etc", true)) {
            return function0.invoke();
        }
        return GLDrawableApi.asyncFactory(function0, new h(str));
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class BusinessFlag {
        private final String type;
        public boolean useStatic = false;
        public boolean useEffect = false;
        public boolean useApng = false;
        public boolean useVideo = false;
        public boolean use3D = false;
        public boolean useAETC = false;

        public BusinessFlag(String str) {
            this.type = str;
        }

        private void reset() {
            this.useStatic = false;
            this.useEffect = false;
            this.useApng = false;
            this.useVideo = false;
            this.use3D = false;
            this.useAETC = false;
        }

        public void setUse3D() {
            reset();
            this.use3D = true;
            log();
        }

        public void setUseAETC() {
            reset();
            this.useAETC = true;
            log();
        }

        public void setUseApng() {
            reset();
            this.useApng = true;
            log();
        }

        public void setUseEffect() {
            reset();
            this.useEffect = true;
            log();
        }

        public void setUseStatic() {
            reset();
            this.useStatic = true;
            log();
        }

        public void setUseVideo() {
            reset();
            this.useVideo = true;
            log();
        }

        private void log() {
        }
    }
}
