package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.picload.avatar.AvatarOption;
import com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarLoader;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleAvatarView extends FrameLayout {

    /* renamed from: g0, reason: collision with root package name */
    public static final String f92909g0;

    /* renamed from: h0, reason: collision with root package name */
    private static RFWMultiDownloadHelper f92910h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final int f92911i0;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private String U;
    private Size V;
    private Option W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f92912a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f92913b0;

    /* renamed from: c0, reason: collision with root package name */
    private final List<IPicLoadStateListener> f92914c0;

    /* renamed from: d, reason: collision with root package name */
    private QCircleRoundImageView f92915d;

    /* renamed from: d0, reason: collision with root package name */
    private IPicLoadStateListener f92916d0;

    /* renamed from: e, reason: collision with root package name */
    private SquareImageView f92917e;

    /* renamed from: e0, reason: collision with root package name */
    private View f92918e0;

    /* renamed from: f, reason: collision with root package name */
    private View f92919f;

    /* renamed from: f0, reason: collision with root package name */
    private HostStaticInvokeHelper.NetworkChangedObserver f92920f0;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f92921h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f92922i;

    /* renamed from: m, reason: collision with root package name */
    private int f92923m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements HostStaticInvokeHelper.NetworkChangedObserver {
        a() {
        }

        @Override // com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver
        public void onNetworkChanged(boolean z16) {
            if (z16) {
                QCircleAvatarView.this.f();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends QFSAsyncUtils.Callback<Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f92926a;

        b(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f92926a = feedCloudMeta$StUser;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doBackgroundAction(Void... voidArr) {
            return Integer.valueOf(QCirclePluginUtil.getAuthType(this.f92926a));
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(Integer num) {
            QCircleAvatarView.this.setIsAuth(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS) {
                QCircleAvatarView.this.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleAvatarView> f92930d;

        public e(QCircleAvatarView qCircleAvatarView) {
            this.f92930d = new WeakReference<>(qCircleAvatarView);
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            WeakReference<QCircleAvatarView> weakReference = this.f92930d;
            if (weakReference != null && weakReference.get() != null) {
                List<IPicLoadStateListener> m3 = this.f92930d.get().m();
                if (m3 != null) {
                    Iterator<IPicLoadStateListener> it = m3.iterator();
                    while (it.hasNext()) {
                        it.next().onStateChange(loadState, option);
                    }
                }
                QCircleAvatarView qCircleAvatarView = this.f92930d.get();
                if (qCircleAvatarView == null) {
                    return;
                }
                if (loadState.isFinishSuccess()) {
                    qCircleAvatarView.W = null;
                } else if (loadState.isFinishError()) {
                    qCircleAvatarView.W = option;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class f implements QCircleFaceBitmapListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QCircleAvatarView> f92931d;

        f(QCircleAvatarView qCircleAvatarView) {
            this.f92931d = new WeakReference<>(qCircleAvatarView);
        }

        @Override // com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener
        public void getFaceBitmap(Bitmap bitmap) {
            QCircleRoundImageView qCircleRoundImageView;
            QCircleAvatarView qCircleAvatarView = this.f92931d.get();
            QLog.d("QCircleAvatarView", 2, "getFaceBitmap bitmap=", bitmap, ",avatarView=", qCircleAvatarView);
            if (qCircleAvatarView != null && (qCircleRoundImageView = qCircleAvatarView.f92915d) != null && bitmap != null) {
                qCircleRoundImageView.setImageBitmap(bitmap);
            }
        }
    }

    static {
        String url = QCircleSkinHelper.getInstance().getUrl("qvideo_newvideo_tips");
        f92909g0 = url;
        RFWMultiDownloadHelper rFWMultiDownloadHelper = new RFWMultiDownloadHelper();
        f92910h0 = rFWMultiDownloadHelper;
        rFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask(url, com.tencent.biz.qqcircle.f.r()));
        f92910h0.start();
        f92911i0 = R.drawable.ntp;
    }

    public QCircleAvatarView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.T) {
            IPicLoadStateListener iPicLoadStateListener = this.f92916d0;
            if (iPicLoadStateListener == null || !this.f92914c0.contains(iPicLoadStateListener)) {
                c cVar = new c();
                this.f92916d0 = cVar;
                this.f92914c0.add(cVar);
                return;
            }
            return;
        }
        IPicLoadStateListener iPicLoadStateListener2 = this.f92916d0;
        if (iPicLoadStateListener2 != null) {
            this.f92914c0.remove(iPicLoadStateListener2);
            this.f92916d0 = null;
        }
    }

    private int j() {
        QCircleRoundImageView qCircleRoundImageView = this.f92915d;
        if (qCircleRoundImageView != null && qCircleRoundImageView.getHeight() != 0) {
            return this.f92915d.getHeight();
        }
        Size size = this.V;
        if (size != null) {
            return size.getHeight();
        }
        return 0;
    }

    private int l() {
        QCircleRoundImageView qCircleRoundImageView = this.f92915d;
        if (qCircleRoundImageView != null && qCircleRoundImageView.getWidth() != 0) {
            return this.f92915d.getWidth();
        }
        Size size = this.V;
        if (size != null) {
            return size.getWidth();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.S) {
            return;
        }
        this.S = true;
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f92915d, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        setBackground(getContext().getDrawable(f92911i0));
        ofFloat.addListener(new d(this));
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleAvatarView.3
            @Override // java.lang.Runnable
            public void run() {
                ofFloat.start();
            }
        });
    }

    public void d(IPicLoadStateListener iPicLoadStateListener) {
        if (iPicLoadStateListener != null && !this.f92914c0.contains(iPicLoadStateListener)) {
            this.f92914c0.add(iPicLoadStateListener);
        }
    }

    public void f() {
        Option option = this.W;
        if (option == null) {
            return;
        }
        if (option instanceof AvatarOption) {
            QCircleAvatarLoader.g().loadAvatar((AvatarOption) this.W, new e(this));
        } else {
            QCircleFeedPicLoader.g().loadImage(this.W, new e(this));
        }
        QLog.d("QCircleAvatarView", 1, "[checkIfNeedRetry]: true. mErrorOption = " + this.W);
    }

    public void g(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void h() {
        View view = this.f92919f;
        if (view != null) {
            removeView(view);
        }
    }

    public void i() {
        View view = this.f92919f;
        if (view != null) {
            removeView(view);
        }
    }

    public ImageView k() {
        return this.f92915d;
    }

    public List<IPicLoadStateListener> m() {
        return this.f92914c0;
    }

    protected void o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.V4);
        if (obtainStyledAttributes != null) {
            this.I = (int) obtainStyledAttributes.getDimension(y91.a.f449584a5, cx.a(24.0f));
            this.J = (int) obtainStyledAttributes.getDimension(y91.a.X4, cx.a(24.0f));
            this.f92923m = (int) obtainStyledAttributes.getDimension(y91.a.f449723l5, 0.0f);
            this.C = (int) obtainStyledAttributes.getDimension(y91.a.f449687i5, 0.0f);
            this.D = (int) obtainStyledAttributes.getDimension(y91.a.f449699j5, 2.14748365E9f);
            this.E = (int) obtainStyledAttributes.getDimension(y91.a.f449711k5, 2.14748365E9f);
            this.F = obtainStyledAttributes.getInteger(y91.a.f449675h5, 0);
            this.G = (int) obtainStyledAttributes.getDimension(y91.a.f449662g5, 0.0f);
            this.H = (int) obtainStyledAttributes.getDimension(y91.a.f449649f5, 0.0f);
            this.K = obtainStyledAttributes.getColor(y91.a.f449597b5, QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_avatar_frame));
            this.L = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449610c5, cx.a(0.5f));
            this.M = obtainStyledAttributes.getColor(y91.a.f449623d5, QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
            this.N = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449636e5, 0);
            this.P = obtainStyledAttributes.getBoolean(y91.a.W4, true);
            this.Q = (int) obtainStyledAttributes.getDimension(y91.a.Z4, 0.0f);
            this.R = (int) obtainStyledAttributes.getDimension(y91.a.Y4, 0.0f);
            this.T = obtainStyledAttributes.getBoolean(y91.a.f449735m5, false);
            obtainStyledAttributes.recycle();
        }
        this.f92915d = new QCircleRoundImageView(getContext(), null, 0);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f92915d.setLayoutParams(layoutParams);
        int screenHeight = DisplayUtil.getScreenHeight() / 2;
        QCircleRoundImageView qCircleRoundImageView = this.f92915d;
        if (screenHeight == 0) {
            screenHeight = 90;
        }
        qCircleRoundImageView.setRoundRect(screenHeight);
        this.f92915d.setBackgroundDrawable(null);
        addView(this.f92915d);
        setStrokes(this.L, this.K, this.N, this.M);
        View view = new View(context);
        this.f92919f = view;
        view.setLayoutParams(layoutParams);
        this.f92919f.setBackground(getResources().getDrawable(R.drawable.qcircle_skin_common_mask_selector));
        addView(this.f92919f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        q();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.S = false;
        if (this.f92912a0) {
            HostStaticInvokeHelper.removeNetworkChangeObserver(this.f92920f0);
            this.f92912a0 = false;
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (i3 == 0) {
            p();
        }
    }

    public void p() {
        if (!TextUtils.equals(QCircleCommonUtil.getCurrentAccount(), this.U)) {
            return;
        }
        String J0 = uq3.c.J0();
        QLog.d("QCircleAvatarView", 1, "[refreshOwnerAvatar] avatarUrl = " + J0 + ", mDefSize = " + this.V);
        if (!TextUtils.isEmpty(J0)) {
            setAvatarByUrl(J0, this.V);
        }
    }

    public void q() {
        if (!this.f92912a0) {
            HostStaticInvokeHelper.addNetworkChangedObserver(this.f92920f0);
            this.f92912a0 = true;
        }
    }

    public void setAvatar(FeedCloudMeta$StUser feedCloudMeta$StUser, Size size) {
        if (feedCloudMeta$StUser == null) {
            QLog.e("QCircleAvatarView", 1, "[setAvatar] user == null.");
            return;
        }
        this.U = feedCloudMeta$StUser.f398463id.get();
        this.V = size;
        String str = feedCloudMeta$StUser.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str)) {
            setAvatarByUrl(str, size);
        } else {
            if (TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get())) {
                return;
            }
            setAvatarByUin(feedCloudMeta$StUser.f398463id.get(), size);
        }
    }

    public void setAvatarByUin(String str, Size size) {
        if (this.f92915d == null) {
            QLog.e("QCircleAvatarView", 1, "[setAvatarByUin] avatar == null.");
            return;
        }
        this.U = str;
        this.V = size;
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(str);
        if (!QCirclePluginUtil.isOwner(feedCloudMeta$StUser) && uq3.c.p7()) {
            int width = this.f92915d.getWidth();
            int height = this.f92915d.getHeight();
            if (width == 0 && size != null) {
                width = size.getWidth();
            }
            if (height == 0 && size != null) {
                height = size.getHeight();
            }
            AvatarOption uin = new AvatarOption().setUin(str);
            Option targetView = uin.setTargetView(this.f92915d);
            com.tencent.biz.qqcircle.immersive.manager.d c16 = com.tencent.biz.qqcircle.immersive.manager.d.c();
            int i3 = f92911i0;
            targetView.setLoadingDrawable(c16.d(i3)).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(i3)).setFromPreLoad(false);
            uin.setRequestWidth(width);
            uin.setRequestHeight(height);
            e();
            QCircleAvatarLoader.g().loadAvatar(uin, new e(this));
            return;
        }
        this.f92915d.setImageDrawable(QCirclePluginGlobalInfo.s(str, new f(this)));
        this.f92915d.setTag(R.id.qcircle_avatar_tag_id, str);
        n();
    }

    public void setAvatarByUrl(String str, Size size) {
        this.V = size;
        if (this.f92915d == null) {
            QLog.e("QCircleAvatarView", 1, "[setAvatarByUrl] avatar == null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int width = this.f92915d.getWidth();
        int height = this.f92915d.getHeight();
        if (width == 0 && size != null) {
            width = size.getWidth();
        }
        if (height == 0 && size != null) {
            height = size.getHeight();
        }
        Drawable d16 = com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.ntp);
        Option obtain = Option.obtain();
        if (!TextUtils.isEmpty(this.U) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101721", true)) {
            LibraGroupKey libraGroupKey = new LibraGroupKey(this.U);
            libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
            obtain.setGroupKey(libraGroupKey);
        }
        obtain.setTargetView(this.f92915d);
        obtain.setUrl(str);
        if (!this.f92913b0) {
            obtain.disableHardwareDecode();
        }
        obtain.setRequestWidth(width);
        obtain.setRequestHeight(height);
        obtain.setFailDrawable(d16);
        obtain.setLoadingDrawable(d16);
        e();
        QCircleFeedPicLoader.g().loadImage(obtain, new e(this));
        this.f92915d.setTag(R.id.qcircle_avatar_tag_id, str);
    }

    public void setImageNeedHardware(boolean z16) {
        this.f92913b0 = z16;
    }

    public void setIsAuth(int i3) {
        int i16;
        if (this.f92917e == null) {
            this.f92917e = new SquareImageView(getContext(), null, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.I, this.J);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = this.Q;
            layoutParams.bottomMargin = this.R;
            this.f92917e.setLayoutParams(layoutParams);
            this.f92917e.setRoundRect(90);
            SquareImageView squareImageView = this.f92917e;
            if (this.P) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            squareImageView.setVisibility(i16);
            super.addView(this.f92917e);
        }
        if (this.P && i3 != 0) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(com.tencent.biz.qqcircle.immersive.utils.p.c(i3)).setRequestWidth(this.I).setRequestHeight(this.J).setTargetView(this.f92917e));
            this.f92917e.setVisibility(0);
            return;
        }
        this.f92917e.setVisibility(8);
    }

    public void setLivingStatus(boolean z16) {
        if (!z16) {
            setLivingStatusVisible(false);
            return;
        }
        if (this.f92921h == null) {
            int i3 = this.G;
            int i16 = this.H;
            if (i3 == 0) {
                i3 = (int) (l() * 1.5417f);
            }
            if (i16 == 0) {
                i16 = (int) (j() * 1.5417f);
            }
            this.f92921h = new ImageView(getContext(), null, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
            layoutParams.gravity = 17;
            this.f92921h.setLayoutParams(layoutParams);
            Option failedDrawableColor = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_live_circle_diffusion")).setTargetView(this.f92921h).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawableColor(0).setFailedDrawableColor(0);
            if (!this.f92913b0) {
                failedDrawableColor.disableHardwareDecode();
            }
            QCircleFeedPicLoader.g().loadImage(failedDrawableColor);
            super.addView(this.f92921h);
        }
        if (this.f92922i == null) {
            this.f92922i = new ImageView(getContext(), null, 0);
            int i17 = this.f92923m;
            int i18 = this.C;
            if (i17 == 0) {
                i17 = (int) (l() * 0.6042f);
                i18 = (int) (i17 * 0.4286f);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i17, i18);
            int i19 = this.F;
            if (i19 == 0) {
                layoutParams2.gravity = 81;
                int i26 = this.D;
                if (i26 == Integer.MAX_VALUE) {
                    i26 = (i18 / 3) * (-1);
                }
                layoutParams2.bottomMargin = i26;
            } else if (i19 == 1) {
                layoutParams2.gravity = 49;
                int i27 = this.E;
                if (i27 == Integer.MAX_VALUE) {
                    i27 = (i18 / 2) * (-1);
                }
                layoutParams2.topMargin = i27;
            }
            this.f92922i.setLayoutParams(layoutParams2);
            Option failedDrawableColor2 = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_live_zhibozhong_noboarder")).setTargetView(this.f92922i).setRequestWidth(i17).setRequestHeight(i18).setLoadingDrawableColor(0).setFailedDrawableColor(0);
            if (!this.f92913b0) {
                failedDrawableColor2.disableHardwareDecode();
            }
            QCircleFeedPicLoader.g().loadImage(failedDrawableColor2);
            super.addView(this.f92922i);
        }
        setLivingStatusVisible(true);
    }

    public void setLivingStatusVisible(boolean z16) {
        int i3;
        ImageView imageView = this.f92922i;
        if (imageView != null && this.f92921h != null) {
            int i16 = 0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            ImageView imageView2 = this.f92921h;
            if (!z16) {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
        }
    }

    public void setShowAuthIcon(boolean z16) {
        this.P = z16;
    }

    public void setStrokes(int i3, @ColorInt int i16, int i17, @ColorInt int i18) {
        this.L = i3;
        this.K = i16;
        this.N = i17;
        this.M = i18;
        if (i3 == 0 && i17 == 0) {
            View view = this.f92918e0;
            if (view != null) {
                view.setBackground(null);
                return;
            }
            return;
        }
        if (this.f92918e0 == null) {
            this.f92918e0 = new View(getContext());
            this.f92918e0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.f92918e0);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(this.L, this.K);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setStroke(this.N, this.M);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        int i19 = this.N;
        layerDrawable.setLayerInset(0, i19, i19, i19, i19);
        this.f92918e0.setBackground(layerDrawable);
    }

    public void setUser(FeedCloudMeta$StUser feedCloudMeta$StUser, Size size) {
        if (feedCloudMeta$StUser == null) {
            return;
        }
        setAvatar(feedCloudMeta$StUser, size);
        if (feedCloudMeta$StUser.busiData.has()) {
            QFSAsyncUtils.executeSub(new b(feedCloudMeta$StUser), new Void[0]);
        }
    }

    public QCircleAvatarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleAvatarView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.S = false;
        this.T = false;
        this.f92912a0 = false;
        this.f92913b0 = true;
        this.f92914c0 = new ArrayList();
        this.f92920f0 = new a();
        o(context, attributeSet);
    }

    public void setAvatar(String str, String str2, Size size) {
        this.U = str2;
        this.V = size;
        if (!TextUtils.isEmpty(str)) {
            setAvatarByUrl(str, size);
        } else {
            setAvatarByUin(str2, size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<View> f92929d;

        public d(View view) {
            this.f92929d = new WeakReference<>(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WeakReference<View> weakReference = this.f92929d;
            if (weakReference != null && weakReference.get() != null) {
                this.f92929d.get().setBackground(null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
