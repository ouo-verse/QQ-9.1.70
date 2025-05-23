package com.tencent.mobileqq.guild.config.subconfig.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/h;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/a;", "", "content", "Ltg1/a;", "parse", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h implements a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/h$a;", "Ltg1/a;", "", "toString", "", "b", "J", "()J", "channelShowJoinDialogDelayTime", "<init>", "(J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.h$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final class GuildVisitorConfigBean extends tg1.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long channelShowJoinDialogDelayTime;

        public GuildVisitorConfigBean(long j3) {
            super(102);
            this.channelShowJoinDialogDelayTime = j3;
        }

        /* renamed from: b, reason: from getter */
        public final long getChannelShowJoinDialogDelayTime() {
            return this.channelShowJoinDialogDelayTime;
        }

        @Override // tg1.a
        @NotNull
        public String toString() {
            return "GuildVisitorConfigBean() channelShowJoinDialogDelayTime=" + this.channelShowJoinDialogDelayTime;
        }
    }

    @Override // com.tencent.mobileqq.guild.config.subconfig.parser.a
    @Nullable
    public tg1.a parse(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        JSONObject jSONObject = new JSONObject(content);
        if (jSONObject.has("channelShowJoinDialogDelayTime")) {
            return new GuildVisitorConfigBean(jSONObject.optLong("channelShowJoinDialogDelayTime"));
        }
        return null;
    }
}
