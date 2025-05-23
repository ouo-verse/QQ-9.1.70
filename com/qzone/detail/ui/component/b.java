package com.qzone.detail.ui.component;

import android.view.View;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.biz.richframework.ioc.RFWIocBaseInterface;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface b extends RFWIocBaseInterface {
    void Ee(View view, BusinessFeedData businessFeedData, int i3, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData, int i16);

    void Fc();

    void If(View view);

    void Pd();

    QZoneDetailService T0();

    void V7(View view, BusinessFeedData businessFeedData, int i3);

    void Y3();

    void Ye(View view, Comment comment, CellTextView.OnTextOperater onTextOperater);

    int cg();

    int getAppid();

    void ih(View view, Comment comment, Reply reply, int i3, int i16, int i17);

    void k3(View view, Object obj);

    void m1();

    void m2(View view, BusinessFeedData businessFeedData, FeedElement feedElement, int i3, Object obj);

    void p6(View view, Comment comment, Reply reply, int i3, int i16);

    void pc(View view, Comment comment, Reply reply, int i3, int i16);

    void q4(View view, Object obj);

    void q5(View view, Comment comment, Reply reply, CellTextView.OnTextOperater onTextOperater);

    StickerBubbleAnimationView z8();

    void zg(View view);
}
