package com.tencent.state.common.record.provider;

import com.tencent.state.common.record.RecordData;
import com.tencent.state.utils.TimeFormatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import qs4.c;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0005"}, d2 = {"Lqs4/c;", "", "text", "Lcom/tencent/state/common/record/RecordData;", "formatLibraryRecord", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class LibraryRecordDataProviderKt {
    public static final RecordData formatLibraryRecord(c formatLibraryRecord, String str) {
        Intrinsics.checkNotNullParameter(formatLibraryRecord, "$this$formatLibraryRecord");
        String valueOf = String.valueOf(formatLibraryRecord.f429477e);
        byte[] bArr = formatLibraryRecord.f429474b;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.nick");
        return new RecordData(valueOf, new String(bArr, Charsets.UTF_8), formatLibraryRecord.f429473a, TimeFormatUtils.INSTANCE.formatTimeToDate(formatLibraryRecord.f429475c * 1000), formatLibraryRecord.f429476d, str);
    }
}
