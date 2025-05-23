package com.tencent.guildmedia.aio.msglist.item.text;

import android.content.Context;
import com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/text/GuildMediaTextContentComponentVM;", "Lcom/tencent/guild/aio/component/combinestyle/GuildMediaItemBaseVM;", "Lcom/tencent/guildmedia/aio/msglist/item/text/b;", "intent", "", "B", "Lol3/b;", "handleIntent", "<init>", "()V", h.F, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaTextContentComponentVM extends GuildMediaItemBaseVM {

    /* renamed from: i, reason: collision with root package name */
    private static final int f113118i = ViewUtils.dip2px(83.333336f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f113119m = ViewUtils.dip2px(3.0f);

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(b intent) {
        QLog.i("GMediaTextItemVM", 1, "handleLottie ThreadName=" + Thread.currentThread().getName());
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context != null) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildMediaTextContentComponentVM$handleLottie$1(intent, this, context, null), 3, null);
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof b) {
            B((b) intent);
        }
    }
}
