package com.tencent.mobileqq.vas.pendant.drawable.bean;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.pendant.proto.qcSubmallServer;
import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;

/* loaded from: classes20.dex */
public class AvatarPendantItem {
    public static final int APPID_AVATAR = 23;
    public static final int APPID_PENDANT = 4;
    public static final int APPID_SIGNATURE = 9;
    public int appid;
    public int discountPrice;
    public int discountReason;
    public int feeType;
    public String imageUrl;
    public boolean isSetup;
    public String itemBgColor;
    public int itemId;
    public String jumpUrl;
    public long nValue;
    public String name;
    public String operateId;
    public int price;
    public String strRuleid;
    public boolean userCanDiscount;
    public ZplanAvatarInfo zplanAvatarInfo;

    /* loaded from: classes20.dex */
    public static class ZplanAvatarInfo {
        public String avatarPath;
        public int coverIndex;
        public String featureKey;
        public String iconUrl;
        public boolean isDynamic;
        public int mode;
        public int portraitId;
    }

    public AvatarPendantItem() {
    }

    public AvatarPendantItem(@NonNull qcUserinfoServer.SplendidItem splendidItem) {
        this.nValue = splendidItem.value_n.get();
        this.operateId = splendidItem.operate_id.get();
        this.appid = 23;
        this.itemId = splendidItem.item_detail.itemId.get();
        this.price = splendidItem.item_detail.extrainfo.price.get();
        this.feeType = splendidItem.item_detail.feeType.get();
        this.name = splendidItem.item_detail.name.get();
        this.itemBgColor = splendidItem.item_detail.itemBgColor.get();
        this.imageUrl = splendidItem.item_detail.image.get();
        this.isSetup = splendidItem.item_detail.isSetup.get() != 0;
    }

    public AvatarPendantItem(qcSubmallServer.SubmallPreviewItem submallPreviewItem, String str) {
        this.appid = submallPreviewItem.appId.get();
        this.itemId = submallPreviewItem.itemId.get();
        this.name = submallPreviewItem.name.get();
        this.feeType = submallPreviewItem.feeType.get();
        this.itemBgColor = submallPreviewItem.itemBgColor.get();
        this.imageUrl = submallPreviewItem.image.get();
        this.price = submallPreviewItem.extrainfo.price.get();
        this.isSetup = submallPreviewItem.isSetup.get() != 0;
        this.strRuleid = str;
        this.jumpUrl = submallPreviewItem.jumpUrl.get();
        this.discountReason = submallPreviewItem.discountInfo.itemDiscount.type.get();
        this.discountPrice = submallPreviewItem.discountInfo.itemDiscount.discountPrice.get();
        this.userCanDiscount = submallPreviewItem.discountInfo.itemDiscount.userCanDiscount.get();
    }
}
