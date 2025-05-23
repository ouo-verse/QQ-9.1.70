package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedEmojiEvent;
import com.tencent.mobileqq.guild.feed.publish.result.EmojiResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ab extends b {
    private void r(GuildFeedEmojiEvent guildFeedEmojiEvent) {
        if (guildFeedEmojiEvent == null) {
            return;
        }
        EmojiResult emojiResult = new EmojiResult(guildFeedEmojiEvent.mEmojiType, guildFeedEmojiEvent.getEmojiId(), "");
        lj1.a l3 = l();
        QLog.e("ShowEmojiMethod", 2, "result->" + emojiResult.c());
        if (l3 != null && !l3.isNativeEmojiClick()) {
            i(emojiResult.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "showEmoji";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.showEmoji(b("show"));
        l3.setNativeEmojiClick(false);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    public ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedEmojiEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    public void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedEmojiEvent) {
            r((GuildFeedEmojiEvent) simpleBaseEvent);
        }
    }
}
