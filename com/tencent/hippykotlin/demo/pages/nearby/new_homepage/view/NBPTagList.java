package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import s35.af;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPTagList extends ComposeView<TagListAttr, TagListEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TagListAttr access$getAttr(NBPTagList nBPTagList) {
        return (TagListAttr) nBPTagList.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                final NBPTagList nBPTagList = NBPTagList.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        af userInfo;
                        boolean z16 = false;
                        if (NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel != null) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                            if (!((nBPHomePageBaseViewModel == null || (userInfo = nBPHomePageBaseViewModel.getUserInfo()) == null || userInfo.f433218m != 0) ? false : true)) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPTagList nBPTagList2 = NBPTagList.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPTagList nBPTagList3 = NBPTagList.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.borderRadius(4.0f);
                                        tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                        tVar2.size(42.0f, 25.0f);
                                        tVar2.margin(6.0f);
                                        tVar2.padding(4.0f, 8.0f, 4.0f, 8.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList4 = NBPTagList.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPTagList nBPTagList5 = NBPTagList.this;
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
                                            
                                                if (r0.f433218m == 1) goto L10;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                boolean z16;
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                afVar2.size(12.0f, 12.0f);
                                                afVar2.o();
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                                if (nBPHomePageBaseViewModel != null && (r0 = nBPHomePageBaseViewModel.getUserInfo()) != null) {
                                                    z16 = true;
                                                }
                                                z16 = false;
                                                if (z16) {
                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8mMIez3Oefl.png", false, 2, null);
                                                } else {
                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_TB7_3nsRQ-f.png", false, 2, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList5 = NBPTagList.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPTagList nBPTagList6 = NBPTagList.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.3.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                af userInfo;
                                                String str;
                                                ce ceVar2 = ceVar;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                                if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null) {
                                                    int i3 = userInfo.f433218m;
                                                    if (i3 == 1) {
                                                        str = "\u7537";
                                                    } else if (i3 != 2) {
                                                        str = "";
                                                    } else {
                                                        str = "\u5973";
                                                    }
                                                    ceVar2.text(str);
                                                }
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.marginLeft(2.5f);
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
                final NBPTagList nBPTagList3 = NBPTagList.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.4
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        boolean z16;
                        af userInfo;
                        String str;
                        boolean z17 = false;
                        if (NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel != null) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                            if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.f433214i) != null) {
                                if (str.length() > 0) {
                                    z16 = true;
                                    if (z16) {
                                        z17 = true;
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                            }
                        }
                        return Boolean.valueOf(z17);
                    }
                };
                final NBPTagList nBPTagList4 = NBPTagList.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPTagList nBPTagList5 = NBPTagList.this;
                        conditionView.addChild(new TagView(), new Function1<TagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TagView tagView) {
                                final NBPTagList nBPTagList6 = NBPTagList.this;
                                tagView.attr(new Function1<TagViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TagViewAttr tagViewAttr) {
                                        af userInfo;
                                        TagViewAttr tagViewAttr2 = tagViewAttr;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null) {
                                            NBPTagList nBPTagList7 = NBPTagList.this;
                                            tagViewAttr2.setTag(new TagInfo(new a(userInfo.f433214i.hashCode() + EmojiHomeUiPlugin.HOMEPAGE_RDM_EVENT_TIMEOUT, userInfo.f433214i, 60)));
                                            NBPTagList.access$getAttr(nBPTagList7).getPagerData().n().k("appId", 0);
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
                final NBPTagList nBPTagList5 = NBPTagList.this;
                Function0<c<TagInfo>> function03 = new Function0<c<TagInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<TagInfo> invoke() {
                        TagListAttr access$getAttr = NBPTagList.access$getAttr(NBPTagList.this);
                        return (c) access$getAttr.tags$delegate.getValue(access$getAttr, TagListAttr.$$delegatedProperties[0]);
                    }
                };
                final NBPTagList nBPTagList6 = NBPTagList.this;
                LoopDirectivesViewKt.a(viewContainer2, function03, new Function2<LoopDirectivesView<TagInfo>, TagInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(LoopDirectivesView<TagInfo> loopDirectivesView, TagInfo tagInfo) {
                        final TagInfo tagInfo2 = tagInfo;
                        final NBPTagList nBPTagList7 = NBPTagList.this;
                        loopDirectivesView.addChild(new TagView(), new Function1<TagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.7.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TagView tagView) {
                                final TagInfo tagInfo3 = TagInfo.this;
                                final NBPTagList nBPTagList8 = nBPTagList7;
                                tagView.attr(new Function1<TagViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.7.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TagViewAttr tagViewAttr) {
                                        tagViewAttr.setTag(TagInfo.this);
                                        NBPTagList.access$getAttr(nBPTagList8).getPagerData().n().k("appId", 0);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPTagList nBPTagList7 = NBPTagList.this;
                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.8
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf((NBPTagList.access$getAttr(NBPTagList.this).lastTagTex.length() > 0) && NBPTagList.access$getAttr(NBPTagList.this).isSelf);
                    }
                };
                final NBPTagList nBPTagList8 = NBPTagList.this;
                ConditionViewKt.c(viewContainer2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPTagList nBPTagList9 = NBPTagList.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPTagList nBPTagList10 = NBPTagList.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.borderRadius(4.0f);
                                        tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                        tVar2.mo141height(25.0f);
                                        tVar2.margin(6.0f);
                                        tVar2.padding(4.0f, 8.0f, 4.0f, 8.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                        tVar2.m151touchEnable((nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getUserInfo() : null) != null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList11 = NBPTagList.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPTagList nBPTagList12 = NBPTagList.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(NBPTagList.access$getAttr(NBPTagList.this).lastTagTex);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.fontWeight400();
                                                ceVar2.marginLeft(5.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList12 = NBPTagList.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPTagList nBPTagList13 = NBPTagList.this;
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                afVar2.size(9.5f, 9.5f);
                                                b.a.b(afVar2, NBPTagList.access$getAttr(NBPTagList.this).lastTagIMG, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList13 = NBPTagList.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPTagList nBPTagList14 = NBPTagList.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.9.1.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    int appId = nBPHomePageBaseViewModel.getAppId();
                                                    NBPTagList nBPTagList15 = NBPTagList.this;
                                                    NBPHomePageBaseViewModel.Companion companion = NBPHomePageBaseViewModel.Companion;
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPTagList.access$getAttr(nBPTagList15).homePageViewModel;
                                                    companion.openTagEditPage(appId, nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.getTagList() : null);
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
                final NBPTagList nBPTagList9 = NBPTagList.this;
                Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.10
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
                    
                        if (r0.shouldShowTagsToggle() == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                        boolean z16 = nBPHomePageBaseViewModel != null;
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPTagList nBPTagList10 = NBPTagList.this;
                ConditionViewKt.c(viewContainer2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList$body$1.11
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPTagList nBPTagList11 = NBPTagList.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.11.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.11.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.borderRadius(4.0f);
                                        tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                        tVar2.size(25.0f, 25.0f);
                                        tVar2.margin(6.0f);
                                        tVar2.padding(4.0f, 8.0f, 4.0f, 8.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList12 = NBPTagList.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.11.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPTagList nBPTagList13 = NBPTagList.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.11.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    nBPHomePageBaseViewModel.tagsExpanded$delegate.setValue(nBPHomePageBaseViewModel, NBPHomePageBaseViewModel.$$delegatedProperties[0], Boolean.valueOf(!nBPHomePageBaseViewModel.getTagsExpanded()));
                                                    if (nBPHomePageBaseViewModel.getTagsExpanded()) {
                                                        nBPHomePageBaseViewModel.assembleFullTags();
                                                    } else {
                                                        nBPHomePageBaseViewModel.prepareCollapsedTags();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPTagList nBPTagList13 = NBPTagList.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.11.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPTagList nBPTagList14 = NBPTagList.this;
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPTagList.body.1.11.1.3.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
                                            
                                                if (r1.getTagsExpanded() == true) goto L8;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                boolean z16;
                                                String str;
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPTagList.access$getAttr(NBPTagList.this).homePageViewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    z16 = true;
                                                }
                                                z16 = false;
                                                if (z16) {
                                                    str = "chevron_up";
                                                } else {
                                                    str = "chevron_down";
                                                }
                                                b.a.b(afVar2, qUIToken.image(str, new h(4287664276L)), false, 2, null);
                                                afVar2.size(16.0f, 16.0f);
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
        return new TagListAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TagListEvent();
    }
}
