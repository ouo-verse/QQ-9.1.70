package com.tencent.mobileqq.search.searchdetail.content.template;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchGuildGuildFeedItemLayout;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchGuildGuildTitleLayout;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import hp2.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/NetSearchFeedCollectionSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem;", "Lhp2/af;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "btn", "", "a0", "Landroid/view/View;", "containerView", "y", "", "getViewStubLayoutId", "data", "", "position", "", "", "payload", "Z", "D", "Lhp2/af;", "getBinding", "()Lhp2/af;", "setBinding", "(Lhp2/af;)V", "binding", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchFeedCollectionSection extends BaseSearchTemplateSection<NetSearchFeedCollectionItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private af binding;

    /* JADX WARN: Multi-variable type inference failed */
    private final void a0(af afVar, final com.tencent.mobileqq.search.searchdetail.content.template.model.k kVar) {
        int i3;
        String str;
        if (kVar != null) {
            if (kVar.getButtonType() != 2 && kVar.getButtonType() != 3) {
                afVar.f405558e.B0("QQSearch.NetDetail.BaseSearchTemplateSection", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$initRightButton$1$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        NetSearchFeedCollectionSection.this.u(kVar);
                    }
                });
            } else {
                int buttonType = kVar.getButtonType();
                boolean z16 = true;
                if (buttonType != 2) {
                    if (buttonType == 3) {
                        if (kVar.getJoinGuildStatus() != 0) {
                            afVar.f405558e.B0("QQSearch.NetDetail.BaseSearchTemplateSection", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$initRightButton$1$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                    invoke2(view);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull View it) {
                                    Object obj;
                                    Object obj2;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    NetSearchFeedCollectionSection netSearchFeedCollectionSection = NetSearchFeedCollectionSection.this;
                                    obj = ((Section) netSearchFeedCollectionSection).mData;
                                    SearchJump jumpLink = ((NetSearchFeedCollectionItem) obj).getFeedCollection().icon.getJumpLink();
                                    obj2 = ((Section) NetSearchFeedCollectionSection.this).mData;
                                    netSearchFeedCollectionSection.d(jumpLink, ((NetSearchFeedCollectionItem) obj2).q());
                                }
                            });
                        } else {
                            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
                            if (dtReportIoc == null || dtReportIoc.getTabMask() != 3) {
                                z16 = false;
                            }
                            if (z16 && ((NetSearchFeedCollectionItem) this.mData).C()) {
                                str = "qq_network_search_post_sub_tab_searchid";
                            } else if (z16 && !((NetSearchFeedCollectionItem) this.mData).C()) {
                                str = "qq_network_search_post_sub_tab_keyword";
                            } else if (!z16 && ((NetSearchFeedCollectionItem) this.mData).C()) {
                                str = "qq_network_search_post_all_tab_searchid";
                            } else {
                                str = "qq_network_search_post_all_tab_keyword";
                            }
                            kVar.getExtras().a(str);
                            afVar.f405558e.B0("QQSearch.NetDetail.BaseSearchTemplateSection", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$initRightButton$1$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                    invoke2(view);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull View it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    NetSearchFeedCollectionSection.this.u(kVar);
                                }
                            });
                        }
                    }
                } else if (kVar.getJoinGroupStatus() != 1) {
                    afVar.f405558e.B0("QQSearch.NetDetail.BaseSearchTemplateSection", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$initRightButton$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Object obj;
                            Object obj2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            NetSearchFeedCollectionSection netSearchFeedCollectionSection = NetSearchFeedCollectionSection.this;
                            obj = ((Section) netSearchFeedCollectionSection).mData;
                            SearchJump jumpLink = ((NetSearchFeedCollectionItem) obj).getJumpLink();
                            obj2 = ((Section) NetSearchFeedCollectionSection.this).mData;
                            netSearchFeedCollectionSection.d(jumpLink, ((NetSearchFeedCollectionItem) obj2).q());
                        }
                    });
                } else {
                    com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = getDtReportIoc();
                    if (dtReportIoc2 == null || dtReportIoc2.getTabMask() != 6) {
                        z16 = false;
                    }
                    if (((NetSearchFeedCollectionItem) this.mData).B()) {
                        if (z16) {
                            i3 = 1020;
                        } else {
                            i3 = 1019;
                        }
                    } else if (z16) {
                        i3 = 1022;
                    } else {
                        i3 = 1021;
                    }
                    kVar.getExtras().b(i3);
                    afVar.f405558e.B0("QQSearch.NetDetail.BaseSearchTemplateSection", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$initRightButton$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            NetSearchFeedCollectionSection.this.u(kVar);
                        }
                    });
                }
            }
            afVar.f405558e.getBinding().f405790b.setText(kVar.getText());
            f.a(kVar.getStatus(), afVar.f405558e.getBinding().f405790b);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull final NetSearchFeedCollectionItem data, final int position, @Nullable List<Object> payload) {
        Object obj;
        boolean isBlank;
        QSearchGuildGuildFeedItemLayout doOnBindData$lambda$7$lambda$6$lambda$5;
        final NetSearchFeedCollectionItem.FeedWrapper feedWrapper;
        String str;
        String str2;
        boolean z16;
        int collectionSizeOrDefault;
        final SearchReportInfo reportInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        if (payload != null) {
            obj = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payload);
        } else {
            obj = null;
        }
        if (obj == NetSearchFeedCollectionItem.ChangeType.BUTTON_STATUS) {
            af afVar = this.binding;
            if (afVar != null) {
                a0(afVar, data.getButtonInfo());
            }
            data.D(NetSearchFeedCollectionItem.ChangeType.NONE);
            return;
        }
        af afVar2 = this.binding;
        if (afVar2 != null) {
            String str3 = data.getFeedCollection().icon.title.text;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "data.feedCollection.icon.title.text ?: \"\"");
            }
            afVar2.f405558e.setTitle(str3);
            QSearchGuildGuildTitleLayout qSearchGuildGuildTitleLayout = afVar2.f405558e;
            SearchIcon searchIcon = data.getFeedCollection().icon;
            Intrinsics.checkNotNullExpressionValue(searchIcon, "data.feedCollection.icon");
            qSearchGuildGuildTitleLayout.setMainIcon(searchIcon);
            String str4 = data.getFeedCollection().busiIcon.title.text;
            if (str4 == null) {
                str4 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "data.feedCollection.busiIcon.title.text ?: \"\"");
            }
            afVar2.f405558e.setBusinessTitle(str4);
            String str5 = data.getFeedCollection().tag.iconLink;
            Intrinsics.checkNotNullExpressionValue(str5, "data.feedCollection.tag.iconLink");
            isBlank = StringsKt__StringsJVMKt.isBlank(str5);
            if (!isBlank) {
                QSearchGuildGuildTitleLayout qSearchGuildGuildTitleLayout2 = afVar2.f405558e;
                String str6 = data.getFeedCollection().tag.iconLink;
                Intrinsics.checkNotNullExpressionValue(str6, "data.feedCollection.tag.iconLink");
                qSearchGuildGuildTitleLayout2.setBadge(str6);
            } else {
                afVar2.f405558e.A0();
            }
            rn2.j jVar = rn2.j.f431768a;
            QSearchGuildGuildTitleLayout guildTitleLayout = afVar2.f405558e;
            Intrinsics.checkNotNullExpressionValue(guildTitleLayout, "guildTitleLayout");
            rn2.j.u(jVar, guildTitleLayout, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$doOnBindData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Object obj2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    NetSearchFeedCollectionSection netSearchFeedCollectionSection = NetSearchFeedCollectionSection.this;
                    SearchJump jumpLink = data.getFeedCollection().icon.getJumpLink();
                    com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = data.getReportInfoWrapper();
                    obj2 = ((Section) NetSearchFeedCollectionSection.this).mData;
                    netSearchFeedCollectionSection.v(jumpLink, reportInfoWrapper, ((NetSearchFeedCollectionItem) obj2).q());
                }
            }, 3, null);
            a0(afVar2, data.getButtonInfo());
            com.tencent.mobileqq.search.searchdetail.content.template.model.k buttonInfo = data.getButtonInfo();
            if (buttonInfo != null && (reportInfo = buttonInfo.getReportInfo()) != null) {
                TextView textView = afVar2.f405558e.getBinding().f405790b;
                Intrinsics.checkNotNullExpressionValue(textView, "guildTitleLayout.binding.btnJoin");
                V(textView, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$doOnBindData$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        NetSearchFeedCollectionSection netSearchFeedCollectionSection = NetSearchFeedCollectionSection.this;
                        return BaseSearchTemplateSection.S(netSearchFeedCollectionSection, reportInfo, netSearchFeedCollectionSection.T(position), null, 2, null);
                    }
                }, String.valueOf(reportInfo.hashCode()));
            }
            int i3 = 3;
            QSearchGuildGuildFeedItemLayout[] qSearchGuildGuildFeedItemLayoutArr = {afVar2.f405555b, afVar2.f405556c, afVar2.f405557d};
            for (int i16 = 0; i16 < 3; i16++) {
                qSearchGuildGuildFeedItemLayoutArr[i16].setVisibility(8);
            }
            Function1<SearchText, Unit> function1 = new Function1<SearchText, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$doOnBindData$1$spanClickCallback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SearchText searchText) {
                    invoke2(searchText);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SearchText searchText) {
                    Intrinsics.checkNotNullParameter(searchText, "searchText");
                    BaseSearchTemplateSection.w(NetSearchFeedCollectionSection.this, searchText.jumpLink, data.getReportInfoWrapper(), null, 4, null);
                }
            };
            int i17 = 0;
            for (Object obj2 : data.A()) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                NetSearchFeedCollectionItem.FeedWrapper feedWrapper2 = (NetSearchFeedCollectionItem.FeedWrapper) obj2;
                if (i3 > i17) {
                    QSearchGuildGuildFeedItemLayout doOnBindData$lambda$7$lambda$6$lambda$5$lambda$3 = qSearchGuildGuildFeedItemLayoutArr[i17];
                    final SearchReportInfo reportInfo2 = feedWrapper2.getFeedsSummary().reportInfo;
                    if (reportInfo2 != null) {
                        Intrinsics.checkNotNullExpressionValue(reportInfo2, "reportInfo");
                        Intrinsics.checkNotNullExpressionValue(doOnBindData$lambda$7$lambda$6$lambda$5$lambda$3, "doOnBindData$lambda$7$lambda$6$lambda$5$lambda$3");
                        doOnBindData$lambda$7$lambda$6$lambda$5 = doOnBindData$lambda$7$lambda$6$lambda$5$lambda$3;
                        feedWrapper = feedWrapper2;
                        V(doOnBindData$lambda$7$lambda$6$lambda$5$lambda$3, reportInfo2.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$doOnBindData$1$4$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final JSONObject invoke() {
                                NetSearchFeedCollectionSection netSearchFeedCollectionSection = NetSearchFeedCollectionSection.this;
                                return BaseSearchTemplateSection.S(netSearchFeedCollectionSection, reportInfo2, netSearchFeedCollectionSection.T(position), null, 2, null);
                            }
                        }, String.valueOf(reportInfo2.hashCode()));
                    } else {
                        doOnBindData$lambda$7$lambda$6$lambda$5 = doOnBindData$lambda$7$lambda$6$lambda$5$lambda$3;
                        feedWrapper = feedWrapper2;
                    }
                    doOnBindData$lambda$7$lambda$6$lambda$5.setVisibility(0);
                    rn2.j jVar2 = rn2.j.f431768a;
                    Intrinsics.checkNotNullExpressionValue(doOnBindData$lambda$7$lambda$6$lambda$5, "doOnBindData$lambda$7$lambda$6$lambda$5");
                    rn2.j.u(jVar2, doOnBindData$lambda$7$lambda$6$lambda$5, "QQSearch.NetDetail.BaseSearchTemplateSection", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.NetSearchFeedCollectionSection$doOnBindData$1$4$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            NetSearchFeedCollectionSection.this.v(feedWrapper.getFeedsSummary().jumpLink, new com.tencent.mobileqq.search.searchdetail.content.model.g(feedWrapper.getFeedsSummary().reportInfo), data.q());
                        }
                    }, 2, null);
                    com.tencent.mobileqq.search.searchdetail.multimedia.q titleRichText = feedWrapper.getTitleRichText();
                    com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
                    if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
                        str = "";
                    }
                    titleRichText.f(str);
                    com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText = feedWrapper.getContentRichText();
                    com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = getDtReportIoc();
                    if (dtReportIoc2 == null || (str2 = dtReportIoc2.getKeyword()) == null) {
                        str2 = "";
                    }
                    contentRichText.f(str2);
                    String str7 = feedWrapper.getFeedsSummary().title.text;
                    if (str7 != null && str7.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        com.tencent.mobileqq.search.searchdetail.multimedia.q titleRichText2 = feedWrapper.getTitleRichText();
                        Context context = doOnBindData$lambda$7$lambda$6$lambda$5.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        SpannableString g16 = titleRichText2.g(context, function1);
                        com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText2 = feedWrapper.getContentRichText();
                        Context context2 = doOnBindData$lambda$7$lambda$6$lambda$5.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        doOnBindData$lambda$7$lambda$6$lambda$5.setTitleAndContent(g16, contentRichText2.g(context2, function1));
                    } else {
                        com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText3 = feedWrapper.getContentRichText();
                        Context context3 = doOnBindData$lambda$7$lambda$6$lambda$5.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "context");
                        doOnBindData$lambda$7$lambda$6$lambda$5.setTitleAndContent("", contentRichText3.g(context3, function1));
                    }
                    SearchIcon searchIcon2 = feedWrapper.getFeedsSummary().icon;
                    Intrinsics.checkNotNullExpressionValue(searchIcon2, "feedSummary.feedsSummary.icon");
                    doOnBindData$lambda$7$lambda$6$lambda$5.setAuthAvatarInfo(searchIcon2);
                    ArrayList<SearchPicture> arrayList = feedWrapper.getFeedsSummary().picList;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "feedSummary.feedsSummary.picList");
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((SearchPicture) it.next()).picLink);
                    }
                    doOnBindData$lambda$7$lambda$6$lambda$5.setPicList(arrayList2);
                }
                i17 = i18;
                i3 = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            this.binding = af.e(containerView);
        }
    }
}
