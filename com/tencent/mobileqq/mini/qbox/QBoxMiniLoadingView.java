package com.tencent.mobileqq.mini.qbox;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.mini.api.IMiniCustomViewService;
import com.tencent.mobileqq.mini.api.ui.ICustomMiniLoadingView;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/mini/qbox/QBoxMiniLoadingView;", "Lcom/tencent/qqmini/sdk/launcher/ui/BaseGameLoadingView;", "Lcom/tencent/mobileqq/mini/api/ui/ICustomMiniLoadingView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAnimConfigChangeRunnable", "Ljava/lang/Runnable;", "mLoadingIcon", "Landroid/widget/ImageView;", "mStartTimeOutRunnable", "mTitleView", "Landroid/widget/TextView;", "doRealHide", "", "hide", "init", "initUIData", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "loadAnim", "quitGame", "requestHideFromJavaScript", "setProgressInt", "v", "", "setProgressTxt", ReportConstant.COSTREPORT_PREFIX, "", "show", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QBoxMiniLoadingView extends BaseGameLoadingView implements ICustomMiniLoadingView {
    private static final String DEFAULT_ANIM_URL = "https://downv6.qq.com/innovate/guild/cover_info/qbox_loading.png";
    private static final long LOADING_TIME_OUT = 30000;
    private static final String TAG = "QBoxMiniLoadingView";
    private final Runnable mAnimConfigChangeRunnable;
    private ImageView mLoadingIcon;
    private final Runnable mStartTimeOutRunnable;
    private TextView mTitleView;

    public QBoxMiniLoadingView(Context context) {
        super(context);
        this.mAnimConfigChangeRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.a
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.mAnimConfigChangeRunnable$lambda$1(QBoxMiniLoadingView.this);
            }
        };
        this.mStartTimeOutRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.b
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.mStartTimeOutRunnable$lambda$3(QBoxMiniLoadingView.this);
            }
        };
        init();
    }

    private final void init() {
        ((IMiniCustomViewService) QRoute.api(IMiniCustomViewService.class)).registerMetaRoomLoadingView(this);
        setBackgroundColor(-1);
        LayoutInflater.from(getContext()).inflate(R.layout.dkr, this);
        View findViewById = findViewById(R.id.rlx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.txt_loading_title)");
        this.mTitleView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.re5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.img_qbox_loading_icon)");
        this.mLoadingIcon = (ImageView) findViewById2;
        loadAnim();
        findViewById(R.id.f163675re2).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.qbox.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QBoxMiniLoadingView.init$lambda$0(QBoxMiniLoadingView.this, view);
            }
        });
        setProgressInt(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(QBoxMiniLoadingView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.quitGame();
    }

    private final void loadAnim() {
        QBoxConfBean qBoxConfBean = (QBoxConfBean) am.s().x(QBoxConfProcessor.TASK_TYPE_ID);
        ImageView imageView = this.mLoadingIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIcon");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = Utils.n(qBoxConfBean.getWidthDP(), getResources());
        layoutParams.height = Utils.n(qBoxConfBean.getHeightDP(), getResources());
        ImageView imageView3 = this.mLoadingIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIcon");
            imageView3 = null;
        }
        imageView3.setLayoutParams(layoutParams);
        String loadingAnimUrl = qBoxConfBean.getLoadingAnimUrl();
        if (loadingAnimUrl == null || loadingAnimUrl.length() == 0) {
            QLog.w(TAG, 1, "config url is empty");
            loadingAnimUrl = DEFAULT_ANIM_URL;
        }
        QLog.d(TAG, 1, "anim url is " + loadingAnimUrl + ", width is " + qBoxConfBean.getWidthDP() + ", height is " + qBoxConfBean.getHeightDP() + " ");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        Drawable drawable = MiniAppUtils.getDrawable(loadingAnimUrl, obtain);
        ImageView imageView4 = this.mLoadingIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIcon");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAnimConfigChangeRunnable$lambda$1(QBoxMiniLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "AnimConfigChanged");
        if (this$0.getVisibility() != 0) {
            return;
        }
        this$0.loadAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStartTimeOutRunnable$lambda$3(QBoxMiniLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(TAG, 1, "loadingTimeout cost");
        this$0.doRealHide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestHideFromJavaScript$lambda$2(QBoxMiniLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doRealHide();
    }

    private final void quitGame() {
        QLog.d(TAG, 1, "quitGame");
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
        removeCallbacks(this.mStartTimeOutRunnable);
    }

    @Override // com.tencent.mobileqq.mini.api.ui.ICustomMiniLoadingView
    public void requestHideFromJavaScript() {
        QLog.d(TAG, 1, "requestHideFromJavaScript");
        post(new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.c
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.requestHideFromJavaScript$lambda$2(QBoxMiniLoadingView.this);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void show(ViewGroup viewGroup) {
        QLog.d(TAG, 1, "show");
        setVisibility(0);
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
        postDelayed(this.mStartTimeOutRunnable, 30000L);
    }

    private final void doRealHide() {
        setVisibility(8);
        removeCallbacks(this.mStartTimeOutRunnable);
    }

    public QBoxMiniLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimConfigChangeRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.a
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.mAnimConfigChangeRunnable$lambda$1(QBoxMiniLoadingView.this);
            }
        };
        this.mStartTimeOutRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.b
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.mStartTimeOutRunnable$lambda$3(QBoxMiniLoadingView.this);
            }
        };
        init();
    }

    public QBoxMiniLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAnimConfigChangeRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.a
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.mAnimConfigChangeRunnable$lambda$1(QBoxMiniLoadingView.this);
            }
        };
        this.mStartTimeOutRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.qbox.b
            @Override // java.lang.Runnable
            public final void run() {
                QBoxMiniLoadingView.mStartTimeOutRunnable$lambda$3(QBoxMiniLoadingView.this);
            }
        };
        init();
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void hide() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public BaseGameLoadingView initUIData(MiniAppInfo miniAppInfo) {
        return this;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void setProgressInt(float v3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView
    public void setProgressTxt(String s16) {
    }
}
