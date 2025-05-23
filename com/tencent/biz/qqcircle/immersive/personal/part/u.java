package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalGuildInfoEmptyEvent;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    public static final String f88945e = "com.tencent.biz.qqcircle.immersive.personal.part.u";

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f88946d;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(u.this.getContext(), 0, new Bundle());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void x9(QFSPersonalGuildInfoEmptyEvent qFSPersonalGuildInfoEmptyEvent) {
        int i3;
        FrameLayout frameLayout = this.f88946d;
        if (frameLayout != null) {
            if (qFSPersonalGuildInfoEmptyEvent.isEmpty) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalGuildInfoEmptyEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return f88945e;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f4852208);
        this.f88946d = frameLayout;
        frameLayout.addView(new QUIEmptyState.Builder(getContext()).setImageType(16).setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f19268486)).setDesc(com.tencent.biz.qqcircle.utils.h.a(R.string.f1927248_)).setButton(com.tencent.biz.qqcircle.utils.h.a(R.string.f19267485), new a()).setBackgroundColorType(0).build());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPersonalGuildInfoEmptyEvent) {
            x9((QFSPersonalGuildInfoEmptyEvent) simpleBaseEvent);
        }
    }
}
