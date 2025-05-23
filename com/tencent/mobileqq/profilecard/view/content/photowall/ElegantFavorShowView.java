package com.tencent.mobileqq.profilecard.view.content.photowall;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ElegantFavorShowView extends ProfileCardFavorShowView {
    public ElegantFavorShowView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getGuideTipsContainerId() {
        return R.id.ous;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getImageArrowId() {
        return R.id.ouy;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getLayout() {
        return R.layout.cz9;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getProfileMoreContainerId() {
        return R.id.ow6;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getRootLayoutId() {
        return R.id.oww;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getTitleId() {
        return R.id.otn;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView
    protected int getTitleTextId() {
        return R.id.oxb;
    }

    public ElegantFavorShowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ElegantFavorShowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
