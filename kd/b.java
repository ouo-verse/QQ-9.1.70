package kd;

import com.qzone.reborn.feedpro.part.QzoneFeedProTimeLinePart;
import com.qzone.reborn.feedpro.part.m;
import com.qzone.reborn.feedpro.part.userhome.QZoneFeedProUserHomeTitlePart;
import com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeActionPanelPart;
import com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.feedx.part.bg;
import com.qzone.reborn.feedx.part.cb;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import ve.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class b extends a {
    @Override // kd.a
    public List<Part> a(i iVar) {
        ArrayList arrayList = new ArrayList(super.a(iVar));
        arrayList.add(new QzoneFeedProTimeLinePart());
        arrayList.add(new QZoneFeedProUserHomeTitlePart());
        arrayList.add(new QzoneFeedProUserHomeDateTitlePart());
        arrayList.add(new QzoneFeedProUserHomeActionPanelPart());
        arrayList.add(new bg());
        arrayList.add(new cb());
        arrayList.add(new m("page_launch_user_home"));
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.c());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, re.b.class));
        return arrayList;
    }
}
