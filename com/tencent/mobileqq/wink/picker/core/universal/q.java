package com.tencent.mobileqq.wink.picker.core.universal;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010*\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JV\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00020\u000b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\n \u0017*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n \u0017*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010#\u001a\n \u0017*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\n \u0017*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010)\u001a\n \u0017*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001c\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/q;", "Lcom/tencent/mobileqq/wink/picker/core/b;", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "v", "w", "t", "u", "localMedia", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "onItemClick", "onItemSelect", "l", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "E", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "thumbImg", "G", "Landroid/view/View;", "selectNumberLayout", "H", "videoDurationTextLayout", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "videoDurationText", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "J", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "selectNumberText", "K", "gifThumb", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;)V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class q extends com.tencent.mobileqq.wink.picker.core.b {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final WinkSelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView thumbImg;

    /* renamed from: G, reason: from kotlin metadata */
    private final View selectNumberLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private final View videoDurationTextLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView videoDurationText;

    /* renamed from: J, reason: from kotlin metadata */
    private final QUICheckBox selectNumberText;

    /* renamed from: K, reason: from kotlin metadata */
    private final View gifThumb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull View itemView, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        this.selectedMediaViewModel = selectedMediaViewModel;
        this.thumbImg = (ImageView) itemView.findViewById(R.id.f96965j4);
        this.selectNumberLayout = itemView.findViewById(R.id.f81954fk);
        this.videoDurationTextLayout = itemView.findViewById(R.id.f1170670f);
        this.videoDurationText = (TextView) itemView.findViewById(R.id.f1170570e);
        this.selectNumberText = (QUICheckBox) itemView.findViewById(R.id.f81964fl);
        this.gifThumb = itemView.findViewById(R.id.vny);
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
        int i3;
        View view = this.gifThumb;
        if (e93.i.F(info)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private final void u(LocalMediaInfo info) {
        float f16;
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.h()) {
            this.selectNumberLayout.setVisibility(8);
            return;
        }
        this.selectNumberLayout.setVisibility(0);
        if (info.selectStatus == 1) {
            this.selectNumberText.setChecked(true);
            int p16 = e93.i.p(info) + this.selectedMediaViewModel.getAlreadySelectedMediaCount() + 1;
            if (p16 > 99) {
                f16 = 12.0f;
            } else {
                f16 = 14.0f;
            }
            this.selectNumberText.setTextSize(2, f16);
            this.selectNumberText.setText(String.valueOf(p16));
            return;
        }
        this.selectNumberText.setChecked(false);
        this.selectNumberText.setText("");
    }

    private final void v(LocalMediaInfo info) {
        float f16;
        ColorDrawable colorDrawable;
        this.thumbImg.setFocusable(true);
        this.thumbImg.setContentDescription(e93.i.i(info));
        ImageView thumbImg = this.thumbImg;
        Intrinsics.checkNotNullExpressionValue(thumbImg, "thumbImg");
        ViewExKt.n(thumbImg, info);
        float f17 = 1.0f;
        if (e93.i.x(info) == 0 && this.selectedMediaViewModel.b2()) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        if (info.selectStatus != 1) {
            f17 = f16;
        }
        this.thumbImg.setAlpha(f17);
        if (info.selectStatus == 1) {
            colorDrawable = WinkMediaListPart.INSTANCE.a();
        } else {
            colorDrawable = null;
        }
        this.thumbImg.setForeground(colorDrawable);
    }

    private final void w(LocalMediaInfo info) {
        if (e93.i.G(info)) {
            this.videoDurationTextLayout.setVisibility(4);
        } else {
            this.videoDurationTextLayout.setVisibility(0);
            this.videoDurationText.setText(QAlbumUtil.formatTimeToString(info.mDuration));
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.b
    public void l(@NotNull LocalMediaInfo localMedia, @NotNull final Function1<? super View, Unit> onItemClick, @NotNull final Function1<? super View, Unit> onItemSelect) {
        Intrinsics.checkNotNullParameter(localMedia, "localMedia");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemSelect, "onItemSelect");
        v(localMedia);
        w(localMedia);
        t(localMedia);
        u(localMedia);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.p(Function1.this, view);
            }
        });
        this.thumbImg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.q(Function1.this, view);
            }
        });
        this.selectNumberLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.r(Function1.this, view);
            }
        });
        s();
    }
}
