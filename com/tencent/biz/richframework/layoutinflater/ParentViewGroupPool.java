package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/ParentViewGroupPool;", "", "()V", "parentViewGroupCache", "Landroidx/collection/LruCache;", "", "Landroid/view/ViewGroup;", "sConstructorSignature", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "createLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManagerClass", "createParentView", "preloadRequest", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "createViewGroup", "viewGroupClass", "viewGroupClassName", "findAndroidSuperClass", "parentViewClass", "getParentViewGroup", "isInValidRequest", "", "release", "", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ParentViewGroupPool {

    @NotNull
    public static final ParentViewGroupPool INSTANCE = new ParentViewGroupPool();
    private static final Class<?>[] sConstructorSignature = {Context.class};
    private static final LruCache<String, ViewGroup> parentViewGroupCache = new LruCache<>(LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getParentViewGroupPoolSize());

    ParentViewGroupPool() {
    }

    private final RecyclerView.LayoutManager createLayoutManager(String layoutManagerClass) {
        Object m476constructorimpl;
        Object newInstance;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName(layoutManagerClass);
            Class<?>[] clsArr = sConstructorSignature;
            newInstance = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(RFWApplication.getApplication());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (newInstance != null) {
            m476constructorimpl = Result.m476constructorimpl((RecyclerView.LayoutManager) newInstance);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            return (RecyclerView.LayoutManager) m476constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutManager");
    }

    private final ViewGroup createParentView(PreloadRequest preloadRequest) {
        ViewGroup createViewGroup;
        if (isInValidRequest(preloadRequest) || (createViewGroup = createViewGroup(preloadRequest.getParentViewClassName())) == null) {
            return null;
        }
        if (createViewGroup instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) createViewGroup;
            RecyclerView.LayoutManager createLayoutManager = createLayoutManager(preloadRequest.getItemLayoutManager());
            if (createLayoutManager == null) {
                return null;
            }
            recyclerView.setLayoutManager(createLayoutManager);
        }
        return createViewGroup;
    }

    private final boolean isInValidRequest(PreloadRequest preloadRequest) {
        boolean z16;
        if (Intrinsics.areEqual(preloadRequest.getParentViewClassName(), RecyclerView.class.getName())) {
            if (preloadRequest.getItemLayoutManager().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final ViewGroup createViewGroup(@NotNull Class<?> viewGroupClass) {
        Object m476constructorimpl;
        Object newInstance;
        Intrinsics.checkNotNullParameter(viewGroupClass, "viewGroupClass");
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?>[] clsArr = sConstructorSignature;
            newInstance = viewGroupClass.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(RFWApplication.getApplication());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (newInstance != null) {
            m476constructorimpl = Result.m476constructorimpl((ViewGroup) newInstance);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            return (ViewGroup) m476constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Nullable
    public final Class<?> findAndroidSuperClass(@NotNull Class<?> parentViewClass) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(parentViewClass, "parentViewClass");
        if (!Modifier.isAbstract(parentViewClass.getModifiers())) {
            String name = parentViewClass.getName();
            Intrinsics.checkNotNullExpressionValue(name, "parentViewClass.name");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "android", false, 2, null);
            if (startsWith$default) {
                return parentViewClass;
            }
        }
        Class<? super Object> superclass = parentViewClass.getSuperclass();
        if (superclass == null) {
            return null;
        }
        return findAndroidSuperClass(superclass);
    }

    @Nullable
    public final ViewGroup getParentViewGroup(@NotNull PreloadRequest preloadRequest) {
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        if (TextUtils.isEmpty(preloadRequest.getParentViewClassName())) {
            return null;
        }
        String str = preloadRequest.getParentViewClassName() + preloadRequest.getItemLayoutManager();
        LruCache<String, ViewGroup> lruCache = parentViewGroupCache;
        ViewGroup viewGroup = lruCache.get(str);
        if (viewGroup == null) {
            synchronized (this) {
                viewGroup = lruCache.get(str);
                if (viewGroup == null) {
                    ViewGroup createParentView = INSTANCE.createParentView(preloadRequest);
                    if (createParentView == null) {
                        return null;
                    }
                    lruCache.put(str, createParentView);
                    viewGroup = createParentView;
                }
            }
        }
        return viewGroup;
    }

    public final void release() {
        parentViewGroupCache.evictAll();
    }

    @Nullable
    public final ViewGroup createViewGroup(@NotNull String viewGroupClassName) {
        Object m476constructorimpl;
        Object newInstance;
        Intrinsics.checkNotNullParameter(viewGroupClassName, "viewGroupClassName");
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName(viewGroupClassName);
            Class<?>[] clsArr = sConstructorSignature;
            newInstance = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(RFWApplication.getApplication());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (newInstance != null) {
            m476constructorimpl = Result.m476constructorimpl((ViewGroup) newInstance);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            return (ViewGroup) m476constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
