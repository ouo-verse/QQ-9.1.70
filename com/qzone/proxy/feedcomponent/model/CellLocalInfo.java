package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLocalInfo implements SmartParcelable {
    public static final int BOTTOM_CONTAINER_SHOW_TYPE_DEFAULT = 0;
    public static final int BOTTOM_CONTAINER_SHOW_TYPE_DISMISS = 2;
    public static final int BOTTOM_CONTAINER_SHOW_TYPE_SHOW = 1;
    public static final int FAKE = 0;
    public static final int HALF_REAL = 1;
    public static final int NEVER_DELETE = 3;
    public static final int REAL = 2;
    public static final int SOFT_FAKE = 4;

    @NeedParcel
    public boolean canComment;

    @NeedParcel
    public boolean canDel;

    @NeedParcel
    public boolean canDelComment;

    @NeedParcel
    public boolean canDelReply;

    @NeedParcel
    public boolean canDownloadOrCallApp;

    @NeedParcel
    public boolean canForward;

    @NeedParcel
    public boolean canHuNuan;

    @NeedParcel
    public boolean canJoinAlbum;

    @NeedParcel
    public boolean canLike;

    @NeedParcel
    public boolean canLookUp;

    @NeedParcel
    public boolean canQuote;

    @NeedParcel
    public boolean canReferComment;

    @NeedParcel
    public boolean canReferReply;

    @NeedParcel
    public boolean canReply;

    @NeedParcel
    public boolean canReturnGift;

    @NeedParcel
    public boolean canShare;

    @NeedParcel
    public int dbPriority;

    @NeedParcel
    public boolean joinedAlbum;

    @NeedParcel
    public String spaceId;

    @NeedParcel
    public int fakeType = 2;
    public int operScene = -1;

    @NeedParcel
    public boolean hasModifiedFakeType = false;

    @NeedParcel
    public int showBottomContainer = 0;

    @NeedParcel
    public String videoLocalUrl = "";

    public boolean isFake() {
        return this.fakeType == 0;
    }

    public boolean isFakeSafe() {
        return isFake() || isSoftFake();
    }

    public boolean isHalfReal() {
        return this.fakeType == 1;
    }

    public boolean isModifiedFakeType() {
        return this.hasModifiedFakeType;
    }

    public boolean isNotReal() {
        return this.fakeType != 2;
    }

    public boolean isReal() {
        return this.fakeType == 2;
    }

    public boolean isSoftFake() {
        return this.fakeType == 4;
    }

    public String toString() {
        return "CellLocalInfo {\ncanComment: " + this.canComment + "\ncanReply: " + this.canReply + "\ncanReferReply: " + this.canReferReply + "\ncanLike: " + this.canLike + "\ncanForward: " + this.canForward + "\ncanShare: " + this.canShare + "\ncanReferComment: " + this.canReferComment + "\ncanReturnGift: " + this.canReturnGift + "\ncanQuote: " + this.canQuote + "\ndbPriority: " + this.dbPriority + "\ncanLookUp: " + this.canLookUp + "\ncanJoinAlbum: " + this.canJoinAlbum + "\njoinedAlbum: " + this.joinedAlbum + "\n}";
    }

    public void setFake() {
        this.fakeType = 0;
        lg.d dVar = lg.d.f414454a;
        if (dVar.g()) {
            if (!dVar.o()) {
                QLog.d("QZoneFeedBottomContainer", 2, "new fake feed but can't show bottom container,because limit frequency");
            } else {
                setShowBottomContainer(1);
                QLog.d("QZoneFeedBottomContainer", 2, "new fake feed set show bottom container flag");
            }
        }
    }

    public void setHalfReal() {
        this.fakeType = 1;
    }

    public void setModifiedFlag() {
        this.hasModifiedFakeType = true;
    }

    public void setReal() {
        this.fakeType = 2;
        setShowBottomContainer(2);
    }

    public void setSoftFake() {
        this.fakeType = 4;
    }

    public void setShowBottomContainer(int i3) {
        if ((i3 == 1 && this.showBottomContainer == 2) || com.qzone.reborn.util.k.f59549a.g()) {
            return;
        }
        this.showBottomContainer = i3;
    }

    public static CellLocalInfo create(l lVar) {
        if (lVar == null) {
            return null;
        }
        CellLocalInfo cellLocalInfo = new CellLocalInfo();
        if (lVar.f50340a != null) {
            cellLocalInfo.canComment = com.qzone.proxy.feedcomponent.util.d.j(r1.operatemask, 3);
            cellLocalInfo.canForward = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 1);
            cellLocalInfo.canLike = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 0);
            cellLocalInfo.canReply = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 5);
            cellLocalInfo.canShare = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 2);
            cellLocalInfo.canReturnGift = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 8);
            cellLocalInfo.canReferReply = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 6);
            cellLocalInfo.canQuote = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 7);
            cellLocalInfo.canReferComment = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 4);
            cellLocalInfo.canDel = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 10);
            cellLocalInfo.canDelComment = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 15);
            cellLocalInfo.canDelReply = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 16);
            cellLocalInfo.canDownloadOrCallApp = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask, 19);
            cellLocalInfo.canLookUp = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask2, 11);
            cellLocalInfo.canJoinAlbum = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask2, 13);
            cellLocalInfo.joinedAlbum = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask2, 14);
            cellLocalInfo.canHuNuan = com.qzone.proxy.feedcomponent.util.d.j(lVar.f50340a.operatemask2, 31);
        }
        return cellLocalInfo;
    }
}
