package com.qzone.reborn.albumx.qzonex.part.layer.batch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/batch/QZAlbumxLayerSectionOperatePart;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "", "isEnforceShow", "", "J9", "H9", "G9", "Loc/b;", "E9", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "extraInfoBean", "preExtraInfoBean", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "canDoubleClick", "canDragClose", "canSingleClick", tl.h.F, "Z", "immersiveVisible", "i", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Loc/b;", "batchLayerViewModel", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "getOperationListener", "()Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "operationListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumxLayerSectionOperatePart extends com.qzone.reborn.albumx.qzonex.part.layer.b implements ILayerOperationInterceptor {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy operationListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean immersiveVisible;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxLayerExtraInfoBean preExtraInfoBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private oc.b batchLayerViewModel;

    public QZAlbumxLayerSectionOperatePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ILayerOperationListener>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxLayerSectionOperatePart$operationListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILayerOperationListener invoke() {
                View rootView = QZAlbumxLayerSectionOperatePart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getLayerOperationListener(rootView);
            }
        });
        this.operationListener = lazy;
    }

    private final oc.b E9() {
        return (oc.b) getViewModel(oc.b.class);
    }

    private final void G9(boolean isEnforceShow) {
        oc.b bVar = this.batchLayerViewModel;
        if (bVar == null) {
            return;
        }
        if (this.immersiveVisible && !isEnforceShow) {
            bVar.N1().setValue(Boolean.FALSE);
            bVar.M1().setValue(1);
            this.immersiveVisible = false;
        } else {
            bVar.N1().setValue(Boolean.TRUE);
            bVar.M1().setValue(2);
            this.immersiveVisible = true;
        }
    }

    private final void H9(boolean isEnforceShow) {
        oc.b bVar = this.batchLayerViewModel;
        if (bVar == null) {
            return;
        }
        if (this.immersiveVisible && !isEnforceShow) {
            bVar.N1().setValue(Boolean.FALSE);
            bVar.M1().setValue(1);
            IVideoPlayerProvider mLayerVideoControlProvider = getMLayerVideoControlProvider();
            if (mLayerVideoControlProvider != null) {
                mLayerVideoControlProvider.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.VISIBLE_LOCK);
            }
            this.immersiveVisible = false;
            return;
        }
        bVar.N1().setValue(Boolean.TRUE);
        bVar.M1().setValue(2);
        if (isEnforceShow) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.m
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxLayerSectionOperatePart.I9(QZAlbumxLayerSectionOperatePart.this);
                }
            }, 100L);
        } else {
            IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
            if (mLayerVideoControlProvider2 != null) {
                mLayerVideoControlProvider2.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.GONE_LOCK);
            }
        }
        this.immersiveVisible = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZAlbumxLayerSectionOperatePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IVideoPlayerProvider mLayerVideoControlProvider = this$0.getMLayerVideoControlProvider();
        if (mLayerVideoControlProvider != null) {
            mLayerVideoControlProvider.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.GONE_LOCK);
        }
    }

    private final void J9(boolean isEnforceShow) {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        boolean z16 = false;
        if (x95 != null && x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            z16 = true;
        }
        if (z16) {
            H9(isEnforceShow);
        } else {
            G9(isEnforceShow);
        }
    }

    private final ILayerOperationListener getOperationListener() {
        return (ILayerOperationListener) this.operationListener.getValue();
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor
    public boolean canDoubleClick() {
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor
    public boolean canDragClose() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.batchLayerViewModel = E9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (F9(x9(), this.preExtraInfoBean)) {
            return;
        }
        this.preExtraInfoBean = x9();
        J9(true);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        RFWLayerIOCUtil.registerLayerOperationInterceptor(rootView, this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor
    public boolean canSingleClick() {
        J9(false);
        ILayerOperationListener operationListener = getOperationListener();
        if (operationListener == null) {
            return true;
        }
        operationListener.onSingleClick(false);
        return true;
    }

    private final boolean F9(QZAlbumxLayerExtraInfoBean extraInfoBean, QZAlbumxLayerExtraInfoBean preExtraInfoBean) {
        return Intrinsics.areEqual(extraInfoBean != null ? extraInfoBean.getLLoc() : null, preExtraInfoBean != null ? preExtraInfoBean.getLLoc() : null);
    }
}
