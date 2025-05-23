package com.tencent.qqnt.qbasealbum.select.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseChildFragment;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.preview.fragment.PreviewMode;
import com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment;
import com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart;
import com.tencent.qqnt.qbasealbum.select.view.a;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedPanelStateViewModel;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0003;<=B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\u000600R\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "X9", "S9", "N9", "V9", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "action", "Z9", "U9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "Z", "enableVideoTemplate", "e", "Ljava/lang/String;", "hint", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel;", "f", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel;", "selectedPanelStateViewModel", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", tl.h.F, "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "i", "Landroid/view/View;", "mediaSelectionPanelPart", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "hintText", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "videoTemplateBtn", "D", "nextStepBtn", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "selectedMediaRV", "Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$c;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$c;", "selectedMediaAdapter", "Lcom/tencent/qqnt/qbasealbum/select/view/a;", "G", "Lcom/tencent/qqnt/qbasealbum/select/view/a;", "mediaThumbDragHelper", "<init>", "(ZLjava/lang/String;)V", "H", "a", "b", "c", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class UniversalMediaSelectionPanelPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView videoTemplateBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView nextStepBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView selectedMediaRV;

    /* renamed from: F, reason: from kotlin metadata */
    private c selectedMediaAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private a mediaThumbDragHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVideoTemplate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String hint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectedPanelStateViewModel selectedPanelStateViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mediaSelectionPanelPart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView hintText;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$a;", "", "", "DRAG_THUMB_ALPHA", UserInfo.SEX_FEMALE, "DRAG_THUMB_SCALE", "", "MARGIN_FOR_SPECIAL_PHONE", "I", "", "MEDIA_DRAG_TIPS_APPEAR_TIME_US", "J", "SCREEN_WIDTH_THRESHOLD", "SELECTED_MEDIA_ITEM_SPACE", "SMOOTH_SCROLL_DELAY_TIME_MS", "", "TAG", "Ljava/lang/String;", "TEXT_SIZE_FOR_SPECIAL_PHONE", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "selectedThumbImg", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "selectedVideoDurationText", "G", "deleteBtn", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart;Landroid/view/View;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView selectedThumbImg;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView selectedVideoDurationText;

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView deleteBtn;
        final /* synthetic */ UniversalMediaSelectionPanelPart H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull UniversalMediaSelectionPanelPart universalMediaSelectionPanelPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = universalMediaSelectionPanelPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) universalMediaSelectionPanelPart, (Object) itemView);
                return;
            }
            this.selectedThumbImg = (ImageView) itemView.findViewById(R.id.f82594ha);
            this.selectedVideoDurationText = (TextView) itemView.findViewById(R.id.f82604hb);
            this.deleteBtn = (ImageView) itemView.findViewById(R.id.ufy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(UniversalMediaSelectionPanelPart this$0, b this$1, LocalMediaInfo this_apply, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            SelectedMediaViewModel selectedMediaViewModel = this$0.selectedMediaViewModel;
            if (selectedMediaViewModel != null) {
                selectedMediaViewModel.Z1(this$1.getLayoutPosition(), this_apply);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(UniversalMediaSelectionPanelPart this$0, b this$1, LocalMediaInfo this_apply, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            SelectedMediaViewModel selectedMediaViewModel = this$0.selectedMediaViewModel;
            if (selectedMediaViewModel != null) {
                selectedMediaViewModel.P1(this$1.getLayoutPosition(), this_apply);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull LocalMediaInfo info) {
            Object orNull;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            ImageView selectedThumbImg = this.selectedThumbImg;
            Intrinsics.checkNotNullExpressionValue(selectedThumbImg, "selectedThumbImg");
            com.tencent.qqnt.qbasealbum.ktx.d.g(selectedThumbImg, info);
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
                if (!com.tencent.qqnt.qbasealbum.ktx.b.l(info) && !com.tencent.qqnt.qbasealbum.ktx.b.k(info) && (!info.isSystemMeidaStore() || com.tencent.qqnt.qbasealbum.ktx.b.f(info) < 0)) {
                    this.selectedVideoDurationText.setVisibility(4);
                } else {
                    this.selectedVideoDurationText.setVisibility(0);
                    this.selectedVideoDurationText.setText(com.tencent.qqnt.qbasealbum.utils.f.f361654a.b(com.tencent.qqnt.qbasealbum.ktx.b.f(info)));
                }
            } else {
                this.selectedVideoDurationText.setVisibility(4);
            }
            c cVar = this.H.selectedMediaAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar = null;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(cVar.i0(), getLayoutPosition());
            final LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
            if (localMediaInfo != null) {
                final UniversalMediaSelectionPanelPart universalMediaSelectionPanelPart = this.H;
                this.deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.select.view.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UniversalMediaSelectionPanelPart.b.o(UniversalMediaSelectionPanelPart.this, this, localMediaInfo, view);
                    }
                });
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.select.view.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UniversalMediaSelectionPanelPart.b.p(UniversalMediaSelectionPanelPart.this, this, localMediaInfo, view);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$b;", "Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "i0", "()Ljava/util/List;", "l0", "(Ljava/util/List;)V", "selectedMedia", "<init>", "(Lcom/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class c extends RecyclerView.Adapter<b> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<LocalMediaInfo> selectedMedia;

        public c() {
            List<LocalMediaInfo> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.selectedMedia = emptyList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniversalMediaSelectionPanelPart.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.selectedMedia.size();
        }

        @NotNull
        public final List<LocalMediaInfo> i0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.selectedMedia;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
            } else {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.n(this.selectedMedia.get(position));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            UniversalMediaSelectionPanelPart universalMediaSelectionPanelPart = UniversalMediaSelectionPanelPart.this;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ftk, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026list_item, parent, false)");
            return new b(universalMediaSelectionPanelPart, inflate);
        }

        public final void l0(@NotNull List<LocalMediaInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.selectedMedia = list;
            }
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/qbasealbum/select/view/UniversalMediaSelectionPanelPart$d", "Lcom/tencent/qqnt/qbasealbum/select/view/a$a;", "", "getSize", "fromPosition", "toPosition", "", "onItemMoved", "position", "c", "a", "", "isInside", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements a.InterfaceC9685a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniversalMediaSelectionPanelPart.this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.select.view.a.InterfaceC9685a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.select.view.a.InterfaceC9685a
        public void b(boolean isInside) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, isInside);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.select.view.a.InterfaceC9685a
        public void c(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, position);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.select.view.a.InterfaceC9685a
        public int getSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c cVar = UniversalMediaSelectionPanelPart.this.selectedMediaAdapter;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                    cVar = null;
                }
                return cVar.i0().size();
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @Override // com.tencent.qqnt.qbasealbum.select.view.a.InterfaceC9685a
        public void onItemMoved(int fromPosition, int toPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SelectedMediaViewModel selectedMediaViewModel = UniversalMediaSelectionPanelPart.this.selectedMediaViewModel;
                if (selectedMediaViewModel != null) {
                    selectedMediaViewModel.X1(fromPosition, toPosition);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public UniversalMediaSelectionPanelPart(boolean z16, @NotNull String hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), hint);
        } else {
            this.enableVideoTemplate = z16;
            this.hint = hint;
        }
    }

    private final void N9() {
        boolean z16;
        ViewGroup.LayoutParams layoutParams;
        View findViewById = getPartRootView().findViewById(R.id.x_m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.hintText)");
        this.hintText = (TextView) findViewById;
        this.nextStepBtn = (TextView) getPartRootView().findViewById(R.id.zqm);
        this.videoTemplateBtn = (ImageView) getPartRootView().findViewById(R.id.f1172070t);
        final boolean z17 = true;
        QAlbumBaseChildFragment qAlbumBaseChildFragment = null;
        if (com.tencent.qqnt.qbasealbum.utils.d.f361649a.g() < 720) {
            TextView textView = this.hintText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView = null;
            }
            textView.setTextSize(10.0f);
            TextView textView2 = this.nextStepBtn;
            if (textView2 != null) {
                layoutParams = textView2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = 6;
            }
        } else {
            TextView textView3 = this.hintText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView3 = null;
            }
            textView3.setTextSize(1, 12.0f);
            TextView textView4 = this.hintText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView4 = null;
            }
            textView4.requestLayout();
        }
        if (this.hint.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView5 = this.hintText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView5 = null;
            }
            textView5.setText(this.hint);
        }
        SelectedPanelStateViewModel selectedPanelStateViewModel = this.selectedPanelStateViewModel;
        if (selectedPanelStateViewModel != null) {
            if (this.enableVideoTemplate) {
                LiveData<Boolean> R1 = selectedPanelStateViewModel.R1();
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart$initActionBtn$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniversalMediaSelectionPanelPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean visible) {
                        ImageView imageView;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) visible);
                            return;
                        }
                        imageView = UniversalMediaSelectionPanelPart.this.videoTemplateBtn;
                        if (imageView == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(visible, "visible");
                        imageView.setVisibility(visible.booleanValue() ? 0 : 8);
                    }
                };
                R1.observe((LifecycleOwner) partHost, new Observer() { // from class: com.tencent.qqnt.qbasealbum.select.view.d
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UniversalMediaSelectionPanelPart.O9(Function1.this, obj);
                    }
                });
            } else {
                ImageView imageView = this.videoTemplateBtn;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
            LiveData<SelectedPanelStateViewModel.b> Q1 = selectedPanelStateViewModel.Q1();
            IPartHost partHost2 = getPartHost();
            Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<SelectedPanelStateViewModel.b, Unit> function12 = new Function1<SelectedPanelStateViewModel.b, Unit>() { // from class: com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart$initActionBtn$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniversalMediaSelectionPanelPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SelectedPanelStateViewModel.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SelectedPanelStateViewModel.b bVar) {
                    TextView textView6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                        return;
                    }
                    textView6 = UniversalMediaSelectionPanelPart.this.nextStepBtn;
                    if (textView6 != null) {
                        textView6.setEnabled(bVar.b());
                        textView6.setText(bVar.c());
                        com.tencent.qqnt.qbasealbum.ktx.d.d(textView6, bVar.a());
                    }
                }
            };
            Q1.observe((LifecycleOwner) partHost2, new Observer() { // from class: com.tencent.qqnt.qbasealbum.select.view.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionPanelPart.P9(Function1.this, obj);
                }
            });
        }
        IPartHost partHost3 = getPartHost();
        if (partHost3 instanceof QAlbumBaseChildFragment) {
            qAlbumBaseChildFragment = (QAlbumBaseChildFragment) partHost3;
        }
        if (qAlbumBaseChildFragment == null || qAlbumBaseChildFragment.th() != 1) {
            z17 = false;
        }
        ImageView imageView2 = this.videoTemplateBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.select.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UniversalMediaSelectionPanelPart.Q9(UniversalMediaSelectionPanelPart.this, z17, view);
                }
            });
        }
        TextView textView6 = this.nextStepBtn;
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.select.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UniversalMediaSelectionPanelPart.R9(UniversalMediaSelectionPanelPart.this, z17, view);
                }
            });
        }
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
    public static final void Q9(UniversalMediaSelectionPanelPart this$0, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this$0);
        if (a16 != null) {
            a16.Mh(z16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(UniversalMediaSelectionPanelPart this$0, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this$0);
        if (a16 != null) {
            a16.Kh(z16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S9() {
        LiveData<Boolean> P1;
        SelectedPanelStateViewModel selectedPanelStateViewModel = this.selectedPanelStateViewModel;
        if (selectedPanelStateViewModel != null && (P1 = selectedPanelStateViewModel.P1()) != null) {
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            LifecycleOwner viewLifecycleOwner = ((Fragment) partHost).getViewLifecycleOwner();
            final UniversalMediaSelectionPanelPart$initMediaDragTips$1 universalMediaSelectionPanelPart$initMediaDragTips$1 = new UniversalMediaSelectionPanelPart$initMediaDragTips$1(this);
            P1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.select.view.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionPanelPart.T9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U9() {
        a aVar = new a();
        this.mediaThumbDragHelper = aVar;
        aVar.d(1.2f);
        a aVar2 = this.mediaThumbDragHelper;
        RecyclerView recyclerView = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaThumbDragHelper");
            aVar2 = null;
        }
        aVar2.b(0.9f);
        a aVar3 = this.mediaThumbDragHelper;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaThumbDragHelper");
            aVar3 = null;
        }
        aVar3.c(new d());
        a aVar4 = this.mediaThumbDragHelper;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaThumbDragHelper");
            aVar4 = null;
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(aVar4);
        RecyclerView recyclerView2 = this.selectedMediaRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
        } else {
            recyclerView = recyclerView2;
        }
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private final void V9() {
        View findViewById = getPartRootView().findViewById(R.id.f82554h7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.selectedMediaRV)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.selectedMediaRV = recyclerView;
        c cVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        this.selectedMediaAdapter = new c();
        RecyclerView recyclerView2 = this.selectedMediaRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = this.selectedMediaRV;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new com.tencent.qqnt.qbasealbum.view.a(com.tencent.qqnt.qbasealbum.ktx.d.a(8.0f)));
        RecyclerView recyclerView4 = this.selectedMediaRV;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            recyclerView4 = null;
        }
        c cVar2 = this.selectedMediaAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
            cVar2 = null;
        }
        recyclerView4.setAdapter(cVar2);
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            FragmentActivity requireActivity = a16.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SelectedMediaViewModel g16 = com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
            this.selectedMediaViewModel = g16;
            if (g16 != null) {
                c cVar3 = this.selectedMediaAdapter;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                    cVar3 = null;
                }
                cVar3.l0(g16.getSelectedMedia());
                c cVar4 = this.selectedMediaAdapter;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                } else {
                    cVar = cVar4;
                }
                cVar.notifyDataSetChanged();
                LiveData<com.tencent.qqnt.qbasealbum.select.model.a> S1 = g16.S1();
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart$initSelectedMediaRecyclerView$1$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniversalMediaSelectionPanelPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a action) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action);
                            return;
                        }
                        UniversalMediaSelectionPanelPart universalMediaSelectionPanelPart = UniversalMediaSelectionPanelPart.this;
                        Intrinsics.checkNotNullExpressionValue(action, "action");
                        universalMediaSelectionPanelPart.Z9(action);
                    }
                };
                S1.observe((LifecycleOwner) partHost, new Observer() { // from class: com.tencent.qqnt.qbasealbum.select.view.c
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UniversalMediaSelectionPanelPart.W9(Function1.this, obj);
                    }
                });
            }
        }
        U9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X9() {
        LiveData<Boolean> panelVisibleLiveData;
        this.mediaSelectionPanelPart = getPartRootView().findViewById(R.id.yzh);
        SelectedPanelStateViewModel selectedPanelStateViewModel = this.selectedPanelStateViewModel;
        if (selectedPanelStateViewModel != null && (panelVisibleLiveData = selectedPanelStateViewModel.getPanelVisibleLiveData()) != null) {
            LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart$updatePartVisibility$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniversalMediaSelectionPanelPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean visible) {
                    View view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) visible);
                        return;
                    }
                    view = UniversalMediaSelectionPanelPart.this.mediaSelectionPanelPart;
                    if (view != null) {
                        Intrinsics.checkNotNullExpressionValue(visible, "visible");
                        if (visible.booleanValue() && view.getVisibility() == 8) {
                            view.setVisibility(0);
                            ox3.a.g("UniversalMediaSelectionPanelPart", UniversalMediaSelectionPanelPart$updatePartVisibility$1$1$1.INSTANCE);
                        } else {
                            if (visible.booleanValue() || view.getVisibility() == 8) {
                                return;
                            }
                            view.setVisibility(8);
                            ox3.a.g("UniversalMediaSelectionPanelPart", UniversalMediaSelectionPanelPart$updatePartVisibility$1$1$2.INSTANCE);
                        }
                    }
                }
            };
            panelVisibleLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.select.view.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionPanelPart.Y9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(final com.tencent.qqnt.qbasealbum.select.model.a action) {
        int collectionSizeOrDefault;
        RecyclerView recyclerView = null;
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.f) {
            c cVar = this.selectedMediaAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar = null;
            }
            cVar.l0(((com.tencent.qqnt.qbasealbum.select.model.f) action).a());
            c cVar2 = this.selectedMediaAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar2 = null;
            }
            cVar2.notifyDataSetChanged();
            if (!r9.a().isEmpty()) {
                RecyclerView recyclerView2 = this.selectedMediaRV;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
                } else {
                    recyclerView = recyclerView2;
                }
                recyclerView.postDelayed(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.select.view.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        UniversalMediaSelectionPanelPart.aa(UniversalMediaSelectionPanelPart.this, action);
                    }
                }, 100L);
                return;
            }
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.b) {
            c cVar3 = this.selectedMediaAdapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar3 = null;
            }
            cVar3.notifyItemInserted(((com.tencent.qqnt.qbasealbum.select.model.b) action).c().size());
            RecyclerView recyclerView3 = this.selectedMediaRV;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.select.view.j
                @Override // java.lang.Runnable
                public final void run() {
                    UniversalMediaSelectionPanelPart.ba(UniversalMediaSelectionPanelPart.this, action);
                }
            }, 100L);
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.g) {
            c cVar4 = this.selectedMediaAdapter;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                cVar4 = null;
            }
            com.tencent.qqnt.qbasealbum.select.model.g gVar = (com.tencent.qqnt.qbasealbum.select.model.g) action;
            cVar4.notifyItemMoved(gVar.a(), gVar.b());
            RecyclerView recyclerView4 = this.selectedMediaRV;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.invalidateItemDecorations();
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.c) {
            RFWLayerLaunchUtil rFWLayerLaunchUtil = RFWLayerLaunchUtil.INSTANCE;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            QAlbumBaseMainFragment<?> l3 = QAlbumPickerContext.f361201a.l();
            Intrinsics.checkNotNull(l3);
            FragmentManager childFragmentManager = l3.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "QAlbumPickerContext.getS\u2026()!!.childFragmentManager");
            com.tencent.qqnt.qbasealbum.select.model.c cVar5 = (com.tencent.qqnt.qbasealbum.select.model.c) action;
            List<LocalMediaInfo> b16 = cVar5.b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.qqnt.qbasealbum.ktx.b.u((LocalMediaInfo) it.next()));
            }
            int a16 = cVar5.a();
            Bundle bundle = new Bundle();
            bundle.putInt("PARAM_PREVIEW_MODE", PreviewMode.SELECT_MODE.ordinal());
            bundle.putBoolean("FROM_PICKER_PREVIEW_BTN", true);
            Unit unit = Unit.INSTANCE;
            com.tencent.qqnt.qbasealbum.base.model.e.b(rFWLayerLaunchUtil, activity, childFragmentManager, null, arrayList, a16, QAlbumPreviewChildFragment.class, bundle, R.id.cks);
            return;
        }
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.h) {
            com.tencent.qqnt.qbasealbum.select.model.h hVar = (com.tencent.qqnt.qbasealbum.select.model.h) action;
            if (hVar.a() == 0) {
                c cVar6 = this.selectedMediaAdapter;
                if (cVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                    cVar6 = null;
                }
                cVar6.notifyDataSetChanged();
            } else {
                c cVar7 = this.selectedMediaAdapter;
                if (cVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedMediaAdapter");
                    cVar7 = null;
                }
                cVar7.notifyItemRemoved(hVar.a());
            }
            RecyclerView recyclerView5 = this.selectedMediaRV;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            } else {
                recyclerView = recyclerView5;
            }
            recyclerView.invalidateItemDecorations();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(UniversalMediaSelectionPanelPart this$0, com.tencent.qqnt.qbasealbum.select.model.a action) {
        Object last;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        RecyclerView recyclerView = this$0.selectedMediaRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            recyclerView = null;
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) ((com.tencent.qqnt.qbasealbum.select.model.f) action).a());
        recyclerView.smoothScrollToPosition(com.tencent.qqnt.qbasealbum.ktx.b.e((LocalMediaInfo) last));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(UniversalMediaSelectionPanelPart this$0, com.tencent.qqnt.qbasealbum.select.model.a action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        RecyclerView recyclerView = this$0.selectedMediaRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
            recyclerView = null;
        }
        recyclerView.smoothScrollToPosition(((com.tencent.qqnt.qbasealbum.select.model.b) action).b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "UniversalMediaSelectionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            FragmentActivity requireActivity = a16.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.selectedPanelStateViewModel = com.tencent.qqnt.qbasealbum.album.b.d(a16, com.tencent.qqnt.qbasealbum.album.b.g(requireActivity).S1());
        }
        X9();
        S9();
        N9();
        V9();
    }
}
