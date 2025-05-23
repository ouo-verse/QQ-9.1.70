package com.tencent.mobileqq.wink.picker.core.repository;

import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.mobile_applist_req;
import NS_MOBILE_FEEDS.mobile_applist_rsp;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_FEEDS.single_feed;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;
import e93.QZoneAlbumStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c extends QZoneCommonRequest implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    public JceStruct f324644d;

    /* renamed from: e, reason: collision with root package name */
    private int f324645e;

    /* renamed from: f, reason: collision with root package name */
    private a f324646f;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(List<QZoneAlbumStruct> list);
    }

    public c(long j3, int i3, String str, a aVar) {
        mobile_applist_req mobile_applist_reqVar = new mobile_applist_req();
        mobile_applist_reqVar.uin = j3;
        mobile_applist_reqVar.appid = 4;
        mobile_applist_reqVar.count = 40;
        mobile_applist_reqVar.attach_info = str;
        mobile_applist_reqVar.album_show_type = 0;
        mobile_applist_reqVar.refresh_type = i3;
        mobile_applist_reqVar.extrance_type = 2;
        mobile_applist_reqVar.mapEx = new HashMap();
        this.f324644d = mobile_applist_reqVar;
        this.f324645e = i3;
        this.f324646f = aVar;
    }

    public static QZoneAlbumStruct a(cell_pic cell_picVar) {
        String trim;
        if (cell_picVar == null || cell_picVar.actiontype != 18 || cell_picVar.albumnum < 1) {
            return null;
        }
        if (TextUtils.isEmpty(cell_picVar.albumname)) {
            trim = "";
        } else {
            trim = cell_picVar.albumname.trim();
        }
        String str = cell_picVar.albumid;
        int i3 = cell_picVar.albumnum;
        Pair<String, String> pair = new Pair<>("", "");
        ArrayList<s_picdata> arrayList = cell_picVar.picdata;
        if (arrayList != null && !arrayList.isEmpty()) {
            pair = d(cell_picVar.picdata.get(0));
        }
        return new QZoneAlbumStruct(i3, trim, str, pair.first, pair.second, false);
    }

    public static <T extends JceStruct> T b(Class<T> cls, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf8");
            newInstance.readFrom(jceInputStream);
            return newInstance;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private List<QZoneAlbumStruct> c(ArrayList<single_feed> arrayList) {
        QZoneAlbumStruct a16;
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Map<Integer, byte[]> map = arrayList.get(i3).singlefeed;
            if (map != null && (a16 = a((cell_pic) b(cell_pic.class, map.get(5)))) != null) {
                arrayList2.add(a16);
            }
        }
        return arrayList2;
    }

    private static Pair<String, String> d(s_picdata s_picdataVar) {
        String str;
        Map<Integer, s_picurl> map;
        String str2;
        String str3 = "";
        if (s_picdataVar == null || (map = s_picdataVar.photourl) == null) {
            str = "";
        } else {
            s_picurl s_picurlVar = map.get(11);
            if (s_picurlVar == null || (str2 = s_picurlVar.url) == null) {
                str2 = "";
            }
            s_picurl s_picurlVar2 = s_picdataVar.photourl.get(0);
            if (s_picurlVar2 == null || (str = s_picurlVar2.url) == null) {
                str = "";
            }
            str3 = str2;
        }
        return new Pair<>(str3, str);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.applist.photo";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.f324644d;
    }

    @Override // cooperation.qzone.QZoneCommonRequest
    public int getType() {
        return this.f324645e;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (bundle == null) {
            w53.b.f("QZoneAlbumListRequest", "[onReceive] ==> bundle is null");
            return;
        }
        JceStruct jceStruct = (JceStruct) bundle.getSerializable("key_response");
        if (!(jceStruct instanceof mobile_applist_rsp)) {
            w53.b.f("QZoneAlbumListRequest", "[onReceive] ==> response is not mobile_applist_rsp");
            return;
        }
        if (!z16) {
            w53.b.f("QZoneAlbumListRequest", "[onReceive] ==> is not succeed");
            return;
        }
        ArrayList<single_feed> arrayList = ((mobile_applist_rsp) jceStruct).all_applist_data;
        if (arrayList != null) {
            List<QZoneAlbumStruct> c16 = c(arrayList);
            a aVar = this.f324646f;
            if (aVar != null) {
                aVar.a(c16);
                return;
            }
            return;
        }
        w53.b.f("QZoneAlbumListRequest", "[onReceive] ==> allFeedsData is null");
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        if (this.f324644d != null) {
            return "photo";
        }
        return "getApplist";
    }
}
