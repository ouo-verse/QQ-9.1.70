package com.tencent.biz.qqcircle.tedgers2.bean;

import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeAction$Action;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.proto.TEdgeEvent$Event;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSEdgeAction extends EdgeAction {
    public final TEdgeAction$Action mAction;
    public long pageRefreshToken;

    public QFSEdgeAction(TEdgeAction$Action tEdgeAction$Action) {
        this.mAction = tEdgeAction$Action;
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeAction
    public ArrayList<TEdgeEvent$Event> getEvents() {
        if (this.mAction == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(this.mAction.events.get());
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeAction
    public String getItemID() {
        TEdgeAction$Action tEdgeAction$Action = this.mAction;
        if (tEdgeAction$Action != null) {
            return tEdgeAction$Action.item_id.get();
        }
        return "";
    }

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        TEdgeAction$Action tEdgeAction$Action = this.mAction;
        if (tEdgeAction$Action == null) {
            return new byte[0];
        }
        return tEdgeAction$Action.toByteArray();
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeAction
    public void setEvents(ArrayList<TEdgeEvent$Event> arrayList) {
        TEdgeAction$Action tEdgeAction$Action = this.mAction;
        if (tEdgeAction$Action != null) {
            tEdgeAction$Action.events.set(arrayList);
        }
    }
}
