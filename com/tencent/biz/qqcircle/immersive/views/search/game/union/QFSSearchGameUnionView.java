package com.tencent.biz.qqcircle.immersive.views.search.game.union;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudRead$StSearchGameCollection;
import u80.a;
import w80.c;
import x80.d;
import x80.e;
import x80.f;
import x80.g;
import x80.i;
import x80.j;
import x80.k;
import y80.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchGameUnionView extends QFSSearchBaseWidgetView<FeedCloudRead$StSearchGameCollection> {

    /* renamed from: e, reason: collision with root package name */
    private final a f91129e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f91130f;

    /* renamed from: h, reason: collision with root package name */
    private k f91131h;

    public QFSSearchGameUnionView(@NonNull Context context) {
        super(context);
        a aVar = new a();
        this.f91129e = aVar;
        k kVar = new k();
        this.f91131h = kVar;
        aVar.c(kVar);
        aVar.c(new g());
        aVar.c(new i(R.layout.grz));
        aVar.c(new d());
        aVar.c(new e(R.layout.f168757gs2));
        aVar.c(new f());
        aVar.c(new j(R.layout.f168757gs2));
        aVar.h(this);
        aVar.l(new b());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168755gs0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchGameCollection feedCloudRead$StSearchGameCollection, int i3) {
        this.f91131h.l1(this.f91130f);
        this.f91129e.f(new c(feedCloudRead$StSearchGameCollection), 0);
    }

    public void setBannerExist(boolean z16) {
        this.f91130f = z16;
    }
}
