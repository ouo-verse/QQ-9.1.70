package com.qzone.reborn.layer.part;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bq extends QZoneFeedxLayerSharePart {
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean X9() {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void va(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.a(getActivity()).t(ta(), actionSheetItem);
    }
}
