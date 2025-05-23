package com.tencent.mobileqq.guild.discoveryv2.content.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshType;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00058DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "refresh", "z9", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "d", "Lkotlin/Lazy;", "x9", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "depends", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class MVPFeedsPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy depends;

    public MVPFeedsPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.discoveryv2.fragment.e>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart$depends$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.discoveryv2.fragment.e invoke() {
                Object iocInterface = PartIOCKt.getIocInterface(MVPFeedsPart.this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
                Intrinsics.checkNotNull(iocInterface);
                return (com.tencent.mobileqq.guild.discoveryv2.fragment.e) iocInterface;
            }
        });
        this.depends = lazy;
    }

    public final void refresh() {
        broadcastMessage("message_pull_to_refresh", new ContentMessage.PullToRefreshMessage(PullToRefreshType.TYPE_FINGER_SLIDING, "TAG"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.guild.discoveryv2.fragment.e x9() {
        return (com.tencent.mobileqq.guild.discoveryv2.fragment.e) this.depends.getValue();
    }

    public final void z9() {
        broadcastMessage("message_on_load_more", new ContentMessage.LoadMoreMessage(LoadMoreType.TYPE_FINGER_SLIDING, "TAG"));
    }
}
