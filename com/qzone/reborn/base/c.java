package com.qzone.reborn.base;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends BlockPart {
    public c(int i3, List<MultiViewBlock> list) {
        super(i3, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getIocInterface(Class<T> cls) {
        return (T) PartIOCKt.getIocInterface(this, cls);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    protected BlockContainer initBlockContainer(Context context) {
        return new QZoneBaseBlockContainer(context);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(Object obj, Class<?> cls) {
        PartIOCKt.registerIoc(this, obj, cls);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    /* renamed from: x9, reason: merged with bridge method [inline-methods] */
    public QZoneBaseBlockContainer getBlockContainer() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            return (QZoneBaseBlockContainer) blockContainer;
        }
        return null;
    }

    public <T extends ViewModel> T z9(Class<T> cls) {
        if (getPartHost() instanceof Fragment) {
            Fragment fragment = (Fragment) getPartHost();
            if (fragment.getParentFragment() instanceof QZoneBaseFragment) {
                return (T) ((QZoneBaseFragment) fragment.getParentFragment()).getViewModel(cls);
            }
        }
        RFWLog.fatal(getTAG(), RFWLog.USR, new RuntimeException("getOuterViewModel error: " + getPartHost()));
        return null;
    }
}
