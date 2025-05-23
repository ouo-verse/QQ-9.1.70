package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import android.os.Bundle;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "CloseMiniAppSubPage", "MiniAppDesktopClose", "MyMiniAppDraggingTempSwitchPosition", "OnAccountChanged", "OnChangeRedDotSwitch", "OnPostThemeChanged", "StudyModeChange", "UpdateDesktopMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$CloseMiniAppSubPage;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$MiniAppDesktopClose;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$MyMiniAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnChangeRedDotSwitch;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$StudyModeChange;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$UpdateDesktopMiniAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class MiniAppDeskTopUIState implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$CloseMiniAppSubPage;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class CloseMiniAppSubPage extends MiniAppDeskTopUIState {
        public static final CloseMiniAppSubPage INSTANCE = new CloseMiniAppSubPage();

        CloseMiniAppSubPage() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$MiniAppDesktopClose;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MiniAppDesktopClose extends MiniAppDeskTopUIState {
        public static final MiniAppDesktopClose INSTANCE = new MiniAppDesktopClose();

        MiniAppDesktopClose() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$MyMiniAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "deepCopyMyMiniAppInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "(Ljava/util/List;)V", "getDeepCopyMyMiniAppInfo", "()Ljava/util/List;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MyMiniAppDraggingTempSwitchPosition extends MiniAppDeskTopUIState {
        private final List<DesktopItemInfo> deepCopyMyMiniAppInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyMiniAppDraggingTempSwitchPosition(List<DesktopItemInfo> deepCopyMyMiniAppInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(deepCopyMyMiniAppInfo, "deepCopyMyMiniAppInfo");
            this.deepCopyMyMiniAppInfo = deepCopyMyMiniAppInfo;
        }

        public final List<DesktopItemInfo> getDeepCopyMyMiniAppInfo() {
            return this.deepCopyMyMiniAppInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class OnAccountChanged extends MiniAppDeskTopUIState {
        public static final OnAccountChanged INSTANCE = new OnAccountChanged();

        OnAccountChanged() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnChangeRedDotSwitch;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class OnChangeRedDotSwitch extends MiniAppDeskTopUIState {
        private final Bundle bundle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnChangeRedDotSwitch(Bundle bundle) {
            super(null);
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.bundle = bundle;
        }

        public final Bundle getBundle() {
            return this.bundle;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class OnPostThemeChanged extends MiniAppDeskTopUIState {
        public static final OnPostThemeChanged INSTANCE = new OnPostThemeChanged();

        OnPostThemeChanged() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$StudyModeChange;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "isStudyMode", "", "(Z)V", "()Z", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class StudyModeChange extends MiniAppDeskTopUIState {
        private final boolean isStudyMode;

        /* renamed from: isStudyMode, reason: from getter */
        public final boolean getIsStudyMode() {
            return this.isStudyMode;
        }

        public StudyModeChange(boolean z16) {
            super(null);
            this.isStudyMode = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012.\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\tR9\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$UpdateDesktopMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "desktopData", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "miniAppType", "(Ljava/util/HashMap;I)V", "getDesktopData", "()Ljava/util/HashMap;", "getMiniAppType", "()I", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateDesktopMiniAppInfo extends MiniAppDeskTopUIState {
        private final HashMap<Integer, List<DesktopItemInfo>> desktopData;
        private final int miniAppType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDesktopMiniAppInfo(HashMap<Integer, List<DesktopItemInfo>> desktopData, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(desktopData, "desktopData");
            this.desktopData = desktopData;
            this.miniAppType = i3;
        }

        public final HashMap<Integer, List<DesktopItemInfo>> getDesktopData() {
            return this.desktopData;
        }

        public final int getMiniAppType() {
            return this.miniAppType;
        }
    }

    public /* synthetic */ MiniAppDeskTopUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    MiniAppDeskTopUIState() {
    }
}
