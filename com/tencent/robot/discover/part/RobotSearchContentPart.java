package com.tencent.robot.discover.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u0006R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001a\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/discover/part/RobotSearchContentPart;", "Lcom/tencent/robot/discover/part/c;", "Lcom/tencent/robot/discover/viewmodel/n;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "R9", "", "T9", "V9", "", "show", "U9", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", ReportConstant.COSTREPORT_PREFIX, "I9", "Ljava/lang/Class;", "F9", "Q9", "", BdhLogUtil.LogTag.Tag_Conn, "I", "containerViewId", "D", "viewStubId", "E", "Landroid/view/View;", "rootViewOwnedByPart", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/RelativeLayout;", "emptyRl", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "searchResultTv", "H", WadlProxyConsts.SCENE_ID, "<init>", "(II)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSearchContentPart extends c<com.tencent.robot.discover.viewmodel.n> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int containerViewId;

    /* renamed from: D, reason: from kotlin metadata */
    private final int viewStubId;

    /* renamed from: E, reason: from kotlin metadata */
    private View rootViewOwnedByPart;

    /* renamed from: F, reason: from kotlin metadata */
    private RelativeLayout emptyRl;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView searchResultTv;

    /* renamed from: H, reason: from kotlin metadata */
    private int sceneId;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/discover/part/RobotSearchContentPart$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1) {
                RobotSearchContentPart.this.Q9();
            }
        }
    }

    public /* synthetic */ RobotSearchContentPart(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? -1 : i16);
    }

    private final View R9(View rootView) {
        if (this.containerViewId != -1) {
            View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f169072ho4, (ViewGroup) rootView.findViewById(this.containerViewId), true);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            // \u5728contai\u2026e\n            )\n        }");
            return inflate;
        }
        int i3 = this.viewStubId;
        if (i3 != -1) {
            ViewStub viewStub = (ViewStub) rootView.findViewById(i3);
            viewStub.setLayoutResource(R.layout.f169072ho4);
            View inflate2 = viewStub.inflate();
            Intrinsics.checkNotNullExpressionValue(inflate2, "{\n            // \u5728viewSt\u2026    }.inflate()\n        }");
            return inflate2;
        }
        View findViewById = rootView.findViewById(R.id.f7658422);
        Intrinsics.checkNotNullExpressionValue(findViewById, "{\n            // \u9ed8\u8ba4\u5904\u7406\uff0cro\u2026_search_result)\n        }");
        return findViewById;
    }

    private final void S9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f766942c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.robot_empty_rl)");
        this.emptyRl = (RelativeLayout) findViewById;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(9);
        String qqStr = HardCodeUtil.qqStr(R.string.f224626jf);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.search_empty_tips)");
        View build = imageType.setTitle(qqStr).setHalfScreenState(true).setBackgroundColorType(0).build();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        build.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = this.emptyRl;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyRl");
            relativeLayout = null;
        }
        relativeLayout.addView(build);
    }

    private final void T9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f774044_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.robot_search_result_tv)");
        TextView textView = (TextView) findViewById;
        this.searchResultTv = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultTv");
            textView = null;
        }
        int i3 = 0;
        boolean z16 = true;
        if (this.sceneId != 1) {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        S9(rootView);
        V9();
        D9().addOnScrollListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(boolean show) {
        RelativeLayout relativeLayout = null;
        if (show) {
            RelativeLayout relativeLayout2 = this.emptyRl;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyRl");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(0);
            D9().setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout3 = this.emptyRl;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyRl");
        } else {
            relativeLayout = relativeLayout3;
        }
        relativeLayout.setVisibility(8);
        D9().setVisibility(0);
    }

    private final void V9() {
        MutableLiveData<Boolean> P1;
        MutableLiveData<Integer> R1;
        MutableLiveData<Boolean> O1;
        MutableLiveData<List<k34.a>> Q1;
        com.tencent.robot.discover.viewmodel.n C9 = C9();
        if (C9 != null && (Q1 = C9.Q1()) != null) {
            LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
            final Function1<List<k34.a>, Unit> function1 = new Function1<List<k34.a>, Unit>() { // from class: com.tencent.robot.discover.part.RobotSearchContentPart$startObserver$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<k34.a> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<k34.a> list) {
                    RobotSearchContentPart.this.U9(list.isEmpty());
                    i34.b mAdapter = RobotSearchContentPart.this.getMAdapter();
                    if (mAdapter == null) {
                        return;
                    }
                    mAdapter.setItems(new ArrayList(list));
                }
            };
            Q1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.robot.discover.part.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotSearchContentPart.W9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.n C92 = C9();
        if (C92 != null && (O1 = C92.O1()) != null) {
            LifecycleOwner viewLifecycleOwner2 = getHostFragment().getViewLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.discover.part.RobotSearchContentPart$startObserver$2
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
                    RobotSearchContentPart.this.z9(!bool.booleanValue());
                }
            };
            O1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.robot.discover.part.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotSearchContentPart.X9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.n C93 = C9();
        if (C93 != null && (R1 = C93.R1()) != null) {
            LifecycleOwner viewLifecycleOwner3 = getHostFragment().getViewLifecycleOwner();
            final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.robot.discover.part.RobotSearchContentPart$startObserver$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    View view;
                    view = RobotSearchContentPart.this.rootViewOwnedByPart;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rootViewOwnedByPart");
                        view = null;
                    }
                    view.setVisibility(1 == (it.intValue() & 1) ? 0 : 8);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if ((it.intValue() & 4) != 0) {
                        RobotSearchContentPart.this.J9();
                    }
                }
            };
            R1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.robot.discover.part.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotSearchContentPart.Y9(Function1.this, obj);
                }
            });
        }
        com.tencent.robot.discover.viewmodel.n C94 = C9();
        if (C94 != null && (P1 = C94.P1()) != null) {
            LifecycleOwner viewLifecycleOwner4 = getHostFragment().getViewLifecycleOwner();
            final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.discover.part.RobotSearchContentPart$startObserver$4
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
                public final void invoke2(Boolean it) {
                    RobotSearchContentPart robotSearchContentPart = RobotSearchContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    robotSearchContentPart.I9(it.booleanValue());
                }
            };
            P1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.robot.discover.part.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotSearchContentPart.Z9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    @Override // com.tencent.robot.discover.part.c
    @NotNull
    public Class<com.tencent.robot.discover.viewmodel.n> F9() {
        return com.tencent.robot.discover.viewmodel.n.class;
    }

    @Override // com.tencent.robot.discover.part.c
    public void I9(boolean show) {
        if (show) {
            A9().setVisibility(0);
            RelativeLayout relativeLayout = this.emptyRl;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyRl");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(8);
            D9().setVisibility(8);
            return;
        }
        A9().setVisibility(8);
    }

    public final void Q9() {
        Object systemService = getPartRootView().getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getPartRootView().getWindowToken(), 0);
    }

    @Override // com.tencent.robot.discover.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View R9 = R9(rootView);
        this.rootViewOwnedByPart = R9;
        View view = null;
        if (R9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootViewOwnedByPart");
            R9 = null;
        }
        super.onInitView(R9);
        View view2 = this.rootViewOwnedByPart;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootViewOwnedByPart");
        } else {
            view = view2;
        }
        T9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.sceneId = activity.getIntent().getIntExtra("scene_id", 0);
    }

    @Override // com.tencent.robot.discover.part.c
    public void s() {
        com.tencent.robot.discover.viewmodel.n C9 = C9();
        if (C9 != null) {
            C9.loadMore();
        }
    }

    public RobotSearchContentPart(int i3, int i16) {
        this.containerViewId = i3;
        this.viewStubId = i16;
    }
}
