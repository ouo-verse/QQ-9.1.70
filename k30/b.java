package k30;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.adapter.ad;
import com.tencent.biz.qqcircle.adapter.o;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    private QCircleTabInfo C;
    private c D;

    /* renamed from: d, reason: collision with root package name */
    private final String f411456d;

    /* renamed from: e, reason: collision with root package name */
    private final int f411457e;

    /* renamed from: f, reason: collision with root package name */
    private final int f411458f;

    /* renamed from: h, reason: collision with root package name */
    private final String f411459h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleReportBean f411460i;

    /* renamed from: m, reason: collision with root package name */
    private j20.a f411461m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate<ad> {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadData(LoadInfo loadInfo, ad adVar) {
            if (b.this.D != null) {
                b.this.D.a(loadInfo, adVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: k30.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10630b implements MultiViewBlock.OnLoadDataDelegate<o> {
        C10630b() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadData(LoadInfo loadInfo, o oVar) {
            if (b.this.D != null) {
                b.this.D.a(loadInfo, oVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a(LoadInfo loadInfo, com.tencent.biz.qqcircle.bizparts.a<e30.b> aVar);
    }

    public b(String str, int i3, int i16, String str2) {
        this.f411456d = str;
        this.f411457e = i3;
        this.f411458f = i16;
        this.f411459h = str2;
        QLog.i("QCircleFeedBlockStrategyHelper", 1, "QCircleFeedBlockStrategyHelper  mTabType = " + str + " , mPageIndex = " + i3 + " , mPageLayoutType = " + i16 + " , mUniqueTabKey = " + str2);
    }

    private ad c() {
        ad adVar = new ad(new Bundle());
        adVar.setOnLoadDataDelegate(new a());
        QLog.i("QCircleFeedBlockStrategyHelper", 1, "initMixFeedBlock");
        return adVar;
    }

    private com.tencent.biz.qqcircle.adapter.e d() {
        int i3;
        if (TextUtils.equals(this.f411456d, QFSLayerTabPart.R)) {
            i3 = 1;
        } else {
            TextUtils.equals(this.f411456d, QFSLayerTabPart.Q);
            i3 = 2;
        }
        o w06 = new o(new Bundle()).w0(i3);
        w06.setOnLoadDataDelegate(new C10630b());
        QLog.i("QCircleFeedBlockStrategyHelper", 1, "initWaterFallBlock");
        return w06;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean getReportBean() {
        return this.f411460i;
    }

    public com.tencent.biz.qqcircle.adapter.e e() {
        com.tencent.biz.qqcircle.adapter.e d16;
        if (this.f411458f != 2) {
            d16 = c();
        } else {
            d16 = d();
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        QCircleTabInfo qCircleTabInfo = this.C;
        if (qCircleTabInfo != null) {
            qCircleExtraTypeInfo.pageType = qCircleTabInfo.getSource();
            qCircleExtraTypeInfo.mGlobalViewModelKey = this.f411459h;
            d16.r0(qCircleExtraTypeInfo);
            d16.s0(this.f411457e);
            QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = this.C.mTab;
            if (qQCircleFeedBase$StTabInfo != null) {
                int size = qQCircleFeedBase$StTabInfo.subTabInfo.size();
                int i3 = this.f411457e;
                if (size > i3) {
                    qCircleExtraTypeInfo.mSubPageType = this.C.mTab.subTabInfo.get(i3).sourceType.get();
                    qCircleExtraTypeInfo.mSubPageId = this.C.mTab.subTabInfo.get(this.f411457e).pageId.get();
                }
            }
        }
        d16.setReportBean(getReportBean());
        d16.setInteractor(this.f411461m);
        return d16;
    }

    public void f(c cVar) {
        this.D = cVar;
    }

    public void g(QCircleReportBean qCircleReportBean) {
        this.f411460i = qCircleReportBean;
    }

    public void h(QCircleTabInfo qCircleTabInfo) {
        this.C = qCircleTabInfo;
    }
}
