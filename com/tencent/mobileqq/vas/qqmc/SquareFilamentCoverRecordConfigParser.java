package com.tencent.mobileqq.vas.qqmc;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.data.SwitchConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/SquareFilamentCoverRecordConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/vas/qqmc/a;", "b", "", "content", "c", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareFilamentCoverRecordConfigParser extends BaseConfigParser<SquareFilamentCoverRecordConfigData> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SquareFilamentCoverRecordConfigData defaultConfig() {
        SquareFilamentCoverRecordConfigData squareFilamentCoverRecordConfigData = new SquareFilamentCoverRecordConfigData(false, false, 3, null);
        QLog.i("SquareFilamentCoverRecordConfigParser", 1, "get default config:" + squareFilamentCoverRecordConfigData);
        return squareFilamentCoverRecordConfigData;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SquareFilamentCoverRecordConfigData parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        JSONObject B = CommonExKt.B(content);
        SquareFilamentCoverRecordConfigData squareFilamentCoverRecordConfigData = new SquareFilamentCoverRecordConfigData(B.optBoolean("enable_dresskey_trigger", false), B.optBoolean(SwitchConfig.Key.filamentCoverRecordGuestUpload, false));
        QLog.i("SquareFilamentCoverRecordConfigParser", 1, "parse config:" + squareFilamentCoverRecordConfigData);
        return squareFilamentCoverRecordConfigData;
    }
}
