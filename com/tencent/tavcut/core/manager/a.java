package com.tencent.tavcut.core.manager;

import com.gyailib.library.GYTrackStickerInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J>\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/manager/a;", "", "", "process", "", "stickerName", "Lorg/light/lightAssetKit/Entity;", "entity", "", "b", "", "errorCode", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "a", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface a {
    void a(int errorCode, @Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity);

    void b(float process, @NotNull String stickerName, @NotNull Entity entity);
}
