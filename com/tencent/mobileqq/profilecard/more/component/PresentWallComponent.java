package com.tencent.mobileqq.profilecard.more.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreController;
import com.tencent.mobileqq.profilecard.more.widget.ComponentTitleView;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes35.dex */
public class PresentWallComponent extends AbsMoreComponent {
    private static final int NUM_OF_PRESENT_IMAGE = 4;
    private static final String TAG = "PresentWallComponent";
    private boolean mClicked;
    private RecyclerView mPresentsRecyclerView;
    private RecyclerViewAdapter mPresentsRecyclerViewAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class PresentViewHolder extends RecyclerView.ViewHolder {
        ImageView presentImageView;

        public PresentViewHolder(View view) {
            super(view);
            this.presentImageView = (ImageView) view.findViewById(R.id.own);
            if (PresentWallComponent.this.mMoreController.isNightMode()) {
                this.presentImageView.setColorFilter(1291845632);
            } else {
                this.presentImageView.setColorFilter(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class RecyclerViewAdapter extends RecyclerView.Adapter<PresentViewHolder> {
        private final List<Drawable> presents;

        public RecyclerViewAdapter(List<Drawable> list) {
            ArrayList arrayList = new ArrayList();
            this.presents = arrayList;
            if (list != null) {
                arrayList.addAll(list);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.presents.size();
        }

        public void updatePresentDrawableListAndUi(List<Drawable> list) {
            this.presents.clear();
            if (list != null) {
                this.presents.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(PresentViewHolder presentViewHolder, int i3) {
            presentViewHolder.presentImageView.setImageDrawable(this.presents.get(i3));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PresentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            PresentWallComponent presentWallComponent = PresentWallComponent.this;
            return new PresentViewHolder(LayoutInflater.from(presentWallComponent.getContext()).inflate(R.layout.cze, viewGroup, false));
        }
    }

    public PresentWallComponent(ProfileCardMoreController profileCardMoreController) {
        super(profileCardMoreController);
    }

    private View bindRootView() {
        Activity activity;
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null && (activity = profileCardMoreController.mActivity) != null) {
            if (this.mViewContainer == null) {
                QLog.e(TAG, 1, "mViewContainer is null");
                return null;
            }
            View inflate = LayoutInflater.from(activity).inflate(R.layout.czd, (ViewGroup) null);
            this.mViewContainer.addComponentContent(inflate);
            return inflate;
        }
        QLog.e(TAG, 1, "mMoreController or mActivity is null");
        return null;
    }

    private Card getCard() {
        return this.mMoreController.mCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return this.mMoreController.mActivity;
    }

    private LinearLayoutManager getLinearLayoutManager() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null && profileCardMoreController.mActivity != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) { // from class: com.tencent.mobileqq.profilecard.more.component.PresentWallComponent.2
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollHorizontally() {
                    return true;
                }
            };
            linearLayoutManager.setOrientation(0);
            return linearLayoutManager;
        }
        QLog.e(TAG, 1, "mMoreController or mActivity is null");
        return null;
    }

    private List<Drawable> getPresentDrawables() {
        ArrayList arrayList = new ArrayList();
        Card card = getCard();
        if (card.presentUrl == null) {
            return arrayList;
        }
        URLDrawable.URLDrawableOptions urlDrawableOptions = getUrlDrawableOptions();
        List<String> list = card.presentUrl;
        for (int i3 = 0; i3 < 4 && i3 < list.size(); i3++) {
            arrayList.add(URLDrawable.getDrawable(list.get(i3), urlDrawableOptions));
        }
        return arrayList;
    }

    private String getRightTxt() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        int i3 = profileCardMoreController.mCard.presentNum;
        if (i3 <= 0) {
            return "";
        }
        return profileCardMoreController.mActivity.getString(R.string.x4d, Integer.valueOf(i3));
    }

    private URLDrawable.URLDrawableOptions getUrlDrawableOptions() {
        int n3 = Utils.n(70.0f, getContext().getResources());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(14606046);
        obtain.mFailedDrawable = new ColorDrawable(14606046);
        obtain.mRequestHeight = n3;
        obtain.mRequestWidth = n3;
        return obtain;
    }

    private void handleOnClick() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null && profileCardMoreController.mActivity != null) {
            if (this.mClicked) {
                return;
            }
            QLog.i(TAG, 2, "handleOnClick");
            this.mClicked = true;
            Intent intent = new Intent(this.mMoreController.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", getCard().presentCustourl);
            this.mMoreController.mActivity.startActivity(intent);
            VideoReport.reportEvent("dt_clck", this.mViewContainer, null);
            return;
        }
        QLog.e(TAG, 1, "mMoreController or mActivity is null");
    }

    private void hideAll() {
        ComponentTitleView componentTitleView = this.mViewContainer;
        if (componentTitleView != null) {
            componentTitleView.setVisibility(8);
        }
        RecyclerView recyclerView = this.mPresentsRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    private boolean hideAllIfNeed() {
        List<String> list;
        Card card = getCard();
        if (card.presentSwitch && !ProfilePAUtils.isNotShowPresent(this.mMoreController.mAllInOne)) {
            if (card.showPresent && (list = card.presentUrl) != null && !list.isEmpty()) {
                if (!isConfigDisable()) {
                    return false;
                }
                hideAll();
                QLog.i(TAG, 2, "hideAll, config disable");
                return true;
            }
            hideAll();
            QLog.i(TAG, 2, "hideAll, no present");
            return true;
        }
        hideAll();
        QLog.i(TAG, 2, "hideAll, presentSwitch off");
        return true;
    }

    private void initTitleBar() {
        ComponentTitleView componentTitleView = this.mViewContainer;
        if (componentTitleView == null) {
            return;
        }
        componentTitleView.setTitle(R.string.x4h);
        this.mViewContainer.setRightTxt(getRightTxt());
        this.mViewContainer.setOnClickListener(this);
        this.mMoreController.initDtElementReport(this.mViewContainer, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_GIFT, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
    }

    private boolean isConfigDisable() {
        IProfileConfig createProfileConfig = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).createProfileConfig(this.mMoreController.mApp);
        return (createProfileConfig == null || createProfileConfig.isSwitchEnable(6)) ? false : true;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getComponentKey() {
        return ProfileCardMoreConstants.MORE_COMPONENT_KEY_PRESENT_WALL;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getPartIndex() {
        return 2;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public boolean isNeedShow() {
        List<String> list;
        Card card = getCard();
        if (card.presentSwitch && !ProfilePAUtils.isNotShowPresent(this.mMoreController.mAllInOne)) {
            if (card.showPresent && (list = card.presentUrl) != null && !list.isEmpty()) {
                if (!isConfigDisable()) {
                    return true;
                }
                QLog.i(TAG, 2, "config disable");
                return false;
            }
            QLog.i(TAG, 2, "no present");
            return false;
        }
        QLog.i(TAG, 2, "presentSwitch off");
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        handleOnClick();
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onCreate(LayoutInflater layoutInflater) {
        super.onCreate(layoutInflater);
        if (hideAllIfNeed()) {
            return;
        }
        initTitleBar();
        initAndShowContent(bindRootView());
        QLog.i(TAG, 2, "onCreate success, num of presents = " + getCard().presentNum);
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onResume() {
        super.onResume();
        this.mClicked = false;
        this.mMoreController.updateCard();
        RecyclerViewAdapter recyclerViewAdapter = this.mPresentsRecyclerViewAdapter;
        if (recyclerViewAdapter != null) {
            recyclerViewAdapter.updatePresentDrawableListAndUi(getPresentDrawables());
        }
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onDestroy() {
        this.mPresentsRecyclerView = null;
        super.onDestroy();
    }

    private void initAndShowContent(View view) {
        if (view == null) {
            return;
        }
        this.mPresentsRecyclerViewAdapter = new RecyclerViewAdapter(getPresentDrawables());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.owm);
        this.mPresentsRecyclerView = recyclerView;
        recyclerView.setVisibility(0);
        this.mPresentsRecyclerView.setAdapter(this.mPresentsRecyclerViewAdapter);
        this.mPresentsRecyclerView.setLayoutManager(getLinearLayoutManager());
        this.mPresentsRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.profilecard.more.component.PresentWallComponent.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                PresentWallComponent.this.mViewContainer.performClick();
                return false;
            }
        });
    }
}
