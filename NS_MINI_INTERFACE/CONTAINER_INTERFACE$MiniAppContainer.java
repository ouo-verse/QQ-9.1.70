package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$MiniAppContainer extends MessageMicro<CONTAINER_INTERFACE$MiniAppContainer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"main_pkg_info", "sub_pkgs", "app_json"}, new Object[]{null, null, ""}, CONTAINER_INTERFACE$MiniAppContainer.class);
    public CONTAINER_INTERFACE$MainPkgInfo main_pkg_info = new CONTAINER_INTERFACE$MainPkgInfo();
    public final PBRepeatMessageField<CONTAINER_INTERFACE$SubPkgInfo> sub_pkgs = PBField.initRepeatMessage(CONTAINER_INTERFACE$SubPkgInfo.class);
    public final PBStringField app_json = PBField.initString("");
}
