package com.tencent.mobileqq.guild.media;

import com.tencent.mobileqq.guild.media.content.GuildMediaChatContent;
import com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase;
import com.tencent.mobileqq.guild.media.content.GuildMediaGameContent;
import com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/media/y;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/y$a;", "", "", "topicType", "Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.y$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildMediaContentFragmentBase a(int topicType) {
            if (topicType != 1) {
                if (topicType != 2) {
                    if (topicType != 6) {
                        return new GuildMediaChatContent();
                    }
                    return new GuildMediaThirdAppContent();
                }
                return new GuildMediaGameContent();
            }
            return new GuildMediaChatContent();
        }

        Companion() {
        }
    }
}
