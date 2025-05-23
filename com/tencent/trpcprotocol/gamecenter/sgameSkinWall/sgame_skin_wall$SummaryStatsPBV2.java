package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes11.dex */
public final class sgame_skin_wall$SummaryStatsPBV2 extends MessageMicro<sgame_skin_wall$SummaryStatsPBV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CustomImageProps.QUALITY, "stat"}, new Object[]{0, null}, sgame_skin_wall$SummaryStatsPBV2.class);
    public final PBInt32Field quality = PBField.initInt32(0);
    public sgame_skin_wall$SkinQualityStat stat = new MessageMicro<sgame_skin_wall$SkinQualityStat>() { // from class: com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$SkinQualityStat
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"owned", "total"}, new Object[]{0, 0}, sgame_skin_wall$SkinQualityStat.class);
        public final PBInt32Field owned = PBField.initInt32(0);
        public final PBInt32Field total = PBField.initInt32(0);
    };
}
