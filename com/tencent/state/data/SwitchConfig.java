package com.tencent.state.data;

import com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/data/SwitchConfig;", "", "()V", IAnimationFactory.AnimationType.f70702GROUP, "Key", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final class SwitchConfig {

    @NotNull
    public static final SwitchConfig INSTANCE = new SwitchConfig();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/data/SwitchConfig$Group;", "", "()V", "filamentCoverRecord", "", "filamentGroup", "squareCommonGroup", "useCacheGroup", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes4.dex */
    public static final class Group {

        @NotNull
        public static final Group INSTANCE = new Group();

        @NotNull
        public static final String filamentCoverRecord = "square_filament_cover_record";

        @NotNull
        public static final String filamentGroup = "ztp_filament";

        @NotNull
        public static final String squareCommonGroup = "ztp_common_config";

        @NotNull
        public static final String useCacheGroup = "101478";

        Group() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/data/SwitchConfig$Key;", "", "()V", "canChatLandUseCache", "", "canIndexUseCache", "canRecordGuest", "canRecordLand", "filamentCoverRecordGuestUpload", "intimateMTKDisabled", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes4.dex */
    public static final class Key {

        @NotNull
        public static final Key INSTANCE = new Key();

        @NotNull
        public static final String canChatLandUseCache = "can_chat_land_use_cache";

        @NotNull
        public static final String canIndexUseCache = "can_index_use_cache";

        @NotNull
        public static final String canRecordGuest = "can_record_guest";

        @NotNull
        public static final String canRecordLand = "can_record_land";

        @NotNull
        public static final String filamentCoverRecordGuestUpload = "enable_guest_upload";

        @NotNull
        public static final String intimateMTKDisabled = "ztp_intimate_mtk_disabled";

        Key() {
        }
    }

    SwitchConfig() {
    }
}
