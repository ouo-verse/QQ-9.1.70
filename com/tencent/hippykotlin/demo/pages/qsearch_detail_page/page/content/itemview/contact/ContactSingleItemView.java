package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageAttr;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageView;
import com.tencent.hippykotlin.demo.pages.base.QQFaceImageViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView$buildDivider$1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ContactSingleItemView extends QSearchBaseSingleItemView<ContactSingleItemAttr, ContactSingleItemEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final e access$combineReportParams(ContactSingleItemView contactSingleItemView) {
        e reportParams = contactSingleItemView.getReportParams();
        e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(((ContactSingleItemAttr) contactSingleItemView.getAttr()).getData().getReportInfo(), reportParams);
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("doc_position", ((ContactSingleItemAttr) contactSingleItemView.getAttr()).index);
        }
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("serial_number", ((ContactSingleItemAttr) contactSingleItemView.getAttr()).getData().serialNumber);
        }
        reportParams.v("transfer_info", mergeTransferInfo);
        return reportParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ContactSingleItemAttr access$getAttr(ContactSingleItemView contactSingleItemView) {
        return (ContactSingleItemAttr) contactSingleItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ContactSingleItemView contactSingleItemView = ContactSingleItemView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ContactSingleItemView contactSingleItemView2 = ContactSingleItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                float qqFontScaleAddSize = FontModuleExtKt.qqFontScaleAddSize(17.0f);
                                if (!ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().labelList.isEmpty()) {
                                    qqFontScaleAddSize += FontModuleExtKt.qqFontScaleAddSize(10.0f);
                                }
                                tVar2.mo141height(qqFontScaleAddSize + 72.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                String eid = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().getEid();
                                if (eid == null) {
                                    eid = "em_search_person_entry";
                                }
                                EcommerceExtKt.vr$default(tVar2, null, eid, ContactSingleItemView.access$combineReportParams(ContactSingleItemView.this), null, String.valueOf(ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().hashCode()), true, 9);
                                return Unit.INSTANCE;
                            }
                        });
                        final ContactSingleItemView contactSingleItemView3 = ContactSingleItemView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final ContactSingleItemView contactSingleItemView4 = ContactSingleItemView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(u.this.getPagerId()), ContactSingleItemView.access$getAttr(contactSingleItemView4).getData().jumpUrl, false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ContactSingleItemView contactSingleItemView4 = ContactSingleItemView.this;
                        QQFaceImageViewKt.QQFaceImage(vVar2, new Function1<QQFaceImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQFaceImageView qQFaceImageView) {
                                final ContactSingleItemView contactSingleItemView5 = ContactSingleItemView.this;
                                qQFaceImageView.attr(new Function1<QQFaceImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QQFaceImageAttr qQFaceImageAttr) {
                                        QQFaceImageAttr qQFaceImageAttr2 = qQFaceImageAttr;
                                        qQFaceImageAttr2.src(ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().uin, 0);
                                        qQFaceImageAttr2.size(52.0f, 52.0f);
                                        qQFaceImageAttr2.borderRadius(26.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ContactSingleItemView contactSingleItemView5 = ContactSingleItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionColumn();
                                        tVar2.marginLeft(12.0f);
                                        tVar2.marginRight(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ContactSingleItemView contactSingleItemView6 = ContactSingleItemView.this;
                                HighlightTextViewKt.HighlightText(vVar4, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HighlightTextView highlightTextView) {
                                        final ContactSingleItemView contactSingleItemView7 = ContactSingleItemView.this;
                                        highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HighlightAttr highlightAttr) {
                                                HighlightAttr highlightAttr2 = highlightAttr;
                                                highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 24.0f);
                                                highlightAttr2.justifyContentCenter();
                                                highlightAttr2.text = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().title;
                                                highlightAttr2.highlightText = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).keyword;
                                                highlightAttr2.fontSize = 17.0f;
                                                highlightAttr2.isIgnoreCase = true;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ContactSingleItemView contactSingleItemView7 = ContactSingleItemView.this;
                                TroopTagViewKt.TroopTag(vVar4, new Function1<TroopTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TroopTagView troopTagView) {
                                        final ContactSingleItemView contactSingleItemView8 = ContactSingleItemView.this;
                                        troopTagView.attr(new Function1<TroopTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TroopTagAttr troopTagAttr) {
                                                TroopTagAttr troopTagAttr2 = troopTagAttr;
                                                troopTagAttr2.marginTop(4.0f);
                                                troopTagAttr2.labelList = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().labelList;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ContactSingleItemView contactSingleItemView6 = ContactSingleItemView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(!ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().hideAddButton);
                            }
                        };
                        final ContactSingleItemView contactSingleItemView7 = ContactSingleItemView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final ContactSingleItemView contactSingleItemView8 = ContactSingleItemView.this;
                                QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(conditionView, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                        QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                        final ContactSingleItemView contactSingleItemView9 = ContactSingleItemView.this;
                                        qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.6.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                int i3 = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().addStatus;
                                                if (i3 == 0) {
                                                    qSearchGrayBorderButtonAttr2.text = "\u6dfb\u52a0";
                                                    qSearchGrayBorderButtonAttr2.status = 0;
                                                } else if (i3 != 2) {
                                                    qSearchGrayBorderButtonAttr2.text = "\u7b49\u5f85\u786e\u8ba4";
                                                    qSearchGrayBorderButtonAttr2.status = 2;
                                                } else {
                                                    qSearchGrayBorderButtonAttr2.text = "\u5df2\u6dfb\u52a0";
                                                    qSearchGrayBorderButtonAttr2.status = 1;
                                                }
                                                EcommerceExtKt.elementVR(qSearchGrayBorderButtonAttr2, "em_bas_person_enter_button", ContactSingleItemView.access$combineReportParams(ContactSingleItemView.this));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        if (ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().addStatus == 0) {
                                            final ContactSingleItemView contactSingleItemView10 = ContactSingleItemView.this;
                                            qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.6.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                    final ContactSingleItemView contactSingleItemView11 = ContactSingleItemView.this;
                                                    qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.ContactSingleItemView.body.1.1.6.1.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                            String str = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().uin;
                                                            String str2 = ContactSingleItemView.access$getAttr(ContactSingleItemView.this).getData().name;
                                                            currentBridgeModule.getClass();
                                                            e eVar = new e();
                                                            eVar.v("uin", str);
                                                            eVar.v("name", str2);
                                                            currentBridgeModule.callNativeMethod(QQFriendJsPlugin.API_ADD_FRIEND, eVar, null);
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
                        ContactSingleItemView contactSingleItemView8 = ContactSingleItemView.this;
                        int i3 = ContactSingleItemView.$r8$clinit;
                        contactSingleItemView8.getClass();
                        new QSearchBaseSingleItemView$buildDivider$1(contactSingleItemView8).invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ContactSingleItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ContactSingleItemEvent();
    }
}
