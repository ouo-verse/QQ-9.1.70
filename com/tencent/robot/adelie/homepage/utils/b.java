package com.tencent.robot.adelie.homepage.utils;

import android.content.Context;
import com.tencent.robot.qqmc.RobotQQMC;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/b;", "", "Landroid/content/Context;", "context", "", "a", "Lcom/tencent/robot/adelie/homepage/utils/b$a;", "listener", "b", "c", "Lcom/tencent/robot/adelie/homepage/utils/b$a;", "generateAvatarListener", "Lcom/tencent/robot/qqmc/model/a;", "Lcom/tencent/robot/qqmc/model/a;", "getAiGenerateConfig", "()Lcom/tencent/robot/qqmc/model/a;", "aiGenerateConfig", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a generateAvatarListener;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f366646a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.robot.qqmc.model.a aiGenerateConfig = RobotQQMC.INSTANCE.getAiGenerateConfig();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/b$a;", "", "Landroid/content/Context;", "context", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@Nullable Context context);
    }

    b() {
    }

    public final void a(@Nullable Context context) {
        a aVar = generateAvatarListener;
        if (aVar != null) {
            aVar.a(context);
        }
    }

    public final void b(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        generateAvatarListener = listener;
    }

    public final void c() {
        generateAvatarListener = null;
    }
}
