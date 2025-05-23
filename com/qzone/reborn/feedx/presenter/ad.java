package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ad extends al {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements QZoneRichTextView.a {
        a() {
        }

        @Override // com.qzone.reborn.feedx.widget.QZoneRichTextView.a
        public void onClick() {
            ad adVar = ad.this;
            adVar.T(adVar.M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        T(this.M);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        T(this.M);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        T(this.M);
        EventCollector.getInstance().onViewClicked(view);
    }

    private String X(CellLeftThumb cellLeftThumb) {
        if (cellLeftThumb != null && cellLeftThumb.getPictureInfo() != null) {
            FeedPictureInfo pictureInfo = cellLeftThumb.getPictureInfo();
            if (pictureInfo != null && pictureInfo.h() != null && pictureInfo.h().url != null) {
                this.G.setVisibility(0);
                this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ac
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ad.this.U(view);
                    }
                });
                return pictureInfo.h().url;
            }
            QLog.d("QZoneFeedH5SharePicPresenter", 1, "picture info is null");
            return "";
        }
        this.G.setVisibility(8);
        return "";
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void J(BusinessFeedData businessFeedData, View view) {
        T(this.M);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void L(BusinessFeedData businessFeedData) {
        if (this.G == null || !I(businessFeedData)) {
            return;
        }
        String X = X(businessFeedData.getLeftThumb());
        if (TextUtils.isEmpty(X)) {
            this.G.setVisibility(8);
        } else {
            K(X);
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void M(BusinessFeedData businessFeedData) {
        if (this.I == null || !I(businessFeedData)) {
            return;
        }
        String parseSummary = businessFeedData.getLeftThumb().getParseSummary();
        if (parseSummary != null && !TextUtils.isEmpty(parseSummary.trim())) {
            this.I.setRichText(parseSummary);
            this.I.setVisibility(0);
            this.I.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ad.this.V(view);
                }
            });
            this.I.setOnUrlClickListener(new a());
            return;
        }
        this.I.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void N(BusinessFeedData businessFeedData) {
        if (this.H == null || !I(businessFeedData)) {
            return;
        }
        this.H.setMaxLine(2);
        TextView textView = this.J;
        if (textView != null) {
            textView.setVisibility(8);
        }
        O(0);
        String parseTitle = businessFeedData.getLeftThumb().getParseTitle();
        if (TextUtils.isEmpty(parseTitle)) {
            this.H.setVisibility(8);
            View view = this.L;
            if (view != null) {
                view.setVisibility(8);
            }
            H(ImmersiveUtils.dpToPx(16.0f), 0, 0, 0);
            return;
        }
        H(ImmersiveUtils.dpToPx(16.0f), ImmersiveUtils.dpToPx(4.0f), 0, 0);
        this.H.setRichText(parseTitle);
        this.H.setVisibility(0);
        View view2 = this.L;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ad.this.W(view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.presenter.al
    public boolean I(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || !businessFeedData.isLeftImageH5ShareFeed() || businessFeedData.isNewHandBlogFeed() || businessFeedData.isReprintedTextBlogFeed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(CellLeftThumb cellLeftThumb) {
        if (cellLeftThumb == null) {
            return;
        }
        String actionUrl = cellLeftThumb.getActionUrl();
        String postDatas = cellLeftThumb.getPostDatas();
        HashMap hashMap = new HashMap();
        hashMap.put("expandFrom", "3");
        yo.d.e(actionUrl, this.C, postDatas, hashMap);
    }
}
