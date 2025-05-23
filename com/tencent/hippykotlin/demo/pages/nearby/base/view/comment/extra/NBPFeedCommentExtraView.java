package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.AlertDialogView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.j;
import com.tencent.kuikly.core.views.k;
import com.tencent.kuikly.core.views.l;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedCommentExtraView extends ComposeView<NBPFeedCommentExtraViewAttr, NBPFeedCommentExtraViewEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* renamed from: vm, reason: collision with root package name */
    public NBPFeedCommentExtraViewModel f114216vm;

    public NBPFeedCommentExtraView(int i3, String str) {
        this.f114216vm = new NBPFeedCommentExtraViewModel(i3, str);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel = this.f114216vm;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        mVar2.absolutePositionAllZero();
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel2 = NBPFeedCommentExtraViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPFeedCommentExtraViewModel.this.getIdentityDialogVisible());
                    }
                };
                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel3 = NBPFeedCommentExtraViewModel.this;
                final NBPFeedCommentExtraView nBPFeedCommentExtraView = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel4 = NBPFeedCommentExtraViewModel.this;
                        final NBPFeedCommentExtraView nBPFeedCommentExtraView2 = nBPFeedCommentExtraView;
                        l.a(conditionView, new Function1<AlertDialogView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AlertDialogView alertDialogView) {
                                AlertDialogView alertDialogView2 = alertDialogView;
                                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel5 = NBPFeedCommentExtraViewModel.this;
                                final NBPFeedCommentExtraView nBPFeedCommentExtraView3 = nBPFeedCommentExtraView2;
                                alertDialogView2.attr(new Function1<j, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(j jVar) {
                                        j jVar2 = jVar;
                                        jVar2.s(NBPFeedCommentExtraViewModel.this.getIdentityDialogVisible());
                                        NBPFeedCommentExtraView nBPFeedCommentExtraView4 = nBPFeedCommentExtraView3;
                                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel6 = NBPFeedCommentExtraViewModel.this;
                                        final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPFeedCommentExtraViewModel.this.closeIdentityDialog(false);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel7 = NBPFeedCommentExtraViewModel.this;
                                        final Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPFeedCommentExtraViewModel.this.closeIdentityDialog(true);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        int i3 = NBPFeedCommentExtraView.$r8$clinit;
                                        nBPFeedCommentExtraView4.getClass();
                                        jVar2.h(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildAlert$1
                                            public final /* synthetic */ String $title = "\u56de\u590d\u9700\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1";
                                            public final /* synthetic */ String $leftBtnText = "\u53d6\u6d88";
                                            public final /* synthetic */ String $rightBtnText = "\u53bb\u5b8c\u6210";

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildAlert$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        m mVar2 = mVar;
                                                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                                                        mVar2.flexDirectionColumn();
                                                        mVar2.mo153width(mVar2.getPagerData().m() - 80);
                                                        mVar2.borderRadius(6.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str = this.$title;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildAlert$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(24.0f);
                                                                tVar2.marginBottom(24.0f);
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final String str2 = str;
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final String str3 = str2;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.color(h.INSTANCE.b());
                                                                        ceVar2.text(str3);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildAlert$1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.mo113backgroundColor(new h(0L, 0.1f));
                                                                tVar2.mo141height(0.5f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str2 = this.$leftBtnText;
                                                final Function0<Unit> function04 = Function0.this;
                                                final String str3 = this.$rightBtnText;
                                                final Function0<Unit> function05 = function03;
                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildAlert$1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.paddingBottom(13.0f);
                                                                tVar2.paddingTop(13.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final String str4 = str2;
                                                        final Function0<Unit> function06 = function04;
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                TextView textView2 = textView;
                                                                final String str5 = str4;
                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.m140flex(1.0f);
                                                                        ceVar2.text(str5);
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.color(h.INSTANCE.b());
                                                                        ceVar2.textAlignCenter();
                                                                        ceVar2.fontWeight600();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final Function0<Unit> function07 = function06;
                                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.2.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextEvent textEvent) {
                                                                        final Function0<Unit> function08 = function07;
                                                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.2.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function09 = function08;
                                                                                if (function09 != null) {
                                                                                    function09.invoke();
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
                                                        final String str5 = str3;
                                                        final Function0<Unit> function07 = function05;
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                TextView textView2 = textView;
                                                                final String str6 = str5;
                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.m140flex(1.0f);
                                                                        ceVar2.text(str6);
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.color(h.INSTANCE.b());
                                                                        ceVar2.textAlignCenter();
                                                                        ceVar2.fontWeight600();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final Function0<Unit> function08 = function07;
                                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.3.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextEvent textEvent) {
                                                                        final Function0<Unit> function09 = function08;
                                                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildAlert.1.4.3.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function010 = function09;
                                                                                if (function010 != null) {
                                                                                    function010.invoke();
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
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel6 = NBPFeedCommentExtraViewModel.this;
                                alertDialogView2.event(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(k kVar) {
                                        k kVar2 = kVar;
                                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel7 = NBPFeedCommentExtraViewModel.this;
                                        kVar2.i(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPFeedCommentExtraViewModel.this.closeIdentityDialog(true);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        kVar2.h(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.3.1.2.2
                                            @Override // kotlin.jvm.functions.Function0
                                            public final /* bridge */ /* synthetic */ Unit invoke() {
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
                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel4 = NBPFeedCommentExtraViewModel.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPFeedCommentExtraViewModel.this.getMenuVisible());
                    }
                };
                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel5 = NBPFeedCommentExtraViewModel.this;
                final NBPFeedCommentExtraView nBPFeedCommentExtraView2 = this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel6 = NBPFeedCommentExtraViewModel.this;
                        final NBPFeedCommentExtraView nBPFeedCommentExtraView3 = nBPFeedCommentExtraView2;
                        e.a(conditionView, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetView actionSheetView) {
                                ActionSheetView actionSheetView2 = actionSheetView;
                                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel7 = NBPFeedCommentExtraViewModel.this;
                                final NBPFeedCommentExtraView nBPFeedCommentExtraView4 = nBPFeedCommentExtraView3;
                                actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                        Function1<ViewContainer<?, ?>, Unit> function1;
                                        ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                        actionSheetAttr2.w(NBPFeedCommentExtraViewModel.this.getMenuVisible());
                                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel8 = nBPFeedCommentExtraView4.f114216vm;
                                        final NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent = nBPFeedCommentExtraViewModel8.menuOpenData;
                                        if (nBPFeedCommentMenuOpenEvent == null) {
                                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$data$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                        } else {
                                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                    ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                    viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(m mVar) {
                                                            m mVar2 = mVar;
                                                            mVar2.flexDirectionColumn();
                                                            mVar2.borderRadius(8.0f);
                                                            mVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            mVar2.mo153width(mVar2.getPagerData().m());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel9 = nBPFeedCommentExtraViewModel8;
                                                    viewContainer4.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Event event) {
                                                            final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel10 = NBPFeedCommentExtraViewModel.this;
                                                            event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel11 = NBPFeedCommentExtraViewModel.this;
                                                                    KProperty<Object>[] kPropertyArr = NBPFeedCommentExtraViewModel.$$delegatedProperties;
                                                                    nBPFeedCommentExtraViewModel11.closeMenu(NBPFeedCommentMenuItem.UNKNOWN);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent2 = NBPFeedCommentMenuOpenEvent.this;
                                                    nBPFeedCommentMenuOpenEvent2.getClass();
                                                    ArrayList arrayList = new ArrayList();
                                                    if (Intrinsics.areEqual(nBPFeedCommentMenuOpenEvent2.targetUserId, nBPFeedCommentMenuOpenEvent2.viewerUserId) || Intrinsics.areEqual(nBPFeedCommentMenuOpenEvent2.posterUserId, nBPFeedCommentMenuOpenEvent2.viewerUserId)) {
                                                        arrayList.add(NBPFeedCommentMenuItem.DELETE);
                                                    }
                                                    if (!Intrinsics.areEqual(nBPFeedCommentMenuOpenEvent2.targetUserId, nBPFeedCommentMenuOpenEvent2.viewerUserId)) {
                                                        arrayList.add(NBPFeedCommentMenuItem.REPORT);
                                                    }
                                                    final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel10 = nBPFeedCommentExtraViewModel8;
                                                    Iterator it = arrayList.iterator();
                                                    int i3 = 0;
                                                    while (it.hasNext()) {
                                                        Object next = it.next();
                                                        int i16 = i3 + 1;
                                                        if (i3 < 0) {
                                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                        }
                                                        final NBPFeedCommentMenuItem nBPFeedCommentMenuItem = (NBPFeedCommentMenuItem) next;
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1$3$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar) {
                                                                v vVar2 = vVar;
                                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1$3$1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.mo141height(56.0f);
                                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel11 = NBPFeedCommentExtraViewModel.this;
                                                                final NBPFeedCommentMenuItem nBPFeedCommentMenuItem2 = nBPFeedCommentMenuItem;
                                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1$3$1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel12 = NBPFeedCommentExtraViewModel.this;
                                                                        final NBPFeedCommentMenuItem nBPFeedCommentMenuItem3 = nBPFeedCommentMenuItem2;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.3.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                NBPFeedCommentExtraViewModel.this.closeMenu(nBPFeedCommentMenuItem3);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFeedCommentMenuItem nBPFeedCommentMenuItem3 = nBPFeedCommentMenuItem;
                                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1$3$1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final NBPFeedCommentMenuItem nBPFeedCommentMenuItem4 = NBPFeedCommentMenuItem.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.3.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                h color$default;
                                                                                String str;
                                                                                ce ceVar2 = ceVar;
                                                                                int ordinal = NBPFeedCommentMenuItem.this.ordinal();
                                                                                if (ordinal == 1) {
                                                                                    color$default = QUIToken.color$default("feedback_error");
                                                                                } else if (ordinal != 2) {
                                                                                    color$default = QUIToken.color$default("text_primary");
                                                                                } else {
                                                                                    color$default = QUIToken.color$default("feedback_error");
                                                                                }
                                                                                ceVar2.color(color$default);
                                                                                int ordinal2 = NBPFeedCommentMenuItem.this.ordinal();
                                                                                if (ordinal2 == 1) {
                                                                                    str = "\u5220\u9664";
                                                                                } else if (ordinal2 != 2) {
                                                                                    str = "";
                                                                                } else {
                                                                                    str = "\u4e3e\u62a5";
                                                                                }
                                                                                ceVar2.text(str);
                                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        if (i3 != arrayList.size() - 1) {
                                                            w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1$3$2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar) {
                                                                    vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1$3$2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.mo141height(0.5f);
                                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                                            tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        i3 = i16;
                                                    }
                                                    w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.mo141height(12.0f);
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_standard"));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel11 = nBPFeedCommentExtraViewModel8;
                                                    w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView$buildMenu$1.5
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            v vVar2 = vVar;
                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.5.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.allCenter();
                                                                    tVar2.mo141height(56.0f);
                                                                    tVar2.marginBottom(21.0f);
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel12 = NBPFeedCommentExtraViewModel.this;
                                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.5.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel13 = NBPFeedCommentExtraViewModel.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.5.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel14 = NBPFeedCommentExtraViewModel.this;
                                                                            KProperty<Object>[] kPropertyArr = NBPFeedCommentExtraViewModel.$$delegatedProperties;
                                                                            nBPFeedCommentExtraViewModel14.closeMenu(NBPFeedCommentMenuItem.UNKNOWN);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.5.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.buildMenu.1.5.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                            ceVar2.text("\u53d6\u6d88");
                                                                            ceVar2.fontWeight600();
                                                                            ceVar2.color(QUIToken.color$default("text_primary"));
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
                                        actionSheetAttr2.j(function1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel8 = NBPFeedCommentExtraViewModel.this;
                                actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        final NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel9 = NBPFeedCommentExtraViewModel.this;
                                        dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel10 = NBPFeedCommentExtraViewModel.this;
                                                KProperty<Object>[] kPropertyArr = NBPFeedCommentExtraViewModel.$$delegatedProperties;
                                                nBPFeedCommentExtraViewModel10.closeMenu(NBPFeedCommentMenuItem.UNKNOWN);
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
        return new NBPFeedCommentExtraViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedCommentExtraViewEvent();
    }

    public final boolean onBack() {
        if (this.f114216vm.getMenuVisible()) {
            this.f114216vm.closeMenu(NBPFeedCommentMenuItem.UNKNOWN);
            return false;
        }
        if (!this.f114216vm.getIdentityDialogVisible()) {
            return true;
        }
        this.f114216vm.closeIdentityDialog(false);
        return false;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewWillUnload() {
        super.viewWillUnload();
        this.f114216vm.manager.onDestroy();
    }
}
