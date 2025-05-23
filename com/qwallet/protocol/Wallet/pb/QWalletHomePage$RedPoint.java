package com.qwallet.protocol.Wallet.pb;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes3.dex */
public final class QWalletHomePage$RedPoint extends MessageMicro<QWalletHomePage$RedPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", DownloaderConstant.KEY_RANGE, "type"}, new Object[]{0, null, 0}, QWalletHomePage$RedPoint.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41696id = PBField.initInt32(0);
    public QWalletHomePage$DateRange range = new QWalletHomePage$DateRange();
    public final PBInt32Field type = PBField.initInt32(0);
}
