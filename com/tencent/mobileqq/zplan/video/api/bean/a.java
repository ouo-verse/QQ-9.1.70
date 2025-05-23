package com.tencent.mobileqq.zplan.video.api.bean;

import android.net.Uri;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JG\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/a;", "", "", "baseurl", "", "roomType", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", QCircleScheme.AttrDetail.VIDEO_INFO, "cid", "", "isLand", "isPreload", "a", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/zplan/video/api/bean/e;Ljava/lang/String;ZZ)Ljava/lang/String;", "loadedUrl", "url", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f335855a = new a();

    a() {
    }

    public final String a(String baseurl, Integer roomType, VideoPlayInfo videoInfo, String cid, boolean isLand, boolean isPreload) {
        Intrinsics.checkNotNullParameter(baseurl, "baseurl");
        try {
            Uri.Builder buildUpon = Uri.parse(baseurl).buildUpon();
            if (videoInfo != null) {
                buildUpon.appendQueryParameter("tvId", videoInfo.getComponentId());
                buildUpon.appendQueryParameter("openId", videoInfo.getOpenId());
                buildUpon.appendQueryParameter("ownerOpenId", videoInfo.getHostOpenId());
            }
            if (roomType != null) {
                buildUpon.appendQueryParameter("roomType", String.valueOf(roomType.intValue()));
            }
            if (cid != null) {
                buildUpon.appendQueryParameter("cid", cid);
            }
            buildUpon.appendQueryParameter("clientWidth", String.valueOf(u.INSTANCE.c(BaseApplication.context)));
            buildUpon.appendQueryParameter(MiniChatConstants.MINI_APP_LANDSCAPE, String.valueOf(isLand));
            if (isPreload) {
                buildUpon.appendQueryParameter("preload", "true");
            }
            String uri = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "{\n            val build \u2026ld().toString()\n        }");
            return uri;
        } catch (Exception e16) {
            QLog.e("buildUrlHelper", 1, "buldMediaL url failed ", e16);
            return baseurl;
        }
    }

    public final boolean c(String loadedUrl, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (loadedUrl == null) {
            return true;
        }
        try {
            String deleteParameter = URLUtil.deleteParameter(loadedUrl, "preload");
            String deleteParameter2 = URLUtil.deleteParameter(url, "preload");
            QLog.d("buildUrlHelper", 1, "oldUrl: " + Intrinsics.areEqual(deleteParameter, deleteParameter2) + " ");
            return true ^ Intrinsics.areEqual(deleteParameter, deleteParameter2);
        } catch (Exception e16) {
            QLog.e("buildUrlHelper", 1, "shouldReload failed ", e16);
            return true;
        }
    }

    public static /* synthetic */ String b(a aVar, String str, Integer num, VideoPlayInfo videoPlayInfo, String str2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i3 & 32) != 0) {
            z17 = false;
        }
        return aVar.a(str, num2, videoPlayInfo, str2, z16, z17);
    }
}
