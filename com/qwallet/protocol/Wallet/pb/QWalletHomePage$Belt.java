package com.qwallet.protocol.Wallet.pb;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$Belt extends MessageMicro<QWalletHomePage$Belt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 90, 98, 106}, new String[]{"id", "name", "url", "pv", "icon", "close_btn_type", "close_btn_title", "show_count", "type", "icon_red_point_type", "icon_red_point_url", DownloaderConstant.KEY_RANGE, "text"}, new Object[]{0, "", "", "", "", 0, "", 0, 0, 0, "", null, ""}, QWalletHomePage$Belt.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41688id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");

    /* renamed from: pv, reason: collision with root package name */
    public final PBStringField f41689pv = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field close_btn_type = PBField.initInt32(0);
    public final PBStringField close_btn_title = PBField.initString("");
    public final PBInt32Field show_count = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field icon_red_point_type = PBField.initInt32(0);
    public final PBStringField icon_red_point_url = PBField.initString("");
    public QWalletHomePage$DateRange range = new QWalletHomePage$DateRange();
    public final PBStringField text = PBField.initString("");
}
