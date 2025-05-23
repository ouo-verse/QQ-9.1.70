package com.tencent.mobileqq.vas.social.record;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B#\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/a;", "Lcom/tencent/mobileqq/vas/social/record/b;", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "k", "step", "r", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/util/Set;", Node.CHILDREN_ATTR, "Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "stepState", "Lcom/tencent/mobileqq/vas/social/record/c;", "listener", "<init>", "(Lcom/tencent/mobileqq/vas/data/b;Lcom/tencent/mobileqq/vas/social/record/RecordState;Lcom/tencent/mobileqq/vas/social/record/c;)V", "G", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a extends b {

    /* renamed from: F, reason: from kotlin metadata */
    private final Set<b> children;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.tencent.mobileqq.vas.data.b taskInfo, RecordState stepState, c cVar) {
        super(taskInfo, stepState, cVar);
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        Intrinsics.checkNotNullParameter(stepState, "stepState");
        this.children = new LinkedHashSet();
    }

    @Override // com.tencent.mobileqq.vas.social.record.b
    public void k(RecordStepProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((b) it.next()).l(getStepState(), product);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(b step) {
        Intrinsics.checkNotNullParameter(step, "step");
        this.children.add(step);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<b> s() {
        return this.children;
    }
}
