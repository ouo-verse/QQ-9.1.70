package com.qzone.reborn.albumx.qzonex.part.layer.batch;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/batch/QZAlbumxBatchLayerBottomOperatePart;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "M9", "initData", "Loc/b;", "J9", "", "it", "K9", "(Ljava/lang/Integer;)V", "Q9", "L9", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "flBottomOperateContainer", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "i", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btnConfirm", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxBatchLayerBottomOperatePart extends com.qzone.reborn.albumx.qzonex.part.layer.b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flBottomOperateContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUIButton btnConfirm;

    private final void I9() {
        fo.c.q(this.btnConfirm, "em_qz_finish_button", null);
    }

    private final oc.b J9() {
        return (oc.b) getViewModel(oc.b.class);
    }

    private final void L9() {
        String str;
        RFWLayerVideoInfo layerVideoInfo;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        RFWLayerPicInfo layerPicInfo2;
        Intent intent = new Intent();
        com.qzone.reborn.feedx.util.m.b("extra_key_parcelable_selected_list_for_result_batch_layer", ((oc.b) getViewModel(oc.b.class)).R1());
        QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = new QZAlbumxBatchLayerSelectedMediaInfoBean();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        String str2 = "";
        if (rFWLayerItemMediaInfo == null || (layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (str = layerPicInfo2.getPicId()) == null) {
            str = "";
        }
        qZAlbumxBatchLayerSelectedMediaInfoBean.g(str);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo2 != null && (layerPicInfo = rFWLayerItemMediaInfo2.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
            str2 = url;
        }
        qZAlbumxBatchLayerSelectedMediaInfoBean.k(str2);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
        qZAlbumxBatchLayerSelectedMediaInfoBean.m((rFWLayerItemMediaInfo3 == null || (layerVideoInfo = rFWLayerItemMediaInfo3.getLayerVideoInfo()) == null) ? 0 : layerVideoInfo.getVideoDurationSec());
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
        qZAlbumxBatchLayerSelectedMediaInfoBean.l(rFWLayerItemMediaInfo4 != null ? rFWLayerItemMediaInfo4.isVideo() : false);
        Unit unit = Unit.INSTANCE;
        intent.putExtra("batch_selector_result_cur_media", qZAlbumxBatchLayerSelectedMediaInfoBean);
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZAlbumxBatchLayerBottomOperatePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        String str;
        List<QZAlbumxBatchLayerSelectedMediaInfoBean> P1;
        List<QZAlbumxBatchLayerSelectedMediaInfoBean> P12;
        oc.b J9 = J9();
        QUIButton qUIButton = this.btnConfirm;
        if (qUIButton == null) {
            return;
        }
        if (((J9 == null || (P12 = J9.P1()) == null) ? 0 : P12.size()) == 0) {
            str = com.qzone.util.l.a(R.string.f133145b);
        } else {
            str = com.qzone.util.l.a(R.string.f133145b) + "(" + ((J9 == null || (P1 = J9.P1()) == null) ? null : Integer.valueOf(P1.size())) + ")";
        }
        qUIButton.setText(str);
    }

    private final void initData() {
        oc.b J9 = J9();
        if (J9 != null) {
            MutableLiveData<Integer> M1 = J9.M1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerBottomOperatePart$initData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    QZAlbumxBatchLayerBottomOperatePart.this.K9(num);
                }
            };
            M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxBatchLayerBottomOperatePart.O9(Function1.this, obj);
                }
            });
            MutableLiveData<Unit> Q1 = J9.Q1();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerBottomOperatePart$initData$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Unit unit) {
                    QZAlbumxBatchLayerBottomOperatePart.this.Q9();
                }
            };
            Q1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxBatchLayerBottomOperatePart.P9(Function1.this, obj);
                }
            });
            Q9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        M9(rootView);
        initData();
        I9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(Integer it) {
        FrameLayout frameLayout;
        if (it == null) {
            return;
        }
        if (it.intValue() == 1) {
            FrameLayout frameLayout2 = this.flBottomOperateContainer;
            if (frameLayout2 == null) {
                return;
            }
            frameLayout2.setVisibility(8);
            return;
        }
        if (it.intValue() != 2 || (frameLayout = this.flBottomOperateContainer) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    private final void M9(View rootView) {
        if (rootView == null) {
            return;
        }
        this.flBottomOperateContainer = (FrameLayout) rootView.findViewById(R.id.f19305b);
        QUIButton qUIButton = (QUIButton) rootView.findViewById(R.id.f19495u);
        this.btnConfirm = qUIButton;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxBatchLayerBottomOperatePart.N9(QZAlbumxBatchLayerBottomOperatePart.this, view);
                }
            });
        }
    }
}
