package com.tencent.robot.discover.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.robot.discover.data.RobotRecentUsedData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/robot/discover/part/RobotRecentUsedPart;", "Lcom/tencent/robot/discover/part/c;", "Lcom/tencent/robot/discover/viewmodel/k;", "", "X9", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "data", "Ljava/util/ArrayList;", "Lk34/a;", "Lkotlin/collections/ArrayList;", "Y9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", ReportConstant.COSTREPORT_PREFIX, "", "show", "I9", "Ljava/lang/Class;", "F9", "onPartDestroy", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "D", "Z", "isFirstEven", "E", "isFirstReceiveErrorTip", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "Ljava/lang/Runnable;", "mLoadingRunnable", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotRecentUsedPart extends c<com.tencent.robot.discover.viewmodel.k> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFirstEven;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFirstReceiveErrorTip;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Runnable mLoadingRunnable;

    public RobotRecentUsedPart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        this.isFirstEven = true;
        this.isFirstReceiveErrorTip = true;
        this.mLoadingRunnable = new Runnable() { // from class: com.tencent.robot.discover.part.q
            @Override // java.lang.Runnable
            public final void run() {
                RobotRecentUsedPart.T9(RobotRecentUsedPart.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(RobotRecentUsedPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X9() {
        QLog.i("RobotRecentUsedPart", 4, WebViewPlugin.KEY_REQUEST);
        com.tencent.robot.discover.viewmodel.k C9 = C9();
        if (C9 != null) {
            C9.R1();
        }
        A9().postDelayed(this.mLoadingRunnable, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<k34.a> Y9(List<GroupRobot> data) {
        ArrayList<k34.a> arrayList = new ArrayList<>();
        if (data != null) {
            int i3 = 0;
            for (Object obj : data) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new k34.d("", (GroupRobot) obj, i16, null, false, 24, null));
                i3 = i16;
            }
        }
        I9(false);
        return arrayList;
    }

    @Override // com.tencent.robot.discover.part.c
    @NotNull
    public Class<com.tencent.robot.discover.viewmodel.k> F9() {
        return com.tencent.robot.discover.viewmodel.k.class;
    }

    @Override // com.tencent.robot.discover.part.c
    public void I9(boolean show) {
        super.I9(show);
        if (!show) {
            A9().removeCallbacks(this.mLoadingRunnable);
        }
    }

    @Override // com.tencent.robot.discover.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        MutableLiveData<Boolean> P1;
        MutableLiveData<Boolean> N1;
        MutableLiveData<List<GroupRobot>> O1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("kay_recent_used_data");
        if (serializableExtra instanceof RobotRecentUsedData) {
            RobotRecentUsedData robotRecentUsedData = (RobotRecentUsedData) serializableExtra;
            if (robotRecentUsedData.getRobots().size() == robotRecentUsedData.getTotalNum()) {
                i34.b mAdapter = getMAdapter();
                if (mAdapter != null) {
                    mAdapter.setItems(Y9(robotRecentUsedData.getRobots()));
                }
                z9(false);
                return;
            }
        }
        com.tencent.robot.discover.viewmodel.k C9 = C9();
        if (C9 != null && (O1 = C9.O1()) != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            final RobotRecentUsedPart$onInitView$1 robotRecentUsedPart$onInitView$1 = new RobotRecentUsedPart$onInitView$1(this);
            O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discover.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotRecentUsedPart.U9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.k C92 = C9();
        if (C92 != null && (N1 = C92.N1()) != null) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.discover.part.RobotRecentUsedPart$onInitView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    RobotRecentUsedPart.this.z9(!bool.booleanValue());
                }
            };
            N1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.robot.discover.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotRecentUsedPart.V9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.k C93 = C9();
        if (C93 != null && (P1 = C93.P1()) != null) {
            LifecycleOwner lifecycleOwner3 = this.lifecycleOwner;
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.discover.part.RobotRecentUsedPart$onInitView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    boolean z16;
                    z16 = RobotRecentUsedPart.this.isFirstReceiveErrorTip;
                    if (z16) {
                        RobotRecentUsedPart.this.isFirstReceiveErrorTip = false;
                    } else {
                        RobotRecentUsedPart.this.J9();
                        RobotRecentUsedPart.this.I9(false);
                    }
                }
            };
            P1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.robot.discover.part.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotRecentUsedPart.W9(Function1.this, obj);
                }
            });
        }
        X9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        A9().removeCallbacks(this.mLoadingRunnable);
    }

    @Override // com.tencent.robot.discover.part.c
    public void s() {
        QLog.i("RobotRecentUsedPart", 4, "onLoadMore");
        com.tencent.robot.discover.viewmodel.k C9 = C9();
        if (C9 != null) {
            C9.R1();
        }
    }
}
