package com.tencent.mobileqq.qwallet.pb;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;

/* loaded from: classes16.dex */
public final class RedPackSkin$RecommendSkin extends MessageMicro<RedPackSkin$RecommendSkin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 96, 106, 114, 120}, new String[]{SkinResFactory.SKIN_THEME_APK_SAVE_DIR, NotificationCompat.CATEGORY_RECOMMENDATION, "img", "labels", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "btn_text", "btn_url", "has_got", "total_count", "got_count", "token", "receive_way", "public_account_uin", "tip", "recommend_id"}, new Object[]{null, "", "", "", null, "", "", Boolean.FALSE, 0, 0, "", 0, "", "", 0}, RedPackSkin$RecommendSkin.class);
    public RedPackSkin$SkinInfo skin = new RedPackSkin$SkinInfo();
    public final PBStringField recommendation = PBField.initString("");
    public final PBStringField img = PBField.initString("");
    public final PBRepeatField<String> labels = PBField.initRepeat(PBStringField.__repeatHelper__);
    public RedPackSkin$RecommendActivity activity = new RedPackSkin$RecommendActivity();
    public final PBStringField btn_text = PBField.initString("");
    public final PBStringField btn_url = PBField.initString("");
    public final PBBoolField has_got = PBField.initBool(false);
    public final PBInt32Field total_count = PBField.initInt32(0);
    public final PBInt32Field got_count = PBField.initInt32(0);
    public final PBStringField token = PBField.initString("");
    public final PBInt32Field receive_way = PBField.initInt32(0);
    public final PBStringField public_account_uin = PBField.initString("");
    public final PBStringField tip = PBField.initString("");
    public final PBInt32Field recommend_id = PBField.initInt32(0);
}
