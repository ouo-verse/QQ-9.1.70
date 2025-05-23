package com.qzone.reborn.message.data;

import bl.CommonNoticeBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZIntimateSpaceReader$StPattonAction;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StRichMsg;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/message/data/b;", "", "", "Lcom/qzone/reborn/message/data/a;", "intimateMessageList", "", "Lbl/a;", "a", "Lqzone/QZIntimateSpaceReader$StNotice;", "stNotice", "Lbl/f;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f58255a = new b();

    b() {
    }

    public final List<CommonNoticeBean> a(List<a> intimateMessageList) {
        Intrinsics.checkNotNullParameter(intimateMessageList, "intimateMessageList");
        ArrayList arrayList = new ArrayList();
        for (a aVar : intimateMessageList) {
            arrayList.add(new CommonNoticeBean(f58255a.b(aVar.getStNotice()), mj.a.d(aVar.getStCommonExt())));
        }
        return arrayList;
    }

    public final bl.f b(QZIntimateSpaceReader$StNotice stNotice) {
        Intrinsics.checkNotNullParameter(stNotice, "stNotice");
        bl.f fVar = new bl.f();
        String str = stNotice.notice_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "stNotice.notice_id.get()");
        fVar.u(str);
        fVar.y(stNotice.notice_type.get());
        fVar.o(stNotice.create_time.get() * 1000);
        List<QZoneBaseMeta$StRichMsg> list = stNotice.notice_message.get();
        Intrinsics.checkNotNullExpressionValue(list, "stNotice.notice_message.get()");
        fVar.v(QZoneIntimateMessageDataConverterKt.c(list));
        fVar.x(QZoneIntimateMessageDataConverterKt.a(stNotice));
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = stNotice.op_user;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StUser, "stNotice.op_user");
        fVar.A(mj.c.a(qZoneBaseMeta$StUser));
        QZIntimateSpaceReader$StPattonAction qZIntimateSpaceReader$StPattonAction = stNotice.action.get();
        Intrinsics.checkNotNullExpressionValue(qZIntimateSpaceReader$StPattonAction, "stNotice.action.get()");
        fVar.n(QZoneIntimateMessageDataConverterKt.b(qZIntimateSpaceReader$StPattonAction));
        fVar.t(c.f58256a.a(stNotice));
        List<Integer> list2 = stNotice.op_mask.get();
        Intrinsics.checkNotNullExpressionValue(list2, "stNotice.op_mask.get()");
        fVar.z(list2);
        QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = stNotice.ext.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "stNotice.ext.get()");
        fVar.p(mj.a.d(qZoneBaseCommon$StCommonExt));
        fVar.q(stNotice);
        return fVar;
    }
}
