package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u0015R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ap;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "p1", "u1", "v1", "t1", "Landroid/view/View;", "view", "o1", "data", "", "position", ICustomDataEditor.STRING_PARAM_1, "", "w0", "K0", "M0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "I", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "mAntiSpamReportHelper", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "mAuthorNameLayout", "Lcom/tencent/biz/qqcircle/widgets/QCircleMaxHeightScrollView;", "K", "Lcom/tencent/biz/qqcircle/widgets/QCircleMaxHeightScrollView;", "mQCircleMaxHeightScrollView", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "mAuthorName", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "M", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mFeedPostContentView", "N", "Landroid/view/View;", "mAdCardWindow", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "mFeedPostFeedBack", "Lcom/tencent/gdtad/aditem/GdtAd;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", BdhLogUtil.LogTag.Tag_Req, "Lfeedcloud/FeedCloudMeta$StFeed;", "mAdFeed", ExifInterface.LATITUDE_SOUTH, "mAdCardStyle", "", "T", "Z", "mIsInitView", "<init>", "()V", "U", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ap extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    @NotNull
    private static final a U = new a(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GdtAntiSpamReportHelper mAntiSpamReportHelper = new GdtAntiSpamReportHelper();

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAuthorNameLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QCircleMaxHeightScrollView mQCircleMaxHeightScrollView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView mAuthorName;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QCircleAsyncTextView mFeedPostContentView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View mAdCardWindow;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView mFeedPostFeedBack;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private GdtAd mAd;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mAdFeed;

    /* renamed from: S, reason: from kotlin metadata */
    private int mAdCardStyle;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mIsInitView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ap$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(ap this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1(this$0.mFeedPostContentView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(ap this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t1();
    }

    private final void o1(View view) {
        int i3;
        if (view == null) {
            return;
        }
        Integer a16 = com.tencent.biz.qqcircle.immersive.feed.ad.a.f85437a.a(view, false);
        String adAntiSpamForClickParams = this.mAntiSpamReportHelper.getAdAntiSpamForClickParams(this.C);
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        GdtAd gdtAd = this.mAd;
        int i16 = this.f85018i;
        QCircleExtraTypeInfo r16 = r();
        if (a16 != null) {
            i3 = a16.intValue();
        } else {
            i3 = 1000;
        }
        jVar.J(gdtAd, view, i16, r16, i3, adAntiSpamForClickParams);
    }

    private final void p1() {
        TextView textView;
        QCircleAsyncTextView qCircleAsyncTextView;
        View view = this.C;
        if (view != null && !this.mIsInitView) {
            this.mIsInitView = true;
            this.mAuthorNameLayout = (LinearLayout) view.findViewById(R.id.v_h);
            this.mQCircleMaxHeightScrollView = (QCircleMaxHeightScrollView) this.C.findViewById(R.id.f58152p9);
            ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.v9u);
            if (viewStub != null) {
                viewStub.inflate();
            }
            View findViewById = this.C.findViewById(R.id.v9q);
            this.mAdCardWindow = findViewById;
            af.a(findViewById);
            View view2 = this.mAdCardWindow;
            ImageView imageView = null;
            if (view2 != null) {
                textView = (TextView) view2.findViewById(R.id.f3740176);
            } else {
                textView = null;
            }
            this.mAuthorName = textView;
            View view3 = this.mAdCardWindow;
            if (view3 != null) {
                qCircleAsyncTextView = (QCircleAsyncTextView) view3.findViewById(R.id.v9j);
            } else {
                qCircleAsyncTextView = null;
            }
            this.mFeedPostContentView = qCircleAsyncTextView;
            View view4 = this.mAdCardWindow;
            if (view4 != null) {
                imageView = (ImageView) view4.findViewById(R.id.f380218u);
            }
            this.mFeedPostFeedBack = imageView;
            u1();
            this.mAntiSpamReportHelper.listenOnTouchEvent(this.mAuthorName);
            TextView textView2 = this.mAuthorName;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.al
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view5) {
                        ap.q1(ap.this, view5);
                    }
                });
            }
            TextView textView3 = this.mAuthorName;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            this.mAntiSpamReportHelper.listenOnTouchEvent(this.mFeedPostContentView);
            QCircleAsyncTextView qCircleAsyncTextView2 = this.mFeedPostContentView;
            if (qCircleAsyncTextView2 != null) {
                qCircleAsyncTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.am
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view5) {
                        ap.r1(ap.this, view5);
                    }
                });
            }
            QCircleAsyncTextView qCircleAsyncTextView3 = this.mFeedPostContentView;
            if (qCircleAsyncTextView3 != null) {
                qCircleAsyncTextView3.setVisibility(0);
                return;
            }
            return;
        }
        QLog.w("QFSFeedChildAdBottomAreaPresenter", 1, "[initView] cancel, rootView=" + view + ",isInitView=" + this.mIsInitView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(ap this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(ap this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ak(u.c(this$0.E).f398449id.get(), null));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t1() {
        x.e(this.C, this.mAd, u.c(this.E), ae.c(r0(), null, this.mAd, this.f85018i), r());
    }

    private final void u1() {
        ImageView imageView = this.mFeedPostFeedBack;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.mAuthorName;
        if (textView != null) {
            textView.setVisibility(8);
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mFeedPostContentView;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setVisibility(8);
        }
    }

    private final void v1() {
        String str;
        boolean z16;
        String str2;
        int i3;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        QCircleAsyncTextView qCircleAsyncTextView = this.mFeedPostContentView;
        if (qCircleAsyncTextView == null) {
            return;
        }
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setNeedSpecialAreaBold(true);
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.mFeedPostContentView;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.setVisibility(0);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this.mFeedPostContentView;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.setTextSize(2, 14.0f);
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mAdFeed;
        String str3 = null;
        if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.content) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        eq eqVar = eq.f85700a;
        if (!eqVar.m(this.mAd, this.mAdCardStyle) && !eqVar.i(this.mAd, this.mAdCardStyle)) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.tencent.biz.qqcircle.immersive.utils.ad.a aVar = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a;
        if (aVar.k(this.E)) {
            str2 = str + " \u8fbe\u4eba\u5171\u4eab";
        } else {
            str2 = str;
        }
        boolean S = af.S(this.mFeedPostContentView, str2, com.tencent.biz.qqcircle.utils.cx.a(270.0f), 2);
        int i16 = R.drawable.mhr;
        if (S) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cl7)), 0, str.length(), 34);
            QCircleAsyncTextView qCircleAsyncTextView4 = this.mFeedPostContentView;
            if (qCircleAsyncTextView4 != null) {
                qCircleAsyncTextView4.d(spannableStringBuilder, 0, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ah
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                    public final void onClick() {
                        ap.w1(ap.this);
                    }
                }, R.color.f158017al3, false);
            }
            QCircleAsyncTextView qCircleAsyncTextView5 = this.mFeedPostContentView;
            if (qCircleAsyncTextView5 != null) {
                qCircleAsyncTextView5.setText(str);
            }
            ImageView imageView = this.mFeedPostFeedBack;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mFeedPostFeedBack;
            if (imageView2 != null) {
                if (!z16) {
                    i16 = R.drawable.mhk;
                }
                imageView2.setImageResource(i16);
            }
            if (aVar.k(this.E)) {
                af.p0(this.mFeedPostFeedBack, Boolean.FALSE);
            }
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
            spannableStringBuilder2.append((CharSequence) " ");
            int length = spannableStringBuilder2.length();
            boolean k3 = aVar.k(this.E);
            if (k3) {
                i3 = 78;
            } else {
                i3 = 38;
            }
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            Context m06 = m0();
            if (k3) {
                i16 = R.drawable.o1c;
            } else if (!z16) {
                i16 = R.drawable.mhk;
            }
            Drawable mutate = qCircleSkinHelper.getDrawable(m06, i16).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "getInstance().getDrawabl\u2026                .mutate()");
            mutate.setBounds(0, ImmersiveUtils.dpToPx(1.0f), ImmersiveUtils.dpToPx(i3), ImmersiveUtils.dpToPx(18.0f));
            QCircleAsyncTextView.e(spannableStringBuilder2, length, mutate);
            QCircleAsyncTextView qCircleAsyncTextView6 = this.mFeedPostContentView;
            if (qCircleAsyncTextView6 != null) {
                qCircleAsyncTextView6.showEllipseEndImageSpan(true);
            }
            QCircleAsyncTextView qCircleAsyncTextView7 = this.mFeedPostContentView;
            if (qCircleAsyncTextView7 != null) {
                qCircleAsyncTextView7.d(spannableStringBuilder2, 0, spannableStringBuilder2.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ai
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                    public final void onClick() {
                        ap.x1(ap.this);
                    }
                }, R.color.f158017al3, false);
            }
            QCircleAsyncTextView qCircleAsyncTextView8 = this.mFeedPostContentView;
            if (qCircleAsyncTextView8 != null) {
                qCircleAsyncTextView8.d(spannableStringBuilder2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.aj
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                    public final void onClick() {
                        ap.y1(ap.this);
                    }
                }, R.color.f158017al3, false);
            }
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cl7)), 0, length, 34);
            QCircleAsyncTextView qCircleAsyncTextView9 = this.mFeedPostContentView;
            if (qCircleAsyncTextView9 != null) {
                qCircleAsyncTextView9.setOnTriggerEllipseListener(new RFWAsyncRichTextView.OnTriggerEllipseListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ak
                    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnTriggerEllipseListener
                    public final void triggerEllipse() {
                        ap.z1(ap.this);
                    }
                });
            }
            QCircleAsyncTextView qCircleAsyncTextView10 = this.mFeedPostContentView;
            if (qCircleAsyncTextView10 != null) {
                qCircleAsyncTextView10.setText(spannableStringBuilder2);
            }
            ImageView imageView3 = this.mFeedPostFeedBack;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mAdFeed;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.nick) != null) {
            str3 = pBStringField.get();
        }
        if (!TextUtils.isEmpty(str3)) {
            TextView textView = this.mAuthorName;
            if (textView != null) {
                textView.setText("@" + str3);
            }
            TextView textView2 = this.mAuthorName;
            if (textView2 != null) {
                textView2.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView3 = this.mAuthorName;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(ap this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1(this$0.mFeedPostContentView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(ap this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1(this$0.mFeedPostContentView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(ap this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(final ap this$0) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSFeedChildAdBottomAreaPresenter", 1, "reset click event. ");
        QCircleAsyncTextView qCircleAsyncTextView = this$0.mFeedPostContentView;
        if (qCircleAsyncTextView != null) {
            charSequence = qCircleAsyncTextView.getText();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        ClickableSpan[] clkSpans = (ClickableSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(clkSpans, "clkSpans");
        for (ClickableSpan clickableSpan : clkSpans) {
            spannableStringBuilder.removeSpan(clickableSpan);
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this$0.mFeedPostContentView;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.d(spannableStringBuilder, 0, spannableStringBuilder.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.an
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    ap.A1(ap.this);
                }
            }, R.color.cl7, false);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this$0.mFeedPostContentView;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.d(spannableStringBuilder, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ao
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    ap.B1(ap.this);
                }
            }, R.color.cl7, false);
        }
        QCircleAsyncTextView qCircleAsyncTextView4 = this$0.mFeedPostContentView;
        if (qCircleAsyncTextView4 != null) {
            qCircleAsyncTextView4.setText(spannableStringBuilder);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        super.K0();
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            adInfo = gdtAd.info;
        } else {
            adInfo = null;
        }
        if (QFSTopViewManager.h(adInfo)) {
            af.r0(this.mAuthorNameLayout, 0);
            af.r0(this.mQCircleMaxHeightScrollView, 0);
            af.r0(this.mAdCardWindow, 8);
        } else {
            af.r0(this.mAuthorNameLayout, 8);
            af.r0(this.mQCircleMaxHeightScrollView, 8);
        }
        this.mAntiSpamReportHelper.setExpoTime();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        af.r0(this.mAuthorNameLayout, 0);
        af.r0(this.mQCircleMaxHeightScrollView, 0);
        this.mAntiSpamReportHelper.resetExpoTime();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        this.mAntiSpamReportHelper.onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        if (data == null) {
            QLog.e("QFSFeedChildAdCardPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        U0(ae.b(this.E.g(), position));
        try {
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            this.mAdFeed = c16;
            this.mAdCardStyle = c16.status.get();
            this.mAd = new GdtAd(u.e(this.E));
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdCardPresenter", 1, "[onBindData] failed, error is " + th5);
        }
        if (eq.f85700a.f(this.mAdCardStyle)) {
            return;
        }
        p1();
        v1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdBottomAreaPresenter";
    }
}
