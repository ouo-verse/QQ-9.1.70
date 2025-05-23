package com.qzone.reborn.feedx.block;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.reborn.base.QZoneBaseBlockContainer;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxDetailBlockContainer extends QZoneBaseBlockContainer {
    public QZoneFeedxDetailBlockContainer(Context context) {
        super(context);
    }

    @Override // com.qzone.reborn.base.QZoneBaseBlockContainer, com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: a */
    public com.qzone.reborn.base.b createBlockMerger() {
        return new i(this);
    }

    public QZoneFeedxDetailBlockContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
