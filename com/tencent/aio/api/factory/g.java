package com.tencent.aio.api.factory;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/api/help/c;", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "getPanelFactory", "Lcom/tencent/aio/api/factory/c;", "buildPanelArea", "Ldt/b;", "getBottomDialogFactory", "Lcom/tencent/aio/msgservice/a;", "buildAIOMsgService", "Lcom/tencent/aio/base/log/f;", "buildAIOLogger", "Lys/a;", "buildActivityJumpService", "", "isDebugModel", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface g extends com.tencent.aio.api.help.c {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static com.tencent.aio.base.log.f a(@NotNull g gVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.msgservice.a b(@NotNull g gVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.api.factory.a c(@NotNull g gVar) {
            return null;
        }

        @Nullable
        public static c d(@NotNull g gVar) {
            return null;
        }

        @Nullable
        public static d e(@NotNull g gVar) {
            return null;
        }

        @Nullable
        public static e f(@NotNull g gVar) {
            return null;
        }

        @Nullable
        public static dt.b g(@NotNull g gVar) {
            return null;
        }

        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "buildPanelArea", imports = {}))
        @Nullable
        public static com.tencent.aio.part.root.panel.mvx.config.a h(@NotNull g gVar) {
            return null;
        }
    }

    @Nullable
    com.tencent.aio.base.log.f buildAIOLogger();

    @Nullable
    com.tencent.aio.msgservice.a buildAIOMsgService();

    @NotNull
    ys.a buildActivityJumpService();

    @NotNull
    f buildBusinessLevel();

    @Nullable
    com.tencent.aio.api.factory.a buildFullBackgroundLevel();

    @NotNull
    j buildMsgLevel();

    @Nullable
    c buildPanelArea();

    @Nullable
    d buildReserve1Level();

    @Nullable
    e buildReserve2Level();

    @Nullable
    dt.b getBottomDialogFactory();

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "buildPanelArea", imports = {}))
    @Nullable
    com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory();

    boolean isDebugModel();
}
