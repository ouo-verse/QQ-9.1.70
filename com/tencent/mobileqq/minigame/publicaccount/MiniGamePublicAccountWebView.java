package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountWebView extends BaseNestScrollWebView {
    public static final int HEAD_HEIGHT_DB = 419;
    public static final int TITLE_HEIGHT_DB = 44;
    private CustomWebView.d mCustomScrollInterface;
    private int mHeadHeight;

    public MiniGamePublicAccountWebView(Context context) {
        super(context);
        this.mHeadHeight = 419;
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView
    public void onPageFinish(String str) {
        setPaddingTop(BaseAIOUtils.f(this.mHeadHeight + 44 + BaseAIOUtils.l(ImmersiveUtils.getStatusBarHeight(getContext()), getContext().getResources()), getResources()));
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView, com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        super.onScrollChanged(i3, i16, i17, i18, view);
        CustomWebView.d dVar = this.mCustomScrollInterface;
        if (dVar != null) {
            dVar.onSChanged(i3, i16, i17, i18);
        }
    }

    public void setHeadHeight(int i3) {
        this.mHeadHeight = i3;
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView
    public void setPaddingTop(int i3) {
        super.setPaddingTop(i3);
    }

    public void setScrollInterface(CustomWebView.d dVar) {
        this.mCustomScrollInterface = dVar;
    }

    public MiniGamePublicAccountWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeadHeight = 419;
    }
}
