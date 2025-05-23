package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.ConfigStubImpl;
import com.tencent.android.gldrawable.FactoryStubImpl;
import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbsApi {
    private static final String CLASS_NAME_CONFIG_STUB = "com.tencent.android.gldrawable.ConfigStubImpl";
    private static final String CLASS_NAME_FACTORY_STUB = "com.tencent.android.gldrawable.FactoryStubImpl";
    private static final String CLASS_NAME_LOADER_IMPL = "com.tencent.android.gldrawable.api.impl.GLDLoaderImpl";
    private static final IGLDrawableLoader EMPTY_LOADER = new EmptyLoader();
    private ClassLoader dynamicClassLoader = null;
    private final IGLDrawableLoader loader;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsApi() {
        IGLDrawableLoader iGLDrawableLoader;
        try {
            iGLDrawableLoader = (IGLDrawableLoader) AbsApi.class.getClassLoader().loadClass(CLASS_NAME_LOADER_IMPL).newInstance();
        } catch (Exception e16) {
            IGLDrawableLoader iGLDrawableLoader2 = EMPTY_LOADER;
            iGLDrawableLoader2.getLoaderUtils().getReport().logE("find no loader", e16);
            iGLDrawableLoader = iGLDrawableLoader2;
        }
        this.loader = iGLDrawableLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public IConfigStub createDynamicConfig() {
        Object obj;
        try {
            obj = this.dynamicClassLoader.loadClass(CLASS_NAME_CONFIG_STUB).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            obj = null;
        }
        return (IConfigStub) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public IFactoryStub createDynamicFactory() {
        Object obj;
        try {
            obj = this.dynamicClassLoader.loadClass(CLASS_NAME_FACTORY_STUB).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            obj = null;
        }
        return (IFactoryStub) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public IConfigStub createStaticConfig() {
        try {
            return (IConfigStub) ConfigStubImpl.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public IFactoryStub createStaticFactory() {
        try {
            return (IFactoryStub) FactoryStubImpl.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    public IGLDrawableLoader getLoader() {
        return this.loader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDynamicReady() {
        if (this.dynamicClassLoader != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDynamicReady(ClassLoader classLoader) {
        this.dynamicClassLoader = classLoader;
    }
}
