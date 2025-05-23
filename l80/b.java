package l80;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import p70.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b f413955a;

    /* renamed from: b, reason: collision with root package name */
    protected i f413956b;

    public void a(QCircleLayerBean qCircleLayerBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, ImageView imageView) {
        String e16 = e();
        w20.a.j().registerDisplaySurface(e16, b());
        qCircleLayerBean.setGlobalViewModelKey(e16);
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("feedid", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(this.f413955a.N1(feedCloudMeta$StFeed.f398449id.get())));
        qCircleLayerBean.setSchemeAttrs(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IDataDisplaySurface<e30.b> b() {
        return this.f413955a;
    }

    public int c(String str) {
        return this.f413955a.N1(str);
    }

    public com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b d() {
        return this.f413955a;
    }

    protected String e() {
        return this.f413955a.U1();
    }

    public void f(i iVar) {
        this.f413956b = iVar;
    }

    public void g(com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b bVar) {
        this.f413955a = bVar;
    }

    public void h(int i3, int i16, String str) {
        this.f413955a.R1(str, i16);
    }
}
