package com.tencent.mobileqq.troop.aivoicechat.voicelist.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/event/TroopAIVoiceChatListSelectVoice;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tabName", "", "selectedVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "selectedConfig", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;)V", "getSelectedConfig", "()Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", "getSelectedVoice", "()Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "getTabName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class TroopAIVoiceChatListSelectVoice extends SimpleBaseEvent {
    private final TroopAIVoiceChatListConfig selectedConfig;
    private final VoiceItem selectedVoice;
    private final String tabName;

    public TroopAIVoiceChatListSelectVoice(String tabName, VoiceItem selectedVoice, TroopAIVoiceChatListConfig selectedConfig) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(selectedVoice, "selectedVoice");
        Intrinsics.checkNotNullParameter(selectedConfig, "selectedConfig");
        this.tabName = tabName;
        this.selectedVoice = selectedVoice;
        this.selectedConfig = selectedConfig;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    /* renamed from: component2, reason: from getter */
    public final VoiceItem getSelectedVoice() {
        return this.selectedVoice;
    }

    /* renamed from: component3, reason: from getter */
    public final TroopAIVoiceChatListConfig getSelectedConfig() {
        return this.selectedConfig;
    }

    public final TroopAIVoiceChatListSelectVoice copy(String tabName, VoiceItem selectedVoice, TroopAIVoiceChatListConfig selectedConfig) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(selectedVoice, "selectedVoice");
        Intrinsics.checkNotNullParameter(selectedConfig, "selectedConfig");
        return new TroopAIVoiceChatListSelectVoice(tabName, selectedVoice, selectedConfig);
    }

    public final TroopAIVoiceChatListConfig getSelectedConfig() {
        return this.selectedConfig;
    }

    public final VoiceItem getSelectedVoice() {
        return this.selectedVoice;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public int hashCode() {
        return (((this.tabName.hashCode() * 31) + this.selectedVoice.hashCode()) * 31) + this.selectedConfig.hashCode();
    }

    public String toString() {
        return "TroopAIVoiceChatListSelectVoice(tabName=" + this.tabName + ", selectedVoice=" + this.selectedVoice + ", selectedConfig=" + this.selectedConfig + ")";
    }

    public static /* synthetic */ TroopAIVoiceChatListSelectVoice copy$default(TroopAIVoiceChatListSelectVoice troopAIVoiceChatListSelectVoice, String str, VoiceItem voiceItem, TroopAIVoiceChatListConfig troopAIVoiceChatListConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = troopAIVoiceChatListSelectVoice.tabName;
        }
        if ((i3 & 2) != 0) {
            voiceItem = troopAIVoiceChatListSelectVoice.selectedVoice;
        }
        if ((i3 & 4) != 0) {
            troopAIVoiceChatListConfig = troopAIVoiceChatListSelectVoice.selectedConfig;
        }
        return troopAIVoiceChatListSelectVoice.copy(str, voiceItem, troopAIVoiceChatListConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopAIVoiceChatListSelectVoice)) {
            return false;
        }
        TroopAIVoiceChatListSelectVoice troopAIVoiceChatListSelectVoice = (TroopAIVoiceChatListSelectVoice) other;
        return Intrinsics.areEqual(this.tabName, troopAIVoiceChatListSelectVoice.tabName) && Intrinsics.areEqual(this.selectedVoice, troopAIVoiceChatListSelectVoice.selectedVoice) && Intrinsics.areEqual(this.selectedConfig, troopAIVoiceChatListSelectVoice.selectedConfig);
    }
}
