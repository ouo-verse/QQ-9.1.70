package com.tencent.mobileqq.tianshu.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0000\"\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "", "d", "", "b", "a", "e", "otherInfo", "f", "", "g", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "TAG", "tianshu-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f293173a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f293173a = "TianshuRedTouch";
        }
    }

    public static final boolean a(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        Boolean e16 = b.e(appInfo);
        Intrinsics.checkNotNullExpressionValue(e16, "isEfficaciousRedNumber(this)");
        return e16.booleanValue();
    }

    public static final int b(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        if (d(appInfo) && appInfo.red_display_info.red_type_info.get() != null) {
            List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.red_type_info.get();
            Intrinsics.checkNotNullExpressionValue(list, "red_display_info.red_type_info.get()");
            if (!list.isEmpty()) {
                return list.get(0).red_type.get();
            }
        }
        return 0;
    }

    @NotNull
    public static final String c() {
        return f293173a;
    }

    public static final boolean d(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        appInfo.path.get();
        if (appInfo.iNewFlag.get() == 0 || appInfo.red_display_info.get() == null) {
            return false;
        }
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.red_type_info.get();
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return true;
    }

    public static final boolean e(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        if (appInfo.click_max.get() <= 1) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo2) {
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        if (appInfo2 == null) {
            return false;
        }
        if (a(appInfo2)) {
            if (appInfo.num.get() != appInfo2.num.get()) {
                return false;
            }
            return true;
        }
        if (!d(appInfo2)) {
            return false;
        }
        return Intrinsics.areEqual(appInfo.hash.get(), appInfo2.hash.get());
    }

    @NotNull
    public static final String g(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        String f16 = b.f(appInfo);
        Intrinsics.checkNotNullExpressionValue(f16, "toLog(this)");
        return f16;
    }
}
