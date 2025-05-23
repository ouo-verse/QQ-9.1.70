package gn3;

import com.tencent.now.linkscreengame.model.LinkScreenModel;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lgn3/a;", "", "", "a", "Lcom/tencent/now/linkscreengame/model/LinkScreenModel;", "Lcom/tencent/now/linkscreengame/model/LinkScreenModel;", "linkScreenModel", "", "roomId", "anchorId", "<init>", "(JJ)V", "b", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkScreenModel linkScreenModel;

    public a(long j3, long j16) {
        this.linkScreenModel = new LinkScreenModel(j3, j16);
    }

    public final void a() {
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenComponent", "LinkScreenComponent unInit");
        this.linkScreenModel.n();
    }
}
