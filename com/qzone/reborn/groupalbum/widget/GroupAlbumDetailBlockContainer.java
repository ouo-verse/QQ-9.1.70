package com.qzone.reborn.groupalbum.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.base.b;
import com.qzone.reborn.feedx.block.i;
import fj.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class GroupAlbumDetailBlockContainer extends QZoneBaseBlockContainer {

    /* renamed from: e, reason: collision with root package name */
    private d f57146e;

    public GroupAlbumDetailBlockContainer(Context context) {
        super(context);
    }

    @Override // com.qzone.reborn.base.QZoneBaseBlockContainer, com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: a */
    public b createBlockMerger() {
        return new i(this);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    public RecyclerView.LayoutManager getLayoutManager() {
        return this.f57146e;
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    public void setLayoutManagerType(int i3, int i16) {
        d dVar = new d(getContext(), 1, false);
        this.f57146e = dVar;
        this.mRecyclerView.setLayoutManager(dVar);
        this.mBlockMerger.updateLayoutManager(this.f57146e);
    }

    public GroupAlbumDetailBlockContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
