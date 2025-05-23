package com.tencent.mobileqq.guild.feed.search.sections;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.widget.GuildSmallWorldView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/j;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView;", "d", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView;", "thirdVideoView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends Section<pn1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildSmallWorldView thirdVideoView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wed};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wee);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d_small_world_video_view)");
        GuildSmallWorldView guildSmallWorldView = (GuildSmallWorldView) findViewById;
        this.thirdVideoView = guildSmallWorldView;
        GuildSmallWorldView guildSmallWorldView2 = null;
        if (guildSmallWorldView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thirdVideoView");
            guildSmallWorldView = null;
        }
        guildSmallWorldView.g((int) (GuildSmallWorldView.INSTANCE.a() * 0.54f));
        GuildSmallWorldView guildSmallWorldView3 = this.thirdVideoView;
        if (guildSmallWorldView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thirdVideoView");
        } else {
            guildSmallWorldView2 = guildSmallWorldView3;
        }
        guildSmallWorldView2.f(ViewUtils.dpToPx(32.0f), new Pair<>(Integer.valueOf(ViewUtils.dpToPx(6.5f)), Integer.valueOf(ViewUtils.dpToPx(5.5f))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable pn1.a data, int position, @Nullable List<Object> payload) {
        Object firstOrNull;
        if (data == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data.d().h());
        t tVar = (t) firstOrNull;
        if (tVar == null) {
            return;
        }
        GuildSmallWorldView guildSmallWorldView = this.thirdVideoView;
        if (guildSmallWorldView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thirdVideoView");
            guildSmallWorldView = null;
        }
        GuildSmallWorldView.j(guildSmallWorldView, new GuildSmallWorldView.b(tVar.getUrlType(), new GuildSmallWorldView.b.C7785b(tVar.getCoverUrl(), tVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String(), true), new GuildSmallWorldView.b.a(tVar.getPlatformIconUrl(), tVar.getPlatformName())), null, null, false, 6, null);
    }
}
