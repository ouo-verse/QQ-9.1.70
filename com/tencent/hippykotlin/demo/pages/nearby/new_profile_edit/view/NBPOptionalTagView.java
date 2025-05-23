package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.TagTabObservable;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class NBPOptionalTagView extends ComposeView<OptionalTagAttr, OptionalTagEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ OptionalTagAttr access$getAttr(NBPOptionalTagView nBPOptionalTagView) {
        return (OptionalTagAttr) nBPOptionalTagView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                final NBPOptionalTagView nBPOptionalTagView = NBPOptionalTagView.this;
                Function0<c<TagInfo>> function0 = new Function0<c<TagInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<TagInfo> invoke() {
                        return NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).getTagTabObservable().getTagList();
                    }
                };
                final NBPOptionalTagView nBPOptionalTagView2 = NBPOptionalTagView.this;
                LoopDirectivesViewKt.a(viewContainer2, function0, new Function2<LoopDirectivesView<TagInfo>, TagInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView$body$1.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(LoopDirectivesView<TagInfo> loopDirectivesView, TagInfo tagInfo) {
                        final TagInfo tagInfo2 = tagInfo;
                        final NBPOptionalTagView nBPOptionalTagView3 = NBPOptionalTagView.this;
                        loopDirectivesView.addChild(new OptionalTagView(), new Function1<OptionalTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(OptionalTagView optionalTagView) {
                                OptionalTagView optionalTagView2 = optionalTagView;
                                final TagInfo tagInfo3 = TagInfo.this;
                                final NBPOptionalTagView nBPOptionalTagView4 = nBPOptionalTagView3;
                                optionalTagView2.attr(new Function1<OptionalTagViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(OptionalTagViewAttr optionalTagViewAttr) {
                                        OptionalTagViewAttr optionalTagViewAttr2 = optionalTagViewAttr;
                                        boolean z16 = false;
                                        optionalTagViewAttr2.tag$delegate.setValue(optionalTagViewAttr2, OptionalTagViewAttr.$$delegatedProperties[0], TagInfo.this);
                                        NBPTagsEditViewModel nBPTagsEditViewModel = NBPOptionalTagView.access$getAttr(nBPOptionalTagView4).viewModel;
                                        if (nBPTagsEditViewModel != null && !nBPTagsEditViewModel.allTagsSet.containsKey(Integer.valueOf(optionalTagViewAttr2.getTag().tag.f435362d))) {
                                            nBPTagsEditViewModel.allTagsSet.put(Integer.valueOf(optionalTagViewAttr2.getTag().tag.f435362d), optionalTagViewAttr2);
                                        }
                                        NBPTagsEditViewModel nBPTagsEditViewModel2 = NBPOptionalTagView.access$getAttr(nBPOptionalTagView4).viewModel;
                                        if (nBPTagsEditViewModel2 != null) {
                                            if (nBPTagsEditViewModel2.getSelectedTags().contains(TagInfo.this)) {
                                                z16 = true;
                                            }
                                        }
                                        optionalTagViewAttr2.setSelected(z16);
                                        optionalTagViewAttr2.viewModel = NBPOptionalTagView.access$getAttr(nBPOptionalTagView4).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPOptionalTagView nBPOptionalTagView5 = nBPOptionalTagView3;
                                optionalTagView2.event(new Function1<OptionalTagViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(OptionalTagViewEvent optionalTagViewEvent) {
                                        final NBPOptionalTagView nBPOptionalTagView6 = NBPOptionalTagView.this;
                                        optionalTagViewEvent.registerEvent("select", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPTagsEditViewModel nBPTagsEditViewModel;
                                                OptionalTagViewAttr optionalTagViewAttr = obj instanceof OptionalTagViewAttr ? (OptionalTagViewAttr) obj : null;
                                                if (optionalTagViewAttr != null && (nBPTagsEditViewModel = NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).viewModel) != null) {
                                                    nBPTagsEditViewModel.toggleTag(optionalTagViewAttr.getTag());
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
                final NBPOptionalTagView nBPOptionalTagView3 = NBPOptionalTagView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).getTagTabObservable().getTagLines() >= 3);
                    }
                };
                final NBPOptionalTagView nBPOptionalTagView4 = NBPOptionalTagView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NBPOptionalTagView nBPOptionalTagView5 = NBPOptionalTagView.this;
                        ConditionViewKt.c(conditionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                TagTabObservable tagTabObservable = NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).getTagTabObservable();
                                return Boolean.valueOf(!((Boolean) tagTabObservable.collapsedSpaceEnough$delegate.getValue(tagTabObservable, TagTabObservable.$$delegatedProperties[3])).booleanValue());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                w.a(conditionView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.2.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.size(70.0f, 32.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPOptionalTagView nBPOptionalTagView6 = NBPOptionalTagView.this;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.size(40.0f, 32.0f);
                                        tVar2.m149right(6.0f);
                                        tVar2.m138bottom(6.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPOptionalTagView nBPOptionalTagView7 = NBPOptionalTagView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPOptionalTagView nBPOptionalTagView8 = NBPOptionalTagView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ce ceVar2 = ceVar;
                                                if (NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).getTagTabObservable().getExpanded()) {
                                                    str = "\u6536\u8d77";
                                                } else {
                                                    str = "\u66f4\u591a";
                                                }
                                                ceVar2.text(str);
                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPOptionalTagView nBPOptionalTagView8 = NBPOptionalTagView.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPOptionalTagView nBPOptionalTagView9 = NBPOptionalTagView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String image;
                                                af afVar2 = afVar;
                                                if (NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).getTagTabObservable().getExpanded()) {
                                                    image = QUIToken.INSTANCE.image("chevron_up", QUIToken.color$default("text_secondary"));
                                                } else {
                                                    image = QUIToken.INSTANCE.image("chevron_down", QUIToken.color$default("text_secondary"));
                                                }
                                                b.a.b(afVar2, image, false, 2, null);
                                                afVar2.marginLeft(4.0f);
                                                afVar2.size(12.0f, 12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPOptionalTagView nBPOptionalTagView9 = NBPOptionalTagView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPOptionalTagView nBPOptionalTagView10 = NBPOptionalTagView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPOptionalTagView.body.1.5.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                TagTabObservable tagTabObservable = NBPOptionalTagView.access$getAttr(NBPOptionalTagView.this).getTagTabObservable();
                                                tagTabObservable.expanded$delegate.setValue(tagTabObservable, TagTabObservable.$$delegatedProperties[2], Boolean.valueOf(!tagTabObservable.getExpanded()));
                                                if (tagTabObservable.getExpanded()) {
                                                    tagTabObservable.getTagList().clear();
                                                    tagTabObservable.getTagList().addAll(tagTabObservable.tags);
                                                } else {
                                                    tagTabObservable.getCollapsedTags();
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new OptionalTagAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new OptionalTagEvent();
    }
}
