package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.event.GuildHashtagDialogDismissEvent;
import com.tencent.mobileqq.guild.event.GuildHashtagDialogEmptyEvent;
import com.tencent.mobileqq.guild.event.GuildHashtagEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartEmptyEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartPanelDismissEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartSelectEvent;
import com.tencent.mobileqq.guild.feed.publish.result.SelectGuildResult;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ac extends b {

    /* renamed from: h, reason: collision with root package name */
    private boolean f220011h = false;

    private void r() {
        if (this.f220011h) {
            i(SelectGuildResult.d());
        }
        this.f220011h = false;
    }

    private void s() {
        lj1.a l3 = l();
        if (l3 == null) {
            return;
        }
        l3.showMoveHashtagEmptyToastMsg();
        if (this.f220011h) {
            i(SelectGuildResult.d());
        }
        this.f220011h = false;
    }

    private void t(String str, String str2, String str3, boolean z16) {
        i(new SelectGuildResult(str, str2, str3, z16).e());
        this.f220011h = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "showFeedChannelsPopper";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.showGuildHashtag();
        this.f220011h = true;
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildHashtagEvent.class);
        arrayList.add(GuildHashtagDialogEmptyEvent.class);
        arrayList.add(GuildHashtagDialogDismissEvent.class);
        arrayList.add(GuildPartSelectEvent.class);
        arrayList.add(GuildPartEmptyEvent.class);
        arrayList.add(GuildPartPanelDismissEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        boolean z16;
        if (simpleBaseEvent instanceof GuildHashtagEvent) {
            GuildHashtagEvent guildHashtagEvent = (GuildHashtagEvent) simpleBaseEvent;
            String str = guildHashtagEvent.guildId;
            String str2 = guildHashtagEvent.channelUin;
            String str3 = guildHashtagEvent.channelName;
            if (guildHashtagEvent.viewType == HashTagViewType.VIEW_TYPE_FEED_SQUARE) {
                z16 = true;
            } else {
                z16 = false;
            }
            t(str, str2, str3, z16);
            return;
        }
        if (simpleBaseEvent instanceof GuildPartSelectEvent) {
            GuildPartSelectEvent guildPartSelectEvent = (GuildPartSelectEvent) simpleBaseEvent;
            t(guildPartSelectEvent.guildId, guildPartSelectEvent.channelUin, guildPartSelectEvent.channelName, guildPartSelectEvent.isSquare);
        } else {
            if (!(simpleBaseEvent instanceof GuildHashtagDialogDismissEvent) && !(simpleBaseEvent instanceof GuildPartPanelDismissEvent)) {
                if ((simpleBaseEvent instanceof GuildHashtagDialogEmptyEvent) || (simpleBaseEvent instanceof GuildPartEmptyEvent)) {
                    s();
                    return;
                }
                return;
            }
            r();
        }
    }
}
