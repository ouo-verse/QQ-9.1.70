package com.tencent.mobileqq.guild.feed.squarehead.gamedistribute;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.distribute.api.IQQGuildDistributeApi;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeExtraInfo;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import ij1.GuildFeedsHeaderData;
import ij1.GuildGameDistributeAdData;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import okhttp3.internal.Util;
import okio.internal._Utf8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002)-\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\"\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R#\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lij1/d;", "headerData", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeExtraInfo;", "extraInfo", "", "N9", "Lorg/json/JSONObject;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "e", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "distributeButton", "f", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeExtraInfo;", h.F, "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/guild/theme/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/theme/d;", "themeChangeCallback", "com/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart$b;", "attachStateChangeListener", "com/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart$c", "D", "Lcom/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart$c;", "layoutListener", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GameDistributeAdPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b attachStateChangeListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c layoutListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IDistributeButton distributeButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameDistributeExtraInfo extraInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UIStateData<GuildFeedsHeaderData> uiStateData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.theme.d themeChangeCallback;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            QLog.i("GameDistributeAdPart", 1, "[onViewAttachedToWindow] registered layoutListener");
            GameDistributeAdPart.this.getPartRootView().getViewTreeObserver().addOnGlobalLayoutListener(GameDistributeAdPart.this.layoutListener);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            GameDistributeAdPart.this.getPartRootView().getViewTreeObserver().removeOnGlobalLayoutListener(GameDistributeAdPart.this.layoutListener);
            QLog.i("GameDistributeAdPart", 1, "[onViewDetachedFromWindow] unregistered layoutListener");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/squarehead/gamedistribute/GameDistributeAdPart$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            int coerceAtLeast;
            Object obj = GameDistributeAdPart.this.distributeButton;
            FrameLayout frameLayout = null;
            if (obj instanceof View) {
                view = (View) obj;
            } else {
                view = null;
            }
            if (view == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int dpToPx = ViewUtils.dpToPx(76.0f);
            FrameLayout frameLayout2 = GameDistributeAdPart.this.container;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                frameLayout2 = null;
            }
            int measuredWidth = frameLayout2.getMeasuredWidth();
            FrameLayout frameLayout3 = GameDistributeAdPart.this.container;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                frameLayout3 = null;
            }
            int paddingLeft = measuredWidth - frameLayout3.getPaddingLeft();
            FrameLayout frameLayout4 = GameDistributeAdPart.this.container;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            } else {
                frameLayout = frameLayout4;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(paddingLeft - frameLayout.getPaddingRight(), 0);
            if (layoutParams == null) {
                QLog.i("GameDistributeAdPart", 1, "[onGlobalLayout] new width = " + coerceAtLeast + ", old width = null");
                view.setLayoutParams(new ViewGroup.LayoutParams(coerceAtLeast, dpToPx));
                return;
            }
            int i3 = layoutParams.width;
            if (i3 != coerceAtLeast) {
                QLog.i("GameDistributeAdPart", 1, "[onGlobalLayout] new width = " + coerceAtLeast + ", old width = " + i3);
                layoutParams.width = coerceAtLeast;
                layoutParams.height = dpToPx;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public GameDistributeAdPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.GameDistributeAdPart$guildId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ax.o(GameDistributeAdPart.this.getHostFragment()).getGuildId();
            }
        });
        this.guildId = lazy;
        this.themeChangeCallback = new com.tencent.mobileqq.guild.theme.d() { // from class: com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.c
            @Override // com.tencent.mobileqq.guild.theme.d
            public final void onThemeChanged() {
                GameDistributeAdPart.M9(GameDistributeAdPart.this);
            }
        };
        this.attachStateChangeListener = new b();
        this.layoutListener = new c();
    }

    private final JSONObject I9() {
        Context context = getPartRootView().getContext();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sixFactorTextColor", Util.toHexString(context.getColor(R.color.qui_common_text_secondary_light)));
        jSONObject.put("gameNameTextColor", Util.toHexString(context.getColor(R.color.qui_common_text_primary)));
        jSONObject.put("waitSubscribeIconColor", Util.toHexString(context.getColor(R.color.qui_common_feedback_normal)));
        jSONObject.put("waitSubscribeTextColor", Util.toHexString(context.getColor(R.color.qui_common_feedback_normal)));
        jSONObject.put("subscribedIconColor", Util.toHexString(context.getColor(R.color.qui_common_icon_secondary)));
        jSONObject.put("subscribedTextColor", Util.toHexString(context.getColor(R.color.qui_common_icon_secondary)));
        jSONObject.put("downloadBtnBgColor", Util.toHexString(getPartRootView().getContext().getColor(R.color.qui_button_bg_secondary_default)));
        jSONObject.put("downloadBtnTextColor", Util.toHexString(getPartRootView().getContext().getColor(R.color.qui_button_text_secondary_default)));
        jSONObject.put("gameIcon", Util.toHexString(context.getColor(R.color.qui_common_text_primary)));
        jSONObject.put("containerBorderColor", Util.toHexString(context.getColor(R.color.qui_common_border_standard)));
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("backgroundColor", Util.toHexString(context.getColor(R.color.qui_button_bg_secondary_default)));
        jSONObject3.put("color", Util.toHexString(context.getColor(R.color.qui_button_text_secondary_default)));
        jSONObject3.put(NodeProps.BORDER_COLOR, Util.toHexString(context.getColor(R.color.ajr)));
        jSONObject3.put("ratioColor", Util.toHexString(context.getColor(R.color.qui_common_brand_light)));
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("default", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("backgroundColor", Util.toHexString(context.getColor(R.color.qui_button_bg_secondary_pressed)));
        jSONObject4.put("color", Util.toHexString(context.getColor(R.color.qui_button_text_secondary_pressed)));
        jSONObject4.put(NodeProps.BORDER_COLOR, Util.toHexString(context.getColor(R.color.ajr)));
        jSONObject4.put("ratioColor", Util.toHexString(context.getColor(R.color.qui_common_brand_light)));
        jSONObject2.put("pressed", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("backgroundColor", Util.toHexString(context.getColor(R.color.qui_button_bg_secondary_default)));
        jSONObject5.put("color", Util.toHexString(context.getColor(R.color.qui_button_text_secondary_default)));
        jSONObject5.put(NodeProps.BORDER_COLOR, Util.toHexString(context.getColor(R.color.ajr)));
        jSONObject5.put("ratioColor", Util.toHexString(context.getColor(R.color.qui_common_brand_light)));
        jSONObject2.put("progress", jSONObject5);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("backgroundColor", Util.toHexString(context.getColor(R.color.qui_button_bg_secondary_disable)));
        jSONObject6.put("color", Util.toHexString(context.getColor(R.color.qui_button_text_secondary_disable)));
        jSONObject6.put(NodeProps.BORDER_COLOR, Util.toHexString(context.getColor(R.color.ajr)));
        jSONObject6.put("ratioColor", Util.toHexString(context.getColor(R.color.qui_common_brand_light)));
        jSONObject2.put("disable", jSONObject6);
        jSONObject.put("downloadBtnTheme", jSONObject2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(final GameDistributeAdPart this$0, tj1.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> data = aVar.getData();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this$0);
        final Function1<UIStateData<GuildFeedsHeaderData>, Unit> function1 = new Function1<UIStateData<GuildFeedsHeaderData>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.GameDistributeAdPart$onInitView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<GuildFeedsHeaderData> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<GuildFeedsHeaderData> uIStateData) {
                GameDistributeExtraInfo gameDistributeExtraInfo;
                GameDistributeAdPart.this.uiStateData = uIStateData;
                GameDistributeAdPart gameDistributeAdPart = GameDistributeAdPart.this;
                gameDistributeExtraInfo = gameDistributeAdPart.extraInfo;
                gameDistributeAdPart.N9(uIStateData, gameDistributeExtraInfo);
            }
        };
        data.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GameDistributeAdPart.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(String str) {
        QLog.i("GameDistributeAdPart", 1, "getIoc fail [IFeedsHeaderDataSource] initialData is empty: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(GameDistributeAdPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GameDistributeAdPart", 1, "[themeChangeCallback] attempt to updateView(" + this$0.uiStateData + ", " + this$0.extraInfo + ")");
        this$0.N9(this$0.uiStateData, this$0.extraInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(UIStateData<GuildFeedsHeaderData> headerData, GameDistributeExtraInfo extraInfo) {
        View view;
        int i3;
        Object obj = this.distributeButton;
        if (obj == null) {
            QLog.i("GameDistributeAdPart", 1, "[updateView] skip, distributeView == null");
            return;
        }
        FrameLayout frameLayout = null;
        if (obj instanceof View) {
            view = (View) obj;
        } else {
            view = null;
        }
        if (headerData == null) {
            if (view != null) {
                view.setVisibility(8);
            }
            QLog.i("GameDistributeAdPart", 1, "[updateView] skip, headerData == null");
            return;
        }
        if (headerData.getData().getAdData() == null) {
            if (view != null) {
                view.setVisibility(8);
            }
            QLog.i("GameDistributeAdPart", 1, "[updateView] skip, adData == null");
        }
        GuildGameDistributeAdData adData = headerData.getData().getAdData();
        Intrinsics.checkNotNull(adData);
        IQQGuildDistributeApi iQQGuildDistributeApi = (IQQGuildDistributeApi) QRoute.api(IQQGuildDistributeApi.class);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton");
        String guildId = getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        com.tencent.gamecenter.wadl.distribute.data.a updateGuildDistributeView = iQQGuildDistributeApi.updateGuildDistributeView((IDistributeButton) view, new GameDistributeInfo(guildId, adData.getAdvInfo(), headerData.isCacheData(), I9(), null, 16, null), extraInfo);
        if (updateGuildDistributeView.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        QLog.i("GameDistributeAdPart", 1, "adData visibility: " + view.getVisibility() + ", isCache: " + headerData.isCacheData() + ", bufferSize: " + adData.getAdvInfo().length + ", decoded:" + _Utf8Kt.commonToUtf8String$default(adData.getAdvInfo(), 0, 0, 3, null) + ", extraInfo: " + extraInfo);
        if (updateGuildDistributeView.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
            FrameLayout frameLayout2 = this.container;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setVisibility(0);
        }
    }

    private final String getGuildId() {
        return (String) this.guildId.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Serializable serializable;
        GameDistributeExtraInfo gameDistributeExtraInfo;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (this.distributeButton != null) {
            QLog.i("GameDistributeAdPart", 1, "[onInitView] failed, remove history distributeButton");
            IDistributeButton iDistributeButton = this.distributeButton;
            if (iDistributeButton != null) {
                iDistributeButton.removeKuiklyView();
            }
        }
        IDistributeButton guildDistributeView = ((IQQGuildDistributeApi) QRoute.api(IQQGuildDistributeApi.class)).getGuildDistributeView(getContext());
        this.distributeButton = guildDistributeView;
        if (guildDistributeView == 0) {
            QLog.i("GameDistributeAdPart", 1, "[onInitView] failed, distributeButton is null");
            return;
        }
        Intrinsics.checkNotNull(guildDistributeView, "null cannot be cast to non-null type android.view.View");
        View findViewById = rootView.findViewById(R.id.wek);
        FrameLayout frameLayout = (FrameLayout) findViewById;
        frameLayout.addView((View) guildDistributeView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Fr\u2026distributeView)\n        }");
        this.container = frameLayout;
        Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(this);
        FrameLayout frameLayout2 = null;
        if (b16 != null) {
            serializable = b16.getSerializable(GameDistributeExtraInfo.EXTRA_KEY);
        } else {
            serializable = null;
        }
        if (serializable instanceof GameDistributeExtraInfo) {
            gameDistributeExtraInfo = (GameDistributeExtraInfo) serializable;
        } else {
            gameDistributeExtraInfo = null;
        }
        this.extraInfo = gameDistributeExtraInfo;
        QLog.i("GameDistributeAdPart", 1, "[onInitView] game extraInfo = " + gameDistributeExtraInfo);
        rootView.addOnAttachStateChangeListener(this.attachStateChangeListener);
        FrameLayout frameLayout3 = this.container;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setVisibility(8);
        GuildThemeManager.g(this.themeChangeCallback);
        RFWIocAbilityProvider.g().getIoc(tj1.a.class).originView(rootView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                GameDistributeAdPart.J9(GameDistributeAdPart.this, (tj1.a) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.b
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                GameDistributeAdPart.L9(str);
            }
        }).run();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        IDistributeButton iDistributeButton = this.distributeButton;
        if (iDistributeButton != null) {
            QLog.i("GameDistributeAdPart", 1, "[onPartDestroy] removeKuiklyView");
            iDistributeButton.removeKuiklyView();
        }
        GuildThemeManager.j(this.themeChangeCallback);
        getPartRootView().removeOnAttachStateChangeListener(this.attachStateChangeListener);
        QLog.i("GameDistributeAdPart", 1, "[onPartDestroy] remove attachStateChangeListener");
    }
}
