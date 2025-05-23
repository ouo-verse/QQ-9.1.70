package com.tencent.mobileqq.search.searchdetail.content.template.model;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchFeedCollection;
import com.tencent.qqnt.kernel.nativeinterface.SearchFeedSummary;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003H\u0007IB\u001f\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010D\u001a\u00020\r\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0000H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010>\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010A\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/g;", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", "a", "", "e", HippyTKDListViewAdapter.X, "", "getItemType", "", "troopUin", "status", "Lcom/tencent/mobileqq/search/searchdetail/a;", tl.h.F, "guildId", "d", "other", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedCollection;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedCollection;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedCollection;", "feedCollection", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "K", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "y", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "setButtonInfo", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;)V", "buttonInfo", "", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$b;", "L", "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "feedSummaryList", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$ChangeType;", "M", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$ChangeType;", "getChangeType", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$ChangeType;", "D", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$ChangeType;)V", "changeType", "N", "Lkotlin/Lazy;", "B", "()Z", "isGroupCodeSearch", "P", BdhLogUtil.LogTag.Tag_Conn, "isGuildIdSearch", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "keyWord", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;Ljava/lang/String;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ChangeType", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchFeedCollectionItem extends QSearchBaseTitleGroupTemplateItem implements g, Cloneable {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final SearchFeedCollection feedCollection;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private k buttonInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final List<FeedWrapper> feedSummaryList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private ChangeType changeType;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy isGroupCodeSearch;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy isGuildIdSearch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$ChangeType;", "", "(Ljava/lang/String;I)V", "BUTTON_STATUS", "NONE", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public enum ChangeType {
        BUTTON_STATUS,
        NONE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/NetSearchFeedCollectionItem$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedSummary;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedSummary;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedSummary;", "feedsSummary", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "c", "()Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "titleRichText", "contentRichText", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchFeedSummary;Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class FeedWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SearchFeedSummary feedsSummary;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.mobileqq.search.searchdetail.multimedia.q titleRichText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText;

        public FeedWrapper(@NotNull SearchFeedSummary feedsSummary, @NotNull com.tencent.mobileqq.search.searchdetail.multimedia.q titleRichText, @NotNull com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText) {
            Intrinsics.checkNotNullParameter(feedsSummary, "feedsSummary");
            Intrinsics.checkNotNullParameter(titleRichText, "titleRichText");
            Intrinsics.checkNotNullParameter(contentRichText, "contentRichText");
            this.feedsSummary = feedsSummary;
            this.titleRichText = titleRichText;
            this.contentRichText = contentRichText;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.mobileqq.search.searchdetail.multimedia.q getContentRichText() {
            return this.contentRichText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final SearchFeedSummary getFeedsSummary() {
            return this.feedsSummary;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final com.tencent.mobileqq.search.searchdetail.multimedia.q getTitleRichText() {
            return this.titleRichText;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedWrapper)) {
                return false;
            }
            FeedWrapper feedWrapper = (FeedWrapper) other;
            if (Intrinsics.areEqual(this.feedsSummary, feedWrapper.feedsSummary) && Intrinsics.areEqual(this.titleRichText, feedWrapper.titleRichText) && Intrinsics.areEqual(this.contentRichText, feedWrapper.contentRichText)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.feedsSummary.hashCode() * 31) + this.titleRichText.hashCode()) * 31) + this.contentRichText.hashCode();
        }

        @NotNull
        public String toString() {
            return "FeedWrapper(feedsSummary=" + this.feedsSummary + ", titleRichText=" + this.titleRichText + ", contentRichText=" + this.contentRichText + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchFeedCollectionItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template, @NotNull final String keyWord) {
        super(commonInfo, template);
        int collectionSizeOrDefault;
        Lazy lazy;
        Lazy lazy2;
        boolean z16;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        this.template = template;
        SearchFeedCollection searchFeedCollection = template.feedCollection;
        searchFeedCollection = searchFeedCollection == null ? new SearchFeedCollection() : searchFeedCollection;
        this.feedCollection = searchFeedCollection;
        ArrayList<SearchFeedSummary> arrayList = searchFeedCollection.feedSummaryList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "feedCollection.feedSummaryList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (SearchFeedSummary it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.mobileqq.search.searchdetail.multimedia.q qVar = new com.tencent.mobileqq.search.searchdetail.multimedia.q(it.richText);
            rn2.j jVar = rn2.j.f431768a;
            String str = it.title.text;
            Intrinsics.checkNotNullExpressionValue(str, "it.title.text");
            qVar.e(jVar.r(str));
            com.tencent.mobileqq.search.searchdetail.multimedia.q qVar2 = new com.tencent.mobileqq.search.searchdetail.multimedia.q(it.richText);
            String str2 = it.text.text;
            Intrinsics.checkNotNullExpressionValue(str2, "it.text.text");
            qVar2.e(jVar.r(str2));
            Unit unit = Unit.INSTANCE;
            arrayList2.add(new FeedWrapper(it, qVar, qVar2));
        }
        this.feedSummaryList = arrayList2;
        this.changeType = ChangeType.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem$isGroupCodeSearch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(NetSearchVerticalDetailTemplateItem.INSTANCE.a(keyWord));
            }
        });
        this.isGroupCodeSearch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem$isGuildIdSearch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(NetSearchVerticalDetailTemplateItem.INSTANCE.b(keyWord));
            }
        });
        this.isGuildIdSearch = lazy2;
        String str3 = this.template.data;
        Intrinsics.checkNotNullExpressionValue(str3, "template.data");
        if (str3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("NetSearchHotTopicItem", 1, this.template.data);
        }
        this.buttonInfo = k.INSTANCE.a(this.feedCollection.button);
    }

    @NotNull
    public final List<FeedWrapper> A() {
        return this.feedSummaryList;
    }

    public final boolean B() {
        return ((Boolean) this.isGroupCodeSearch.getValue()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) this.isGuildIdSearch.getValue()).booleanValue();
    }

    public final void D(@NotNull ChangeType changeType) {
        Intrinsics.checkNotNullParameter(changeType, "<set-?>");
        this.changeType = changeType;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public boolean a(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return super.a(newItem);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.g
    @NotNull
    public com.tencent.mobileqq.search.searchdetail.a d(@NotNull String guildId, int status) {
        String str;
        SearchJump jumpInfo;
        SearchGuildJump searchGuildJump;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        k kVar = this.buttonInfo;
        boolean z16 = false;
        if (kVar != null && kVar.getButtonType() == 3) {
            z16 = true;
        }
        if (z16) {
            k kVar2 = this.buttonInfo;
            k kVar3 = null;
            if (kVar2 != null && (jumpInfo = kVar2.getJumpInfo()) != null && (searchGuildJump = jumpInfo.guildJump) != null) {
                str = Long.valueOf(searchGuildJump.guildId).toString();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                NetSearchFeedCollectionItem clone = clone();
                k kVar4 = this.buttonInfo;
                if (kVar4 != null) {
                    kVar3 = kVar4.clone();
                }
                if (kVar3 != null) {
                    kVar3.c(status);
                }
                clone.buttonInfo = kVar3;
                this.changeType = ChangeType.BUTTON_STATUS;
                return clone;
            }
        }
        return this;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.c
    @Nullable
    public Object e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof NetSearchFeedCollectionItem)) {
            return super.e(newItem);
        }
        if (this.changeType != ((NetSearchFeedCollectionItem) newItem).changeType) {
            return ChangeType.BUTTON_STATUS;
        }
        return super.e(newItem);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetSearchFeedCollectionItem) || !super.equals(other)) {
            return false;
        }
        NetSearchFeedCollectionItem netSearchFeedCollectionItem = (NetSearchFeedCollectionItem) other;
        if (Intrinsics.areEqual(this.template, netSearchFeedCollectionItem.template) && Intrinsics.areEqual(this.feedCollection, netSearchFeedCollectionItem.feedCollection) && Intrinsics.areEqual(this.buttonInfo, netSearchFeedCollectionItem.buttonInfo) && Intrinsics.areEqual(this.feedSummaryList, netSearchFeedCollectionItem.feedSummaryList) && this.changeType == netSearchFeedCollectionItem.changeType && B() == netSearchFeedCollectionItem.B() && C() == netSearchFeedCollectionItem.C()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 18;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.g
    @NotNull
    public com.tencent.mobileqq.search.searchdetail.a h(@NotNull String troopUin, int status) {
        String str;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        k kVar = this.buttonInfo;
        boolean z16 = false;
        if (kVar != null && kVar.getButtonType() == 2) {
            z16 = true;
        }
        if (z16) {
            k kVar2 = this.buttonInfo;
            k kVar3 = null;
            if (kVar2 != null) {
                str = kVar2.getTroopUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, troopUin)) {
                NetSearchFeedCollectionItem clone = clone();
                k kVar4 = this.buttonInfo;
                if (kVar4 != null) {
                    kVar3 = kVar4.clone();
                }
                if (kVar3 != null) {
                    kVar3.b(status);
                }
                clone.buttonInfo = kVar3;
                this.changeType = ChangeType.BUTTON_STATUS;
                return clone;
            }
        }
        return this;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        int i3;
        int hashCode = ((((super.hashCode() * 31) + this.template.hashCode()) * 31) + this.feedCollection.hashCode()) * 31;
        k kVar = this.buttonInfo;
        if (kVar != null) {
            i3 = kVar.hashCode();
        } else {
            i3 = 0;
        }
        return ((((((((hashCode + i3) * 31) + this.feedSummaryList.hashCode()) * 31) + this.changeType.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(B())) * 31) + com.tencent.aio.widget.textView.param.a.a(C());
    }

    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public NetSearchFeedCollectionItem clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchFeedCollectionItem");
        return (NetSearchFeedCollectionItem) clone;
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final k getButtonInfo() {
        return this.buttonInfo;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final SearchFeedCollection getFeedCollection() {
        return this.feedCollection;
    }
}
