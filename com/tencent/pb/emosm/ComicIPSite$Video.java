package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;

/* loaded from: classes22.dex */
public final class ComicIPSite$Video extends MessageMicro<ComicIPSite$Video> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 98, 106}, new String[]{"id", "buttonDesc", "content", "cover", "desc", "name", "endTime", ViewStickEventHelper.IS_SHOW, "newStartTime", "newEndTime", "redirectUrl", "videoSource", "showDate"}, new Object[]{"", "", "", "", "", "", "", 0, 0L, 0L, "", "", ""}, ComicIPSite$Video.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342124id = PBField.initString("");
    public final PBStringField buttonDesc = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField endTime = PBField.initString("");
    public final PBInt32Field isShow = PBField.initInt32(0);
    public final PBInt64Field newStartTime = PBField.initInt64(0);
    public final PBInt64Field newEndTime = PBField.initInt64(0);
    public final PBStringField redirectUrl = PBField.initString("");
    public final PBStringField videoSource = PBField.initString("");
    public final PBStringField showDate = PBField.initString("");
}
