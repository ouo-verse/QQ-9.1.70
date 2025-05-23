package com.tencent.mobileqq.emosm.emocompat;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.emocompat.impl.GuildAioEmoticonPanelCallbackProcessor;
import com.tencent.mobileqq.emosm.emocompat.impl.a;
import com.tencent.mobileqq.emosm.p;
import com.tencent.mobileqq.emosm.q;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabContentBuilder;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabHelperBuilder;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabListener;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zq0.AioPanelParam;
import zq0.c;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0001@\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OB\u000f\u0012\u0006\u0010+\u001a\u00020&\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J2\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R#\u00101\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/emosm/emocompat/QQEmoticonPanelProvider;", "Lcom/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider;", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "panelBuilder", "", "w", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Lzq0/c;", "k", "", ReportConstant.COSTREPORT_PREFIX, "", "t", "Landroid/widget/EditText;", h.F, "u", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", HippyTKDListViewAdapter.X, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.VISIBLE, "bottom", "clearWord", "word", "width", "setEmotionSearchPanelVisible", "getEmoPanel", "Lzq0/b;", "i", "Lzq0/b;", "getAioPanelParam", "()Lzq0/b;", "aioPanelParam", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "p", "()Lmqq/app/AppRuntime;", "appRuntime", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsExperiment", "D", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "mainPanel", "Lcom/tencent/mobileqq/emosm/emocompat/impl/GuildAioEmoticonPanelCallbackProcessor;", "E", "Lcom/tencent/mobileqq/emosm/emocompat/impl/GuildAioEmoticonPanelCallbackProcessor;", "r", "()Lcom/tencent/mobileqq/emosm/emocompat/impl/GuildAioEmoticonPanelCallbackProcessor;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/mobileqq/emosm/emocompat/impl/GuildAioEmoticonPanelCallbackProcessor;)V", "emoCallbackGuildAio", "com/tencent/mobileqq/emosm/emocompat/QQEmoticonPanelProvider$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/emosm/emocompat/QQEmoticonPanelProvider$b;", "panelProxy", "Lcom/tencent/mobileqq/emosm/q;", "G", "Lcom/tencent/mobileqq/emosm/q;", "getMEmotionSearchPanel", "()Lcom/tencent/mobileqq/emosm/q;", "setMEmotionSearchPanel", "(Lcom/tencent/mobileqq/emosm/q;)V", "mEmotionSearchPanel", "<init>", "(Lzq0/b;)V", "H", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QQEmoticonPanelProvider extends BaseEmoticonPanelProvider implements IAIOEmoticonUIHelper {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsExperiment;

    /* renamed from: D, reason: from kotlin metadata */
    private IEmoticonMainPanel mainPanel;

    /* renamed from: E, reason: from kotlin metadata */
    public GuildAioEmoticonPanelCallbackProcessor emoCallbackGuildAio;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b panelProxy;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private q mEmotionSearchPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AioPanelParam aioPanelParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy appRuntime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQEmoticonPanelProvider(@NotNull AioPanelParam aioPanelParam) {
        super(aioPanelParam.getPanelParam());
        Lazy lazy;
        Intrinsics.checkNotNullParameter(aioPanelParam, "aioPanelParam");
        this.aioPanelParam = aioPanelParam;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.mobileqq.emosm.emocompat.QQEmoticonPanelProvider$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return MobileQQ.sMobileQQ.peekAppRuntime();
            }
        });
        this.appRuntime = lazy;
        this.panelProxy = new b();
    }

    private final EmoticonCallback m() {
        z(new GuildAioEmoticonPanelCallbackProcessor(g(), this));
        return r();
    }

    private final IEmoticonMainPanel n() {
        IEmoticonMainPanelService.PanelBuilder panelBuilder = ((IEmoticonMainPanelService) p().getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(g(), 10014).setCallBack(m()).setOnlySysAndEmoji(false).setDisableMoreEmotionButton(false).setDisableGuide(false).setPanelInteractionListener(new a(this)).setDefaultPanelType(-1).setGuildChatPieScene(s()).setTextGifOpen(t()).setToastOffset(u()).keepLottieMerged(y());
        Intrinsics.checkNotNullExpressionValue(panelBuilder, "panelBuilder");
        w(panelBuilder);
        if (this.mIsExperiment) {
            panelBuilder.setTopTab();
        }
        zq0.a styleSheet = this.aioPanelParam.getStyleSheet();
        if (styleSheet != null) {
            IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet panelContainerStyleSheet = new IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet();
            panelContainerStyleSheet.contentBg = styleSheet.getContentBg();
            panelContainerStyleSheet.tabContainerBg = styleSheet.getTabContainerBg();
            panelBuilder.setStyleSheet(panelContainerStyleSheet);
        }
        IEmoticonMainPanel create = panelBuilder.create();
        Intrinsics.checkNotNullExpressionValue(create, "panelBuilder.create()");
        return create;
    }

    private final AppRuntime p() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    private final void v() {
        if (!QQTheme.isNowSimpleUI()) {
            this.mIsExperiment = false;
        } else {
            this.mIsExperiment = true;
        }
    }

    private final void w(IEmoticonMainPanelService.PanelBuilder panelBuilder) {
        IEmoticonMainPanelApp emoticonMainPanelApp = panelBuilder.getEmoticonMainPanelApp();
        QRouteApi api = QRoute.api(IHotPicSearchTabContentBuilder.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IHotPicSearchTabContentBuilder::class.java)");
        IHotPicSearchTabContentBuilder iHotPicSearchTabContentBuilder = (IHotPicSearchTabContentBuilder) api;
        iHotPicSearchTabContentBuilder.init(emoticonMainPanelApp, 4, 20, 18, null);
        EmotionInjectionInfo emotionInjectionInfo = new EmotionInjectionInfo(18, 4, R.drawable.qui_search_selector_01, iHotPicSearchTabContentBuilder);
        emotionInjectionInfo.setEmotionPanelLifecycleObserver(((IHotPicSearchTabHelperBuilder) QRoute.api(IHotPicSearchTabHelperBuilder.class)).build(12));
        emotionInjectionInfo.setEmotionTabCreateListener(((IHotPicSearchTabListener) QRoute.api(IHotPicSearchTabListener.class)).build(emoticonMainPanelApp));
        panelBuilder.addEmotionInjectionInfo("search", emotionInjectionInfo);
    }

    @Override // com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper
    @NotNull
    public IEmoticonMainPanel getEmoPanel() {
        QLog.i("QQEmoticonPanelProvider", 4, "getEmoPanel");
        if (this.mainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            return null;
        }
        return iEmoticonMainPanel;
    }

    @Override // com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider
    @Nullable
    public EditText h() {
        View view = getPanelParam().a().c().getView();
        if (view != null) {
            return (EditText) view.findViewById(R.id.vxk);
        }
        return null;
    }

    @Override // com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider
    @NotNull
    public c k(@NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.mainPanel = n();
        GuildAioEmoticonPanelCallbackProcessor r16 = r();
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        IEmoticonMainPanel iEmoticonMainPanel2 = null;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            iEmoticonMainPanel = null;
        }
        r16.j(iEmoticonMainPanel);
        IHostEmoticonMainApi iHostEmoticonMainApi = (IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class);
        IEmoticonMainPanel iEmoticonMainPanel3 = this.mainPanel;
        if (iEmoticonMainPanel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
        } else {
            iEmoticonMainPanel2 = iEmoticonMainPanel3;
        }
        iHostEmoticonMainApi.onInit(iEmoticonMainPanel2);
        return this.panelProxy;
    }

    public final boolean o() {
        return ((IFeatureRuntimeService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("guild_lottie_8835");
    }

    @Override // com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider, com.tencent.aio.part.root.panel.mvx.config.b
    public void onDestroy() {
        super.onDestroy();
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            iEmoticonMainPanel = null;
        }
        iEmoticonMainPanel.onDestory();
        ((IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class)).onClear();
    }

    @Override // com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider
    public void onPause() {
        super.onPause();
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            iEmoticonMainPanel = null;
        }
        iEmoticonMainPanel.onPause();
    }

    @Override // com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider
    public void onResume() {
        QLog.i("QQEmoticonPanelProvider", 4, "onResume");
        super.onResume();
        v();
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        IEmoticonMainPanel iEmoticonMainPanel2 = null;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            iEmoticonMainPanel = null;
        }
        iEmoticonMainPanel.onResume();
        IEmoticonMainPanel iEmoticonMainPanel3 = this.mainPanel;
        if (iEmoticonMainPanel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
        } else {
            iEmoticonMainPanel2 = iEmoticonMainPanel3;
        }
        iEmoticonMainPanel2.updateFavEmoticonPanel();
    }

    @NotNull
    public final String q() {
        return com.tencent.guild.aio.util.a.b(getPanelParam().b());
    }

    @NotNull
    public final GuildAioEmoticonPanelCallbackProcessor r() {
        GuildAioEmoticonPanelCallbackProcessor guildAioEmoticonPanelCallbackProcessor = this.emoCallbackGuildAio;
        if (guildAioEmoticonPanelCallbackProcessor != null) {
            return guildAioEmoticonPanelCallbackProcessor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emoCallbackGuildAio");
        return null;
    }

    public int s() {
        return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transChannelType(getPanelParam().b().n());
    }

    @Override // com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper
    public void setEmotionSearchPanelVisible(boolean visible, int bottom, boolean clearWord, @Nullable String word, int width) {
        QLog.i("QQEmoticonPanelProvider", 4, "setEmotionSearchPanelVisible visible=" + visible + " bottom=" + bottom + " clearWord=" + clearWord + " word=" + word + " with=" + width);
        if (visible) {
            IEmoticonMainPanel iEmoticonMainPanel = null;
            if (this.mEmotionSearchPanel == null) {
                KeyEvent.Callback inflate = View.inflate(g(), R.layout.f167593dv1, null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.emosm.IEmotionSearchPanel");
                this.mEmotionSearchPanel = (q) inflate;
            }
            IEmoticonMainPanel iEmoticonMainPanel2 = this.mainPanel;
            if (iEmoticonMainPanel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                iEmoticonMainPanel2 = null;
            }
            Object helper = iEmoticonMainPanel2.getEmoController().getHelper(6);
            Intrinsics.checkNotNullExpressionValue(helper, "mainPanel.emoController.\u2026ICON_HELPER\n            )");
            p pVar = (p) helper;
            q qVar = this.mEmotionSearchPanel;
            if (qVar != null) {
                qVar.showEmotionSearchWindow();
            }
            int realHeight = (ScreenUtil.getRealHeight(g()) - bottom) - ImmersiveUtils.getStatusBarHeight(g());
            int i3 = 0;
            if (ThemeUtil.isNowThemeIsSimple(p(), false, null)) {
                Rect rect = new Rect();
                EditText h16 = h();
                if (h16 != null) {
                    h16.getGlobalVisibleRect(rect);
                }
                q qVar2 = this.mEmotionSearchPanel;
                if (qVar2 != null) {
                    AppRuntime p16 = p();
                    Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
                    BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) p16;
                    IEmoticonMainPanel iEmoticonMainPanel3 = this.mainPanel;
                    if (iEmoticonMainPanel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                    } else {
                        iEmoticonMainPanel = iEmoticonMainPanel3;
                    }
                    qVar2.init(baseQQAppInterface, iEmoticonMainPanel.getPanelInteractionListener(), realHeight, clearWord, word, bottom - rect.bottom, width, pVar);
                }
            } else {
                EditText h17 = h();
                if (h17 != null) {
                    i3 = h17.getHeight();
                }
                q qVar3 = this.mEmotionSearchPanel;
                if (qVar3 != null) {
                    AppRuntime p17 = p();
                    Intrinsics.checkNotNull(p17, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
                    BaseQQAppInterface baseQQAppInterface2 = (BaseQQAppInterface) p17;
                    IEmoticonMainPanel iEmoticonMainPanel4 = this.mainPanel;
                    if (iEmoticonMainPanel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                    } else {
                        iEmoticonMainPanel = iEmoticonMainPanel4;
                    }
                    qVar3.init(baseQQAppInterface2, iEmoticonMainPanel.getPanelInteractionListener(), realHeight, clearWord, word, i3, width, pVar);
                }
            }
            if (clearWord) {
                pVar.loadHotPicData();
                return;
            }
            return;
        }
        q qVar4 = this.mEmotionSearchPanel;
        if (qVar4 != null) {
            qVar4.onDestory();
        }
    }

    public boolean t() {
        return ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSafetySwitchOpen(com.tencent.guild.aio.util.a.g(getPanelParam().b()), 8);
    }

    public final int u() {
        return l.D(g()) + ImmersiveUtils.getStatusBarHeight(g());
    }

    public final boolean x() {
        if (s() == 2) {
            return true;
        }
        return false;
    }

    public final boolean y() {
        if (x() || !o()) {
            return true;
        }
        return false;
    }

    public final void z(@NotNull GuildAioEmoticonPanelCallbackProcessor guildAioEmoticonPanelCallbackProcessor) {
        Intrinsics.checkNotNullParameter(guildAioEmoticonPanelCallbackProcessor, "<set-?>");
        this.emoCallbackGuildAio = guildAioEmoticonPanelCallbackProcessor;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/emosm/emocompat/QQEmoticonPanelProvider$b", "Lzq0/c;", "", "onCreate", "Landroid/view/View;", "d", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements c {
        b() {
        }

        @Override // zq0.c
        public void a() {
            IEmoticonMainPanel iEmoticonMainPanel = QQEmoticonPanelProvider.this.mainPanel;
            if (iEmoticonMainPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                iEmoticonMainPanel = null;
            }
            iEmoticonMainPanel.updateFavEmoticonPanel();
        }

        @Override // zq0.c
        @NotNull
        public View d() {
            IEmoticonMainPanel iEmoticonMainPanel = QQEmoticonPanelProvider.this.mainPanel;
            if (iEmoticonMainPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                iEmoticonMainPanel = null;
            }
            RelativeLayout view = iEmoticonMainPanel.getView();
            Intrinsics.checkNotNullExpressionValue(view, "mainPanel.view");
            return view;
        }

        @Override // zq0.c
        public void onDestroy() {
            IEmoticonMainPanel iEmoticonMainPanel = QQEmoticonPanelProvider.this.mainPanel;
            if (iEmoticonMainPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                iEmoticonMainPanel = null;
            }
            iEmoticonMainPanel.onDestory();
        }

        @Override // zq0.c
        public void onCreate() {
        }
    }
}
