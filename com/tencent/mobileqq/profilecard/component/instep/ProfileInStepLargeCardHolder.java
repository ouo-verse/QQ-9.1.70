package com.tencent.mobileqq.profilecard.component.instep;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardHolder;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.data.ProfileInStepAnimationData;
import com.tencent.mobileqq.profilecard.utils.ProfileInStepCardTextHelper;

/* loaded from: classes35.dex */
public class ProfileInStepLargeCardHolder extends ProfileInStepBaseCardHolder implements RFWCardViewBuilder.OnLargeBindListener {
    private static final float FULL_SCREEN_SUBTITLE_SCALE_OFFSET = 0.25f;
    private static final float TITLE_SHOW_RATIO = 0.25f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public static class ViewHolder implements IRFWCardHolder {
        public View actionButtonView;
        public View contentListView;
        public ImageView iconView;
        public View itemMainView;
        public View itemView;
        public LinearLayout subTitleView;
        public TextView titleView;

        ViewHolder() {
        }
    }

    public void onAnimation(ViewHolder viewHolder, ProfileInStepAnimationData profileInStepAnimationData) {
        viewHolder.itemMainView.setPadding(0, (int) profileInStepAnimationData.itemPaddingTop, 0, 0);
        ViewGroup.LayoutParams layoutParams = viewHolder.iconView.getLayoutParams();
        layoutParams.width = (int) profileInStepAnimationData.iconWidth;
        layoutParams.height = (int) profileInStepAnimationData.iconHeight;
        viewHolder.iconView.setLayoutParams(layoutParams);
        float f16 = profileInStepAnimationData.ratio;
        if (f16 > 0.25f) {
            float f17 = (f16 - 0.25f) / 0.75f;
            viewHolder.titleView.setAlpha(f17);
            viewHolder.subTitleView.setAlpha(f17);
            float f18 = profileInStepAnimationData.ratio;
            float f19 = f18 + ((1.0f - f18) * 0.25f);
            viewHolder.subTitleView.setPivotX(r1.getWidth() / 2);
            viewHolder.subTitleView.setPivotY(0.0f);
            viewHolder.subTitleView.setScaleX(f19);
            viewHolder.subTitleView.setScaleY(f19);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.contentListView.getLayoutParams();
            layoutParams2.width = (int) profileInStepAnimationData.itemWidth;
            layoutParams2.leftMargin = viewHolder.subTitleView.getResources().getDimensionPixelSize(R.dimen.f158712n1);
            viewHolder.contentListView.setLayoutParams(layoutParams2);
            return;
        }
        viewHolder.titleView.setAlpha(0.0f);
        viewHolder.subTitleView.setAlpha(0.0f);
    }

    @Override // com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder.OnLargeBindListener
    public void onBind(IRFWCardHolder iRFWCardHolder, RFWCardModel rFWCardModel, int i3) {
        ViewHolder viewHolder = (ViewHolder) iRFWCardHolder;
        ProfileInStepCardModel profileInStepCardModel = (ProfileInStepCardModel) rFWCardModel;
        viewHolder.titleView.setText(profileInStepCardModel.title);
        ProfileInStepCardTextHelper.generateSubTitle(viewHolder.subTitleView, profileInStepCardModel.subTitles);
        initIconView(viewHolder.iconView, profileInStepCardModel.iconUrl, true);
    }

    @Override // com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder.OnLargeBindListener
    public IRFWCardHolder onCreate(View view) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.itemView = view;
        viewHolder.itemMainView = view.findViewById(R.id.f65903_7);
        viewHolder.iconView = (ImageView) view.findViewById(R.id.f65893_6);
        viewHolder.titleView = (TextView) view.findViewById(R.id.f65933__);
        viewHolder.subTitleView = (LinearLayout) view.findViewById(R.id.f65923_9);
        viewHolder.contentListView = view.findViewById(R.id.f65883_5);
        viewHolder.actionButtonView = view.findViewById(R.id.f65843_1);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = view.getResources().getDimensionPixelSize(R.dimen.d_l);
        view.setLayoutParams(layoutParams);
        viewHolder.actionButtonView.setVisibility(8);
        return viewHolder;
    }

    @Override // com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder.OnLargeBindListener
    public void onLayoutDuringAnimation(IRFWCardHolder iRFWCardHolder, View view, float f16) {
        ProfileInStepAnimationData profileInStepAnimationData = new ProfileInStepAnimationData();
        profileInStepAnimationData.ratio = f16;
        Resources resources = view.getContext().getResources();
        profileInStepAnimationData.itemWidth = resources.getDimensionPixelSize(R.dimen.d_q) + ((resources.getDimensionPixelSize(R.dimen.d_m) - r1) * f16);
        profileInStepAnimationData.itemPaddingTop = resources.getDimensionPixelSize(R.dimen.d_h) + ((resources.getDimensionPixelSize(R.dimen.d_e) - r1) * f16);
        profileInStepAnimationData.iconWidth = resources.getDimensionPixelSize(R.dimen.d_i) + ((resources.getDimensionPixelSize(R.dimen.d_f) - r1) * f16);
        profileInStepAnimationData.iconHeight = resources.getDimensionPixelSize(R.dimen.d_g) + ((resources.getDimensionPixelSize(R.dimen.d_d) - r1) * f16);
        profileInStepAnimationData.subTitleMarginTop = resources.getDimensionPixelSize(R.dimen.d__);
        onAnimation((ViewHolder) iRFWCardHolder, profileInStepAnimationData);
    }
}
