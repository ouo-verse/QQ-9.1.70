package com.tencent.tuxmeterqui.question.matrix;

import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.SubTitle;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface OnMatrixItemClickListener {
    void onItemClick(SubTitle subTitle, List<Option> list);

    void onLimitClick(SubTitle subTitle, int i3);
}
