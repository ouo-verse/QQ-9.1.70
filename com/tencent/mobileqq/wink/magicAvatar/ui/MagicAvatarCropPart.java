package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PortraitImageview;
import com.tencent.mobileqq.activity.photo.RegionView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "J9", "H9", "K9", "M9", "N9", "G9", "Landroid/graphics/Bitmap;", "result", "I9", "F9", "O9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "Lcom/tencent/mobileqq/activity/photo/PortraitImageview;", "e", "Lcom/tencent/mobileqq/activity/photo/PortraitImageview;", "portraitImageview", "Lcom/tencent/mobileqq/activity/photo/RegionView;", "f", "Lcom/tencent/mobileqq/activity/photo/RegionView;", "regionView", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "cropLayout", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "loadingLayout", "<init>", "(Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarCropPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarCropViewModel magicCropVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PortraitImageview portraitImageview;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RegionView regionView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup cropLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout loadingLayout;

    public MagicAvatarCropPart(@NotNull MagicAvatarCropViewModel magicCropVm) {
        Intrinsics.checkNotNullParameter(magicCropVm, "magicCropVm");
        this.magicCropVm = magicCropVm;
    }

    private final void E9() {
        ViewGroup.LayoutParams layoutParams;
        boolean isFolderScreenOpenMode = HippyUtils.isFolderScreenOpenMode(getContext());
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int f16 = oVar.f(context) - ViewExKt.d(QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE);
        w53.b.f("MagicAvatarCropPart", "adjustCropSize isFolderOpen = " + isFolderScreenOpenMode + ", remain = " + f16);
        ViewGroup viewGroup = this.cropLayout;
        if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
            int min = Math.min(com.tencent.videocut.utils.o.g(), f16);
            layoutParams.width = min;
            layoutParams.height = min;
            int i3 = min - 3;
            PortraitImageview portraitImageview = this.portraitImageview;
            if (portraitImageview != null) {
                portraitImageview.setRestrict(i3, i3);
            }
            PortraitImageview portraitImageview2 = this.portraitImageview;
            if (portraitImageview2 != null) {
                portraitImageview2.o();
            }
        }
    }

    private final void F9(Bitmap result) {
        PortraitImageview portraitImageview = this.portraitImageview;
        if (portraitImageview != null) {
            portraitImageview.setImageBitmap(result);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.regionView = new RegionView(getContext(), this.portraitImageview, 512, 512, 0, true);
        ViewGroup viewGroup = this.cropLayout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.cropLayout;
        if (viewGroup2 != null) {
            viewGroup2.addView(this.portraitImageview, layoutParams);
        }
        ViewGroup viewGroup3 = this.cropLayout;
        if (viewGroup3 != null) {
            viewGroup3.addView(this.regionView, layoutParams);
        }
    }

    private final void G9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropPart$initObserver$1(this, null));
    }

    private final void H9() {
        String generateAvatarFilePath;
        boolean z16;
        MagicAvatarGenerateInfo infoFromPicker = this.magicCropVm.getInfoFromPicker();
        if (infoFromPicker != null && (generateAvatarFilePath = infoFromPicker.getGenerateAvatarFilePath()) != null) {
            if (generateAvatarFilePath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQToast.makeText(getContext(), ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC, 1).show();
                return;
            }
            w53.b.f("MagicAvatarCropPart", "onInitView");
            this.magicCropVm.r2();
            this.magicCropVm.N2(generateAvatarFilePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(Bitmap result) {
        FrameLayout frameLayout = this.loadingLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        F9(result);
    }

    private final void J9() {
        this.magicCropVm.Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        FrameLayout frameLayout = this.loadingLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        View c16 = com.tencent.mobileqq.guild.util.qqui.d.c(getContext(), false);
        TextView textView = (TextView) c16.findViewById(R.id.yt9);
        if (textView != null) {
            textView.setText("\u70b9\u51fb\u91cd\u8bd5");
        }
        ImageView imageView = (ImageView) c16.findViewById(R.id.ysu);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(c16.getContext(), R.drawable.oqx));
        }
        c16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MagicAvatarCropPart.L9(MagicAvatarCropPart.this, view);
            }
        });
        FrameLayout frameLayout2 = this.loadingLayout;
        if (frameLayout2 != null) {
            frameLayout2.addView(c16);
        }
        O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(MagicAvatarCropPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("MagicAvatarCropPart", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
        this$0.magicCropVm.w2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        FrameLayout frameLayout = this.loadingLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(URLDrawable.getDrawable("https://qq-video.cdn-go.cn/android/latest/defaultmode/8973/qvideo_dark_emptystate_img_nocontent.png", URLDrawable.URLDrawableOptions.obtain()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewExKt.d(80), ViewExKt.d(80));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        FrameLayout frameLayout2 = this.loadingLayout;
        if (frameLayout2 != null) {
            frameLayout2.addView(imageView);
        }
        O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        FrameLayout frameLayout = this.loadingLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        View e16 = com.tencent.mobileqq.guild.util.qqui.d.e(getContext(), ViewExKt.d(48), ViewExKt.d(48), 1);
        FrameLayout frameLayout2 = this.loadingLayout;
        if (frameLayout2 != null) {
            frameLayout2.addView(e16);
        }
        O9();
    }

    private final void O9() {
        int i3;
        try {
            FrameLayout frameLayout = this.loadingLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ViewGroup viewGroup = this.cropLayout;
            if (viewGroup != null) {
                i3 = viewGroup.getMeasuredWidth();
            } else {
                i3 = 360;
            }
            int i16 = i3 - 6;
            if (i16 <= 0) {
                w53.b.c("MagicAvatarCropPart", "editWidth <= 0");
                return;
            }
            Bitmap bitmap = Bitmap.createBitmap(i16, i16, Bitmap.Config.ARGB_8888);
            new Canvas(bitmap).drawColor(-16777216);
            ViewGroup viewGroup2 = this.cropLayout;
            if (viewGroup2 != null) {
                if (viewGroup2.getChildCount() == 0) {
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    F9(bitmap);
                } else {
                    PortraitImageview portraitImageview = this.portraitImageview;
                    if (portraitImageview != null) {
                        portraitImageview.setImageBitmap(bitmap);
                    }
                }
            }
        } catch (Exception e16) {
            w53.b.d("MagicAvatarCropPart", "triggerLoading error", e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        Bitmap bitmap;
        if (Intrinsics.areEqual(action, "broadcast_photo")) {
            MagicAvatarCropViewModel magicAvatarCropViewModel = this.magicCropVm;
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) args).booleanValue();
            RegionView regionView = this.regionView;
            if (regionView != null) {
                bitmap = regionView.a();
            } else {
                bitmap = null;
            }
            magicAvatarCropViewModel.x2(booleanValue, bitmap);
            return;
        }
        if (Intrinsics.areEqual(action, "broadcast_init")) {
            H9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w53.b.f("MagicAvatarCropPart", "onConfigurationChanged");
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        FrameLayout frameLayout = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.ubo);
        } else {
            viewGroup = null;
        }
        this.cropLayout = viewGroup;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.loading_layout);
        }
        this.loadingLayout = frameLayout;
        this.portraitImageview = new PortraitImageview(getContext());
        E9();
        J9();
        G9();
    }
}
