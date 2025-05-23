package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$GradeDistributed extends MessageMicro<sgame_qgroup_datacard$GradeDistributed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"grade", QFSSearchBaseRequest.EXTRA_KEY_USER_COUNT}, new Object[]{0, 0L}, sgame_qgroup_datacard$GradeDistributed.class);
    public final PBEnumField grade = PBField.initEnum(0);
    public final PBInt64Field userCount = PBField.initInt64(0);
}
