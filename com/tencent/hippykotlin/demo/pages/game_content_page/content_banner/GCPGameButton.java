package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GamePrivilegeInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.b;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class GCPGameButton extends ComposeView<GCPGameButtonAttr, GCPGameButtonEvent> {
    public aa<ButtonView> buttonRef;
    public final GCPGameButtonAttr viewAttr = new GCPGameButtonAttr();
    public static final Companion Companion = new Companion();
    public static final Map<String, String> gameButtonTextMap = new LinkedHashMap();
    public static final Map<String, Long> gameButtonTextColorMap = new LinkedHashMap();
    public static final Map<String, Long> gameButtonBackgroundColorMap = new LinkedHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameButtonAttr access$getAttr(GCPGameButton gCPGameButton) {
        return (GCPGameButtonAttr) gCPGameButton.getAttr();
    }

    public static final void access$onButtonClick(final GCPGameButton gCPGameButton) {
        String str;
        gCPGameButton.getClass();
        e eVar = new e();
        eVar.v("buttonClickFrom", "PARAMS_IS_FROM_NORMAL_BUTTON");
        Unit unit = Unit.INSTANCE;
        gCPGameButton.emit("buttonClick", eVar);
        Utils utils = Utils.INSTANCE;
        String pagerId = gCPGameButton.getPagerId();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(gCPGameButton.getLogTag());
        sb5.append(" onButtonClick btnStatus:");
        Companion companion = Companion;
        sb5.append(companion.buttonStatusToString(((GCPGameButtonAttr) gCPGameButton.getAttr()).getStatus()));
        sb5.append(" taskStatus:");
        sb5.append(companion.taskStatusToString(((GCPGameButtonAttr) gCPGameButton.getAttr()).getTaskStatus()));
        utils.bridgeModule(pagerId).log(sb5.toString());
        switch (((GCPGameButtonAttr) gCPGameButton.getAttr()).getStatus()) {
            case 2:
                if (gCPGameButton.getPager().getPageData().getIsIOS()) {
                    BridgeModule bridgeModule = utils.bridgeModule(gCPGameButton.getPagerId());
                    String gameId = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId();
                    String packName = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getPackName();
                    String appStoreUrl = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getAppStoreUrl();
                    bridgeModule.getClass();
                    e eVar2 = new e();
                    eVar2.v("appId", gameId);
                    eVar2.v("packageName", packName);
                    eVar2.v("appStoreUrl", appStoreUrl);
                    bridgeModule.callNativeMethod("openAppStoreWithGameInfo", eVar2, null);
                    utils.bridgeModule(gCPGameButton.getPagerId()).log(gCPGameButton.getLogTag() + " jump to appStroe appid:" + ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId() + ",packName:" + ((GCPGameButtonAttr) gCPGameButton.getAttr()).getPackName() + ",appStoreUrl:" + ((GCPGameButtonAttr) gCPGameButton.getAttr()).getAppStoreUrl());
                    return;
                }
                BridgeModule bridgeModule2 = utils.bridgeModule(gCPGameButton.getPagerId());
                String str2 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).detailUrl;
                if (str2 != null) {
                    str = str2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("detailUrl");
                    str = null;
                }
                BridgeModule.openPage$default(bridgeModule2, str, false, null, null, 30);
                return;
            case 3:
            case 4:
                BridgeModule currentBridgeModule = utils.currentBridgeModule();
                String gameId2 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId();
                String channelId = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getChannelId();
                GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) gCPGameButton.getAttr();
                String str3 = (String) gCPGameButtonAttr.adTag$delegate.getValue(gCPGameButtonAttr, GCPGameButtonAttr.$$delegatedProperties[13]);
                final Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton$onButtonClick$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar3) {
                        int i3;
                        String str4;
                        e eVar4 = eVar3;
                        Utils.INSTANCE.bridgeModule(GCPGameButton.this.getPagerId()).log(GCPGameButton.this.getLogTag() + " subscribeGame result data: " + eVar4 + TokenParser.SP);
                        if (GCPGameButton.access$getAttr(GCPGameButton.this).getFollowStatus() == 2) {
                            if (eVar4 != null) {
                                if (GCPGameButton.this.getPagerData().getIsIOS()) {
                                    str4 = "subscribeStatus";
                                } else {
                                    str4 = "followStatus";
                                }
                                i3 = eVar4.k(str4, 1);
                            } else {
                                i3 = 1;
                            }
                            if (i3 == 2) {
                                GCPGameButtonAttr access$getAttr = GCPGameButton.access$getAttr(GCPGameButton.this);
                                access$getAttr.followStatus$delegate.setValue(access$getAttr, GCPGameButtonAttr.$$delegatedProperties[8], 3);
                            }
                        }
                        GCPGameButton.this.onBtnStatusChanged(eVar4 != null ? eVar4.k("subscribeStatus", 1) : 1, GCPGameButton.access$getAttr(GCPGameButton.this).getFollowStatus(), true);
                        return Unit.INSTANCE;
                    }
                };
                currentBridgeModule.getClass();
                e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("appId", gameId2, "channelId", channelId);
                m3.v(QCircleDaTongConstant.ElementParamValue.OPERATION, "1");
                m3.v(VasWebviewConstants.KEY_ADTAG, str3);
                currentBridgeModule.callNativeMethod("subscribeGame", m3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$subscribeGame$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar3) {
                        function1.invoke(eVar3);
                        return Unit.INSTANCE;
                    }
                });
                return;
            case 5:
            case 6:
                utils.bridgeModule(gCPGameButton.getPagerId()).log(gCPGameButton.getLogTag() + " OnButtonClick return by isSubscribed");
                return;
            case 7:
                if (utils.currentBridgeModule().isWifiConnected()) {
                    BridgeModule currentBridgeModule2 = utils.currentBridgeModule();
                    String gameId3 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId();
                    String packName2 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getPackName();
                    String gameName = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameName();
                    String channelId2 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getChannelId();
                    String appStoreUrl2 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getAppStoreUrl();
                    currentBridgeModule2.getClass();
                    e eVar3 = new e();
                    eVar3.v("appId", gameId3);
                    eVar3.v(PushClientConstants.TAG_PKG_NAME, packName2);
                    eVar3.v("appName", gameName);
                    eVar3.v("channelId", channelId2);
                    eVar3.v("downloadUrl", appStoreUrl2);
                    currentBridgeModule2.callNativeMethod("startDownloadApp", eVar3, null);
                    ((GCPGameButtonAttr) gCPGameButton.getAttr()).setTaskStatus(2);
                    gCPGameButton.updateBtnUIByTaskStatus();
                    return;
                }
                gCPGameButton.handleDownloadNoWifiDialog(false);
                return;
            case 8:
                BridgeModule currentBridgeModule3 = utils.currentBridgeModule();
                String gameId4 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId();
                currentBridgeModule3.getClass();
                e eVar4 = new e();
                eVar4.v("appId", gameId4);
                currentBridgeModule3.callNativeMethod("pauseDownloadApp", eVar4, null);
                ((GCPGameButtonAttr) gCPGameButton.getAttr()).setTaskStatus(5);
                gCPGameButton.updateBtnUIByTaskStatus();
                return;
            case 9:
                if (utils.currentBridgeModule().isWifiConnected()) {
                    BridgeModule currentBridgeModule4 = utils.currentBridgeModule();
                    String gameId5 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId();
                    currentBridgeModule4.getClass();
                    e eVar5 = new e();
                    eVar5.v("appId", gameId5);
                    currentBridgeModule4.callNativeMethod("resumeDownloadApp", eVar5, null);
                    ((GCPGameButtonAttr) gCPGameButton.getAttr()).setTaskStatus(4);
                    gCPGameButton.updateBtnUIByTaskStatus();
                    return;
                }
                gCPGameButton.handleDownloadNoWifiDialog(true);
                return;
            case 10:
                BridgeModule currentBridgeModule5 = utils.currentBridgeModule();
                String gameId6 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameId();
                String packName3 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getPackName();
                String gameName2 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getGameName();
                String channelId3 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getChannelId();
                String appStoreUrl3 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getAppStoreUrl();
                currentBridgeModule5.getClass();
                e eVar6 = new e();
                eVar6.v("appId", gameId6);
                eVar6.v(PushClientConstants.TAG_PKG_NAME, packName3);
                eVar6.v("appName", gameName2);
                eVar6.v("channelId", channelId3);
                eVar6.v("downloadUrl", appStoreUrl3);
                currentBridgeModule5.callNativeMethod("requestInstallApp", eVar6, null);
                return;
            case 11:
                BridgeModule currentBridgeModule6 = utils.currentBridgeModule();
                String packName4 = ((GCPGameButtonAttr) gCPGameButton.getAttr()).getPackName();
                currentBridgeModule6.getClass();
                e eVar7 = new e();
                eVar7.v(PushClientConstants.TAG_PKG_NAME, packName4);
                currentBridgeModule6.callNativeMethod("launchApp", eVar7, null);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GCPGameButton gCPGameButton = GCPGameButton.this;
                c.a(viewContainer, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ButtonView buttonView) {
                        ButtonView buttonView2 = buttonView;
                        final GCPGameButton gCPGameButton2 = GCPGameButton.this;
                        buttonView2.ref(buttonView2, new Function1<aa<ButtonView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<ButtonView> aaVar) {
                                GCPGameButton.this.buttonRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameButton gCPGameButton3 = GCPGameButton.this;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                h hVar;
                                a aVar2 = aVar;
                                final GCPGameButton gCPGameButton4 = GCPGameButton.this;
                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        GCPGameButtonAttr access$getAttr = GCPGameButton.access$getAttr(GCPGameButton.this);
                                        ReadWriteProperty readWriteProperty = access$getAttr.buttonText$delegate;
                                        KProperty<?>[] kPropertyArr = GCPGameButtonAttr.$$delegatedProperties;
                                        ceVar2.text((String) readWriteProperty.getValue(access$getAttr, kPropertyArr[3]));
                                        ceVar2.fontWeightSemisolid();
                                        GCPGameButtonAttr access$getAttr2 = GCPGameButton.access$getAttr(GCPGameButton.this);
                                        ceVar2.color(new h(((Number) access$getAttr2.buttonTextColor$delegate.getValue(access$getAttr2, kPropertyArr[4])).longValue()));
                                        ce.fontSize$default(ceVar2, GCPGameButton.access$getAttr(GCPGameButton.this).buttonFontSize, null, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                aVar2.mo141height(32.0f);
                                GCPGameButtonAttr access$getAttr = GCPGameButton.access$getAttr(GCPGameButton.this);
                                aVar2.mo113backgroundColor(new h(((Number) access$getAttr.buttonColor$delegate.getValue(access$getAttr, GCPGameButtonAttr.$$delegatedProperties[5])).longValue()));
                                aVar2.borderRadius(4.0f);
                                if (GCPGameButton.access$getAttr(GCPGameButton.this).buttonFixedWidth) {
                                    aVar2.mo153width(64.0f);
                                } else {
                                    aVar2.paddingLeft(18.0f);
                                    aVar2.paddingRight(18.0f);
                                }
                                aVar2.n(true);
                                if (GCPGameButton.access$getAttr(GCPGameButton.this).isDarkStyle) {
                                    hVar = new h(1294937903L);
                                } else {
                                    hVar = new h(4293322470L);
                                }
                                aVar2.o(hVar);
                                aVar2.p(GCPGameButton.access$getAttr(GCPGameButton.this).getButtonProgress());
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameButton gCPGameButton4 = GCPGameButton.this;
                        buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(b bVar) {
                                final GCPGameButton gCPGameButton5 = GCPGameButton.this;
                                bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GCPGameButton.access$onButtonClick(GCPGameButton.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPGameButtonEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.Long>] */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) getAttr();
        String str = (String) gameButtonTextMap.get(((GCPGameButtonAttr) getAttr()).getGameId());
        if (str == null) {
            str = "\u9884\u7ea6";
        }
        ReadWriteProperty readWriteProperty = gCPGameButtonAttr.buttonText$delegate;
        KProperty<?>[] kPropertyArr = GCPGameButtonAttr.$$delegatedProperties;
        readWriteProperty.setValue(gCPGameButtonAttr, kPropertyArr[3], str);
        GCPGameButtonAttr gCPGameButtonAttr2 = (GCPGameButtonAttr) getAttr();
        Long l3 = (Long) gameButtonTextColorMap.get(((GCPGameButtonAttr) getAttr()).getGameId());
        gCPGameButtonAttr2.buttonTextColor$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[4], Long.valueOf(l3 != null ? l3.longValue() : 4294967295L));
        GCPGameButtonAttr gCPGameButtonAttr3 = (GCPGameButtonAttr) getAttr();
        Long l16 = (Long) gameButtonBackgroundColorMap.get(((GCPGameButtonAttr) getAttr()).getGameId());
        gCPGameButtonAttr3.setButtonColor(l16 != null ? l16.longValue() : 4278229503L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        String str;
        super.didInit();
        Utils utils = Utils.INSTANCE;
        utils.bridgeModule(getPagerId()).log(getLogTag() + " didInit() start queryGameSubscribeStatus");
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        String gameId = ((GCPGameButtonAttr) getAttr()).getGameId();
        String channelId = ((GCPGameButtonAttr) getAttr()).getChannelId();
        final Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton$didInit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                Utils utils2 = Utils.INSTANCE;
                utils2.bridgeModule(GCPGameButton.this.getPagerId()).log(GCPGameButton.this.getLogTag() + " queryGameSubscribeStatus callback result: " + eVar2 + TokenParser.SP);
                GCPGameButtonAttr access$getAttr = GCPGameButton.access$getAttr(GCPGameButton.this);
                int i3 = 1;
                int k3 = eVar2 != null ? eVar2.k("subscribeStatus", 1) : 1;
                ReadWriteProperty readWriteProperty = access$getAttr.subscribeStatus$delegate;
                KProperty<?>[] kPropertyArr = GCPGameButtonAttr.$$delegatedProperties;
                readWriteProperty.setValue(access$getAttr, kPropertyArr[7], Integer.valueOf(k3));
                int k16 = eVar2 != null ? eVar2.k("followStatus", 1) : 1;
                GCPGameButtonAttr access$getAttr2 = GCPGameButton.access$getAttr(GCPGameButton.this);
                if (k16 == 1) {
                    i3 = 2;
                } else if (k16 == 2) {
                    i3 = 3;
                }
                access$getAttr2.followStatus$delegate.setValue(access$getAttr2, kPropertyArr[8], Integer.valueOf(i3));
                GCPGameButton gCPGameButton = GCPGameButton.this;
                boolean needShowDownload = gCPGameButton.needShowDownload(GCPGameButton.access$getAttr(gCPGameButton).getSubscribeStatus());
                utils2.bridgeModule(GCPGameButton.this.getPagerId()).log(GCPGameButton.this.getLogTag() + " didInit() needShowDownload:" + needShowDownload);
                if (needShowDownload) {
                    BridgeModule currentBridgeModule2 = utils2.currentBridgeModule();
                    String packName = GCPGameButton.access$getAttr(GCPGameButton.this).getPackName();
                    currentBridgeModule2.getClass();
                    e eVar3 = new e();
                    eVar3.v(PushClientConstants.TAG_PKG_NAME, packName);
                    if (Intrinsics.areEqual(currentBridgeModule2.syncToNativeMethod("isAppInstalled", eVar3, (Function1<? super e, Unit>) null), "1")) {
                        GCPGameButton.access$getAttr(GCPGameButton.this).setTaskStatus(9);
                        utils2.bridgeModule(GCPGameButton.this.getPagerId()).log(GCPGameButton.this.getLogTag() + " game installed! update taskStatus to INSTALL_COMPLETED_SUCCESS");
                    } else {
                        utils2.bridgeModule(GCPGameButton.this.getPagerId()).log(GCPGameButton.this.getLogTag() + " not installed, start queryGameDownloadTaskStatus gameId: " + GCPGameButton.access$getAttr(GCPGameButton.this).getGameId() + TokenParser.SP);
                        BridgeModule currentBridgeModule3 = utils2.currentBridgeModule();
                        String gameId2 = GCPGameButton.access$getAttr(GCPGameButton.this).getGameId();
                        final GCPGameButton gCPGameButton2 = GCPGameButton.this;
                        Function1<e, Unit> function12 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameButton$didInit$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar4) {
                                String q16;
                                e eVar5 = eVar4;
                                String str2 = "";
                                if (eVar5 != null && (q16 = eVar5.q("appId", "")) != null) {
                                    str2 = q16;
                                }
                                if (Intrinsics.areEqual(str2, GCPGameButton.access$getAttr(GCPGameButton.this).getGameId())) {
                                    Utils.INSTANCE.bridgeModule(GCPGameButton.this.getPagerId()).log(GCPGameButton.this.getLogTag() + " queryGameDownloadTaskStatus callback result: " + eVar5 + TokenParser.SP);
                                    GCPGameButton.access$getAttr(GCPGameButton.this).downloadProgress = eVar5 != null ? eVar5.k("progress", 0) : 0;
                                    GCPGameButton.access$getAttr(GCPGameButton.this).setTaskStatus(eVar5 != null ? eVar5.k("taskStatus", 0) : 0);
                                    GCPGameButton gCPGameButton3 = GCPGameButton.this;
                                    gCPGameButton3.onBtnStatusChanged(GCPGameButton.access$getAttr(gCPGameButton3).getSubscribeStatus(), GCPGameButton.access$getAttr(GCPGameButton.this).getFollowStatus(), false);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        currentBridgeModule3.getClass();
                        e eVar4 = new e();
                        eVar4.v("appId", gameId2);
                        currentBridgeModule3.toNative(true, "queryGameDownloadTaskStatus", eVar4.toString(), function12, false);
                    }
                }
                GCPGameButton gCPGameButton3 = GCPGameButton.this;
                gCPGameButton3.onBtnStatusChanged(GCPGameButton.access$getAttr(gCPGameButton3).getSubscribeStatus(), GCPGameButton.access$getAttr(GCPGameButton.this).getFollowStatus(), false);
                return Unit.INSTANCE;
            }
        };
        currentBridgeModule.getClass();
        e eVar = new e();
        eVar.v("appId", gameId);
        eVar.v("channelId", channelId);
        try {
        } catch (Throwable th5) {
            Utils.INSTANCE.logToNative("queryGameSubscribeStatus exception:" + th5);
        }
        if (com.tencent.kuikly.core.manager.c.f117352a.k(currentBridgeModule.getPagerId()).getPageData().getIsIOS()) {
            str = "queryGameStatus";
            currentBridgeModule.callNativeMethod(str, eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$queryGameSubscribeStatus$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    function1.invoke(eVar2);
                    return Unit.INSTANCE;
                }
            });
        }
        str = "queryGameSubscribeStatus";
        currentBridgeModule.callNativeMethod(str, eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$queryGameSubscribeStatus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                function1.invoke(eVar2);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getLogTag() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GCPGameButton_");
        m3.append(((GCPGameButtonAttr) getAttr()).getGameId());
        m3.append(util.base64_pad_url);
        m3.append(((GCPGameButtonAttr) getAttr()).getGameName());
        return m3.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean needShowDownload(int i3) {
        boolean isBlank;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        String str2;
        String str3;
        String str4;
        if (((GCPGameButtonAttr) getAttr()).getPagerData().getIsIOS() || i3 != 3) {
            return false;
        }
        GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) getAttr();
        isBlank = StringsKt__StringsJVMKt.isBlank((String) gCPGameButtonAttr.androidDownloadUrl$delegate.getValue(gCPGameButtonAttr, GCPGameButtonAttr.$$delegatedProperties[2]));
        if (!(!isBlank) || ((GCPGameButtonAttr) getAttr()).privilege == null) {
            return false;
        }
        GamePrivilegeInfo gamePrivilegeInfo = ((GCPGameButtonAttr) getAttr()).privilege;
        if (gamePrivilegeInfo != null && (str4 = gamePrivilegeInfo.developer) != null) {
            if (str4.length() > 0) {
                z16 = true;
                if (z16) {
                    return false;
                }
                GamePrivilegeInfo gamePrivilegeInfo2 = ((GCPGameButtonAttr) getAttr()).privilege;
                if (gamePrivilegeInfo2 != null && (str3 = gamePrivilegeInfo2.version) != null) {
                    if (str3.length() > 0) {
                        z17 = true;
                        if (z17) {
                            return false;
                        }
                        GamePrivilegeInfo gamePrivilegeInfo3 = ((GCPGameButtonAttr) getAttr()).privilege;
                        if (gamePrivilegeInfo3 != null && (str2 = gamePrivilegeInfo3.appPrivilegesText) != null) {
                            if (str2.length() > 0) {
                                z18 = true;
                                if (z18) {
                                    return false;
                                }
                                GamePrivilegeInfo gamePrivilegeInfo4 = ((GCPGameButtonAttr) getAttr()).privilege;
                                if (gamePrivilegeInfo4 != null && (str = gamePrivilegeInfo4.privatePoliciesText) != null) {
                                    if (str.length() > 0) {
                                        z19 = true;
                                        return !z19;
                                    }
                                }
                                z19 = false;
                                if (!z19) {
                                }
                            }
                        }
                        z18 = false;
                        if (z18) {
                        }
                    }
                }
                z17 = false;
                if (z17) {
                }
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBtnBackgroundColor(long j3) {
        ((GCPGameButtonAttr) getAttr()).setButtonColor(j3);
        gameButtonBackgroundColorMap.put(((GCPGameButtonAttr) getAttr()).getGameId(), Long.valueOf(j3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBtnText(String str) {
        GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) getAttr();
        gCPGameButtonAttr.buttonText$delegate.setValue(gCPGameButtonAttr, GCPGameButtonAttr.$$delegatedProperties[3], str);
        gameButtonTextMap.put(((GCPGameButtonAttr) getAttr()).getGameId(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBtnTextColor(long j3) {
        GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) getAttr();
        gCPGameButtonAttr.buttonTextColor$delegate.setValue(gCPGameButtonAttr, GCPGameButtonAttr.$$delegatedProperties[4], Long.valueOf(j3));
        gameButtonTextColorMap.put(((GCPGameButtonAttr) getAttr()).getGameId(), Long.valueOf(j3));
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final String buttonStatusToString(int i3) {
            switch (i3) {
                case 2:
                    return "BUTTON_GAME_ONLINE";
                case 3:
                    return "BUTTON_NEED_SUBSED";
                case 4:
                    return "BUTTON_NEED_FOLLOWED";
                case 5:
                    return "BUTTON_SUBSED";
                case 6:
                    return "BUTTON_FOLLOWED";
                case 7:
                    return "BUTTON_DOWNLOAD_IDLE";
                case 8:
                    return "BUTTON_DOWNLOAD_RUNNING";
                case 9:
                    return "BUTTON_DOWNLOAD_PAUSED";
                case 10:
                    return "BUTTON_DOWNLOAD_SUCCESS";
                case 11:
                    return "BUTTON_INSTALLED";
                default:
                    return "unknown";
            }
        }

        public final String taskStatusToString(int i3) {
            if (i3 == 0) {
                return "DOWNLOAD_IDLE";
            }
            if (i3 == 2) {
                return "DOWNLOAD_START";
            }
            if (i3 == 9) {
                return "INSTALL_COMPLETED_SUCCESS";
            }
            if (i3 == 12) {
                return "DOWNLOAD_DELETED";
            }
            if (i3 == 4) {
                return "DOWNLOAD_RUNNING";
            }
            if (i3 == 5) {
                return "DOWNLOAD_PAUSED";
            }
            if (i3 == 6) {
                return "DOWNLOAD_COMPLETED_SUCCESS";
            }
            if (i3 != 7) {
                return "unknown";
            }
            return "DOWNLOAD_COMPLETED_FAIL";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleDownloadNoWifiDialog(boolean z16) {
        String str;
        if (!z16) {
            String str2 = ((GCPGameButtonAttr) getAttr()).pkgSize;
            boolean z17 = false;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z17 = true;
                }
            }
            if (z17) {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u672c\u6e38\u620f\u5b89\u88c5\u5305\u9884\u8ba1\u5927\u5c0f\u4e3a{");
                m3.append(getAttr());
                m3.append(".pkgSize}\uff0c\u5f53\u524d\u5904\u4e8e\u975eWIFI\u73af\u5883\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f");
                str = m3.toString();
                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                String gameId = ((GCPGameButtonAttr) getAttr()).getGameId();
                String packName = ((GCPGameButtonAttr) getAttr()).getPackName();
                String gameName = ((GCPGameButtonAttr) getAttr()).getGameName();
                String channelId = ((GCPGameButtonAttr) getAttr()).getChannelId();
                String appStoreUrl = ((GCPGameButtonAttr) getAttr()).getAppStoreUrl();
                currentBridgeModule.getClass();
                e eVar = new e();
                eVar.v("msg", str);
                eVar.w("isResume", z16);
                eVar.v("appId", gameId);
                eVar.v(PushClientConstants.TAG_PKG_NAME, packName);
                eVar.v("appName", gameName);
                eVar.v("channelId", channelId);
                eVar.v("downloadUrl", appStoreUrl);
                currentBridgeModule.callNativeMethod("downloadAppShowNoWifiDialog", eVar, null);
            }
        }
        str = "\u5f53\u524d\u5904\u4e8e\u975eWIFI\u73af\u5883\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f";
        BridgeModule currentBridgeModule2 = Utils.INSTANCE.currentBridgeModule();
        String gameId2 = ((GCPGameButtonAttr) getAttr()).getGameId();
        String packName2 = ((GCPGameButtonAttr) getAttr()).getPackName();
        String gameName2 = ((GCPGameButtonAttr) getAttr()).getGameName();
        String channelId2 = ((GCPGameButtonAttr) getAttr()).getChannelId();
        String appStoreUrl2 = ((GCPGameButtonAttr) getAttr()).getAppStoreUrl();
        currentBridgeModule2.getClass();
        e eVar2 = new e();
        eVar2.v("msg", str);
        eVar2.w("isResume", z16);
        eVar2.v("appId", gameId2);
        eVar2.v(PushClientConstants.TAG_PKG_NAME, packName2);
        eVar2.v("appName", gameName2);
        eVar2.v("channelId", channelId2);
        eVar2.v("downloadUrl", appStoreUrl2);
        currentBridgeModule2.callNativeMethod("downloadAppShowNoWifiDialog", eVar2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r2 != 7) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateBtnUIByTaskStatus() {
        int status = ((GCPGameButtonAttr) getAttr()).getStatus();
        int taskStatus = ((GCPGameButtonAttr) getAttr()).getTaskStatus();
        if (taskStatus != 0) {
            if (taskStatus != 2) {
                if (taskStatus == 9) {
                    ((GCPGameButtonAttr) getAttr()).setStatus(11);
                    setBtnText("\u8fdb\u5165");
                    setBtnBackgroundColor(4278229503L);
                    setBtnTextColor(4294967295L);
                } else if (taskStatus != 12) {
                    if (taskStatus != 4) {
                        if (taskStatus == 5) {
                            GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) getAttr();
                            gCPGameButtonAttr.buttonProgress$delegate.setValue(gCPGameButtonAttr, GCPGameButtonAttr.$$delegatedProperties[10], Float.valueOf(((GCPGameButtonAttr) getAttr()).downloadProgress / 100.0f));
                            aa<ButtonView> aaVar = this.buttonRef;
                            if (aaVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("buttonRef");
                                aaVar = null;
                            }
                            ButtonView b16 = aaVar.b();
                            a aVar = b16 != null ? (a) b16.getViewAttr() : null;
                            if (aVar != null) {
                                aVar.p(((GCPGameButtonAttr) getAttr()).getButtonProgress());
                            }
                            ((GCPGameButtonAttr) getAttr()).setStatus(9);
                            setBtnText("\u7ee7\u7eed");
                            setBtnBackgroundColor(((GCPGameButtonAttr) getAttr()).isDarkStyle ? 4293322470L : 4294309365L);
                            setBtnTextColor(4278190080L);
                        } else if (taskStatus == 6) {
                            ((GCPGameButtonAttr) getAttr()).setStatus(10);
                            setBtnText("\u5b89\u88c5");
                            setBtnBackgroundColor(4278229503L);
                            setBtnTextColor(4294967295L);
                        }
                    }
                }
                Utils utils = Utils.INSTANCE;
                String pagerId = getPagerId();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(getLogTag());
                sb5.append(" updateBtnUIByTaskStatus taskStatus:");
                Companion companion = Companion;
                sb5.append(companion.taskStatusToString(((GCPGameButtonAttr) getAttr()).getTaskStatus()));
                sb5.append(" oldBtnStatus:");
                sb5.append(companion.buttonStatusToString(status));
                sb5.append(" -> curBtnStatus:");
                sb5.append(companion.buttonStatusToString(((GCPGameButtonAttr) getAttr()).getStatus()));
                sb5.append(" btnText:");
                GCPGameButtonAttr gCPGameButtonAttr2 = (GCPGameButtonAttr) getAttr();
                sb5.append((String) gCPGameButtonAttr2.buttonText$delegate.getValue(gCPGameButtonAttr2, GCPGameButtonAttr.$$delegatedProperties[3]));
                utils.bridgeModule(pagerId).log(sb5.toString());
            }
            GCPGameButtonAttr gCPGameButtonAttr3 = (GCPGameButtonAttr) getAttr();
            gCPGameButtonAttr3.buttonProgress$delegate.setValue(gCPGameButtonAttr3, GCPGameButtonAttr.$$delegatedProperties[10], Float.valueOf(((GCPGameButtonAttr) getAttr()).downloadProgress / 100.0f));
            aa<ButtonView> aaVar2 = this.buttonRef;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttonRef");
                aaVar2 = null;
            }
            ButtonView b17 = aaVar2.b();
            a aVar2 = b17 != null ? (a) b17.getViewAttr() : null;
            if (aVar2 != null) {
                aVar2.p(((GCPGameButtonAttr) getAttr()).getButtonProgress());
            }
            ((GCPGameButtonAttr) getAttr()).setStatus(8);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(((GCPGameButtonAttr) getAttr()).downloadProgress);
            sb6.append('%');
            setBtnText(sb6.toString());
            setBtnBackgroundColor(((GCPGameButtonAttr) getAttr()).isDarkStyle ? 4293322470L : 4294309365L);
            setBtnTextColor(4278190080L);
            Utils utils2 = Utils.INSTANCE;
            String pagerId2 = getPagerId();
            StringBuilder sb52 = new StringBuilder();
            sb52.append(getLogTag());
            sb52.append(" updateBtnUIByTaskStatus taskStatus:");
            Companion companion2 = Companion;
            sb52.append(companion2.taskStatusToString(((GCPGameButtonAttr) getAttr()).getTaskStatus()));
            sb52.append(" oldBtnStatus:");
            sb52.append(companion2.buttonStatusToString(status));
            sb52.append(" -> curBtnStatus:");
            sb52.append(companion2.buttonStatusToString(((GCPGameButtonAttr) getAttr()).getStatus()));
            sb52.append(" btnText:");
            GCPGameButtonAttr gCPGameButtonAttr22 = (GCPGameButtonAttr) getAttr();
            sb52.append((String) gCPGameButtonAttr22.buttonText$delegate.getValue(gCPGameButtonAttr22, GCPGameButtonAttr.$$delegatedProperties[3]));
            utils2.bridgeModule(pagerId2).log(sb52.toString());
        }
        ((GCPGameButtonAttr) getAttr()).setStatus(7);
        setBtnText("\u4e0b\u8f7d");
        setBtnBackgroundColor(4278229503L);
        setBtnTextColor(4294967295L);
        Utils utils22 = Utils.INSTANCE;
        String pagerId22 = getPagerId();
        StringBuilder sb522 = new StringBuilder();
        sb522.append(getLogTag());
        sb522.append(" updateBtnUIByTaskStatus taskStatus:");
        Companion companion22 = Companion;
        sb522.append(companion22.taskStatusToString(((GCPGameButtonAttr) getAttr()).getTaskStatus()));
        sb522.append(" oldBtnStatus:");
        sb522.append(companion22.buttonStatusToString(status));
        sb522.append(" -> curBtnStatus:");
        sb522.append(companion22.buttonStatusToString(((GCPGameButtonAttr) getAttr()).getStatus()));
        sb522.append(" btnText:");
        GCPGameButtonAttr gCPGameButtonAttr222 = (GCPGameButtonAttr) getAttr();
        sb522.append((String) gCPGameButtonAttr222.buttonText$delegate.getValue(gCPGameButtonAttr222, GCPGameButtonAttr.$$delegatedProperties[3]));
        utils22.bridgeModule(pagerId22).log(sb522.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008b, code lost:
    
        if (r18 != 1995001) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onBtnStatusChanged(int i3, int i16, boolean z16) {
        String str;
        Utils utils = Utils.INSTANCE;
        String pagerId = getPagerId();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getLogTag());
        sb5.append(" onBtnStatusChanged subscribeStatus:");
        Companion companion = Companion;
        if (i3 == 1) {
            str = "STATUS_NOT_SUBSCRIBE";
        } else if (i3 == 2) {
            str = "STATUS_SUBSCRIBED";
        } else if (i3 == 3) {
            str = "STATUS_GAME_ONLINE";
        } else if (i3 != 1995001) {
            str = "unknown";
        } else {
            str = "STATUS_DOUBLE_SUBSCRIBED";
        }
        StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(sb5, str, " followStatus:", i16, " taskStatus:");
        m3.append(companion.taskStatusToString(((GCPGameButtonAttr) getAttr()).getTaskStatus()));
        m3.append(" isFromClick:");
        m3.append(z16);
        utils.bridgeModule(pagerId).log(m3.toString());
        ((GCPGameButtonAttr) getAttr()).setStatus(3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (needShowDownload(i3)) {
                        updateBtnUIByTaskStatus();
                    } else {
                        ((GCPGameButtonAttr) getAttr()).setStatus(2);
                        setBtnText("\u8fdb\u5165");
                        setBtnBackgroundColor(4278229503L);
                        setBtnTextColor(4294967295L);
                    }
                }
            }
            if (i16 == 3) {
                setBtnText("\u5df2\u5173\u6ce8");
                ((GCPGameButtonAttr) getAttr()).setStatus(6);
            } else {
                setBtnText("\u5df2\u9884\u7ea6");
                ((GCPGameButtonAttr) getAttr()).setStatus(5);
            }
            setBtnBackgroundColor(4291621119L);
            setBtnTextColor(4294967295L);
            if (z16) {
                GCPGameButtonAttr gCPGameButtonAttr = (GCPGameButtonAttr) getAttr();
                BridgeModule.openPage$default(utils.bridgeModule(getPagerId()), (String) gCPGameButtonAttr.subscribeSucUrl$delegate.getValue(gCPGameButtonAttr, GCPGameButtonAttr.$$delegatedProperties[11]), false, null, null, 30);
                if (((GCPGameButtonAttr) getAttr()).getStatus() == 5) {
                    String gameName = ((GCPGameButtonAttr) getAttr()).getGameName();
                    GameTab gameTab = ((GCPGameButtonAttr) getAttr()).gameTab;
                    e m16 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m(CrashRtInfoHolder.BeaconKey.GAME_NAME, gameName, "reserve_pos", ((GCPGameButtonAttr) getAttr()).scene);
                    if (gameTab != null) {
                        m16.v("second_tab_name", gameTab.name);
                    }
                    e m17 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
                    Iterator<String> c16 = m16.c();
                    while (c16.hasNext()) {
                        String next = c16.next();
                        m17.v(next, m16.p(next));
                    }
                    Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_reserve_game", m17);
                }
            }
        } else {
            if (i16 == 2) {
                setBtnText("\u5173\u6ce8");
                ((GCPGameButtonAttr) getAttr()).setStatus(4);
            } else {
                setBtnText("\u9884\u7ea6");
                ((GCPGameButtonAttr) getAttr()).setStatus(3);
            }
            setBtnBackgroundColor(4278229503L);
            setBtnTextColor(4294967295L);
        }
        e eVar = new e();
        eVar.t("status", ((GCPGameButtonAttr) getAttr()).getStatus());
        Unit unit = Unit.INSTANCE;
        emit("statusChange", eVar);
    }
}
