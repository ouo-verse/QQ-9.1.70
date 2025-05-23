package com.tencent.mobileqq.gamecenter.qa.model;

import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/model/LinkType;", "", "Ljava/io/Serializable;", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "REFERENCE_TYPE_LINK", "REFERENCE_TYPE_NOVEL", "REFERENCE_TYPE_QA", "REFERENCE_TYPE_CHANNEL", "REFERENCE_TYPE_XWORLD", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public enum LinkType implements Serializable {
    REFERENCE_TYPE_LINK(0),
    REFERENCE_TYPE_NOVEL(1),
    REFERENCE_TYPE_QA(2),
    REFERENCE_TYPE_CHANNEL(3),
    REFERENCE_TYPE_XWORLD(4);

    private final int type;

    LinkType(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
