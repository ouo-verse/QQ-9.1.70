package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMallAIORecommend$ShopArk extends MessageMicro<GameMallAIORecommend$ShopArk> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"app", "view", "ver", "prompt", DownloadInfo.spKey_Config, PublicAccountMessageUtilImpl.META_NAME}, new Object[]{"", "", "", "", "", ""}, GameMallAIORecommend$ShopArk.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField view = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField config = PBField.initString("");
    public final PBStringField meta = PBField.initString("");
}
