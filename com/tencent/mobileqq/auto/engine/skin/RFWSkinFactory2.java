package com.tencent.mobileqq.auto.engine.skin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.auto.engine.skin.entity.AttrFactory;
import com.tencent.mobileqq.auto.engine.skin.entity.SkinAttr;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RFWSkinFactory2 implements LayoutInflater.Factory2 {
    static IPatchRedirector $redirector_;
    private static final ClassLoader BOOT_CLASS_LOADER;
    private static final String TAG;
    private static Field sConstructorArgsField;
    private static final Class<?>[] sConstructorSignature;
    private String mBusinessTag;
    private boolean mForceSkinFactory2;
    protected final RFWThreadLocal<InflaterHelper> mInflaterHelpers;
    private final Map<String, Constructor<? extends View>> sConstructorMap;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class InflaterHelper {
        static IPatchRedirector $redirector_;
        protected final Object[] mConstructorArgs;
        protected final List<SkinAttr> mViewAttrs;

        public InflaterHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mConstructorArgs = new Object[2];
                this.mViewAttrs = new ArrayList();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        TAG = RFWSkinFactory2.class.getSimpleName();
        BOOT_CLASS_LOADER = LayoutInflater.class.getClassLoader();
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
    }

    public RFWSkinFactory2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mBusinessTag = str;
        this.mInflaterHelpers = new RFWThreadLocal<InflaterHelper>() { // from class: com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RFWSkinFactory2.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.biz.richframework.collection.RFWThreadLocal
            public InflaterHelper initialValue(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new InflaterHelper() : (InflaterHelper) iPatchRedirector2.redirect((short) 2, (Object) this, z16);
            }
        };
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25) {
            this.sConstructorMap = new HashMap();
        } else {
            this.sConstructorMap = new ConcurrentHashMap();
        }
    }

    private void applyViewAttrs(View view, InflaterHelper inflaterHelper) {
        Iterator<SkinAttr> it = inflaterHelper.mViewAttrs.iterator();
        while (it.hasNext()) {
            it.next().apply(view);
        }
    }

    private boolean createSkinAttr(Context context, String str, InflaterHelper inflaterHelper, String str2) {
        SkinAttr createAttr;
        SkinAttr createAttr2;
        Map<String, Integer> resourceIdMap = SkinManager.g(this.mBusinessTag).getResourceIdMap();
        Map<String, String> resourceIdAndNameMap = SkinManager.g(this.mBusinessTag).getResourceIdAndNameMap();
        String substring = str2.substring(1);
        if (resourceIdMap != null && resourceIdAndNameMap != null) {
            if (resourceIdMap.get(substring) == null) {
                return false;
            }
            int intValue = resourceIdMap.get(substring).intValue();
            String str3 = resourceIdAndNameMap.get(substring);
            if (!SkinManager.g(this.mBusinessTag).needChangeTheme(str3) || (createAttr2 = AttrFactory.createAttr(context, str, intValue, str3, this.mBusinessTag)) == null) {
                return false;
            }
            inflaterHelper.mViewAttrs.add(createAttr2);
            return true;
        }
        try {
            int parseInt = Integer.parseInt(substring);
            String resourceEntryName = context.getResources().getResourceEntryName(parseInt);
            if (!SkinManager.g(this.mBusinessTag).needChangeTheme(resourceEntryName) || (createAttr = AttrFactory.createAttr(context, str, parseInt, resourceEntryName, this.mBusinessTag)) == null) {
                return false;
            }
            inflaterHelper.mViewAttrs.add(createAttr);
            return true;
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, "create skin attr error: ", e16);
            return false;
        }
    }

    private View createViewInner(String str, String str2, Context context, AttributeSet attributeSet, InflaterHelper inflaterHelper) {
        String generateConstructorCacheKey = generateConstructorCacheKey(str);
        Constructor<? extends View> constructor = this.sConstructorMap.get(generateConstructorCacheKey);
        if (constructor != null && !verifyClassLoader(context, constructor)) {
            this.sConstructorMap.remove(generateConstructorCacheKey);
            constructor = null;
        }
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str = str2 + str;
                }
                constructor = classLoader.loadClass(str).asSubclass(View.class).getConstructor(sConstructorSignature);
                constructor.setAccessible(true);
                this.sConstructorMap.put(generateConstructorCacheKey, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        Object[] objArr = inflaterHelper.mConstructorArgs;
        Object obj = objArr[0];
        if (obj == null) {
            objArr[0] = context;
        }
        objArr[1] = attributeSet;
        modifyArgs(objArr, constructor, context);
        View newInstance = constructor.newInstance(objArr);
        if (newInstance instanceof ViewStub) {
            ((ViewStub) newInstance).setLayoutInflater(LayoutInflater.from(context).cloneInContext((Context) objArr[0]));
        }
        inflaterHelper.mConstructorArgs[0] = obj;
        return newInstance;
    }

    private void handleAndroid7(Context context, LayoutInflater layoutInflater) {
        if (Build.VERSION.SDK_INT <= 25) {
            setViewConstructArgsIfNeed(context, layoutInflater);
        }
    }

    private void setViewConstructArgsIfNeed(Context context, LayoutInflater layoutInflater) {
        try {
            if (sConstructorArgsField == null) {
                Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
                sConstructorArgsField = declaredField;
                declaredField.setAccessible(true);
            }
            Object[] objArr = (Object[]) sConstructorArgsField.get(layoutInflater);
            if (objArr == null || objArr[0] == null) {
                RFWLog.w(TAG, RFWLog.USR, "constructorArgs[0] is null");
                Object[] objArr2 = new Object[2];
                objArr2[0] = context;
                sConstructorArgsField.set(layoutInflater, objArr2);
            }
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, "set mConstructorArgs failed: ", e16);
        }
    }

    private boolean verifyClassLoader(Context context, Constructor<? extends View> constructor) {
        ClassLoader classLoader = constructor.getDeclaringClass().getClassLoader();
        if (classLoader == BOOT_CLASS_LOADER) {
            return true;
        }
        ClassLoader classLoader2 = context.getClassLoader();
        while (classLoader != classLoader2) {
            classLoader2 = classLoader2.getParent();
            if (classLoader2 == null) {
                return false;
            }
        }
        return true;
    }

    protected String generateConstructorCacheKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return str;
    }

    public InflaterHelper getInflaterHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InflaterHelper) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mInflaterHelpers.get();
    }

    protected void modifyArgs(Object[] objArr, Constructor<? extends View> constructor, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, objArr, constructor, context);
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return null;
        }
        return (View) iPatchRedirector.redirect((short) 8, this, str, context, attributeSet);
    }

    public boolean parseSkinAttr(Context context, AttributeSet attributeSet, InflaterHelper inflaterHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, context, attributeSet, inflaterHelper)).booleanValue();
        }
        inflaterHelper.mViewAttrs.clear();
        boolean parseSkinAttr = parseSkinAttr(context, attributeSet, "TextColorAttr", "textColor", inflaterHelper);
        if (parseSkinAttr(context, attributeSet, "SrcAttr", "src", inflaterHelper)) {
            parseSkinAttr = true;
        }
        if (parseSkinAttr(context, attributeSet, "BackgroundAttr", "background", inflaterHelper)) {
            return true;
        }
        return parseSkinAttr;
    }

    public void setForceSkinFactory2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mForceSkinFactory2 = z16;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, view, str, context, attributeSet);
        }
        boolean z16 = !TextUtils.isEmpty(SkinManager.g(this.mBusinessTag).getPackageName(context));
        if (!z16 && !this.mForceSkinFactory2) {
            return null;
        }
        LayoutInflater from = LayoutInflater.from(context);
        InflaterHelper inflaterHelper = getInflaterHelper();
        if (str.contains(".")) {
            try {
                handleAndroid7(context, from);
                r14 = createViewInner(str, null, context, attributeSet, inflaterHelper);
                if (r14 != null && z16 && parseSkinAttr(context, attributeSet, inflaterHelper)) {
                    applyViewAttrs(r14, inflaterHelper);
                }
            } catch (Exception e16) {
                RFWLog.e(TAG, RFWLog.USR, "create custom view error: ", e16);
            }
        } else {
            if (!parseSkinAttr(context, attributeSet, inflaterHelper)) {
                return null;
            }
            try {
                r14 = "View".equals(str) ? createViewInner(str, "android.view.", context, attributeSet, inflaterHelper) : null;
                if (r14 == null) {
                    r14 = createViewInner(str, "android.widget.", context, attributeSet, inflaterHelper);
                }
                if (r14 == null) {
                    r14 = createViewInner(str, "android.webkit.", context, attributeSet, inflaterHelper);
                }
                if (r14 != null && z16) {
                    applyViewAttrs(r14, inflaterHelper);
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        return r14;
    }

    private boolean parseSkinAttr(Context context, AttributeSet attributeSet, String str, String str2, InflaterHelper inflaterHelper) {
        for (int i3 = 0; i3 < attributeSet.getAttributeCount(); i3++) {
            String attributeValue = attributeSet.getAttributeValue(i3);
            if (str2.equals(attributeSet.getAttributeName(i3)) && attributeValue.startsWith("@") && createSkinAttr(context, str, inflaterHelper, attributeValue)) {
                return true;
            }
        }
        return false;
    }
}
