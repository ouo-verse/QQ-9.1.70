package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetHomepageV2Rsp extends MessageMicro<QWalletHomePage$GetHomepageV2Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"pay_code_app", "top_apps", "assets", "finance_app_group", "life_app_group", "belts", "declaim", "h5", "virtual_entities", "red_dots", "app_list"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null}, QWalletHomePage$GetHomepageV2Rsp.class);
    public QWalletHomePage$AppInfo pay_code_app = new QWalletHomePage$AppInfo();
    public final PBRepeatMessageField<QWalletHomePage$AppInfo> top_apps = PBField.initRepeatMessage(QWalletHomePage$AppInfo.class);
    public final PBRepeatMessageField<QWalletHomePage$VirtualAsset> assets = PBField.initRepeatMessage(QWalletHomePage$VirtualAsset.class);
    public QWalletHomePage$AppGroup finance_app_group = new QWalletHomePage$AppGroup();
    public QWalletHomePage$AppGroup life_app_group = new QWalletHomePage$AppGroup();
    public final PBRepeatMessageField<QWalletHomePage$Belt> belts = PBField.initRepeatMessage(QWalletHomePage$Belt.class);
    public QWalletHomePage$Declaim declaim = new QWalletHomePage$Declaim();

    /* renamed from: h5, reason: collision with root package name */
    public QWalletHomePage$H5 f41693h5 = new QWalletHomePage$H5();
    public final PBRepeatMessageField<QWalletHomePage$VirtualEntity> virtual_entities = PBField.initRepeatMessage(QWalletHomePage$VirtualEntity.class);
    public final PBRepeatMessageField<QWalletHomePage$RedDot> red_dots = PBField.initRepeatMessage(QWalletHomePage$RedDot.class);
    public final PBRepeatMessageField<QWalletHomePage$AppGroup> app_list = PBField.initRepeatMessage(QWalletHomePage$AppGroup.class);
}
