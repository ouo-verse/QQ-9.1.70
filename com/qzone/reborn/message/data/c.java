package com.qzone.reborn.message.data;

import cl.CommonNoticeInteractiveInfo;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/message/data/c;", "", "Lqzone/QZIntimateSpaceReader$StNotice;", "stNotice", "", "Lcl/c;", "a", "b", "Lcl/c;", "defaultReplyBtnInfo", "c", "defaultChatBtnInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f58256a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo defaultReplyBtnInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo defaultChatBtnInfo;

    static {
        String a16 = l.a(R.string.ges);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026.qzone_feed_button_reply)");
        defaultReplyBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_comment_testing, a16, 0, 1, false, null, 0, false, null, 500, null);
        String a17 = l.a(R.string.w_l);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_passive_message_btn_chat)");
        defaultChatBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_message_testing, a17, 0, 2, false, null, 0, false, null, 500, null);
    }

    c() {
    }

    public final List<CommonNoticeInteractiveInfo> a(QZIntimateSpaceReader$StNotice stNotice) {
        Intrinsics.checkNotNullParameter(stNotice, "stNotice");
        ArrayList arrayList = new ArrayList();
        if (stNotice.op_mask.get().contains(1)) {
            gl.c cVar = gl.c.f402376a;
            String str = stNotice.op_user.uid.get();
            Intrinsics.checkNotNullExpressionValue(str, "stNotice.op_user.uid.get()");
            if (gl.c.c(cVar, 0L, str, 1, null)) {
                arrayList.add(defaultChatBtnInfo);
            }
            arrayList.add(defaultReplyBtnInfo);
        }
        return arrayList;
    }
}
