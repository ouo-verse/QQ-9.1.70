package com.tencent.mobileqq.guild.feed.publish.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedEmojiEvent;
import com.tencent.mobileqq.guild.feed.publish.widget.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements EmoticonCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                int localToServer = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).localToServer(String.valueOf(i16), i3);
                QLog.d("GuildFeedPublishEmojiPa", 1, "emojiId:" + i16 + ", emojiType:" + i3 + ",sid:" + localToServer);
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedEmojiEvent(i3, localToServer, null));
                ho1.d.a(f.this.f223196f, systemAndEmojiEmoticonInfo);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    public f(Context context, FrameLayout frameLayout, b.a aVar) {
        super(context, frameLayout, aVar);
    }

    private EmoticonCallback n() {
        return new a();
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.widget.b
    @NonNull
    protected View j() {
        return ho1.d.c(this.f223194d, null, n());
    }
}
