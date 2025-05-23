package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRecommendNoneView extends BaseWidgetView<FeedCloudMeta$StFeed> {
    private ImageView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private LinearLayout I;
    private View J;
    private b K;
    private LoadImageFileTask L;
    private c M;
    private a N;
    private int P;
    private int Q;
    private int R;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class LoadImageFileTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleRecommendNoneView> f96382d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<ImageView> f96383e;

        /* renamed from: f, reason: collision with root package name */
        private String f96384f;

        public LoadImageFileTask(QCircleRecommendNoneView qCircleRecommendNoneView, ImageView imageView, String str) {
            this.f96382d = new WeakReference<>(qCircleRecommendNoneView);
            this.f96383e = new WeakReference<>(imageView);
            this.f96384f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleRecommendNoneView qCircleRecommendNoneView;
            WeakReference<QCircleRecommendNoneView> weakReference = this.f96382d;
            ImageView imageView = null;
            if (weakReference == null) {
                qCircleRecommendNoneView = null;
            } else {
                qCircleRecommendNoneView = weakReference.get();
            }
            if (qCircleRecommendNoneView == null) {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[run] recommend none view should not be null.");
                return;
            }
            WeakReference<ImageView> weakReference2 = this.f96383e;
            if (weakReference2 != null) {
                imageView = weakReference2.get();
            }
            qCircleRecommendNoneView.F(imageView, this.f96384f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class UpdateImageFilePathTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleRecommendNoneView> f96385d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<ImageView> f96386e;

        /* renamed from: f, reason: collision with root package name */
        private String f96387f;

        public UpdateImageFilePathTask(QCircleRecommendNoneView qCircleRecommendNoneView, ImageView imageView, String str) {
            this.f96385d = new WeakReference<>(qCircleRecommendNoneView);
            this.f96386e = new WeakReference<>(imageView);
            this.f96387f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleRecommendNoneView qCircleRecommendNoneView;
            WeakReference<QCircleRecommendNoneView> weakReference = this.f96385d;
            ImageView imageView = null;
            if (weakReference == null) {
                qCircleRecommendNoneView = null;
            } else {
                qCircleRecommendNoneView = weakReference.get();
            }
            if (qCircleRecommendNoneView == null) {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[run] recommend none view should not be null.");
                return;
            }
            WeakReference<ImageView> weakReference2 = this.f96386e;
            if (weakReference2 != null) {
                imageView = weakReference2.get();
            }
            qCircleRecommendNoneView.B(imageView, this.f96387f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleRecommendNoneView> f96388d;

        /* renamed from: e, reason: collision with root package name */
        private String f96389e;

        public a(QCircleRecommendNoneView qCircleRecommendNoneView, String str) {
            this.f96388d = new WeakReference<>(qCircleRecommendNoneView);
            this.f96389e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QCircleRecommendNoneView qCircleRecommendNoneView;
            EventCollector.getInstance().onViewClickedBefore(view);
            WeakReference<QCircleRecommendNoneView> weakReference = this.f96388d;
            if (weakReference == null) {
                qCircleRecommendNoneView = null;
            } else {
                qCircleRecommendNoneView = weakReference.get();
            }
            if (qCircleRecommendNoneView != null) {
                qCircleRecommendNoneView.A(this.f96389e);
            } else {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[onClick] none view should not be null.");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b extends QFSAsyncUtils.Callback<Void, QQCircleDitto$StItemContainer> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QCircleRecommendNoneView> f96390a;

        /* renamed from: b, reason: collision with root package name */
        private FeedCloudMeta$StFeed f96391b;

        public b(QCircleRecommendNoneView qCircleRecommendNoneView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f96390a = new WeakReference<>(qCircleRecommendNoneView);
            this.f96391b = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQCircleDitto$StItemContainer doBackgroundAction(Void... voidArr) {
            FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed;
            PBBytesField pBBytesField;
            ByteStringMicro byteStringMicro;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f96391b;
            if (feedCloudMeta$StFeed == null) {
                feedCloudMeta$StDittoFeed = null;
            } else {
                feedCloudMeta$StDittoFeed = feedCloudMeta$StFeed.dittoFeed;
            }
            if (feedCloudMeta$StDittoFeed == null) {
                pBBytesField = null;
            } else {
                pBBytesField = feedCloudMeta$StDittoFeed.dittoDataNew;
            }
            if (pBBytesField == null) {
                byteStringMicro = null;
            } else {
                byteStringMicro = pBBytesField.get();
            }
            if (byteStringMicro == null) {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[doBackgroundAction] byte data field should not be null.");
                return null;
            }
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
            try {
                qQCircleDitto$StCircleDittoDataNew.mergeFrom(byteStringMicro.toByteArray());
            } catch (Throwable th5) {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[bindData] error: ", th5);
            }
            return qQCircleDitto$StCircleDittoDataNew.itemContainter;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
            QCircleRecommendNoneView qCircleRecommendNoneView;
            WeakReference<QCircleRecommendNoneView> weakReference = this.f96390a;
            if (weakReference == null) {
                qCircleRecommendNoneView = null;
            } else {
                qCircleRecommendNoneView = weakReference.get();
            }
            if (qCircleRecommendNoneView != null) {
                qCircleRecommendNoneView.G(qQCircleDitto$StItemContainer);
            } else {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[doMainAction] recommend none view should not be null.");
            }
        }
    }

    public QCircleRecommendNoneView(@NonNull @android.support.annotation.NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
    }

    private void D(@android.support.annotation.NonNull QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        QQCircleDitto$StButton qQCircleDitto$StButton;
        String str;
        if (this.J == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateButtonInfo] button layout should not be null.");
            return;
        }
        if (this.H == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateButtonInfo] button view should not be null.");
            return;
        }
        PBRepeatMessageField<QQCircleDitto$StItemInfo> pBRepeatMessageField = qQCircleDitto$StItemContainer.items;
        if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
            QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = qQCircleDitto$StItemContainer.items.get(0);
            String str2 = null;
            if (qQCircleDitto$StItemInfo == null) {
                qQCircleDitto$StButton = null;
            } else {
                qQCircleDitto$StButton = qQCircleDitto$StItemInfo.buttonInfo;
            }
            if (qQCircleDitto$StButton == null) {
                str = null;
            } else {
                str = qQCircleDitto$StButton.name.get();
            }
            if (qQCircleDitto$StButton != null) {
                str2 = qQCircleDitto$StButton.jumpUrl.get();
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                I(this.J, 0);
                this.H.setText(qQCircleDitto$StButton.name.get());
                a aVar = new a(this, qQCircleDitto$StButton.jumpUrl.get());
                this.N = aVar;
                this.J.setOnClickListener(aVar);
                return;
            }
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateButtonInfo] ditto buttonName: " + str + " | jumpUrl: " + str2 + ", update invalid.");
            I(this.J, 8);
            return;
        }
        QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateButtonInfo] item container items not is empty.");
        I(this.J, 8);
    }

    private void E(ImageView imageView, String str) {
        String url = ((IQCircleSkinHelperApi) QRoute.api(IQCircleSkinHelperApi.class)).getUrl(str);
        QLog.d("SCF-QCircleRecommendNoneView", 1, "[updateCoverView] url: ", url);
        C(imageView, url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ImageView imageView, String str) {
        if (imageView == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateImageDrawable] image view should not be null.");
            return;
        }
        imageView.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.ajr));
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRequestWidth = imageView.getMeasuredWidth();
        obtain.mRequestHeight = imageView.getMeasuredHeight();
        QLog.d("SCF-QCircleRecommendNoneView", 1, "options.mRequestWidth =" + obtain.mRequestWidth + "options.mRequestHeight =" + obtain.mRequestHeight);
        imageView.setImageDrawable(URLDrawable.getFileDrawable(str, obtain));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        String str;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateItemInfo] item container should not be null.");
            return;
        }
        E(this.E, "qvideo_emptystate_img_nocontent");
        TextView textView = this.F;
        PBStringField pBStringField = qQCircleDitto$StItemContainer.title;
        String str2 = null;
        if (pBStringField == null) {
            str = null;
        } else {
            str = pBStringField.get();
        }
        H(textView, str);
        TextView textView2 = this.G;
        PBStringField pBStringField2 = qQCircleDitto$StItemContainer.subTitle;
        if (pBStringField2 != null) {
            str2 = pBStringField2.get();
        }
        H(textView2, str2);
        D(qQCircleDitto$StItemContainer);
        w(this.E, this.P, QCircleDaTongConstant.ElementId.EM_FOLLOW_EMPTY_MORE_PIC, z(qQCircleDitto$StItemContainer));
        w(this.J, this.P, QCircleDaTongConstant.ElementId.EM_FOLLOW_EMPTY_MORE_BTN, z(qQCircleDitto$StItemContainer));
    }

    private void H(TextView textView, String str) {
        if (textView == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateTextView] view should not be null.");
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateTextView] text should not be null.");
        } else {
            textView.setText(str);
        }
    }

    private void I(View view, int i3) {
        if (view == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[updateViewVisible] view should not be null.");
        } else if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private void w(View view, int i3, String str, String str2) {
        String str3;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (i3 == 46) {
            VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_DYH_EXPLORE_PAGE);
        } else if (i3 == 45) {
            VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_DYH_FOLLOWING_PAGE);
        }
        FeedCloudMeta$StFeed f16 = f();
        String str4 = "";
        if (f16 == null || (pBStringField2 = f16.f398449id) == null) {
            str3 = "";
        } else {
            str3 = pBStringField2.get();
        }
        if (f16 != null && (feedCloudMeta$StUser = f16.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str4 = pBStringField.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.R + 1));
        buildElementParams.put("xsj_feed_id", str3);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str4);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str2);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.DYH_FEED_NUM, Integer.valueOf(this.Q));
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void x(Context context) {
        Resources resources;
        int i3;
        int i16;
        if (context == null) {
            resources = null;
        } else {
            resources = context.getResources();
        }
        if (resources == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[changeStyleColor] resources should not be null.");
            return;
        }
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (isNowThemeIsNight) {
            i3 = R.color.f157724cb0;
        } else {
            i3 = R.color.caz;
        }
        int color = resources.getColor(i3);
        this.F.setTextColor(color);
        this.G.setTextColor(color);
        QLog.e("SCF-QCircleRecommendNoneView", 1, "[changeStyleColor] isInNightMode: " + isNowThemeIsNight);
        if (isNowThemeIsNight) {
            i16 = R.drawable.llt;
        } else {
            i16 = R.drawable.llu;
        }
        this.I.setBackground(resources.getDrawable(i16));
    }

    private String z(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        PBRepeatMessageField<QQCircleDitto$StItemInfo> pBRepeatMessageField;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo;
        QQCircleDitto$StButton qQCircleDitto$StButton;
        PBStringField pBStringField;
        if (qQCircleDitto$StItemContainer == null || (pBRepeatMessageField = qQCircleDitto$StItemContainer.items) == null || pBRepeatMessageField.isEmpty() || (qQCircleDitto$StItemInfo = qQCircleDitto$StItemContainer.items.get(0)) == null || (qQCircleDitto$StButton = qQCircleDitto$StItemInfo.buttonInfo) == null || (pBStringField = qQCircleDitto$StButton.jumpUrl) == null) {
            return "";
        }
        return pBStringField.get();
    }

    protected void B(ImageView imageView, String str) {
        QLog.d("SCF-QCircleRecommendNoneView", 1, "[setImageFilePath] imageView: " + imageView + " | filePath: " + str);
        this.L = new LoadImageFileTask(this, imageView, str);
        RFWThreadManager.getUIHandler().post(this.L);
    }

    protected void C(ImageView imageView, String str) {
        String y16 = y(str);
        if (RFWDownloaderFactory.getDownloader(f.r()).isFileDownLoading(str)) {
            return;
        }
        if (new File(y16).exists()) {
            B(imageView, y16);
        } else {
            this.M = new c(this, imageView);
            RFWDownloaderFactory.getDownloader(f.r()).download(str, this.M);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.e1i;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        if (view == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[rootView] should not be null.");
            return;
        }
        if (context == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[onInitView] content should not be null.");
            return;
        }
        this.E = (ImageView) view.findViewById(R.id.tqr);
        this.F = (TextView) view.findViewById(R.id.tqy);
        this.G = (TextView) view.findViewById(R.id.tqq);
        this.H = (TextView) view.findViewById(R.id.tqp);
        this.J = view.findViewById(R.id.tqo);
        this.I = (LinearLayout) view.findViewById(R.id.tqs);
        x(context);
    }

    public void setDataSize(int i3) {
        this.Q = i3;
    }

    public void setPosition(int i3) {
        this.R = i3;
    }

    public void setSourceType(int i3) {
        this.P = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[bindData] feed should not be null.");
            return;
        }
        b bVar = new b(this, feedCloudMeta$StFeed);
        this.K = bVar;
        QFSAsyncUtils.executeSub(bVar, new Void[0]);
    }

    protected String y(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("SCF-QCircleRecommendNoneView", 1, "[getImagePath] url should not be null.");
            return "";
        }
        return RFWDownloaderFactory.getDownloader(f.r()).getDefaultSavePath(str);
    }

    public QCircleRecommendNoneView(@NonNull @android.support.annotation.NonNull Context context, @Nullable @android.support.annotation.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCircleRecommendNoneView(@NonNull @android.support.annotation.NonNull Context context, @Nullable @android.support.annotation.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleRecommendNoneView> f96392d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<ImageView> f96393e;

        /* renamed from: f, reason: collision with root package name */
        private UpdateImageFilePathTask f96394f;

        public c(QCircleRecommendNoneView qCircleRecommendNoneView, ImageView imageView) {
            this.f96392d = new WeakReference<>(qCircleRecommendNoneView);
            this.f96393e = new WeakReference<>(imageView);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            QCircleRecommendNoneView qCircleRecommendNoneView;
            if (!z16) {
                QLog.e("SCF-QCircleRecommendNoneView", 1, "[onRspCallback] download load image fail, filePath: " + str);
                return;
            }
            WeakReference<QCircleRecommendNoneView> weakReference = this.f96392d;
            ImageView imageView = null;
            if (weakReference == null) {
                qCircleRecommendNoneView = null;
            } else {
                qCircleRecommendNoneView = weakReference.get();
            }
            WeakReference<ImageView> weakReference2 = this.f96393e;
            if (weakReference2 != null) {
                imageView = weakReference2.get();
            }
            this.f96394f = new UpdateImageFilePathTask(qCircleRecommendNoneView, imageView, str);
            RFWThreadManager.getUIHandler().post(this.f96394f);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
