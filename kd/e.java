package kd;

import com.qzone.reborn.feedpro.part.k;
import com.qzone.reborn.feedx.part.bb;
import com.qzone.reborn.feedx.part.userhome.QZoneUserHomeRedirectFamousPart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import ve.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends b {
    @Override // kd.a
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k());
        arrayList.add(new QZoneUserHomeRedirectFamousPart());
        if (bb.INSTANCE.a()) {
            arrayList.add(new bb());
        }
        arrayList.add(new com.qzone.reborn.feedx.part.a());
        return arrayList;
    }
}
