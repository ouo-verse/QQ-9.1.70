package com.tencent.mobileqq.guild.api.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.FeedListDelegateType;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListDescSection;
import com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListFunctionSection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J3\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020\u000fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/RecommendFeedListDelegateSectionFactory;", "Lcom/tencent/mobileqq/guild/api/impl/a;", "", "b", "Lcom/tencent/mobileqq/guild/api/FeedListSectionType;", "sectionType", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "a", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;", "delegateType", "", "e", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "viewPool", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delegate", "delegateToViewType", "", "g", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RecommendFeedListDelegateSectionFactory extends com.tencent.mobileqq.guild.api.impl.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214415a;

        static {
            int[] iArr = new int[FeedListSectionType.values().length];
            try {
                iArr[FeedListSectionType.RecommendGuildHeader.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeedListSectionType.Function.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeedListSectionType.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeedListSectionType.LongFeedContent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FeedListSectionType.Desc.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FeedListSectionType.SingleImage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FeedListSectionType.MultiImage.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f214415a = iArr;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.impl.a, com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public Class<? extends Section<?>> a(@NotNull FeedListSectionType sectionType) {
        Intrinsics.checkNotNullParameter(sectionType, "sectionType");
        switch (a.f214415a[sectionType.ordinal()]) {
            case 1:
                return com.tencent.mobileqq.guild.feed.feedlist.section.e.class;
            case 2:
                return RecommendFeedListFunctionSection.class;
            case 3:
                return com.tencent.mobileqq.guild.feed.feedlist.section.recommend.a.class;
            case 4:
                return com.tencent.mobileqq.guild.feed.feedlist.section.recommend.b.class;
            case 5:
                return RecommendFeedListDescSection.class;
            case 6:
                return com.tencent.mobileqq.guild.feed.feedlist.section.recommend.d.class;
            case 7:
                return com.tencent.mobileqq.guild.feed.feedlist.section.recommend.c.class;
            default:
                return super.a(sectionType);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.impl.a, com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    public int b() {
        return R.layout.eqe;
    }

    @Override // com.tencent.mobileqq.guild.api.impl.a, com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    @NotNull
    public List<FeedListSectionType> e(@NotNull FeedListDelegateType delegateType) {
        List c16;
        List c17;
        List c18;
        List c19;
        List<FeedListSectionType> d16;
        Intrinsics.checkNotNullParameter(delegateType, "delegateType");
        c16 = l.c(super.e(delegateType), FeedListSectionType.Avatar);
        c17 = l.c(c16, FeedListSectionType.Header);
        c18 = l.c(c17, FeedListSectionType.Comment);
        c19 = l.c(c18, FeedListSectionType.Prefer);
        d16 = l.d(c19, FeedListSectionType.RecommendGuildHeader);
        return d16;
    }

    @Override // com.tencent.mobileqq.guild.api.impl.a, com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory
    public void g(@NotNull RecyclerView.RecycledViewPool viewPool, @NotNull final Function1<? super FeedListDelegateType, Integer> delegateToViewType) {
        Intrinsics.checkNotNullParameter(viewPool, "viewPool");
        Intrinsics.checkNotNullParameter(delegateToViewType, "delegateToViewType");
        super.g(viewPool, new Function1<FeedListDelegateType, Integer>() { // from class: com.tencent.mobileqq.guild.api.impl.RecommendFeedListDelegateSectionFactory$addFeedListViewTypeConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull FeedListDelegateType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(delegateToViewType.invoke(it).intValue() + 10000);
            }
        });
    }
}
