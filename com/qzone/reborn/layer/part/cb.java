package com.qzone.reborn.layer.part;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cb extends QZoneFeedxLayerSharePart {
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Aa(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.ab(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ba(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.ac(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Fa(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.ad(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ga(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.ae(getActivity()).t(ta(), actionSheetItem);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean V9(boolean z16) {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean ha() {
        return true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    public boolean ia() {
        return true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void va(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        new com.qzone.reborn.layer.share.a(getActivity()).t(ta(), actionSheetItem);
    }
}
