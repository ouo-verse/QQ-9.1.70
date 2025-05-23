package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/IThemeFontAdapter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "switchFont", "", MessageForRichState.SIGN_MSG_FONT_ID, "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IThemeFontAdapter extends QRouteApi {
    void switchFont(int fontId);
}
