package e50;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.layer.base.f;
import com.tencent.biz.qqcircle.immersive.part.fg;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends f {
    public static boolean x(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || !TextUtils.equals(qCircleInitBean.getSchemeAttrs().get("key_jump_from"), String.valueOf(1005))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(@NonNull com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar.b() instanceof QCircleLayerBean)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar2 = (com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar;
        arrayList.add(new fg());
        arrayList.add(new com.tencent.biz.qqcircle.immersive.layer.biz.f(aVar2.b()));
        arrayList.add(new com.tencent.biz.qqcircle.immersive.part.profilecard.a(aVar2.b().getFeed().get().poster.f398463id.get()));
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(QCircleInitBean qCircleInitBean) {
        if (x(qCircleInitBean)) {
            return true;
        }
        return false;
    }
}
