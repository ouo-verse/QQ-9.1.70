package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqgamepub.web.view.BaseNestHeaderLayout;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountHeadLayout extends BaseNestHeaderLayout {
    public MiniGamePublicAccountHeadLayout(Context context) {
        super(context);
        initView();
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseLayout
    protected int getLayoutId() {
        return R.layout.dk_;
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.b
    public boolean isPined() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.b
    public boolean isShow(String str) {
        return true;
    }

    public MiniGamePublicAccountHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
    }
}
