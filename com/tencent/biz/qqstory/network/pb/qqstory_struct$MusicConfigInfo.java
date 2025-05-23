package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$MusicConfigInfo extends MessageMicro<qqstory_struct$MusicConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField audio_url;
    public final PBBytesField desc;
    public final PBUInt32Field duration;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f94086id = PBField.initUInt32(0);
    public final PBBytesField image_url;
    public final PBBytesField share_url;
    public final PBBytesField title;

    static {
        String[] strArr = {"id", "title", "desc", AppConstants.Key.SHARE_REQ_AUDIO_URL, "image_url", GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "duration"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, qqstory_struct$MusicConfigInfo.class);
    }

    public qqstory_struct$MusicConfigInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title = PBField.initBytes(byteStringMicro);
        this.desc = PBField.initBytes(byteStringMicro);
        this.audio_url = PBField.initBytes(byteStringMicro);
        this.image_url = PBField.initBytes(byteStringMicro);
        this.share_url = PBField.initBytes(byteStringMicro);
        this.duration = PBField.initUInt32(0);
    }
}
