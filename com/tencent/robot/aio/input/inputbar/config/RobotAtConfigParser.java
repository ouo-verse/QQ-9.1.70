package com.tencent.robot.aio.input.inputbar.config;

import com.google.gson.Gson;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.qqmc.GsonUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfig;", "b", "", "content", "c", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAtConfigParser extends BaseConfigParser<RobotAtConfig> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfigParser$a;", "", "Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfig;", "a", "", "KEY_ROBOT_AT_CONFIG", "Ljava/lang/String;", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.input.inputbar.config.RobotAtConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RobotAtConfig a() {
            RobotAtConfig robotAtConfig = (RobotAtConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("103213");
            if (robotAtConfig == null) {
                return new RobotAtConfig();
            }
            return robotAtConfig;
        }

        Companion() {
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RobotAtConfig defaultConfig() {
        return new RobotAtConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public RobotAtConfig parse(@NotNull byte[] content) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        QLog.i("RobotAtConfigParser", 2, "parse content: " + new String(content, UTF_8));
        try {
            Result.Companion companion = Result.INSTANCE;
            Gson a16 = GsonUtil.f368209a.a();
            Charset UTF_82 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
            m476constructorimpl = Result.m476constructorimpl((RobotAtConfig) a16.fromJson(new String(content, UTF_82), RobotAtConfig.class));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("RobotAtConfigParser", 2, m479exceptionOrNullimpl, new Object[0]);
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = defaultConfig();
        }
        return (RobotAtConfig) m476constructorimpl;
    }
}
