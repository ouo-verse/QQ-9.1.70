package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishStatusData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProAvatarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProAvatarEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProAvatarView;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.module.r;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.PAGViewAttr;
import com.tencent.kuikly.core.views.PAGViewKt;
import com.tencent.kuikly.core.views.bc;
import com.tencent.kuikly.core.views.bd;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.ttpic.openapi.filter.LightConstants;
import d45.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import q25.f;

/* loaded from: classes31.dex */
public final class NBPPublishAvatarView extends ComposeView<NBPPublishAvatarAttr, NBPPublishAvatarEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishAvatarView.class, "realAvatarFrame", "getRealAvatarFrame()Lcom/tencent/kuikly/core/layout/Frame;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishAvatarView.class, "showUserTips", "getShowUserTips()Z", 0)};
    public aa<NearbyProAvatarView> avatarViewRef;
    public final ReadWriteProperty realAvatarFrame$delegate = c.a(d.INSTANCE.a());
    public String notifyCallbackRef = "";
    public final ReadWriteProperty showUserTips$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishAvatarAttr access$getAttr(NBPPublishAvatarView nBPPublishAvatarView) {
        return (NBPPublishAvatarAttr) nBPPublishAvatarView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishAvatarView nBPPublishAvatarView = NBPPublishAvatarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishAvatarView nBPPublishAvatarView2 = NBPPublishAvatarView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().getSelectStatus();
                            }
                        };
                        final NBPPublishAvatarView nBPPublishAvatarView3 = NBPPublishAvatarView.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                final NBPPublishAvatarView nBPPublishAvatarView4 = NBPPublishAvatarView.this;
                                bindDirectivesView2.addChild(new NearbyProAvatarView(), new Function1<NearbyProAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NearbyProAvatarView nearbyProAvatarView) {
                                        NearbyProAvatarView nearbyProAvatarView2 = nearbyProAvatarView;
                                        final NBPPublishAvatarView nBPPublishAvatarView5 = NBPPublishAvatarView.this;
                                        nearbyProAvatarView2.ref(nearbyProAvatarView2, new Function1<aa<NearbyProAvatarView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<NearbyProAvatarView> aaVar) {
                                                NBPPublishAvatarView.this.avatarViewRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishAvatarView nBPPublishAvatarView6 = NBPPublishAvatarView.this;
                                        nearbyProAvatarView2.attr(new Function1<NearbyProAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyProAvatarAttr nearbyProAvatarAttr) {
                                                String decodeToString;
                                                NearbyProAvatarView b16;
                                                NearbyProAvatarAttr nearbyProAvatarAttr2 = nearbyProAvatarAttr;
                                                NBPPublishStatusData selectStatus = NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().getSelectStatus();
                                                if (selectStatus != null) {
                                                    NBPPublishAvatarView nBPPublishAvatarView7 = NBPPublishAvatarView.this;
                                                    f fVar = selectStatus.filamentResource;
                                                    if (fVar != null) {
                                                        long j3 = selectStatus.tid;
                                                        boolean z16 = selectStatus.male;
                                                        String str = selectStatus.dressKey;
                                                        long j16 = UserDataManager.INSTANCE.getUserSelfInfo().tid;
                                                        e eVar = new e();
                                                        eVar.u("tid", j3);
                                                        eVar.w(LightConstants.MALE, z16);
                                                        eVar.u("selfTid", j16);
                                                        decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(i.d(fVar)));
                                                        eVar.v("resourceInfo", decodeToString);
                                                        eVar.w("autoPlay", true);
                                                        if (str != null) {
                                                            eVar.v("dressKey", str);
                                                        }
                                                        Unit unit = Unit.INSTANCE;
                                                        nearbyProAvatarAttr2.with("avatarData", eVar.toString());
                                                        aa<NearbyProAvatarView> aaVar = nBPPublishAvatarView7.avatarViewRef;
                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                            b16.onPlay();
                                                        }
                                                    }
                                                }
                                                nearbyProAvatarAttr2.getPagerData().getIsIOS();
                                                float statusBarHeight = nearbyProAvatarAttr2.getPagerData().getStatusBarHeight() + 44.0f;
                                                float contentHeight = NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().getContentHeight() + 4.0f;
                                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).viewModelCityWalk;
                                                if (nBPCityWalkViewModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                    nBPCityWalkViewModel = null;
                                                }
                                                float floatValue = ((Number) nBPCityWalkViewModel.bottomBarHeight$delegate.getValue(nBPCityWalkViewModel, NBPCityWalkViewModel.$$delegatedProperties[1])).floatValue();
                                                float to812 = FloatExtKt.getTo812(200.0f);
                                                float l3 = ((((nearbyProAvatarAttr2.getPagerData().l() - contentHeight) - statusBarHeight) - floatValue) - 43.0f) - 5.0f;
                                                if (l3 > to812) {
                                                    nearbyProAvatarAttr2.size(to812, to812);
                                                } else {
                                                    nearbyProAvatarAttr2.size(l3, l3);
                                                }
                                                KLog.INSTANCE.i("NBPPublishAvatarView", "Avatar Size: lastHeight: " + l3 + ", normalHeight: " + to812);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishAvatarView nBPPublishAvatarView7 = NBPPublishAvatarView.this;
                                        nearbyProAvatarView2.event(new Function1<NearbyProAvatarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyProAvatarEvent nearbyProAvatarEvent) {
                                                NearbyProAvatarEvent nearbyProAvatarEvent2 = nearbyProAvatarEvent;
                                                final NBPPublishAvatarView nBPPublishAvatarView8 = NBPPublishAvatarView.this;
                                                nearbyProAvatarEvent2.register("loadSuccess", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPPublishAvatarView nBPPublishAvatarView9 = NBPPublishAvatarView.this;
                                                        KProperty<Object>[] kPropertyArr = NBPPublishAvatarView.$$delegatedProperties;
                                                        r rVar = (r) nBPPublishAvatarView9.acquireModule("KRSharedPreferencesModule");
                                                        if (!Intrinsics.areEqual(rVar.getItem("NBPPublishAvatarView_canShowUserTips"), "1")) {
                                                            rVar.setItem("NBPPublishAvatarView_canShowUserTips", "1");
                                                            nBPPublishAvatarView9.showUserTips$delegate.setValue(nBPPublishAvatarView9, NBPPublishAvatarView.$$delegatedProperties[1], Boolean.TRUE);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishAvatarView nBPPublishAvatarView9 = NBPPublishAvatarView.this;
                                                VisibilityEventKt.b(nearbyProAvatarEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.1.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                        NBPPublishAvatarView nBPPublishAvatarView10 = NBPPublishAvatarView.this;
                                                        jsonWithPublishPgParams.v("dt_eid", "em_nearby_avatar_state_choose");
                                                        NBPPublishStatusData selectStatus = NBPPublishAvatarView.access$getAttr(nBPPublishAvatarView10).getViewModel().getSelectStatus();
                                                        jsonWithPublishPgParams.v("nearby_status_id", selectStatus != null ? Integer.valueOf(selectStatus.statusId) : null);
                                                        NBPPublishStatusData selectStatus2 = NBPPublishAvatarView.access$getAttr(nBPPublishAvatarView10).getViewModel().getSelectStatus();
                                                        jsonWithPublishPgParams.v("nearby_action_id", selectStatus2 != null ? Integer.valueOf(selectStatus2.richStatusId) : null);
                                                        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithPublishPgParams);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishAvatarView nBPPublishAvatarView5 = NBPPublishAvatarView.this;
                                w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishAvatarView nBPPublishAvatarView6 = NBPPublishAvatarView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPPublishAvatarView nBPPublishAvatarView7 = NBPPublishAvatarView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().setShowAvatarStatusPanel(true);
                                                        NBPPublishAvatarView nBPPublishAvatarView8 = NBPPublishAvatarView.this;
                                                        nBPPublishAvatarView8.showUserTips$delegate.setValue(nBPPublishAvatarView8, NBPPublishAvatarView.$$delegatedProperties[1], Boolean.FALSE);
                                                        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                        NBPPublishAvatarView nBPPublishAvatarView9 = NBPPublishAvatarView.this;
                                                        jsonWithPublishPgParams.v("dt_eid", "em_nearby_avatar_state_choose");
                                                        NBPPublishStatusData selectStatus = NBPPublishAvatarView.access$getAttr(nBPPublishAvatarView9).getViewModel().getSelectStatus();
                                                        jsonWithPublishPgParams.v("nearby_status_id", selectStatus != null ? Integer.valueOf(selectStatus.statusId) : null);
                                                        NBPPublishStatusData selectStatus2 = NBPPublishAvatarView.access$getAttr(nBPPublishAvatarView9).getViewModel().getSelectStatus();
                                                        jsonWithPublishPgParams.v("nearby_action_id", selectStatus2 != null ? Integer.valueOf(selectStatus2.richStatusId) : null);
                                                        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPublishPgParams);
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
                        });
                        final NBPPublishAvatarView nBPPublishAvatarView4 = NBPPublishAvatarView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPPublishAvatarView nBPPublishAvatarView5 = NBPPublishAvatarView.this;
                                FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        NBPPublishAvatarView nBPPublishAvatarView6 = NBPPublishAvatarView.this;
                                        nBPPublishAvatarView6.realAvatarFrame$delegate.setValue(nBPPublishAvatarView6, NBPPublishAvatarView.$$delegatedProperties[0], dVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishAvatarView nBPPublishAvatarView2 = NBPPublishAvatarView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPublishAvatarView nBPPublishAvatarView3 = NBPPublishAvatarView.this;
                        return Boolean.valueOf(((Boolean) nBPPublishAvatarView3.showUserTips$delegate.getValue(nBPPublishAvatarView3, NBPPublishAvatarView.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final NBPPublishAvatarView nBPPublishAvatarView3 = NBPPublishAvatarView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishAvatarView nBPPublishAvatarView4 = NBPPublishAvatarView.this;
                        PAGViewKt.a(conditionView, new Function1<bc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(bc bcVar) {
                                bc bcVar2 = bcVar;
                                final NBPPublishAvatarView nBPPublishAvatarView5 = NBPPublishAvatarView.this;
                                bcVar2.attr(new Function1<PAGViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGViewAttr pAGViewAttr) {
                                        PAGViewAttr pAGViewAttr2 = pAGViewAttr;
                                        Attr.absolutePosition$default(pAGViewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        NBPPublishAvatarView nBPPublishAvatarView6 = NBPPublishAvatarView.this;
                                        pAGViewAttr2.m150top((((d) nBPPublishAvatarView6.realAvatarFrame$delegate.getValue(nBPPublishAvatarView6, NBPPublishAvatarView.$$delegatedProperties[0])).getHeight() - 26.0f) / 2);
                                        pAGViewAttr2.m149right(18.0f);
                                        pAGViewAttr2.size(118.0f, 26.0f);
                                        pAGViewAttr2.m151touchEnable(false);
                                        pAGViewAttr2.src("https://cdn.meta.qq.com/nearby/pag/publish-avatar-tips.pag");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishAvatarView nBPPublishAvatarView6 = NBPPublishAvatarView.this;
                                bcVar2.event(new Function1<bd, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(bd bdVar) {
                                        final NBPPublishAvatarView nBPPublishAvatarView7 = NBPPublishAvatarView.this;
                                        bdVar.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPPublishAvatarView nBPPublishAvatarView8 = NBPPublishAvatarView.this;
                                                nBPPublishAvatarView8.showUserTips$delegate.setValue(nBPPublishAvatarView8, NBPPublishAvatarView.$$delegatedProperties[1], Boolean.FALSE);
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
                });
                final NBPPublishAvatarView nBPPublishAvatarView4 = NBPPublishAvatarView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().getShowAvatarStatusPanel());
                    }
                };
                final NBPPublishAvatarView nBPPublishAvatarView5 = NBPPublishAvatarView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishAvatarView nBPPublishAvatarView6 = NBPPublishAvatarView.this;
                        com.tencent.kuikly.core.views.e.a(conditionView, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetView actionSheetView) {
                                ActionSheetView actionSheetView2 = actionSheetView;
                                final NBPPublishAvatarView nBPPublishAvatarView7 = NBPPublishAvatarView.this;
                                actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                        ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                        actionSheetAttr2.w(NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().getShowAvatarStatusPanel());
                                        final NBPPublishAvatarView nBPPublishAvatarView8 = NBPPublishAvatarView.this;
                                        nBPPublishAvatarView8.getClass();
                                        actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$statusPanel$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$statusPanel$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        mVar.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishAvatarView nBPPublishAvatarView9 = NBPPublishAvatarView.this;
                                                viewContainer4.addChild(new NBPPublishStatusPanelView(), new Function1<NBPPublishStatusPanelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$statusPanel$1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPublishStatusPanelView nBPPublishStatusPanelView) {
                                                        final NBPPublishAvatarView nBPPublishAvatarView10 = NBPPublishAvatarView.this;
                                                        nBPPublishStatusPanelView.attr(new Function1<NBPPublishStatusPanelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.statusPanel.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPPublishStatusPanelAttr nBPPublishStatusPanelAttr) {
                                                                nBPPublishStatusPanelAttr.viewModel = NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        actionSheetAttr2.mo113backgroundColor(h.INSTANCE.j());
                                        actionSheetAttr2.i(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.mo113backgroundColor(h.INSTANCE.j());
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
                                });
                                final NBPPublishAvatarView nBPPublishAvatarView8 = NBPPublishAvatarView.this;
                                actionSheetView2.event(new Function1<com.tencent.kuikly.core.views.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.d dVar) {
                                        final NBPPublishAvatarView nBPPublishAvatarView9 = NBPPublishAvatarView.this;
                                        dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView.body.1.6.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().setShowAvatarStatusPanel(false);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPPublishAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishAvatarEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        IPagerIdKtxKt.getNotifyModule(this).e("NBPPublishStatusPanelSelectStatus", this.notifyCallbackRef);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        this.notifyCallbackRef = k.b(IPagerIdKtxKt.getNotifyModule(this), "NBPPublishStatusPanelSelectStatus", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$viewDidLoad$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                final NBPPublishAvatarView nBPPublishAvatarView = NBPPublishAvatarView.this;
                TimerKt.c(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView$viewDidLoad$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NBPPublishAvatarView.access$getAttr(NBPPublishAvatarView.this).getViewModel().setShowAvatarStatusPanel(false);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 2, null);
    }
}
