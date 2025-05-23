package com.qzone.reborn.feedx.presenter.ad.reward;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedExposePresenter$mHandler$2;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.QZoneAdExposureChecker;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.qphone.base.util.QLog;
import ih.f;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedExposePresenter;", "Lvg/a;", "", "O", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "onViewHolderDetachedFromWindow", "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "mQZoneActivity", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "G", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "mAdExposureChecker", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "H", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "mCallBack", "I", "Z", "mIsDataParsed", "J", "mIsViewAttachedToWindow", "Landroid/os/Handler;", "K", "Lkotlin/Lazy;", "N", "()Landroid/os/Handler;", "mHandler", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdRewardFeedExposePresenter extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private vac_adv_get.QzoneActivity mQZoneActivity;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneAdExposureChecker mAdExposureChecker;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneAdExposureChecker.b mCallBack;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsDataParsed;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsViewAttachedToWindow;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy mHandler;

    public QZoneAdRewardFeedExposePresenter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneAdRewardFeedExposePresenter$mHandler$2.a>() { // from class: com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedExposePresenter$mHandler$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedExposePresenter$mHandler$2$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes37.dex */
            public static final class a extends Handler {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ QZoneAdRewardFeedExposePresenter f55504a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(QZoneAdRewardFeedExposePresenter qZoneAdRewardFeedExposePresenter, Looper looper) {
                    super(looper);
                    this.f55504a = qZoneAdRewardFeedExposePresenter;
                }

                @Override // android.os.Handler
                public void handleMessage(Message msg2) {
                    boolean z16;
                    QZoneAdExposureChecker qZoneAdExposureChecker;
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    if (msg2.what == 1) {
                        this.f55504a.mIsDataParsed = true;
                        this.f55504a.O();
                        z16 = this.f55504a.mIsViewAttachedToWindow;
                        if (z16) {
                            qZoneAdExposureChecker = this.f55504a.mAdExposureChecker;
                            if (qZoneAdExposureChecker != null) {
                                qZoneAdExposureChecker.E();
                            }
                            this.f55504a.Q();
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(QZoneAdRewardFeedExposePresenter.this, Looper.getMainLooper());
            }
        });
        this.mHandler = lazy;
    }

    private final Handler N() {
        return (Handler) this.mHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        PBStringField pBStringField;
        String str;
        vac_adv_get.QzoneActivity qzoneActivity = this.mQZoneActivity;
        if (qzoneActivity == null || (pBStringField = qzoneActivity.trace_id) == null || (str = pBStringField.get()) == null) {
            return;
        }
        this.mAdExposureChecker = new QZoneAdExposureChecker(str, new WeakReference(this.f441563e));
        this.mCallBack = new b(str);
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.A(new WeakReference<>(this.mCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QZoneAdRewardFeedExposePresenter this$0) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        BusinessFeedData mFeedData = this$0.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
        vac_adv_get.QzoneActivity c06 = qZoneAdFeedUtils.c0(mFeedData);
        String str = null;
        String str2 = (c06 == null || (pBStringField2 = c06.trace_id) == null) ? null : pBStringField2.get();
        if (str2 == null) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            vac_adv_get.QzoneActivity qzoneActivity = this$0.mQZoneActivity;
            if (qzoneActivity != null && (pBStringField = qzoneActivity.trace_id) != null) {
                str = pBStringField.get();
            }
            if (!Intrinsics.areEqual(str, str2)) {
                this$0.mQZoneActivity = c06;
                if (c06 != null) {
                    Message message = new Message();
                    message.what = 1;
                    this$0.N().sendMessage(message);
                    return;
                }
                return;
            }
        }
        this$0.mIsDataParsed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        boolean contains;
        vac_adv_get.QzoneActivity qzoneActivity;
        PBStringField pBStringField;
        String str;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        vac_adv_get.QzoneActivity qzoneActivity2 = this.mQZoneActivity;
        String str2 = null;
        String str3 = (qzoneActivity2 == null || (pBStringField3 = qzoneActivity2.trace_id) == null) ? null : pBStringField3.get();
        if (str3 == null || str3.length() == 0) {
            return;
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        HashSet<String> u16 = qZoneAdFeedUtils.u();
        vac_adv_get.QzoneActivity qzoneActivity3 = this.mQZoneActivity;
        if (qzoneActivity3 != null && (pBStringField2 = qzoneActivity3.trace_id) != null) {
            str2 = pBStringField2.get();
        }
        contains = CollectionsKt___CollectionsKt.contains(u16, str2);
        if (contains || (qzoneActivity = this.mQZoneActivity) == null || (pBStringField = qzoneActivity.trace_id) == null || (str = pBStringField.get()) == null) {
            return;
        }
        f.f407629a.f(str);
        qZoneAdFeedUtils.u().add(str);
    }

    @Override // vg.a, vg.c
    public void c() {
        super.c();
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdRewardFeedExposePresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.u();
        }
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        super.onPaused();
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.w();
        }
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        this.mIsViewAttachedToWindow = true;
        if (this.mIsDataParsed) {
            QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
            if (qZoneAdExposureChecker != null) {
                qZoneAdExposureChecker.E();
            }
            Q();
        }
    }

    @Override // vg.a, vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        this.mIsViewAttachedToWindow = false;
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmu;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        this.mIsDataParsed = false;
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.reward.b
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdRewardFeedExposePresenter.P(QZoneAdRewardFeedExposePresenter.this);
            }
        }, 16, null, false);
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedExposePresenter$b", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "view", "", "onExposure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneAdExposureChecker.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f55503a;

        b(String str) {
            this.f55503a = str;
        }

        @Override // com.tencent.mobileqq.util.QZoneAdExposureChecker.b
        public void onExposure(WeakReference<View> view) {
            if (view == null) {
                return;
            }
            f.f407629a.e(this.f55503a);
            QLog.e("QZoneAdRewardFeedExposePresenter", 1, "[doEffectiveExposureReport],traceId: " + this.f55503a);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
