package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.QzoneFragmentImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001b\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedx/part/bo;", "Lcom/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart;", "", "ba", "ea", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "M9", "S9", "", "T9", "K9", "Lcooperation/qzone/api/QzoneFragmentImpl;", UserInfo.SEX_FEMALE, "Lcooperation/qzone/api/QzoneFragmentImpl;", "getQzoneFragmentImpl", "()Lcooperation/qzone/api/QzoneFragmentImpl;", "setQzoneFragmentImpl", "(Lcooperation/qzone/api/QzoneFragmentImpl;)V", "qzoneFragmentImpl", "G", "Z", "mIsOpenZPlanEntrance", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bo extends QZoneFriendFeedTitlePart {

    /* renamed from: F, reason: from kotlin metadata */
    private QzoneFragmentImpl qzoneFragmentImpl;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsOpenZPlanEntrance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(QzoneFragmentImpl qzoneFragmentImpl) {
        super(false);
        Intrinsics.checkNotNullParameter(qzoneFragmentImpl, "qzoneFragmentImpl");
        this.qzoneFragmentImpl = qzoneFragmentImpl;
        this.mIsOpenZPlanEntrance = true;
    }

    private final void ba() {
        fo.c.n(L9().f(new uh.d(R.drawable.qui_setting, null, new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.bn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bo.ca(bo.this, view);
            }
        }, null, "\u6837\u5f0f\u9009\u62e9", false, 42, null)), "em_setting_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(bo this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.qzone.util.h.a()) {
            this$0.ea();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(bo this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qzoneFragmentImpl.forceRefresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ea() {
        ILebaUIStyleSettingApi iLebaUIStyleSettingApi = (ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        iLebaUIStyleSettingApi.openStyleSetting((QBaseActivity) activity);
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart
    public boolean K9() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart
    public int M9() {
        return R.id.mzk;
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart
    public void S9() {
        super.S9();
        if (com.qzone.util.ah.b()) {
            ba();
        }
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(LoginData.getInstance().getUin())) {
            return;
        }
        ViewParent L9 = L9();
        uh.a aVar = L9 instanceof uh.a ? (uh.a) L9 : null;
        if (aVar != null) {
            aVar.setAdaptToConcise(null);
        }
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart
    public boolean T9() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxZPlanTitlePart";
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart, com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        L9().u();
        L9().setProgressBarEnable(false);
        this.mIsOpenZPlanEntrance = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(MobileQQ.sMobileQQ.waitAppRuntime().getLongAccountUin());
        if (com.qzone.reborn.util.k.f59549a.g()) {
            this.mIsOpenZPlanEntrance = false;
        }
        QLog.i(getTAG(), 1, "onInitView  mIsOpenZPlanEntrance:" + this.mIsOpenZPlanEntrance);
        if (this.mIsOpenZPlanEntrance) {
            L9().setTitleAlpha(0);
            L9().getMLeftTitle().setVisibility(8);
            L9().getMTitleName().setVisibility(8);
            L9().getMLeftTitle().setText(com.qzone.util.l.a(R.string.mvs));
        } else {
            L9().setTitleAlpha(255);
            L9().getMLeftTitle().setVisibility(0);
            L9().getMTitleName().setVisibility(8);
            L9().getMLeftTitle().setText(com.qzone.util.l.a(R.string.mvs));
        }
        L9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.bm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bo.da(bo.this, view);
            }
        });
    }
}
