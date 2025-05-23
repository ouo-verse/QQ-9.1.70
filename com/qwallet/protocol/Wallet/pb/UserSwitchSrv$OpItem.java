package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class UserSwitchSrv$OpItem extends MessageMicro<UserSwitchSrv$OpItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sw", "op"}, new Object[]{0, 0}, UserSwitchSrv$OpItem.class);

    /* renamed from: sw, reason: collision with root package name */
    public final PBEnumField f41702sw = PBField.initEnum(0);

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f41701op = PBField.initEnum(0);
}
