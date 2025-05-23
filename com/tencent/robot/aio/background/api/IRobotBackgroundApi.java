package com.tencent.robot.aio.background.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/background/api/IRobotBackgroundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkImmersiveAIO", "", "uin", "", "chatType", "", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "getDefaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "preloadRobotBackground", "", "robotProfile", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "decodeFile", "robotUin", "preloadRobotBackgroundUrl", "backgroundUrl", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotBackgroundApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(IRobotBackgroundApi iRobotBackgroundApi, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                iRobotBackgroundApi.preloadRobotBackground(str, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadRobotBackground");
        }

        public static /* synthetic */ void b(IRobotBackgroundApi iRobotBackgroundApi, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                iRobotBackgroundApi.preloadRobotBackgroundUrl(str, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadRobotBackgroundUrl");
        }
    }

    boolean checkImmersiveAIO(@Nullable String uin, @Nullable Integer chatType);

    @NotNull
    Drawable getDefaultBackgroundDrawable();

    void preloadRobotBackground(@Nullable GroupRobotProfile robotProfile, boolean decodeFile);

    void preloadRobotBackground(@Nullable String robotUin, boolean decodeFile);

    void preloadRobotBackgroundUrl(@Nullable String backgroundUrl, boolean decodeFile);
}
