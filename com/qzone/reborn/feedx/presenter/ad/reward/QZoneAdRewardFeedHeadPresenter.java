package com.qzone.reborn.feedx.presenter.ad.reward;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.b;
import com.qzone.reborn.feedx.presenter.ad.reward.a;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import gf.h;
import ih.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0003\"#$B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedHeadPresenter;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b;", "Lcom/qzone/reborn/feedx/presenter/ad/reward/a;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "k", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M", "O", "e", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "g", "N", "Ljava/lang/String;", "TAG", "P", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "mQZoneActivity", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$Activity;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$Activity;", "mActivityInfo", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Handler;", "mHandler", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "AdResultReceiver", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdRewardFeedHeadPresenter extends com.qzone.reborn.feedx.presenter.ad.basepresenter.b implements com.qzone.reborn.feedx.presenter.ad.reward.a {

    /* renamed from: P, reason: from kotlin metadata */
    private vac_adv_get.QzoneActivity mQZoneActivity;

    /* renamed from: Q, reason: from kotlin metadata */
    private vac_adv_get.Activity mActivityInfo;

    /* renamed from: N, reason: from kotlin metadata */
    private final String TAG = "QZoneAdRewardFeedHeadPresenter";

    /* renamed from: R, reason: from kotlin metadata */
    private final Handler mHandler = new c(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedHeadPresenter$AdResultReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "(Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedHeadPresenter;Landroid/os/Handler;)V", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public final class AdResultReceiver extends ResultReceiver {
        public AdResultReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            super.onReceiveResult(resultCode, resultData);
            QZoneAdRewardFeedHeadPresenter.this.R(resultCode, resultData);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedHeadPresenter$a;", "Lcom/qzone/reborn/feedx/presenter/ad/reward/e;", "", "profitable", "", "elapsedTime", "totalTime", "", "a", "<init>", "(Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedHeadPresenter;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a implements e {
        public a() {
        }

        @Override // com.qzone.reborn.feedx.presenter.ad.reward.e
        public void a(boolean profitable, int elapsedTime, int totalTime) {
            QZoneAdRewardFeedHeadPresenter.this.S(profitable, elapsedTime);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedHeadPresenter$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1) {
                QZoneAdRewardFeedHeadPresenter.this.M();
                QZoneAdRewardFeedHeadPresenter.this.O();
            }
        }
    }

    private final void Q() {
        if (getMInteractOperateIoc() == null) {
            N((h) j(h.class));
        }
        h mInteractOperateIoc = getMInteractOperateIoc();
        if (mInteractOperateIoc != null) {
            mInteractOperateIoc.h2(this.f441565h, this.f441567m, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(QZoneAdRewardFeedHeadPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        BusinessFeedData mFeedData = this$0.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
        this$0.mQZoneActivity = qZoneAdFeedUtils.c0(mFeedData);
        Message message = new Message();
        message.what = 1;
        this$0.mHandler.sendMessage(message);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b, vg.a
    protected void A(BusinessFeedData feedData) {
        if (this.f441565h == null) {
            QLog.e(getTAG(), 1, "[onBindData] error, feeddata is null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.reward.c
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneAdRewardFeedHeadPresenter.T(QZoneAdRewardFeedHeadPresenter.this);
                }
            }, 16, null, false);
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b
    public void M() {
        vac_adv_get.Activity y16;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        vac_adv_get.QzoneActivity qzoneActivity = this.mQZoneActivity;
        if (qzoneActivity == null || (y16 = QZoneAdFeedUtils.f55717a.y(qzoneActivity)) == null) {
            return;
        }
        this.mActivityInfo = y16;
        b.a mAdFeedHeadData = getMAdFeedHeadData();
        vac_adv_get.Activity activity = this.mActivityInfo;
        String str = null;
        String str2 = (activity == null || (pBStringField2 = activity.icon_url) == null) ? null : pBStringField2.get();
        if (str2 == null) {
            str2 = "";
        }
        mAdFeedHeadData.f(str2);
        b.a mAdFeedHeadData2 = getMAdFeedHeadData();
        vac_adv_get.Activity activity2 = this.mActivityInfo;
        if (activity2 != null && (pBStringField = activity2.title) != null) {
            str = pBStringField.get();
        }
        mAdFeedHeadData2.g(str != null ? str : "");
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b
    public void O() {
        Resources resources;
        super.O();
        Activity activity = this.C;
        if (activity != null && (resources = activity.getResources()) != null) {
            int color = resources.getColor(R.color.qui_button_text_error_pressed);
            QZoneNickNameView mAdName = getMAdName();
            if (mAdName != null) {
                mAdName.setTextColor(color);
            }
        }
        QZoneRichTextView mAdDes = getMAdDes();
        if (mAdDes != null) {
            mAdDes.setVisibility(8);
        }
        View mAdContainerView = getMAdContainerView();
        if (mAdContainerView != null) {
            mAdContainerView.setOnClickListener(this);
        }
    }

    public void R(int i3, Bundle bundle) {
        a.C0468a.a(this, i3, bundle);
    }

    public void S(boolean z16, int i3) {
        a.C0468a.b(this, z16, i3);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.reward.a
    public void f(boolean z16, int i3, boolean z17) {
        a.C0468a.c(this, z16, i3, z17);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.reward.a
    /* renamed from: g, reason: from getter */
    public vac_adv_get.QzoneActivity getMQZoneActivity() {
        return this.mQZoneActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mmc /* 1745224432 */:
                case R.id.mmd /* 1745224433 */:
                    Q();
                    break;
                default:
                    f.f407629a.j("third_fulicard_exbutton", "click");
                    ih.e eVar = ih.e.f407623a;
                    Activity mActivity = this.C;
                    Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                    eVar.j(mActivity, this.mQZoneActivity, new AdResultReceiver(new Handler(Looper.getMainLooper())), new a(), QZoneAdFeedUtils.f55717a.Y(this.mQZoneActivity), QZoneAdFeedDataExtKt.isRewardAdRealTimeRequest(this.f441565h));
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.reward.a
    public void e() {
    }
}
