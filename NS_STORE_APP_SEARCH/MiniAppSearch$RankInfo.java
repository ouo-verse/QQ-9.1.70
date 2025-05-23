package NS_STORE_APP_SEARCH;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StoreAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$RankInfo extends MessageMicro<MiniAppSearch$RankInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"rank_type", "category", "name", "jump_url", "apps"}, new Object[]{"", "", "", "", null}, MiniAppSearch$RankInfo.class);
    public final PBStringField rank_type = PBField.initString("");
    public final PBStringField category = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBRepeatMessageField<STORE_APP_CLIENT$StoreAppInfo> apps = PBField.initRepeatMessage(STORE_APP_CLIENT$StoreAppInfo.class);
}
