package a50;

import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.helpers.f;
import com.tencent.biz.qqcircle.immersive.layer.base.b;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTagPolymerizationTaskDoneDialogPart;
import com.tencent.biz.qqcircle.immersive.part.ch;
import com.tencent.biz.qqcircle.immersive.part.cl;
import com.tencent.biz.richframework.part.Part;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends b {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> e(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a)) {
            return null;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar2 = (com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new cl());
        arrayList.add(new QFSReportBottomSheetPart());
        f.f84618a.a(arrayList, aVar2.a(), false);
        arrayList.add(new QFSSharePart());
        QCircleLightInteractListPart qCircleLightInteractListPart = new QCircleLightInteractListPart();
        qCircleLightInteractListPart.setReportBeanAgent(aVar2.a());
        arrayList.add(qCircleLightInteractListPart);
        arrayList.add(new QCircleRichMediaDownLoadPart());
        arrayList.add(new QFSMainTabTipExpPart(true));
        arrayList.add(new QFSTagPolymerizationTaskDoneDialogPart());
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a)) {
            return null;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar2 = (com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new z40.b(aVar2.b()));
        if (aVar.b() != null) {
            ch chVar = new ch(aVar2.b());
            FeedCloudMeta$StTagInfo tagInfo = aVar.b().getTagInfo();
            if (tagInfo != null) {
                chVar.Ja(tagInfo);
            }
            chVar.Ha(aVar2.b());
            chVar.Ga(8);
            arrayList.add(chVar);
        }
        return arrayList;
    }
}
