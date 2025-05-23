package com.tencent.biz.richframework.ioc;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.lifecycle.RFWViewLifecycleUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LifecycleIocManagerRetriever implements LifecycleEventObserver {
    private static volatile LifecycleIocManagerRetriever sInstance;
    private final Map<Integer, List<Pair<Integer, String>>> mLifecycleToIocMap = new HashMap();

    public static LifecycleIocManagerRetriever g() {
        if (sInstance == null) {
            synchronized (LifecycleIocManagerRetriever.class) {
                if (sInstance == null) {
                    sInstance = new LifecycleIocManagerRetriever();
                }
            }
        }
        return sInstance;
    }

    public void addViewLifecycle(View view, int i3, String str) {
        LifecycleOwner viewLifecycleOwner;
        if (view == null || TextUtils.isEmpty(str) || (viewLifecycleOwner = RFWViewLifecycleUtil.getViewLifecycleOwner(view, false)) == null) {
            return;
        }
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        lifecycle.addObserver(this);
        List<Pair<Integer, String>> list = this.mLifecycleToIocMap.get(Integer.valueOf(lifecycle.hashCode()));
        if (list == null) {
            list = new ArrayList<>();
            this.mLifecycleToIocMap.put(Integer.valueOf(lifecycle.hashCode()), list);
        }
        list.add(new Pair<>(Integer.valueOf(i3), str));
        RFWLog.i("qioc-LifecycleIocManagerRetriever", RFWLog.USR, "addViewLifecycle   | lifecycle = " + lifecycle + " | pageKey = " + i3 + " | iocKey = " + str);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.removeObserver(this);
        List<Pair<Integer, String>> remove = this.mLifecycleToIocMap.remove(Integer.valueOf(lifecycle.hashCode()));
        if (remove == null) {
            return;
        }
        for (Pair<Integer, String> pair : remove) {
            RFWIocAbilityProvider.g().getIocInterfaceCenter().removeSingleIoc(((Integer) pair.first).intValue(), (String) pair.second);
        }
    }
}
