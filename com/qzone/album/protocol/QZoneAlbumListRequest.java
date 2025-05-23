package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_operation;
import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.last_album_area_info;
import NS_MOBILE_FEEDS.mobile_applist_req;
import NS_MOBILE_FEEDS.mobile_applist_rsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_QMALL_COVER.PhotoAlbumQzmallDeco;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.oskplayer.util.PlayerUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import t5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAlbumListRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "getApplist";
    private static final String NEW_CMD_STRING = "applist";
    private static final String TAG = "QZoneAlbumListRequest";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f43885a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f43886b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<AlbumCacheData> f43887c;

        /* renamed from: d, reason: collision with root package name */
        public String f43888d;

        /* renamed from: e, reason: collision with root package name */
        public int f43889e;

        /* renamed from: f, reason: collision with root package name */
        public int f43890f;

        /* renamed from: g, reason: collision with root package name */
        public int f43891g;

        /* renamed from: h, reason: collision with root package name */
        public PhotoAlbumQzmallDeco f43892h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f43893i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f43894j;

        /* renamed from: k, reason: collision with root package name */
        public String f43895k;

        /* renamed from: l, reason: collision with root package name */
        public last_album_area_info f43896l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumListRequest(long j3, int i3, String str, boolean z16, HashMap<String, String> hashMap) {
        super(CMD_STRING);
        String str2 = CMD_STRING;
        mobile_applist_req mobile_applist_reqVar = new mobile_applist_req();
        mobile_applist_reqVar.uin = j3;
        mobile_applist_reqVar.appid = 4;
        mobile_applist_reqVar.count = 30;
        setGetMore(z16);
        mobile_applist_reqVar.attach_info = z16 ? str : "";
        int i16 = z16 ? 2 : 1;
        mobile_applist_reqVar.album_show_type = 0;
        mobile_applist_reqVar.refresh_type = i16;
        mobile_applist_reqVar.extrance_type = i3;
        String a16 = com.qzone.app.a.a(4);
        if (!TextUtils.isEmpty(a16)) {
            str2 = "applist." + a16;
        }
        setCmdString(str2);
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 4, "QZoneAlbumListRequest cmd:" + getCmdString());
        }
        if (mobile_applist_reqVar.mapEx == null) {
            mobile_applist_reqVar.mapEx = new HashMap();
        }
        if (hashMap != null) {
            mobile_applist_reqVar.mapEx.putAll(hashMap);
        }
        if (hashMap != null && String.valueOf(1).equals(hashMap.get("only_public_album"))) {
            mobile_applist_reqVar.req_from = 1;
        }
        mobile_applist_reqVar.mapEx.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        QZLog.i("h265debug mobile_applist_req", mobile_applist_reqVar.mapEx.get("mobile_detail_info"));
        this.req = mobile_applist_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString() + "Photo";
    }

    public mobile_applist_rsp getResp() {
        return (mobile_applist_rsp) this.rsp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L8;
     */
    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String uniKey() {
        String str;
        if (this.req != null) {
            str = com.qzone.app.a.a(4);
        }
        str = CMD_STRING;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 4, "QZoneAlbumListRequest unikey:" + str);
        }
        return str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0142  */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        int i3;
        int parseInt;
        int i16;
        String str;
        boolean z16;
        AlbumCacheData albumCacheData;
        int i17;
        ArrayList<AlbumCacheData> arrayList;
        Map map;
        cell_comm cell_commVar;
        Map map2 = null;
        if (!(jceStruct instanceof mobile_applist_rsp)) {
            return null;
        }
        a aVar = new a();
        mobile_applist_rsp mobile_applist_rspVar = (mobile_applist_rsp) jceStruct;
        long j3 = ((mobile_applist_req) this.req).uin;
        if (mobile_applist_rspVar.mapEx.get("AlbumThemeSkin") != null) {
            aVar.f43892h = (PhotoAlbumQzmallDeco) b.b(PhotoAlbumQzmallDeco.class, mobile_applist_rspVar.mapEx.get("AlbumThemeSkin"));
        }
        aVar.f43896l = mobile_applist_rspVar.album_area_info;
        int i18 = mobile_applist_rspVar.hasmore;
        ArrayList<single_feed> arrayList2 = mobile_applist_rspVar.all_applist_data;
        int i19 = 0;
        if (arrayList2 != null) {
            ArrayList<AlbumCacheData> arrayList3 = new ArrayList<>();
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 4, "all_feeds_data.size()=" + arrayList2.size());
            }
            AlbumCacheData albumCacheData2 = null;
            int i26 = 0;
            while (i26 < arrayList2.size()) {
                Map<Integer, byte[]> map3 = arrayList2.get(i26).singlefeed;
                if (map3 != null) {
                    cell_pic cell_picVar = (cell_pic) b.b(cell_pic.class, map3.get(5));
                    cell_operation cell_operationVar = (cell_operation) b.b(cell_operation.class, map3.get(18));
                    if (cell_operationVar != null) {
                        Map map4 = cell_operationVar.busi_param;
                        if (map4 == null) {
                            map4 = new HashMap();
                        }
                        map = map4;
                    } else {
                        map = map2;
                    }
                    byte[] bArr = map3.get(Integer.valueOf(i19));
                    int i27 = (bArr == null || (cell_commVar = (cell_comm) b.b(cell_comm.class, bArr)) == null) ? i19 : cell_commVar.operatemask;
                    albumCacheData = albumCacheData2;
                    i17 = i26;
                    arrayList = arrayList3;
                    albumCacheData2 = AlbumCacheData.createFromResponse(cell_picVar, 0, j3, -1, map, i27);
                    if (albumCacheData2 != null) {
                        if (albumCacheData2.isToppedAlbum) {
                            i26 = i17 + 1;
                            arrayList3 = arrayList;
                            map2 = null;
                            i19 = 0;
                        } else {
                            arrayList.add(albumCacheData2);
                        }
                    }
                } else {
                    albumCacheData = albumCacheData2;
                    i17 = i26;
                    arrayList = arrayList3;
                }
                albumCacheData2 = albumCacheData;
                i26 = i17 + 1;
                arrayList3 = arrayList;
                map2 = null;
                i19 = 0;
            }
            AlbumCacheData albumCacheData3 = albumCacheData2;
            ArrayList<AlbumCacheData> arrayList4 = arrayList3;
            i3 = 0;
            if (albumCacheData3 != null) {
                arrayList4.add(0, albumCacheData3);
            }
            aVar.f43887c = arrayList4;
        } else {
            i3 = 0;
        }
        Map<String, String> map5 = mobile_applist_rspVar.extend_info;
        if (map5 != null) {
            try {
                parseInt = Integer.parseInt(map5.get("is_scan_visible"));
                try {
                    i16 = 1 == Integer.parseInt(mobile_applist_rspVar.extend_info.get("isNeedPhotoRecycleBinVisible")) ? 1 : i3;
                    try {
                        str = mobile_applist_rspVar.extend_info.get("PhotoRecycleBinUrl");
                        z16 = i16;
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    i16 = i3;
                }
            } catch (Throwable unused3) {
            }
            aVar.f43885a = j3;
            aVar.f43886b = i18 == 0 ? 1 : i3;
            aVar.f43888d = mobile_applist_rspVar.attach_info;
            aVar.f43893i = parseInt != 1 ? 1 : i3;
            aVar.f43894j = z16;
            aVar.f43895k = str;
            aVar.f43889e = mobile_applist_rspVar.album_count;
            aVar.f43890f = mobile_applist_rspVar.photo_count;
            aVar.f43891g = mobile_applist_rspVar.video_count;
            return aVar;
        }
        parseInt = i3;
        i16 = parseInt;
        str = null;
        z16 = i16;
        aVar.f43885a = j3;
        aVar.f43886b = i18 == 0 ? 1 : i3;
        aVar.f43888d = mobile_applist_rspVar.attach_info;
        aVar.f43893i = parseInt != 1 ? 1 : i3;
        aVar.f43894j = z16;
        aVar.f43895k = str;
        aVar.f43889e = mobile_applist_rspVar.album_count;
        aVar.f43890f = mobile_applist_rspVar.photo_count;
        aVar.f43891g = mobile_applist_rspVar.video_count;
        return aVar;
    }
}
