package com.tencent.mobileqq.guild.media.thirdapp.container.plugin;

import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/EntryType;", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        @NotNull
        public static EntryType a(@NotNull d dVar) {
            return EntryType.WEB;
        }
    }

    @NotNull
    EntryType a();

    void b(@NotNull ContainerMsgIntent intent);
}
