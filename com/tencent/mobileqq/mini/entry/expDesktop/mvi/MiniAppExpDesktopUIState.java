package com.tencent.mobileqq.mini.entry.expDesktop.mvi;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "CloseMiniAppSubPage", "MiniAppDesktopClose", "MyMiniAppDraggingTempSwitchPosition", "OnAccountChanged", "OnPostThemeChanged", "StudyModeChange", "UpdateDesktopAllMiniAppInfo", "UpdateDesktopMoreMiniAppInfo", "UpdateDesktopPersonalMiniAppInfo", "UpdateDesktopRankMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$CloseMiniAppSubPage;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$MiniAppDesktopClose;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$MyMiniAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$OnAccountChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$OnPostThemeChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$StudyModeChange;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopAllMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopMoreMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopPersonalMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopRankMiniAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class MiniAppExpDesktopUIState implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$CloseMiniAppSubPage;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class CloseMiniAppSubPage extends MiniAppExpDesktopUIState {
        public static final CloseMiniAppSubPage INSTANCE = new CloseMiniAppSubPage();

        CloseMiniAppSubPage() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$MiniAppDesktopClose;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MiniAppDesktopClose extends MiniAppExpDesktopUIState {
        public static final MiniAppDesktopClose INSTANCE = new MiniAppDesktopClose();

        MiniAppDesktopClose() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$MyMiniAppDraggingTempSwitchPosition;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "deepCopyMyMiniAppInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(Ljava/util/List;)V", "getDeepCopyMyMiniAppInfo", "()Ljava/util/List;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MyMiniAppDraggingTempSwitchPosition extends MiniAppExpDesktopUIState {
        private final List<DesktopAppInfo> deepCopyMyMiniAppInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyMiniAppDraggingTempSwitchPosition(List<DesktopAppInfo> deepCopyMyMiniAppInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(deepCopyMyMiniAppInfo, "deepCopyMyMiniAppInfo");
            this.deepCopyMyMiniAppInfo = deepCopyMyMiniAppInfo;
        }

        public final List<DesktopAppInfo> getDeepCopyMyMiniAppInfo() {
            return this.deepCopyMyMiniAppInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$OnAccountChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class OnAccountChanged extends MiniAppExpDesktopUIState {
        public static final OnAccountChanged INSTANCE = new OnAccountChanged();

        OnAccountChanged() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$OnPostThemeChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class OnPostThemeChanged extends MiniAppExpDesktopUIState {
        public static final OnPostThemeChanged INSTANCE = new OnPostThemeChanged();

        OnPostThemeChanged() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$StudyModeChange;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "isStudyMode", "", "(Z)V", "()Z", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class StudyModeChange extends MiniAppExpDesktopUIState {
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\u0002\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopAllMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "personalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "recommendModules", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "(Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V", "getPersonalModuleMap", "()Ljava/util/Map;", "getRankModules", "()Ljava/util/List;", "getRecommendModules", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateDesktopAllMiniAppInfo extends MiniAppExpDesktopUIState {
        private final Map<Integer, DesktopItemInfo> personalModuleMap;
        private final List<ExpDesktopRankTabAppInfo> rankModules;
        private final List<ExpDesktopGroupAppInfo> recommendModules;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDesktopAllMiniAppInfo(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModules, List<ExpDesktopRankTabAppInfo> rankModules) {
            super(null);
            Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
            Intrinsics.checkNotNullParameter(recommendModules, "recommendModules");
            Intrinsics.checkNotNullParameter(rankModules, "rankModules");
            this.personalModuleMap = personalModuleMap;
            this.recommendModules = recommendModules;
            this.rankModules = rankModules;
        }

        public final Map<Integer, DesktopItemInfo> getPersonalModuleMap() {
            return this.personalModuleMap;
        }

        public final List<ExpDesktopRankTabAppInfo> getRankModules() {
            return this.rankModules;
        }

        public final List<ExpDesktopGroupAppInfo> getRecommendModules() {
            return this.recommendModules;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopMoreMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "moduleType", "", "moreMiniAppInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(ILjava/util/List;)V", "getModuleType", "()I", "getMoreMiniAppInfo", "()Ljava/util/List;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateDesktopMoreMiniAppInfo extends MiniAppExpDesktopUIState {
        private final int moduleType;
        private final List<DesktopAppInfo> moreMiniAppInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDesktopMoreMiniAppInfo(int i3, List<DesktopAppInfo> moreMiniAppInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(moreMiniAppInfo, "moreMiniAppInfo");
            this.moduleType = i3;
            this.moreMiniAppInfo = moreMiniAppInfo;
        }

        public final int getModuleType() {
            return this.moduleType;
        }

        public final List<DesktopAppInfo> getMoreMiniAppInfo() {
            return this.moreMiniAppInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopPersonalMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "personalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "moduleType", "(Ljava/util/Map;I)V", "getModuleType", "()I", "getPersonalModuleMap", "()Ljava/util/Map;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateDesktopPersonalMiniAppInfo extends MiniAppExpDesktopUIState {
        private final int moduleType;
        private final Map<Integer, DesktopItemInfo> personalModuleMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDesktopPersonalMiniAppInfo(Map<Integer, DesktopItemInfo> personalModuleMap, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
            this.personalModuleMap = personalModuleMap;
            this.moduleType = i3;
        }

        public final int getModuleType() {
            return this.moduleType;
        }

        public final Map<Integer, DesktopItemInfo> getPersonalModuleMap() {
            return this.personalModuleMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopRankMiniAppInfo;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "moduleType", "", "rankMiniAppInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(ILjava/util/List;)V", "getModuleType", "()I", "getRankMiniAppInfo", "()Ljava/util/List;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateDesktopRankMiniAppInfo extends MiniAppExpDesktopUIState {
        private final int moduleType;
        private final List<DesktopAppInfo> rankMiniAppInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDesktopRankMiniAppInfo(int i3, List<DesktopAppInfo> rankMiniAppInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(rankMiniAppInfo, "rankMiniAppInfo");
            this.moduleType = i3;
            this.rankMiniAppInfo = rankMiniAppInfo;
        }

        public final int getModuleType() {
            return this.moduleType;
        }

        public final List<DesktopAppInfo> getRankMiniAppInfo() {
            return this.rankMiniAppInfo;
        }
    }

    public /* synthetic */ MiniAppExpDesktopUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    MiniAppExpDesktopUIState() {
    }
}
