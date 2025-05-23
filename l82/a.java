package l82;

import com.tencent.biz.richframework.order.IOrderElement;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Ll82/a;", "Lcom/tencent/biz/richframework/order/IOrderElement;", "", "getGroup", "", "isDataReady", "getGroupExtraKey", "getElementExtraKey", "", "onElementActivated", "<init>", "()V", "d", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a implements IOrderElement {
    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getElementExtraKey() {
        return "";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "feed_square";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroupExtraKey() {
        return "";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isDataReady() {
        return m82.a.f416439a.b().getGroupElementList(this).size() == 5;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
    }
}
