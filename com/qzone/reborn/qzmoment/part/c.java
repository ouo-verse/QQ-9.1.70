package com.qzone.reborn.qzmoment.part;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.comment.d;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StReply;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends an.a {

    /* renamed from: d, reason: collision with root package name */
    private View f58947d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneUserAvatarView f58948e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneAsyncTextView f58949f;

    /* renamed from: h, reason: collision with root package name */
    private QZMFeedCommentInfo f58950h;

    private void D9() {
        String str;
        QZMomentMeta$StFeed qZMomentMeta$StFeed;
        HashMap hashMap = new HashMap();
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f58950h;
        String str2 = "";
        if (qZMFeedCommentInfo == null) {
            str = "";
        } else {
            str = qZMFeedCommentInfo.mFeed.f430362id.get();
        }
        hashMap.put("operated_feed", str);
        QZMFeedCommentInfo qZMFeedCommentInfo2 = this.f58950h;
        if (qZMFeedCommentInfo2 != null && (qZMomentMeta$StFeed = qZMFeedCommentInfo2.mFeed) != null) {
            str2 = qZMomentMeta$StFeed.poster.f430367id.get();
        }
        hashMap.put("author_id", str2);
        fo.c.o(this.f58949f, "em_bas_commentspanel_inputbox", new fo.b().l(hashMap));
    }

    private void E9() {
        com.qzone.reborn.qzmoment.comment.d.l().p((QZMCommentBusinessViewModel) getViewModel(QZMCommentBusinessViewModel.class));
        com.qzone.reborn.qzmoment.comment.d.l().q(getActivity(), this.f58950h, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void H9() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY) instanceof QZMFeedCommentInfo) {
            this.f58950h = (QZMFeedCommentInfo) extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY);
        }
    }

    private void I9() {
        QZoneUserAvatarView qZoneUserAvatarView = this.f58948e;
        if (qZoneUserAvatarView == null) {
            return;
        }
        qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        F9(view);
    }

    private void F9(View view) {
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.mjx);
        this.f58947d = findViewById;
        this.f58948e = (QZoneUserAvatarView) findViewById.findViewById(R.id.mjw);
        QZoneAsyncTextView qZoneAsyncTextView = (QZoneAsyncTextView) this.f58947d.findViewById(R.id.mle);
        this.f58949f = qZoneAsyncTextView;
        qZoneAsyncTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.this.G9(view2);
            }
        });
        I9();
        H9();
        D9();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements d.InterfaceC0494d {
        a() {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void a(QZMomentMeta$StComment qZMomentMeta$StComment) {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void b(QZMomentMeta$StReply qZMomentMeta$StReply) {
        }
    }
}
