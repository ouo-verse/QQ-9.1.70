package com.tencent.hippykotlin.demo.pages.nearby.debug;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.debug.NBPDebugSettings;
import com.tencent.hippykotlin.demo.pages.nearby.base.debug.NBPDebugSettingsKt;
import com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule;
import com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule$enterLocationPage$1;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.SwitchView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.bt;
import com.tencent.kuikly.core.views.bu;
import com.tencent.kuikly.core.views.bv;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.k;

/* loaded from: classes31.dex */
public final class NBPDebugSettingsPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPDebugSettingsPage.class, QCircleDaTongConstant.ElementParamValue.SETTINGS, "getSettings()Lcom/tencent/hippykotlin/demo/pages/nearby/base/debug/NBPDebugSettings;", 0)};
    public final ReadWriteProperty settings$delegate = c.a(new NBPDebugSettings(false, null, 3, null));

    public static final NBPDebugSettings access$getSettings(NBPDebugSettingsPage nBPDebugSettingsPage) {
        return (NBPDebugSettings) nBPDebugSettingsPage.settings$delegate.getValue(nBPDebugSettingsPage, $$delegatedProperties[0]);
    }

    public static final void access$updateMockLocation(final NBPDebugSettingsPage nBPDebugSettingsPage, boolean z16) {
        nBPDebugSettingsPage.getClass();
        if (!z16) {
            nBPDebugSettingsPage.save(new NBPDebugSettings(false, ((NBPDebugSettings) nBPDebugSettingsPage.settings$delegate.getValue(nBPDebugSettingsPage, $$delegatedProperties[0])).mockLocation));
            return;
        }
        final Function1<k, Unit> function1 = new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage$updateMockLocation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                NBPDebugSettingsPage nBPDebugSettingsPage2 = NBPDebugSettingsPage.this;
                NBPDebugSettingsPage.access$getSettings(nBPDebugSettingsPage2).getClass();
                nBPDebugSettingsPage2.save(new NBPDebugSettings(true, kVar));
                return Unit.INSTANCE;
            }
        };
        NBPPublishBridgeModule nBPPublishBridgeModule = (NBPPublishBridgeModule) com.tencent.kuikly.core.manager.c.f117352a.k(nBPDebugSettingsPage.getPagerId()).acquireModule("NBPPublishKuiklyModule");
        Function1<k, Unit> function12 = new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage$selectMockLocation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                function1.invoke(kVar);
                return Unit.INSTANCE;
            }
        };
        nBPPublishBridgeModule.getClass();
        nBPPublishBridgeModule.asyncToNativeMethod("enterLocationPage", new Object[0], new NBPPublishBridgeModule$enterLocationPage$1(function12));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        if (PageDataExtKt.isPublic(getPagerData())) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage$body$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPDebugSettingsPage nBPDebugSettingsPage = NBPDebugSettingsPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage$body$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NBPDebugSettingsPage.access$getSettings(NBPDebugSettingsPage.this);
                    }
                };
                final NBPDebugSettingsPage nBPDebugSettingsPage2 = NBPDebugSettingsPage.this;
                BindDirectivesViewKt.a(viewContainer, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage$body$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final NBPDebugSettings access$getSettings = NBPDebugSettingsPage.access$getSettings(NBPDebugSettingsPage.this);
                        final NBPDebugSettingsPage nBPDebugSettingsPage3 = NBPDebugSettingsPage.this;
                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionColumn();
                                        a.C5863a.a(tVar2, 20.0f + tVar2.getPagerData().getStatusBarHeight(), 20.0f, 0.0f, 20.0f, 4, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPDebugSettings nBPDebugSettings = NBPDebugSettings.this;
                                final NBPDebugSettingsPage nBPDebugSettingsPage4 = nBPDebugSettingsPage3;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u6a21\u62df\u4f4d\u7f6e");
                                                        ceVar2.marginRight(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPDebugSettings nBPDebugSettings2 = NBPDebugSettings.this;
                                        final NBPDebugSettingsPage nBPDebugSettingsPage5 = nBPDebugSettingsPage4;
                                        bv.a(vVar4, new Function1<SwitchView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(SwitchView switchView) {
                                                SwitchView switchView2 = switchView;
                                                final NBPDebugSettings nBPDebugSettings3 = NBPDebugSettings.this;
                                                switchView2.attr(new Function1<bt, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(bt btVar) {
                                                        btVar.l(NBPDebugSettings.this.enableMockLocation);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPDebugSettingsPage nBPDebugSettingsPage6 = nBPDebugSettingsPage5;
                                                switchView2.event(new Function1<bu, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(bu buVar) {
                                                        final NBPDebugSettingsPage nBPDebugSettingsPage7 = NBPDebugSettingsPage.this;
                                                        buVar.i(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.2.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                NBPDebugSettingsPage.access$updateMockLocation(NBPDebugSettingsPage.this, bool.booleanValue());
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
                                final NBPDebugSettings nBPDebugSettings2 = NBPDebugSettings.this;
                                if (nBPDebugSettings2.enableMockLocation) {
                                    final NBPDebugSettingsPage nBPDebugSettingsPage5 = nBPDebugSettingsPage3;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            final NBPDebugSettingsPage nBPDebugSettingsPage6 = NBPDebugSettingsPage.this;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPDebugSettingsPage nBPDebugSettingsPage7 = NBPDebugSettingsPage.this;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.3.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            NBPDebugSettingsPage.access$updateMockLocation(NBPDebugSettingsPage.this, true);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPDebugSettings nBPDebugSettings3 = nBPDebugSettings2;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final NBPDebugSettings nBPDebugSettings4 = NBPDebugSettings.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage.body.2.2.1.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            k kVar = NBPDebugSettings.this.mockLocation;
                                                            NBPSsoLocation nBPSsoLocation = kVar != null ? NBPDebugSettingsKt.toNBPSsoLocation(kVar) : null;
                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u56fd\u5bb6: ");
                                                            m3.append(nBPSsoLocation != null ? nBPSsoLocation.nation : null);
                                                            m3.append(" | \u57ce\u5e02 :");
                                                            m3.append(nBPSsoLocation != null ? nBPSsoLocation.city : null);
                                                            m3.append(" | \u4f4d\u7f6e: ");
                                                            m3.append(nBPSsoLocation != null ? nBPSsoLocation.name : null);
                                                            m3.append(" | \u5750\u6807: (");
                                                            m3.append(nBPSsoLocation != null ? Double.valueOf(nBPSsoLocation.lat02) : null);
                                                            m3.append(',');
                                                            m3.append(nBPSsoLocation != null ? Double.valueOf(nBPSsoLocation.lon02) : null);
                                                            m3.append(')');
                                                            ceVar2.text(m3.toString());
                                                            ceVar2.textDecorationUnderLine();
                                                            ceVar2.marginTop(6.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
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

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager, com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(super.createExternalModules());
        if (mutableMap != null) {
            mutableMap.put("NBPPublishKuiklyModule", new NBPPublishBridgeModule());
        }
        return mutableMap;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        NBPDebugSettings loadIfNotPublic = NBPDebugSettings.Companion.loadIfNotPublic(getPagerData());
        if (loadIfNotPublic == null) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        } else {
            this.settings$delegate.setValue(this, $$delegatedProperties[0], loadIfNotPublic);
        }
    }

    public final void save(NBPDebugSettings nBPDebugSettings) {
        e eVar = new e();
        eVar.w("enableMockLocation", nBPDebugSettings.enableMockLocation);
        k kVar = nBPDebugSettings.mockLocation;
        if (kVar != null) {
            eVar.v("mockLocation", i.c(kVar));
        }
        String eVar2 = eVar.toString();
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("save NBPDebugSettings ", eVar2, KLog.INSTANCE, "NBPDebugSettings");
        Utils.INSTANCE.cacheModule("").setItem("NBP_DEBUG_SETTINGS_CACHE_KEY", eVar2);
        this.settings$delegate.setValue(this, $$delegatedProperties[0], nBPDebugSettings);
    }
}
