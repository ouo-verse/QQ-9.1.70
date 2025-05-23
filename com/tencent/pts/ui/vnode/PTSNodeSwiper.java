package com.tencent.pts.ui.vnode;

import android.arch.core.util.Function;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.RelativeLayout;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperDotIndicator;
import com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class PTSNodeSwiper extends PTSNodeVirtual {
    static IPatchRedirector $redirector_;
    private final String ATTRIBUTE_AUTOPLAY;
    private final String ATTRIBUTE_CIRCULAR;
    private final String ATTRIBUTE_CURRENT;
    private final String ATTRIBUTE_DURATION;
    private final String ATTRIBUTE_INDICATOR_ACTIVE_COLOR;
    private final String ATTRIBUTE_INDICATOR_COLOR;
    private final String ATTRIBUTE_INDICATOR_DOTS;
    private final String ATTRIBUTE_INTERVAL;
    private boolean autoPlay;
    private int autoPlayDuration;
    private int autoPlayInterval;
    private boolean circular;
    private Map<String, Function<Object, Boolean>> functionMap;
    private int indicatorFocusedColor;
    private float indicatorGap;
    private float indicatorHeight;
    private float indicatorMarginBottom;
    private float indicatorMarginRight;
    private int indicatorNormalColor;
    private float indicatorRadius;
    private int indicatorRuleHorizontal;
    private int indicatorRuleVertical;
    private String indicatorStyle;
    private float indicatorWidth;
    private boolean showIndicatorDots;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorGap = PTSValueConvertUtil.getFloat(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorMarginBottom = PTSValueConvertUtil.getFloat(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorRadius = PTSValueConvertUtil.getFloat(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class d implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorMarginRight = PTSValueConvertUtil.getFloat(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class e implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorRuleHorizontal = PTSValueConvertUtil.getInt(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class f implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorRuleVertical = PTSValueConvertUtil.getInt(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class g implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            String string = PTSValueConvertUtil.getString(obj);
            if (string.equalsIgnoreCase("dot") || string.equalsIgnoreCase("text")) {
                PTSNodeSwiper.this.indicatorStyle = PTSValueConvertUtil.getString(obj);
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class h implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.showIndicatorDots = PTSValueConvertUtil.getBoolean(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class i implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorNormalColor = PTSValueConvertUtil.getColor(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class j implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorFocusedColor = PTSValueConvertUtil.getColor(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class k implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.autoPlay = PTSValueConvertUtil.getBoolean(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class l implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.autoPlayInterval = PTSValueConvertUtil.getInt(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class m implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.autoPlayDuration = PTSValueConvertUtil.getInt(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class n implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.circular = PTSValueConvertUtil.getBoolean(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class o implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorWidth = PTSValueConvertUtil.getFloat(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class p implements Function<Object, Boolean> {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeSwiper.this);
            }
        }

        @Override // android.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            PTSNodeSwiper.this.indicatorHeight = PTSValueConvertUtil.getFloat(obj);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes22.dex */
    public static class q implements PTSNodeVirtual.a {
        static IPatchRedirector $redirector_;

        public q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) pTSNodeVirtual);
            }
            return new PTSSwiperView((PTSNodeSwiper) pTSNodeVirtual);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PTSNodeVirtual) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
            }
            return new PTSNodeSwiper(pTSAppInstance);
        }
    }

    public PTSNodeSwiper(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, PTSConstant.VNT_SWIPER, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
            return;
        }
        this.ATTRIBUTE_INDICATOR_DOTS = "indicator-dots";
        this.ATTRIBUTE_INDICATOR_COLOR = "indicator-color";
        this.ATTRIBUTE_INDICATOR_ACTIVE_COLOR = "indicator-active-color";
        this.ATTRIBUTE_AUTOPLAY = "autoplay";
        this.ATTRIBUTE_CURRENT = "current";
        this.ATTRIBUTE_INTERVAL = WidgetCacheConstellationData.INTERVAL;
        this.ATTRIBUTE_DURATION = "duration";
        this.ATTRIBUTE_CIRCULAR = "circular";
        this.showIndicatorDots = false;
        this.indicatorNormalColor = CellDynamicAlbum.sBtnBackgroundColor;
        this.indicatorFocusedColor = -16777216;
        this.autoPlay = false;
        this.autoPlayInterval = 5000;
        this.autoPlayDuration = 500;
        this.circular = false;
        this.indicatorWidth = PTSDeviceUtil.dp2pxInt(16.0f);
        this.indicatorHeight = PTSDeviceUtil.dp2pxInt(3.0f);
        this.indicatorGap = PTSDeviceUtil.dp2pxInt(4.0f);
        this.indicatorMarginBottom = PTSDeviceUtil.dp2pxInt(12.0f);
        this.indicatorMarginRight = PTSDeviceUtil.dp2pxInt(2.5f);
        this.indicatorRadius = PTSDeviceUtil.dp2px(3.0f);
        this.indicatorRuleHorizontal = -1;
        this.indicatorRuleVertical = -1;
        this.indicatorStyle = "dot";
    }

    private void initFunctionMap() {
        HashMap hashMap = new HashMap();
        this.functionMap = hashMap;
        hashMap.put("indicator-dots".toLowerCase(), new h());
        this.functionMap.put("indicator-color".toLowerCase(), new i());
        this.functionMap.put("indicator-active-color".toLowerCase(), new j());
        this.functionMap.put("autoplay".toLowerCase(), new k());
        this.functionMap.put(WidgetCacheConstellationData.INTERVAL.toLowerCase(), new l());
        this.functionMap.put("duration".toLowerCase(), new m());
        this.functionMap.put("circular".toLowerCase(), new n());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_DOTS_WIDTH.toLowerCase(), new o());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_DOTS_HEIGHT.toLowerCase(), new p());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_DOTS_GAP.toLowerCase(), new a());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_BOTTOM.toLowerCase(), new b());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_DOTS_RADIUS.toLowerCase(), new c());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_RIGHT.toLowerCase(), new d());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_RULE_HORIZONTAL.toLowerCase(), new e());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_RULE_VERTICAL.toLowerCase(), new f());
        this.functionMap.put(PTSNodeAttributeConstant.ATTRIBUTE_PTS_INDICATOR_STYLE.toLowerCase(), new g());
    }

    private void setIndicatorStyle(com.tencent.pts.ui.view.PTSSwiperView.a aVar) {
        aVar.setIndicatorVisible(this.showIndicatorDots);
        RelativeLayout.LayoutParams b16 = aVar.b();
        if (this.indicatorStyle.equalsIgnoreCase("text")) {
            if (this.indicatorRuleHorizontal == -1) {
                this.indicatorRuleHorizontal = 11;
            }
            if (this.indicatorRuleVertical == -1) {
                this.indicatorRuleVertical = 12;
            }
            b16.addRule(this.indicatorRuleHorizontal);
            b16.addRule(this.indicatorRuleVertical);
            b16.setMargins(0, 0, 32, 32);
            aVar.setIndicatorLayoutParams(b16);
            return;
        }
        if (this.indicatorStyle.equalsIgnoreCase("dot")) {
            if (this.indicatorRuleHorizontal == -1) {
                this.indicatorRuleHorizontal = 14;
            }
            if (this.indicatorRuleVertical == -1) {
                this.indicatorRuleVertical = 12;
            }
            b16.addRule(this.indicatorRuleHorizontal);
            b16.addRule(this.indicatorRuleVertical);
            aVar.setIndicatorLayoutParams(b16);
            PTSSwiperDotIndicator pTSSwiperDotIndicator = (PTSSwiperDotIndicator) aVar;
            pTSSwiperDotIndicator.setIndicatorNormalColor(this.indicatorNormalColor);
            pTSSwiperDotIndicator.setIndicatorFocusedColor(this.indicatorFocusedColor);
            pTSSwiperDotIndicator.setIndicatorWidth(this.indicatorWidth);
            pTSSwiperDotIndicator.setIndicatorHeight(this.indicatorHeight);
            pTSSwiperDotIndicator.setIndicatorGap(this.indicatorGap);
            pTSSwiperDotIndicator.setIndicatorMargin(this.indicatorMarginRight, this.indicatorMarginBottom);
            pTSSwiperDotIndicator.setIndicatorRadius(this.indicatorRadius);
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    @RequiresApi(api = 17)
    public void onParseValueFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onParseValueFinished();
        PTSSwiperView pTSSwiperView = (PTSSwiperView) getView();
        pTSSwiperView.setAutoPlay(this.autoPlay);
        pTSSwiperView.setAutoPlayInterval(this.autoPlayInterval);
        pTSSwiperView.setAutoPlayDuration(this.autoPlayDuration);
        pTSSwiperView.setCircular(this.circular);
        pTSSwiperView.p(this.indicatorStyle);
        setIndicatorStyle(pTSSwiperView.q());
        pTSSwiperView.w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj)).booleanValue();
        }
        if (super.setAttribute(str, obj)) {
            return true;
        }
        if (this.functionMap == null) {
            initFunctionMap();
        }
        Function<Object, Boolean> function = this.functionMap.get(str.toLowerCase());
        if (function != null) {
            function.apply(obj);
            return false;
        }
        return false;
    }
}
