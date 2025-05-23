package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p35.i;

/* loaded from: classes31.dex */
public final class NBPFeedCommentReplyItemView extends ComposeView<NBPFeedCommentReplyItemViewAttr, NBPFeedCommentReplyItemViewEvent> {
    public final int appId;
    public aa<NBPFeedLCommentHighlightView> highlightRef;

    public NBPFeedCommentReplyItemView(int i3) {
        this.appId = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
    
        if (r5 == true) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$onReplyClick(NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView, int i3) {
        NBPReplyVO nBPReplyVO;
        boolean z16;
        aa<NBPFeedLCommentHighlightView> aaVar;
        NBPFeedLCommentHighlightView b16;
        NBPCommentVO nBPCommentVO = ((NBPFeedCommentReplyItemViewAttr) nBPFeedCommentReplyItemView.getAttr()).comment;
        if (nBPCommentVO == null || (nBPReplyVO = ((NBPFeedCommentReplyItemViewAttr) nBPFeedCommentReplyItemView.getAttr()).reply) == null) {
            return;
        }
        Function1<? super CommentClickInfo, Boolean> function1 = ((NBPFeedCommentReplyItemViewEvent) nBPFeedCommentReplyItemView.getEvent()).onClickHandler;
        if (function1 != null) {
            boolean booleanValue = function1.invoke(new CommentClickInfo(i3, nBPCommentVO, nBPReplyVO)).booleanValue();
            z16 = true;
        }
        z16 = false;
        if (!z16 || (aaVar = nBPFeedCommentReplyItemView.highlightRef) == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.trigger();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPReplyVO nBPReplyVO = ((NBPFeedCommentReplyItemViewAttr) getAttr()).reply;
        if (nBPReplyVO == null) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$reply$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView = NBPFeedCommentReplyItemView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView2 = NBPFeedCommentReplyItemView.this;
                        event.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LongPressParams longPressParams) {
                                NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 5);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView2 = NBPFeedCommentReplyItemView.this;
                viewContainer2.addChild(new NBPFeedLCommentHighlightView(), new Function1<NBPFeedLCommentHighlightView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPFeedLCommentHighlightView nBPFeedLCommentHighlightView) {
                        NBPFeedLCommentHighlightView nBPFeedLCommentHighlightView2 = nBPFeedLCommentHighlightView;
                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView3 = NBPFeedCommentReplyItemView.this;
                        nBPFeedLCommentHighlightView2.ref(nBPFeedLCommentHighlightView2, new Function1<aa<NBPFeedLCommentHighlightView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPFeedLCommentHighlightView> aaVar) {
                                NBPFeedCommentReplyItemView.this.highlightRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView3 = NBPFeedCommentReplyItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final String str;
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(20.0f, 20.0f);
                                tVar2.allCenter();
                                tVar2.marginRight(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView4 = nBPFeedCommentReplyItemView3;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView5 = NBPFeedCommentReplyItemView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView6 = NBPFeedCommentReplyItemView.this;
                                uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LongPressParams longPressParams) {
                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 5);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPReplyVO nBPReplyVO3 = NBPReplyVO.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPReplyVO nBPReplyVO4 = NBPReplyVO.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String str2;
                                        af afVar2 = afVar;
                                        afVar2.size(20.0f, 20.0f);
                                        afVar2.borderRadius(10.0f);
                                        afVar2.absolutePositionAllZero();
                                        afVar2.mo113backgroundColor(new h(167793150L));
                                        s35.af afVar3 = NBPReplyVO.this.user;
                                        if (afVar3 == null || (str2 = afVar3.E) == null) {
                                            str2 = "";
                                        }
                                        b.a.b(afVar2, str2, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        s35.af afVar = NBPReplyVO.this.user;
                        if (afVar != null) {
                            str = StrangerUtilsKt.getAvatarDressFrameUrl(afVar);
                        } else {
                            str = "";
                        }
                        if (str.length() > 0) {
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    final String str2 = str;
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.4.4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar2) {
                                            af afVar3 = afVar2;
                                            afVar3.size(21.875f, 21.875f);
                                            afVar3.borderRadius(10.9375f);
                                            b.a.b(afVar3, str2, false, 2, null);
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
                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView4 = NBPFeedCommentReplyItemView.this;
                final NBPReplyVO nBPReplyVO3 = nBPReplyVO;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView5 = NBPFeedCommentReplyItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView6 = NBPFeedCommentReplyItemView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 4);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView7 = NBPFeedCommentReplyItemView.this;
                                uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LongPressParams longPressParams) {
                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 5);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPReplyVO nBPReplyVO4 = nBPReplyVO3;
                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView6 = NBPFeedCommentReplyItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                String str;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo141height(18.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView7 = nBPFeedCommentReplyItemView6;
                                final NBPReplyVO nBPReplyVO5 = NBPReplyVO.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView8 = NBPFeedCommentReplyItemView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                u uVar2 = uVar;
                                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView9 = NBPFeedCommentReplyItemView.this;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 2);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView10 = NBPFeedCommentReplyItemView.this;
                                                uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.2.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LongPressParams longPressParams) {
                                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 5);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPReplyVO nBPReplyVO6 = nBPReplyVO5;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPReplyVO nBPReplyVO7 = NBPReplyVO.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str2;
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                        ceVar2.lineHeight(18.0f);
                                                        ceVar2.m144maxWidth(100.0f);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.lines(1);
                                                        ceVar2.color(QUIToken.color$default("text_secondary_light"));
                                                        s35.af afVar = NBPReplyVO.this.user;
                                                        if (afVar == null || (str2 = afVar.f433209f) == null) {
                                                            str2 = "\u9644\u8fd1\u7528\u6237";
                                                        }
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, str2);
                                                        ceVar2.textPostProcessor("emoji");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                s35.af afVar = NBPReplyVO.this.targetUser;
                                if (afVar == null || (str = StrangerUtilsKt.getUserId(afVar, nBPFeedCommentReplyItemView6.appId)) == null) {
                                    str = "";
                                }
                                if ((str.length() > 0) && !Intrinsics.areEqual(str, "0")) {
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar2) {
                                                    af afVar3 = afVar2;
                                                    b.a.b(afVar3, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_I0LAv7rumsR.png", false, 2, null);
                                                    afVar3.size(14.0f, 18.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPReplyVO nBPReplyVO6 = NBPReplyVO.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final NBPReplyVO nBPReplyVO7 = NBPReplyVO.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.3.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    String str2;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.lineHeight(18.0f);
                                                    ceVar2.m144maxWidth(100.0f);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.lines(1);
                                                    ceVar2.color(QUIToken.color$default("text_secondary_light"));
                                                    s35.af afVar2 = NBPReplyVO.this.targetUser;
                                                    if (afVar2 == null || (str2 = afVar2.f433209f) == null) {
                                                        str2 = "\u9644\u8fd1\u7528\u6237";
                                                    }
                                                    TextViewExtKt.textWithLineHeightFix(ceVar2, str2);
                                                    ceVar2.textPostProcessor("emoji");
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
                        final NBPReplyVO nBPReplyVO5 = nBPReplyVO3;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPReplyVO nBPReplyVO6 = NBPReplyVO.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.textPostProcessor("emoji");
                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                        ceVar2.lineHeight(22.0f);
                                        ceVar2.fontWeight400();
                                        ceVar2.marginTop(4.0f);
                                        ceVar2.marginBottom(2.0f);
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        i iVar = NBPReplyVO.this.content;
                                        TextViewExtKt.textWithLineHeightFix(ceVar2, String.valueOf(iVar != null ? iVar.f425179d : null));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView7 = NBPFeedCommentReplyItemView.this;
                        final NBPReplyVO nBPReplyVO6 = nBPReplyVO3;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.mo141height(18.0f);
                                        tVar2.m140flex(1.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView8 = NBPFeedCommentReplyItemView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView9 = NBPFeedCommentReplyItemView.this;
                                        uVar.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LongPressParams longPressParams) {
                                                NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 5);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPReplyVO nBPReplyVO7 = nBPReplyVO6;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPReplyVO nBPReplyVO8 = NBPReplyVO.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                ceVar2.lineHeight(18.0f);
                                                ceVar2.color(QUIToken.color$default("text_secondary_light"));
                                                ceVar2.fontWeight400();
                                                TextViewExtKt.textWithLineHeightFix(ceVar2, NearbyFormatUtils.INSTANCE.formatFeedTime(NBPReplyVO.this.cTime * 1000));
                                                ceVar2.marginRight(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView9 = NBPFeedCommentReplyItemView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView10 = NBPFeedCommentReplyItemView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView11 = NBPFeedCommentReplyItemView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPFeedCommentReplyItemView.access$onReplyClick(NBPFeedCommentReplyItemView.this, 3);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.4.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView.body.1.5.5.4.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                        ceVar2.lineHeight(18.0f);
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        ceVar2.fontWeight500();
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u56de\u590d");
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedCommentReplyItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedCommentReplyItemViewEvent();
    }
}
