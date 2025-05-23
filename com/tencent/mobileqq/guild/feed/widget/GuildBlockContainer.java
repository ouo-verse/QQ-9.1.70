package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBlockContainer extends BlockContainer {
    public GuildBlockContainer(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GuildBlockMerger getBlockMerger() {
        return (GuildBlockMerger) super.getBlockMerger();
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    protected BlockMerger createBlockMerger() {
        return new GuildBlockMerger(this);
    }

    public GuildBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public GuildBlockContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
