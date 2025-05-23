package ie0;

import android.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.biz.qui.quitoken.QUITokenConstants;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements QUITokenConstants {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f407556d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f407557a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f407558b;

    /* renamed from: c, reason: collision with root package name */
    private final List<InterfaceC10522a> f407559c = new ArrayList();

    /* compiled from: P */
    /* renamed from: ie0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC10522a {
        boolean a(Context context);

        ColorStateList b(Context context, int i3, int i16);
    }

    a() {
    }

    private boolean b(Context context) {
        for (int i3 = 0; i3 < this.f407559c.size(); i3++) {
            if (this.f407559c.get(i3).a(context)) {
                return true;
            }
        }
        return false;
    }

    private SkinData c(SkinData skinData) {
        SkinData skinData2 = new SkinData();
        skinData2.mTintColorResId = skinData.mTintColorResId;
        skinData2.mResourcesID = skinData.mResourcesID;
        skinData2.mFilePath = skinData.mFilePath;
        skinData2.mFileName = skinData.mFileName;
        skinData2.mOriginalResourcesId = skinData.mOriginalResourcesId;
        skinData2.mOriginalFileName = skinData.mOriginalFileName;
        return skinData2;
    }

    private int d(float f16, int i3) {
        return (Math.min(255, Math.max(0, (int) (f16 * 255.0f))) << 24) + (i3 & 16777215);
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00a3: MOVE (r8 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:164), block:B:63:0x00a3 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String e(AssetManager assetManager, String str) {
        Throwable th5;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        r8 = null;
        r8 = null;
        String str2 = null;
        bufferedReader3 = null;
        try {
            try {
                inputStream = assetManager.open(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (IOException e16) {
                    e = e16;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    th5 = th;
                    if (bufferedReader3 != null) {
                    }
                    if (inputStream == null) {
                    }
                }
            } catch (IOException e17) {
                e = e17;
                inputStream = null;
                bufferedReader = null;
            } catch (Throwable th7) {
                th5 = th7;
                inputStream = null;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e18) {
                        d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets close input stream error, fileName:", str, e18);
                    }
                }
                if (inputStream == null) {
                    try {
                        inputStream.close();
                        throw th5;
                    } catch (IOException e19) {
                        d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets close content reader error, fileName:", str, e19);
                        throw th5;
                    }
                }
                throw th5;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                str2 = sb5.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e26) {
                    d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets close input stream error, fileName:", str, e26);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e27) {
                        d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets close content reader error, fileName:", str, e27);
                    }
                }
            } catch (IOException e28) {
                e = e28;
                d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets error, fileName:", str, e);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e29) {
                        d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets close input stream error, fileName:", str, e29);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e36) {
                        d.b("QUITokenThemeManager", d.f438811e, "getContentFromAssets close content reader error, fileName:", str, e36);
                    }
                }
                return str2;
            }
            return str2;
        } catch (Throwable th8) {
            th = th8;
            bufferedReader3 = bufferedReader2;
        }
    }

    public static a f() {
        if (f407556d == null) {
            synchronized (a.class) {
                if (f407556d == null) {
                    f407556d = new a();
                }
            }
        }
        return f407556d;
    }

    private ColorStateList i(Context context, int i3, int i16) {
        for (int i17 = 0; i17 < this.f407559c.size(); i17++) {
            ColorStateList b16 = this.f407559c.get(i17).b(context, i3, i16);
            if (b16 != null) {
                return b16;
            }
        }
        return null;
    }

    private synchronized void q(Context context) {
        if (context == null) {
            d.a("QUITokenThemeManager", d.f438811e, "loadConfig, Context is null!");
            return;
        }
        if (this.f407557a == null || this.f407558b == null) {
            this.f407557a = new HashMap();
            this.f407558b = new HashMap();
            String e16 = e(context.getAssets(), QUITokenConstants.CONFIG_FILE_NAME);
            if (TextUtils.isEmpty(e16)) {
                d.a("QUITokenThemeManager", d.f438811e, "loadConfig, getContentFromAssets returns null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(e16);
                JSONObject optJSONObject = jSONObject.optJSONObject(String.valueOf(1002));
                if (optJSONObject == null) {
                    d.a("QUITokenThemeManager", d.f438811e, "loadConfig for night, theme json is null");
                    return;
                }
                s(optJSONObject.optJSONObject("color"), this.f407557a);
                JSONObject optJSONObject2 = jSONObject.optJSONObject(String.valueOf(1001));
                if (optJSONObject2 == null) {
                    d.a("QUITokenThemeManager", d.f438811e, "loadConfig for default, theme json is null");
                    return;
                }
                s(optJSONObject2.optJSONObject("color"), this.f407558b);
            } catch (JSONException e17) {
                d.b("QUITokenThemeManager", d.f438811e, "parse config error : ", e17);
            }
        }
    }

    private Drawable r(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        return drawable.mutate();
    }

    private void s(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && map != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                map.put(str, jSONObject.optString(str));
            }
        }
    }

    private void t(Context context, Drawable drawable, int i3, int i16, int i17) {
        BaseConstantState baseConstantState;
        SkinData skinData;
        drawable.setColorFilter(new LightingColorFilter(0, i16));
        if (!b(context)) {
            return;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof BaseConstantState) || (skinData = (baseConstantState = (BaseConstantState) constantState).skinData) == null) {
            return;
        }
        SkinData c16 = c(skinData);
        if (i17 == 1000) {
            c16.mTintColorResId = i3;
        } else {
            c16.mTintColorResId = 0;
            c16.mFileName = null;
        }
        baseConstantState.skinData = c16;
    }

    public void a(InterfaceC10522a interfaceC10522a) {
        this.f407559c.add(interfaceC10522a);
    }

    public int g(Context context, int i3, int i16) {
        ColorStateList i17 = i(context, i3, i16);
        if (i17 != null) {
            return i17.getDefaultColor();
        }
        if (context == null) {
            d.a("QUITokenThemeManager", d.f438811e, "getQuiColor, context is null");
            return SupportMenu.CATEGORY_MASK;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            d.a("QUITokenThemeManager", d.f438811e, "getQuiColor, Resources is null");
            return SupportMenu.CATEGORY_MASK;
        }
        if (i16 == 1000) {
            return resources.getColor(i3);
        }
        ColorStateList h16 = h(context, i3, i16);
        if (h16 == null) {
            d.a("QUITokenThemeManager", d.f438811e, "getQuiColor, colorStateList is null.");
            return SupportMenu.CATEGORY_MASK;
        }
        return h16.getDefaultColor();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097 A[Catch: Exception -> 0x0070, LOOP:0: B:33:0x0094->B:35:0x0097, LOOP_END, TryCatch #0 {Exception -> 0x0070, blocks: (B:44:0x005b, B:46:0x0063, B:29:0x008c, B:32:0x0090, B:33:0x0094, B:35:0x0097, B:37:0x00a2, B:25:0x0076, B:27:0x007e), top: B:43:0x005b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ColorStateList h(Context context, int i3, int i16) {
        int i17;
        ColorStateList i18 = i(context, i3, i16);
        if (i18 != null) {
            return i18;
        }
        String[] strArr = null;
        if (context == null) {
            d.a("QUITokenThemeManager", d.f438811e, "getQuiColorStateList, context is null");
            return null;
        }
        q(context);
        Resources resources = context.getResources();
        if (resources == null) {
            d.a("QUITokenThemeManager", d.f438811e, "getQuiColorStateList, Resources is null");
            return null;
        }
        String resourceEntryName = resources.getResourceEntryName(i3);
        ColorStateList colorStateList = resources.getColorStateList(i3);
        if (i16 != 1000 && this.f407558b.size() != 0 && this.f407557a.size() != 0 && (colorStateList instanceof SkinnableColorStateList)) {
            if (i16 == 1002) {
                try {
                    if (this.f407557a.containsKey(resourceEntryName)) {
                        strArr = this.f407557a.get(resourceEntryName).split(",");
                        if (strArr != null && strArr.length > 0) {
                            int[] iArr = new int[strArr.length];
                            for (i17 = 0; i17 < strArr.length; i17++) {
                                iArr[i17] = Color.parseColor(strArr[i17]);
                            }
                            return new ColorStateList(((SkinnableColorStateList) colorStateList).getStateSpecs(), iArr);
                        }
                    }
                } catch (Exception e16) {
                    d.b("QUITokenThemeManager", d.f438811e, "getQuiColorStateList error : ", e16);
                }
            }
            if (i16 == 1001 && this.f407558b.containsKey(resourceEntryName)) {
                strArr = this.f407558b.get(resourceEntryName).split(",");
            }
            if (strArr != null) {
                int[] iArr2 = new int[strArr.length];
                while (i17 < strArr.length) {
                }
                return new ColorStateList(((SkinnableColorStateList) colorStateList).getStateSpecs(), iArr2);
            }
        }
        return colorStateList;
    }

    public String[] j(Context context, String str, boolean z16) {
        Map<String, String> map;
        String str2;
        Map<String, String> map2;
        if (context == null) {
            d.a("QUITokenThemeManager", d.f438811e, "getQuiDefaultColors, context is null");
            return null;
        }
        q(context);
        if (z16 && (map2 = this.f407557a) != null) {
            String str3 = map2.get(str);
            if (str3 != null) {
                return str3.split(",");
            }
        } else if (!z16 && (map = this.f407558b) != null && (str2 = map.get(str)) != null) {
            return str2.split(",");
        }
        return null;
    }

    public Drawable k(Context context, int i3, float f16, int i16) {
        return l(context, i3, new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, i16);
    }

    public Drawable l(Context context, int i3, float[] fArr, int i16) {
        ColorStateList h16 = h(context, i3, i16);
        if (h16 == null) {
            return new GradientDrawable();
        }
        int defaultColor = h16.getDefaultColor();
        if (fArr == null || fArr.length != 8) {
            fArr = new float[]{4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f};
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(defaultColor);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public Drawable m(Context context, int i3, float f16, int i16) {
        return n(context, i3, new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, i16);
    }

    public Drawable n(Context context, int i3, float[] fArr, int i16) {
        ColorStateList h16 = h(context, i3, i16);
        if (h16 == null) {
            return new GradientDrawable();
        }
        int defaultColor = h16.getDefaultColor();
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (fArr == null || fArr.length != 8) {
            fArr = new float[]{4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(d(50.0f, defaultColor));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable);
        gradientDrawable.mutate();
        gradientDrawable.setColor(d(20.0f, defaultColor));
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
        gradientDrawable.mutate();
        gradientDrawable.setColor(defaultColor);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public Drawable o(Context context, int i3, int i16, int i17) {
        int g16 = g(context, i16, i17);
        Drawable r16 = r(context.getDrawable(i3));
        t(context, r16, i16, g16, i17);
        return r16;
    }

    public Drawable p(Context context, int i3, int i16, int i17) {
        int g16 = g(context, i16, i17);
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable r16 = r(context.getDrawable(i3));
        t(context, r16, i16, g16, i17);
        r16.setAlpha(127);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, r16);
        stateListDrawable.addState(new int[]{R.attr.state_selected}, r16);
        Drawable r17 = r(r16);
        t(context, r17, i16, g16, i17);
        r17.setAlpha(51);
        stateListDrawable.addState(new int[]{-16842910}, r17);
        Drawable r18 = r(r17);
        r18.setAlpha(255);
        t(context, r18, i16, g16, i17);
        stateListDrawable.addState(new int[0], r18);
        return stateListDrawable;
    }
}
