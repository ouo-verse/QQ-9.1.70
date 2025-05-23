package com.tencent.mobileqq.nearby.now.model;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.FeedsProtocol$GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol$LiveAggregateInfo;
import com.tencent.pb.now.FeedsProtocol$MediaInfo;
import com.tencent.pb.now.FeedsProtocol$RichTitleElement;
import com.tencent.pb.now.FeedsProtocol$ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol$TopicCfg;
import com.tencent.pb.now.FeedsProtocol$VideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xada.oidb_0xada$RspBody;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends com.tencent.mobileqq.nearby.now.model.a {

    /* renamed from: f, reason: collision with root package name */
    private String f252715f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f252716g = false;

    /* renamed from: h, reason: collision with root package name */
    private String f252717h;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements INowShortVideoProtoManager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.i("InfinitePlayListDataModel", 2, "errorCode:   " + i3);
            }
            if (i3 != 0 || bArr == null) {
                return;
            }
            oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
            try {
                oidb_0xada_rspbody.mergeFrom(bArr);
                if (QLog.isColorLevel()) {
                    QLog.i("InfinitePlayListDataModel", 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get());
                }
                if (oidb_0xada_rspbody.busi_buf.has()) {
                    FeedsProtocol$GetMediaDetailRsp feedsProtocol$GetMediaDetailRsp = new FeedsProtocol$GetMediaDetailRsp();
                    try {
                        feedsProtocol$GetMediaDetailRsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                        c.this.f252716g = feedsProtocol$GetMediaDetailRsp.is_end.get() != 0;
                        c.this.f252707a = feedsProtocol$GetMediaDetailRsp.total.get();
                        c.this.n(feedsProtocol$GetMediaDetailRsp);
                        if (!TextUtils.isEmpty(c.this.f252717h)) {
                            int size = c.this.f252710d.size();
                            int i16 = 0;
                            while (true) {
                                if (i16 >= c.this.f252710d.size()) {
                                    break;
                                }
                                if (c.this.f252717h.equals(c.this.f252710d.get(i16).f252695e)) {
                                    c cVar = c.this;
                                    cVar.f252711e.a(cVar.f252710d.get(i16));
                                    size = i16;
                                    break;
                                }
                                i16++;
                            }
                            while (size < c.this.f252710d.size()) {
                                c.this.f252710d.remove(size);
                                size++;
                            }
                        }
                        c.this.f252711e.b(0, feedsProtocol$GetMediaDetailRsp.err_code.has() ? feedsProtocol$GetMediaDetailRsp.err_code.get() : 0);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                        c.this.f252711e.onError();
                    }
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e17.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements INowShortVideoProtoManager.a {
        b() {
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.i("InfinitePlayListDataModel", 2, "errorCode:   " + i3);
            }
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.i("InfinitePlayListDataModel", 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get());
                    }
                    if (oidb_0xada_rspbody.busi_buf.has()) {
                        FeedsProtocol$GetMediaDetailRsp feedsProtocol$GetMediaDetailRsp = new FeedsProtocol$GetMediaDetailRsp();
                        try {
                            feedsProtocol$GetMediaDetailRsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                            c.this.f252708b = feedsProtocol$GetMediaDetailRsp.is_end.get() != 0;
                            c.this.f252707a = feedsProtocol$GetMediaDetailRsp.total.get();
                            c.this.n(feedsProtocol$GetMediaDetailRsp);
                            if (!TextUtils.isEmpty(c.this.f252717h)) {
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= c.this.f252710d.size()) {
                                        i16 = -1;
                                        break;
                                    } else {
                                        if (c.this.f252717h.equals(c.this.f252710d.get(i16).f252695e)) {
                                            c cVar = c.this;
                                            cVar.f252711e.a(cVar.f252710d.get(i16));
                                            break;
                                        }
                                        i16++;
                                    }
                                }
                                for (int i17 = 0; i17 <= i16; i17++) {
                                    c.this.f252710d.remove(0);
                                }
                            }
                            c.this.f252711e.b(1, feedsProtocol$GetMediaDetailRsp.err_code.has() ? feedsProtocol$GetMediaDetailRsp.err_code.get() : 0);
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            QLog.e("InfinitePlayListDataModel", 1, e16, new Object[0]);
                            c.this.f252711e.onError();
                            return;
                        }
                    }
                    c.this.f252711e.onError();
                    return;
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                    QLog.e("InfinitePlayListDataModel", 1, e17, new Object[0]);
                    c.this.f252711e.onError();
                    return;
                }
            }
            QLog.i("InfinitePlayListDataModel", 1, "\u83b7\u53d6\u8be6\u60c5\u9519\u8bef   errorCode=   " + i3 + ",data=" + bArr);
        }
    }

    private void m(FeedsProtocol$MediaInfo feedsProtocol$MediaInfo, ArrayList<VideoData> arrayList) {
        FeedsProtocol$LiveAggregateInfo feedsProtocol$LiveAggregateInfo = feedsProtocol$MediaInfo.live_aggregate.get();
        FeedsProtocol$VideoItem feedsProtocol$VideoItem = feedsProtocol$LiveAggregateInfo.video.get();
        if (feedsProtocol$LiveAggregateInfo.total_short_size.get() == 0 && feedsProtocol$VideoItem != null && !TextUtils.isEmpty(feedsProtocol$VideoItem.jump_url.get().toString())) {
            p(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$VideoItem, arrayList);
            return;
        }
        Iterator<FeedsProtocol$ShortVideoInfo> it = feedsProtocol$LiveAggregateInfo.short_video.get().iterator();
        while (it.hasNext()) {
            VideoData parseShortVideoData = ((IModelUtil) QRoute.api(IModelUtil.class)).parseShortVideoData(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), it.next(), arrayList);
            parseShortVideoData.f252706m = feedsProtocol$VideoItem.jump_url.get().toStringUtf8();
            parseShortVideoData.f252693d = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(FeedsProtocol$GetMediaDetailRsp feedsProtocol$GetMediaDetailRsp) {
        List<FeedsProtocol$MediaInfo> list = feedsProtocol$GetMediaDetailRsp.media_list.get();
        this.f252710d.clear();
        for (FeedsProtocol$MediaInfo feedsProtocol$MediaInfo : list) {
            if (feedsProtocol$MediaInfo.type.get() == 1) {
                m(feedsProtocol$MediaInfo, this.f252710d);
            } else if (feedsProtocol$MediaInfo.type.get() == 2) {
                o(feedsProtocol$MediaInfo, this.f252710d);
            } else if (feedsProtocol$MediaInfo.type.get() == 3) {
                ((IModelUtil) QRoute.api(IModelUtil.class)).parseShortVideoData(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.short_video.get(), this.f252710d);
            } else if (feedsProtocol$MediaInfo.type.get() == 5) {
                ((IModelUtil) QRoute.api(IModelUtil.class)).parseImageData(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.pic_info.get(), this.f252710d);
            } else if (feedsProtocol$MediaInfo.type.get() == 6) {
                ((IModelUtil) QRoute.api(IModelUtil.class)).parseTextFeeds(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.text_feed.get(), this.f252710d);
            }
        }
    }

    private void o(FeedsProtocol$MediaInfo feedsProtocol$MediaInfo, ArrayList<VideoData> arrayList) {
        p(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.video.get(), arrayList);
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public void a() {
        if (this.f252708b) {
            return;
        }
        ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.f252709c).getMediaDetailInfo(this.f252715f + "&num=10", new b());
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public void b() {
        if (this.f252716g) {
            return;
        }
        ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.f252709c).getMediaDetailInfo(this.f252715f + "&num=10", new a());
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public int d() {
        return this.f252707a;
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public void e(Bundle bundle) {
        String string = bundle.getString("raw_url");
        this.f252715f = Uri.parse(string).getQuery();
        if (QLog.isColorLevel()) {
            QLog.d("InfinitePlayListDataModel", 2, "InfinitePlayListDataModel, url=" + string);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public boolean f() {
        return this.f252708b;
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public void i(String str, String str2) {
        this.f252717h = str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f252715f = this.f252715f.replace(str, str2);
    }

    private void p(int i3, List<FeedsProtocol$TopicCfg> list, FeedsProtocol$VideoItem feedsProtocol$VideoItem, ArrayList<VideoData> arrayList) {
        if (feedsProtocol$VideoItem == null) {
            if (QLog.isColorLevel()) {
                QLog.e("paseRecord", 1, "item is null!");
                return;
            }
            return;
        }
        VideoData videoData = new VideoData();
        videoData.f252693d = 1;
        videoData.f252695e = feedsProtocol$VideoItem.f342132id.get().toStringUtf8();
        videoData.f252706m = feedsProtocol$VideoItem.jump_url.get().toStringUtf8();
        videoData.D = feedsProtocol$VideoItem.user_info.uid.get();
        videoData.E = feedsProtocol$VideoItem.user_info.tinyid.get();
        videoData.F = feedsProtocol$VideoItem.user_info.explicit_uid.get();
        videoData.G = feedsProtocol$VideoItem.user_info.id_type.get();
        videoData.f252700h = feedsProtocol$VideoItem.video_cover_url.get().toStringUtf8();
        videoData.H = feedsProtocol$VideoItem.user_info.get().head_img_url.get().toStringUtf8();
        videoData.N = feedsProtocol$VideoItem.user_info.get().anchor_name.get().toStringUtf8();
        videoData.U = feedsProtocol$VideoItem.video_start_time.get();
        videoData.f252705k0 = i3;
        videoData.W = "";
        for (FeedsProtocol$RichTitleElement feedsProtocol$RichTitleElement : feedsProtocol$VideoItem.rpt_msg_rich_title.get()) {
            if (feedsProtocol$RichTitleElement.type.get() == 1) {
                videoData.W += feedsProtocol$RichTitleElement.text.get().toStringUtf8();
            } else if (feedsProtocol$RichTitleElement.type.get() == 2) {
                videoData.W += "#" + feedsProtocol$RichTitleElement.text.get().toStringUtf8() + "#";
            }
        }
        arrayList.add(((IModelUtil) QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(list, videoData));
        arrayList.add(videoData);
    }
}
