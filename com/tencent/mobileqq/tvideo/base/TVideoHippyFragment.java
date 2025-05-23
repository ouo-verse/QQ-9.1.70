package com.tencent.mobileqq.tvideo.base;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment;
import com.tencent.mobileqq.tvideo.event.TVideoMultiTabPageBackEvent;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoHippyFragment extends QCircleCommonHippyFragment implements SimpleEventReceiver {
    public static TVideoHippyFragment Eh(String str, HashMap<String, String> hashMap) {
        TVideoHippyFragment tVideoHippyFragment = new TVideoHippyFragment();
        Bundle bundle = new Bundle();
        bundle.putBundle("params", com.tencent.mobileqq.tvideo.hippy.a.a(str, hashMap));
        tVideoHippyFragment.setArguments(bundle);
        return tVideoHippyFragment;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<Class>() { // from class: com.tencent.mobileqq.tvideo.base.TVideoHippyFragment.1
            {
                add(TVideoMultiTabPageBackEvent.class);
            }
        };
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment, com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof TVideoMultiTabPageBackEvent) && isResumed() && getActivity() != null) {
            gy2.c.u(false, false);
            getActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment
    protected void addNightModeMask() {
    }
}
