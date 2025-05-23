package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.part.ab;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001FB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010<\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/comment/part/ab;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "J9", "N9", "Lcom/qzone/business/qboss/QbossAdvDesc;", "qbossAdvDesc", "H9", "G9", "onInitView", "", "qbossAdvType", "L9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mPanelRootView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mPrivateAreaGuide", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", tl.h.F, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mPrivateIconGuide", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mPrivateTextGuide", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mFontIconGuide", BdhLogUtil.LogTag.Tag_Conn, "mBarrageIconGuide", "D", "mGuideImageView", "Ldd/b;", "E", "Ldd/b;", "mInputViewModel", "", UserInfo.SEX_FEMALE, "Z", "mCanOpenVipActivity", "G", "mHasShowGuideAdv", "H", "Lcom/qzone/business/qboss/QbossAdvDesc;", "mCommentQbossAdvDesc", "I", "mPictureViewerCommentQbossAdvDesc", "", "J", "Ljava/lang/String;", "mGuideImageViewJumpUrl", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ab extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mBarrageIconGuide;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mGuideImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mCanOpenVipActivity;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mHasShowGuideAdv;

    /* renamed from: H, reason: from kotlin metadata */
    private QbossAdvDesc mCommentQbossAdvDesc;

    /* renamed from: I, reason: from kotlin metadata */
    private QbossAdvDesc mPictureViewerCommentQbossAdvDesc;

    /* renamed from: J, reason: from kotlin metadata */
    private String mGuideImageViewJumpUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPanelRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mPrivateAreaGuide;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mPrivateIconGuide;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mPrivateTextGuide;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mFontIconGuide;

    public ab(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
        this.mCanOpenVipActivity = true;
    }

    private final void H9(final QbossAdvDesc qbossAdvDesc) {
        String str;
        if (LoginData.getInstance().isQzoneVip()) {
            str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_svUJcaCyIZ.png";
        } else {
            str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_eiEc6zwDkg.png";
        }
        File imageFile = ImageLoader.getInstance().getImageFile(str);
        if (imageFile != null && imageFile.exists()) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.comment.part.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ab.I9(ab.this, qbossAdvDesc);
                }
            });
        } else {
            ImageLoader.getInstance().loadImage(str, (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(ab this$0, QbossAdvDesc qbossAdvDesc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9(qbossAdvDesc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(ab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.mPanelRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
            viewGroup = null;
        }
        new cd.i(viewGroup, this$0.initParams.getEnableBarrageEffect(), this$0.mGuideImageViewJumpUrl).i(this$0.mCommentQbossAdvDesc, this$0.mPictureViewerCommentQbossAdvDesc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(int i3, ab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dd.b bVar = null;
        if (i3 == 0) {
            dd.b bVar2 = this$0.mInputViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            } else {
                bVar = bVar2;
            }
            QbossAdvDesc W1 = bVar.W1(2655);
            this$0.mCommentQbossAdvDesc = W1;
            this$0.H9(W1);
            return;
        }
        if (i3 != 1) {
            return;
        }
        dd.b bVar3 = this$0.mInputViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
        } else {
            bVar = bVar3;
        }
        QbossAdvDesc W12 = bVar.W1(2864);
        this$0.mPictureViewerCommentQbossAdvDesc = W12;
        this$0.H9(W12);
    }

    private final void N9() {
        if (this.initParams.getShowPrivateComment() != -1 && this.initParams.getEnableFont() && this.initParams.getEnableBarrageEffect()) {
            L9(0);
        } else {
            L9(1);
        }
    }

    public final void L9(final int qbossAdvType) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.comment.part.z
            @Override // java.lang.Runnable
            public final void run() {
                ab.M9(qbossAdvType, this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        J9(rootView);
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.mHasShowGuideAdv) {
            return;
        }
        this.mHasShowGuideAdv = true;
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.comment.part.y
            @Override // java.lang.Runnable
            public final void run() {
                ab.K9(ab.this);
            }
        }, 300L);
    }

    private final void G9(QbossAdvDesc qbossAdvDesc) {
        String str;
        if (qbossAdvDesc == null) {
            return;
        }
        if (LoginData.getInstance().isQzoneVip()) {
            str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_svUJcaCyIZ.png";
        } else {
            str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_eiEc6zwDkg.png";
        }
        try {
            this.mGuideImageViewJumpUrl = new JSONObject(qbossAdvDesc.res_data).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        } catch (Exception e16) {
            QLog.e("QZoneCommentPanelPrivateGuidePart", 1, "addGuideAdv parse error " + e16);
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, new b());
        ImageView imageView = null;
        if (loadImage != null) {
            ImageView imageView2 = this.mGuideImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuideImageView");
                imageView2 = null;
            }
            imageView2.setImageDrawable(loadImage);
        }
        ImageView imageView3 = this.mGuideImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideImageView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void J9(View rootView) {
        View findViewById = rootView.findViewById(R.id.msr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_comment_panel_root_view)");
        this.mPanelRootView = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.msh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026panel_private_area_guide)");
        this.mPrivateAreaGuide = (LinearLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.msk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026panel_private_icon_guide)");
        this.mPrivateIconGuide = (QUICheckBox) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.msm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026panel_private_text_guide)");
        this.mPrivateTextGuide = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.ms5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026nt_panel_font_icon_guide)");
        this.mFontIconGuide = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.mrl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026arrage_effect_icon_guide)");
        this.mBarrageIconGuide = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.msi);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026panel_private_guide_view)");
        this.mGuideImageView = (ImageView) findViewById7;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/comment/part/ab$b", "Lcom/tencent/component/media/image/ImageLoader$ImageLoadListener;", "", "url", "Lcom/tencent/component/media/image/ImageLoader$Options;", "options", "", "onImageCanceled", "onImageFailed", "Landroid/graphics/drawable/Drawable;", "image", "onImageLoaded", "", "progress", "onImageProgress", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ImageLoader.ImageLoadListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Drawable drawable, ab this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (drawable != null) {
                ImageView imageView = this$0.mGuideImageView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuideImageView");
                    imageView = null;
                }
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String url, final Drawable image, ImageLoader.Options options) {
            Activity activity = ab.this.getActivity();
            if (activity != null) {
                final ab abVar = ab.this;
                activity.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.comment.part.ac
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.b.b(image, abVar);
                    }
                });
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String url, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String url, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String url, float progress, ImageLoader.Options options) {
        }
    }
}
