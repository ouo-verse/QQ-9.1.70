package com.tencent.mobileqq.wink.picker.core.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter$Companion$urlDrawableDownListener$2;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart;
import com.tencent.mobileqq.wink.picker.core.view.WinkLocalVideoPreviewView;
import com.tencent.mobileqq.wink.picker.core.view.WinkQZoneVideoPreviewView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.view.multitouchview.MultiTouchImageView;
import e93.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005/0123BA\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010'\u001a\u00020$\u00a2\u0006\u0004\b,\u0010-J\u0006\u0010\u0004\u001a\u00020\u0003J\u001c\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00032\n\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$d;", "", "l0", "Landroid/view/ViewGroup;", "viewGroup", "", "viewType", "n0", "mediaPreviewVH", "position", "m0", "getItemCount", "getItemViewType", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "previewMedia", "Lcom/tencent/mobileqq/wink/picker/core/view/c;", "D", "Lcom/tencent/mobileqq/wink/picker/core/view/c;", "videoViewCallBack", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$b;", "E", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$b;", "picViewCallBack", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "", "G", "Z", "isVideoAutoPlay", "Landroid/os/CountDownTimer;", "H", "Landroid/os/CountDownTimer;", "qZoneVideoTimeoutTimer", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mobileqq/wink/picker/core/view/c;Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$b;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;Z)V", "I", "a", "b", "c", "d", "e", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaPreviewAdapter extends RecyclerView.Adapter<d> {

    @NotNull
    private static final Lazy<WinkMediaPreviewAdapter$Companion$urlDrawableDownListener$2.a> J;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> previewMedia;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.picker.core.view.c videoViewCallBack;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final WinkMediaPreviewContentPart.b picViewCallBack;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final WinkMediaPreviewViewModel mediaPreviewViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isVideoAutoPlay;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private CountDownTimer qZoneVideoTimeoutTimer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$b;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$d;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "l", "Lcom/tencent/mobileqq/wink/view/multitouchview/MultiTouchImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/view/multitouchview/MultiTouchImageView;", "imagePreview", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends d {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final MultiTouchImageView imagePreview;
        final /* synthetic */ WinkMediaPreviewAdapter G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull WinkMediaPreviewAdapter winkMediaPreviewAdapter, View itemView) {
            super(winkMediaPreviewAdapter, itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = winkMediaPreviewAdapter;
            View findViewById = itemView.findViewById(R.id.f246909t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.photo_preview_image)");
            this.imagePreview = (MultiTouchImageView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(WinkMediaPreviewAdapter this$0, View view, float f16, float f17) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.picViewCallBack.onClick();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter.d
        public void l(@NotNull LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            ViewExKt.l(this.imagePreview, info);
            MultiTouchImageView multiTouchImageView = this.imagePreview;
            final WinkMediaPreviewAdapter winkMediaPreviewAdapter = this.G;
            multiTouchImageView.setOnViewTapListener(new com.tencent.mobileqq.wink.view.multitouchview.d() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.d
                @Override // com.tencent.mobileqq.wink.view.multitouchview.d
                public final void onViewTap(View view, float f16, float f17) {
                    WinkMediaPreviewAdapter.b.n(WinkMediaPreviewAdapter.this, view, f16, f17);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$c;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$d;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "l", "Lcom/tencent/mobileqq/wink/picker/core/view/WinkLocalVideoPreviewView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/core/view/WinkLocalVideoPreviewView;", "localVideoPreview", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends d {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final WinkLocalVideoPreviewView localVideoPreview;
        final /* synthetic */ WinkMediaPreviewAdapter G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull WinkMediaPreviewAdapter winkMediaPreviewAdapter, View itemView) {
            super(winkMediaPreviewAdapter, itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = winkMediaPreviewAdapter;
            this.localVideoPreview = (WinkLocalVideoPreviewView) itemView;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter.d
        public void l(@NotNull LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.localVideoPreview.o(info);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00a6\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public abstract class d extends RecyclerView.ViewHolder {
        final /* synthetic */ WinkMediaPreviewAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull WinkMediaPreviewAdapter winkMediaPreviewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = winkMediaPreviewAdapter;
        }

        public abstract void l(@NotNull LocalMediaInfo info);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$e;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$d;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "l", "Lcom/tencent/mobileqq/wink/picker/core/view/WinkQZoneVideoPreviewView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/core/view/WinkQZoneVideoPreviewView;", "qZoneVideoPreview", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class e extends d {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final WinkQZoneVideoPreviewView qZoneVideoPreview;
        final /* synthetic */ WinkMediaPreviewAdapter G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull WinkMediaPreviewAdapter winkMediaPreviewAdapter, View itemView) {
            super(winkMediaPreviewAdapter, itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = winkMediaPreviewAdapter;
            this.qZoneVideoPreview = (WinkQZoneVideoPreviewView) itemView;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter.d
        public void l(@NotNull LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.qZoneVideoPreview.r(info);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$g", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$d;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "l", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends d {
        g(WinkMediaPreviewAdapter winkMediaPreviewAdapter, View view) {
            super(winkMediaPreviewAdapter, view);
        }

        @Override // com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter.d
        public void l(@NotNull LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    static {
        Lazy<WinkMediaPreviewAdapter$Companion$urlDrawableDownListener$2.a> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPreviewAdapter$Companion$urlDrawableDownListener$2.a>() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter$Companion$urlDrawableDownListener$2

            @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$Companion$urlDrawableDownListener$2$a", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "i", "onLoadProgressed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements URLDrawableDownListener {
                a() {
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadCancelled(@NotNull View view, @NotNull URLDrawable urlDrawable) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadFailed(@NotNull View view, @NotNull URLDrawable urlDrawable, @Nullable Throwable throwable) {
                    String str;
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    if (throwable != null) {
                        str = throwable.getMessage();
                    } else {
                        str = null;
                    }
                    w53.b.a("WinkMediaPreviewAdapter", "onLoadFailed: " + str);
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadInterrupted(@NotNull View view, @NotNull URLDrawable urlDrawable, @NotNull InterruptedException e16) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    Intrinsics.checkNotNullParameter(e16, "e");
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadProgressed(@NotNull View view, @NotNull URLDrawable urlDrawable, int i3) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                }

                @Override // com.tencent.image.URLDrawableDownListener
                public void onLoadSuccessed(@NotNull View view, @NotNull URLDrawable urlDrawable) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageDrawable(urlDrawable);
                    }
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        J = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WinkMediaPreviewAdapter(@NotNull Context context, @NotNull List<? extends LocalMediaInfo> previewMedia, @NotNull com.tencent.mobileqq.wink.picker.core.view.c videoViewCallBack, @NotNull WinkMediaPreviewContentPart.b picViewCallBack, @Nullable WinkMediaPreviewViewModel winkMediaPreviewViewModel, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
        Intrinsics.checkNotNullParameter(videoViewCallBack, "videoViewCallBack");
        Intrinsics.checkNotNullParameter(picViewCallBack, "picViewCallBack");
        this.context = context;
        this.previewMedia = previewMedia;
        this.videoViewCallBack = videoViewCallBack;
        this.picViewCallBack = picViewCallBack;
        this.mediaPreviewViewModel = winkMediaPreviewViewModel;
        this.isVideoAutoPlay = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.previewMedia.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return i.r(this.previewMedia.get(position)).ordinal();
    }

    public final void l0() {
        CountDownTimer countDownTimer = this.qZoneVideoTimeoutTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d mediaPreviewVH, int position) {
        Intrinsics.checkNotNullParameter(mediaPreviewVH, "mediaPreviewVH");
        mediaPreviewVH.l(this.previewMedia.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        boolean z16 = true;
        if (viewType != MediaType.LOCAL_IMAGE.ordinal() && viewType != MediaType.QZONE_IMAGE.ordinal()) {
            z16 = false;
        }
        if (z16) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.f169197i73, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026m_view, viewGroup, false)");
            return new b(this, inflate);
        }
        if (viewType == MediaType.LOCAL_VIDEO.ordinal()) {
            WinkLocalVideoPreviewView winkLocalVideoPreviewView = new WinkLocalVideoPreviewView(this.context, this.videoViewCallBack, this.isVideoAutoPlay);
            winkLocalVideoPreviewView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new c(this, winkLocalVideoPreviewView);
        }
        if (viewType == MediaType.QZONE_VIDEO.ordinal()) {
            WinkQZoneVideoPreviewView winkQZoneVideoPreviewView = new WinkQZoneVideoPreviewView(this.context, this.videoViewCallBack);
            winkQZoneVideoPreviewView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            winkQZoneVideoPreviewView.setCallback(new f(winkQZoneVideoPreviewView));
            return new e(this, winkQZoneVideoPreviewView);
        }
        return new g(this, new View(this.context));
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$f", "Lcom/tencent/mobileqq/wink/picker/core/view/WinkQZoneVideoPreviewView$b;", "", "onVideoLoadStart", "onVideoPlayStart", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements WinkQZoneVideoPreviewView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkQZoneVideoPreviewView f324468b;

        f(WinkQZoneVideoPreviewView winkQZoneVideoPreviewView) {
            this.f324468b = winkQZoneVideoPreviewView;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.WinkQZoneVideoPreviewView.b
        public void onVideoLoadStart() {
            CountDownTimer countDownTimer = WinkMediaPreviewAdapter.this.qZoneVideoTimeoutTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            WinkMediaPreviewAdapter.this.qZoneVideoTimeoutTimer = new a(this.f324468b);
            CountDownTimer countDownTimer2 = WinkMediaPreviewAdapter.this.qZoneVideoTimeoutTimer;
            Intrinsics.checkNotNull(countDownTimer2);
            countDownTimer2.start();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.WinkQZoneVideoPreviewView.b
        public void onVideoPlayStart() {
            CountDownTimer countDownTimer = WinkMediaPreviewAdapter.this.qZoneVideoTimeoutTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter$f$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a extends CountDownTimer {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WinkQZoneVideoPreviewView f324469a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(WinkQZoneVideoPreviewView winkQZoneVideoPreviewView) {
                super(2000L, 1000L);
                this.f324469a = winkQZoneVideoPreviewView;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.f324469a.F();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }
        }
    }
}
