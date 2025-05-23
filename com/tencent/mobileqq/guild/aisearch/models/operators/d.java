package com.tencent.mobileqq.guild.aisearch.models.operators;

import android.util.Log;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/d;", "", "", "totalCount", "", "dataTimestamp", "", "c", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "data", "prevData", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/e;", "b", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/a;", "a", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/a;", "speedCounter", "", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "Ljava/util/List;", "emitSpeedList", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "emitSpeed", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a speedCounter = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<EmitSpeed> emitSpeedList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EmitSpeed emitSpeed;

    public d() {
        Object first;
        List<EmitSpeed> b16 = EmitSpeed.INSTANCE.b();
        this.emitSpeedList = b16;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) b16);
        this.emitSpeed = (EmitSpeed) first;
        int i3 = 0;
        for (Object obj : b16) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            EmitSpeed emitSpeed = (EmitSpeed) obj;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("AIChatRepository", "adaptiveContentEmit: speedConfigs[" + i3 + "]=" + emitSpeed);
            }
            i3 = i16;
        }
    }

    private final void c(int totalCount, long dataTimestamp) {
        this.speedCounter.a(totalCount, dataTimestamp);
        float c16 = this.speedCounter.c();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("AIChatRepository", "updateSpeed: speed=" + c16);
        }
        EmitSpeed a16 = EmitSpeed.INSTANCE.a(this.emitSpeedList, c16);
        if (!Intrinsics.areEqual(a16, this.emitSpeed)) {
            if (QLog.isDevelopLevel()) {
                Log.d("AIChatRepository", "updateSpeed: speedChange: " + this.emitSpeed + " -> " + a16);
            }
            this.emitSpeed = a16;
        }
    }

    @Nullable
    public final StepResult b(@NotNull ChatAnswerData data, @Nullable ChatAnswerData prevData) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(data, "data");
        if (prevData == null) {
            this.speedCounter.a(data.getReasonContent().length() + data.getContent().length(), data.getFirstDataTimestamp());
            return null;
        }
        int length = data.getReasonContent().length() - prevData.getReasonContent().length();
        int length2 = data.getContent().length() - prevData.getContent().length();
        int i3 = length + length2;
        if (i3 <= 0) {
            return null;
        }
        if (data.getState() == 2 || data.getState() == 4) {
            roundToInt = MathKt__MathJVMKt.roundToInt(this.emitSpeed.f() * (1000.0f / ((float) this.emitSpeed.d())));
            if (i3 < roundToInt) {
                EmitSpeed emitSpeed = this.emitSpeed;
                return new StepResult(0, 0, emitSpeed, emitSpeed.d(), roundToInt);
            }
            c(i3 - roundToInt, data.getDataTimestamp());
            return new StepResult(length, length2, this.emitSpeed, 0L, roundToInt);
        }
        c(i3, data.getDataTimestamp());
        return new StepResult(length, length2, this.emitSpeed, 0L, 0, 24, null);
    }
}
