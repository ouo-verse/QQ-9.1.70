package com.tencent.robot.discover.part;

import a54.a;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001D\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u000f\u0012\u0006\u0010,\u001a\u00020)\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J(\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\bH\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\"\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001d028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010;R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/robot/discover/part/RobotCategoryContentPart;", "Lcom/tencent/robot/discover/part/c;", "Lcom/tencent/robot/discover/viewmodel/h;", "Ll34/c;", "", "robotUin", "", "ca", "", "W9", "ba", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "data", "Ljava/util/ArrayList;", "Lk34/a;", "Lkotlin/collections/ArrayList;", "ea", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "", "redDot", "B2", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", IRobotUtilApi.MMKV_SCENE_ID, "Lkotlin/Function0;", "callback", "i1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", ReportConstant.COSTREPORT_PREFIX, "show", "I9", "Ljava/lang/Class;", "F9", "onPartDestroy", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "D", "Z", "isFirstEven", "E", "isFirstReceiveErrorTip", "Lcom/tencent/util/LongSparseArray;", UserInfo.SEX_FEMALE, "Lcom/tencent/util/LongSparseArray;", "mAddRobotCallBack", "G", "isJumpRobotProfile", "H", "J", "jumpRobotUid", "I", "Ljava/lang/String;", "mTroopUin", "", "mCategoryId", "Ljava/lang/Runnable;", "K", "Ljava/lang/Runnable;", "mLoadingRunnable", "com/tencent/robot/discover/part/RobotCategoryContentPart$b", "L", "Lcom/tencent/robot/discover/part/RobotCategoryContentPart$b;", "mRobotObserver", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "M", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotCategoryContentPart extends c<com.tencent.robot.discover.viewmodel.h> implements l34.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFirstEven;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFirstReceiveErrorTip;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private LongSparseArray<Function0<Unit>> mAddRobotCallBack;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isJumpRobotProfile;

    /* renamed from: H, reason: from kotlin metadata */
    private long jumpRobotUid;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String mTroopUin;

    /* renamed from: J, reason: from kotlin metadata */
    private int mCategoryId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private Runnable mLoadingRunnable;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final b mRobotObserver;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/discover/part/RobotCategoryContentPart$b", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements a54.a {
        b() {
        }

        @Override // a54.a
        public void a(@NotNull String str) {
            a.C0013a.e(this, str);
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String str) {
            a.C0013a.a(this, str);
        }

        @Override // a54.a
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.c(this, robotUin, troopUin, extraData);
            if (Intrinsics.areEqual(troopUin, RobotCategoryContentPart.this.mTroopUin)) {
                QLog.d(RobotCategoryContentPart.this.getLogTag(), 2, "onAddRobotToGroupSucc " + robotUin + " " + troopUin);
                RobotCategoryContentPart.this.ca(Util.toLongOrDefault(robotUin, 0L));
            }
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String str, @NotNull String str2) {
            a.C0013a.f(this, str, str2);
        }
    }

    public RobotCategoryContentPart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        this.isFirstEven = true;
        this.isFirstReceiveErrorTip = true;
        this.mAddRobotCallBack = new LongSparseArray<>();
        this.mTroopUin = "";
        this.mLoadingRunnable = new Runnable() { // from class: com.tencent.robot.discover.part.e
            @Override // java.lang.Runnable
            public final void run() {
                RobotCategoryContentPart.X9(RobotCategoryContentPart.this);
            }
        };
        this.mRobotObserver = new b();
    }

    private final boolean W9() {
        if (this.mCategoryId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(RobotCategoryContentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ba() {
        QLog.i("RobotCategoryContentPart", 4, "requestData groupId=" + this.mTroopUin + " categoryId=" + this.mCategoryId);
        com.tencent.robot.discover.viewmodel.h C9 = C9();
        if (C9 != null) {
            C9.S1(this.mTroopUin, this.mCategoryId);
        }
        A9().postDelayed(this.mLoadingRunnable, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(final long robotUin) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.robot.discover.part.i
                @Override // java.lang.Runnable
                public final void run() {
                    RobotCategoryContentPart.da(RobotCategoryContentPart.this, robotUin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(RobotCategoryContentPart this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAddRobotCallBack.remove(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<k34.a> ea(List<GroupRobot> data) {
        ArrayList<k34.a> arrayList = new ArrayList<>();
        if (data != null) {
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                arrayList.add(new k34.d(this.mTroopUin, (GroupRobot) it.next(), 0, null, false, 28, null));
            }
        }
        I9(false);
        return arrayList;
    }

    @Override // l34.c
    public void B2(@NotNull String robotUin, boolean redDot) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(robotUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.jumpRobotUid = j3;
        this.isJumpRobotProfile = true;
    }

    @Override // com.tencent.robot.discover.part.c
    @NotNull
    public Class<com.tencent.robot.discover.viewmodel.h> F9() {
        return com.tencent.robot.discover.viewmodel.h.class;
    }

    @Override // com.tencent.robot.discover.part.c
    public void I9(boolean show) {
        super.I9(show);
        if (!show) {
            A9().removeCallbacks(this.mLoadingRunnable);
        }
    }

    @Override // l34.c
    public void i1(@NotNull RobotBase robot, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(robot, "robot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mAddRobotCallBack.append(robot.robotUin, callback);
    }

    @Override // com.tencent.robot.discover.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        MutableLiveData<Boolean> Q1;
        MutableLiveData<Boolean> O1;
        MutableLiveData<List<GroupRobot>> P1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QLog.i("RobotCategoryContentPart", 4, "onInitView isHotCategory=" + W9());
        com.tencent.robot.discover.viewmodel.h C9 = C9();
        if (C9 != null && (P1 = C9.P1()) != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            final RobotCategoryContentPart$onInitView$1 robotCategoryContentPart$onInitView$1 = new RobotCategoryContentPart$onInitView$1(this);
            P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discover.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotCategoryContentPart.Y9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.h C92 = C9();
        if (C92 != null && (O1 = C92.O1()) != null) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.discover.part.RobotCategoryContentPart$onInitView$2
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
                    RobotCategoryContentPart.this.z9(!bool.booleanValue());
                }
            };
            O1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.robot.discover.part.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotCategoryContentPart.Z9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.h C93 = C9();
        if (C93 != null && (Q1 = C93.Q1()) != null) {
            LifecycleOwner lifecycleOwner3 = this.lifecycleOwner;
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.discover.part.RobotCategoryContentPart$onInitView$3
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
                    z16 = RobotCategoryContentPart.this.isFirstReceiveErrorTip;
                    if (z16) {
                        RobotCategoryContentPart.this.isFirstReceiveErrorTip = false;
                    } else {
                        RobotCategoryContentPart.this.J9();
                        RobotCategoryContentPart.this.I9(false);
                    }
                }
            };
            Q1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.robot.discover.part.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotCategoryContentPart.aa(Function1.this, obj);
                }
            });
        }
        ba();
        l34.e.f(rootView, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IRuntimeService iRuntimeService;
        int i3;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(this.mRobotObserver);
        }
        String stringExtra = activity.getIntent().getStringExtra("group_id_key");
        if (stringExtra != null) {
            str = stringExtra;
        }
        this.mTroopUin = str;
        String stringExtra2 = activity.getIntent().getStringExtra("category_id_key");
        if (stringExtra2 != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        this.mCategoryId = i3;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IRuntimeService iRuntimeService;
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.mRobotObserver);
        }
        A9().removeCallbacks(this.mLoadingRunnable);
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        l34.e.g(rootView, l34.c.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        if (this.isJumpRobotProfile) {
            this.isJumpRobotProfile = false;
            com.tencent.robot.discover.viewmodel.h C9 = C9();
            if (C9 != null) {
                C9.W1(this.mTroopUin, this.jumpRobotUid);
            }
        }
    }

    @Override // com.tencent.robot.discover.part.c
    public void s() {
        QLog.i("RobotCategoryContentPart", 4, "onLoadMore groupId=" + this.mTroopUin + " categoryId=" + this.mCategoryId);
        com.tencent.robot.discover.viewmodel.h C9 = C9();
        if (C9 != null) {
            C9.S1(this.mTroopUin, this.mCategoryId);
        }
    }
}
