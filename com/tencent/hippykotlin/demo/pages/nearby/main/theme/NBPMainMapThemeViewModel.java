package com.tencent.hippykotlin.demo.pages.nearby.main.theme;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetMapThemeListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyMapThemeRepo$fetchMapThemeList$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import o25.f;
import v25.i;

/* loaded from: classes31.dex */
public final class NBPMainMapThemeViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "filterUrl", "getFilterUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeIcon", "getThemeIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeName", "getThemeName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeJoinText", "getThemeJoinText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "isCityTheme", "isCityTheme()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "personCount", "getPersonCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeGuideType", "getThemeGuideType()Lcom/tencent/hippykotlin/demo/pages/nearby/main/theme/NBPMainThemeGuideType;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeGuideLeftIcon", "getThemeGuideLeftIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeGuideText", "getThemeGuideText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeGuideRightIcon", "getThemeGuideRightIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "showThemeSwitchLoadingAnimationView", "getShowThemeSwitchLoadingAnimationView()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapThemeViewModel.class, "themeSwitchLoadingAnimationPlaying", "getThemeSwitchLoadingAnimationPlaying()Z", 0)};
    public CameraPosition curCameraPos;
    public boolean mapThemeConfigLoaded;
    public String reportThemeMapId;
    public int retryCount;
    public final ReadWriteProperty showThemeSwitchLoadingAnimationView$delegate;
    public String themeGuideTimeoutRef;
    public final ReadWriteProperty themeSwitchLoadingAnimationPlaying$delegate;
    public final List<f> mapThemes = new ArrayList();
    public final Map<String, NBPMainMapTheme> mapThemesCache = new LinkedHashMap();
    public String paramsThemeId = "";
    public String currentThemeId = "";
    public String paddingSelectedThemeId = "";
    public final ReadWriteProperty filterUrl$delegate = c.a("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/OP8jLoTI.png");
    public final ReadWriteProperty themeIcon$delegate = c.a("");
    public final ReadWriteProperty themeName$delegate = c.a("");
    public final ReadWriteProperty themeJoinText$delegate = c.a("");
    public final ReadWriteProperty isCityTheme$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty personCount$delegate = c.a(0);
    public final ReadWriteProperty themeGuideType$delegate = c.a(null);
    public final ReadWriteProperty themeGuideLeftIcon$delegate = c.a("");
    public final ReadWriteProperty themeGuideText$delegate = c.a("");
    public final ReadWriteProperty themeGuideRightIcon$delegate = c.a("");

    public NBPMainMapThemeViewModel() {
        Boolean bool = Boolean.FALSE;
        this.showThemeSwitchLoadingAnimationView$delegate = c.a(bool);
        this.themeSwitchLoadingAnimationPlaying$delegate = c.a(bool);
        this.reportThemeMapId = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void changeMapTheme(String str, boolean z16) {
        final f theme;
        String str2;
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPMainMapThemeViewModel", "change theme: " + str + " animated:" + z16);
        if (str.length() == 0) {
            theme = getCityTheme();
        } else {
            theme = getTheme(str);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str3 = "";
        objectRef.element = "";
        if (theme != null && theme.H) {
            objectRef.element = "";
        } else {
            objectRef.element = str;
        }
        boolean z17 = !Intrinsics.areEqual(this.currentThemeId, objectRef.element);
        this.currentThemeId = (String) objectRef.element;
        if (theme != null && (str2 = theme.f421849d) != null) {
            str3 = str2;
        }
        this.reportThemeMapId = str3;
        if (theme != null) {
            kLog.i("NBPMainMapThemeViewModel", "refreshMapTheme: " + str);
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$innerChangeMapTheme$refreshAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Removed duplicated region for block: B:20:0x00da  */
                /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
                @Override // kotlin.jvm.functions.Function0
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke() {
                    boolean z18;
                    Map<String, String> mutableMap;
                    Map<String, String> mutableMap2;
                    f cityTheme;
                    String removeSuffix;
                    NBPMainMapThemeViewModel nBPMainMapThemeViewModel = NBPMainMapThemeViewModel.this;
                    nBPMainMapThemeViewModel.refreshCurrentMapThemeData(theme);
                    boolean z19 = true;
                    if (!(nBPMainMapThemeViewModel.paramsThemeId.length() > 0) || (cityTheme = nBPMainMapThemeViewModel.getCityTheme()) == null) {
                        z18 = false;
                    } else {
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u56de\u5230");
                        removeSuffix = StringsKt__StringsKt.removeSuffix(UserDataManager.INSTANCE.getUserSelfInfo().locationCity, (CharSequence) "\u5e02");
                        m3.append(removeSuffix);
                        m3.append(AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION);
                        nBPMainMapThemeViewModel.setThemeGuideText(m3.toString());
                        nBPMainMapThemeViewModel.setThemeGuideLeftIcon(cityTheme.f421851f);
                        nBPMainMapThemeViewModel.setThemeGuideRightIcon();
                        nBPMainMapThemeViewModel.setThemeGuideType(NBPMainThemeGuideType.BACK_CITY_THEME);
                        nBPMainMapThemeViewModel.paramsThemeId = "";
                        nBPMainMapThemeViewModel.startHideGuideTimeout();
                        z18 = true;
                    }
                    if (!z18) {
                        NBPMainMapTheme orCreateNBPMainMapTheme = nBPMainMapThemeViewModel.getOrCreateNBPMainMapTheme(nBPMainMapThemeViewModel.currentThemeId);
                        NBPThemeAttachConfig nBPThemeAttachConfig = orCreateNBPMainMapTheme != null ? orCreateNBPMainMapTheme.attachConfig : null;
                        NBPThemeGuideConfig nBPThemeGuideConfig = nBPThemeAttachConfig != null ? nBPThemeAttachConfig.recommendGuide : null;
                        if (nBPThemeGuideConfig != null) {
                            mutableMap2 = MapsKt__MapsKt.toMutableMap(nBPMainMapThemeViewModel.loadGuideShownCache("nbp_theme_recommend_guide_shown_list"));
                            if (!Intrinsics.areEqual(mutableMap2.get(nBPMainMapThemeViewModel.currentThemeId), nBPThemeGuideConfig.key)) {
                                mutableMap2.put(nBPMainMapThemeViewModel.currentThemeId, nBPThemeGuideConfig.key);
                                nBPMainMapThemeViewModel.updateGuideShownCache("nbp_theme_recommend_guide_shown_list", mutableMap2);
                                nBPMainMapThemeViewModel.setThemeGuideText(nBPThemeGuideConfig.text);
                                nBPMainMapThemeViewModel.setThemeGuideLeftIcon(nBPThemeGuideConfig.icon);
                                nBPMainMapThemeViewModel.setThemeGuideRightIcon();
                                nBPMainMapThemeViewModel.setThemeGuideType(NBPMainThemeGuideType.THEME_RECOMMEND);
                                nBPMainMapThemeViewModel.startHideGuideTimeout();
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4e3b\u9898\u63a8\u8350\u5f15\u5bfc: show from=");
                                m16.append(nBPMainMapThemeViewModel.currentThemeId);
                                m16.append(" to=");
                                m16.append(nBPThemeGuideConfig.themeId);
                                m16.append(" key=");
                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, nBPThemeGuideConfig.key, kLog2, "NBPMainMapThemeViewModel");
                                if (!z19) {
                                    NBPThemeGuideConfig nBPThemeGuideConfig2 = nBPThemeAttachConfig != null ? nBPThemeAttachConfig.publishGuide : null;
                                    if (nBPThemeGuideConfig2 != null) {
                                        mutableMap = MapsKt__MapsKt.toMutableMap(nBPMainMapThemeViewModel.loadGuideShownCache("nbp_theme_publish_guide_shown_list"));
                                        if (!Intrinsics.areEqual(mutableMap.get(nBPMainMapThemeViewModel.currentThemeId), nBPThemeGuideConfig2.key)) {
                                            mutableMap.put(nBPMainMapThemeViewModel.currentThemeId, nBPThemeGuideConfig2.key);
                                            nBPMainMapThemeViewModel.updateGuideShownCache("nbp_theme_publish_guide_shown_list", mutableMap);
                                            nBPMainMapThemeViewModel.setThemeGuideText(nBPThemeGuideConfig2.text);
                                            nBPMainMapThemeViewModel.setThemeGuideLeftIcon(nBPThemeGuideConfig2.icon);
                                            nBPMainMapThemeViewModel.setThemeGuideRightIcon();
                                            nBPMainMapThemeViewModel.setThemeGuideType(NBPMainThemeGuideType.GO_TO_PUBLISH);
                                            nBPMainMapThemeViewModel.startHideGuideTimeout();
                                            KLog kLog3 = KLog.INSTANCE;
                                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u53d1\u8868\u5f15\u5bfc: show from=");
                                            m17.append(nBPMainMapThemeViewModel.currentThemeId);
                                            m17.append(" to=");
                                            m17.append(nBPThemeGuideConfig2.themeId);
                                            m17.append(" key=");
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, nBPThemeGuideConfig2.key, kLog3, "NBPMainMapThemeViewModel");
                                        }
                                    }
                                }
                            }
                        }
                        z19 = false;
                        if (!z19) {
                        }
                    }
                    NBPViewModelStore vmStore = NBPMainKtxKt.getVmStore();
                    f fVar = theme;
                    Iterator it = vmStore.viewModels.values().iterator();
                    while (it.hasNext()) {
                        ((NBPMainBaseViewModel) it.next()).onMapThemeChanged(fVar);
                    }
                    return Unit.INSTANCE;
                }
            };
            if (z16 && z17) {
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("willStartSwitchThemeForAnimation curTheme:"), this.currentThemeId, kLog, "ThemeLoadingAnimation");
                if (((Boolean) this.showThemeSwitchLoadingAnimationView$delegate.getValue(this, $$delegatedProperties[10])).booleanValue()) {
                    setShowThemeSwitchLoadingAnimationView(false);
                }
                setThemeSwitchLoadingAnimationPlaying(false);
                setShowThemeSwitchLoadingAnimationView(true);
                TimerKt.d(250, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$innerChangeMapTheme$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (Intrinsics.areEqual(objectRef.element, this.currentThemeId)) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            function0.invoke();
            return;
        }
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("can not find map theme, ", str, kLog, "NBPMainMapThemeViewModel");
    }

    public final void fetchMapThemes(final Function0<Unit> function0) {
        this.retryCount++;
        Function2<Boolean, i, Unit> function2 = new Function2<Boolean, i, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$fetchMapThemes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r4v11, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapTheme>] */
            /* JADX WARN: Type inference failed for: r4v13, types: [java.util.List<o25.f>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r4v16, types: [java.util.List<o25.f>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r4v21, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
            /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List<o25.f>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, i iVar) {
                i iVar2 = iVar;
                if (bool.booleanValue()) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("currentId: ");
                    m3.append(NBPMainMapThemeViewModel.this.currentThemeId);
                    m3.append(", paramsId: ");
                    m3.append(NBPMainMapThemeViewModel.this.paramsThemeId);
                    m3.append(", paddingId: ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, NBPMainMapThemeViewModel.this.paddingSelectedThemeId, kLog, "NBPMainMapThemeViewModel");
                    NBPMainMapThemeViewModel.this.mapThemes.clear();
                    NBPMainMapThemeViewModel.this.mapThemesCache.clear();
                    NBPMainMapThemeViewModel.this.mapThemes.addAll(iVar2.f440858e);
                    function0.invoke();
                    Iterator it = NBPMainMapThemeViewModel.this.mapThemes.iterator();
                    while (it.hasNext()) {
                        NBPThemeAttachConfig.Companion.parseJsonStr(((f) it.next()).L);
                    }
                    if (!NBPMainMapThemeViewModel.this.mapThemeConfigLoaded) {
                        Iterator it5 = NBPMainKtxKt.getVmStore().viewModels.values().iterator();
                        while (it5.hasNext()) {
                            ((NBPMainBaseViewModel) it5.next()).onMapThemesLoaded();
                        }
                        NBPMainMapThemeViewModel.this.mapThemeConfigLoaded = true;
                    }
                } else {
                    final NBPMainMapThemeViewModel nBPMainMapThemeViewModel = NBPMainMapThemeViewModel.this;
                    if (nBPMainMapThemeViewModel.retryCount <= 3) {
                        final Function0<Unit> function02 = function0;
                        TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$fetchMapThemes$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPMainMapThemeViewModel nBPMainMapThemeViewModel2 = NBPMainMapThemeViewModel.this;
                                Function0<Unit> function03 = function02;
                                KProperty<Object>[] kPropertyArr = NBPMainMapThemeViewModel.$$delegatedProperties;
                                nBPMainMapThemeViewModel2.fetchMapThemes(function03);
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        nBPMainMapThemeViewModel.retryCount = 0;
                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch themes error rearch: "), NBPMainMapThemeViewModel.this.retryCount, KLog.INSTANCE, "NBPMainMapThemeViewModel");
                    }
                }
                return Unit.INSTANCE;
            }
        };
        KLog.INSTANCE.i("NearbyMapThemeRepo", "start fetch map themes");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        NearbyProUtilsKt.getCachedMapThemeList();
        GetMapThemeListRequest getMapThemeListRequest = new GetMapThemeListRequest(true);
        NearbyMapThemeRepo$fetchMapThemeList$1 nearbyMapThemeRepo$fetchMapThemeList$1 = new NearbyMapThemeRepo$fetchMapThemeList$1(booleanRef, function2);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetMapThemeList");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getMapThemeListRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nearbyMapThemeRepo$fetchMapThemeList$1), 6);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<o25.f>, java.util.ArrayList] */
    public final f getCityTheme() {
        Object obj;
        Iterator it = this.mapThemes.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((f) obj).H) {
                break;
            }
        }
        return (f) obj;
    }

    public final f getCurrentMapTheme() {
        if (isCityTheme(this.currentThemeId)) {
            return getCityTheme();
        }
        return getTheme(this.currentThemeId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapTheme>] */
    public final NBPMainMapTheme getOrCreateNBPMainMapTheme(String str) {
        f theme;
        String sb5;
        NBPMainMapTheme nBPMainMapTheme = (NBPMainMapTheme) this.mapThemesCache.get(str);
        if (nBPMainMapTheme != null) {
            return nBPMainMapTheme;
        }
        if (str.length() == 0) {
            theme = getCityTheme();
        } else {
            theme = getTheme(str);
        }
        if (theme == null) {
            return nBPMainMapTheme;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("createNBPMainMapTheme: ");
        if (theme.H) {
            sb5 = "is city theme, hide id info";
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("id=");
            m16.append(theme.f421849d);
            sb5 = m16.toString();
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, sb5, kLog, "NBPMainMapThemeViewModel");
        NBPMainMapTheme nBPMainMapTheme2 = new NBPMainMapTheme(NBPThemeAttachConfig.Companion.parseJsonStr(theme.L));
        this.mapThemesCache.put(str, nBPMainMapTheme2);
        return nBPMainMapTheme2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<o25.f>, java.util.ArrayList] */
    public final f getTheme(String str) {
        Object obj;
        Iterator it = this.mapThemes.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((f) obj).f421849d, str)) {
                break;
            }
        }
        return (f) obj;
    }

    public final String getThemeGuideText() {
        return (String) this.themeGuideText$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final NBPMainThemeGuideType getThemeGuideType() {
        return (NBPMainThemeGuideType) this.themeGuideType$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final int getThemeMapType() {
        f theme = getTheme(this.reportThemeMapId);
        return (theme == null || theme.H) ? 0 : 1;
    }

    public final boolean getThemeSwitchLoadingAnimationPlaying() {
        return ((Boolean) this.themeSwitchLoadingAnimationPlaying$delegate.getValue(this, $$delegatedProperties[11])).booleanValue();
    }

    public final boolean isCityTheme() {
        return ((Boolean) this.isCityTheme$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List<o25.f>, java.util.ArrayList] */
    public final Map<String, String> loadGuideShownCache(String str) {
        String str2;
        e object = Utils.INSTANCE.cacheModule("").getObject(str);
        if (object == null) {
            object = new e();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = this.mapThemes.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.H) {
                str2 = "";
            } else {
                str2 = fVar.f421849d;
            }
            String p16 = object.p(str2);
            if (p16.length() > 0) {
                linkedHashMap.put(str2, p16);
            }
        }
        KLog.INSTANCE.d("NBPMainMapThemeViewModel", "loadGuideShownCache: cache=" + str + " data=" + linkedHashMap);
        return linkedHashMap;
    }

    public final boolean onBackPress() {
        f currentMapTheme = getCurrentMapTheme();
        if (currentMapTheme == null) {
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("current theme not find: "), this.currentThemeId, KLog.INSTANCE, "NBPMainMapThemeViewModel");
            return false;
        }
        if (currentMapTheme.H) {
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("current theme is city theme: "), this.currentThemeId, KLog.INSTANCE, "NBPMainMapThemeViewModel");
            return false;
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("change to city theme: "), this.currentThemeId, KLog.INSTANCE, "NBPMainMapThemeViewModel");
        changeMapTheme("", false);
        this.reportThemeMapId = currentMapTheme.f421849d;
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("map theme: ");
        m3.append(NBPMainKtxKt.getVmStore().loginSuccess);
        m3.append(", ");
        m3.append(z16);
        kLog.i("NBPMainMapThemeViewModel", m3.toString());
        if (NBPMainKtxKt.getVmStore().loginSuccess && z16) {
            fetchMapThemes(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$onLocationFinish$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch map theme on location finish: ");
                    m16.append(NBPMainMapThemeViewModel.this.paramsThemeId);
                    m16.append(", ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, NBPMainMapThemeViewModel.this.paddingSelectedThemeId, kLog2, "NBPMainMapThemeViewModel");
                    if (NBPMainMapThemeViewModel.this.paddingSelectedThemeId.length() == 0) {
                        NBPMainMapThemeViewModel nBPMainMapThemeViewModel = NBPMainMapThemeViewModel.this;
                        nBPMainMapThemeViewModel.changeMapTheme(nBPMainMapThemeViewModel.paramsThemeId, false);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChangedFinish(CameraPosition cameraPosition) {
        this.curCameraPos = cameraPosition;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
        this.paramsThemeId = NBPMainKtxKt.getPageData().n().p("theme_id");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("param theme id: "), this.paramsThemeId, KLog.INSTANCE, "NBPMainMapThemeViewModel");
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
        String str = this.themeGuideTimeoutRef;
        if (str != null) {
            TimerKt.b(str);
        }
        this.themeGuideTimeoutRef = null;
    }

    public final void refreshCurrentMapThemeData(f fVar) {
        String str = fVar.F;
        if (str.length() == 0) {
            str = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/OP8jLoTI.png";
        }
        ReadWriteProperty readWriteProperty = this.filterUrl$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], str);
        this.themeIcon$delegate.setValue(this, kPropertyArr[1], fVar.f421851f);
        this.themeName$delegate.setValue(this, kPropertyArr[2], fVar.f421850e);
        this.themeJoinText$delegate.setValue(this, kPropertyArr[3], fVar.f421852h);
        this.isCityTheme$delegate.setValue(this, kPropertyArr[4], Boolean.valueOf(fVar.H));
        this.personCount$delegate.setValue(this, kPropertyArr[5], Integer.valueOf(fVar.I));
    }

    public final void reportThemeGuideClick(String str, int i3) {
        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
        jsonWithMainPgParams.v("dt_eid", "em_nearby_guide_bubble");
        jsonWithMainPgParams.v("nearby_bubble_id", str);
        jsonWithMainPgParams.t("nearby_bubble_type", i3);
        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
    }

    public final void setShowThemeSwitchLoadingAnimationView(boolean z16) {
        this.showThemeSwitchLoadingAnimationView$delegate.setValue(this, $$delegatedProperties[10], Boolean.valueOf(z16));
    }

    public final void setThemeGuideLeftIcon(String str) {
        this.themeGuideLeftIcon$delegate.setValue(this, $$delegatedProperties[7], str);
    }

    public final void setThemeGuideRightIcon() {
        this.themeGuideRightIcon$delegate.setValue(this, $$delegatedProperties[9], "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_cgbN245e4Ni.png");
    }

    public final void setThemeGuideText(String str) {
        this.themeGuideText$delegate.setValue(this, $$delegatedProperties[8], str);
    }

    public final void setThemeGuideType(NBPMainThemeGuideType nBPMainThemeGuideType) {
        this.themeGuideType$delegate.setValue(this, $$delegatedProperties[6], nBPMainThemeGuideType);
    }

    public final void setThemeSwitchLoadingAnimationPlaying(boolean z16) {
        this.themeSwitchLoadingAnimationPlaying$delegate.setValue(this, $$delegatedProperties[11], Boolean.valueOf(z16));
    }

    public final void startHideGuideTimeout() {
        this.themeGuideTimeoutRef = TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$startHideGuideTimeout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPMainMapThemeViewModel.this.setThemeGuideType(null);
                return Unit.INSTANCE;
            }
        });
    }

    public final void themeSwitchLoadingAnimationEndPlay() {
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("themeSwitchLoadingAnimationEndPlay curTheme:"), this.currentThemeId, KLog.INSTANCE, "ThemeLoadingAnimation");
        setShowThemeSwitchLoadingAnimationView(false);
        setThemeSwitchLoadingAnimationPlaying(false);
    }

    public final void updateGuideShownCache(String str, Map<String, String> map) {
        e eVar = new e();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            eVar.v(entry.getKey(), entry.getValue());
        }
        KLog.INSTANCE.d("NBPMainMapThemeViewModel", "updateGuideShownCache: cache=" + str + " data=" + eVar);
        Utils.INSTANCE.cacheModule("").setObject(str, eVar);
    }

    public final boolean isCityTheme(String str) {
        return str.length() == 0;
    }
}
