package com.tencent.mobileqq.nearby.now.protocol.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.pb.now.FeedsProtocol$GetMediaDetailReq;
import com.tencent.pb.now.LbsShare$LocationReq;
import com.tencent.pb.now.ilive_feeds_like$FeedsLikeReq;
import com.tencent.pb.now.ilive_feeds_like$FeedsUnLikeReq;
import com.tencent.pb.now.ilive_feeds_source$CollectFeedsDataReq;
import com.tencent.pb.now.ilive_new_anchor_follow_interface$FollowActionReq;
import com.tencent.pb.now.ilive_short_video_label$GetShortVideoVideoLabelReq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import tencent.im.oidb.cmd0xada.oidb_0xada$ReqBody;

/* loaded from: classes33.dex */
public class NowShortVideoProtoManagerImpl implements INowShortVideoProtoManager {
    public static final int ACTION_FOLLOW = 1;
    public static final int ACTION_UNFOLLOW = 2;
    public static final short CMD_CS_ADD_SHORT_VIDEO_FEEDS = 24608;
    public static final short CMD_CS_APPLY_SHORT_VIDEO = 24592;
    AppInterface mApp = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252731e;

        a(INowShortVideoProtoManager.a aVar) {
            this.f252731e = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            INowShortVideoProtoManager.a aVar = this.f252731e;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252733e;

        b(INowShortVideoProtoManager.a aVar) {
            this.f252733e = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            QLog.i("reportPlay", 1, " reportPlay code:" + i3);
            INowShortVideoProtoManager.a aVar = this.f252733e;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252735e;

        c(INowShortVideoProtoManager.a aVar) {
            this.f252735e = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            INowShortVideoProtoManager.a aVar = this.f252735e;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252740e;

        e(INowShortVideoProtoManager.a aVar) {
            this.f252740e = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            INowShortVideoProtoManager.a aVar = this.f252740e;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class f extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252742e;

        f(INowShortVideoProtoManager.a aVar) {
            this.f252742e = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            INowShortVideoProtoManager.a aVar = this.f252742e;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class g extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252744e;

        g(INowShortVideoProtoManager.a aVar) {
            this.f252744e = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            INowShortVideoProtoManager.a aVar = this.f252744e;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$follow$4(oidb_0xada$ReqBody oidb_0xada_reqbody, long j3, int i3, boolean z16, long j16, int i16, INowShortVideoProtoManager.a aVar, boolean z17) {
        if (z17) {
            oidb_0xada_reqbody.cmd.set(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START);
            oidb_0xada_reqbody.subcmd.set(64);
            ilive_new_anchor_follow_interface$FollowActionReq ilive_new_anchor_follow_interface_followactionreq = new ilive_new_anchor_follow_interface$FollowActionReq();
            ilive_new_anchor_follow_interface_followactionreq.anchor_uin.set(j3);
            ilive_new_anchor_follow_interface_followactionreq.client_type.set(401);
            ilive_new_anchor_follow_interface_followactionreq.source.set(i3);
            ilive_new_anchor_follow_interface_followactionreq.action.set(z16 ? 1 : 2);
            ilive_new_anchor_follow_interface_followactionreq.anchor_nowid.set(j16);
            ilive_new_anchor_follow_interface_followactionreq.id_type.set(i16);
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(ilive_new_anchor_follow_interface_followactionreq.toByteArray()));
            ProtoUtils.i(this.mApp, new e(aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void feedsLike(final String str, final INowShortVideoProtoManager.a aVar, final Bundle bundle) {
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.c
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                NowShortVideoProtoManagerImpl.this.lambda$feedsLike$0(oidb_0xada_reqbody, str, aVar, bundle, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void feedsUnLike(final String str, final INowShortVideoProtoManager.a aVar, final Bundle bundle) {
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.e
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                NowShortVideoProtoManagerImpl.this.lambda$feedsUnLike$2(oidb_0xada_reqbody, str, aVar, bundle, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void follow(final long j3, final long j16, final int i3, final int i16, final boolean z16, final INowShortVideoProtoManager.a aVar) {
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.b
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z17) {
                NowShortVideoProtoManagerImpl.this.lambda$follow$4(oidb_0xada_reqbody, j3, i16, z16, j16, i3, aVar, z17);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void getLbsShareInfo(Object obj, final INowShortVideoProtoManager.a aVar) {
        final LbsShare$LocationReq lbsShare$LocationReq = (LbsShare$LocationReq) obj;
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.a
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                NowShortVideoProtoManagerImpl.this.lambda$getLbsShareInfo$6(oidb_0xada_reqbody, lbsShare$LocationReq, aVar, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void getMediaDetailInfo(final String str, final INowShortVideoProtoManager.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("getMediaDetailInfo", 2, "mQueryString = " + str);
        }
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.f
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                NowShortVideoProtoManagerImpl.this.lambda$getMediaDetailInfo$3(oidb_0xada_reqbody, str, aVar, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void getShortLabel(final long j3, final String str, final INowShortVideoProtoManager.a aVar) {
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.g
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                NowShortVideoProtoManagerImpl.this.lambda$getShortLabel$5(oidb_0xada_reqbody, str, j3, aVar, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public void reportPlay(final String str, final INowShortVideoProtoManager.a aVar) {
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.mApp, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: com.tencent.mobileqq.nearby.now.protocol.impl.d
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                NowShortVideoProtoManagerImpl.this.lambda$reportPlay$1(oidb_0xada_reqbody, str, aVar, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f252737e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ INowShortVideoProtoManager.a f252738f;

        d(String str, INowShortVideoProtoManager.a aVar) {
            this.f252737e = str;
            this.f252738f = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo\u9519\u8bef   errorCode=" + i3 + ", data=" + bArr + ", mQueryString=" + this.f252737e);
            }
            INowShortVideoProtoManager.a aVar = this.f252738f;
            if (aVar != null) {
                aVar.a(i3, bArr, bundle);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
    public NowShortVideoProtoManagerImpl init(AppInterface appInterface) {
        this.mApp = appInterface;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$feedsLike$0(oidb_0xada$ReqBody oidb_0xada_reqbody, String str, INowShortVideoProtoManager.a aVar, Bundle bundle, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(24640);
            oidb_0xada_reqbody.subcmd.set(1);
            ilive_feeds_like$FeedsLikeReq ilive_feeds_like_feedslikereq = new ilive_feeds_like$FeedsLikeReq();
            ilive_feeds_like_feedslikereq.f342142id.set(ByteStringMicro.copyFromUtf8(str));
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(ilive_feeds_like_feedslikereq.toByteArray()));
            ProtoUtils.i(this.mApp, new a(aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, bundle, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$feedsUnLike$2(oidb_0xada$ReqBody oidb_0xada_reqbody, String str, INowShortVideoProtoManager.a aVar, Bundle bundle, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(24640);
            oidb_0xada_reqbody.subcmd.set(2);
            ilive_feeds_like$FeedsUnLikeReq ilive_feeds_like_feedsunlikereq = new ilive_feeds_like$FeedsUnLikeReq();
            ilive_feeds_like_feedsunlikereq.f342143id.set(ByteStringMicro.copyFromUtf8(str));
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(ilive_feeds_like_feedsunlikereq.toByteArray()));
            ProtoUtils.i(this.mApp, new c(aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, bundle, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLbsShareInfo$6(oidb_0xada$ReqBody oidb_0xada_reqbody, LbsShare$LocationReq lbsShare$LocationReq, INowShortVideoProtoManager.a aVar, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(21296);
            oidb_0xada_reqbody.subcmd.set(1);
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(lbsShare$LocationReq.toByteArray()));
            ProtoUtils.i(this.mApp, new g(aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMediaDetailInfo$3(oidb_0xada$ReqBody oidb_0xada_reqbody, String str, INowShortVideoProtoManager.a aVar, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(30577);
            oidb_0xada_reqbody.subcmd.set(1);
            FeedsProtocol$GetMediaDetailReq feedsProtocol$GetMediaDetailReq = new FeedsProtocol$GetMediaDetailReq();
            feedsProtocol$GetMediaDetailReq.querystring.set(ByteStringMicro.copyFrom(str.getBytes()));
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(feedsProtocol$GetMediaDetailReq.toByteArray()));
            oidb_0xada_reqbody.buss_id.set(((com.tencent.mobileqq.nearby.b) this.mApp.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).g() > 0 ? 0 : 1);
            ProtoUtils.i(this.mApp, new d(str, aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getShortLabel$5(oidb_0xada$ReqBody oidb_0xada_reqbody, String str, long j3, INowShortVideoProtoManager.a aVar, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(30481);
            oidb_0xada_reqbody.subcmd.set(1);
            ilive_short_video_label$GetShortVideoVideoLabelReq ilive_short_video_label_getshortvideovideolabelreq = new ilive_short_video_label$GetShortVideoVideoLabelReq();
            if (!TextUtils.isEmpty(str)) {
                ilive_short_video_label_getshortvideovideolabelreq.feed_id.set(ByteStringMicro.copyFromUtf8(str));
            }
            ilive_short_video_label_getshortvideovideolabelreq.uid.set(j3);
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(ilive_short_video_label_getshortvideovideolabelreq.toByteArray()));
            ProtoUtils.i(this.mApp, new f(aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportPlay$1(oidb_0xada$ReqBody oidb_0xada_reqbody, String str, INowShortVideoProtoManager.a aVar, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(24640);
            oidb_0xada_reqbody.subcmd.set(3);
            ilive_feeds_source$CollectFeedsDataReq ilive_feeds_source_collectfeedsdatareq = new ilive_feeds_source$CollectFeedsDataReq();
            ilive_feeds_source_collectfeedsdatareq.client_type.set(2);
            ilive_feeds_source_collectfeedsdatareq.feeds_id.set(ByteStringMicro.copyFromUtf8(str));
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(ilive_feeds_source_collectfeedsdatareq.toByteArray()));
            ProtoUtils.i(this.mApp, new b(aVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        }
    }
}
