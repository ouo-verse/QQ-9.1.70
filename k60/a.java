package k60;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.QCircleVideoSeekHelper;
import java.util.ArrayList;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u implements SimpleEventReceiver {

    /* renamed from: f, reason: collision with root package name */
    private static final int f411722f = cx.a(56.0f);

    /* renamed from: d, reason: collision with root package name */
    private boolean f411723d;

    /* renamed from: e, reason: collision with root package name */
    private View f411724e;

    public a(boolean z16) {
        this.f411723d = z16;
    }

    private void x9(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (this.f411724e == null) {
            return;
        }
        int panelType = qCirclePanelStateEvent.getPanelType();
        if (panelType != 0 && panelType != 26 && panelType != 29 && panelType != 40) {
            return;
        }
        if (qCirclePanelStateEvent.isShowing()) {
            QCircleVideoSeekHelper.removeSeekArea(this.f411724e);
        } else {
            QCircleVideoSeekHelper.addSeekView(this.f411724e, f411722f);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSVideoSeekAreaPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (this.f411723d && c.s0() && c.d2()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (this.f411723d) {
            this.f411724e = ((Activity) getContext()).findViewById(R.id.ckj);
        } else {
            this.f411724e = getPartRootView();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        QCircleVideoSeekHelper.addSeekView(this.f411724e, f411722f);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            x9((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }
}
