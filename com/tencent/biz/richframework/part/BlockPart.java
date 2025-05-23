package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes5.dex */
public class BlockPart extends Part {
    public static final String TAG = "BlockPart";
    protected BlockContainer mBlockContainer;
    private boolean mEnablePageRecyclerViewPool;
    private final int mLayoutType;
    private final int mMostSpanCount;
    private final int mPeerBlockFindViewId;
    protected final ArrayList<MultiViewBlock> mPeerBlocks;

    public BlockPart() {
        this(0);
    }

    public BlockContainer getBlockContainer() {
        return this.mBlockContainer;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    public ArrayList<MultiViewBlock> getPeerBlocks() {
        return this.mPeerBlocks;
    }

    public IStatusViewProvider getStatusViewProvider() {
        if (getBlockContainer() != null) {
            return getBlockContainer().getStatusInterface();
        }
        return null;
    }

    protected BlockContainer initBlockContainer(Context context) {
        return new BlockContainer(context);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (getBlockContainer() != null && getBlockContainer().onBackEvent()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onInitView(View view) {
        super.onInitView(view);
        int i3 = this.mPeerBlockFindViewId;
        if (i3 != 0) {
            this.mBlockContainer = (BlockContainer) view.findViewById(i3);
        }
        if (this.mBlockContainer == null) {
            this.mBlockContainer = initBlockContainer(view.getContext());
        }
        this.mBlockContainer.setEnablePageRecyclerViewPool(this.mEnablePageRecyclerViewPool);
        this.mBlockContainer.setLayoutManagerType(this.mLayoutType, this.mMostSpanCount);
        this.mBlockContainer.setBlockWrapper(this);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.registerBlock(this.mPeerBlocks);
        this.mBlockContainer.start();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    @CallSuper
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onPartDestroy(activity);
        }
        if (getBlockContainer() != null) {
            getBlockContainer().onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartPause(Activity activity) {
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onPartPause(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartResume(Activity activity) {
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onPartResume(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onPartSaveInstanceState(activity, bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartStart(Activity activity) {
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onPartStart(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartStop(Activity activity) {
        if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
            getBlockContainer().getBlockMerger().onPartStop(activity);
        }
    }

    public void setEnablePageRecyclerViewPool(boolean z16) {
        this.mEnablePageRecyclerViewPool = z16;
        if (getBlockContainer() != null) {
            getBlockContainer().setEnablePageRecyclerViewPool(z16);
        }
    }

    public BlockPart(int i3) {
        this(i3, null);
    }

    public BlockPart(int i3, List<MultiViewBlock> list) {
        this(i3, list, 3, 1);
    }

    public BlockPart(int i3, List<MultiViewBlock> list, int i16, int i17) {
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        this.mPeerBlocks = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.mLayoutType = i16;
        this.mMostSpanCount = i17;
        this.mPeerBlockFindViewId = i3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
    }
}
