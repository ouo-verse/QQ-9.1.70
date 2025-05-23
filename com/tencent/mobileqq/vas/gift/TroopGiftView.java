package com.tencent.mobileqq.vas.gift;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.api.ITroopGiftApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.anonymous.api.IAnonymousApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u00017\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\b=\u0010AB#\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\b=\u0010DJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/TroopGiftView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/vas/gift/b;", "Lcom/tencent/mobileqq/aio/msg/ai;", "msgItem", "", HippyTKDListViewAdapter.X, "itemTroop", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "o", "Lorg/libpag/PAGView;", "pagView", "", "pagPath", "u", "troop", "troopId", "p", "v", "troopGiftItem", "Lcom/tencent/mobileqq/vas/gift/a;", "giftListener", "r", "y", "pagFile", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/data/msglist/a;", "a", "pauseAnim", "resumeAnim", "Landroid/view/View;", "getView", "Lz33/a;", "d", "Lz33/a;", "binding", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "animator", "f", "Ljava/lang/String;", "sendUin", tl.h.F, "receiveUin", "Lcom/tencent/mobileqq/vas/gift/TroopGiftPagView;", "i", "Lcom/tencent/mobileqq/vas/gift/TroopGiftPagView;", "pagHeadPagView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "bgPagView", "com/tencent/mobileqq/vas/gift/TroopGiftView$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/gift/TroopGiftView$b;", "giftHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TroopGiftView extends RelativeLayout implements com.tencent.mobileqq.vas.gift.b {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float E = ViewUtils.dpToPx(4.0f);
    private static final float F = ViewUtils.dpToPx(16.0f);
    private static boolean G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private b giftHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private z33.a binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sendUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String receiveUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopGiftPagView pagHeadPagView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasPagView bgPagView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/TroopGiftView$a;", "", "", "isPause", "Z", "a", "()Z", "b", "(Z)V", "", "BG_IMAGE_FILENAME", "Ljava/lang/String;", "", "BG_RADIUS", UserInfo.SEX_FEMALE, "BIRTH_BG_PNG", "BTN_RADIUS", "PIAO_DAI_IMAGE_FILENAME", "", "REPORT_EXPOSE_DELAY", "J", "", "REPORT_EXPOSE_WHAT", "I", "RESUME_PAG_DELAY", "STATIC_PRE_VIEW_IMAGE_FILENAME", "TAG", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.gift.TroopGiftView$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return TroopGiftView.G;
        }

        public final void b(boolean z16) {
            TroopGiftView.G = z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/gift/TroopGiftView$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            ai aiVar;
            TextGiftElement j26;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            if (obj instanceof ai) {
                aiVar = (ai) obj;
            } else {
                aiVar = null;
            }
            if (aiVar == null || msg2.what != 1 || (j26 = aiVar.j2()) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("gift_price", String.valueOf(j26.price));
            hashMap.put("gift_type", aiVar.i2());
            ITroopGiftApi iTroopGiftApi = (ITroopGiftApi) QRoute.api(ITroopGiftApi.class);
            String valueOf = String.valueOf(j26.giftId);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(textGiftItem.giftId)");
            String str = j26.giftName;
            Intrinsics.checkNotNullExpressionValue(str, "textGiftItem.giftName");
            iTroopGiftApi.reportTroopBirthGift("20", valueOf, str, "5", 101, hashMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/gift/TroopGiftView$c", "Lcom/tencent/mobileqq/vas/gift/c;", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements com.tencent.mobileqq.vas.gift.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f309284a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ai f309285b;

        c(a aVar, ai aiVar) {
            this.f309284a = aVar;
            this.f309285b = aiVar;
        }

        @Override // com.tencent.mobileqq.vas.gift.c
        public void a() {
            this.f309284a.A(this.f309285b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        z33.a g16 = z33.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.sendUin = "";
        this.receiveUin = "";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.pagHeadPagView = new TroopGiftPagView(context2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.bgPagView = new VasPagView(context3);
        this.giftHandler = new b();
        this.binding.f451848d.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
        this.binding.f451850f.setCornerRadiusAndMode(ViewUtils.dpToPx(16.0f), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(ai troopGiftItem, String pagFile, a giftListener) {
        if (q(troopGiftItem)) {
            this.binding.f451848d.setVisibility(8);
            a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
            VasDynamicDrawableCache vasDynamicDrawableCache = VasDynamicDrawableCache.INSTANCE;
            this.binding.f451850f.setImageDrawable(a16.l(vasDynamicDrawableCache).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).k("https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_bg.png").h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$showArkData$drawable$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                    float f16;
                    float f17;
                    Intrinsics.checkNotNullParameter(it, "it");
                    f16 = TroopGiftView.E;
                    it.D(f16);
                    f17 = TroopGiftView.E;
                    it.E(f17);
                }
            }).a());
            this.binding.f451848d.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(vasDynamicDrawableCache).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).k("https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_bg.png").h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$showArkData$btnDrawable$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                    float f16;
                    float f17;
                    Intrinsics.checkNotNullParameter(it, "it");
                    f16 = TroopGiftView.F;
                    it.D(f16);
                    f17 = TroopGiftView.F;
                    it.E(f17);
                }
            }).a());
        } else {
            this.binding.f451848d.setVisibility(0);
            String str = pagFile + File.separator + "arkBackgroundImage.png";
            if (new File(str).exists()) {
                this.binding.f451850f.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$showArkData$drawable$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                        invoke2(kVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                        float f16;
                        float f17;
                        Intrinsics.checkNotNullParameter(it, "it");
                        f16 = TroopGiftView.F;
                        it.D(f16);
                        f17 = TroopGiftView.F;
                        it.E(f17);
                    }
                }).a());
                this.binding.f451848d.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$showArkData$btnDrawable$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                        invoke2(kVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                        float f16;
                        float f17;
                        Intrinsics.checkNotNullParameter(it, "it");
                        f16 = TroopGiftView.E;
                        it.D(f16);
                        f17 = TroopGiftView.E;
                        it.E(f17);
                    }
                }).a());
            } else {
                this.binding.f451848d.setImageDrawable(new ColorDrawable(Color.parseColor("#FF5FAEFF")));
                this.binding.f451850f.setImageDrawable(new ColorDrawable(Color.parseColor("#FF5FAEFF")));
            }
        }
        String str2 = File.separator;
        String str3 = pagFile + str2 + "staticPreviewImage.png";
        if (new File(str3).exists()) {
            this.binding.f451851g.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str3).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).a());
        } else {
            this.binding.f451851g.setImageDrawable(null);
        }
        String str4 = pagFile + str2 + "piaodai.pag";
        if (new File(str4).exists()) {
            this.pagHeadPagView.setJumpFile(str4);
            this.pagHeadPagView.setPlayEndListener(new c(giftListener, troopGiftItem));
            if (q(troopGiftItem) && Intrinsics.areEqual(troopGiftItem.getExtInfoFromExtStr("mNeedShowGift", "true"), "true")) {
                this.bgPagView.api().build();
                this.bgPagView.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$showArkData$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                        invoke2(pAGView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable PAGView pAGView) {
                        if (pAGView != null) {
                            TroopGiftView.this.u(pAGView, ((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).getBirthPagPath());
                        }
                    }
                });
                this.bgPagView.setVisibility(0);
            }
            this.pagHeadPagView.w();
            v();
        }
    }

    private final void B() {
        this.binding.f451849e.removeAllViews();
        this.binding.f451846b.removeAllViews();
        this.pagHeadPagView.setVisibility(8);
        this.bgPagView.setVisibility(8);
        this.animator = null;
    }

    private final void o() {
        if (this.pagHeadPagView.getParent() == null) {
            this.binding.f451849e.addView(this.pagHeadPagView);
        }
        if (this.bgPagView.getParent() == null) {
            this.binding.f451846b.addView(this.bgPagView);
        }
    }

    private final void p(ai troop, String troopId) {
        try {
            TextGiftElement j26 = troop.j2();
            if (j26 == null) {
                return;
            }
            VideoReport.addToDetectionWhitelist(QBaseActivity.sTopActivity);
            VideoReport.setPageId(this, "pg_sgrp_giftgroup_native");
            HashMap hashMap = new HashMap();
            hashMap.put("dt_qq_h5", Long.valueOf(j26.senderUin));
            hashMap.put("qq_receiver_id", Long.valueOf(j26.receiverUin));
            hashMap.put("birthday", Integer.valueOf(j26.sendType));
            hashMap.put("yes_gift_id", Long.valueOf(j26.giftId));
            hashMap.put("qq_group_id", troopId);
            hashMap.put("qq_gift_name", j26.giftName);
            hashMap.put("qq_gift_price", Long.valueOf(j26.price));
            VideoReport.setPageParams(this, new PageParams(hashMap));
            VideoReport.setElementId(this.binding.f451851g, "em_sgrp_giftgroup_smallpic");
            VideoReport.setElementId(this.binding.f451847c, "em_sgrp_giftgroup_btn");
            VideoReport.reportEvent("pgin", this, hashMap);
            VideoReport.reportEvent("imp", this, hashMap);
            VideoReport.reportEvent("imp", this.binding.f451851g, hashMap);
            VideoReport.reportEvent("imp", this.binding.f451847c, hashMap);
        } catch (Exception unused) {
        }
    }

    private final boolean q(ai itemTroop) {
        TextGiftElement j26 = itemTroop.j2();
        if (j26 == null || j26.sendType != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(ai troopGiftItem, a giftListener) {
        TextGiftElement j26 = troopGiftItem.j2();
        if (j26 == null) {
            return;
        }
        int i3 = (int) j26.tianquanId;
        String headPagPath = ((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).getHeadPagPath(i3);
        if (((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).isDownloaded(i3)) {
            A(troopGiftItem, headPagPath, giftListener);
        } else {
            y();
            ((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).startGiftPagDownload(i3, new TroopGiftView$loadArkData$1(this, troopGiftItem, headPagPath, giftListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(a giftListener, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(giftListener, "$giftListener");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        giftListener.A0(msgItem);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(a giftListener, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(giftListener, "$giftListener");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        giftListener.D0(msgItem);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(PAGView pagView, String pagPath) {
        PAGFile Load;
        File file = new File(pagPath);
        if (file.exists() && (Load = PagViewMonitor.Load(file.getAbsolutePath())) != null) {
            pagView.setComposition(Load);
            pagView.setRepeatCount(1);
            pagView.play();
        }
    }

    private final void v() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.4f, 1.0f);
        if (ofFloat != null) {
            ofFloat.setStartDelay(2000L);
            ofFloat.setDuration(500L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.vas.gift.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TroopGiftView.w(TroopGiftView.this, valueAnimator);
                }
            });
            this.binding.f451851g.setVisibility(0);
            ofFloat.start();
            if (G) {
                ofFloat.pause();
            }
        } else {
            ofFloat = null;
        }
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(TroopGiftView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.binding.f451851g.setScaleX((valueAnimator.getAnimatedFraction() * 0.6f) + 0.4f);
        this$0.binding.f451851g.setScaleY((valueAnimator.getAnimatedFraction() * 0.6f) + 0.4f);
    }

    private final void x(ai msgItem) {
        this.giftHandler.removeMessages(1);
        Message message = new Message();
        message.what = 1;
        message.obj = msgItem;
        this.giftHandler.sendMessageDelayed(message, 2000L);
    }

    private final void y() {
        this.binding.f451848d.setImageDrawable(new ColorDrawable(Color.parseColor("#FF5FAEFF")));
        this.binding.f451850f.setImageDrawable(new ColorDrawable(Color.parseColor("#FF5FAEFF")));
        this.binding.f451851g.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(TroopGiftView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (G) {
            return;
        }
        this$0.o();
        ValueAnimator valueAnimator = this$0.animator;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
        this$0.pagHeadPagView.u();
        this$0.bgPagView.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$resumeAnim$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying() || TroopGiftView.INSTANCE.a() || it.getProgress() >= 1.0d) {
                    return;
                }
                it.play();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r3);
     */
    @Override // com.tencent.mobileqq.vas.gift.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final a giftListener) {
        BaseQQAppInterface baseQQAppInterface;
        String str;
        Float floatOrNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(giftListener, "giftListener");
        if (!(msgItem instanceof ai)) {
            return;
        }
        B();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        ai aiVar = (ai) msgItem;
        TextGiftElement j26 = aiVar.j2();
        if (j26 == null) {
            return;
        }
        String str2 = j26.paddingTop;
        if (str2 != null && floatOrNull != null) {
            this.binding.f451851g.setTranslationY(0 - (floatOrNull.floatValue() * 0.484f));
        }
        if (Intrinsics.areEqual(currentAccountUin, String.valueOf(j26.receiverUin))) {
            this.binding.f451857m.setText("\u6211");
        } else {
            this.binding.f451857m.setText(j26.receiverNick);
        }
        TextView textView = this.binding.f451858n;
        if (q(aiVar)) {
            str = "\u795d\u4f60\u751f\u65e5\u5feb\u4e50\uff5e\uff5e";
        } else {
            str = j26.giftName;
        }
        textView.setText(str);
        TextView textView2 = this.binding.f451856l;
        g gVar = g.f309293a;
        textView2.setText(gVar.f(j26));
        if (Intrinsics.areEqual(currentAccountUin, String.valueOf(j26.senderUin))) {
            this.binding.f451847c.setBackgroundResource(R.drawable.lmx);
            this.binding.f451847c.setContentDescription("\u7ee7\u7eed\u9001");
        } else if (Intrinsics.areEqual(currentAccountUin, String.valueOf(j26.receiverUin))) {
            this.binding.f451847c.setBackgroundResource(R.drawable.lmz);
            this.binding.f451847c.setContentDescription("\u56de\u793c");
        } else {
            if (q(aiVar)) {
                this.binding.f451847c.setBackgroundResource(R.drawable.lmw);
            } else {
                this.binding.f451847c.setBackgroundResource(R.drawable.lmy);
            }
            this.binding.f451847c.setContentDescription("\u6211\u4e5f\u9001");
        }
        this.pagHeadPagView.setBirthType(q(aiVar));
        if (!G) {
            o();
        }
        this.binding.f451847c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.gift.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopGiftView.s(a.this, msgItem, view);
            }
        });
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.gift.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopGiftView.t(a.this, msgItem, view);
            }
        });
        this.sendUin = String.valueOf(j26.senderUin);
        String valueOf = String.valueOf(j26.receiverUin);
        this.receiveUin = valueOf;
        gVar.h(Long.parseLong(valueOf), new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$onBindData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                TroopGiftPagView troopGiftPagView;
                String str3;
                TroopGiftPagView troopGiftPagView2;
                troopGiftPagView = TroopGiftView.this.pagHeadPagView;
                troopGiftPagView.setRecBitmap(bitmap);
                if (((ai) msgItem).getMsgRecord().anonymousExtInfo != null) {
                    Bitmap drawableToBitmap = BaseImageUtil.drawableToBitmap(((IAnonymousApi) QRoute.api(IAnonymousApi.class)).getAvatarDrawable((AIOMsgItem) msgItem));
                    troopGiftPagView2 = TroopGiftView.this.pagHeadPagView;
                    troopGiftPagView2.setSendBitmap(drawableToBitmap);
                    TroopGiftView.this.r((ai) msgItem, giftListener);
                    return;
                }
                g gVar2 = g.f309293a;
                str3 = TroopGiftView.this.sendUin;
                long parseLong = Long.parseLong(str3);
                final TroopGiftView troopGiftView = TroopGiftView.this;
                final com.tencent.aio.data.msglist.a aVar = msgItem;
                final a aVar2 = giftListener;
                gVar2.h(parseLong, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$onBindData$4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap2) {
                        invoke2(bitmap2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Bitmap bitmap2) {
                        TroopGiftPagView troopGiftPagView3;
                        troopGiftPagView3 = TroopGiftView.this.pagHeadPagView;
                        troopGiftPagView3.setSendBitmap(bitmap2);
                        TroopGiftView.this.r((ai) aVar, aVar2);
                    }
                });
            }
        });
        x(aiVar);
        String str3 = aiVar.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.peerUid");
        p(aiVar, str3);
    }

    @Override // com.tencent.mobileqq.vas.gift.b
    public void pauseAnim() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
        this.pagHeadPagView.t();
        this.bgPagView.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vas.gift.TroopGiftView$pauseAnim$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPlaying() && TroopGiftView.INSTANCE.a()) {
                    it.stop();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.gift.b
    public void resumeAnim() {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopGiftView.z(TroopGiftView.this);
            }
        }, 200L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        z33.a g16 = z33.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.sendUin = "";
        this.receiveUin = "";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.pagHeadPagView = new TroopGiftPagView(context2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.bgPagView = new VasPagView(context3);
        this.giftHandler = new b();
        this.binding.f451848d.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
        this.binding.f451850f.setCornerRadiusAndMode(ViewUtils.dpToPx(16.0f), 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        z33.a g16 = z33.a.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.sendUin = "";
        this.receiveUin = "";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.pagHeadPagView = new TroopGiftPagView(context2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.bgPagView = new VasPagView(context3);
        this.giftHandler = new b();
        this.binding.f451848d.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
        this.binding.f451850f.setCornerRadiusAndMode(ViewUtils.dpToPx(16.0f), 1);
    }

    @Override // com.tencent.mobileqq.vas.gift.b
    @NotNull
    public View getView() {
        return this;
    }
}
