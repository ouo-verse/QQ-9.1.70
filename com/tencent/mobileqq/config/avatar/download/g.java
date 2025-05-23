package com.tencent.mobileqq.config.avatar.download;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.ak;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ)\u0010\u0015\u001a\u00020\u00062!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00060\u0010R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/download/g;", "", "", "url", "", "c", "", "l", "j", h.F, "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "subIndex", "i", "f", "k", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "callback", "d", "", "b", "Ljava/util/Set;", "mTaskSet", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f202388a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> mTaskSet = new LinkedHashSet();

    g() {
    }

    private final synchronized boolean c(String url) {
        boolean contains;
        Set<String> set = mTaskSet;
        contains = set.contains(url);
        if (!contains) {
            if (QLog.isColorLevel()) {
                QLog.i("TofuBgResUtil", 2, "[checkAndAddTask]: addDownloading Task, url is " + url);
            }
            set.add(url);
        }
        return contains;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ArrayList<String> b16 = ak.f202506a.a().b();
        Intrinsics.checkNotNullExpressionValue(b16, "OnlineStatusConfigRepo.g\u2026rentConfig().allTofuBgUrl");
        Iterator<T> it = b16.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            z16 &= f202388a.h((String) it.next());
        }
        callback.invoke(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, int i16) {
        int i17;
        AppRuntime.Status status;
        ArrayList<au> arrayList;
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (i3 <= AppRuntime.Status.dnd.getValue()) {
            status = ae.b(i3);
            Intrinsics.checkNotNullExpressionValue(status, "translate(statusId)");
            i17 = 0;
        } else {
            i17 = i3;
            status = status2;
        }
        au I = af.C().I(status, i17);
        Intrinsics.checkNotNullExpressionValue(I, "getInstance().getOnlineS\u2026atus, extStatus.toLong())");
        if (I.f255489b == 1000 && I.f255494g == status2 && (arrayList = I.f255512y) != null && arrayList.size() > 0 && I.f255512y.size() > i16) {
            au auVar = I.f255512y.get(i16);
            Intrinsics.checkNotNullExpressionValue(auVar, "item.batteryList[subIndex]");
            I = auVar;
        }
        String str = I.f255507t;
        Intrinsics.checkNotNullExpressionValue(str, "item.tofuBackground");
        f202388a.h(str);
    }

    private final boolean h(String url) {
        try {
            String j3 = j(url);
            File file = new File(j3);
            String md5 = MD5.toMD5(url);
            if (file.exists()) {
                QLog.i("TofuBgResUtil", 1, "[downloadSingleTofuBackground]: bgFile exists, path is " + j3);
                return true;
            }
            if (c(url)) {
                QLog.i("TofuBgResUtil", 1, "[downloadSingleTofuBackground]: url already have downloadTask, url is " + md5);
                return false;
            }
            String str = j3 + "_tmp";
            File file2 = new File(str);
            boolean download = HttpDownloadUtil.download(MobileQQ.sMobileQQ.peekAppRuntime(), url, file2);
            QLog.i("TofuBgResUtil", 1, "[downloadSingleTofuBackground]: download result is " + download + ", url is " + md5);
            if (!download) {
                l(url);
                if (file2.exists()) {
                    file2.delete();
                }
                return false;
            }
            boolean rename = FileUtils.rename(str, j3);
            QLog.i("TofuBgResUtil", 1, "[downloadSingleTofuBackground]: rename result is " + rename + ", url is " + md5);
            l(url);
            if (!rename) {
                if (file2.exists()) {
                    file2.delete();
                }
                if (file.exists()) {
                    file.delete();
                }
            }
            return rename;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TofuBgResUtil", 2, "[downloadSingleTofuBackground]: download exception: " + e16 + ", url is " + url);
            }
            l(url);
            return false;
        }
    }

    private final String j(String url) {
        List split$default;
        Object last;
        String h16 = com.tencent.mobileqq.config.avatar.d.f202369a.h();
        String str = File.separator;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{"/"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        return h16 + str + MD5.toMD5((String) last);
    }

    private final synchronized void l(String url) {
        Set<String> set = mTaskSet;
        if (set.contains(url)) {
            if (QLog.isColorLevel()) {
                QLog.i("TofuBgResUtil", 2, "[checkAndAddTask]: remove Task, url is " + url);
            }
            set.remove(url);
        }
    }

    public final void d(@NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.download.e
            @Override // java.lang.Runnable
            public final void run() {
                g.e(Function1.this);
            }
        }, 128, null, true);
    }

    public final void f(final int statusId, final int subIndex) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.download.f
            @Override // java.lang.Runnable
            public final void run() {
                g.g(statusId, subIndex);
            }
        }, 128, null, true);
    }

    @NotNull
    public final String i(int statusId, int subIndex) {
        int i3;
        AppRuntime.Status status;
        ArrayList<au> arrayList;
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (statusId <= AppRuntime.Status.dnd.getValue()) {
            status = ae.b(statusId);
            Intrinsics.checkNotNullExpressionValue(status, "translate(statusId)");
            i3 = 0;
        } else {
            i3 = statusId;
            status = status2;
        }
        au I = af.C().I(status, i3);
        Intrinsics.checkNotNullExpressionValue(I, "getInstance().getOnlineS\u2026atus, extStatus.toLong())");
        if (I.f255489b == 1000 && I.f255494g == status2 && (arrayList = I.f255512y) != null && arrayList.size() > 0 && I.f255512y.size() > subIndex) {
            au auVar = I.f255512y.get(subIndex);
            Intrinsics.checkNotNullExpressionValue(auVar, "item.batteryList[subIndex]");
            I = auVar;
        }
        String str = I.f255507t;
        Intrinsics.checkNotNullExpressionValue(str, "item.tofuBackground");
        return j(str);
    }

    public final boolean k(int statusId, int subIndex) {
        boolean z16;
        if (i(statusId, subIndex).length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        try {
            return new File(i(statusId, subIndex)).exists();
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.e("TofuBgResUtil", 2, "isResReady: " + e16);
            return false;
        }
    }
}
