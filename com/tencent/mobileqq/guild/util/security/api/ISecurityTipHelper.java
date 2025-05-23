package com.tencent.mobileqq.guild.util.security.api;

import android.content.Context;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&J6\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/util/security/api/ISecurityTipHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "showSecurityTip", "", "context", "Landroid/content/Context;", "errorCode", "", "errorMsg", "", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "defaultErrorMsg", "showSecurityTipByApi", "", "toastDefaultMsg", "userToastError", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ISecurityTipHelper extends QRouteApi {
    void showSecurityTip(@Nullable Context context, int errorCode, @Nullable String errorMsg, @Nullable IGProSecurityResult result, @Nullable String defaultErrorMsg);

    boolean showSecurityTipByApi(@Nullable IGProSecurityResult result, @Nullable Context context, int errorCode, @Nullable String toastDefaultMsg, boolean userToastError);
}
