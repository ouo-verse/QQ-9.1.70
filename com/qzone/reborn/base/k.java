package com.qzone.reborn.base;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class k extends Part {
    private boolean A9() {
        return false;
    }

    private boolean z9() {
        return lm.a.f414989a.h(this);
    }

    public void B9(Intent intent, int i3) {
        if ((getPartHost() instanceof Fragment) && com.qzone.reborn.configx.g.f53821a.l().k()) {
            ((Fragment) getPartHost()).startActivityForResult(intent, i3);
        } else if (getActivity() != null) {
            getActivity().startActivityForResult(intent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getIocInterface(Class<T> cls) {
        return (T) PartIOCKt.getIocInterface(this, cls);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return (A9() || z9()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(View view, Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, view, obj, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterIoc(Class<?> cls) {
        PartIOCKt.unregisterIoc(this, cls);
    }

    public <T extends ViewModel> T x9(Class<T> cls) {
        if (getPartHost() instanceof Fragment) {
            Fragment fragment = (Fragment) getPartHost();
            if (fragment.getParentFragment() instanceof QZoneBaseFragment) {
                return (T) ((QZoneBaseFragment) fragment.getParentFragment()).getViewModel(cls);
            }
        }
        RFWLog.fatal(getLogTag(), RFWLog.USR, new RuntimeException("getOuterViewModel error: " + getPartHost()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, obj, cls);
    }
}
