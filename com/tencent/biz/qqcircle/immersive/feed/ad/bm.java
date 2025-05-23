package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.feed.ad.af;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\"R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010D\u00a8\u0006L"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/bm;", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedChildAdCardPresenter;", "", "z1", "S1", "W1", "V1", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "position", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/biz/qqcircle/immersive/feed/event/f;", "event", "t1", "N1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onFeedUnSelected", "onStart", "onResumed", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderDetachedFromWindow", "y1", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "p0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAdBannerAuthorAvatarView", "Landroid/widget/TextView;", "q0", "Landroid/widget/TextView;", "mAdBigBannerTitle", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "r0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mAdBigBannerPupDes", "Landroid/widget/ImageView;", "s0", "Landroid/widget/ImageView;", "mAdBigBannerFeedBack", "Landroid/widget/FrameLayout;", "t0", "Landroid/widget/FrameLayout;", "mAdBigBannerButton", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "u0", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "mBannerDownloadBtnController", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "v0", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "mBannerDownloadBtn", "w0", "mAdBigBannerButtonText", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "x0", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "mAdBigBannerButtonShakeIcon", "Landroid/graphics/drawable/Drawable;", "y0", "Landroid/graphics/drawable/Drawable;", "mFeedBackDrawableLight", "", "z0", "Z", "mIsDefaultCard", "A0", "mHasInitView", "<init>", "()V", "B0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bm extends QFSFeedChildAdCardPresenter {

    @NotNull
    private static final a B0 = new a(null);

    /* renamed from: A0, reason: from kotlin metadata */
    private boolean mHasInitView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView mAdBannerAuthorAvatarView;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBigBannerTitle;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAsyncTextView mAdBigBannerPupDes;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdBigBannerFeedBack;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mAdBigBannerButton;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdAppDownloadButtonController mBannerDownloadBtnController;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSAdDownloadButton mBannerDownloadBtn;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBigBannerButtonText;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView mAdBigBannerButtonShakeIcon;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mFeedBackDrawableLight;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDefaultCard;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/bm$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void S1() {
        View view = this.f85356l0;
        if (view != null && !this.mHasInitView) {
            this.mHasInitView = true;
            View findViewById = view.findViewById(R.id.f3742178);
            this.f85346b0 = findViewById;
            af.a(findViewById);
            this.mAdBannerAuthorAvatarView = (QCircleAvatarView) this.f85356l0.findViewById(R.id.f374617b);
            this.mAdBigBannerTitle = (TextView) this.f85356l0.findViewById(R.id.f376617v);
            this.mAdBigBannerPupDes = (QCircleAsyncTextView) this.f85356l0.findViewById(R.id.f375617l);
            this.mAdBigBannerFeedBack = (ImageView) this.f85356l0.findViewById(R.id.f374417_);
            this.mAdBigBannerButton = (FrameLayout) this.f85356l0.findViewById(R.id.f374817d);
            QFSAdDownloadButton qFSAdDownloadButton = (QFSAdDownloadButton) this.f85356l0.findViewById(R.id.f376517u);
            this.mBannerDownloadBtn = qFSAdDownloadButton;
            if (qFSAdDownloadButton != null) {
                qFSAdDownloadButton.setPrefixTag("QFSFeedChildAdDefaultCardPresenter");
            }
            this.mAdBigBannerButtonText = (TextView) this.f85356l0.findViewById(R.id.f375317i);
            this.mAdBigBannerButtonShakeIcon = (GdtShakeIconView) this.f85356l0.findViewById(R.id.f374917e);
            F1(this.mAdBigBannerButton);
            F1(this.mAdBigBannerPupDes);
            F1(this.f85346b0);
            F1(this.mAdBigBannerTitle);
            F1(this.mAdBannerAuthorAvatarView);
            ImageView imageView = this.mAdBigBannerFeedBack;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bi
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        bm.T1(bm.this, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(bm this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(bm this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdAppDownloadButtonController adAppDownloadButtonController = this$0.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
        if (!af.Z(this$0.W)) {
            return;
        }
        this$0.T0(new com.tencent.biz.qqcircle.immersive.feed.event.c(this$0.W.getTraceId(), true));
    }

    private final void V1() {
        int i3;
        int i16;
        boolean k3 = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.k(this.E);
        if (k3) {
            i3 = 78;
        } else {
            i3 = 38;
        }
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        Context m06 = m0();
        if (k3) {
            i16 = R.drawable.o1d;
        } else {
            i16 = R.drawable.mhn;
        }
        Drawable mutate = qCircleSkinHelper.getDrawable(m06, i16).mutate();
        this.mFeedBackDrawableLight = mutate;
        if (mutate != null) {
            mutate.setBounds(0, ImmersiveUtils.dpToPx(1.0f), ImmersiveUtils.dpToPx(i3), ImmersiveUtils.dpToPx(18.0f));
        }
    }

    private final void W1() {
        String str;
        ImageView imageView;
        TextView textView = this.mAdBigBannerTitle;
        if (textView != null) {
            textView.setTextColor(m0().getResources().getColor(R.color.black));
        }
        String str2 = this.X.poster.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str2)) {
            Option requestHeight = Option.obtain().setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(40.0f)).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(40.0f));
            QCircleAvatarView qCircleAvatarView = this.mAdBannerAuthorAvatarView;
            if (qCircleAvatarView != null) {
                imageView = qCircleAvatarView.k();
            } else {
                imageView = null;
            }
            Option regionWidth = requestHeight.setTargetView(imageView).setUrl(str2).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(40.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(40.0f));
            regionWidth.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
        }
        TextView textView2 = this.mAdBigBannerTitle;
        if (textView2 != null) {
            textView2.setText(this.X.poster.nick.get());
        }
        QFSAdDownloadButton qFSAdDownloadButton = this.mBannerDownloadBtn;
        if (qFSAdDownloadButton != null) {
            qFSAdDownloadButton.setPrefixText("");
        }
        if (af.Z(this.W) && af.z(this.W) == 1) {
            String x16 = af.x(this.W);
            if (TextUtils.isEmpty(x16)) {
                x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            QFSAdDownloadButton qFSAdDownloadButton2 = this.mBannerDownloadBtn;
            if (qFSAdDownloadButton2 != null) {
                qFSAdDownloadButton2.setPrefixText("\u6447\u52a8\u6216\u70b9\u51fb");
            }
            TextView textView3 = this.mAdBigBannerButtonText;
            if (textView3 != null) {
                textView3.setText(x16);
            }
            GdtShakeIconView gdtShakeIconView = this.mAdBigBannerButtonShakeIcon;
            if (gdtShakeIconView != null) {
                gdtShakeIconView.setVisibility(0);
            }
        } else {
            TextView textView4 = this.mAdBigBannerButtonText;
            if (textView4 != null) {
                textView4.setText(this.X.subtitle.get());
            }
            GdtShakeIconView gdtShakeIconView2 = this.mAdBigBannerButtonShakeIcon;
            if (gdtShakeIconView2 != null) {
                gdtShakeIconView2.setVisibility(8);
            }
            GdtShakeIconView gdtShakeIconView3 = this.mAdBigBannerButtonShakeIcon;
            if (gdtShakeIconView3 != null) {
                gdtShakeIconView3.stop();
            }
        }
        String str3 = this.X.content.get();
        com.tencent.biz.qqcircle.immersive.utils.ad.a aVar = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a;
        if (aVar.k(this.E)) {
            str = str3 + " \u8fbe\u4eba\u5171\u4eab";
        } else {
            str = str3;
        }
        if (af.S(this.mAdBigBannerPupDes, str, com.tencent.biz.qqcircle.utils.cx.a(248.0f), 2)) {
            QCircleAsyncTextView qCircleAsyncTextView = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView != null) {
                qCircleAsyncTextView.setText(str3);
            }
            QCircleAsyncTextView qCircleAsyncTextView2 = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView2 != null) {
                qCircleAsyncTextView2.setTextColor(m0().getResources().getColor(R.color.black));
            }
            ImageView imageView2 = this.mAdBigBannerFeedBack;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.mhn);
            }
            ImageView imageView3 = this.mAdBigBannerFeedBack;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            if (aVar.k(this.E)) {
                af.p0(this.mAdBigBannerFeedBack, Boolean.TRUE);
            }
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
            spannableStringBuilder.append((CharSequence) " ");
            QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.mFeedBackDrawableLight);
            QCircleAsyncTextView qCircleAsyncTextView3 = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView3 != null) {
                qCircleAsyncTextView3.showEllipseEndImageSpan(true);
            }
            this.f85345a0.listenOnTouchEvent(this.mAdBigBannerPupDes);
            QCircleAsyncTextView qCircleAsyncTextView4 = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView4 != null) {
                qCircleAsyncTextView4.d(spannableStringBuilder, 0, spannableStringBuilder.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bk
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                    public final void onClick() {
                        bm.X1(bm.this);
                    }
                }, R.color.black, false);
            }
            QCircleAsyncTextView qCircleAsyncTextView5 = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView5 != null) {
                qCircleAsyncTextView5.d(spannableStringBuilder, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bl
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                    public final void onClick() {
                        bm.Z1(bm.this);
                    }
                }, R.color.black, false);
            }
            QCircleAsyncTextView qCircleAsyncTextView6 = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView6 != null) {
                qCircleAsyncTextView6.setPreloadParserInfo(null);
            }
            spannableStringBuilder.append((CharSequence) "   ");
            QCircleAsyncTextView qCircleAsyncTextView7 = this.mAdBigBannerPupDes;
            if (qCircleAsyncTextView7 != null) {
                qCircleAsyncTextView7.setText(spannableStringBuilder);
            }
            ImageView imageView4 = this.mAdBigBannerFeedBack;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        QCircleAsyncTextView qCircleAsyncTextView8 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView8 != null) {
            qCircleAsyncTextView8.setClickAreaTextColor(m0().getResources().getColor(R.color.black));
        }
        QCircleAsyncTextView qCircleAsyncTextView9 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView9 != null) {
            qCircleAsyncTextView9.setTextColor(m0().getResources().getColor(R.color.black));
        }
        G1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(bm this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r1(this$0.mAdBigBannerPupDes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(bm this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(this$0.C);
    }

    private final void z1() {
        if (this.mBannerDownloadBtnController != null) {
            return;
        }
        QLog.d("QFSFeedChildAdDefaultCardPresenter", 1, "initDownloadBtnView isValid: " + af.k(this.W));
        Context m06 = m0();
        Intrinsics.checkNotNull(m06, "null cannot be cast to non-null type android.app.Activity");
        this.mBannerDownloadBtnController = af.R((Activity) m06, this.W, this.mBannerDownloadBtn, this.mAdBigBannerButton, R.drawable.kdt);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1 */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        boolean e16 = eq.f85700a.e(this.W, this.Y);
        this.mIsDefaultCard = e16;
        if (!e16) {
            return;
        }
        S1();
        GdtShakeIconView gdtShakeIconView = this.mAdBigBannerButtonShakeIcon;
        if (gdtShakeIconView != null) {
            gdtShakeIconView.setVisibility(8);
        }
        GdtShakeIconView gdtShakeIconView2 = this.mAdBigBannerButtonShakeIcon;
        if (gdtShakeIconView2 != null) {
            gdtShakeIconView2.stop();
        }
        V1();
        z1();
        y1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void N1() {
        super.N1();
        if (!this.mIsDefaultCard) {
            return;
        }
        W1();
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            long j3 = 1000;
            qFSFeedAdCardAnimWrap.G(true, this.X.createTime.get() * j3, this.X.createTimeNs.get() * j3, this.X.syncTime.get() * j3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("QFSFeedChildAdDefaultCardPresenter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        v1();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.mBannerDownloadBtn));
        }
        this.mBannerDownloadBtnController = null;
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        H1();
        z1();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        QLog.i("QFSFeedChildAdDefaultCardPresenter", 2, "onFeedUnSelected");
        if (!af.T(this.W)) {
            v1();
        }
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewPause();
        }
        super.onFeedUnSelected(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
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
        QLog.i("QFSFeedChildAdDefaultCardPresenter", 2, "onViewHolderDetachedFromWindow");
        v1();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.mBannerDownloadBtn));
        }
        this.mBannerDownloadBtnController = null;
        super.onViewHolderDetachedFromWindow(holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void t1(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.f event) {
        super.t1(event);
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void y1() {
        View view = this.f85356l0;
        View view2 = this.f85346b0;
        this.f85358n0 = new QFSFeedAdCardAnimWrap(view, view2, (ImageView) view2.findViewById(R.id.f375417j), this.X, this.W);
        af.Q(this.X, this.mAdBigBannerButton);
        this.f85358n0.F(new af.c() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bj
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.af.c
            public final void a() {
                bm.U1(bm.this);
            }
        });
    }
}
