package com.tencent.mobileqq.springhb.preload;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tJ&\u0010\u0010\u001a\u00020\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001dR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001d\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/r;", "", "Landroid/content/Context;", "context", "", "assetName", "destName", "", "c", "", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadResource;", "list", "Lcom/tencent/mobileqq/springhb/preload/SpringHbZipMappingBean;", "zipMappings", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "resId", tl.h.F, "url", "i", "k", "j", "g", "d", "Lcom/tencent/mobileqq/springhb/preload/SpringRes;", "springRes", "b", "", "Ljava/util/List;", "gameCenterResourceList", "springHbResourceList", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "fallbackDir", "e", "gameCenterZipMappingList", "springHbZipMappingList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f289531a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<IPreloadResource> gameCenterResourceList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<IPreloadResource> springHbResourceList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String fallbackDir;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<SpringHbZipMappingBean> gameCenterZipMappingList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<SpringHbZipMappingBean> springHbZipMappingList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61217);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f289531a = new r();
        gameCenterResourceList = new ArrayList();
        springHbResourceList = new ArrayList();
        fallbackDir = AppConstants.SDCARD_SPRING_HB + File.separator;
        gameCenterZipMappingList = new ArrayList();
        springHbZipMappingList = new ArrayList();
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c(Context context, String assetName, String destName) {
        File file = new File(destName);
        if (file.exists()) {
            return true;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            FileUtils.copyAssetToFile(context, assetName, destName);
            return true;
        } catch (Throwable th5) {
            QLog.e("SpringHb_Preload_SpringResManager", 1, "copyAssetToDest: fail ", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BaseApplication context) {
        for (String str : g.INSTANCE.a().values()) {
            String str2 = fallbackDir + str;
            r rVar = f289531a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            rVar.c(context, str, str2);
        }
        for (Map.Entry<String, String> entry : g.INSTANCE.c().entrySet()) {
            String str3 = fallbackDir + ((Object) entry.getKey());
            r rVar2 = f289531a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            rVar2.c(context, entry.getValue(), str3);
        }
    }

    public final boolean b(@NotNull Context context, @NotNull SpringRes springRes) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) springRes)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(springRes, "springRes");
        String g16 = springRes.g();
        boolean z17 = true;
        if (g16 != null && g16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String k3 = springRes.k();
            if (k3 != null && k3.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                return c(context, springRes.g(), springRes.k());
            }
        }
        return false;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("SpringHb_Preload_SpringResManager", 1, "copyAssetToLocal: ");
        final BaseApplication context = BaseApplication.getContext();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.preload.q
            @Override // java.lang.Runnable
            public final void run() {
                r.e(BaseApplication.this);
            }
        }, 64, null, false);
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return fallbackDir;
    }

    @Nullable
    public final String g(@NotNull String url) {
        boolean z16;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object obj = null;
        if (z16) {
            return null;
        }
        Iterator<T> it = g.INSTANCE.c().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) next, false, 2, (Object) null);
            if (contains$default) {
                obj = next;
                break;
            }
        }
        return (String) obj;
    }

    @Nullable
    public final synchronized IPreloadResource h(@NotNull String resId) {
        boolean z16;
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IPreloadResource) iPatchRedirector.redirect((short) 5, (Object) this, (Object) resId);
        }
        Intrinsics.checkNotNullParameter(resId, "resId");
        if (resId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        List<IPreloadResource> list = gameCenterResourceList;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((IPreloadResource) obj).getResId(), resId)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IPreloadResource iPreloadResource = (IPreloadResource) obj;
            if (iPreloadResource != null) {
                return iPreloadResource;
            }
            Unit unit = Unit.INSTANCE;
            List<IPreloadResource> list2 = springHbResourceList;
            synchronized (list2) {
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((IPreloadResource) obj2).getResId(), resId)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                IPreloadResource iPreloadResource2 = (IPreloadResource) obj2;
                if (iPreloadResource2 != null) {
                    return iPreloadResource2;
                }
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    @Nullable
    public final synchronized IPreloadResource i(@NotNull String url) {
        boolean z16;
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IPreloadResource) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        List<IPreloadResource> list = gameCenterResourceList;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((IPreloadResource) obj).getUrl(), url)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IPreloadResource iPreloadResource = (IPreloadResource) obj;
            if (iPreloadResource != null) {
                return iPreloadResource;
            }
            Unit unit = Unit.INSTANCE;
            List<IPreloadResource> list2 = springHbResourceList;
            synchronized (list2) {
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((IPreloadResource) obj2).getUrl(), url)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                IPreloadResource iPreloadResource2 = (IPreloadResource) obj2;
                if (iPreloadResource2 != null) {
                    return iPreloadResource2;
                }
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    @Nullable
    public final synchronized SpringHbZipMappingBean j(@NotNull String resId) {
        boolean z16;
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SpringHbZipMappingBean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) resId);
        }
        Intrinsics.checkNotNullParameter(resId, "resId");
        if (resId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        List<SpringHbZipMappingBean> list = gameCenterZipMappingList;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SpringHbZipMappingBean) obj).resName, resId)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            SpringHbZipMappingBean springHbZipMappingBean = (SpringHbZipMappingBean) obj;
            if (springHbZipMappingBean != null) {
                return springHbZipMappingBean;
            }
            Unit unit = Unit.INSTANCE;
            List<SpringHbZipMappingBean> list2 = springHbZipMappingList;
            synchronized (list2) {
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((SpringHbZipMappingBean) obj2).resName, resId)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                SpringHbZipMappingBean springHbZipMappingBean2 = (SpringHbZipMappingBean) obj2;
                if (springHbZipMappingBean2 != null) {
                    return springHbZipMappingBean2;
                }
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    @Nullable
    public final synchronized SpringHbZipMappingBean k(@NotNull String url) {
        boolean z16;
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SpringHbZipMappingBean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        List<SpringHbZipMappingBean> list = gameCenterZipMappingList;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SpringHbZipMappingBean) obj).url, url)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            SpringHbZipMappingBean springHbZipMappingBean = (SpringHbZipMappingBean) obj;
            if (springHbZipMappingBean != null) {
                return springHbZipMappingBean;
            }
            Unit unit = Unit.INSTANCE;
            List<SpringHbZipMappingBean> list2 = springHbZipMappingList;
            synchronized (list2) {
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((SpringHbZipMappingBean) obj2).url, url)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                SpringHbZipMappingBean springHbZipMappingBean2 = (SpringHbZipMappingBean) obj2;
                if (springHbZipMappingBean2 != null) {
                    return springHbZipMappingBean2;
                }
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    public final synchronized void l(@Nullable List<? extends IPreloadResource> list, @Nullable List<? extends SpringHbZipMappingBean> zipMappings) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) zipMappings);
            return;
        }
        if (list != null && zipMappings != null) {
            QLog.i("SpringHb_Preload_SpringResManager", 1, "[updateResourceList], list.size:" + list.size() + ",zipMapSize:" + zipMappings.size());
        }
        List<IPreloadResource> list2 = gameCenterResourceList;
        synchronized (list2) {
            list2.clear();
            if (list != null) {
                list2.addAll(list);
            }
        }
        List<SpringHbZipMappingBean> list3 = gameCenterZipMappingList;
        synchronized (list3) {
            list3.clear();
            if (zipMappings != null) {
                list3.addAll(zipMappings);
            }
        }
    }

    public final synchronized void m(@Nullable List<? extends IPreloadResource> list, @Nullable List<? extends SpringHbZipMappingBean> zipMappings) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) zipMappings);
            return;
        }
        if (list != null && zipMappings != null) {
            QLog.i("SpringHb_Preload_SpringResManager", 1, "[updateResourceList], list.size:" + list.size() + ",zipMapSize:" + zipMappings.size());
        }
        List<IPreloadResource> list2 = springHbResourceList;
        synchronized (list2) {
            list2.clear();
            if (list != null) {
                list2.addAll(list);
            }
        }
        List<SpringHbZipMappingBean> list3 = springHbZipMappingList;
        synchronized (list3) {
            list3.clear();
            if (zipMappings != null) {
                list3.addAll(zipMappings);
            }
        }
    }
}
