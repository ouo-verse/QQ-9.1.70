package com.tencent.biz.qqcircle.comment.abovebar;

import android.view.View;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.comment.sticker.c;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface a extends View.OnClickListener {
    boolean O2();

    boolean Of();

    QFSCommentInputWindowConfig R4();

    String S8(List<HostSelectMemberUtils.QCircleResultData> list);

    boolean V8(int i3);

    void Z3(boolean z16);

    o20.d d8();

    FeedCloudMeta$StFeed getFeed();

    List<HostSelectMemberUtils.QCircleResultData> i9();

    boolean ka();

    void m3(boolean z16);

    void showKeyboard();

    boolean wg();

    c.b y9();
}
