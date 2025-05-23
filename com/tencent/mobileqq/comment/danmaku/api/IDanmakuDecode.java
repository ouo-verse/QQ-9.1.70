package com.tencent.mobileqq.comment.danmaku.api;

import android.graphics.Paint;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea$Comment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IDanmakuDecode extends QRouteApi {
    List<DanmuItemBean> decodeCommentList(List<oidb_0xdea$Comment> list, long j3, Paint paint, int i3);
}
