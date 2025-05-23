package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001bR\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010)R\u0018\u0010:\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010)R\u0018\u0010<\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010)R\u0018\u0010>\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010)R\u0018\u0010@\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010)R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010C\u00a8\u0006K"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/be;", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedChildAdCardPresenter;", "", "P1", "S1", "T1", "R1", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "position", Constants.BASE_IN_PLUGIN_ID, "N1", "y1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onFeedUnSelected", "onStart", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "K0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderDetachedFromWindow", "Landroid/view/View;", "p0", "Landroid/view/View;", "mAdBusinessWindow", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "q0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAdBusinessLogo", "Landroid/widget/ImageView;", "r0", "Landroid/widget/ImageView;", "mAdBusinessFeedback", "s0", "mAdBusinessClose", "Landroid/widget/TextView;", "t0", "Landroid/widget/TextView;", "mAdBusinessTitle", "u0", "mAdBusinessBtnDes", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "v0", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "mAdBusinessShakeIcon", "w0", "mAdBusinessCardWindow", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "x0", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "mAdBusinessCardCover", "y0", "mAdBusinessCardDes", "z0", "mAdBusinessCardPrice", "A0", "mAdBusinessCardEndPrice", "B0", "mAdBusinessFirstLabel", "C0", "mAdBusinessLastLabel", "", "D0", "Z", "mIsBusinessCard", "E0", "mHasInitView", "<init>", "()V", "F0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class be extends QFSFeedChildAdCardPresenter {

    @NotNull
    private static final a F0 = new a(null);

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBusinessCardEndPrice;

    /* renamed from: B0, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBusinessFirstLabel;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBusinessLastLabel;

    /* renamed from: D0, reason: from kotlin metadata */
    private boolean mIsBusinessCard;

    /* renamed from: E0, reason: from kotlin metadata */
    private boolean mHasInitView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAdBusinessWindow;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView mAdBusinessLogo;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdBusinessFeedback;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdBusinessClose;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessTitle;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessBtnDes;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView mAdBusinessShakeIcon;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAdBusinessCardWindow;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleRoundImageView mAdBusinessCardCover;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessCardDes;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessCardPrice;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/be$a;", "", "", "AD_LOGO_AVATAR_SIZE", "I", "", "CARD_IMG_HEIGHT", UserInfo.SEX_FEMALE, "CARD_IMG_WIDTH", "LABEL_SIZE_MIN", "LABEL_TEXT_MAX_LENGTH", "", "PRICE_LABEL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void P1() {
        ViewStub viewStub;
        View view;
        QCircleRoundImageView qCircleRoundImageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        QCircleAvatarView qCircleAvatarView;
        ImageView imageView;
        TextView textView6;
        ImageView imageView2;
        GdtShakeIconView gdtShakeIconView;
        LinearLayout linearLayout;
        View view2 = this.f85356l0;
        if (view2 != null && !this.mHasInitView) {
            this.mHasInitView = true;
            TextView textView7 = null;
            if (this.mAdBusinessWindow == null) {
                View inflate = ((ViewStub) view2.findViewById(R.id.v9p)).inflate();
                this.mAdBusinessWindow = inflate;
                if (inflate != null) {
                    textView5 = (TextView) inflate.findViewById(R.id.f33270w0);
                } else {
                    textView5 = null;
                }
                this.mAdBusinessBtnDes = textView5;
                View view3 = this.mAdBusinessWindow;
                if (view3 != null) {
                    qCircleAvatarView = (QCircleAvatarView) view3.findViewById(R.id.f378618e);
                } else {
                    qCircleAvatarView = null;
                }
                this.mAdBusinessLogo = qCircleAvatarView;
                View view4 = this.mAdBusinessWindow;
                if (view4 != null) {
                    imageView = (ImageView) view4.findViewById(R.id.f379418m);
                } else {
                    imageView = null;
                }
                this.mAdBusinessClose = imageView;
                View view5 = this.mAdBusinessWindow;
                if (view5 != null) {
                    textView6 = (TextView) view5.findViewById(R.id.f379718p);
                } else {
                    textView6 = null;
                }
                this.mAdBusinessTitle = textView6;
                View view6 = this.mAdBusinessWindow;
                if (view6 != null) {
                    imageView2 = (ImageView) view6.findViewById(R.id.f379518n);
                } else {
                    imageView2 = null;
                }
                this.mAdBusinessFeedback = imageView2;
                View view7 = this.mAdBusinessWindow;
                if (view7 != null) {
                    gdtShakeIconView = (GdtShakeIconView) view7.findViewById(R.id.f379618o);
                } else {
                    gdtShakeIconView = null;
                }
                this.mAdBusinessShakeIcon = gdtShakeIconView;
                View view8 = this.mAdBusinessWindow;
                if (view8 != null) {
                    linearLayout = (LinearLayout) view8.findViewById(R.id.f33260vz);
                } else {
                    linearLayout = null;
                }
                F1(linearLayout);
                F1(this.mAdBusinessWindow);
                F1(this.mAdBusinessTitle);
                F1(this.mAdBusinessBtnDes);
                F1(this.mAdBusinessLogo);
                ImageView imageView3 = this.mAdBusinessFeedback;
                if (imageView3 != null) {
                    imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bd
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view9) {
                            be.Q1(be.this, view9);
                        }
                    });
                }
            }
            if (this.mAdBusinessCardWindow == null) {
                View view9 = this.mAdBusinessWindow;
                if (view9 != null) {
                    viewStub = (ViewStub) view9.findViewById(R.id.f379318l);
                } else {
                    viewStub = null;
                }
                if (viewStub != null) {
                    view = viewStub.inflate();
                } else {
                    view = null;
                }
                this.mAdBusinessCardWindow = view;
                if (view != null) {
                    qCircleRoundImageView = (QCircleRoundImageView) view.findViewById(R.id.f378718f);
                } else {
                    qCircleRoundImageView = null;
                }
                this.mAdBusinessCardCover = qCircleRoundImageView;
                View view10 = this.mAdBusinessCardWindow;
                if (view10 != null) {
                    textView = (TextView) view10.findViewById(R.id.f378818g);
                } else {
                    textView = null;
                }
                this.mAdBusinessCardDes = textView;
                View view11 = this.mAdBusinessCardWindow;
                if (view11 != null) {
                    textView2 = (TextView) view11.findViewById(R.id.f379218k);
                } else {
                    textView2 = null;
                }
                this.mAdBusinessCardPrice = textView2;
                View view12 = this.mAdBusinessCardWindow;
                if (view12 != null) {
                    textView3 = (TextView) view12.findViewById(R.id.f378918h);
                } else {
                    textView3 = null;
                }
                this.mAdBusinessCardEndPrice = textView3;
                View view13 = this.mAdBusinessCardWindow;
                if (view13 != null) {
                    textView4 = (TextView) view13.findViewById(R.id.f379018i);
                } else {
                    textView4 = null;
                }
                this.mAdBusinessFirstLabel = textView4;
                View view14 = this.mAdBusinessCardWindow;
                if (view14 != null) {
                    textView7 = (TextView) view14.findViewById(R.id.f379118j);
                }
                this.mAdBusinessLastLabel = textView7;
                F1(this.mAdBusinessCardWindow);
                F1(this.mAdBusinessCardCover);
                F1(this.mAdBusinessCardDes);
                F1(this.mAdBusinessCardPrice);
                F1(this.mAdBusinessCardEndPrice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(be this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R1() {
        TextView textView = this.mAdBusinessCardEndPrice;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mAdBusinessCardPrice;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.mAdBusinessFirstLabel;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        TextView textView4 = this.mAdBusinessLastLabel;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        GdtShakeIconView gdtShakeIconView = this.mAdBusinessShakeIcon;
        if (gdtShakeIconView != null) {
            gdtShakeIconView.setVisibility(8);
        }
    }

    private final void S1() {
        ImageView imageView;
        if (this.W != null && this.mAdBusinessWindow != null) {
            String str = this.X.poster.icon.iconUrl.get();
            Drawable drawable = null;
            if (!TextUtils.isEmpty(str)) {
                Option requestHeight = Option.obtain().setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(24.0f)).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(24.0f));
                QCircleAvatarView qCircleAvatarView = this.mAdBusinessLogo;
                if (qCircleAvatarView != null) {
                    imageView = qCircleAvatarView.k();
                } else {
                    imageView = null;
                }
                Option regionWidth = requestHeight.setTargetView(imageView).setUrl(str).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(24.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(24.0f));
                regionWidth.setSupportRecycler(true);
                QCircleFeedPicLoader.g().loadImage(regionWidth);
            }
            TextView textView = this.mAdBusinessTitle;
            if (textView != null) {
                textView.setText(this.X.poster.nick.get());
            }
            if (af.Z(this.W) && af.z(this.W) == 1) {
                String x16 = af.x(this.W);
                if (TextUtils.isEmpty(x16)) {
                    x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
                }
                TextView textView2 = this.mAdBusinessBtnDes;
                if (textView2 != null) {
                    textView2.setText(x16);
                }
                GdtShakeIconView gdtShakeIconView = this.mAdBusinessShakeIcon;
                if (gdtShakeIconView != null) {
                    gdtShakeIconView.setVisibility(0);
                }
            } else {
                TextView textView3 = this.mAdBusinessBtnDes;
                if (textView3 != null) {
                    textView3.setText(this.X.subtitle.get());
                }
                GdtShakeIconView gdtShakeIconView2 = this.mAdBusinessShakeIcon;
                if (gdtShakeIconView2 != null) {
                    gdtShakeIconView2.setVisibility(8);
                }
                GdtShakeIconView gdtShakeIconView3 = this.mAdBusinessShakeIcon;
                if (gdtShakeIconView3 != null) {
                    gdtShakeIconView3.stop();
                }
            }
            View view = this.mAdBusinessCardWindow;
            if (view != null) {
                drawable = view.getBackground();
            }
            if (drawable != null) {
                drawable.setAlpha(0);
            }
            G1();
        }
    }

    private final void T1() {
        boolean z16;
        boolean z17;
        TextPaint textPaint;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo adMaterialInfo = this.W.getAdMaterialInfo();
        if (adMaterialInfo != null) {
            TextView textView = this.mAdBusinessCardDes;
            if (textView != null) {
                textView.setText(adMaterialInfo.title.get());
            }
            QCircleRoundImageView qCircleRoundImageView = this.mAdBusinessCardCover;
            if (qCircleRoundImageView != null) {
                qCircleRoundImageView.setRoundRect(com.tencent.biz.qqcircle.utils.cx.a(3.0f));
            }
            Option regionWidth = Option.obtain().setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(72.0f)).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(72.0f)).setTargetView(this.mAdBusinessCardCover).setUrl(adMaterialInfo.image_url.get()).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(72.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(72.0f));
            regionWidth.setSupportRecycler(false);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
            List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> labelList = this.W.getLabelList();
            String price = adMaterialInfo.price.get();
            String str = adMaterialInfo.original_price.get();
            Intrinsics.checkNotNullExpressionValue(price, "price");
            boolean z18 = true;
            if (price.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TextView textView2 = this.mAdBusinessCardPrice;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.mAdBusinessCardPrice;
                if (textView3 != null) {
                    textView3.setText("\u00a5 " + price);
                }
                String str2 = adMaterialInfo.original_price.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.original_price.get()");
                if (str2.length() <= 0) {
                    z18 = false;
                }
                if (z18) {
                    TextView textView4 = this.mAdBusinessCardEndPrice;
                    if (textView4 != null) {
                        textView4.setText("\u00a5 " + str);
                    }
                    TextView textView5 = this.mAdBusinessCardEndPrice;
                    if (textView5 != null) {
                        textPaint = textView5.getPaint();
                    } else {
                        textPaint = null;
                    }
                    if (textPaint != null) {
                        textPaint.setFlags(16);
                    }
                    TextView textView6 = this.mAdBusinessCardEndPrice;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            String str3 = adMaterialInfo.original_price.get();
            Intrinsics.checkNotNullExpressionValue(str3, "it.original_price.get()");
            if (str3.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                TextView textView7 = this.mAdBusinessCardPrice;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                TextView textView8 = this.mAdBusinessCardPrice;
                if (textView8 != null) {
                    textView8.setText("\u00a5 " + str);
                    return;
                }
                return;
            }
            if (labelList != null && (!labelList.isEmpty())) {
                String str4 = labelList.get(0).content.get();
                TextView textView9 = this.mAdBusinessFirstLabel;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                TextView textView10 = this.mAdBusinessFirstLabel;
                if (textView10 != null) {
                    textView10.setText(str4);
                }
                if (labelList.size() > 1 && str4.length() < 9) {
                    TextView textView11 = this.mAdBusinessLastLabel;
                    if (textView11 != null) {
                        textView11.setVisibility(0);
                    }
                    TextView textView12 = this.mAdBusinessLastLabel;
                    if (textView12 != null) {
                        textView12.setText(labelList.get(1).content.get());
                    }
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1 */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        boolean d16 = eq.f85700a.d(this.W, this.Y);
        this.mIsBusinessCard = d16;
        if (!d16) {
            return;
        }
        P1();
        y1();
        R1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        H1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void N1() {
        super.N1();
        if (!this.mIsBusinessCard) {
            return;
        }
        S1();
        T1();
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            long j3 = 1000;
            qFSFeedAdCardAnimWrap.G(true, this.X.createTime.get() * j3, this.X.createTimeNs.get() * j3, this.X.syncTime.get() * j3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("QFSFeedChildAdBusinessCardPresenter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        v1();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        H1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        QLog.i("QFSFeedChildAdBusinessCardPresenter", 2, "onFeedUnSelected");
        if (!af.T(this.W)) {
            v1();
        }
        super.onFeedUnSelected(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onStart(selectInfo);
        H1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(@Nullable RFWFeedSelectInfo selectInfo) {
        v1();
        super.onStop(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("QFSFeedChildAdBusinessCardPresenter", 2, "onViewHolderDetachedFromWindow");
        v1();
        super.onViewHolderDetachedFromWindow(holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void y1() {
        this.f85358n0 = new QFSFeedAdCardAnimWrap(this.f85356l0, this.mAdBusinessWindow, this.mAdBusinessClose, this.X, this.W);
        super.y1();
    }
}
