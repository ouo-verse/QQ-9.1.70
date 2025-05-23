package com.tencent.pts.core;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil;
import java.util.List;

/* loaded from: classes22.dex */
public interface IPTSRootNodeDelegate {
    boolean animation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo);

    View getRootView();

    boolean insert(PTSNodeInfo pTSNodeInfo, int i3);

    boolean modify(PTSNodeInfo pTSNodeInfo);

    View onCreateNativeView();

    void onLayoutTempPatchFinished();

    boolean refreshNodeList(List<PTSNodeInfo> list);

    boolean remove(int i3);

    void setRootView(ViewGroup viewGroup);
}
