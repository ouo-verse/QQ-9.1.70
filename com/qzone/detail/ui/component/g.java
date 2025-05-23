package com.qzone.detail.ui.component;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g extends ShareActionSheetV2 {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends ShareActionSheetV2.Param {
    }

    public g(a aVar) {
        super(aVar);
    }

    public ShareActionSheetBuilder.ActionSheetItem o0(int i3) {
        List<ShareActionSheetBuilder.ActionSheetItem>[] listArr = this.W;
        if (listArr == null) {
            return null;
        }
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : listArr) {
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
                if (actionSheetItem.action == i3) {
                    return actionSheetItem;
                }
            }
        }
        return null;
    }

    public ShareActionSheetBuilder.ActionSheetItem p0(int i3) {
        List<ShareActionSheetBuilder.ActionSheetItem>[] listArr = this.W;
        if (listArr == null) {
            return null;
        }
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : listArr) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = list.get(size);
                if (actionSheetItem.action == i3) {
                    list.remove(size);
                    return actionSheetItem;
                }
            }
        }
        return null;
    }

    public boolean q0(int i3, int i16) {
        return r0(i3, ShareActionSheetBuilder.ActionSheetItem.build(i16));
    }

    public void s0(int i3, boolean z16) {
        ShareActionSheetBuilder.ActionSheetItem o06 = o0(i3);
        if (o06 != null) {
            o06.enable = z16;
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] listArr) {
        super.setActionSheetItems(listArr);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    @Deprecated
    public void updateUI() {
        super.updateUI();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2, com.tencent.mobileqq.widget.share.ShareActionSheet
    @Deprecated
    public void updateUIIfShowing() {
        super.updateUIIfShowing();
    }

    public boolean r0(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        List<ShareActionSheetBuilder.ActionSheetItem>[] listArr;
        if (actionSheetItem == null || (listArr = this.W) == null) {
            return false;
        }
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : listArr) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size).action == i3) {
                    list.remove(size);
                    list.add(size, actionSheetItem);
                    return true;
                }
            }
        }
        return true;
    }
}
