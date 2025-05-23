package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GuildScheduleChannelInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private final long channelId;
    private final String channelName;
    private final long guildId;
    private final boolean hasJoin;
    private final boolean isPrivate;
    private final int type;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f265606a;

        /* renamed from: b, reason: collision with root package name */
        private int f265607b;

        /* renamed from: c, reason: collision with root package name */
        private long f265608c;

        /* renamed from: d, reason: collision with root package name */
        private String f265609d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f265610e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f265611f;

        public GuildScheduleChannelInfo g() {
            return new GuildScheduleChannelInfo(this);
        }

        public a h(long j3) {
            this.f265606a = j3;
            return this;
        }

        public a i(String str) {
            this.f265609d = str;
            return this;
        }

        public a j(long j3) {
            this.f265608c = j3;
            return this;
        }

        public a k(boolean z16) {
            this.f265611f = z16;
            return this;
        }

        public a l(boolean z16) {
            this.f265610e = z16;
            return this;
        }

        public a m(int i3) {
            this.f265607b = i3;
            return this;
        }
    }

    public GuildScheduleChannelInfo() {
        this.channelId = 0L;
        this.type = 0;
        this.guildId = 0L;
        this.channelName = "";
        this.isPrivate = false;
        this.hasJoin = false;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getType() {
        return this.type;
    }

    public boolean isHasJoin() {
        return this.hasJoin;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isValidChannelInfo() {
        if (this.channelId != 0 || this.guildId != 0) {
            return true;
        }
        return false;
    }

    GuildScheduleChannelInfo(a aVar) {
        this.channelId = aVar.f265606a;
        this.type = aVar.f265607b;
        this.guildId = aVar.f265608c;
        this.channelName = aVar.f265609d;
        this.isPrivate = aVar.f265610e;
        this.hasJoin = aVar.f265611f;
    }
}
