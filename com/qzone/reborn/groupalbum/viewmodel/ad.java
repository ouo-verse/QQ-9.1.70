package com.qzone.reborn.groupalbum.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerCommentEvent;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunCommentRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J&\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012J6\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0014J&\u0010$\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 J.\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 J\"\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\u0018H\u0014R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010:\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020C0B8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006Q"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/ad;", "Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel;", "Lcom/qzone/reborn/albumx/common/bean/d;", "feed", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedBusiness", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "fakeComment", "", "Y2", "U2", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerCommentEvent;", "event", "W2", "comment", "T2", "", "getLogTag", "", "action", "commentCount", "y2", "operationType", "E2", "", "batch", "isSuccess", "", QzoneIPCModule.RESULT_CODE, "opType", ICustomDataEditor.STRING_ARRAY_PARAM_3, "type", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "targetReply", Constants.BASE_IN_PLUGIN_VERSION, "S2", "actionType", "businessFeedData", "V2", "id", "attachInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "C2", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "G", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "d3", "()Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "i3", "(Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;)V", "mLayerExtraInfoBean", "H", "Ljava/lang/String;", "e3", "()Ljava/lang/String;", "j3", "(Ljava/lang/String;)V", "sourceFeedId", "I", "Z", "c3", "()Z", "h3", "(Z)V", "fromFeedDetail", "Landroidx/lifecycle/MutableLiveData;", "Lci/c;", "J", "Landroidx/lifecycle/MutableLiveData;", "b3", "()Landroidx/lifecycle/MutableLiveData;", "commentNumberLiveData", "Lki/j;", "K", "Lki/j;", "mCommentRepo", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends CommonCommentBusinessViewModel {

    /* renamed from: G, reason: from kotlin metadata */
    private GroupAlbumLayerExtraInfoBean mLayerExtraInfoBean;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean fromFeedDetail;

    /* renamed from: H, reason: from kotlin metadata */
    private String sourceFeedId = "";

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<ci.c> commentNumberLiveData = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    private ki.j mCommentRepo = new ki.j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/ad$c", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "rspComment", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<Comment> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.albumx.common.bean.d f57043b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comment f57044c;

        c(com.qzone.reborn.albumx.common.bean.d dVar, Comment comment) {
            this.f57043b = dVar;
            this.f57044c = comment;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Comment rspComment, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ad adVar = ad.this;
            com.qzone.reborn.albumx.common.bean.d dVar = this.f57043b;
            Comment comment = this.f57044c;
            Intrinsics.checkNotNull(rspComment);
            adVar.r2(0, dVar, comment, rspComment);
            ad adVar2 = ad.this;
            String sourceFeedId = ad.this.getSourceFeedId();
            GroupAlbumLayerExtraInfoBean mLayerExtraInfoBean = ad.this.getMLayerExtraInfoBean();
            if (mLayerExtraInfoBean == null || (str = mLayerExtraInfoBean.getLLoc()) == null) {
                str = "";
            }
            adVar2.W2(new GroupAlbumLayerCommentEvent(2, sourceFeedId, str, rspComment, null, ad.this.getFromFeedDetail()));
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ad.this.p2(0, this.f57043b, this.f57044c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/ad$d", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "rsp", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements n.a<Reply> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f57046b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.albumx.common.bean.d f57047c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comment f57048d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Reply f57049e;

        d(int i3, com.qzone.reborn.albumx.common.bean.d dVar, Comment comment, Reply reply) {
            this.f57046b = i3;
            this.f57047c = dVar;
            this.f57048d = comment;
            this.f57049e = reply;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Reply rsp, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ad adVar = ad.this;
            int i3 = this.f57046b;
            com.qzone.reborn.albumx.common.bean.d dVar = this.f57047c;
            Comment comment = this.f57048d;
            Reply reply = this.f57049e;
            Intrinsics.checkNotNull(rsp);
            adVar.t2(i3, dVar, comment, reply, rsp);
            ad adVar2 = ad.this;
            String sourceFeedId = ad.this.getSourceFeedId();
            GroupAlbumLayerExtraInfoBean mLayerExtraInfoBean = ad.this.getMLayerExtraInfoBean();
            if (mLayerExtraInfoBean == null || (str = mLayerExtraInfoBean.getLLoc()) == null) {
                str = "";
            }
            adVar2.W2(new GroupAlbumLayerCommentEvent(4, sourceFeedId, str, this.f57048d, rsp, ad.this.getFromFeedDetail()));
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    private final Comment T2(Comment comment) {
        Comment comment2 = new Comment();
        comment2.commentid = comment.commentid;
        comment2.clientKey = comment.clientKey;
        comment2.comment = comment.comment;
        comment2.time = comment.time;
        ArrayList<PictureItem> arrayList = comment.commentPictureItems;
        if (!(arrayList == null || arrayList.isEmpty())) {
            comment2.commentPictureItems = comment.commentPictureItems;
        }
        comment2.user = comment.user;
        comment2.replies = comment.replies;
        comment2.replyNum = comment.replyNum;
        return comment2;
    }

    private final void U2(com.qzone.reborn.albumx.common.bean.d feed, BusinessFeedData feedBusiness, Comment fakeComment) {
        this.mCommentRepo.g(false, feedBusiness, fakeComment, new c(feed, fakeComment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W2(GroupAlbumLayerCommentEvent event) {
        String feedId = event.getFeedId();
        if (feedId == null || feedId.length() == 0) {
            return;
        }
        if (event.getAction() == 1) {
            Comment comment = event.getComment();
            Intrinsics.checkNotNull(comment);
            event.setComment(T2(comment));
        }
        SimpleEventBus.getInstance().dispatchEvent(event);
    }

    private final void Y2(com.qzone.reborn.albumx.common.bean.d feed, BusinessFeedData feedBusiness, Comment fakeComment) {
        this.mCommentRepo.e(false, feedBusiness, fakeComment, new e(feed, fakeComment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(final ad this$0, final boolean z16, final NTGetQunCommentReq request, final String id5, final NTGetQunCommentRsp nTGetQunCommentRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(id5, "$id");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.g3(ad.this, nTGetQunCommentRsp, z16, request, id5);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    protected void C2(final String id5, String attachInfo, final boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(id5, "id");
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        requestTimelineInfo.requestInvokeTime = System.currentTimeMillis();
        StCommonExt stCommonExt = new StCommonExt();
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean = this.mLayerExtraInfoBean;
        String groupId = groupAlbumLayerExtraInfoBean != null ? groupAlbumLayerExtraInfoBean.getGroupId() : null;
        int page_limit = getPAGE_LIMIT();
        if (attachInfo == null) {
            attachInfo = "";
        }
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean2 = this.mLayerExtraInfoBean;
        String albumId = groupAlbumLayerExtraInfoBean2 != null ? groupAlbumLayerExtraInfoBean2.getAlbumId() : null;
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean3 = this.mLayerExtraInfoBean;
        String batchId = groupAlbumLayerExtraInfoBean3 != null ? groupAlbumLayerExtraInfoBean3.getBatchId() : null;
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean4 = this.mLayerExtraInfoBean;
        final NTGetQunCommentReq nTGetQunCommentReq = new NTGetQunCommentReq(0, requestTimelineInfo, stCommonExt, groupId, "", page_limit, attachInfo, albumId, batchId, groupAlbumLayerExtraInfoBean4 != null ? groupAlbumLayerExtraInfoBean4.getLLoc() : null);
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.getQunComment(nTGetQunCommentReq, new IAlbumServiceGetQunCommentCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.ab
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunCommentCallback
                public final void onGetQunComment(NTGetQunCommentRsp nTGetQunCommentRsp) {
                    ad.f3(ad.this, isLoadMore, nTGetQunCommentReq, id5, nTGetQunCommentRsp);
                }
            });
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    protected void D2(int type, com.qzone.reborn.albumx.common.bean.d feed, Comment comment, Reply reply, Reply targetReply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        BusinessFeedData a16 = di.a.a(feed);
        if (type == 1) {
            Intrinsics.checkNotNull(comment);
            Intrinsics.checkNotNull(reply);
            S2(feed, a16, comment, reply);
        }
        if (type == 0 || type == 2) {
            Intrinsics.checkNotNull(comment);
            Intrinsics.checkNotNull(reply);
            V2(type, feed, a16, comment, reply);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    public void E2(int operationType, com.qzone.reborn.albumx.common.bean.d feed, Comment comment) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        BusinessFeedData a16 = di.a.a(feed);
        if (operationType == 0) {
            U2(feed, a16, comment);
        } else {
            if (operationType != 1) {
                return;
            }
            Y2(feed, a16, comment);
        }
    }

    public final void S2(com.qzone.reborn.albumx.common.bean.d feed, BusinessFeedData feedBusiness, Comment comment, Reply reply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(feedBusiness, "feedBusiness");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.mCommentRepo.f(false, feedBusiness, comment, reply, new b(feed, comment, reply));
    }

    public final void V2(int actionType, com.qzone.reborn.albumx.common.bean.d feed, BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.mCommentRepo.h(false, businessFeedData, comment, reply, new d(actionType, feed, comment, reply));
    }

    public final void a3(boolean batch, boolean isSuccess, long resultCode, int opType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("interact_op_success", Integer.valueOf(isSuccess ? 1 : 0));
        linkedHashMap.put("business_type", Integer.valueOf(!batch ? 1 : 0));
        linkedHashMap.put("fail_error_code", Long.valueOf(resultCode));
        linkedHashMap.put("op_type", Integer.valueOf(opType));
        fo.c.c("ev_qun_album_on_interact_op", linkedHashMap);
    }

    public final MutableLiveData<ci.c> b3() {
        return this.commentNumberLiveData;
    }

    /* renamed from: c3, reason: from getter */
    public final boolean getFromFeedDetail() {
        return this.fromFeedDetail;
    }

    /* renamed from: d3, reason: from getter */
    public final GroupAlbumLayerExtraInfoBean getMLayerExtraInfoBean() {
        return this.mLayerExtraInfoBean;
    }

    /* renamed from: e3, reason: from getter */
    public final String getSourceFeedId() {
        return this.sourceFeedId;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumLayerCommentViewModel";
    }

    public final void h3(boolean z16) {
        this.fromFeedDetail = z16;
    }

    public final void i3(GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean) {
        this.mLayerExtraInfoBean = groupAlbumLayerExtraInfoBean;
    }

    public final void j3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceFeedId = str;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel
    public void y2(int action, com.qzone.reborn.albumx.common.bean.d feed, int commentCount) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        ci.c cVar = new ci.c(action);
        cVar.g(feed.getGroupId());
        cVar.h(feed.getLlocId());
        cVar.d(commentCount);
        this.commentNumberLiveData.postValue(cVar);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/ad$e", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "rspComment", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements n.a<Comment> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.albumx.common.bean.d f57051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comment f57052c;

        e(com.qzone.reborn.albumx.common.bean.d dVar, Comment comment) {
            this.f57051b = dVar;
            this.f57052c = comment;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ad.this.p2(1, this.f57051b, this.f57052c);
            ad.this.a3(false, false, errorCode, 0);
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Comment rspComment, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ad adVar = ad.this;
            com.qzone.reborn.albumx.common.bean.d dVar = this.f57051b;
            Comment comment = this.f57052c;
            Intrinsics.checkNotNull(rspComment);
            adVar.r2(1, dVar, comment, rspComment);
            ad adVar2 = ad.this;
            String sourceFeedId = ad.this.getSourceFeedId();
            GroupAlbumLayerExtraInfoBean mLayerExtraInfoBean = ad.this.getMLayerExtraInfoBean();
            if (mLayerExtraInfoBean == null || (str = mLayerExtraInfoBean.getLLoc()) == null) {
                str = "";
            }
            adVar2.W2(new GroupAlbumLayerCommentEvent(1, sourceFeedId, str, rspComment, null, ad.this.getFromFeedDetail()));
            ad.this.a3(false, true, retCode, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/ad$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "rsp", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<Reply> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.albumx.common.bean.d f57039b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comment f57040c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Reply f57041d;

        b(com.qzone.reborn.albumx.common.bean.d dVar, Comment comment, Reply reply) {
            this.f57039b = dVar;
            this.f57040c = comment;
            this.f57041d = reply;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Reply rsp, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ad adVar = ad.this;
            com.qzone.reborn.albumx.common.bean.d dVar = this.f57039b;
            Comment comment = this.f57040c;
            Reply reply = this.f57041d;
            Intrinsics.checkNotNull(rsp);
            adVar.t2(1, dVar, comment, reply, rsp);
            ad adVar2 = ad.this;
            String sourceFeedId = ad.this.getSourceFeedId();
            GroupAlbumLayerExtraInfoBean mLayerExtraInfoBean = ad.this.getMLayerExtraInfoBean();
            if (mLayerExtraInfoBean == null || (str = mLayerExtraInfoBean.getLLoc()) == null) {
                str = "";
            }
            adVar2.W2(new GroupAlbumLayerCommentEvent(3, sourceFeedId, str, this.f57040c, rsp, ad.this.getFromFeedDetail()));
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            if (errorCode == 10014) {
                ToastUtil.s("\u8bc4\u8bba\u5df2\u8fc7\u671f, \u65e0\u6cd5\u4e92\u52a8", 4);
            } else {
                ToastUtil.s("\u5220\u9664\u56de\u590d\u5931\u8d25", 4);
            }
            ad.this.q2(1, this.f57039b, this.f57040c, this.f57041d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(ad this$0, NTGetQunCommentRsp nTGetQunCommentRsp, boolean z16, NTGetQunCommentReq request, String id5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(id5, "$id");
        String tag = this$0.getTAG();
        int i3 = nTGetQunCommentRsp.seq;
        int i16 = nTGetQunCommentRsp.result;
        String str = nTGetQunCommentRsp.errMs;
        String str2 = nTGetQunCommentRsp.attachInfo;
        boolean z17 = nTGetQunCommentRsp.hasmore;
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean = this$0.mLayerExtraInfoBean;
        String lLoc = groupAlbumLayerExtraInfoBean != null ? groupAlbumLayerExtraInfoBean.getLLoc() : null;
        QLog.e(tag, 1, "sendCommentListRequest seq: " + i3 + " | resultCode: " + i16 + " | errMsg:" + str + " | nextAttachInfo:" + str2 + " | hasMore:" + z17 + " | isLoadMore:" + z16 + " | lloc id" + lLoc + " | traceId " + nTGetQunCommentRsp.traceId);
        int i17 = nTGetQunCommentRsp.result;
        fj.v.a(i17 == 0, 5, i17, System.currentTimeMillis() - request.requestTimeLine.requestInvokeTime, nTGetQunCommentRsp.traceId);
        CellCommentInfo v3 = yh.b.v(nTGetQunCommentRsp.cellComment, nTGetQunCommentRsp.ext);
        int i18 = nTGetQunCommentRsp.result;
        String str3 = nTGetQunCommentRsp.errMs;
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean2 = this$0.mLayerExtraInfoBean;
        String groupId = groupAlbumLayerExtraInfoBean2 != null ? groupAlbumLayerExtraInfoBean2.getGroupId() : null;
        Intrinsics.checkNotNull(groupId);
        int i19 = nTGetQunCommentRsp.cellComment.num;
        ArrayList<Comment> arrayList = v3.commments;
        boolean z18 = nTGetQunCommentRsp.hasmore;
        String str4 = nTGetQunCommentRsp.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str4, "response.attachInfo");
        this$0.l2(i18, str3, groupId, id5, i19, arrayList, z18, z16, str4);
    }
}
