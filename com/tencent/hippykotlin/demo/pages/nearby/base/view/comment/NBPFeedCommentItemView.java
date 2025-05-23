package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
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
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import p35.i;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFeedCommentItemView extends ComposeView<NBPFeedCommentItemViewAttr, NBPFeedCommentItemViewEvent> {
    public final int appId;
    public aa<NBPFeedLCommentHighlightView> highlightRef;
    public Map<Long, aa<NBPFeedCommentReplyItemView>> replyViewRefs = new LinkedHashMap();

    public NBPFeedCommentItemView(int i3) {
        this.appId = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedCommentItemViewEvent access$getEvent(NBPFeedCommentItemView nBPFeedCommentItemView) {
        return (NBPFeedCommentItemViewEvent) nBPFeedCommentItemView.getEvent();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
    
        if (r5 == true) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$onCommentClick(NBPFeedCommentItemView nBPFeedCommentItemView, int i3) {
        boolean z16;
        aa<NBPFeedLCommentHighlightView> aaVar;
        NBPFeedLCommentHighlightView b16;
        NBPCommentVO nBPCommentVO = ((NBPFeedCommentItemViewAttr) nBPFeedCommentItemView.getAttr()).comment;
        if (nBPCommentVO == null) {
            return;
        }
        Function1<? super CommentClickInfo, Boolean> function1 = ((NBPFeedCommentItemViewEvent) nBPFeedCommentItemView.getEvent()).onClickHandler;
        if (function1 != null) {
            boolean booleanValue = function1.invoke(new CommentClickInfo(i3, nBPCommentVO, null)).booleanValue();
            z16 = true;
        }
        z16 = false;
        if (!z16 || (aaVar = nBPFeedCommentItemView.highlightRef) == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.trigger();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPCommentVO nBPCommentVO = ((NBPFeedCommentItemViewAttr) getAttr()).comment;
        if (nBPCommentVO == null) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView$body$comment$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        final c<NBPReplyVO> replies = ((NBPFeedCommentItemViewAttr) getAttr()).getReplies();
        String str = nBPCommentVO.feedPosterUserId;
        af afVar = nBPCommentVO.user;
        final boolean areEqual = Intrinsics.areEqual(str, afVar != null ? StrangerUtilsKt.getUserId(afVar, this.appId) : null);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPFeedCommentItemView nBPFeedCommentItemView = NBPFeedCommentItemView.this;
                final NBPCommentVO nBPCommentVO2 = nBPCommentVO;
                final boolean z16 = areEqual;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentItemView nBPFeedCommentItemView2 = NBPFeedCommentItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPFeedCommentItemView nBPFeedCommentItemView3 = NBPFeedCommentItemView.this;
                                uVar.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LongPressParams longPressParams) {
                                        NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 5);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentItemView nBPFeedCommentItemView3 = NBPFeedCommentItemView.this;
                        vVar2.addChild(new NBPFeedLCommentHighlightView(), new Function1<NBPFeedLCommentHighlightView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedLCommentHighlightView nBPFeedLCommentHighlightView) {
                                NBPFeedLCommentHighlightView nBPFeedLCommentHighlightView2 = nBPFeedLCommentHighlightView;
                                final NBPFeedCommentItemView nBPFeedCommentItemView4 = NBPFeedCommentItemView.this;
                                nBPFeedLCommentHighlightView2.ref(nBPFeedLCommentHighlightView2, new Function1<aa<NBPFeedLCommentHighlightView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<NBPFeedLCommentHighlightView> aaVar) {
                                        NBPFeedCommentItemView.this.highlightRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCommentVO nBPCommentVO3 = nBPCommentVO2;
                        final NBPFeedCommentItemView nBPFeedCommentItemView4 = NBPFeedCommentItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final String str2;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 36.0f);
                                        tVar2.allCenter();
                                        tVar2.marginRight(10.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentItemView nBPFeedCommentItemView5 = nBPFeedCommentItemView4;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NBPFeedCommentItemView nBPFeedCommentItemView6 = NBPFeedCommentItemView.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentItemView nBPFeedCommentItemView7 = NBPFeedCommentItemView.this;
                                        uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LongPressParams longPressParams) {
                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 5);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCommentVO nBPCommentVO4 = NBPCommentVO.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPCommentVO nBPCommentVO5 = NBPCommentVO.this;
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                String str3;
                                                com.tencent.kuikly.core.views.af afVar3 = afVar2;
                                                afVar3.size(36.0f, 36.0f);
                                                afVar3.borderRadius(18.0f);
                                                afVar3.absolutePositionAllZero();
                                                afVar3.mo113backgroundColor(new h(167793150L));
                                                af afVar4 = NBPCommentVO.this.user;
                                                if (afVar4 == null || (str3 = afVar4.E) == null) {
                                                    str3 = "";
                                                }
                                                b.a.b(afVar3, str3, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                af afVar2 = NBPCommentVO.this.user;
                                if (afVar2 != null) {
                                    str2 = StrangerUtilsKt.getAvatarDressFrameUrl(afVar2);
                                } else {
                                    str2 = "";
                                }
                                if (str2.length() > 0) {
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final String str3 = str2;
                                            imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.4.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(com.tencent.kuikly.core.views.af afVar3) {
                                                    com.tencent.kuikly.core.views.af afVar4 = afVar3;
                                                    afVar4.size(39.375f, 39.375f);
                                                    afVar4.borderRadius(19.6875f);
                                                    b.a.b(afVar4, str3, false, 2, null);
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
                        final NBPFeedCommentItemView nBPFeedCommentItemView5 = NBPFeedCommentItemView.this;
                        final boolean z17 = z16;
                        final NBPCommentVO nBPCommentVO4 = nBPCommentVO2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentItemView nBPFeedCommentItemView6 = NBPFeedCommentItemView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NBPFeedCommentItemView nBPFeedCommentItemView7 = NBPFeedCommentItemView.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 4);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentItemView nBPFeedCommentItemView8 = NBPFeedCommentItemView.this;
                                        uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LongPressParams longPressParams) {
                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 5);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final boolean z18 = z17;
                                final NBPFeedCommentItemView nBPFeedCommentItemView7 = NBPFeedCommentItemView.this;
                                final NBPCommentVO nBPCommentVO5 = nBPCommentVO4;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(18.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentItemView nBPFeedCommentItemView8 = nBPFeedCommentItemView7;
                                        final NBPCommentVO nBPCommentVO6 = nBPCommentVO5;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                final NBPFeedCommentItemView nBPFeedCommentItemView9 = NBPFeedCommentItemView.this;
                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        u uVar2 = uVar;
                                                        final NBPFeedCommentItemView nBPFeedCommentItemView10 = NBPFeedCommentItemView.this;
                                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.2.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 2);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFeedCommentItemView nBPFeedCommentItemView11 = NBPFeedCommentItemView.this;
                                                        uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.2.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LongPressParams longPressParams) {
                                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 5);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCommentVO nBPCommentVO7 = nBPCommentVO6;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPCommentVO nBPCommentVO8 = NBPCommentVO.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str2;
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                ceVar2.lineHeight(18.0f);
                                                                ceVar2.m144maxWidth(180.0f);
                                                                ceVar2.fontWeight400();
                                                                ceVar2.lines(1);
                                                                ceVar2.color(QUIToken.color$default("text_secondary_light"));
                                                                af afVar2 = NBPCommentVO.this.user;
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        if (z18) {
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.m136border(new e(0.5f, BorderStyle.SOLID, new h(4287664276L)));
                                                            tVar2.borderRadius(2.0f);
                                                            tVar2.marginLeft(4.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.3.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.3.3.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ce.fontSize$default(ceVar2, 9.0f, null, 2, null);
                                                                    ceVar2.lineHeight(12.0f);
                                                                    ceVar2.fontWeight500();
                                                                    ceVar2.color(new h(4285953914L));
                                                                    TextViewExtKt.textWithLineHeightFix(ceVar2, "\u4f5c\u8005");
                                                                    ceVar2.margin(1.0f, 4.0f, 1.0f, 4.0f);
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
                                final NBPCommentVO nBPCommentVO6 = nBPCommentVO4;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPCommentVO nBPCommentVO7 = NBPCommentVO.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.4.1
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
                                                i iVar = NBPCommentVO.this.content;
                                                TextViewExtKt.textWithLineHeightFix(ceVar2, String.valueOf(iVar != null ? iVar.f425179d : null));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentItemView nBPFeedCommentItemView8 = NBPFeedCommentItemView.this;
                                final NBPCommentVO nBPCommentVO7 = nBPCommentVO4;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.1
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
                                        final NBPFeedCommentItemView nBPFeedCommentItemView9 = NBPFeedCommentItemView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPFeedCommentItemView nBPFeedCommentItemView10 = NBPFeedCommentItemView.this;
                                                uVar.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LongPressParams longPressParams) {
                                                        NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 5);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPCommentVO nBPCommentVO8 = nBPCommentVO7;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPCommentVO nBPCommentVO9 = NBPCommentVO.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.3.1
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
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, NearbyFormatUtils.INSTANCE.formatFeedTime(NBPCommentVO.this.cTime * 1000));
                                                        ceVar2.marginRight(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentItemView nBPFeedCommentItemView10 = NBPFeedCommentItemView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                final NBPFeedCommentItemView nBPFeedCommentItemView11 = NBPFeedCommentItemView.this;
                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPFeedCommentItemView nBPFeedCommentItemView12 = NBPFeedCommentItemView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.4.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPFeedCommentItemView.access$onCommentClick(NBPFeedCommentItemView.this, 3);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.4.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.1.5.5.4.2.1
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
                });
                final c<NBPReplyVO> cVar = replies;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(!cVar.isEmpty());
                    }
                };
                final c<NBPReplyVO> cVar2 = replies;
                final NBPFeedCommentItemView nBPFeedCommentItemView2 = NBPFeedCommentItemView.this;
                final NBPCommentVO nBPCommentVO3 = nBPCommentVO;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final c<NBPReplyVO> cVar3 = cVar2;
                        final NBPFeedCommentItemView nBPFeedCommentItemView3 = nBPFeedCommentItemView2;
                        final NBPCommentVO nBPCommentVO4 = nBPCommentVO3;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginBottom(10.0f);
                                        tVar2.marginLeft(46.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final c<NBPReplyVO> cVar4 = cVar3;
                                Function0<c<NBPReplyVO>> function02 = new Function0<c<NBPReplyVO>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<NBPReplyVO> invoke() {
                                        return cVar4;
                                    }
                                };
                                final NBPFeedCommentItemView nBPFeedCommentItemView4 = nBPFeedCommentItemView3;
                                final NBPCommentVO nBPCommentVO5 = nBPCommentVO4;
                                LoopDirectivesViewKt.b(vVar2, function02, new Function4<LoopDirectivesView<NBPReplyVO>, NBPReplyVO, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public final Unit invoke(LoopDirectivesView<NBPReplyVO> loopDirectivesView, NBPReplyVO nBPReplyVO, Integer num, Integer num2) {
                                        LoopDirectivesView<NBPReplyVO> loopDirectivesView2 = loopDirectivesView;
                                        final NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                                        int intValue = num.intValue();
                                        num2.intValue();
                                        if (intValue < 2) {
                                            final NBPFeedCommentItemView nBPFeedCommentItemView5 = NBPFeedCommentItemView.this;
                                            int i3 = nBPFeedCommentItemView5.appId;
                                            final NBPCommentVO nBPCommentVO6 = nBPCommentVO5;
                                            loopDirectivesView2.addChild(new NBPFeedCommentReplyItemView(i3), new Function1<NBPFeedCommentReplyItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView) {
                                                    NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView2 = nBPFeedCommentReplyItemView;
                                                    final NBPFeedCommentItemView nBPFeedCommentItemView6 = NBPFeedCommentItemView.this;
                                                    final NBPReplyVO nBPReplyVO3 = nBPReplyVO2;
                                                    nBPFeedCommentReplyItemView2.ref(nBPFeedCommentReplyItemView2, new Function1<aa<NBPFeedCommentReplyItemView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.3.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(aa<NBPFeedCommentReplyItemView> aaVar) {
                                                            NBPFeedCommentItemView.this.replyViewRefs.put(Long.valueOf(nBPReplyVO3.key), aaVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPCommentVO nBPCommentVO7 = nBPCommentVO6;
                                                    final NBPReplyVO nBPReplyVO4 = nBPReplyVO2;
                                                    nBPFeedCommentReplyItemView2.attr(new Function1<NBPFeedCommentReplyItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.3.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPFeedCommentReplyItemViewAttr nBPFeedCommentReplyItemViewAttr) {
                                                            NBPFeedCommentReplyItemViewAttr nBPFeedCommentReplyItemViewAttr2 = nBPFeedCommentReplyItemViewAttr;
                                                            nBPFeedCommentReplyItemViewAttr2.marginTop(12.0f);
                                                            NBPCommentVO nBPCommentVO8 = NBPCommentVO.this;
                                                            NBPReplyVO nBPReplyVO5 = nBPReplyVO4;
                                                            nBPFeedCommentReplyItemViewAttr2.comment = nBPCommentVO8;
                                                            nBPFeedCommentReplyItemViewAttr2.reply = nBPReplyVO5;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedCommentItemView nBPFeedCommentItemView7 = NBPFeedCommentItemView.this;
                                                    nBPFeedCommentReplyItemView2.event(new Function1<NBPFeedCommentReplyItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.3.1.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPFeedCommentReplyItemViewEvent nBPFeedCommentReplyItemViewEvent) {
                                                            final NBPFeedCommentItemView nBPFeedCommentItemView8 = NBPFeedCommentItemView.this;
                                                            nBPFeedCommentReplyItemViewEvent.onClickHandler = new Function1<CommentClickInfo, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.3.1.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
                                                                
                                                                    if (r2 == true) goto L8;
                                                                 */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final Boolean invoke(CommentClickInfo commentClickInfo) {
                                                                    boolean z17;
                                                                    CommentClickInfo commentClickInfo2 = commentClickInfo;
                                                                    Function1<? super CommentClickInfo, Boolean> function1 = NBPFeedCommentItemView.access$getEvent(NBPFeedCommentItemView.this).onClickHandler;
                                                                    if (function1 != null) {
                                                                        boolean booleanValue = function1.invoke(commentClickInfo2).booleanValue();
                                                                        z17 = true;
                                                                    }
                                                                    z17 = false;
                                                                    return Boolean.valueOf(z17);
                                                                }
                                                            };
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
                                final NBPCommentVO nBPCommentVO6 = nBPCommentVO4;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(!NBPCommentVO.this.getRepliesFold());
                                    }
                                };
                                final c<NBPReplyVO> cVar5 = cVar3;
                                final NBPFeedCommentItemView nBPFeedCommentItemView5 = nBPFeedCommentItemView3;
                                final NBPCommentVO nBPCommentVO7 = nBPCommentVO4;
                                ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        final c<NBPReplyVO> cVar6 = cVar5;
                                        Function0<c<NBPReplyVO>> function04 = new Function0<c<NBPReplyVO>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final c<NBPReplyVO> invoke() {
                                                return cVar6;
                                            }
                                        };
                                        final NBPFeedCommentItemView nBPFeedCommentItemView6 = nBPFeedCommentItemView5;
                                        final NBPCommentVO nBPCommentVO8 = nBPCommentVO7;
                                        LoopDirectivesViewKt.b(conditionView2, function04, new Function4<LoopDirectivesView<NBPReplyVO>, NBPReplyVO, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // kotlin.jvm.functions.Function4
                                            public final Unit invoke(LoopDirectivesView<NBPReplyVO> loopDirectivesView, NBPReplyVO nBPReplyVO, Integer num, Integer num2) {
                                                LoopDirectivesView<NBPReplyVO> loopDirectivesView2 = loopDirectivesView;
                                                final NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                                                int intValue = num.intValue();
                                                num2.intValue();
                                                if (intValue >= 2) {
                                                    final NBPFeedCommentItemView nBPFeedCommentItemView7 = NBPFeedCommentItemView.this;
                                                    int i3 = nBPFeedCommentItemView7.appId;
                                                    final NBPCommentVO nBPCommentVO9 = nBPCommentVO8;
                                                    loopDirectivesView2.addChild(new NBPFeedCommentReplyItemView(i3), new Function1<NBPFeedCommentReplyItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView) {
                                                            NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView2 = nBPFeedCommentReplyItemView;
                                                            final NBPFeedCommentItemView nBPFeedCommentItemView8 = NBPFeedCommentItemView.this;
                                                            final NBPReplyVO nBPReplyVO3 = nBPReplyVO2;
                                                            nBPFeedCommentReplyItemView2.ref(nBPFeedCommentReplyItemView2, new Function1<aa<NBPFeedCommentReplyItemView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.2.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(aa<NBPFeedCommentReplyItemView> aaVar) {
                                                                    NBPFeedCommentItemView.this.replyViewRefs.put(Long.valueOf(nBPReplyVO3.key), aaVar);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPCommentVO nBPCommentVO10 = nBPCommentVO9;
                                                            final NBPReplyVO nBPReplyVO4 = nBPReplyVO2;
                                                            nBPFeedCommentReplyItemView2.attr(new Function1<NBPFeedCommentReplyItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.2.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPFeedCommentReplyItemViewAttr nBPFeedCommentReplyItemViewAttr) {
                                                                    NBPFeedCommentReplyItemViewAttr nBPFeedCommentReplyItemViewAttr2 = nBPFeedCommentReplyItemViewAttr;
                                                                    nBPFeedCommentReplyItemViewAttr2.marginTop(12.0f);
                                                                    NBPCommentVO nBPCommentVO11 = NBPCommentVO.this;
                                                                    NBPReplyVO nBPReplyVO5 = nBPReplyVO4;
                                                                    nBPFeedCommentReplyItemViewAttr2.comment = nBPCommentVO11;
                                                                    nBPFeedCommentReplyItemViewAttr2.reply = nBPReplyVO5;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPFeedCommentItemView nBPFeedCommentItemView9 = NBPFeedCommentItemView.this;
                                                            nBPFeedCommentReplyItemView2.event(new Function1<NBPFeedCommentReplyItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.2.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPFeedCommentReplyItemViewEvent nBPFeedCommentReplyItemViewEvent) {
                                                                    final NBPFeedCommentItemView nBPFeedCommentItemView10 = NBPFeedCommentItemView.this;
                                                                    nBPFeedCommentReplyItemViewEvent.onClickHandler = new Function1<CommentClickInfo, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.5.2.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
                                                                        
                                                                            if (r2 == true) goto L8;
                                                                         */
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        /*
                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                        */
                                                                        public final Boolean invoke(CommentClickInfo commentClickInfo) {
                                                                            boolean z17;
                                                                            CommentClickInfo commentClickInfo2 = commentClickInfo;
                                                                            Function1<? super CommentClickInfo, Boolean> function1 = NBPFeedCommentItemView.access$getEvent(NBPFeedCommentItemView.this).onClickHandler;
                                                                            if (function1 != null) {
                                                                                boolean booleanValue = function1.invoke(commentClickInfo2).booleanValue();
                                                                                z17 = true;
                                                                            }
                                                                            z17 = false;
                                                                            return Boolean.valueOf(z17);
                                                                        }
                                                                    };
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
                                final c<NBPReplyVO> cVar6 = cVar3;
                                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(cVar6.size() > 2);
                                    }
                                };
                                final NBPCommentVO nBPCommentVO8 = nBPCommentVO4;
                                final c<NBPReplyVO> cVar7 = cVar3;
                                ConditionViewKt.c(vVar2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        final NBPCommentVO nBPCommentVO9 = NBPCommentVO.this;
                                        final c<NBPReplyVO> cVar8 = cVar7;
                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.marginLeft(28.0f);
                                                        tVar2.marginTop(12.0f);
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCommentVO nBPCommentVO10 = NBPCommentVO.this;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPCommentVO nBPCommentVO11 = NBPCommentVO.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPCommentVO nBPCommentVO12 = NBPCommentVO.this;
                                                                nBPCommentVO12.repliesFold$delegate.setValue(nBPCommentVO12, NBPCommentVO.$$delegatedProperties[0], Boolean.valueOf(!nBPCommentVO12.getRepliesFold()));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCommentVO nBPCommentVO11 = NBPCommentVO.this;
                                                final c<NBPReplyVO> cVar9 = cVar8;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPCommentVO nBPCommentVO12 = NBPCommentVO.this;
                                                        final c<NBPReplyVO> cVar10 = cVar9;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str2;
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                ceVar2.mo141height(20.0f);
                                                                ceVar2.lineHeight(20.0f);
                                                                ceVar2.marginRight(2.0f);
                                                                if (NBPCommentVO.this.getRepliesFold()) {
                                                                    str2 = "\u5c55\u5f00";
                                                                } else {
                                                                    str2 = "\u6536\u8d77";
                                                                }
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str2);
                                                                m3.append(cVar10.size() - 2);
                                                                m3.append("\u6761\u56de\u590d");
                                                                TextViewExtKt.textWithLineHeightFix(ceVar2, m3.toString());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPCommentVO nBPCommentVO12 = NBPCommentVO.this;
                                                ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.4
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(NBPCommentVO.this.getRepliesFold());
                                                    }
                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.5
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView3) {
                                                        ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.5.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.5.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                                        com.tencent.kuikly.core.views.af afVar3 = afVar2;
                                                                        afVar3.size(12.0f, 12.0f);
                                                                        b.a.b(afVar3, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_xSgu3R6aeel.png", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.6
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView3) {
                                                        ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.6.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemView.body.1.3.1.7.1.6.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                                        com.tencent.kuikly.core.views.af afVar3 = afVar2;
                                                                        afVar3.size(12.0f, 12.0f);
                                                                        b.a.b(afVar3, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_xSgu3R6aeel.png", false, 2, null);
                                                                        afVar3.transform(new com.tencent.kuikly.core.base.t(180.0f, 0.0f, 0.0f, 6, null));
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedCommentItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedCommentItemViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void expandReplies() {
        NBPCommentVO nBPCommentVO = ((NBPFeedCommentItemViewAttr) getAttr()).comment;
        if (nBPCommentVO == null) {
            return;
        }
        nBPCommentVO.repliesFold$delegate.setValue(nBPCommentVO, NBPCommentVO.$$delegatedProperties[0], Boolean.FALSE);
    }
}
