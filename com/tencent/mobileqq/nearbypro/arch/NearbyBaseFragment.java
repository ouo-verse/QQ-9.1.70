package com.tencent.mobileqq.nearbypro.arch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.part.a;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u001a\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010*\u001a\u00020\tR\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/arch/NearbyBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "", "ph", "", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/mobileqq/nearbypro/part/e;", "assembleParts", "rh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onDestroyView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r3", "bh", "Landroidx/lifecycle/LifecycleOwner;", "c9", "Landroid/content/Context;", "getContext", "key", "", "t5", "action", "e6", "setStatusBarImmersive", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/part/a;", "parentHost", "Ly92/a;", "D", "Ly92/a;", "pageNav", "<init>", "()V", "E", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class NearbyBaseFragment extends QPublicBaseFragment implements a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a parentHost;

    /* renamed from: D, reason: from kotlin metadata */
    private y92.a pageNav;

    private final boolean ph() {
        if (getPartManager() != null && getPartManager().onBackEvent()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<e> assembleParts() {
        List<e> rh5 = rh();
        Iterator<T> it = rh5.iterator();
        while (it.hasNext()) {
            ((e) it.next()).x9(this);
        }
        return rh5;
    }

    public void bh() {
        a aVar = this.parentHost;
        if (aVar != null) {
            aVar.r3();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.a
    @NotNull
    public LifecycleOwner c9() {
        LifecycleOwner hostLifecycleOwner = getHostLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        return hostLifecycleOwner;
    }

    @Override // com.tencent.mobileqq.nearbypro.part.a
    @Nullable
    public Object e6(@NotNull String action, @Nullable Object data) {
        Intrinsics.checkNotNullParameter(action, "action");
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            return partManager.getMessageFromPart(action, data);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.qqnt.aio.e
    @NotNull
    public Context getContext() {
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        return hostActivity;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        j.c().e(qh(), "onActivityResult");
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        aVar.e(requestCode, requestCode, data);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        j.c().e(qh(), "onBackEvent Start======");
        y92.a aVar = this.pageNav;
        y92.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        boolean a16 = aVar.a();
        j.c().e(qh(), "onBackEvent childConsume=" + a16);
        if (a16) {
            return true;
        }
        boolean ph5 = ph();
        j.c().e(qh(), "onBackEvent sefConsume=" + ph5);
        if (!ph5) {
            y92.a aVar3 = this.pageNav;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            } else {
                aVar2 = aVar3;
            }
            boolean d16 = aVar2.d();
            j.c().e(qh(), "onBackEvent backSubResult=" + d16);
            if (!d16) {
                j.c().e(qh(), "onBackEvent closeCurPage");
                bh();
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.pageNav == null) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
            this.pageNav = new y92.a(parentFragmentManager, simpleName);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j.c().e(qh(), MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        aVar.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        j.c().e(qh(), "onDestroyView");
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        j.c().e(qh(), MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        aVar.f();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        j.c().e(qh(), "onResume");
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        aVar.g();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        j.c().e(qh(), "onStart");
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        aVar.h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        j.c().e(qh(), DKHippyEvent.EVENT_STOP);
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        aVar.i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        j.c().e(qh(), DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        super.onViewCreated(view, savedInstanceState);
    }

    @NotNull
    public final String qh() {
        return "NearbyBaseFragment-" + getClass().getSimpleName();
    }

    public boolean r3() {
        y92.a aVar = this.pageNav;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageNav");
            aVar = null;
        }
        return aVar.d();
    }

    @NotNull
    public List<e> rh() {
        return new ArrayList();
    }

    public final void setStatusBarImmersive() {
        if (getQBaseActivity() != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
            ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.a
    public void t5(@NotNull String key, @Nullable Object data) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.mPartManager != null) {
            getPartManager().broadcastMessage(key, data);
        }
    }
}
