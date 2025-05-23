package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.RedirectAndAndroidNFactory2;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J,\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R.\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RedirectAndAndroidNFactory2;", "Landroid/view/LayoutInflater$Factory2;", "()V", "filter", "Landroid/view/LayoutInflater$Filter;", "filterMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "inflaterHelpers", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "Lcom/tencent/biz/richframework/layoutinflater/RedirectAndAndroidNFactory2$InflaterHelper;", "sConstructorMap", "", "Ljava/lang/reflect/Constructor;", "Landroid/view/View;", "createViewInner", "name", "prefix", "viewContext", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "failNotAllowed", "", "context", "onCreateView", HippyNestedScrollComponent.PRIORITY_PARENT, "verifyClassLoader", "constructor", "Companion", "InflaterHelper", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RedirectAndAndroidNFactory2 implements LayoutInflater.Factory2 {
    private final LayoutInflater.Filter filter;
    private final HashMap<String, Boolean> filterMap;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = RedirectAndAndroidNFactory2.class.getSimpleName();
    private static final ClassLoader BOOT_CLASS_LOADER = LayoutInflater.class.getClassLoader();
    private static final Class<? extends Object>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    private Map<String, Constructor<? extends View>> sConstructorMap = new ConcurrentHashMap();
    private final RFWThreadLocal<InflaterHelper> inflaterHelpers = new RFWThreadLocal<InflaterHelper>() { // from class: com.tencent.biz.richframework.layoutinflater.RedirectAndAndroidNFactory2$inflaterHelpers$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.biz.richframework.collection.RFWThreadLocal
        @NotNull
        public RedirectAndAndroidNFactory2.InflaterHelper initialValue(boolean isMainThread) {
            return new RedirectAndAndroidNFactory2.InflaterHelper();
        }
    };

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RedirectAndAndroidNFactory2$Companion;", "", "()V", "BOOT_CLASS_LOADER", "Ljava/lang/ClassLoader;", "kotlin.jvm.PlatformType", "EMPTY_STACK_TRACE", "", "Ljava/lang/StackTraceElement;", "[Ljava/lang/StackTraceElement;", "TAG", "", "USE_PRELOAD_COMPACT_FACTORY2", "sConstructorSignature", "Ljava/lang/Class;", "[Ljava/lang/Class;", "getParserStateDescription", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getParserStateDescription(Context context, AttributeSet attrs) {
            int i3;
            if (Build.VERSION.SDK_INT >= 29) {
                i3 = Resources.getAttributeSetSourceResId(attrs);
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                String positionDescription = attrs.getPositionDescription();
                Intrinsics.checkNotNullExpressionValue(positionDescription, "attrs.positionDescription");
                return positionDescription;
            }
            return attrs.getPositionDescription() + " in " + context.getResources().getResourceName(i3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RedirectAndAndroidNFactory2$InflaterHelper;", "", "()V", "mConstructorArgs", "", "getMConstructorArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class InflaterHelper {

        @NotNull
        private final Object[] mConstructorArgs = new Object[2];

        @NotNull
        public final Object[] getMConstructorArgs() {
            return this.mConstructorArgs;
        }
    }

    private final void failNotAllowed(String name, String prefix, Context context, AttributeSet attrs) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(INSTANCE.getParserStateDescription(context, attrs));
        sb5.append(": Class not allowed to be inflated ");
        if (prefix != null) {
            name = prefix + name;
        }
        sb5.append(name);
        throw new InflateException(sb5.toString());
    }

    private final boolean verifyClassLoader(Context context, Constructor<? extends View> constructor) {
        Class<? extends View> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
        ClassLoader classLoader = declaringClass.getClassLoader();
        if (classLoader == BOOT_CLASS_LOADER) {
            return true;
        }
        ClassLoader classLoader2 = context.getClassLoader();
        while (classLoader != classLoader2) {
            if (classLoader2 != null) {
                classLoader2 = classLoader2.getParent();
            } else {
                classLoader2 = null;
            }
            if (classLoader2 == null) {
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    @NotNull
    public final View createViewInner(@NotNull String name, @Nullable String prefix, @NotNull Context viewContext, @NotNull AttributeSet attrs) throws ClassNotFoundException {
        String name2;
        String str;
        boolean z16;
        String str2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(viewContext, "viewContext");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        InflaterHelper inflaterHelper = this.inflaterHelpers.get();
        Constructor<? extends View> constructor = this.sConstructorMap.get(name);
        Class cls = null;
        if (constructor != null && !verifyClassLoader(viewContext, constructor)) {
            this.sConstructorMap.remove(name);
            constructor = null;
        }
        try {
            if (constructor == null) {
                if (prefix != null) {
                    str2 = prefix + name;
                } else {
                    str2 = name;
                }
                Class asSubclass = Class.forName(str2, false, viewContext.getClassLoader()).asSubclass(View.class);
                LayoutInflater.Filter filter = this.filter;
                if (filter != null && asSubclass != null && !filter.onLoadClass(asSubclass)) {
                    failNotAllowed(name, prefix, viewContext, attrs);
                }
                Class<? extends Object>[] clsArr = sConstructorSignature;
                constructor = asSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
                constructor.setAccessible(true);
                this.sConstructorMap.put(name, constructor);
            } else if (this.filter != null) {
                HashMap<String, Boolean> hashMap = this.filterMap;
                Intrinsics.checkNotNull(hashMap);
                Boolean bool = hashMap.get(name);
                if (bool == null) {
                    if (prefix != null) {
                        str = prefix + name;
                    } else {
                        str = name;
                    }
                    Class asSubclass2 = Class.forName(str, false, viewContext.getClassLoader()).asSubclass(View.class);
                    if (asSubclass2 != null && this.filter.onLoadClass(asSubclass2)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.filterMap.put(name, Boolean.valueOf(z16));
                    if (!z16) {
                        failNotAllowed(name, prefix, viewContext, attrs);
                    }
                } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    failNotAllowed(name, prefix, viewContext, attrs);
                }
            }
            Object obj = inflaterHelper.getMConstructorArgs()[0];
            inflaterHelper.getMConstructorArgs()[0] = viewContext;
            Object[] mConstructorArgs = inflaterHelper.getMConstructorArgs();
            mConstructorArgs[1] = attrs;
            try {
                View view = constructor.newInstance(Arrays.copyOf(mConstructorArgs, mConstructorArgs.length));
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return view;
            } finally {
                this.inflaterHelpers.get().getMConstructorArgs()[0] = obj;
            }
        } catch (ClassCastException e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(INSTANCE.getParserStateDescription(viewContext, attrs));
            sb5.append(": Class is not a View ");
            if (prefix != null) {
                name = prefix + name;
            }
            sb5.append(name);
            InflateException inflateException = new InflateException(sb5.toString(), e16);
            inflateException.setStackTrace(EMPTY_STACK_TRACE);
            throw inflateException;
        } catch (ClassNotFoundException e17) {
            throw e17;
        } catch (NoSuchMethodException e18) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(INSTANCE.getParserStateDescription(viewContext, attrs));
            sb6.append(": Error inflating class ");
            if (prefix != null) {
                name = prefix + name;
            }
            sb6.append(name);
            InflateException inflateException2 = new InflateException(sb6.toString(), e18);
            inflateException2.setStackTrace(EMPTY_STACK_TRACE);
            throw inflateException2;
        } catch (Exception e19) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(INSTANCE.getParserStateDescription(viewContext, attrs));
            sb7.append(": Error inflating class ");
            if (0 == 0) {
                name2 = "<unknown>";
            } else {
                name2 = cls.getName();
            }
            sb7.append(name2);
            InflateException inflateException3 = new InflateException(sb7.toString(), e19);
            inflateException3.setStackTrace(EMPTY_STACK_TRACE);
            throw inflateException3;
        }
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(@Nullable View parent, @NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        boolean contains$default;
        View createViewInner;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25 && !CreateViewRedirectManager.INSTANCE.needRedirect(name, context, attrs) && (!Intrinsics.areEqual(name, "ViewStub"))) {
            return null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) ".", false, 2, (Object) null);
        if (contains$default) {
            try {
                return createViewInner(name, null, context, attrs);
            } catch (Exception e16) {
                RFWLog.e(TAG, RFWLog.USR, "create custom view error: ", e16);
                return null;
            }
        }
        try {
            r3 = (Intrinsics.areEqual("View", name) || Intrinsics.areEqual("ViewStub", name) || Intrinsics.areEqual("TextureView", name)) ? createViewInner(name, "android.view.", context, attrs) : null;
            if (r3 == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    createViewInner = createViewInner(name, "android.widget.", context, attrs);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    Result.m476constructorimpl(Unit.INSTANCE);
                    r3 = createViewInner;
                } catch (Throwable th6) {
                    th = th6;
                    r3 = createViewInner;
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th));
                    if (r3 == null) {
                    }
                }
            }
            if (r3 == null) {
                return r3;
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                r3 = createViewInner(name, "android.webkit.", context, attrs);
                Result.m476constructorimpl(Unit.INSTANCE);
                return r3;
            } catch (Throwable th7) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th7));
                return r3;
            }
        } catch (Exception e17) {
            RFWLog.e(TAG, RFWLog.USR, "create custom view error: ", e17);
            return r3;
        }
    }
}
