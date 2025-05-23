package com.tencent.mobileqq.troop.aivoicechat.aiobar;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "InputBarRequestFocus", "InsertAtMemberSpanUIState", "OnLifeCycleUpdate", "StartAIChatExitAnim", "UpdateBottomMarginView", "UpdateGagStatus", "UpdateVoiceListUI", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$InputBarRequestFocus;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$InsertAtMemberSpanUIState;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$OnLifeCycleUpdate;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$StartAIChatExitAnim;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$UpdateBottomMarginView;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$UpdateGagStatus;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$UpdateVoiceListUI;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public abstract class TroopAIVoiceChatUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$InputBarRequestFocus;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class InputBarRequestFocus extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name */
        public static final InputBarRequestFocus f293835d = new InputBarRequestFocus();

        InputBarRequestFocus() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$InsertAtMemberSpanUIState;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uid", "e", "c", "uin", "f", "a", "nickName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class InsertAtMemberSpanUIState extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String uid;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final String uin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final String nickName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertAtMemberSpanUIState(String uid, String uin, String nickName) {
            super(null);
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.uid = uid;
            this.uin = uin;
            this.nickName = nickName;
        }

        /* renamed from: a, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        /* renamed from: b, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        /* renamed from: c, reason: from getter */
        public final String getUin() {
            return this.uin;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$OnLifeCycleUpdate;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "", "d", "I", "a", "()I", "lifeCycleState", "<init>", "(I)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class OnLifeCycleUpdate extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int lifeCycleState;

        /* renamed from: a, reason: from getter */
        public final int getLifeCycleState() {
            return this.lifeCycleState;
        }

        public OnLifeCycleUpdate(int i3) {
            super(null);
            this.lifeCycleState = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$StartAIChatExitAnim;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class StartAIChatExitAnim extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name */
        public static final StartAIChatExitAnim f293840d = new StartAIChatExitAnim();

        StartAIChatExitAnim() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$UpdateBottomMarginView;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "", "d", "Z", "a", "()Z", "isShowKeyboard", "", "e", "I", "getKeyboardHeight", "()I", "keyboardHeight", "<init>", "(ZI)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class UpdateBottomMarginView extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowKeyboard;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int keyboardHeight;

        /* renamed from: a, reason: from getter */
        public final boolean getIsShowKeyboard() {
            return this.isShowKeyboard;
        }

        public UpdateBottomMarginView(boolean z16, int i3) {
            super(null);
            this.isShowKeyboard = z16;
            this.keyboardHeight = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$UpdateGagStatus;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "", "d", "Z", "c", "()Z", "isGag", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "wording", "f", "a", "needShowSoftInput", "<init>", "(ZLjava/lang/String;Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class UpdateGagStatus extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isGag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final String wording;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needShowSoftInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateGagStatus(boolean z16, String wording, boolean z17) {
            super(null);
            Intrinsics.checkNotNullParameter(wording, "wording");
            this.isGag = z16;
            this.wording = wording;
            this.needShowSoftInput = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedShowSoftInput() {
            return this.needShowSoftInput;
        }

        /* renamed from: b, reason: from getter */
        public final String getWording() {
            return this.wording;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsGag() {
            return this.isGag;
        }

        public /* synthetic */ UpdateGagStatus(boolean z16, String str, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, str, (i3 & 4) != 0 ? true : z17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState$UpdateVoiceListUI;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "voiceList", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "selectedVoiceItem", "<init>", "(Ljava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class UpdateVoiceListUI extends TroopAIVoiceChatUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<VoiceItem> voiceList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final VoiceItem selectedVoiceItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateVoiceListUI(List<VoiceItem> voiceList, VoiceItem voiceItem) {
            super(null);
            Intrinsics.checkNotNullParameter(voiceList, "voiceList");
            this.voiceList = voiceList;
            this.selectedVoiceItem = voiceItem;
        }

        /* renamed from: a, reason: from getter */
        public final VoiceItem getSelectedVoiceItem() {
            return this.selectedVoiceItem;
        }

        public final List<VoiceItem> b() {
            return this.voiceList;
        }
    }

    public /* synthetic */ TroopAIVoiceChatUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    TroopAIVoiceChatUIState() {
    }
}
