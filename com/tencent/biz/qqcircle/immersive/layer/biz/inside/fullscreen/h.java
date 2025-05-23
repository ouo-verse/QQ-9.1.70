package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFLiuHaiUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends com.tencent.biz.qqcircle.bizparts.b implements QCircleAlbumSlidBottomView.c {
    private static final int F = cx.a(6.0f);

    /* renamed from: d, reason: collision with root package name */
    protected View f86602d;

    /* renamed from: e, reason: collision with root package name */
    protected View f86603e;

    /* renamed from: f, reason: collision with root package name */
    protected View f86604f;

    /* renamed from: h, reason: collision with root package name */
    protected QCircleAlbumSlidBottomView f86605h;

    /* renamed from: i, reason: collision with root package name */
    private int f86606i = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f86607m = 0;
    private String C = "";
    private int D = 0;
    private int E = 0;

    private String A9() {
        return bj.g(z9());
    }

    private int B9() {
        int i3;
        Window window;
        int i16 = 0;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(getContext()) - 1;
        } else {
            i3 = 0;
        }
        if ((getContext() instanceof Activity) && RFLiuHaiUtils.enableNotch((Activity) getContext())) {
            RFLiuHaiUtils.initLiuHaiBarHeight((Activity) getContext());
            i16 = RFLiuHaiUtils.liuHaiTopBarHeight();
        }
        View view = null;
        if ((getContext() instanceof Activity) && (window = ((Activity) getContext()).getWindow()) != null) {
            view = window.getDecorView();
        }
        if (view != null) {
            return Math.max(view.getMeasuredHeight(), view.getMeasuredWidth());
        }
        return Math.max(ImmersiveUtils.getScreenHeight(), ImmersiveUtils.getScreenWidth()) + Math.max(i3, i16) + DisplayUtil.getNavigationBarHeight(getContext());
    }

    private boolean E9() {
        return !TextUtils.equals(A9(), this.C);
    }

    private void F9(View view, int i3, int i16, int i17) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            QLog.d(getLogTag(), 1, "[setViewSize] params not is FrameLayout#LayoutParams, set size fail return.");
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        layoutParams2.rightMargin = i17;
        layoutParams2.gravity = 17;
        view.setLayoutParams(layoutParams2);
    }

    private void initListener() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.f86605h;
        if (qCircleAlbumSlidBottomView == null) {
            return;
        }
        qCircleAlbumSlidBottomView.c(this);
    }

    private float x9() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        FeedCloudMeta$StFeed z95 = z9();
        if (z95 != null && (feedCloudMeta$StVideo = z95.video) != null && feedCloudMeta$StVideo.width.get() > 0 && z95.video.height.get() > 0) {
            return z95.video.width.get() / z95.video.height.get();
        }
        return 1.0f;
    }

    private FeedCloudMeta$StFeed z9() {
        QFSVideoView qFSVideoView;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            qFSVideoView = null;
        } else {
            qFSVideoView = weakReference.get();
        }
        if (qFSVideoView == null) {
            return null;
        }
        return qFSVideoView.getData();
    }

    @IdRes
    protected int C9() {
        return R.id.f30700p2;
    }

    protected void D9(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.f86605h;
        if (qCircleAlbumSlidBottomView != null && qCircleAlbumSlidBottomView.getVisibility() == 0) {
            if (E9()) {
                return;
            }
            float g16 = this.f86605h.g() - this.D;
            float h16 = i3 - this.f86605h.h();
            float abs = Math.abs(this.f86605h.h()) + Math.abs(this.f86605h.i());
            float f18 = h16 / abs;
            float x95 = x9();
            int i19 = this.f86606i;
            float f19 = (((this.E * 2) + i19) - g16) / i19;
            float f26 = 1.0f - ((1.0f - f19) * f18);
            if (x95 <= 1.0f) {
                f16 = i19 * f26;
                f17 = this.f86607m;
            } else {
                f16 = i19 * f26;
                f17 = this.f86607m * f26;
            }
            int i26 = (int) f16;
            int i27 = (int) f17;
            int i28 = (int) ((g16 * f18) / 2.0f);
            F9(this.f86602d, i26, i27, i28);
            F9(this.f86603e, i26, i27, 0);
            F9(this.f86604f, i26, i27, 0);
            QLog.d(getLogTag(), 4, "[handlerScrollChange] scrollX: " + i3 + " | currentScrollX: " + h16 + " | scrollSumOffset: " + abs + " | currentScrollScale: " + f18 + " | videoViewToPanelScale: " + f19 + " | currentScale: " + f26 + " | layoutParams.height: " + i27 + " | layoutParams.width: " + i26 + " | layoutParams.rightMargin: " + i28 + " | videoViewOffset: " + g16 + " | mRightMargin: " + this.D + " | panelSize: " + this.f86605h.g());
            return;
        }
        QLog.d(getLogTag(), 1, "[handlerScrollChange] current slide view param illegality.");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "VFS-QFSSlideFullScreenAlbumAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
    public void onDismiss() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f86602d;
        if (view == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (!(layoutParams instanceof ViewGroup.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f86602d.getLayoutParams();
        if (E9()) {
            layoutParams2.rightMargin = 0;
            this.f86602d.setLayoutParams(layoutParams2);
            return;
        }
        F9(this.f86602d, this.f86606i, this.f86607m, 0);
        F9(this.f86603e, this.f86606i, this.f86607m, 0);
        F9(this.f86604f, this.f86606i, this.f86607m, 0);
        QLog.d(getLogTag(), 1, "[onDismiss] update params, mVideoViewWidth: " + layoutParams2.width + " | mVideoViewWidth: " + layoutParams2.height + " | rightMargin: " + layoutParams2.rightMargin + " | mSlideFeedId: " + this.C);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f86605h = (QCircleAlbumSlidBottomView) view.findViewById(C9());
        initListener();
    }

    @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        try {
            D9(i3, i16, i17, i18);
        } catch (Throwable th5) {
            QLog.e(getLogTag(), 1, "[onScrollChanged] ex: ", th5);
        }
    }

    @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
    public void onShow() {
        QFSVideoView qFSVideoView;
        Object parent;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        ViewParent viewParent = null;
        if (weakReference == null) {
            qFSVideoView = null;
        } else {
            qFSVideoView = weakReference.get();
        }
        if (qFSVideoView == null) {
            parent = null;
        } else {
            parent = qFSVideoView.getParent();
        }
        if (parent instanceof ViewGroup) {
            viewParent = ((View) parent).getParent();
        }
        if (!(viewParent instanceof ViewGroup)) {
            QLog.e(getLogTag(), 1, "[onShow] item view should not is view group, end flow.");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        this.f86602d = viewGroup.findViewById(R.id.f42781kp);
        this.f86603e = viewGroup.findViewById(R.id.f74163vi);
        this.f86604f = viewGroup.findViewById(R.id.v_z);
        View view = this.f86602d;
        if (view == null) {
            QLog.d(getLogTag(), 1, "[onShow] current slide view is null, end flow.");
            return;
        }
        this.f86606i = view.getWidth();
        this.f86607m = this.f86602d.getHeight();
        this.C = bj.g(qFSVideoView.getData());
        int B9 = B9() + F;
        int min = Math.min(ImmersiveUtils.getScreenHeight(), ImmersiveUtils.getScreenWidth());
        int max = Math.max(ImmersiveUtils.getScreenHeight(), ImmersiveUtils.getScreenWidth());
        this.D = (B9 - max) / 2;
        this.E = (max - this.f86606i) / 2;
        QLog.d(getLogTag(), 1, "[onShow] mFullScreenSlideWidth: " + this.f86606i + " | mFullScreenSlideHeight: " + this.f86607m + " | mRightMargin: " + this.D + " | mSlideFeedId: " + this.C + " | screenWidth: " + B9 + " | screenHeight: " + min);
    }
}
