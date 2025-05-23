package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NBPInteractivePageSource$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.MarkGreetRequest;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.SendGreetRequest;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import k35.j;
import k35.l;
import k35.r;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPInteractiveUserItemView extends ComposeView<NBPInteractiveUserItemViewAttr, NBPInteractiveUserItemViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveUserItemView.class, QCircleAlphaUserReporter.KEY_USER, "getUser()Lkuikly/com/tencent/trpcprotocol/lplan_ext/mood_svr/mood_svr/InteractUser;", 0)};
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public final ReadWriteProperty user$delegate = c.a(null);
    public String source = NBPInteractivePageSource$EnumUnboxingLocalUtility._getValue(2);
    public int mid = 1;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveUserItemViewAttr access$getAttr(NBPInteractiveUserItemView nBPInteractiveUserItemView) {
        return (NBPInteractiveUserItemViewAttr) nBPInteractiveUserItemView.getAttr();
    }

    public static final j access$getUser(NBPInteractiveUserItemView nBPInteractiveUserItemView) {
        return (j) nBPInteractiveUserItemView.user$delegate.getValue(nBPInteractiveUserItemView, $$delegatedProperties[0]);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(70.0f);
                        mVar2.positionRelative();
                        mVar2.alignItemsCenter();
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                        return Unit.INSTANCE;
                    }
                });
                final NBPInteractiveUserItemView nBPInteractiveUserItemView = NBPInteractiveUserItemView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final NBPInteractiveUserItemView nBPInteractiveUserItemView2 = NBPInteractiveUserItemView.this;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                af afVar2 = afVar;
                                afVar2.marginLeft(16.0f);
                                afVar2.size(32.0f, 32.0f);
                                afVar2.p();
                                afVar2.borderRadius(16.0f);
                                j access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                if (access$getUser != null && (str = access$getUser.f411558f) != null) {
                                    b.a.b(afVar2, str, false, 2, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveUserItemView nBPInteractiveUserItemView3 = NBPInteractiveUserItemView.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPInteractiveUserItemView nBPInteractiveUserItemView4 = NBPInteractiveUserItemView.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        j access$getUser;
                                        if (!NBPInteractiveUserItemView.this.fastClickUtils.isFastDoubleClick() && (access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this)) != null) {
                                            NBPJumpUtil.jumpPersonaPage$default(2, String.valueOf(access$getUser.f411556d), access$getUser.f411556d == UserDataManager.INSTANCE.getUserSelfInfo().tid, false, null, null, 56);
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
                final NBPInteractiveUserItemView nBPInteractiveUserItemView2 = NBPInteractiveUserItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginLeft(7.0f);
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveUserItemView nBPInteractiveUserItemView3 = NBPInteractiveUserItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPInteractiveUserItemView nBPInteractiveUserItemView4 = NBPInteractiveUserItemView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.m144maxWidth(NBPInteractiveUserItemView.this.getPagerData().m() - 145.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUserItemView nBPInteractiveUserItemView5 = NBPInteractiveUserItemView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPInteractiveUserItemView nBPInteractiveUserItemView6 = NBPInteractiveUserItemView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                String str2;
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                j access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                                if (access$getUser != null && (str2 = access$getUser.f411557e) != null) {
                                                    ceVar2.text(str2);
                                                }
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.textPostProcessor("emoji");
                                                ceVar2.fontWeight500();
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.textOverFlowTail();
                                                ceVar2.lines(1);
                                                j access$getUser2 = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                                if (access$getUser2 != null && (str = access$getUser2.D) != null) {
                                                    ceVar2.m144maxWidth(((NBPInteractiveUserItemView.this.getPagerData().m() - 145.0f) - (r0 * 14)) - (str.length() > 0 ? 10 : 0));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUserItemView nBPInteractiveUserItemView6 = NBPInteractiveUserItemView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPInteractiveUserItemView nBPInteractiveUserItemView7 = NBPInteractiveUserItemView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(10.0f);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                j access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                                if (access$getUser != null && (str = access$getUser.D) != null) {
                                                    ceVar2.text(str);
                                                }
                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                ceVar2.textPostProcessor("emoji");
                                                ceVar2.fontWeight400();
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.lines(1);
                                                ceVar2.textOverFlowTail();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveUserItemView nBPInteractiveUserItemView4 = NBPInteractiveUserItemView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPInteractiveUserItemView nBPInteractiveUserItemView5 = NBPInteractiveUserItemView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        List split$default;
                                        String take;
                                        String sb5;
                                        List take2;
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(2.0f);
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        j access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                        if (access$getUser != null) {
                                            NBPInteractiveUserItemView.this.getClass();
                                            StringBuilder sb6 = new StringBuilder();
                                            long j3 = access$getUser.f411559h;
                                            if (j3 <= 100) {
                                                sb5 = GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(new StringBuilder(), access$getUser.f411559h, 'm');
                                            } else {
                                                String valueOf = String.valueOf(((float) j3) / 1000.0f);
                                                split$default = StringsKt__StringsKt.split$default((CharSequence) valueOf, new String[]{"."}, false, 0, 6, (Object) null);
                                                if (split$default.size() < 2) {
                                                    sb5 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(valueOf, "km");
                                                } else {
                                                    StringBuilder sb7 = new StringBuilder();
                                                    sb7.append((String) split$default.get(0));
                                                    sb7.append('.');
                                                    take = StringsKt___StringsKt.take((String) split$default.get(1), 1);
                                                    sb7.append(take);
                                                    sb7.append("km");
                                                    sb5 = sb7.toString();
                                                }
                                            }
                                            sb6.append(sb5);
                                            StringBuilder sb8 = new StringBuilder();
                                            take2 = CollectionsKt___CollectionsKt.take(access$getUser.f411561m, 2);
                                            int i3 = 0;
                                            for (Object obj : take2) {
                                                int i16 = i3 + 1;
                                                if (i3 < 0) {
                                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                }
                                                sb8.append(((a) obj).f435363e);
                                                if (i3 != access$getUser.f411561m.size() - 1) {
                                                    sb8.append("\u00b7");
                                                }
                                                i3 = i16;
                                            }
                                            String sb9 = sb8.toString();
                                            if (sb9.length() > 0) {
                                                sb6.append("\u00b7");
                                                sb6.append(sb9);
                                            }
                                            sb6.append("\u00b7");
                                            NearbyFormatUtils nearbyFormatUtils = NearbyFormatUtils.INSTANCE;
                                            long j16 = access$getUser.f411560i * 1000;
                                            if (j16 == 0) {
                                                str = "";
                                            } else if (j16 >= NearbyFormatUtils.mYesterdayTime) {
                                                str = "\u4eca\u5929";
                                            } else if (j16 >= NearbyFormatUtils.mTwoDayAgoTime) {
                                                str = "\u6628\u5929";
                                            } else if (j16 >= NearbyFormatUtils.mThreeDayAgoTime) {
                                                str = "\u524d\u5929";
                                            } else {
                                                str = "\u4e09\u5929\u524d";
                                            }
                                            sb6.append(str);
                                            ceVar2.text(sb6.toString());
                                        }
                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                        ceVar2.textPostProcessor("emoji");
                                        ceVar2.fontWeight400();
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPInteractiveUserItemView nBPInteractiveUserItemView3 = NBPInteractiveUserItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPInteractiveUserItemView nBPInteractiveUserItemView4 = NBPInteractiveUserItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexWrapWrap();
                                tVar2.alignItemsCenter();
                                tVar2.marginRight(16.0f);
                                j access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                tVar2.m152visibility(access$getUser != null && access$getUser.G == 0);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveUserItemView nBPInteractiveUserItemView5 = NBPInteractiveUserItemView.this;
                        com.tencent.kuikly.core.views.compose.c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ButtonView buttonView) {
                                ButtonView buttonView2 = buttonView;
                                buttonView2.attr(new Function1<com.tencent.kuikly.core.views.compose.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.a aVar) {
                                        com.tencent.kuikly.core.views.compose.a aVar2 = aVar;
                                        aVar2.size(68.0f, 24.0f);
                                        aVar2.borderRadius(4.0f);
                                        aVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                        aVar2.alignItemsCenter();
                                        aVar2.m(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(14.0f, 14.0f);
                                                afVar2.alignSelfCenter();
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_nI5PsWB0PyO.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u8c22\u8c22TA");
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 10.5f, null, 2, null);
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUserItemView nBPInteractiveUserItemView6 = NBPInteractiveUserItemView.this;
                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                        com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                        final NBPInteractiveUserItemView nBPInteractiveUserItemView7 = NBPInteractiveUserItemView.this;
                                        bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                final j access$getUser = NBPInteractiveUserItemView.access$getUser(NBPInteractiveUserItemView.this);
                                                if (access$getUser != null) {
                                                    final NBPInteractiveUserItemView nBPInteractiveUserItemView8 = NBPInteractiveUserItemView.this;
                                                    if (!nBPInteractiveUserItemView8.fastClickUtils.isFastDoubleClick()) {
                                                        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$interact$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                bool.booleanValue();
                                                                NBPInteractiveUserItemView.access$sendMsg(NBPInteractiveUserItemView.this, access$getUser);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        Utils utils = Utils.INSTANCE;
                                                        if (Intrinsics.areEqual(utils.cacheModule("").getItem("InteractiveMsgAlertFlag"), "1")) {
                                                            function1.invoke(Boolean.TRUE);
                                                        } else {
                                                            QQNearbyModule.Companion.getInstance().asyncToNativeMethod("showInteractiveMsgAlert", (e) null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$showAlert$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(e eVar) {
                                                                    e eVar2 = eVar;
                                                                    if (eVar2 != null && eVar2.j("result") == 0) {
                                                                        function1.invoke(Boolean.TRUE);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            utils.cacheModule("").setItem("InteractiveMsgAlertFlag", "1");
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPInteractiveUserItemView nBPInteractiveUserItemView8 = NBPInteractiveUserItemView.this;
                                        VisibilityEventKt.b(bVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.4.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractiveUserItemView.access$getAttr(NBPInteractiveUserItemView.this).viewModel;
                                                if (nBPInteractiveViewModel != null) {
                                                    NBPInteractiveUserItemView nBPInteractiveUserItemView9 = NBPInteractiveUserItemView.this;
                                                    nBPInteractiveViewModel.reportInteractive("dt_imp", "em_nearby_interaction_btn", nBPInteractiveUserItemView9.source, Integer.valueOf(nBPInteractiveUserItemView9.mid));
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
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m140flex(1.0f);
                                tVar2.m138bottom(0.0f);
                                tVar2.m142left(16.0f);
                                tVar2.mo141height(0.5f);
                                tVar2.mo153width(tVar2.getPagerData().m() - 32.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
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
        return new NBPInteractiveUserItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPInteractiveUserItemViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        com.tencent.kuikly.core.reactive.collection.c<j> userList;
        super.created();
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        this.source = cVar.g().getPageData().n().q("source", "1");
        this.mid = cVar.g().getPageData().n().j("mid");
        NBPInteractiveViewModel nBPInteractiveViewModel = ((NBPInteractiveUserItemViewAttr) getAttr()).viewModel;
        this.user$delegate.setValue(this, $$delegatedProperties[0], (nBPInteractiveViewModel == null || (userList = nBPInteractiveViewModel.getUserList()) == null) ? null : userList.get(((NBPInteractiveUserItemViewAttr) getAttr()).index));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$sendMsg(final NBPInteractiveUserItemView nBPInteractiveUserItemView, final j jVar) {
        NBPInteractiveViewModel nBPInteractiveViewModel = ((NBPInteractiveUserItemViewAttr) nBPInteractiveUserItemView.getAttr()).viewModel;
        if (nBPInteractiveViewModel != null) {
            nBPInteractiveViewModel.reportInteractive("dt_clck", "em_nearby_interaction_btn", nBPInteractiveUserItemView.source, Integer.valueOf(nBPInteractiveUserItemView.mid));
        }
        nBPInteractiveUserItemView.user$delegate.setValue(nBPInteractiveUserItemView, $$delegatedProperties[0], new j(jVar.f411556d, jVar.f411557e, jVar.f411558f, jVar.f411559h, jVar.f411560i, jVar.f411561m, jVar.C, jVar.D, jVar.E, jVar.F, 1));
        String str = jVar.F;
        KLog.INSTANCE.i("NBPInteractiveRepo", "mark greet req:" + str);
        MarkGreetRequest markGreetRequest = new MarkGreetRequest(str);
        final Function1 function1 = null;
        Function1<PbResponse<l>, Unit> function12 = new Function1<PbResponse<l>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$markGreet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<l> pbResponse) {
                PbResponse<l> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mark greet result: ");
                m3.append(pbResponse2.code);
                m3.append(", ");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPInteractiveRepo");
                if (pbResponse2.success) {
                    Function1<Boolean, Unit> function13 = function1;
                    if (function13 != null) {
                        function13.invoke(Boolean.TRUE);
                    }
                } else {
                    Function1<Boolean, Unit> function14 = function1;
                    if (function14 != null) {
                        function14.invoke(Boolean.FALSE);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoMarkGreet");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(markGreetRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
        QQNearbyModule companion2 = QQNearbyModule.Companion.getInstance();
        String valueOf = String.valueOf(jVar.f411556d);
        final Function1<byte[], Unit> function13 = new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$sendMsg$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(byte[] bArr) {
                byte[] bArr2 = bArr;
                if (bArr2 != null) {
                    final j jVar2 = j.this;
                    NBPInteractiveUserItemView nBPInteractiveUserItemView2 = nBPInteractiveUserItemView;
                    long j3 = jVar2.f411556d;
                    int i3 = nBPInteractiveUserItemView2.mid;
                    final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView$sendMsg$1$1$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Integer num, String str2) {
                            int intValue = num.intValue();
                            String str3 = str2;
                            if (intValue == 0) {
                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u6d88\u606f\u5df2\u53d1\u9001", QToastMode.Success);
                            } else {
                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str3, QToastMode.Warning);
                                if (intValue == 73 || intValue == 74 || intValue == 75) {
                                    QQNearbyModule companion3 = QQNearbyModule.Companion.getInstance();
                                    String valueOf2 = String.valueOf(j.this.f411556d);
                                    companion3.getClass();
                                    e eVar = new e();
                                    eVar.v("peerUid", valueOf2);
                                    eVar.v("msg", str3);
                                    Unit unit = Unit.INSTANCE;
                                    companion3.asyncToNativeMethod("addLocalJsonGrayTipMsg", eVar, (Function1<? super e, Unit>) null);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    KLog.INSTANCE.i("NBPInteractiveRepo", "send greet peerTid:" + j3 + ", mid:" + i3);
                    SendGreetRequest sendGreetRequest = new SendGreetRequest(j3, bArr2, i3);
                    Function1<PbResponse<r>, Unit> function14 = new Function1<PbResponse<r>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$sendGreet$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PbResponse<r> pbResponse) {
                            PbResponse<r> pbResponse2 = pbResponse;
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("send greet result: ");
                            m3.append(pbResponse2.code);
                            m3.append(", ");
                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPInteractiveRepo");
                            Function2<Integer, String, Unit> function22 = function2;
                            if (function22 != null) {
                                function22.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    APICallTechReporter aPICallTechReporter2 = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoSendGreet");
                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(sendGreetRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter2, function14), 6);
                }
                return Unit.INSTANCE;
            }
        };
        companion2.getClass();
        companion2.asyncToNativeMethod("signatureForNBPAIO", new Object[]{valueOf}, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$signatureForNBPAIO$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                if (obj != null && (obj instanceof byte[])) {
                    function13.invoke(obj);
                } else {
                    function13.invoke(null);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
