package com.tencent.sqshow.zootopia.avatar.loading.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.avatar.loading.recorder.AvatarRecordType;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.n;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001+B7\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010U\u001a\u00020\u0006\u0012\u0006\u00107\u001a\u00020\u0006\u0012\u0006\u0010;\u001a\u000208\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u0004H\u0016R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010@R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00106R\u0016\u0010E\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR&\u0010N\u001a\u0012\u0012\u0004\u0012\u0002010Jj\b\u0012\u0004\u0012\u000201`K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010D\u00a8\u0006Y"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/view/ZPlanAvatarMallLoading;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/d;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "j", "l", "y", "v", DomainData.DOMAIN_NAME, "B", "w", "g", "t", "u", "Landroid/animation/ObjectAnimator;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "pauseAnim", "resumeAnim", "destroy", "Landroid/view/ViewGroup;", "getView", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "listener", "setCloseListener", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "Landroid/view/View;", "getCloseIcon", HippyTKDListViewAdapter.X, "Landroid/view/View$OnClickListener;", "setOnLoadingClickListener", "targetState", "setSwitchState", "styleMode", "setStyleMode", "avatarRecorderType", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "res", "a", "p", "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/scene/component/c;", "originHandler", ReportConstant.COSTREPORT_PREFIX, "k", "d", "I", "mStyleMode", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "e", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "mEngineType", "Ln74/n;", "f", "Ln74/n;", "mBinding", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "mCloseListener", "mCurrentProgress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mRecordAvatarCanShow", BdhLogUtil.LogTag.Tag_Conn, "mRecordAvatarIsShowing", "D", "mPageDataIsError", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "E", "Ljava/util/HashSet;", "mPageDataRetryHandlerSet", UserInfo.SEX_FEMALE, "enableSecondLoading", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;)V", "G", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarMallLoading extends FrameLayout implements ISceneLoadingView, com.tencent.sqshow.zootopia.avatar.loading.recorder.d {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mRecordAvatarIsShowing;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mPageDataIsError;

    /* renamed from: E, reason: from kotlin metadata */
    private HashSet<com.tencent.sqshow.zootopia.scene.component.c> mPageDataRetryHandlerSet;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean enableSecondLoading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mStyleMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AvatarEngineType mEngineType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final n mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ISceneLoadingView.b mCloseListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCurrentProgress;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mRecordAvatarCanShow;

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/avatar/loading/view/ZPlanAvatarMallLoading$b", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawableDownListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View p06, URLDrawable p16, int p26) {
            QLog.i("ZPlanAvatarMallLoading", 1, "onLoadProgressed p2:" + p26);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View p06, URLDrawable p16) {
            QLog.i("ZPlanAvatarMallLoading", 1, "onLoadSucceed");
            ZPlanAvatarMallLoading.this.t();
            ZPlanAvatarMallLoading.this.mRecordAvatarIsShowing = true;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View p06, URLDrawable p16) {
            QLog.w("ZPlanAvatarMallLoading", 1, "onLoadCancelled");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View p06, URLDrawable p16, Throwable p26) {
            QLog.e("ZPlanAvatarMallLoading", 1, "onLoadFailed", p26);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View p06, URLDrawable p16, InterruptedException p26) {
            QLog.w("ZPlanAvatarMallLoading", 1, "onLoadInterrupted");
        }
    }

    public /* synthetic */ ZPlanAvatarMallLoading(Context context, AttributeSet attributeSet, int i3, int i16, AvatarEngineType avatarEngineType, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, i16, avatarEngineType);
    }

    private final void A() {
        dw4.b value;
        String str;
        if (FilamentApiImpl.f369933a.d() && this.mStyleMode == 4 && (value = com.tencent.sqshow.dresskey.b.f369818a.l("ZPlanAvatarMallLoading", true).getValue()) != null) {
            qu4.h hVar = value.f395115b;
            if (hVar == null || TextUtils.isEmpty(hVar.f429598b)) {
                str = null;
            } else {
                c84.e eVar = c84.e.f30458a;
                String str2 = value.f395115b.f429598b;
                Intrinsics.checkNotNullExpressionValue(str2, "it.dressKey.dressKey");
                str = eVar.d(str2, QQTheme.isNowThemeIsNight());
            }
            if (str == null) {
                return;
            }
            if (!this.enableSecondLoading) {
                this.mBinding.f419381h.setVisibility(8);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.mBinding.f419375b.getDrawable();
            if (drawable == null) {
                drawable = new ColorDrawable(0);
            }
            obtain.mLoadingDrawable = drawable;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, obtain);
            this.mBinding.f419375b.setURLDrawableDownListener(null);
            this.mBinding.f419375b.setImageDrawable(fileDrawable);
        }
    }

    private final void B() {
        this.mBinding.f419382i.setProgress(this.mCurrentProgress);
    }

    private final void g() {
        FrameLayout frameLayout = this.mBinding.f419381h;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.loadingInfoArea");
        aa.h(frameLayout, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.ZPlanAvatarMallLoading$adjustAvatarLoadingBottomMargin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams updateLayoutParams) {
                int i3;
                float height;
                int i16;
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                i3 = ZPlanAvatarMallLoading.this.mStyleMode;
                if (i3 == 4) {
                    if (com.tencent.sqshow.zootopia.recommend.main.tab.b.f372639a.d().size() > 1) {
                        height = ZPlanAvatarMallLoading.this.getContext().getResources().getDimension(R.dimen.f122670);
                    } else {
                        i16 = 0;
                        updateLayoutParams.bottomMargin = i16;
                        QLog.i("ZPlanAvatarMallLoading", 1, "adjustAvatarLoadingBottomMargin bottomMargin:" + i16);
                    }
                } else {
                    height = e84.a.f395879a.d().height() * 0.477f;
                }
                i16 = (int) height;
                updateLayoutParams.bottomMargin = i16;
                QLog.i("ZPlanAvatarMallLoading", 1, "adjustAvatarLoadingBottomMargin bottomMargin:" + i16);
            }
        });
    }

    private final ObjectAnimator i() {
        float alpha = this.mBinding.f419376c.getAlpha();
        QLog.i("ZPlanAvatarMallLoading", 1, "currentAlpha :" + alpha);
        ObjectAnimator anim = ObjectAnimator.ofFloat(this.mBinding.f419376c, com.tencent.luggage.wxa.c8.c.f123400v, alpha, 1.0f);
        anim.setDuration(o());
        anim.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.a());
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    @AvatarRecordType
    private final int j() {
        int i3 = this.mStyleMode;
        if (i3 != 4) {
            return (i3 == 5 || i3 == 6) ? 2 : 1;
        }
        return 1;
    }

    private final void l() {
        if (FilamentApiImpl.f369933a.d()) {
            QLog.w("ZPlanAvatarMallLoading", 1, "initRecordAvatar is not ue engine!");
        } else {
            com.tencent.sqshow.zootopia.avatar.loading.recorder.e.f370046a.b(j()).m(this);
            post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarMallLoading.m(ZPlanAvatarMallLoading.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZPlanAvatarMallLoading this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanAvatarMallLoading", 1, "begin checkRecordRes");
        com.tencent.sqshow.zootopia.avatar.loading.recorder.e.f370046a.b(this$0.j()).e("ZPlanAvatarMallLoading");
        QLog.i("ZPlanAvatarMallLoading", 1, "end checkRecordRes");
    }

    private final void q() {
        if (!this.mPageDataIsError) {
            this.mBinding.f419378e.setVisibility(0);
            this.mBinding.f419379f.setVisibility(8);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanAvatarMallLoading.r(ZPlanAvatarMallLoading.this, view);
            }
        };
        if (!this.enableSecondLoading && this.mEngineType == AvatarEngineType.FILAMENT) {
            this.mBinding.f419381h.setVisibility(0);
        }
        this.mBinding.f419378e.setVisibility(4);
        this.mBinding.f419379f.setVisibility(0);
        this.mBinding.f419379f.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ZPlanAvatarMallLoading this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        u();
    }

    private final void u() {
        QLog.i("ZPlanAvatarMallLoading", 1, "refreshLoadingUIImpl mRecordAvatarCanShow:" + this.mRecordAvatarCanShow);
        this.mBinding.f419376c.setVisibility(0);
        if (ZPlanQQMC.INSTANCE.enableBottomLoadingHint()) {
            this.mBinding.f419380g.setVisibility(0);
        } else {
            this.mBinding.f419380g.setVisibility(8);
        }
        q();
    }

    private final void v() {
        int i3 = this.mStyleMode;
        if (i3 == 5) {
            this.mBinding.f419381h.setBackground(q.b(R.drawable.f159869h44));
        } else if (i3 != 6) {
            this.mBinding.f419381h.setBackground(q.b(R.drawable.f159869h44));
        } else {
            this.mBinding.f419381h.setBackground(new ColorDrawable(0));
        }
    }

    private final void w() {
        QLog.i("ZPlanAvatarMallLoading", 1, "refreshUILayout mStyleMode:" + this.mStyleMode);
        g();
        requestLayout();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.recorder.d
    public void a(int avatarRecorderType, ZPlanRecordResource res) {
        Intrinsics.checkNotNullParameter(res, "res");
        int j3 = j();
        QLog.i("ZPlanAvatarMallLoading", 1, "onRecordRes avatarRecorderType:" + avatarRecorderType + ", selfRecorderType:" + j3 + " res:" + res);
        if (j3 != avatarRecorderType) {
            return;
        }
        Rect a16 = e84.a.f395879a.a();
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        option.mRequestWidth = a16.width();
        option.mRequestHeight = a16.height();
        option.mUseSharpPAnimImage = true;
        Drawable drawable = this.mBinding.f419375b.getDrawable();
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        option.mLoadingDrawable = drawable;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_double_bitmap", true);
        option.mExtraInfo = bundle;
        b bVar = new b();
        if (res.o()) {
            this.mRecordAvatarCanShow = true;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(res.getLocalPath(), option);
            this.mBinding.f419375b.setURLDrawableDownListener(bVar);
            this.mBinding.f419375b.setImageDrawable(fileDrawable);
            return;
        }
        if (res.p()) {
            this.mRecordAvatarCanShow = true;
            URLImageView uRLImageView = this.mBinding.f419375b;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.avatarIcon");
            String remoteUrl = res.getRemoteUrl();
            if (remoteUrl == null) {
                remoteUrl = "";
            }
            Intrinsics.checkNotNullExpressionValue(option, "option");
            CommonExKt.u(uRLImageView, remoteUrl, option, bVar);
            return;
        }
        this.mRecordAvatarCanShow = false;
        QLog.e("ZPlanAvatarMallLoading", 1, "onRecordRes invalid res");
        t();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void destroy() {
        String str;
        QLog.i("ZPlanAvatarMallLoading", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        com.tencent.sqshow.zootopia.avatar.loading.recorder.e.f370046a.d(this);
        dw4.b value = com.tencent.sqshow.dresskey.b.f369818a.l("ZPlanAvatarMallLoading", true).getValue();
        if (value != null) {
            qu4.h hVar = value.f395115b;
            if (hVar == null || TextUtils.isEmpty(hVar.f429598b)) {
                str = null;
            } else {
                c84.e eVar = c84.e.f30458a;
                String str2 = value.f395115b.f429598b;
                Intrinsics.checkNotNullExpressionValue(str2, "it.dressKey.dressKey");
                str = eVar.d(str2, QQTheme.isNowThemeIsNight());
            }
            if (str == null) {
                return;
            }
            URLDrawable.removeMemoryCacheByUrl(str, URLDrawable.URLDrawableOptions.obtain());
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public View getCloseIcon() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public void k() {
        h();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public long o() {
        return 10L;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public ObjectAnimator p() {
        return i();
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public boolean s(com.tencent.sqshow.zootopia.scene.component.c originHandler) {
        Intrinsics.checkNotNullParameter(originHandler, "originHandler");
        this.mPageDataIsError = true;
        this.mPageDataRetryHandlerSet.add(originHandler);
        q();
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void setCloseListener(ISceneLoadingView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mCloseListener = listener;
    }

    @Override // c84.a
    public void setProgress(int progress) {
        n();
        if (this.mCurrentProgress == 100) {
            return;
        }
        this.mCurrentProgress = progress;
        B();
    }

    public void setStyleMode(int styleMode) {
        if (this.mStyleMode != styleMode) {
            y();
        }
        this.mStyleMode = styleMode;
        w();
        v();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public View x() {
        return new View(getContext());
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    /* renamed from: z, reason: from getter */
    public boolean getMRecordAvatarIsShowing() {
        return this.mRecordAvatarIsShowing;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarMallLoading(Context context, AttributeSet attributeSet, int i3, int i16, AvatarEngineType mEngineType) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mEngineType, "mEngineType");
        this.mStyleMode = i16;
        this.mEngineType = mEngineType;
        n g16 = n.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        this.mPageDataRetryHandlerSet = new HashSet<>();
        this.enableSecondLoading = ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableFilamentPortalSecondLoading();
        setOnClickListener(null);
        l();
        t();
        setStyleMode(this.mStyleMode);
        URLImageView _init_$lambda$0 = g16.f419377d;
        _init_$lambda$0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String str = QQTheme.isNowThemeIsNight() ? "https://static-res.qq.com/static-res/zplan/background/zplan_bg_dark.png" : "https://static-res.qq.com/static-res/zplan/background/zplan_bg_light.png";
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$0, "_init_$lambda$0");
        CommonExKt.v(_init_$lambda$0, str, R.drawable.qui_common_bg_bottom_standard_bg, null, 4, null);
        A();
    }

    private final void h() {
        this.mPageDataIsError = false;
        Iterator<T> it = this.mPageDataRetryHandlerSet.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.scene.component.c) it.next()).yd();
        }
        this.mPageDataRetryHandlerSet.clear();
        q();
    }

    private final void y() {
        this.mRecordAvatarCanShow = false;
        this.mRecordAvatarIsShowing = false;
        l();
        t();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void pauseAnim() {
        QLog.i("ZPlanAvatarMallLoading", 1, "pauseAnim");
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void resumeAnim() {
        QLog.i("ZPlanAvatarMallLoading", 1, "resumeAnim");
    }

    private final void n() {
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public ViewGroup getView() {
        return this;
    }

    public void setOnLoadingClickListener(View.OnClickListener l3) {
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void setSwitchState(int targetState) {
    }
}
