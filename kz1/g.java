package kz1;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\n\u001a\u00028\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lkz1/g;", "Lmz1/c;", "T", "Landroidx/viewbinding/ViewBinding;", "VB", "Lkz1/i;", UserInfo.SEX_FEMALE, "Landroidx/viewbinding/ViewBinding;", ReportConstant.COSTREPORT_PREFIX, "()Landroidx/viewbinding/ViewBinding;", "viewBinding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class g<T extends mz1.c, VB extends ViewBinding> extends i<T> {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final VB viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g(@NotNull VB viewBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        this.viewBinding = viewBinding;
    }

    @NotNull
    public final VB s() {
        return this.viewBinding;
    }
}
