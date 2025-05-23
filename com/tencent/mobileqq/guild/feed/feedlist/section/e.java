package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/e;", "Lrj1/b;", "Ext", "Ltk1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", "attached", "onAttachedChanged", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class e<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RecommendGuildTitleComponents components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/e$a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildTitleComponents$b;", "Lkotlin/Pair;", "", "b", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements RecommendGuildTitleComponents.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<Ext> f218594a;

        a(e<Ext> eVar) {
            this.f218594a = eVar;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents.b
        @NotNull
        public Pair<String, String> b() {
            return e.z(this.f218594a).b();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildTitleComponents.b
        public boolean c() {
            return false;
        }
    }

    public e() {
        super(FeedListSectionType.RecommendGuildHeader);
        this.components = new RecommendGuildTitleComponents(new a(this));
    }

    public static final /* synthetic */ rj1.b z(e eVar) {
        return (rj1.b) eVar.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w1c};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        this.components.q(attached);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        RecommendGuildTitleComponents recommendGuildTitleComponents = this.components;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        recommendGuildTitleComponents.t(rootView);
        ViewGroup.LayoutParams layoutParams = getRootView().getLayoutParams();
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = null;
        if (layoutParams != null) {
            if (!(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                layoutParams = null;
            }
            layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.setFullSpan(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        rj1.d dVar;
        super.onBindData(bindData, position, payload);
        Ext s16 = s();
        if (s16 instanceof rj1.d) {
            dVar = (rj1.d) s16;
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return;
        }
        this.components.r(dVar.getGuildInfo(), "em_sgrp_one_forum_module_join");
    }
}
