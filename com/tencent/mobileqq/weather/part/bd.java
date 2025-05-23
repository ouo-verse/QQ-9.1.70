package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.weather.event.WeatherViewPageSelectChangeEvent;
import com.tencent.mobileqq.weather.part.briefwarning.WeatherBriefWarningView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001jB\u0007\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J*\u0010\u001d\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$0#H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00107\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0016\u00109\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010,R\u0016\u0010:\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u00102R\u0016\u0010<\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00102R\u0016\u0010=\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u00102R\u0016\u0010>\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u0016\u0010?\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u00102R\u0016\u0010B\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010@R\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010DR\u0016\u0010P\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010DR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u0018\u0010\\\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010UR\u0016\u0010^\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010RR\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/weather/part/bd;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "w", UserInfo.SEX_FEMALE, "G", "", "url", "D", "", "weatherType", "H", "L", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "B", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mVideoContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mVideoCoverView", "f", "mWindImg", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mWindText", "i", "mHumidityImg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mHumidityText", BdhLogUtil.LogTag.Tag_Conn, "mAirQualityView", "mAirQualityText", "E", "mUpdateDescText", "mTemperatureText", "mBigTemperatureText", "mBigTemperatureDesc", "I", "Landroid/view/View;", "mBottomBarBg", "Lcom/tencent/mobileqq/weather/part/briefwarning/WeatherBriefWarningView;", "J", "Lcom/tencent/mobileqq/weather/part/briefwarning/WeatherBriefWarningView;", "mBriefWarningView", "Lcom/tencent/mobileqq/weather/data/t;", "K", "Lcom/tencent/mobileqq/weather/data/t;", "mBean", "mPagePosition", "", "M", "mTodaySunSetTimeStamp", "N", "mTodaySunRiseTimeStamp", "P", "Z", "mIsNight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "mMoonUrl", BdhLogUtil.LogTag.Tag_Req, "mHeadBackgroundPicUrl", ExifInterface.LATITUDE_SOUTH, "mVideoUrl", "T", "mImageUrl", "U", "mIsVideoReady", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "V", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "mVideoView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "W", "Lcom/tencent/superplayer/api/ISuperPlayer;", "mSuperPlayer", "<init>", "()V", "X", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class bd extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mAirQualityView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAirQualityText;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mUpdateDescText;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mTemperatureText;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mBigTemperatureText;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mBigTemperatureDesc;

    /* renamed from: I, reason: from kotlin metadata */
    private View mBottomBarBg;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private WeatherBriefWarningView mBriefWarningView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.weather.data.t mBean;

    /* renamed from: L, reason: from kotlin metadata */
    private int mPagePosition;

    /* renamed from: M, reason: from kotlin metadata */
    private long mTodaySunSetTimeStamp;

    /* renamed from: N, reason: from kotlin metadata */
    private long mTodaySunRiseTimeStamp;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsNight;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String mMoonUrl;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String mHeadBackgroundPicUrl;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private String mVideoUrl;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private String mImageUrl;

    /* renamed from: U, reason: from kotlin metadata */
    private volatile boolean mIsVideoReady;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private ISPlayerVideoView mVideoView;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ISuperPlayer mSuperPlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mVideoContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mVideoCoverView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mWindImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mWindText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mHumidityImg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mHumidityText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/weather/part/bd$a;", "", "", "TAG", "Ljava/lang/String;", "TEMP_SUB", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.bd$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMoonUrl = "";
            this.mHeadBackgroundPicUrl = "";
        }
    }

    private final boolean A() {
        return !TextUtils.isEmpty(this.mHeadBackgroundPicUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(bd this$0, com.tencent.mobileqq.weather.data.k kVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Context context = this$0.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        gVar.O(context, "https://e.weather.com.cn/");
        com.tencent.mobileqq.weather.util.report.r.f313695a.c(((com.tencent.mobileqq.weather.data.t) kVar).a());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D(String url) {
        boolean z16;
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("WeatherTopVideoSection", 1, "openMediaPlayer url is empty");
            return;
        }
        QLog.i("WeatherTopVideoSection", 2, "openMediaPlayer url is " + url + " " + this);
        w();
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(url, 101, (String) null, (String) null);
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.openMediaPlayer(MobileQQ.sMobileQQ, createVideoInfoForUrl, 0L);
        }
    }

    private final void F() {
        if (GdtUIUtils.getPercentageOfGlobalVisibleRect(this.mRootView) > 0.0d && this.mIsVideoReady) {
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.start();
                return;
            }
            return;
        }
        ISuperPlayer iSuperPlayer2 = this.mSuperPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.pause();
        }
    }

    private final void G() {
        boolean z16;
        int currentTimeMillis = (int) (((float) System.currentTimeMillis()) / 1000.0f);
        long j3 = this.mTodaySunRiseTimeStamp;
        long j16 = this.mTodaySunSetTimeStamp;
        long j17 = currentTimeMillis;
        if (j3 <= j17 && j17 < j16) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = !z16;
        this.mIsNight = z17;
        QLog.d("WeatherTopVideoSection", 1, "isNight:", Boolean.valueOf(z17));
    }

    private final void H(int weatherType) {
        boolean endsWith$default;
        QLog.d("WeatherTopVideoSection", 1, "updateVideo:", Integer.valueOf(weatherType));
        if (A()) {
            return;
        }
        String y16 = com.tencent.mobileqq.weather.util.g.f313646a.y(weatherType, ".mp4", this.mIsNight);
        if (this.mIsNight && !TextUtils.isEmpty(this.mMoonUrl)) {
            if (weatherType == 2) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.mMoonUrl, ".mp4", false, 2, null);
                if (endsWith$default) {
                    y16 = this.mMoonUrl;
                }
            }
            if (weatherType == 1) {
                return;
            }
        }
        if (Intrinsics.areEqual(this.mVideoUrl, y16)) {
            return;
        }
        this.mVideoUrl = y16;
        if (QQVideoPlaySDKManager.isSDKReady()) {
            String str = this.mVideoUrl;
            if (str != null) {
                D(str);
                return;
            }
            return;
        }
        QLog.e("WeatherTopVideoSection", 1, "updateVideo: sdk not ready");
        QQVideoPlaySDKManager.initSDKAsync(this.mRootView.getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.weather.part.ay
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public final void onSDKInited(boolean z16) {
                bd.J(bd.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final bd this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("WeatherTopVideoSection", 1, "updateVideo: sdk inited:", Boolean.valueOf(z16));
        if (z16) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.weather.part.az
                @Override // java.lang.Runnable
                public final void run() {
                    bd.K(bd.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(bd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.mVideoUrl;
        if (str != null) {
            this$0.D(str);
        }
    }

    private final void L(int weatherType) {
        String str;
        boolean endsWith$default;
        ImageView imageView = null;
        if (A()) {
            str = this.mHeadBackgroundPicUrl;
        } else {
            String y16 = com.tencent.mobileqq.weather.util.g.f313646a.y(weatherType, ".png", this.mIsNight);
            if (this.mIsNight && weatherType == 1 && !TextUtils.isEmpty(this.mMoonUrl)) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.mMoonUrl, ".png", false, 2, null);
                if (endsWith$default) {
                    str = this.mMoonUrl;
                }
            }
            str = y16;
        }
        if (Intrinsics.areEqual(str, this.mImageUrl)) {
            return;
        }
        this.mImageUrl = str;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = new ColorDrawable(Color.parseColor("#F2F2F2"));
        obtain.mLoadingDrawable = new ColorDrawable(Color.parseColor("#F2F2F2"));
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(imgUrl, options)");
        QLog.i("WeatherTopVideoSection", 2, "openImg url is " + str + " " + this);
        ImageView imageView2 = this.mVideoCoverView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverView");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(drawable);
    }

    private final void v() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            View view = this.mBottomBarBg;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBarBg");
                view = null;
            }
            view.setBackground(this.mRootView.getResources().getDrawable(R.drawable.kzv));
        }
    }

    private final void w() {
        if (this.mSuperPlayer == null) {
            final ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(MobileQQ.sMobileQQ, 136, this.mVideoView);
            createMediaPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.weather.part.ba
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
                public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                    bd.x(bd.this, iSuperPlayer);
                }
            });
            createMediaPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.weather.part.bb
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
                public final boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                    boolean y16;
                    y16 = bd.y(ISuperPlayer.this, iSuperPlayer, i3, i16, i17, str);
                    return y16;
                }
            });
            createMediaPlayer.setLoopback(true);
            createMediaPlayer.setOutputMute(true);
            createMediaPlayer.setXYaxis(1);
            this.mSuperPlayer = createMediaPlayer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(bd this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mIsVideoReady = true;
        this$0.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(final ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2, int i3, int i16, int i17, String str) {
        QLog.e("WeatherTopVideoSection", 2, "onError " + iSuperPlayer);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.weather.part.bc
            @Override // java.lang.Runnable
            public final void run() {
                bd.z(ISuperPlayer.this);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ISuperPlayer iSuperPlayer) {
        View view;
        Object videoView = iSuperPlayer.getVideoView();
        if (videoView instanceof View) {
            view = (View) videoView;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        com.tencent.mobileqq.weather.data.u e16;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (!(data instanceof com.tencent.mobileqq.weather.data.t)) {
            return;
        }
        com.tencent.mobileqq.weather.data.t tVar = (com.tencent.mobileqq.weather.data.t) data;
        if (tVar.e() == null) {
            QLog.e("WeatherTopVideoSection", 1, "data is null");
            return;
        }
        if (tVar.d(this.mBean)) {
            QLog.e("WeatherTopVideoSection", 1, "cancel update");
            return;
        }
        com.tencent.mobileqq.weather.data.u e17 = tVar.e();
        this.mPagePosition = tVar.a();
        TextView textView = this.mWindText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindText");
            textView = null;
        }
        textView.setText(e17.m());
        TextView textView3 = this.mHumidityText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumidityText");
            textView3 = null;
        }
        textView3.setText(e17.d());
        TextView textView4 = this.mAirQualityText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAirQualityText");
            textView4 = null;
        }
        textView4.setText(e17.a());
        TextView textView5 = this.mTemperatureText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemperatureText");
            textView5 = null;
        }
        textView5.setText(e17.c() + "/" + e17.e() + BdhLogUtil.LogTag.Tag_Conn);
        TextView textView6 = this.mBigTemperatureText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigTemperatureText");
            textView6 = null;
        }
        textView6.setText(e17.i());
        TextView textView7 = this.mUpdateDescText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpdateDescText");
            textView7 = null;
        }
        textView7.setText(e17.j());
        TextView textView8 = this.mBigTemperatureDesc;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigTemperatureDesc");
            textView8 = null;
        }
        textView8.setText(e17.k());
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        this.mTodaySunRiseTimeStamp = gVar.r(e17.g(), 0);
        this.mTodaySunSetTimeStamp = gVar.s(e17.h(), 0);
        this.mMoonUrl = e17.f();
        this.mHeadBackgroundPicUrl = e17.b();
        G();
        FrameLayout frameLayout = this.mVideoContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainer");
            frameLayout = null;
        }
        if (frameLayout.getChildCount() == 0) {
            Object obj = this.mVideoView;
            if (obj instanceof View) {
                view = (View) obj;
            } else {
                view = null;
            }
            if (view != null) {
                FrameLayout frameLayout2 = this.mVideoContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoContainer");
                    frameLayout2 = null;
                }
                frameLayout2.addView(view);
            }
        }
        com.tencent.mobileqq.weather.data.t tVar2 = this.mBean;
        if (tVar2 == null || (e16 = tVar2.e()) == null || e17.l() != e16.l()) {
            z16 = false;
        }
        if (!z16) {
            int l3 = e17.l();
            H(l3);
            L(l3);
        }
        TextView textView9 = this.mUpdateDescText;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpdateDescText");
        } else {
            textView2 = textView9;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.ax
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bd.C(bd.this, data, view2);
            }
        });
        this.mBean = tVar;
        WeatherBriefWarningView weatherBriefWarningView = this.mBriefWarningView;
        if (weatherBriefWarningView != null) {
            weatherBriefWarningView.d(gVar.i(tVar.b(), this.mIsNight, this.mPagePosition));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherViewPageSelectChangeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1193776o};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        WeatherBriefWarningView weatherBriefWarningView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, attached);
            return;
        }
        super.onAttachedChanged(attached);
        if (attached && (weatherBriefWarningView = this.mBriefWarningView) != null) {
            weatherBriefWarningView.m();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(null);
        }
        ISuperPlayer iSuperPlayer2 = this.mSuperPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setOnErrorListener(null);
        }
        ISuperPlayer iSuperPlayer3 = this.mSuperPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.release();
        }
        this.mSuperPlayer = null;
        this.mVideoView = null;
        WeatherBriefWarningView weatherBriefWarningView = this.mBriefWarningView;
        if (weatherBriefWarningView != null) {
            weatherBriefWarningView.onDestroy();
        }
        this.mBriefWarningView = null;
        super.onDestroy();
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
            View findViewById = containerView.findViewById(R.id.f167092kq3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.video_container)");
            this.mVideoContainer = (FrameLayout) findViewById;
            View findViewById2 = containerView.findViewById(R.id.kq_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.video_cover)");
            this.mVideoCoverView = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f122057cx);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.weather_wind_text)");
            this.mWindText = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f122047cw);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.weather_wind_img)");
            this.mWindImg = (ImageView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.f120997a2);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.weather_humidity_img)");
            this.mHumidityImg = (ImageView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.f121007a3);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.weather_humidity_text)");
            this.mHumidityText = (TextView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.f120777_g);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.weather_air_img)");
            this.mAirQualityView = (ImageView) findViewById7;
            View findViewById8 = containerView.findViewById(R.id.f120787_h);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "it.findViewById(R.id.weather_air_text)");
            this.mAirQualityText = (TextView) findViewById8;
            View findViewById9 = containerView.findViewById(R.id.f121957cn);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "it.findViewById(R.id.weather_update_text)");
            this.mUpdateDescText = (TextView) findViewById9;
            View findViewById10 = containerView.findViewById(R.id.f121627br);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "it.findViewById(R.id.weather_temperature_desc)");
            this.mTemperatureText = (TextView) findViewById10;
            View findViewById11 = containerView.findViewById(R.id.f120817_k);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "it.findViewById(R.id.weather_big_temperature_text)");
            this.mBigTemperatureText = (TextView) findViewById11;
            View findViewById12 = containerView.findViewById(R.id.f120807_j);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "it.findViewById(R.id.weather_big_air_desc)");
            this.mBigTemperatureDesc = (TextView) findViewById12;
            View findViewById13 = containerView.findViewById(R.id.f121937cl);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "it.findViewById(R.id.weather_top_radius_bg)");
            this.mBottomBarBg = findViewById13;
            this.mBriefWarningView = (WeatherBriefWarningView) containerView.findViewById(R.id.f120887_r);
        }
        this.mVideoView = SuperPlayerFactory.createPlayerVideoView(this.mRootView.getContext());
        SimpleEventBus.getInstance().registerReceiver(this);
        v();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        WeatherBriefWarningView weatherBriefWarningView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if (event instanceof WeatherViewPageSelectChangeEvent) {
            QLog.d("WeatherTopVideoSection", 1, "WeatherViewPageSelectChangeEvent");
            F();
            if (this.mPagePosition == ((WeatherViewPageSelectChangeEvent) event).getPagePosition() && (weatherBriefWarningView = this.mBriefWarningView) != null) {
                weatherBriefWarningView.n(this.mPagePosition);
            }
        }
    }
}
