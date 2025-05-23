package com.tencent.robot.aio.pluspanel.processor;

import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.qqnt.pluspanel.logic.b;
import com.tencent.robot.aio.pluspanel.processor.RobotPlusPanelEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/processor/RobotPictureOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPictureOnClickProcessor implements b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f367319a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/processor/RobotPictureOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(@NotNull com.tencent.qqnt.pluspanel.data.a data, @NotNull final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        if (FastClickUtils.isFastDoubleClick("RobotPictureOnClickProcessor")) {
            return;
        }
        v24.a aVar = v24.a.f440822a;
        Fragment c16 = context.c();
        Intrinsics.checkNotNullExpressionValue(c16, "context.fragment");
        aVar.a(c16, "album", new Function0<Unit>() { // from class: com.tencent.robot.aio.pluspanel.processor.RobotPictureOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.aio.api.runtime.a.this.e().h(RobotPlusPanelEvent.OnClickPicture.f367321d);
            }
        });
    }
}
