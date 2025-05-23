package com.tencent.mobileqq.qqecommerce.biz.router.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qqecommerce.biz.router.api.IECommerceJumpAction;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJD\u0010\t\u001a\u00020\b2&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002JN\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00032&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/router/api/impl/ECommerceJumpActionImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/router/api/IECommerceJumpAction;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "jumActionFrom", "jumpActionSource", "", "gotoFromSourceTarget", "actionName", "handleScheme", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECommerceJumpActionImpl implements IECommerceJumpAction {
    public static final String TAG = "RIJJumpActionImpl";

    private final boolean gotoFromSourceTarget(HashMap<String, String> attrs, String jumActionFrom, String jumpActionSource) {
        if (attrs == null) {
            QLog.e(TAG, 1, "[gotoFromSourceTarget] attrs is null.");
            return false;
        }
        if (attrs.get("target") == null) {
            return false;
        }
        QLog.d(TAG, 1, "[gotoFromSourceTarget] jumpActionSource = " + jumpActionSource + " .");
        if (jumpActionSource != null) {
            if (jumpActionSource.length() > 0) {
                ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(jumpActionSource, null);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.router.api.IECommerceJumpAction
    public boolean handleScheme(String actionName, HashMap<String, String> attrs, String jumActionFrom, String jumpActionSource) {
        if (Intrinsics.areEqual("open", actionName)) {
            return gotoFromSourceTarget(attrs, jumActionFrom, jumpActionSource);
        }
        return false;
    }
}
