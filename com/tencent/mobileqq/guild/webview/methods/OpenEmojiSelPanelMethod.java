package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.event.GuildEmojiDialogDismissEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedEmojiEvent;
import java.util.ArrayList;

/* loaded from: classes14.dex */
public class OpenEmojiSelPanelMethod extends a implements SimpleEventReceiver {

    @Keep
    /* loaded from: classes14.dex */
    private static class InvokeResult {

        @SerializedName("emojiId")
        public String emojiId;

        @SerializedName("emojiType")
        public int emojiType;

        /* renamed from: msg, reason: collision with root package name */
        @SerializedName("msg")
        public String f235753msg;

        @SerializedName("result")
        public int result;

        InvokeResult() {
        }

        public static InvokeResult create(int i3, String str, String str2, int i16) {
            InvokeResult invokeResult = new InvokeResult();
            invokeResult.result = i3;
            invokeResult.f235753msg = str;
            invokeResult.emojiId = str2;
            invokeResult.emojiType = i16;
            return invokeResult;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedEmojiEvent.class);
        arrayList.add(GuildEmojiDialogDismissEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.aa.class, new Object[0]);
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedEmojiEvent) {
            GuildFeedEmojiEvent guildFeedEmojiEvent = (GuildFeedEmojiEvent) simpleBaseEvent;
            i(InvokeResult.create(0, "", String.valueOf(guildFeedEmojiEvent.mEmojiId), guildFeedEmojiEvent.mEmojiType).toJson());
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        } else if (simpleBaseEvent instanceof GuildEmojiDialogDismissEvent) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }
}
