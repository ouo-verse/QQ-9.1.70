package com.tencent.mobileqq.wink.picker.qcircle.templatelibrary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import e93.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JV\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00020\n2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\n \u0016*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\n \u0016*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n \u0016*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/templatelibrary/f;", "Lcom/tencent/mobileqq/wink/picker/core/b;", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "u", "t", "v", "localMedia", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "onItemClick", "onItemSelect", "l", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "E", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "thumbImg", "G", "Landroid/view/View;", "selectNumberLayout", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "selectedIndicator", "I", "videoDurationText", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f extends com.tencent.mobileqq.wink.picker.core.b {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final WinkSelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView thumbImg;

    /* renamed from: G, reason: from kotlin metadata */
    private final View selectNumberLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView selectedIndicator;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView videoDurationText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        this.selectedMediaViewModel = selectedMediaViewModel;
        this.thumbImg = (ImageView) itemView.findViewById(R.id.f96965j4);
        this.selectNumberLayout = itemView.findViewById(R.id.f81954fk);
        this.selectedIndicator = (TextView) itemView.findViewById(R.id.f82544h6);
        this.videoDurationText = (TextView) itemView.findViewById(R.id.f1170570e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 onItemClick, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onItemClick.invoke(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 onItemClick, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onItemClick.invoke(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 onItemSelect, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(onItemSelect, "$onItemSelect");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onItemSelect.invoke(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void s() {
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_CONTENT_TYPE, TuxQuestionType.QUESTION_OPTION_CHECKBOX);
        com.tencent.mobileqq.wink.picker.report.a.b(this.selectNumberLayout, "em_xsj_content", hashMap, null, false, 24, null);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_CONTENT_TYPE, AssetExtension.SCENE_THUMBNAIL);
        com.tencent.mobileqq.wink.picker.report.a.b(this.itemView, "em_xsj_content", hashMap2, null, false, 24, null);
    }

    private final void t(LocalMediaInfo info) {
        if (info.selectStatus == 1) {
            this.selectedIndicator.setVisibility(0);
        } else {
            this.selectedIndicator.setVisibility(4);
        }
    }

    private final void u(LocalMediaInfo info) {
        float f16;
        this.thumbImg.setFocusable(true);
        if (i.G(info)) {
            this.thumbImg.setContentDescription("\u56fe\u7247");
        } else if (i.I(info)) {
            this.thumbImg.setContentDescription("\u89c6\u9891");
        }
        ImageView thumbImg = this.thumbImg;
        Intrinsics.checkNotNullExpressionValue(thumbImg, "thumbImg");
        ViewExKt.n(thumbImg, info);
        float f17 = 1.0f;
        if (i.x(info) == 0 && this.selectedMediaViewModel.b2()) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        if (info.selectStatus != 1) {
            f17 = f16;
        }
        this.thumbImg.setAlpha(f17);
    }

    private final void v(LocalMediaInfo info) {
        if (info.mMediaType == 0) {
            this.videoDurationText.setVisibility(4);
        } else {
            this.videoDurationText.setVisibility(0);
            this.videoDurationText.setText(QAlbumUtil.formatTimeToString(info.mDuration));
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.b
    public void l(@NotNull LocalMediaInfo localMedia, @NotNull final Function1<? super View, Unit> onItemClick, @NotNull final Function1<? super View, Unit> onItemSelect) {
        Intrinsics.checkNotNullParameter(localMedia, "localMedia");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemSelect, "onItemSelect");
        u(localMedia);
        t(localMedia);
        v(localMedia);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.p(Function1.this, view);
            }
        });
        this.thumbImg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.q(Function1.this, view);
            }
        });
        this.selectNumberLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.r(Function1.this, view);
            }
        });
        s();
    }
}
