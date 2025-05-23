package ag3;

import android.content.Context;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.StaggerItemContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lag3/c;", "Lag3/b;", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContent;", "f", "", "d", "I", "g", "()I", "setCreateCounter", "(I)V", "createCounter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends b<StaggerItemContent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int createCounter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ag3.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public StaggerItemContent a() {
        this.createCounter++;
        return new StaggerItemContent(getContext());
    }

    /* renamed from: g, reason: from getter */
    public final int getCreateCounter() {
        return this.createCounter;
    }
}
