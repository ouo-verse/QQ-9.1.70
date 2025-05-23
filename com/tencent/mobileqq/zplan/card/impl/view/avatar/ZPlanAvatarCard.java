package com.tencent.mobileqq.zplan.card.impl.view.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.card.impl.view.avatar.ZPlanAvatarCard;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.avatar.b;
import com.tencent.sqshow.zootopia.avatar.c;
import com.tencent.sqshow.zootopia.avatar.f;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oa4.a;
import rf3.e;
import rf3.g;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB/\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010]\u001a\u00020\u001c\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0015J\b\u0010\u0010\u001a\u00020\u0003H\u0014J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017J \u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u000e\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020%J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0012\u0010+\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010,\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010)R\u0016\u0010.\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0007R\"\u00104\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0007\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0007\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010\u0007R\u0014\u0010K\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010\u0007R\u0016\u0010N\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010FR\u0016\u0010V\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010F\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "", "O", "M", "Landroid/view/View;", "I", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/tencent/sqshow/zootopia/avatar/b;", "H", "()Lcom/tencent/sqshow/zootopia/avatar/b;", "avatarView", "", "updateFrame", "Landroid/widget/FrameLayout$LayoutParams;", "lp", "E", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "G", "Landroid/widget/ImageView;", "J", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "P", BdhLogUtil.LogTag.Tag_Req, "mWidth", ExifInterface.LATITUDE_SOUTH, "K", "()I", "setMHeight$zplan_impl_release", "(I)V", "mHeight", "T", "L", "setMState$zplan_impl_release", "mState", "Lrf3/e;", "U", "Lrf3/e;", "mAnimHelper", "Lrf3/g;", "V", "Lrf3/g;", "mTouchHelper", "Landroid/graphics/Rect;", "W", "Landroid/graphics/Rect;", "mCardSizeRect", "a0", "Landroid/widget/ImageView;", "mAvatarBtmCover", "b0", "mAvatarBtmCoverHeight", "c0", "mAvatarBtmCoverBtmPadding", "d0", "Z", "enableParallelWorld", "Landroid/widget/FrameLayout;", "e0", "Landroid/widget/FrameLayout;", "mCardRootView", "f0", "mLoadingBgImageView", "g0", "mBgImageView", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "h0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarCard extends ZootopiaBaseCard implements c {

    /* renamed from: R, reason: from kotlin metadata */
    private int mWidth;

    /* renamed from: S, reason: from kotlin metadata */
    private int mHeight;

    /* renamed from: T, reason: from kotlin metadata */
    private int mState;

    /* renamed from: U, reason: from kotlin metadata */
    private final e mAnimHelper;

    /* renamed from: V, reason: from kotlin metadata */
    private final g mTouchHelper;

    /* renamed from: W, reason: from kotlin metadata */
    private Rect mCardSizeRect;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final ImageView mAvatarBtmCover;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int mAvatarBtmCoverHeight;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final int mAvatarBtmCoverBtmPadding;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean enableParallelWorld;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mCardRootView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final ImageView mLoadingBgImageView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private ImageView mBgImageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarCard(Context context, LifecycleOwner owner, a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.mState = 1;
        e eVar = new e(context, this);
        this.mAnimHelper = eVar;
        this.mTouchHelper = new g(context, this, eVar);
        ImageView imageView = new ImageView(context);
        this.mAvatarBtmCover = imageView;
        int dp5 = LayoutAttrsKt.getDp(33);
        this.mAvatarBtmCoverHeight = dp5;
        int dp6 = LayoutAttrsKt.getDp(-10);
        this.mAvatarBtmCoverBtmPadding = dp6;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, dp5);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = dp6;
        imageView.setImageResource(R.drawable.f159860ie0);
        addView(imageView, layoutParams);
        O();
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache(context, ZplanCacheComponentType.AVATAR_CARD, this);
        this.enableParallelWorld = ZPlanFeatureSwitch.f369852a.N();
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mLoadingBgImageView = imageView2;
        ImageView imageView3 = new ImageView(context);
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mBgImageView = imageView3;
    }

    private final View I() {
        b H = H();
        if (H != null) {
            return H.getView();
        }
        return null;
    }

    private final void M() {
        b H = H();
        if (H != null && H.getState() == 1) {
            IZplanCacheApi iZplanCacheApi = (IZplanCacheApi) QRoute.api(IZplanCacheApi.class);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Object cache = iZplanCacheApi.getCache(context, ZplanCacheComponentType.AVATAR_CACHE_CONTAINER);
            ViewGroup viewGroup = cache instanceof ViewGroup ? (ViewGroup) cache : null;
            if (viewGroup == null) {
                return;
            }
            View view = H.getView();
            if (Intrinsics.areEqual(view.getParent(), viewGroup)) {
                return;
            }
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            viewGroup.addView(view, new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
            H.load();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ZPlanAvatarCard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G();
    }

    private final void O() {
        Rect rect = new Rect(f.f369932a.b().a());
        this.mCardSizeRect = rect;
        this.mWidth = rect.width();
        Rect rect2 = this.mCardSizeRect;
        if (rect2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardSizeRect");
            rect2 = null;
        }
        this.mHeight = rect2.height();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.mWidth, this.mHeight);
        }
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.mCardRootView;
        if (frameLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(this.mWidth, this.mHeight);
        }
        layoutParams2.width = this.mWidth;
        layoutParams2.height = this.mHeight;
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.requestLayout();
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public boolean A() {
        return false;
    }

    public final void E(View avatarView, boolean updateFrame, FrameLayout.LayoutParams lp5) {
        FrameLayout frameLayout;
        b H;
        Bitmap e16;
        Intrinsics.checkNotNullParameter(lp5, "lp");
        if (avatarView == null || (frameLayout = this.mCardRootView) == null || (H = H()) == null) {
            return;
        }
        if (updateFrame && (e16 = H.e()) != null) {
            Q(e16);
        }
        if (!Intrinsics.areEqual(avatarView.getParent(), frameLayout)) {
            ViewParent parent = avatarView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(avatarView);
            }
            frameLayout.addView(avatarView, lp5);
            H.load();
            H.b(this);
        }
        this.mAvatarBtmCover.bringToFront();
    }

    public final void G() {
        this.mBgImageView.setImageResource(R.color.ajr);
    }

    public final b H() {
        Context context = getContext();
        QLog.i("ZPlanAvatarCard_", 1, "getAvatarComponentView ctx:" + context);
        if (context == null) {
            return null;
        }
        b bVar = (b) CommonExKt.p(context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        QLog.i("ZPlanAvatarCard_", 1, "getAvatarComponentView avatarView:" + bVar);
        return bVar;
    }

    /* renamed from: J, reason: from getter */
    public final ImageView getMBgImageView() {
        return this.mBgImageView;
    }

    /* renamed from: K, reason: from getter */
    public final int getMHeight() {
        return this.mHeight;
    }

    /* renamed from: L, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    public final boolean P(MotionEvent ev5) {
        return super.onInterceptTouchEvent(ev5);
    }

    public final void Q(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.mBgImageView.setImageBitmap(bitmap);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean z16) {
        c.a.a(this, z16);
    }

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        b H;
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        Context context = getContext();
        QLog.i("ZPlanAvatarCard_", 1, "bindItemInfo ctx:" + context + ", position:" + position + ", dataInfo:" + dataInfo);
        if (context == null || (H = H()) == null) {
            return;
        }
        int state = H.getState();
        QLog.i("ZPlanAvatarCard_", 1, "bindItemInfo state:" + state);
        if (state == 2) {
            QLog.e("ZPlanAvatarCard_", 1, "bindItemInfo avatarView state is FULL!");
        } else {
            F(this, null, false, null, 7, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        b bVar = (b) CommonExKt.p(context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        if (bVar == null) {
            return;
        }
        int state = bVar.getState();
        QLog.i("ZPlanAvatarCard_", 1, "onAttachedToWindow state:" + state);
        if (state == 2) {
            QLog.e("ZPlanAvatarCard_", 1, "onAttachedToWindow avatarView state is FULL!");
            return;
        }
        F(this, null, false, null, 7, null);
        this.mAnimHelper.n();
        bVar.a(true);
        QLog.i("ZPlanAvatarCard_", 1, "onAttachedToWindow end");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        b bVar = (b) CommonExKt.p(context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        if (bVar == null) {
            return;
        }
        int state = bVar.getState();
        QLog.i("ZPlanAvatarCard_", 1, "onDetachedFromWindow state:" + state);
        if (state == 2) {
            QLog.e("ZPlanAvatarCard_", 1, "onDetachedFromWindow avatarView state is FULL!");
            return;
        }
        this.mAnimHelper.o();
        G();
        bVar.g();
        bVar.a(false);
        M();
        QLog.i("ZPlanAvatarCard_", 1, "onDetachedFromWindow end");
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult firstFrameResult) {
        c.a.b(this, firstFrameResult);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        return this.mTouchHelper.d(ev5);
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        QLog.i("ZPlanAvatarCard_", 1, "this:" + this + " inflateRootView context:" + context);
        FrameLayout frameLayout = new FrameLayout(context);
        if (!this.enableParallelWorld) {
            frameLayout.addView(this.mLoadingBgImageView);
        }
        frameLayout.addView(this.mBgImageView);
        viewParent.addView(frameLayout, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(this.mWidth, this.mHeight)));
        this.mCardRootView = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean connect) {
        QLog.i("ZPlanAvatarCard_", 1, "serviceConnected connect:" + connect);
        if (connect) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: rf3.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarCard.N(ZPlanAvatarCard.this);
            }
        });
    }

    public final void setMHeight$zplan_impl_release(int i3) {
        this.mHeight = i3;
    }

    public final void setMState$zplan_impl_release(int i3) {
        this.mState = i3;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanAvatarCard_";
    }

    public static /* synthetic */ void F(ZPlanAvatarCard zPlanAvatarCard, View view, boolean z16, FrameLayout.LayoutParams layoutParams, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = zPlanAvatarCard.I();
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        zPlanAvatarCard.E(view, z16, layoutParams);
    }
}
