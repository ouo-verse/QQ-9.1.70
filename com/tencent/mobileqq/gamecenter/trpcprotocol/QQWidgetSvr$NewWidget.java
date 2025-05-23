package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tenpay.sdk.util.UinConfigManager;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$NewWidget extends MessageMicro<QQWidgetSvr$NewWidget> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"promotion_id", "gifts", "cloud_game", UinConfigManager.KEY_ADS}, new Object[]{null, null, null, null}, QQWidgetSvr$NewWidget.class);
    public QQWidgetSvr$PromotionAd promotion_id = new QQWidgetSvr$PromotionAd();
    public QQWidgetSvr$Gift gifts = new QQWidgetSvr$Gift();
    public QQWidgetSvr$CloudGame cloud_game = new QQWidgetSvr$CloudGame();
    public QQWidgetSvr$MessageNotice notice = new QQWidgetSvr$MessageNotice();
}
