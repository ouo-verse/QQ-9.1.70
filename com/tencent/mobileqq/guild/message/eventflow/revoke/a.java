package com.tencent.mobileqq.guild.message.eventflow.revoke;

import java.util.ArrayList;
import tencent.im.group_pro_proto.eventflow.msg_event$ChannelEvents;
import tencent.im.group_pro_proto.eventflow.msg_event$GuildEvents;
import tencent.im.group_pro_proto.eventflow.msg_event$MsgEvent;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static long f230558c = -1;

    /* renamed from: a, reason: collision with root package name */
    public long f230559a = f230558c;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<C7853a> f230560b = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.message.eventflow.revoke.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C7853a {

        /* renamed from: a, reason: collision with root package name */
        public long f230561a = a.f230558c;

        /* renamed from: b, reason: collision with root package name */
        public long f230562b = a.f230558c;

        /* renamed from: c, reason: collision with root package name */
        public long f230563c = a.f230558c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<Long> f230564d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<b> f230565e = new ArrayList<>();

        public void a(msg_event$ChannelEvents msg_event_channelevents) {
            if (msg_event_channelevents != null) {
                if (msg_event_channelevents.channel_id.has()) {
                    this.f230561a = msg_event_channelevents.channel_id.get();
                }
                if (msg_event_channelevents.begin_seq.has()) {
                    this.f230562b = msg_event_channelevents.begin_seq.get();
                }
                if (msg_event_channelevents.end_seq.has()) {
                    this.f230563c = msg_event_channelevents.end_seq.get();
                }
                if (msg_event_channelevents.event_types.has()) {
                    this.f230564d = (ArrayList) msg_event_channelevents.event_types.get();
                }
                if (msg_event_channelevents.msg_events.has()) {
                    for (msg_event$MsgEvent msg_event_msgevent : msg_event_channelevents.msg_events.get()) {
                        b bVar = new b();
                        bVar.a(msg_event_msgevent);
                        this.f230565e.add(bVar);
                    }
                }
            }
        }

        public String toString() {
            return "ChannelItem{channelId=" + this.f230561a + ", beginSeq=" + this.f230562b + ", endSeq=" + this.f230563c + ", eventTypes=" + this.f230564d + ", msgEventsItemList=" + this.f230565e + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f230566a = a.f230558c;

        /* renamed from: b, reason: collision with root package name */
        public long f230567b = a.f230558c;

        /* renamed from: c, reason: collision with root package name */
        public bu1.a f230568c;

        public void a(msg_event$MsgEvent msg_event_msgevent) {
            if (msg_event_msgevent != null) {
                if (msg_event_msgevent.msg_seq.has()) {
                    this.f230566a = msg_event_msgevent.msg_seq.get();
                }
                if (msg_event_msgevent.event_version.has()) {
                    this.f230567b = msg_event_msgevent.event_version.get();
                }
                if (msg_event_msgevent.events.has()) {
                    this.f230568c = new bu1.a(msg_event_msgevent.events.get());
                }
            }
        }

        public String toString() {
            return "MsgEventsItem{msgSeq=" + this.f230566a + ", eventVersion=" + this.f230567b + ", guildMsgEventInfo=" + this.f230568c + '}';
        }
    }

    public void b(msg_event$GuildEvents msg_event_guildevents) {
        if (msg_event_guildevents != null) {
            if (msg_event_guildevents.guild_id.has()) {
                this.f230559a = msg_event_guildevents.guild_id.get();
            }
            if (msg_event_guildevents.channels.has()) {
                for (msg_event$ChannelEvents msg_event_channelevents : msg_event_guildevents.channels.get()) {
                    C7853a c7853a = new C7853a();
                    c7853a.a(msg_event_channelevents);
                    this.f230560b.add(c7853a);
                }
            }
        }
    }

    public String toString() {
        return "GuildRegisterProxyRevokeEventItem{guildId=" + this.f230559a + ", channelItemList=" + this.f230560b + '}';
    }
}
