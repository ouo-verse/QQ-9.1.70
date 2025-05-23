package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.state.mmkv.SKey;

/* loaded from: classes3.dex */
public final class QWalletHomePage$VirtualEntity extends MessageMicro<QWalletHomePage$VirtualEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"id", "type", "market", SKey.DetailMe.KEY_TITLE_RED_POINT_SP}, new Object[]{0, 0, null, null}, QWalletHomePage$VirtualEntity.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41700id = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public QWalletHomePage$Market market = new QWalletHomePage$Market();
    public QWalletHomePage$RedPoint red_point = new QWalletHomePage$RedPoint();
}
