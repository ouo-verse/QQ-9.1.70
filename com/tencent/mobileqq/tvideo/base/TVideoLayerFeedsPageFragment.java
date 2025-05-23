package com.tencent.mobileqq.tvideo.base;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEntranceVisibleEvent;
import com.tencent.mobileqq.tvideo.event.TVideoMultiTabPageBackEvent;
import com.tencent.mobileqq.tvideo.parts.ab;
import com.tencent.mobileqq.tvideo.parts.ag;
import com.tencent.mobileqq.tvideo.parts.ak;
import com.tencent.mobileqq.tvideo.parts.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes19.dex */
public class TVideoLayerFeedsPageFragment extends QFSLayerTVideoPageFragment {
    private volatile int J = 1;

    private void Th() {
        if (!super.onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList<Part>() { // from class: com.tencent.mobileqq.tvideo.base.TVideoLayerFeedsPageFragment.1
            {
                add(new ak((QCircleLayerBean) TVideoLayerFeedsPageFragment.this.getInitBean(), TVideoLayerFeedsPageFragment.this.J));
                add(new ab());
                add(new o((QCircleLayerBean) TVideoLayerFeedsPageFragment.this.getInitBean()));
                if (qx2.a.c().l()) {
                    add(new ag(com.tencent.mobileqq.tvideo.viewmodel.g.class));
                }
            }
        };
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.ggo;
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(TVideoMultiTabPageBackEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoLayerFeedsPageFragment";
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.J = arguments.getInt("channelId", 1);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowEntranceVisibleEvent(false));
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TVideoMultiTabPageBackEvent) {
            if (isResumed()) {
                Th();
                return;
            }
            return;
        }
        super.onReceiveEvent(simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        gy2.a.b(4);
    }
}
