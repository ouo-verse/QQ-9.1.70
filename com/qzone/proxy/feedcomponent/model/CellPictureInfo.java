package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_pic;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes39.dex */
public class CellPictureInfo implements SmartParcelable {
    public static final int BABY_ANONYMITY_TYPE_VALUE = 5;
    public static final int LOVE_ANONYMITY_TYPE_VALUE = 8;
    public static final int MULTI_ANONYMITY_TYPE_VALUE = 9;
    public static final String PICTURE_TAB = "picture";
    public static final int TRAVEL_ANONYMITY_TYPE_VALUE = 6;

    @NeedParcel
    public String actionurl;

    @NeedParcel
    public String albumanswer;

    @NeedParcel
    public String albumid;

    @NeedParcel
    public String albumname;

    @NeedParcel
    public int albumnum;

    @NeedParcel
    public String albumquestion;

    @NeedParcel
    public int albumrights;

    @NeedParcel
    public int albumshowmask;

    @NeedParcel
    public int albumtype;

    @NeedParcel
    public int allow_share;

    @NeedParcel
    public int animationType;

    @NeedParcel
    public int anonymity;

    @NeedParcel
    public boolean balbum;

    @NeedParcel
    public long batchId;

    @NeedParcel
    public Map<Integer, String> busiParam;

    @NeedParcel
    public String desc;
    public String displayStr;

    @NeedParcel
    public String exActionUrl;

    @NeedParcel
    public int extend_actiontype;

    @NeedParcel
    public int faceman_num;

    @NeedParcel
    public ArrayList<User> facemans;

    @NeedParcel
    public boolean individualAlbum;
    public Integer integerUniKey;

    @NeedParcel
    boolean isSharingAlbum;

    @NeedParcel
    public boolean isTmpData;

    @NeedParcel
    boolean isVideoPicMix;

    @NeedParcel
    public int lastupdatetime;

    @NeedParcel
    public ArrayList<PictureItem> pics;

    @NeedParcel
    public String shareNewReason;

    @NeedParcel
    public long uin;
    public String uniKey;

    @NeedParcel
    public int uploadnum;

    @NeedParcel
    public int actiontype = 0;

    @NeedParcel
    public String extend_actionurl = "";

