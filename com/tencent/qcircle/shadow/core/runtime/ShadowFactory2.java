package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinManager;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ShadowFactory2 extends RFWSkinFactory2 {
    private static final ClassLoader BOOT_CLASS_LOADER = LayoutInflater.class.getClassLoader();
    private final String mPartKey;

    public ShadowFactory2(String str) {
        super(str);
        this.mPartKey = str;
        setForceSkinFactory2(true);
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2
    protected String generateConstructorCacheKey(String str) {
        return this.mPartKey + str;
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2
    public void modifyArgs(Object[] objArr, Constructor<? extends View> constructor, Context context) {
        if (constructor.getDeclaringClass().getClassLoader() != context.getClassLoader() && constructor.getDeclaringClass().getClassLoader() != BOOT_CLASS_LOADER && (context instanceof ContextWrapper) && (((ContextWrapper) context).getBaseContext() instanceof Activity)) {
            objArr[0] = RFWApplication.getApplication();
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!str.contains(".") && (context instanceof PluginActivity) && (SkinManager.g(this.mPartKey).getPackageName(context) == null || !parseSkinAttr(context, attributeSet, getInflaterHelper()))) {
            return ((PluginActivity) context).onCreateView(view, str, context, attributeSet);
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}
