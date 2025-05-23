package ky;

import android.content.Context;
import android.os.Bundle;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB;
import com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.notifyservice.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cy.d;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\b\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006`\u0007H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lky/b;", "Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVB;", "", "C1", "B1", "Ljava/util/HashSet;", "Lcom/tencent/aio/base/mvvm/a;", "Lkotlin/collections/HashSet;", "g1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "e1", "bindViewAndData", "", "visibility", "z1", "x1", "A1", "Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM;", "getMNotifyServiceVM", "()Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM;", "setMNotifyServiceVM", "(Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVM;)V", "mNotifyServiceVM", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends PublicAccountInputContainerVB {

    /* renamed from: C, reason: from kotlin metadata */
    private PublicAccountInputContainerVM mNotifyServiceVM;

    private final void B1() {
        h1().f411143c.setBackground(h1().getRoot().getResources().getDrawable(R.drawable.lvj));
    }

    private final void C1() {
        h1().f411143c.setBackground(h1().getRoot().getResources().getDrawable(R.drawable.lvj));
    }

    @Override // com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB
    public void A1() {
        C1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        Bundle l3;
        super.bindViewAndData();
        PublicAccountInputContainerVM publicAccountInputContainerVM = this.mNotifyServiceVM;
        Integer valueOf = (publicAccountInputContainerVM == null || (aVar = (com.tencent.aio.api.runtime.a) publicAccountInputContainerVM.getMContext()) == null || (g16 = aVar.g()) == null || (l3 = g16.l()) == null) ? null : Integer.valueOf(l3.getInt("key_chat_type"));
        VideoReport.setPageParams(h1().f411145e, c.b());
        VideoReport.setPageReportPolicy(h1().f411145e, PageReportPolicy.REPORT_ALL);
        if (h1().f411145e.getContext() instanceof BaseActivity) {
            Context context = h1().f411145e.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
            VideoReport.addToDetectionWhitelist((BaseActivity) context);
        }
        if (valueOf != null && valueOf.intValue() == 118) {
            VideoReport.setPageId(h1().f411145e, "pg_bas_service_node_details");
        } else if (valueOf != null && valueOf.intValue() == 201) {
            VideoReport.setPageId(h1().f411145e, "pg_bas_service_notification_node_details");
        }
    }

    @Override // com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<PAInputIntent, PAInputUIState> createVM() {
        PublicAccountInputContainerVM publicAccountInputContainerVM = new PublicAccountInputContainerVM();
        this.mNotifyServiceVM = publicAccountInputContainerVM;
        Intrinsics.checkNotNull(publicAccountInputContainerVM);
        return publicAccountInputContainerVM;
    }

    @Override // com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB
    public HashSet<com.tencent.aio.base.mvvm.a<?, ?>> g1() {
        HashSet<com.tencent.aio.base.mvvm.a<?, ?>> hashSet = new HashSet<>();
        hashSet.add(new d());
        return hashSet;
    }

    @Override // com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB
    public void x1(int visibility) {
        if (visibility == 0) {
            C1();
        } else {
            B1();
        }
        super.x1(visibility);
    }

    @Override // com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB
    public void z1(int visibility) {
        if (visibility == 0) {
            C1();
        } else {
            B1();
        }
        super.z1(visibility);
    }
}