    public void calculate(String str, String str2, boolean z16) {
        this.displayStr = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append("picture");
        if (z16) {
            sb5.append(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        }
        String sb6 = sb5.toString();
        this.uniKey = sb6;
        this.integerUniKey = Integer.valueOf(sb6.hashCode());
    }

    public boolean isBabyAlbumData() {
        return this.anonymity == 5;
    }

    public boolean isIndividualAlbumData() {
        return this.individualAlbum;
    }

    public boolean isLoverAlbumData() {
        return this.anonymity == 8;
    }

    public boolean isMultiAlbumData() {
        return this.anonymity == 9;
    }

    public boolean isPanorama() {
        ArrayList<PictureItem> arrayList = this.pics;
        if (arrayList == null || arrayList.size() != 1 || this.pics.get(0) == null) {
            return false;
        }
        return this.pics.get(0).isCirclePanorama() || this.pics.get(0).isBallPanorama();
    }

    public boolean isSharingAlbumData() {
        return this.isSharingAlbum;
    }

    @Deprecated
    public boolean isThemeAlbumData() {
        return false;
    }

    public boolean isTravelAlbumData() {
        return this.anonymity == 6;
    }

    public boolean isVideoPicMix() {
        return this.isVideoPicMix;
    }

    public boolean setVideoPicMix(boolean z16) {
        this.isVideoPicMix = z16;
        return z16;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellPictureInfo {\n");
        if (!TextUtils.isEmpty(this.albumname)) {
            sb5.append("albumname: ");
            sb5.append(this.albumname);
            sb5.append(", ");
        }
        sb5.append("uin: ");
        sb5.append(this.uin);
        sb5.append(", ");
        if (!TextUtils.isEmpty(this.actionurl)) {
            sb5.append("actionurl: ");
            sb5.append(this.actionurl);
            sb5.append("\n");
        }
        if (this.pics != null) {
            for (int i3 = 0; i3 < this.pics.size(); i3++) {
                sb5.append("pics[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.pics.get(i3).toString());
                sb5.append("\n");
            }
        }
        sb5.append("isTmpData: ");
        sb5.append(this.isTmpData);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public static CellPictureInfo create(l lVar) {
        Map<String, String> map;
        if (lVar == null || lVar.f50350f == null) {
            return null;
        }
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        if (lVar.f50350f.picdata != null) {
            cellPictureInfo.pics = new ArrayList<>();
            int size = lVar.f50350f.picdata.size();
            for (int i3 = 0; i3 < size; i3++) {
                PictureItem m3 = com.qzone.proxy.feedcomponent.util.e.m(lVar.f50350f.picdata.get(i3));
                if (m3 != null) {
                    if (TextUtils.isEmpty(m3.albumId)) {
                        m3.albumId = lVar.f50350f.albumid;
                    }
                    m3.allowShare = lVar.f50350f.allow_share;
                    cell_comm cell_commVar = lVar.f50340a;
                    if (cell_commVar != null && (map = cell_commVar.extendInfo) != null) {
                        String str = map.get("is_feeds_long_pics_browsing_mode");
                        if (str != null && str.equals("1")) {
                            m3.fakeLongPic = 1;
                        }
                    } else {
                        m3.fakeLongPic = 0;
                    }
                    cellPictureInfo.pics.add(m3);
                }
            }
        }
        cell_pic cell_picVar = lVar.f50350f;
        cellPictureInfo.albumname = cell_picVar.albumname;
        cellPictureInfo.albumtype = cell_picVar.albumtype;
        cellPictureInfo.albumid = cell_picVar.albumid;
        cellPictureInfo.albumnum = cell_picVar.albumnum;
        cellPictureInfo.uploadnum = cell_picVar.uploadnum;
        cellPictureInfo.albumrights = cell_picVar.albumrights;
        cellPictureInfo.albumquestion = cell_picVar.albumquestion;
        cellPictureInfo.albumanswer = cell_picVar.albumanswer;
        cellPictureInfo.desc = cell_picVar.desc;
        cellPictureInfo.uin = cell_picVar.uin;
        cellPictureInfo.balbum = cell_picVar.balbum;
        cellPictureInfo.lastupdatetime = cell_picVar.lastupdatetime;
        cellPictureInfo.busiParam = cell_picVar.busi_param;
        cellPictureInfo.actiontype = cell_picVar.actiontype;
        cellPictureInfo.actionurl = cell_picVar.actionurl;
        if (cell_picVar.facemans != null) {
            cellPictureInfo.facemans = new ArrayList<>();
            for (int i16 = 0; i16 < lVar.f50350f.facemans.size(); i16++) {
                cellPictureInfo.facemans.add(User.fromSUser(lVar.f50350f.facemans.get(i16)));
            }
        }
        cell_pic cell_picVar2 = lVar.f50350f;
        cellPictureInfo.faceman_num = cell_picVar2.faceman_num;
        cellPictureInfo.extend_actiontype = cell_picVar2.extend_actiontype;
        String str2 = cell_picVar2.extend_actionurl;
        cellPictureInfo.extend_actionurl = str2;
        cellPictureInfo.exActionUrl = str2;
        cellPictureInfo.anonymity = cell_picVar2.anonymity;
        cellPictureInfo.albumshowmask = cell_picVar2.albshowmask;
        cellPictureInfo.allow_share = cell_picVar2.allow_share;
        cellPictureInfo.individualAlbum = cell_picVar2.individualalbum != 0;
        cellPictureInfo.isSharingAlbum = cell_picVar2.is_share;
        cellPictureInfo.isVideoPicMix = cell_picVar2.is_video_pic_mix;
        cellPictureInfo.animationType = cell_picVar2.animation_type;
        cellPictureInfo.shareNewReason = cell_picVar2.share_new_reason;
        return cellPictureInfo;
    }
}
