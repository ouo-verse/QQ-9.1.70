package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.canvasui.widget.shake.GdtShakeLayoutForQzone;
import com.qzone.canvasui.widget.shake.GdtShakeLayoutForQzoneBase;
import com.qzone.canvasui.widget.shake.GdtShakeLeftLayoutForQzone;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0014J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0006\u0010 \u001a\u00020\u0002R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000eR\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u000eR\"\u0010J\u001a\u00020D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/o;", "Lvg/a;", "", "W", ExifInterface.LATITUDE_SOUTH, "", "O", "", "P", "V", "U", "T", BdhLogUtil.LogTag.Tag_Req, "isVerticalAd", "J", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeWithValueListener;", "M", "", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/gdtad/aditem/GdtAd;", UserInfo.SEX_FEMALE, "Lcom/tencent/gdtad/aditem/GdtAd;", "K", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setMAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "mAd", "Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzone;", "G", "Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzone;", "getMShakeLayout", "()Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzone;", "setMShakeLayout", "(Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzone;)V", "mShakeLayout", "Lcom/qzone/canvasui/widget/shake/GdtShakeLeftLayoutForQzone;", "H", "Lcom/qzone/canvasui/widget/shake/GdtShakeLeftLayoutForQzone;", "getMShakeLeftLayout", "()Lcom/qzone/canvasui/widget/shake/GdtShakeLeftLayoutForQzone;", "setMShakeLeftLayout", "(Lcom/qzone/canvasui/widget/shake/GdtShakeLeftLayoutForQzone;)V", "mShakeLeftLayout", "Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzoneBase;", "I", "Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzoneBase;", "L", "()Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzoneBase;", "setMCurrentShakeLayout", "(Lcom/qzone/canvasui/widget/shake/GdtShakeLayoutForQzoneBase;)V", "mCurrentShakeLayout", "", "mShakeStartTime", "mShakeScrollTime", "Landroid/os/Handler;", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHandler", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: G, reason: from kotlin metadata */
    private GdtShakeLayoutForQzone mShakeLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private GdtShakeLeftLayoutForQzone mShakeLeftLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private GdtShakeLayoutForQzoneBase mCurrentShakeLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private long mShakeStartTime;

    /* renamed from: K, reason: from kotlin metadata */
    private long mShakeScrollTime;

    /* renamed from: L, reason: from kotlin metadata */
    private Handler mHandler = new b(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/o$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1) {
                GdtAd mAd = o.this.getMAd();
                if (ih.j.i(mAd != null ? mAd.getTraceId() : null)) {
                    QLog.d("QZoneAdFeedShakePresenter", 1, "feed is marked as shielded ");
                    o.this.R();
                } else {
                    GdtShakeLayoutForQzoneBase mCurrentShakeLayout = o.this.getMCurrentShakeLayout();
                    if (mCurrentShakeLayout == null) {
                        return;
                    }
                    mCurrentShakeLayout.setVisibility(0);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils.f55717a.Q(r0.getInnerShowType()) == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int J(boolean isVerticalAd) {
        GdtAd gdtAd = this.mAd;
        boolean z16 = true;
        if (!(gdtAd != null && gdtAd.getInnerShowType() == 21)) {
            GdtAd gdtAd2 = this.mAd;
            if (gdtAd2 != null) {
            }
            z16 = false;
            if (!z16) {
                if (isVerticalAd) {
                    return QZoneAdFeedUtils.f55717a.D(this.f441565h, this.mAd);
                }
                return 0;
            }
        }
        return ViewUtils.dpToPx(12.0f);
    }

    private final GdtShakeSensor.OnShakeWithValueListener M() {
        return new GdtShakeSensor.OnShakeWithValueListener() { // from class: com.qzone.reborn.feedx.presenter.ad.n
            @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeWithValueListener
            public final void onShakeComplete(float f16, float f17, float f18, float f19) {
                o.N(o.this, f16, f17, f18, f19);
            }
        };
    }

    private final int O() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int gdtInnerAdShowType = QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h);
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.T(gdtInnerAdShowType)) {
            com.qzone.reborn.feedx.widget.picmixvideo.b.b(i(), layoutParams, this.f441565h.getVideoInfo());
        } else if (qZoneAdFeedUtils.P(gdtInnerAdShowType)) {
            Activity activity = this.C;
            BusinessFeedData businessFeedData = this.f441565h;
            com.qzone.reborn.feedx.widget.picmixvideo.b.a(activity, businessFeedData, layoutParams, businessFeedData != null ? QZoneAdFeedDataExtKt.getAdPicture(businessFeedData) : null, pl.a.f426446a.l(this.C));
        } else if (qZoneAdFeedUtils.Q(gdtInnerAdShowType)) {
            qZoneAdFeedUtils.d(this.C, layoutParams);
        }
        return layoutParams.width;
    }

    private final boolean P() {
        GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this.mCurrentShakeLayout;
        return gdtShakeLayoutForQzoneBase != null && gdtShakeLayoutForQzoneBase.hasWindowFocus() && QZoneAdFeedUtils.f55717a.N(gdtShakeLayoutForQzoneBase, this.C, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this.mCurrentShakeLayout;
        if (gdtShakeLayoutForQzoneBase != null) {
            gdtShakeLayoutForQzoneBase.setVisibility(8);
        }
        GdtAd gdtAd = this.mAd;
        ih.j.q(gdtAd != null ? gdtAd.getTraceId() : null);
        V();
    }

    private final void S() {
        GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this.mCurrentShakeLayout;
        if (gdtShakeLayoutForQzoneBase != null) {
            GdtShakeSensor.OnShakeWithValueListener M = M();
            gdtShakeLayoutForQzoneBase.setTag(M);
            gdtShakeLayoutForQzoneBase.init(ih.j.c(this.f441565h));
            gdtShakeLayoutForQzoneBase.setShakeWithValueListener(new WeakReference<>(M));
            T();
            gdtShakeLayoutForQzoneBase.setVisibility(0);
        }
    }

    private final void T() {
        GdtAd gdtAd = this.mAd;
        if (ih.j.i(gdtAd != null ? gdtAd.getTraceId() : null)) {
            return;
        }
        GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this.mCurrentShakeLayout;
        if (gdtShakeLayoutForQzoneBase != null) {
            gdtShakeLayoutForQzoneBase.start();
        }
        long f16 = ih.j.f();
        Message message = new Message();
        message.what = 1;
        this.mHandler.sendMessageDelayed(message, f16);
    }

    private final void U() {
        if (ih.j.k(this.f441565h)) {
            GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this.mCurrentShakeLayout;
            if (gdtShakeLayoutForQzoneBase != null) {
                gdtShakeLayoutForQzoneBase.setVisibility(8);
            }
            T();
            this.mShakeStartTime = System.currentTimeMillis();
            if (this.mShakeScrollTime != 0) {
                return;
            }
            this.mShakeScrollTime = System.currentTimeMillis();
        }
    }

    private final void V() {
        if (ih.j.k(this.f441565h)) {
            GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this.mCurrentShakeLayout;
            if (gdtShakeLayoutForQzoneBase != null) {
                gdtShakeLayoutForQzoneBase.stop();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private final void W() {
        FrameLayout.LayoutParams layoutParams;
        GdtShakeLayoutForQzone gdtShakeLayoutForQzone = this.mShakeLayout;
        if (gdtShakeLayoutForQzone != null) {
            int O = O();
            int i3 = AreaConst.dp50;
            if (GdtAdFeedUtil.isVerticalVideo(this.f441565h)) {
                int i16 = AreaConst.dp25;
                ViewExtKt.c(gdtShakeLayoutForQzone, i16);
                i3 += i16;
            } else {
                ViewExtKt.c(gdtShakeLayoutForQzone, 0);
            }
            boolean R = QZoneAdFeedUtils.f55717a.R(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) gdtShakeLayoutForQzone.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = O;
                layoutParams2.height = i3;
                layoutParams2.gravity = 80;
                layoutParams2.bottomMargin = J(R);
                layoutParams2.topMargin = -i3;
                gdtShakeLayoutForQzone.setLayoutParams(layoutParams2);
            }
        }
        GdtShakeLeftLayoutForQzone gdtShakeLeftLayoutForQzone = this.mShakeLeftLayout;
        if (gdtShakeLeftLayoutForQzone == null || (layoutParams = (FrameLayout.LayoutParams) gdtShakeLeftLayoutForQzone.getLayoutParams()) == null) {
            return;
        }
        int i17 = AreaConst.dp25;
        layoutParams.height = i17;
        int gdtInnerAdShowType = QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h);
        if (!QZoneAdFeedUtils.f55717a.R(gdtInnerAdShowType) && gdtInnerAdShowType != 21 && gdtInnerAdShowType != 10) {
            layoutParams.bottomMargin = AreaConst.dp12;
        } else {
            layoutParams.bottomMargin = i17;
        }
        if (gdtInnerAdShowType == 10) {
            layoutParams.leftMargin = AreaConst.dp16;
        } else {
            layoutParams.leftMargin = AreaConst.dp12;
        }
        layoutParams.gravity = 80;
        gdtShakeLeftLayoutForQzone.setLayoutParams(layoutParams);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        BusinessFeedData businessFeedData;
        if (this.f441562d == null || (businessFeedData = this.f441565h) == null || !ih.j.k(businessFeedData)) {
            return;
        }
        this.mAd = new GdtAd(GdtFeedUtilForQZone.f(this.f441565h));
        W();
        GdtShakeLayoutForQzone gdtShakeLayoutForQzone = this.mShakeLayout;
        if (gdtShakeLayoutForQzone != null) {
            gdtShakeLayoutForQzone.setVisibility(8);
        }
        GdtShakeLeftLayoutForQzone gdtShakeLeftLayoutForQzone = this.mShakeLeftLayout;
        if (gdtShakeLeftLayoutForQzone != null) {
            gdtShakeLeftLayoutForQzone.setVisibility(8);
        }
        if (Intrinsics.areEqual(QZoneAdFeedDataExtKt.shakeAdNewStyle(this.f441565h), "bottom_left")) {
            GdtShakeLeftLayoutForQzone gdtShakeLeftLayoutForQzone2 = this.mShakeLeftLayout;
            this.mCurrentShakeLayout = gdtShakeLeftLayoutForQzone2;
            Intrinsics.checkNotNull(gdtShakeLeftLayoutForQzone2, "null cannot be cast to non-null type com.qzone.canvasui.widget.shake.GdtShakeLeftLayoutForQzone");
            gdtShakeLeftLayoutForQzone2.addGuideText("");
        } else {
            this.mCurrentShakeLayout = this.mShakeLayout;
        }
        GdtAd gdtAd = this.mAd;
        if (ih.j.i(gdtAd != null ? gdtAd.getTraceId() : null)) {
            QLog.d("QZoneAdFeedShakePresenter", 1, "feed is marked as shielded cancel bind data");
        } else if (this.mCurrentShakeLayout != null) {
            S();
        }
    }

    @Override // vg.a
    public void B() {
        V();
    }

    /* renamed from: K, reason: from getter */
    public final GdtAd getMAd() {
        return this.mAd;
    }

    /* renamed from: L, reason: from getter */
    public final GdtShakeLayoutForQzoneBase getMCurrentShakeLayout() {
        return this.mCurrentShakeLayout;
    }

    public final void Q() {
        this.mShakeScrollTime = System.currentTimeMillis();
    }

    @Override // vg.a, vg.c
    public void c() {
        U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedShakePresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        V();
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        V();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nn6;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(o this$0, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ih.j.k(this$0.f441565h)) {
            if (ih.j.j(this$0.f441565h, this$0.mShakeStartTime)) {
                QLog.d("QZoneAdFeedShakePresenter", 1, "user shake in limit time, shield shake");
                this$0.R();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this$0.mShakeScrollTime;
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            if (qZoneAdFeedUtils.f(this$0.f441565h, this$0.f441563e, this$0.C, currentTimeMillis)) {
                QLog.d("QZoneAdFeedShakePresenter", 1, "intercept tab, shield shake");
                GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase = this$0.mCurrentShakeLayout;
                if (gdtShakeLayoutForQzoneBase != null) {
                    gdtShakeLayoutForQzoneBase.resetShakeSensor();
                    return;
                }
                return;
            }
            if (qZoneAdFeedUtils.K(this$0.f441565h, this$0.f441563e, this$0.C) && this$0.P()) {
                ih.j.p(f16, f17, f18, f19, currentTimeMillis);
                GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase2 = this$0.mCurrentShakeLayout;
                if (gdtShakeLayoutForQzoneBase2 != null) {
                    Activity mActivity = this$0.C;
                    Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                    BusinessFeedData mFeedData = this$0.f441565h;
                    Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
                    qZoneAdFeedUtils.H(mActivity, gdtShakeLayoutForQzoneBase2, mFeedData, FeedElement.GDT_ACTION_SHAKE, 80, this$0.f441567m, null);
                    return;
                }
                return;
            }
            GdtShakeLayoutForQzoneBase gdtShakeLayoutForQzoneBase3 = this$0.mCurrentShakeLayout;
            if (gdtShakeLayoutForQzoneBase3 != null) {
                gdtShakeLayoutForQzoneBase3.resetShakeSensor();
            }
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        if (containerView == null) {
            return;
        }
        this.mShakeLayout = (GdtShakeLayoutForQzone) this.f441562d.findViewById(R.id.myh);
        this.mShakeLeftLayout = (GdtShakeLeftLayoutForQzone) this.f441562d.findViewById(R.id.myi);
    }
}
