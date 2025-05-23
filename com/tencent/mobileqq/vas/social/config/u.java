package com.tencent.mobileqq.vas.social.config;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.state.square.IShareUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014JS\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/u;", "Lcom/tencent/state/square/IShareUtils;", "", "uin", "contentPath", "", "contentType", "", "contentList", "operationList", "source", "", "doShare", "(Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Integer;[Ljava/lang/Integer;Ljava/lang/Integer;)V", "shareLink", "imageSize", "imageMargin", "Landroid/graphics/Bitmap;", "getQrCode", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class u implements IShareUtils {
    @Override // com.tencent.state.square.IShareUtils
    public void doShare(String uin, String contentPath, int contentType, Integer[] contentList, Integer[] operationList, Integer source) {
        Intrinsics.checkNotNullParameter(contentPath, "contentPath");
        int i3 = 3;
        Integer[] numArr = contentList == null ? new Integer[]{0, 1, 4, 2, 3} : contentList;
        Integer[] numArr2 = operationList == null ? new Integer[]{1} : operationList;
        if (source != null && source.intValue() == 0) {
            i3 = 7;
        }
        int i16 = i3;
        IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.context;
        }
        Context context = topActivity;
        Intrinsics.checkNotNullExpressionValue(context, "Foreground.getTopActivit\u2026seApplicationImpl.context");
        iZPlanShareApi.launchForShareMedia(context, new ZPlanShareLaunchParam(i16, uin, contentType, contentPath, null, null, null, numArr, null, numArr2, false, null, 3440, null));
    }

    @Override // com.tencent.state.square.IShareUtils
    public Bitmap getQrCode(String shareLink, int imageSize, int imageMargin) {
        ContextWrapper topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.context;
        }
        if (shareLink == null || shareLink.length() == 0) {
            return null;
        }
        return com.tencent.mobileqq.troopshare.e.C(shareLink, topActivity.getResources(), imageSize, imageMargin, false);
    }
}
