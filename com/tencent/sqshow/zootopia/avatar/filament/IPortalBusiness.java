package com.tencent.sqshow.zootopia.avatar.filament;

import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\rH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0015H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001c\u001a\u00020\u001bH&J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000bH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "listener", "", "setRenderListener", "Lqu4/a;", ac.f283467k0, "updateAvatarCharacter", "getAvatarCharacter", "", "event", "Luk0/e;", "addListener", "removeListener", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "cameraKey", "updateInitCameraId", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "getViewer", "", "getPortalNeedFullReloadAfterFirstFrame", "needReload", "setPortalNeedFullReloadAfterFirstFrame", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "getPortalAnimHelper", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "getPortalUrlTemplate", "camera", "setCamera", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface IPortalBusiness extends i, IBusinessScene {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static void a(IPortalBusiness iPortalBusiness, String camera2) {
            Intrinsics.checkNotNullParameter(camera2, "camera");
        }
    }

    void addListener(String event, uk0.e listener);

    qu4.a getAvatarCharacter();

    PortalAnimHelper getPortalAnimHelper();

    boolean getPortalNeedFullReloadAfterFirstFrame();

    FilamentUrlTemplate getPortalUrlTemplate();

    FilamentViewerV2 getViewer();

    void removeListener(String event, uk0.e listener);

    @Override // com.tencent.sqshow.zootopia.avatar.filament.i
    /* synthetic */ void runOnViewerThread(String str, Function0<Unit> function0);

    void setCamera(String camera2);

    void setPortalNeedFullReloadAfterFirstFrame(boolean needReload);

    void setRenderListener(h listener);

    void updateAvatarCharacter(qu4.a ac5);

    void updateInitCameraId(CameraKey cameraKey);
}
