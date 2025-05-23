package pg2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import androidx.core.view.LayoutInflaterCompat;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.hr.ECKuiklyExport;
import com.tencent.ecommerce.biz.hr.adapter.h;
import com.tencent.ecommerce.biz.hr.module.ECHRShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lpg2/b;", "", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "d", "e", "f", "a", "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "c", "Landroid/content/Context;", "context", "b", "", "Z", "hadInitECSkin", "<init>", "()V", "qqecommerce_shell_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f426174a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hadInitECSkin;

    b() {
    }

    public final void a() {
        ECPluginApplication.Companion companion = ECPluginApplication.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.d(context);
        h.f102529b.a();
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (!hadInitECSkin) {
                ECSkin eCSkin = ECSkin.INSTANCE;
                BaseApplication context2 = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
                eCSkin.init(context2);
                hadInitECSkin = true;
            }
            ECSkin eCSkin2 = ECSkin.INSTANCE;
            LayoutInflater.Factory2 skinFactory2 = eCSkin2.getSkinFactory2();
            if (skinFactory2 != null) {
                LayoutInflaterCompat.setFactory2(LayoutInflater.from(context), skinFactory2);
            }
            eCSkin2.loadResource();
        } catch (Throwable th5) {
            QLog.e("QQECKuiklyExport", 1, "initECSkinResource: " + th5);
        }
    }

    public final void c(int resultCode, @Nullable Intent data) {
        ECHRShare.f102572h.j(resultCode, data);
    }

    public final void d(@NotNull com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        ECKuiklyExport.f102513a.a(kuiklyRenderExport);
    }

    public final void e(@NotNull com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        ECKuiklyExport.f102513a.b(kuiklyRenderExport);
    }

    public final void f(@NotNull com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        ECKuiklyExport.f102513a.c(kuiklyRenderExport);
    }
}
