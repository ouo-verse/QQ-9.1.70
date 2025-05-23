package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WebUiStrategy1HeaderAdapter extends BaseHeaderAdapter {
    private static final String TAG = "WebUiStrategy1HeaderAdapter";

    public WebUiStrategy1HeaderAdapter(Activity activity) {
        super(activity);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        List<QQGameMsgInfo> list = this.mMsgInfoList;
        if (list != null && list.size() != 0) {
            TextView textView = null;
            QQGameMsgInfo qQGameMsgInfo = i3 < this.mMsgInfoList.size() ? this.mMsgInfoList.get(i3) : null;
            Object obj = (IHeaderView) this.mHeaderRecords.get(i3);
            if (obj == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "headerView = null");
                }
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "headerView = " + obj.getClass().getSimpleName());
            }
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            View view = (View) obj;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (qQGameMsgInfo != null) {
                textView = new TextView(this.mActivity);
                textView.setTextColor(-1);
                textView.setTextSize(1, 10.0f);
                textView.setText(en.d(this.mActivity, 3, qQGameMsgInfo.msgTime * 1000));
                textView.setPadding(12, 0, 12, 0);
                textView.setId(R.id.jld);
                layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, BaseAIOUtils.f(15.0f, this.mActivity.getResources()));
                }
                textView.setGravity(17);
                layoutParams.addRule(14);
                layoutParams.addRule(10);
                textView.bringToFront();
            } else {
                layoutParams = null;
            }
            if (textView != null) {
                relativeLayout.addView(textView, layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, R.id.jld);
            relativeLayout.addView(view, layoutParams2);
            viewGroup.addView(relativeLayout, layoutParams2);
            if (i3 == 0) {
                initArk(0);
            }
            return relativeLayout;
        }
        View createEmptyView = createEmptyView();
        viewGroup.addView(createEmptyView);
        return createEmptyView;
    }
}
