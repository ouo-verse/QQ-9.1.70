package com.tencent.mobileqq.troop.homework.coursemgr.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.CourseInfo;
import com.tencent.mobileqq.troop.homework.coursemgr.ui.TroopHwCourseFloatingView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR&\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\r0\u001fj\b\u0012\u0004\u0012\u00020\r` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R#\u0010*\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseListPart;", "Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseBasePart;", "", "ba", "", "isCurSelect", "canBeDelete", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "courseInfo", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/e;", "S9", "courseInfoToDelete", "X9", "Lcom/tencent/mobileqq/widget/listitem/v;", "Q9", "V9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/TroopHwCourseFloatingView;", "f", "Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/TroopHwCourseFloatingView;", "floatingContainer", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "courseRecyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "i", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "courseAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "configList", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "U9", "()Landroid/app/Dialog;", "deleteLoading", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHwCourseListPart extends TroopHwCourseBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy deleteLoading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TroopHwCourseFloatingView floatingContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView courseRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIListItemAdapter courseAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<v> configList;

    public TroopHwCourseListPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.configList = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new TroopHwCourseListPart$deleteLoading$2(this));
        this.deleteLoading = lazy;
    }

    private final v Q9() {
        v vVar = new v(R.layout.g0_);
        vVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHwCourseListPart.R9(TroopHwCourseListPart.this, view);
            }
        });
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(TroopHwCourseListPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9().W1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.troop.homework.coursemgr.ui.e S9(boolean isCurSelect, boolean canBeDelete, final CourseInfo courseInfo) {
        final com.tencent.mobileqq.troop.homework.coursemgr.ui.e eVar = new com.tencent.mobileqq.troop.homework.coursemgr.ui.e(isCurSelect, canBeDelete, courseInfo, new Function0<Unit>(courseInfo) { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseListPart$createTroopHwCourseItemConfig$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CourseInfo $courseInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$courseInfo = courseInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseListPart.this, (Object) courseInfo);
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TroopHwCourseListPart.this.X9(this.$courseInfo);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        eVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopHwCourseListPart.T9(com.tencent.mobileqq.troop.homework.coursemgr.ui.e.this, this, courseInfo, view);
            }
        });
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(com.tencent.mobileqq.troop.homework.coursemgr.ui.e this_apply, TroopHwCourseListPart this$0, CourseInfo courseInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(courseInfo, "$courseInfo");
        this_apply.P(true);
        this$0.E9().d2(courseInfo);
        TroopHwCourseFloatingView troopHwCourseFloatingView = this$0.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog U9() {
        return (Dialog) this.deleteLoading.getValue();
    }

    private final void V9() {
        LiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> T1 = E9().T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.coursemgr.intent.c, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.coursemgr.intent.c, Unit>() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseListPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHwCourseListPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.coursemgr.intent.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.coursemgr.intent.c cVar) {
                Dialog U9;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                if (cVar instanceof com.tencent.mobileqq.troop.homework.coursemgr.intent.d) {
                    TroopHwCourseListPart.this.ba();
                    return;
                }
                if (cVar instanceof com.tencent.mobileqq.troop.homework.coursemgr.intent.b) {
                    com.tencent.mobileqq.troop.homework.coursemgr.intent.b bVar = (com.tencent.mobileqq.troop.homework.coursemgr.intent.b) cVar;
                    if (bVar.b() && bVar.a() == 0) {
                        TroopHwCourseListPart.this.ba();
                        QQToastUtil.showQQToast(2, TroopHwCourseListPart.this.getContext().getString(R.string.f23413795));
                    } else {
                        QQToastUtil.showQQToast(1, TroopHwCourseListPart.this.getContext().getString(R.string.f23412794));
                    }
                    U9 = TroopHwCourseListPart.this.U9();
                    U9.dismiss();
                    return;
                }
                if (cVar instanceof com.tencent.mobileqq.troop.homework.coursemgr.intent.a) {
                    com.tencent.mobileqq.troop.homework.coursemgr.intent.a aVar = (com.tencent.mobileqq.troop.homework.coursemgr.intent.a) cVar;
                    if (aVar.b() && aVar.a() == 0) {
                        TroopHwCourseListPart.this.ba();
                    }
                }
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopHwCourseListPart.W9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(final CourseInfo courseInfoToDelete) {
        TroopHwCourseFloatingView troopHwCourseFloatingView = this.floatingContainer;
        TroopHwCourseFloatingView troopHwCourseFloatingView2 = null;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.k
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                TroopHwCourseListPart.Y9(TroopHwCourseListPart.this);
            }
        });
        TroopHwCourseFloatingView troopHwCourseFloatingView3 = this.floatingContainer;
        if (troopHwCourseFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
        } else {
            troopHwCourseFloatingView2 = troopHwCourseFloatingView3;
        }
        troopHwCourseFloatingView2.t();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        createCustomDialog.setMessage(getActivity().getResources().getString(R.string.f23409791));
        createCustomDialog.setNegativeButton(R.string.f2059456z, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopHwCourseListPart.Z9(TroopHwCourseListPart.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(R.string.f20595570, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopHwCourseListPart.aa(TroopHwCourseListPart.this, courseInfoToDelete, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(TroopHwCourseListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopHwCourseFloatingView troopHwCourseFloatingView = this$0.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.setOnDismissListener(this$0.D9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(TroopHwCourseListPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        TroopHwCourseFloatingView troopHwCourseFloatingView = this$0.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(TroopHwCourseListPart this$0, CourseInfo courseInfoToDelete, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(courseInfoToDelete, "$courseInfoToDelete");
        dialogInterface.dismiss();
        this$0.E9().O1(courseInfoToDelete);
        this$0.U9().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        TroopHwCourseFloatingView troopHwCourseFloatingView;
        String str;
        this.configList = new ArrayList<>();
        Iterator<T> it = E9().S1().iterator();
        while (true) {
            troopHwCourseFloatingView = null;
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            CourseInfo courseInfo = (CourseInfo) it.next();
            String courseName = courseInfo.getCourseName();
            CourseInfo U1 = E9().U1();
            if (U1 != null) {
                str2 = U1.getCourseName();
            }
            this.configList.add(S9(Intrinsics.areEqual(courseName, str2), false, courseInfo));
        }
        for (CourseInfo courseInfo2 : E9().R1()) {
            String courseName2 = courseInfo2.getCourseName();
            CourseInfo U12 = E9().U1();
            if (U12 != null) {
                str = U12.getCourseName();
            } else {
                str = null;
            }
            this.configList.add(S9(Intrinsics.areEqual(courseName2, str), true, courseInfo2));
        }
        if (!E9().b2()) {
            this.configList.add(Q9());
        }
        QUIListItemAdapter qUIListItemAdapter = this.courseAdapter;
        if (qUIListItemAdapter != null) {
            Object[] array = this.configList.toArray(new v[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            v[] vVarArr = (v[]) array;
            qUIListItemAdapter.t0(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(vVarArr, vVarArr.length)));
        }
        TroopHwCourseFloatingView troopHwCourseFloatingView2 = this.floatingContainer;
        if (troopHwCourseFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
        } else {
            troopHwCourseFloatingView = troopHwCourseFloatingView2;
        }
        troopHwCourseFloatingView.T();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView == null) {
            A9();
            return;
        }
        View findViewById = rootView.findViewById(R.id.f66743bg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qus_half_screen_view)");
        this.floatingContainer = (TroopHwCourseFloatingView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f102085wy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ourse_list_recycler_view)");
        this.courseRecyclerView = (RecyclerView) findViewById2;
        RecyclerView recyclerView = null;
        this.courseAdapter = new QUIListItemAdapter(null, false, true, 3, null);
        RecyclerView recyclerView2 = this.courseRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.courseAdapter);
        RecyclerView recyclerView3 = this.courseRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView4 = this.courseRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        RecyclerView recyclerView5 = this.courseRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseRecyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new com.tencent.mobileqq.widget.listitem.m(context, false));
        ba();
        V9();
    }
}
