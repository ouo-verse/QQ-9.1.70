package b50;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.part.cf;
import com.tencent.biz.qqcircle.immersive.part.dg;
import com.tencent.biz.qqcircle.immersive.part.dl;
import com.tencent.biz.qqcircle.immersive.part.dn;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.f {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(@NonNull com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar.b() instanceof QCircleLayerBean)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(((com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar).b()));
        cf cfVar = new cf();
        cfVar.aa(aVar.b());
        arrayList.add(cfVar);
        arrayList.add(new dn(v()));
        arrayList.add(new dl(v()));
        arrayList.add(new dg(v()));
        arrayList.add(new br());
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || !TextUtils.equals(qCircleInitBean.getSchemeAttrs().get("xsj_custom_pgid"), "pg_xsj_chat_history_short_video_page")) {
            return false;
        }
        return true;
    }
}
