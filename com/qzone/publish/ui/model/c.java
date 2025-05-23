package com.qzone.publish.ui.model;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_FEEDS.cnst.FEEDSKIN;
import NS_MOBILE_FEEDS.cnst.PROTO_EXT_TO_UGCSVR_FOR_FONT;
import NS_MOBILE_MATERIAL.UgcDecoQualReq;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import PROTO_EXT_TO_UGCSVR.Font;
import android.text.TextUtils;
import com.qzone.album.data.model.GifInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.service.QzoneNewCardSkinService;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.vas.VasLogReporter;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.publishInterface.QzonePublishMoodCallback;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {
    public boolean A;
    public ArrayList<GifInfo> B;
    public PublishEventTag C;
    public Map<String, byte[]> D;
    public HashMap<String, String> E;
    public Map<String, byte[]> F;
    public Map<String, String> G;
    public String I;
    public boolean J;
    public QzoneVerticalVideoTopicInfo K;
    public HashMap<String, String> L;
    public ArrayList<MediaWrapper> M;
    public PicInfo N;
    public boolean O;
    public ArrayList<String> P;
    public boolean Q;
    public String R;
    public String S;
    public String T;
    public boolean U;
    public FeedSkinData V;
    public boolean X;
    public String Y;
    public ArrayList<CommodityBean> Z;

    /* renamed from: a, reason: collision with root package name */
    public String f51932a;

    /* renamed from: b, reason: collision with root package name */
    public String f51934b;

    /* renamed from: b0, reason: collision with root package name */
    public Map<String, String> f51935b0;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f51936c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<DynamicPhotoData> f51938d;

    /* renamed from: d0, reason: collision with root package name */
    public QzonePublishMoodCallback f51939d0;

    /* renamed from: e, reason: collision with root package name */
    public List<LocalMediaInfo> f51940e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, String> f51942f;

    /* renamed from: g, reason: collision with root package name */
    public shuoshuo_privacy f51944g;

    /* renamed from: g0, reason: collision with root package name */
    public String f51945g0;

    /* renamed from: h, reason: collision with root package name */
    public ShuoshuoVideoInfo f51946h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap<String, PicInfo> f51947i;

    /* renamed from: j, reason: collision with root package name */
    public LbsDataV2.PoiInfo f51948j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f51949k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f51950l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f51951m;

    /* renamed from: n, reason: collision with root package name */
    public int f51952n;

    /* renamed from: o, reason: collision with root package name */
    public QZonePreUploadInfo f51953o;

    /* renamed from: p, reason: collision with root package name */
    public Map<String, String> f51954p;

    /* renamed from: q, reason: collision with root package name */
    public Font f51955q;

    /* renamed from: r, reason: collision with root package name */
    public int f51956r;

    /* renamed from: s, reason: collision with root package name */
    public long f51957s;

    /* renamed from: t, reason: collision with root package name */
    public long f51958t;

    /* renamed from: u, reason: collision with root package name */
    public int f51959u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<String> f51960v;

    /* renamed from: w, reason: collision with root package name */
    public String f51961w;

    /* renamed from: x, reason: collision with root package name */
    public LbsDataV2.PoiInfo f51962x;

    /* renamed from: y, reason: collision with root package name */
    public String f51963y;

    /* renamed from: z, reason: collision with root package name */
    public int f51964z;
    public int H = 2;
    public boolean W = true;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f51933a0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f51937c0 = false;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f51941e0 = true;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f51943f0 = false;

    public Map<String, byte[]> b() {
        byte[] byteArray;
        HashMap hashMap = new HashMap();
        Font font = this.f51955q;
        if (font != null && (byteArray = font.toByteArray()) != null) {
            hashMap.put(PROTO_EXT_TO_UGCSVR_FOR_FONT.value, byteArray);
        }
        return hashMap;
    }

    public Map<String, String> d() {
        if (this.f51954p == null) {
            this.f51954p = new HashMap();
        }
        return this.f51954p;
    }

    public Map<String, String> e() {
        if (this.f51935b0 == null) {
            this.f51935b0 = new HashMap();
        }
        return this.f51935b0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("title: ");
        sb5.append(this.f51932a);
        sb5.append(" content: ");
        sb5.append(this.f51934b);
        if (this.f51936c != null) {
            sb5.append(" imageFiles: ");
            sb5.append(this.f51936c);
        }
        if (this.f51944g != null) {
            sb5.append(" shuoshuoPrivacy:");
            sb5.append(this.f51944g.mood_permission);
        }
        sb5.append(" syncWeibo:");
        sb5.append(this.f51949k);
        sb5.append(" syncQQ:");
        sb5.append(this.f51950l);
        sb5.append(" photoQuality:");
        sb5.append(this.f51956r);
        sb5.append(" isSyncToQQStory:");
        sb5.append(this.J);
        sb5.append("  publishTime;:");
        sb5.append(this.f51957s);
        return sb5.toString();
    }

    public Map<String, byte[]> c(Map<String, byte[]> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        FeedSkinData feedSkinData = this.V;
        if (feedSkinData != null) {
            if (feedSkinData.iNewFeedSkin == 1) {
                UgcDecoQualReq ugcDecoQualReq = new UgcDecoQualReq();
                if (ugcDecoQualReq.mapItemId == null) {
                    ugcDecoQualReq.mapItemId = new HashMap();
                }
                if (!TextUtils.isEmpty(this.V.sSkinId)) {
                    ugcDecoQualReq.mapItemId.put(140, Integer.valueOf(FeedSkinData.transferToInt(this.V.sSkinId)));
                    byte[] byteArray = ugcDecoQualReq.toByteArray();
                    if (byteArray != null) {
                        map.put(FEEDSKIN.value, byteArray);
                        j.f("QzoneShuoshuoParams", "@newCard mNewCardData.skin" + this.V.sSkinId);
                        VasLogReporter.getQzoneFeedsCard().report("mood params with feeds card id:" + this.V.sSkinId);
                    }
                } else {
                    map.put(FEEDSKIN.value, ugcDecoQualReq.toByteArray());
                    j.f("QzoneShuoshuoParams", "inew skin =1 cancle decorare @newCard");
                }
                QzoneNewCardSkinService.F().V(LoginData.getInstance().getUin(), null, this.V);
            } else {
                j.f("QzoneShuoshuoParams", " @newCard iNewFeedSkin!=1 follow user");
            }
        } else {
            j.f("QzoneShuoshuoParams", "@mNewcardData null");
        }
        return map;
    }

    public void a(HashMap<String, MarkUinInfoBeforeUpload> hashMap) {
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            MarkUinInfoBeforeUpload markUinInfoBeforeUpload = hashMap.get(str);
            if (markUinInfoBeforeUpload != null) {
                hashMap2.put(str, markUinInfoBeforeUpload.toByteArray());
            }
        }
        this.F = hashMap2;
    }
}
