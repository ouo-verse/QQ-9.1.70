package com.tencent.ecommerce.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u00020\u000b*\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/c;", "", "Landroidx/fragment/app/Fragment;", "", "b", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "fragment", "", "c", "d", "", "", "Landroid/app/Activity;", "a", "Ljava/util/Map;", "singletonActivityMap", "(Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;)Ljava/lang/String;", "businessId", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f100710b = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Activity> singletonActivityMap = new LinkedHashMap();

    c() {
    }

    private final String a(ECBaseFragment eCBaseFragment) {
        return Reflection.getOrCreateKotlinClass(eCBaseFragment.getClass()).getQualifiedName() + util.base64_pad_url + eCBaseFragment.getTAG();
    }

    private final boolean b(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        return Intrinsics.areEqual("1", arguments != null ? arguments.getString("single_mode") : null);
    }

    public final void c(ECBaseFragment fragment) {
        if (b(fragment)) {
            Map<String, Activity> map = singletonActivityMap;
            Activity activity = map.get(a(fragment));
            if (activity != null) {
                activity.finish();
            }
            map.put(a(fragment), fragment.requireActivity());
        }
    }

    public final void d(ECBaseFragment fragment) {
        Map<String, Activity> map;
        Activity activity;
        if (b(fragment) && (activity = (map = singletonActivityMap).get(a(fragment))) != null && activity.isFinishing()) {
            map.remove(a(fragment));
        }
    }
}
