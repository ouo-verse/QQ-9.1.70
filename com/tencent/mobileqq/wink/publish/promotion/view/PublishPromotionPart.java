package com.tencent.mobileqq.wink.publish.promotion.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.multiselect.PublishMultiSelectPanelPart;
import com.tencent.mobileqq.wink.publish.multiselect.WinkMultiSelectData;
import com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.utils.ax;
import com.tencent.mobileqq.wink.view.WinkPressEffectImageView;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.utils.LiveDataExtKt;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import o93.PromotionChannelItem;
import o93.PromotionPartInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002JH\u0010#\u001aB\u0012\f\u0012\n  *\u0004\u0018\u00010\f0\f\u0012\f\u0012\n  *\u0004\u0018\u00010!0!  * \u0012\f\u0012\n  *\u0004\u0018\u00010\f0\f\u0012\f\u0012\n  *\u0004\u0018\u00010!0!\u0018\u00010\"0\u001fH\u0002J\b\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0016R#\u0010.\u001a\n  *\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u00103\u001a\n  *\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R#\u00108\u001a\n  *\u0004\u0018\u000104048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010;R\u0016\u0010J\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010?R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001d\u0010X\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010+\u001a\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/promotion/view/PublishPromotionPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "oa", "initData", "ua", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "", "ra", "Aa", "", "jumpSchema", "sa", "currentSelectedItem", "ea", "Leipc/EIPCResult;", "ipcResult", "Lorg/json/JSONObject;", "Ba", "Z9", "aa", "ba", "ca", "da", "Ea", "Da", "Lo93/a;", "selectedChannel", "Ca", "", "kotlin.jvm.PlatformType", "", "", "ha", "B9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel;", "d", "Lkotlin/Lazy;", "la", "()Lcom/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel;", "promotionViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "e", "ma", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "publishViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "f", LocaleUtils.L_JAPANESE, "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "partsStateViewModel", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", "containerView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "promotionTitleView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "promotionDescView", "Lcom/tencent/mobileqq/wink/view/WinkPressEffectImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/view/WinkPressEffectImageView;", "arrowRightIcon", "D", "selectedItemContainer", "E", "selectedPromotionNameView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "editItemView", "G", "deleteItemView", "Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart;", "H", "Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart;", "multiSelectPart", "I", "ia", "()Landroid/view/View;", "multiSelectPartReportView", "<init>", "()V", "J", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishPromotionPart extends com.tencent.mobileqq.wink.publish.part.j {

    /* renamed from: C, reason: from kotlin metadata */
    private WinkPressEffectImageView arrowRightIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private RelativeLayout selectedItemContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView selectedPromotionNameView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView editItemView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView deleteItemView;

    /* renamed from: H, reason: from kotlin metadata */
    private PublishMultiSelectPanelPart multiSelectPart;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy multiSelectPartReportView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy promotionViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy partsStateViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout containerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView promotionTitleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView promotionDescView;

    public PublishPromotionPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PublishPromotionViewModel>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$promotionViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishPromotionViewModel invoke() {
                return (PublishPromotionViewModel) PublishPromotionPart.this.getViewModel(PublishPromotionViewModel.class);
            }
        });
        this.promotionViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PublishViewModel>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishViewModel invoke() {
                return (PublishViewModel) PublishPromotionPart.this.getViewModel(PublishViewModel.class);
            }
        });
        this.publishViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PartsStateViewModel>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$partsStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PartsStateViewModel invoke() {
                return (PartsStateViewModel) PublishPromotionPart.this.getViewModel(PartsStateViewModel.class);
            }
        });
        this.partsStateViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$multiSelectPartReportView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                PublishMultiSelectPanelPart publishMultiSelectPanelPart;
                publishMultiSelectPanelPart = PublishPromotionPart.this.multiSelectPart;
                if (publishMultiSelectPanelPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiSelectPart");
                    publishMultiSelectPanelPart = null;
                }
                return publishMultiSelectPanelPart.J9();
            }
        });
        this.multiSelectPartReportView = lazy4;
    }

    private final void Aa() {
        int collectionSizeOrDefault;
        boolean isBlank;
        String nightIconUrl;
        Object first;
        PublishSettingItemState value = ja().g2().getValue();
        boolean z16 = false;
        if (value != null && !value.getSelectable()) {
            z16 = true;
        }
        if (z16) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            com.tencent.mobileqq.wink.publish.util.f.a(context, ja().k2());
            return;
        }
        PromotionPartInfo value2 = la().W1().getValue();
        if (value2 == null) {
            return;
        }
        final List<PromotionChannelItem> c16 = value2.c();
        if (c16.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) c16);
            sa(((PromotionChannelItem) first).getJumpUrl());
            return;
        }
        List<PromotionChannelItem> list = c16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (PromotionChannelItem promotionChannelItem : list) {
            if (!ax.a()) {
                nightIconUrl = promotionChannelItem.getIconUrl();
            } else {
                nightIconUrl = promotionChannelItem.getNightIconUrl();
            }
            arrayList.add(new WinkMultiSelectData(null, nightIconUrl, promotionChannelItem.getChannelMsg(), false, 1, null));
        }
        PublishMultiSelectPanelPart publishMultiSelectPanelPart = this.multiSelectPart;
        if (publishMultiSelectPanelPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiSelectPart");
            publishMultiSelectPanelPart = null;
        }
        PublishMultiSelectPanelPart.Style style = PublishMultiSelectPanelPart.Style.STYLE_FORWARD;
        String partName = value2.getPartName();
        isBlank = StringsKt__StringsJVMKt.isBlank(partName);
        if (isBlank) {
            partName = getContext().getString(R.string.f2190365b);
            Intrinsics.checkNotNullExpressionValue(partName, "context.getString(R.stri\u2026blish_add_promotion_item)");
        }
        publishMultiSelectPanelPart.R9(style, partName, arrayList, new Function1<List<? extends WinkMultiSelectData>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$onContainerViewClicked$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends WinkMultiSelectData> list2) {
                invoke2((List<WinkMultiSelectData>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<WinkMultiSelectData> resultList) {
                Intrinsics.checkNotNullParameter(resultList, "resultList");
                List<PromotionChannelItem> list2 = c16;
                PublishPromotionPart publishPromotionPart = this;
                int i3 = 0;
                for (Object obj : resultList) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (((WinkMultiSelectData) obj).getIsChecked()) {
                        PromotionChannelItem promotionChannelItem2 = list2.get(i3);
                        publishPromotionPart.sa(promotionChannelItem2.getJumpUrl());
                        publishPromotionPart.Ca(promotionChannelItem2);
                    }
                    i3 = i16;
                }
            }
        });
        Da();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject Ba(EIPCResult ipcResult) {
        boolean z16;
        boolean isBlank;
        String string = ipcResult.data.getString("data");
        if (string != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                try {
                    return new JSONObject(string);
                } catch (JSONException e16) {
                    QLog.e("PublishPromotionPart", 1, e16, new Object[0]);
                    return null;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca(PromotionChannelItem selectedChannel) {
        Map<String, Object> ha5 = ha();
        ha5.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROMOTION_SELECT_OPTION, selectedChannel.getChannelMsg());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", ia(), ha5);
    }

    private final void Da() {
        VideoReport.reportEvent("ev_xsj_abnormal_imp", ia(), ha());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea() {
        TextView textView = this.selectedPromotionNameView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedPromotionNameView");
            textView = null;
        }
        VideoReport.setElementId(textView, WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_PROMOTION_ITEM);
        Map<String, Object> ha5 = ha();
        TextView textView3 = this.selectedPromotionNameView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedPromotionNameView");
        } else {
            textView2 = textView3;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", textView2, ha5);
    }

    private final void Z9() {
        la().i2(null, PublishPromotionViewModel.PromotionSource.SOURCE_DELETE);
    }

    private final void aa() {
        RelativeLayout relativeLayout = this.containerView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        VideoReport.setElementId(relativeLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_PROMOTION);
        RelativeLayout relativeLayout3 = this.containerView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        VideoReport.setElementParams(relativeLayout2, ha());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        ImageView imageView = this.deleteItemView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteItemView");
            imageView = null;
        }
        VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_REMOVE_PUBLISH_PROMOTION);
        ImageView imageView3 = this.deleteItemView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteItemView");
        } else {
            imageView2 = imageView3;
        }
        VideoReport.setElementParams(imageView2, ha());
    }

    private final void ca() {
        ImageView imageView = this.editItemView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editItemView");
            imageView = null;
        }
        VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_PUBLISH_PROMOTION);
        ImageView imageView3 = this.editItemView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editItemView");
        } else {
            imageView2 = imageView3;
        }
        VideoReport.setElementParams(imageView2, ha());
    }

    private final void da() {
        VideoReport.setElementId(ia(), WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_PROMOTION_SELECT_PANEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(PromotionParams currentSelectedItem) {
        String builder = Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter(ISchemeApi.KEY_IOS_SRC_TYPE, "internal").appendQueryParameter("version", "1").appendQueryParameter("target", "35").appendQueryParameter(ReportDataBuilder.KEY_PRODUCT_ID, currentSelectedItem.getId()).appendQueryParameter("saas_product_id", currentSelectedItem.getSaasProductId()).appendQueryParameter(WadlProxyConsts.CHANNEL, "2").appendQueryParameter("goods_type", String.valueOf(currentSelectedItem.getBusinessType())).appendQueryParameter("product_type", currentSelectedItem.getPlatformType()).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(\"mqqapi://ecommerc\u2026)\n            .toString()");
        Bundle bundle = new Bundle();
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_SCHEMA_TO_EC_PAGE, builder);
        QIPCClientHelper.getInstance().getClient().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_SCHEMA_JUMP_TO_EC_PAGE, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.i
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                PublishPromotionPart.ga(PublishPromotionPart.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(PublishPromotionPart this$0, EIPCResult eipcResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(eipcResult, "eipcResult");
        JSONObject Ba = this$0.Ba(eipcResult);
        if (Ba == null) {
            QLog.e("PublishPromotionPart", 1, "editSelectedPromotionItem: parse result failed.");
            return;
        }
        p93.a aVar = p93.a.f425806a;
        if (!this$0.la().j2(aVar.b(Ba), aVar.c(Ba), aVar.a(Ba))) {
            QLog.i("PublishPromotionPart", 1, "updatePromotionParamsInfo failed. not matched or skipped.");
        }
    }

    private final Map<String, Object> ha() {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE);
        Pair<PromotionParams, PublishPromotionViewModel.PromotionSource> value = la().c2().getValue();
        if (value != null) {
            PromotionParams first = value.getFirst();
            if (first != null) {
                buildElementParams.put("xsj_business_ad_id", first.getId());
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROMOTION_ITEM_NAME, first.getName());
            }
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROMOTION_ITEM_FROM, String.valueOf(value.getSecond().getValue()));
        }
        return buildElementParams;
    }

    private final View ia() {
        return (View) this.multiSelectPartReportView.getValue();
    }

    private final void initData() {
        boolean z16;
        Intent intent;
        if (ma().f326018r0 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            LiveData<List<ha3.b>> liveData = ma().H;
            Intrinsics.checkNotNullExpressionValue(liveData, "publishViewModel.mDraftContent");
            LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "hostFragment.viewLifecycleOwner");
            LiveDataExtKt.a(liveData, viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PublishPromotionPart.na(PublishPromotionPart.this, (List) obj);
                }
            });
            return;
        }
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            la().g2(intent);
        }
        la().h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PartsStateViewModel ja() {
        return (PartsStateViewModel) this.partsStateViewModel.getValue();
    }

    private final PublishPromotionViewModel la() {
        return (PublishPromotionViewModel) this.promotionViewModel.getValue();
    }

    private final PublishViewModel ma() {
        return (PublishViewModel) this.publishViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(PublishPromotionPart this$0, List list) {
        boolean z16;
        ha3.b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (bVar = (ha3.b) list.get(0)) != null) {
            this$0.la().f2(bVar);
        }
    }

    private final void oa(View rootView) {
        Part part = getPartManager().getPart(PublishMultiSelectPanelPart.class.getName());
        Intrinsics.checkNotNull(part, "null cannot be cast to non-null type com.tencent.mobileqq.wink.publish.multiselect.PublishMultiSelectPanelPart");
        this.multiSelectPart = (PublishMultiSelectPanelPart) part;
        View findViewById = rootView.findViewById(R.id.f32040so);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026circle_publish_promotion)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.containerView = relativeLayout;
        ImageView imageView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = this.containerView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout2 = null;
        }
        ViewUtilsKt.e(relativeLayout2, 500L, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishPromotionPart.pa(PublishPromotionPart.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.f28670jk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.promotion_title)");
        this.promotionTitleView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f28660jj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.promotion_desc)");
        this.promotionDescView = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.svy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.arrow_right_icon)");
        this.arrowRightIcon = (WinkPressEffectImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f82724hn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026cted_promotion_container)");
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById5;
        this.selectedItemContainer = relativeLayout3;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedItemContainer");
            relativeLayout3 = null;
        }
        relativeLayout3.setVisibility(8);
        View findViewById6 = rootView.findViewById(R.id.f111136ke);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026_selected_promotion_name)");
        this.selectedPromotionNameView = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.y7_);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.iv_promotion_edit)");
        this.editItemView = (ImageView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.y79);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.iv_promotion_delete)");
        ImageView imageView2 = (ImageView) findViewById8;
        this.deleteItemView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteItemView");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishPromotionPart.qa(PublishPromotionPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(PublishPromotionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Aa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(PublishPromotionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ra(PromotionParams promotionParams) {
        if (promotionParams.getRecallSource() == 2 && promotionParams.getBusinessType() == 101) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(final String jumpSchema) {
        Bundle bundle = new Bundle();
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_SCHEMA_TO_EC_PAGE, jumpSchema);
        QIPCClientHelper.getInstance().getClient().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_SCHEMA_JUMP_TO_EC_PAGE, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.h
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                PublishPromotionPart.ta(PublishPromotionPart.this, jumpSchema, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(PublishPromotionPart this$0, String jumpSchema, EIPCResult eipcResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpSchema, "$jumpSchema");
        Intrinsics.checkNotNullExpressionValue(eipcResult, "eipcResult");
        JSONObject Ba = this$0.Ba(eipcResult);
        if (Ba == null) {
            QLog.e("PublishPromotionPart", 1, "editSelectedPromotionItem: parse result failed.");
            return;
        }
        p93.a aVar = p93.a.f425806a;
        Uri parse = Uri.parse(jumpSchema);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(jumpSchema)");
        PromotionParams d16 = aVar.d(parse, Ba);
        if (d16 != null) {
            this$0.la().i2(d16, PublishPromotionViewModel.PromotionSource.SOURCE_MANUAL_SELECT);
        } else {
            QQToast.makeText(this$0.getContext(), 1, R.string.f216155xj, 0).show();
        }
    }

    private final void ua() {
        LiveData<Pair<PromotionParams, PublishPromotionViewModel.PromotionSource>> c26 = la().c2();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        final PublishPromotionPart$observeLiveData$1 publishPromotionPart$observeLiveData$1 = new PublishPromotionPart$observeLiveData$1(this);
        c26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishPromotionPart.va(Function1.this, obj);
            }
        });
        LiveData<Boolean> U1 = la().U1();
        LifecycleOwner viewLifecycleOwner2 = getHostFragment().getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$observeLiveData$2
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
            public final void invoke2(Boolean enableShowPromotion) {
                PartsStateViewModel ja5;
                ja5 = PublishPromotionPart.this.ja();
                Intrinsics.checkNotNullExpressionValue(enableShowPromotion, "enableShowPromotion");
                ja5.Q2(enableShowPromotion.booleanValue());
            }
        };
        U1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishPromotionPart.wa(Function1.this, obj);
            }
        });
        MediatorLiveData<PublishSettingItemState> g26 = ja().g2();
        LifecycleOwner viewLifecycleOwner3 = getHostFragment().getViewLifecycleOwner();
        final Function1<PublishSettingItemState, Unit> function12 = new Function1<PublishSettingItemState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$observeLiveData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItemState publishSettingItemState) {
                invoke2(publishSettingItemState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItemState publishSettingItemState) {
                RelativeLayout relativeLayout;
                TextView textView;
                TextView textView2;
                TextView textView3;
                QLog.d("PublishPromotionPart", 2, "isPromotionVisible: " + publishSettingItemState.getVisible());
                relativeLayout = PublishPromotionPart.this.containerView;
                TextView textView4 = null;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(publishSettingItemState.getVisible() ? 0 : 8);
                QLog.d("PublishPromotionPart", 2, "isPromotionSelectable: " + publishSettingItemState.getSelectable());
                int i3 = publishSettingItemState.getSelectable() ? R.color.qui_common_text_primary : R.color.qui_common_text_secondary;
                textView = PublishPromotionPart.this.promotionTitleView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promotionTitleView");
                    textView = null;
                }
                textView2 = PublishPromotionPart.this.promotionTitleView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promotionTitleView");
                    textView2 = null;
                }
                textView.setTextColor(textView2.getContext().getColorStateList(i3));
                textView3 = PublishPromotionPart.this.promotionTitleView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promotionTitleView");
                } else {
                    textView4 = textView3;
                }
                textView4.setTextColor(ie0.a.f().g(PublishPromotionPart.this.getContext(), i3, 1000));
            }
        };
        g26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishPromotionPart.xa(Function1.this, obj);
            }
        });
        LiveData<PromotionPartInfo> W1 = la().W1();
        LifecycleOwner viewLifecycleOwner4 = getHostFragment().getViewLifecycleOwner();
        final Function1<PromotionPartInfo, Unit> function13 = new Function1<PromotionPartInfo, Unit>() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart$observeLiveData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PromotionPartInfo promotionPartInfo) {
                invoke2(promotionPartInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PromotionPartInfo promotionPartInfo) {
                TextView textView;
                TextView textView2;
                textView = PublishPromotionPart.this.promotionTitleView;
                TextView textView3 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promotionTitleView");
                    textView = null;
                }
                textView.setText(promotionPartInfo.getPartName());
                textView2 = PublishPromotionPart.this.promotionDescView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promotionDescView");
                } else {
                    textView3 = textView2;
                }
                textView3.setText(promotionPartInfo.getPartDesc());
            }
        };
        W1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishPromotionPart.za(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishPromotionPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        oa(rootView);
        ua();
        initData();
        aa();
        ba();
        ca();
        da();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QIPCClientHelper.getInstance().getClient().disConnect();
    }
}
