package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$RefInfo extends MessageMicro<GameStrategyQA$RefInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"type", "qa", WadlProxyConsts.CHANNEL, "xworld", "has_media"}, new Object[]{0, null, null, null, Boolean.FALSE}, GameStrategyQA$RefInfo.class);
    public final PBEnumField type = PBField.initEnum(0);

    /* renamed from: qa, reason: collision with root package name */
    public GameStrategyQA$RefQAInfo f212676qa = new GameStrategyQA$RefQAInfo();
    public GameStrategyQA$RefChannelInfo channel = new GameStrategyQA$RefChannelInfo();
    public GameStrategyQA$RefXWorldInfo xworld = new GameStrategyQA$RefXWorldInfo();
    public final PBBoolField has_media = PBField.initBool(false);
}
