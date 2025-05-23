package com.tencent.gdtad.basics.motivebrowsing;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.AdLinkReportForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivebrowsing.l;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u0000 T2\u00020\u0001:\u0002U\u000fB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010Q\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010M\u00a8\u0006V"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/l;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "model", "", "d", "Landroid/view/View;", "webView", "gdtMotiveVideoModel", "Lcom/tencent/gdtad/basics/motivebrowsing/l$b;", "reportCallback", "e", "Landroid/view/MotionEvent;", "motionEvent", "", "b", "v", "event", "onTouch", "", "originalUrl", "c", "Lcom/tencent/gdtad/basics/motivebrowsing/l$b;", "getReportCallback", "()Lcom/tencent/gdtad/basics/motivebrowsing/l$b;", "setReportCallback", "(Lcom/tencent/gdtad/basics/motivebrowsing/l$b;)V", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "getModel", "()Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "setModel", "(Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;)V", "f", "Z", "getFirstExposeReport", "()Z", "setFirstExposeReport", "(Z)V", "firstExposeReport", tl.h.F, "getFirstClickReport", "setFirstClickReport", "firstClickReport", "", "i", "J", "getClickDownTime", "()J", "setClickDownTime", "(J)V", "clickDownTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getClickUpTime", "setClickUpTime", "clickUpTime", "Lorg/json/JSONObject;", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "getClickJSONObject", "()Lorg/json/JSONObject;", "setClickJSONObject", "(Lorg/json/JSONObject;)V", "clickJSONObject", "", "D", "I", "getTouchSlop", "()I", "setTouchSlop", "(I)V", "touchSlop", "", "E", UserInfo.SEX_FEMALE, "getStartX", "()F", "setStartX", "(F)V", "startX", "getStartY", "setStartY", "startY", "<init>", "()V", "G", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class l implements View.OnTouchListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private JSONObject clickJSONObject;

    /* renamed from: D, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: E, reason: from kotlin metadata */
    private float startX;

    /* renamed from: F, reason: from kotlin metadata */
    private float startY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b reportCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtMotiveVideoModel model;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean firstExposeReport = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean firstClickReport = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long clickDownTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long clickUpTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/l$b;", "", "", "url", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "model", "", "c1", "", "clickStartTimeMillis", "w1", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface b {
        void c1(@NotNull String url, @Nullable GdtMotiveVideoModel model);

        void w1(@NotNull String url, @Nullable GdtMotiveVideoModel model, long clickStartTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b bVar, l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar != null) {
            bVar.c1("gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", this$0.model);
        }
        GdtLog.i("GdtMotiveBrowsingExperimentReportHelper", "report expose");
    }

    public final boolean b(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.clickUpTime = System.currentTimeMillis();
                    if (Math.abs(motionEvent.getRawX() - this.startX) >= this.touchSlop || Math.abs(motionEvent.getRawY() - this.startY) >= this.touchSlop) {
                        return false;
                    }
                    return true;
                }
            } else {
                this.startX = motionEvent.getRawX();
                this.startY = motionEvent.getRawY();
                this.clickDownTime = System.currentTimeMillis();
            }
        }
        return false;
    }

    @NotNull
    public final String c(@NotNull String originalUrl) {
        Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
        return originalUrl + "&s=" + URLEncoder.encode(String.valueOf(this.clickJSONObject));
    }

    public final void d(@Nullable GdtMotiveVideoModel model) {
        this.model = model;
    }

    public final void e(@Nullable View webView, @Nullable GdtMotiveVideoModel gdtMotiveVideoModel, @Nullable final b reportCallback) {
        if (!this.firstExposeReport) {
            return;
        }
        d(gdtMotiveVideoModel);
        if (webView != null) {
            webView.setOnTouchListener(this);
        }
        if (webView != null) {
            this.touchSlop = ViewConfiguration.get(webView.getContext()).getScaledTouchSlop();
        }
        this.reportCallback = reportCallback;
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.gdtad.basics.motivebrowsing.k
            @Override // java.lang.Runnable
            public final void run() {
                l.f(l.b.this, this);
            }
        }, 1000L);
        this.firstExposeReport = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        Context context;
        Context context2;
        if (this.firstClickReport && b(event)) {
            GdtLog.i("GdtMotiveBrowsingExperimentReportHelper", "report click");
            JSONObject jSONObject = new JSONObject();
            try {
                long abs = Math.abs(this.clickUpTime - this.clickDownTime);
                BaseApplication baseApplication = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(baseApplication.getResources().getDisplayMetrics(), "context.resources.displayMetrics");
                int instantScreenWidth = ScreenUtil.getInstantScreenWidth(baseApplication);
                int instantScreenHeight = ScreenUtil.getInstantScreenHeight(baseApplication) + ScreenUtil.getNavigationBarHeight(baseApplication);
                int h16 = x.h(baseApplication, instantScreenWidth);
                int h17 = x.h(baseApplication, instantScreenHeight);
                jSONObject.put("da", String.valueOf(h16));
                jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf(h17));
                jSONObject.put("px", "0");
                jSONObject.put("py", "0");
                jSONObject.put("sh", x.h(baseApplication, r7.heightPixels));
                jSONObject.put("sw", x.h(baseApplication, r7.widthPixels));
                if (event != null) {
                    jSONObject.put("aa", String.valueOf(x.h(baseApplication, event.getRawX())));
                    jSONObject.put("ab", String.valueOf(x.h(baseApplication, event.getRawY())));
                }
                jSONObject.put("g", String.valueOf(abs));
                GdtLog.i("GdtMotiveBrowsingExperimentReportHelper", "\u6309\u4e0b\u95f4\u9694:" + abs + " ; \u4e0a\u62a5\u5185\u5bb9:" + jSONObject);
            } catch (Exception e16) {
                GdtLog.e("GdtMotiveBrowsingExperimentReportHelper", "getReportString error", e16);
            }
            this.clickJSONObject = jSONObject;
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = null;
            if (v3 != null && (context2 = v3.getContext()) != null) {
                context = context2.getApplicationContext();
            } else {
                context = null;
            }
            GdtMotiveVideoModel gdtMotiveVideoModel = this.model;
            if (gdtMotiveVideoModel != null) {
                adInfo = gdtMotiveVideoModel.getAdInfo();
            }
            AdLinkReportForClick.linkReportForClickStart(context, new GdtAd(adInfo), 2);
            b bVar = this.reportCallback;
            if (bVar != null) {
                bVar.w1("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", this.model, System.currentTimeMillis());
            }
            this.firstClickReport = false;
        }
        return false;
    }
}
