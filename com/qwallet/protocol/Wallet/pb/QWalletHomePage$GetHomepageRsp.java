package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetHomepageRsp extends MessageMicro<QWalletHomePage$GetHomepageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 58, 66, 74, 82}, new String[]{"top_apps", "apps", "belts", "assets", "declaim", "h5", "virtual_entities", "control", "operation_apps"}, new Object[]{null, null, null, null, null, null, null, null, null}, QWalletHomePage$GetHomepageRsp.class);
    public final PBRepeatMessageField<QWalletHomePage$AppInfo> top_apps = PBField.initRepeatMessage(QWalletHomePage$AppInfo.class);
    public final PBRepeatMessageField<QWalletHomePage$AppInfo> apps = PBField.initRepeatMessage(QWalletHomePage$AppInfo.class);
    public final PBRepeatMessageField<QWalletHomePage$Belt> belts = PBField.initRepeatMessage(QWalletHomePage$Belt.class);
    public final PBRepeatMessageField<QWalletHomePage$VirtualAsset> assets = PBField.initRepeatMessage(QWalletHomePage$VirtualAsset.class);
    public QWalletHomePage$Declaim declaim = new QWalletHomePage$Declaim();

    /* renamed from: h5, reason: collision with root package name */
    public QWalletHomePage$H5 f41692h5 = new QWalletHomePage$H5();
    public final PBRepeatMessageField<QWalletHomePage$VirtualEntity> virtual_entities = PBField.initRepeatMessage(QWalletHomePage$VirtualEntity.class);
    public QWalletHomePage$Control control = new MessageMicro<QWalletHomePage$Control>() { // from class: com.qwallet.protocol.Wallet.pb.QWalletHomePage$Control
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"has_top_app_sep"}, new Object[]{Boolean.FALSE}, QWalletHomePage$Control.class);
        public final PBBoolField has_top_app_sep = PBField.initBool(false);
    };
    public final PBRepeatMessageField<QWalletHomePage$AppInfo> operation_apps = PBField.initRepeatMessage(QWalletHomePage$AppInfo.class);
}
