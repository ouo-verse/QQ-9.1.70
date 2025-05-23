package com.tencent.mobileqq.profilecard.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.mutualmark.MutualMarkCard$Guide;
import tencent.im.mutualmark.mutualmark$State;
import tencent.im.mutualmark.mutualmark$Status;

/* loaded from: classes35.dex */
public class ProfileIntimateComponent extends AbsProfileContentComponent {
    private static final int COMPONENT_HEIGHT = 56;
    private static final int ICON_HEIGHT = 24;
    private static final int ICON_WIDTH = 28;
    private static final String PROFILE_INTERACT_TAG_STATUS = "profile_interact_tag_status";
    private static final String TAG = "ProfileIntimateComponent";
    private boolean isInitDtReport;
    private boolean isListMode;
    private boolean isVasCard;
    private ImageView mGuideIconView;
    private RelativeLayout mGuideLayout;
    private TextView mGuideTextView;
    private final com.tencent.mobileqq.friends.intimate.d mIntimateInfoObserver;
    private String mJumpUrl;
    private HorizontalListView mMutualListView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class IntimateIconListAdapter extends BaseAdapter {
        private final Context mContext;
        private final List<String> mDataList = new ArrayList();

        public IntimateIconListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mDataList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 < this.mDataList.size()) {
                return this.mDataList.get(i3);
            }
            return "";
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            String str;
            if (this.mContext == null) {
                return null;
            }
            ImageView imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(BaseAIOUtils.f(28.0f, ((AbsComponent) ProfileIntimateComponent.this).mActivity.getResources()), BaseAIOUtils.f(24.0f, ((AbsComponent) ProfileIntimateComponent.this).mActivity.getResources())));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (i3 < this.mDataList.size()) {
                str = this.mDataList.get(i3);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                ProfileIntimateComponent.this.initImageViewWithUrl(imageView, str);
            }
            imageView.setImportantForAccessibility(2);
            imageView.setOnClickListener(ProfileIntimateComponent.this.obtainClickListener());
            return imageView;
        }

        public void setData(List<String> list) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public ProfileIntimateComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mJumpUrl = "";
        this.isListMode = false;
        this.isInitDtReport = false;
        this.mIntimateInfoObserver = new com.tencent.mobileqq.friends.intimate.d() { // from class: com.tencent.mobileqq.profilecard.component.ProfileIntimateComponent.2
            @Override // com.tencent.mobileqq.friends.intimate.d
            protected void onMutualMarkCardUpdate(long j3, boolean z16) {
                if (((AbsProfileComponent) ProfileIntimateComponent.this).mDelegate == null) {
                    return;
                }
                ((AbsProfileComponent) ProfileIntimateComponent.this).mDelegate.requestUpdateCard();
                QLog.i(ProfileIntimateComponent.TAG, 1, "onMutualMarkCardUpdate_invoke_requestUpdateCard");
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, VIEW] */
    private void initComponentViewContainer() {
        QBaseActivity qBaseActivity;
        if (this.mViewContainer != 0 || (qBaseActivity = this.mActivity) == null) {
            return;
        }
        this.mViewContainer = View.inflate(qBaseActivity, R.layout.cz7, null);
        ((View) this.mViewContainer).setLayoutParams(new ViewGroup.LayoutParams(-1, BaseAIOUtils.f(56.0f, this.mActivity.getResources())));
        this.mGuideLayout = (RelativeLayout) ((View) this.mViewContainer).findViewById(R.id.ow9);
        this.mGuideTextView = (TextView) ((View) this.mViewContainer).findViewById(R.id.owa);
        this.mGuideIconView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.ow_);
        HorizontalListView horizontalListView = (HorizontalListView) ((View) this.mViewContainer).findViewById(R.id.owb);
        this.mMutualListView = horizontalListView;
        horizontalListView.setImportantForAccessibility(2);
        ((View) this.mViewContainer).setOnClickListener(obtainClickListener());
        if (this.isVasCard) {
            VIEW view = this.mViewContainer;
            updateItemTheme((View) view, (TextView) ((View) view).findViewById(R.id.owd), null, (ImageView) ((View) this.mViewContainer).findViewById(R.id.ow8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initImageViewWithUrl(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            imageView.setVisibility(8);
            return;
        }
        String upgradeIconUrlToVersion2 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mUseApngImage = true;
        URLDrawable drawable = URLDrawable.getDrawable(upgradeIconUrlToVersion2, obtain);
        if (drawable.getStatus() == 2) {
            drawable.restartDownload();
        }
        imageView.setImageDrawable(drawable);
    }

    private void initIntimateGuideView(Card card) {
        String str;
        mutualmark$Status mutualmark_status;
        MutualMarkCard$Guide mutualMarkCard$Guide = card.mutualGuide;
        if (mutualMarkCard$Guide != null) {
            str = mutualMarkCard$Guide.url.get();
        } else {
            str = "";
        }
        this.mJumpUrl = str;
        RelativeLayout relativeLayout = this.mGuideLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        HorizontalListView horizontalListView = this.mMutualListView;
        if (horizontalListView != null) {
            horizontalListView.setVisibility(8);
        }
        MutualMarkCard$Guide mutualMarkCard$Guide2 = card.mutualGuide;
        if (mutualMarkCard$Guide2 == null) {
            return;
        }
        if (this.mGuideTextView != null && mutualMarkCard$Guide2.desc.get() != null) {
            this.mGuideTextView.setText(card.mutualGuide.desc.get());
        }
        if (this.mGuideIconView == null) {
            return;
        }
        mutualmark$State mutualmark_state = card.mutualGuide.state;
        if (mutualmark_state != null && (mutualmark_status = mutualmark_state.status) != null && mutualmark_status.icon_url.get() != null) {
            this.mGuideIconView.setVisibility(0);
            initImageViewWithUrl(this.mGuideIconView, card.mutualGuide.state.status.icon_url.get());
        } else {
            this.mGuideIconView.setVisibility(8);
        }
    }

    private void initIntimateListView(Card card) {
        this.mJumpUrl = card.mutualHomeUrl;
        RelativeLayout relativeLayout = this.mGuideLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        HorizontalListView horizontalListView = this.mMutualListView;
        if (horizontalListView == null) {
            return;
        }
        horizontalListView.setVisibility(0);
        IntimateIconListAdapter intimateIconListAdapter = new IntimateIconListAdapter(this.mActivity);
        ArrayList arrayList = new ArrayList();
        Iterator<mutualmark$State> it = card.mutualStateList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().status.icon_url.get());
        }
        intimateIconListAdapter.setData(arrayList);
        this.mMutualListView.setAdapter((ListAdapter) intimateIconListAdapter);
        this.mMutualListView.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.ProfileIntimateComponent.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams;
                int lastVisiblePosition = ProfileIntimateComponent.this.mMutualListView.getLastVisiblePosition();
                if (lastVisiblePosition <= 0) {
                    return;
                }
                if ((lastVisiblePosition + 1) * BaseAIOUtils.f(28.0f, ProfileIntimateComponent.this.mMutualListView.getResources()) > ProfileIntimateComponent.this.mMutualListView.getMeasuredWidth() && (layoutParams = ProfileIntimateComponent.this.mMutualListView.getLayoutParams()) != null) {
                    layoutParams.width = lastVisiblePosition * BaseAIOUtils.f(28.0f, ProfileIntimateComponent.this.mMutualListView.getResources());
                    ProfileIntimateComponent.this.mMutualListView.setLayoutParams(layoutParams);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$obtainClickListener$0(View view) {
        QBaseActivity qBaseActivity;
        if (u.a().b() || (qBaseActivity = this.mActivity) == null || qBaseActivity.isFinishing()) {
            return;
        }
        ProfileCardDtReportUtil.dtReportClick(view);
        Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.mJumpUrl);
        this.mActivity.startActivity(intent);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 1, "onClick,jumpUrl=" + this.mJumpUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View.OnClickListener obtainClickListener() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileIntimateComponent.this.lambda$obtainClickListener$0(view);
            }
        };
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1042;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_INTIMATE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean makeOrRefreshUI(Card card, boolean z16) {
        boolean z17 = false;
        if (card == null) {
            QLog.e(TAG, 1, "makeOrRefreshUI fail, card is null");
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "card=" + card.toString() + ", isNetRet=" + z16);
        }
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            QLog.e(TAG, 1, "makeOrRefreshUI fail, mApp is null");
            return true;
        }
        boolean E = ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).E(false);
        if (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne) && !E) {
            if (card.mutualStateList.size() == 0 && card.mutualGuide == null) {
                return false;
            }
            initComponentViewContainer();
            List<mutualmark$State> list = card.mutualStateList;
            if (list != null && list.size() > 0) {
                z17 = true;
            }
            this.isListMode = z17;
            if (z17) {
                initIntimateListView(card);
            } else {
                initIntimateGuideView(card);
            }
            return true;
        }
        this.mViewContainer = null;
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        appInterface.addObserver(this.mIntimateInfoObserver);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        appInterface.removeObserver(this.mIntimateInfoObserver);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileIntimateComponent) profileCardInfo);
        checkVasProfileCard(profileCardInfo);
        DATA data = this.mData;
        boolean makeOrRefreshUI = makeOrRefreshUI(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet) | lambda$checkValidComponent$3;
        dataReport(makeOrRefreshUI);
        return makeOrRefreshUI;
    }

    private void dataReport(boolean z16) {
        if (!z16 || this.isInitDtReport || this.mViewContainer == 0) {
            return;
        }
        this.isInitDtReport = true;
        HashMap hashMap = new HashMap();
        hashMap.put(PROFILE_INTERACT_TAG_STATUS, Integer.valueOf(this.isListMode ? 1 : 0));
        VideoReport.setElementId(this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_INTERACT_TAG);
        VideoReport.setElementParams(this.mViewContainer, hashMap);
        VideoReport.setElementClickPolicy(this.mViewContainer, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.mViewContainer, ExposurePolicy.REPORT_ALL);
    }

    private void checkVasProfileCard(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo == null) {
            return;
        }
        this.isVasCard = profileCardInfo.currentTemplate != null || ((card = profileCardInfo.card) != null && ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId));
    }
}
