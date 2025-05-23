package com.tencent.mobileqq.app.displaymetric;

import android.content.res.Resources;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.app.QBaseActivityInjectUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/displaymetric/a;", "", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "", "a", "<init>", "()V", "base_activity_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f195491a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37592);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195491a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Resources resources) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources);
            return;
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        try {
            ArrayList<b> checkerList = QBaseActivityInjectUtil.sDisplayMetricCheckerList;
            Intrinsics.checkNotNullExpressionValue(checkerList, "checkerList");
            if (!checkerList.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) checkerList);
                ((b) first).a(resources);
            }
        } catch (Throwable th5) {
            QLog.e("DisplayMetricUtils", 1, "[checkDisplayMetric]: ", th5);
        }
    }
}
