package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.jungle.weather.proto.WeatherReportStore$DailyAstroFortune;
import com.tencent.jungle.weather.proto.WeatherReportStore$Fortune;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.weather.event.WeatherConstellationChangeEvent;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001|B\u0007\u00a2\u0006\u0004\by\u0010zJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J*\u0010$\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\t2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0014J\u0012\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040(0'H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010BR\u0018\u0010M\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010BR\u0018\u0010O\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010BR\u0018\u0010Q\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010BR\u0018\u0010R\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010BR\u0018\u0010T\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010BR\u0018\u0010V\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010BR\u0018\u0010X\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010BR\u0018\u0010Z\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010BR\u0018\u0010\\\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010BR\u0018\u0010^\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010BR\u0018\u0010`\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010>R\u0018\u0010b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010>R\u0018\u0010d\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010>R\u0018\u0010f\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010>R\u0018\u0010h\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010>R\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010kR\u0018\u0010r\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010BR\u0018\u0010t\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010BR\u0018\u0010v\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010BR\u0016\u0010x\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u00107\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/weather/part/j;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/jungle/weather/proto/WeatherReportStore$DailyAstroFortune;", "constellationData", "", HippyTKDListViewAdapter.X, "", LocalPhotoFaceInfo.SCORE, "y", "starPos", "startNum", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "view", "resId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", HippyControllerProps.STRING, "r", "t", "selectPos", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "v", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", NodeProps.VISIBLE, "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/weather/data/e;", "e", "Lcom/tencent/mobileqq/weather/data/e;", "mBeanData", "f", "I", "mCurrentPos", "Landroidx/cardview/widget/CardView;", tl.h.F, "Landroidx/cardview/widget/CardView;", "mCardContainer", "i", "Landroid/widget/ImageView;", "mBg", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mName", BdhLogUtil.LogTag.Tag_Conn, "mDate", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "mChange", "E", "mScore", UserInfo.SEX_FEMALE, "mFirstScore", "G", "mMiddleScore", "H", "mLastScore", "mFirstLabel", "J", "mMiddleLabel", "K", "mLastLabel", "L", "mFirstLabelPre", "M", "mMiddleLabelPre", "N", "mLastLabelPre", "P", "mLongDesc", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mStar1", BdhLogUtil.LogTag.Tag_Req, "mStar2", ExifInterface.LATITUDE_SOUTH, "mStar3", "T", "mStar4", "U", "mStar5", "Lcom/airbnb/lottie/LottieAnimationView;", "V", "Lcom/airbnb/lottie/LottieAnimationView;", "mFirstScoreImageView", "W", "mMiddleScoreImageView", "X", "mLastScoreImageView", "Y", "mConsLottieFirstName", "Z", "mConsLottieMiddleName", "a0", "mConsLottieLastName", "b0", "mPage", "<init>", "()V", "c0", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mDate;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mChange;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mScore;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mFirstScore;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mMiddleScore;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mLastScore;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView mFirstLabel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mMiddleLabel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView mLastLabel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView mFirstLabelPre;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView mMiddleLabelPre;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView mLastLabelPre;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView mLongDesc;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView mStar1;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ImageView mStar2;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView mStar3;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ImageView mStar4;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ImageView mStar5;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView mFirstScoreImageView;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView mMiddleScoreImageView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView mLastScoreImageView;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private TextView mConsLottieFirstName;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TextView mConsLottieMiddleName;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mConsLottieLastName;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int mPage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.weather.data.e mBeanData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCurrentPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardView mCardContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/weather/part/j$a;", "", "", "ALL_SCORE_TITLE", "Ljava/lang/String;", "BUSINESS_SCORE_TITLE", "COLOR_KEY", "CONS_KEY", "LOVE_SCORE_TITLE", "SCORE_KEY", "SCORE_SUB", "TAG", "WEALTH_SCORE_TITLE", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.j$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void q() {
        Drawable drawable;
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mName;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.mScore;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
            TextView textView3 = this.mFirstScore;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
            TextView textView4 = this.mMiddleScore;
            if (textView4 != null) {
                textView4.setTextColor(-1);
            }
            TextView textView5 = this.mLastScore;
            if (textView5 != null) {
                textView5.setTextColor(-1);
            }
            TextView textView6 = this.mFirstLabel;
            if (textView6 != null) {
                textView6.setTextColor(-1);
            }
            TextView textView7 = this.mMiddleLabel;
            if (textView7 != null) {
                textView7.setTextColor(-1);
            }
            TextView textView8 = this.mLastLabel;
            if (textView8 != null) {
                textView8.setTextColor(-1);
            }
            TextView textView9 = this.mFirstLabelPre;
            if (textView9 != null) {
                textView9.setTextColor(-1);
            }
            TextView textView10 = this.mMiddleLabelPre;
            if (textView10 != null) {
                textView10.setTextColor(-1);
            }
            TextView textView11 = this.mLastLabelPre;
            if (textView11 != null) {
                textView11.setTextColor(-1);
            }
            TextView textView12 = this.mLongDesc;
            if (textView12 != null) {
                textView12.setTextColor(-1);
            }
            TextView textView13 = this.mLongDesc;
            if (textView13 != null) {
                textView13.setBackgroundColor(Color.parseColor("#313131"));
            }
            TextView textView14 = this.mConsLottieFirstName;
            if (textView14 != null) {
                textView14.setTextColor(-1);
            }
            TextView textView15 = this.mConsLottieMiddleName;
            if (textView15 != null) {
                textView15.setTextColor(-1);
            }
            TextView textView16 = this.mConsLottieLastName;
            if (textView16 != null) {
                textView16.setTextColor(-1);
            }
            FrameLayout frameLayout = this.mChange;
            if (frameLayout != null) {
                Context context = this.mContext;
                if (context != null) {
                    drawable = context.getDrawable(R.drawable.kzy);
                } else {
                    drawable = null;
                }
                frameLayout.setBackground(drawable);
            }
            CardView cardView = this.mCardContainer;
            if (cardView != null) {
                cardView.setCardBackgroundColor(Color.parseColor("#1A1A1A"));
            }
        }
    }

    private final String r(String string) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(string, "%", "", false, 4, (Object) null);
        return replace$default;
    }

    private final int s(int starPos, int startNum) {
        int i3;
        if (com.tencent.mobileqq.weather.util.b.g()) {
            i3 = R.drawable.f161925nj3;
        } else {
            i3 = R.drawable.f161926nj4;
        }
        if (starPos <= startNum) {
            return R.drawable.nj5;
        }
        return i3;
    }

    private final void t() {
        if (this.mContext == null) {
            return;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        new n(context, this.mCurrentPos).show();
        com.tencent.mobileqq.weather.util.report.g.f313677a.c(this.mPage);
    }

    private final void u(int selectPos) {
        List<WeatherReportStore$DailyAstroFortune> list;
        boolean z16;
        weather$GetConcernWeatherReply b16;
        PBRepeatMessageField<WeatherReportStore$DailyAstroFortune> pBRepeatMessageField;
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        if (selectPos >= gVar.d().size()) {
            return;
        }
        String str = gVar.d().get(selectPos);
        com.tencent.mobileqq.weather.data.e eVar = this.mBeanData;
        if (eVar != null && (b16 = eVar.b()) != null && (pBRepeatMessageField = b16.all_astro) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        List<WeatherReportStore$DailyAstroFortune> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && selectPos < list.size()) {
            Iterator<WeatherReportStore$DailyAstroFortune> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeatherReportStore$DailyAstroFortune constellationData = it.next();
                String str2 = constellationData.astro.get();
                if (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, str)) {
                    Intrinsics.checkNotNullExpressionValue(constellationData, "constellationData");
                    x(constellationData);
                    break;
                }
            }
            this.mCurrentPos = selectPos;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x(WeatherReportStore$DailyAstroFortune constellationData) {
        List<WeatherReportStore$Fortune> list;
        ImageView imageView;
        TextView textView;
        String str;
        PBStringField pBStringField;
        String astroText = constellationData.astro.get();
        TextView textView2 = this.mName;
        if (textView2 != null) {
            textView2.setText(astroText);
        }
        if (!TextUtils.isEmpty(astroText)) {
            com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
            if (gVar.e().containsKey(astroText)) {
                TextView textView3 = this.mDate;
                if (textView3 != null) {
                    textView3.setText(gVar.e().get(astroText));
                }
                list = constellationData.fortunes.get();
                if (list.size() <= 8) {
                    TextView textView4 = this.mLongDesc;
                    if (textView4 != null) {
                        WeatherReportStore$Fortune weatherReportStore$Fortune = list.get(8);
                        if (weatherReportStore$Fortune != null && (pBStringField = weatherReportStore$Fortune.content) != null) {
                            str = pBStringField.get();
                        } else {
                            str = null;
                        }
                        textView4.setText(str);
                    }
                } else {
                    TextView textView5 = this.mLongDesc;
                    if (textView5 != null) {
                        textView5.setText(constellationData.astro_title.get());
                    }
                }
                imageView = this.mBg;
                if (imageView != null) {
                    com.tencent.mobileqq.weather.util.g gVar2 = com.tencent.mobileqq.weather.util.g.f313646a;
                    Intrinsics.checkNotNullExpressionValue(astroText, "astroText");
                    imageView.setImageDrawable(com.tencent.mobileqq.weather.util.b.e(gVar2.l(astroText, com.tencent.mobileqq.weather.util.b.g())));
                }
                for (WeatherReportStore$Fortune weatherReportStore$Fortune2 : list) {
                    String str2 = weatherReportStore$Fortune2.content.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "item.content.get()");
                    String r16 = r(str2);
                    if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u7efc\u5408\u6307\u6570")) {
                        TextView textView6 = this.mScore;
                        if (textView6 != null) {
                            textView6.setText(r16);
                        }
                        y(Integer.parseInt(r16));
                    } else if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u7231\u60c5\u6307\u6570")) {
                        TextView textView7 = this.mFirstScore;
                        if (textView7 != null) {
                            textView7.setText(r16);
                        }
                        LottieAnimationView lottieAnimationView = this.mFirstScoreImageView;
                        if (lottieAnimationView != null) {
                            lottieAnimationView.cancelAnimation();
                        }
                        LottieAnimationView lottieAnimationView2 = this.mFirstScoreImageView;
                        if (lottieAnimationView2 != null) {
                            lottieAnimationView2.setAnimationFromUrl("https://qq-weather.cdn-go.cn/hippy-weather/latest/circle-android.json");
                        }
                        LottieAnimationView lottieAnimationView3 = this.mFirstScoreImageView;
                        if (lottieAnimationView3 != null) {
                            lottieAnimationView3.setProgress(Float.parseFloat(r16) / 100);
                        }
                    } else if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u5de5\u4f5c\u6307\u6570")) {
                        TextView textView8 = this.mMiddleScore;
                        if (textView8 != null) {
                            textView8.setText(r16);
                        }
                        LottieAnimationView lottieAnimationView4 = this.mMiddleScoreImageView;
                        if (lottieAnimationView4 != null) {
                            lottieAnimationView4.cancelAnimation();
                        }
                        LottieAnimationView lottieAnimationView5 = this.mMiddleScoreImageView;
                        if (lottieAnimationView5 != null) {
                            lottieAnimationView5.setAnimationFromUrl("https://qq-weather.cdn-go.cn/hippy-weather/latest/circle-android.json");
                        }
                        LottieAnimationView lottieAnimationView6 = this.mMiddleScoreImageView;
                        if (lottieAnimationView6 != null) {
                            lottieAnimationView6.setProgress(Float.parseFloat(r16) / 100);
                        }
                    } else if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u8d22\u8fd0\u6307\u6570")) {
                        TextView textView9 = this.mLastScore;
                        if (textView9 != null) {
                            textView9.setText(r16);
                        }
                        LottieAnimationView lottieAnimationView7 = this.mLastScoreImageView;
                        if (lottieAnimationView7 != null) {
                            lottieAnimationView7.cancelAnimation();
                        }
                        LottieAnimationView lottieAnimationView8 = this.mLastScoreImageView;
                        if (lottieAnimationView8 != null) {
                            lottieAnimationView8.setAnimationFromUrl("https://qq-weather.cdn-go.cn/hippy-weather/latest/circle-android.json");
                        }
                        LottieAnimationView lottieAnimationView9 = this.mLastScoreImageView;
                        if (lottieAnimationView9 != null) {
                            lottieAnimationView9.setProgress(Float.parseFloat(r16) / 100);
                        }
                    } else if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u901f\u914d\uff31\u53cb")) {
                        TextView textView10 = this.mFirstLabel;
                        if (textView10 != null) {
                            textView10.setText(weatherReportStore$Fortune2.content.get());
                        }
                    } else if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u5e78\u8fd0\u6570\u5b57")) {
                        TextView textView11 = this.mMiddleLabel;
                        if (textView11 != null) {
                            textView11.setText(weatherReportStore$Fortune2.content.get());
                        }
                    } else if (Intrinsics.areEqual(weatherReportStore$Fortune2.type.get(), "\u5e78\u8fd0\u989c\u8272") && (textView = this.mLastLabel) != null) {
                        textView.setText(weatherReportStore$Fortune2.content.get());
                    }
                }
            }
        }
        TextView textView12 = this.mDate;
        if (textView12 != null) {
            textView12.setText(constellationData.date.get());
        }
        list = constellationData.fortunes.get();
        if (list.size() <= 8) {
        }
        imageView = this.mBg;
        if (imageView != null) {
        }
        while (r7.hasNext()) {
        }
    }

    private final void y(int score) {
        int roundToInt;
        if (score < 100) {
            roundToInt = MathKt__MathJVMKt.roundToInt(score / 20.0f);
        } else {
            roundToInt = 5;
        }
        z(this.mStar1, s(1, roundToInt));
        z(this.mStar2, s(2, roundToInt));
        z(this.mStar3, s(3, roundToInt));
        z(this.mStar4, s(4, roundToInt));
        z(this.mStar5, s(5, roundToInt));
    }

    private final void z(ImageView view, int resId) {
        if (view != null) {
            view.setImageDrawable(this.mRootView.getContext().getDrawable(resId));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherConstellationChangeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1190875w};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            this.mCardContainer = (CardView) containerView.findViewById(R.id.u4s);
            this.mBg = (ImageView) containerView.findViewById(R.id.u4r);
            this.mName = (TextView) containerView.findViewById(R.id.u5b);
            this.mDate = (TextView) containerView.findViewById(R.id.u4v);
            this.mChange = (FrameLayout) containerView.findViewById(R.id.u4t);
            this.mScore = (TextView) containerView.findViewById(R.id.u5c);
            this.mFirstScore = (TextView) containerView.findViewById(R.id.f164888u55);
            this.mMiddleScore = (TextView) containerView.findViewById(R.id.u5a);
            this.mLastScore = (TextView) containerView.findViewById(R.id.u58);
            this.mFirstLabel = (TextView) containerView.findViewById(R.id.u4w);
            this.mMiddleLabel = (TextView) containerView.findViewById(R.id.f164883u50);
            this.mLastLabel = (TextView) containerView.findViewById(R.id.u4y);
            this.mFirstLabelPre = (TextView) containerView.findViewById(R.id.u4x);
            this.mMiddleLabelPre = (TextView) containerView.findViewById(R.id.f164884u51);
            this.mLastLabelPre = (TextView) containerView.findViewById(R.id.u4z);
            this.mLongDesc = (TextView) containerView.findViewById(R.id.f164885u52);
            this.mStar1 = (ImageView) containerView.findViewById(R.id.u5e);
            this.mStar2 = (ImageView) containerView.findViewById(R.id.u5f);
            this.mStar3 = (ImageView) containerView.findViewById(R.id.u5g);
            this.mStar4 = (ImageView) containerView.findViewById(R.id.u5h);
            this.mStar5 = (ImageView) containerView.findViewById(R.id.u5i);
            this.mFirstScoreImageView = (LottieAnimationView) containerView.findViewById(R.id.f164886u53);
            this.mMiddleScoreImageView = (LottieAnimationView) containerView.findViewById(R.id.u59);
            this.mLastScoreImageView = (LottieAnimationView) containerView.findViewById(R.id.u56);
            this.mConsLottieFirstName = (TextView) containerView.findViewById(R.id.f164887u54);
            this.mConsLottieMiddleName = (TextView) containerView.findViewById(R.id.u5_);
            this.mConsLottieLastName = (TextView) containerView.findViewById(R.id.u57);
            this.mContext = containerView.getContext();
        }
        com.tencent.mobileqq.weather.util.b.j(this.mLongDesc, 5.0f);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else if (event instanceof WeatherConstellationChangeEvent) {
            u(((WeatherConstellationChangeEvent) event).getPosition());
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, visible);
            return;
        }
        super.onVisibleChanged(visible);
        if (visible) {
            com.tencent.mobileqq.weather.util.report.g.f313677a.e(this.mPage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data instanceof com.tencent.mobileqq.weather.data.e) {
            com.tencent.mobileqq.weather.data.e eVar = (com.tencent.mobileqq.weather.data.e) data;
            this.mBeanData = eVar;
            this.mPage = eVar.a();
            WeatherReportStore$DailyAstroFortune constellationData = eVar.b().astro.get();
            String str = constellationData.astro.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(constellationData, "constellationData");
            x(constellationData);
            String str2 = constellationData.astro.get();
            com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
            if (gVar.d().contains(str2)) {
                this.mCurrentPos = gVar.d().indexOf(str2);
                FrameLayout frameLayout = this.mChange;
                if (frameLayout != null) {
                    frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            j.w(j.this, view);
                        }
                    });
                }
            }
            q();
        }
    }
}
