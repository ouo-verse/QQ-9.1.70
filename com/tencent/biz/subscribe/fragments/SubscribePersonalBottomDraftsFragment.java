package com.tencent.biz.subscribe.fragments;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.d;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.part.block.a;

/* loaded from: classes5.dex */
public class SubscribePersonalBottomDraftsFragment extends SubscribeBaseBottomPersonalFragment {
    private ExtraTypeInfo G;
    private d H;

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    protected void initView() {
        d dVar = new d(null);
        this.H = dVar;
        this.D.n(dVar);
        this.D.p();
        this.H.i0();
        SubscribeBaseBottomPersonalFragment.a aVar = this.E;
        if (aVar != null) {
            this.H.f0("share_key_subscribe_opus", new a.d(aVar));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SimpleEventBus.getInstance().dispatchEvent(new SubDraftChangeEvent());
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    ExtraTypeInfo ph() {
        ExtraTypeInfo extraTypeInfo;
        if (getBaseActivity() != null && getBaseActivity().getIntent() != null) {
            extraTypeInfo = (ExtraTypeInfo) getBaseActivity().getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
        } else {
            extraTypeInfo = null;
        }
        if (extraTypeInfo == null) {
            extraTypeInfo = new ExtraTypeInfo();
        }
        ExtraTypeInfo extraTypeInfo2 = new ExtraTypeInfo(7005, extraTypeInfo.sourceType);
        this.G = extraTypeInfo2;
        return extraTypeInfo2;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    public void rh(String str, SubscribeBaseBottomPersonalFragment.a aVar) {
        if ("share_key_subscribe_opus".equals(str)) {
            this.E = aVar;
            d dVar = this.H;
            if (dVar != null) {
                dVar.f0("share_key_subscribe_opus", new a.d(aVar));
            }
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    public void qh(int i3) {
    }
}
