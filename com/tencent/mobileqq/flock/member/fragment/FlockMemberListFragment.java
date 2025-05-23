package com.tencent.mobileqq.flock.member.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.bottomsheet.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.FragmentPartProvider;
import com.tencent.biz.richframework.part.IPartFragmentHost;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.ktx.i;
import com.tencent.mobileqq.flock.member.part.FlockMemberListPart;
import com.tencent.mobileqq.flock.member.part.f;
import com.tencent.mobileqq.flock.member.viewmodel.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b%\u0010&J$\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/flock/member/fragment/FlockMemberListFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ph", "Landroid/content/Context;", "context", "", "onAttach", "onResume", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onStart", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/flock/member/viewmodel/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/flock/member/viewmodel/b;", "flockMemberListViewModel", "Lcom/google/android/material/bottomsheet/a;", "D", "Lcom/google/android/material/bottomsheet/a;", "fragmentDialog", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "hostFragment", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockMemberListFragment extends BottomSheetDialogFragment implements IPartFragmentHost {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b flockMemberListViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private a fragmentDialog;

    public FlockMemberListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HashMap<String, Object> ph() {
        Intent intent;
        byte[] byteArrayExtra;
        y45.b d16;
        String str;
        String str2;
        String l3;
        HashMap<String, Object> hashMap = new HashMap<>();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (byteArrayExtra = intent.getByteArrayExtra("key_feed")) != null && (d16 = y45.b.d(byteArrayExtra)) != null) {
            hashMap.put("publisher_event_results", d16.f449369d.f449450b);
            l lVar = d16.f449376k;
            if (lVar != null) {
                str = lVar.f449420b;
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "feed.poiInfo?.name ?: \"\"");
            }
            hashMap.put("activity_location", str);
            y45.a aVar = d16.f449374i;
            if (aVar == null || (str2 = Long.valueOf(aVar.f449361a).toString()) == null) {
                str2 = "";
            }
            hashMap.put("activity_start_time", str2);
            y45.a aVar2 = d16.f449374i;
            if (aVar2 != null && (l3 = Long.valueOf(aVar2.f449362b).toString()) != null) {
                str3 = l3;
            }
            hashMap.put("activity_end_time", str3);
            hashMap.put("activity_name", d16.f449371f);
            hashMap.put("activity_result_id", d16.f449366a);
            hashMap.put("participants_num", String.valueOf(d16.f449379n.f449416b));
            hashMap.put("group_id", String.valueOf(d16.f449367b));
        }
        return hashMap;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f());
        arrayList.add(new FlockMemberListPart());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public /* synthetic */ Activity getHostActivity() {
        return com.tencent.biz.richframework.part.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Context getHostContext() {
        return com.tencent.biz.richframework.part.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.IPartFragmentHost
    @NotNull
    public Fragment getHostFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Fragment) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    /* renamed from: getHostLifecycleOwner */
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return com.tencent.biz.richframework.part.a.c(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Object getViewTagData() {
        return ne0.a.d(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        new FragmentPartProvider(this).initProvider();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            inflate = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            b bVar = (b) getViewModel(this, null, b.class);
            this.flockMemberListViewModel = bVar;
            if (bVar != null) {
                bVar.P1(getArguments());
            }
            inflate = inflater.inflate(R.layout.e8l, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        VideoReport.setPageId(this, "pg_bas_sub_activity_participant_list");
        VideoReport.setPageParams(this, com.tencent.mobileqq.flock.datong.a.f210009a.b(ph()));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStart();
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        a aVar = (a) dialog;
        this.fragmentDialog = aVar;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentDialog");
            aVar = null;
        }
        View findViewById = aVar.findViewById(R.id.ugk);
        if (findViewById != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            Intrinsics.checkNotNullExpressionValue(from, "from(this)");
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (findViewById.getResources().getDisplayMetrics().heightPixels > i.b(172)) {
                i3 = findViewById.getResources().getDisplayMetrics().heightPixels - i.b(172);
            } else {
                i3 = (int) (findViewById.getResources().getDisplayMetrics().heightPixels * 0.8d);
            }
            layoutParams.height = i3;
            from.setPeekHeight(-1);
            from.setDraggable(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
