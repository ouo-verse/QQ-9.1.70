package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtTimeLineComponentData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.util.ad.QZoneAdStyleManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Comm_errKt;
import com.tencent.image.URLDrawable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 E2\u00020\u0001:\u0003FGHB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\nH\u0014J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0018\u00100\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0018\u00101\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010'R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010*\u00a8\u0006I"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter;", "Lvg/a;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "M", "N", "Lcom/qzone/proxy/feedcomponent/model/gdt/GdtTimeLineComponentData;", "targetComponent", "", "P", "", ExifInterface.LATITUDE_SOUTH, "O", BdhLogUtil.LogTag.Tag_Req, "k", "", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/ViewStub;", UserInfo.SEX_FEMALE, "Landroid/view/ViewStub;", "mAdBottomTimeLineViewStub", "G", "Z", "mIsBottomTimeLineInflate", "H", "Landroid/view/View;", "mAdBottomLeftView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mAdBottomLeftTextView", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "mAdBottomAdvertiserIconView", "K", "mAdTimeLineLayout", "L", "mAdTimeLineText", "mAdTimeLineTimeText", "", "Ljava/util/List;", "mComponentDataListInLine", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUiHandler", "Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter$UpdateRunnable;", "Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter$UpdateRunnable;", "mUpdateRunnable", "Lcom/qzone/proxy/feedcomponent/model/gdt/GdtTimeLineComponentData;", "mCurrentComponent", "Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter$b;", "Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter$b;", "mOnTimeLineClickListener", "", "T", "mCurrentComponentShowSeconds", "<init>", "()V", "U", "a", "b", "UpdateRunnable", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdFeedTimeLinePresenter extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private ViewStub mAdBottomTimeLineViewStub;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsBottomTimeLineInflate;

    /* renamed from: H, reason: from kotlin metadata */
    private View mAdBottomLeftView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mAdBottomLeftTextView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mAdBottomAdvertiserIconView;

    /* renamed from: K, reason: from kotlin metadata */
    private View mAdTimeLineLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mAdTimeLineText;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView mAdTimeLineTimeText;

    /* renamed from: N, reason: from kotlin metadata */
    private List<GdtTimeLineComponentData> mComponentDataListInLine;

    /* renamed from: R, reason: from kotlin metadata */
    private GdtTimeLineComponentData mCurrentComponent;

    /* renamed from: P, reason: from kotlin metadata */
    private final Handler mUiHandler = new Handler(Looper.getMainLooper(), null);

    /* renamed from: Q, reason: from kotlin metadata */
    private UpdateRunnable mUpdateRunnable = new UpdateRunnable(new WeakReference(this));

    /* renamed from: S, reason: from kotlin metadata */
    private final b mOnTimeLineClickListener = new b(new WeakReference(this));

    /* renamed from: T, reason: from kotlin metadata */
    private long mCurrentComponentShowSeconds = Long.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter$UpdateRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter;", "d", "Ljava/lang/ref/WeakReference;", "getMWeakPresenter", "()Ljava/lang/ref/WeakReference;", "setMWeakPresenter", "(Ljava/lang/ref/WeakReference;)V", "mWeakPresenter", "weakPresenter", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class UpdateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private WeakReference<QZoneAdFeedTimeLinePresenter> mWeakPresenter;

        public UpdateRunnable(WeakReference<QZoneAdFeedTimeLinePresenter> weakPresenter) {
            Intrinsics.checkNotNullParameter(weakPresenter, "weakPresenter");
            this.mWeakPresenter = weakPresenter;
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[UpdateRunnable] run");
            QZoneAdFeedTimeLinePresenter qZoneAdFeedTimeLinePresenter = this.mWeakPresenter.get();
            boolean z16 = false;
            if (qZoneAdFeedTimeLinePresenter != null && qZoneAdFeedTimeLinePresenter.S()) {
                z16 = true;
            }
            if (z16) {
                qZoneAdFeedTimeLinePresenter.M();
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter$b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdFeedTimeLinePresenter;", "d", "Ljava/lang/ref/WeakReference;", "mWeakPresenter", "weakPresenter", "<init>", "(Ljava/lang/ref/WeakReference;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneAdFeedTimeLinePresenter> mWeakPresenter;

        public b(WeakReference<QZoneAdFeedTimeLinePresenter> weakReference) {
            this.mWeakPresenter = weakReference;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(v3);
            if (v3 == null) {
                QLog.e("QZoneAdFeedTimeLinePresenter", 2, "[OnTimeLineClickListener] v = null");
            } else {
                WeakReference<QZoneAdFeedTimeLinePresenter> weakReference = this.mWeakPresenter;
                QZoneAdFeedTimeLinePresenter qZoneAdFeedTimeLinePresenter = weakReference != null ? weakReference.get() : null;
                if (qZoneAdFeedTimeLinePresenter == null) {
                    QLog.e("QZoneAdFeedTimeLinePresenter", 2, "[OnTimeLineClickListener] presenter = null");
                } else {
                    if (v3.getId() == R.id.mmt) {
                        i3 = 10059;
                    } else if (v3.getId() == R.id.mmy) {
                        i3 = 10060;
                    } else if (v3.getId() == R.id.mmz) {
                        i3 = 10061;
                    } else {
                        i3 = v3.getId() == R.id.mmu ? Comm_errKt.QZRetCode_QZ_IMS_SPACE_EXCEED_LIMIT : 1000;
                    }
                    int i16 = i3;
                    QLog.i("QZoneAdFeedTimeLinePresenter", 2, "[OnTimeLineClickListener] clickPos" + i16);
                    QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                    Activity activity = ((vg.a) qZoneAdFeedTimeLinePresenter).C;
                    Intrinsics.checkNotNullExpressionValue(activity, "presenter.mActivity");
                    BusinessFeedData businessFeedData = ((vg.a) qZoneAdFeedTimeLinePresenter).f441565h;
                    Intrinsics.checkNotNullExpressionValue(businessFeedData, "presenter.mFeedData");
                    qZoneAdFeedUtils.H(activity, v3, businessFeedData, FeedElement.GDT_TIME_LINE, i16, ((vg.a) qZoneAdFeedTimeLinePresenter).f441567m, null);
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        N();
        this.mUiHandler.postDelayed(this.mUpdateRunnable, 500L);
    }

    private final void N() {
        this.mUiHandler.removeCallbacks(this.mUpdateRunnable);
    }

    private final GdtTimeLineComponentData O() {
        List<GdtTimeLineComponentData> list = this.mComponentDataListInLine;
        ArrayList arrayList = list != null ? new ArrayList(list) : null;
        if (arrayList != null && arrayList.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GdtTimeLineComponentData gdtTimeLineComponentData = (GdtTimeLineComponentData) it.next();
                if (gdtTimeLineComponentData == null || !gdtTimeLineComponentData.isValid()) {
                    QLog.e("QZoneAdFeedTimeLinePresenter", 2, "[updateTimeLineComponent] components error");
                } else if (currentTimeMillis >= gdtTimeLineComponentData.beginTimeSeconds && currentTimeMillis <= gdtTimeLineComponentData.endTimeSeconds) {
                    return gdtTimeLineComponentData;
                }
            }
            return null;
        }
        QLog.e("QZoneAdFeedTimeLinePresenter", 2, "[updateTimeLineComponent] components is empty");
        return null;
    }

    private final void Q() {
        if (this.mIsBottomTimeLineInflate) {
            return;
        }
        this.mIsBottomTimeLineInflate = true;
        View view = this.f441562d;
        ViewStub viewStub = view != null ? (ViewStub) view.findViewById(R.id.nmq) : null;
        this.mAdBottomTimeLineViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        View view2 = this.f441562d;
        this.mAdBottomLeftView = view2 != null ? view2.findViewById(R.id.mmu) : null;
        View view3 = this.f441562d;
        this.mAdBottomLeftTextView = view3 != null ? (TextView) view3.findViewById(R.id.mmw) : null;
        View view4 = this.f441562d;
        this.mAdTimeLineText = view4 != null ? (TextView) view4.findViewById(R.id.mmy) : null;
        View view5 = this.f441562d;
        this.mAdTimeLineTimeText = view5 != null ? (TextView) view5.findViewById(R.id.mmz) : null;
        View view6 = this.f441562d;
        this.mAdTimeLineLayout = view6 != null ? view6.findViewById(R.id.mmx) : null;
        View view7 = this.f441562d;
        this.mAdBottomAdvertiserIconView = view7 != null ? (ImageView) view7.findViewById(R.id.mmt) : null;
    }

    private final void R(GdtTimeLineComponentData targetComponent) {
        GdtTimeLineComponentData gdtTimeLineComponentData = this.mCurrentComponent;
        if (gdtTimeLineComponentData != null && Intrinsics.areEqual(targetComponent, gdtTimeLineComponentData)) {
            QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[updateTimeLineComponent] no need to update component");
            return;
        }
        QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[updateTimeLineComponent] " + targetComponent + "\ncurrnet time:" + System.currentTimeMillis());
        View view = this.f441562d;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.mAdBottomLeftTextView;
        if (textView != null) {
            textView.setText(targetComponent.buttonText);
        }
        TextView textView2 = this.mAdTimeLineText;
        if (textView2 != null) {
            textView2.setText(targetComponent.text);
        }
        TextView textView3 = this.mAdBottomLeftTextView;
        if (textView3 != null) {
            ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = LayoutAttrsKt.getDp(6);
            }
        }
        ImageView imageView = this.mAdBottomAdvertiserIconView;
        if (imageView != null) {
            imageView.setImageDrawable(URLDrawable.getDrawable(targetComponent.brandImageUrl, URLDrawable.URLDrawableOptions.obtain()));
        }
        this.mCurrentComponent = targetComponent;
        this.mCurrentComponentShowSeconds = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S() {
        String str;
        QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[updateTimeLineComponent]");
        GdtTimeLineComponentData O = O();
        if (O == null) {
            QLog.i("QZoneAdFeedTimeLinePresenter", 2, "[updateTimeLineComponent] no targetComponent touch end");
            View view = this.mAdTimeLineLayout;
            if (view != null) {
                view.setVisibility(8);
            }
            TextView textView = this.mAdBottomLeftTextView;
            if (textView != null) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.leftMargin = LayoutAttrsKt.getDp(13);
                }
            }
            return false;
        }
        TextView textView2 = this.mAdTimeLineTimeText;
        if (textView2 != null) {
            if (O.isShowCountDown) {
                str = P(O);
            } else {
                str = "";
            }
            textView2.setText(str);
        }
        TextView textView3 = this.mAdTimeLineTimeText;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        R(O);
        return true;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        if (this.f441562d == null) {
            QLog.e("QZoneAdFeedTimeLinePresenter", 2, "[onBindData] mContainerView is null");
            return;
        }
        if (!QZoneAdStyleManager.f55731a.a(4L, feedData)) {
            QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[onBindData] don't support time line");
            View view = this.f441562d;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        List<GdtTimeLineComponentData> B = QZoneAdFeedUtils.f55717a.B(feedData);
        List<GdtTimeLineComponentData> list = B;
        if (list == null || list.isEmpty()) {
            QLog.e("QZoneAdFeedTimeLinePresenter", 1, "[onBindData] components is empty");
            View view2 = this.f441562d;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        View view3 = this.f441562d;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        Q();
        View view4 = this.mAdBottomLeftView;
        if (view4 != null) {
            view4.setOnClickListener(this.mOnTimeLineClickListener);
        }
        TextView textView = this.mAdTimeLineText;
        if (textView != null) {
            textView.setOnClickListener(this.mOnTimeLineClickListener);
        }
        TextView textView2 = this.mAdTimeLineTimeText;
        if (textView2 != null) {
            textView2.setOnClickListener(this.mOnTimeLineClickListener);
        }
        ImageView imageView = this.mAdBottomAdvertiserIconView;
        if (imageView != null) {
            imageView.setOnClickListener(this.mOnTimeLineClickListener);
        }
        this.mComponentDataListInLine = B;
        S();
        M();
    }

    @Override // vg.a, vg.c
    public void c() {
        super.c();
        QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[onResumed]");
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedTimeLinePresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmp;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[onResumed]");
        N();
        super.onDestroy();
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        QLog.d("QZoneAdFeedTimeLinePresenter", 2, "[onPaused]");
        N();
        super.onPaused();
    }

    private final String P(GdtTimeLineComponentData targetComponent) {
        String str;
        String str2;
        String str3;
        Integer valueOf = targetComponent != null ? Integer.valueOf(targetComponent.countDownAnchorSeconds) : null;
        if (valueOf != null && valueOf.intValue() > 0) {
            long intValue = valueOf.intValue() - (System.currentTimeMillis() / 1000);
            if (intValue < 0) {
                intValue = 0;
            }
            int i3 = (int) (intValue / 86400);
            long j3 = intValue - (i3 * 86400);
            int i16 = (int) (j3 / 3600);
            long j16 = j3 - (i16 * 3600);
            int i17 = (int) (j16 / 60);
            int i18 = (int) (j16 - (i17 * 60));
            if (i18 > 9) {
                str = String.valueOf(i18);
            } else {
                str = "0" + i18;
            }
            if (i17 > 9) {
                str2 = String.valueOf(i17);
            } else {
                str2 = "0" + i17;
            }
            if (i16 > 9) {
                str3 = String.valueOf(i16);
            } else {
                str3 = "0" + i16;
            }
            if (i3 > 99) {
                i3 = 99;
            }
            String str4 = i3 + "\u5929";
            String str5 = str3 + ":" + str2 + ":" + str;
            long j17 = this.mCurrentComponentShowSeconds;
            if ((j17 == Long.MIN_VALUE || j17 >= valueOf.intValue() - 86400) && i3 <= 0) {
                return str5;
            }
            return str4 + str5;
        }
        return "";
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
