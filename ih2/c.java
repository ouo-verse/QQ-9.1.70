package ih2;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.qqgamepub.hippy.module.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\n2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0006\u0010\u000e\u001a\u00020\nR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lih2/c;", "Lcom/tencent/mobileqq/qqgamepub/hippy/module/e$a;", "Landroid/app/Activity;", "getHostActivity", "", "a", "Ljava/util/ArrayList;", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "Lkotlin/collections/ArrayList;", "wadlResults", "", "b", "wadlResult", "onWadlTaskStatusChanged", "c", "Ljava/lang/ref/WeakReference;", "Lih2/d;", "Ljava/lang/ref/WeakReference;", "weakRefWadlModule", "kuiklyWadlModule", "<init>", "(Lih2/d;)V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements e.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<d> weakRefWadlModule;

    public c(@Nullable d dVar) {
        if (dVar != null) {
            this.weakRefWadlModule = new WeakReference<>(dVar);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
    @NotNull
    public String a() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
    public void b(@NotNull ArrayList<WadlResult> wadlResults) {
        d dVar;
        Intrinsics.checkNotNullParameter(wadlResults, "wadlResults");
        WeakReference<d> weakReference = this.weakRefWadlModule;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.r(wadlResults);
        }
    }

    public final void c() {
        WeakReference<d> weakReference = this.weakRefWadlModule;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
    @Nullable
    public Activity getHostActivity() {
        d dVar;
        WeakReference<d> weakReference = this.weakRefWadlModule;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            return dVar.getActivity();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
    public void onWadlTaskStatusChanged(@NotNull WadlResult wadlResult) {
        d dVar;
        Intrinsics.checkNotNullParameter(wadlResult, "wadlResult");
        WeakReference<d> weakReference = this.weakRefWadlModule;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.t(wadlResult);
        }
    }
}
