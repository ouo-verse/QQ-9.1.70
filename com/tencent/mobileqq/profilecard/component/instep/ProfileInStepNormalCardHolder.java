package com.tencent.mobileqq.profilecard.component.instep;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardHolder;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;

/* loaded from: classes35.dex */
public class ProfileInStepNormalCardHolder extends ProfileInStepBaseCardHolder implements RFWCardViewBuilder.OnNormalBindListener {
    private static final float CARD_TOUCH_SCALE = 0.95f;
    private boolean isEnableBlur;

    /* loaded from: classes35.dex */
    private static class ViewHolder implements IRFWCardHolder {
        public View bgView;
        public ImageView iconView;
        public View itemView;

        ViewHolder() {
        }
    }

    public ProfileInStepNormalCardHolder(boolean z16) {
        this.isEnableBlur = z16;
    }

    private void initItemView(View view, int i3) {
        initTouchAnimation(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Resources resources = view.getContext().getResources();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.d_p), resources.getDimensionPixelSize(R.dimen.d_n));
        } else {
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.d_p);
            if (i3 == 0) {
                layoutParams.width = resources.getDimensionPixelSize(R.dimen.d_r);
            }
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.d_n);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(i3 == 0 ? resources.getDimensionPixelSize(R.dimen.d_j) : 0, 0, resources.getDimensionPixelSize(R.dimen.d_o), 0);
    }

    @Override // com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder.OnNormalBindListener
    public void onBind(IRFWCardHolder iRFWCardHolder, RFWCardModel rFWCardModel, int i3) {
        ViewHolder viewHolder = (ViewHolder) iRFWCardHolder;
        ProfileInStepCardModel profileInStepCardModel = (ProfileInStepCardModel) rFWCardModel;
        initItemView(viewHolder.itemView, i3);
        if (profileInStepCardModel == null) {
            return;
        }
        initIconView(viewHolder.iconView, profileInStepCardModel.iconUrl, false);
        setItemMainContentDescription(viewHolder.itemView, profileInStepCardModel);
    }

    @Override // com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder.OnNormalBindListener
    public IRFWCardHolder onCreate(View view) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.itemView = view;
        viewHolder.bgView = view.findViewById(R.id.f65873_4);
        viewHolder.iconView = (ImageView) view.findViewById(R.id.f65893_6);
        if (this.isEnableBlur) {
            viewHolder.bgView.setAlpha(0.5f);
        }
        return viewHolder;
    }

    private void initTouchAnimation(final View view) {
        view.findViewById(R.id.f65903_7).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.profilecard.component.instep.ProfileInStepNormalCardHolder.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view2.setScaleX(0.95f);
                    view2.setScaleY(0.95f);
                    view2.setPressed(true);
                } else if (action == 1) {
                    view2.setScaleX(1.0f);
                    view2.setScaleY(1.0f);
                    view2.setPressed(false);
                    view.performClick();
                } else if (action == 2 || action == 3) {
                    view2.setScaleX(1.0f);
                    view2.setScaleY(1.0f);
                    view2.setPressed(false);
                }
                return false;
            }
        });
    }

    private void setItemMainContentDescription(View view, ProfileInStepCardModel profileInStepCardModel) {
        if (profileInStepCardModel == null || view == null) {
            return;
        }
        AccessibilityUtil.s(view.findViewById(R.id.f65903_7), profileInStepCardModel.title);
    }
}
