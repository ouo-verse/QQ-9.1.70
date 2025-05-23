package com.tencent.robot.discoveryv2.troop.added;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.discover.fragment.TroopRobotAddedFragment;
import com.tencent.robot.discoveryv2.troop.added.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/added/TroopRobotAddedPart;", "Lo34/a;", "", "E9", "J9", "K9", "G9", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "addedRobotsData", "M9", "I9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "Ljava/lang/String;", "mTroopUin", "e", "Landroid/view/View;", "mAddedRobotsLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mAddedRobotsText", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "Landroid/widget/ImageView;", h.F, "Ljava/util/List;", "mAvatarUIList", "Lcom/tencent/robot/discoveryv2/troop/added/TroopRobotAddedViewModel;", "i", "Lcom/tencent/robot/discoveryv2/troop/added/TroopRobotAddedViewModel;", "mAddedRobotsViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/discoveryv2/troop/added/a;", "mAddedRobotsData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopRobotAddedPart extends o34.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mAddedRobotsLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mAddedRobotsText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<Pair<RoundRectImageView, ImageView>> mAvatarUIList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TroopRobotAddedViewModel mAddedRobotsViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AddedRobotsData mAddedRobotsData;

    private final void E9() {
        List<Pair> listOf;
        View findViewById = getPartRootView().findViewById(R.id.sdl);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discoveryv2.troop.added.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopRobotAddedPart.F9(TroopRobotAddedPart.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026)\n            }\n        }");
        this.mAddedRobotsLayout = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.f7621412);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mAddedRobotsLayout.findV\u2026ById(R.id.robot_add_text)");
        this.mAddedRobotsText = (TextView) findViewById2;
        this.mAvatarUIList = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Integer.valueOf(R.id.f763041a), Integer.valueOf(R.id.f763541f)), new Pair(Integer.valueOf(R.id.f762941_), Integer.valueOf(R.id.f763441e)), new Pair(Integer.valueOf(R.id.f7628419), Integer.valueOf(R.id.f763341d))});
        for (Pair pair : listOf) {
            View view = this.mAddedRobotsLayout;
            List<Pair<RoundRectImageView, ImageView>> list = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
                view = null;
            }
            RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(((Number) pair.getFirst()).intValue());
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(16.0f), 1);
            View view2 = this.mAddedRobotsLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
                view2 = null;
            }
            ImageView imageView = (ImageView) view2.findViewById(((Number) pair.getSecond()).intValue());
            List<Pair<RoundRectImageView, ImageView>> list2 = this.mAvatarUIList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarUIList");
            } else {
                list = list2;
            }
            list.add(new Pair<>(roundRectImageView, imageView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(TroopRobotAddedPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9() {
        TroopRobotAddedViewModel troopRobotAddedViewModel = (TroopRobotAddedViewModel) z9(TroopRobotAddedViewModel.class);
        this.mAddedRobotsViewModel = troopRobotAddedViewModel;
        TroopRobotAddedViewModel troopRobotAddedViewModel2 = null;
        if (troopRobotAddedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsViewModel");
            troopRobotAddedViewModel = null;
        }
        troopRobotAddedViewModel.Q1();
        TroopRobotAddedViewModel troopRobotAddedViewModel3 = this.mAddedRobotsViewModel;
        if (troopRobotAddedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsViewModel");
        } else {
            troopRobotAddedViewModel2 = troopRobotAddedViewModel3;
        }
        MutableLiveData<b> P1 = troopRobotAddedViewModel2.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<b, Unit> function1 = new Function1<b, Unit>() { // from class: com.tencent.robot.discoveryv2.troop.added.TroopRobotAddedPart$initAddedRobotsViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                if (bVar instanceof b.RefreshAddedRobotsLayoutUIState) {
                    TroopRobotAddedPart.this.M9(((b.RefreshAddedRobotsLayoutUIState) bVar).getAddedRobotsData());
                }
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discoveryv2.troop.added.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopRobotAddedPart.H9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        x34.a aVar = x34.a.f447161a;
        View view = this.mAddedRobotsLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
            view = null;
        }
        aVar.a(view, "em_qqrobot_added_robot", null);
        View view2 = this.mAddedRobotsLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
            view2 = null;
        }
        VideoReport.reportEvent("imp", view2, null);
    }

    private final void J9() {
        String stringExtra = getPartHost().getHostActivity().getIntent().getStringExtra("param_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTroopUin = stringExtra;
    }

    private final void K9() {
        ArrayList<RobotBase> arrayList;
        int i3;
        List<GroupRobotBaseInfo> a16;
        int collectionSizeOrDefault;
        if (FastClickUtils.isFastDoubleClick("TroopAddedRobotsPartonAddedRobotsLayoutClick")) {
            return;
        }
        L9();
        AddedRobotsData addedRobotsData = this.mAddedRobotsData;
        String str = null;
        if (addedRobotsData != null && (a16 = addedRobotsData.a()) != null) {
            List<GroupRobotBaseInfo> list = a16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList<>(collectionSizeOrDefault);
            for (GroupRobotBaseInfo groupRobotBaseInfo : list) {
                RobotBase robotBase = new RobotBase();
                robotBase.robotUin = groupRobotBaseInfo.robotUin;
                robotBase.robotName = groupRobotBaseInfo.robotName;
                robotBase.robotAvatar = groupRobotBaseInfo.robotAvatar;
                robotBase.robotDesc = groupRobotBaseInfo.robotDesc;
                arrayList.add(robotBase);
            }
        } else {
            arrayList = null;
        }
        if (!(arrayList instanceof ArrayList)) {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        TroopRobotAddedFragment.Companion companion = TroopRobotAddedFragment.INSTANCE;
        String str2 = this.mTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
        } else {
            str = str2;
        }
        AddedRobotsData addedRobotsData2 = this.mAddedRobotsData;
        if (addedRobotsData2 != null) {
            i3 = addedRobotsData2.getMaxRobotCount();
        } else {
            i3 = 0;
        }
        companion.a(str, i3, arrayList, getActivity());
    }

    private final void L9() {
        View view = this.mAddedRobotsLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
            view = null;
        }
        VideoReport.reportEvent("clck", view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(AddedRobotsData addedRobotsData) {
        this.mAddedRobotsData = addedRobotsData;
        View view = null;
        if (addedRobotsData.a().isEmpty()) {
            View view2 = this.mAddedRobotsLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.mAddedRobotsLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsLayout");
            view3 = null;
        }
        view3.setVisibility(0);
        TextView textView = this.mAddedRobotsText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddedRobotsText");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f222286d4);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.robot_discovery_add_txt)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(addedRobotsData.a().size()), Integer.valueOf(addedRobotsData.getMaxRobotCount())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        List<Pair<RoundRectImageView, ImageView>> list = this.mAvatarUIList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarUIList");
            list = null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<Pair<RoundRectImageView, ImageView>> list2 = this.mAvatarUIList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarUIList");
                list2 = null;
            }
            Pair<RoundRectImageView, ImageView> pair = list2.get(i3);
            if (i3 >= addedRobotsData.a().size()) {
                pair.getFirst().setVisibility(8);
                pair.getSecond().setVisibility(8);
            } else {
                pair.getFirst().setVisibility(0);
                n34.c.f418125a.a(String.valueOf(addedRobotsData.a().get(i3).robotUin), pair.getFirst());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        J9();
        E9();
        G9();
        I9();
    }
}
