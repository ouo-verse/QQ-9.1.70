package com.tencent.mobileqq.guild.discoveryv2.fragment;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.mvi.base.route.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/MVPFeedsDepends;", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "", "d", "getContentWidth", "b", "a", h.F, "", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/c;", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/c;", "playableManager", "Lcom/tencent/mvi/base/route/j;", "Lcom/tencent/mvi/base/route/j;", "getMessage", "()Lcom/tencent/mvi/base/route/j;", "message", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class MVPFeedsDepends implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy playableManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j message;

    public MVPFeedsDepends() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PlayableManager>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends$playableManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PlayableManager invoke() {
                return new PlayableManager();
            }
        });
        this.playableManager = lazy;
        this.message = new VMMessenger(false, null, 3, null);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    public int a() {
        return (b() / 4) * 3;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    public int b() {
        return (getContentWidth() - (QQGuildUIUtil.l(R.dimen.cdz) * 6)) / 2;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    public int d() {
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    public boolean f() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    @NotNull
    public com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c g() {
        return (com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c) this.playableManager.getValue();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    public abstract int getContentWidth();

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    @NotNull
    public final j getMessage() {
        return this.message;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
    public int h() {
        return (b() / 4) * 5;
    }
}
