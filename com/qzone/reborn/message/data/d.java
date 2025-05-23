package com.qzone.reborn.message.data;

import bl.CommonNoticeBean;
import bl.CommonNoticePattonInfo;
import bl.CommonStComment;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/message/data/d;", "", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedDataList", "Lbl/a;", "a", "feedData", "Lbl/f;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f58259a = new d();

    d() {
    }

    public final List<CommonNoticeBean> a(List<? extends BusinessFeedData> feedDataList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(feedDataList, "feedDataList");
        List<? extends BusinessFeedData> list = feedDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CommonNoticeBean(f58259a.b((BusinessFeedData) it.next()), new CommonStCommonExt()));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0040, code lost:
    
        if (r2 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final bl.f b(BusinessFeedData feedData) {
        CommonNoticePattonInfo commonNoticePattonInfo;
        CommonStComment commonStComment;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        bl.f fVar = new bl.f();
        fVar.u(e.q(feedData));
        fVar.y(e.g(feedData));
        fVar.o(e.d(feedData));
        fVar.v(e.f(feedData));
        fVar.w(e.e(feedData));
        CellLeftThumb leftThumb = feedData.getLeftThumb();
        if (leftThumb != null) {
            Intrinsics.checkNotNullExpressionValue(leftThumb, "leftThumb");
            commonNoticePattonInfo = e.k(leftThumb);
        }
        commonNoticePattonInfo = new CommonNoticePattonInfo(0, null, null, false, 15, null);
        fVar.x(commonNoticePattonInfo);
        CellUserInfo cellUserInfo = feedData.cellUserInfo;
        fVar.A(e.c(cellUserInfo != null ? cellUserInfo.user : null));
        fVar.n(e.j(feedData));
        Comment h16 = e.h(feedData);
        if (h16 == null || (commonStComment = e.a(h16)) == null) {
            commonStComment = new CommonStComment(null, null, null, 0L, null, 0, null, null, 255, null);
        }
        fVar.r(commonStComment);
        Reply i3 = e.i(feedData);
        fVar.s(i3 != null ? e.b(i3) : null);
        fVar.t(g.f58262a.a(feedData));
        fVar.q(feedData);
        return fVar;
    }
}
