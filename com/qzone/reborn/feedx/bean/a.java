package com.qzone.reborn.feedx.bean;

import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.tencent.mobileqq.utils.bl;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private CellCommentInfo f54738a;

    /* renamed from: b, reason: collision with root package name */
    private CellCommentEssence f54739b;

    public a(CellCommentInfo cellCommentInfo) {
        this.f54738a = cellCommentInfo;
    }

    public CellCommentEssence a() {
        return this.f54739b;
    }

    public CellCommentInfo b() {
        return this.f54738a;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QZoneFeedDetailMoreCommentInfo{mCommentInfo.commentSize = ");
        CellCommentInfo cellCommentInfo = this.f54738a;
        sb5.append(cellCommentInfo != null ? Integer.valueOf(bl.d(cellCommentInfo.commments)) : null);
        sb5.append(", mCellCommentEssence.commentSize=");
        CellCommentEssence cellCommentEssence = this.f54739b;
        sb5.append(cellCommentEssence != null ? Integer.valueOf(bl.d(cellCommentEssence.commments)) : null);
        sb5.append('}');
        return sb5.toString();
    }

    public a(CellCommentEssence cellCommentEssence) {
        this.f54739b = cellCommentEssence;
    }
}
