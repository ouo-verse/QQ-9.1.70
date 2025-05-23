package com.tencent.mobileqq.matchfriend.voicechat.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController;
import com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi;
import com.tencent.relation.common.activity.QPublicTransFragmentActivityForQQStranger;
import o72.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VoiceChatApiImpl implements IVoiceChatApi {
    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public void enterVoiceMatchOnlinePage(Context context, RoomInfo roomInfo) {
        Intent intent = new Intent();
        intent.putExtra("key_room_info", roomInfo);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityForQQStranger.class, MatchFriendVoiceMatchFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public void exitRoom() {
        VoiceChatController.I().D();
    }

    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public boolean isInVoiceChat() {
        return VoiceChatController.I().N();
    }

    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public void onQQStrangerProcessCreate() {
        b.register();
    }

    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public void onQQStrangerProcessDestroy() {
        b.unregister();
    }

    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public void restoreVoiceChatPage(Context context, int i3) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("key_is_restore", true);
        intent.putExtra("key_room_id", i3);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityForQQStranger.class, MatchFriendVoiceMatchFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi
    public void setRestoreVoiceChatIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.putExtra("public_fragment_class", MatchFriendVoiceMatchFragment.class.getName());
        intent.putExtra("key_is_from_notification", true);
        RoomInfo E = VoiceChatController.I().E();
        intent.putExtra("key_room_id", E == null ? 0 : E.f245597d);
    }
}
