package kd;

import com.qzone.reborn.feedpro.part.QzoneFriendFeedProCeilingPublishBarPart;
import com.qzone.reborn.feedpro.part.QzoneFriendFeedProTitlePart;
import com.qzone.reborn.feedpro.part.l;
import com.qzone.reborn.feedpro.part.m;
import com.qzone.reborn.feedpro.part.p;
import com.qzone.reborn.feedpro.part.r;
import com.qzone.reborn.feedpro.part.v;
import com.qzone.reborn.feedpro.part.y;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkd/f;", "Lkd/a;", "", "Lcom/tencent/biz/richframework/part/Part;", "d", "e", "Lve/i;", "builder", "b", "Lcom/qzone/reborn/feedpro/part/QzoneFriendFeedProTitlePart;", "a", "Lcom/qzone/reborn/feedpro/part/QzoneFriendFeedProTitlePart;", "mFeedxTitlePart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QzoneFriendFeedProTitlePart mFeedxTitlePart;

    private final List<Part> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new p());
        arrayList.add(new l());
        return arrayList;
    }

    private final List<Part> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v());
        arrayList.add(new y());
        return arrayList;
    }

    @Override // kd.a
    public List<Part> b(i builder) {
        ArrayList arrayList = new ArrayList();
        QzoneFriendFeedProTitlePart qzoneFriendFeedProTitlePart = new QzoneFriendFeedProTitlePart();
        this.mFeedxTitlePart = qzoneFriendFeedProTitlePart;
        Intrinsics.checkNotNull(qzoneFriendFeedProTitlePart);
        arrayList.add(qzoneFriendFeedProTitlePart);
        arrayList.add(new r());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.c());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, re.b.class));
        arrayList.add(new QzoneFriendFeedProCeilingPublishBarPart());
        arrayList.add(new m("page_launch_friend_feed"));
        arrayList.addAll(e());
        arrayList.addAll(d());
        return arrayList;
    }
}
