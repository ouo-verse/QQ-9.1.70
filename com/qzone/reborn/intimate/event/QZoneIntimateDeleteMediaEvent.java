package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.util.ArrayUtils;
import ij.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;
import sj.e;
import vj.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneIntimateDeleteMediaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Lij/g;", "Lkotlin/collections/ArrayList;", "deleteList", "Ljava/util/ArrayList;", "getDeleteList", "()Ljava/util/ArrayList;", "setDeleteList", "(Ljava/util/ArrayList;)V", "Lsj/e;", "operateBean", "<init>", "(Lsj/e;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateDeleteMediaEvent extends SimpleBaseEvent {
    public static final String TAG = "QZoneIntimateDeleteMediaEvent";
    private ArrayList<g> deleteList;

    public QZoneIntimateDeleteMediaEvent(e operateBean) {
        Intrinsics.checkNotNullParameter(operateBean, "operateBean");
        this.deleteList = new ArrayList<>();
        if (ArrayUtils.isOutOfArrayIndex(0, operateBean.c())) {
            RFWLog.e(TAG, RFWLog.USR, "media list is empty");
            return;
        }
        g gVar = new g();
        Iterator<QZoneBaseMeta$StMedia> it = xh.e.g(operateBean.c()).iterator();
        while (it.hasNext()) {
            QZoneBaseMeta$StMedia media = it.next();
            gVar.b(media.batch_id.get());
            String albumId = operateBean.getAlbumId();
            gVar.a(albumId == null ? "" : albumId);
            gVar.d(media.type.get() == 1);
            d dVar = d.f441734a;
            Intrinsics.checkNotNullExpressionValue(media, "media");
            gVar.c(dVar.j(media));
            this.deleteList.add(gVar);
        }
    }

    public final ArrayList<g> getDeleteList() {
        return this.deleteList;
    }

    public final void setDeleteList(ArrayList<g> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.deleteList = arrayList;
    }
}
