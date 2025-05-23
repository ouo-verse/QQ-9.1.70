package com.qzone.reborn.feedx.presenter.ad.reward;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedPresenter$mHandler$2;
import com.qzone.reborn.feedx.presenter.ad.reward.a;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.widget.AsyncImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import ih.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003BCDB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0006\u0010\u0014\u001a\u00020\u0004J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b#\u0010=\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedPresenter;", "Lvg/a;", "Lcom/qzone/reborn/feedx/presenter/ad/reward/a;", "Landroid/view/View$OnClickListener;", "", "L", "M", "O", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "P", "v", NodeProps.ON_CLICK, "e", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "g", "Lcom/qzone/widget/AsyncImageView;", UserInfo.SEX_FEMALE, "Lcom/qzone/widget/AsyncImageView;", "mRewardPic1", "G", "mRewardPic2", "H", "mRewardPic3", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "mRewardPicsLayout", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mRewardDes", "Landroid/widget/Button;", "K", "Landroid/widget/Button;", "mRewardBtn", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "mRewardBar", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "N", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "mQZoneActivity", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$Activity;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$Activity;", "mActivityInfo", "Landroid/os/Handler;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "()Landroid/os/Handler;", "mHandler", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "AdResultReceiver", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdRewardFeedPresenter extends vg.a implements com.qzone.reborn.feedx.presenter.ad.reward.a, View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private AsyncImageView mRewardPic1;

    /* renamed from: G, reason: from kotlin metadata */
    private AsyncImageView mRewardPic2;

    /* renamed from: H, reason: from kotlin metadata */
    private AsyncImageView mRewardPic3;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout mRewardPicsLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mRewardDes;

    /* renamed from: K, reason: from kotlin metadata */
    private Button mRewardBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private FrameLayout mRewardBar;

    /* renamed from: M, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: N, reason: from kotlin metadata */
    private vac_adv_get.QzoneActivity mQZoneActivity;

    /* renamed from: P, reason: from kotlin metadata */
    private vac_adv_get.Activity mActivityInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy mHandler;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedPresenter$AdResultReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "(Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedPresenter;Landroid/os/Handler;)V", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public final class AdResultReceiver extends ResultReceiver {
        public AdResultReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            super.onReceiveResult(resultCode, resultData);
            QZoneAdRewardFeedPresenter.this.J(resultCode, resultData);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedPresenter$a;", "Lcom/qzone/reborn/feedx/presenter/ad/reward/e;", "", "profitable", "", "elapsedTime", "totalTime", "", "a", "<init>", "(Lcom/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedPresenter;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a implements e {
        public a() {
        }

        @Override // com.qzone.reborn.feedx.presenter.ad.reward.e
        public void a(boolean profitable, int elapsedTime, int totalTime) {
            QZoneAdRewardFeedPresenter.this.K(profitable, elapsedTime);
        }
    }

    public QZoneAdRewardFeedPresenter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneAdRewardFeedPresenter$mHandler$2.a>() { // from class: com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedPresenter$mHandler$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/reward/QZoneAdRewardFeedPresenter$mHandler$2$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes37.dex */
            public static final class a extends Handler {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ QZoneAdRewardFeedPresenter f55510a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(QZoneAdRewardFeedPresenter qZoneAdRewardFeedPresenter, Looper looper) {
                    super(looper);
                    this.f55510a = qZoneAdRewardFeedPresenter;
                }

                @Override // android.os.Handler
                public void handleMessage(Message msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    if (msg2.what == 1) {
                        this.f55510a.P();
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
                return new a(QZoneAdRewardFeedPresenter.this, Looper.getMainLooper());
            }
        });
        this.mHandler = lazy;
    }

    private final Handler I() {
        return (Handler) this.mHandler.getValue();
    }

    private final void L() {
        String str;
        PBStringField pBStringField;
        Drawable background;
        String str2;
        PBStringField pBStringField2;
        boolean contains;
        PBStringField pBStringField3;
        vac_adv_get.QzoneActivity qzoneActivity = this.mQZoneActivity;
        Drawable drawable = null;
        String str3 = (qzoneActivity == null || (pBStringField3 = qzoneActivity.trace_id) == null) ? null : pBStringField3.get();
        if (!TextUtils.isEmpty(str3)) {
            contains = CollectionsKt___CollectionsKt.contains(QZoneAdFeedUtils.f55717a.x(), str3);
            if (contains) {
                O();
                QLog.e("QZoneAdRewardPresenter", 1, "[onBindData] ignore, is the same reward ad");
                return;
            }
        }
        Button button = this.mRewardBtn;
        if (button != null) {
            vac_adv_get.Activity activity = this.mActivityInfo;
            if (activity == null || (pBStringField2 = activity.btn_before) == null || (str2 = pBStringField2.get()) == null) {
                str2 = "\u770b\u89c6\u9891\u9886\u798f\u5229";
            }
            button.setText(str2);
        }
        Button button2 = this.mRewardBtn;
        if (button2 != null) {
            button2.setTextColor(Color.parseColor("#5E3900"));
        }
        Button button3 = this.mRewardBtn;
        if (button3 != null && (background = button3.getBackground()) != null) {
            drawable = background.mutate();
        }
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setColors(new int[]{Color.parseColor("#F6C74D"), Color.parseColor("#EEBC0B")});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = this.mRewardDes;
        if (textView != null) {
            vac_adv_get.Activity activity2 = this.mActivityInfo;
            if (activity2 == null || (pBStringField = activity2.desc_before) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        FrameLayout frameLayout = this.mRewardBar;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
        Button button4 = this.mRewardBtn;
        if (button4 != null) {
            button4.setOnClickListener(this);
        }
    }

    private final void M() {
        PBRepeatField<String> pBRepeatField;
        vac_adv_get.Activity activity = this.mActivityInfo;
        List<String> list = (activity == null || (pBRepeatField = activity.images) == null) ? null : pBRepeatField.get();
        if (list == null || list.isEmpty() || list.size() < 3) {
            return;
        }
        AsyncImageView asyncImageView = this.mRewardPic1;
        if (asyncImageView != null) {
            asyncImageView.setAsyncImage(list.get(0));
        }
        AsyncImageView asyncImageView2 = this.mRewardPic2;
        if (asyncImageView2 != null) {
            asyncImageView2.setAsyncImage(list.get(1));
        }
        AsyncImageView asyncImageView3 = this.mRewardPic3;
        if (asyncImageView3 != null) {
            asyncImageView3.setAsyncImage(list.get(2));
        }
        LinearLayout linearLayout = this.mRewardPicsLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(QZoneAdRewardFeedPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        BusinessFeedData mFeedData = this$0.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
        vac_adv_get.QzoneActivity c06 = qZoneAdFeedUtils.c0(mFeedData);
        this$0.mQZoneActivity = c06;
        if (c06 != null) {
            Message message = new Message();
            message.what = 1;
            this$0.I().sendMessage(message);
        }
    }

    private final void O() {
        String str;
        PBStringField pBStringField;
        String str2;
        PBStringField pBStringField2;
        Drawable background;
        Button button = this.mRewardBtn;
        GradientDrawable gradientDrawable = (GradientDrawable) ((button == null || (background = button.getBackground()) == null) ? null : background.mutate());
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setColors(new int[]{Color.parseColor("#C5C5C5"), Color.parseColor("#8A8A8A")});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        Button button2 = this.mRewardBtn;
        if (button2 != null) {
            vac_adv_get.Activity activity = this.mActivityInfo;
            if (activity == null || (pBStringField2 = activity.btn_after) == null || (str2 = pBStringField2.get()) == null) {
                str2 = "\u5df2\u9886\u53d6\u798f\u5229";
            }
            button2.setText(str2);
        }
        Button button3 = this.mRewardBtn;
        if (button3 != null) {
            button3.setTextColor(-1);
        }
        TextView textView = this.mRewardDes;
        if (textView != null) {
            vac_adv_get.Activity activity2 = this.mActivityInfo;
            if (activity2 == null || (pBStringField = activity2.desc_after) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        Button button4 = this.mRewardBtn;
        if (button4 != null) {
            button4.setClickable(false);
        }
        FrameLayout frameLayout = this.mRewardBar;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setClickable(false);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            View view = this.f441562d;
            if (view != null) {
                view.setVisibility(8);
            }
            QLog.e("QZoneAdRewardPresenter", 1, "[onBindData] error, feeddata is null");
            return;
        }
        if (!QZoneAdFeedDataExtKt.isRewardAd(businessFeedData)) {
            View view2 = this.f441562d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            QLog.e("QZoneAdRewardPresenter", 1, "[onBindData] error, feeddata is not reward ad");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.reward.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdRewardFeedPresenter.N(QZoneAdRewardFeedPresenter.this);
            }
        }, 16, null, false);
    }

    @Override // vg.a
    protected void C(View containerView) {
        View view = this.f441562d;
        if (view != null && (view instanceof RelativeLayout)) {
            view.setVisibility(8);
            this.mRewardPic1 = (AsyncImageView) this.f441562d.findViewById(R.id.myd);
            this.mRewardPic2 = (AsyncImageView) this.f441562d.findViewById(R.id.mye);
            this.mRewardPic3 = (AsyncImageView) this.f441562d.findViewById(R.id.myf);
            this.mRewardPicsLayout = (LinearLayout) this.f441562d.findViewById(R.id.myg);
            this.mRewardBar = (FrameLayout) this.f441562d.findViewById(R.id.mya);
            this.mRewardDes = (TextView) this.f441562d.findViewById(R.id.myc);
            this.mRewardBtn = (Button) this.f441562d.findViewById(R.id.myb);
            return;
        }
        QLog.e("QZoneAdRewardPresenter", 1, "[onInitView] error, containerView is null or container isn't RelativeLayout");
    }

    public void J(int i3, Bundle bundle) {
        a.C0468a.a(this, i3, bundle);
    }

    public void K(boolean z16, int i3) {
        a.C0468a.b(this, z16, i3);
    }

    public final void P() {
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        this.mAd = new GdtAd(qZoneAdFeedUtils.z(this.mQZoneActivity));
        this.mActivityInfo = qZoneAdFeedUtils.y(this.mQZoneActivity);
        View view = this.f441562d;
        if (view != null) {
            view.setVisibility(0);
        }
        L();
        M();
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.reward.a
    public void e() {
        String str;
        PBStringField pBStringField;
        String str2;
        PBStringField pBStringField2;
        Drawable background;
        Button button = this.mRewardBtn;
        GradientDrawable gradientDrawable = (GradientDrawable) ((button == null || (background = button.getBackground()) == null) ? null : background.mutate());
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setColors(new int[]{Color.parseColor("#C5C5C5"), Color.parseColor("#8A8A8A")});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        Button button2 = this.mRewardBtn;
        if (button2 != null) {
            vac_adv_get.Activity activity = this.mActivityInfo;
            if (activity == null || (pBStringField2 = activity.btn_after) == null || (str2 = pBStringField2.get()) == null) {
                str2 = "\u5df2\u9886\u53d6\u798f\u5229";
            }
            button2.setText(str2);
        }
        Button button3 = this.mRewardBtn;
        if (button3 != null) {
            button3.setTextColor(-1);
        }
        TextView textView = this.mRewardDes;
        if (textView == null) {
            return;
        }
        vac_adv_get.Activity activity2 = this.mActivityInfo;
        if (activity2 == null || (pBStringField = activity2.desc_after) == null || (str = pBStringField.get()) == null) {
            str = "";
        }
        textView.setText(str);
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
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdRewardPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mya /* 1745224872 */:
                case R.id.myb /* 1745224873 */:
                    f.f407629a.j("third_fulicard_button", "click");
                    ih.e eVar = ih.e.f407623a;
                    Activity mActivity = this.C;
                    Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                    eVar.j(mActivity, this.mQZoneActivity, new AdResultReceiver(new Handler(Looper.getMainLooper())), new a(), true, QZoneAdFeedDataExtKt.isRewardAdRealTimeRequest(this.f441565h));
                    break;
                case R.id.myg /* 1745224878 */:
                    f.f407629a.j("third_fulicard_exbutton", "click");
                    ih.e eVar2 = ih.e.f407623a;
                    Activity mActivity2 = this.C;
                    Intrinsics.checkNotNullExpressionValue(mActivity2, "mActivity");
                    eVar2.j(mActivity2, this.mQZoneActivity, new AdResultReceiver(new Handler(Looper.getMainLooper())), new a(), QZoneAdFeedUtils.f55717a.Y(this.mQZoneActivity), QZoneAdFeedDataExtKt.isRewardAdRealTimeRequest(this.f441565h));
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // vg.a
    protected int s() {
        return R.id.f162979nn4;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
