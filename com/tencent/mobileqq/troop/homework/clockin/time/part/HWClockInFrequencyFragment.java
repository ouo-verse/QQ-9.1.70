package com.tencent.mobileqq.troop.homework.clockin.time.part;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR)\u0010%\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyFragment$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyFragment$a;", "getListener", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyFragment$a;", "listener", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "cancelBtn", "E", "confirmBtn", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "selectorViewGroup", "", "", "kotlin.jvm.PlatformType", "G", "Lkotlin/Lazy;", "th", "()Ljava/util/List;", "daysList", "<init>", "(Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyFragment$a;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInFrequencyFragment extends BottomSheetDialogFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a listener;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView cancelBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView confirmBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout selectorViewGroup;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy daysList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyFragment$a;", "", "", "", "frequencyList", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a(@NotNull List<Integer> frequencyList);
    }

    public HWClockInFrequencyFragment(@NotNull a listener) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener);
            return;
        }
        this.listener = listener;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<Integer>>() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.HWClockInFrequencyFragment$daysList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInFrequencyFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<Integer> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = HWClockInFrequencyFragment.this.getArguments();
                ArrayList<Integer> integerArrayList = arguments != null ? arguments.getIntegerArrayList("time_setting_frequency") : null;
                return integerArrayList == null ? new ArrayList() : integerArrayList;
            }
        });
        this.daysList = lazy;
    }

    private final void sh() {
        getParentFragmentManager().beginTransaction().remove(this).commit();
    }

    private final List<Integer> th() {
        return (List) this.daysList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(HWClockInFrequencyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(HWClockInFrequencyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.th().isEmpty()) {
            QQToast.makeText(this$0.getContext(), 1, "\u8bf7\u81f3\u5c11\u9009\u62e9\u4e00\u5929", 0).show();
        } else {
            this$0.listener.a(this$0.th());
            this$0.sh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(HWClockInFrequencyFragment this$0, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        if (z16) {
            if (!this$0.th().contains(Integer.valueOf(i3))) {
                this$0.th().add(Integer.valueOf(i3));
                return;
            }
            return;
        }
        this$0.th().remove(Integer.valueOf(i3));
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            rootView = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            rootView = inflater.inflate(R.layout.f168602g02, container, false);
            View findViewById = rootView.findViewById(R.id.aou);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cancel_btn)");
            this.cancelBtn = (TextView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.b7p);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.confirm_btn)");
            this.confirmBtn = (TextView) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.f82824hx);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.selector_view_group)");
            this.selectorViewGroup = (LinearLayout) findViewById3;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Window window;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (viewGroup = (ViewGroup) window.findViewById(R.id.ugk)) != null) {
            viewGroup.setBackgroundResource(17170445);
        }
        TextView textView = this.cancelBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWClockInFrequencyFragment.uh(HWClockInFrequencyFragment.this, view2);
            }
        });
        TextView textView2 = this.confirmBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWClockInFrequencyFragment.vh(HWClockInFrequencyFragment.this, view2);
            }
        });
        int length = com.tencent.mobileqq.troop.homework.clockin.b.f296279a.a().length;
        for (final int i3 = 0; i3 < length; i3++) {
            LinearLayout linearLayout = this.selectorViewGroup;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectorViewGroup");
                linearLayout = null;
            }
            Context context = linearLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "selectorViewGroup.context");
            QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null, 2, null);
            x.b.d dVar = new x.b.d(com.tencent.mobileqq.troop.homework.clockin.b.f296279a.a()[i3]);
            x.c.i iVar = new x.c.i(th().contains(Integer.valueOf(i3)), null, 2, null);
            iVar.e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.f
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view2, boolean z16) {
                    HWClockInFrequencyFragment.wh(HWClockInFrequencyFragment.this, i3, view2, z16);
                }
            });
            Unit unit = Unit.INSTANCE;
            qUISingleLineListItem.setConfig(dVar, iVar);
            LinearLayout linearLayout2 = this.selectorViewGroup;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectorViewGroup");
                linearLayout2 = null;
            }
            linearLayout2.addView(qUISingleLineListItem);
        }
    }
}
