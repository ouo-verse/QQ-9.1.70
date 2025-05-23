package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit;

import c01.c;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsLoadingAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsLoadingView;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagsAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagsEvent;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagListAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPSetProfileTagEditPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPSetProfileTagEditPage.class, "showMask", "getShowMask()Z", 0)};
    public aa<NBPAllTagListView> allTagsViewRef;
    public int appId;
    public final ReadWriteProperty showMask$delegate = c.a(Boolean.FALSE);
    public NBPTagsEditViewModel viewModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage = NBPSetProfileTagEditPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                tVar2.paddingTop(tVar2.getPagerData().getStatusBarHeight());
                                float m3 = tVar2.getPagerData().m();
                                tVar2.getPagerData().getIsIOS();
                                tVar2.size(m3, tVar2.getPagerData().getStatusBarHeight() + 44.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage2 = NBPSetProfileTagEditPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.m142left(10.0f);
                                        tVar2.m150top(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.m138bottom(0.0f);
                                        tVar2.justifyContentCenter();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage3 = NBPSetProfileTagEditPage.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage4 = NBPSetProfileTagEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPTagsEditViewModel nBPTagsEditViewModel = NBPSetProfileTagEditPage.this.viewModel;
                                                if (!((nBPTagsEditViewModel == null || nBPTagsEditViewModel.checkSelectedTags()) ? false : true)) {
                                                    NBPTagsEditViewModel nBPTagsEditViewModel2 = NBPSetProfileTagEditPage.this.viewModel;
                                                    if ((nBPTagsEditViewModel2 == null || nBPTagsEditViewModel2.isTagsModified()) ? false : true) {
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                    } else {
                                                        NBPTagsEditViewModel nBPTagsEditViewModel3 = NBPSetProfileTagEditPage.this.viewModel;
                                                        if (nBPTagsEditViewModel3 != null) {
                                                            nBPTagsEditViewModel3.updateTagInfo();
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gprg2tiIEyx.png", false, 2, null);
                                                afVar2.t(QUIToken.color$default("text_nav_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage3 = NBPSetProfileTagEditPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.justifyContentCenter();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u6211\u7684\u6807\u7b7e");
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.fontWeight500();
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage4 = NBPSetProfileTagEditPage.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage5 = NBPSetProfileTagEditPage.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                com.tencent.kuikly.core.reactive.collection.c<TagInfo> selectedTags;
                                                ce ceVar2 = ceVar;
                                                StringBuilder sb5 = new StringBuilder();
                                                NBPTagsEditViewModel nBPTagsEditViewModel = NBPSetProfileTagEditPage.this.viewModel;
                                                sb5.append((nBPTagsEditViewModel == null || (selectedTags = nBPTagsEditViewModel.getSelectedTags()) == null) ? null : Integer.valueOf(selectedTags.size()));
                                                sb5.append("/20");
                                                ceVar2.text(sb5.toString());
                                                ceVar2.color(new h(9211020L, 1.0f));
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
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
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage2 = NBPSetProfileTagEditPage.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m154zIndex(1);
                                aoVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                                aoVar2.flexDirectionColumn();
                                aoVar2.size(aoVar2.getPagerData().m(), aoVar2.getPagerData().l() * 0.4f);
                                aoVar2.justifyContentCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage3 = NBPSetProfileTagEditPage.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignSelfFlexStart();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage4 = NBPSetProfileTagEditPage.this;
                                vVar2.addChild(new NBPSelectedTagListView(), new Function1<NBPSelectedTagListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPSelectedTagListView nBPSelectedTagListView) {
                                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage5 = NBPSetProfileTagEditPage.this;
                                        nBPSelectedTagListView.attr(new Function1<SelectedTagListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(SelectedTagListAttr selectedTagListAttr) {
                                                SelectedTagListAttr selectedTagListAttr2 = selectedTagListAttr;
                                                selectedTagListAttr2.mo153width(selectedTagListAttr2.getPagerData().m());
                                                selectedTagListAttr2.alignSelfFlexStart();
                                                selectedTagListAttr2.padding(16.0f, 16.0f, 0.0f, 16.0f);
                                                selectedTagListAttr2.viewModel = NBPSetProfileTagEditPage.this.viewModel;
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
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage3 = NBPSetProfileTagEditPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.4
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
                    
                        if (r0.isEmpty() == true) goto L10;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        NBPTagsEditViewModel nBPTagsEditViewModel = NBPSetProfileTagEditPage.this.viewModel;
                        boolean z16 = (nBPTagsEditViewModel == null || (r0 = nBPTagsEditViewModel.getSelectedTags()) == null) ? false : true;
                        return Boolean.valueOf(z16);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.getPagerData().getIsIOS();
                                        tVar2.marginTop(tVar2.getPagerData().getStatusBarHeight() + 44.0f);
                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l() * 0.4f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.5.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.5.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(69.0f, 69.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_TzMDBaNd74o.png", false, 2, null);
                                                if (PageDataExtKt.isNightMode(afVar2.getPagerData())) {
                                                    afVar2.t(h.INSTANCE.m());
                                                }
                                                afVar2.marginBottom(30.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.5.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.5.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                ceVar2.lineHeight(22.0f);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.text("\u81f3\u5c11\u9009\u62e93\u4e2a\u6807\u7b7e\u54e6~");
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
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage4 = NBPSetProfileTagEditPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPSetProfileTagEditPage nBPSetProfileTagEditPage5 = NBPSetProfileTagEditPage.this;
                        return Boolean.valueOf(((Boolean) nBPSetProfileTagEditPage5.showMask$delegate.getValue(nBPSetProfileTagEditPage5, NBPSetProfileTagEditPage.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage5 = NBPSetProfileTagEditPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage6 = NBPSetProfileTagEditPage.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.7.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m154zIndex(2);
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        tVar2.backgroundColor(2147483648L);
                                        float m3 = tVar2.getPagerData().m();
                                        float l3 = tVar2.getPagerData().l() * 0.4f;
                                        tVar2.getPagerData().getIsIOS();
                                        tVar2.size(m3, tVar2.getPagerData().getStatusBarHeight() + l3 + 44.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage7 = NBPSetProfileTagEditPage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage8 = NBPSetProfileTagEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPAllTagListView b16;
                                                NBPSetProfileTagEditPage nBPSetProfileTagEditPage9 = NBPSetProfileTagEditPage.this;
                                                nBPSetProfileTagEditPage9.showMask$delegate.setValue(nBPSetProfileTagEditPage9, NBPSetProfileTagEditPage.$$delegatedProperties[0], Boolean.FALSE);
                                                aa<NBPAllTagListView> aaVar = NBPSetProfileTagEditPage.this.allTagsViewRef;
                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                    b16.collapseView();
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
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage6 = NBPSetProfileTagEditPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.8
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPTagsEditViewModel nBPTagsEditViewModel = NBPSetProfileTagEditPage.this.viewModel;
                        return Boolean.valueOf((nBPTagsEditViewModel != null ? nBPTagsEditViewModel.getState() : null) == NBPTagsEditViewModel.TagState.LOADING);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        conditionView.addChild(new HomepageFeedsLoadingView(), new Function1<HomepageFeedsLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.9.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(HomepageFeedsLoadingView homepageFeedsLoadingView) {
                                homepageFeedsLoadingView.attr(new Function1<HomepageFeedsLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.9.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HomepageFeedsLoadingAttr homepageFeedsLoadingAttr) {
                                        HomepageFeedsLoadingAttr homepageFeedsLoadingAttr2 = homepageFeedsLoadingAttr;
                                        homepageFeedsLoadingAttr2.mo153width(homepageFeedsLoadingAttr2.getPagerData().m());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage7 = NBPSetProfileTagEditPage.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage$body$1.10
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage8 = NBPSetProfileTagEditPage.this;
                        conditionView.addChild(new NBPAllTagListView(), new Function1<NBPAllTagListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.10.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPAllTagListView nBPAllTagListView) {
                                NBPAllTagListView nBPAllTagListView2 = nBPAllTagListView;
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage9 = NBPSetProfileTagEditPage.this;
                                nBPAllTagListView2.ref(nBPAllTagListView2, new Function1<aa<NBPAllTagListView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.10.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<NBPAllTagListView> aaVar) {
                                        NBPSetProfileTagEditPage.this.allTagsViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage10 = NBPSetProfileTagEditPage.this;
                                nBPAllTagListView2.attr(new Function1<NBPAllTagsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.10.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPAllTagsAttr nBPAllTagsAttr) {
                                        NBPAllTagsAttr nBPAllTagsAttr2 = nBPAllTagsAttr;
                                        nBPAllTagsAttr2.m154zIndex(3);
                                        nBPAllTagsAttr2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                        nBPAllTagsAttr2.mo153width(nBPAllTagsAttr2.getPagerData().m());
                                        nBPAllTagsAttr2.positionAbsolute();
                                        nBPAllTagsAttr2.m138bottom(0.0f);
                                        float l3 = nBPAllTagsAttr2.getPagerData().l() * 0.6f;
                                        nBPAllTagsAttr2.getPagerData().getIsIOS();
                                        nBPAllTagsAttr2.initHeight = (l3 - 44.0f) - nBPAllTagsAttr2.getPagerData().getStatusBarHeight();
                                        nBPAllTagsAttr2.viewModel = NBPSetProfileTagEditPage.this.viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSetProfileTagEditPage nBPSetProfileTagEditPage11 = NBPSetProfileTagEditPage.this;
                                nBPAllTagListView2.event(new Function1<NBPAllTagsEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.10.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPAllTagsEvent nBPAllTagsEvent) {
                                        final NBPSetProfileTagEditPage nBPSetProfileTagEditPage12 = NBPSetProfileTagEditPage.this;
                                        nBPAllTagsEvent.registerEvent("expand", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage.body.1.10.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPSetProfileTagEditPage nBPSetProfileTagEditPage13 = NBPSetProfileTagEditPage.this;
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                                nBPSetProfileTagEditPage13.showMask$delegate.setValue(nBPSetProfileTagEditPage13, NBPSetProfileTagEditPage.$$delegatedProperties[0], Boolean.valueOf(((Boolean) obj).booleanValue()));
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

    /* JADX WARN: Type inference failed for: r5v22, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        Object d16;
        super.created();
        this.appId = getPageData().n().j("appid");
        NBPTagsEditViewModel nBPTagsEditViewModel = new NBPTagsEditViewModel(this.appId);
        g pageData = getPageData();
        nBPTagsEditViewModel.pageViewWidth = pageData.m();
        com.tencent.kuikly.core.nvi.serialization.json.b l3 = pageData.n().l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        if (l3 != null) {
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                if (BooleanCompanionObject.INSTANCE instanceof e) {
                    d16 = Boolean.valueOf(l3.e(i3));
                } else if (IntCompanionObject.INSTANCE instanceof e) {
                    d16 = Integer.valueOf(l3.i(i3));
                } else if (LongCompanionObject.INSTANCE instanceof e) {
                    d16 = Long.valueOf(l3.m(i3));
                } else if (StringCompanionObject.INSTANCE instanceof e) {
                    d16 = l3.o(i3);
                } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                    d16 = Double.valueOf(l3.g(i3));
                } else {
                    d16 = l3.d(i3);
                }
                if (d16 != null) {
                    e eVar = (e) d16;
                    a aVar = new a(eVar.j("tagId"), eVar.p("tagName"), 60);
                    nBPTagsEditViewModel.getSelectedTags().add(new TagInfo(aVar));
                    nBPTagsEditViewModel.rawTags.add(new TagInfo(aVar));
                    int i16 = aVar.f435362d;
                    if ((10000 <= i16 && i16 < 11112) && aVar.f435363e.length() >= 4) {
                        nBPTagsEditViewModel.selectedMBTITag = new TagInfo(aVar);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                }
            }
        }
        nBPTagsEditViewModel.fetchAllTags();
        this.viewModel = nBPTagsEditViewModel;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        NBPAllTagListView b16;
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            NBPTagsEditViewModel nBPTagsEditViewModel = this.viewModel;
            if ((nBPTagsEditViewModel == null || nBPTagsEditViewModel.checkSelectedTags()) ? false : true) {
                return;
            }
            NBPTagsEditViewModel nBPTagsEditViewModel2 = this.viewModel;
            if ((nBPTagsEditViewModel2 == null || nBPTagsEditViewModel2.isTagsModified()) ? false : true) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
                return;
            } else {
                NBPTagsEditViewModel nBPTagsEditViewModel3 = this.viewModel;
                if (nBPTagsEditViewModel3 != null) {
                    nBPTagsEditViewModel3.updateTagInfo();
                    return;
                }
                return;
            }
        }
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED)) {
            NBPTagsEditViewModel nBPTagsEditViewModel4 = this.viewModel;
            if (nBPTagsEditViewModel4 != null) {
                nBPTagsEditViewModel4.handleOnSizeChanged(getPageData().m());
            }
            aa<NBPAllTagListView> aaVar = this.allTagsViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            b16.handleOnRootSizeChanged();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        KLog.INSTANCE.i("NBPSetProfileTagEditPage", Pager.PAGER_EVENT_WILL_DESTROY);
        reportPageExposure(false);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        reportPageExposure(true);
    }

    public final void reportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_tag_edit");
        m3.t("nearby_kl_appid", this.appId);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, m3);
    }
}
