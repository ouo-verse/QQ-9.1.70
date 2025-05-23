package kd;

import com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeBtnGroupPart;
import com.qzone.reborn.feedpro.part.userhome.q;
import com.qzone.reborn.feedx.part.cp;
import com.qzone.reborn.feedx.part.userhome.QZoneUserHomeRedirectFamousPart;
import com.qzone.reborn.feedx.part.userhome.p;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import ve.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends b {
    @Override // kd.a
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new p());
        arrayList.add(new cp());
        arrayList.add(new QzoneFeedProUserHomeBtnGroupPart());
        arrayList.add(new q());
        arrayList.add(new QZoneUserHomeRedirectFamousPart());
        return arrayList;
    }
}
