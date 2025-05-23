package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanSmallHomeEventImpl;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u0012\u001a\u00020\u0007H&J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H&J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002H&J&\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0007H&J\b\u0010!\u001a\u00020\u0007H&J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0007H&J\b\u0010$\u001a\u00020\u0007H&\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/f;", "", "", "getCurrentMapId", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "", "inStablePos", "source", "", "notifyShowFloatWindow", "destroyFloatLogic", "notifyHideFloatWindow", ViewStickEventHelper.IS_SHOW, "setIsFloat", "isFloat", "setIsShowUE", "isShowUE", "progress", "tips1", "tips2", "mapSetLoadingProgress", "version1", "version2", "version3", "mapSetGameVer", "mapCloseLoadingView", "Lpk3/c;", "callback", "h5ShowMapFloatWindow", "isStarting", "setUEActivityStarting", "isUEActivityStarting", "isInAvatar", "setIsInAvatarScene", "isInAvatarScene", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanSmallHomeEventImpl.class)
/* loaded from: classes35.dex */
public interface f {
    int getCurrentMapId();

    void h5ShowMapFloatWindow(String mapId, String scheme, pk3.c callback);

    boolean isFloat();

    boolean isInAvatarScene();

    boolean isShowUE();

    boolean isUEActivityStarting();

    void mapCloseLoadingView(int mapId);

    void mapSetGameVer(int mapId, String version1, String version2, String version3);

    void mapSetLoadingProgress(int mapId, int progress, String tips1, String tips2);

    void notifyHideFloatWindow(int mapId, boolean destroyFloatLogic);

    void notifyShowFloatWindow(int mapId, String scheme, boolean inStablePos, int source);

    void setIsFloat(boolean isShow);

    void setIsInAvatarScene(boolean isInAvatar);

    void setIsShowUE(boolean isShow);

    void setUEActivityStarting(boolean isStarting);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static /* synthetic */ void a(f fVar, int i3, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    z16 = false;
                }
                fVar.notifyHideFloatWindow(i3, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyHideFloatWindow");
        }
    }
}
