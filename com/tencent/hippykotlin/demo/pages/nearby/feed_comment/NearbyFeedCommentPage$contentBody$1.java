package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentVO;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NearbyFeedCommentPage$contentBody$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ NearbyFeedCommentPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyFeedCommentPage$contentBody$1(NearbyFeedCommentPage nearbyFeedCommentPage) {
        super(1);
        this.this$0 = nearbyFeedCommentPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final NearbyFeedCommentPage nearbyFeedCommentPage = this.this$0;
        NearbyFeedCommentPageData nearbyFeedCommentPageData = nearbyFeedCommentPage.data;
        Integer valueOf = nearbyFeedCommentPageData != null ? Integer.valueOf(nearbyFeedCommentPageData.source) : null;
        final int i3 = 2;
        if ((valueOf == null || valueOf.intValue() != 1) && valueOf != null && valueOf.intValue() == 2) {
            i3 = 1;
        }
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$contentBody$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        tVar.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                NearbyFeedCommentPageData nearbyFeedCommentPageData2 = NearbyFeedCommentPage.this.data;
                NBPFeedCommentsData nBPFeedCommentsData = new NBPFeedCommentsData(nearbyFeedCommentPageData2 != null ? nearbyFeedCommentPageData2.appId : 0, i3, (nearbyFeedCommentPageData2 == null || (str5 = nearbyFeedCommentPageData2.viewerUserId) == null) ? "" : str5, (nearbyFeedCommentPageData2 == null || (str4 = nearbyFeedCommentPageData2.viewerNickname) == null) ? "" : str4, (nearbyFeedCommentPageData2 == null || (str3 = nearbyFeedCommentPageData2.viewerAvatar) == null) ? "" : str3, (nearbyFeedCommentPageData2 == null || (str2 = nearbyFeedCommentPageData2.posterUserId) == null) ? "" : str2, (nearbyFeedCommentPageData2 == null || (str = nearbyFeedCommentPageData2.feedId) == null) ? "" : str, nearbyFeedCommentPageData2 != null ? nearbyFeedCommentPageData2.commentInfo : null, nearbyFeedCommentPageData2 != null ? nearbyFeedCommentPageData2.likeInfo : null, null, null, false);
                String pagerId = vVar2.getPagerId();
                final NearbyFeedCommentPage nearbyFeedCommentPage2 = NearbyFeedCommentPage.this;
                NBPFeedCommentsViewKt.NBPFeedComments$default(vVar2, pagerId, "pg_nearby_comment_card_float", nBPFeedCommentsData, false, false, new Function1<NBPFeedCommentsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPFeedCommentsView nBPFeedCommentsView) {
                        NBPFeedCommentsView nBPFeedCommentsView2 = nBPFeedCommentsView;
                        final NearbyFeedCommentPage nearbyFeedCommentPage3 = NearbyFeedCommentPage.this;
                        nBPFeedCommentsView2.ref(nBPFeedCommentsView2, new Function1<aa<NBPFeedCommentsView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPFeedCommentsView> aaVar) {
                                NearbyFeedCommentPage.this.commentsViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedCommentPage nearbyFeedCommentPage4 = NearbyFeedCommentPage.this;
                        nBPFeedCommentsView2.attr(new Function1<NBPFeedCommentsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedCommentsAttr nBPFeedCommentsAttr) {
                                List<QuickCommentItem> emptyList;
                                List<QuickCommentItem> emptyList2;
                                NBPFeedCommentsAttr nBPFeedCommentsAttr2 = nBPFeedCommentsAttr;
                                nBPFeedCommentsAttr2.m140flex(1.0f);
                                nBPFeedCommentsAttr2.marginTop(12.0f);
                                NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                                if (nearbyFeedCommentPageViewModel == null || (emptyList = nearbyFeedCommentPageViewModel.getQuickComments()) == null) {
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                }
                                nBPFeedCommentsAttr2.quickComments = emptyList;
                                NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel2 = NearbyFeedCommentPage.this.pageVm;
                                if (nearbyFeedCommentPageViewModel2 == null || (emptyList2 = nearbyFeedCommentPageViewModel2.getAiQuickComments()) == null) {
                                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                                }
                                nBPFeedCommentsAttr2.aiQuickComments = emptyList2;
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedCommentPage nearbyFeedCommentPage5 = NearbyFeedCommentPage.this;
                        nBPFeedCommentsView2.event(new Function1<NBPFeedCommentsEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedCommentsEvent nBPFeedCommentsEvent) {
                                final NBPFeedCommentsEvent nBPFeedCommentsEvent2 = nBPFeedCommentsEvent;
                                final NearbyFeedCommentPage nearbyFeedCommentPage6 = NearbyFeedCommentPage.this;
                                nBPFeedCommentsEvent2.onFirstPageLoadedHandler = new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.3.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Boolean bool, Integer num) {
                                        aa<NBPFeedCommentsView> aaVar;
                                        NBPFeedCommentsView b16;
                                        boolean booleanValue = bool.booleanValue();
                                        int intValue = num.intValue();
                                        boolean z16 = false;
                                        if (!booleanValue) {
                                            NearbyFeedCommentPage nearbyFeedCommentPage7 = NearbyFeedCommentPage.this;
                                            nearbyFeedCommentPage7.loadFailed$delegate.setValue(nearbyFeedCommentPage7, NearbyFeedCommentPage.$$delegatedProperties[0], Boolean.TRUE);
                                        } else {
                                            NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                                            if (nearbyFeedCommentPageViewModel != null) {
                                                nearbyFeedCommentPageViewModel.firstPageLoaded$delegate.setValue(nearbyFeedCommentPageViewModel, NearbyFeedCommentPageViewModel.$$delegatedProperties[3], Boolean.TRUE);
                                            }
                                            NearbyFeedCommentPageData nearbyFeedCommentPageData3 = NearbyFeedCommentPage.this.data;
                                            boolean z17 = nearbyFeedCommentPageData3 != null && nearbyFeedCommentPageData3.withKeyboard;
                                            boolean z18 = intValue == 0 && !Intrinsics.areEqual(nearbyFeedCommentPageData3 != null ? nearbyFeedCommentPageData3.viewerUserId : null, nearbyFeedCommentPageData3 != null ? nearbyFeedCommentPageData3.posterUserId : null);
                                            if ((z17 || z18) && !NearbyFeedCommentPage.this.pageClosed) {
                                                z16 = true;
                                            }
                                            if (z16 && (aaVar = NearbyFeedCommentPage.this.commentsViewRef) != null && (b16 = aaVar.b()) != null) {
                                                NBPFeedCommentsView.showInput$default(b16, null, null, null, 7);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final NearbyFeedCommentPage nearbyFeedCommentPage7 = NearbyFeedCommentPage.this;
                                nBPFeedCommentsEvent2.onCountChangeHandler = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Integer num) {
                                        int intValue = num.intValue();
                                        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                                        if (nearbyFeedCommentPageViewModel != null) {
                                            nearbyFeedCommentPageViewModel.commentCount$delegate.setValue(nearbyFeedCommentPageViewModel, NearbyFeedCommentPageViewModel.$$delegatedProperties[2], Integer.valueOf(intValue));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final NearbyFeedCommentPage nearbyFeedCommentPage8 = NearbyFeedCommentPage.this;
                                nBPFeedCommentsEvent2.onAddedHandler = new Function2<NBPCommentVO, NBPReplyVO, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO) {
                                        final NBPCommentVO nBPCommentVO2 = nBPCommentVO;
                                        final NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                                        NBPFeedCommentsEvent nBPFeedCommentsEvent3 = NBPFeedCommentsEvent.this;
                                        final NearbyFeedCommentPage nearbyFeedCommentPage9 = nearbyFeedCommentPage8;
                                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.2.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                final NBPFeedCommentsView b16;
                                                aa<NBPFeedCommentsView> aaVar = NearbyFeedCommentPage.this.commentsViewRef;
                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                    long j3 = nBPCommentVO2.key;
                                                    NBPReplyVO nBPReplyVO3 = nBPReplyVO2;
                                                    b16.getCommentOffset(j3, nBPReplyVO3 != null ? Long.valueOf(nBPReplyVO3.key) : null, new Function3<Float, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$scrollTo$1
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(Float f16, Float f17, Float f18) {
                                                            aq<?, ?> b17;
                                                            f16.floatValue();
                                                            float floatValue = f17.floatValue();
                                                            f18.floatValue();
                                                            aa<aq<?, ?>> aaVar2 = NBPFeedCommentsView.this.listRef;
                                                            if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                                                ScrollerView.setContentOffset$default(b17, 0.0f, floatValue, true, null, 8, null);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                        TimerKt.e(nBPFeedCommentsEvent3.getPagerId(), 50, function0);
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }, 56);
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFeedCommentPage nearbyFeedCommentPage3 = NearbyFeedCommentPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.4
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
                    
                        if (((r0 == null || (r0 = r0.getQuickComments()) == null || !(r0.isEmpty() ^ true)) ? false : true) != false) goto L20;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        List<QuickCommentItem> aiQuickComments;
                        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                        boolean z16 = false;
                        if (!((nearbyFeedCommentPageViewModel == null || (aiQuickComments = nearbyFeedCommentPageViewModel.getAiQuickComments()) == null || !(aiQuickComments.isEmpty() ^ true)) ? false : true)) {
                            NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel2 = NearbyFeedCommentPage.this.pageVm;
                        }
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                };
                final NearbyFeedCommentPage nearbyFeedCommentPage4 = NearbyFeedCommentPage.this;
                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NearbyFeedCommentPage nearbyFeedCommentPage5 = NearbyFeedCommentPage.this;
                        NBPFeedQuickCommentSelectViewKt.NBPFeedQuickCommentSelect(conditionView, new Function1<NBPFeedQuickCommentSelectView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView) {
                                NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView2 = nBPFeedQuickCommentSelectView;
                                final NearbyFeedCommentPage nearbyFeedCommentPage6 = NearbyFeedCommentPage.this;
                                nBPFeedQuickCommentSelectView2.attr(new Function1<NBPFeedQuickCommentSelectAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr) {
                                        List<QuickCommentItem> quickComments;
                                        List<QuickCommentItem> aiQuickComments;
                                        NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr2 = nBPFeedQuickCommentSelectAttr;
                                        nBPFeedQuickCommentSelectAttr2.mo153width(nBPFeedQuickCommentSelectAttr2.getPagerData().m());
                                        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                                        if (nearbyFeedCommentPageViewModel != null && (aiQuickComments = nearbyFeedCommentPageViewModel.getAiQuickComments()) != null) {
                                            nBPFeedQuickCommentSelectAttr2.setAiQuickComments(aiQuickComments);
                                        }
                                        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel2 = NearbyFeedCommentPage.this.pageVm;
                                        if (nearbyFeedCommentPageViewModel2 != null && (quickComments = nearbyFeedCommentPageViewModel2.getQuickComments()) != null) {
                                            nBPFeedQuickCommentSelectAttr2.setQuickComments(quickComments);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedCommentPage nearbyFeedCommentPage7 = NearbyFeedCommentPage.this;
                                nBPFeedQuickCommentSelectView2.event(new Function1<NBPFeedQuickCommentSelectEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedQuickCommentSelectEvent nBPFeedQuickCommentSelectEvent) {
                                        NBPFeedQuickCommentSelectEvent nBPFeedQuickCommentSelectEvent2 = nBPFeedQuickCommentSelectEvent;
                                        final NearbyFeedCommentPage nearbyFeedCommentPage8 = NearbyFeedCommentPage.this;
                                        nBPFeedQuickCommentSelectEvent2.onSelectHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                NBPFeedCommentsView b16;
                                                QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                if (quickCommentItem2 != null) {
                                                    aa<NBPFeedCommentsView> aaVar = NearbyFeedCommentPage.this.commentsViewRef;
                                                    if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                        b16.sendQuickComment(quickCommentItem2);
                                                    }
                                                    NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm;
                                                    if (nearbyFeedCommentPageViewModel != null) {
                                                        nearbyFeedCommentPageViewModel.dtReportQuickComment("dt_clck", quickCommentItem2);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NearbyFeedCommentPage nearbyFeedCommentPage9 = NearbyFeedCommentPage.this;
                                        nBPFeedQuickCommentSelectEvent2.onExposeHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel;
                                                QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                if (quickCommentItem2 != null && (nearbyFeedCommentPageViewModel = NearbyFeedCommentPage.this.pageVm) != null) {
                                                    nearbyFeedCommentPageViewModel.dtReportQuickComment("dt_imp", quickCommentItem2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NearbyFeedCommentPage nearbyFeedCommentPage10 = NearbyFeedCommentPage.this;
                                        nBPFeedQuickCommentSelectEvent2.onClickAIHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.5.1.2.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPFeedCommentsView b16;
                                                aa<NBPFeedCommentsView> aaVar = NearbyFeedCommentPage.this.commentsViewRef;
                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                    NBPFeedCommentsView.showInput$default(b16, null, null, CommentPanelState.AI_Quick_Comments, 3);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFeedCommentPage nearbyFeedCommentPage5 = NearbyFeedCommentPage.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(36.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                tVar2.borderRadius(8.0f);
                                tVar2.margin(8.0f, 16.0f, 8.0f, 16.0f);
                                tVar2.paddingLeft(16.0f);
                                tVar2.justifyContentCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedCommentPage nearbyFeedCommentPage6 = NearbyFeedCommentPage.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.6.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NearbyFeedCommentPage nearbyFeedCommentPage7 = NearbyFeedCommentPage.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.6.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPFeedCommentsView b16;
                                        aa<NBPFeedCommentsView> aaVar = NearbyFeedCommentPage.this.commentsViewRef;
                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                            NBPFeedCommentsView.showInput$default(b16, null, null, null, 7);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.6.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.contentBody.1.1.6.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.lineHeight(24.0f);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u671f\u5f85\u4f60\u7684\u7cbe\u5f69\u70b9\u8bc4");
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
}
