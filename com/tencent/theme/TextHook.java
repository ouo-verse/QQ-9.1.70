package com.tencent.theme;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.theme.font.IFontHook;
import com.tencent.theme.font.MiuiFontHook;
import com.tencent.theme.font.OppoFontHook;
import com.tencent.theme.utils.BrandUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TextHook {
    static IPatchRedirector $redirector_ = null;
    private static final String[] SUPPORT_PROCESS;
    public static final String TAG = "TextHook";
    private static final TextHook mInstance;
    private static Boolean mIsSupportFont;
    private static String sCurrentFontPath;
    private Typeface mCurrentTf;
    private final Typeface mDefaultSansSerif;
    private IFontHook mFontHook;
    private boolean mIsInitFontHook;
    public HashMap<String, Typeface> mTypefaceMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class SwitchFontTask extends AsyncTask<Context, String, Context> {
        static IPatchRedirector $redirector_;

        SwitchFontTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextHook.this);
        }

        /* synthetic */ SwitchFontTask(TextHook textHook, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) textHook, (Object) anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Context doInBackground(Context... contextArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contextArr);
            }
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                String str = TextHook.sCurrentFontPath;
                if (!TextUtils.isEmpty(str) && TextHook.isSupportProcess(contextArr[0])) {
                    synchronized (SwitchFontTask.class) {
                        if (TextHook.this.mTypefaceMap.get(str) != null) {
                            TextHook textHook = TextHook.this;
                            textHook.setsSystemFontMap(textHook.mTypefaceMap.get(str));
                            return contextArr[0];
                        }
                        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                            return null;
                        }
                        Typeface createFromFile = Typeface.createFromFile(new File(str));
                        TextHook.this.mTypefaceMap.put(str, createFromFile);
                        TextHook.this.setsSystemFontMap(createFromFile);
                        m.a(TextHook.TAG, 1, "SwitchFontTask load fontFile cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                        return contextArr[0];
                    }
                }
            } catch (Exception unused) {
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            } else if (context != null) {
                TextHook.this.update(context);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        SUPPORT_PROCESS = new String[]{"", "qzone"};
        mInstance = new TextHook();
        sCurrentFontPath = "";
        mIsSupportFont = null;
    }

    TextHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDefaultSansSerif = Typeface.SANS_SERIF;
        this.mIsInitFontHook = false;
        this.mTypefaceMap = new HashMap<>();
    }

    public static String getFontPath(Context context) {
        try {
            return SkinEngine.getInstances().getSharedPreference(context).getString(SkinEngine.KEY_THEME_FONT, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static TextHook getInstance() {
        try {
            return mInstance;
        } catch (Exception unused) {
            return mInstance;
        }
    }

    public static String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            String str = null;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getTypefaceStyle(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            return typeface.getStyle();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isSupportProcess(Context context) {
        Boolean bool;
        try {
            bool = mIsSupportFont;
        } catch (Exception unused) {
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        String processName = getProcessName(context);
        if (processName == null) {
            return false;
        }
        String[] split = processName.split(":");
        String str = "";
        if (split.length > 1) {
            str = split[1];
        }
        for (String str2 : SUPPORT_PROCESS) {
            if (str.equals(str2)) {
                mIsSupportFont = Boolean.TRUE;
                return true;
            }
        }
        mIsSupportFont = Boolean.FALSE;
        return false;
    }

    public static boolean isSysCustomFont(Context context) {
        TextView textView;
        try {
            textView = new TextView(context);
        } catch (Exception e16) {
            m.a(TAG, 1, "isSysCustomFont error : " + e16.getMessage());
        }
        if (textView.getPaint().getTypeface() == Typeface.SANS_SERIF) {
            return false;
        }
        if (textView.getPaint().getTypeface() != getInstance().mCurrentTf) {
            return true;
        }
        return false;
    }

    private void lazyInitFontHook() {
        if (!this.mIsInitFontHook) {
            if (BrandUtil.isMiui()) {
                this.mFontHook = new MiuiFontHook();
            } else if (BrandUtil.isOppo()) {
                this.mFontHook = new OppoFontHook();
            }
            this.mIsInitFontHook = true;
        }
    }

    private void nativeSetDefault(Typeface typeface) {
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            Method declaredMethod = Typeface.class.getDeclaredMethod("nativeSetDefault", Long.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(typeface, declaredField.get(typeface));
        } catch (Exception e16) {
            m.d(TAG, 1, "nativeSetDefault error", e16);
        }
    }

    private void replaceTypefaceField(String str, Object obj) {
        try {
            Field declaredField = Typeface.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception e16) {
            m.a(TAG, 1, "replaceTypefaceField error : " + e16.getMessage());
        }
    }

    private void replaceTypefaceMap(Typeface typeface) {
        try {
            Field declaredField = Typeface.class.getDeclaredField("sDefaults");
            declaredField.setAccessible(true);
            Typeface[] typefaceArr = (Typeface[]) declaredField.get(null);
            typefaceArr[0] = typeface;
            typefaceArr[1] = typeface;
        } catch (Exception e16) {
            m.a(TAG, 1, "replaceTypefaceMap error : " + e16.getMessage());
        }
    }

    public static void saveLastPath(Context context, String str) {
        try {
            SkinEngine.getInstances().getSharedPreference(context).edit().putString(SkinEngine.KEY_THEME_FONT, str).commit();
        } catch (Exception unused) {
        }
    }

    public static void setSupportProcess(boolean z16) {
        try {
            mIsSupportFont = Boolean.valueOf(z16);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setsSystemFontMap(Typeface typeface) {
        this.mCurrentTf = typeface;
        try {
            lazyInitFontHook();
            IFontHook iFontHook = this.mFontHook;
            if (iFontHook != null) {
                iFontHook.hookFont();
            }
            replaceSystemDefaultFont(typeface);
            replaceTypefaceMap(typeface);
            Field declaredField = Typeface.class.getDeclaredField("sSystemFontMap");
            declaredField.setAccessible(true);
            HashMap hashMap = new HashMap((Map) declaredField.get(null));
            hashMap.put("sans-serif", typeface);
            declaredField.set(null, hashMap);
            nativeSetDefault(typeface);
        } catch (Exception e16) {
            m.a(TAG, 1, "setsSystemFontMap error : " + e16.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void updateFont(View view) {
        Boolean bool;
        try {
            Typeface typeface = getInstance().mCurrentTf;
            if (view != 0 && typeface != null && (bool = mIsSupportFont) != null && bool.booleanValue()) {
                if (SkinEngine.DEBUG) {
                    m.a(TAG, 1, "start update font, root view : " + view);
                }
                if (view instanceof ISkinIgnoreTypeface) {
                    m.a(TAG, 1, "root is instance of ISkinIgnoreTypeface");
                    return;
                }
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    if (textView.getTypeface() != typeface) {
                        textView.setTypeface(typeface, getTypefaceStyle(textView.getTypeface()));
                        return;
                    }
                    return;
                }
                if (view instanceof ISkinTypeface) {
                    Paint paint = ((ISkinTypeface) view).getPaint();
                    if (paint != null && paint.getTypeface() != typeface) {
                        paint.setTypeface(typeface);
                        view.requestLayout();
                        view.invalidate();
                        return;
                    }
                    return;
                }
                if (view instanceof ISkinSetTypeface) {
                    ((ISkinSetTypeface) view).setTypeface(typeface);
                    view.requestLayout();
                    view.invalidate();
                } else if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        updateFont(viewGroup.getChildAt(i3));
                    }
                }
            }
        } catch (Exception e16) {
            m.a(TAG, 1, "updateFont error : " + e16.getMessage());
        }
    }

    public void checkTypeface(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        try {
            m.a(TAG, 1, "start checkTypeface");
            if (!isSupportProcess(context)) {
                m.a(TAG, 1, "not support process");
                return;
            }
            String fontPath = getFontPath(context);
            if (!TextUtils.isEmpty(fontPath)) {
                if (this.mTypefaceMap.get(fontPath) == null) {
                    if (new File(fontPath).exists()) {
                        Typeface createFromFile = Typeface.createFromFile(new File(fontPath));
                        this.mTypefaceMap.put(fontPath, createFromFile);
                        setsSystemFontMap(createFromFile);
                        return;
                    }
                    return;
                }
                if (this.mTypefaceMap.get(fontPath) != this.mCurrentTf) {
                    setsSystemFontMap(this.mTypefaceMap.get(fontPath));
                    return;
                }
                return;
            }
            switchDefault();
        } catch (Exception e16) {
            m.a(TAG, 1, "checkTypeface error : " + e16.getMessage());
        }
    }

    public Typeface getSystemDefaultFont() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Typeface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return this.mDefaultSansSerif;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isDefault() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            Typeface typeface = this.mCurrentTf;
            if (typeface == null) {
                return true;
            }
            if (this.mDefaultSansSerif.equals(typeface)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public void replaceSystemDefaultFont(Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) typeface);
            return;
        }
        try {
            replaceTypefaceField("DEFAULT", typeface);
            replaceTypefaceField("DEFAULT_BOLD", typeface);
            replaceTypefaceField("SANS_SERIF", typeface);
            replaceTypefaceField("SERIF", typeface);
        } catch (Exception e16) {
            m.a(TAG, 1, "replaceSystemDefaultFont error : " + e16.getMessage());
        }
    }

    public void switchDefault() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            setsSystemFontMap(this.mDefaultSansSerif);
            IFontHook iFontHook = this.mFontHook;
            if (iFontHook != null) {
                iFontHook.restore();
            }
        } catch (Exception unused) {
        }
    }

    public boolean switchFont(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        sCurrentFontPath = str;
                        new SwitchFontTask(this, null).execute(context);
                        return true;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void update(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        try {
            Intent intent = new Intent(SkinEngine.ACTION_THEME_INVALIDATE);
            intent.putExtra("isFont", true);
            context.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } catch (Exception unused) {
        }
    }
}
