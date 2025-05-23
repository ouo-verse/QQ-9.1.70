package m01;

import com.tencent.kuikly.core.base.v;
import com.tencent.kuikly.core.base.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0006\u0010\u000e\u001a\u00020\u0002R$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0000@BX\u0080\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\u00a8\u0006#"}, d2 = {"Lm01/b;", "Lcom/tencent/kuikly/core/base/v;", "", "c", "", "key", "", "value", "setProp", "", "width", "height", "Lcom/tencent/kuikly/core/base/w;", "calculateRenderViewSize", "b", "", "<set-?>", "a", "Z", "isDirty", "()Z", "Ljava/lang/Float;", "lastWidth", "lastHeight", "d", "Lcom/tencent/kuikly/core/base/w;", "lastSize", "e", "calculateFromCache", "pagerId", "", "viewRef", "viewName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b extends v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isDirty;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Float lastWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Float lastHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w lastSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean calculateFromCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String pagerId, int i3, String viewName) {
        super(pagerId, i3, viewName);
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.isDirty = true;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCalculateFromCache() {
        return this.calculateFromCache;
    }

    public final void b() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        this.lastSize = null;
    }

    @Override // com.tencent.kuikly.core.base.v
    public w calculateRenderViewSize(float width, float height) {
        w wVar;
        if (!this.isDirty && Intrinsics.areEqual(this.lastWidth, width) && Intrinsics.areEqual(this.lastHeight, height) && (wVar = this.lastSize) != null) {
            this.calculateFromCache = true;
            Intrinsics.checkNotNull(wVar);
            return wVar;
        }
        this.calculateFromCache = false;
        w calculateRenderViewSize = super.calculateRenderViewSize(width, height);
        c();
        this.lastWidth = Float.valueOf(width);
        this.lastHeight = Float.valueOf(height);
        this.lastSize = calculateRenderViewSize;
        return calculateRenderViewSize;
    }

    @Override // com.tencent.kuikly.core.base.v
    public void setProp(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        super.setProp(key, value);
        b();
    }

    private final void c() {
        this.isDirty = false;
    }
}
