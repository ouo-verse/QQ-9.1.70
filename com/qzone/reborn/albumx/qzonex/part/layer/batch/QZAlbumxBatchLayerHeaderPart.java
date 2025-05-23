package com.qzone.reborn.albumx.qzonex.part.layer.batch;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0014R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/batch/QZAlbumxBatchLayerHeaderPart;", "Lcom/qzone/reborn/albumx/common/layer/part/c;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "", "J9", "P9", "", "isChecked", "M9", "", "index", "", "O9", "Loc/b;", "L9", "N9", "Landroid/view/View;", "view", "pickStatus", "K9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "i", "Landroid/view/View;", "headerView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cbSelect", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "backView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxBatchLayerHeaderPart extends com.qzone.reborn.albumx.common.layer.part.c<QZAlbumxLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView backView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox cbSelect;

    private final void J9() {
        fo.c.q(this.backView, "em_qz_finish_button", null);
    }

    private final oc.b L9() {
        return (oc.b) getViewModel(oc.b.class);
    }

    private final void M9(boolean isChecked) {
        oc.b L9 = L9();
        QUICheckBox qUICheckBox = null;
        if (isChecked) {
            int L1 = L9 != null ? L9.L1(this.mCurrentSelectedItem) : 0;
            QUICheckBox qUICheckBox2 = this.cbSelect;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
            } else {
                qUICheckBox = qUICheckBox2;
            }
            qUICheckBox.setText(O9(L1));
            return;
        }
        if (L9 != null) {
            L9.U1(this.mCurrentSelectedItem);
        }
        QUICheckBox qUICheckBox3 = this.cbSelect;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
        } else {
            qUICheckBox = qUICheckBox3;
        }
        qUICheckBox.setText("");
    }

    private final void N9() {
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
        int i3 = 0;
        qZAlbumxBatchLayerSelectedMediaInfoBean.l(rFWLayerItemMediaInfo3 != null ? rFWLayerItemMediaInfo3.isVideo() : false);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo4 != null && (layerVideoInfo = rFWLayerItemMediaInfo4.getLayerVideoInfo()) != null) {
            i3 = layerVideoInfo.getVideoDurationSec();
        }
        qZAlbumxBatchLayerSelectedMediaInfoBean.m(i3);
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

    private final void P9() {
        MutableLiveData<Boolean> N1;
        oc.b L9 = L9();
        if (L9 == null || (N1 = L9.N1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerHeaderPart$initDate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                View view;
                View maskView;
                View view2;
                View maskView2;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                View view3 = null;
                if (it.booleanValue()) {
                    view2 = QZAlbumxBatchLayerHeaderPart.this.headerView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    } else {
                        view3 = view2;
                    }
                    view3.setVisibility(0);
                    maskView2 = QZAlbumxBatchLayerHeaderPart.this.getMaskView();
                    if (maskView2 == null) {
                        return;
                    }
                    maskView2.setVisibility(0);
                    return;
                }
                view = QZAlbumxBatchLayerHeaderPart.this.headerView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                } else {
                    view3 = view;
                }
                view3.setVisibility(8);
                maskView = QZAlbumxBatchLayerHeaderPart.this.getMaskView();
                if (maskView == null) {
                    return;
                }
                maskView.setVisibility(8);
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxBatchLayerHeaderPart.Q9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZAlbumxBatchLayerHeaderPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        fo.c.q(view, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZAlbumxBatchLayerHeaderPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9(z16);
        this$0.K9(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxBatchLayerHeaderPart";
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        QUICheckBox qUICheckBox = null;
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.f1286740, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView?.context)\n\u2026batch_layer_header, null)");
        this.headerView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f19656_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "headerView.findViewById(R.id.cb_batch_select)");
        QUICheckBox qUICheckBox2 = (QUICheckBox) findViewById;
        this.cbSelect = qUICheckBox2;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setType(4);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.f352270a.b(50));
        layoutParams.gravity = 48;
        layoutParams.topMargin = statusBarHeight;
        View view = this.headerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view = null;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.n0j);
        this.backView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZAlbumxBatchLayerHeaderPart.R9(QZAlbumxBatchLayerHeaderPart.this, view2);
                }
            });
        }
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view2 = this.headerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view2 = null;
        }
        viewGroup.addView(view2, layoutParams);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.backView, -1);
        AccessibilityUtil.s(this.backView, com.qzone.util.l.a(R.string.f2201668d));
        QUICheckBox qUICheckBox3 = this.cbSelect;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
        } else {
            qUICheckBox = qUICheckBox3;
        }
        qUICheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.batch.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                QZAlbumxBatchLayerHeaderPart.S9(QZAlbumxBatchLayerHeaderPart.this, compoundButton, z16);
            }
        });
        P9();
        J9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        String tag = getTAG();
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        QUICheckBox qUICheckBox = null;
        com.tencent.xaction.log.b.a(tag, 4, "all layer item size:" + (richMediaDataList != null ? Integer.valueOf(richMediaDataList.size()) : null));
        oc.b L9 = L9();
        int W1 = L9 != null ? L9.W1(layerState.getSelectedItemMedia()) : 0;
        if (W1 != 0) {
            QUICheckBox qUICheckBox2 = this.cbSelect;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
                qUICheckBox2 = null;
            }
            qUICheckBox2.setText(O9(W1));
            QUICheckBox qUICheckBox3 = this.cbSelect;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
            } else {
                qUICheckBox = qUICheckBox3;
            }
            qUICheckBox.setChecked(true);
            return;
        }
        QUICheckBox qUICheckBox4 = this.cbSelect;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
            qUICheckBox4 = null;
        }
        qUICheckBox4.setText("");
        QUICheckBox qUICheckBox5 = this.cbSelect;
        if (qUICheckBox5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbSelect");
        } else {
            qUICheckBox = qUICheckBox5;
        }
        qUICheckBox.setChecked(false);
    }

    private final void K9(View view, boolean pickStatus) {
        if (view == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pick_status", Integer.valueOf(pickStatus ? 1 : 0));
        fo.c.e(WinkDaTongReportConstant.ElementId.EM_QZ_SELECT_PICTURE, "pg_qz_pic_large", view, linkedHashMap);
    }

    private final String O9(int index) {
        if (index >= 100) {
            return "99+";
        }
        return String.valueOf(index);
    }
}
