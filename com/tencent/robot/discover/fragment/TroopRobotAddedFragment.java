package com.tencent.robot.discover.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.discover.part.RobotAddedContentPart;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/discover/fragment/TroopRobotAddedFragment;", "Lcom/tencent/robot/discover/fragment/RobotBaseFragment;", "", "initData", "vh", "", "th", "initViewModel", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopUin", "D", "I", "maxRobotNum", "E", "addedRobotNum", "Lcom/tencent/robot/discover/viewmodel/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/discover/viewmodel/d;", "viewModel", "<init>", "()V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopRobotAddedFragment extends RobotBaseFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    private int maxRobotNum;

    /* renamed from: E, reason: from kotlin metadata */
    private int addedRobotNum;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.robot.discover.viewmodel.d viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/discover/fragment/TroopRobotAddedFragment$a;", "", "", "troopUin", "", "maxNum", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", "Lkotlin/collections/ArrayList;", "robotList", "Landroid/content/Context;", "context", "", "a", "TROOP_ADDED_ROBOT_LIST", "Ljava/lang/String;", "TROOP_MAX_ROBOT_NUM", "TROOP_ROBOT_EXTRA_BUNDLE", "TROOP_UIN", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discover.fragment.TroopRobotAddedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String troopUin, int maxNum, @NotNull ArrayList<RobotBase> robotList, @Nullable Context context) {
            Intrinsics.checkNotNullParameter(robotList, "robotList");
            if (context != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("TROOP_ADDED_ROBOT_LIST", robotList);
                Intent intent = new Intent();
                intent.putExtra("TROOP_ROBOT_EXTRA_BUNDLE", bundle);
                intent.putExtra("TROOP_UIN", troopUin);
                intent.putExtra("TROOP_MAX_ROBOT_NUM", maxNum);
                QPublicFragmentActivity.start(context, intent, TroopRobotAddedFragment.class);
            }
        }

        Companion() {
        }
    }

    private final void initData() {
        String str;
        Intent intent;
        Bundle bundleExtra;
        Intent intent2;
        Intent intent3;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent3 = activity.getIntent()) == null || (str = intent3.getStringExtra("TROOP_UIN")) == null) {
            str = "";
        }
        this.troopUin = str;
        FragmentActivity activity2 = getActivity();
        int i3 = 0;
        if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
            i3 = intent2.getIntExtra("TROOP_MAX_ROBOT_NUM", 0);
        }
        this.maxRobotNum = i3;
        ArrayList arrayList = new ArrayList();
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null && (bundleExtra = intent.getBundleExtra("TROOP_ROBOT_EXTRA_BUNDLE")) != null) {
            Serializable serializable = bundleExtra.getSerializable("TROOP_ADDED_ROBOT_LIST");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RobotBase) {
                    arrayList.add(next);
                }
            }
        }
        this.addedRobotNum = arrayList.size();
        com.tencent.robot.discover.viewmodel.d dVar = this.viewModel;
        if (dVar != null) {
            dVar.W1(th(), arrayList, this.maxRobotNum, this.addedRobotNum);
        }
    }

    private final void initViewModel() {
        MutableLiveData<Pair<Integer, Integer>> S1;
        com.tencent.robot.discover.viewmodel.d dVar = (com.tencent.robot.discover.viewmodel.d) getViewModel(com.tencent.robot.discover.viewmodel.d.class);
        this.viewModel = dVar;
        if (dVar != null && (S1 = dVar.S1()) != null) {
            LifecycleOwner lifecycleOwner = getLifecycleOwner();
            final Function1<Pair<? extends Integer, ? extends Integer>, Unit> function1 = new Function1<Pair<? extends Integer, ? extends Integer>, Unit>() { // from class: com.tencent.robot.discover.fragment.TroopRobotAddedFragment$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends Integer> pair) {
                    invoke2((Pair<Integer, Integer>) pair);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Pair<Integer, Integer> pair) {
                    TroopRobotAddedFragment.this.addedRobotNum = pair.getFirst().intValue();
                    TroopRobotAddedFragment.this.maxRobotNum = pair.getSecond().intValue();
                    TroopRobotAddedFragment.this.vh();
                }
            };
            S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discover.fragment.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopRobotAddedFragment.uh(Function1.this, obj);
                }
            });
        }
    }

    private final String th() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("TROOP_UIN");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f222276d3);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.robot_discovery_add_title_txt)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(this.addedRobotNum), Integer.valueOf(this.maxRobotNum)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        setTitle(format);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new RobotAddedContentPart(viewLifecycleOwner));
        return mutableListOf;
    }

    @Override // com.tencent.robot.discover.fragment.RobotBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.fzb;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initData();
    }
}
