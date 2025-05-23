package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBannerBaseImageItemViewV2 extends GuildBaseWidgetView<GuildFeedRichMediaData> implements SimpleEventReceiver {
    public GuildBannerBaseImageItemViewV2(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
