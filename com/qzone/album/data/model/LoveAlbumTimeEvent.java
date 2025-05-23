package com.qzone.album.data.model;

import NS_MOBILE_PHOTO.TimeEventOp;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LoveAlbumTimeEvent implements SmartParcelable, Serializable {
    public static final int ACTION_OP_MODIFY = 2;
    public static final int ACTION_OP_NEW = 1;
    public static final int ACTION_OP_NONE = 0;

    @NeedParcel
    public long time;

    @NeedParcel
    public long type;

    @NeedParcel
    public String content = "";

    @NeedParcel
    public String copywriter = "";

    @NeedParcel
    public int action = 0;

    public LoveAlbumTimeEvent() {
    }

    public static LoveAlbumTimeEvent createFromResponse(TimeEventOp timeEventOp) {
        LoveAlbumTimeEvent loveAlbumTimeEvent = new LoveAlbumTimeEvent();
        NS_MOBILE_PHOTO.TimeEvent timeEvent = timeEventOp.events;
        loveAlbumTimeEvent.time = timeEvent.time;
        loveAlbumTimeEvent.type = timeEvent.type;
        loveAlbumTimeEvent.content = timeEvent.content;
        loveAlbumTimeEvent.copywriter = timeEvent.copywriter;
        loveAlbumTimeEvent.action = timeEventOp.action;
        return loveAlbumTimeEvent;
    }

    public static LoveAlbumTimeEvent toLoveAlbumTimeEvent(TimeEvent timeEvent) {
        LoveAlbumTimeEvent loveAlbumTimeEvent = new LoveAlbumTimeEvent();
        loveAlbumTimeEvent.time = timeEvent.f43879d;
        loveAlbumTimeEvent.type = timeEvent.f43880e;
        loveAlbumTimeEvent.content = timeEvent.f43881f;
        return loveAlbumTimeEvent;
    }

    public TimeEventOp generateRequestModel() {
        NS_MOBILE_PHOTO.TimeEvent timeEvent = new NS_MOBILE_PHOTO.TimeEvent();
        timeEvent.time = this.time;
        timeEvent.type = this.type;
        timeEvent.content = this.content;
        timeEvent.copywriter = this.copywriter;
        TimeEventOp timeEventOp = new TimeEventOp();
        timeEventOp.events = timeEvent;
        timeEventOp.action = this.action;
        return timeEventOp;
    }

    public String toString() {
        return "(time, " + this.time + ")\n(type, " + this.type + ")\n(content, " + this.content + ")\n(copywriter, " + this.copywriter + ")\n(action, " + this.action + ")";
    }

    public LoveAlbumTimeEvent(long j3) {
        this.time = Long.parseLong(new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date(j3 * 1000)));
    }
}
