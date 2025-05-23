package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.immersive.events.QFSFriendFooterViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ge extends u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private View f88161d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f88162e;

    /* renamed from: f, reason: collision with root package name */
    private int f88163f;

    private void A9(View view) {
        this.f88162e = (ViewStub) view.findViewById(R.id.f41931ie);
    }

    private void B9(boolean z16) {
        int i3;
        ViewStub viewStub = this.f88162e;
        if (viewStub == null) {
            return;
        }
        if (this.f88161d == null) {
            this.f88161d = viewStub.inflate();
        }
        View view = this.f88161d;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void x9(QFSFriendFooterViewEvent qFSFriendFooterViewEvent) {
        if (this.f88163f != 9) {
            return;
        }
        B9(qFSFriendFooterViewEvent.mIsPulling);
    }

    private void z9(QFSPageSelectEvent qFSPageSelectEvent) {
        int i3 = qFSPageSelectEvent.mSelectTabType;
        this.f88163f = i3;
        if (i3 != 9 && this.f88161d != null) {
            B9(false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPageSelectEvent.class);
        arrayList.add(QFSFriendFooterViewEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QFSTopShadowPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        A9(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFriendFooterViewEvent) {
            x9((QFSFriendFooterViewEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSPageSelectEvent) {
            z9((QFSPageSelectEvent) simpleBaseEvent);
        }
    }
}
