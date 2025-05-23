package com.qwallet.protocol.Wallet.pb;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$Market extends MessageMicro<QWalletHomePage$Market> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"id", "type", "icon", DownloaderConstant.KEY_RANGE, "action", "name"}, new Object[]{0, 0, "", null, 0, ""}, QWalletHomePage$Market.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41694id = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
    public QWalletHomePage$DateRange range = new QWalletHomePage$DateRange();
    public final PBInt32Field action = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
}
