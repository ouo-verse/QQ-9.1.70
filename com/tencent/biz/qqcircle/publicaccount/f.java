package com.tencent.biz.qqcircle.publicaccount;

import com.tencent.biz.qqcircle.helpers.QCirclePublicAccountHelper;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountDetailPageLaunchInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002J3\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00040\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/publicaccount/f;", "", "", "url", "", "d", "", "b", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "e", "playUrl", "", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "a", "c", "g", "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f91680a = new f();

    f() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069 A[Catch: Exception -> 0x00a0, TryCatch #0 {Exception -> 0x00a0, blocks: (B:3:0x0013, B:5:0x0054, B:6:0x0058, B:8:0x005d, B:13:0x0069, B:16:0x006d), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d A[Catch: Exception -> 0x00a0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a0, blocks: (B:3:0x0013, B:5:0x0054, B:6:0x0058, B:8:0x005d, B:13:0x0069, B:16:0x006d), top: B:2:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo, @NotNull Function1<? super QCirclePublicAccountDetailPageLaunchInfo.VideoInfo, Unit> callback) {
        List list;
        boolean z16;
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Object invoke = QCirclePublicAccountHelper.class.getDeclaredMethod("exchangeUrl", String.class, String.class, Long.TYPE, Boolean.TYPE).invoke(QCirclePublicAccountHelper.class.newInstance(), videoInfo.getFileId(), videoInfo.getPlayUrl(), videoInfo.getDuration(), videoInfo.getIsQUIC());
            if (invoke instanceof List) {
                list = (List) invoke;
            } else {
                list = null;
            }
            List list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
                if (!z16) {
                    callback.invoke(null);
                    return;
                }
                Object obj = list.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = list.get(1);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(2);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Long");
                Object obj4 = list.get(3);
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                callback.invoke(new QCirclePublicAccountDetailPageLaunchInfo.VideoInfo((String) obj, (String) obj2, (Long) obj3, (Boolean) obj4));
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            QLog.e("QCirclePublicAccountLaunchHelper", 1, "exchangeUrl exception", e16);
            callback.invoke(null);
        }
    }

    public final int b(@NotNull String url) {
        Integer num;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Object invoke = QCirclePublicAccountHelper.class.getDeclaredMethod("getImageCacheStatusCode", String.class).invoke(QCirclePublicAccountHelper.class.newInstance(), url);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            } else {
                num = null;
            }
            if (num == null) {
                return -1;
            }
            return num.intValue();
        } catch (Exception e16) {
            QLog.e("QCirclePublicAccountLaunchHelper", 1, "getCoverCacheStatusCode exception", e16);
            return -1;
        }
    }

    public final boolean c(@NotNull QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        try {
            Object invoke = QCirclePublicAccountHelper.class.getDeclaredMethod("hasLocalCache", String.class, String.class).invoke(QCirclePublicAccountHelper.class.newInstance(), videoInfo.getPlayUrl(), videoInfo.getFileId());
            if (invoke instanceof Boolean) {
                bool = (Boolean) invoke;
            } else {
                bool = null;
            }
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Exception e16) {
            QLog.e("QCirclePublicAccountLaunchHelper", 1, "hasLocalCache exception", e16);
            return false;
        }
    }

    public final void d(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            QCirclePublicAccountHelper.class.getDeclaredMethod("loadImage", String.class).invoke(QCirclePublicAccountHelper.class.newInstance(), url);
        } catch (Exception e16) {
            QLog.e("QCirclePublicAccountLaunchHelper", 1, "loadCover exception", e16);
        }
    }

    public final void e(@NotNull QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        try {
            QCirclePublicAccountHelper.class.getDeclaredMethod("loadVideo", String.class, String.class, Long.TYPE, Boolean.TYPE).invoke(QCirclePublicAccountHelper.class.newInstance(), videoInfo.getFileId(), videoInfo.getPlayUrl(), videoInfo.getDuration(), videoInfo.getIsQUIC());
        } catch (Exception e16) {
            QLog.e(QCirclePublicAccountMessageServiceImpl.TAG, 1, "loadVideo exception", e16);
        }
    }

    public final boolean f(@NotNull String playUrl) {
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        try {
            Object invoke = QCirclePublicAccountHelper.class.getDeclaredMethod("needExchangeUrl", String.class).invoke(QCirclePublicAccountHelper.class.newInstance(), playUrl);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e16) {
            QLog.e("QCirclePublicAccountLaunchHelper", 1, "needExChangeUrl exception", e16);
            return false;
        }
    }

    public final void g(@NotNull QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        try {
            QCirclePublicAccountHelper.class.getDeclaredMethod("removeHistoryPreloadRecord", String.class, String.class).invoke(QCirclePublicAccountHelper.class.newInstance(), videoInfo.getPlayUrl(), videoInfo.getFileId());
        } catch (Exception e16) {
            QLog.e("QCirclePublicAccountLaunchHelper", 1, "cancelPreload exception", e16);
        }
    }
}
