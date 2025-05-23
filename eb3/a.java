package eb3;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.QBaseActivityInjectUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Leb3/a;", "Landroid/content/ContextWrapper;", "Landroid/content/res/Resources;", "getResources", "Landroid/content/Context;", "a", "Landroid/content/Context;", PM.BASE, "<init>", "(Landroid/content/Context;)V", "b", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context base;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context base) {
        super(base);
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Object first;
        Resources resources = super.getResources();
        try {
            ArrayList<com.tencent.mobileqq.app.displaymetric.b> checkerList = QBaseActivityInjectUtil.sDisplayMetricCheckerList;
            Intrinsics.checkNotNullExpressionValue(checkerList, "checkerList");
            if (!checkerList.isEmpty()) {
                QLog.d("MWXAContextImpl", 4, "getResources checkerList.isNotEmpty()");
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) checkerList);
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                ((com.tencent.mobileqq.app.displaymetric.b) first).a(resources);
            }
        } catch (Throwable th5) {
            QLog.e("MWXAContextImpl", 1, "[checkDisplayMetric]: ", th5);
        }
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources;
    }
}
