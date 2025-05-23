package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MBTITagView extends ComposeView<MBTITagAttr, MBTITagEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MBTITagAttr access$getAttr(MBTITagView mBTITagView) {
        return (MBTITagAttr) mBTITagView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float m3 = (getPagerData().m() - 44) / 2;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f16 = m3;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.borderRadius(4.0f);
                        mVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                        mVar2.size(f16, 32.0f);
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                final float f17 = m3;
                final MBTITagView mBTITagView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f18 = f17;
                        final MBTITagView mBTITagView2 = mBTITagView;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h j3;
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.size(f18 / 2, 32.0f);
                                if (MBTITagView.access$getAttr(mBTITagView2).getSelectTag() == 0) {
                                    j3 = new h(443832831L);
                                } else {
                                    j3 = h.INSTANCE.j();
                                }
                                tVar2.mo113backgroundColor(j3);
                                return Unit.INSTANCE;
                            }
                        });
                        final MBTITagView mBTITagView3 = mBTITagView;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final MBTITagView mBTITagView4 = MBTITagView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h color$default;
                                        ce ceVar2 = ceVar;
                                        ceVar2.m142left(8.0f);
                                        ceVar2.text(MBTITagView.access$getAttr(MBTITagView.this).leftTag);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 0) {
                                            ceVar2.fontWeight500();
                                        } else {
                                            ceVar2.fontWeight400();
                                        }
                                        if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 0) {
                                            color$default = new h(4285815295L);
                                        } else {
                                            color$default = QUIToken.color$default("text_primary");
                                        }
                                        ceVar2.color(color$default);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MBTITagView mBTITagView4 = mBTITagView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentFlexEnd();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final MBTITagView mBTITagView5 = MBTITagView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final MBTITagView mBTITagView6 = MBTITagView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h color$default;
                                                ce ceVar2 = ceVar;
                                                ceVar2.m149right(8.0f);
                                                ceVar2.text(MBTITagView.access$getAttr(MBTITagView.this).leftMeaning);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 0) {
                                                    ceVar2.fontWeight500();
                                                } else {
                                                    ceVar2.fontWeight400();
                                                }
                                                if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 0) {
                                                    color$default = new h(4285815295L);
                                                } else {
                                                    color$default = QUIToken.color$default("text_secondary");
                                                }
                                                ceVar2.color(color$default);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MBTITagView mBTITagView5 = mBTITagView;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final MBTITagView mBTITagView6 = MBTITagView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPTagsEditViewModel nBPTagsEditViewModel = MBTITagView.access$getAttr(MBTITagView.this).viewModel;
                                        if (!((nBPTagsEditViewModel == null || nBPTagsEditViewModel.checkMBTICanBeSelected()) ? false : true)) {
                                            if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() != 0) {
                                                MBTITagView.access$getAttr(MBTITagView.this).setSelectTag(0);
                                            } else {
                                                MBTITagView.access$getAttr(MBTITagView.this).setSelectTag(-1);
                                            }
                                            MBTITagView mBTITagView7 = MBTITagView.this;
                                            mBTITagView7.emit("select", MBTITagView.access$getAttr(mBTITagView7));
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
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(1.0f);
                                tVar2.mo141height(30.0f);
                                tVar2.mo113backgroundColor(new h(0L, 0.1f));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final float f18 = m3;
                final MBTITagView mBTITagView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f19 = f18;
                        final MBTITagView mBTITagView3 = mBTITagView2;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h j3;
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m149right(0.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.size(f19 / 2, 32.0f);
                                if (MBTITagView.access$getAttr(mBTITagView3).getSelectTag() == 1) {
                                    j3 = new h(443832831L);
                                } else {
                                    j3 = h.INSTANCE.j();
                                }
                                tVar2.mo113backgroundColor(j3);
                                return Unit.INSTANCE;
                            }
                        });
                        final MBTITagView mBTITagView4 = mBTITagView2;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final MBTITagView mBTITagView5 = MBTITagView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h color$default;
                                        ce ceVar2 = ceVar;
                                        ceVar2.m142left(8.0f);
                                        ceVar2.text(MBTITagView.access$getAttr(MBTITagView.this).rightMeaning);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 1) {
                                            ceVar2.fontWeight500();
                                        } else {
                                            ceVar2.fontWeight400();
                                        }
                                        if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 1) {
                                            color$default = new h(4285815295L);
                                        } else {
                                            color$default = QUIToken.color$default("text_secondary");
                                        }
                                        ceVar2.color(color$default);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MBTITagView mBTITagView5 = mBTITagView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentFlexEnd();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final MBTITagView mBTITagView6 = MBTITagView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final MBTITagView mBTITagView7 = MBTITagView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h color$default;
                                                ce ceVar2 = ceVar;
                                                ceVar2.m149right(8.0f);
                                                ceVar2.text(MBTITagView.access$getAttr(MBTITagView.this).rightTag);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 1) {
                                                    ceVar2.fontWeight500();
                                                } else {
                                                    ceVar2.fontWeight400();
                                                }
                                                if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() == 1) {
                                                    color$default = new h(4285815295L);
                                                } else {
                                                    color$default = QUIToken.color$default("text_primary");
                                                }
                                                ceVar2.color(color$default);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MBTITagView mBTITagView6 = mBTITagView2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final MBTITagView mBTITagView7 = MBTITagView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.MBTITagView.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPTagsEditViewModel nBPTagsEditViewModel = MBTITagView.access$getAttr(MBTITagView.this).viewModel;
                                        if (!((nBPTagsEditViewModel == null || nBPTagsEditViewModel.checkMBTICanBeSelected()) ? false : true)) {
                                            if (MBTITagView.access$getAttr(MBTITagView.this).getSelectTag() != 1) {
                                                MBTITagView.access$getAttr(MBTITagView.this).setSelectTag(1);
                                            } else {
                                                MBTITagView.access$getAttr(MBTITagView.this).setSelectTag(-1);
                                            }
                                            MBTITagView mBTITagView8 = MBTITagView.this;
                                            mBTITagView8.emit("select", MBTITagView.access$getAttr(mBTITagView8));
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new MBTITagAttr(null, null, null, null, 0, 31, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new MBTITagEvent();
    }
}
