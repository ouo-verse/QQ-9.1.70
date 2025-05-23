package com.qzone.reborn.feedpro.block;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.reborn.base.QZoneBaseBlockContainer;

/* loaded from: classes37.dex */
public class QzoneFeedProDetailBlockContainer extends QZoneBaseBlockContainer {
    public QzoneFeedProDetailBlockContainer(Context context) {
        super(context);
    }

    @Override // com.qzone.reborn.base.QZoneBaseBlockContainer, com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: a */
    public com.qzone.reborn.base.b createBlockMerger() {
        return new g(this);
    }

    public QzoneFeedProDetailBlockContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
