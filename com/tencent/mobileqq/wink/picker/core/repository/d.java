package com.tencent.mobileqq.wink.picker.core.repository;

import NS_MOBILE_FEEDS.cell_video;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.get_photo_list_2_req;
import NS_MOBILE_PHOTO.get_photo_list_2_rsp;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d extends QZoneCommonRequest implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private final a f324647d;

    /* renamed from: e, reason: collision with root package name */
    public JceStruct f324648e;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z16, List<LocalMediaInfo> list, boolean z17, String str);
    }

    public d(long j3, String str, a aVar, String str2) {
        get_photo_list_2_req get_photo_list_2_reqVar = new get_photo_list_2_req();
        get_photo_list_2_reqVar.uin = j3;
        get_photo_list_2_reqVar.albumid = str;
        get_photo_list_2_reqVar.f25041ps = 0;
        get_photo_list_2_reqVar.f25040pn = 1;
        get_photo_list_2_reqVar.password = "";
        get_photo_list_2_reqVar.curlloc = null;
        get_photo_list_2_reqVar.sheight = 200;
        get_photo_list_2_reqVar.swidth = 200;
        get_photo_list_2_reqVar.busi_param = null;
        get_photo_list_2_reqVar.req_url = "";
        get_photo_list_2_reqVar.face_uin = 0L;
        get_photo_list_2_reqVar.ciphertext = "";
        get_photo_list_2_reqVar.password_cleartext = 1L;
        get_photo_list_2_reqVar.type = 0;
        get_photo_list_2_reqVar.sharer = 0L;
        get_photo_list_2_reqVar.need_pos = false;
        get_photo_list_2_reqVar.sort_type = 3;
        get_photo_list_2_reqVar.attach_info = str2;
        this.f324648e = get_photo_list_2_reqVar;
        this.f324647d = aVar;
    }

    public String a(s_picdata s_picdataVar) {
        Map<Integer, s_picurl> map;
        if (s_picdataVar != null && (map = s_picdataVar.photourl) != null) {
            s_picurl s_picurlVar = map.get(14);
            s_picurl s_picurlVar2 = map.get(1);
            s_picurl s_picurlVar3 = map.get(0);
            if (s_picurlVar != null) {
                return s_picurlVar.url;
            }
            if (s_picurlVar2 != null) {
                return s_picurlVar2.url;
            }
            if (s_picurlVar3 != null) {
                return s_picurlVar3.url;
            }
        }
        return "";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.getPhotoList2";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.f324648e;
    }

    @Override // cooperation.qzone.QZoneCommonRequest
    public int getType() {
        return 1;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        boolean z17;
        Map<Integer, s_picurl> map;
        if (bundle == null) {
            return;
        }
        JceStruct jceStruct = (JceStruct) bundle.getSerializable("key_response");
        if (!(jceStruct instanceof get_photo_list_2_rsp)) {
            return;
        }
        get_photo_list_2_rsp get_photo_list_2_rspVar = (get_photo_list_2_rsp) jceStruct;
        if (get_photo_list_2_rspVar.finish == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        ArrayList<s_picdata> arrayList = get_photo_list_2_rspVar.photolist;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (s_picdata s_picdataVar : arrayList) {
                if (s_picdataVar != null && (map = s_picdataVar.photourl) != null && map.size() >= 2) {
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    e93.i.J(localMediaInfo, s_picdataVar.albumid);
                    e93.i.R(localMediaInfo, s_picdataVar.sloc);
                    e93.i.S(localMediaInfo, s_picdataVar.lloc);
                    e93.i.Q(localMediaInfo, s_picdataVar.picname);
                    localMediaInfo.mediaWidth = s_picdataVar.photourl.get(1).width;
                    localMediaInfo.mediaHeight = s_picdataVar.photourl.get(1).height;
                    int i16 = s_picdataVar.videoflag;
                    if (i16 == 1) {
                        localMediaInfo.mMediaType = 1;
                        cell_video cell_videoVar = s_picdataVar.videodata;
                        localMediaInfo.mDuration = cell_videoVar.videotime;
                        localMediaInfo.mMimeType = "video/mp4";
                        s_picurl s_picurlVar = cell_videoVar.coverurl.get(0);
                        if (s_picurlVar == null) {
                            s_picurlVar = s_picdataVar.videodata.coverurl.get(s_picdataVar.videodata.coverurl.keySet().iterator().next());
                        }
                        if (s_picurlVar != null) {
                            e93.i.T(localMediaInfo, s_picurlVar.url);
                        }
                        e93.i.L(localMediaInfo, s_picdataVar.videodata.actionurl);
                    } else if (i16 == 0) {
                        localMediaInfo.mMediaType = 0;
                        if (s_picdataVar.isAutoPlayGif) {
                            localMediaInfo.mMimeType = "image/gif";
                        } else {
                            localMediaInfo.mMimeType = "image/jpeg";
                        }
                        e93.i.T(localMediaInfo, a(s_picdataVar));
                        e93.i.L(localMediaInfo, a(s_picdataVar));
                    }
                    arrayList2.add(localMediaInfo);
                }
            }
        }
        this.f324647d.a(z16, arrayList2, z17, get_photo_list_2_rspVar.attach_info);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getPhotoList2";
    }
}
