package com.tencent.biz.richframework.hook.instrumentation;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.hook.util.RFWFieldUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HookedInstrumentation extends Instrumentation {
    protected Instrumentation mBase;
    protected Context mContext;
    protected List<InnerInstrumentationDelegate> mDelegates;

    public HookedInstrumentation(Context context, Instrumentation instrumentation, @NonNull List<InnerInstrumentationDelegate> list) {
        ArrayList arrayList = new ArrayList();
        this.mDelegates = arrayList;
        this.mContext = context;
        this.mBase = instrumentation;
        arrayList.addAll(list);
    }

    public static boolean hookInstrumentation(Context context, List<InnerInstrumentationDelegate> list) {
        if (list != null && list.size() != 0) {
            try {
                Object obj = RFWFieldUtil.getField(Class.forName("android.app.ContextImpl"), "mMainThread").get(context);
                Class<?> cls = Class.forName("android.app.ActivityThread");
                RFWFieldUtil.setField(cls, obj, "mInstrumentation", new HookedInstrumentation(context, (Instrumentation) RFWFieldUtil.getField(cls, "mInstrumentation").get(obj), list));
                return true;
            } catch (Exception e16) {
                RFWLog.e("HookedInstrumentation", RFWLog.USR, "hookInstrumentation failed", e16);
            }
        }
        return false;
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Iterator<InnerInstrumentationDelegate> it = this.mDelegates.iterator();
        while (it.hasNext()) {
            Activity newActivity = it.next().newActivity(this.mContext, this.mBase, classLoader, str, intent);
            if (newActivity != null) {
                return newActivity;
            }
        }
        return this.mBase.newActivity(classLoader, str, intent);
    }
}
