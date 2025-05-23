package kd;

import com.qzone.reborn.feedpro.part.m;
import com.qzone.reborn.feedpro.part.moodlist.QzoneFeedProMoodListTitlePart;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.feedx.part.am;
import com.qzone.reborn.feedx.part.bb;
import com.qzone.reborn.feedx.part.bg;
import com.qzone.reborn.feedx.part.cb;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import ve.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lkd/c;", "Lkd/a;", "Lve/i;", "builder", "", "Lcom/tencent/biz/richframework/part/Part;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends a {
    @Override // kd.a
    public List<Part> b(i builder) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QzoneFeedProMoodListTitlePart());
        arrayList.add(new bg());
        arrayList.add(new am());
        arrayList.add(new cb());
        arrayList.add(new m("page_launch_mood_list"));
        if (bb.INSTANCE.a()) {
            arrayList.add(new bb());
        }
        arrayList.add(new com.qzone.reborn.feedx.part.a());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.c());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, re.b.class));
        return arrayList;
    }
}
