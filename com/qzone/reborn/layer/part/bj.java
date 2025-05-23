package com.qzone.reborn.layer.part;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bj extends QZoneFeedxLayerSharePart {
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void va(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.a(getActivity()).t(ta(), actionSheetItem);
    }
}
