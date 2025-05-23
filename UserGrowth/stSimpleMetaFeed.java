package UserGrowth;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaGeoInfo;
import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import NS_KING_SOCIALIZE_META.stMusicFullInfo;
import NS_KING_SOCIALIZE_META.stShareInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSimpleMetaFeed extends JceStruct {
    static stAcquisitionInfo cache_acquisitionInfo;
    static stVideoTag cache_bottomTag;
    static ArrayList<stMagicBrand> cache_brands;
    static stMetaTag cache_bt_style;
    static stCardInfo cache_cardInfo;
    static stCollection cache_collection;
    static ArrayList<stMetaComment> cache_comments;
    static stDramaFall cache_dramaInfo;
    static stFeedBarInfo cache_feedBarInfo;
    static stFloatingLayerCardStyle cache_floatingLayerCardStyle;
    static stFriendLikes cache_friendLikes;
    static stMetaGeoInfo cache_geoInfo;
    static stH5OpInfo cache_h5_op_info;
    static ArrayList<stImgReplacement> cache_imgReplacements;
    static stLive cache_live;
    static stMagicBrand cache_magicBrand;
    static Map<String, String> cache_map_ext;
    static Map<Integer, byte[]> cache_map_pass_back;
    static stMusicFullInfo cache_music_info;
    static stNewIconStyle cache_new_icon;
    static stFeedOpInfo cache_opInfo;
    static stOpVideo cache_opVideo;
    static ArrayList<stQQGroupInfo> cache_qqGroups;
    static stShareInfo cache_share_info;
    static ArrayList<stSimpleComment> cache_simpleComments;
    static ArrayList<stMetaTag> cache_tags;
    static stVideoTag cache_videoTag;
    static Map<Integer, VideoSpecUrl> cache_video_spec_urls;
    static byte[] cache_waterAdItem;
    static stWaterAdStyle cache_waterAdStyle;
    static stWaterFallCardStyle cache_waterFallCardStyle;
    static stWaterFallItemStrategy cache_waterFallItemStrategy;
    static stCallWeishiButton cache_weishiButton;
    static stSimpleMetaPerson cache_poster = new stSimpleMetaPerson();
    static stMetaUgcVideoSeg cache_video = new stMetaUgcVideoSeg();
    static ArrayList<stMetaUgcImage> cache_images = new ArrayList<>();

    /* renamed from: id, reason: collision with root package name */
    public String f25129id = "";
    public String wording = "";
    public String poster_id = "";
    public stSimpleMetaPerson poster = null;
    public stMetaUgcVideoSeg video = null;
    public ArrayList<stMetaUgcImage> images = null;
    public int ding_count = 0;
    public int total_comment_num = 0;
    public ArrayList<stMetaComment> comments = null;
    public String material_id = "";
    public String material_desc = "";
    public int is_ding = 0;
    public int playNum = 0;
    public String video_url = "";
    public String material_thumburl = "";
    public stShareInfo share_info = null;
    public String feed_desc = "";
    public long music_begin_time = 0;
    public long music_end_time = 0;
    public stMusicFullInfo music_info = null;
    public String music_id = "";
    public ArrayList<stMetaTag> tags = null;
    public Map<Integer, byte[]> map_pass_back = null;
    public int gdt_ad_type = 0;
    public String gdt_ad_info = "";
    public stMetaTag bt_style = null;
    public stH5OpInfo h5_op_info = null;
    public int video_type = 0;
    public Map<String, String> map_ext = null;
    public String weishi_jump_url = "";
    public String bottom_img_url = "";
    public stNewIconStyle new_icon = null;
    public String feed_material_jump_url = "";
    public stWaterFallItemStrategy waterFallItemStrategy = null;
    public stWaterFallCardStyle waterFallCardStyle = null;
    public int videoPoolType = 0;
    public ArrayList<stImgReplacement> imgReplacements = null;
    public stOpVideo opVideo = null;
    public String traceId = "";
    public stMetaGeoInfo geoInfo = null;
    public stMagicBrand magicBrand = null;
    public ArrayList<stSimpleComment> simpleComments = null;
    public int createTime = 0;
    public stVideoTag videoTag = null;
    public stFloatingLayerCardStyle floatingLayerCardStyle = null;
    public stCollection collection = null;
    public stFriendLikes friendLikes = null;
    public ArrayList<stMagicBrand> brands = null;
    public ArrayList<stQQGroupInfo> qqGroups = null;
    public boolean isLoop = false;
    public stLive live = null;
    public int scaleType = 0;
    public stFeedOpInfo opInfo = null;
    public stCardInfo cardInfo = null;
    public stDramaFall dramaInfo = null;
    public stVideoTag bottomTag = null;
    public stCallWeishiButton weishiButton = null;
    public stFeedBarInfo feedBarInfo = null;
    public int oneMoreThreshold = 0;
    public byte[] waterAdItem = null;
    public Map<Integer, VideoSpecUrl> video_spec_urls = null;
    public stAcquisitionInfo acquisitionInfo = null;
    public stWaterAdStyle waterAdStyle = null;

    static {
        cache_images.add(new stMetaUgcImage());
        cache_comments = new ArrayList<>();
        cache_comments.add(new stMetaComment());
        cache_share_info = new stShareInfo();
        cache_music_info = new stMusicFullInfo();
        cache_tags = new ArrayList<>();
        cache_tags.add(new stMetaTag());
        cache_map_pass_back = new HashMap();
        cache_map_pass_back.put(0, new byte[]{0});
        cache_bt_style = new stMetaTag();
        cache_h5_op_info = new stH5OpInfo();
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
        cache_new_icon = new stNewIconStyle();
        cache_waterFallItemStrategy = new stWaterFallItemStrategy();
        cache_waterFallCardStyle = new stWaterFallCardStyle();
        cache_imgReplacements = new ArrayList<>();
        cache_imgReplacements.add(new stImgReplacement());
        cache_opVideo = new stOpVideo();
        cache_geoInfo = new stMetaGeoInfo();
        cache_magicBrand = new stMagicBrand();
        cache_simpleComments = new ArrayList<>();
        cache_simpleComments.add(new stSimpleComment());
        cache_videoTag = new stVideoTag();
        cache_floatingLayerCardStyle = new stFloatingLayerCardStyle();
        cache_collection = new stCollection();
        cache_friendLikes = new stFriendLikes();
        cache_brands = new ArrayList<>();
        cache_brands.add(new stMagicBrand());
        cache_qqGroups = new ArrayList<>();
        cache_qqGroups.add(new stQQGroupInfo());
        cache_live = new stLive();
        cache_opInfo = new stFeedOpInfo();
        cache_cardInfo = new stCardInfo();
        cache_dramaInfo = new stDramaFall();
        cache_bottomTag = new stVideoTag();
        cache_weishiButton = new stCallWeishiButton();
        cache_feedBarInfo = new stFeedBarInfo();
        cache_waterAdItem = r2;
        byte[] bArr = {0};
        cache_video_spec_urls = new HashMap();
        cache_video_spec_urls.put(0, new VideoSpecUrl());
        cache_acquisitionInfo = new stAcquisitionInfo();
        cache_waterAdStyle = new stWaterAdStyle();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25129id = jceInputStream.readString(0, false);
        this.wording = jceInputStream.readString(1, false);
        this.poster_id = jceInputStream.readString(2, false);
        this.poster = (stSimpleMetaPerson) jceInputStream.read((JceStruct) cache_poster, 3, false);
        this.video = (stMetaUgcVideoSeg) jceInputStream.read((JceStruct) cache_video, 4, false);
        this.images = (ArrayList) jceInputStream.read((JceInputStream) cache_images, 5, false);
        this.ding_count = jceInputStream.read(this.ding_count, 6, false);
        this.total_comment_num = jceInputStream.read(this.total_comment_num, 7, false);
        this.comments = (ArrayList) jceInputStream.read((JceInputStream) cache_comments, 8, false);
        this.material_id = jceInputStream.readString(9, false);
        this.material_desc = jceInputStream.readString(10, false);
        this.is_ding = jceInputStream.read(this.is_ding, 11, false);
        this.playNum = jceInputStream.read(this.playNum, 12, false);
        this.video_url = jceInputStream.readString(13, false);
        this.material_thumburl = jceInputStream.readString(14, false);
        this.share_info = (stShareInfo) jceInputStream.read((JceStruct) cache_share_info, 15, false);
        this.feed_desc = jceInputStream.readString(16, false);
        this.music_begin_time = jceInputStream.read(this.music_begin_time, 17, false);
        this.music_end_time = jceInputStream.read(this.music_end_time, 18, false);
        this.music_info = (stMusicFullInfo) jceInputStream.read((JceStruct) cache_music_info, 19, false);
        this.music_id = jceInputStream.readString(20, false);
        this.tags = (ArrayList) jceInputStream.read((JceInputStream) cache_tags, 21, false);
        this.map_pass_back = (Map) jceInputStream.read((JceInputStream) cache_map_pass_back, 22, false);
        this.gdt_ad_type = jceInputStream.read(this.gdt_ad_type, 23, false);
        this.gdt_ad_info = jceInputStream.readString(24, false);
        this.bt_style = (stMetaTag) jceInputStream.read((JceStruct) cache_bt_style, 25, false);
        this.h5_op_info = (stH5OpInfo) jceInputStream.read((JceStruct) cache_h5_op_info, 26, false);
        this.video_type = jceInputStream.read(this.video_type, 27, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 28, false);
        this.weishi_jump_url = jceInputStream.readString(29, false);
        this.bottom_img_url = jceInputStream.readString(30, false);
        this.new_icon = (stNewIconStyle) jceInputStream.read((JceStruct) cache_new_icon, 31, false);
        this.feed_material_jump_url = jceInputStream.readString(32, false);
        this.waterFallItemStrategy = (stWaterFallItemStrategy) jceInputStream.read((JceStruct) cache_waterFallItemStrategy, 33, false);
        this.waterFallCardStyle = (stWaterFallCardStyle) jceInputStream.read((JceStruct) cache_waterFallCardStyle, 34, false);
        this.videoPoolType = jceInputStream.read(this.videoPoolType, 35, false);
        this.imgReplacements = (ArrayList) jceInputStream.read((JceInputStream) cache_imgReplacements, 36, false);
        this.opVideo = (stOpVideo) jceInputStream.read((JceStruct) cache_opVideo, 37, false);
        this.traceId = jceInputStream.readString(38, false);
        this.geoInfo = (stMetaGeoInfo) jceInputStream.read((JceStruct) cache_geoInfo, 39, false);
        this.magicBrand = (stMagicBrand) jceInputStream.read((JceStruct) cache_magicBrand, 40, false);
        this.simpleComments = (ArrayList) jceInputStream.read((JceInputStream) cache_simpleComments, 41, false);
        this.createTime = jceInputStream.read(this.createTime, 42, false);
        this.videoTag = (stVideoTag) jceInputStream.read((JceStruct) cache_videoTag, 43, false);
        this.floatingLayerCardStyle = (stFloatingLayerCardStyle) jceInputStream.read((JceStruct) cache_floatingLayerCardStyle, 44, false);
        this.collection = (stCollection) jceInputStream.read((JceStruct) cache_collection, 45, false);
        this.friendLikes = (stFriendLikes) jceInputStream.read((JceStruct) cache_friendLikes, 46, false);
        this.brands = (ArrayList) jceInputStream.read((JceInputStream) cache_brands, 47, false);
        this.qqGroups = (ArrayList) jceInputStream.read((JceInputStream) cache_qqGroups, 48, false);
        this.isLoop = jceInputStream.read(this.isLoop, 49, false);
        this.live = (stLive) jceInputStream.read((JceStruct) cache_live, 50, false);
        this.scaleType = jceInputStream.read(this.scaleType, 51, false);
        this.opInfo = (stFeedOpInfo) jceInputStream.read((JceStruct) cache_opInfo, 52, false);
        this.cardInfo = (stCardInfo) jceInputStream.read((JceStruct) cache_cardInfo, 53, false);
        this.dramaInfo = (stDramaFall) jceInputStream.read((JceStruct) cache_dramaInfo, 54, false);
        this.bottomTag = (stVideoTag) jceInputStream.read((JceStruct) cache_bottomTag, 55, false);
        this.weishiButton = (stCallWeishiButton) jceInputStream.read((JceStruct) cache_weishiButton, 56, false);
        this.feedBarInfo = (stFeedBarInfo) jceInputStream.read((JceStruct) cache_feedBarInfo, 57, false);
        this.oneMoreThreshold = jceInputStream.read(this.oneMoreThreshold, 58, false);
        this.waterAdItem = jceInputStream.read(cache_waterAdItem, 59, false);
        this.video_spec_urls = (Map) jceInputStream.read((JceInputStream) cache_video_spec_urls, 60, false);
        this.acquisitionInfo = (stAcquisitionInfo) jceInputStream.read((JceStruct) cache_acquisitionInfo, 61, false);
        this.waterAdStyle = (stWaterAdStyle) jceInputStream.read((JceStruct) cache_waterAdStyle, 62, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25129id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.wording;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.poster_id;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        stSimpleMetaPerson stsimplemetaperson = this.poster;
        if (stsimplemetaperson != null) {
            jceOutputStream.write((JceStruct) stsimplemetaperson, 3);
        }
        stMetaUgcVideoSeg stmetaugcvideoseg = this.video;
        if (stmetaugcvideoseg != null) {
            jceOutputStream.write((JceStruct) stmetaugcvideoseg, 4);
        }
        ArrayList<stMetaUgcImage> arrayList = this.images;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        jceOutputStream.write(this.ding_count, 6);
        jceOutputStream.write(this.total_comment_num, 7);
        ArrayList<stMetaComment> arrayList2 = this.comments;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 8);
        }
        String str4 = this.material_id;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.material_desc;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        jceOutputStream.write(this.is_ding, 11);
        jceOutputStream.write(this.playNum, 12);
        String str6 = this.video_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        String str7 = this.material_thumburl;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        stShareInfo stshareinfo = this.share_info;
        if (stshareinfo != null) {
            jceOutputStream.write((JceStruct) stshareinfo, 15);
        }
        String str8 = this.feed_desc;
        if (str8 != null) {
            jceOutputStream.write(str8, 16);
        }
        jceOutputStream.write(this.music_begin_time, 17);
        jceOutputStream.write(this.music_end_time, 18);
        stMusicFullInfo stmusicfullinfo = this.music_info;
        if (stmusicfullinfo != null) {
            jceOutputStream.write((JceStruct) stmusicfullinfo, 19);
        }
        String str9 = this.music_id;
        if (str9 != null) {
            jceOutputStream.write(str9, 20);
        }
        ArrayList<stMetaTag> arrayList3 = this.tags;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 21);
        }
        Map<Integer, byte[]> map = this.map_pass_back;
        if (map != null) {
            jceOutputStream.write((Map) map, 22);
        }
        jceOutputStream.write(this.gdt_ad_type, 23);
        String str10 = this.gdt_ad_info;
        if (str10 != null) {
            jceOutputStream.write(str10, 24);
        }
        stMetaTag stmetatag = this.bt_style;
        if (stmetatag != null) {
            jceOutputStream.write((JceStruct) stmetatag, 25);
        }
        stH5OpInfo sth5opinfo = this.h5_op_info;
        if (sth5opinfo != null) {
            jceOutputStream.write((JceStruct) sth5opinfo, 26);
        }
        jceOutputStream.write(this.video_type, 27);
        Map<String, String> map2 = this.map_ext;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 28);
        }
        String str11 = this.weishi_jump_url;
        if (str11 != null) {
            jceOutputStream.write(str11, 29);
        }
        String str12 = this.bottom_img_url;
        if (str12 != null) {
            jceOutputStream.write(str12, 30);
        }
        stNewIconStyle stnewiconstyle = this.new_icon;
        if (stnewiconstyle != null) {
            jceOutputStream.write((JceStruct) stnewiconstyle, 31);
        }
        String str13 = this.feed_material_jump_url;
        if (str13 != null) {
            jceOutputStream.write(str13, 32);
        }
        stWaterFallItemStrategy stwaterfallitemstrategy = this.waterFallItemStrategy;
        if (stwaterfallitemstrategy != null) {
            jceOutputStream.write((JceStruct) stwaterfallitemstrategy, 33);
        }
        stWaterFallCardStyle stwaterfallcardstyle = this.waterFallCardStyle;
        if (stwaterfallcardstyle != null) {
            jceOutputStream.write((JceStruct) stwaterfallcardstyle, 34);
        }
        jceOutputStream.write(this.videoPoolType, 35);
        ArrayList<stImgReplacement> arrayList4 = this.imgReplacements;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 36);
        }
        stOpVideo stopvideo = this.opVideo;
        if (stopvideo != null) {
            jceOutputStream.write((JceStruct) stopvideo, 37);
        }
        String str14 = this.traceId;
        if (str14 != null) {
            jceOutputStream.write(str14, 38);
        }
        stMetaGeoInfo stmetageoinfo = this.geoInfo;
        if (stmetageoinfo != null) {
            jceOutputStream.write((JceStruct) stmetageoinfo, 39);
        }
        stMagicBrand stmagicbrand = this.magicBrand;
        if (stmagicbrand != null) {
            jceOutputStream.write((JceStruct) stmagicbrand, 40);
        }
        ArrayList<stSimpleComment> arrayList5 = this.simpleComments;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 41);
        }
        jceOutputStream.write(this.createTime, 42);
        stVideoTag stvideotag = this.videoTag;
        if (stvideotag != null) {
            jceOutputStream.write((JceStruct) stvideotag, 43);
        }
        stFloatingLayerCardStyle stfloatinglayercardstyle = this.floatingLayerCardStyle;
        if (stfloatinglayercardstyle != null) {
            jceOutputStream.write((JceStruct) stfloatinglayercardstyle, 44);
        }
        stCollection stcollection = this.collection;
        if (stcollection != null) {
            jceOutputStream.write((JceStruct) stcollection, 45);
        }
        stFriendLikes stfriendlikes = this.friendLikes;
        if (stfriendlikes != null) {
            jceOutputStream.write((JceStruct) stfriendlikes, 46);
        }
        ArrayList<stMagicBrand> arrayList6 = this.brands;
        if (arrayList6 != null) {
            jceOutputStream.write((Collection) arrayList6, 47);
        }
        ArrayList<stQQGroupInfo> arrayList7 = this.qqGroups;
        if (arrayList7 != null) {
            jceOutputStream.write((Collection) arrayList7, 48);
        }
        jceOutputStream.write(this.isLoop, 49);
        stLive stlive = this.live;
        if (stlive != null) {
            jceOutputStream.write((JceStruct) stlive, 50);
        }
        jceOutputStream.write(this.scaleType, 51);
        stFeedOpInfo stfeedopinfo = this.opInfo;
        if (stfeedopinfo != null) {
            jceOutputStream.write((JceStruct) stfeedopinfo, 52);
        }
        stCardInfo stcardinfo = this.cardInfo;
        if (stcardinfo != null) {
            jceOutputStream.write((JceStruct) stcardinfo, 53);
        }
        stDramaFall stdramafall = this.dramaInfo;
        if (stdramafall != null) {
            jceOutputStream.write((JceStruct) stdramafall, 54);
        }
        stVideoTag stvideotag2 = this.bottomTag;
        if (stvideotag2 != null) {
            jceOutputStream.write((JceStruct) stvideotag2, 55);
        }
        stCallWeishiButton stcallweishibutton = this.weishiButton;
        if (stcallweishibutton != null) {
            jceOutputStream.write((JceStruct) stcallweishibutton, 56);
        }
        stFeedBarInfo stfeedbarinfo = this.feedBarInfo;
        if (stfeedbarinfo != null) {
            jceOutputStream.write((JceStruct) stfeedbarinfo, 57);
        }
        jceOutputStream.write(this.oneMoreThreshold, 58);
        byte[] bArr = this.waterAdItem;
        if (bArr != null) {
            jceOutputStream.write(bArr, 59);
        }
        Map<Integer, VideoSpecUrl> map3 = this.video_spec_urls;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 60);
        }
        stAcquisitionInfo stacquisitioninfo = this.acquisitionInfo;
        if (stacquisitioninfo != null) {
            jceOutputStream.write((JceStruct) stacquisitioninfo, 61);
        }
        stWaterAdStyle stwateradstyle = this.waterAdStyle;
        if (stwateradstyle != null) {
            jceOutputStream.write((JceStruct) stwateradstyle, 62);
        }
    }
}
