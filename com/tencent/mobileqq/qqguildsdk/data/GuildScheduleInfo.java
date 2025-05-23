package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProOtherJumpAddress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GuildScheduleInfo implements Serializable, Cloneable {
    public static final int STATUS_EXPIRED = 4;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_READY = 2;
    public static final int STATUS_STARTED = 3;
    private static final long serialVersionUID = 1;
    int acceptedNums;
    final ArrayList<GuildScheduleUser> acceptedUser;
    final GuildScheduleChannelInfo channelInfo;
    final String content;
    final long createTimeMs;
    final GuildScheduleUser creator;
    private long dateMs;
    final long endTimeMs;
    int inviteStatus;
    final boolean isNotified;
    final String mChannelName;
    final String mCoverUrl;
    final String mGuildName;
    final String mIconUrl;
    final int mTitleFontColor;
    final byte[] needDecodeData;
    public GProOtherJumpAddress otherJumpAddress;
    final int rejectedNums;
    final int reminderTimeType;
    final long scheduleId;
    final long startTimeMs;
    final String title;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f265612a;

        /* renamed from: b, reason: collision with root package name */
        private long f265613b = 0;

        /* renamed from: c, reason: collision with root package name */
        private String f265614c = "";

        /* renamed from: d, reason: collision with root package name */
        private long f265615d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f265616e = 0;

        /* renamed from: f, reason: collision with root package name */
        private String f265617f = "";

        /* renamed from: g, reason: collision with root package name */
        private int f265618g = 0;

        /* renamed from: h, reason: collision with root package name */
        private GuildScheduleChannelInfo f265619h = new GuildScheduleChannelInfo();

        /* renamed from: i, reason: collision with root package name */
        private GProOtherJumpAddress f265620i = new GProOtherJumpAddress();

        /* renamed from: j, reason: collision with root package name */
        private int f265621j = 0;

        /* renamed from: k, reason: collision with root package name */
        private long f265622k = 0;

        /* renamed from: l, reason: collision with root package name */
        private GuildScheduleUser f265623l = new GuildScheduleUser();

        /* renamed from: m, reason: collision with root package name */
        private int f265624m = 0;

        /* renamed from: n, reason: collision with root package name */
        private int f265625n = 0;

        /* renamed from: o, reason: collision with root package name */
        private ArrayList<GuildScheduleUser> f265626o = new ArrayList<>();

        /* renamed from: p, reason: collision with root package name */
        private boolean f265627p = false;

        /* renamed from: q, reason: collision with root package name */
        private String f265628q = "";

        /* renamed from: r, reason: collision with root package name */
        private String f265629r = "";

        /* renamed from: s, reason: collision with root package name */
        private String f265630s = "";

        /* renamed from: t, reason: collision with root package name */
        private int f265631t = 0;

        /* renamed from: u, reason: collision with root package name */
        private String f265632u = "";

        /* renamed from: v, reason: collision with root package name */
        private byte[] f265633v = new byte[0];

        public a A(String str) {
            this.f265617f = str;
            return this;
        }

        public a B(long j3) {
            this.f265622k = j3;
            return this;
        }

        public a C(GuildScheduleUser guildScheduleUser) {
            this.f265623l = guildScheduleUser;
            return this;
        }

        public a D(long j3) {
            this.f265612a = j3;
            return this;
        }

        public a E(long j3) {
            this.f265616e = j3;
            return this;
        }

        public a F(int i3) {
            this.f265621j = i3;
            return this;
        }

        public a G(boolean z16) {
            this.f265627p = z16;
            return this;
        }

        public a H(GProOtherJumpAddress gProOtherJumpAddress) {
            this.f265620i = gProOtherJumpAddress;
            return this;
        }

        public a I(int i3) {
            this.f265625n = i3;
            return this;
        }

        public a J(int i3) {
            this.f265618g = i3;
            return this;
        }

        public a K(long j3) {
            this.f265613b = j3;
            return this;
        }

        public void L(String str) {
            this.f265632u = str;
        }

        public void M(String str) {
            this.f265629r = str;
        }

        public void N(String str) {
            this.f265628q = str;
        }

        public void O(String str) {
            this.f265630s = str;
        }

        public void P(int i3) {
            this.f265631t = i3;
        }

        public a Q(long j3) {
            this.f265615d = j3;
            return this;
        }

        public a R(String str) {
            this.f265614c = str;
            return this;
        }

        public a w(int i3) {
            this.f265624m = i3;
            return this;
        }

        public a x(ArrayList<GuildScheduleUser> arrayList) {
            this.f265626o = arrayList;
            return this;
        }

        public GuildScheduleInfo y() {
            return new GuildScheduleInfo(this);
        }

        public a z(GuildScheduleChannelInfo guildScheduleChannelInfo) {
            this.f265619h = guildScheduleChannelInfo;
            return this;
        }
    }

    public GuildScheduleInfo() {
        this.scheduleId = 0L;
        this.title = "";
        this.startTimeMs = 0L;
        this.endTimeMs = 0L;
        this.content = "";
        this.reminderTimeType = 0;
        this.channelInfo = new GuildScheduleChannelInfo();
        this.otherJumpAddress = new GProOtherJumpAddress();
        this.inviteStatus = 0;
        this.createTimeMs = 0L;
        this.creator = new GuildScheduleUser();
        this.acceptedNums = 0;
        this.rejectedNums = 0;
        this.acceptedUser = new ArrayList<>();
        this.isNotified = false;
        this.mGuildName = "";
        this.mCoverUrl = "";
        this.mIconUrl = "";
        this.mTitleFontColor = 0;
        this.mChannelName = "";
        this.needDecodeData = new byte[0];
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAcceptedNums() {
        return Math.max(this.acceptedNums, 0);
    }

    public ArrayList<GuildScheduleUser> getAcceptedUser() {
        return this.acceptedUser;
    }

    public GuildScheduleChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public String getContent() {
        return this.content;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public GuildScheduleUser getCreator() {
        return this.creator;
    }

    public long getDateMs() {
        return this.dateMs;
    }

    public long getEndTimeMs() {
        return this.endTimeMs;
    }

    public String getGuildName() {
        return this.mGuildName;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public byte[] getNeedDecodeData() {
        return this.needDecodeData;
    }

    public GProOtherJumpAddress getOtherJumpAddress() {
        return this.otherJumpAddress;
    }

    public int getRejectedNums() {
        return Math.max(this.rejectedNums, 0);
    }

    public int getReminderTimeType() {
        return this.reminderTimeType;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public int getStatus() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis >= this.endTimeMs) {
            return 4;
        }
        if (timeInMillis >= this.startTimeMs) {
            return 3;
        }
        if (this.startTimeMs - timeInMillis < reminderTimeMs()) {
            return 2;
        }
        return 1;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitleFontColor() {
        return this.mTitleFontColor;
    }

    public void increaseAcceptNums() {
        this.acceptedNums++;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void reduceAcceptedNums() {
        this.acceptedNums--;
    }

    public long reminderTimeMs() {
        int i3 = this.reminderTimeType;
        int i16 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            i16 = 60;
                        }
                    } else {
                        i16 = 30;
                    }
                } else {
                    i16 = 15;
                }
            } else {
                i16 = 5;
            }
        }
        return i16 * 60000;
    }

    public void setDateMs(long j3) {
        this.dateMs = j3;
    }

    public String toString() {
        return "GuildScheduleInfo{dateMs=" + this.dateMs + ", scheduleId=" + this.scheduleId + ", title='" + this.title + "', startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + ", reminderTimeType=" + this.reminderTimeType + ", channelInfo=" + this.channelInfo.getChannelId() + ", otherJumpAddress=" + this.otherJumpAddress.addressType + ", inviteStatus=" + this.inviteStatus + ", createTimeMs=" + this.createTimeMs + ", acceptedNums=" + this.acceptedNums + ", acceptedUser=" + this.acceptedUser.size() + '}';
    }

    public void updateInviteStatus(int i3) {
        this.inviteStatus = i3;
    }

    GuildScheduleInfo(a aVar) {
        this.scheduleId = aVar.f265613b;
        this.title = aVar.f265614c;
        this.dateMs = aVar.f265612a;
        this.startTimeMs = aVar.f265615d;
        this.endTimeMs = aVar.f265616e;
        this.content = aVar.f265617f;
        this.reminderTimeType = aVar.f265618g;
        this.channelInfo = aVar.f265619h;
        this.otherJumpAddress = aVar.f265620i;
        this.inviteStatus = aVar.f265621j;
        this.createTimeMs = aVar.f265622k;
        this.creator = aVar.f265623l;
        this.acceptedNums = aVar.f265624m;
        this.rejectedNums = aVar.f265625n;
        this.acceptedUser = aVar.f265626o;
        this.isNotified = aVar.f265627p;
        this.mGuildName = aVar.f265628q;
        this.mCoverUrl = aVar.f265629r;
        this.mIconUrl = aVar.f265630s;
        this.mTitleFontColor = aVar.f265631t;
        this.mChannelName = aVar.f265632u;
        this.needDecodeData = aVar.f265633v;
    }
}
