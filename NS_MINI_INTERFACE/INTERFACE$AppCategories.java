package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$AppCategories extends MessageMicro<INTERFACE$AppCategories> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND}, new Object[]{"", ""}, INTERFACE$AppCategories.class);
    public final PBStringField first = PBField.initString("");
    public final PBStringField second = PBField.initString("");
}
