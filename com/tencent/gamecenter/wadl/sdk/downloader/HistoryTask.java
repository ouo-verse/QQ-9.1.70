package com.tencent.gamecenter.wadl.sdk.downloader;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HistoryTask {

    /* renamed from: a, reason: collision with root package name */
    private final String f107264a;

    /* renamed from: b, reason: collision with root package name */
    private final int f107265b;

    /* renamed from: c, reason: collision with root package name */
    private final long f107266c;

    /* renamed from: d, reason: collision with root package name */
    private final DownloaderTaskCategory f107267d;

    /* renamed from: e, reason: collision with root package name */
    private final DownloaderTaskPriority f107268e;

    /* renamed from: f, reason: collision with root package name */
    private final String f107269f;

    /* renamed from: g, reason: collision with root package name */
    private final String f107270g;

    /* renamed from: h, reason: collision with root package name */
    private final String f107271h;

    /* renamed from: i, reason: collision with root package name */
    private final DownloaderTaskStatus f107272i;

    /* renamed from: j, reason: collision with root package name */
    private final long f107273j;

    /* renamed from: k, reason: collision with root package name */
    private final long f107274k;

    /* renamed from: l, reason: collision with root package name */
    private final int f107275l;

    public HistoryTask(String str, int i3, long j3, DownloaderTaskCategory downloaderTaskCategory, DownloaderTaskPriority downloaderTaskPriority, String str2, String str3, String str4, DownloaderTaskStatus downloaderTaskStatus, long j16, long j17, int i16) {
        this.f107264a = str;
        this.f107265b = i3;
        this.f107266c = j3;
        this.f107267d = downloaderTaskCategory;
        this.f107268e = downloaderTaskPriority;
        this.f107269f = str2;
        this.f107270g = str3;
        this.f107271h = str4;
        this.f107272i = downloaderTaskStatus;
        this.f107273j = j16;
        this.f107274k = j17;
        this.f107275l = i16;
    }

    public DownloaderTaskCategory getCategory() {
        return this.f107267d;
    }

    public String getId() {
        return this.f107264a;
    }

    public long getKnownSize() {
        return this.f107266c;
    }

    public long getPercentage() {
        return this.f107275l;
    }

    public DownloaderTaskPriority getPriority() {
        return this.f107268e;
    }

    public long getReceivedLength() {
        return this.f107274k;
    }

    public String getSaveDir() {
        return this.f107270g;
    }

    public String getSaveName() {
        return this.f107271h;
    }

    public DownloaderTaskStatus getStatus() {
        return this.f107272i;
    }

    public long getTotalLength() {
        return this.f107273j;
    }

    public int getType() {
        return this.f107265b;
    }

    public String getUrl() {
        return this.f107269f;
    }

    public String toString() {
        return "HistoryTask{Id='" + this.f107264a + "', type=" + this.f107265b + ", knownSize='" + this.f107266c + "', category=" + this.f107267d + ", priority=" + this.f107268e + ", url='" + this.f107269f + "', saveDir='" + this.f107270g + "', saveName='" + this.f107271h + "', status=" + this.f107272i + ", totalLen=" + this.f107273j + ", rcvLen=" + this.f107274k + ", percent=" + this.f107275l + '}';
    }
}
