package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPKuiklyQQEmojiView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPKuiklyQQEmojiViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPKuiklyQQEmojiViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectEvent;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectEvent;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ak;
import com.tencent.kuikly.core.views.al;
import com.tencent.kuikly.core.views.cc;
import com.tencent.kuikly.core.views.cd;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tenpay.proxy.dlg.location.QbAddrData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputView extends ComposeView<NBPFeedCommentInputViewAttr, NBPFeedCommentInputViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "emojiIconState", "getEmojiIconState()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "currentPanelState", "getCurrentPanelState()Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/CommentPanelState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "keepEmojiPanel", "getKeepEmojiPanel()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "keepAiQuickCommentsPanel", "getKeepAiQuickCommentsPanel()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "inputBarHeight", "getInputBarHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "opacity", "getOpacity()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "panelHeight", "getPanelHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "inputSpans", "getInputSpans()Lcom/tencent/kuikly/core/views/InputSpans;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "inputText", "getInputText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentInputView.class, "inputAreaHeight", "getInputAreaHeight()F", 0)};
    public final ReadWriteProperty currentPanelState$delegate;
    public final Function1<Object, Unit> emojiCallbackHandler;
    public final ReadWriteProperty emojiIconState$delegate;
    public final ReadWriteProperty inputAreaHeight$delegate;
    public final ReadWriteProperty inputBarHeight$delegate;
    public final ReadWriteProperty inputSpans$delegate;
    public final ReadWriteProperty inputText$delegate;
    public aa<TextAreaView> inputViewRef;
    public final ReadWriteProperty keepAiQuickCommentsPanel$delegate;
    public final ReadWriteProperty keepEmojiPanel$delegate;
    public final Function1<Object, Unit> onDeleteBtnClickCallbackHandler;
    public final Function1<Object, Unit> onSendBtnClickCallbackHandler;
    public final ReadWriteProperty opacity$delegate;
    public final ReadWriteProperty panelHeight$delegate;
    public boolean textLengthBeyondLimitToasting;

    public NBPFeedCommentInputView() {
        Boolean bool = Boolean.FALSE;
        this.emojiIconState$delegate = c.a(bool);
        this.currentPanelState$delegate = c.a(CommentPanelState.None);
        this.keepEmojiPanel$delegate = c.a(bool);
        this.keepAiQuickCommentsPanel$delegate = c.a(bool);
        Float valueOf = Float.valueOf(0.0f);
        this.inputBarHeight$delegate = c.a(valueOf);
        this.opacity$delegate = c.a(valueOf);
        this.panelHeight$delegate = c.a(valueOf);
        this.inputSpans$delegate = c.a(new al());
        this.emojiCallbackHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$emojiCallbackHandler$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                TextAreaView b16;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                String p16 = ((e) obj).p("emoji");
                NBPFeedCommentInputView nBPFeedCommentInputView = NBPFeedCommentInputView.this;
                aa<TextAreaView> aaVar = nBPFeedCommentInputView.inputViewRef;
                if (aaVar != null && (b16 = aaVar.b()) != null) {
                    b16.k(new NBPFeedCommentInputView$manuallyAppendText$1(nBPFeedCommentInputView, p16));
                }
                return Unit.INSTANCE;
            }
        };
        this.onDeleteBtnClickCallbackHandler = new NBPFeedCommentInputView$onDeleteBtnClickCallbackHandler$1(this);
        this.onSendBtnClickCallbackHandler = new NBPFeedCommentInputView$onSendBtnClickCallbackHandler$1(this);
        this.inputText$delegate = c.a("");
        this.inputAreaHeight$delegate = c.a(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedCommentInputViewAttr access$getAttr(NBPFeedCommentInputView nBPFeedCommentInputView) {
        return (NBPFeedCommentInputViewAttr) nBPFeedCommentInputView.getAttr();
    }

    public static final void access$onSend(NBPFeedCommentInputView nBPFeedCommentInputView) {
        TextAreaView b16;
        CharSequence trim;
        aa<TextAreaView> aaVar = nBPFeedCommentInputView.inputViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        if (nBPFeedCommentInputView.getInputText().length() <= 140) {
            trim = StringsKt__StringsKt.trim((CharSequence) nBPFeedCommentInputView.getInputText());
            if (trim.toString().length() == 0) {
                Utils.INSTANCE.currentBridgeModule().qToast("\u8f93\u5165\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a", QToastMode.Warning);
                return;
            } else {
                b16.h();
                nBPFeedCommentInputView.hide(true);
                return;
            }
        }
        Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u8d85\u8fc7\u5b57\u6570\u6700\u5927\u9650\u5236", QToastMode.Warning);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$submitByQuickComment(NBPFeedCommentInputView nBPFeedCommentInputView, String str) {
        Function3<? super Boolean, ? super String, ? super Boolean, Unit> function3 = ((NBPFeedCommentInputViewEvent) nBPFeedCommentInputView.getEvent()).onCloseCallback;
        if (function3 != null) {
            Boolean bool = Boolean.TRUE;
            function3.invoke(bool, str, bool);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        String str = ((NBPFeedCommentInputViewAttr) getAttr()).cachedText;
        ReadWriteProperty readWriteProperty = this.inputText$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[8], str);
        if (getInputText().length() > 0) {
            al alVar = new al();
            ak akVar = new ak();
            akVar.e(getInputText());
            akVar.a(QUIToken.color$default("text_primary"));
            akVar.b(Float.valueOf(16.0f));
            alVar.a(akVar);
            this.inputSpans$delegate.setValue(this, kPropertyArr[7], alVar);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    aa<TextAreaView> aaVar;
                    TextAreaView b16;
                    TextAreaView b17;
                    NBPFeedCommentInputView nBPFeedCommentInputView = NBPFeedCommentInputView.this;
                    aa<TextAreaView> aaVar2 = nBPFeedCommentInputView.inputViewRef;
                    if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                        b17.m(new NBPFeedCommentInputView$autoFitInputHeight$1(nBPFeedCommentInputView));
                    }
                    if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(com.tencent.kuikly.core.manager.c.f117352a) && (aaVar = NBPFeedCommentInputView.this.inputViewRef) != null && (b16 = aaVar.b()) != null) {
                        b16.n(NBPFeedCommentInputView.this.getInputText().length());
                    }
                    return Unit.INSTANCE;
                }
            };
            KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
            TimerKt.e(getPagerId(), 100, function0);
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPFeedCommentInputView nBPFeedCommentInputView = NBPFeedCommentInputView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        b l3;
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        mVar2.absolutePositionAllZero();
                        mVar2.mo113backgroundColor(QUIToken.color$default("overlay_standard_secondary"));
                        NBPFeedCommentInputView nBPFeedCommentInputView2 = NBPFeedCommentInputView.this;
                        KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                        if (nBPFeedCommentInputView2.getPagerData().getIsIOS()) {
                            l3 = b.Companion.f(b.INSTANCE, 0.25f, null, 2, null).h(0.25f);
                        } else {
                            l3 = b.Companion.l(b.INSTANCE, 0.25f, null, 2, null);
                        }
                        NBPFeedCommentInputView nBPFeedCommentInputView3 = NBPFeedCommentInputView.this;
                        ReadWriteProperty readWriteProperty2 = nBPFeedCommentInputView3.opacity$delegate;
                        KProperty<?>[] kPropertyArr4 = NBPFeedCommentInputView.$$delegatedProperties;
                        mVar2.animate(l3, Float.valueOf(((Number) readWriteProperty2.getValue(nBPFeedCommentInputView3, kPropertyArr4[5])).floatValue()));
                        NBPFeedCommentInputView nBPFeedCommentInputView4 = NBPFeedCommentInputView.this;
                        mVar2.m147opacity(((Number) nBPFeedCommentInputView4.opacity$delegate.getValue(nBPFeedCommentInputView4, kPropertyArr4[5])).floatValue());
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedCommentInputView nBPFeedCommentInputView2 = NBPFeedCommentInputView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPFeedCommentInputView nBPFeedCommentInputView3 = NBPFeedCommentInputView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                TextAreaView b16;
                                aa<TextAreaView> aaVar = NBPFeedCommentInputView.this.inputViewRef;
                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                    b16.h();
                                }
                                NBPFeedCommentInputView.this.hide(false);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedCommentInputView nBPFeedCommentInputView3 = NBPFeedCommentInputView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPFeedCommentInputView nBPFeedCommentInputView4 = NBPFeedCommentInputView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                float floatValue;
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_top_light"));
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                floatValue = ((Number) r1.panelHeight$delegate.getValue(NBPFeedCommentInputView.this, NBPFeedCommentInputView.$$delegatedProperties[6])).floatValue();
                                tVar2.transform(new y(0.0f, 0.0f, 0.0f, (-floatValue) + 1.0f, 6, null));
                                tVar2.mo139boxShadow(new g(0.0f, -4.0f, 8.0f, new h(251658240L)));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentInputView nBPFeedCommentInputView5 = NBPFeedCommentInputView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPFeedCommentInputView nBPFeedCommentInputView6 = NBPFeedCommentInputView.this;
                                FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        NBPFeedCommentInputView nBPFeedCommentInputView7 = NBPFeedCommentInputView.this;
                                        nBPFeedCommentInputView7.inputBarHeight$delegate.setValue(nBPFeedCommentInputView7, NBPFeedCommentInputView.$$delegatedProperties[4], Float.valueOf(dVar.getHeight()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.mo141height(0.5f);
                                        tVar2.mo113backgroundColor(new h(218103808L));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentInputView nBPFeedCommentInputView6 = NBPFeedCommentInputView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean z16 = true;
                                if (!(!NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).aiQuickComments.isEmpty()) && !(!NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).quickComments.isEmpty())) {
                                    z16 = false;
                                }
                                return Boolean.valueOf(z16);
                            }
                        };
                        final NBPFeedCommentInputView nBPFeedCommentInputView7 = NBPFeedCommentInputView.this;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                                NBPFeedQuickCommentSelectViewKt.NBPFeedQuickCommentSelect(conditionView, new Function1<NBPFeedQuickCommentSelectView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView) {
                                        NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView2 = nBPFeedQuickCommentSelectView;
                                        final NBPFeedCommentInputView nBPFeedCommentInputView9 = NBPFeedCommentInputView.this;
                                        nBPFeedQuickCommentSelectView2.attr(new Function1<NBPFeedQuickCommentSelectAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr) {
                                                NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr2 = nBPFeedQuickCommentSelectAttr;
                                                nBPFeedQuickCommentSelectAttr2.mo153width(nBPFeedQuickCommentSelectAttr2.getPagerData().m());
                                                nBPFeedQuickCommentSelectAttr2.setQuickComments(NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).quickComments);
                                                nBPFeedQuickCommentSelectAttr2.setAiQuickComments(NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).aiQuickComments);
                                                nBPFeedQuickCommentSelectAttr2.isAIQuickCommentMode$delegate.setValue(nBPFeedQuickCommentSelectAttr2, NBPFeedQuickCommentSelectAttr.$$delegatedProperties[2], Boolean.valueOf(NBPFeedCommentInputView.this.getCurrentPanelState() == CommentPanelState.AI_Quick_Comments));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                        nBPFeedQuickCommentSelectView2.event(new Function1<NBPFeedQuickCommentSelectEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPFeedQuickCommentSelectEvent nBPFeedQuickCommentSelectEvent) {
                                                NBPFeedQuickCommentSelectEvent nBPFeedQuickCommentSelectEvent2 = nBPFeedQuickCommentSelectEvent;
                                                final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                                nBPFeedQuickCommentSelectEvent2.onSelectHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                        QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                        if (quickCommentItem2 != null) {
                                                            NBPFeedCommentInputView.access$submitByQuickComment(NBPFeedCommentInputView.this, quickCommentItem2.text);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                nBPFeedQuickCommentSelectEvent2.onExposeHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5.1.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(QuickCommentItem quickCommentItem) {
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                                nBPFeedQuickCommentSelectEvent2.onClickAIHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.5.1.2.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPFeedCommentInputView nBPFeedCommentInputView13 = NBPFeedCommentInputView.this;
                                                        KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                                                        CommentPanelState currentPanelState = nBPFeedCommentInputView13.getCurrentPanelState();
                                                        CommentPanelState commentPanelState = CommentPanelState.AI_Quick_Comments;
                                                        if (currentPanelState != commentPanelState) {
                                                            NBPFeedCommentInputView.this.switchPanelState(commentPanelState);
                                                        } else {
                                                            NBPFeedCommentInputView.this.switchPanelState(CommentPanelState.Keyboard);
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
                        final NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.padding(7.5f, 12.0f, 9.0f, 12.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentInputView nBPFeedCommentInputView9 = NBPFeedCommentInputView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.paddingLeft(8.0f);
                                                tVar2.paddingRight(8.0f);
                                                tVar2.paddingTop(7.0f);
                                                tVar2.paddingBottom(7.0f);
                                                tVar2.borderRadius(8.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                        cd.a(vVar6, new Function1<TextAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextAreaView textAreaView) {
                                                TextAreaView textAreaView2 = textAreaView;
                                                final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                                textAreaView2.ref(textAreaView2, new Function1<aa<TextAreaView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<TextAreaView> aaVar) {
                                                        NBPFeedCommentInputView.this.inputViewRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                                textAreaView2.attr(new Function1<cc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(cc ccVar) {
                                                        cc ccVar2 = ccVar;
                                                        ccVar2.i(QUIToken.color$default("text_primary"));
                                                        ccVar2.m140flex(1.0f);
                                                        cc.m(ccVar2, 16.0f, null, 2, null);
                                                        NBPFeedCommentInputView nBPFeedCommentInputView13 = NBPFeedCommentInputView.this;
                                                        ReadWriteProperty readWriteProperty2 = nBPFeedCommentInputView13.inputAreaHeight$delegate;
                                                        KProperty<?>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                                                        ccVar2.mo141height(((Number) readWriteProperty2.getValue(nBPFeedCommentInputView13, kPropertyArr3[9])).floatValue());
                                                        ccVar2.h(NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).panelState == CommentPanelState.None);
                                                        ccVar2.v(140);
                                                        NBPFeedCommentInputView nBPFeedCommentInputView14 = NBPFeedCommentInputView.this;
                                                        ccVar2.r((al) nBPFeedCommentInputView14.inputSpans$delegate.getValue(nBPFeedCommentInputView14, kPropertyArr3[7]));
                                                        ccVar2.with("textPostProcessor", HippyTextInputController.CLASS_NAME);
                                                        ccVar2.w(NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).placeHolder);
                                                        ccVar2.x(QUIToken.color$default("text_secondary"));
                                                        ccVar2.C();
                                                        if (NBPFeedCommentInputView.this.getPagerData().getIsAndroid()) {
                                                            ccVar2.m145minHeight(23.27f);
                                                        } else {
                                                            ccVar2.m145minHeight(22.0f);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentInputView nBPFeedCommentInputView13 = NBPFeedCommentInputView.this;
                                                textAreaView2.event(new Function1<TextAreaEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextAreaEvent textAreaEvent) {
                                                        final TextAreaEvent textAreaEvent2 = textAreaEvent;
                                                        final NBPFeedCommentInputView nBPFeedCommentInputView14 = NBPFeedCommentInputView.this;
                                                        TextAreaEvent.k(textAreaEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(KeyboardParams keyboardParams) {
                                                                KeyboardParams keyboardParams2 = keyboardParams;
                                                                KLog kLog = KLog.INSTANCE;
                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("keyboardHeightChange: ");
                                                                m3.append(keyboardParams2.getHeight());
                                                                m3.append(QbAddrData.DATA_SPLITER);
                                                                m3.append(keyboardParams2.getDuration());
                                                                kLog.i("NBPFeedCommentInputView", m3.toString());
                                                                NBPFeedCommentInputView nBPFeedCommentInputView15 = NBPFeedCommentInputView.this;
                                                                float height = keyboardParams2.getHeight();
                                                                KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                                                                nBPFeedCommentInputView15.changePanelHeight(height, true);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
                                                        final NBPFeedCommentInputView nBPFeedCommentInputView15 = NBPFeedCommentInputView.this;
                                                        TextAreaEvent.o(textAreaEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                TextAreaView b16;
                                                                NBPFeedCommentInputView nBPFeedCommentInputView16 = NBPFeedCommentInputView.this;
                                                                nBPFeedCommentInputView16.inputText$delegate.setValue(nBPFeedCommentInputView16, NBPFeedCommentInputView.$$delegatedProperties[8], inputParams.getText());
                                                                NBPFeedCommentInputView nBPFeedCommentInputView17 = NBPFeedCommentInputView.this;
                                                                aa<TextAreaView> aaVar = nBPFeedCommentInputView17.inputViewRef;
                                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                    b16.m(new NBPFeedCommentInputView$autoFitInputHeight$1(nBPFeedCommentInputView17));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
                                                        final NBPFeedCommentInputView nBPFeedCommentInputView16 = NBPFeedCommentInputView.this;
                                                        textAreaEvent2.p(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.3.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                if (!NBPFeedCommentInputView.this.textLengthBeyondLimitToasting) {
                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u8d85\u8fc7\u5b57\u6570\u6700\u5927\u9650\u5236", QToastMode.Info);
                                                                    final NBPFeedCommentInputView nBPFeedCommentInputView17 = NBPFeedCommentInputView.this;
                                                                    nBPFeedCommentInputView17.textLengthBeyondLimitToasting = true;
                                                                    TextAreaEvent textAreaEvent3 = textAreaEvent2;
                                                                    Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.3.3.1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPFeedCommentInputView.this.textLengthBeyondLimitToasting = false;
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    KProperty<Object>[] kPropertyArr3 = IPagerIdKtxKt.$$delegatedProperties;
                                                                    TimerKt.e(textAreaEvent3.getPagerId(), 300, function03);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFeedCommentInputView nBPFeedCommentInputView17 = NBPFeedCommentInputView.this;
                                                        textAreaEvent2.l(new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.2.2.3.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(String str2) {
                                                                if (Intrinsics.areEqual(str2, "send")) {
                                                                    NBPFeedCommentInputView.access$onSend(NBPFeedCommentInputView.this);
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
                                final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.marginLeft(8.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ElpocoH-PMT.png", false, 2, null);
                                                NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                                if (!((Boolean) nBPFeedCommentInputView12.emojiIconState$delegate.getValue(nBPFeedCommentInputView12, NBPFeedCommentInputView.$$delegatedProperties[0])).booleanValue()) {
                                                    afVar2.t(QUIToken.color$default("icon_primary"));
                                                } else {
                                                    afVar2.t(new h(4278229503L, 1.0f));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final NBPFeedCommentInputView nBPFeedCommentInputView13 = NBPFeedCommentInputView.this;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.3.6.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPFeedCommentInputView nBPFeedCommentInputView14 = NBPFeedCommentInputView.this;
                                                        KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                                                        CommentPanelState currentPanelState = nBPFeedCommentInputView14.getCurrentPanelState();
                                                        CommentPanelState commentPanelState = CommentPanelState.QQ_Emoji;
                                                        if (currentPanelState != commentPanelState) {
                                                            NBPFeedCommentInputView.this.switchPanelState(commentPanelState);
                                                        } else {
                                                            NBPFeedCommentInputView.this.switchPanelState(CommentPanelState.Keyboard);
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
                final NBPFeedCommentInputView nBPFeedCommentInputView4 = NBPFeedCommentInputView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16;
                        NBPFeedCommentInputView nBPFeedCommentInputView5 = NBPFeedCommentInputView.this;
                        KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                        if (nBPFeedCommentInputView5.getCurrentPanelState() != CommentPanelState.QQ_Emoji) {
                            NBPFeedCommentInputView nBPFeedCommentInputView6 = NBPFeedCommentInputView.this;
                            if (!((Boolean) nBPFeedCommentInputView6.keepEmojiPanel$delegate.getValue(nBPFeedCommentInputView6, NBPFeedCommentInputView.$$delegatedProperties[2])).booleanValue() || NBPFeedCommentInputView.this.getCurrentPanelState() != CommentPanelState.Keyboard) {
                                z16 = false;
                                return Boolean.valueOf(z16);
                            }
                        }
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPFeedCommentInputView nBPFeedCommentInputView5 = NBPFeedCommentInputView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        if (conditionView2.getPager().getPageData().getIsAndroid()) {
                            final NBPFeedCommentInputView nBPFeedCommentInputView6 = NBPFeedCommentInputView.this;
                            conditionView2.addChild(new NBPKuiklyQQEmojiView(), new Function1<NBPKuiklyQQEmojiView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPKuiklyQQEmojiView nBPKuiklyQQEmojiView) {
                                    NBPKuiklyQQEmojiView nBPKuiklyQQEmojiView2 = nBPKuiklyQQEmojiView;
                                    final NBPFeedCommentInputView nBPFeedCommentInputView7 = NBPFeedCommentInputView.this;
                                    nBPKuiklyQQEmojiView2.attr(new Function1<NBPKuiklyQQEmojiViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPKuiklyQQEmojiViewAttr nBPKuiklyQQEmojiViewAttr) {
                                            float floatValue;
                                            NBPKuiklyQQEmojiViewAttr nBPKuiklyQQEmojiViewAttr2 = nBPKuiklyQQEmojiViewAttr;
                                            float m3 = nBPKuiklyQQEmojiViewAttr2.getPagerData().m();
                                            floatValue = ((Number) r1.panelHeight$delegate.getValue(NBPFeedCommentInputView.this, NBPFeedCommentInputView.$$delegatedProperties[6])).floatValue();
                                            nBPKuiklyQQEmojiViewAttr2.size(m3, floatValue + 1.0f);
                                            Attr.absolutePosition$default(nBPKuiklyQQEmojiViewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                            nBPKuiklyQQEmojiViewAttr2.mo113backgroundColor(h.INSTANCE.m());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                                    nBPKuiklyQQEmojiView2.event(new Function1<NBPKuiklyQQEmojiViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPKuiklyQQEmojiViewEvent nBPKuiklyQQEmojiViewEvent) {
                                            nBPKuiklyQQEmojiViewEvent.register("addEmojiCallback", NBPFeedCommentInputView.this.emojiCallbackHandler);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPFeedCommentInputView nBPFeedCommentInputView7 = NBPFeedCommentInputView.this;
                            Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                                    KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                                    return Boolean.valueOf(nBPFeedCommentInputView8.getInputText().length() > 0);
                                }
                            };
                            final NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                            ConditionViewKt.c(conditionView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ConditionView conditionView3) {
                                    ConditionView conditionView4 = conditionView3;
                                    final NBPFeedCommentInputView nBPFeedCommentInputView9 = NBPFeedCommentInputView.this;
                                    w.a(conditionView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 8.0f, 66.0f, 3, null);
                                                    tVar2.size(50.0f, 29.0f);
                                                    tVar2.allCenter();
                                                    tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_primary"));
                                                    tVar2.borderRadius(3.0f);
                                                    tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, h.INSTANCE.a(0.12f)), true);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.1.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            NBPFeedCommentInputView.this.onDeleteBtnClickCallbackHandler.invoke(null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.1.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(21.0f, 15.0f);
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_qSqkzrU-24V.png", false, 2, null);
                                                            afVar2.t(QUIToken.color$default("icon_secondary"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                    w.a(conditionView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 8.0f, 8.0f, 3, null);
                                                    tVar2.size(50.0f, 29.0f);
                                                    tVar2.allCenter();
                                                    tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                    tVar2.borderRadius(3.0f);
                                                    tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, h.INSTANCE.a(0.12f)), true);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.2.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            NBPFeedCommentInputView.this.onSendBtnClickCallbackHandler.invoke(null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.2.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.3.2.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                            ceVar2.color(QUIToken.color$default("button_text_primary_default"));
                                                            ceVar2.text("\u53d1\u9001");
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
                        } else if (conditionView2.getPager().getPageData().getIsIOS()) {
                            final NBPFeedCommentInputView nBPFeedCommentInputView9 = NBPFeedCommentInputView.this;
                            conditionView2.addChild(new NBPNewQQEmojiView(), new Function1<NBPNewQQEmojiView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPNewQQEmojiView nBPNewQQEmojiView) {
                                    NBPNewQQEmojiView nBPNewQQEmojiView2 = nBPNewQQEmojiView;
                                    final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                    nBPNewQQEmojiView2.attr(new Function1<NBPNewQQEmojiAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.4.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPNewQQEmojiAttr nBPNewQQEmojiAttr) {
                                            float floatValue;
                                            NBPNewQQEmojiAttr nBPNewQQEmojiAttr2 = nBPNewQQEmojiAttr;
                                            float m3 = nBPNewQQEmojiAttr2.getPagerData().m();
                                            floatValue = ((Number) r1.panelHeight$delegate.getValue(NBPFeedCommentInputView.this, NBPFeedCommentInputView.$$delegatedProperties[6])).floatValue();
                                            nBPNewQQEmojiAttr2.size(m3, floatValue + 1.0f);
                                            Attr.absolutePosition$default(nBPNewQQEmojiAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                            nBPNewQQEmojiAttr2.showDeleteBtn$delegate.setValue(nBPNewQQEmojiAttr2, NBPNewQQEmojiAttr.$$delegatedProperties[0], Boolean.valueOf(NBPFeedCommentInputView.this.getInputText().length() > 0));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                    nBPNewQQEmojiView2.event(new Function1<NBPNewQQEmojiEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.5.4.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPNewQQEmojiEvent nBPNewQQEmojiEvent) {
                                            NBPNewQQEmojiEvent nBPNewQQEmojiEvent2 = nBPNewQQEmojiEvent;
                                            NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                            nBPNewQQEmojiEvent2.addEmojiCallbackFn = nBPFeedCommentInputView12.emojiCallbackHandler;
                                            nBPNewQQEmojiEvent2.onDeleteBtnClickFn = nBPFeedCommentInputView12.onDeleteBtnClickCallbackHandler;
                                            nBPNewQQEmojiEvent2.onSendBtnClickFn = nBPFeedCommentInputView12.onSendBtnClickCallbackHandler;
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
                final NBPFeedCommentInputView nBPFeedCommentInputView6 = NBPFeedCommentInputView.this;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16;
                        NBPFeedCommentInputView nBPFeedCommentInputView7 = NBPFeedCommentInputView.this;
                        KProperty<Object>[] kPropertyArr3 = NBPFeedCommentInputView.$$delegatedProperties;
                        if (nBPFeedCommentInputView7.getCurrentPanelState() != CommentPanelState.AI_Quick_Comments) {
                            NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                            if (!((Boolean) nBPFeedCommentInputView8.keepAiQuickCommentsPanel$delegate.getValue(nBPFeedCommentInputView8, NBPFeedCommentInputView.$$delegatedProperties[3])).booleanValue() || NBPFeedCommentInputView.this.getCurrentPanelState() != CommentPanelState.Keyboard) {
                                z16 = false;
                                return Boolean.valueOf(z16);
                            }
                        }
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPFeedCommentInputView nBPFeedCommentInputView7 = NBPFeedCommentInputView.this;
                ConditionViewKt.b(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$body$3.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPFeedCommentInputView nBPFeedCommentInputView8 = NBPFeedCommentInputView.this;
                        conditionView.addChild(new NBPFeedAIQuickCommentSelectView(), new Function1<NBPFeedAIQuickCommentSelectView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView) {
                                NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView2 = nBPFeedAIQuickCommentSelectView;
                                final NBPFeedCommentInputView nBPFeedCommentInputView9 = NBPFeedCommentInputView.this;
                                nBPFeedAIQuickCommentSelectView2.attr(new Function1<NBPFeedAIQuickCommentSelectAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.7.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedAIQuickCommentSelectAttr nBPFeedAIQuickCommentSelectAttr) {
                                        float floatValue;
                                        float floatValue2;
                                        NBPFeedAIQuickCommentSelectAttr nBPFeedAIQuickCommentSelectAttr2 = nBPFeedAIQuickCommentSelectAttr;
                                        float m3 = nBPFeedAIQuickCommentSelectAttr2.getPagerData().m();
                                        floatValue = ((Number) r1.panelHeight$delegate.getValue(NBPFeedCommentInputView.this, NBPFeedCommentInputView.$$delegatedProperties[6])).floatValue();
                                        nBPFeedAIQuickCommentSelectAttr2.size(m3, floatValue + 1.0f);
                                        Attr.absolutePosition$default(nBPFeedAIQuickCommentSelectAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                        nBPFeedAIQuickCommentSelectAttr2.mo113backgroundColor(h.INSTANCE.m());
                                        floatValue2 = ((Number) r0.panelHeight$delegate.getValue(NBPFeedCommentInputView.this, NBPFeedCommentInputView.$$delegatedProperties[6])).floatValue();
                                        nBPFeedAIQuickCommentSelectAttr2.viewHeight$delegate.setValue(nBPFeedAIQuickCommentSelectAttr2, NBPFeedAIQuickCommentSelectAttr.$$delegatedProperties[0], Float.valueOf(floatValue2));
                                        nBPFeedAIQuickCommentSelectAttr2.aiQuickComments = NBPFeedCommentInputView.access$getAttr(NBPFeedCommentInputView.this).aiQuickComments;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedCommentInputView nBPFeedCommentInputView10 = NBPFeedCommentInputView.this;
                                nBPFeedAIQuickCommentSelectView2.event(new Function1<NBPFeedAIQuickCommentSelectEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedAIQuickCommentSelectEvent nBPFeedAIQuickCommentSelectEvent) {
                                        final NBPFeedCommentInputView nBPFeedCommentInputView11 = NBPFeedCommentInputView.this;
                                        nBPFeedAIQuickCommentSelectEvent.eventHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView.body.3.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                TextAreaView b16;
                                                TextAreaView b17;
                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                String str2 = quickCommentItem.text;
                                                QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
                                                qQKuiklyPlatformApi.getClass();
                                                e eVar = new e();
                                                eVar.v("content", str2);
                                                Unit unit = Unit.INSTANCE;
                                                String syncCallNativeMethod = qQKuiklyPlatformApi.syncCallNativeMethod("convertQQEmojiDesToString", eVar, null);
                                                NBPFeedCommentInputView nBPFeedCommentInputView12 = NBPFeedCommentInputView.this;
                                                aa<TextAreaView> aaVar = nBPFeedCommentInputView12.inputViewRef;
                                                if (aaVar != null && (b17 = aaVar.b()) != null) {
                                                    b17.k(new NBPFeedCommentInputView$manuallyAppendText$1(nBPFeedCommentInputView12, syncCallNativeMethod));
                                                }
                                                aa<TextAreaView> aaVar2 = NBPFeedCommentInputView.this.inputViewRef;
                                                if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                                    b16.l();
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
                return Unit.INSTANCE;
            }
        };
    }

    public final void changePanelHeight(float f16, boolean z16) {
        KLog.INSTANCE.i("NBPFeedCommentInputView", "changePanelHeight: " + f16);
        if (f16 > 0.0f) {
            ReadWriteProperty readWriteProperty = this.opacity$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(this, kPropertyArr[5], Float.valueOf(1.0f));
            if (z16) {
                setEmojiIconState(false);
                CommentPanelState currentPanelState = getCurrentPanelState();
                setKeepEmojiPanel(currentPanelState == CommentPanelState.QQ_Emoji);
                setKeepAiQuickCommentsPanel(currentPanelState == CommentPanelState.AI_Quick_Comments);
                setCurrentPanelState(CommentPanelState.Keyboard);
            }
            this.panelHeight$delegate.setValue(this, kPropertyArr[6], Float.valueOf(f16));
        } else {
            if ((f16 == 0.0f) && getCurrentPanelState() == CommentPanelState.Keyboard) {
                setCurrentPanelState(CommentPanelState.None);
                setKeepEmojiPanel(false);
                setKeepAiQuickCommentsPanel(false);
                this.panelHeight$delegate.setValue(this, $$delegatedProperties[6], Float.valueOf(0.0f));
                hide(false);
            }
        }
        k kVar = (k) getPager().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.v("height", Float.valueOf(f16));
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "NBPFeedInputKeyBoardChangeEvent", eVar, false, 4, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedCommentInputViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedCommentInputViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        switchPanelState(((NBPFeedCommentInputViewAttr) getAttr()).panelState);
        if (((NBPFeedCommentInputViewAttr) getAttr()).panelState == CommentPanelState.None || ((NBPFeedCommentInputViewAttr) getAttr()).panelState == CommentPanelState.Keyboard) {
            return;
        }
        changePanelHeight(346.0f, false);
    }

    public final CommentPanelState getCurrentPanelState() {
        return (CommentPanelState) this.currentPanelState$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final String getInputText() {
        return (String) this.inputText$delegate.getValue(this, $$delegatedProperties[8]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hide(boolean z16) {
        Function3<? super Boolean, ? super String, ? super Boolean, Unit> function3 = ((NBPFeedCommentInputViewEvent) getEvent()).onCloseCallback;
        if (function3 != null) {
            function3.invoke(Boolean.valueOf(z16), getInputText(), Boolean.FALSE);
        }
    }

    public final void setCurrentPanelState(CommentPanelState commentPanelState) {
        this.currentPanelState$delegate.setValue(this, $$delegatedProperties[1], commentPanelState);
    }

    public final void setEmojiIconState(boolean z16) {
        this.emojiIconState$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setKeepAiQuickCommentsPanel(boolean z16) {
        this.keepAiQuickCommentsPanel$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    public final void setKeepEmojiPanel(boolean z16) {
        this.keepEmojiPanel$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public final void switchPanelState(CommentPanelState commentPanelState) {
        TextAreaView b16;
        TextAreaView b17;
        TextAreaView b18;
        TextAreaView b19;
        if (getCurrentPanelState() == commentPanelState) {
            return;
        }
        CommentPanelState currentPanelState = getCurrentPanelState();
        setCurrentPanelState(commentPanelState);
        int ordinal = commentPanelState.ordinal();
        if (ordinal == 0) {
            setEmojiIconState(false);
            aa<TextAreaView> aaVar = this.inputViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            b16.l();
            return;
        }
        if (ordinal == 1) {
            setEmojiIconState(false);
            setKeepEmojiPanel(currentPanelState == CommentPanelState.QQ_Emoji);
            setKeepAiQuickCommentsPanel(currentPanelState == CommentPanelState.AI_Quick_Comments);
            aa<TextAreaView> aaVar2 = this.inputViewRef;
            if (aaVar2 == null || (b17 = aaVar2.b()) == null) {
                return;
            }
            b17.l();
            return;
        }
        if (ordinal == 2) {
            setEmojiIconState(true);
            aa<TextAreaView> aaVar3 = this.inputViewRef;
            if (aaVar3 == null || (b18 = aaVar3.b()) == null) {
                return;
            }
            b18.h();
            return;
        }
        if (ordinal != 3) {
            return;
        }
        setEmojiIconState(false);
        aa<TextAreaView> aaVar4 = this.inputViewRef;
        if (aaVar4 == null || (b19 = aaVar4.b()) == null) {
            return;
        }
        b19.h();
    }
}
