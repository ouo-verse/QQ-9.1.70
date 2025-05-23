package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cj;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetRecommendWordsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchRecommendWord;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bi;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "account", "", "onAccountChanged", "", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "items", "g", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "e", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "f", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "<init>", "()V", "a", "RecommendItem", "SerializableItem", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AISearchRecommendRepository implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final AISearchRecommendRepository f214105d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final RuntimeServiceHolder serviceHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy gproService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "Ljava/io/Serializable;", "<init>", "()V", "Companion", "a", "RecommendWord", "TitleText", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$TitleText;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class RecommendItem implements Serializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "index", "", "wordId", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getIndex", "()I", "getWordId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes12.dex */
        public static final /* data */ class RecommendWord extends RecommendItem {

            @NotNull
            private final String content;
            private final int index;

            @NotNull
            private final String wordId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RecommendWord(int i3, @NotNull String wordId, @NotNull String content) {
                super(null);
                Intrinsics.checkNotNullParameter(wordId, "wordId");
                Intrinsics.checkNotNullParameter(content, "content");
                this.index = i3;
                this.wordId = wordId;
                this.content = content;
            }

            public static /* synthetic */ RecommendWord copy$default(RecommendWord recommendWord, int i3, String str, String str2, int i16, Object obj) {
                if ((i16 & 1) != 0) {
                    i3 = recommendWord.index;
                }
                if ((i16 & 2) != 0) {
                    str = recommendWord.wordId;
                }
                if ((i16 & 4) != 0) {
                    str2 = recommendWord.content;
                }
                return recommendWord.copy(i3, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getWordId() {
                return this.wordId;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            @NotNull
            public final RecommendWord copy(int index, @NotNull String wordId, @NotNull String content) {
                Intrinsics.checkNotNullParameter(wordId, "wordId");
                Intrinsics.checkNotNullParameter(content, "content");
                return new RecommendWord(index, wordId, content);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecommendWord)) {
                    return false;
                }
                RecommendWord recommendWord = (RecommendWord) other;
                if (this.index == recommendWord.index && Intrinsics.areEqual(this.wordId, recommendWord.wordId) && Intrinsics.areEqual(this.content, recommendWord.content)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final String getContent() {
                return this.content;
            }

            public final int getIndex() {
                return this.index;
            }

            @NotNull
            public final String getWordId() {
                return this.wordId;
            }

            public int hashCode() {
                return (((this.index * 31) + this.wordId.hashCode()) * 31) + this.content.hashCode();
            }

            @NotNull
            public String toString() {
                return "RecommendWord(index=" + this.index + ", wordId=" + this.wordId + ", content=" + this.content + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$TitleText;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "title", "", QQWinkConstants.TAB_SUBTITLE, "(Ljava/lang/String;Ljava/lang/String;)V", "getSubTitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes12.dex */
        public static final /* data */ class TitleText extends RecommendItem {

            @NotNull
            private final String subTitle;

            @NotNull
            private final String title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TitleText(@NotNull String title, @NotNull String subTitle) {
                super(null);
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(subTitle, "subTitle");
                this.title = title;
                this.subTitle = subTitle;
            }

            public static /* synthetic */ TitleText copy$default(TitleText titleText, String str, String str2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = titleText.title;
                }
                if ((i3 & 2) != 0) {
                    str2 = titleText.subTitle;
                }
                return titleText.copy(str, str2);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getSubTitle() {
                return this.subTitle;
            }

            @NotNull
            public final TitleText copy(@NotNull String title, @NotNull String subTitle) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(subTitle, "subTitle");
                return new TitleText(title, subTitle);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TitleText)) {
                    return false;
                }
                TitleText titleText = (TitleText) other;
                if (Intrinsics.areEqual(this.title, titleText.title) && Intrinsics.areEqual(this.subTitle, titleText.subTitle)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final String getSubTitle() {
                return this.subTitle;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.subTitle.hashCode();
            }

            @NotNull
            public String toString() {
                return "TitleText(title=" + this.title + ", subTitle=" + this.subTitle + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$a;", "", "", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "list", "", "b", "bytes", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository$RecommendItem$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final List<RecommendItem> a(@Nullable byte[] bytes) {
                Object m476constructorimpl;
                int collectionSizeOrDefault;
                List list;
                List filterNotNull;
                Object obj = null;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Serializable c16 = cj.f235519a.c(bytes);
                    Intrinsics.checkNotNull(c16);
                    Iterable<SerializableItem> iterable = (Iterable) c16;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 9);
                    if (collectionSizeOrDefault == 0) {
                        list = CollectionsKt__CollectionsJVMKt.listOf(null);
                    } else {
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
                        arrayList.add(null);
                        Object obj2 = null;
                        for (SerializableItem serializableItem : iterable) {
                            int i3 = 0;
                            if (obj2 != null && !(obj2 instanceof TitleText)) {
                                if (obj2 instanceof RecommendWord) {
                                    i3 = ((RecommendWord) obj2).getIndex() + 1;
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            int type = serializableItem.getType();
                            if (type != 0) {
                                if (type != 1) {
                                    obj2 = null;
                                } else {
                                    obj2 = new TitleText(serializableItem.getText1(), serializableItem.getText2());
                                }
                            } else {
                                obj2 = new RecommendWord(i3, serializableItem.getText1(), serializableItem.getText2());
                            }
                            arrayList.add(obj2);
                        }
                        list = arrayList;
                    }
                    filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
                    m476constructorimpl = Result.m476constructorimpl(filterNotNull);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl == null) {
                    obj = m476constructorimpl;
                } else {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "[fromByteArray] error: " + m479exceptionOrNullimpl.getMessage();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("AISearchRecommendRepository", 1, (String) it.next(), m479exceptionOrNullimpl);
                    }
                }
                return (List) obj;
            }

            @Nullable
            public final byte[] b(@NotNull List<? extends RecommendItem> list) {
                Object m476constructorimpl;
                int collectionSizeOrDefault;
                SerializableItem serializableItem;
                Intrinsics.checkNotNullParameter(list, "list");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    cj cjVar = cj.f235519a;
                    List<? extends RecommendItem> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (RecommendItem recommendItem : list2) {
                        if (recommendItem instanceof RecommendWord) {
                            serializableItem = new SerializableItem(0, ((RecommendWord) recommendItem).getWordId(), ((RecommendWord) recommendItem).getContent());
                        } else if (recommendItem instanceof TitleText) {
                            serializableItem = new SerializableItem(1, ((TitleText) recommendItem).getTitle(), ((TitleText) recommendItem).getSubTitle());
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        arrayList.add(serializableItem);
                    }
                    m476constructorimpl = Result.m476constructorimpl(cjVar.a(new ArrayList(arrayList)));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "[toByteArray] error: " + m479exceptionOrNullimpl.getMessage();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("AISearchRecommendRepository", 1, (String) it.next(), m479exceptionOrNullimpl);
                    }
                    m476constructorimpl = new byte[0];
                }
                return (byte[]) m476constructorimpl;
            }

            Companion() {
            }
        }

        public /* synthetic */ RecommendItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        RecommendItem() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$SerializableItem;", "Ljava/io/Serializable;", "type", "", "text1", "", "text2", "(ILjava/lang/String;Ljava/lang/String;)V", "getText1", "()Ljava/lang/String;", "getText2", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    private static final /* data */ class SerializableItem implements Serializable {

        @NotNull
        private final String text1;

        @NotNull
        private final String text2;
        private final int type;

        public SerializableItem(int i3, @NotNull String text1, @NotNull String text2) {
            Intrinsics.checkNotNullParameter(text1, "text1");
            Intrinsics.checkNotNullParameter(text2, "text2");
            this.type = i3;
            this.text1 = text1;
            this.text2 = text2;
        }

        public static /* synthetic */ SerializableItem copy$default(SerializableItem serializableItem, int i3, String str, String str2, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = serializableItem.type;
            }
            if ((i16 & 2) != 0) {
                str = serializableItem.text1;
            }
            if ((i16 & 4) != 0) {
                str2 = serializableItem.text2;
            }
            return serializableItem.copy(i3, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getText1() {
            return this.text1;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getText2() {
            return this.text2;
        }

        @NotNull
        public final SerializableItem copy(int type, @NotNull String text1, @NotNull String text2) {
            Intrinsics.checkNotNullParameter(text1, "text1");
            Intrinsics.checkNotNullParameter(text2, "text2");
            return new SerializableItem(type, text1, text2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SerializableItem)) {
                return false;
            }
            SerializableItem serializableItem = (SerializableItem) other;
            if (this.type == serializableItem.type && Intrinsics.areEqual(this.text1, serializableItem.text1) && Intrinsics.areEqual(this.text2, serializableItem.text2)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getText1() {
            return this.text1;
        }

        @NotNull
        public final String getText2() {
            return this.text2;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.type * 31) + this.text1.hashCode()) * 31) + this.text2.hashCode();
        }

        @NotNull
        public String toString() {
            return "SerializableItem(type=" + this.type + ", text1=" + this.text1 + ", text2=" + this.text2 + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$a;", "", "", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f214108a = new a();

        a() {
        }

        @NotNull
        public final List<RecommendItem> a() {
            List<RecommendItem> listOf;
            Logger.f235387a.d().i("AISearchRecommendRepository", 1, "[generateDefaultResponse] generate default response");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new RecommendItem.TitleText("\u6b22\u8fce\u4f7f\u7528\u9891\u9053\u95ee\u95ee", "\u57fa\u4e8eAI\u6df1\u5ea6\u89e3\u6790\u6d77\u91cf\u9891\u9053\u5185\u5bb9\uff0c\u5e2e\u4f60\u5feb\u901f\u627e\u7b54\u6848"));
            return listOf;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$b", "Lwh2/bi;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAISearchGetRecommendWordsRsp;", "rsp", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements bi {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<? extends RecommendItem>> f214109a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super List<? extends RecommendItem>> continuation) {
            this.f214109a = continuation;
        }

        @Override // wh2.bi
        public void a(int result, @Nullable String errMsg, @Nullable IGProAISearchGetRecommendWordsRsp rsp) {
            boolean z16;
            boolean z17;
            List take;
            int collectionSizeOrDefault;
            List listOf;
            List plus;
            if (errMsg == null) {
                errMsg = "";
            }
            ri1.a c16 = ri1.a.c(result, errMsg, rsp);
            String str = null;
            if (c16.d() && rsp != null) {
                String firstTitle = rsp.getFirstTitle();
                int i3 = 0;
                if (firstTitle != null && firstTitle.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!(!z16)) {
                    firstTitle = null;
                }
                if (firstTitle == null) {
                    firstTitle = "AI\u52a9\u624b";
                }
                String secondTitle = rsp.getSecondTitle();
                if (secondTitle != null && secondTitle.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (true ^ z17) {
                    str = secondTitle;
                }
                if (str == null) {
                    str = "AI\u52a9\u624b\u4e3a\u4f60\u63a8\u8350";
                }
                RecommendItem.TitleText titleText = new RecommendItem.TitleText(firstTitle, str);
                ArrayList<IGProAISearchRecommendWord> words = rsp.getWords();
                Intrinsics.checkNotNullExpressionValue(words, "rsp.words");
                take = CollectionsKt___CollectionsKt.take(words, 3);
                List list = take;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (Object obj : list) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    IGProAISearchRecommendWord iGProAISearchRecommendWord = (IGProAISearchRecommendWord) obj;
                    String wordId = iGProAISearchRecommendWord.getWordId();
                    Intrinsics.checkNotNullExpressionValue(wordId, "item.wordId");
                    String content = iGProAISearchRecommendWord.getContent();
                    Intrinsics.checkNotNullExpressionValue(content, "item.content");
                    arrayList.add(new RecommendItem.RecommendWord(i3, wordId, content));
                    i3 = i16;
                }
                AISearchRecommendRepository.f214105d.g(arrayList);
                Continuation<List<? extends RecommendItem>> continuation = this.f214109a;
                Result.Companion companion = Result.INSTANCE;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(titleText);
                plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) arrayList);
                continuation.resumeWith(Result.m476constructorimpl(plus));
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "[getSearchRecommendWords] error: " + c16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AISearchRecommendRepository", 1, (String) it.next(), null);
            }
            Continuation<List<? extends RecommendItem>> continuation2 = this.f214109a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException(c16.toString()))));
        }
    }

    static {
        AISearchRecommendRepository aISearchRecommendRepository = new AISearchRecommendRepository();
        f214105d = aISearchRecommendRepository;
        RuntimeServiceHolder runtimeServiceHolder = new RuntimeServiceHolder();
        serviceHolder = runtimeServiceHolder;
        gproService = runtimeServiceHolder.a("AISearchRecommendRepository", IGPSService.class);
        AccountChangedNotifier.f214789d.a(aISearchRecommendRepository);
    }

    AISearchRecommendRepository() {
    }

    private final IGPSService c() {
        return (IGPSService) gproService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String str) {
        if (str == null) {
            str = "";
        }
        ri1.a b16 = ri1.a.b(i3, str);
        if (!b16.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "[reportItemClick] error: " + b16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AISearchRecommendRepository", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str) {
        if (str == null) {
            str = "";
        }
        ri1.a b16 = ri1.a.b(i3, str);
        if (!b16.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "[reportItemExpose] error: " + b16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AISearchRecommendRepository", 1, (String) it.next(), null);
            }
        }
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super List<? extends RecommendItem>> continuation) throws RuntimeException {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        f214105d.c().getAISearchRecommendWords(new b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void e(@NotNull RecommendItem.RecommendWord item) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(item, "item");
        Logger.f235387a.d().d("AISearchRecommendRepository", 1, "[reportItemClick] item: " + item);
        com.tencent.mobileqq.qqguildsdk.data.genc.i iVar = new com.tencent.mobileqq.qqguildsdk.data.genc.i();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(item.getWordId());
        iVar.d(arrayListOf);
        iVar.e(2);
        c().reportAISearchRecommendWords(iVar, new em() { // from class: com.tencent.mobileqq.guild.aisearch.models.b
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                AISearchRecommendRepository.f(i3, str);
            }
        });
    }

    public final void g(@NotNull List<RecommendItem.RecommendWord> items) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(items, "items");
        com.tencent.mobileqq.qqguildsdk.data.genc.i iVar = new com.tencent.mobileqq.qqguildsdk.data.genc.i();
        List<RecommendItem.RecommendWord> list = items;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RecommendItem.RecommendWord) it.next()).getWordId());
        }
        iVar.d(new ArrayList<>(arrayList));
        iVar.e(1);
        c().reportAISearchRecommendWords(iVar, new em() { // from class: com.tencent.mobileqq.guild.aisearch.models.c
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                AISearchRecommendRepository.h(i3, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        serviceHolder.e();
    }
}
