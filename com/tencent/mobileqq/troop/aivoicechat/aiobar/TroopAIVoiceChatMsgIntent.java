package com.tencent.mobileqq.troop.aivoicechat.aiobar;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "AddVoiceIntent", "LifeCycleUpdateIntent", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent$AddVoiceIntent;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent$LifeCycleUpdateIntent;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public abstract class TroopAIVoiceChatMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent$LifeCycleUpdateIntent;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "lifeCycleState", "<init>", "(I)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final /* data */ class LifeCycleUpdateIntent extends TroopAIVoiceChatMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int lifeCycleState;

        /* renamed from: a, reason: from getter */
        public final int getLifeCycleState() {
            return this.lifeCycleState;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatMsgIntent.LifeCycleUpdateIntent";
        }

        public int hashCode() {
            return this.lifeCycleState;
        }

        public String toString() {
            return "LifeCycleUpdateIntent(lifeCycleState=" + this.lifeCycleState + ")";
        }

        public LifeCycleUpdateIntent(int i3) {
            super(null);
            this.lifeCycleState = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LifeCycleUpdateIntent) && this.lifeCycleState == ((LifeCycleUpdateIntent) other).lifeCycleState;
        }
    }

    public /* synthetic */ TroopAIVoiceChatMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    TroopAIVoiceChatMsgIntent() {
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent$AddVoiceIntent;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "voiceItemList", "<init>", "(Ljava/util/List;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final /* data */ class AddVoiceIntent extends TroopAIVoiceChatMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<VoiceItem> voiceItemList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddVoiceIntent(List<VoiceItem> voiceItemList) {
            super(null);
            Intrinsics.checkNotNullParameter(voiceItemList, "voiceItemList");
            this.voiceItemList = voiceItemList;
        }

        public final List<VoiceItem> a() {
            return this.voiceItemList;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatMsgIntent.AddVoiceIntent";
        }

        public int hashCode() {
            return this.voiceItemList.hashCode();
        }

        public String toString() {
            return "AddVoiceIntent(voiceItemList=" + this.voiceItemList + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AddVoiceIntent) && Intrinsics.areEqual(this.voiceItemList, ((AddVoiceIntent) other).voiceItemList);
        }
    }
}
