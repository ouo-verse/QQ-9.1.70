package com.tencent.mobileqq.nearby.now.model;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.FeedsProtocol$GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol$MediaInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada$RspBody;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d extends com.tencent.mobileqq.nearby.now.model.a {

    /* renamed from: g, reason: collision with root package name */
    private String f252721g;

    /* renamed from: f, reason: collision with root package name */
    private String f252720f = "PlayListDataModel";

    /* renamed from: h, reason: collision with root package name */
    private int f252722h = 0;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements INowShortVideoProtoManager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.i(d.this.f252720f, 2, "errorCode:   " + i3);
            }
            if (bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.i(d.this.f252720f, 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get());
                    }
                    if (oidb_0xada_rspbody.busi_buf.has()) {
                        FeedsProtocol$GetMediaDetailRsp feedsProtocol$GetMediaDetailRsp = new FeedsProtocol$GetMediaDetailRsp();
                        feedsProtocol$GetMediaDetailRsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                        if (QLog.isColorLevel()) {
                            QLog.i(d.this.f252720f, 2, "GetMediaDetailRsp  error_code:   " + feedsProtocol$GetMediaDetailRsp.err_code.get() + ",err_msg:     " + feedsProtocol$GetMediaDetailRsp.err_msg.get().toStringUtf8() + ",total:  " + feedsProtocol$GetMediaDetailRsp.total.get());
                        }
                        d.this.f252708b = feedsProtocol$GetMediaDetailRsp.is_end.get() != 0;
                        d.this.f252707a = feedsProtocol$GetMediaDetailRsp.total.get();
                        d.this.n(feedsProtocol$GetMediaDetailRsp);
                        d.this.f252722h += 10;
                        d.this.f252711e.b(1, feedsProtocol$GetMediaDetailRsp.err_code.has() ? feedsProtocol$GetMediaDetailRsp.err_code.get() : 0);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(FeedsProtocol$GetMediaDetailRsp feedsProtocol$GetMediaDetailRsp) {
        for (FeedsProtocol$MediaInfo feedsProtocol$MediaInfo : feedsProtocol$GetMediaDetailRsp.media_list.get()) {
            if (feedsProtocol$MediaInfo.type.get() != 1 && feedsProtocol$MediaInfo.type.get() != 2) {
                if (feedsProtocol$MediaInfo.type.get() == 3) {
                    ((IModelUtil) QRoute.api(IModelUtil.class)).parseShortVideoData(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.short_video.get(), this.f252710d);
                } else if (feedsProtocol$MediaInfo.type.get() == 5) {
                    ((IModelUtil) QRoute.api(IModelUtil.class)).parseImageData(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.pic_info.get(), this.f252710d);
                } else if (feedsProtocol$MediaInfo.type.get() == 6) {
                    ((IModelUtil) QRoute.api(IModelUtil.class)).parseTextFeeds(feedsProtocol$MediaInfo.is_my_feeds.get(), feedsProtocol$MediaInfo.topic_cfg.get(), feedsProtocol$MediaInfo.text_feed.get(), this.f252710d);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public void a() {
        if (this.f252708b) {
            return;
        }
        ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.f252709c).getMediaDetailInfo(this.f252721g + "&start=" + this.f252722h + "&num=10", new a());
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public int d() {
        return this.f252707a;
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public void e(Bundle bundle) {
        if ("1".equals(bundle.getString("isLocal"))) {
            return;
        }
        String string = bundle.getString("raw_url");
        this.f252721g = Uri.parse(string).getQuery();
        if (QLog.isColorLevel()) {
            QLog.d(this.f252720f, 2, "PlayListDataModel, url=" + string);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.model.a
    public boolean f() {
        return this.f252708b;
    }
}
