package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildUpdateOperationImgEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class as extends f {

    /* renamed from: h, reason: collision with root package name */
    private ImageView f222536h;

    private void B9(GuildUpdateOperationImgEvent guildUpdateOperationImgEvent) {
        String guildId = guildUpdateOperationImgEvent.getGuildId();
        String url = guildUpdateOperationImgEvent.getUrl();
        if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(url) && guildId.equals(x9().getGuildId())) {
            com.tencent.mobileqq.guild.u.p(url, this.f222536h);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildUpdateOperationImgEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f222536h = (ImageView) view.findViewById(R.id.wf8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildUpdateOperationImgEvent) {
            B9((GuildUpdateOperationImgEvent) simpleBaseEvent);
        }
    }
}
