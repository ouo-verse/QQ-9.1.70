package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GuildScheduleUser implements Serializable {
    private static final long serialVersionUID = 1;
    private final String avatar;
    private final String nick;
    private final int role;
    private final long tinyId;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265634a = "";

        /* renamed from: b, reason: collision with root package name */
        private long f265635b = 0;

        /* renamed from: c, reason: collision with root package name */
        private String f265636c = "";

        /* renamed from: d, reason: collision with root package name */
        private int f265637d = 0;

        public a e(String str) {
            this.f265636c = str;
            return this;
        }

        public GuildScheduleUser f() {
            return new GuildScheduleUser(this);
        }

        public a g(String str) {
            this.f265634a = str;
            return this;
        }

        public a h(int i3) {
            this.f265637d = i3;
            return this;
        }

        public a i(long j3) {
            this.f265635b = j3;
            return this;
        }
    }

    public GuildScheduleUser() {
        this.nick = "";
        this.tinyId = 0L;
        this.avatar = "";
        this.role = 0;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public int getRole() {
        return this.role;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    GuildScheduleUser(a aVar) {
        this.nick = aVar.f265634a;
        this.tinyId = aVar.f265635b;
        this.avatar = aVar.f265636c;
        this.role = aVar.f265637d;
    }
}
