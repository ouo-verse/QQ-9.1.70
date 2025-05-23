package n92;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.luggage.wxa.gf.u;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.now.NowNearbyVideoCommentProto$AddCommentNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto$AddCommentNoFilterResp;
import com.tencent.pb.now.NowNearbyVideoCommentProto$Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto$CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto$CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto$DelCommentReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto$DelCommentResp;
import com.tencent.pb.now.NowNearbyVideoCommentProto$GetCommentListNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto$GetCommentListResp;
import com.tencent.pb.now.NowNearbyVideoCommentProto$UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import n92.a;
import tencent.im.oidb.cmd0xada.oidb_0xada$ReqBody;
import tencent.im.oidb.cmd0xada.oidb_0xada$RspBody;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements n92.a {

    /* renamed from: a, reason: collision with root package name */
    private Handler f419517a = new Handler();

    /* renamed from: b, reason: collision with root package name */
    private HashSet<Long> f419518b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private VideoData f419519c;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f419520d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a.b f419521e;

        a(a.b bVar) {
            this.f419521e = bVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            QLog.i("CommentsDataSource", 1, "errorCode:" + i3);
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    QLog.i("CommentsDataSource", 1, "err_msg:" + oidb_0xada_rspbody.err_msg.get());
                    if (!oidb_0xada_rspbody.busi_buf.has()) {
                        QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
                        this.f419521e.a();
                        return;
                    }
                    NowNearbyVideoCommentProto$GetCommentListResp nowNearbyVideoCommentProto$GetCommentListResp = new NowNearbyVideoCommentProto$GetCommentListResp();
                    nowNearbyVideoCommentProto$GetCommentListResp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                    if (nowNearbyVideoCommentProto$GetCommentListResp.result.get() != 0) {
                        QLog.i("CommentsDataSource", 1, "error code :" + nowNearbyVideoCommentProto$GetCommentListResp.result.get());
                        this.f419521e.a();
                        return;
                    }
                    Comments comments = new Comments();
                    comments.f252663d = nowNearbyVideoCommentProto$GetCommentListResp.total_num.get();
                    QLog.i("CommentsDataSource", 1, "all comments count is: " + comments.f252663d);
                    comments.f252664e = nowNearbyVideoCommentProto$GetCommentListResp.end_flag.get() == 1;
                    comments.f252665f = new ArrayList();
                    if (nowNearbyVideoCommentProto$GetCommentListResp.lists.has()) {
                        for (NowNearbyVideoCommentProto$Comment nowNearbyVideoCommentProto$Comment : nowNearbyVideoCommentProto$GetCommentListResp.lists.get()) {
                            Comments.Comment comment = new Comments.Comment();
                            comment.f252667d = nowNearbyVideoCommentProto$Comment.comment_id.get();
                            comment.f252669f = nowNearbyVideoCommentProto$Comment.create_time.get();
                            comment.f252670h = nowNearbyVideoCommentProto$Comment.type.get();
                            if (nowNearbyVideoCommentProto$Comment.publish_info.has()) {
                                comment.f252672m = nowNearbyVideoCommentProto$Comment.publish_info.uid.get();
                                comment.f252671i = nowNearbyVideoCommentProto$Comment.publish_info.anchor_name.get().toStringUtf8();
                                comment.C = nowNearbyVideoCommentProto$Comment.publish_info.head_img_url.get().toStringUtf8();
                                comment.D = nowNearbyVideoCommentProto$Comment.publish_info.user_type.get();
                                comment.E = nowNearbyVideoCommentProto$Comment.publish_info.now_id.get();
                                if (nowNearbyVideoCommentProto$Comment.reply_info.has()) {
                                    comment.G = nowNearbyVideoCommentProto$Comment.reply_info.uid.get();
                                    comment.F = nowNearbyVideoCommentProto$Comment.reply_info.anchor_name.get().toStringUtf8();
                                    comment.H = nowNearbyVideoCommentProto$Comment.reply_info.head_img_url.get().toStringUtf8();
                                    comment.I = nowNearbyVideoCommentProto$Comment.reply_info.user_type.get();
                                    comment.J = nowNearbyVideoCommentProto$Comment.reply_info.now_id.get();
                                }
                            }
                            if (nowNearbyVideoCommentProto$Comment.content.has() && nowNearbyVideoCommentProto$Comment.content.msgs.has()) {
                                comment.f252668e = nowNearbyVideoCommentProto$Comment.content.msgs.get(0).f342139msg.get().toStringUtf8();
                            }
                            if (!e.this.f419518b.contains(Long.valueOf(nowNearbyVideoCommentProto$Comment.comment_id.get()))) {
                                e.this.f419518b.add(Long.valueOf(nowNearbyVideoCommentProto$Comment.comment_id.get()));
                            }
                            if (comment.f252670h == 2) {
                                comments.f252666h.add(comment);
                            }
                            comments.f252665f.add(comment);
                        }
                    }
                    QLog.i("CommentsDataSource", 1, "total:" + nowNearbyVideoCommentProto$GetCommentListResp.total_num.get() + ", ret:" + nowNearbyVideoCommentProto$GetCommentListResp.result.get());
                    this.f419521e.b(comments);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.i("CommentsDataSource", 1, "merge data error " + e16);
                    this.f419521e.a();
                    return;
                }
            }
            QLog.i("CommentsDataSource", 1, "getComments failed");
            this.f419521e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a.c f419523e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Comments.Comment f419524f;

        b(a.c cVar, Comments.Comment comment) {
            this.f419523e = cVar;
            this.f419524f = comment;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            QLog.i("CommentsDataSource", 1, "errorCode:" + i3);
            String str = "";
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.i("CommentsDataSource", 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get());
                    }
                    if (!oidb_0xada_rspbody.busi_buf.has()) {
                        QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
                        this.f419523e.b(this.f419524f, -1, "");
                        return;
                    }
                    NowNearbyVideoCommentProto$AddCommentNoFilterResp nowNearbyVideoCommentProto$AddCommentNoFilterResp = new NowNearbyVideoCommentProto$AddCommentNoFilterResp();
                    nowNearbyVideoCommentProto$AddCommentNoFilterResp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                    if (nowNearbyVideoCommentProto$AddCommentNoFilterResp.wording.has()) {
                        str = nowNearbyVideoCommentProto$AddCommentNoFilterResp.wording.get().toStringUtf8();
                    }
                    QLog.d("CommentsDataSource", 1, "id: " + nowNearbyVideoCommentProto$AddCommentNoFilterResp.comment_id.get() + ",ret:" + nowNearbyVideoCommentProto$AddCommentNoFilterResp.result.get() + ", tip=" + str);
                    if (nowNearbyVideoCommentProto$AddCommentNoFilterResp.result.get() != 0) {
                        QLog.i("CommentsDataSource", 1, "error code :" + nowNearbyVideoCommentProto$AddCommentNoFilterResp.result.get());
                        this.f419523e.b(this.f419524f, (int) nowNearbyVideoCommentProto$AddCommentNoFilterResp.result.get(), str);
                        return;
                    }
                    if (nowNearbyVideoCommentProto$AddCommentNoFilterResp.comment_id.get() > 0) {
                        this.f419524f.f252667d = nowNearbyVideoCommentProto$AddCommentNoFilterResp.comment_id.get();
                        this.f419523e.a(this.f419524f);
                        e.this.f419518b.add(Long.valueOf(nowNearbyVideoCommentProto$AddCommentNoFilterResp.comment_id.get()));
                        AppInterface appInterface = (AppInterface) this.f78322d.get();
                        if (appInterface != null) {
                            ((u92.c) appInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).d(e.this.f419519c.f252695e);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    QLog.i("CommentsDataSource", 1, "merge publish resp data error");
                    this.f419523e.b(this.f419524f, -1, "");
                    return;
                }
            }
            QLog.i("CommentsDataSource", 1, "publishComment failed");
            this.f419523e.b(this.f419524f, -1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c extends ProtoUtils.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC10832a f419526e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Comments.Comment f419527f;

        c(a.InterfaceC10832a interfaceC10832a, Comments.Comment comment) {
            this.f419526e = interfaceC10832a;
            this.f419527f = comment;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            QLog.i("CommentsDataSource", 1, "errorCode:" + i3);
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    QLog.i("CommentsDataSource", 1, "err_msg:" + oidb_0xada_rspbody.err_msg.get());
                    if (oidb_0xada_rspbody.busi_buf.has()) {
                        NowNearbyVideoCommentProto$DelCommentResp nowNearbyVideoCommentProto$DelCommentResp = new NowNearbyVideoCommentProto$DelCommentResp();
                        nowNearbyVideoCommentProto$DelCommentResp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                        if (QLog.isColorLevel()) {
                            QLog.i("CommentsDataSource", 1, "ret:" + nowNearbyVideoCommentProto$DelCommentResp.result.get());
                        }
                        this.f419526e.a(this.f419527f, (int) nowNearbyVideoCommentProto$DelCommentResp.result.get());
                        AppInterface appInterface = (AppInterface) this.f78322d.get();
                        if (appInterface != null) {
                            ((u92.c) appInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(e.this.f419519c.f252695e, this.f419527f.f252667d);
                            return;
                        }
                        return;
                    }
                    QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
                    this.f419526e.a(this.f419527f, -1);
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    QLog.i("CommentsDataSource", 1, "merge delete resp data error");
                    this.f419526e.a(this.f419527f, -1);
                    return;
                }
            }
            this.f419526e.a(this.f419527f, -1);
        }
    }

    public e(VideoData videoData, QQAppInterface qQAppInterface) {
        this.f419520d = null;
        this.f419519c = videoData;
        this.f419520d = qQAppInterface;
    }

    @Override // n92.a
    public void a(final Comments.Comment comment, final a.c cVar) {
        if (this.f419519c == null || this.f419520d == null) {
            return;
        }
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.f419520d, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: n92.d
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                e.this.l(cVar, comment, oidb_0xada_reqbody, z16);
            }
        });
    }

    @Override // n92.a
    public void b(final Comments.Comment comment, final a.InterfaceC10832a interfaceC10832a) {
        if (this.f419519c == null || this.f419520d == null) {
            return;
        }
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.f419520d, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: n92.c
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                e.this.j(oidb_0xada_reqbody, comment, interfaceC10832a, z16);
            }
        });
    }

    @Override // n92.a
    public void c(final int i3, final a.b bVar) {
        if (this.f419519c == null || this.f419520d == null) {
            return;
        }
        final oidb_0xada$ReqBody oidb_0xada_reqbody = new oidb_0xada$ReqBody();
        q92.b.b(this.f419520d, oidb_0xada_reqbody, new com.tencent.mobileqq.nearby.now.b() { // from class: n92.b
            @Override // com.tencent.mobileqq.nearby.now.b
            public final void onResult(boolean z16) {
                e.this.k(bVar, i3, oidb_0xada_reqbody, z16);
            }
        });
    }

    public int i() {
        try {
            return Integer.parseInt(AppSetting.f99551k.replace(".", ""));
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.e("CommentsDataSource", 2, "getVersionInt exp:" + e16.toString());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(a.c cVar, Comments.Comment comment, oidb_0xada$ReqBody oidb_0xada_reqbody, boolean z16) {
        if (!z16) {
            QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
            cVar.b(comment, -1, "");
            return;
        }
        NowNearbyVideoCommentProto$AddCommentNoFilterReq nowNearbyVideoCommentProto$AddCommentNoFilterReq = new NowNearbyVideoCommentProto$AddCommentNoFilterReq();
        int i3 = this.f419519c.f252692c0;
        if (i3 == VideoData.f252689l0) {
            nowNearbyVideoCommentProto$AddCommentNoFilterReq.feed_type.set(6L);
        } else if (i3 == 4) {
            nowNearbyVideoCommentProto$AddCommentNoFilterReq.feed_type.set(4L);
        } else {
            nowNearbyVideoCommentProto$AddCommentNoFilterReq.feed_type.set(3L);
        }
        nowNearbyVideoCommentProto$AddCommentNoFilterReq.feed_id.set(this.f419519c.f252695e);
        NowNearbyVideoCommentProto$UserInfo nowNearbyVideoCommentProto$UserInfo = new NowNearbyVideoCommentProto$UserInfo();
        nowNearbyVideoCommentProto$UserInfo.uid.set(this.f419519c.Q);
        nowNearbyVideoCommentProto$UserInfo.user_type.set(this.f419519c.S);
        nowNearbyVideoCommentProto$UserInfo.now_id.set(this.f419519c.R);
        nowNearbyVideoCommentProto$AddCommentNoFilterReq.video_recorder.set(nowNearbyVideoCommentProto$UserInfo);
        if (comment.G > 0 || comment.J > 0) {
            NowNearbyVideoCommentProto$UserInfo nowNearbyVideoCommentProto$UserInfo2 = new NowNearbyVideoCommentProto$UserInfo();
            nowNearbyVideoCommentProto$UserInfo2.uid.set(comment.G);
            nowNearbyVideoCommentProto$UserInfo2.user_type.set(comment.I);
            nowNearbyVideoCommentProto$UserInfo2.now_id.set(comment.J);
            nowNearbyVideoCommentProto$AddCommentNoFilterReq.reply_user.set(nowNearbyVideoCommentProto$UserInfo2);
        }
        NowNearbyVideoCommentProto$UserInfo nowNearbyVideoCommentProto$UserInfo3 = new NowNearbyVideoCommentProto$UserInfo();
        nowNearbyVideoCommentProto$UserInfo3.uid.set(this.f419519c.Y);
        nowNearbyVideoCommentProto$UserInfo3.now_id.set(this.f419519c.Z);
        nowNearbyVideoCommentProto$UserInfo3.user_type.set(this.f419519c.f252690a0);
        nowNearbyVideoCommentProto$AddCommentNoFilterReq.video_owner.set(nowNearbyVideoCommentProto$UserInfo3);
        nowNearbyVideoCommentProto$AddCommentNoFilterReq.is_aggregate_short_video.set(0);
        NowNearbyVideoCommentProto$UserInfo nowNearbyVideoCommentProto$UserInfo4 = new NowNearbyVideoCommentProto$UserInfo();
        nowNearbyVideoCommentProto$UserInfo4.uid.set(this.f419519c.D);
        nowNearbyVideoCommentProto$UserInfo4.user_type.set(this.f419519c.G);
        nowNearbyVideoCommentProto$UserInfo4.now_id.set(this.f419519c.F);
        nowNearbyVideoCommentProto$AddCommentNoFilterReq.video_anchor.set(nowNearbyVideoCommentProto$UserInfo4);
        NowNearbyVideoCommentProto$CommentMsgBody nowNearbyVideoCommentProto$CommentMsgBody = new NowNearbyVideoCommentProto$CommentMsgBody();
        NowNearbyVideoCommentProto$CommentMsg nowNearbyVideoCommentProto$CommentMsg = new NowNearbyVideoCommentProto$CommentMsg();
        nowNearbyVideoCommentProto$CommentMsg.f342139msg.set(ByteStringMicro.copyFromUtf8(comment.f252668e));
        nowNearbyVideoCommentProto$CommentMsg.type.set(0);
        nowNearbyVideoCommentProto$CommentMsgBody.msgs.add(nowNearbyVideoCommentProto$CommentMsg);
        nowNearbyVideoCommentProto$AddCommentNoFilterReq.content.set(nowNearbyVideoCommentProto$CommentMsgBody);
        oidb_0xada_reqbody.cmd.set(u.CTRL_INDEX);
        oidb_0xada_reqbody.subcmd.set(9);
        oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(nowNearbyVideoCommentProto$AddCommentNoFilterReq.toByteArray()));
        if (QLog.isColorLevel()) {
            QLog.i("CommentsDataSource", 2, "print bytes count =" + nowNearbyVideoCommentProto$AddCommentNoFilterReq.toByteArray().length);
        }
        int i16 = i();
        QLog.i("CommentsDataSource", 1, "publishComment, qqver=" + i16);
        if (i16 > 0) {
            oidb_0xada_reqbody.version_code.set(i16);
        }
        ProtoUtils.i(this.f419520d, new b(cVar, comment), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(oidb_0xada$ReqBody oidb_0xada_reqbody, Comments.Comment comment, a.InterfaceC10832a interfaceC10832a, boolean z16) {
        if (z16) {
            oidb_0xada_reqbody.cmd.set(u.CTRL_INDEX);
            oidb_0xada_reqbody.subcmd.set(3);
            NowNearbyVideoCommentProto$DelCommentReq nowNearbyVideoCommentProto$DelCommentReq = new NowNearbyVideoCommentProto$DelCommentReq();
            nowNearbyVideoCommentProto$DelCommentReq.feed_id.set(ByteStringMicro.copyFrom(this.f419519c.f252695e.getBytes()));
            nowNearbyVideoCommentProto$DelCommentReq.comment_id.set(comment.f252667d);
            oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(nowNearbyVideoCommentProto$DelCommentReq.toByteArray()));
            ProtoUtils.i(this.f419520d, new c(interfaceC10832a, comment), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
            return;
        }
        interfaceC10832a.a(comment, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(a.b bVar, int i3, oidb_0xada$ReqBody oidb_0xada_reqbody, boolean z16) {
        if (!z16) {
            QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
            bVar.a();
            return;
        }
        NowNearbyVideoCommentProto$GetCommentListNoFilterReq nowNearbyVideoCommentProto$GetCommentListNoFilterReq = new NowNearbyVideoCommentProto$GetCommentListNoFilterReq();
        nowNearbyVideoCommentProto$GetCommentListNoFilterReq.count.set(20L);
        if (!TextUtils.isEmpty(this.f419519c.f252695e)) {
            nowNearbyVideoCommentProto$GetCommentListNoFilterReq.feed_id.set(this.f419519c.f252695e);
        }
        nowNearbyVideoCommentProto$GetCommentListNoFilterReq.feed_type.set(this.f419519c.f252692c0);
        nowNearbyVideoCommentProto$GetCommentListNoFilterReq.page.set(i3);
        nowNearbyVideoCommentProto$GetCommentListNoFilterReq.filter.set(0L);
        oidb_0xada_reqbody.cmd.set(u.CTRL_INDEX);
        oidb_0xada_reqbody.subcmd.set(8);
        oidb_0xada_reqbody.busi_buf.set(ByteStringMicro.copyFrom(nowNearbyVideoCommentProto$GetCommentListNoFilterReq.toByteArray()));
        ProtoUtils.i(this.f419520d, new a(bVar), oidb_0xada_reqbody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
}
