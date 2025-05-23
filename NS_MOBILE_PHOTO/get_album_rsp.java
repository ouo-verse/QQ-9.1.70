package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_album_rsp extends JceStruct {
    public Album album;
    public int albumCommentNum;
    public int albumFaceNum;
    public int albumLikeNum;
    public String albumLikekey;
    public int albumVisitNum;
    public String invite_key;
    public boolean isCoverUserSet;
    public boolean isMyLiked;
    public boolean isOwner;
    public int largeCoverHeight;
    public String largeCoverUrl;
    public int largeCoverWidth;
    public photo_share_struct.PublicShareData public_share_data;
    public String share_url;
    public Map<Long, wx_user_info> sharer_wx_info;
    public int sort_type;
    static Album cache_album = new Album();
    static photo_share_struct.PublicShareData cache_public_share_data = new photo_share_struct.PublicShareData();
    static int cache_sort_type = 0;
    static Map<Long, wx_user_info> cache_sharer_wx_info = new HashMap();

    static {
        cache_sharer_wx_info.put(0L, new wx_user_info());
    }

    public get_album_rsp() {
        this.album = null;
        this.albumFaceNum = 0;
        this.albumLikeNum = 0;
        this.albumLikekey = "";
        this.albumVisitNum = 0;
        this.isMyLiked = false;
        this.largeCoverUrl = "";
        this.albumCommentNum = 0;
        this.share_url = "";
        this.invite_key = "";
        this.public_share_data = null;
        this.largeCoverHeight = 0;
        this.largeCoverWidth = 0;
        this.sort_type = 3;
        this.isOwner = false;
        this.sharer_wx_info = null;
        this.isCoverUserSet = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.album = (Album) jceInputStream.read((JceStruct) cache_album, 0, true);
        this.albumFaceNum = jceInputStream.read(this.albumFaceNum, 1, false);
        this.albumLikeNum = jceInputStream.read(this.albumLikeNum, 2, false);
        this.albumLikekey = jceInputStream.readString(3, false);
        this.albumVisitNum = jceInputStream.read(this.albumVisitNum, 4, false);
        this.isMyLiked = jceInputStream.read(this.isMyLiked, 5, false);
        this.largeCoverUrl = jceInputStream.readString(6, false);
        this.albumCommentNum = jceInputStream.read(this.albumCommentNum, 7, false);
        this.share_url = jceInputStream.readString(8, false);
        this.invite_key = jceInputStream.readString(9, false);
        this.public_share_data = (photo_share_struct.PublicShareData) jceInputStream.read((JceStruct) cache_public_share_data, 10, false);
        this.largeCoverHeight = jceInputStream.read(this.largeCoverHeight, 11, false);
        this.largeCoverWidth = jceInputStream.read(this.largeCoverWidth, 12, false);
        this.sort_type = jceInputStream.read(this.sort_type, 13, false);
        this.isOwner = jceInputStream.read(this.isOwner, 14, false);
        this.sharer_wx_info = (Map) jceInputStream.read((JceInputStream) cache_sharer_wx_info, 15, false);
        this.isCoverUserSet = jceInputStream.read(this.isCoverUserSet, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.album, 0);
        jceOutputStream.write(this.albumFaceNum, 1);
        jceOutputStream.write(this.albumLikeNum, 2);
        String str = this.albumLikekey;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.albumVisitNum, 4);
        jceOutputStream.write(this.isMyLiked, 5);
        String str2 = this.largeCoverUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.albumCommentNum, 7);
        String str3 = this.share_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.invite_key;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        photo_share_struct.PublicShareData publicShareData = this.public_share_data;
        if (publicShareData != null) {
            jceOutputStream.write((JceStruct) publicShareData, 10);
        }
        jceOutputStream.write(this.largeCoverHeight, 11);
        jceOutputStream.write(this.largeCoverWidth, 12);
        jceOutputStream.write(this.sort_type, 13);
        jceOutputStream.write(this.isOwner, 14);
        Map<Long, wx_user_info> map = this.sharer_wx_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 15);
        }
        jceOutputStream.write(this.isCoverUserSet, 16);
    }

    public get_album_rsp(Album album, int i3, int i16, String str, int i17, boolean z16, String str2, int i18, String str3, String str4, photo_share_struct.PublicShareData publicShareData, int i19, int i26, int i27, boolean z17, Map<Long, wx_user_info> map, boolean z18) {
        this.album = album;
        this.albumFaceNum = i3;
        this.albumLikeNum = i16;
        this.albumLikekey = str;
        this.albumVisitNum = i17;
        this.isMyLiked = z16;
        this.largeCoverUrl = str2;
        this.albumCommentNum = i18;
        this.share_url = str3;
        this.invite_key = str4;
        this.public_share_data = publicShareData;
        this.largeCoverHeight = i19;
        this.largeCoverWidth = i26;
        this.sort_type = i27;
        this.isOwner = z17;
        this.sharer_wx_info = map;
        this.isCoverUserSet = z18;
    }
}
