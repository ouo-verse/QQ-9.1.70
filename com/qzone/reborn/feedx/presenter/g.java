package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class g extends al {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        xg.d.a(businessFeedData, this.C, this.H);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        xg.d.a(businessFeedData, this.C, this.H);
        EventCollector.getInstance().onViewClicked(view);
    }

    private String X(final BusinessFeedData businessFeedData) {
        String R = R(businessFeedData);
        if (TextUtils.isEmpty(R)) {
            this.G.setVisibility(8);
            return "";
        }
        this.G.setVisibility(0);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.this.V(businessFeedData, view);
            }
        });
        return R;
    }

    abstract String R(BusinessFeedData businessFeedData);

    public String S(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || com.tencent.mobileqq.utils.bl.b(businessFeedData.getPictureInfo().pics) || businessFeedData.getPictureInfo().pics.get(0) == null || businessFeedData.getPictureInfo().pics.get(0).bigUrl == null || TextUtils.isEmpty(businessFeedData.getPictureInfo().pics.get(0).bigUrl.url)) {
            return "";
        }
        return businessFeedData.getPictureInfo().pics.get(0).bigUrl.url;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(BusinessFeedData businessFeedData, View view) {
        xg.d.a(businessFeedData, this.C, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(BusinessFeedData businessFeedData) {
        if (this.G != null && I(businessFeedData)) {
            K(X(businessFeedData));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(BusinessFeedData businessFeedData) {
        if (this.I != null && I(businessFeedData)) {
            this.I.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(final BusinessFeedData businessFeedData) {
        if (this.J == null || this.H == null) {
            return;
        }
        if (!I(businessFeedData)) {
            this.J.setVisibility(8);
            return;
        }
        O(0);
        O(ImmersiveUtils.dpToPx(6.0f));
        this.J.setVisibility(0);
        this.H.setVisibility(0);
        if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().title != null) {
            this.H.setText(businessFeedData.getOperationInfoV2().title);
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.this.W(businessFeedData, view);
                }
            });
        } else {
            this.H.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean T(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isNewHandBlogFeed();
    }
}
