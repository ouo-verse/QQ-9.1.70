package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$ItemInfo extends MessageMicro<giftMidgroundPanel$ItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 64, 74, 82, 90, 96, 104, 112}, new String[]{"item_id", "name", "level", "price", "creater", AlbumCacheData.CREATE_TIME, "warehousing_time", "version", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "approval_record", "resource", "list_id", "status", "tian_quan_id"}, new Object[]{0L, "", 0L, 0L, "", 0L, 0L, 0L, "", null, null, 0L, 0, 0L}, giftMidgroundPanel$ItemInfo.class);
    public final PBInt64Field item_id = PBField.initInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt64Field level = PBField.initInt64(0);
    public final PBInt64Field price = PBField.initInt64(0);
    public final PBStringField creater = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field warehousing_time = PBField.initInt64(0);
    public final PBInt64Field version = PBField.initInt64(0);
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<giftMidgroundPanel$VersionInfo> approval_record = PBField.initRepeatMessage(giftMidgroundPanel$VersionInfo.class);
    public giftMidgroundPanel$MaterialResource resource = new giftMidgroundPanel$MaterialResource();
    public final PBInt64Field list_id = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field tian_quan_id = PBField.initInt64(0);
}
