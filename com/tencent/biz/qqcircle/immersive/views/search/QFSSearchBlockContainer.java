package com.tencent.biz.qqcircle.immersive.views.search;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import g80.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchBlockContainer extends BlockContainer {
    public QFSSearchBlockContainer(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    protected BlockMerger createBlockMerger() {
        return new a(this);
    }

    public QFSSearchBlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
