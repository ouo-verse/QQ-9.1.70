package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumUnAuthorizePart$urlDrawableDownListener$2;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import v83.e;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/part/MemoryAlbumUnAuthorizePart;", "Lp53/b;", "Landroid/widget/TextView;", "imageView", "", "B9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "visibility", "E9", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "path", "Lcom/tencent/image/URLDrawableDownListener;", "listener", "D9", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", "d", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/a;", "memoryAlbumPreviewViewModel", "e", "Landroid/widget/TextView;", "openBtn", "f", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "backImage", h.F, "A9", "()Lcom/tencent/image/URLDrawableDownListener;", "urlDrawableDownListener", "<init>", "()V", "i", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MemoryAlbumUnAuthorizePart extends p53.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy memoryAlbumPreviewViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView openBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView backImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy urlDrawableDownListener;

    public MemoryAlbumUnAuthorizePart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumUnAuthorizePart$memoryAlbumPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a) MemoryAlbumUnAuthorizePart.this.getViewModel(com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a.class);
            }
        });
        this.memoryAlbumPreviewViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MemoryAlbumUnAuthorizePart$urlDrawableDownListener$2.a>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.MemoryAlbumUnAuthorizePart$urlDrawableDownListener$2

            @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/part/MemoryAlbumUnAuthorizePart$urlDrawableDownListener$2$a", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "i", "onLoadProgressed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
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
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
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
        this.urlDrawableDownListener = lazy2;
    }

    private final URLDrawableDownListener A9() {
        return (URLDrawableDownListener) this.urlDrawableDownListener.getValue();
    }

    private final void B9(TextView imageView) {
        String str;
        VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_OPEN_BUTTON);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        if (e.f441245a.f()) {
            str = "1";
        } else {
            str = "0";
        }
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_AUTHORIZE_MEMORIES_COLLECTION, str);
        VideoReport.setElementParams(imageView, reportMap);
        VideoReport.setElementEndExposePolicy(imageView, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(MemoryAlbumUnAuthorizePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9(false);
        ar.f326685a.m("ae_key_editor_need_show_memory_album_topic_new", false);
        e.f441245a.m(true);
        this$0.z9().M1(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a z9() {
        Object value = this.memoryAlbumPreviewViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-memoryAlbumPreviewViewModel>(...)");
        return (com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.a) value;
    }

    public final void D9(@NotNull RoundCornerImageView imageView, @NotNull String path, @NotNull URLDrawableDownListener listener) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(listener, "listener");
        imageView.setURLDrawableDownListener(listener);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        int screenWidth = ImmersiveUtils.getScreenWidth() - x.a(40.0f);
        obtain.mRequestWidth = screenWidth;
        obtain.mRequestHeight = (int) (screenWidth * 1.5f);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        imageView.setImageDrawable(URLDrawable.getDrawable(path, obtain));
    }

    public final void E9(boolean visibility) {
        ConstraintLayout constraintLayout = (ConstraintLayout) getPartRootView().findViewById(R.id.z2w);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) getPartRootView().findViewById(R.id.z2t);
        ImageView imageView = (ImageView) getPartRootView().findViewById(R.id.f166233z34);
        if (visibility) {
            imageView.setVisibility(8);
            constraintLayout.setVisibility(8);
            constraintLayout2.setVisibility(0);
            constraintLayout2.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            return;
        }
        imageView.setVisibility(0);
        constraintLayout.setVisibility(0);
        constraintLayout2.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MemoryAlbumUnAuthorizePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.zyw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.open_memory_album_btn)");
        this.openBtn = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.zyy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.open_memory_album_image)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById2;
        this.backImage = roundCornerImageView;
        TextView textView = null;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            roundCornerImageView = null;
        }
        D9(roundCornerImageView, "https://downv6.qq.com/shadow_qqcamera/memoryalbum/authorization_vertical.png", A9());
        RoundCornerImageView roundCornerImageView2 = this.backImage;
        if (roundCornerImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImage");
            roundCornerImageView2 = null;
        }
        roundCornerImageView2.setCorner(x.a(8.0f));
        TextView textView2 = this.openBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoryAlbumUnAuthorizePart.C9(MemoryAlbumUnAuthorizePart.this, view);
            }
        });
        TextView textView3 = this.openBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openBtn");
        } else {
            textView = textView3;
        }
        B9(textView);
        E9(true);
    }
}
