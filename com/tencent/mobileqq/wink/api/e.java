package com.tencent.mobileqq.wink.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QZoneAutoTexting$TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/api/e;", "", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "textInfo", "", "a", "", "isSuccess", "", "retCode", "", "errorMsg", "b", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface e {
    void a(@NotNull List<QZoneAutoTexting$TextInfo> textInfo);

    void b(boolean isSuccess, long retCode, @Nullable String errorMsg, @NotNull List<QZoneAutoTexting$TextInfo> textInfo);
}
