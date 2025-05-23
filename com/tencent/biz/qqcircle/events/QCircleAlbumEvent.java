package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAlbumEvent extends SimpleBaseEvent {
    public static final int STATE_CREATE = 3;
    public static final int STATE_DELETE = 1;
    public static final int STATE_UPDATE = 2;
    public static final String TAG = "com.tencent.biz.qqcircle.events.QCircleAlbumEvent";
    public long albumId;
    public String coverUrl;
    public String description;
    public long itemCount;
    public int state;
    public String title;

    public QCircleAlbumEvent(int i3, long j3) {
        this.itemCount = 0L;
        this.state = i3;
        this.albumId = j3;
    }

    public QCircleAlbumEvent(int i3, long j3, String str, String str2, String str3, long j16) {
        this.state = i3;
        this.albumId = j3;
        this.coverUrl = str3;
        this.description = str2;
        this.title = str;
        this.itemCount = j16;
    }
}
