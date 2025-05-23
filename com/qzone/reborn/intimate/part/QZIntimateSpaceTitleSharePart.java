package com.qzone.reborn.intimate.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$PHShareStatus;
import qzone.QZIntimateSpaceReader$PHStatusPattern;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateSpaceTitleSharePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "initViewModel", "Lqzone/QZIntimateSpaceReader$PHShareStatus;", "shareStatus", "G9", "K9", "M9", "J9", "F9", "", "isPartEnable", "onInitView", "view", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "llShareContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivShareIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvShareText", "Lnk/at;", tl.h.F, "Lnk/at;", "mainTabViewModel", "i", "Lqzone/QZIntimateSpaceReader$PHShareStatus;", "phShareStatus", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceTitleSharePart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llShareContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivShareIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvShareText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZIntimateSpaceReader$PHShareStatus phShareStatus;
    private static final int C = com.qzone.util.ar.e(4.0f);
    private static final int D = com.qzone.util.ar.e(4.0f);

    private final void F9() {
        QZIntimateSpaceReader$PHStatusPattern qZIntimateSpaceReader$PHStatusPattern;
        PBStringField pBStringField;
        QZIntimateSpaceReader$PHShareStatus qZIntimateSpaceReader$PHShareStatus = this.phShareStatus;
        nk.at atVar = null;
        String str = (qZIntimateSpaceReader$PHShareStatus == null || (qZIntimateSpaceReader$PHStatusPattern = qZIntimateSpaceReader$PHShareStatus.status_pattern) == null || (pBStringField = qZIntimateSpaceReader$PHStatusPattern.schemal_url) == null) ? null : pBStringField.get();
        QLog.i("QZIntimateSpaceTitleSharePart", 1, "[handleClickShareContainer] schema = " + str);
        if (com.qzone.reborn.util.e.a("QZIntimateSpaceTitleSharePart")) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            com.qzone.reborn.util.o.f59556a.c(R.string.w_h, 1);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nk.at atVar2 = this.mainTabViewModel;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            atVar = atVar2;
        }
        atVar.M1();
        yo.d.o(getActivity(), str, true, 0, 0, -1, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(QZIntimateSpaceReader$PHShareStatus shareStatus) {
        this.phShareStatus = shareStatus;
        LinearLayout linearLayout = null;
        if (shareStatus == null) {
            QLog.d("QZIntimateSpaceTitleSharePart", 1, "[handleShareStatusRsp] share container is gone");
            LinearLayout linearLayout2 = this.llShareContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llShareContainer");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.llShareContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llShareContainer");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(0);
        J9(shareStatus);
        K9(shareStatus);
        M9(shareStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void J9(QZIntimateSpaceReader$PHShareStatus shareStatus) {
        PBEnumField pBEnumField;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, String.valueOf((shareStatus == null || (pBEnumField = shareStatus.share_type) == null) ? 0 : pBEnumField.get()));
        fo.b j3 = new fo.b().l(linkedHashMap).j(EndExposurePolicy.REPORT_NONE);
        LinearLayout linearLayout = this.llShareContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llShareContainer");
            linearLayout = null;
        }
        fo.c.o(linearLayout, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE_BTN, j3);
    }

    private final void K9(QZIntimateSpaceReader$PHShareStatus shareStatus) {
        PBEnumField pBEnumField;
        PBStringField pBStringField;
        QZIntimateSpaceReader$PHStatusPattern qZIntimateSpaceReader$PHStatusPattern = shareStatus.status_pattern;
        ImageView imageView = null;
        String str = (qZIntimateSpaceReader$PHStatusPattern == null || (pBStringField = qZIntimateSpaceReader$PHStatusPattern.icon_url) == null) ? null : pBStringField.get();
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            QLog.i("QZIntimateSpaceTitleSharePart", 1, "[showTitleShareIcon] iconUrl = " + str);
            LinearLayout linearLayout = this.llShareContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llShareContainer");
                linearLayout = null;
            }
            linearLayout.setPadding(0, 0, 0, 0);
            ImageView imageView2 = this.ivShareIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivShareIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setImageResource(R.drawable.qui_share_icon_allwhite_primary);
            return;
        }
        QZIntimateSpaceReader$PHStatusPattern qZIntimateSpaceReader$PHStatusPattern2 = shareStatus.status_pattern;
        if (qZIntimateSpaceReader$PHStatusPattern2 != null && (pBEnumField = qZIntimateSpaceReader$PHStatusPattern2.pattern_type) != null && pBEnumField.get() == 1) {
            z16 = true;
        }
        if (z16) {
            QLog.i("QZIntimateSpaceTitleSharePart", 1, "[showTitleShareIcon] qui token = " + str);
            ImageView imageView3 = this.ivShareIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivShareIcon");
            } else {
                imageView = imageView3;
            }
            rn.h.a(imageView, str, R.color.qui_common_icon_allwhite_primary);
            return;
        }
        Option url = Option.obtain().setUrl(str);
        ImageView imageView4 = this.ivShareIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivShareIcon");
        } else {
            imageView = imageView4;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(url.setTargetView(imageView).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans), new IPicLoadStateListener() { // from class: com.qzone.reborn.intimate.part.bd
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZIntimateSpaceTitleSharePart.L9(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(LoadState loadState, Option option) {
        if (!loadState.isFinishError() || option == null) {
            return;
        }
        QLog.e("QZIntimateSpaceTitleSharePart", 1, "loadImage | state = " + loadState + " | url = " + option.getUrl());
    }

    private final void M9(QZIntimateSpaceReader$PHShareStatus shareStatus) {
        PBStringField pBStringField;
        QZIntimateSpaceReader$PHStatusPattern qZIntimateSpaceReader$PHStatusPattern = shareStatus.status_pattern;
        TextView textView = null;
        String str = (qZIntimateSpaceReader$PHStatusPattern == null || (pBStringField = qZIntimateSpaceReader$PHStatusPattern.text) == null) ? null : pBStringField.get();
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZIntimateSpaceTitleSharePart", 1, "[showTitleShareText] shareStatusText = " + str);
            TextView textView2 = this.tvShareText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvShareText");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        LinearLayout linearLayout = this.llShareContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llShareContainer");
            linearLayout = null;
        }
        linearLayout.setPadding(C, 0, D, 0);
        TextView textView3 = this.tvShareText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShareText");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.tvShareText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShareText");
        } else {
            textView = textView4;
        }
        textView.setText(str);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel;
        this.mainTabViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceTitleSharePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                if ((uIStateData != null ? uIStateData.getData() : null) != null) {
                    QZIntimateSpaceTitleSharePart.this.G9(uIStateData.getData().getPhShareStatus());
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.bc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateSpaceTitleSharePart.I9(Function1.this, obj);
            }
        });
    }

    @Override // com.qzone.reborn.base.k, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return super.isPartEnable() && com.qzone.reborn.configx.g.f53821a.b().q0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n66) {
            F9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        H9(rootView);
        initViewModel();
    }

    private final void H9(View rootView) {
        View findViewById = rootView.findViewById(R.id.n66);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026te_title_share_container)");
        this.llShareContainer = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.n67);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ntimate_title_share_icon)");
        this.ivShareIcon = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.n68);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ntimate_title_share_text)");
        this.tvShareText = (TextView) findViewById3;
        LinearLayout linearLayout = this.llShareContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llShareContainer");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
    }
}
