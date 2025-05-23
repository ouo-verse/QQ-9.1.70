package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import android.os.Bundle;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.xweb.FileReaderHelper;
import eipc.EIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000e\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "CheckIsInMyAppList", "DeleteDesktopMiniApp", "GetMiniAppDesktopLocalData", "GetMiniAppDesktopNetworkData", "InsertMyMiniApp", "InsertMyMiniAppToTopById", "MyMiniAppDraggingTempSwitchPosition", "MyMiniAppSwitchPosition", "NONE", "QueryMyMiniAppInfo", "RecentAppInsertMyAppDraggingTempSwitchPosition", "RegisterMiniAppRedDotObserverEvent", "RemoveMyMiniAppTopById", "UpdateMiniAppDesktopInfo", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$CheckIsInMyAppList;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$DeleteDesktopMiniApp;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$GetMiniAppDesktopLocalData;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$GetMiniAppDesktopNetworkData;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$InsertMyMiniApp;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$InsertMyMiniAppToTopById;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$MyMiniAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$MyMiniAppSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$NONE;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$QueryMyMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RecentAppInsertMyAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RegisterMiniAppRedDotObserverEvent;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RemoveMyMiniAppTopById;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$UpdateMiniAppDesktopInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class MiniAppDeskTopIntent implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$CheckIsInMyAppList;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "params", "Landroid/os/Bundle;", "eipcModule", "Leipc/EIPCModule;", "(Landroid/os/Bundle;Leipc/EIPCModule;)V", "getEipcModule", "()Leipc/EIPCModule;", "getParams", "()Landroid/os/Bundle;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class CheckIsInMyAppList extends MiniAppDeskTopIntent {
        private final EIPCModule eipcModule;
        private final Bundle params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckIsInMyAppList(Bundle params, EIPCModule eipcModule) {
            super(null);
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(eipcModule, "eipcModule");
            this.params = params;
            this.eipcModule = eipcModule;
        }

        public final EIPCModule getEipcModule() {
            return this.eipcModule;
        }

        public final Bundle getParams() {
            return this.params;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$DeleteDesktopMiniApp;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "moduleType", "", "(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;I)V", "getDesktopAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getModuleType", "()I", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class DeleteDesktopMiniApp extends MiniAppDeskTopIntent {
        private final DesktopAppInfo desktopAppInfo;
        private final int moduleType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteDesktopMiniApp(DesktopAppInfo desktopAppInfo, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
            this.desktopAppInfo = desktopAppInfo;
            this.moduleType = i3;
        }

        public final DesktopAppInfo getDesktopAppInfo() {
            return this.desktopAppInfo;
        }

        public final int getModuleType() {
            return this.moduleType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$GetMiniAppDesktopLocalData;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class GetMiniAppDesktopLocalData extends MiniAppDeskTopIntent {
        public static final GetMiniAppDesktopLocalData INSTANCE = new GetMiniAppDesktopLocalData();

        GetMiniAppDesktopLocalData() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$GetMiniAppDesktopNetworkData;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "(ZLcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;)V", "getForce", "()Z", "getScene", "()Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class GetMiniAppDesktopNetworkData extends MiniAppDeskTopIntent {
        private final boolean force;
        private final GetAppListV2Scene scene;

        public /* synthetic */ GetMiniAppDesktopNetworkData(boolean z16, GetAppListV2Scene getAppListV2Scene, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? GetAppListV2Scene.DROP_DOWN : getAppListV2Scene);
        }

        public final boolean getForce() {
            return this.force;
        }

        public final GetAppListV2Scene getScene() {
            return this.scene;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetMiniAppDesktopNetworkData(boolean z16, GetAppListV2Scene scene) {
            super(null);
            Intrinsics.checkNotNullParameter(scene, "scene");
            this.force = z16;
            this.scene = scene;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$InsertMyMiniApp;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "position", "", "(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;I)V", "getDesktopAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getPosition", "()I", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class InsertMyMiniApp extends MiniAppDeskTopIntent {
        private final DesktopAppInfo desktopAppInfo;
        private final int position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertMyMiniApp(DesktopAppInfo desktopAppInfo, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
            this.desktopAppInfo = desktopAppInfo;
            this.position = i3;
        }

        public final DesktopAppInfo getDesktopAppInfo() {
            return this.desktopAppInfo;
        }

        public final int getPosition() {
            return this.position;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$InsertMyMiniAppToTopById;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "miniAppId", "", "callbackId", "", "eipcModule", "Leipc/EIPCModule;", "(Ljava/lang/String;ILeipc/EIPCModule;)V", "getCallbackId", "()I", "getEipcModule", "()Leipc/EIPCModule;", "getMiniAppId", "()Ljava/lang/String;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class InsertMyMiniAppToTopById extends MiniAppDeskTopIntent {
        private final int callbackId;
        private final EIPCModule eipcModule;
        private final String miniAppId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertMyMiniAppToTopById(String miniAppId, int i3, EIPCModule eipcModule) {
            super(null);
            Intrinsics.checkNotNullParameter(miniAppId, "miniAppId");
            Intrinsics.checkNotNullParameter(eipcModule, "eipcModule");
            this.miniAppId = miniAppId;
            this.callbackId = i3;
            this.eipcModule = eipcModule;
        }

        public final int getCallbackId() {
            return this.callbackId;
        }

        public final EIPCModule getEipcModule() {
            return this.eipcModule;
        }

        public final String getMiniAppId() {
            return this.miniAppId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$MyMiniAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "fromPosition", "", "toPosition", "(II)V", "getFromPosition", "()I", "getToPosition", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MyMiniAppDraggingTempSwitchPosition extends MiniAppDeskTopIntent {
        private final int fromPosition;
        private final int toPosition;

        public final int getFromPosition() {
            return this.fromPosition;
        }

        public final int getToPosition() {
            return this.toPosition;
        }

        public MyMiniAppDraggingTempSwitchPosition(int i3, int i16) {
            super(null);
            this.fromPosition = i3;
            this.toPosition = i16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$MyMiniAppSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "oldIndex", "", "newIndex", "(II)V", "getNewIndex", "()I", "getOldIndex", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MyMiniAppSwitchPosition extends MiniAppDeskTopIntent {
        private final int newIndex;
        private final int oldIndex;

        public final int getNewIndex() {
            return this.newIndex;
        }

        public final int getOldIndex() {
            return this.oldIndex;
        }

        public MyMiniAppSwitchPosition(int i3, int i16) {
            super(null);
            this.oldIndex = i3;
            this.newIndex = i16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$NONE;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class NONE extends MiniAppDeskTopIntent {
        public static final NONE INSTANCE = new NONE();

        NONE() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$QueryMyMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "params", "Landroid/os/Bundle;", "eipcModule", "Leipc/EIPCModule;", "(Landroid/os/Bundle;Leipc/EIPCModule;)V", "getEipcModule", "()Leipc/EIPCModule;", "getParams", "()Landroid/os/Bundle;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class QueryMyMiniAppInfo extends MiniAppDeskTopIntent {
        private final EIPCModule eipcModule;
        private final Bundle params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QueryMyMiniAppInfo(Bundle params, EIPCModule eipcModule) {
            super(null);
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(eipcModule, "eipcModule");
            this.params = params;
            this.eipcModule = eipcModule;
        }

        public final EIPCModule getEipcModule() {
            return this.eipcModule;
        }

        public final Bundle getParams() {
            return this.params;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RecentAppInsertMyAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "position", "", "(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;I)V", "getDesktopAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getPosition", "()I", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class RecentAppInsertMyAppDraggingTempSwitchPosition extends MiniAppDeskTopIntent {
        private final DesktopAppInfo desktopAppInfo;
        private final int position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentAppInsertMyAppDraggingTempSwitchPosition(DesktopAppInfo desktopAppInfo, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
            this.desktopAppInfo = desktopAppInfo;
            this.position = i3;
        }

        public final DesktopAppInfo getDesktopAppInfo() {
            return this.desktopAppInfo;
        }

        public final int getPosition() {
            return this.position;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RegisterMiniAppRedDotObserverEvent;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class RegisterMiniAppRedDotObserverEvent extends MiniAppDeskTopIntent {
        public static final RegisterMiniAppRedDotObserverEvent INSTANCE = new RegisterMiniAppRedDotObserverEvent();

        RegisterMiniAppRedDotObserverEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$RemoveMyMiniAppTopById;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "miniAppId", "", "callbackId", "", "eipcModule", "Leipc/EIPCModule;", "(Ljava/lang/String;ILeipc/EIPCModule;)V", "getCallbackId", "()I", "getEipcModule", "()Leipc/EIPCModule;", "getMiniAppId", "()Ljava/lang/String;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class RemoveMyMiniAppTopById extends MiniAppDeskTopIntent {
        private final int callbackId;
        private final EIPCModule eipcModule;
        private final String miniAppId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveMyMiniAppTopById(String miniAppId, int i3, EIPCModule eipcModule) {
            super(null);
            Intrinsics.checkNotNullParameter(miniAppId, "miniAppId");
            Intrinsics.checkNotNullParameter(eipcModule, "eipcModule");
            this.miniAppId = miniAppId;
            this.callbackId = i3;
            this.eipcModule = eipcModule;
        }

        public final int getCallbackId() {
            return this.callbackId;
        }

        public final EIPCModule getEipcModule() {
            return this.eipcModule;
        }

        public final String getMiniAppId() {
            return this.miniAppId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent$UpdateMiniAppDesktopInfo;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopIntent;", "miniAppType", "", "(I)V", "getMiniAppType", "()I", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateMiniAppDesktopInfo extends MiniAppDeskTopIntent {
        private final int miniAppType;

        public final int getMiniAppType() {
            return this.miniAppType;
        }

        public UpdateMiniAppDesktopInfo(int i3) {
            super(null);
            this.miniAppType = i3;
        }
    }

    public /* synthetic */ MiniAppDeskTopIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    MiniAppDeskTopIntent() {
    }
}
