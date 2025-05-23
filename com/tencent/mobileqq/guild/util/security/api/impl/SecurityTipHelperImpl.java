package com.tencent.mobileqq.guild.util.security.api.impl;

import android.content.Context;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.util.security.api.ISecurityTipHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J6\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/util/security/api/impl/SecurityTipHelperImpl;", "Lcom/tencent/mobileqq/guild/util/security/api/ISecurityTipHelper;", "()V", "showSecurityTip", "", "context", "Landroid/content/Context;", "errorCode", "", "errorMsg", "", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "defaultErrorMsg", "showSecurityTipByApi", "", "toastDefaultMsg", "userToastError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SecurityTipHelperImpl implements ISecurityTipHelper {
    @Override // com.tencent.mobileqq.guild.util.security.api.ISecurityTipHelper
    public void showSecurityTip(@Nullable Context context, int errorCode, @Nullable String errorMsg, @Nullable IGProSecurityResult result, @Nullable String defaultErrorMsg) {
        SecurityTipHelperKt.F(context, errorCode, errorMsg, result, defaultErrorMsg, null, 32, null);
    }

    @Override // com.tencent.mobileqq.guild.util.security.api.ISecurityTipHelper
    public boolean showSecurityTipByApi(@Nullable IGProSecurityResult result, @Nullable Context context, int errorCode, @Nullable String toastDefaultMsg, boolean userToastError) {
        return SecurityTipHelperKt.N(result, context, errorCode, toastDefaultMsg, userToastError, null, 32, null);
    }
}
