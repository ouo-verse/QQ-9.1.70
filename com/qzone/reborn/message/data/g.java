package com.qzone.reborn.message.data;

import cl.CommonNoticeInteractiveInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.util.l;
import com.tencent.luggage.wxa.ig.k;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/message/data/g;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "Lcl/c;", "a", "b", "Lcl/c;", "leaveMsgBtnInfo", "c", "lookUpBtnInfo", "d", "returnGiftBtnInfo", "e", "visitReturnBtnInfo", "f", "likeBtnInfo", "g", "joinedAlbumBtnInfo", h.F, "joinAlbumBtnInfo", "i", "defaultChatBtnInfo", "j", "defaultReplyBtnInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f58262a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo leaveMsgBtnInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo lookUpBtnInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo returnGiftBtnInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo visitReturnBtnInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo likeBtnInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo joinedAlbumBtnInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo joinAlbumBtnInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo defaultChatBtnInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final CommonNoticeInteractiveInfo defaultReplyBtnInfo;

    static {
        String a16 = l.a(R.string.w_r);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_pas\u2026ve_message_btn_leave_msg)");
        leaveMsgBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_comment_qzone, a16, 0, 4, false, null, 0, false, null, 500, null);
        String a17 = l.a(R.string.w_n);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_passive_message_btn_eye_on)");
        lookUpBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_see_testing, a17, 0, 8, false, null, 0, false, null, 500, null);
        String a18 = l.a(R.string.get);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(com.tencent.mobile\u2026e_feed_button_reply_gift)");
        returnGiftBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_thank_testing, a18, 0, 7, false, null, 0, false, null, 500, null);
        String a19 = l.a(R.string.w_t);
        Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qzone_pas\u2026message_btn_visit_return)");
        visitReturnBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_interact_testing, a19, 0, 6, false, null, 0, false, null, 500, null);
        String a26 = l.a(R.string.w_s);
        Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qzone_passive_message_btn_like)");
        likeBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_like, a26, 0, 3, false, null, 0, false, null, 500, null);
        String a27 = l.a(R.string.w_q);
        Intrinsics.checkNotNullExpressionValue(a27, "qqStr(R.string.qzone_pas\u2026message_btn_joined_album)");
        joinedAlbumBtnInfo = new CommonNoticeInteractiveInfo(0, a27, R.color.qui_common_text_tertiary, 0, false, null, 0, false, null, k.CTRL_INDEX, null);
        String a28 = l.a(R.string.w_o);
        Intrinsics.checkNotNullExpressionValue(a28, "qqStr(R.string.qzone_pas\u2026e_message_btn_join_album)");
        joinAlbumBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_tick, a28, 0, 5, false, null, 0, false, null, 500, null);
        String a29 = l.a(R.string.w_l);
        Intrinsics.checkNotNullExpressionValue(a29, "qqStr(R.string.qzone_passive_message_btn_chat)");
        defaultChatBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_message_testing, a29, 0, 2, false, null, 0, false, null, 500, null);
        String a36 = l.a(R.string.ges);
        Intrinsics.checkNotNullExpressionValue(a36, "qqStr(com.tencent.mobile\u2026.qzone_feed_button_reply)");
        defaultReplyBtnInfo = new CommonNoticeInteractiveInfo(R.drawable.qui_comment_testing, a36, 0, 1, false, null, 0, false, null, 500, null);
    }

    g() {
    }

    public final List<CommonNoticeInteractiveInfo> a(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        ArrayList arrayList = new ArrayList();
        f fVar = f.f58260a;
        if (fVar.m(feedData)) {
            arrayList.add(leaveMsgBtnInfo);
            return arrayList;
        }
        if (fVar.z(feedData)) {
            arrayList.add(visitReturnBtnInfo);
            return arrayList;
        }
        CellLocalInfo localInfoV2 = feedData.getLocalInfoV2();
        if (localInfoV2 != null && localInfoV2.canJoinAlbum) {
            arrayList.add(joinAlbumBtnInfo);
            return arrayList;
        }
        CellLocalInfo localInfoV22 = feedData.getLocalInfoV2();
        if (localInfoV22 != null && localInfoV22.joinedAlbum) {
            arrayList.add(joinedAlbumBtnInfo);
            return arrayList;
        }
        if (fVar.o(feedData)) {
            arrayList.add(returnGiftBtnInfo);
            return arrayList;
        }
        if (fVar.q(feedData)) {
            arrayList.add(lookUpBtnInfo);
            return arrayList;
        }
        gl.c cVar = gl.c.f402376a;
        User user = feedData.getUser();
        if (gl.c.c(cVar, user != null ? user.uin : 0L, null, 2, null) && fVar.d(feedData)) {
            arrayList.add(defaultChatBtnInfo);
        }
        if (fVar.d(feedData)) {
            arrayList.add(defaultReplyBtnInfo);
        }
        return arrayList;
    }
}
