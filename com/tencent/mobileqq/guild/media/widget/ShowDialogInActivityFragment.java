package com.tencent.mobileqq.guild.media.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/ShowDialogInActivityFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ShowDialogInActivityFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AtomicInteger D = new AtomicInteger(0);

    @NotNull
    private static final HashMap<Integer, aw> E = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/ShowDialogInActivityFragment$a;", "", "Lcom/tencent/mobileqq/guild/media/widget/aw;", "showDialogCallback", "", "a", "", "ARG_ID", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "idCallbackMap", "Ljava/util/HashMap;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.ShowDialogInActivityFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull aw showDialogCallback) {
            Intrinsics.checkNotNullParameter(showDialogCallback, "showDialogCallback");
            Intent intent = new Intent();
            int addAndGet = ShowDialogInActivityFragment.D.addAndGet(1);
            intent.putExtra("arg_id", addAndGet);
            ShowDialogInActivityFragment.E.put(Integer.valueOf(addAndGet), showDialogCallback);
            QPublicFragmentActivity.b.d(intent, QPublicTransFragmentActivity.class, ShowDialogInActivityFragment.class);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void rh(@NotNull aw awVar) {
        INSTANCE.a(awVar);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = new View(BaseApplication.getContext());
        view.setVisibility(8);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Object obj;
        super.onDestroy();
        Bundle arguments = getArguments();
        Integer num = null;
        if (arguments != null) {
            obj = arguments.get("arg_id");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            E.remove(Integer.valueOf(num.intValue()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Object obj;
        super.onDestroyView();
        Bundle arguments = getArguments();
        Integer num = null;
        if (arguments != null) {
            obj = arguments.get("arg_id");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            aw awVar = E.get(Integer.valueOf(num.intValue()));
            if (awVar != null) {
                awVar.dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Object obj;
        aw awVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        Integer num = null;
        if (arguments != null) {
            obj = arguments.get("arg_id");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            int intValue = num.intValue();
            FragmentActivity activity = getActivity();
            if (activity != null && (awVar = E.get(Integer.valueOf(intValue))) != null) {
                awVar.show(activity);
            }
        }
    }
}
