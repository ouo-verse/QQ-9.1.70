package com.tencent.mobileqq.troop.aivoicechat.voicelist.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/event/TroopAIVoiceChatListRefreshSelectVoice;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "oldConfig", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", "(Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;)V", "getOldConfig", "()Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class TroopAIVoiceChatListRefreshSelectVoice extends SimpleBaseEvent {
    private final TroopAIVoiceChatListConfig oldConfig;

    public TroopAIVoiceChatListRefreshSelectVoice(TroopAIVoiceChatListConfig oldConfig) {
        Intrinsics.checkNotNullParameter(oldConfig, "oldConfig");
        this.oldConfig = oldConfig;
    }

    /* renamed from: component1, reason: from getter */
    public final TroopAIVoiceChatListConfig getOldConfig() {
        return this.oldConfig;
    }

    public final TroopAIVoiceChatListRefreshSelectVoice copy(TroopAIVoiceChatListConfig oldConfig) {
        Intrinsics.checkNotNullParameter(oldConfig, "oldConfig");
        return new TroopAIVoiceChatListRefreshSelectVoice(oldConfig);
    }

    public final TroopAIVoiceChatListConfig getOldConfig() {
        return this.oldConfig;
    }

    public int hashCode() {
        return this.oldConfig.hashCode();
    }

    public String toString() {
        return "TroopAIVoiceChatListRefreshSelectVoice(oldConfig=" + this.oldConfig + ")";
    }

    public static /* synthetic */ TroopAIVoiceChatListRefreshSelectVoice copy$default(TroopAIVoiceChatListRefreshSelectVoice troopAIVoiceChatListRefreshSelectVoice, TroopAIVoiceChatListConfig troopAIVoiceChatListConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            troopAIVoiceChatListConfig = troopAIVoiceChatListRefreshSelectVoice.oldConfig;
        }
        return troopAIVoiceChatListRefreshSelectVoice.copy(troopAIVoiceChatListConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TroopAIVoiceChatListRefreshSelectVoice) && Intrinsics.areEqual(this.oldConfig, ((TroopAIVoiceChatListRefreshSelectVoice) other).oldConfig);
    }
}
