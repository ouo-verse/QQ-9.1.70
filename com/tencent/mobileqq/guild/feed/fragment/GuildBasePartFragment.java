package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public abstract class GuildBasePartFragment extends ImmersivePartFragment implements SimpleEventReceiver {
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedThemeChangeEvent.class);
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            qh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        if (ph()) {
            qh();
        }
    }

    protected boolean ph() {
        return false;
    }

    protected void qh() {
        if (getFragmentContentView() == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            getFragmentContentView().setBackgroundColor(getContext().getResources().getColor(R.color.bnr));
        } else {
            getFragmentContentView().setBackgroundColor(getContext().getResources().getColor(R.color.bns));
        }
    }
}
