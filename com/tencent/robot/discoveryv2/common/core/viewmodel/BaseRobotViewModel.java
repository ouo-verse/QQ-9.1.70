package com.tencent.robot.discoveryv2.common.core.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.robot.discoveryv2.common.core.viewmodel.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import q34.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u00020\u0007B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\f\u0010\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\"\u0010\u0019\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0011R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "Lq34/a;", BdhLogUtil.LogTag.Tag_Req, "", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/a;", "I", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "intent", "", "R1", "(Lcom/tencent/robot/discoveryv2/common/core/viewmodel/a;)V", "O1", "Landroidx/lifecycle/MutableLiveData;", "P1", "repository", "L1", "(Lq34/a;)V", "Q1", "T1", "i", "Lq34/a;", "M1", "()Lq34/a;", "S1", "mRobotRepository", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "mRobotUIState", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class BaseRobotViewModel<R extends q34.a, S, I extends a> extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public R mRobotRepository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mRobotUIState;

    public BaseRobotViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<MutableLiveData<S>>() { // from class: com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel$mRobotUIState$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<S> invoke() {
                return new MutableLiveData<>();
            }
        });
        this.mRobotUIState = lazy;
    }

    private final MutableLiveData<S> N1() {
        return (MutableLiveData) this.mRobotUIState.getValue();
    }

    public final void L1(@NotNull R repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        if (this.mRobotRepository == null) {
            S1(repository);
        }
    }

    @NotNull
    public final R M1() {
        R r16 = this.mRobotRepository;
        if (r16 != null) {
            return r16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRobotRepository");
        return null;
    }

    public void O1(@NotNull I intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @NotNull
    public final MutableLiveData<S> P1() {
        return N1();
    }

    public final void R1(@NotNull I intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        O1(intent);
    }

    public final void S1(@NotNull R r16) {
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.mRobotRepository = r16;
    }

    public void Q1() {
    }

    public void T1() {
    }
}
