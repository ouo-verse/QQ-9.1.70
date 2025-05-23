package com.tencent.mobileqq.profilecard.component;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardExtension;
import com.tencent.biz.richframework.widget.listview.card.RFWCardListView;
import com.tencent.biz.richframework.widget.listview.card.RFWCardViewBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SimilarityData;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.instep.IBusinessZPlanHandleEventListener;
import com.tencent.mobileqq.profilecard.component.instep.ProfileInStepCardModel;
import com.tencent.mobileqq.profilecard.component.instep.ProfileInStepLargeCardHolder;
import com.tencent.mobileqq.profilecard.component.instep.ProfileInStepNormalCardHolder;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileInStepBubbleTips;
import com.tencent.mobileqq.profilecard.utils.ProfileInStepDecoration;
import com.tencent.mobileqq.profilecard.utils.ProfileInStepReportHelper;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class ProfileInStepComponent extends AbsProfileContentComponent {
    private static final String TAG = "ProfileInStepComponent";
    private ProfileInStepBubbleTips bubbleTips;
    private RFWCardListView inStepListView;
    private boolean isVasCard;

    public ProfileInStepComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void adaptProfileCard() {
        Resources resources;
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getVersionCode() != 1 && (resources = this.mActivity.getResources()) != null) {
            ((View) this.mViewContainer).setPadding(0, resources.getDimensionPixelSize(R.dimen.f10682q), 0, resources.getDimensionPixelSize(R.dimen.f10682q));
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity instanceof FriendProfileCardActivity) {
            ((FriendProfileCardActivity) qBaseActivity).disableTopGestureLR();
        }
        this.mDelegate.getListView().addBusinessHandleEvent(new IBusinessZPlanHandleEventListener() { // from class: com.tencent.mobileqq.profilecard.component.a
            @Override // com.tencent.mobileqq.profilecard.bussiness.instep.IBusinessZPlanHandleEventListener
            public final boolean handleZPlanEvent(MotionEvent motionEvent) {
                boolean lambda$adaptProfileCard$0;
                lambda$adaptProfileCard$0 = ProfileInStepComponent.this.lambda$adaptProfileCard$0(motionEvent);
                return lambda$adaptProfileCard$0;
            }
        });
        if (this.isVasCard) {
            updateItemTheme(null, (TextView) ((View) this.mViewContainer).findViewById(R.id.f163205ov4), null, null, null, null, null, (View) this.mViewContainer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildInStepListView() {
        RFWCardListView rFWCardListView = (RFWCardListView) ((View) this.mViewContainer).findViewById(R.id.f163203ov2);
        this.inStepListView = rFWCardListView;
        Resources resources = rFWCardListView.getResources();
        this.inStepListView.setCardExtension(new RFWCardExtension().setCardViewBuilder(new RFWCardViewBuilder().setNormalCardView(R.layout.f168947hg0, new ProfileInStepNormalCardHolder(this.isVasCard)).setLargeCardView(R.layout.hfz, new ProfileInStepLargeCardHolder()).setLargeCardDecoration(new ProfileInStepDecoration()).setNormalCardAttribute(resources.getDimensionPixelSize(R.dimen.d_p) - resources.getDimensionPixelSize(R.dimen.d_o), resources.getDimensionPixelSize(R.dimen.d_n)).setLargeCardAttribute(resources.getDimensionPixelSize(R.dimen.d_m), resources.getDimensionPixelSize(R.dimen.d_l), resources.getDimensionPixelSize(R.dimen.f158713n2), resources.getDimensionPixelSize(R.dimen.d_j))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean checkShouldShowInStep() {
        DATA data = this.mData;
        return (((ProfileCardInfo) data).allInOne.f260789pa == 0 || ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) data).allInOne) || !((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isInStepComponentEnable()) ? false : true;
    }

    private void checkVasProfileCard(ProfileCardInfo profileCardInfo) {
        Card card;
        this.isVasCard = profileCardInfo.currentTemplate != null || ((card = profileCardInfo.card) != null && ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId));
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.View, VIEW] */
    private void initializeInStepComponent(Card card) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null || qBaseActivity.isFinishing()) {
            return;
        }
        if (this.mViewContainer == 0) {
            this.mViewContainer = View.inflate(this.mActivity, R.layout.cz6, null);
        }
        if (this.bubbleTips == null) {
            this.bubbleTips = new ProfileInStepBubbleTips();
        }
        buildInStepListView();
        adaptProfileCard();
        bindCardData(card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$adaptProfileCard$0(MotionEvent motionEvent) {
        if (this.mViewContainer == 0) {
            return true;
        }
        return this.inStepListView.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1041;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_IN_STEP;
    }

    public boolean makeOrRefreshUI(Card card, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "card=" + card.toString() + ", isNetRet=" + z16);
        }
        if (!checkShouldShowInStep()) {
            return true;
        }
        initializeInStepComponent(card);
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public boolean onBackPressed() {
        RFWCardListView rFWCardListView = this.inStepListView;
        if (rFWCardListView != null) {
            return rFWCardListView.onBackPressed();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileInStepComponent) profileCardInfo);
        checkVasProfileCard(profileCardInfo);
        DATA data = this.mData;
        return makeOrRefreshUI(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet) | lambda$checkValidComponent$3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindCardData(Card card) {
        if (card != null && this.inStepListView != null) {
            ArrayList arrayList = new ArrayList();
            for (SimilarityData similarityData : card.similarityData) {
                arrayList.add(new ProfileInStepCardModel(similarityData.icon, similarityData.title, similarityData.wordings));
            }
            if (arrayList.size() > 0) {
                ProfileInStepReportHelper.registerInStepElement((View) this.mViewContainer, arrayList.size());
                ProfileInStepReportHelper.initQUICardReport(this.inStepListView.getCardExtension(), arrayList);
                this.inStepListView.setData(arrayList);
            } else {
                this.mViewContainer = null;
            }
            if (this.mViewContainer == 0 || this.bubbleTips == null || !((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isInStepBubbleTipsEnable()) {
                return;
            }
            this.bubbleTips.checkShowBubbleTips(this.mActivity, this.inStepListView.getCardExtension(), card, getComponentCenter());
            return;
        }
        QLog.e(TAG, 1, "bindCardData fail, card or listview is null");
        this.mViewContainer = null;
    }
}
