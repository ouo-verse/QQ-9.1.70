package ci;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lci/b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "Lci/e;", "k", "Lci/e;", "u", "()Lci/e;", "v", "(Lci/e;)V", "layerListBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends com.qzone.reborn.albumx.common.bean.b {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private e layerListBean = new e();

    /* renamed from: u, reason: from getter */
    public final e getLayerListBean() {
        return this.layerListBean;
    }

    public final void v(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.layerListBean = eVar;
    }
}
