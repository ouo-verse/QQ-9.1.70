package com.tencent.qqmini.sdk.launcher.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/model/CrashRtInfoHolder;", "", "buildReportParams", "", "", "getRuntimeNativeLibs", "", "BeaconKey", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface CrashRtInfoHolder {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/model/CrashRtInfoHolder$BeaconKey;", "", "()V", "FIRST_FRAME_RESULT", "", "GAME_ID", "GAME_NAME", "JS_VERSION", "LAUNCH_RESULT", "TRITON_VERSION", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class BeaconKey {

        @NotNull
        public static final String FIRST_FRAME_RESULT = "first_frame_result";

        @NotNull
        public static final String GAME_ID = "game_id";

        @NotNull
        public static final String GAME_NAME = "game_name";
        public static final BeaconKey INSTANCE = new BeaconKey();

        @NotNull
        public static final String JS_VERSION = "js_version";

        @NotNull
        public static final String LAUNCH_RESULT = "launch_result";

        @NotNull
        public static final String TRITON_VERSION = "triton_version";

        BeaconKey() {
        }
    }

    @NotNull
    Map<String, String> buildReportParams();

    @NotNull
    List<String> getRuntimeNativeLibs();
}
