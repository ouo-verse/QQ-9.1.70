package addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes.dex */
public final class AccountSearchPb$Location extends MessageMicro<AccountSearchPb$Location> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField double_latitude = PBField.initDouble(0.0d);
    public final PBDoubleField double_longitude = PBField.initDouble(0.0d);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17}, new String[]{"double_latitude", "double_longitude"}, new Object[]{valueOf, valueOf}, AccountSearchPb$Location.class);
    }
}
