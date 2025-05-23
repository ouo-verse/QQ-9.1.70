package com.tencent.robot.discoveryv2.common.repository.core;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/core/RobotRepositoryPart;", "Lo34/a;", "", "initData", "E9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "getMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/robot/discoveryv2/common/repository/core/a;", "d", "Lcom/tencent/robot/discoveryv2/common/repository/core/a;", "mRepositoryDelegate", "e", "Ljava/lang/String;", "mUin", "Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "f", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "mRobotRepository", "<init>", "(Lcom/tencent/robot/discoveryv2/common/repository/core/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotRepositoryPart extends o34.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mRepositoryDelegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mRobotRepository;

    public RobotRepositoryPart(@NotNull a mRepositoryDelegate) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mRepositoryDelegate, "mRepositoryDelegate");
        this.mRepositoryDelegate = mRepositoryDelegate;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<d>() { // from class: com.tencent.robot.discoveryv2.common.repository.core.RobotRepositoryPart$mRobotRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                a aVar;
                aVar = RobotRepositoryPart.this.mRepositoryDelegate;
                return new d(aVar);
            }
        });
        this.mRobotRepository = lazy;
    }

    private final void C9() {
        D9().onDestroy();
    }

    private final d D9() {
        return (d) this.mRobotRepository.getValue();
    }

    private final void E9() {
        d D9 = D9();
        String str = this.mUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUin");
            str = null;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        D9.h(new RepositoryParams(str, lifecycleOwner));
        d D92 = D9();
        String str3 = this.mUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUin");
        } else {
            str2 = str3;
        }
        D92.a(new FirstScreenFetchArgs(str2));
    }

    private final void initData() {
        String stringExtra = getPartHost().getHostActivity().getIntent().getStringExtra("param_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mUin = stringExtra;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "get_robot_repository")) {
            return D9();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        C9();
    }
}
