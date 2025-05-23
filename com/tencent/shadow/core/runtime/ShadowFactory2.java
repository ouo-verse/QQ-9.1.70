package com.tencent.shadow.core.runtime;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.tencent.shadow.core.runtime.skin.entity.AttrFactory;
import com.tencent.shadow.core.runtime.skin.entity.SkinAttr;
import com.tencent.shadow.core.runtime.skin.entity.SkinItem;
import com.tencent.shadow.core.runtime.skin.loader.SkinManager;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowFactory2 implements LayoutInflater.Factory2 {
    private static final String SKIN_PREFIX = "qcircle_skin_";
    private static final String TAG = "ShadowFactory2";
    private LayoutInflater mLayoutInflater;
    private String mPartKey;
    private HashMap<View, SkinItem> mSkinMap;
    private static final HashMap<String, String> sCreateSystemMap = new HashMap<>();
    private static final ClassLoader BOOT_CLASS_LOADER = LayoutInflater.class.getClassLoader();
    private final Object[] mConstructorArgs = new Object[2];
    private final Class<?>[] mConstructorSignature = {Context.class, AttributeSet.class};
    private final HashMap<String, Constructor<? extends View>> sConstructorMap = new HashMap<>();
    private List<SkinAttr> mViewAttrs = new ArrayList();

    public ShadowFactory2(String str, LayoutInflater layoutInflater, HashMap<View, SkinItem> hashMap) {
        this.mPartKey = str;
        this.mLayoutInflater = layoutInflater;
        this.mSkinMap = hashMap;
    }

    private void applyViewAttrs(View view) {
        Iterator<SkinAttr> it = this.mViewAttrs.iterator();
        while (it.hasNext()) {
            it.next().apply(view);
        }
    }

    private View createCustomView(String str, Context context, AttributeSet attributeSet) {
        return createCustomView(str, null, context, attributeSet);
    }

    private boolean parseSkinAttr(Context context, AttributeSet attributeSet) {
        this.mViewAttrs.clear();
        boolean parseSkinAttr = parseSkinAttr(context, attributeSet, "TextColorAttr", "textColor");
        if (parseSkinAttr(context, attributeSet, "SrcAttr", "src")) {
            parseSkinAttr = true;
        }
        if (parseSkinAttr(context, attributeSet, "BackgroundAttr", "background")) {
            return true;
        }
        return parseSkinAttr;
    }

    private final boolean verifyClassLoader(Context context, Constructor<? extends View> constructor) {
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

    public void addSkinAttr(View view, List<SkinAttr> list) {
        if (list != null && !list.isEmpty()) {
            HashMap<View, SkinItem> hashMap = this.mSkinMap;
            if (hashMap == null) {
                Log.e(TAG, "addSkinAttr error  skinMap is null");
                return;
            }
            SkinItem skinItem = hashMap.get(view);
            if (skinItem == null) {
                skinItem = new SkinItem(view, list);
                this.mSkinMap.put(view, skinItem);
            } else {
                skinItem.addItem(list);
            }
            skinItem.apply();
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    private View createCustomView(String str, String str2, Context context, AttributeSet attributeSet) {
        String str3 = this.mPartKey + str;
        Constructor<? extends View> constructor = this.sConstructorMap.get(str3);
        if (constructor != null && !verifyClassLoader(context, constructor)) {
            this.sConstructorMap.remove(str3);
            constructor = null;
        }
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str = str2 + str;
                }
                constructor = classLoader.loadClass(str).asSubclass(View.class).getConstructor(this.mConstructorSignature);
                constructor.setAccessible(true);
                this.sConstructorMap.put(str3, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        Object[] objArr = this.mConstructorArgs;
        Object obj = objArr[0];
        if (obj == null) {
            objArr[0] = context;
        }
        objArr[1] = attributeSet;
        View newInstance = constructor.newInstance(objArr);
        if (newInstance instanceof ViewStub) {
            ((ViewStub) newInstance).setLayoutInflater(this.mLayoutInflater.cloneInContext((Context) objArr[0]));
        }
        this.mConstructorArgs[0] = obj;
        return newInstance;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View createCustomView;
        if (str.contains(".")) {
            HashMap<String, String> hashMap = sCreateSystemMap;
            if (hashMap.get(str) == null) {
                hashMap.put(str, this.mPartKey);
            }
            try {
                r1 = createCustomView(str, context, attributeSet);
                if (r1 != null && parseSkinAttr(context, attributeSet)) {
                    addSkinAttr(r1, this.mViewAttrs);
                    if (SkinManager.getsInstance().getPackageName() != null) {
                        applyViewAttrs(r1);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            if (context instanceof PluginActivity) {
                if (!parseSkinAttr(context, attributeSet)) {
                    return ((PluginActivity) context).onCreateView(view, str, context, attributeSet);
                }
            } else if (!parseSkinAttr(context, attributeSet)) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    r1 = "View".equals(str) ? this.mLayoutInflater.createView(str, "android.mView.", attributeSet) : null;
                    if (r1 == null) {
                        r1 = this.mLayoutInflater.createView(str, "android.widget.", attributeSet);
                    }
                    if (r1 == null) {
                        createCustomView = this.mLayoutInflater.createView(str, "android.webkit.", attributeSet);
                        r1 = createCustomView;
                    }
                    addSkinAttr(r1, this.mViewAttrs);
                    if (r1 != null && SkinManager.getsInstance().getPackageName() != null) {
                        applyViewAttrs(r1);
                    }
                } else {
                    r1 = "View".equals(str) ? createCustomView(str, "android.view.", context, attributeSet) : null;
                    if (r1 == null) {
                        r1 = createCustomView(str, "android.widget.", context, attributeSet);
                    }
                    if (r1 == null) {
                        createCustomView = createCustomView(str, "android.webkit.", context, attributeSet);
                        r1 = createCustomView;
                    }
                    addSkinAttr(r1, this.mViewAttrs);
                    if (r1 != null) {
                        applyViewAttrs(r1);
                    }
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            e17.printStackTrace();
        }
        return r1;
    }

    private boolean parseSkinAttr(Context context, AttributeSet attributeSet, String str, String str2) {
        SkinAttr createAttr;
        for (int i3 = 0; i3 < attributeSet.getAttributeCount(); i3++) {
            String attributeValue = attributeSet.getAttributeValue(i3);
            if (str2.equals(attributeSet.getAttributeName(i3)) && attributeValue.startsWith("@")) {
                try {
                    int parseInt = Integer.parseInt(attributeValue.substring(1));
                    String resourceEntryName = context.getResources().getResourceEntryName(parseInt);
                    if (resourceEntryName.startsWith(SKIN_PREFIX) && (createAttr = AttrFactory.createAttr(str, parseInt, resourceEntryName)) != null) {
                        this.mViewAttrs.add(createAttr);
                        return true;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        return false;
    }
}
