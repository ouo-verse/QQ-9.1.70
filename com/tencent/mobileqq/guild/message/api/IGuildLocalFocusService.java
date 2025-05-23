package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.guild.message.d;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildLocalFocusService extends IRuntimeService {
    public static final int ACTIVIE_CHANNEL_ONESELF_TYPE = 2;
    public static final int ACTIVIE_CHANNEL_SPLASH = 1;
    public static final int ACTIVIE_GUILD_MF_TYPE = 1;
    public static final int ACTIVIE_GUILD_ONESELF_TYPE = 2;
    public static final int ACTIVIE_NONE_TYPE = 0;
    public static final int NOTIFY_TYPE_ACTIVE_APPONFOREGROUND_CHANGE = 3;
    public static final int NOTIFY_TYPE_ACTIVE_CHANNEL_CHANGE = 1;
    public static final int NOTIFY_TYPE_ACTIVE_GUILD_CHANGE = 2;
    public static final int NOTIFY_TYPE_ACTIVE_TAB_CHANGE = 4;
    public static final int NOTIFY_TYPE_NONE = 0;
    public static final int SEL_TAB_CONVERSATION = 2;
    public static final int SEL_TAB_GUILD = 1;
    public static final int SEL_TAB_OTHER = 0;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f230117a;

        /* renamed from: b, reason: collision with root package name */
        public Object f230118b;

        public a(int i3, Object obj) {
            this.f230117a = i3;
            this.f230118b = obj;
        }
    }

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    long getActiveChannelId();

    d getActiveGuild();

    long getActiveGuildId();

    boolean getAppOnForeground();

    int getSelTab();

    void onTabChange(int i3);

    void setActiveChannel(d dVar);

    void setActiveGuild(d dVar);

    void setAppForeground(boolean z16);
}
