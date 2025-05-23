package com.tencent.ecommerce.biz.hr.ktx;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.ecommerce.biz.hr.ECHippyRenderView;
import com.tencent.kuikly.core.render.android.d;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Li01/a;", "Lcom/tencent/ecommerce/biz/hr/ECHRFragment;", "b", "(Li01/a;)Lcom/tencent/ecommerce/biz/hr/ECHRFragment;", "hrFragment", "Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "a", "(Li01/a;)Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "ecHippyRenderView", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {
    public static final ECHippyRenderView a(i01.a aVar) {
        com.tencent.kuikly.core.render.android.a aVar2;
        d O0;
        ViewGroup view;
        ECHRFragment b16 = b(aVar);
        ECHippyRenderView ecHippyRenderView = b16 != null ? b16.getEcHippyRenderView() : null;
        if (ecHippyRenderView != null || (aVar2 = aVar.get_kuiklyRenderContext()) == null || (O0 = aVar2.O0()) == null || (view = O0.getView()) == null) {
            return ecHippyRenderView;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ECHippyRenderView) {
                return (ECHippyRenderView) parent;
            }
        }
        return ecHippyRenderView;
    }

    public static final ECHRFragment b(i01.a aVar) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        Activity activity = aVar.getActivity();
        if (!(activity instanceof FragmentActivity)) {
            activity = null;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof ECHRFragment) {
                    return (ECHRFragment) fragment;
                }
            }
        }
        return null;
    }
}
