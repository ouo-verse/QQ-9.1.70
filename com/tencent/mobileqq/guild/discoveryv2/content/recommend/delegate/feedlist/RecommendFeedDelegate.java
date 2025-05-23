package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.api.FeedListDelegateType;
import com.tencent.mobileqq.guild.discoveryv2.content.base.a;
import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001 B3\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\"\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0010\b\u0001\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00110\u0010j\u0002`\u001a0\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J8\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001e\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\b\u0001\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00110\u00100\u0005H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R0\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0010\b\u0001\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00110\u0010j\u0002`\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/feedlist/RecommendFeedDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;", "type", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/feedlist/RecommendFeedSectionClass;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;Ljava/util/List;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedDelegate extends a<l<?>> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Integer> E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Class<? extends Section<l<?>>>> sections;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedListDelegateType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/feedlist/RecommendFeedDelegate$a;", "", "", "LAYOUT_ID$delegate", "Lkotlin/Lazy;", "a", "()I", "LAYOUT_ID", "ITEM_TYPE_BASE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist.RecommendFeedDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) RecommendFeedDelegate.E.getValue()).intValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Integer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist.RecommendFeedDelegate$Companion$LAYOUT_ID$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(RecommendFeedDelegateKt.a().b());
            }
        });
        E = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecommendFeedDelegate(@NotNull FeedListDelegateType type, @NotNull List<? extends Class<? extends Section<l<?>>>> sections) {
        super(l.class);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sections, "sections");
        this.type = type;
        this.sections = sections;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.a, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c */
    public boolean isForViewType(@NotNull h item, @NotNull List<h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.getItemType() == this.type.getLayoutType() + 10000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return INSTANCE.a();
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<l<?>>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.addAll(this.sections);
    }
}
