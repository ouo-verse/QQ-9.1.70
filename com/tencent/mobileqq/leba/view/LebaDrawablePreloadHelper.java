package com.tencent.mobileqq.leba.view;

import android.graphics.drawable.Drawable;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/leba/view/LebaDrawablePreloadHelper;", "", "", "e", "b", "", "resId", "Landroid/graphics/drawable/Drawable;", "d", "", "Lkotlin/Lazy;", "c", "()Z", "asyncGetDrawableSwitch", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "drawableMap", "", "Ljava/util/List;", "defaultIconResIdList", "simpleIconResIdList", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaDrawablePreloadHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LebaDrawablePreloadHelper f240771a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy asyncGetDrawableSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Drawable> drawableMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> defaultIconResIdList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> simpleIconResIdList;

    static {
        Lazy lazy;
        List<Integer> listOf;
        List<Integer> listOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f240771a = new LebaDrawablePreloadHelper();
        lazy = LazyKt__LazyJVMKt.lazy(LebaDrawablePreloadHelper$asyncGetDrawableSwitch$2.INSTANCE);
        asyncGetDrawableSwitch = lazy;
        drawableMap = new ConcurrentHashMap<>();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.ew8), Integer.valueOf(R.drawable.evr), Integer.valueOf(R.drawable.krh)});
        defaultIconResIdList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.neu), Integer.valueOf(R.drawable.krg), Integer.valueOf(R.drawable.krj)});
        simpleIconResIdList = listOf2;
    }

    LebaDrawablePreloadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b() {
        QLog.i("LebaDrawablePreloadHelper", 1, HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        drawableMap.clear();
    }

    private final boolean c() {
        return ((Boolean) asyncGetDrawableSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    @Nullable
    public static final Drawable d(int resId) {
        Drawable drawable;
        Drawable drawable2 = drawableMap.get(Integer.valueOf(resId));
        if (drawable2 == null) {
            try {
                drawable = com.tencent.mobileqq.webview.view.b.c(resId);
            } catch (Exception unused) {
                drawable = null;
            }
            return drawable;
        }
        return drawable2;
    }

    @JvmStatic
    public static final void e() {
        QLog.i("LebaDrawablePreloadHelper", 1, "preloadDrawables begin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.view.c
            @Override // java.lang.Runnable
            public final void run() {
                LebaDrawablePreloadHelper.f();
            }
        }, 240, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        List<Integer> list;
        Drawable drawable;
        if (QQTheme.isNowSimpleUI()) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = defaultIconResIdList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            try {
                if (f240771a.c()) {
                    drawable = SkinEngine.getInstances().loadDrawable(intValue);
                } else {
                    drawable = com.tencent.mobileqq.webview.view.b.c(intValue);
                }
            } catch (Exception unused) {
                drawable = null;
            }
            if (drawable != null) {
                linkedHashMap.put(Integer.valueOf(intValue), drawable);
            }
        }
        ConcurrentHashMap<Integer, Drawable> concurrentHashMap = drawableMap;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(linkedHashMap);
        QLog.i("LebaDrawablePreloadHelper", 1, "preloadDrawables end size: " + concurrentHashMap.size());
    }
}
