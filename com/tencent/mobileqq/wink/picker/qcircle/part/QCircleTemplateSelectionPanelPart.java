package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart;
import com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.TemplateLibMediaPreviewFragment;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.QCircleTemplateMediaPickerViewModel;
import com.tencent.mobileqq.wink.view.RoundCorneredRelativeLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u0003012B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J#\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001f\u0010\"\u001a\u00060\u001dR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "N9", "", "enable", "J9", "", "firstEmptyHolderIndex", "", "tipsMsg", "S9", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "getLogTag", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "selectedMediaRV", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "templateDesc", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "nextStepBtn", "Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart$c;", tl.h.F, "Lkotlin/Lazy;", "K9", "()Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart$c;", "selectedMediaAdapter", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "i", "M9", "()Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "templateMediaPickerViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleTemplateSelectionPanelPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView selectedMediaRV;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView templateDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton nextStepBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy templateMediaPickerViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u000f\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR\u001c\u0010 \u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u001c\u0010\"\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\r\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "position", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "seqText", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "ivDeleteArea", "Lcom/tencent/mobileqq/wink/view/RoundCorneredRelativeLayout;", "G", "Lcom/tencent/mobileqq/wink/view/RoundCorneredRelativeLayout;", "rcMainLayout", "Lcom/tencent/mobileqq/widget/SquareImageView;", "H", "Lcom/tencent/mobileqq/widget/SquareImageView;", "selectedThumbImg", "I", "ivPicHolderContent", "J", "ivTemplateSlotTime", "K", "durationBg", "L", "tvDuration", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView seqText;

        /* renamed from: F, reason: from kotlin metadata */
        private final View ivDeleteArea;

        /* renamed from: G, reason: from kotlin metadata */
        private final RoundCorneredRelativeLayout rcMainLayout;

        /* renamed from: H, reason: from kotlin metadata */
        private final SquareImageView selectedThumbImg;

        /* renamed from: I, reason: from kotlin metadata */
        private final View ivPicHolderContent;

        /* renamed from: J, reason: from kotlin metadata */
        private final TextView ivTemplateSlotTime;

        /* renamed from: K, reason: from kotlin metadata */
        private final View durationBg;

        /* renamed from: L, reason: from kotlin metadata */
        private final TextView tvDuration;
        final /* synthetic */ QCircleTemplateSelectionPanelPart M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.M = qCircleTemplateSelectionPanelPart;
            this.seqText = (TextView) itemView.findViewById(R.id.f83314j8);
            this.ivDeleteArea = itemView.findViewById(R.id.xyn);
            this.rcMainLayout = (RoundCorneredRelativeLayout) itemView.findViewById(R.id.f70573lt);
            this.selectedThumbImg = (SquareImageView) itemView.findViewById(R.id.f82594ha);
            this.ivPicHolderContent = itemView.findViewById(R.id.xyu);
            this.ivTemplateSlotTime = (TextView) itemView.findViewById(R.id.f165890xz4);
            this.durationBg = itemView.findViewById(R.id.uox);
            this.tvDuration = (TextView) itemView.findViewById(R.id.f1051965c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(QCircleTemplateSelectionPanelPart this$0, b this$1, TemplateLibraryHolderInfo info, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(info, "$info");
            int z26 = this$0.M9().z2(this$1.getAdapterPosition());
            LocalMediaInfo mediaInfo = info.getMediaInfo();
            if (mediaInfo != null) {
                this$0.L9().d2(z26, mediaInfo);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(QCircleTemplateSelectionPanelPart this$0, b this$1, View view) {
            Object orNull;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            List<LocalMediaInfo> selectedMedia = this$0.L9().getSelectedMedia();
            orNull = CollectionsKt___CollectionsKt.getOrNull(selectedMedia, this$1.getLayoutPosition());
            if (orNull != null) {
                com.tencent.mobileqq.wink.picker.core.c.f324480a.i(TemplateLibMediaPreviewFragment.INSTANCE.a(selectedMedia, this$1.getLayoutPosition()));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void q(TemplateLibraryHolderInfo info) {
            this.selectedThumbImg.setImageBitmap(null);
            this.ivPicHolderContent.setVisibility(4);
            TextView textView = this.ivTemplateSlotTime;
            if (info.getHolderTimeSlot() > 0.0f) {
                textView.setVisibility(0);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.CHINA, "%.1fs", Arrays.copyOf(new Object[]{Float.valueOf(info.getHolderTimeSlot())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                textView.setText(format);
            } else {
                textView.setVisibility(4);
            }
            this.durationBg.setVisibility(4);
            this.tvDuration.setVisibility(4);
            this.ivDeleteArea.setVisibility(4);
            float dip2px = ViewUtils.dip2px(4.0f);
            this.rcMainLayout.setRadius(dip2px, dip2px, dip2px, dip2px);
            if (this.M.M9().l2(getAdapterPosition())) {
                this.rcMainLayout.setBackground(R.drawable.qvideo_skin_qqwink_editor_template_holder_background);
            } else {
                this.rcMainLayout.setBackground(R.drawable.qvideo_skin_qqwink_pick_holder_dashed_border_bg);
            }
        }

        private final void r(TemplateLibraryHolderInfo info) {
            this.ivTemplateSlotTime.setVisibility(4);
            this.ivPicHolderContent.setVisibility(0);
            if (info.getHolderTimeSlot() > 0.0f) {
                this.durationBg.setVisibility(0);
                this.tvDuration.setVisibility(0);
                TextView textView = this.tvDuration;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.CHINA, "%.1fs", Arrays.copyOf(new Object[]{Float.valueOf(info.getHolderTimeSlot())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                textView.setText(format);
            } else {
                this.durationBg.setVisibility(4);
                this.tvDuration.setVisibility(4);
            }
            this.ivDeleteArea.setVisibility(0);
            LocalMediaInfo mediaInfo = info.getMediaInfo();
            if (mediaInfo != null) {
                SquareImageView selectedThumbImg = this.selectedThumbImg;
                Intrinsics.checkNotNullExpressionValue(selectedThumbImg, "selectedThumbImg");
                ViewExKt.n(selectedThumbImg, mediaInfo);
            }
        }

        public final void n(@NotNull final TemplateLibraryHolderInfo info, int position) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.seqText.setText(String.valueOf(position + 1));
            if (info.getMediaInfo() == null) {
                q(info);
            } else {
                r(info);
            }
            View view = this.ivDeleteArea;
            final QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart = this.M;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QCircleTemplateSelectionPanelPart.b.o(QCircleTemplateSelectionPanelPart.this, this, info, view2);
                }
            });
            View view2 = this.itemView;
            final QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart2 = this.M;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.af
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QCircleTemplateSelectionPanelPart.b.p(QCircleTemplateSelectionPanelPart.this, this, view3);
                }
            });
            int adapterPosition = getAdapterPosition();
            Integer value = this.M.M9().R1().getValue();
            if (value != null && adapterPosition == value.intValue()) {
                this.rcMainLayout.setForeground(R.drawable.l6a);
            } else {
                this.rcMainLayout.setForeground(-1);
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\f2\n\u0010\n\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart$b;", "Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getSelectedMedia", "()Ljava/util/List;", "k0", "(Ljava/util/List;)V", "selectedMedia", "<init>", "(Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleTemplateSelectionPanelPart;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends RecyclerView.Adapter<b> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<TemplateLibraryHolderInfo> selectedMedia;

        public c() {
            List<TemplateLibraryHolderInfo> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.selectedMedia = emptyList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.selectedMedia.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (ArrayUtils.isOutOfArrayIndex(position, this.selectedMedia)) {
                return;
            }
            holder.n(this.selectedMedia.get(position), position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart = QCircleTemplateSelectionPanelPart.this;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.g68, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026item_view, parent, false)");
            return new b(qCircleTemplateSelectionPanelPart, inflate);
        }

        public final void k0(@NotNull List<TemplateLibraryHolderInfo> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.selectedMedia = list;
        }
    }

    public QCircleTemplateSelectionPanelPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart$selectedMediaAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QCircleTemplateSelectionPanelPart.c invoke() {
                return new QCircleTemplateSelectionPanelPart.c();
            }
        });
        this.selectedMediaAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QCircleTemplateMediaPickerViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart$templateMediaPickerViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QCircleTemplateMediaPickerViewModel invoke() {
                com.tencent.mobileqq.wink.picker.qcircle.c cVar = com.tencent.mobileqq.wink.picker.qcircle.c.f324971a;
                Fragment hostFragment = QCircleTemplateSelectionPanelPart.this.getHostFragment();
                Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment");
                return cVar.f((QCircleTemplateLibraryMediaPickerFragment) hostFragment);
            }
        });
        this.templateMediaPickerViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart$selectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkSelectedMediaViewModel invoke() {
                Fragment hostFragment = QCircleTemplateSelectionPanelPart.this.getHostFragment();
                Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment<*>");
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.j((WinkMediaPickerMainBaseFragment) hostFragment);
            }
        });
        this.selectedMediaViewModel = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(boolean enable) {
        QUIButton qUIButton = this.nextStepBtn;
        if (qUIButton != null) {
            qUIButton.setClickable(enable);
        }
        QUIButton qUIButton2 = this.nextStepBtn;
        if (qUIButton2 != null) {
            qUIButton2.setEnabled(enable);
        }
        if (enable) {
            QUIButton qUIButton3 = this.nextStepBtn;
            if (qUIButton3 != null) {
                qUIButton3.o();
                return;
            }
            return;
        }
        QUIButton qUIButton4 = this.nextStepBtn;
        if (qUIButton4 != null) {
            qUIButton4.setBackgroundDisabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c K9() {
        return (c) this.selectedMediaAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSelectedMediaViewModel L9() {
        return (WinkSelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleTemplateMediaPickerViewModel M9() {
        return (QCircleTemplateMediaPickerViewModel) this.templateMediaPickerViewModel.getValue();
    }

    private final void N9() {
        Object firstOrNull;
        TextView textView;
        RecyclerView recyclerView = this.selectedMediaRV;
        boolean z16 = false;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.selectedMediaRV;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new com.tencent.mobileqq.wink.view.f(ImmersiveUtils.dpToPx(8.0f)));
        }
        RecyclerView recyclerView3 = this.selectedMediaRV;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(K9());
        }
        final QCircleTemplateMediaPickerViewModel M9 = M9();
        M9.r2(L9().Z1());
        List<TemplateLibraryHolderInfo> value = M9.a2().getValue();
        if (value != null) {
            c K9 = K9();
            Intrinsics.checkNotNullExpressionValue(value, "this");
            K9.k0(value);
            K9().notifyDataSetChanged();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
            TemplateLibraryHolderInfo templateLibraryHolderInfo = (TemplateLibraryHolderInfo) firstOrNull;
            if (templateLibraryHolderInfo != null) {
                String holderHintText = templateLibraryHolderInfo.getHolderHintText();
                if (holderHintText == null || holderHintText.length() == 0) {
                    z16 = true;
                }
                if (!z16 && (textView = this.templateDesc) != null) {
                    textView.setText(templateLibraryHolderInfo.getHolderHintText());
                }
            }
        }
        LiveData<List<TemplateLibraryHolderInfo>> a26 = M9.a2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<TemplateLibraryHolderInfo>, Unit> function1 = new Function1<List<TemplateLibraryHolderInfo>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart$initSelectedMediaRecyclerView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<TemplateLibraryHolderInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<TemplateLibraryHolderInfo> list) {
                QCircleTemplateSelectionPanelPart.c K92;
                K92 = QCircleTemplateSelectionPanelPart.this.K9();
                K92.notifyDataSetChanged();
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCircleTemplateSelectionPanelPart.O9(Function1.this, obj);
            }
        });
        LiveData<Integer> R1 = M9.R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart$initSelectedMediaRecyclerView$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
            
                r4 = r4.templateDesc;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Integer it) {
                RecyclerView recyclerView4;
                Object orNull;
                String holderHintText2;
                TextView textView2;
                boolean z17 = true;
                if (it == null || it.intValue() != -1) {
                    recyclerView4 = QCircleTemplateSelectionPanelPart.this.selectedMediaRV;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    com.tencent.mobileqq.wink.utils.e.g(recyclerView4, 0, it.intValue());
                    List<TemplateLibraryHolderInfo> value2 = M9.a2().getValue();
                    if (value2 != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(value2, it.intValue());
                        TemplateLibraryHolderInfo templateLibraryHolderInfo2 = (TemplateLibraryHolderInfo) orNull;
                        if (templateLibraryHolderInfo2 != null && (holderHintText2 = templateLibraryHolderInfo2.getHolderHintText()) != null) {
                            QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart = QCircleTemplateSelectionPanelPart.this;
                            if ((holderHintText2.length() > 0) && textView2 != null) {
                                textView2.setText(holderHintText2);
                            }
                        }
                    }
                }
                QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart2 = QCircleTemplateSelectionPanelPart.this;
                if ((it == null || it.intValue() != -1) && !QCircleTemplateSelectionPanelPart.this.M9().m2()) {
                    z17 = false;
                }
                qCircleTemplateSelectionPanelPart2.J9(z17);
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCircleTemplateSelectionPanelPart.P9(Function1.this, obj);
            }
        });
        LiveData<String> W1 = M9.W1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleTemplateSelectionPanelPart$initSelectedMediaRecyclerView$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                QCircleTemplateSelectionPanelPart qCircleTemplateSelectionPanelPart = QCircleTemplateSelectionPanelPart.this;
                qCircleTemplateSelectionPanelPart.S9(qCircleTemplateSelectionPanelPart.M9().R1().getValue(), str);
            }
        };
        W1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCircleTemplateSelectionPanelPart.Q9(Function1.this, obj);
            }
        });
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
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QCircleTemplateSelectionPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this$0);
        if (b16 != null) {
            WinkMediaPickerMainBaseFragment.ei(b16, false, null, 3, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(Integer firstEmptyHolderIndex, String tipsMsg) {
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        if (firstEmptyHolderIndex == null || firstEmptyHolderIndex.intValue() == -1 || tipsMsg == null) {
            return;
        }
        RecyclerView recyclerView = this.selectedMediaRV;
        LinearLayoutManager linearLayoutManager = null;
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager != null && (findViewByPosition = linearLayoutManager.findViewByPosition(firstEmptyHolderIndex.intValue())) != null) {
            QUIDefaultBubbleTip.r(getContext()).g0(false).o0(tipsMsg).k0(0).S(findViewByPosition).f0(false).m0(3).R(0).s0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleTemplateSelectionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        TextView textView;
        super.onInitView(rootView);
        QUIButton qUIButton = null;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f82554h7);
        } else {
            recyclerView = null;
        }
        this.selectedMediaRV = recyclerView;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.x_m);
        } else {
            textView = null;
        }
        this.templateDesc = textView;
        if (textView != null) {
            textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        if (rootView != null) {
            qUIButton = (QUIButton) rootView.findViewById(R.id.zqm);
        }
        this.nextStepBtn = qUIButton;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleTemplateSelectionPanelPart.R9(QCircleTemplateSelectionPanelPart.this, view);
                }
            });
        }
        N9();
    }
}
