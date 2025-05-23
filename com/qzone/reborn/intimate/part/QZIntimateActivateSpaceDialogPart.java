package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.intimate.bean.QZoneIntimateActivateResultBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$ActiveGuideInfo;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 f2\u00020\u0001:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J \u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u0002H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010MR\u0018\u0010V\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010MR\u0018\u0010X\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010MR\u0018\u0010Z\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010QR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010]R\u0018\u0010c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateActivateSpaceDialogPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "la", "initViewModel", "ga", "ca", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateActivateResultBean;", "resultBean", "ma", "ea", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "spaceBean", "qa", "", "", "urlList", "ra", "url", "", "iconSize", "ua", WidgetCacheConstellationData.NUM, "Y9", "titleText", "ta", "colorString", "pa", "firstTag", "secondTag", "thirdTag", "sa", "leftBtnTitle", "rightBtnTittle", "oa", "contentLayout", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "U9", "ba", "", "anniversary", "Z9", "V9", "W9", "X9", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "Lnk/u;", "e", "Lnk/u;", "activateSpaceViewModel", "Lnk/ar;", "f", "Lnk/ar;", "feedViewModel", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", tl.h.F, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "initBean", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "i", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "activateSpaceBean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "guideDialog", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "guideImgGroup", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "guideTitle", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "guideTagGroup", UserInfo.SEX_FEMALE, "guideTagFirst", "G", "guideTagSecond", "H", "guideTagThird", "I", "guideBtnGroup", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "J", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "cancelBtn", "K", "confirmBtn", "L", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateActivateResultBean;", "activateResultBean", "<init>", "()V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateActivateSpaceDialogPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup guideImgGroup;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView guideTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout guideTagGroup;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView guideTagFirst;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView guideTagSecond;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView guideTagThird;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout guideBtnGroup;

    /* renamed from: J, reason: from kotlin metadata */
    private QUIButton cancelBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private QUIButton confirmBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private QZoneIntimateActivateResultBean activateResultBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.u activateSpaceViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private nk.ar feedViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateMainPageInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateActivateSpaceBean activateSpaceBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView guideDialog;

    private final QUSHalfScreenImmersiveFloatingView U9(View contentLayout) {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = new QUSHalfScreenImmersiveFloatingView(getContext());
        qUSHalfScreenImmersiveFloatingView.setBackgroundColor(0);
        qUSHalfScreenImmersiveFloatingView.setIgnoreHorizontalMove(true);
        qUSHalfScreenImmersiveFloatingView.setIsContentDraggable(false);
        qUSHalfScreenImmersiveFloatingView.setDraggable(false);
        qUSHalfScreenImmersiveFloatingView.q();
        qUSHalfScreenImmersiveFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenImmersiveFloatingView.setOnOutsideClickListener(new b());
        qUSHalfScreenImmersiveFloatingView.setQUSDragFloatController(new c(contentLayout));
        return qUSHalfScreenImmersiveFloatingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        fo.c.n(this.guideDialog, "em_qz_intimate_space_floating");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        fo.c.n(this.cancelBtn, "em_qz_think_again");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9() {
        fo.c.n(this.confirmBtn, "em_qz_go_play");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(com.qzone.reborn.widget.g selectorView, QZIntimateActivateSpaceDialogPart this$0) {
        Intrinsics.checkNotNullParameter(selectorView, "$selectorView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        selectorView.m();
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this$0.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.setOnDismissListener(null);
        }
    }

    private final void ba() {
        nk.u uVar = this.activateSpaceViewModel;
        if (uVar != null) {
            uVar.W1();
        }
    }

    private final void ca() {
        nk.u uVar;
        MutableLiveData<QZoneIntimateActivateResultBean> O1;
        nk.u uVar2 = (nk.u) getViewModel(nk.u.class);
        this.activateSpaceViewModel = uVar2;
        if (uVar2 != null) {
            uVar2.Z1(this.activateSpaceBean);
        }
        nk.u uVar3 = this.activateSpaceViewModel;
        if (uVar3 != null && (O1 = uVar3.O1()) != null) {
            Fragment hostFragment = getHostFragment();
            final QZIntimateActivateSpaceDialogPart$initActivateSpaceViewModel$1 qZIntimateActivateSpaceDialogPart$initActivateSpaceViewModel$1 = new QZIntimateActivateSpaceDialogPart$initActivateSpaceViewModel$1(this);
            O1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZIntimateActivateSpaceDialogPart.da(Function1.this, obj);
                }
            });
        }
        mk.d dVar = mk.d.f416875a;
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = this.activateSpaceBean;
        if (!dVar.y(qZoneIntimateActivateSpaceBean != null ? Integer.valueOf(qZoneIntimateActivateSpaceBean.getSpaceType()) : null) || (uVar = this.activateSpaceViewModel) == null) {
            return;
        }
        uVar.Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ea() {
        this.feedViewModel = (nk.ar) getViewModel(nk.ar.class);
    }

    private final void ga() {
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        nk.at atVar = (nk.at) getViewModel(nk.at.class);
        this.mainTabViewModel = atVar;
        if (atVar == null || (U1 = atVar.U1()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateActivateSpaceDialogPart$initTabViewModel$1
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
                nk.at atVar2;
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView;
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2;
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3;
                if (uIStateData.getData() != null && uIStateData.getData().isDraft()) {
                    atVar2 = QZIntimateActivateSpaceDialogPart.this.mainTabViewModel;
                    if (atVar2 != null && atVar2.getMIsIntercept() == 1) {
                        QLog.i("QZIntimateActivateSpaceDialogPart", 1, " is intercept, no need to show");
                        return;
                    }
                    if (!com.qzone.reborn.util.k.f59549a.g() || !uIStateData.getData().isLoveSpace()) {
                        qUSHalfScreenImmersiveFloatingView = QZIntimateActivateSpaceDialogPart.this.guideDialog;
                        if ((qUSHalfScreenImmersiveFloatingView != null ? qUSHalfScreenImmersiveFloatingView.getParent() : null) == null) {
                            View partRootView = QZIntimateActivateSpaceDialogPart.this.getPartRootView();
                            Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type android.view.ViewGroup");
                            qUSHalfScreenImmersiveFloatingView3 = QZIntimateActivateSpaceDialogPart.this.guideDialog;
                            ((ViewGroup) partRootView).addView(qUSHalfScreenImmersiveFloatingView3);
                        }
                        qUSHalfScreenImmersiveFloatingView2 = QZIntimateActivateSpaceDialogPart.this.guideDialog;
                        if (qUSHalfScreenImmersiveFloatingView2 != null) {
                            qUSHalfScreenImmersiveFloatingView2.setVisibility(0);
                        }
                        QZIntimateActivateSpaceDialogPart.this.qa(uIStateData.getData());
                        QZIntimateActivateSpaceDialogPart.this.V9();
                        QZIntimateActivateSpaceDialogPart.this.W9();
                        QZIntimateActivateSpaceDialogPart.this.X9();
                        return;
                    }
                    QLog.i("QZIntimateActivateSpaceDialogPart", 1, " teen mode lover is intercept");
                    return;
                }
                RFWLog.i("QZIntimateActivateSpaceDialogPart", RFWLog.USR, "is not draft space");
            }
        };
        U1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateActivateSpaceDialogPart.ha(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(QZIntimateActivateSpaceDialogPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        ga();
        ca();
        ea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(QZIntimateActivateSpaceDialogPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void la() {
        Intent intent;
        Intent intent2;
        Activity activity = getActivity();
        Serializable serializable = null;
        if (((activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getSerializableExtra("key_bundle_common_init_bean")) instanceof QZoneIntimateMainPageInitBean) {
            Activity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
            }
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
            QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = (QZoneIntimateMainPageInitBean) serializable;
            this.initBean = qZoneIntimateMainPageInitBean;
            Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean);
            this.activateSpaceBean = qZoneIntimateMainPageInitBean.getActivateSpaceBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma(final QZoneIntimateActivateResultBean resultBean) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.intimate.part.f
            @Override // java.lang.Runnable
            public final void run() {
                QZIntimateActivateSpaceDialogPart.na(QZIntimateActivateSpaceDialogPart.this, resultBean);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(QZIntimateActivateSpaceDialogPart this$0, QZoneIntimateActivateResultBean resultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultBean, "$resultBean");
        nk.at atVar = this$0.mainTabViewModel;
        if (atVar != null) {
            atVar.j2(resultBean.getSpaceId());
        }
        nk.at atVar2 = this$0.mainTabViewModel;
        if (atVar2 != null) {
            atVar2.N1();
        }
    }

    private final void oa(String leftBtnTitle, String rightBtnTittle) {
        QUIButton qUIButton = this.cancelBtn;
        if (qUIButton != null) {
            qUIButton.setText(leftBtnTitle);
        }
        QUIButton qUIButton2 = this.confirmBtn;
        if (qUIButton2 == null) {
            return;
        }
        qUIButton2.setText(rightBtnTittle);
    }

    private final void pa(String colorString) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (TextUtils.isEmpty(colorString)) {
            colorString = "#0099FF";
        }
        gradientDrawable.setStroke(ImmersiveUtils.dpToPx(1.0f), Color.parseColor(colorString));
        gradientDrawable.setCornerRadius(8.0f);
        QUIButton qUIButton = this.cancelBtn;
        if (qUIButton != null) {
            qUIButton.setBackground(gradientDrawable);
        }
        QUIButton qUIButton2 = this.cancelBtn;
        if (qUIButton2 != null) {
            qUIButton2.setTextColor(Color.parseColor(colorString));
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor(colorString));
        gradientDrawable2.setCornerRadius(8.0f);
        QUIButton qUIButton3 = this.confirmBtn;
        if (qUIButton3 == null) {
            return;
        }
        qUIButton3.setBackground(gradientDrawable2);
    }

    private final void sa(String firstTag, String secondTag, String thirdTag) {
        TextView textView = this.guideTagFirst;
        if (textView != null) {
            textView.setText(firstTag);
        }
        TextView textView2 = this.guideTagSecond;
        if (textView2 != null) {
            textView2.setText(secondTag);
        }
        TextView textView3 = this.guideTagThird;
        if (textView3 == null) {
            return;
        }
        textView3.setText(thirdTag);
    }

    private final void ta(String titleText) {
        TextView textView = this.guideTitle;
        if (textView == null) {
            return;
        }
        textView.setText(titleText);
    }

    private final void ua(String url, int iconSize) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iconSize, iconSize);
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        ViewGroup viewGroup = this.guideImgGroup;
        if (viewGroup != null) {
            viewGroup.addView(imageView);
        }
        com.qzone.reborn.util.h.i(getContext(), imageView, url, iconSize, iconSize);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        la();
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = this.initBean;
        if (qZoneIntimateMainPageInitBean != null) {
            boolean z16 = false;
            if (qZoneIntimateMainPageInitBean != null && qZoneIntimateMainPageInitBean.getIsDraft()) {
                z16 = true;
            }
            if (z16) {
                initViewModel();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cjn, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026de_activate_layout, null)");
                this.guideImgGroup = (ViewGroup) inflate.findViewById(R.id.k9p);
                this.guideTitle = (TextView) inflate.findViewById(R.id.kaa);
                this.guideTagGroup = (LinearLayout) inflate.findViewById(R.id.k_k);
                this.guideTagFirst = (TextView) inflate.findViewById(R.id.k_e);
                this.guideTagSecond = (TextView) inflate.findViewById(R.id.k_i);
                this.guideTagThird = (TextView) inflate.findViewById(R.id.k_2);
                this.guideBtnGroup = (LinearLayout) inflate.findViewById(R.id.k9i);
                QUIButton qUIButton = (QUIButton) inflate.findViewById(R.id.f196469);
                this.cancelBtn = qUIButton;
                if (qUIButton != null) {
                    qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QZIntimateActivateSpaceDialogPart.ia(QZIntimateActivateSpaceDialogPart.this, view);
                        }
                    });
                }
                QUIButton qUIButton2 = (QUIButton) inflate.findViewById(R.id.f20127j);
                this.confirmBtn = qUIButton2;
                if (qUIButton2 != null) {
                    qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QZIntimateActivateSpaceDialogPart.ja(QZIntimateActivateSpaceDialogPart.this, view);
                        }
                    });
                }
                QUSHalfScreenImmersiveFloatingView U9 = U9(inflate);
                this.guideDialog = U9;
                if (U9 == null) {
                    return;
                }
                U9.setVisibility(8);
                return;
            }
        }
        RFWLog.i("QZIntimateActivateSpaceDialogPart", RFWLog.USR, "not draft space, return");
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateActivateSpaceDialogPart$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f57179d;

        c(View view) {
            this.f57179d = view;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView, reason: from getter */
        public View getF57179d() {
            return this.f57179d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ImmersiveUtils.dpToPx(500.0f);
        }
    }

    private final void ra(List<String> urlList) {
        if (ArrayUtils.isOutOfArrayIndex(0, urlList)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (urlList.size() >= 5) {
            arrayList.addAll(urlList.subList(0, 5));
        } else {
            arrayList.addAll(urlList);
        }
        int Y9 = Y9(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ua((String) it.next(), Y9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(long anniversary) {
        String title = com.qzone.util.l.a(R.string.wbn);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        final com.qzone.reborn.widget.g gVar = new com.qzone.reborn.widget.g(context, title);
        gVar.M(anniversary * 1000);
        gVar.i(new QZIntimateActivateSpaceDialogPart$goToDateSelector$1(this, gVar));
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.intimate.part.e
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    QZIntimateActivateSpaceDialogPart.aa(com.qzone.reborn.widget.g.this, this);
                }
            });
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.guideDialog;
        if (qUSHalfScreenImmersiveFloatingView2 != null) {
            qUSHalfScreenImmersiveFloatingView2.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(QZoneIntimateSpaceBean spaceBean) {
        QZIntimateSpaceReader$ActiveGuideInfo activateGuideInfo;
        if (spaceBean == null || (activateGuideInfo = spaceBean.getActivateGuideInfo()) == null) {
            return;
        }
        List<String> iconUrlList = activateGuideInfo.relation_icons.get();
        String guideTitle = activateGuideInfo.guide_title.get();
        String themeColor = activateGuideInfo.theme_color.get();
        List<String> list = activateGuideInfo.tags.get();
        String leftBtnTitle = activateGuideInfo.left_btn_title.get();
        String rightBtnTitle = activateGuideInfo.right_btn_btn_title.get();
        Intrinsics.checkNotNullExpressionValue(iconUrlList, "iconUrlList");
        ra(iconUrlList);
        Intrinsics.checkNotNullExpressionValue(guideTitle, "guideTitle");
        ta(guideTitle);
        Intrinsics.checkNotNullExpressionValue(themeColor, "themeColor");
        pa(themeColor);
        if (list.size() >= 3) {
            String str = list.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "tagList[0]");
            String str2 = list.get(1);
            Intrinsics.checkNotNullExpressionValue(str2, "tagList[1]");
            String str3 = list.get(2);
            Intrinsics.checkNotNullExpressionValue(str3, "tagList[2]");
            sa(str, str2, str3);
        }
        Intrinsics.checkNotNullExpressionValue(leftBtnTitle, "leftBtnTitle");
        Intrinsics.checkNotNullExpressionValue(rightBtnTitle, "rightBtnTitle");
        oa(leftBtnTitle, rightBtnTitle);
    }

    private final int Y9(int num) {
        if (num <= 3) {
            return ImmersiveUtils.dpToPx(60.0f);
        }
        return ImmersiveUtils.dpToPx(40.0f);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateActivateSpaceDialogPart$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.o {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(View v3) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
        }
    }
}
