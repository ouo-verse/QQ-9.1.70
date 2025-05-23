package com.tencent.theme;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.theme.h;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SkinEngine {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_THEME_INVALIDATE = "com.tencent.qplus.THEME_INVALIDATE";
    public static final String ACTION_THEME_UPDATE = "com.tencent.qplus.THEME_UPDATE";
    public static final String ASSET_PATH = "/asset/";
    public static boolean BUG_LOCATE = false;
    public static boolean DEBUG = false;
    static int DENSITY_HDPI_INDEX = 0;
    static int DENSITY_MDPI_INDEX = 0;
    static final int[][] DENSITY_ORDER;
    static final String[][] DENSITY_PATH_ORDER;
    static int DENSITY_XHDPI_INDEX = 0;
    static int DENSITY_XXHDPI_INDEX = 0;
    static int DENSITY_XXXHDPI_INDEX = 0;
    static boolean IS_MNC_PREVIEW = false;
    static boolean IS_NOUGAT = false;
    public static boolean IS_PROBLEM_CM11 = false;
    public static boolean IS_PROBLEM_MIUI = false;
    public static final String KEY_PENDING_THEME = "pending_theme_root";
    public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
    public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
    public static final String KEY_SIMPLE_PENDING_THEME = "simple_theme_root";
    public static final String KEY_SIMPLE_RESOURCES_IS_COMPLIED = "complied";
    public static final String KEY_SIMPLE_THEME = "theme_simple_root";
    public static final String KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED = "simple_theme_resources_complied";
    public static final String KEY_THEME = "theme_root";
    public static final String KEY_THEME_FONT = "theme_font_root";
    private static final int MAX_LOAD_TIME = 2000;
    public static final String PREFERENCE_NAME = "theme";
    public static final String Q_CHAT_LIST_BG1_FILENAME = "skin_list_item_normal_theme_version2";
    public static final String Q_CHAT_LIST_BG2_FILENAME = "skin_item_sticky_normal";
    public static final String Q_CHAT_LIST_BG3_FILENAME = "skin_list_item_pressed_theme_version2";
    public static final String Q_CHAT_LIST_BG4_FILENAME = "skin_item_sticky_pressed";
    public static final String Q_QZONE_FEED_BACKGROUND_COLOR = "qzone_skin_feed_background_color";
    public static final String Q_TITLE_BAR_BG_FILENAME = "skin_header_bar_bg";
    public static boolean SWITCH_DEBUG = false;
    public static final String TAG = "SkinEngine";
    public static final String TAG_LOAD_CLR = "SkinEngine.load.clr";
    public static final String TAG_OPTIMIZE = "SkinEngine.optimize";
    public static final String TAG_SWITCH = "SkinEngine.switch";
    public static final int TYPE_FILE = 16777215;
    private static SkinEngine instances;
    public static Field mComposedIconInfoOfCM;
    public static Integer mIconResourceID;
    public static Field mIconsOfCM;
    static k mThemeService;
    public HashMap<Integer, BackupForOOMData> backupForOOMData;
    private c colorStateListPreloadIntercepter;
    private b colorStateListPreloadIntercepter15;
    private e drawableIntercepter;
    private final LongSparseArray<WeakReference<SkinnableColorStateList>> mColorStateListCache;
    private final ReentrantReadWriteLock mColorStateListLock;
    private HashMap<String, Object> mConfigs;
    private Context mContext;
    private HashMap<String, Object> mDefaultConfigs;
    private final LongSparseArray<WeakReference<BaseConstantState>> mDefaultThemeDrawableCache;
    private int mDensityIndex;
    private final LongSparseArray<WeakReference<BaseConstantState>> mDrawableCache;
    private final ReentrantReadWriteLock mDrawableCacheLock;
    private g mFileExistCache;
    private boolean mInSimpleModel;
    private boolean mIsResourcesComplied;
    private j mPreference;
    private int mQuiPicRenderColorRes;
    BroadcastReceiver mReceiver;
    public Resources mResources;
    private h mResourcesTransform;
    private String mSimpleSkinRootPath;
    SkinEngineHandler mSkinEngineHandler;
    i mSkinLifecycle;
    private String mSkinRootPath;
    private ISkinTint mSkinTint;
    private boolean mSkinUpdating;
    private String mTempSkinRootPath;
    TypedValue mTempValue;
    private TypedValue mTmpValue;
    private final Object mTmpValueLock;
    s mUpdateCallback;
    public final HashMap<String, Long> sStatisticMap;

    /* compiled from: P */
    /* renamed from: com.tencent.theme.SkinEngine$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    class AnonymousClass1 extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SkinEngine.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            m.f(SkinEngine.TAG, "receive update receiver");
            try {
                k kVar = SkinEngine.mThemeService;
                if (kVar != null && kVar.switchOn("vas_theme_engine_new_thread_pool", true)) {
                    m.f(SkinEngine.TAG, "UpdateTask use new pool");
                    BaseThread baseThread = new BaseThread(new Runnable(context) { // from class: com.tencent.theme.SkinEngine.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Context f376032d;

                        {
                            this.f376032d = context;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) context);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            m.f(SkinEngine.TAG, "run updateThread");
                            SkinEngine.this.startUpdateRes(this.f376032d);
                            k kVar2 = SkinEngine.mThemeService;
                            if (kVar2 != null) {
                                kVar2.runOnUIThread(new Runnable() { // from class: com.tencent.theme.SkinEngine.1.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC99161.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        m.f(SkinEngine.TAG, "after updateThread");
                                        RunnableC99161 runnableC99161 = RunnableC99161.this;
                                        SkinEngine.this.afterUpdateRes(runnableC99161.f376032d);
                                    }
                                });
                            }
                        }
                    });
                    baseThread.setPriority(10);
                    baseThread.start();
                } else {
                    new a(SkinEngine.this, null).execute(context);
                }
            } catch (RejectedExecutionException e16) {
                m.b(SkinEngine.TAG, 1, "receive update, RejectedExecutionException : ", e16);
                SkinEngine.this.reUploadRes(context);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class BackupForOOMData {
        static IPatchRedirector $redirector_;
        public int backFileResId;
        public Bitmap.Config inPreferredConfig;
        public int orgkFileResId;

        public BackupForOOMData(int i3, int i16, Bitmap.Config config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
                return;
            }
            this.orgkFileResId = i3;
            this.backFileResId = i16;
            this.inPreferredConfig = config;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class a extends AsyncTask<Context, Void, Context> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SkinEngine.this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Context doInBackground(Context... contextArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contextArr);
            }
            if (SkinEngine.SWITCH_DEBUG) {
                Log.d(SkinEngine.TAG_SWITCH, "UpdateTask.doInBackground start");
            }
            SkinEngine.this.startUpdateRes(contextArr[0]);
            if (SkinEngine.SWITCH_DEBUG) {
                Log.d(SkinEngine.TAG_SWITCH, "UpdateTask.doInBackground done");
            }
            return contextArr[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
                return;
            }
            if (SkinEngine.SWITCH_DEBUG) {
                Log.d(SkinEngine.TAG_SWITCH, "UpdateTask.onPostExecute start");
            }
            SkinEngine.this.afterUpdateRes(context);
            if (SkinEngine.SWITCH_DEBUG) {
                Log.d(SkinEngine.TAG_SWITCH, "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
                Log.d(SkinEngine.TAG_SWITCH, "UpdateTask.onPostExecute done");
            }
        }

        /* synthetic */ a(SkinEngine skinEngine, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) skinEngine, (Object) anonymousClass1);
        }
    }

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
            return;
        }
        DENSITY_PATH_ORDER = new String[][]{new String[]{"drawable-xhdpi/", "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/"}, new String[]{"drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-mdpi/", "drawable/"}, new String[]{"drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/"}, new String[]{"drawable-ldpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable/"}, new String[]{"drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/"}, new String[]{"drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/"}};
        DENSITY_ORDER = new int[][]{new int[]{320, 640, 480, 240, 160, 160}, new int[]{240, 320, 480, 640, 160, 160}, new int[]{160, 160, 240, 320, 480, 640}, new int[]{120, 240, 320, 480, 640, 160}, new int[]{480, 640, 320, 240, 160, 160}, new int[]{640, 480, 320, 240, 160, 160}};
        DEBUG = false;
        SWITCH_DEBUG = false;
        BUG_LOCATE = true;
        IS_PROBLEM_MIUI = false;
        mIconsOfCM = null;
        mComposedIconInfoOfCM = null;
        IS_PROBLEM_CM11 = false;
        mIconResourceID = null;
        "MNC".equals(Build.VERSION.CODENAME);
        IS_MNC_PREVIEW = true;
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        IS_NOUGAT = z16;
        DENSITY_XHDPI_INDEX = 0;
        DENSITY_HDPI_INDEX = 1;
        DENSITY_MDPI_INDEX = 2;
        DENSITY_XXHDPI_INDEX = 4;
        DENSITY_XXXHDPI_INDEX = 5;
    }

    SkinEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTmpValueLock = new Object();
        this.mTmpValue = new TypedValue();
        this.mSkinUpdating = false;
        this.mIsResourcesComplied = true;
        this.mDensityIndex = DENSITY_XXHDPI_INDEX;
        this.mReceiver = new AnonymousClass1();
        this.sStatisticMap = new HashMap<>();
        this.mDrawableCacheLock = new ReentrantReadWriteLock();
        this.mColorStateListLock = new ReentrantReadWriteLock();
        this.mTempValue = new TypedValue();
        this.mDrawableCache = new LongSparseArray<>();
        this.mColorStateListCache = new LongSparseArray<>();
        this.mDefaultThemeDrawableCache = new LongSparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterUpdateRes(Context context) {
        m.a(TAG, 1, "UpdateTask switch theme end");
        this.mConfigs = null;
        ensureConfigLoaded(this.mIsResourcesComplied);
        s sVar = this.mUpdateCallback;
        if (sVar != null) {
            sVar.a();
        }
        Intent intent = new Intent(ACTION_THEME_INVALIDATE);
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        m.a(TAG, 1, "UpdateTask afterUpdateRes: pid=" + Process.myPid());
    }

    private static void checkBound(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        m.a(TAG, 2, "text view drawable bound: " + bounds + "\uff0c drawable.getIntrinsicWidth()\uff1a " + drawable.getIntrinsicWidth() + ", drawable.getIntrinsicHeight(): " + drawable.getIntrinsicHeight());
        if (bounds.left == 0 && bounds.right == 0 && bounds.top == 0 && bounds.bottom == 0) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    private static void checkBounds(Drawable[] drawableArr) {
        for (Drawable drawable : drawableArr) {
            checkBound(drawable);
        }
    }

    private static void clearSystemSelectorCache() {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
            m.e(TAG, 2, "clearSystemSelectorCache start", null);
            try {
                Class<?> cls = Class.forName("android.rms.iaware.AwareAppScheduleManager");
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                Field declaredField = cls.getDeclaredField("mDrawableCaches");
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                declaredField.setAccessible(true);
                SparseArray sparseArray = (SparseArray) declaredField.get(invoke);
                synchronized (sparseArray) {
                    sparseArray.clear();
                }
                declaredField.setAccessible(false);
                m.e(TAG, 2, "clearSystemSelectorCache done", null);
            } catch (Exception e16) {
                m.d(TAG, 1, "clearSystemSelectorCache fail", e16);
            }
        }
    }

    private void doAfterReUpdate(final Context context) {
        mThemeService.runOnUIThread(new Runnable() { // from class: com.tencent.theme.p
            @Override // java.lang.Runnable
            public final void run() {
                SkinEngine.this.lambda$doAfterReUpdate$1(context);
            }
        });
    }

    public static long dumpDrawableCacheMemSize() {
        return 0L;
    }

    private void ensureConfigLoaded(boolean z16) {
        XmlPullParser newPullParser;
        if (this.mDefaultConfigs == null) {
            try {
                XmlResourceParser openXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
                this.mDefaultConfigs = parseXml(openXmlResourceParser);
                openXmlResourceParser.close();
            } catch (IOException unused) {
                this.mDefaultConfigs = new HashMap<>();
            } catch (XmlPullParserException e16) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("wrong xml config file: res/xml/theme_config.xml");
                notFoundException.initCause(e16);
                throw notFoundException;
            }
        }
        if (this.mConfigs == null) {
            if (this.mSkinRootPath == null && this.mSimpleSkinRootPath == null) {
                this.mConfigs = new HashMap<>();
                return;
            }
            try {
                if (z16) {
                    newPullParser = new AndroidXmlResourceParser();
                } else {
                    newPullParser = Xml.newPullParser();
                }
                FileInputStream fileInputStream = new FileInputStream(new File(getRealRootPath(), "xml/theme_config.xml"));
                newPullParser.setInput(fileInputStream, "UTF-8");
                this.mConfigs = parseXml(newPullParser);
                fileInputStream.close();
            } catch (IOException unused2) {
                this.mConfigs = new HashMap<>();
            } catch (XmlPullParserException e17) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("wrong theme xml config file: xml/theme_config.xml");
                notFoundException2.initCause(e17);
                throw notFoundException2;
            }
        }
    }

    private String generateColorPath(String str, String str2) {
        if (str != null && str2 != null) {
            StringBuilder sb5 = new StringBuilder(str2);
            String str3 = File.separator;
            if (!str2.endsWith(str3)) {
                sb5.append(str3);
            }
            sb5.append("color");
            sb5.append(str3);
            sb5.append(str);
            return sb5.toString();
        }
        return null;
    }

    private static int getBimapSize(Bitmap bitmap) {
        return bitmap.getByteCount();
    }

    private String getConfigPath() {
        String realRootPath = getRealRootPath();
        if (realRootPath == null) {
            return "";
        }
        String str = File.separator;
        if (!realRootPath.endsWith(str)) {
            realRootPath = realRootPath + str;
        }
        return realRootPath + "config.json";
    }

    private static int getDensityIndex(Resources resources) {
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i3 <= 160) {
            return DENSITY_MDPI_INDEX;
        }
        if (i3 <= 240) {
            return DENSITY_HDPI_INDEX;
        }
        if (i3 <= 320) {
            return DENSITY_XHDPI_INDEX;
        }
        if (i3 <= 480) {
            return DENSITY_XXHDPI_INDEX;
        }
        if (i3 <= 640) {
            return DENSITY_XXXHDPI_INDEX;
        }
        return DENSITY_XXHDPI_INDEX;
    }

    private InputStream getInputStream(Resources resources, String str) throws IOException {
        if (str.startsWith(ASSET_PATH)) {
            return resources.getAssets().open(str.substring(7));
        }
        return new BufferedInputStream(new FileInputStream(str));
    }

    public static synchronized SkinEngine getInstances() {
        SkinEngine skinEngine;
        synchronized (SkinEngine.class) {
            if (instances == null) {
                instances = new SkinEngine();
            }
            skinEngine = instances;
        }
        return skinEngine;
    }

    private XmlResourceParser getXml(int i3, TypedValue typedValue) throws IOException {
        this.mResources.getValue(i3, typedValue, true);
        if (typedValue.type == 3) {
            return this.mResources.getAssets().openXmlResourceParser(typedValue.assetCookie, typedValue.string.toString());
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i3) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    private String grabColorFile(Resources resources, String str) {
        String str2 = getRealRootPath() + "color/" + str;
        m.a(TAG_LOAD_CLR, 2, "start grab color path, file name : " + str2);
        try {
            g gVar = this.mFileExistCache;
            if (gVar != null && gVar.h() && !this.mFileExistCache.g()) {
                if (this.mFileExistCache.e(str)) {
                    return str2;
                }
            } else {
                if (str2.startsWith(ASSET_PATH)) {
                    resources.getAssets().open(str2.substring(7)).close();
                    m.a(TAG_LOAD_CLR, 2, "value exist in assets");
                    return str2;
                }
                if (new File(str2).exists()) {
                    m.a(TAG_LOAD_CLR, 2, "value exist in path");
                    return str2;
                }
            }
        } catch (IOException e16) {
            if (DEBUG) {
                Log.w(TAG, e16);
            }
        }
        m.a(TAG_LOAD_CLR, 2, "value not exist");
        return null;
    }

    private void grabImageFile(Resources resources, TypedValue typedValue, String str, String[] strArr, int[] iArr) {
        String str2;
        g gVar = this.mFileExistCache;
        if (gVar != null && gVar.h() && !this.mFileExistCache.g()) {
            Integer d16 = this.mFileExistCache.d(str);
            if (d16 != null) {
                typedValue.string = getRealRootPath() + strArr[d16.intValue()] + str;
                typedValue.density = iArr[d16.intValue()];
                return;
            }
            typedValue.string = null;
            typedValue.density = 0;
            printSpecifyFileLog(str, "mFileExistCache has no need dpi");
            return;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            try {
                str2 = getRealRootPath() + strArr[i3] + str;
            } catch (IOException e16) {
                if (DEBUG) {
                    Log.w(TAG, e16);
                }
                printSpecifyFileLog(str, "open file IOException " + e16.getMessage());
            }
            if (str2.startsWith(ASSET_PATH)) {
                resources.getAssets().open(str2.substring(7)).close();
                typedValue.string = str2;
                typedValue.density = iArr[i3];
                return;
            } else {
                if (new File(str2).exists()) {
                    typedValue.string = str2;
                    typedValue.density = iArr[i3];
                    return;
                }
            }
        }
        m.a(TAG_LOAD_CLR, 2, "image file not exist : " + str);
        printSpecifyFileLog(str, "not find in res dir");
        typedValue.string = null;
        typedValue.density = 0;
    }

    public static void init(Context context, int i3, int i16, int i17, int i18, int i19, int i26, File file) throws UnSupportPlatformException {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init cacheFile:");
        sb5.append(file == null);
        m.e(TAG, 2, sb5.toString(), null);
        long uptimeMillis = SystemClock.uptimeMillis();
        SkinEngine instances2 = getInstances();
        Resources resources = context.getResources();
        instances2.mContext = context.getApplicationContext();
        instances2.mResources = resources;
        isSupportPlatform(context, resources);
        instances2.mDensityIndex = getDensityIndex(instances2.mResources);
        SharedPreferences sharedPreference = instances2.getSharedPreference(context);
        instances2.mSkinRootPath = sharedPreference.getString("theme_root", null);
        String string = sharedPreference.getString(KEY_SIMPLE_THEME, null);
        instances2.mSimpleSkinRootPath = string;
        instances2.mInSimpleModel = string != null;
        instances2.initIntercepter(resources, i3, i16, i17, i18, i19, i26, file);
        initConfig(context.getResources(), instances2);
        TextHook.getInstance().switchFont(context, sharedPreference.getString(KEY_THEME_FONT, null));
        context.getApplicationContext().registerReceiver(instances2.mReceiver, new IntentFilter(ACTION_THEME_UPDATE), "com.tencent.msg.permission.pushnotify", null);
        if (instances2.mInSimpleModel) {
            instances2.mIsResourcesComplied = sharedPreference.getBoolean("complied", true);
        } else {
            instances2.mIsResourcesComplied = sharedPreference.getBoolean("complied", true);
        }
        clearSystemSelectorCache();
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        instances2.sStatisticMap.put("init_total", Long.valueOf(uptimeMillis2));
        m.a(TAG, 1, "SkinEngine init cost time : " + uptimeMillis2);
    }

    private void initColorInterceptor(Resources resources, int[] iArr) throws UnSupportPlatformException {
        Object obj;
        try {
            l a16 = l.a(resources);
            try {
                a16.b(resources);
                long uptimeMillis = SystemClock.uptimeMillis();
                if (IS_MNC_PREVIEW) {
                    this.colorStateListPreloadIntercepter = new d(this, resources, iArr, a16.f376083g);
                } else {
                    this.colorStateListPreloadIntercepter = new c(this, resources, iArr, a16.f376083g);
                }
                m.a(TAG, 1, "int color Loader cost time : " + (SystemClock.uptimeMillis() - uptimeMillis));
                if (IS_NOUGAT && (obj = a16.f376079c) != null) {
                    a16.f376081e.set(obj, this.colorStateListPreloadIntercepter);
                } else {
                    a16.f376081e.set(resources, this.colorStateListPreloadIntercepter);
                }
            } catch (Exception e16) {
                Field declaredField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
                a16.f376081e = declaredField;
                declaredField.setAccessible(true);
                Object obj2 = a16.f376081e.get(resources);
                long uptimeMillis2 = SystemClock.uptimeMillis();
                if (obj2 instanceof SparseArray) {
                    b bVar = new b(this, resources, iArr, (SparseArray) obj2);
                    this.colorStateListPreloadIntercepter15 = bVar;
                    a16.f376081e.set(resources, bVar);
                } else if (obj2 instanceof LongSparseArray) {
                    c cVar = new c(this, resources, iArr, (LongSparseArray) obj2);
                    this.colorStateListPreloadIntercepter = cVar;
                    a16.f376081e.set(resources, cVar);
                } else {
                    throw new UnSupportPlatformException(e16);
                }
                m.a(TAG, 1, "int color Loader cost time : " + (SystemClock.uptimeMillis() - uptimeMillis2));
            }
            m.e(TAG, 2, "initIntercepter colorStateListPreloadIntercepter ok", null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e17) {
            throw new UnSupportPlatformException(e17);
        }
    }

    private static void initConfig(Resources resources, SkinEngine skinEngine) {
        long uptimeMillis = SystemClock.uptimeMillis();
        ISkinTint iSkinTint = skinEngine.mSkinTint;
        if (iSkinTint != null) {
            if (skinEngine.mSkinRootPath == null && skinEngine.mSimpleSkinRootPath == null) {
                iSkinTint.clear();
            } else {
                iSkinTint.loadConfig(resources, skinEngine.getConfigPath());
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        getInstances().sStatisticMap.put("init_config", Long.valueOf(uptimeMillis2));
        m.a(TAG, 1, "load config cost : " + uptimeMillis2);
    }

    private void initDrawableInterceptor(Resources resources, int[] iArr) throws UnSupportPlatformException {
        Object obj;
        try {
            l a16 = l.a(resources);
            a16.c(resources);
            g c16 = e.c(this, resources);
            this.mFileExistCache = c16;
            c16.j();
            long uptimeMillis = SystemClock.uptimeMillis();
            Object obj2 = a16.f376082f;
            if (obj2 instanceof LongSparseArray) {
                this.drawableIntercepter = new e(this, resources, iArr, (LongSparseArray) obj2);
                m.a(TAG, 1, "int Drawable Loader cost time : " + (SystemClock.uptimeMillis() - uptimeMillis));
                if (IS_NOUGAT && (obj = a16.f376079c) != null) {
                    a16.f376080d.set(obj, new f(0, this.drawableIntercepter));
                } else {
                    a16.f376080d.set(resources, new f(0, this.drawableIntercepter));
                }
            } else if (obj2 instanceof LongSparseArray[]) {
                LongSparseArray[] longSparseArrayArr = (LongSparseArray[]) obj2;
                this.drawableIntercepter = new e(this, resources, iArr, longSparseArrayArr);
                m.a(TAG, 1, "int Drawable Loader cost time : " + (SystemClock.uptimeMillis() - uptimeMillis));
                for (int i3 = 0; i3 < longSparseArrayArr.length; i3++) {
                    longSparseArrayArr[i3] = new f(i3, this.drawableIntercepter);
                }
            }
            m.e(TAG, 2, "initIntercepter DrawablePreloadIntercepter ok", null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e16) {
            throw new UnSupportPlatformException(e16);
        }
    }

    private void initForOther(Resources resources) {
        l.e(resources);
        l.d(resources);
        l.f(resources);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015d A[Catch: Exception -> 0x01dd, TRY_LEAVE, TryCatch #2 {Exception -> 0x01dd, blocks: (B:27:0x0159, B:29:0x015d, B:31:0x0169, B:34:0x016f, B:36:0x0184, B:37:0x019f, B:39:0x01a5, B:40:0x01cb, B:43:0x01d1, B:44:0x01d7, B:45:0x01b9, B:48:0x0177, B:51:0x018e), top: B:26:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a5 A[Catch: Exception -> 0x01dd, TryCatch #2 {Exception -> 0x01dd, blocks: (B:27:0x0159, B:29:0x015d, B:31:0x0169, B:34:0x016f, B:36:0x0184, B:37:0x019f, B:39:0x01a5, B:40:0x01cb, B:43:0x01d1, B:44:0x01d7, B:45:0x01b9, B:48:0x0177, B:51:0x018e), top: B:26:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b9 A[Catch: Exception -> 0x01dd, TryCatch #2 {Exception -> 0x01dd, blocks: (B:27:0x0159, B:29:0x015d, B:31:0x0169, B:34:0x016f, B:36:0x0184, B:37:0x019f, B:39:0x01a5, B:40:0x01cb, B:43:0x01d1, B:44:0x01d7, B:45:0x01b9, B:48:0x0177, B:51:0x018e), top: B:26:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018e A[Catch: Exception -> 0x01dd, TryCatch #2 {Exception -> 0x01dd, blocks: (B:27:0x0159, B:29:0x015d, B:31:0x0169, B:34:0x016f, B:36:0x0184, B:37:0x019f, B:39:0x01a5, B:40:0x01cb, B:43:0x01d1, B:44:0x01d7, B:45:0x01b9, B:48:0x0177, B:51:0x018e), top: B:26:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0244 A[Catch: Exception -> 0x0261, TryCatch #10 {Exception -> 0x0261, blocks: (B:64:0x0233, B:66:0x0244, B:68:0x0255), top: B:63:0x0233 }] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [com.tencent.theme.e] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Throwable, java.lang.Object, java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r13v9 */
    @SuppressLint({"DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initIntercepter(Resources resources, int i3, int i16, int i17, int i18, int i19, int i26, File file) throws UnSupportPlatformException {
        String str;
        long j3;
        Object obj;
        ?? r132;
        Field declaredField;
        Class<?> cls;
        Field declaredField2;
        LongSparseArray longSparseArray;
        String str2;
        Object obj2;
        Field field;
        Object obj3;
        Field declaredField3;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (i3 == 0 || i16 == 0) {
            str = "sPreloadedComplexColors";
            j3 = uptimeMillis;
            obj = null;
        } else {
            try {
                try {
                    if (IS_NOUGAT) {
                        Field declaredField4 = Resources.class.getDeclaredField("mResourcesImpl");
                        declaredField4.setAccessible(true);
                        obj3 = declaredField4.get(resources);
                        try {
                            declaredField3 = obj3.getClass().getDeclaredField("sPreloadedDrawables");
                        } catch (NoSuchFieldException unused) {
                            declaredField3 = obj3.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
                        }
                        declaredField3.setAccessible(true);
                        obj2 = declaredField3.get(obj3);
                        field = declaredField3;
                    } else {
                        Field declaredField5 = Resources.class.getDeclaredField("sPreloadedDrawables");
                        declaredField5.setAccessible(true);
                        obj2 = declaredField5.get(resources);
                        field = declaredField5;
                        obj3 = null;
                    }
                    if (!(obj2 instanceof LongSparseArray)) {
                        str = "sPreloadedComplexColors";
                        j3 = uptimeMillis;
                        if (obj2 instanceof LongSparseArray[]) {
                            LongSparseArray[] longSparseArrayArr = (LongSparseArray[]) obj2;
                            g c16 = e.c(this, resources);
                            this.mFileExistCache = c16;
                            c16.j();
                            r132 = new e(this, resources, i3, i16, i17, file, longSparseArrayArr);
                            this.drawableIntercepter = r132;
                            for (int i27 = 0; i27 < longSparseArrayArr.length; i27++) {
                                longSparseArrayArr[i27] = new f(i27, this.drawableIntercepter);
                            }
                        }
                    } else {
                        g c17 = e.c(this, resources);
                        this.mFileExistCache = c17;
                        c17.j();
                        j3 = uptimeMillis;
                        r132 = field;
                        str = "sPreloadedComplexColors";
                        this.drawableIntercepter = new e(this, resources, i3, i16, i17, file, (LongSparseArray) obj2);
                        if (IS_NOUGAT && obj3 != null) {
                            r132.set(obj3, new f(0, this.drawableIntercepter));
                        } else {
                            r132.set(resources, new f(0, this.drawableIntercepter));
                        }
                    }
                    obj = obj3;
                } catch (IllegalAccessException e16) {
                    e = e16;
                    throw new UnSupportPlatformException(e);
                } catch (IllegalArgumentException e17) {
                    e = e17;
                    throw new UnSupportPlatformException(e);
                }
            } catch (NoSuchFieldException e18) {
                e = e18;
                throw new UnSupportPlatformException(e);
            }
        }
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.BRAND)) {
            try {
                declaredField = Resources.class.getDeclaredField("mALDC");
            } catch (Throwable th5) {
                th = th5;
                r132 = 0;
            }
            try {
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    Object obj4 = declaredField.get(this.mResources);
                    if (obj4 instanceof Map) {
                        ((Map) obj4).clear();
                        r132 = 0;
                        m.e(TAG, 2, "clear mALDC suss", null);
                    } else {
                        r132 = 0;
                        m.e(TAG, 1, "clear fail, mALDC type:" + obj4, null);
                    }
                } else {
                    r132 = 0;
                    m.e(TAG, 1, "clear fail, null == f", null);
                }
            } catch (Throwable th6) {
                th = th6;
                m.d(TAG, 1, "clear mALDC Error", th);
                m.e(TAG, 2, "initIntercepter DrawablePreloadIntercepter ok", r132);
                if (i18 != 0) {
                    try {
                        if (!IS_NOUGAT) {
                        }
                        LongSparseArray longSparseArray2 = longSparseArray;
                        Object obj5 = obj;
                        if (IS_MNC_PREVIEW) {
                        }
                        if (!IS_NOUGAT) {
                        }
                        declaredField2.set(resources, this.colorStateListPreloadIntercepter);
                    } catch (Exception e19) {
                        Field declaredField6 = Resources.class.getDeclaredField("mPreloadedColorStateLists");
                        declaredField6.setAccessible(true);
                        Object obj6 = declaredField6.get(resources);
                        if (obj6 instanceof SparseArray) {
                            b bVar = new b(this, resources, (SparseArray) obj6, i18, i19, i26);
                            this.colorStateListPreloadIntercepter15 = bVar;
                            declaredField6.set(resources, bVar);
                        } else if (obj6 instanceof LongSparseArray) {
                            c cVar = new c(this, resources, (LongSparseArray) obj6, i18, i19, i26);
                            this.colorStateListPreloadIntercepter = cVar;
                            declaredField6.set(resources, cVar);
                        } else {
                            throw new UnSupportPlatformException(e19);
                        }
                    }
                }
                m.e(TAG, 2, "initIntercepter colorStateListPreloadIntercepter ok", r132);
                cls = resources.getClass();
                if (cls.getName().equals("android.content.res.MiuiResources")) {
                }
                Field declaredField7 = resources.getClass().getDeclaredField("mIcons");
                mIconsOfCM = declaredField7;
                declaredField7.setAccessible(true);
                mIconsOfCM.set(resources, r132);
                mIconsOfCM.setAccessible(false);
                Field declaredField8 = resources.getClass().getDeclaredField("mComposedIconInfo");
                mComposedIconInfoOfCM = declaredField8;
                declaredField8.setAccessible(true);
                mComposedIconInfoOfCM.set(resources, r132);
                mComposedIconInfoOfCM.setAccessible(false);
                IS_PROBLEM_CM11 = true;
                long uptimeMillis2 = SystemClock.uptimeMillis() - j3;
                getInstances().sStatisticMap.put("init_hook", Long.valueOf(uptimeMillis2));
                m.a(TAG, 1, "initIntercepter cost : " + uptimeMillis2);
            }
        } else {
            r132 = 0;
        }
        m.e(TAG, 2, "initIntercepter DrawablePreloadIntercepter ok", r132);
        if (i18 != 0 && i19 != 0) {
            if (!IS_NOUGAT) {
                Field declaredField9 = Resources.class.getDeclaredField("mResourcesImpl");
                declaredField9.setAccessible(true);
                obj = declaredField9.get(resources);
                try {
                    str2 = str;
                } catch (NoSuchFieldException unused2) {
                    str2 = str;
                }
                try {
                    declaredField2 = obj.getClass().getDeclaredField(str2);
                } catch (NoSuchFieldException unused3) {
                    declaredField2 = obj.getClass().getSuperclass().getDeclaredField(str2);
                    declaredField2.setAccessible(true);
                    longSparseArray = (LongSparseArray) declaredField2.get(obj);
                    LongSparseArray longSparseArray22 = longSparseArray;
                    Object obj52 = obj;
                    if (IS_MNC_PREVIEW) {
                    }
                    if (!IS_NOUGAT) {
                    }
                    declaredField2.set(resources, this.colorStateListPreloadIntercepter);
                    m.e(TAG, 2, "initIntercepter colorStateListPreloadIntercepter ok", r132);
                    cls = resources.getClass();
                    if (cls.getName().equals("android.content.res.MiuiResources")) {
                    }
                    Field declaredField72 = resources.getClass().getDeclaredField("mIcons");
                    mIconsOfCM = declaredField72;
                    declaredField72.setAccessible(true);
                    mIconsOfCM.set(resources, r132);
                    mIconsOfCM.setAccessible(false);
                    Field declaredField82 = resources.getClass().getDeclaredField("mComposedIconInfo");
                    mComposedIconInfoOfCM = declaredField82;
                    declaredField82.setAccessible(true);
                    mComposedIconInfoOfCM.set(resources, r132);
                    mComposedIconInfoOfCM.setAccessible(false);
                    IS_PROBLEM_CM11 = true;
                    long uptimeMillis22 = SystemClock.uptimeMillis() - j3;
                    getInstances().sStatisticMap.put("init_hook", Long.valueOf(uptimeMillis22));
                    m.a(TAG, 1, "initIntercepter cost : " + uptimeMillis22);
                }
                declaredField2.setAccessible(true);
                longSparseArray = (LongSparseArray) declaredField2.get(obj);
            } else {
                declaredField2 = Resources.class.getDeclaredField("sPreloadedColorStateLists");
                declaredField2.setAccessible(true);
                longSparseArray = (LongSparseArray) declaredField2.get(resources);
            }
            LongSparseArray longSparseArray222 = longSparseArray;
            Object obj522 = obj;
            if (IS_MNC_PREVIEW) {
                this.colorStateListPreloadIntercepter = new d(this, resources, longSparseArray222, i18, i19, i26);
            } else {
                this.colorStateListPreloadIntercepter = new c(this, resources, longSparseArray222, i18, i19, i26);
            }
            if (!IS_NOUGAT && obj522 != null) {
                declaredField2.set(obj522, this.colorStateListPreloadIntercepter);
            } else {
                declaredField2.set(resources, this.colorStateListPreloadIntercepter);
            }
        }
        m.e(TAG, 2, "initIntercepter colorStateListPreloadIntercepter ok", r132);
        try {
            cls = resources.getClass();
            if (cls.getName().equals("android.content.res.MiuiResources")) {
                Field declaredField10 = cls.getDeclaredField("sPreloadDrawableSources");
                declaredField10.setAccessible(true);
                if (declaredField10.get(resources) == null) {
                    declaredField10.set(resources, new SparseArray());
                    IS_PROBLEM_MIUI = true;
                }
            }
        } catch (Exception e26) {
            if (DEBUG) {
                Log.e(TAG, "", e26);
            }
            IS_PROBLEM_MIUI = false;
        }
        try {
            Field declaredField722 = resources.getClass().getDeclaredField("mIcons");
            mIconsOfCM = declaredField722;
            declaredField722.setAccessible(true);
            mIconsOfCM.set(resources, r132);
            mIconsOfCM.setAccessible(false);
            Field declaredField822 = resources.getClass().getDeclaredField("mComposedIconInfo");
            mComposedIconInfoOfCM = declaredField822;
            declaredField822.setAccessible(true);
            mComposedIconInfoOfCM.set(resources, r132);
            mComposedIconInfoOfCM.setAccessible(false);
            IS_PROBLEM_CM11 = true;
        } catch (Exception unused4) {
            mIconsOfCM = r132;
            mComposedIconInfoOfCM = r132;
        }
        long uptimeMillis222 = SystemClock.uptimeMillis() - j3;
        getInstances().sStatisticMap.put("init_hook", Long.valueOf(uptimeMillis222));
        m.a(TAG, 1, "initIntercepter cost : " + uptimeMillis222);
    }

    private static void initResInterceptor(SkinEngine skinEngine, Resources resources, int[] iArr, int[] iArr2) throws UnSupportPlatformException {
        long uptimeMillis = SystemClock.uptimeMillis();
        k kVar = mThemeService;
        if (kVar != null && kVar.switchOn("vas_theme_engine_enable_color_first", true)) {
            skinEngine.initColorInterceptor(resources, iArr2);
            skinEngine.initDrawableInterceptor(resources, iArr);
        } else {
            skinEngine.initDrawableInterceptor(resources, iArr);
            skinEngine.initColorInterceptor(resources, iArr2);
        }
        skinEngine.initForOther(resources);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        getInstances().sStatisticMap.put("init_hook", Long.valueOf(uptimeMillis2));
        m.a(TAG, 1, "initResInterceptor cost : " + uptimeMillis2);
    }

    private static void initSync(SkinEngine skinEngine, Resources resources, int[] iArr, int[] iArr2) throws UnSupportPlatformException {
        initResInterceptor(skinEngine, resources, iArr, iArr2);
        initConfig(resources, skinEngine);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void invalidateAll(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            String name = view.getClass().getName();
            if (name.contains("ListView")) {
                m.a(TAG, 1, "refresh view : " + name + " count : " + viewGroup.getChildCount());
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                invalidateAll(viewGroup.getChildAt(i3));
            }
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background instanceof DrawableContainer) {
                Rect rect = new Rect();
                background.getPadding(rect);
                refreshGradientInContainer((DrawableContainer) background);
                if (rect.left == view.getPaddingLeft() && rect.right == view.getPaddingRight() && rect.top == view.getPaddingTop() && rect.bottom == view.getPaddingBottom()) {
                    SkinnableActivityProcesser.updateDrawableContainerPadding(background);
                    view.setBackgroundDrawable(null);
                    view.setBackgroundDrawable(background);
                } else {
                    int paddingTop = view.getPaddingTop();
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    SkinnableActivityProcesser.updateDrawableContainerPadding(background);
                    view.setBackgroundDrawable(null);
                    view.setBackgroundDrawable(background);
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            } else if (background instanceof SkinnableNinePatchDrawable) {
                Rect rect2 = new Rect();
                if (((SkinnableNinePatchDrawable) background).getOldPadding(rect2) && rect2.left == view.getPaddingLeft() && rect2.right == view.getPaddingRight() && rect2.top == view.getPaddingTop() && rect2.bottom == view.getPaddingBottom()) {
                    view.setBackgroundDrawable(null);
                    view.setBackgroundDrawable(background);
                } else {
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    view.setBackgroundDrawable(null);
                    view.setBackgroundDrawable(background);
                    view.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
            } else if (background instanceof SkinnableBitmapDrawable) {
                view.setBackgroundDrawable(null);
                view.setBackgroundDrawable(background);
            } else if (background instanceof GradientDrawable) {
                refreshGradientDrawable((GradientDrawable) background);
                view.setBackgroundDrawable(null);
                view.setBackgroundDrawable(background);
            } else if (background instanceof LayerDrawable) {
                refreshLayerDrawable((LayerDrawable) background);
                view.setBackgroundDrawable(null);
                view.setBackgroundDrawable(background);
            }
        }
        if (view instanceof SkinnableView) {
            ((SkinnableView) view).onThemeChanged();
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            SkinnableActivityProcesser.updateDrawableContainerPadding(drawable);
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(drawable);
        } else if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (compoundDrawables[0] != null || compoundDrawables[1] != null || compoundDrawables[2] != null || compoundDrawables[3] != null) {
                checkBounds(compoundDrawables);
                textView.setCompoundDrawables(null, null, null, null);
                textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            }
        }
        view.destroyDrawingCache();
        view.refreshDrawableState();
        view.invalidate();
        view.requestLayout();
    }

    private boolean isNotQuiRes(String str) {
        if (str.startsWith("qui_") && str.endsWith(".png")) {
            return false;
        }
        return true;
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static void isSupportPlatform(Context context, Resources resources) throws UnSupportPlatformException {
        Object obj;
        Object obj2;
        Field declaredField;
        Field declaredField2;
        try {
            try {
                if (IS_NOUGAT) {
                    Field declaredField3 = Resources.class.getDeclaredField("mResourcesImpl");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(resources);
                    try {
                        declaredField2 = obj3.getClass().getDeclaredField("sPreloadedDrawables");
                    } catch (NoSuchFieldException unused) {
                        declaredField2 = obj3.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
                    }
                    declaredField2.setAccessible(true);
                    obj = declaredField2.get(obj3);
                } else {
                    Field declaredField4 = Resources.class.getDeclaredField("sPreloadedDrawables");
                    declaredField4.setAccessible(true);
                    obj = declaredField4.get(resources);
                }
                if (!(obj instanceof LongSparseArray) && !(obj instanceof LongSparseArray[])) {
                    throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
                }
                try {
                    if (IS_NOUGAT) {
                        Field declaredField5 = Resources.class.getDeclaredField("mResourcesImpl");
                        declaredField5.setAccessible(true);
                        Object obj4 = declaredField5.get(resources);
                        try {
                            declaredField = obj4.getClass().getDeclaredField("sPreloadedComplexColors");
                        } catch (NoSuchFieldException unused2) {
                            declaredField = obj4.getClass().getSuperclass().getDeclaredField("sPreloadedComplexColors");
                        }
                        declaredField.setAccessible(true);
                        obj2 = declaredField.get(obj4);
                    } else {
                        Field declaredField6 = Resources.class.getDeclaredField("sPreloadedColorStateLists");
                        declaredField6.setAccessible(true);
                        obj2 = declaredField6.get(resources);
                    }
                } catch (Exception e16) {
                    Field declaredField7 = Resources.class.getDeclaredField("mPreloadedColorStateLists");
                    declaredField7.setAccessible(true);
                    Object obj5 = declaredField7.get(resources);
                    if (!(obj5 instanceof SparseArray) && !(obj5 instanceof LongSparseArray)) {
                        throw new UnSupportPlatformException(e16);
                    }
                }
                if (!(obj2 instanceof LongSparseArray)) {
                    throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
                }
                if (!r.a(context, "ro.lewa.version").equalsIgnoreCase("LeWa_OS6.0_14.10.22")) {
                } else {
                    throw new UnSupportPlatformException("lewa is not supported");
                }
            } catch (IllegalAccessException e17) {
                e = e17;
                throw new UnSupportPlatformException(e);
            } catch (IllegalArgumentException e18) {
                e = e18;
                throw new UnSupportPlatformException(e);
            }
        } catch (NoSuchFieldException e19) {
            e = e19;
            throw new UnSupportPlatformException(e);
        }
    }

    private boolean isTrackLoadRes() {
        return DEBUG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doAfterReUpdate$1(Context context) {
        m.a(TAG, 1, "do after reUpload");
        afterUpdateRes(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reUploadRes$0(Context context) {
        startUpdateRes(context);
        doAfterReUpdate(context);
    }

    private SkinnableColorStateList loadColor(File file) {
        try {
            return ResourcesFactory.createColorStateListFromXmlFile(this, this.mResources, file, this.mIsResourcesComplied);
        } catch (Exception unused) {
            return null;
        }
    }

    private SkinnableColorStateList loadDefaultColor(SkinData skinData) {
        synchronized (this.mTmpValue) {
            if (!skinData.mFileName.endsWith(".xml")) {
                return null;
            }
            try {
                XmlResourceParser xml = getXml(skinData.mResourcesID, this.mTmpValue);
                SkinnableColorStateList createFromXml = SkinnableColorStateList.createFromXml(this, this.mResources, xml, true);
                xml.close();
                return createFromXml;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private boolean needTint(String str) {
        ISkinTint iSkinTint = this.mSkinTint;
        if (iSkinTint != null && iSkinTint.needTintRes(str)) {
            return true;
        }
        return false;
    }

    private TypedValue obtainTempTypedValue() {
        synchronized (this.mTmpValueLock) {
            if (this.mTempValue != null) {
                this.mTempValue = null;
            }
        }
        return new TypedValue();
    }

    private HashMap<String, Object> parseXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xmlPullParser.getName();
            HashMap<String, Object> hashMap = new HashMap<>();
            if (name.equals(DKConfiguration.Directory.RESOURCES)) {
                int depth = xmlPullParser.getDepth() + 1;
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1 || (xmlPullParser.getDepth() < depth && next2 == 3)) {
                        break;
                    }
                    if (next2 == 2) {
                        String name2 = xmlPullParser.getName();
                        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                        if ("color".equals(name2)) {
                            hashMap.put(attributeValue, Integer.valueOf(Color.parseColor(xmlPullParser.nextText())));
                        } else if ("dimen".equals(name2)) {
                            String nextText = xmlPullParser.nextText();
                            int parseInt = Integer.parseInt(nextText.substring(0, nextText.length() - 2));
                            if (nextText.endsWith("dp")) {
                                hashMap.put(attributeValue, Float.valueOf(TypedValue.applyDimension(1, parseInt, this.mResources.getDisplayMetrics())));
                            } else if (nextText.endsWith("dip")) {
                                hashMap.put(attributeValue, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(nextText.substring(0, nextText.length() - 3)), this.mResources.getDisplayMetrics())));
                            } else if (nextText.endsWith("sp")) {
                                hashMap.put(attributeValue, Float.valueOf(TypedValue.applyDimension(2, parseInt, this.mResources.getDisplayMetrics())));
                            } else if (nextText.endsWith("px")) {
                                hashMap.put(attributeValue, Float.valueOf(TypedValue.applyDimension(0, parseInt, this.mResources.getDisplayMetrics())));
                            }
                        } else if ("bool".equals(name2)) {
                            hashMap.put(attributeValue, Boolean.valueOf("true".equalsIgnoreCase(xmlPullParser.nextText())));
                        } else if ("integer".equals(name2)) {
                            hashMap.put(attributeValue, Integer.valueOf(Integer.parseInt(xmlPullParser.nextText())));
                        }
                    }
                }
            }
            return hashMap;
        }
        throw new XmlPullParserException("No start tag found");
    }

    private void printSpecifyFileLog(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && isTrackLoadRes()) {
            m.a(TAG, 1, "file : " + str + " log : " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reUploadRes(final Context context) {
        k kVar = mThemeService;
        if (kVar != null && kVar.switchOn("switch_update_failed_fixed", false)) {
            m.a(TAG, 1, "start reUpdate");
            mThemeService.execute(new Runnable() { // from class: com.tencent.theme.o
                @Override // java.lang.Runnable
                public final void run() {
                    SkinEngine.this.lambda$reUploadRes$0(context);
                }
            });
        }
    }

    private SkinnableColorStateList realLoadColor(int i3, Resources resources, SkinData skinData) {
        String str = skinData.mFilePath;
        if (str != null && str.endsWith(".xml")) {
            m.c(TAG_LOAD_CLR, "load color from skin, path : " + str);
            try {
                SkinnableColorStateList createColorStateListFromXmlFile = ResourcesFactory.createColorStateListFromXmlFile(this, resources, new File(str), this.mIsResourcesComplied);
                if (needTint(skinData.mFileName)) {
                    this.mSkinTint.tintColorState(createColorStateListFromXmlFile.getColors(), createColorStateListFromXmlFile.getStateSpecs(), skinData.mFileName);
                    createColorStateListFromXmlFile.setDefaultColor(createColorStateListFromXmlFile.getColors(), createColorStateListFromXmlFile.getStateSpecs());
                }
                return createColorStateListFromXmlFile;
            } catch (Exception unused) {
                if (DEBUG) {
                    throw new Resources.NotFoundException("File " + str + " from Skin ColorState resource ID #0x" + Integer.toHexString(i3));
                }
            }
        }
        String str2 = skinData.mFileName;
        if (str2.endsWith(".xml")) {
            try {
                XmlResourceParser xml = getXml(i3, this.mTmpValue);
                SkinnableColorStateList createFromXml = SkinnableColorStateList.createFromXml(this, resources, xml, true);
                ISkinTint iSkinTint = this.mSkinTint;
                if (iSkinTint != null) {
                    iSkinTint.tintColorState(createFromXml.getColors(), createFromXml.getStateSpecs(), str2);
                    createFromXml.setDefaultColor(createFromXml.getColors(), createFromXml.getStateSpecs());
                }
                if (xml != null) {
                    xml.close();
                }
                return createFromXml;
            } catch (Exception unused2) {
                throw new Resources.NotFoundException("File " + str2 + " from Skin ColorList list resource ID #0x" + Integer.toHexString(i3));
            }
        }
        throw new Resources.NotFoundException("File " + str2 + " from Skin ColorList resource ID #0x" + Integer.toHexString(i3) + ": .xml extension required");
    }

    public static void refreshGradientDrawable(GradientDrawable gradientDrawable) {
        refreshSolidColor(gradientDrawable);
        refreshStrokeColor(gradientDrawable);
    }

    public static void refreshGradientInContainer(DrawableContainer drawableContainer) {
        Drawable.ConstantState constantState = drawableContainer.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return;
        }
        DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState) constantState;
        int childCount = drawableContainerState.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Drawable child = drawableContainerState.getChild(i3);
            if (child instanceof GradientDrawable) {
                refreshGradientDrawable((GradientDrawable) child);
            } else if (child instanceof LayerDrawable) {
                refreshLayerDrawable((LayerDrawable) child);
            } else if (child instanceof DrawableContainer) {
                refreshGradientInContainer((DrawableContainer) child);
            }
        }
    }

    public static void refreshLayerDrawable(LayerDrawable layerDrawable) {
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            Drawable drawable = layerDrawable.getDrawable(i3);
            if (drawable instanceof GradientDrawable) {
                refreshGradientDrawable((GradientDrawable) drawable);
            } else if (drawable instanceof DrawableContainer) {
                refreshGradientInContainer((DrawableContainer) drawable);
            }
        }
    }

    private static void refreshSolidColor(GradientDrawable gradientDrawable) {
        ColorStateList b16;
        if (gradientDrawable == null) {
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            b16 = com.tencent.theme.utils.a.a(gradientDrawable);
        } else if (i3 == 23) {
            b16 = com.tencent.theme.utils.a.c(gradientDrawable.getConstantState());
        } else {
            b16 = com.tencent.theme.utils.a.b(gradientDrawable.getConstantState());
        }
        if (b16 != null) {
            gradientDrawable.setColor(b16);
        }
    }

    private static void refreshStrokeColor(GradientDrawable gradientDrawable) {
        ColorStateList d16;
        int g16;
        Drawable.ConstantState constantState = gradientDrawable.getConstantState();
        if (constantState == null || (d16 = com.tencent.theme.utils.a.d(constantState)) == null || (g16 = com.tencent.theme.utils.a.g(constantState)) == -1) {
            return;
        }
        gradientDrawable.setStroke(g16, d16, com.tencent.theme.utils.a.f(constantState), com.tencent.theme.utils.a.e(constantState));
    }

    private void releaseTempTypedValue(TypedValue typedValue) {
        synchronized (this.mTmpValueLock) {
            if (this.mTempValue == null) {
                this.mTempValue = typedValue;
            }
        }
    }

    private void reloadColor(SkinnableColorStateList skinnableColorStateList) {
        SkinData skinData = skinnableColorStateList.skinData;
        if (this.mSkinRootPath == null && this.mSimpleSkinRootPath == null) {
            skinData.mFilePath = null;
        } else {
            skinData.mFilePath = grabColorFile(this.mResources, skinData.mFileName);
        }
        ISkinTint iSkinTint = this.mSkinTint;
        if (iSkinTint != null && iSkinTint.isTint(skinnableColorStateList.skinData.mFileName) && needTint(skinnableColorStateList.skinData.mFileName)) {
            updateTintedColor(skinnableColorStateList);
        } else {
            skinnableColorStateList.update(loadColor(skinData.mResourcesID, this.mResources, skinData));
        }
    }

    private void reloadImage(BaseConstantState baseConstantState) {
        k kVar = mThemeService;
        if (kVar != null && kVar.switchOn("vas_theme_engine_release_lock", false)) {
            TypedValue obtainTempTypedValue = obtainTempTypedValue();
            try {
                reloadImage(baseConstantState, obtainTempTypedValue);
                return;
            } finally {
                releaseTempTypedValue(obtainTempTypedValue);
            }
        }
        reloadImage(baseConstantState, this.mTmpValue);
    }

    private void resolveSkinData(SkinData skinData, TypedValue typedValue) {
        if (skinData == null) {
            return;
        }
        int i3 = skinData.mOriginalResourcesId;
        if (i3 != 0 && i3 != skinData.mResourcesID) {
            skinData.mResourcesID = i3;
            skinData.mFileName = skinData.mOriginalFileName;
            skinData.mOriginalResourcesId = 0;
            skinData.mOriginalFileName = null;
        }
        h hVar = this.mResourcesTransform;
        if (hVar != null && hVar.needTransformDrawable(skinData.mResourcesID)) {
            resourcesTransform(skinData, typedValue);
        }
    }

    private void resourcesTransform(SkinData skinData, TypedValue typedValue) {
        h.a aVar;
        int i3;
        h hVar = this.mResourcesTransform;
        if (hVar != null) {
            aVar = hVar.transformDrawable(skinData.mResourcesID, skinData.mFileName);
        } else {
            aVar = null;
        }
        if (aVar != null && (i3 = aVar.f376073a) != 0 && i3 != skinData.mResourcesID && !TextUtils.isEmpty(aVar.f376074b)) {
            if (!aVar.f376075c && (this.mSkinRootPath != null || this.mSimpleSkinRootPath != null)) {
                typedValue.resourceId = aVar.f376073a;
                Resources resources = this.mResources;
                String str = aVar.f376074b;
                String[][] strArr = DENSITY_PATH_ORDER;
                int i16 = this.mDensityIndex;
                grabImageFile(resources, typedValue, str, strArr[i16], DENSITY_ORDER[i16]);
                if (typedValue.string == null) {
                    m.c(TAG, "resourcesTransform " + skinData.mFileName + " filePath is null");
                    return;
                }
            }
            skinData.mOriginalResourcesId = skinData.mResourcesID;
            skinData.mOriginalFileName = skinData.mFileName;
            skinData.mResourcesID = aVar.f376073a;
            skinData.mFileName = aVar.f376074b;
            m.c(TAG, "resourcesTransform, resourcesId = " + skinData.mResourcesID + ", fileName = " + skinData.mFileName + ", originalResourcesId = " + skinData.mOriginalResourcesId + ", originalFileName = " + skinData.mOriginalFileName);
        }
    }

    public static void setSKLog(ISkinEngineLog iSkinEngineLog) {
        m.f376084a = iSkinEngineLog;
        m.e(TAG, 2, "set ISkinEngineLog ok", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void startUpdateRes(Context context) {
        m.a(TAG, 1, "UpdateTask switch theme start");
        s sVar = this.mUpdateCallback;
        if (sVar != null) {
            sVar.b();
        }
        update(context);
        System.gc();
        Thread.yield();
        System.gc();
    }

    private void tintConstantState(BaseConstantState baseConstantState, String str) {
        Paint paint;
        tintQuiPic(baseConstantState, str);
        if (this.mSkinTint != null && baseConstantState != null && !TextUtils.isEmpty(str)) {
            if (!(baseConstantState instanceof SkinnableBitmapDrawable.BitmapState) || (paint = ((SkinnableBitmapDrawable.BitmapState) baseConstantState).mPaint) == null) {
                if (baseConstantState instanceof SkinnableNinePatchDrawable.a) {
                    SkinnableNinePatchDrawable.a aVar = (SkinnableNinePatchDrawable.a) baseConstantState;
                    if (aVar.f376036a != null) {
                        paint = aVar.f376043h;
                    }
                }
                paint = null;
            }
            this.mSkinTint.tint(paint, str);
        }
    }

    private void tintQuiPic(BaseConstantState baseConstantState, String str) {
        if (this.mQuiPicRenderColorRes == 0 || !(baseConstantState instanceof SkinnableBitmapDrawable.BitmapState)) {
            return;
        }
        Paint paint = ((SkinnableBitmapDrawable.BitmapState) baseConstantState).mPaint;
        if (paint == null) {
            m.a(TAG, 1, "paint == null");
            return;
        }
        if (isNotQuiRes(str)) {
            return;
        }
        SkinnableColorStateList loadColorStateList = loadColorStateList(this.mQuiPicRenderColorRes);
        if (loadColorStateList == null) {
            m.a(TAG, 1, "color return null, mQUiTokenColorRes : " + this.mQuiPicRenderColorRes);
            return;
        }
        paint.setColorFilter(new LightingColorFilter(0, loadColorStateList.getDefaultColor()));
    }

    private synchronized void update(Context context) {
        boolean z16;
        m.a(TAG, 1, "update start");
        this.mSkinUpdating = true;
        SharedPreferences sharedPreference = getSharedPreference(context);
        String string = sharedPreference.getString(KEY_PENDING_THEME, null);
        String string2 = sharedPreference.getString(KEY_SIMPLE_PENDING_THEME, null);
        if (string2 != null) {
            z16 = sharedPreference.getBoolean(KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED, true);
        } else if (string != null) {
            z16 = sharedPreference.getBoolean(KEY_PENDING_THEME_RESOURCES_IS_COMPLIED, true);
        } else {
            z16 = true;
        }
        synchronized (this.mTmpValue) {
            this.mTempSkinRootPath = getRealRootPath();
            this.mSkinRootPath = string;
            this.mSimpleSkinRootPath = string2;
            this.mIsResourcesComplied = z16;
            initConfig(context.getResources(), this);
            m.a(TAG, 1, "update : mTempSkinRootPath : " + this.mTempSkinRootPath);
            m.a(TAG, 1, "update : mSkinRootPath : " + this.mSkinRootPath);
            m.a(TAG, 1, "update : mSimpleSkinRootPath : " + this.mSimpleSkinRootPath);
            if (this.mFileExistCache != null) {
                m.a(TAG, 1, "mFileExistCache startRecordTask");
                this.mFileExistCache.j();
            }
            updateColorState();
            updateImage();
        }
        if (this.mInSimpleModel) {
            sharedPreference.edit().putString(KEY_SIMPLE_THEME, string2).putBoolean("complied", this.mIsResourcesComplied).commit();
        } else {
            sharedPreference.edit().putString("theme_root", string).putBoolean("complied", this.mIsResourcesComplied).commit();
        }
        this.mSkinUpdating = false;
        this.mTempSkinRootPath = null;
        m.b(TAG_SWITCH, 1, "skinEngine update done", null);
    }

    private void updateColorState() {
        WeakReference<SkinnableColorStateList> weakReference;
        SkinnableColorStateList skinnableColorStateList;
        this.mColorStateListLock.writeLock().lock();
        for (int i3 = 0; i3 < this.mColorStateListCache.size(); i3++) {
            try {
                try {
                    try {
                        weakReference = this.mColorStateListCache.valueAt(i3);
                    } catch (ClassCastException e16) {
                        m.d(TAG, 1, "updateColorState()", e16);
                        weakReference = null;
                    }
                    if (weakReference != null && (skinnableColorStateList = weakReference.get()) != null) {
                        reloadColor(skinnableColorStateList);
                        i iVar = this.mSkinLifecycle;
                        if (iVar != null) {
                            iVar.onColorReloaded(skinnableColorStateList);
                        }
                    }
                } catch (Exception e17) {
                    m.d(TAG, 1, "updateColorState() error", e17);
                }
            } finally {
                this.mColorStateListLock.writeLock().unlock();
            }
        }
    }

    private void updateImage() {
        WeakReference<BaseConstantState> weakReference;
        BaseConstantState baseConstantState;
        this.mDrawableCacheLock.writeLock().lock();
        try {
            try {
                ArrayList arrayList = new ArrayList();
                int size = this.mDrawableCache.size();
                for (int i3 = 0; i3 < size; i3++) {
                    try {
                        weakReference = this.mDrawableCache.valueAt(i3);
                    } catch (ClassCastException e16) {
                        m.d(TAG, 1, "updateImage()", e16);
                        weakReference = null;
                    }
                    if (weakReference != null && (baseConstantState = weakReference.get()) != null) {
                        if (baseConstantState.skinData.mFileName.endsWith(".xml")) {
                            arrayList.add(baseConstantState);
                        } else {
                            reloadImage(baseConstantState);
                            i iVar = this.mSkinLifecycle;
                            if (iVar != null) {
                                iVar.onDrawableReloaded(baseConstantState);
                            }
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    BaseConstantState baseConstantState2 = (BaseConstantState) it.next();
                    reloadImage(baseConstantState2);
                    i iVar2 = this.mSkinLifecycle;
                    if (iVar2 != null) {
                        iVar2.onDrawableReloaded(baseConstantState2);
                    }
                }
            } catch (Exception e17) {
                m.d(TAG, 1, "updateImage error", e17);
            }
        } finally {
            this.mDrawableCacheLock.writeLock().unlock();
        }
    }

    private void updateTintedColor(SkinnableColorStateList skinnableColorStateList) {
        this.mSkinTint.tintColorState(skinnableColorStateList.getColors(), skinnableColorStateList.getStateSpecs(), skinnableColorStateList.skinData.mFileName);
        skinnableColorStateList.setDefaultColor(skinnableColorStateList.getColors(), skinnableColorStateList.getStateSpecs());
    }

    public void addBackupForOOMData(Integer num, BackupForOOMData backupForOOMData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) num, (Object) backupForOOMData);
            return;
        }
        if (this.backupForOOMData == null) {
            this.backupForOOMData = new HashMap<>();
        }
        this.backupForOOMData.put(num, backupForOOMData);
    }

    public final void addDrawableResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.drawableIntercepter.a(this.mResources, i3);
        }
    }

    public boolean checkResExist(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, i3)).booleanValue();
        }
        TypedValue obtainTempTypedValue = obtainTempTypedValue();
        this.mResources.getValue(i3, obtainTempTypedValue, true);
        if (TextUtils.isEmpty(obtainTempTypedValue.string)) {
            releaseTempTypedValue(obtainTempTypedValue);
            return false;
        }
        String charSequence = obtainTempTypedValue.string.toString();
        obtainTempTypedValue.resourceId = i3;
        String substring = charSequence.substring(charSequence.lastIndexOf("/") + 1);
        Resources resources = this.mResources;
        String[][] strArr = DENSITY_PATH_ORDER;
        int i16 = this.mDensityIndex;
        grabImageFile(resources, obtainTempTypedValue, substring, strArr[i16], DENSITY_ORDER[i16]);
        if (obtainTempTypedValue.string != null) {
            releaseTempTypedValue(obtainTempTypedValue);
            return true;
        }
        releaseTempTypedValue(obtainTempTypedValue);
        if (grabColorFile(this.mResources, substring) != null) {
            return true;
        }
        return false;
    }

    public void clearSimpleModel(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
            return;
        }
        getSharedPreference(context).edit().remove(KEY_SIMPLE_PENDING_THEME).remove(KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED).remove(KEY_SIMPLE_THEME).commit();
        this.mInSimpleModel = false;
        this.mSimpleSkinRootPath = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.tencent.theme.SkinEngine] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.util.TypedValue] */
    BaseConstantState createSmallImageFromResourceStream(Resources resources, SkinData skinData, BitmapFactory.Options options, Rect rect, boolean z16, BackupForOOMData backupForOOMData, int i3, boolean z17) {
        String str;
        ?? r36;
        int i16;
        String str2;
        BitmapFactory.Options options2;
        BaseConstantState baseConstantState = null;
        try {
        } catch (Throwable th5) {
            th = th5;
            m.d(str, r36, "skinEngine createSmallImageFromResourceStream: io error", th);
            return baseConstantState;
        }
        if (z17 && backupForOOMData != null) {
            try {
                TypedValue typedValue = new TypedValue();
                this.mResources.getValue(backupForOOMData.backFileResId, typedValue, true);
                String charSequence = typedValue.string.toString();
                SkinData skinData2 = new SkinData();
                skinData2.mResourcesID = backupForOOMData.backFileResId;
                str = charSequence.substring(charSequence.lastIndexOf("/") + 1);
                skinData2.mFileName = str;
                if (this.mSkinRootPath != null || this.mSimpleSkinRootPath != null) {
                    Resources resources2 = this.mResources;
                    String[][] strArr = DENSITY_PATH_ORDER;
                    int i17 = this.mDensityIndex;
                    String[] strArr2 = strArr[i17];
                    int[] iArr = DENSITY_ORDER[i17];
                    r36 = typedValue;
                    grabImageFile(resources2, r36, str, strArr2, iArr);
                    CharSequence charSequence2 = typedValue.string;
                    if (charSequence2 != null) {
                        skinData2.mFilePath = charSequence2.toString();
                        skinData2.mInDensity = typedValue.density;
                    }
                }
                if (skinData2.mFilePath != null) {
                    Rect rect2 = new Rect();
                    BitmapFactory.Options options3 = new BitmapFactory.Options();
                    options3.inDensity = skinData2.mInDensity;
                    options3.inPreferredConfig = backupForOOMData.inPreferredConfig;
                    InputStream inputStream = getInputStream(resources, skinData2.mFilePath);
                    try {
                        baseConstantState = ResourcesFactory.createImageFromResourceStream(resources, null, inputStream, skinData2.mFileName, options3, rect2, this.mIsResourcesComplied);
                    } catch (OutOfMemoryError e16) {
                        m.d(TAG, 1, "skinEngine createSmallImageFromResourceStream: OOM 0, " + skinData2.mFilePath, e16);
                    }
                    inputStream.close();
                } else {
                    try {
                        InputStream openRawResource = resources.openRawResource(backupForOOMData.backFileResId, typedValue);
                        String charSequence3 = typedValue.string.toString();
                        try {
                            options2 = new BitmapFactory.Options();
                            i16 = 1;
                            str2 = TAG;
                        } catch (IOException e17) {
                            e = e17;
                            i16 = 1;
                            str2 = TAG;
                        }
                        try {
                            try {
                                baseConstantState = ResourcesFactory.createImageFromResourceStream(resources, typedValue, openRawResource, charSequence3, options2, rect, true);
                            } catch (OutOfMemoryError e18) {
                                m.d(str2, 1, "skinEngine createSmallImageFromResourceStream: OOM 1, " + backupForOOMData.backFileResId, e18);
                            }
                            openRawResource.close();
                        } catch (IOException e19) {
                            e = e19;
                            m.d(str2, i16, "skinEngine createSmallImageFromResourceStream: IOException, ", e);
                            return baseConstantState;
                        }
                    } catch (Exception e26) {
                        m.d(TAG, 1, "skinEngine createSmallImageFromResourceStream: openRawResource Exception," + backupForOOMData.backFileResId, e26);
                        return null;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                r36 = 1;
                str = TAG;
                m.d(str, r36, "skinEngine createSmallImageFromResourceStream: io error", th);
                return baseConstantState;
            }
            return baseConstantState;
        }
        r36 = 1;
        str = TAG;
        InputStream inputStream2 = getInputStream(resources, skinData.mFilePath);
        options.inJustDecodeBounds = false;
        if (backupForOOMData != null) {
            options.inPreferredConfig = backupForOOMData.inPreferredConfig;
        }
        options.inSampleSize = i3;
        try {
            baseConstantState = ResourcesFactory.createImageFromResourceStream(resources, null, inputStream2, skinData.mFileName, options, rect, this.mIsResourcesComplied);
        } catch (OutOfMemoryError unused) {
            if (DEBUG) {
                Log.w(str, "small Bitmap File:" + skinData.mFilePath + " is OOM");
            }
        }
        inputStream2.close();
        return baseConstantState;
    }

    public int getColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, i3)).intValue();
        }
        synchronized (this.mTmpValue) {
            TypedValue typedValue = this.mTmpValue;
            this.mResources.getValue(i3, typedValue, true);
            int i16 = typedValue.type;
            if (i16 >= 16 && i16 <= 31) {
                return typedValue.data;
            }
            if (i16 == 3) {
                return loadColorStateList(i3).getDefaultColor();
            }
            throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i3) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
        }
    }

    public synchronized Drawable getDefaultThemeDrawable(int i3) {
        BaseConstantState baseConstantState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Drawable) iPatchRedirector.redirect((short) 32, (Object) this, i3);
        }
        synchronized (this.mTmpValue) {
            long j3 = i3;
            WeakReference<BaseConstantState> weakReference = this.mDefaultThemeDrawableCache.get(j3);
            Drawable drawable = null;
            if (weakReference != null) {
                baseConstantState = weakReference.get();
                if (baseConstantState == null) {
                    this.mDefaultThemeDrawableCache.delete(j3);
                }
            } else {
                baseConstantState = null;
            }
            if (baseConstantState == null) {
                if (IS_PROBLEM_CM11) {
                    try {
                        mIconsOfCM.setAccessible(true);
                        mIconsOfCM.set(this.mResources, null);
                        mComposedIconInfoOfCM.setAccessible(true);
                        mComposedIconInfoOfCM.set(this.mResources, null);
                        try {
                            mIconsOfCM.setAccessible(true);
                            mComposedIconInfoOfCM.setAccessible(true);
                            if (mIconsOfCM.get(this.mResources) != null) {
                                if (mComposedIconInfoOfCM.get(this.mResources) != null) {
                                    return null;
                                }
                            }
                        } catch (Exception unused) {
                            return null;
                        }
                    } catch (Exception unused2) {
                        return null;
                    }
                }
                this.mResources.getValue(i3, this.mTmpValue, true);
                String charSequence = this.mTmpValue.string.toString();
                SkinData skinData = new SkinData();
                skinData.mResourcesID = i3;
                skinData.mFileName = charSequence.substring(charSequence.lastIndexOf("/") + 1);
                skinData.mFilePath = null;
                baseConstantState = loadImage(i3, this.mResources, skinData, this.mTmpValue);
                if (baseConstantState != null) {
                    baseConstantState.skinData = skinData;
                    this.mDefaultThemeDrawableCache.put(j3, new WeakReference<>(baseConstantState));
                }
            }
            if (baseConstantState != null) {
                drawable = baseConstantState.newDrawable(this.mResources);
            }
            return drawable;
        }
    }

    public int getDrawableDpi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        String[][] strArr = DENSITY_PATH_ORDER;
        int i3 = this.mDensityIndex;
        String[] strArr2 = strArr[i3];
        int[] iArr = DENSITY_ORDER[i3];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            if (strArr2[i16].equals(str)) {
                return i16;
            }
        }
        if ("color/".equals(str)) {
            return -2;
        }
        return -1;
    }

    public String getRealRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        String str = this.mSimpleSkinRootPath;
        if (str == null) {
            return this.mSkinRootPath;
        }
        return str;
    }

    public SharedPreferences getSharedPreference(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        }
        j jVar = this.mPreference;
        if (jVar != null) {
            return jVar.getPreference();
        }
        m.a(TAG, 1, "getSharedPreference, IThemePreference not set");
        return context.getSharedPreferences("theme", 4);
    }

    public String getSkinRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (this.mSkinUpdating) {
            return this.mTempSkinRootPath;
        }
        return getRealRootPath();
    }

    public Object getThemeConfig(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, obj);
        }
        synchronized (this.mTmpValue) {
            ensureConfigLoaded(this.mIsResourcesComplied);
            Object obj2 = this.mConfigs.get(str);
            if (obj2 == null) {
                obj2 = this.mDefaultConfigs.get(str);
            }
            if (obj2 != null) {
                obj = obj2;
            }
        }
        return obj;
    }

    public File getThemeDirFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mSkinRootPath == null && this.mSimpleSkinRootPath == null) {
            return null;
        }
        return new File(getRealRootPath());
    }

    public SkinnableColorStateList grabImageAndLoadColor(int i3, Resources resources, SkinData skinData) {
        String grabColorFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (SkinnableColorStateList) iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), resources, skinData);
        }
        if (this.mSkinRootPath == null && this.mSimpleSkinRootPath == null) {
            grabColorFile = null;
        } else {
            grabColorFile = grabColorFile(this.mResources, skinData.mFileName);
        }
        skinData.mFilePath = grabColorFile;
        return loadColor(i3, resources, skinData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (com.tencent.theme.engine.utils.c.e(r4.mContext) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isEnableCacheTask() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        k kVar = mThemeService;
        if (kVar != null) {
            z16 = true;
            if (kVar.switchOn("vas_theme_engine_cache_task", true)) {
            }
        }
        z16 = false;
        m.a(TAG_OPTIMIZE, 2, "isEnableCacheTask=" + z16);
        return z16;
    }

    public boolean isInSimpleModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.mInSimpleModel;
    }

    public SkinnableColorStateList loadColorForTheme(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (SkinnableColorStateList) iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) str);
        }
        TypedValue obtainTempTypedValue = obtainTempTypedValue();
        try {
            this.mResources.getValue(i3, obtainTempTypedValue, true);
            String charSequence = obtainTempTypedValue.string.toString();
            if (!charSequence.endsWith(".xml")) {
                return null;
            }
            SkinData skinData = new SkinData();
            skinData.mResourcesID = i3;
            skinData.mFileName = charSequence.substring(charSequence.lastIndexOf("/") + 1);
            return loadColorForTheme(skinData, str);
        } catch (Exception unused) {
            m.a(TAG, 1, "loadColorForTheme error, root path : " + str + " resourceId : " + i3);
            return null;
        } finally {
            releaseTempTypedValue(obtainTempTypedValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SkinnableColorStateList loadColorStateList(int i3) {
        k kVar;
        TypedValue obtainTempTypedValue = obtainTempTypedValue();
        try {
            this.mColorStateListLock.readLock().lock();
            try {
                long j3 = i3;
                WeakReference<SkinnableColorStateList> weakReference = this.mColorStateListCache.get(j3);
                if (weakReference != null) {
                    SkinnableColorStateList skinnableColorStateList = weakReference.get();
                    if (skinnableColorStateList != null) {
                        return skinnableColorStateList;
                    }
                    this.mColorStateListLock.writeLock().lock();
                    try {
                        this.mColorStateListCache.delete(j3);
                        this.mColorStateListLock.writeLock().unlock();
                    } finally {
                    }
                }
                this.mResources.getValue(i3, obtainTempTypedValue, true);
                String charSequence = obtainTempTypedValue.string.toString();
                if (charSequence.endsWith(".xml")) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    SkinData skinData = new SkinData();
                    skinData.mResourcesID = i3;
                    String substring = charSequence.substring(charSequence.lastIndexOf("/") + 1);
                    skinData.mFileName = substring;
                    if (this.mSkinRootPath != null || this.mSimpleSkinRootPath != null) {
                        skinData.mFilePath = grabColorFile(this.mResources, substring);
                    }
                    m.c(TAG, "grab color file finish, skin path : " + skinData.mFilePath + " file name : " + skinData.mFileName);
                    SkinnableColorStateList loadColor = loadColor(i3, this.mResources, skinData);
                    loadColor.skinData = skinData;
                    this.mColorStateListLock.writeLock().lock();
                    try {
                        this.mColorStateListCache.put(j3, new WeakReference<>(loadColor));
                        i iVar = this.mSkinLifecycle;
                        if (iVar != null) {
                            iVar.onColorLoaded(loadColor);
                        }
                        this.mColorStateListLock.writeLock().unlock();
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        if (uptimeMillis2 >= 2000 && (kVar = mThemeService) != null) {
                            kVar.reportLoadOverTime(skinData.mFileName, uptimeMillis2, 2);
                        }
                        return loadColor;
                    } finally {
                    }
                }
                m.a(TAG, 1, "not xml res color, res id : " + i3);
                return null;
            } finally {
                this.mColorStateListLock.readLock().unlock();
            }
        } catch (Resources.NotFoundException e16) {
            m.b(TAG, 1, "res not found, res id : " + i3, e16);
            return null;
        } finally {
            releaseTempTypedValue(obtainTempTypedValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable.ConstantState loadConstantState(int i3) {
        Drawable.ConstantState loadConstantState;
        k kVar = mThemeService;
        if (kVar != null && kVar.switchOn("vas_theme_engine_load_sync", false)) {
            synchronized (this.mTmpValue) {
                loadConstantState = loadConstantState(i3, true);
            }
            return loadConstantState;
        }
        return loadConstantState(i3, true);
    }

    public Drawable loadDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Drawable) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        synchronized (this.mTmpValue) {
            Drawable.ConstantState loadConstantState = loadConstantState(i3);
            if (loadConstantState != null) {
                return loadConstantState.newDrawable(this.mResources);
            }
            return null;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public com.tencent.theme.BaseConstantState loadImage(int r28, android.content.res.Resources r29, com.tencent.theme.SkinData r30, android.util.TypedValue r31) {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.theme.SkinEngine.loadImage(int, android.content.res.Resources, com.tencent.theme.SkinData, android.util.TypedValue):com.tencent.theme.BaseConstantState");
    }

    public void notifyUIChanged(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        Intent intent = new Intent(ACTION_THEME_INVALIDATE);
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        m.f(TAG_SWITCH, "notifyUIChanged sendBroadcast(ACTION_THEME_INVALIDATE)");
    }

    public int recordDpiFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).intValue();
        }
        int[][] iArr = DENSITY_ORDER;
        int i3 = this.mDensityIndex;
        int[] iArr2 = iArr[i3];
        String[] strArr = DENSITY_PATH_ORDER[i3];
        if (this.mSkinRootPath == null && this.mSimpleSkinRootPath == null) {
            return -1;
        }
        for (int i16 = 0; i16 < iArr2.length; i16++) {
            String str2 = getRealRootPath() + strArr[i16] + str;
            if (str2.startsWith(ASSET_PATH)) {
                return -2;
            }
            if (new File(str2).exists()) {
                return i16;
            }
        }
        return -3;
    }

    public Object[] releasePreloadDrawableCache() {
        int i3;
        LongSparseArray<Drawable.ConstantState>[] longSparseArrayArr;
        Field field;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Object[]) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        Object[] objArr = new Object[2];
        Field field2 = null;
        try {
            field2 = Class.forName("android.graphics.drawable.NinePatchDrawable").getDeclaredField("mNinePatch");
            field2.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException e16) {
            e16.printStackTrace();
        }
        e eVar = this.drawableIntercepter;
        long j3 = 0;
        if (eVar != null && (longSparseArrayArr = eVar.f376051b) != null) {
            i3 = 0;
            for (LongSparseArray<Drawable.ConstantState> longSparseArray : longSparseArrayArr) {
                int i16 = 0;
                while (i16 < longSparseArray.size()) {
                    int i17 = i3 + 1;
                    Drawable.ConstantState valueAt = longSparseArray.valueAt(i16);
                    if (valueAt != null) {
                        Drawable newDrawable = valueAt.newDrawable();
                        if (newDrawable instanceof BitmapDrawable) {
                            if (((BitmapDrawable) newDrawable).getBitmap() != null) {
                                j3 += r0.getByteCount();
                            }
                        } else {
                            if (newDrawable instanceof NinePatchDrawable) {
                                if (field2 == null) {
                                    j3++;
                                } else {
                                    try {
                                        obj = field2.get((NinePatchDrawable) newDrawable);
                                    } catch (IllegalAccessException e17) {
                                        e = e17;
                                        field = field2;
                                    }
                                    if (obj instanceof NinePatch) {
                                        NinePatch ninePatch = (NinePatch) obj;
                                        field = field2;
                                        try {
                                            j3 += ninePatch.getWidth() * ninePatch.getHeight();
                                        } catch (IllegalAccessException e18) {
                                            e = e18;
                                            e.printStackTrace();
                                            j3++;
                                            i16++;
                                            i3 = i17;
                                            field2 = field;
                                        }
                                        i16++;
                                        i3 = i17;
                                        field2 = field;
                                    }
                                }
                            } else {
                                field = field2;
                            }
                            j3++;
                            i16++;
                            i3 = i17;
                            field2 = field;
                        }
                    }
                    field = field2;
                    i16++;
                    i3 = i17;
                    field2 = field;
                }
                longSparseArray.clear();
            }
        } else {
            i3 = 0;
        }
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Long.valueOf(j3);
        return objArr;
    }

    public void setPreference(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar);
        } else {
            this.mPreference = jVar;
        }
    }

    public void setQuiPicRenderColorRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mQuiPicRenderColorRes = i3;
        }
    }

    public void setResourcesTransform(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) hVar);
        } else {
            this.mResourcesTransform = hVar;
        }
    }

    public void setSkinEngineHandler(SkinEngineHandler skinEngineHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) skinEngineHandler);
        } else {
            this.mSkinEngineHandler = skinEngineHandler;
        }
    }

    public void setSkinLifecycle(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iVar);
        } else {
            this.mSkinLifecycle = iVar;
        }
    }

    public boolean setSkinRootPath(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? setSkinRootPath(context, str, true) : ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) str)).booleanValue();
    }

    public void setSkinTint(ISkinTint iSkinTint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iSkinTint);
        } else {
            this.mSkinTint = iSkinTint;
        }
    }

    public void setThemeService(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) kVar);
        } else {
            mThemeService = kVar;
        }
    }

    public void setUpdateCallback(s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) sVar);
        } else {
            this.mUpdateCallback = sVar;
        }
    }

    public boolean switchToSimpleModel(Context context, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? switchToSimpleModel(context, nVar, true) : ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, (Object) nVar)).booleanValue();
    }

    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            if (this.drawableIntercepter != null) {
                Field declaredField = Resources.class.getDeclaredField("sPreloadedDrawables");
                declaredField.setAccessible(true);
                if (declaredField.getDeclaringClass().isArray()) {
                    declaredField.set(null, this.drawableIntercepter.f376051b);
                } else {
                    declaredField.set(null, this.drawableIntercepter.f376051b[0]);
                }
            }
            try {
                Field declaredField2 = Resources.class.getDeclaredField("sPreloadedColorStateLists");
                declaredField2.setAccessible(true);
                declaredField2.set(null, this.colorStateListPreloadIntercepter.f376048e);
            } catch (Exception unused) {
                Field declaredField3 = Resources.class.getDeclaredField("mPreloadedColorStateLists");
                declaredField3.setAccessible(true);
                Object obj = declaredField3.get(this.mResources);
                if (obj instanceof SparseArray) {
                    declaredField3.set(null, this.colorStateListPreloadIntercepter15.f376045e);
                } else if (obj instanceof LongSparseArray) {
                    declaredField3.set(null, this.colorStateListPreloadIntercepter.f376048e);
                }
            }
        } catch (Exception e16) {
            if (DEBUG) {
                Log.e(TAG, "resotre SkinEngine failed", e16);
            }
        }
    }

    public InputStream useCacheInputStream(String str) {
        g gVar;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (InputStream) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        }
        if (isEnableCacheTask() && (gVar = this.mFileExistCache) != null && (bArr = gVar.f376067f.get(str)) != null) {
            if (DEBUG) {
                m.a(TAG_OPTIMIZE, 2, "cache found, use cache:" + str);
            }
            return new ByteArrayInputStream(bArr);
        }
        return null;
    }

    public void writeCacheFile(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) file);
        } else {
            this.drawableIntercepter.d(file);
        }
    }

    private SkinnableColorStateList loadColor(int i3, Resources resources, SkinData skinData) {
        SkinnableColorStateList realLoadColor;
        synchronized (this.mTmpValue) {
            realLoadColor = realLoadColor(i3, resources, skinData);
        }
        return realLoadColor;
    }

    public boolean setSkinRootPath(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, context, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.mSkinUpdating) {
            m.a(TAG_SWITCH, 1, "[setSkinRootPath] mSkinUpdating is true");
            return false;
        }
        m.a(TAG_SWITCH, 1, "[setSkinRootPath] start");
        clearSimpleModel(context);
        SharedPreferences sharedPreference = getSharedPreference(context);
        if (str == null) {
            sharedPreference.edit().remove(KEY_PENDING_THEME).remove(KEY_PENDING_THEME_RESOURCES_IS_COMPLIED).commit();
        } else {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            if (str.startsWith(ASSET_PATH)) {
                sharedPreference.edit().putString(KEY_PENDING_THEME, str).putBoolean(KEY_PENDING_THEME_RESOURCES_IS_COMPLIED, z16).commit();
            } else {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    sharedPreference.edit().putString(KEY_PENDING_THEME, str).putBoolean(KEY_PENDING_THEME_RESOURCES_IS_COMPLIED, z16).commit();
                } else {
                    if (DEBUG) {
                        Log.w(TAG, "[setSkinRootPath] wrong skinPath: " + str);
                    }
                    sharedPreference.edit().remove(KEY_PENDING_THEME).putBoolean(KEY_PENDING_THEME_RESOURCES_IS_COMPLIED, z16).commit();
                }
            }
        }
        context.sendBroadcast(new Intent(ACTION_THEME_UPDATE), "com.tencent.msg.permission.pushnotify");
        m.a(TAG_SWITCH, 1, "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
        return true;
    }

    public boolean switchToSimpleModel(Context context, n nVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, context, nVar, Boolean.valueOf(z16))).booleanValue();
        }
        if (nVar == null) {
            m.a(TAG_SWITCH, 1, "[switchToSimpleModel] data is null");
            return false;
        }
        if (this.mSkinUpdating) {
            m.a(TAG_SWITCH, 1, "[switchToSimpleModel] mSkinUpdating is true");
            return false;
        }
        SharedPreferences sharedPreference = getSharedPreference(context);
        String str = nVar.f376085a;
        if (str == null) {
            sharedPreference.edit().remove(KEY_SIMPLE_PENDING_THEME).remove(KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED).commit();
        } else {
            if (!str.endsWith("/")) {
                nVar.f376085a += "/";
            }
            if (nVar.f376085a.startsWith(ASSET_PATH)) {
                sharedPreference.edit().putString(KEY_SIMPLE_PENDING_THEME, nVar.f376085a).putBoolean(KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED, z16).commit();
            } else {
                File file = new File(nVar.f376085a);
                if (file.exists() && file.isDirectory()) {
                    sharedPreference.edit().putString(KEY_SIMPLE_PENDING_THEME, nVar.f376085a).putBoolean(KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED, z16).commit();
                } else {
                    m.a(TAG, 1, "[setSkinRootPath] wrong skinPath: " + nVar.f376085a);
                    sharedPreference.edit().remove(KEY_SIMPLE_PENDING_THEME).putBoolean(KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED, z16).commit();
                }
            }
        }
        this.mInSimpleModel = true;
        this.mSimpleSkinRootPath = nVar.f376085a;
        context.sendBroadcast(new Intent(ACTION_THEME_UPDATE), "com.tencent.msg.permission.pushnotify");
        m.a(TAG_SWITCH, 1, "[switchToSimpleModel] sendBroadcast(ACTION_THEME_UPDATE)");
        return true;
    }

    Drawable.ConstantState loadConstantState(int i3, boolean z16) {
        WeakReference<BaseConstantState> weakReference;
        k kVar;
        ReentrantReadWriteLock.WriteLock writeLock;
        h hVar;
        ReentrantReadWriteLock.WriteLock writeLock2;
        TypedValue obtainTempTypedValue = obtainTempTypedValue();
        try {
            try {
                this.mDrawableCacheLock.readLock().lock();
                try {
                    weakReference = this.mDrawableCache.get(i3);
                    this.mDrawableCacheLock.readLock().unlock();
                } catch (Exception unused) {
                    this.mDrawableCacheLock.readLock().unlock();
                    weakReference = null;
                } catch (Throwable th5) {
                    this.mDrawableCacheLock.readLock().unlock();
                    throw th5;
                }
                if (weakReference != null) {
                    BaseConstantState baseConstantState = weakReference.get();
                    if (baseConstantState != null) {
                        return baseConstantState;
                    }
                    this.mDrawableCacheLock.writeLock().lock();
                    try {
                        this.mDrawableCache.delete(i3);
                        writeLock2 = this.mDrawableCacheLock.writeLock();
                    } catch (Exception unused2) {
                        writeLock2 = this.mDrawableCacheLock.writeLock();
                    } catch (Throwable th6) {
                        throw th6;
                    }
                    writeLock2.unlock();
                }
                if (IS_PROBLEM_CM11) {
                    try {
                        mIconsOfCM.setAccessible(true);
                        mIconsOfCM.set(this.mResources, null);
                        mComposedIconInfoOfCM.setAccessible(true);
                        mComposedIconInfoOfCM.set(this.mResources, null);
                        try {
                            mIconsOfCM.setAccessible(true);
                            mComposedIconInfoOfCM.setAccessible(true);
                            if (mIconsOfCM.get(this.mResources) != null) {
                                if (mComposedIconInfoOfCM.get(this.mResources) != null) {
                                    return null;
                                }
                            }
                        } catch (Exception unused3) {
                            return null;
                        }
                    } catch (Exception unused4) {
                        return null;
                    }
                }
                this.mResources.getValue(i3, obtainTempTypedValue, true);
                CharSequence charSequence = obtainTempTypedValue.string;
                if (charSequence == null) {
                    return null;
                }
                String charSequence2 = charSequence.toString();
                SkinData skinData = new SkinData();
                skinData.mResourcesID = i3;
                skinData.mFileName = charSequence2.substring(charSequence2.lastIndexOf("/") + 1);
                if (z16 && (hVar = this.mResourcesTransform) != null && hVar.needTransformDrawable(i3)) {
                    resourcesTransform(skinData, obtainTempTypedValue);
                }
                if (this.mSkinRootPath != null || this.mSimpleSkinRootPath != null) {
                    Resources resources = this.mResources;
                    String str = skinData.mFileName;
                    String[][] strArr = DENSITY_PATH_ORDER;
                    int i16 = this.mDensityIndex;
                    grabImageFile(resources, obtainTempTypedValue, str, strArr[i16], DENSITY_ORDER[i16]);
                    CharSequence charSequence3 = obtainTempTypedValue.string;
                    if (charSequence3 != null) {
                        skinData.mFilePath = charSequence3.toString();
                        skinData.mInDensity = obtainTempTypedValue.density;
                    }
                }
                if (isTrackLoadRes()) {
                    m.c(TAG, "SkinEngine loadConstantState begin, resourceID -> " + i3 + " , mFileName -> " + skinData.mFileName + " , mFilePath -> " + skinData.mFilePath + ", mResources.getValue -> " + obtainTempTypedValue + ", cacheSize: " + this.mDrawableCache.size());
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                BaseConstantState loadImage = loadImage(skinData.mResourcesID, this.mResources, skinData, obtainTempTypedValue);
                if (loadImage != null) {
                    SkinData skinData2 = loadImage.skinData;
                    skinData.mTintColorResId = skinData2 != null ? skinData2.mTintColorResId : 0;
                    loadImage.skinData = skinData;
                    this.mDrawableCacheLock.writeLock().lock();
                    try {
                        try {
                            this.mDrawableCache.put(i3, new WeakReference<>(loadImage));
                            i iVar = this.mSkinLifecycle;
                            if (iVar != null) {
                                iVar.onDrawableLoaded(loadImage);
                            }
                            writeLock = this.mDrawableCacheLock.writeLock();
                        } catch (Exception e16) {
                            m.d(TAG, 1, "loadConstantState error result", e16);
                            writeLock = this.mDrawableCacheLock.writeLock();
                        }
                        writeLock.unlock();
                        m.c(TAG, "SkinEngine loadConstantState success, resourceID -> " + i3 + " , mFileName -> " + skinData.mFileName + " , mFilePath -> " + skinData.mFilePath + ", mResources.getValue -> " + obtainTempTypedValue + ", cacheSize: " + this.mDrawableCache.size());
                    } finally {
                        this.mDrawableCacheLock.writeLock().unlock();
                    }
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 >= 2000 && (kVar = mThemeService) != null) {
                    kVar.reportLoadOverTime(skinData.mFileName, uptimeMillis2, 1);
                }
                return loadImage;
            } catch (Resources.NotFoundException unused5) {
                releaseTempTypedValue(obtainTempTypedValue);
                return null;
            }
        } finally {
            releaseTempTypedValue(obtainTempTypedValue);
        }
    }

    private void reloadImage(BaseConstantState baseConstantState, TypedValue typedValue) {
        ISkinTint iSkinTint;
        Paint paint;
        Paint paint2;
        SkinData skinData = baseConstantState.skinData;
        int i3 = skinData.mResourcesID;
        String str = skinData.mFilePath;
        resolveSkinData(skinData, typedValue);
        if (this.mSkinRootPath == null && this.mSimpleSkinRootPath == null) {
            skinData.mFilePath = null;
        } else {
            typedValue.resourceId = skinData.mResourcesID;
            Resources resources = this.mResources;
            String str2 = skinData.mFileName;
            String[][] strArr = DENSITY_PATH_ORDER;
            int i16 = this.mDensityIndex;
            grabImageFile(resources, typedValue, str2, strArr[i16], DENSITY_ORDER[i16]);
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                skinData.mFilePath = charSequence.toString();
                skinData.mInDensity = typedValue.density;
            } else {
                skinData.mFilePath = null;
            }
        }
        if (isTrackLoadRes()) {
            m.c(TAG, "SkinEngine reloadImage : cs -> " + baseConstantState + ",fileName -> " + skinData.mFileName + ", mFilePath -> " + skinData.mFilePath + ", oldFilePath -> " + str + ", resourceID -> " + skinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.mDrawableCache.size());
        }
        if (str == null && skinData.mFilePath == null && !skinData.mFileName.endsWith(".xml") && (iSkinTint = this.mSkinTint) != null && !iSkinTint.isTint(skinData.mFileName) && isNotQuiRes(skinData.mFileName) && i3 == skinData.mResourcesID) {
            if ((baseConstantState instanceof SkinnableBitmapDrawable.BitmapState) && (paint2 = ((SkinnableBitmapDrawable.BitmapState) baseConstantState).mPaint) != null) {
                paint2.setColorFilter(null);
                return;
            } else {
                if (!(baseConstantState instanceof SkinnableNinePatchDrawable.a) || (paint = ((SkinnableNinePatchDrawable.a) baseConstantState).f376043h) == null) {
                    return;
                }
                paint.setColorFilter(null);
                return;
            }
        }
        if (baseConstantState instanceof SkinnableBitmapDrawable.BitmapState) {
            SkinnableBitmapDrawable.BitmapState bitmapState = (SkinnableBitmapDrawable.BitmapState) baseConstantState;
            BaseConstantState loadImage = loadImage(skinData.mResourcesID, this.mResources, skinData, typedValue);
            if (loadImage == null) {
                if (isTrackLoadRes()) {
                    m.c(TAG, "SkinEngine reloadImage : _loadImage fail, fileName -> " + skinData.mFileName + ", mFilePath -> " + skinData.mFilePath + ", resourceID -> " + skinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.mDrawableCache.size());
                }
                if (DEBUG) {
                    throw new NullPointerException("loadImage failed, file path: " + skinData.mFilePath + " , resource name:" + skinData.mFileName);
                }
                return;
            }
            if (DEBUG && (loadImage instanceof SkinnableNinePatchDrawable.a)) {
                throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + skinData.mFilePath + " , resource name:" + skinData.mFileName);
            }
            if (isTrackLoadRes()) {
                m.c(TAG, "SkinEngine reloadImage : _loadImage success, fileName -> " + skinData.mFileName + ", mFilePath -> " + skinData.mFilePath + ", oldFilePath -> " + str + ", resourceID -> " + skinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.mDrawableCache.size());
            }
            SkinnableBitmapDrawable.BitmapState bitmapState2 = (SkinnableBitmapDrawable.BitmapState) loadImage;
            bitmapState.mBitmap = bitmapState2.mBitmap;
            bitmapState.bitmapType = bitmapState2.bitmapType;
            bitmapState.hasProblem = bitmapState2.hasProblem;
            bitmapState.mPaint = bitmapState2.mPaint;
            bitmapState.mImageSizeWhenOOM = bitmapState2.mImageSizeWhenOOM;
            if (bitmapState.mBuildFromXml || bitmapState2.mBuildFromXml) {
                bitmapState.mGravity = bitmapState2.mGravity;
                bitmapState.mTileModeX = bitmapState2.mTileModeX;
                bitmapState.mTileModeY = bitmapState2.mTileModeY;
                bitmapState.mBuildFromXml = true;
            }
            tintConstantState(bitmapState2, skinData.mFileName);
            return;
        }
        if (baseConstantState instanceof SkinnableNinePatchDrawable.a) {
            SkinnableNinePatchDrawable.a aVar = (SkinnableNinePatchDrawable.a) baseConstantState;
            BaseConstantState loadImage2 = loadImage(skinData.mResourcesID, this.mResources, skinData, typedValue);
            if (loadImage2 == null) {
                if (isTrackLoadRes()) {
                    m.c(TAG, "SkinEngine reloadImage : _loadImage fail, fileName -> " + skinData.mFileName + ", mFilePath -> " + skinData.mFilePath + ", resourceID -> " + skinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.mDrawableCache.size());
                }
                if (DEBUG) {
                    throw new NullPointerException("loadImage failed, file path: " + skinData.mFilePath + " , resource name:" + skinData.mFileName);
                }
                return;
            }
            if (DEBUG && (loadImage2 instanceof SkinnableBitmapDrawable.BitmapState)) {
                throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + skinData.mFilePath + " , resource name:" + skinData.mFileName);
            }
            if (isTrackLoadRes()) {
                m.c(TAG, "SkinEngine reloadImage : _loadImage success, fileName -> " + skinData.mFileName + ", mFilePath -> " + skinData.mFilePath + ", oldFilePath -> " + str + ", resourceID -> " + skinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.mDrawableCache.size());
            }
            SkinnableNinePatchDrawable.a aVar2 = (SkinnableNinePatchDrawable.a) loadImage2;
            aVar.mImageSizeWhenOOM = aVar2.mImageSizeWhenOOM;
            aVar.f376036a = aVar2.f376036a;
            aVar.f376043h = aVar2.f376043h;
            aVar.f376038c = aVar.f376037b;
            aVar.f376037b = aVar2.f376037b;
            aVar.f376042g = aVar2.f376042g;
            aVar.hasProblem = aVar2.hasProblem;
            tintConstantState(aVar2, skinData.mFileName);
        }
    }

    public SkinnableColorStateList loadColorForTheme(SkinData skinData, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (SkinnableColorStateList) iPatchRedirector.redirect((short) 29, (Object) this, (Object) skinData, (Object) str);
        }
        if (skinData == null || skinData.mFileName == null || skinData.mResourcesID == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return loadDefaultColor(skinData);
        }
        File file = new File(generateColorPath(skinData.mFileName, str));
        if (!file.exists()) {
            return loadDefaultColor(skinData);
        }
        return loadColor(file);
    }

    public static void init(Context context, int[] iArr, int[] iArr2) throws UnSupportPlatformException {
        m.a(TAG, 1, "start new init");
        long uptimeMillis = SystemClock.uptimeMillis();
        SkinEngine instances2 = getInstances();
        Resources resources = context.getResources();
        instances2.mContext = context.getApplicationContext();
        instances2.mResources = resources;
        isSupportPlatform(context, resources);
        instances2.mDensityIndex = getDensityIndex(instances2.mResources);
        SharedPreferences sharedPreference = instances2.getSharedPreference(context);
        instances2.mSkinRootPath = sharedPreference.getString("theme_root", null);
        String string = sharedPreference.getString(KEY_SIMPLE_THEME, null);
        instances2.mSimpleSkinRootPath = string;
        instances2.mInSimpleModel = string != null;
        context.getApplicationContext().registerReceiver(instances2.mReceiver, new IntentFilter(ACTION_THEME_UPDATE), "com.tencent.msg.permission.pushnotify", null);
        TextHook.getInstance().switchFont(context, sharedPreference.getString(KEY_THEME_FONT, null));
        initSync(instances2, resources, iArr, iArr2);
        if (instances2.mInSimpleModel) {
            instances2.mIsResourcesComplied = sharedPreference.getBoolean("complied", true);
        } else {
            instances2.mIsResourcesComplied = sharedPreference.getBoolean("complied", true);
        }
        clearSystemSelectorCache();
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        instances2.sStatisticMap.put("init_total", Long.valueOf(uptimeMillis2));
        m.a(TAG, 1, "SkinEngine init cost time : " + uptimeMillis2);
    }
}
