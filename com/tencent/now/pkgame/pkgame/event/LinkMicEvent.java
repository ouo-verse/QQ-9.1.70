package com.tencent.now.pkgame.pkgame.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.now.pkgame.pkgame.sei.Pos;
import go3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LinkMicEvent extends SimpleBaseEvent {
    protected a linkMicBean;
    protected int linkType;

    public LinkMicEvent(int i3, a aVar) {
        this.linkType = i3;
        this.linkMicBean = aVar;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public Pos getPos() {
        a aVar = this.linkMicBean;
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public long getRoomId() {
        a aVar = this.linkMicBean;
        if (aVar == null) {
            return 0L;
        }
        return aVar.c();
    }

    public boolean isLinkMicOn() {
        a aVar = this.linkMicBean;
        if (aVar == null) {
            return false;
        }
        return aVar.e();
    }
}
