package com.qzone.reborn.albumx.qzonex.event;

import bb.a;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.util.ArrayUtils;
import fj.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o9.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR6\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR6\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxDeleteMediaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Lbb/a;", "Lkotlin/collections/ArrayList;", "deleteList", "Ljava/util/ArrayList;", "getDeleteList", "()Ljava/util/ArrayList;", "setDeleteList", "(Ljava/util/ArrayList;)V", "", "feedList", "getFeedList", "setFeedList", "batchList", "getBatchList", "setBatchList", "Lo9/f;", "operateBean", "<init>", "(Lo9/f;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxDeleteMediaEvent extends SimpleBaseEvent {
    public static final String TAG = "GroupAlbumDeleteMediaEvent";
    private ArrayList<String> batchList;
    private ArrayList<a> deleteList;
    private ArrayList<String> feedList;

    public QZAlbumxDeleteMediaEvent(f operateBean) {
        Intrinsics.checkNotNullParameter(operateBean, "operateBean");
        this.deleteList = new ArrayList<>();
        this.feedList = new ArrayList<>();
        this.batchList = new ArrayList<>();
        if (ArrayUtils.isOutOfArrayIndex(0, operateBean.c())) {
            RFWLog.e("GroupAlbumDeleteMediaEvent", RFWLog.USR, "media list is empty");
            return;
        }
        a aVar = new a();
        Iterator<CommonStMedia> it = operateBean.c().iterator();
        while (it.hasNext()) {
            CommonStMedia media = it.next();
            aVar.d(media.getBatchId());
            String albumId = operateBean.getAlbumId();
            aVar.c(albumId == null ? "" : albumId);
            aVar.f(media.getType() == 1);
            p pVar = p.f399467a;
            Intrinsics.checkNotNullExpressionValue(media, "media");
            aVar.e(pVar.i(media));
            this.deleteList.add(aVar);
        }
    }

    public final ArrayList<String> getBatchList() {
        return this.batchList;
    }

    public final ArrayList<a> getDeleteList() {
        return this.deleteList;
    }

    public final ArrayList<String> getFeedList() {
        return this.feedList;
    }

    public final void setBatchList(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.batchList = arrayList;
    }

    public final void setDeleteList(ArrayList<a> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.deleteList = arrayList;
    }

    public final void setFeedList(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.feedList = arrayList;
    }
}
