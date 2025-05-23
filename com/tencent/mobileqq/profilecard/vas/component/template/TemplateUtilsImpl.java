package com.tencent.mobileqq.profilecard.vas.component.template;

import android.R;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.g;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.image.Utils;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.profile.o;
import com.tencent.mobileqq.profile.p;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.theme.ThemeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TemplateUtilsImpl implements ITemplateUtils {
    public static final boolean FEATURE_UPDATE_CARD_UI_2 = ThemeService.switchOn("vas_theme_engine_feature_mutate", false, true);
    private UpdateViewAttrDispatch updateDispatcher = new UpdateViewAttrDispatch();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class TemplateColorStateList {
        private static List<ItemStateSpec> stateSpecList;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public static class ItemStateSpec {
            String key;
            int spec1;
            int spec2;
            boolean status;

            public ItemStateSpec(String str, boolean z16, int i3, int i16) {
                this.key = str;
                this.status = z16;
                this.spec1 = i3;
                this.spec2 = i16;
            }

            public static ItemStateSpec newInstance(String str, boolean z16, int i3, int i16) {
                return new ItemStateSpec(str, z16, i3, i16);
            }
        }

        TemplateColorStateList() {
        }

        static int getStateSpec(JSONObject jSONObject, String str) {
            initStateSpecList(jSONObject);
            for (int i3 = 0; i3 < stateSpecList.size(); i3++) {
                ItemStateSpec itemStateSpec = stateSpecList.get(i3);
                if (itemStateSpec.key.equalsIgnoreCase(str)) {
                    if (itemStateSpec.status) {
                        return itemStateSpec.spec1;
                    }
                    return itemStateSpec.spec2;
                }
            }
            return 0;
        }

        private static void initStateSpecList(JSONObject jSONObject) {
            ArrayList arrayList = new ArrayList();
            stateSpecList = arrayList;
            arrayList.add(ItemStateSpec.newInstance("state_pressed", jSONObject.optBoolean("state_pressed"), R.attr.state_pressed, -16842919));
            stateSpecList.add(ItemStateSpec.newInstance("state_focused", jSONObject.optBoolean("state_focused"), R.attr.state_focused, -16842908));
            stateSpecList.add(ItemStateSpec.newInstance("state_selected", jSONObject.optBoolean("state_selected"), R.attr.state_selected, -16842913));
            stateSpecList.add(ItemStateSpec.newInstance("state_checkable", jSONObject.optBoolean("state_checkable"), R.attr.state_checkable, -16842911));
            stateSpecList.add(ItemStateSpec.newInstance("state_checked", jSONObject.optBoolean("state_checked"), R.attr.state_checked, -16842912));
            stateSpecList.add(ItemStateSpec.newInstance("state_enabled", jSONObject.optBoolean("state_enabled"), R.attr.state_enabled, -16842910));
            stateSpecList.add(ItemStateSpec.newInstance("state_window_focused", jSONObject.optBoolean("state_window_focused"), R.attr.state_window_focused, -16842909));
        }

        static ColorStateList invoke(JSONArray jSONArray) {
            String optString;
            if (jSONArray != null) {
                int i3 = 20;
                int[] iArr = new int[20];
                int[][] iArr2 = new int[20];
                int length = jSONArray.length();
                int i16 = 0;
                for (int i17 = 0; i17 < length; i17++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i17);
                    if (optJSONObject != null && optJSONObject.has("color") && (optString = optJSONObject.optString("color")) != null && optString.length() > 0) {
                        Iterator keys = optJSONObject.keys();
                        int[] iArr3 = new int[optJSONObject.length()];
                        int i18 = SupportMenu.CATEGORY_MASK;
                        int i19 = 0;
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            if (str.equalsIgnoreCase("color")) {
                                i18 = Color.parseColor(optString);
                            } else {
                                int stateSpec = getStateSpec(optJSONObject, str);
                                if (stateSpec > 0) {
                                    iArr3[i19] = stateSpec;
                                    i19++;
                                }
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr3, i19);
                        int i26 = i16 + 1;
                        if (i26 >= i3) {
                            int[] iArr4 = new int[i26];
                            System.arraycopy(iArr, 0, iArr4, 0, i16);
                            int[][] iArr5 = new int[i26];
                            System.arraycopy(iArr2, 0, iArr5, 0, i16);
                            iArr2 = iArr5;
                            iArr = iArr4;
                            i3 = i26;
                        }
                        iArr[i16] = i18;
                        iArr2[i16] = trimStateSet;
                        i16 = i26;
                    }
                }
                int[] iArr6 = new int[i16];
                int[][] iArr7 = new int[i16];
                System.arraycopy(iArr, 0, iArr6, 0, i16);
                System.arraycopy(iArr2, 0, iArr7, 0, i16);
                return new ColorStateList(iArr7, iArr6);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class TemplateStateListDrawable {
        private static List<ItemStateSpec> stateSpecList;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public static class ItemStateSpec {
            String key;
            int spec1;
            int spec2;
            boolean status;

            public ItemStateSpec(String str, boolean z16, int i3, int i16) {
                this.key = str;
                this.status = z16;
                this.spec1 = i3;
                this.spec2 = i16;
            }

            public static ItemStateSpec newInstance(String str, boolean z16, int i3, int i16) {
                return new ItemStateSpec(str, z16, i3, i16);
            }
        }

        TemplateStateListDrawable() {
        }

        private static void addDrawableState(ITemplateUtils iTemplateUtils, ProfileCardTemplate profileCardTemplate, StateListDrawable stateListDrawable, JSONObject jSONObject, String str) {
            Iterator keys = jSONObject.keys();
            int[] iArr = new int[jSONObject.length()];
            Drawable drawable = null;
            int i3 = 0;
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (str2.equalsIgnoreCase("drawable")) {
                    drawable = iTemplateUtils.getTemplateDrawable(profileCardTemplate, true, false, str);
                } else {
                    int stateSpec = getStateSpec(jSONObject, str2);
                    if (stateSpec > 0) {
                        iArr[i3] = stateSpec;
                        i3++;
                    }
                }
            }
            int[] trimStateSet = StateSet.trimStateSet(iArr, i3);
            if (drawable != null) {
                stateListDrawable.addState(trimStateSet, drawable);
            }
        }

        private static int getStateSpec(JSONObject jSONObject, String str) {
            initStateSpecList(jSONObject);
            for (int i3 = 0; i3 < stateSpecList.size(); i3++) {
                ItemStateSpec itemStateSpec = stateSpecList.get(i3);
                if (itemStateSpec.key.equalsIgnoreCase(str)) {
                    if (itemStateSpec.status) {
                        return itemStateSpec.spec1;
                    }
                    return itemStateSpec.spec2;
                }
            }
            return 0;
        }

        private static void initStateSpecList(JSONObject jSONObject) {
            ArrayList arrayList = new ArrayList();
            stateSpecList = arrayList;
            arrayList.add(ItemStateSpec.newInstance("state_pressed", jSONObject.optBoolean("state_pressed"), R.attr.state_pressed, -16842919));
            stateSpecList.add(ItemStateSpec.newInstance("state_focused", jSONObject.optBoolean("state_focused"), R.attr.state_focused, -16842908));
            stateSpecList.add(ItemStateSpec.newInstance("state_hovered", jSONObject.optBoolean("state_hovered"), R.attr.state_hovered, -16843623));
            stateSpecList.add(ItemStateSpec.newInstance("state_selected", jSONObject.optBoolean("state_selected"), R.attr.state_selected, -16842913));
            stateSpecList.add(ItemStateSpec.newInstance("state_checkable", jSONObject.optBoolean("state_checkable"), R.attr.state_checkable, -16842911));
            stateSpecList.add(ItemStateSpec.newInstance("state_checked", jSONObject.optBoolean("state_checked"), R.attr.state_checked, -16842912));
            stateSpecList.add(ItemStateSpec.newInstance("state_enabled", jSONObject.optBoolean("state_enabled"), R.attr.state_enabled, -16842910));
            stateSpecList.add(ItemStateSpec.newInstance("state_activated", jSONObject.optBoolean("state_activated"), R.attr.state_activated, -16843518));
            stateSpecList.add(ItemStateSpec.newInstance("state_window_focused", jSONObject.optBoolean("state_window_focused"), R.attr.state_window_focused, -16842909));
        }

        static StateListDrawable invoke(ITemplateUtils iTemplateUtils, ProfileCardTemplate profileCardTemplate, JSONArray jSONArray) {
            String optString;
            if (jSONArray == null) {
                return null;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && optJSONObject.has("drawable") && (optString = optJSONObject.optString("drawable")) != null && optString.length() > 0) {
                    addDrawableState(iTemplateUtils, profileCardTemplate, stateListDrawable, optJSONObject, optString);
                }
            }
            return stateListDrawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class TemplateXmlBitmap {
        TemplateXmlBitmap() {
        }

        static Drawable invoke(ITemplateUtils iTemplateUtils, ProfileCardTemplate profileCardTemplate, JSONObject jSONObject) {
            String optString;
            if (jSONObject != null && jSONObject.has("src") && (optString = jSONObject.optString("src")) != null && optString.length() > 0) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) iTemplateUtils.getTemplateDrawable(profileCardTemplate, true, false, optString);
                Iterator keys = jSONObject.keys();
                if (bitmapDrawable != null) {
                    while (keys.hasNext()) {
                        setDrawableAttr(profileCardTemplate, jSONObject, bitmapDrawable, keys);
                    }
                    return bitmapDrawable;
                }
                return null;
            }
            return null;
        }

        private static void setDrawableAttr(ProfileCardTemplate profileCardTemplate, JSONObject jSONObject, BitmapDrawable bitmapDrawable, Iterator<String> it) {
            String next = it.next();
            if (next.equalsIgnoreCase("antialias")) {
                bitmapDrawable.setAntiAlias(jSONObject.optBoolean("antialias"));
                return;
            }
            if (next.equalsIgnoreCase("dither")) {
                bitmapDrawable.setDither(jSONObject.optBoolean("dither"));
                return;
            }
            if (next.equalsIgnoreCase("filter")) {
                bitmapDrawable.setFilterBitmap(jSONObject.optBoolean("filter"));
                return;
            }
            if (next.equalsIgnoreCase(LayoutAttrDefine.Gravity.Gravity)) {
                String lowerCase = jSONObject.optString(LayoutAttrDefine.Gravity.Gravity).toLowerCase();
                if (!TextUtils.isEmpty(lowerCase)) {
                    HashMap<String, Integer> hashMap = ProfileCardTemplate.GRAVITY_MAP;
                    if (hashMap.containsKey(lowerCase)) {
                        bitmapDrawable.setGravity(hashMap.get(lowerCase).intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            if (next.equalsIgnoreCase("tileMode")) {
                String lowerCase2 = jSONObject.optString("tileMode", "disabled").toLowerCase();
                if (!TextUtils.isEmpty(lowerCase2)) {
                    HashMap<String, Shader.TileMode> hashMap2 = ProfileCardTemplate.TILE_MODE_MAP;
                    if (hashMap2.containsKey(lowerCase2)) {
                        Shader.TileMode tileMode = hashMap2.get(lowerCase2);
                        bitmapDrawable.setTileModeXY(tileMode, tileMode);
                        return;
                    }
                }
                bitmapDrawable.setTileModeXY(null, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class UpdateViewAttrDispatch {
        UpdateViewAttrDispatch() {
        }

        private Drawable muteProxy(Drawable drawable) {
            if (!TemplateUtilsImpl.FEATURE_UPDATE_CARD_UI_2 && (drawable instanceof SkinnableBitmapDrawable)) {
                return ((SkinnableBitmapDrawable) drawable).mutate2();
            }
            return drawable.mutate();
        }

        private void setViewPaddings(View view, Drawable drawable) {
            Drawable newDrawable = drawable.getConstantState().newDrawable();
            Rect rect = new Rect();
            newDrawable.getPadding(rect);
            int paddingTop = view.getPaddingTop() + rect.top;
            int paddingLeft = view.getPaddingLeft() + rect.left;
            int paddingRight = view.getPaddingRight() + rect.right;
            int paddingBottom = view.getPaddingBottom() + rect.bottom;
            View findViewById = view.findViewById(com.tencent.mobileqq.R.id.m2g);
            view.setBackground(newDrawable);
            if (findViewById != null) {
                findViewById.setBackground(newDrawable);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }

        void dispatchApngDrawable(String str, View view, Object obj) {
            if (str.equals("apngDrawable") && (obj instanceof Drawable)) {
                ((ImageView) view).setImageDrawable((Drawable) obj);
            }
        }

        void dispatchBackground(String str, View view, Object obj) {
            if (!str.equals("background")) {
                return;
            }
            if (obj instanceof Drawable) {
                setViewPaddings(view, (Drawable) obj);
            } else if (obj instanceof String) {
                String str2 = (String) obj;
                if (str2.startsWith("#")) {
                    view.setBackgroundColor(Color.parseColor(str2));
                }
            }
        }

        void dispatchColor(String str, View view, Object obj) {
            if (!str.equals("color")) {
                return;
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (obj instanceof ColorStateList) {
                    textView.setTextColor((ColorStateList) obj);
                } else if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.startsWith("#")) {
                        textView.setTextColor(Color.parseColor(str2));
                    }
                }
            }
            if (view instanceof SingleLineTextView) {
                SingleLineTextView singleLineTextView = (SingleLineTextView) view;
                if (obj instanceof ColorStateList) {
                    singleLineTextView.setTextColor((ColorStateList) obj);
                } else if (obj instanceof String) {
                    String str3 = (String) obj;
                    if (str3.startsWith("#")) {
                        singleLineTextView.setTextColor(Color.parseColor(str3));
                    }
                }
            }
            if (obj instanceof ColorStateList) {
                int defaultColor = ((ColorStateList) obj).getDefaultColor();
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    if (imageView.getDrawable() != null) {
                        Drawable muteProxy = muteProxy(imageView.getDrawable());
                        muteProxy.setColorFilter(defaultColor, PorterDuff.Mode.SRC_ATOP);
                        imageView.setImageDrawable(muteProxy);
                        return;
                    } else {
                        if (imageView.getBackground() != null) {
                            Drawable muteProxy2 = muteProxy(imageView.getBackground());
                            muteProxy2.setColorFilter(defaultColor, PorterDuff.Mode.SRC_ATOP);
                            imageView.setBackground(muteProxy2);
                            return;
                        }
                        return;
                    }
                }
                Drawable background = view.getBackground();
                if (background != null) {
                    Drawable muteProxy3 = muteProxy(background);
                    muteProxy3.setColorFilter(defaultColor, PorterDuff.Mode.SRC_ATOP);
                    view.setBackground(muteProxy3);
                }
            }
        }

        void dispatchContentBackground(String str, View view, Object obj) {
            boolean z16;
            if (str.equals("contentBackground") && ((z16 = obj instanceof Drawable))) {
                ListView listView = (ListView) view;
                if (z16) {
                    listView.setContentBackground(((Drawable) obj).getConstantState().newDrawable());
                }
            }
        }

        void dispatchDrawableleft(String str, View view, Object obj) {
            boolean z16;
            if (str.equals("drawableleft") && ((z16 = obj instanceof Drawable))) {
                TextView textView = (TextView) view;
                if (z16) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(((Drawable) obj).getConstantState().newDrawable(), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        }

        void dispatchDrawableright(String str, View view, Object obj) {
            boolean z16;
            if (str.equals("drawableright") && ((z16 = obj instanceof Drawable))) {
                TextView textView = (TextView) view;
                if (z16) {
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ((Drawable) obj).getConstantState().newDrawable(), (Drawable) null);
                }
            }
        }

        void dispatchShimmerMask(String str, View view, Object obj) {
            if (str.equals("shimmer_mask") && (obj instanceof BitmapDrawable)) {
                ((ShimmerLinearLayout) view).setMask(((BitmapDrawable) obj).getBitmap(), 1, 2000, 1000);
            }
        }

        void dispatchSrc(String str, View view, Object obj) {
            boolean z16;
            if (str.equals("src") && ((z16 = obj instanceof Drawable))) {
                ImageView imageView = (ImageView) view;
                if (z16) {
                    imageView.setImageDrawable(((Drawable) obj).getConstantState().newDrawable());
                }
            }
        }
    }

    private boolean checkValidate(View view, String str, ProfileCardTemplate profileCardTemplate, String str2) {
        if (view == null || profileCardTemplate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || ProfileTemplateApi.isDiyTemplateStyleID(profileCardTemplate.styleId) || profileCardTemplate.templateAttr.get(str2) == null) {
            return false;
        }
        return true;
    }

    private void closeResponse(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JSONObject loadConfigContent(long j3) {
        String str;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (j3 == 1) {
            str = "config_white.json";
        } else {
            str = "config_black.json";
        }
        profileCardColorLevelDebugQLog("loadConfigContent config file is " + str);
        if (j3 == 1 && (jSONObject2 = ProfileCardTemplate.mWhiteStyleConfig) != null) {
            return jSONObject2;
        }
        if (j3 != 1 && (jSONObject = ProfileCardTemplate.mBlackStyleConfig) != null) {
            return jSONObject;
        }
        profileCardColorLevelDebugQLog("loadConfigContent from file=" + str);
        String e16 = ProfileCardTemplateUtil.e(-1L);
        InputStream inputStream = null;
        if (e16 != null && e16.length() > 0) {
            String str2 = e16 + File.separator + str;
            try {
                try {
                    File file = new File(str2);
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            String str3 = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                            if (str3.length() > 0) {
                                if (j3 == 1) {
                                    JSONObject jSONObject3 = new JSONObject(str3);
                                    ProfileCardTemplate.mWhiteStyleConfig = jSONObject3;
                                    closeResponse(fileInputStream);
                                    return jSONObject3;
                                }
                                JSONObject jSONObject4 = new JSONObject(str3);
                                ProfileCardTemplate.mBlackStyleConfig = jSONObject4;
                                closeResponse(fileInputStream);
                                return jSONObject4;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                            closeResponse(fileInputStream);
                            return null;
                        }
                    } else {
                        fileInputStream = null;
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    closeResponse(inputStream);
                    throw th;
                }
                closeResponse(fileInputStream);
            } catch (Throwable th6) {
                th = th6;
                inputStream = str2;
                closeResponse(inputStream);
                throw th;
            }
        }
        return null;
    }

    private void profileCardColorLevelDebugQLog(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, str);
        }
    }

    protected Drawable checkBitmapType(String str, Drawable drawable, Resources resources, Bitmap bitmap) {
        if (str.endsWith(".9.png")) {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (ninePatchChunk != null) {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(resources, bitmap, ninePatchChunk, new Rect(0, 0, 0, 0), null);
                ninePatchDrawable.setTargetDensity(resources.getDisplayMetrics());
                return ninePatchDrawable;
            }
            return drawable;
        }
        if (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg")) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        }
        return drawable;
    }

    protected Drawable checkCacheDrawable(boolean z16, String str, String str2) {
        if (z16) {
            Object g16 = ImageCacheHelper.f98636a.g(str2);
            if (g16 instanceof g) {
                return ((Drawable.ConstantState) ((g) g16).b()).newDrawable();
            }
            return null;
        }
        return null;
    }

    protected Bitmap getBitmap(String str, Resources resources, String str2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 320;
        options.inScreenDensity = resources.getDisplayMetrics().densityDpi;
        options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        options.inScaled = true;
        if (str.endsWith(".jpg") || str.endsWith(".jpeg")) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
        bufferedInputStream.close();
        return decodeStream;
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    public Drawable getTemplateDrawable(ProfileCardTemplate profileCardTemplate, boolean z16, boolean z17, String str) {
        Drawable checkBitmapType;
        try {
            Resources resources = BaseApplication.getContext().getResources();
            String e16 = ProfileCardTemplateUtil.e(-1L);
            if (isValid(str) && isValid(e16)) {
                String str2 = e16 + File.separator + str;
                if (z17) {
                    str2 = str;
                }
                String str3 = "profilecard:" + str2;
                Drawable checkCacheDrawable = checkCacheDrawable(z16, str2, str3);
                if (checkCacheDrawable != null) {
                    return checkCacheDrawable;
                }
                Bitmap bitmap = getBitmap(str, resources, str2);
                int bitmapSize = Utils.getBitmapSize(bitmap);
                if (bitmap == null) {
                    checkBitmapType = null;
                } else {
                    checkBitmapType = checkBitmapType(str, null, resources, bitmap);
                }
                if (checkBitmapType != null && z16) {
                    ImageCacheHelper.f98636a.i(str3, new g(checkBitmapType.getConstantState(), bitmapSize), Business.AIO);
                }
                return checkBitmapType;
            }
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        } catch (Throwable th5) {
            th5.printStackTrace();
            profileCardColorLevelDebugQLog("getTemplateDrawable exception fileName=" + str + ",msg=" + th5.getMessage());
            return null;
        }
    }

    protected Object getTypeObj(ProfileCardTemplate profileCardTemplate, JSONObject jSONObject, String str) {
        if (str.equalsIgnoreCase("ColorStateList")) {
            return TemplateColorStateList.invoke(jSONObject.optJSONArray("data"));
        }
        if (str.equalsIgnoreCase("BitmapDrawable")) {
            return getTemplateDrawable(profileCardTemplate, true, false, jSONObject.optString("data"));
        }
        if (str.equalsIgnoreCase("XMLBitmap")) {
            return TemplateXmlBitmap.invoke(this, profileCardTemplate, jSONObject.optJSONObject("data"));
        }
        if (str.equalsIgnoreCase("StateListDrawable")) {
            return TemplateStateListDrawable.invoke(this, profileCardTemplate, jSONObject.optJSONArray("data"));
        }
        if (str.equalsIgnoreCase(Entry.DATA_TYPE_STRING)) {
            return jSONObject.optString("data");
        }
        if (str.equalsIgnoreCase("Color")) {
            return jSONObject.optString("data");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5 A[Catch: all -> 0x00f1, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0028, B:8:0x002e, B:11:0x0030, B:12:0x0034, B:14:0x003a, B:16:0x0040, B:18:0x0049, B:20:0x004f, B:23:0x0056, B:25:0x005c, B:29:0x0075, B:32:0x007b, B:38:0x0097, B:40:0x009d, B:41:0x00df, B:43:0x00e5, B:46:0x00ef, B:50:0x0082, B:52:0x0088, B:56:0x0091), top: B:2:0x0001 }] */
    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean initTemplateConfig(ProfileCardTemplate profileCardTemplate, long j3, long j16) {
        boolean z16;
        JSONObject loadConfigContent;
        synchronized (profileCardTemplate) {
            profileCardColorLevelDebugQLog("initTemplateConfig config file is " + j3);
            String str = "";
            String str2 = ProfileCardTemplate.STYLE_NAME_MAP.get(String.valueOf(j16));
            boolean z17 = true;
            try {
                loadConfigContent = loadConfigContent(j3);
            } catch (Exception e16) {
                e = e16;
            }
            if (loadConfigContent == null) {
                return false;
            }
            Iterator keys = loadConfigContent.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                try {
                    if (!str3.startsWith("common") && (TextUtils.isEmpty(str2) || !str3.startsWith(str2))) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "initTemplateConfig config key is not used,key=" + str3);
                        }
                        str = str3;
                    }
                    if (parseCommonJson(profileCardTemplate, str3, loadConfigContent)) {
                        return false;
                    }
                    str = str3;
                } catch (Exception e17) {
                    e = e17;
                    str = str3;
                    if (QLog.isColorLevel()) {
                        QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "initTemplateConfig key=" + str + ",exception msg=" + (e.getClass().getName() + "," + e.getMessage()));
                    }
                    e.printStackTrace();
                    z16 = false;
                    if (z16) {
                    }
                    z17 = false;
                    return z17;
                }
            }
            if (j16 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC && j16 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
                z16 = true;
                if (z16 || profileCardTemplate.templateAttr.size() <= 0) {
                    z17 = false;
                }
                return z17;
            }
            z16 = parseWzryTemplate(profileCardTemplate, true);
            if (z16) {
            }
            z17 = false;
            return z17;
        }
    }

    protected boolean isValid(String str) {
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    protected boolean parseCommonJson(ProfileCardTemplate profileCardTemplate, String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("type");
            if (optString != null && optString.length() > 0) {
                Object typeObj = getTypeObj(profileCardTemplate, optJSONObject, optString);
                if (typeObj != null) {
                    profileCardTemplate.templateAttr.put(str, typeObj);
                    if (QLog.isColorLevel()) {
                        QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "initTemplateConfig config key= " + str + ",put templateAttr and size=" + profileCardTemplate.templateAttr.size());
                        return false;
                    }
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "initTemplateConfig config key= " + str + ",init error");
                    return true;
                }
                return true;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "initTemplateConfig config key= " + str + ",value is null");
            return false;
        }
        return false;
    }

    protected boolean parseWzryTemplate(ProfileCardTemplate profileCardTemplate, boolean z16) {
        if (!o.a()) {
            return false;
        }
        String c16 = p.c();
        profileCardTemplate.templateAttr.put("wzryLogo", VasApngUtil.getOptimizedApngDrawable(c16 + "logo.png", "-wzry-card-logo-", getTemplateDrawable(profileCardTemplate, true, true, c16 + "logo.png"), new int[]{7}, "-wzry-card-logo-", null));
        profileCardTemplate.templateAttr.put("wzryGameInfoBackground", getTemplateDrawable(profileCardTemplate, true, true, c16 + "bgImage.jpg"));
        profileCardTemplate.templateAttr.put("wzryLogoBg", getTemplateDrawable(profileCardTemplate, true, true, c16 + "logo_bg.png"));
        profileCardTemplate.templateAttr.put("wzryShimmer", getTemplateDrawable(profileCardTemplate, true, true, c16 + "shimmer_mask.png"));
        profileCardTemplate.templateAttr.put("addIcon", getTemplateDrawable(profileCardTemplate, true, true, c16 + "addIcon.png"));
        if (ProfileCardTemplate.wzryTTFChn == null) {
            ProfileCardTemplate.wzryTTFChn = Typeface.createFromFile(c16 + "font_chs.tff");
        }
        if (ProfileCardTemplate.wzryTTFNum == null) {
            ProfileCardTemplate.wzryTTFNum = Typeface.createFromFile(c16 + "font_num.tff");
        }
        profileCardTemplate.templateAttr.put("commonMaskBackground", "#e61c212c");
        return z16;
    }

    @Override // com.tencent.mobileqq.profilecard.template.ITemplateUtils
    @SuppressLint({"NewApi"})
    public void updateViewAttr(View view, String str, ProfileCardTemplate profileCardTemplate, String str2) {
        if (!checkValidate(view, str, profileCardTemplate, str2)) {
            return;
        }
        Object obj = profileCardTemplate.templateAttr.get(str2);
        String lowerCase = str.toLowerCase();
        this.updateDispatcher.dispatchColor(lowerCase, view, obj);
        this.updateDispatcher.dispatchBackground(lowerCase, view, obj);
        this.updateDispatcher.dispatchDrawableleft(lowerCase, view, obj);
        this.updateDispatcher.dispatchDrawableright(lowerCase, view, obj);
        this.updateDispatcher.dispatchSrc(lowerCase, view, obj);
        this.updateDispatcher.dispatchContentBackground(lowerCase, view, obj);
        this.updateDispatcher.dispatchApngDrawable(lowerCase, view, obj);
        this.updateDispatcher.dispatchShimmerMask(lowerCase, view, obj);
    }
}
