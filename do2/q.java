package do2;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ldo2/q;", "Lcom/tencent/mobileqq/search/model/x;", "", "l", "", "Lcom/tencent/mobileqq/search/model/y;", "o", "Landroid/view/View;", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "", tl.h.F, "Ljava/util/List;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/util/List;", "groupList", "<init>", "(Ljava/util/List;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class q extends x {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<x> groupList;

    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull List<? extends x> groupList) {
        Intrinsics.checkNotNullParameter(groupList, "groupList");
        this.groupList = groupList;
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    public String l() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    public String m() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    public List<y> o() {
        return new ArrayList();
    }

    @NotNull
    public final List<x> s() {
        return this.groupList;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(@Nullable View view) {
    }
}
