package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonFamilyAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonLoverAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0002J\u001a\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J0\u0010#\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0002J\b\u0010$\u001a\u00020\u0002H\u0002J\u0012\u0010%\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010&\u001a\u00020\fH\u0002J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\u0002H\u0002J\b\u0010)\u001a\u00020\u0002H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\fH\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u000eH\u0002J\b\u00101\u001a\u00020\u001aH\u0016J\u0010\u00102\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00105\u001a\u00020\u0002H\u0014J\b\u00106\u001a\u00020\u0002H\u0014J\b\u00107\u001a\u00020\fH\u0016J\"\u0010<\u001a\u00020\u00022\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010GR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailTitlePart;", "Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailTitlePart;", "", "ta", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ha", "ra", "", "wa", WidgetCacheConstellationData.NUM, "Wa", "", "Ga", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Fa", "Da", "view", "xa", "Ra", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "itemIdList", "pa", "", "emId", "va", "ua", "", "", "getReportParams", "clickedView", "which", "za", "Aa", "Ua", "Qa", "Pa", "Ba", "Ea", "Ca", "isOperateMode", "Va", "qa", "sa", "updatedAlbum", "Oa", "getLogTag", "onInitView", "v", NodeProps.ON_CLICK, "D9", "E9", "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/RelativeLayout;", "M", "Landroid/widget/RelativeLayout;", "rlNormalTitleLayout", "N", "rlOperateLayout", "P", "rlOperateContainer", "Landroid/widget/FrameLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", "flTitleBar", "Lnc/y;", BdhLogUtil.LogTag.Tag_Req, "Lnc/y;", "albumViewModel", ExifInterface.LATITUDE_SOUTH, "Z", "isAllSelectMode", "Lnc/ap;", "T", "Lnc/ap;", "operateViewModel", "U", "flTransmitLayout", "Landroid/widget/ImageView;", "V", "Landroid/widget/ImageView;", "ivCalendar", "<init>", "()V", "W", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailTitlePart extends CommonAlbumDetailTitlePart {

    /* renamed from: M, reason: from kotlin metadata */
    private RelativeLayout rlNormalTitleLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private RelativeLayout rlOperateLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private RelativeLayout rlOperateContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout flTitleBar;

    /* renamed from: R, reason: from kotlin metadata */
    private nc.y albumViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isAllSelectMode;

    /* renamed from: T, reason: from kotlin metadata */
    private nc.ap operateViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private FrameLayout flTransmitLayout;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView ivCalendar;

    private final void Aa() {
        nc.y yVar = this.albumViewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        yVar.b2(false);
        F9().setExpanded(false);
        F9().setExpanded(true);
        L9().stopScroll();
        L9().scrollToPosition(0);
    }

    private final void Ba() {
        boolean z16 = !this.isAllSelectMode;
        this.isAllSelectMode = z16;
        nc.ap apVar = null;
        if (z16) {
            nc.ap apVar2 = this.operateViewModel;
            if (apVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                apVar = apVar2;
            }
            apVar.M1();
        } else {
            nc.ap apVar3 = this.operateViewModel;
            if (apVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                apVar = apVar3;
            }
            apVar.h2();
        }
        QLog.i(getTAG(), 1, "handleClickAllSelectOperate  isAllSelectMode = " + this.isAllSelectMode);
    }

    private final void Da() {
        CommonGridItemData itemData;
        com.qzone.reborn.albumx.common.bean.a batchBean;
        CommonBatchInfo batchInfo;
        nc.y yVar = this.albumViewModel;
        nc.y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        xa.b value = yVar.y2().getValue();
        CommonStTimeLineEvent timeLineEvent = (value == null || (itemData = value.getItemData()) == null || (batchBean = itemData.getBatchBean()) == null || (batchInfo = batchBean.getBatchInfo()) == null) ? null : batchInfo.getTimeLineEvent();
        nc.y yVar3 = this.albumViewModel;
        if (yVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            yVar2 = yVar3;
        }
        yVar2.x2().postValue(timeLineEvent);
    }

    private final void Fa(CommonAlbumInfo albumInfo) {
        nc.y yVar = this.albumViewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        if (!yVar.N1().isEmpty() && Ga()) {
            G9().setVisibility(0);
        } else {
            G9().setVisibility(8);
        }
        if (Qa() || Pa()) {
            H9().setVisibility(0);
            return;
        }
        ViewGroup.LayoutParams layoutParams = G9().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
        G9().setLayoutParams(layoutParams2);
        H9().setVisibility(8);
    }

    private final boolean Ga() {
        nc.y yVar = this.albumViewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        ArrayList<Integer> value = yVar.E2().getValue();
        if (value == null) {
            return false;
        }
        return value.contains(11) || value.contains(12) || value.contains(14) || value.contains(15) || value.contains(16) || value.contains(17) || value.contains(18);
    }

    private final void Ha(View rootView) {
        com.qzone.reborn.albumx.common.viewmodel.b bVar;
        nc.y yVar = null;
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, rootView, null);
        if (cVar == null || (bVar = cVar.Ne()) == null) {
            bVar = null;
        } else {
            bVar.M1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.as
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailTitlePart.Ia(QZAlbumxAlbumDetailTitlePart.this, (CommonAlbumInfo) obj);
                }
            });
            bVar.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.at
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailTitlePart.Ja(QZAlbumxAlbumDetailTitlePart.this, (UIStateData) obj);
                }
            });
        }
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        this.albumViewModel = (nc.y) bVar;
        ViewModel viewModel = getViewModel(nc.ap.class);
        final nc.ap apVar = (nc.ap) viewModel;
        apVar.d2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailTitlePart.Ka(QZAlbumxAlbumDetailTitlePart.this, (Boolean) obj);
            }
        });
        apVar.a2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailTitlePart.La(QZAlbumxAlbumDetailTitlePart.this, (Integer) obj);
            }
        });
        apVar.c2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailTitlePart.Ma(QZAlbumxAlbumDetailTitlePart.this, apVar, (Unit) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026\n            })\n        }");
        this.operateViewModel = apVar;
        nc.y yVar2 = this.albumViewModel;
        if (yVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            yVar = yVar2;
        }
        MutableLiveData<Boolean> S2 = yVar.S2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailTitlePart$initData$3
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
            public final void invoke2(Boolean bool) {
                QZAlbumxAlbumDetailTitlePart.this.F9().setExpanded(!bool.booleanValue());
                QZAlbumxAlbumDetailTitlePart.this.L9().setNestedScrollingEnabled(!bool.booleanValue());
            }
        };
        S2.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailTitlePart.Na(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(QZAlbumxAlbumDetailTitlePart this$0, CommonAlbumInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9().setText(it.getName());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Fa(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(QZAlbumxAlbumDetailTitlePart this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Collection collection = (Collection) uIStateData.getData();
        ImageView imageView = null;
        if (!(collection == null || collection.isEmpty())) {
            ImageView imageView2 = this$0.ivCalendar;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this$0.ivCalendar;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(QZAlbumxAlbumDetailTitlePart this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Va(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(QZAlbumxAlbumDetailTitlePart this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Wa(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(QZAlbumxAlbumDetailTitlePart this$0, nc.ap apVar, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean value = apVar.d2().getValue();
        Intrinsics.checkNotNull(value);
        this$0.Va(value.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Oa(CommonAlbumInfo updatedAlbum) {
        CommonLoverAlbumMeta loverAlbum;
        CommonFamilyAlbumMeta familyAlbum;
        nc.y yVar = this.albumViewModel;
        String str = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        CommonAlbumInfo value = yVar.M1().getValue();
        if (!(value != null && value.getQzAlbumType() == updatedAlbum.getQzAlbumType())) {
            return true;
        }
        nc.y yVar2 = this.albumViewModel;
        if (yVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar2 = null;
        }
        CommonAlbumInfo value2 = yVar2.M1().getValue();
        if (!Intrinsics.areEqual((value2 == null || (familyAlbum = value2.getFamilyAlbum()) == null) ? null : familyAlbum.getBirthTime(), updatedAlbum.getFamilyAlbum().getBirthTime())) {
            if (updatedAlbum.getDesc().length() == 0) {
                return true;
            }
        }
        nc.y yVar3 = this.albumViewModel;
        if (yVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar3 = null;
        }
        CommonAlbumInfo value3 = yVar3.M1().getValue();
        if (value3 != null && (loverAlbum = value3.getLoverAlbum()) != null) {
            str = loverAlbum.getFallInLoveTime();
        }
        if (!Intrinsics.areEqual(str, updatedAlbum.getLoverAlbum().getFallInLoveTime())) {
            if (updatedAlbum.getDesc().length() == 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean Pa() {
        nc.y yVar = this.albumViewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        ArrayList<Integer> value = yVar.T1().getValue();
        if (value != null) {
            return value.contains(19);
        }
        return false;
    }

    private final boolean Qa() {
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        nc.y yVar = this.albumViewModel;
        nc.y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        CommonAlbumInfo value = yVar.M1().getValue();
        if (!((value == null || (commonAlbumAccessPermission = value.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String()) == null || commonAlbumAccessPermission.getPermissionType() != 3) ? false : true)) {
            nc.y yVar3 = this.albumViewModel;
            if (yVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            } else {
                yVar2 = yVar3;
            }
            ArrayList<Integer> value2 = yVar2.T1().getValue();
            if (value2 != null ? value2.contains(13) : false) {
                return true;
            }
        }
        return false;
    }

    private final void Ra() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        final ArrayList arrayList = new ArrayList();
        if (Pa()) {
            arrayList.add(Integer.valueOf(R.string.f134729l));
            va("em_qz_more_edit_album", actionSheet.getActionContentView());
        }
        if (Qa()) {
            arrayList.add(Integer.valueOf(R.string.f134739m));
            va("em_qz_more_share", actionSheet.getActionContentView());
        }
        pa(actionSheet, arrayList);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ay
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QZAlbumxAlbumDetailTitlePart.Ta(QZAlbumxAlbumDetailTitlePart.this, actionSheet, arrayList, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        va("em_qz_more_cancel", actionSheet.getActionContentView());
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.az
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAlbumDetailTitlePart.Sa(QZAlbumxAlbumDetailTitlePart.this, actionSheet, view);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(QZAlbumxAlbumDetailTitlePart this$0, ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        this$0.ua("em_qz_more_cancel", view);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(QZAlbumxAlbumDetailTitlePart this$0, ActionSheet actionSheet, List itemIdList, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(itemIdList, "$itemIdList");
        this$0.za(view, actionSheet, i3, itemIdList);
    }

    private final void Ua(View view) {
        nc.y yVar = this.albumViewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        yVar.H2().postValue(Boolean.TRUE);
        ua("em_qz_more_share", view);
    }

    private final void Va(boolean isOperateMode) {
        RelativeLayout relativeLayout = null;
        nc.ap apVar = null;
        if (isOperateMode) {
            RelativeLayout relativeLayout2 = this.rlNormalTitleLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlNormalTitleLayout");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
            RelativeLayout relativeLayout3 = this.rlOperateLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
                relativeLayout3 = null;
            }
            relativeLayout3.setVisibility(0);
            nc.ap apVar2 = this.operateViewModel;
            if (apVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
                apVar2 = null;
            }
            if (apVar2.e2()) {
                N9().setText(com.qzone.util.l.a(R.string.snr));
            } else {
                N9().setText(com.qzone.util.l.a(R.string.sni));
            }
            nc.ap apVar3 = this.operateViewModel;
            if (apVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            } else {
                apVar = apVar3;
            }
            this.isAllSelectMode = apVar.e2();
        } else {
            RelativeLayout relativeLayout4 = this.rlNormalTitleLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlNormalTitleLayout");
                relativeLayout4 = null;
            }
            relativeLayout4.setVisibility(0);
            RelativeLayout relativeLayout5 = this.rlOperateLayout;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
            } else {
                relativeLayout = relativeLayout5;
            }
            relativeLayout.setVisibility(8);
            this.isAllSelectMode = false;
            N9().setText(com.qzone.util.l.a(R.string.sni));
        }
        VideoReport.traversePage(getPartRootView());
    }

    private final Map<String, Object> getReportParams() {
        String str;
        CommonAlbumInfo value;
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        String name;
        CommonAlbumInfo value2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        nc.y yVar = this.albumViewModel;
        Integer num = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        mc.d dVar = mc.d.f416543a;
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        MutableLiveData<CommonAlbumInfo> M1 = yVar.M1();
        linkedHashMap.put("topic_type", Integer.valueOf(dVar.a(cVar.c((M1 == null || (value2 = M1.getValue()) == null) ? null : Integer.valueOf(value2.getQzAlbumType())))));
        CommonAlbumInfo value3 = yVar.M1().getValue();
        String str2 = "";
        if (value3 == null || (str = value3.getAlbumId()) == null) {
            str = "";
        }
        linkedHashMap.put("albumid", str);
        CommonAlbumInfo value4 = yVar.M1().getValue();
        if (value4 != null && (name = value4.getName()) != null) {
            str2 = name;
        }
        linkedHashMap.put("album_name", str2);
        MutableLiveData<CommonAlbumInfo> M12 = yVar.M1();
        linkedHashMap.put("user_identity", Integer.valueOf(dVar.b(M12 != null ? M12.getValue() : null)));
        MutableLiveData<CommonAlbumInfo> M13 = yVar.M1();
        if (M13 != null && (value = M13.getValue()) != null && (commonAlbumAccessPermission = value.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String()) != null) {
            num = Integer.valueOf(commonAlbumAccessPermission.getPermissionType());
        }
        linkedHashMap.put(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, Integer.valueOf(dVar.c(num)));
        return linkedHashMap;
    }

    private final void pa(ActionSheet actionSheet, List<Integer> itemIdList) {
        Iterator<T> it = itemIdList.iterator();
        while (it.hasNext()) {
            actionSheet.addButton(((Number) it.next()).intValue());
        }
    }

    private final void qa() {
        ViewGroup.LayoutParams layoutParams = I9().getLayoutParams();
        if (layoutParams.height != ef.d.b(26)) {
            layoutParams.height = ef.d.b(26);
            layoutParams.width = ef.d.b(26);
            I9().setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = G9().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams.rightMargin != ef.d.b(0)) {
            marginLayoutParams.rightMargin = ef.d.b(0);
            G9().setLayoutParams(marginLayoutParams);
        }
        ImageView imageView = this.ivCalendar;
        FrameLayout frameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (marginLayoutParams2.rightMargin != ef.d.b(0)) {
            marginLayoutParams2.rightMargin = ef.d.b(0);
            ImageView imageView2 = this.ivCalendar;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
                imageView2 = null;
            }
            imageView2.setLayoutParams(marginLayoutParams2);
        }
        FrameLayout frameLayout2 = this.flTransmitLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            frameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams4 = frameLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams4;
        if (marginLayoutParams3.rightMargin != ef.d.b(0)) {
            marginLayoutParams3.rightMargin = ef.d.b(0);
            FrameLayout frameLayout3 = this.flTransmitLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setLayoutParams(marginLayoutParams3);
        }
    }

    private final void ra() {
        FrameLayout frameLayout = this.flTitleBar;
        RelativeLayout relativeLayout = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTitleBar");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = wa();
        FrameLayout frameLayout2 = this.flTitleBar;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTitleBar");
            frameLayout2 = null;
        }
        frameLayout2.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = this.rlOperateContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlOperateContainer");
            relativeLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = relativeLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
        layoutParams3.topMargin = com.qzone.util.ar.n(getContext());
        RelativeLayout relativeLayout3 = this.rlOperateContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlOperateContainer");
            relativeLayout3 = null;
        }
        relativeLayout3.setLayoutParams(layoutParams3);
        RelativeLayout relativeLayout4 = this.rlNormalTitleLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlNormalTitleLayout");
            relativeLayout4 = null;
        }
        ViewGroup.LayoutParams layoutParams4 = relativeLayout4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams4;
        layoutParams5.topMargin = com.qzone.util.ar.n(getContext());
        RelativeLayout relativeLayout5 = this.rlNormalTitleLayout;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlNormalTitleLayout");
        } else {
            relativeLayout = relativeLayout5;
        }
        relativeLayout.setLayoutParams(layoutParams5);
    }

    private final void sa() {
        ViewGroup.LayoutParams layoutParams = I9().getLayoutParams();
        if (layoutParams.height != ef.d.b(20)) {
            layoutParams.height = ef.d.b(20);
            layoutParams.width = ef.d.b(20);
            I9().setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = G9().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams.rightMargin != ef.d.b(8)) {
            marginLayoutParams.rightMargin = ef.d.b(8);
            G9().setLayoutParams(marginLayoutParams);
        }
        ImageView imageView = this.ivCalendar;
        FrameLayout frameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (marginLayoutParams2.rightMargin != ef.d.b(8)) {
            marginLayoutParams2.rightMargin = ef.d.b(8);
            ImageView imageView2 = this.ivCalendar;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
                imageView2 = null;
            }
            imageView2.setLayoutParams(marginLayoutParams2);
        }
        FrameLayout frameLayout2 = this.flTransmitLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            frameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams4 = frameLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams4;
        if (marginLayoutParams3.rightMargin != ef.d.b(8)) {
            marginLayoutParams3.rightMargin = ef.d.b(8);
            FrameLayout frameLayout3 = this.flTransmitLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flTransmitLayout");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setLayoutParams(marginLayoutParams3);
        }
    }

    private final void ta() {
        fo.c.o(G9(), "em_qz_batch_operation_icon", null);
        fo.c.o(H9(), "em_qz_more", null);
        fo.c.o(N9(), "em_qz_batch_operation_select_all", null);
        fo.c.o(P9(), "em_qz_batch_operation_cancel", null);
        ImageView imageView = this.ivCalendar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            imageView = null;
        }
        fo.c.o(imageView, "em_qz_time_shaft", null);
    }

    private final int wa() {
        return com.qzone.util.ar.n(getContext()) + com.qzone.util.ar.d(50.0f);
    }

    private final void xa(View view) {
        String str;
        ua("em_qz_more_edit_album", view);
        nc.y yVar = this.albumViewModel;
        nc.y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        CommonAlbumInfo value = yVar.M1().getValue();
        if (value == null) {
            RFWLog.w("QZAlbumxAlbumDetailTitlePart", RFWLog.USR, "handEditAlbum, albumInfo is null ");
            return;
        }
        vb.b x16 = ho.i.x();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        nc.y yVar3 = this.albumViewModel;
        if (yVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar3 = null;
        }
        QZAlbumxAlbumDetailInitBean mInitBean = yVar3.getMInitBean();
        if (mInitBean == null || (str = mInitBean.getUin()) == null) {
            str = "";
        }
        String str2 = str;
        nc.y yVar4 = this.albumViewModel;
        if (yVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar4 = null;
        }
        ArrayList<Integer> value2 = yVar4.T1().getValue();
        boolean contains = value2 != null ? value2.contains(12) : false;
        nc.y yVar5 = this.albumViewModel;
        if (yVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            yVar2 = yVar5;
        }
        x16.f(activity, 999, new CommonAlbumEditInitBean(str2, value, true, contains, yVar2.W1()));
    }

    private final void za(View clickedView, ActionSheet actionSheet, int which, List<Integer> itemIdList) {
        if (which >= itemIdList.size() || which < 0) {
            return;
        }
        switch (itemIdList.get(which).intValue()) {
            case R.string.f134729l /* 1745354939 */:
                xa(clickedView);
                break;
            case R.string.f134739m /* 1745354940 */:
                Ua(clickedView);
                break;
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart
    public void D9() {
        super.D9();
        Q9().setVisibility(8);
        J9().setVisibility(0);
        nc.y yVar = this.albumViewModel;
        ImageView imageView = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        CommonAlbumInfo value = yVar.M1().getValue();
        if (value != null) {
            J9().setText(value.getName());
        }
        RelativeLayout relativeLayout = this.rlOperateLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
            relativeLayout = null;
        }
        relativeLayout.setBackground(null);
        qa();
        ImageView imageView2 = this.ivCalendar;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            imageView2 = null;
        }
        imageView2.setBackgroundResource(0);
        ImageView imageView3 = this.ivCalendar;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
        } else {
            imageView = imageView3;
        }
        rn.h.a(imageView, "qui_calendar_default", R.color.qui_common_icon_primary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart
    public void E9() {
        super.E9();
        Q9().setVisibility(0);
        J9().setVisibility(8);
        ImageView imageView = null;
        if (this.isAllSelectMode) {
            RelativeLayout relativeLayout = this.rlOperateLayout;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlOperateLayout");
                relativeLayout = null;
            }
            relativeLayout.setBackground(getContext().getDrawable(R.drawable.f13730n));
        }
        sa();
        ImageView imageView2 = this.ivCalendar;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            imageView2 = null;
        }
        imageView2.setBackgroundResource(R.drawable.f169970);
        ImageView imageView3 = this.ivCalendar;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
        } else {
            imageView = imageView3;
        }
        rn.h.a(imageView, "qui_calendar_default", R.color.qui_common_text_allwhite_primary);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RFWLog.i("QZAlbumxAlbumDetailTitlePart", RFWLog.USR, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (resultCode != -1 || data == null) {
            return;
        }
        CommonAlbumInfo commonAlbumInfo = (CommonAlbumInfo) data.getParcelableExtra("EDIT_ALBUM_INFO");
        if (commonAlbumInfo != null) {
            if (Oa(commonAlbumInfo)) {
                SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxUpdateAlbumEvent(commonAlbumInfo.getAlbumId()));
            } else {
                nc.y yVar = this.albumViewModel;
                if (yVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                    yVar = null;
                }
                yVar.M1().postValue(commonAlbumInfo);
            }
        }
        CommonAlbumInfo commonAlbumInfo2 = (CommonAlbumInfo) data.getParcelableExtra("KEY_DELETE_ALBUM_INFO");
        if (commonAlbumInfo2 != null) {
            RFWLog.i("QZAlbumxAlbumDetailTitlePart", RFWLog.USR, "onActivityResult, delete album, albumInfo:" + commonAlbumInfo2);
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        nc.ap apVar = this.operateViewModel;
        if (apVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            apVar = null;
        }
        if (Intrinsics.areEqual(apVar.d2().getValue(), Boolean.TRUE)) {
            Ea();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        super.onClick(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.lvo) {
            Ra();
        } else if (valueOf != null && valueOf.intValue() == R.id.fyg) {
            Ca();
        } else if (valueOf != null && valueOf.intValue() == R.id.nia) {
            Ea();
        } else if (valueOf != null && valueOf.intValue() == R.id.nhv) {
            Ba();
        } else if (valueOf != null && valueOf.intValue() == R.id.ktv) {
            Aa();
        } else if (valueOf != null && valueOf.intValue() == R.id.lvl) {
            Da();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailTitlePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        G9().setVisibility(8);
        H9().setVisibility(8);
        View findViewById = rootView.findViewById(R.id.jor);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.fl_title_bar)");
        this.flTitleBar = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ner);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rl_normal_title_layout)");
        this.rlNormalTitleLayout = (RelativeLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.net);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rl_operate_layout)");
        this.rlOperateLayout = (RelativeLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.nes);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.rl_operate_container)");
        this.rlOperateContainer = (RelativeLayout) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f162954ni4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.tv_batch_operate_text)");
        ca((TextView) findViewById5);
        View findViewById6 = rootView.findViewById(R.id.nhv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.tv_all_select_text)");
        ba((TextView) findViewById6);
        View findViewById7 = rootView.findViewById(R.id.n6a);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026mate_title_transmit_view)");
        this.flTransmitLayout = (FrameLayout) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.lvl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.iv_title_calendar)");
        ImageView imageView = (ImageView) findViewById8;
        this.ivCalendar = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCalendar");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        Ha(rootView);
        ta();
        ra();
    }

    private final void Ca() {
        Va(true);
        nc.ap apVar = this.operateViewModel;
        if (apVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            apVar = null;
        }
        apVar.d2().postValue(Boolean.TRUE);
        QLog.i(getTAG(), 1, "handleClickBatchOperate");
    }

    private final void Ea() {
        Va(false);
        nc.ap apVar = this.operateViewModel;
        if (apVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
            apVar = null;
        }
        apVar.Q1();
        QLog.i(getTAG(), 1, "handleClickCancelOperate");
    }

    private final void Wa(int num) {
        if (num > 0) {
            O9().setText(getContext().getResources().getString(R.string.sop, Integer.valueOf(num)));
        } else {
            O9().setText(getContext().getResources().getString(R.string.sp6));
        }
    }

    private final void ua(String emId, View view) {
        if (view == null) {
            return;
        }
        fo.c.e(emId, "pg_qz_photo_list_new", view, getReportParams());
    }

    private final void va(String emId, View view) {
        if (view == null) {
            return;
        }
        fo.c.g(emId, "pg_qz_photo_list_new", view, getReportParams());
    }
}
