package com.tencent.biz.qqcircle.immersive.views.search.mixuser;

import android.content.Context;
import android.util.Size;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e80.j;
import feedcloud.FeedCloudMeta$StFeed;
import k80.g;
import l90.a;
import l90.b;
import l90.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchMixUserItemView extends QFSSearchBaseCardItemView {
    public QFSSearchMixUserItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView
    @NonNull
    protected g B0() {
        return new b();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.grh;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView
    protected void n0(j<FeedCloudMeta$StFeed> jVar) {
        jVar.c(new c());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView
    protected Size o0() {
        if (p.A(this.D)) {
            return ad.l(this);
        }
        return ad.g(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView
    protected String u0() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_USER_ITEM_BIG_V_FEED;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView
    @NonNull
    protected k80.b z0() {
        return new a();
    }
}
