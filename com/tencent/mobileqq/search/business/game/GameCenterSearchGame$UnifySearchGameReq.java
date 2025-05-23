package com.tencent.mobileqq.search.business.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class GameCenterSearchGame$UnifySearchGameReq extends MessageMicro<GameCenterSearchGame$UnifySearchGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"search_key"}, new Object[]{""}, GameCenterSearchGame$UnifySearchGameReq.class);
    public final PBStringField search_key = PBField.initString("");
}
