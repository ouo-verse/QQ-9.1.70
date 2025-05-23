package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J0\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasColorNoteApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "displayColorNote", "", "isDisplay", "", "isColorNoteExist", "type", "", "removeColorNote", "showColorNote", "title", "", QQWinkConstants.TAB_SUBTITLE, "picUrl", "openUrl", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasColorNoteApi extends QRouteApi {
    void displayColorNote(boolean isDisplay);

    boolean isColorNoteExist(int type);

    void removeColorNote(int type);

    void showColorNote(@NotNull String title, @NotNull String subTitle, @NotNull String picUrl, int type, @NotNull String openUrl);
}
