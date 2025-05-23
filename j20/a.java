package j20;

import com.tencent.biz.richframework.ioc.RFWIocBaseInterface;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a implements BaseWidgetView.IInteractor, RFWIocBaseInterface {

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.biz.qqcircle.immersive.views.mixfeed.a> f409150d = new ArrayList();

    public void a(com.tencent.biz.qqcircle.immersive.views.mixfeed.a aVar) {
        this.f409150d.add(aVar);
    }

    public List<com.tencent.biz.qqcircle.immersive.views.mixfeed.a> b() {
        return this.f409150d;
    }

    public void d() {
        this.f409150d.clear();
    }

    public boolean isContainerOnScreen() {
        return false;
    }

    public void c(String str, Object obj) {
    }
}
