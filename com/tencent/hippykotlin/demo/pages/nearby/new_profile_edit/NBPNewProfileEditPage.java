package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit;

import c01.c;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.TagListAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.EditStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.SliderView;
import com.tencent.kuikly.core.views.SwitchView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.bp;
import com.tencent.kuikly.core.views.br;
import com.tencent.kuikly.core.views.bt;
import com.tencent.kuikly.core.views.bu;
import com.tencent.kuikly.core.views.bv;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import s35.d;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPNewProfileEditPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewProfileEditPage.class, "progress", "getProgress()F", 0)};
    public int appId;
    public final Lazy editViewModel$delegate;
    public final FastClickUtils fastClickUtils;
    public final ReadWriteProperty progress$delegate;
    public String userSelfInfoChangeNotifyRef;

    public NBPNewProfileEditPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<NBPNewEditViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$editViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPNewEditViewModel invoke() {
                return new NBPNewEditViewModel(NBPNewProfileEditPage.this.appId, 0);
            }
        });
        this.editViewModel$delegate = lazy;
        this.progress$delegate = c.a(Float.valueOf(0.0f));
        this.fastClickUtils = new FastClickUtils(500L);
    }

    public static final e access$getDTPageParam(NBPNewProfileEditPage nBPNewProfileEditPage) {
        nBPNewProfileEditPage.getClass();
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.t("nearby_kl_appid", nBPNewProfileEditPage.appId);
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_profile_setting");
        e eVar = new e();
        eVar.t("nearby_kl_appid", nBPNewProfileEditPage.appId);
        Unit unit = Unit.INSTANCE;
        nearbyDTBaseParams.v("cur_pg", eVar);
        return nearbyDTBaseParams;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.getPager().getPageData().getIsIOS();
                final NBPNewProfileEditPage nBPNewProfileEditPage = NBPNewProfileEditPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().getNavigationBarHeight());
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewProfileEditPage nBPNewProfileEditPage2 = NBPNewProfileEditPage.this;
                        final float f16 = 44.0f;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final float f17 = f16;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.mo141height(f17);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f18 = f16;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final float f19 = f18;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(36.0f, 36.0f);
                                                tVar2.positionAbsolute();
                                                tVar2.m142left(20.0f);
                                                tVar2.m150top((f19 - 36) / 2);
                                                tVar2.allCenter();
                                                tVar2.borderRadius(18.0f);
                                                tVar2.mo113backgroundColor(new h(0L, 0.2f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(24.0f, 24.0f);
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_tYDNTg8cDk5.png", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage3 = nBPNewProfileEditPage2;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPNewProfileEditPage nBPNewProfileEditPage4 = NBPNewProfileEditPage.this;
                                        KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                        return Float.valueOf(nBPNewProfileEditPage4.getProgress());
                                    }
                                };
                                final NBPNewProfileEditPage nBPNewProfileEditPage4 = nBPNewProfileEditPage2;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage5 = NBPNewProfileEditPage.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(180.0f, 44.0f);
                                                        tVar2.allCenter();
                                                        tVar2.borderRadius(25.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                                        tVar2.flexDirectionColumn();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.fontWeight500();
                                                                NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, "text_primary");
                                                                NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                if (nBPNewProfileEditPage8.getProgress() < 0.5f) {
                                                                    str = "\u5b8c\u6210\u5ea6\u8d8a\u9ad8\uff0c\u5339\u914d\u7387\u8d8a\u9ad8\u54e6";
                                                                } else if (nBPNewProfileEditPage8.getProgress() < 1.0f) {
                                                                    str = "\u518d\u4e30\u5bcc\u4e00\u4e9b\uff0c\u5c55\u793a\u4f60\u7684\u9b45\u529b\u5427";
                                                                } else {
                                                                    if (nBPNewProfileEditPage8.getProgress() == 1.0f) {
                                                                        str = "\u592a\u68d2\u4e86\uff0c\u8d44\u6599\u5b8c\u6210\u5ea6100%";
                                                                    } else {
                                                                        str = "\u65e0\u6548\u7684\u8fdb\u5ea6\u503c";
                                                                    }
                                                                }
                                                                ceVar2.text(str);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                                br.a(vVar6, new Function1<SliderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(SliderView sliderView) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                                        sliderView.attr(new Function1<bp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(bp bpVar) {
                                                                bp bpVar2 = bpVar;
                                                                bpVar2.mo153width(130.0f);
                                                                bpVar2.mo141height(3.0f);
                                                                bpVar2.marginTop(5.0f);
                                                                NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                bpVar2.h(nBPNewProfileEditPage9.getProgress());
                                                                bpVar2.M(new h(0, 0, 0, 0.08f));
                                                                bpVar2.K(h.INSTANCE.j());
                                                                bpVar2.borderRadius(19.0f);
                                                                bpVar2.A(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.3.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                        viewContainer3.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.2.2.4.1.3.1.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(m mVar) {
                                                                                m mVar2 = mVar;
                                                                                mVar2.mo141height(3.0f);
                                                                                mVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4294919538L), 0.0f), new j(new h(4294955343L), 1.0f));
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
                final NBPNewProfileEditPage nBPNewProfileEditPage2 = NBPNewProfileEditPage.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                aoVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewProfileEditPage nBPNewProfileEditPage3 = NBPNewProfileEditPage.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(80.0f, 80.0f);
                                        tVar2.marginTop(15.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.allCenter();
                                        tVar2.marginLeft((tVar2.getPagerData().m() - 80) / 2);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage4 = NBPNewProfileEditPage.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage5 = NBPNewProfileEditPage.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(80.0f, 80.0f);
                                                afVar2.borderRadius(40.0f);
                                                NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                if (nBPNewProfileEditPage6.getEditViewModel().getEditStatus() == EditStatus.AFTER) {
                                                    b.a.b(afVar2, NBPNewProfileEditPage.this.getEditViewModel().avatar, false, 2, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.positionAbsolute();
                                                afVar2.m149right(7.0f);
                                                afVar2.m138bottom(0.0f);
                                                afVar2.size(20.0f, 20.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gZOrKlBitcG.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage5 = NBPNewProfileEditPage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (!NBPNewProfileEditPage.this.fastClickUtils.isFastDoubleClick()) {
                                                    e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                    access$getDTPageParam.v("dt_eid", "em_nearby_kl_avatar");
                                                    access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
                                                    String str = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_profile_avatar_edit&modal_mode=1&appid=" + NBPNewProfileEditPage.this.appId;
                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewProfileEditPage nBPNewProfileEditPage4 = NBPNewProfileEditPage.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m() - 32, 168.0f);
                                        tVar2.marginTop(15.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage5 = NBPNewProfileEditPage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.size(tVar2.getPagerData().m() - 32.0f, 56.0f);
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentSpaceBetween();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        if (!NBPNewProfileEditPage.this.fastClickUtils.isFastDoubleClick()) {
                                                            e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                            access$getDTPageParam.v("dt_eid", "em_nearby_kl_nickname");
                                                            access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
                                                            NBPJumpUtil.jumpNickEditPage$default(NBPNewProfileEditPage.this.appId, NBPNewProfileEditPage.this.getEditViewModel().nickname, 4);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.positionAbsolute();
                                                        tVar2.m142left((tVar2.getPagerData().m() - 32.0f) / 20);
                                                        tVar2.m150top(56.0f);
                                                        tVar2.size(((tVar2.getPagerData().m() - 32.0f) / 10) * 9, 0.5f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u6635\u79f0");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.fontWeight400();
                                                        ceVar2.marginLeft(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.5.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionRow();
                                                        tVar2.marginRight(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.5.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.5.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.lines(1);
                                                                ceVar2.m144maxWidth(200.0f);
                                                                ceVar2.textAlignRight();
                                                                NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                if (nBPNewProfileEditPage10.getEditViewModel().getEditStatus() == EditStatus.AFTER) {
                                                                    ceVar2.text(NBPNewProfileEditPage.this.getEditViewModel().nickname);
                                                                }
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                ceVar2.fontWeight400();
                                                                ceVar2.marginLeft(14.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.5.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.2.5.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_right", new h(4287401100L)), false, 2, null);
                                                                afVar2.size(16.0f, 16.0f);
                                                                afVar2.marginLeft(4.0f);
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
                                final NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.size(tVar2.getPagerData().m() - 32.0f, 56.0f);
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentSpaceBetween();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                        access$getDTPageParam.v("dt_eid", "em_nearby_kl_gender");
                                                        access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                        if (!nBPNewProfileEditPage9.fastClickUtils.isFastDoubleClick()) {
                                                            int i3 = nBPNewProfileEditPage9.getEditViewModel().gender;
                                                            int i16 = 1;
                                                            if (i3 == 1) {
                                                                i16 = 0;
                                                            } else if (i3 != 2) {
                                                                i16 = -1;
                                                            }
                                                            QQNearbyModule.Companion.getInstance().showKLGenderPicker(i16, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$showGenderPicker$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Integer num) {
                                                                    Integer num2 = num;
                                                                    NBPNewEditViewModel nBPNewEditViewModel = new NBPNewEditViewModel(NBPNewProfileEditPage.this.appId, 7);
                                                                    final NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                                    if (num2 != null) {
                                                                        nBPNewEditViewModel.save(new s35.af(null, 0L, null, 0, null, num2.intValue(), null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -33, 255), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$showGenderPicker$1$1$1$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Boolean bool) {
                                                                                if (bool.booleanValue()) {
                                                                                    NBPNewProfileEditPage nBPNewProfileEditPage11 = NBPNewProfileEditPage.this;
                                                                                    KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                                    nBPNewProfileEditPage11.calculateProgress();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
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
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.positionAbsolute();
                                                        tVar2.m142left((tVar2.getPagerData().m() - 32.0f) / 20);
                                                        tVar2.m150top(56.0f);
                                                        tVar2.size(((tVar2.getPagerData().m() - 32.0f) / 10) * 9, 0.5f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u6027\u522b");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.fontWeight400();
                                                        ceVar2.marginLeft(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.5.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionRow();
                                                        tVar2.marginRight(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.5.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.5.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                NBPNewProfileEditPage nBPNewProfileEditPage11 = NBPNewProfileEditPage.this;
                                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                if (nBPNewProfileEditPage11.getEditViewModel().getEditStatus() == EditStatus.AFTER) {
                                                                    int i3 = NBPNewProfileEditPage.this.getEditViewModel().gender;
                                                                    if (i3 == 1) {
                                                                        str = "\u7537";
                                                                    } else if (i3 != 2) {
                                                                        str = "";
                                                                    } else {
                                                                        str = "\u5973";
                                                                    }
                                                                    ceVar2.text(str);
                                                                }
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                ceVar2.fontWeight400();
                                                                ceVar2.marginLeft(14.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.5.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.3.5.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_right", new h(4287401100L)), false, 2, null);
                                                                afVar2.size(16.0f, 16.0f);
                                                                afVar2.marginLeft(4.0f);
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
                                final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.size(tVar2.getPagerData().m() - 32.0f, 56.0f);
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentSpaceBetween();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                        if (!nBPNewProfileEditPage10.fastClickUtils.isFastDoubleClick()) {
                                                            int i3 = nBPNewProfileEditPage10.getEditViewModel().year;
                                                            int i16 = nBPNewProfileEditPage10.getEditViewModel().month;
                                                            int i17 = nBPNewProfileEditPage10.getEditViewModel().day;
                                                            if (i3 == 0 && i16 == 0 && i17 == 0) {
                                                                ICalendar c16 = com.tencent.kuikly.core.module.b.c((com.tencent.kuikly.core.module.b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null);
                                                                int c17 = c16.c(ICalendar.Field.YEAR);
                                                                int c18 = c16.c(ICalendar.Field.MONTH);
                                                                i17 = c16.c(ICalendar.Field.DAY_OF_MONTH);
                                                                i3 = c17;
                                                                i16 = c18;
                                                            }
                                                            QQNearbyModule.Companion.getInstance().showKLDatePicker(i3, i16, i17, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$showDatePicker$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(e eVar) {
                                                                    e eVar2 = eVar;
                                                                    if (eVar2 != null) {
                                                                        final NBPNewProfileEditPage nBPNewProfileEditPage11 = NBPNewProfileEditPage.this;
                                                                        new NBPNewEditViewModel(nBPNewProfileEditPage11.appId, 3).save(new s35.af(null, 0L, null, 0, eVar2.p(LpReport_UserInfo_dc02148.CONSTELLATION), 0, new d(eVar2.j("year"), eVar2.j("month"), eVar2.j("day")), null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -81, 255), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$showDatePicker$1$1$1$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Boolean bool) {
                                                                                if (bool.booleanValue()) {
                                                                                    NBPNewProfileEditPage nBPNewProfileEditPage12 = NBPNewProfileEditPage.this;
                                                                                    KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                                    nBPNewProfileEditPage12.calculateProgress();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                        access$getDTPageParam.v("dt_eid", "em_nearby_kl_constellation");
                                                        access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u661f\u5ea7");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.fontWeight400();
                                                        ceVar2.marginLeft(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionRow();
                                                        tVar2.marginRight(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage11 = NBPNewProfileEditPage.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                NBPNewProfileEditPage nBPNewProfileEditPage12 = NBPNewProfileEditPage.this;
                                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                if (nBPNewProfileEditPage12.getEditViewModel().getEditStatus() == EditStatus.AFTER) {
                                                                    ceVar2.text(NBPNewProfileEditPage.this.getEditViewModel().constellation);
                                                                }
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                ceVar2.fontWeight400();
                                                                ceVar2.marginLeft(14.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.4.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.3.4.4.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_right", new h(4287401100L)), false, 2, null);
                                                                afVar2.size(16.0f, 16.0f);
                                                                afVar2.marginLeft(4.0f);
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
                        });
                        final NBPNewProfileEditPage nBPNewProfileEditPage5 = NBPNewProfileEditPage.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m() - 32);
                                        tVar2.marginTop(16.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(20.0f);
                                                ceVar2.marginLeft(16.0f);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.text("\u4ea4\u53cb\u5ba3\u8a00");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                        KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                        boolean z16 = false;
                                        if (nBPNewProfileEditPage7.getEditViewModel().getEditStatus() == EditStatus.AFTER) {
                                            if (NBPNewProfileEditPage.this.getEditViewModel().declaration.length() > 0) {
                                                z16 = true;
                                            }
                                        }
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.margin(16.0f);
                                                        ceVar2.lines(3);
                                                        ceVar2.fontWeight400();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.lineSpacing(5.0f);
                                                        ceVar2.color(new h(4287401100L));
                                                        NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                        KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                        ceVar2.text(nBPNewProfileEditPage10.getEditViewModel().declaration);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.margin(16.0f);
                                                        tVar2.flexDirectionRow();
                                                        tVar2.mo141height(22.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(15.0f, 15.0f);
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9neOGptQ8ao.png", false, 2, null);
                                                                afVar2.t(new h(4287401100L));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.5.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(5.0f);
                                                                ceVar2.fontWeight400();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.lineSpacing(5.0f);
                                                                ceVar2.color(new h(4287401100L));
                                                                ceVar2.text("\u586b\u5199\u4ea4\u53cb\u5ba3\u8a00\uff0c\u5339\u914d\u7387\u63d0\u9ad850%");
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
                                final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.4.6.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (!NBPNewProfileEditPage.this.fastClickUtils.isFastDoubleClick()) {
                                                    NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                    nBPNewProfileEditPage10.getClass();
                                                    Utils utils = Utils.INSTANCE;
                                                    String base64Code = utils.currentBridgeModule().base64Code(nBPNewProfileEditPage10.getEditViewModel().declaration, true);
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_manifesto_edit&appid=");
                                                    m3.append(nBPNewProfileEditPage10.appId);
                                                    m3.append("&declaration=");
                                                    m3.append(base64Code);
                                                    m3.append("&custom_back_pressed=1&custom_back_pressed_ios=1");
                                                    String sb5 = m3.toString();
                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                                                    e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                    access$getDTPageParam.v("dt_eid", "em_nearby_kl_pal_declaration");
                                                    access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    utils.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewProfileEditPage nBPNewProfileEditPage6 = NBPNewProfileEditPage.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m() - 32);
                                        tVar2.marginTop(16.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPHomePageBaseViewModel.Companion companion = NBPHomePageBaseViewModel.Companion;
                                                NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                                companion.openTagEditPage(nBPNewProfileEditPage9.appId, nBPNewProfileEditPage9.getEditViewModel().getTags());
                                                e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                access$getDTPageParam.v("dt_eid", "em_nearby_kl_tag");
                                                access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(20.0f);
                                                ceVar2.marginLeft(16.0f);
                                                ceVar2.marginBottom(10.0f);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.text("\u5174\u8da3\u6807\u7b7e");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                vVar2.addChild(new NBPTagList(), new Function1<NBPTagList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPTagList nBPTagList) {
                                        final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                        nBPTagList.attr(new Function1<TagListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.5.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TagListAttr tagListAttr) {
                                                TagListAttr tagListAttr2 = tagListAttr;
                                                tagListAttr2.mo153width(tagListAttr2.getPagerData().m() - 52);
                                                tagListAttr2.margin(0.0f, 0.0f, 9.0f, 0.0f);
                                                tagListAttr2.alignSelfCenter();
                                                tagListAttr2.lastTagIMG = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_WQAhgtyLgax.png";
                                                tagListAttr2.lastTagTex = "\u6dfb\u52a0\u6807\u7b7e";
                                                NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                if (nBPNewProfileEditPage10.getEditViewModel().getEditStatus() == EditStatus.AFTER) {
                                                    tagListAttr2.tags$delegate.setValue(tagListAttr2, TagListAttr.$$delegatedProperties[0], NBPNewProfileEditPage.this.getEditViewModel().getTags());
                                                }
                                                tagListAttr2.isSelf = true;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewProfileEditPage nBPNewProfileEditPage7 = NBPNewProfileEditPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                return Boolean.valueOf(nBPNewProfileEditPage8.getEditViewModel().appId == 2);
                            }
                        };
                        final NBPNewProfileEditPage nBPNewProfileEditPage8 = NBPNewProfileEditPage.this;
                        ConditionViewKt.c(aqVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPNewProfileEditPage nBPNewProfileEditPage9 = NBPNewProfileEditPage.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(tVar2.getPagerData().m() - 32);
                                                tVar2.mo141height(56.0f);
                                                tVar2.marginTop(16.0f);
                                                tVar2.marginLeft(16.0f);
                                                tVar2.marginBottom(20.0f);
                                                tVar2.borderRadius(8.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                                tVar2.alignItemsCenter();
                                                tVar2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage10 = NBPNewProfileEditPage.this;
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPNewProfileEditPage nBPNewProfileEditPage11 = NBPNewProfileEditPage.this;
                                                VisibilityEventKt.b(uVar, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        String str;
                                                        NBPNewProfileEditPage nBPNewProfileEditPage12 = NBPNewProfileEditPage.this;
                                                        KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                        NBPNewEditViewModel editViewModel = nBPNewProfileEditPage12.getEditViewModel();
                                                        if (((Boolean) editViewModel.likesOnlySelf$delegate.getValue(editViewModel, NBPNewEditViewModel.$$delegatedProperties[2])).booleanValue()) {
                                                            str = "0";
                                                        } else {
                                                            str = "1";
                                                        }
                                                        e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                        access$getDTPageParam.v("dt_eid", "em_nearby_kl_like_open");
                                                        access$getDTPageParam.v("nearby_kl_after_click_state", str);
                                                        access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", access$getDTPageParam);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(16.0f);
                                                        ceVar2.text("\u516c\u5f00\u6211\u7684\u70b9\u8d5e");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewProfileEditPage nBPNewProfileEditPage11 = NBPNewProfileEditPage.this;
                                        bv.a(vVar2, new Function1<SwitchView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(SwitchView switchView) {
                                                SwitchView switchView2 = switchView;
                                                final NBPNewProfileEditPage nBPNewProfileEditPage12 = NBPNewProfileEditPage.this;
                                                switchView2.attr(new Function1<bt, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(bt btVar) {
                                                        bt btVar2 = btVar;
                                                        btVar2.marginRight(20.0f);
                                                        NBPNewProfileEditPage nBPNewProfileEditPage13 = NBPNewProfileEditPage.this;
                                                        KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                        NBPNewEditViewModel editViewModel = nBPNewProfileEditPage13.getEditViewModel();
                                                        btVar2.l(!((Boolean) editViewModel.likesOnlySelf$delegate.getValue(editViewModel, NBPNewEditViewModel.$$delegatedProperties[2])).booleanValue());
                                                        btVar2.n(QUIToken.color$default("brand_standard"));
                                                        btVar2.p(QUIToken.color$default("on_brand_primary"));
                                                        btVar2.marginLeft(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPNewProfileEditPage nBPNewProfileEditPage13 = NBPNewProfileEditPage.this;
                                                switchView2.event(new Function1<bu, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.5.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(bu buVar) {
                                                        final NBPNewProfileEditPage nBPNewProfileEditPage14 = NBPNewProfileEditPage.this;
                                                        buVar.i(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage.body.1.3.7.1.5.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                String str;
                                                                boolean booleanValue = bool.booleanValue();
                                                                NBPNewProfileEditPage nBPNewProfileEditPage15 = NBPNewProfileEditPage.this;
                                                                final boolean z16 = !booleanValue;
                                                                KProperty<Object>[] kPropertyArr = NBPNewProfileEditPage.$$delegatedProperties;
                                                                nBPNewProfileEditPage15.getClass();
                                                                new NBPNewEditViewModel(nBPNewProfileEditPage15.appId, 34).save(new s35.af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, z16, false, -1, 223), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$changeLikesOnlySelfLimit$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Boolean bool2) {
                                                                        boolean booleanValue2 = bool2.booleanValue();
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Publicly liked by me: ");
                                                                        m3.append(z16);
                                                                        m3.append(", Completed: ");
                                                                        m3.append(booleanValue2);
                                                                        kLog.i("NBPNewProfileEditPage", m3.toString());
                                                                        if (booleanValue2) {
                                                                            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                                                                            e eVar = new e();
                                                                            eVar.w("likesOnlySelf", z16);
                                                                            Unit unit = Unit.INSTANCE;
                                                                            k.d(kVar, "NEARBY_CHANGE_LIKE_LIST_VISIBLE", eVar, false, 4, null);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                if (booleanValue) {
                                                                    str = "1";
                                                                } else {
                                                                    str = "0";
                                                                }
                                                                e access$getDTPageParam = NBPNewProfileEditPage.access$getDTPageParam(NBPNewProfileEditPage.this);
                                                                access$getDTPageParam.v("dt_eid", "em_nearby_kl_like_open");
                                                                access$getDTPageParam.v("nearby_kl_after_click_state", str);
                                                                access$getDTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTPageParam);
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public final void calculateProgress() {
        this.progress$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(NearbyProUtilsKt.doCalculateProgress(getEditViewModel().avatar.length() > 0, getEditViewModel().nickname.length() > 0, getEditViewModel().gender, getEditViewModel().constellation.length() > 0, getEditViewModel().declaration.length() > 0, getEditViewModel().getTags().size(), getEditViewModel().completedTacitCount)));
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("calculate progress: ");
        m3.append(getProgress());
        kLog.i("NBPNewProfileEditPage", m3.toString());
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.appId = getPageData().n().j("appid");
        if (getPagerData().n().a("avatar") && getPagerData().n().a("nick")) {
            NBPNewEditViewModel editViewModel = getEditViewModel();
            g pageData = getPageData();
            editViewModel.getClass();
            editViewModel.avatar = pageData.n().p("avatar");
            pageData.n().p("dress_border");
            Utils utils = Utils.INSTANCE;
            editViewModel.nickname = utils.currentBridgeModule().base64Code(pageData.n().p("nick"), false);
            editViewModel.gender = pageData.n().j("gender");
            editViewModel.declaration = utils.currentBridgeModule().base64Code(pageData.n().p("declaration"), false);
            editViewModel.constellation = pageData.n().p(LpReport_UserInfo_dc02148.CONSTELLATION);
            editViewModel.year = pageData.n().j("year");
            editViewModel.month = pageData.n().j("month");
            editViewModel.day = pageData.n().j("day");
            editViewModel.likesOnlySelf$delegate.setValue(editViewModel, NBPNewEditViewModel.$$delegatedProperties[2], Boolean.valueOf(pageData.n().f("likes_only_self")));
            editViewModel.getTags().addAll(NBPNewHomeRepository.INSTANCE.decodeTags(pageData.n().l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS)));
            editViewModel.completedTacitCount = pageData.n().j("completed_tacit_count");
            editViewModel.setEditStatus(EditStatus.AFTER);
        } else {
            NBPNewHomeRepository.fetchUserInfo$default(this.appId, this.appId == 1 ? 0 : 2, getPageData().n().p("tinyid"), new Function1<s35.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$created$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(s35.af afVar) {
                    int collectionSizeOrDefault;
                    s35.af afVar2 = afVar;
                    NBPNewEditViewModel editViewModel2 = NBPNewProfileEditPage.this.getEditViewModel();
                    editViewModel2.getClass();
                    editViewModel2.avatar = afVar2.E;
                    editViewModel2.nickname = afVar2.f433209f;
                    editViewModel2.gender = afVar2.f433218m;
                    editViewModel2.declaration = afVar2.F;
                    editViewModel2.constellation = afVar2.f433214i;
                    d dVar = afVar2.C;
                    if (dVar != null) {
                        editViewModel2.year = dVar.f433229d;
                    }
                    if (dVar != null) {
                        editViewModel2.month = dVar.f433230e;
                    }
                    if (dVar != null) {
                        editViewModel2.day = dVar.f433231f;
                    }
                    com.tencent.kuikly.core.reactive.collection.c<TagInfo> tags = editViewModel2.getTags();
                    List<a> list = afVar2.I;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new TagInfo((a) it.next()));
                    }
                    tags.addAll(arrayList);
                    editViewModel2.completedTacitCount = 0;
                    editViewModel2.setEditStatus(EditStatus.AFTER);
                    return Unit.INSTANCE;
                }
            }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$created$2
                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    num.intValue();
                    return Unit.INSTANCE;
                }
            });
        }
        new NBPTagsEditViewModel(this.appId);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$created$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPNewProfileEditPage nBPNewProfileEditPage = NBPNewProfileEditPage.this;
                nBPNewProfileEditPage.getClass();
                nBPNewProfileEditPage.userSelfInfoChangeNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPNewProfileEditPage), "onNearbyProUserInfoChange", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage$addUserSelfInfoChangeEvent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("on user info change: ", eVar2, KLog.INSTANCE, "NBPNewProfileEditPage");
                        if (eVar2 != null) {
                            NBPNewEditViewModel editViewModel2 = NBPNewProfileEditPage.this.getEditViewModel();
                            editViewModel2.setEditStatus(EditStatus.PREV);
                            int j3 = eVar2.j("itemId");
                            if (j3 == 1) {
                                editViewModel2.avatar = eVar2.p("value");
                            } else if (j3 == 2) {
                                editViewModel2.nickname = eVar2.p("value");
                            } else if (j3 == 3) {
                                editViewModel2.constellation = eVar2.p("value");
                                editViewModel2.year = eVar2.j("year");
                                editViewModel2.month = eVar2.j("month");
                                editViewModel2.day = eVar2.j("day");
                            } else if (j3 == 6) {
                                editViewModel2.declaration = eVar2.p("value");
                            } else if (j3 == 7) {
                                editViewModel2.gender = eVar2.j("value");
                            } else if (j3 == 9) {
                                editViewModel2.getTags().clear();
                                editViewModel2.getTags().addAll(NBPNewHomeRepository.INSTANCE.decodeTags(eVar2.l("value")));
                            }
                            editViewModel2.setEditStatus(EditStatus.AFTER);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1, function0);
    }

    public final NBPNewEditViewModel getEditViewModel() {
        return (NBPNewEditViewModel) this.editViewModel$delegate.getValue();
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        calculateProgress();
        KLog.INSTANCE.i("NBPNewProfileEditPage", "pageDidAppear");
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        String str = this.userSelfInfoChangeNotifyRef;
        if (str != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onNearbyProUserInfoChange", str);
        }
        reportPageExposure(false);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        reportPageExposure(true);
    }

    public final void reportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_profile_setting");
        m3.t("nearby_kl_appid", this.appId);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, m3);
    }
}
