package com.tencent.biz.qqcircle.bizparts;

import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bq extends ai {
    @Override // com.tencent.biz.qqcircle.bizparts.ai
    protected boolean S9() {
        if (getContext() == null) {
            return false;
        }
        return !com.tencent.biz.qqcircle.helpers.i.f84624a.a(String.valueOf(r0.hashCode()));
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ai
    public int U9() {
        return R.id.f4853209;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ai
    public int V9() {
        return R.id.f485820d;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ai
    public int X9() {
        return R.id.f485920e;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ai, com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QFSPersonalVideoAnimPart";
    }
}
