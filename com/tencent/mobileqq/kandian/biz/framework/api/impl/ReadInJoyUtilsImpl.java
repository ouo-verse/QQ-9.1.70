package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import p62.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J#\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils;", "()V", "getAccount", "", "getAppRuntime", "Lmqq/app/AppRuntime;", "getEncryptUin", "getLongAccountUin", "", "handConversationToHide", "", "handConversationToShow", "isWeiShiAccount", "", "uin", "jumpTo", "", "context", "Landroid/content/Context;", ZPlanPublishSource.FROM_SCHEME, WadlProxyConsts.EXTRA_DATA, "Landroid/os/Bundle;", "jumpToUrl", "url", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReadInJoyUtilsImpl implements IReadInJoyUtils {
    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public String getAccount() {
        String a16 = b.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getAccount()");
        return a16;
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public AppRuntime getAppRuntime() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getAppRuntime()");
        return c16;
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public String getEncryptUin() {
        return com.tencent.mobileqq.kandian.biz.common.b.c();
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public long getLongAccountUin() {
        return b.d();
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public void handConversationToHide() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        RIJAppSetting.a((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public void handConversationToShow() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        RIJAppSetting.b((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public boolean isWeiShiAccount(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return TextUtils.equals(AppConstants.WEISHI_UIN, uin);
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public int jumpTo(Context context, String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Integer b16 = a.b(context, scheme, null);
        Intrinsics.checkNotNullExpressionValue(b16, "jumpTo(context, scheme, null)");
        return b16.intValue();
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public Integer jumpToUrl(Context context, String url) {
        return com.tencent.mobileqq.kandian.biz.common.b.d(context, url);
    }

    @Override // com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils
    public int jumpTo(Context context, String scheme, Bundle extraData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Integer b16 = a.b(context, scheme, extraData);
        Intrinsics.checkNotNullExpressionValue(b16, "jumpTo(context, scheme, extraData)");
        return b16.intValue();
    }
}
