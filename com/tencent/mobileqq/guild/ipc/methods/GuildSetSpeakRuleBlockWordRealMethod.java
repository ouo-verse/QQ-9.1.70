package com.tencent.mobileqq.guild.ipc.methods;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/GuildSetSpeakRuleBlockWordRealMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "ipcContext", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "SetSpeakRuleBlockWordEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSetSpeakRuleBlockWordRealMethod extends AbsIpcMethod {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/GuildSetSpeakRuleBlockWordRealMethod$SetSpeakRuleBlockWordEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "words", "", "(Ljava/lang/String;Ljava/util/List;)V", "getGuildId", "()Ljava/lang/String;", "getWords", "()Ljava/util/List;", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class SetSpeakRuleBlockWordEvent extends SimpleBaseEvent {

        @NotNull
        private final String guildId;

        @NotNull
        private final List<String> words;

        public SetSpeakRuleBlockWordEvent(@NotNull String guildId, @NotNull List<String> words) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(words, "words");
            this.guildId = guildId;
            this.words = words;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        public final List<String> getWords() {
            return this.words;
        }

        @NotNull
        public String toString() {
            return "SetSpeakRuleBlockWordEvent(guildId=" + this.guildId + ", words=" + this.words + ")";
        }
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@Nullable AbsIpcMethod.a ipcContext, @Nullable String method, @NotNull Object... arguments) {
        String replace$default;
        String replace$default2;
        List arrayList;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        try {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildSetSpeakRuleBlockWordRealMethod", 2, "GuildSetSpeakRuleBlockWordRealMethod arguments:" + arguments);
            }
            boolean z16 = false;
            Object obj = arguments[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = arguments[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            replace$default = StringsKt__StringsJVMKt.replace$default((String) obj2, "[", "", false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "]", "", false, 4, (Object) null);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (replace$default2.length() > 0) {
                z16 = true;
            }
            if (z16) {
                arrayList = StringsKt__StringsKt.split$default((CharSequence) replace$default2, new String[]{","}, false, 0, 6, (Object) null);
            } else {
                arrayList = new ArrayList();
            }
            simpleEventBus.dispatchEvent(new SetSpeakRuleBlockWordEvent(str, arrayList));
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(null);
            Intrinsics.checkNotNullExpressionValue(createSuccessResult, "{\n            Logger.col\u2026essResult(null)\n        }");
            return createSuccessResult;
        } catch (Exception e16) {
            EIPCResult createExceptionResult = EIPCResult.createExceptionResult(e16);
            Intrinsics.checkNotNullExpressionValue(createExceptionResult, "{\n            EIPCResult\u2026ptionResult(ex)\n        }");
            return createExceptionResult;
        }
    }
}
