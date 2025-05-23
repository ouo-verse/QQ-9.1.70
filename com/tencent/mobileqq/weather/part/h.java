package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weather.event.WeatherBannerTitleShowEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J*\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a`\u001bH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00101R\u0016\u0010;\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00101\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/weather/part/h;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "", "v", "Landroid/content/Context;", "u", "t", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mTitleArrow", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTitleDesc", tl.h.F, "mTitleName", "", "i", "Ljava/lang/String;", "mJumpUrl", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsMiniApp", BdhLogUtil.LogTag.Tag_Conn, "I", "mTitleType", "D", "mPagePos", "E", "mIsBannerNameShow", UserInfo.SEX_FEMALE, "mHasWeatherChangeTip", "<init>", "()V", "G", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mTitleType;

    /* renamed from: D, reason: from kotlin metadata */
    private int mPagePos;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile boolean mIsBannerNameShow;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mHasWeatherChangeTip;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mTitleArrow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTitleDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTitleName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mJumpUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMiniApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/weather/part/h$a;", "", "", "ALMANAC_DESC", "Ljava/lang/String;", "ALMANAC_NAME", "CONSTELLATION_NAME", "DES_DETAIL_TEXT", "QUOTE_DESC", "QUOTE_NAME", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.h$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mJumpUrl = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(h this$0, com.tencent.mobileqq.weather.data.k kVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(kVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mTitleName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView = null;
            }
            textView.setTextColor(-1);
        }
    }

    private final Context u() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private final void v(com.tencent.mobileqq.weather.data.k data) {
        if (this.mIsMiniApp) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(u(), this.mJumpUrl, 2016, null);
        } else {
            Intent intent = new Intent(u(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.mJumpUrl);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.addFlags(268435456);
            Context u16 = u();
            if (u16 != null) {
                u16.startActivity(intent);
            }
        }
        if (data instanceof com.tencent.mobileqq.weather.data.i) {
            com.tencent.mobileqq.weather.util.report.i.f313681a.c(((com.tencent.mobileqq.weather.data.i) data).a());
            return;
        }
        if (data instanceof com.tencent.mobileqq.weather.data.g) {
            com.tencent.mobileqq.weather.util.report.h.f313679a.c(((com.tencent.mobileqq.weather.data.g) data).a(), this.mHasWeatherChangeTip);
            return;
        }
        if (data instanceof com.tencent.mobileqq.weather.data.l) {
            com.tencent.mobileqq.weather.data.l lVar = (com.tencent.mobileqq.weather.data.l) data;
            if (lVar.e().size() == 0) {
                return;
            }
            com.tencent.mobileqq.weather.data.m mVar = lVar.e().get(0);
            Intrinsics.checkNotNullExpressionValue(mVar, "data.getQuoteData()[0]");
            com.tencent.mobileqq.weather.data.m mVar2 = mVar;
            com.tencent.mobileqq.weather.util.report.n.f313689a.f(String.valueOf(mVar2.d()), mVar2.g(), mVar2.a(), lVar.a());
            return;
        }
        if (data instanceof com.tencent.mobileqq.weather.data.e) {
            com.tencent.mobileqq.weather.util.report.g.f313677a.d(((com.tencent.mobileqq.weather.data.e) data).a());
        } else if (data instanceof com.tencent.mobileqq.weather.data.b) {
            com.tencent.mobileqq.weather.util.report.c.f313670a.c(((com.tencent.mobileqq.weather.data.b) data).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(h this$0, com.tencent.mobileqq.weather.data.k kVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(kVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(h this$0, com.tencent.mobileqq.weather.data.k kVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(kVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(h this$0, com.tencent.mobileqq.weather.data.k kVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(kVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherBannerTitleShowEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1190775v};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
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
            View findViewById = containerView.findViewById(R.id.f120917_u);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.weather_card_title_container)");
            this.mContainer = (RelativeLayout) findViewById;
            View findViewById2 = containerView.findViewById(R.id.f120937_w);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.weather_card_title_name)");
            this.mTitleName = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f120927_v);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.weather_card_title_desc)");
            this.mTitleDesc = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f120907_t);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.weather_card_title_arrow)");
            this.mTitleArrow = (ImageView) findViewById4;
        }
        t();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        if (event instanceof WeatherBannerTitleShowEvent) {
            int titleType = ((WeatherBannerTitleShowEvent) event).getTitleType();
            int i3 = this.mTitleType;
            if (titleType == i3 && i3 == 2) {
                this.mIsBannerNameShow = true;
                RelativeLayout relativeLayout = this.mContainer;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                QLog.d("WeatherCardTitleSection", 1, "recv event: WeatherBannerTitleShowEvent");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        int i3;
        int i16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        float f16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null) {
            i3 = data.a();
        } else {
            i3 = 0;
        }
        this.mPagePos = i3;
        ImageView imageView = null;
        if (data instanceof com.tencent.mobileqq.weather.data.i) {
            TextView textView = this.mTitleName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView = null;
            }
            com.tencent.mobileqq.weather.data.i iVar = (com.tencent.mobileqq.weather.data.i) data;
            textView.setText(iVar.h());
            TextView textView2 = this.mTitleDesc;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView2 = null;
            }
            textView2.setText(iVar.i());
            this.mJumpUrl = "https://e.weather.com.cn/";
            TextView textView3 = this.mTitleName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView3 = null;
            }
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.x(h.this, data, view);
                }
            });
        } else if (data instanceof com.tencent.mobileqq.weather.data.g) {
            TextView textView4 = this.mTitleName;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView4 = null;
            }
            com.tencent.mobileqq.weather.data.g gVar = (com.tencent.mobileqq.weather.data.g) data;
            textView4.setText(gVar.j());
            TextView textView5 = this.mTitleDesc;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView5 = null;
            }
            textView5.setText(gVar.k());
            TextView textView6 = this.mTitleDesc;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView6 = null;
            }
            textView6.setVisibility(0);
            ImageView imageView2 = this.mTitleArrow;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            this.mJumpUrl = "https://qq.weather.com.cn/mweather15d/";
            TextView textView7 = this.mTitleName;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView7 = null;
            }
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.y(h.this, data, view);
                }
            });
            this.mHasWeatherChangeTip = TextUtils.equals(gVar.j(), "7\u5929\u9884\u62a5");
        } else if (data instanceof com.tencent.mobileqq.weather.data.l) {
            TextView textView8 = this.mTitleName;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView8 = null;
            }
            textView8.setText("\u6bcf\u65e5\u7bb4\u8a00");
            TextView textView9 = this.mTitleDesc;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView9 = null;
            }
            textView9.setText("\u4e00\u8a00");
            TextView textView10 = this.mTitleDesc;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView10 = null;
            }
            textView10.setVisibility(0);
            ImageView imageView3 = this.mTitleArrow;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            com.tencent.mobileqq.weather.data.l lVar = (com.tencent.mobileqq.weather.data.l) data;
            if (lVar.e().size() > 0) {
                this.mJumpUrl = lVar.e().get(0).e();
                this.mIsMiniApp = true;
            }
        } else if (data instanceof com.tencent.mobileqq.weather.data.e) {
            TextView textView11 = this.mTitleName;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView11 = null;
            }
            textView11.setText("\u661f\u5ea7\u8fd0\u52bf");
            TextView textView12 = this.mTitleDesc;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView12 = null;
            }
            textView12.setText("\u67e5\u770b\u8be6\u60c5");
            TextView textView13 = this.mTitleDesc;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView13 = null;
            }
            textView13.setVisibility(0);
            ImageView imageView4 = this.mTitleArrow;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            this.mJumpUrl = "https://m.q.qq.com/a/p/1108937847?s=pages/day_fortune?e=2";
            this.mIsMiniApp = true;
        } else if (data instanceof com.tencent.mobileqq.weather.data.b) {
            TextView textView14 = this.mTitleName;
            if (textView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView14 = null;
            }
            textView14.setText("\u9ec4\u5386\u4e0e\u6307\u6570");
            TextView textView15 = this.mTitleDesc;
            if (textView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView15 = null;
            }
            textView15.setText("\u66f4\u591a\u9ec4\u5386");
            TextView textView16 = this.mTitleDesc;
            if (textView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView16 = null;
            }
            textView16.setVisibility(0);
            ImageView imageView5 = this.mTitleArrow;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
                imageView5 = null;
            }
            imageView5.setVisibility(0);
            this.mJumpUrl = "https://m.q.qq.com/a/p/1110695537?via=2014_52";
            this.mIsMiniApp = true;
        } else if (data instanceof com.tencent.mobileqq.weather.data.p) {
            com.tencent.mobileqq.weather.data.p pVar = (com.tencent.mobileqq.weather.data.p) data;
            this.mTitleType = pVar.f();
            TextView textView17 = this.mTitleName;
            if (textView17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView17 = null;
            }
            textView17.setText(pVar.e());
            TextView textView18 = this.mTitleDesc;
            if (textView18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
                textView18 = null;
            }
            textView18.setVisibility(8);
            ImageView imageView6 = this.mTitleArrow;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
                imageView6 = null;
            }
            imageView6.setVisibility(8);
            RelativeLayout relativeLayout = this.mContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout = null;
            }
            if (this.mTitleType == 2 && (this.mPagePos != 0 || !this.mIsBannerNameShow)) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            relativeLayout.setVisibility(i16);
            TextView textView19 = this.mTitleName;
            if (textView19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleName");
                textView19 = null;
            }
            if (this.mTitleType == 1 && com.tencent.mobileqq.weather.util.g.f313646a.J()) {
                i18 = 8;
            }
            textView19.setVisibility(i18);
            RelativeLayout relativeLayout2 = this.mContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout2 = null;
            }
            RelativeLayout relativeLayout3 = this.mContainer;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout3 = null;
            }
            ViewGroup.LayoutParams layoutParams = relativeLayout3.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = relativeLayout3.getLayoutParams();
                int i19 = -2;
                if (layoutParams2 != null) {
                    i17 = layoutParams2.width;
                } else {
                    i17 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = relativeLayout3.getLayoutParams();
                if (layoutParams3 != null) {
                    i19 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, i19);
            }
            if (this.mTitleType == 1) {
                f16 = 8.0f;
            } else {
                f16 = 0.0f;
            }
            marginLayoutParams.topMargin = ViewUtils.dip2px(f16);
            relativeLayout2.setLayoutParams(marginLayoutParams);
        }
        TextView textView20 = this.mTitleDesc;
        if (textView20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleDesc");
            textView20 = null;
        }
        textView20.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.z(h.this, data, view);
            }
        });
        ImageView imageView7 = this.mTitleArrow;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleArrow");
        } else {
            imageView = imageView7;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.A(h.this, data, view);
            }
        });
    }
}
