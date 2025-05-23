package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.view.View;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.widget.GuildLinkView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.q;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J0\u0010\u000f\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/l;", "Lrj1/b;", "Ext", "Ltk1/a;", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", "getViewStubLayoutId", "Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", "linkView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class l<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildLinkView linkView;

    public l() {
        super(FeedListSectionType.ThirdPartyShareLink);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wbd};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        View findViewById = p().findViewById(R.id.f96795in);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026id.third_party_link_view)");
        this.linkView = (GuildLinkView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        Object firstOrNull;
        super.onBindData(bindData, position, payload);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) r().b());
        q qVar = (q) firstOrNull;
        if (qVar == null) {
            return;
        }
        GuildLinkView guildLinkView = this.linkView;
        if (guildLinkView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkView");
            guildLinkView = null;
        }
        GuildLinkView.d(guildLinkView, qVar.getTitle(), qVar.getAbstract(), qVar.getThumbUrl(), qVar.getRedirectUrl(), null, null, null, null, null, w.CTRL_INDEX, null);
    }
}
