package af;

import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Laf/a;", "", "Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "a", "Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "()Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "c", "(Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;)V", "commInfo", "", "<set-?>", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "key", "feedKey", "<init>", "(Ljava/lang/String;Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CellFeedCommInfo commInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String key;

    public a(String str, CellFeedCommInfo commInfo) {
        Intrinsics.checkNotNullParameter(commInfo, "commInfo");
        this.commInfo = commInfo;
        this.key = str == null ? "" : str;
    }

    /* renamed from: a, reason: from getter */
    public final CellFeedCommInfo getCommInfo() {
        return this.commInfo;
    }

    /* renamed from: b, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final void c(CellFeedCommInfo cellFeedCommInfo) {
        Intrinsics.checkNotNullParameter(cellFeedCommInfo, "<set-?>");
        this.commInfo = cellFeedCommInfo;
    }
}
